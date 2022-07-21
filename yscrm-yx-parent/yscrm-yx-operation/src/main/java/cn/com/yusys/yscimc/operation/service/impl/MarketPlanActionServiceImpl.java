package cn.com.yusys.yscimc.operation.service.impl;

import cn.com.yusys.yscimc.operation.domain.bo.EventTypeDataBo;
import cn.com.yusys.yscimc.operation.domain.bo.MarketPlanInitialDataBo;
import cn.com.yusys.yscimc.operation.domain.bo.MarketPlanValidatorBo;
import cn.com.yusys.yscimc.operation.event.MarketPlantFlowDataEvent;
import cn.com.yusys.yscimc.operation.resolver.impl.EventActivityResolver;
import cn.com.yusys.yscimc.operation.service.ActivityStatisticsService;
import cn.com.yusys.yscimc.operation.service.MarketPlanActionService;
import cn.com.yusys.yscimc.operation.support.ActivityValidatorExtend;
import cn.com.yusys.yscimc.operation.support.MarketPlanServiceExtend;
import cn.com.yusys.yscimc.operation.support.MarketPlanTaskExecutor;
import cn.com.yusys.yusp.cm.cust.domain.AcimFCiCustomer;
import cn.com.yusys.yusp.cm.cust.service.AcimFCiCustomerService;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmNodeMapper;
import cn.com.yusys.yusp.cm.market.service.CimpCmMarketPlanService;
import cn.com.yusys.yusp.rai.engine.data.domain.ActionPo;
import cn.com.yusys.yusp.rai.engine.data.domain.ActivityPo;
import cn.com.yusys.yusp.rai.engine.data.domain.EngMarketingEntryVo;
import constant.TaskResultType;
import core.PendingJobPool;
import core.ScheduledJobPool;
import dto.TaskResultDto;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import process.ITaskProcessor;
import process.ScheduledTaskProcessor;
import vo.CustomDelayedVo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Lenovo
 * @Data 2021/12/7 15:57
 */
@Service("marketPlanActionServiceImpl")
public class MarketPlanActionServiceImpl implements MarketPlanActionService, ScheduledTaskProcessor {

    private static final Logger log = LoggerFactory.getLogger(MarketPlanActionServiceImpl.class);

    private final MarketPlanServiceExtend marketPlanServiceExtend;

    private final CimpCmMarketPlanService marketPlanService;

    private final CimpCmNodeMapper nodeMapper;

    private final ActivityStatisticsService activityStatisticsService;

    private final AcimFCiCustomerService acimFCiCustomerService;

    private final EventActivityResolver eventActivityResolver;

    private final ActivityValidatorExtend activityValidatorExtend;

    public MarketPlanActionServiceImpl(MarketPlanServiceExtend marketPlanServiceExtend,
                                       CimpCmMarketPlanService marketPlanService,
                                       CimpCmNodeMapper nodeMapper,
                                       ActivityStatisticsService activityStatisticsService,
                                       AcimFCiCustomerService acimFCiCustomerService,
                                       EventActivityResolver eventActivityResolver,
                                       ActivityValidatorExtend activityValidatorExtend) {
        this.marketPlanServiceExtend = marketPlanServiceExtend;
        this.marketPlanService = marketPlanService;
        this.nodeMapper = nodeMapper;
        this.activityStatisticsService = activityStatisticsService;
        this.acimFCiCustomerService = acimFCiCustomerService;
        this.eventActivityResolver = eventActivityResolver;
        this.activityValidatorExtend = activityValidatorExtend;
    }

    public CimpCmMarketplan getMarkPlan(String tempId) {
        return marketPlanService.gettempById(tempId);
    }

    /**
     * 判断活动是否过期
     * 判断活动是否当下执行
     * 判断活动执行频率，下次是否执行
     * 修改活动状态
     */
    private String checkActivityTime(CimpCmMarketplan marketPlan) {
        String msg = null;
        Date endDate = marketPlan.getEndDate();
        Date startDate = marketPlan.getStartDate();

        if ((new Date().getTime() - endDate.getTime()) > 0) {
            msg = "该活动已过期！";
            MarketPlantFlowDataEvent event = new MarketPlantFlowDataEvent(marketPlan, msg);
            marketPlanServiceExtend.getEventPublisher().publishEvent(event);

            // TODO 修改活动状态为已关闭 05，保障前端活动执行的校验行为
            marketPlanService.updateSts(marketPlan.getTempId(), "05");
            return msg;
        }

        /**
         * 判断当前活动立刻执行还是添加定时任务
         * 如果 time 大于 5 秒，添加定时任务并提示活动开始时间；
         */
        long time = startDate.getTime() - new Date().getTime();
        if (time > 5000) {
            msg = addNextScheduledTask(time - 4000, marketPlan.getTempId(), startDate);
        }

        /**
         * 现在开始判断活动执行一次还是执行多次
         * 如果 ifTimeTask == 1，表示活动会执行多次，需要添加下一次执行的定时任务
         */
        if ("1".equals(marketPlan.getIfTimeTask())) {

            // 判断该活动的状态是否修改为已执行
            if (!"04".equals(marketPlan.getActivitySts())) {
                // 修改 marketPlan 的 activitySts 为 04
                marketPlanService.updateSts(marketPlan.getTempId(), "04");
            }

            long nextAdditionalTime = getNextAdditionalTime(marketPlan.getTaskFreq(), Integer.parseInt(String.format("%td", startDate)));
            long nextTime = nextAdditionalTime + new Date().getTime();
            // 使用 endTime 判断有没有下一次活动，如果为 true 表示还需添加下次的定时任务
            if (nextTime < endDate.getTime()) {
                addNextScheduledTask(nextAdditionalTime, marketPlan.getTempId(), startDate);
            }else {
                marketPlanService.updateSts(marketPlan.getTempId(), "05");
            }
        }else {
            marketPlanService.updateSts(marketPlan.getTempId(), "05");
        }

        return msg;
    }

    /**
     * 活动执行方法
     */
    @Override
    public String startPlanByTempId(String tempId) {

        // 1. 获取活动模板消息
        CimpCmMarketplan marketPlan = marketPlanService.gettempById(tempId);
        log.info("活动日志-第一步，查询活动基本信息： {}", marketPlan);

        // 2. 校验活动时间
        log.info("活动日志-第二步，校验活动时间，是否配置定时任务。");
        String msg = this.checkActivityTime(marketPlan);
        if (!StringUtils.isBlank(msg)) {
            log.info("活动日志-第二步，校验活动时间后，延时执行该活动： {}", msg);
            return msg;
        }

        // 3. 活动开始执行
        msg = executeActive(marketPlan);

        return msg;
    }

    /**
     * 事件活动触发执行
     */
    @Override
    public void startPlanForEventAction(EngMarketingEntryVo entryVo) {
        // 1. 获取活动 ID 集合
        List<String> tempIdList = entryVo.getActionPoList().stream().map(ActionPo::getActId).collect(Collectors.toList());
        // 2. 获取用户信息
        String customerId = (String) entryVo.getTransDataMap().get("custId");
        AcimFCiCustomer customer = new AcimFCiCustomer();
        customer.setCustId(customerId);
        customer = (AcimFCiCustomer) acimFCiCustomerService.getMapper().selectByPrimaryKey(customer);
        // 3. 创建活动执行所需的对象
        for (String tempId : tempIdList) {
            EventTypeDataBo eventTypeDataBo = null;
            List<String> actionIdList = new ArrayList<>();
            for (ActionPo actionPo : entryVo.getActionPoList()) {
                if (actionPo.getActId().equals(tempId)) {
                    actionIdList.add(actionPo.getActionId());
                }
            }
            eventTypeDataBo = new EventTypeDataBo(tempId, customer, actionIdList);

            // 4. 查询活动所有信息
            CimpCmMarketplan marketPlan = marketPlanService.gettempById(tempId);
            List<CimpCmNodeinfo> nodesList = nodeMapper.getNodeByTempId(tempId);

            // 5. 生成 JobInfo，使用线程框架执行活动
            createTask(nodesList, marketPlan, eventTypeDataBo);
        }
    }

    private String executeActive(CimpCmMarketplan marketPlan) {

        // 1. 查询所有节点信息
        List<CimpCmNodeinfo> nodesList = nodeMapper.getNodeByTempId(marketPlan.getTempId());
        log.info("活动日志-第三步，查询活动中的所有节点信息： {}", nodesList);

        // 2. 根据活动类型校验活动组件最低需求是否满足
        MarketPlanValidatorBo validatorBo = new MarketPlanValidatorBo(marketPlan, nodesList);
        log.info("活动日志-第四步，组成 validatorBo 对象，开始校验活动组件是否匹配： {}", validatorBo);
        activityValidatorExtend.preValidate(validatorBo);
        if (!validatorBo.isPassed()) {
            log.info("活动日志-第四步，活动组件配置错误： {}", validatorBo);
            return validatorBo.getResultMessage();
        }

        /**
         * 3. 判断组件中有没有【事件组件】
         * 如果没有创建 MarketPlanListProcessor 名单类任务立即执行
         * 如果有创建 MarketPlanEventProcessor 事件类任务存储事件规则
         */
        log.info("活动日志-第五步，开始判断活动中是否有【事件组件】。");
        CimpCmNodeinfo eventNodeInfo = null;
        for (CimpCmNodeinfo nodeinfo : nodesList) {
            if ("38".equals(nodeinfo.getAssemblyId())) {
                eventNodeInfo = nodeinfo;
                break;
            }
        }

        if (eventNodeInfo != null) {
            // 事件类活动
            log.info("活动日志-第六步，开始创建【事件类活动】任务！");
            return createEventPreTask(eventNodeInfo, marketPlan.getActivityName());
        } else {
            // 名单类 / 互联网营销
            log.info("活动日志-第六步，开始创建【名单类 / 互联网营销】任务！");
            return createTask(nodesList, marketPlan, null);
        }
    }

    private String createEventPreTask(CimpCmNodeinfo eventNodeInfo, String taskName) {
        MarketPlanEventProcessor processor = new MarketPlanEventProcessor();
        PendingJobPool pendingJobPool = PendingJobPool.jobPoolInstance();
        // TODO 过期时间设置为 5 秒, 是为了方便测试
        pendingJobPool.registerJob(taskName, 1, processor, 1000*5);
        pendingJobPool.putTask(taskName, eventNodeInfo);
        return taskName + " - 活动开始执行.";
    }

    private String createTask(List<CimpCmNodeinfo> nodesList, CimpCmMarketplan marketPlan, EventTypeDataBo eventTypeDataBo) {
        // 异步执行，提高响应时间
        MarketPlanInitialDataBo marketPlanInitialDataBo = new MarketPlanInitialDataBo(marketPlan, nodesList);
        // 组装成一个包含活动信息，所有节点组件信息，所有的组件解析器，流程的执行器
        MarketPlanTaskExecutor executor = new MarketPlanTaskExecutor(marketPlanInitialDataBo, marketPlanServiceExtend, activityStatisticsService);
        executor.setEventTypeDataBo(eventTypeDataBo);

        // 定义一个需要执行的事件，放入线程池（这里代表是活动执行类型，任务执行时会根据不同类型执行不同start方法）
        MarketPlanListProcessor processor = new MarketPlanListProcessor();
        PendingJobPool pendingJobPool = PendingJobPool.jobPoolInstance();
        // TODO 过期时间设置为 5 秒, 是为了方便测试
        String taskName = "01".equals(marketPlan.getActivityType()) ? marketPlan.getActivityType() : marketPlan.getActivityType() + marketPlanService.getUuid();
        pendingJobPool.registerJob(taskName, 1, processor, 1000*5);
        pendingJobPool.putTask(taskName, executor);
        log.info("活动日志-第七步，创建【名单类 / 互联网营销】任务成功！{}", taskName);
        return marketPlan.getActivityName() + " - 活动开始执行.";
    }

    private String addNextScheduledTask(long time, String tempId, Date startDate) {
        CustomDelayedVo<String> customDelayedVo = new CustomDelayedVo<>(time - 4000, tempId, this);
        ScheduledJobPool.getInstance().putJob(customDelayedVo);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "活动将于: [" + dateFormat.format(startDate) + "] 开始执行";
    }

    /**
     * 获取下次任务执行的附加时间
     * @param taskFreq
     * @return
     */
    private long getNextAdditionalTime(String taskFreq, int day) {

        long additionalTime;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (taskFreq.equals("M")) {
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.HOUR_OF_DAY, 2);
            calendar.add(Calendar.MONTH, 1);
            additionalTime = calendar.getTimeInMillis() - new Date().getTime();
        } else if (taskFreq.equals("D")) {
            calendar.set(Calendar.HOUR_OF_DAY, 2);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.add(Calendar.DATE, 1);
            additionalTime = calendar.getTimeInMillis() - new Date().getTime();
        } else {
            throw new RuntimeException("无法识别活动执行频率！！！");
        }

        return additionalTime;
    }

    /**
     * 定时任务接口实现方法
     */
    @Override
    public void scheduledTask(Object object) {
        this.startPlanByTempId(object.toString());
    }

    /**
     * 名单类 / 互联网 活动异步执行处理方法
     */
    private static class MarketPlanListProcessor implements ITaskProcessor<MarketPlanTaskExecutor, Object> {

        @Override
        public TaskResultDto<Object> taskExecute(MarketPlanTaskExecutor executor) {
            try {
                executor.start();
                return new TaskResultDto<Object>(TaskResultType.Success, "活动执行完毕！", "success");
            } catch (Exception e) {
                e.printStackTrace();

                return new TaskResultDto<Object>(TaskResultType.Exception, e, "活动执行失败，出现异常：" + e.getMessage());
            }
        }
    }

    /**
     * 事件类活动异步执行处理方法
     */
    private class MarketPlanEventProcessor implements ITaskProcessor<CimpCmNodeinfo, Object> {

        @Override
        public TaskResultDto<Object> taskExecute(CimpCmNodeinfo nodeInfo) {
            try {
                // 直接调用【事件组件 resolver】 预加载事件组件的规则信息到 redis 中；
                ActivityPo activityPo = eventActivityResolver.preLoadRuleInformation(nodeInfo);
                return new TaskResultDto<Object>(TaskResultType.Success, activityPo, "success");
            } catch (Exception e) {
                e.printStackTrace();
                return new TaskResultDto<Object>(TaskResultType.Exception, e, "活动执行失败，出现异常：" + e.getMessage());
            }
        }
    }
}
