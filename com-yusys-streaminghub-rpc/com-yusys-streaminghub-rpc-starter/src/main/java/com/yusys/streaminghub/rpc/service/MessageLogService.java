package com.yusys.streaminghub.rpc.service;

import com.yusys.streaminghub.rpc.domain.TPSmOperLogInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.file.OpenOption;
import java.util.Map;
@Component
public class MessageLogService {

    public static MessageLogService messageLog;//定义一个静态时实例

    @Autowired
    private OperateLogService operateLogService;


    @PostConstruct//使用这个java注解，让静态实例联系到mapper接口，下边这个方法完全写上，修改为自己的东西
    public void init() {
        messageLog = this;
        messageLog.operateLogService = this.operateLogService;
    }
    /**积分明细查询交易代码*/
    private static String SCORE_DETAILS_QUERY = "CYBQUERY_0001_000003";

    /**礼遇排序查询交易代码*/
    private static String SERVICE_QUERY = "CYBQUERY_0001_000004";

    /**积分兑换查询交易代码*/
    private static String SCORE_EXCHANGE = "CYBQUERY_0001_000005";

    /**订单查询交易代码*/
    private static String ORDER_QUERY = "CYBQUERY_0001_000006";

    /**查证接口查询交易代码*/
    private static String CHECK_QUERY = "CYBQUERY_0001_000007";

    /**客户评级查询交易代码*/
    private static String GRADE_QUERY = "CYBQUERY_0001_000008";

    /** 积分查询交易代码 */
    private static String BASE_SCORE_QUERY = "CYBQUERY_0001_000009";

    /**携程支付确认及消息回传接口代码*/
    private static String CTRIP_CALL_BACK = "CALL_BACK";

    /**移动进件营销平台*/
    private static String CUST_VIEW_QUERY = "CUSTVIEW_QUERY";

    /**APP、短信已经阅读信息返回*/
    private static String MSG_READ_CALLBACK = "040107_BACK";

    /**投诉工单推送交易代码*/
    private static String SHEET_PUSH = "CUST_COMPL_001";

    /**投诉工单查询交易代码*/
    private static String SHEET_QUERY = "CUST_COMPL_002";

    /**新版手机银行三个接口*/
    //接口交易代码
    //查询用户资产负债
    private final static String MBK_ASSET_QUERY ="MOBLIEBANK_AL_QUERY_001";
    //查询用户财富统计
    private final static String MBK_TREA_QUERY ="MOBLIEBANK_AL_QUERY_002";
    //历史收益明细查询
    private final static String MBK_EARN_QUERY ="MOBLIEBANK_AL_QUERY_003";

    /**电子渠道合格投资者认定接口*/
    private static String INVESTOR_JUDGE = "CUST_INVEST_JUDGE";

    /**电子渠道合格投资者认定详情接口*/
    private static String INVESTOR_JUDGE_EXT = "CUST_INVEST_JUDGE_EXT";


    public static void msg2log(String msgInfo, String isSuccess, String launchTime,
                               String backTime, Map<String,String> header){

        TPSmOperLogInf tpSmOperLogInf = new TPSmOperLogInf();
        // 接口发起方
        //TODO 日志实体类还未完善
        tpSmOperLogInf.setLaunch(header.get("UPDATED_SYSTEM_ID") != null ? header.get("UPDATED_SYSTEM_ID"):"");
        //接口接收方 1:ECIE;2:CRM;3:YIP;4:网银;5:YRL;6:短信平台;7:NDS
        tpSmOperLogInf.setReceive("CRM");
        //业务数据对象
        tpSmOperLogInf.setBusObject(msgInfo.toString());
        //是否返回成功标识
        tpSmOperLogInf.setIfSuccess(isSuccess);
        //操作类型 1:新增:2:更新:3:删除;4:查询:5:其他;6:联机;
        tpSmOperLogInf.setOpType("6");
        //流水类型 1:前台功能操作; 2:实时联机接口;
        tpSmOperLogInf.setFlowType("2");
        String SERVICE_CODE = header.get("SERVICE_CODE") != null ? header.get("SERVICE_CODE"):"";
        String UPDATED_USER = header.get("UPDATED_USER") != null && "1".equals(isSuccess) ? header.get("UPDATED_USER"):"";



        if (SERVICE_CODE.equals(GRADE_QUERY)) {
            // 功能名称
            tpSmOperLogInf.setMouldName("客户评级信息接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI23");
        } else if (SERVICE_CODE.equals(BASE_SCORE_QUERY)) {
            // 功能名称
            tpSmOperLogInf.setMouldName("积分汇总查询接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI12");
        } else if (SERVICE_CODE.equals(SCORE_DETAILS_QUERY)) {
            // 功能名称
            tpSmOperLogInf.setMouldName("积分明细查询接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI13");
        } else if (SERVICE_CODE.equals(SERVICE_QUERY)) {
            // 功能名称
            tpSmOperLogInf.setMouldName("礼遇排序接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI14");
        } else if (SERVICE_CODE.equals(SCORE_EXCHANGE)) {
            // 功能名称
            tpSmOperLogInf.setMouldName("积分兑换接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI15");
        } else if (SERVICE_CODE.equals(ORDER_QUERY)) {
            // 功能名称
            tpSmOperLogInf.setMouldName("订单查询接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI16");
        } else if (SERVICE_CODE.equals(CHECK_QUERY)) {
            // 功能名称
            tpSmOperLogInf.setMouldName("查证接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI18");
        } else if (SERVICE_CODE.startsWith(CUST_VIEW_QUERY)) {
            // 功能名称
            tpSmOperLogInf.setMouldName("移动进件营销平台接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI22");
        }
        else if(SERVICE_CODE.startsWith(CTRIP_CALL_BACK)){
            // 功能名称
            tpSmOperLogInf.setMouldName("携程支付确认及消息回传接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI21");
        }else if (SERVICE_CODE.equals(SHEET_PUSH)) {
            // 功能名称
            tpSmOperLogInf.setMouldName("投诉工单推送接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI23");
        } else if (SERVICE_CODE.equals(SHEET_QUERY)) {
            // 功能名称
            tpSmOperLogInf.setMouldName("投诉工单查询接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI24");
        }else if(SERVICE_CODE.equals(MBK_ASSET_QUERY)){
            // 功能名称
            tpSmOperLogInf.setMouldName("新手机银行查询用户资产负债");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI35");
        }else if(SERVICE_CODE.equals(MBK_TREA_QUERY)){
            // 功能名称
            tpSmOperLogInf.setMouldName("新手机银行查询用户财富统计");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI36");
        }else if(SERVICE_CODE.equals(MBK_EARN_QUERY)){
            // 功能名称
            tpSmOperLogInf.setMouldName("新手机银行历史收益明细查询");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI37");
        }else if(SERVICE_CODE.equals(INVESTOR_JUDGE)){
            // 功能名称
            tpSmOperLogInf.setMouldName("电子渠道合格投资者认定接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI39");
        }else if(SERVICE_CODE.equals(INVESTOR_JUDGE_EXT)){
            // 功能名称
            tpSmOperLogInf.setMouldName("合格投资者行外资产认定接口");
            // 功能类型编号
            tpSmOperLogInf.setMouldType("LI40");
        }else {
            //功能名称
            tpSmOperLogInf.setMouldName("");
            //功能类型编号
            tpSmOperLogInf.setMouldType("");
        }



        //操作用户编号
        tpSmOperLogInf.setUserNo("");
        //操作用户姓名
        tpSmOperLogInf.setUserName(UPDATED_USER);

        //报文发送时间
        tpSmOperLogInf.setLaunchTime(launchTime);
        //报文接受时间
        tpSmOperLogInf.setBackTime(backTime);
        //源系统联机业务流水编号
        tpSmOperLogInf.setSrcFlowNo(header.get("FLOW_ID"));
        if (header.get("SRC_UPDATED_TS")!=null) {
            tpSmOperLogInf.setSrcUpdatedTs(header.get("SRC_CREATE_TS")!=null ? header.get("SRC_CREATE_TS") : header.get("SRC_UPDATED_TS"));
        }else {
            tpSmOperLogInf.setSrcUpdatedTs("");
        }

        messageLog.operateLogService.operateLogService(tpSmOperLogInf);

        //new OperateLogService(tpSmOperLogInf).start();
    }

}