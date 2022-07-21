package cn.com.yusys.yscimc.marketmethod.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.yusys.yscimc.marketmethod.domain.CimpCmNodesPresentation;
import cn.com.yusys.yscimc.marketmethod.domain.CmicAppMarketActyInfo;
import cn.com.yusys.yscimc.marketmethod.repository.mapper.CmicAppBulletinBoardMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @version 1.0.0
 * @项目名称：yscimc-app-mobile
 * @类名称：CmicAppBulletinBoardService
 * @类描述：公告板业务类
 * @功能描述:营销方式公告板
 * @创建人：chenlin2@yusys.com.cn
 * @创建时间：2019-06-11
 * @修改备注：
 * @修改日期 修改人员        修改原因 --------    --------		----------------------------------------
 * @Copyright (c) 2019宇信科技-版权所有
 */
@Service
public class CmicAppBulletinBoardService extends CommonService {

    @Autowired
    private CmicAppBulletinBoardMapper bulletinBoardMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return bulletinBoardMapper;
    }

    /**
     * @方法名称:bulletinBoardQuery
     * @方法描述:营销方式公告板
     * @参数与返回说明:condition: {"channel":"渠道ID（组件ID）","hurdles":"栏位标识"}
     * @算法描述:
     */
    public Map<String, List<Map<String, String>>> bulletinBoardQuery(QueryModel model) {
        //查询出操作表的活动信息
        List<Map<String, String>> nodeIdList = bulletinBoardMapper.bulletinBoardQuery(model);
        if (nodeIdList == null)
            return null;
        // 从返回的数据中获取栏位信息，对应栏位有活动才添加该栏位，否则不添加
        List<String> sign = new ArrayList<>();
        for (Map<String, String> map : nodeIdList) {
            if (sign.size() == 0 || !sign.contains(map.get("mktPositCode"))) {
                sign.add(map.get("mktPositCode"));
            }
        }
        Map<String, List<Map<String, String>>> actyInfoMap = new HashMap<>();
        for (int i = 0; i < sign.size(); i++) {
            String signNum = sign.get(i);
            List<Map<String, String>> signList = new ArrayList<>();
            nodeIdList.stream()
                    .filter((map) -> map.get("mktPositCode").equals(signNum))
                    .collect(Collectors.toList())
                    .stream()
                    .forEach((map) -> {
                        Map<String, String> actyInfo = new HashMap<>();
                        //组件的节点ID作为活动ID,取出来又存是因为设置了自动转驼峰会影响字段名
                        actyInfo.put("nodeId", map.get("ctNodeId"));
                        actyInfo.put("assemblyId", map.get("assemblyId"));
                        actyInfo.put("activityId", map.get("activityId"));
                        actyInfo.put("displayType", map.get("displayType"));
                        actyInfo.put("activityStartPic", map.get("activityStartPic"));
                        // 富文本需要根据activityStartPic获取到的id查询具体的文本内容
                        if (Objects.equals("3", map.get("displayType"))) {
                            actyInfo.put("detailContent", bulletinBoardMapper.getDetailContentById(actyInfo.get("activityStartPic")));
                        }
                        signList.add(actyInfo);
                    });
            actyInfoMap.put(signNum, signList);
        }
        return actyInfoMap;
    }

    /**
     * @方法名称:setMarketActy
     * @方法描述:营销位展示活动信息
     * @参数与返回说明:营销方式组件的配置信息（拼团信息的操作信息）
     * @算法描述:
     */
    public CmicAppMarketActyInfo setMarketActy(List<CimpCmNodesPresentation> list) {
        CmicAppMarketActyInfo actyInfo = new CmicAppMarketActyInfo();
        for (CimpCmNodesPresentation cimpCmNodesPresentation : list) {
            if (cimpCmNodesPresentation.getFormOperationFiled().equals("activityStartPic")) {
                actyInfo.setActivityStartPic(cimpCmNodesPresentation.getFormOperationVal());
                break;
            }
        }
        return actyInfo;
    }

    /**
     * @方法名称:setActyInfo
     * @方法描述:组装拼团活动信息
     * @参数与返回说明:营销方式组件的配置信息（拼团信息的操作信息）
     * @算法描述: 注actyId, activityStartPic是必须的参数
     */
    public CmicAppMarketActyInfo setActyInfo(String nodeId) {
        List<CimpCmNodesPresentation> list = bulletinBoardMapper.getMarketActy(nodeId);
        CmicAppMarketActyInfo actyInfo = new CmicAppMarketActyInfo();
        //组件的节点ID作为活动ID
        actyInfo.setActyId(nodeId);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFormOperationFiled().equals("avtivityTitle")) {
                actyInfo.setAvtivityTitle(list.get(i).getFormOperationVal());
            }
            if (list.get(i).getFormOperationFiled().equals("activityStartPic")) {
                actyInfo.setActivityStartPic(list.get(i).getFormOperationVal());
            }
            if (list.get(i).getFormOperationFiled().equals("acitvityRule")) {
                actyInfo.setAcitvityRule(list.get(i).getFormOperationVal());
            }
            if (list.get(i).getFormOperationFiled().equals("startTime")) {
                actyInfo.setStartTime(list.get(i).getFormOperationVal());
            }
            if (list.get(i).getFormOperationFiled().equals("prodName")) {
                actyInfo.setProdName(list.get(i).getFormOperationVal());
            }
            if (list.get(i).getFormOperationFiled().equals("endTime")) {
                actyInfo.setEndTime(list.get(i).getFormOperationVal());
            }
            if (list.get(i).getFormOperationFiled().equals("prodType")) {
                actyInfo.setProdType(list.get(i).getFormOperationVal());
            }
            if (list.get(i).getFormOperationFiled().equals("prodInfo")) {
                actyInfo.setProdInfo(list.get(i).getFormOperationVal());
            }
            if (list.get(i).getFormOperationFiled().equals("modelId")) {
                actyInfo.setModelId(list.get(i).getFormOperationVal());
            }
            // TODO 20190719 默认取得是一号团的人数，如果需要用到二三号团，此处需要调整
            if (list.get(i).getFormOperationFiled().equals("firstGroupNum")) {
                actyInfo.setAssembleNum(list.get(i).getFormOperationVal());
            }
            if (list.get(i).getFormOperationFiled().equals("prodOldPrice")) {
                actyInfo.setAssemblePrice(list.get(i).getFormOperationVal());
            }
            if (list.get(i).getFormOperationFiled().equals("markPic")) {
                actyInfo.setMarkPic(list.get(i).getFormOperationVal());
            }
        }
        return actyInfo;
    }
}
