package cn.com.yusys.yscimc.operation.service.impl;

import cn.com.yusys.yscimc.assemble.domain.CmicAppAssembleSignUpEntity;
import cn.com.yusys.yscimc.assemble.service.CmicAppAssembleSignUpService;
import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.ActivityFieldInfo;
import cn.com.yusys.yscimc.operation.domain.ActivityStatistics;
import cn.com.yusys.yscimc.operation.domain.vo.StatisticsVo;
import cn.com.yusys.yscimc.operation.repository.mapper.ActivityFieldInfoMapper;
import cn.com.yusys.yscimc.operation.repository.mapper.ActivityStatisticsMapper;
import cn.com.yusys.yscimc.operation.service.ActivityStatisticsService;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketPositCt;
import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiFission;
import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiShare;
import cn.com.yusys.yusp.cm.market.service.CimpCmMarketPlanService;
import cn.com.yusys.yusp.cm.market.service.PresentationFormService;
import cn.com.yusys.yusp.cm.market.service.YscimcFmkActiFissionService;
import cn.com.yusys.yusp.cm.market.service.YscimcFmkActiShareService;
import cn.com.yusys.yusp.cm.market.vo.YscimcFMkActiFissionVo;
import cn.com.yusys.yusp.cm.market.vo.YscimcFMkActiShareVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/1/13 17:13
 */
@Service
public class ActivityStatisticsServiceImpl implements ActivityStatisticsService {

    @Autowired
    private PresentationFormService presentationFormService;

    @Autowired
    private CimpCmMarketPlanService marketPlanService;

    @Autowired
    private CmicAppAssembleSignUpService signUpService;

    @Autowired
    private YscimcFmkActiShareService shareService;

    @Autowired
    private YscimcFmkActiFissionService fissionService;

    @Autowired
    private ActivityStatisticsMapper mapper;

    @Autowired
    private ActivityFieldInfoMapper fieldInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void statistics(StatisticsVo vo) throws Exception {

        Date dateTime = new Date();
        Date startTime = null;
        Date endTime = null;

        if (vo.getAssemblyType().equals("1")) {
            CmicAppAssembleSignUpEntity signInfo = signUpService.getSignInfoById(vo.getNodeId());
            startTime = signInfo.getActStartTime();
            endTime = signInfo.getActEndTime();
            int virifyFlag = mapper.virifySignUp(vo);
            if (virifyFlag > 0) {
                throw new Exception("该手机号已报名");
            }
        } else if (vo.getAssemblyType().equals("2")) {
            YscimcFMkActiFissionVo fissionInfo = fissionService.getInfoByAssemble(vo.getNodeId());
            startTime = fissionInfo.getStartTime();
            endTime = fissionInfo.getEndTime();
            if (StringUtils.isBlank(vo.getInvitee()) || StringUtils.isBlank(vo.getReceiver()) || vo.getInvitee().equals(vo.getReceiver())) {
                return;
            }
            List<StatisticsVo> virifyFission = mapper.virifyFission(vo);
            for (StatisticsVo s : virifyFission
            ) {
                if (s.getInvitee().equals(vo.getInvitee())) {
                    return;
                }
            }
        } else if (vo.getAssemblyType().equals("3")) {
            YscimcFMkActiShareVo shareInfo = shareService.getInfoByAssemble(vo.getNodeId());
            startTime = shareInfo.getStartTime();
            endTime = shareInfo.getEndTime();

            if (StringUtils.isBlank(vo.getInvitee()) || StringUtils.isBlank(vo.getReceiver()) || vo.getInvitee().equals(vo.getReceiver())) {
                return;
            }
            List<StatisticsVo> virifyFission = mapper.virifyFission(vo);
            for (StatisticsVo s : virifyFission
            ) {
                if (s.getInvitee().equals(vo.getInvitee())) {
                    return;
                }
            }
        } else {
            throw new Exception("未知信息");
        }

        if (startTime.compareTo(dateTime) < 1 && dateTime.compareTo(endTime) < 1) {
            ActivityStatistics entity = new ActivityStatistics();
            BeanUtils.copyProperties(vo, entity);
            entity.setId(UUID.randomUUID().toString().replace("-", ""));
            entity.setCreateDate(dateTime);
            mapper.insertSelective(entity);
        } else {
            throw new Exception("不在活动时间内");
        }
    }

    /**
     * 通过活动ID添加营销方式到外部访问资源
     * @param actId 活动编号
     * @return
     */
    @Override
    public int saveActAddrForActId(String actId) {

        /** 查询流程中的营销方式组件 */
        List<Map<String, Object>> marketTypeAllByFlowId = presentationFormService.getMarketTypeAllByFlowId(actId);

        if (CollectionUtils.isEmpty(marketTypeAllByFlowId)){
            return 0;
        }
        /** 通过活动编号查询该活动的手机银行组件信息 */
        List<CimpCmMarketPositCt> cts = marketPlanService.getMarketPositCtByActId(actId);

        List<ActivityFieldInfo> list = new ArrayList<>();
        List<String> signUpIds = new ArrayList<>();
        List<String> fissionIds = new ArrayList<>();
        List<String> shareIds = new ArrayList<>();
        for (Map m : marketTypeAllByFlowId) {
            String ss = m.get("assemblyId").toString();
            switch (ss) {
                case "14"://报名组件
                    signUpIds.add(m.get("nodeId").toString());
                    break;
                case "55"://裂变组件
                    fissionIds.add(m.get("nodeId").toString());
                    break;
                case "71"://分享组件
                    shareIds.add(m.get("nodeId").toString());
                    break;
            }
        }
        if (!CollectionUtils.isEmpty(signUpIds)) {
            /**
             * 通过活动里的报名组件ID查询出报名组件信息并记录
             */
            List<CmicAppAssembleSignUpEntity> signUpVos = signUpService.getInfoByIds(signUpIds);
            for (CmicAppAssembleSignUpEntity vo : signUpVos) {
                ActivityFieldInfo info = new ActivityFieldInfo();

                info.setId(UUID.randomUUID().toString().replace("-", ""));
                info.setActId(actId);
                info.setStartTime(vo.getActStartTime());
                info.setEndTime(vo.getActEndTime());
                info.setActHtmlAddr(vo.getActHtml());
                info.setImageAddr(vo.getImageurl());
                info.setImageSize(vo.getImageSize());
                info.setAssemblyType(ComponentTypeEnum.SIGN_UP.getComponentType());
                /**
                 * 判断组件是否与活动下的手机银行组件关联，如果关联则标识，并添加手机栏位编号
                 */
                for (CimpCmMarketPositCt ct : cts) {
                    if (vo.getId().equals(ct.getMarketTypeId())) {
                        info.setFieldType("1");
                        info.setMktPositCode(ct.getMktPositCode());
                    }
                }
                list.add(info);
            }
        }
        if (!CollectionUtils.isEmpty(shareIds)) {
            /**
             * 通过活动里的分享组件ID查询出报名组件信息并记录
             */
            List<YscimcFMkActiShare> shareVos = shareService.getInfoByIds(shareIds);
            for (YscimcFMkActiShare vo : shareVos) {
                getFieldInfoList(actId, cts, list, vo.getStartTime(), vo.getEndTime(), vo.getActHtml(), vo.getImageurl(), vo.getImageSize(), vo.getNodeId(),ComponentTypeEnum.SHARE.getComponentType());
            }
        }
        if (!CollectionUtils.isEmpty(fissionIds)) {
            /**
             * 通过活动里的裂变组件ID查询出报名组件信息并记录
             */
            List<YscimcFMkActiFission> fissionVos = fissionService.getInfoByIds(fissionIds);
            for (YscimcFMkActiFission vo : fissionVos) {
                getFieldInfoList(actId, cts, list, vo.getStartTime(), vo.getEndTime(), vo.getActHtml(), vo.getImageurl(), vo.getImageSize(), vo.getNodeId(),ComponentTypeEnum.FISSION.getComponentType());
            }
        }

        if (!CollectionUtils.isEmpty(list)) {
            fieldInfoMapper.delByActId(actId);
            fieldInfoMapper.batchInsert(list);
        }
        return 0;
    }

    public ActivityFieldInfoMapper getFieldInfoMapper() {
        return this.fieldInfoMapper;
    }

    private void getFieldInfoList(String actId, List<CimpCmMarketPositCt> cts, List<ActivityFieldInfo> list, Date startTime, Date endTime, String actHtml, String imageurl, String imageSize, String nodeId,String assemblyType) {
        ActivityFieldInfo info = new ActivityFieldInfo();
        info.setId(UUID.randomUUID().toString().replace("-", ""));
        info.setActId(actId);
        info.setStartTime(startTime);
        info.setEndTime(endTime);
        info.setActHtmlAddr(actHtml);
        info.setImageAddr(imageurl);
        info.setImageSize(imageSize);
        info.setAssemblyType(assemblyType);
        /**
         * 判断组件是否与活动下的手机银行组件关联，如果关联则标识，并添加手机栏位编号
         */
        for (CimpCmMarketPositCt ct : cts
        ) {
            if (nodeId.equals(ct.getMarketTypeId())) {
                info.setFieldType("1");
                info.setMktPositCode(ct.getMktPositCode());
            }
        }
        list.add(info);
    }
}
