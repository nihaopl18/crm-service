package cn.com.yusys.yscimc.assemble.service;

import java.math.BigDecimal;
import java.util.*;

import cn.com.yusys.yscimc.marketmethod.domain.CimpCmNodesPresentation;
import cn.com.yusys.yscimc.marketmethod.repository.mapper.CmicAppBulletinBoardMapper;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.sequence.service.SequenceTemplateService;
import cn.com.yusys.yscimc.assemble.domain.CmicAppAssembleCusts;
import cn.com.yusys.yscimc.assemble.domain.LoyAcOrderList;
import cn.com.yusys.yscimc.assemble.repository.mapper.CmicAppAssembleCustsMapper;
import cn.com.yusys.yscimc.assemble.repository.mapper.CmicAppLoyAcOrderListMapper;
import org.springframework.util.StringUtils;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @version 1.0.0
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CmicAppAssembleCustsService
 * @类描述: #服务类
 * @功能描述: 客户拼团信息
 * @创建人: chenl
 * @创建时间: 2019-06-12
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CmicAppAssembleCustsService extends CommonService {
    private static final Logger log = getLogger(CmicAppAssembleCustsService.class);

    @Autowired
    private CmicAppAssembleCustsMapper cmicAppAssembleCustsMapper;
    @Autowired
    private CmicAppLoyAcOrderListMapper orderMapper;
    @Autowired
    private SequenceTemplateService sequenceConfigService;
    @Autowired
    private CmicAppBulletinBoardMapper cmicAppBulletinBoardMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return cmicAppAssembleCustsMapper;
    }

    /**
     * @方法名称:getAssembleNum
     * @方法描述:生成团Id
     * @参数与返回说明:
     * @算法描述:
     */
    public String getAssembleNum() {
        return sequenceConfigService.getNextSeq("ID_SEQUENCES");
    }

    /**
     * 保存客户拼团信息
     * 1、新开团生成团ID。
     * 2、加入团，随机加入未满团。
     * 拼团客户信息做add操作，根据活动id及团id统计区分。
     */
    @Override
    public int insert(Object record) {
        CmicAppAssembleCusts assemble = (CmicAppAssembleCusts) record;
        // 判断用户是否已参加了该活动
        List<Map<String, Object>> custList = cmicAppAssembleCustsMapper.getCustByActyid(assemble.getActyId());
        for (Map<String, Object> map : custList) {
            if (map.get("custId").equals(assemble.getCustId())) {
                return -1;
            }
        }

        if (assemble.getNewOrIn().equals("N")) {//新开团
            assemble.setAssembleId("PT" + getAssembleNum());
        }
        assemble.setAssembleTime(new Date()); // 拼团时间
        assemble.setAssembleType("1");// TODO 20190719 默认为一号团，需要前端传数据（用户选择的是一号团还是二号三号团）
        // 根据团的类型查询拼团价格和拼团人数
        List<CimpCmNodesPresentation> list = cmicAppBulletinBoardMapper.getMarketActy(assemble.getActyId());
        list.parallelStream().forEach(c -> {
            if (Objects.equals("1", assemble.getAssembleType())) {
                if (c.getFormOperationFiled().equals("firstGroupNum")) {
                    assemble.setAssemblePirce(c.getFormOperationVal());
                }
                if (c.getFormOperationFiled().equals("firstGroupPrice")) {
                    assemble.setAssembleNum(c.getFormOperationVal());
                }
            } else if (Objects.equals("2", assemble.getAssembleType())) {
                if (c.getFormOperationFiled().equals("twoGroupNum")) {
                    assemble.setAssemblePirce(c.getFormOperationVal());
                }
                if (c.getFormOperationFiled().equals("twoGroupPrice")) {
                    assemble.setAssembleNum(c.getFormOperationVal());
                }
            } else if (Objects.equals("3", assemble.getAssembleType())) {
                if (c.getFormOperationFiled().equals("threeGroupNum")) {
                    assemble.setAssemblePirce(c.getFormOperationVal());
                }
                if (c.getFormOperationFiled().equals("threeGroupPrice")) {
                    assemble.setAssembleNum(c.getFormOperationVal());
                }
            }
        });
        // 插入订单
        saveOrder(assemble);
        // 将客户信息存到拼团客户信息表中
        return super.insertSelective(assemble);
    }

    /**
     * @方法名称:joinAssemble
     * @方法描述:加入拼团
     * @参数与返回说明:data：加入团队所需的信息
     * @算法描述:
     */
    public ResultDto<CmicAppAssembleCusts> joinAssemble(Map<String, String> data) {
        List<Map<String, String>> assembleList = cmicAppAssembleCustsMapper.getAssembleInfoByAssId(data.get("assembleId"));
        Map<String, String> assembleInfo = new HashMap<>();
        // 获取团长的团信息
        for (Map<String, String> map : assembleList) {
            if (Objects.equals("1", map.get("isRegCom")))
                assembleInfo = map;
        }
        // 判断用户是否已参加该活动，判断用户是否加入自己的团
        List<Map<String, Object>> custList = cmicAppAssembleCustsMapper.getCustByActyid(assembleInfo.get("actyId"));
        for (Map<String, Object> map : custList) {
            if (map.get("custId").equals(data.get("custId"))) {
                if (map.containsKey("isRegCom") && map.get("isRegCom").equals("1")) {
                    return new ResultDto(-1, "您不能加入自己的拼团！");
                } else
                    return new ResultDto(-1, "您已参加了该活动！");
            }
        }
        // 拼装用户信息，插入数据，提示用户拼团成功
        CmicAppAssembleCusts cmicAppAssembleCusts = new CmicAppAssembleCusts();
        cmicAppAssembleCusts.setId(UUID.randomUUID().toString().toLowerCase().replace("-", ""));
        cmicAppAssembleCusts.setAssembleId(data.get("assembleId"));
        cmicAppAssembleCusts.setActyId(assembleInfo.get("actyId"));
        cmicAppAssembleCusts.setRecommenderId(StringUtils.isEmpty(data.get("recommenderId")) ? "" : data.get("recommenderId"));// 当用户是点击推荐连接时需要填写分享人信息
        cmicAppAssembleCusts.setRecommender("");
        cmicAppAssembleCusts.setCustId(data.get("custId"));
        cmicAppAssembleCusts.setProId(assembleInfo.get("proId"));
        cmicAppAssembleCusts.setChannel(assembleInfo.get("channel"));
        cmicAppAssembleCusts.setHurdles(assembleInfo.get("hurdles"));
        cmicAppAssembleCusts.setBuyNum(Long.valueOf(data.get("buyNum")));// 虚拟产品默认1，实物可选数量
        cmicAppAssembleCusts.setAssemblePirce(assembleInfo.get("assemblePrice") == null ? "" : assembleInfo.get("modelId"));
        cmicAppAssembleCusts.setAssembleTime(new Date());
        cmicAppAssembleCusts.setModelId(assembleInfo.get("modelId") == null ? "" : assembleInfo.get("modelId"));
        cmicAppAssembleCusts.setIsRegCom("0");
        // 加入订单
        saveOrder(cmicAppAssembleCusts);
        // 插入拼团客户表
        int flag = cmicAppAssembleCustsMapper.joinAssemble(cmicAppAssembleCusts);
        // 该团当前人数
        int assembleNum = cmicAppAssembleCustsMapper.getCustNumByAssembleId(data.get("assembleId"));
        int fullAssNum = 0;
        List<CimpCmNodesPresentation> list = cmicAppBulletinBoardMapper.getMarketActy(cmicAppAssembleCusts.getActyId());
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals("1", cmicAppAssembleCusts.getAssembleType()) &&
                    list.get(i).getFormOperationFiled().equals("firstGroupNum")) {
                fullAssNum = Integer.valueOf(list.get(i).getFormOperationVal());
            } else if (Objects.equals("2", cmicAppAssembleCusts.getAssembleType()) &&
                    list.get(i).getFormOperationFiled().equals("twoGroupNum")) {
                fullAssNum = Integer.valueOf(list.get(i).getFormOperationVal());
            } else if (Objects.equals("3", cmicAppAssembleCusts.getAssembleType()) &&
                    list.get(i).getFormOperationFiled().equals("threeGroupNum")) {
                fullAssNum = Integer.valueOf(list.get(i).getFormOperationVal());
            }
        }
        // 满团后修改对应订单状态（包括该团的其他成员的订单状态）
        if (fullAssNum == assembleNum) {
            // 修改团其他成员的订单状态
            for (Map<String, String> map : assembleList) {
                // 拼团待支付状态
                cmicAppAssembleCustsMapper.updateOrderState("8", map.get("custId"), map.get("actyId"));
            }
            // 修改自己的订单状态（拼团待支付状态）
            cmicAppAssembleCustsMapper.updateOrderState("8", cmicAppAssembleCusts.getCustId(), cmicAppAssembleCusts.getActyId());
        }
        if (flag > 0) {
            cmicAppAssembleCusts.setAssembleNum(String.valueOf(assembleNum));
            return new ResultDto<>(cmicAppAssembleCusts);
        }
        return new ResultDto(-1, "加入团失败！");
    }

    /**
     * @方法名称:getAssembleByCusId
     * @方法描述:根据用户Id和actyId查询团信息
     * @参数与返回说明:custId:用户Id
     * @算法描述:
     */
    public CmicAppAssembleCusts getAssembleByCustId(String custId, String actyId) {
        return cmicAppAssembleCustsMapper.getAssembleByCustId(custId, actyId);
    }

    /**
     * @方法名称:getAssembleNum
     * @方法描述:获取未满团信息
     * @参数与返回说明:活动id、拼团人数
     * @算法描述:
     */
    public List<Map<String, Object>> getAssembleNum(Map<String, String> param) {
        int firstGroup = 0, secondGroup = 0, thirdGroup = 0;
        List<CimpCmNodesPresentation> nodesPresentationList = cmicAppBulletinBoardMapper.getMarketActy(param.get("actyId"));
        if(null == nodesPresentationList){
            return null;
        }
        for (CimpCmNodesPresentation c : nodesPresentationList) {
            if (c.getFormOperationFiled().equals("firstGroupNum")) {
                firstGroup = Integer.valueOf(c.getFormOperationVal());
                break;
            } else if (c.getFormOperationFiled().equals("twoGroupNum")) {
                secondGroup = Integer.valueOf(c.getFormOperationVal());
                break;
            } else if (c.getFormOperationFiled().equals("threeGroupNum")) {
                thirdGroup = Integer.valueOf(c.getFormOperationVal());
                break;
            }
        }
        // 查询所有团信息
        List<Map<String, Object>> list = cmicAppAssembleCustsMapper.getAssembleNum(param);
        // 筛选未满团
        Iterator<Map<String, Object>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Map<String, Object> map = iterator.next();
            String assembleId = map.get("assembleId").toString();
            int alerady = cmicAppAssembleCustsMapper.getCustNumByAssembleId(assembleId);
            // 根据团类型来筛选
            if ((Objects.equals("1", map.get("assembleType")) && alerady >= firstGroup) ||
                    (Objects.equals("2", map.get("assembleType")) && alerady >= secondGroup) ||
                    (Objects.equals("3", map.get("assembleType")) && alerady >= thirdGroup)) {
                iterator.remove();
            } else {
                map.put("alerady", alerady);
            }
        }
        return list;
    }

    /**
     * @方法名称:saveOrder
     * @方法描述:生成订单
     * @参数与返回说明:
     * @算法描述:
     */
    public int saveOrder(CmicAppAssembleCusts assemble) {
        LoyAcOrderList order = new LoyAcOrderList();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        order.setOrderNumber(uuid);//订单号
        order.setOrderState("7");//状态（拼团进行中）

        order.setOrderStartDate(new Date());//下单日期

        order.setOrderType("Q");//订单类型（Q-渠道，E-引擎）
        order.setCommodityCode(assemble.getProId());
        order.setCommodityNumber(BigDecimal.valueOf(assemble.getBuyNum()));
        //商品类型R-实物V-虚拟P-金融产品
        //金融产品
        if ("prod".equals(assemble.getProdType())) {
            order.setCommodityType("P");
        }
        //虚拟票券
        if ("coupon".equals(assemble.getProdType())) {
            order.setCommodityType("V");
            List<Map<String, Object>> stockList = cmicAppAssembleCustsMapper.getVirtStock();
            if (stockList.size() > assemble.getBuyNum()) {
                for (int i = 0; i < stockList.size(); i++) {
                    Map<String, String> param = new HashMap<>();
                    param.put("ordernNumber", uuid);
                    param.put("ticketNo", stockList.get(i).get("TICKET_NO").toString());
                    param.put("virtNo", stockList.get(i).get("VIRT_NO").toString());
                    param.put("virtPwd", stockList.get(i).get("VIRT_PWD").toString());
                    cmicAppAssembleCustsMapper.insertVirtOut(param);
                    cmicAppAssembleCustsMapper.updateVirtStock(param);
                }
            }
        }
        //实物商品
        if ("goods".equals(assemble.getProdType())) {
            order.setCommodityType("R");
            order.setModelParam(assemble.getModelId());
        }
        order.setOrderCustId(assemble.getCustId());
        order.setActivityId(assemble.getActyId()); // 活动ID即nodeId
        return super.insertSelective(orderMapper, order);
    }


    /**
     * @方法名称:getCustByActyid
     * @方法描述:根据活动id查询参与拼团客户信息
     * @参数与返回说明:actyId(活动id)
     * @算法描述:
     */
    public List<Map<String, Object>> getCustByActyid(String actyId) {
        List<Map<String, Object>> list = cmicAppAssembleCustsMapper.getCustByActyid(actyId);
        return list;
    }

    /**
     * @方法名称:addReward
     * @方法描述:被分享人点击链接后为分享人增加奖励
     * @参数与返回说明:map:裂变和增加奖励所需要的数据
     * @算法描述:
     */
    public ResultDto<String> addReward(Map<String, Object> map) {
        //  String nodeId,String activityId, String recommenderId,String custId,String data
        // TODO 拼团页面需要判断跳转地址中的参数，根据参数判断用户是通过分享进入还是主动点击进入活动页面
        // TODO 调用拼团接口为分享人增加奖励（具体增加什么奖励需要读取配置)
        return new ResultDto<>();
    }
}
