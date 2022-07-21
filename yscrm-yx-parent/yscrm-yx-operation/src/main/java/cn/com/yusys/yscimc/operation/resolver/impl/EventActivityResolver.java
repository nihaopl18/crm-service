package cn.com.yusys.yscimc.operation.resolver.impl;

import cn.com.yusys.climp.acty.domain.LoyRlTableEcName;
import cn.com.yusys.climp.acty.service.LoyRlTableEcNameService;
import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.bo.ComponentDataBo;
import cn.com.yusys.yscimc.operation.domain.bo.EventTypeDataBo;
import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.dto.ProductInfoDto;
import cn.com.yusys.yscimc.operation.domain.vo.CmFRcEventInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.ContentInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.CustomerInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.ProductInfoVo;
import cn.com.yusys.yscimc.operation.resolver.AbstractEventActivityResolver;
import cn.com.yusys.yscimc.operation.support.MarketPlanTaskExecutor;
import cn.com.yusys.yusp.cm.cust.domain.AcimFCiCustomer;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.market.domain.FrTransInfoModel;
import cn.com.yusys.yusp.cm.market.domain.FrTransMapModel;
import cn.com.yusys.yusp.cm.market.service.TransManagerService;
import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProductManagerInfo;
import cn.com.yusys.yusp.cm.productmanager.service.CmFRcProductManagerService;
import cn.com.yusys.yusp.cm.ruleConfig.domain.*;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcRuleActionMapper;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcRuleComparisonMapper;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcRuleConComparisonMapper;
import cn.com.yusys.yusp.cm.ruleConfig.service.CmFRcEventConfigService;
import cn.com.yusys.yusp.cm.ruleConfig.service.CmFRcEventInfoService;
import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcSysTypeInfo;
import cn.com.yusys.yusp.cm.sysKeyWord.service.CmFRcSysTypeService;
import cn.com.yusys.yusp.rai.engine.data.domain.*;
import cn.com.yusys.yusp.rai.engine.data.enums.ContActionStoreTypeEnum;
import cn.com.yusys.yusp.rai.engine.data.enums.CountCycleTypeEnum;
import cn.com.yusys.yusp.rai.engine.data.enums.CountTypeEnum;
import cn.com.yusys.yusp.rai.engine.data.enums.FieldTypeEnum;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EventActivityResolver extends AbstractEventActivityResolver {

    private static final Logger log = LoggerFactory.getLogger(MarketPlanTaskExecutor.class);

    private static final String REDIS_KEY="RAI:CONFIG:RULE:ACTIVITY:";

    @Autowired
    private CmFRcEventInfoService cmFRcEventInfoService;

    @Autowired
    private CmFRcRuleConComparisonMapper cmFRcRuleConComparisonMapper;

    @Autowired
    private CmFRcRuleActionMapper cmFRcRuleActionMapper;

    @Autowired
    private CmFRcRuleComparisonMapper cmFRcRuleComparisonMapper;

    @Autowired
    private CmFRcSysTypeService cmFRcSysTypeService;

    @Autowired
    private TransManagerService transManagerService;

    @Autowired
    private CmFRcEventConfigService cmFRcEventConfigService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private LoyRlTableEcNameService loyRlTableEcNameService;

    @Autowired
    private CmFRcProductManagerService cmFRcProductManagerService;

    @Autowired
    private MarketActionResolver marketActionResolver;

    @Override
    public ActivityPo preLoadRuleInformation(CimpCmNodeinfo nodeInfo) {

        String eventId = nodeInfo.getNodeId();

        //根据事件id查询事件信息
        List<CmFRcEventInfoVo> cmFRcEventInfoVoList =new ArrayList<>();
        CmFRcEventInfo cmFRcEventInfo = cmFRcEventInfoService.selectByPrimaryKey(eventId);

        // 查询触发该活动的类型
        LoyRlTableEcName ecName = loyRlTableEcNameService.selectByTransactionCode(cmFRcEventInfo.getTransactionCode());

        // 生成活动对应封装类
        ActivityPo activityPo = new ActivityPo();
        activityPo.setActivityId(nodeInfo.getTempId());
        activityPo.setTransCode(ecName.getTableEName());
        activityPo.setActivityName(cmFRcEventInfo.getEventName());
        activityPo.setEffectDate(cmFRcEventInfo.getBeginDate());
        activityPo.setExpireDate(cmFRcEventInfo.getEndDate());
        BigDecimal eventPriority = cmFRcEventInfo.getEventPriority();
        activityPo.setPriority(eventPriority == null ? 1 : eventPriority.intValue());

        // 开始创建规则封装类
        RulePo rulePo = new RulePo();
        rulePo.setActivityId(activityPo.getActivityId());
        // 设置基本规则
        rulePo.setConditionExpress(cmFRcEventInfo.getCondition());

        // 根据事件id查询连续动作比较
        List<CmFRcRuleConComparison> cmFRcRuleConComparisonList = cmFRcRuleConComparisonMapper.getConComByEventId(eventId);
        // 该连续动作只能设置一个条件！！
        if (cmFRcRuleConComparisonList != null && cmFRcRuleConComparisonList.size() > 0) {
            ContinueExpressPo continueExpressPo = new ContinueExpressPo();
            CmFRcRuleConComparison cmFRcRuleConComparison = cmFRcRuleConComparisonList.get(0);
            continueExpressPo.setFieldName(cmFRcRuleConComparison.getVariableName());
            continueExpressPo.setBeginDate(activityPo.getEffectDate());
            continueExpressPo.setEndDate(activityPo.getExpireDate());
            continueExpressPo.setContActionStore(ContActionStoreTypeEnum.CONT_OPER_EG);
            continueExpressPo.setCompareValue(cmFRcRuleConComparison.getComparisionValue());
            continueExpressPo.setCountCycleType(CountCycleTypeEnum.getByCode("70080001"));
            if ("COUNT".equals(cmFRcRuleConComparison.getStatisticalMethod())) {
                continueExpressPo.setCountType(CountTypeEnum.getByCode("70070002"));
            } else {
                continueExpressPo.setCountType(CountTypeEnum.getByCode("70070001"));
            }
            // 为规则对象添加连续动作封装类属性
            rulePo.setContinueExpressPo(continueExpressPo);
        }

        // 单次动作集合
        List<ActionPo> actionPoList = new ArrayList<>();
        // 连续动作集合
        List<ActionPo> continueActionPoList = new ArrayList<>();
        //根据事件 id 查询动作主表,获得 actionId
        List<CmFRcRuleAction> cmFRcRuleActionList = cmFRcRuleActionMapper.getActionByEventId(eventId);
        for (CmFRcRuleAction cmFRcRuleAction : cmFRcRuleActionList) {
            //营销产品
            if (cmFRcRuleAction.getActionType().equals("PRODUCT")){
                String actionId = cmFRcRuleAction.getId();
                List<CmFRcProAction> proAction = cmFRcRuleActionMapper.getProAction(actionId);
                for (CmFRcProAction cmFRcProAction : proAction) {
                    ActionPo actionPo = new ActionPo();
                    actionPo.setActId(activityPo.getActivityId());
                    actionPo.setActionId(cmFRcProAction.getProId());
                    if ("S".equals(cmFRcProAction.getActionClassify())) {
                        actionPoList.add(actionPo);
                    } else {
                        continueActionPoList.add(actionPo);
                    }
                }
            }
            else if (cmFRcRuleAction.getActionType().equals("CARE")){
                //客户关怀
                String actionId = cmFRcRuleAction.getId();
                List<CmFRcCareAction> careAction = cmFRcRuleActionMapper.getCareAction(actionId);
                for (CmFRcCareAction cmFRcCareAction : careAction) {
                    ActionPo actionPo = new ActionPo();
                    actionPo.setActId(activityPo.getActivityId());
                    actionPo.setActionId(cmFRcCareAction.getCareId());
                    actionPo.setActionType(cmFRcCareAction.getActionClassify());
                    if ("S".equals(cmFRcCareAction.getActionClassify())) {
                        actionPoList.add(actionPo);
                    } else {
                        continueActionPoList.add(actionPo);
                    }
                }
            }
            else if (cmFRcRuleAction.getActionType().equals("RISK")){
                //关注风险
                String actionId = cmFRcRuleAction.getId();
                List<CmFRcRiskAction> riskAction = cmFRcRuleActionMapper.getRiskAction(actionId);
                for (CmFRcRiskAction cmFRcRiskAction : riskAction) {
                    ActionPo actionPo = new ActionPo();
                    actionPo.setActId(activityPo.getActivityId());
                    actionPo.setActionId(cmFRcRiskAction.getRiskId());
                    actionPo.setActionType(cmFRcRiskAction.getActionClassify());
                    if ("S".equals(cmFRcRiskAction.getActionClassify())) {
                        actionPoList.add(actionPo);
                    } else {
                        continueActionPoList.add(actionPo);
                    }
                }
            }
        }
        // 给规则对象 rulePo 中设置 单次动作类计集合
        rulePo.setActionPoList(actionPoList);
        // 给规则对象 rulePo 中设置 连续动作类计集合
        rulePo.setContinueActionPoList(continueActionPoList);

        // 查询事件对应表格所用的字段
        Set<FieldPo> fieldPoList = new HashSet<>();
        FrTransInfoModel model = new FrTransInfoModel();
        model.setTransCode(cmFRcEventInfo.getTransactionCode());
        List<FrTransMapModel> currentTransParamList = transManagerService.getCurrentTransParamList(model);
        currentTransParamList.forEach(mapModel -> {
            FieldPo fieldPo = new FieldPo();
            fieldPo.setFieldCode(mapModel.getParamCode());
            fieldPo.setFieldName(mapModel.getFieldName());
            fieldPo.setFieldType("C".equals(mapModel.getFieldType()) ? FieldTypeEnum.VARCHAR : FieldTypeEnum.NUMBER);
            fieldPoList.add(fieldPo);
        });
        // 规则对象添加 交易字段参数
        rulePo.setFieldList(fieldPoList);

        // 获取所有的 引用参数
        Set<QuoteParamPo> quoteParamPoSet = new HashSet<>();
        List<CmFRcRuleParam> cmFRcRuleParams = cmFRcEventConfigService.queryParams();
        for (CmFRcRuleParam cmFRcRuleParam : cmFRcRuleParams) {
            QuoteParamPo quoteParamPo = new QuoteParamPo();
            quoteParamPo.setParamAttr(cmFRcRuleParam.getParamCode());
            quoteParamPo.setParamCode(cmFRcRuleParam.getParamCode());
            quoteParamPo.setParamName(cmFRcRuleParam.getParamName());
            quoteParamPo.setParamMapp(cmFRcRuleParam.getParamMapping());
            quoteParamPo.setDataSourceType("HTTP");
            quoteParamPo.setDataUrl(cmFRcRuleParam.getStatement());
            quoteParamPo.setDataType(cmFRcRuleParam.getParamType());
            quoteParamPoSet.add(quoteParamPo);
        }
        // 规则对象添加 引用参数
        rulePo.setQuoteParamList(quoteParamPoSet);

        // 最后将规则对象放入 activityPo 对象中
        List<RulePo> rulePos = new ArrayList<>();
        rulePos.add(rulePo);
        activityPo.setRulePos(rulePos);

        // TODO 使用工具类封装为引擎要的格式 ? 不知道用哪个

        // 存入redis
        String redisKey = REDIS_KEY + activityPo.getTransCode();
        Boolean hasKey = redisTemplate.hasKey(redisKey);

        if (Boolean.TRUE.equals(hasKey)){
            // TODO 清理 key 中过期的活动信息
        }
        // redis 存储
        redisTemplate.opsForHash().put(redisKey, activityPo.getActivityId(), JSON.toJSONString(activityPo));
        return activityPo;
    }

    @Override
    public void executeResolver(MarketPlanTaskExecutor taskExecutor) {

        // 1.引擎匹配成功返回的数据
        EventTypeDataBo eventTypeDataBo = taskExecutor.getEventTypeDataBo();

        if (eventTypeDataBo == null) {
            log.warn("事件类活动 {} 执行失败，eventTypeDataBo 实时数据为空！", taskExecutor.getInitialData().getPlanInfo().getActivityName());
            throw new RuntimeException("事件类活动 " + taskExecutor.getInitialData().getPlanInfo().getActivityName() + " 执行失败，eventTypeDataBo 实时数据为空！");
        }

        // 2.解析营销动作信息
        List<String> actionIdList = eventTypeDataBo.getActionIdList();
        List<CmFRcSysTypeInfo> cmFRcSysTypeInfos = cmFRcSysTypeService.selectByIdList(actionIdList);
        List<ContentInfoVo> actionVoList = marketActionResolver.analysisKeyword(cmFRcSysTypeInfos);

        // 3.解析出产品信息
        List<String> productIdList = cmFRcSysTypeInfos.stream().map(CmFRcSysTypeInfo::getApplyObject).collect(Collectors.toList());
        List<CmFRcProductManagerInfo> infoList = cmFRcProductManagerService.selectByIdList(productIdList);
        List<ProductInfoVo> infoVoList = new ArrayList<>();
        for (CmFRcProductManagerInfo info : infoList) {
            ProductInfoVo vo = new ProductInfoVo();
            BeanUtils.copyProperties(info, vo);
            infoVoList.add(vo);
        }
        ProductInfoDto productInfoDto = new ProductInfoDto().setProductInfoVoList(infoVoList);

        // 4.将查询到【产品信息】+【动作信息】存入 componentDataBo 对象中
        ComponentDataBo componentDataBo = taskExecutor.getComponentDataBo();
        componentDataBo.setProductInfoDto(productInfoDto);
        componentDataBo.addContentInfoList(actionVoList);

        // 5.将客户信息存入 processedDataBo 当中
        ProcessedDataBo processedDataBo = new ProcessedDataBo();
        AcimFCiCustomer customer = eventTypeDataBo.getCustomer();
        CustomerInfoVo vo = new CustomerInfoVo();
        BeanUtils.copyProperties(customer, vo);
        processedDataBo.setCustomerInfoVoSet(vo);
        taskExecutor.setProcessedDataBo(processedDataBo);
    }

    @Override
    public String getType() {
        //原批量事件活动，现事件活动
        return ComponentTypeEnum.BATCH_EVENT_ACTIVITY.getComponentType();
    }
}
