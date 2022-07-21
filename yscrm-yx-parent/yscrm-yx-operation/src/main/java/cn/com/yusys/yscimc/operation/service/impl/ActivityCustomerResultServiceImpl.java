package cn.com.yusys.yscimc.operation.service.impl;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.ActivityCustomerResultEntity;
import cn.com.yusys.yscimc.operation.domain.dto.ActivityResultDto;
import cn.com.yusys.yscimc.operation.domain.form.ActivityResultForm;
import cn.com.yusys.yscimc.operation.domain.form.CustomerResultForm;
import cn.com.yusys.yscimc.operation.domain.vo.ActivityFieldInfoVo;
import cn.com.yusys.yscimc.operation.repository.mapper.ActivityCustomerResultMapper;
import cn.com.yusys.yscimc.operation.repository.mapper.ActivityFieldInfoMapper;
import cn.com.yusys.yscimc.operation.service.ActivityCustomerResultService;
import cn.com.yusys.yscimc.operation.service.ActivityEventResultService;
import cn.com.yusys.yscimc.operation.service.ActivityStatisticsService;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.cm.market.service.CimpCmMarketPlanService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author Lenovo
 * @Data 2022/3/8 12:12
 */
@Service
public class ActivityCustomerResultServiceImpl implements ActivityCustomerResultService {

    private static final String FILED_AND_TYPE = "[filed|type]";

    private final ActivityCustomerResultMapper resultMapper;

    private final CimpCmMarketPlanService marketPlanService;

    private final ActivityStatisticsService activityStatisticsService;

    private final ActivityEventResultService activityEventResultService;

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ActivityCustomerResultServiceImpl(ActivityCustomerResultMapper resultMapper,
                                             CimpCmMarketPlanService marketPlanService,
                                             ActivityStatisticsService activityStatisticsService,
                                             ActivityEventResultService activityEventResultService) {
        this.resultMapper = resultMapper;
        this.marketPlanService = marketPlanService;
        this.activityStatisticsService = activityStatisticsService;
        this.activityEventResultService = activityEventResultService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveBatch(List<ActivityCustomerResultEntity> list) {
        resultMapper.saveBatch(list);
    }

    @Override
    public ActivityResultDto getActivityResult(ActivityResultForm resultForm) {

        CimpCmMarketplan marketPlan = marketPlanService.gettempById(resultForm.getTempId());
        ActivityResultDto resultDto = new ActivityResultDto();
        setMarketPlanInfo(resultDto, marketPlan);

        if ("01".equals(marketPlan.getActivityType())) {
            typeListResult(marketPlan, resultDto);
        } else if ("02".equals(marketPlan.getActivityType())) {
            typeInternetResult(marketPlan, resultDto);
        } else if ("03".equals(marketPlan.getActivityType())) {
            typeEventResult(marketPlan, resultDto);
        }

        return resultDto;
    }

    private void setMarketPlanInfo(ActivityResultDto resultDto, CimpCmMarketplan marketPlan) {
        resultDto.setActivityName(marketPlan.getActivityName());
        resultDto.setActivityType(marketPlan.getActivityType());
        resultDto.setActivitySts(marketPlan.getActivitySts());
        resultDto.setStartTime(dateFormat.format(marketPlan.getStartDate()));
        resultDto.setEndTime(dateFormat.format(marketPlan.getEndDate()));
    }

    /**
     * 名单制营销结果返回
     */
    private void typeListResult(CimpCmMarketplan marketPlan, ActivityResultDto resultDto) {

        List<String> resultTypeList = this.getResultTypeList(marketPlan.getTempId());
        // 给 resultDto 赋值活动执行客户数量
        resultDto.setCustomerNumber(resultTypeList.size());

        int count = 0;
        for (String result : resultTypeList) {
            if ("success".equals(result)) {
                count ++;
            }
        }
        // 给 resultDto 赋值活动执行成功率
        resultDto.setSuccessRate(getSuccessRate(count, resultTypeList.size()));
    }

    /**
     * 互联网营销结果返回
     */
    private void typeInternetResult(CimpCmMarketplan marketPlan, ActivityResultDto resultDto) {
        ActivityFieldInfoMapper fieldInfoMapper = activityStatisticsService.getFieldInfoMapper();
        List<ActivityFieldInfoVo> fieldInfoVoList = fieldInfoMapper.getInfoByTempId(marketPlan.getTempId());
        // 设置 栏位信息&活动类型 相关信息
        StringBuilder stringBuilder = new StringBuilder();
        for (ActivityFieldInfoVo vo : fieldInfoVoList) {
            // TODO 还需替换类型 ( .replace("type", vo.getActId() 这个是错的)
            stringBuilder.append(FILED_AND_TYPE.replace("filed", vo.getMktSet()).replace("type", ComponentTypeEnum.selectComponentName(vo.getAssemblyType()))).append("\t");
        }
        resultDto.setFieldAndType(stringBuilder.toString());
    }

    /**
     * 事件类营销结果返回
     */
    private void typeEventResult(CimpCmMarketplan marketPlan, ActivityResultDto resultDto) {
        // 设置请求数量
        resultDto.setVisitVolume(activityEventResultService.selectCountByTempId(marketPlan.getTempId()));
        String transCode = activityEventResultService.distinctTransCodeByTempId(marketPlan.getTempId());

        Example example = new Example(ActivityCustomerResultEntity.class);
        if (StringUtils.isBlank(transCode)) {
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("activityId", marketPlan.getTempId());
            // 设置匹配成功数量
            resultDto.setSuccessNumber(resultMapper.selectCountByExample(example));
        } else {
            example.setTableName(transCode);
            resultDto.setSuccessNumber(resultMapper.selectCountByExample(example));
        }
//        resultDto.setTableCode();
    }

    @Override
    public List<ActivityCustomerResultEntity> getResultByTempId(ActivityResultForm resultForm) {

        String condition = resultForm.getCondition();
        CustomerResultForm customerResultForm = null;
        if (condition != null) {
            customerResultForm = JSONObject.parseObject(condition, CustomerResultForm.class);
        }
        PageHelper.startPage(resultForm.getPage(), resultForm.getSize());
        Example example = new Example(ActivityCustomerResultEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activityId", resultForm.getTempId());
        if (customerResultForm != null) {

            if (!StringUtils.isBlank(customerResultForm.getCustomerId())) {
                criteria.andLike("customerId", "%" + customerResultForm.getCustomerId() + "%");
            }
            if (!StringUtils.isBlank(customerResultForm.getCustomerName())) {
                criteria.andLike("customerName", "%" + customerResultForm.getCustomerName() + "%");
            }
            if (!StringUtils.isBlank(customerResultForm.getChannelId())) {
                criteria.andEqualTo("channelId", customerResultForm.getChannelId());
            }
            if (!StringUtils.isBlank(customerResultForm.getResultType())) {
                criteria.andEqualTo("resultType", customerResultForm.getResultType());
            }
            if (!ObjectUtils.isEmpty(customerResultForm.getStartTime())) {
                criteria.andGreaterThanOrEqualTo("sendTime", customerResultForm.getStartTime());
            }
        }
        List<ActivityCustomerResultEntity> resultList = resultMapper.selectByExample(example);
        PageHelper.clearPage();
        return resultList;
    }

    private String getSuccessRate(int small, int big) {
        if (small == 0){
            return "0%";
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format((float) small / (float) big * 100) + "%";
    }

    private List<String> getResultTypeList(String tempId) {
        return this.resultMapper.getResultList(tempId);
    }
}
