package com.yusys.streaminghub.rpc.netty.codec;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.netty.IRpcEncoder;
import com.yusys.streaminghub.rpc.service.MessageLogService;
import com.yusys.streaminghub.rpc.util.UtilRpc;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Slf4j
public class XmlRpcEncoder extends ResponseToByte implements IRpcEncoder {
    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void encode(RpcResponse response, ByteBuf byteBuf, ChannelHandlerContext channelHandlerContext) throws Exception {
        Map<String, String> header = response.getHeader();
        ByteArrayOutputStream os = null;
        try {
            os = new ByteArrayOutputStream();
            byte[] bytes = translateXmlResponse(response, os);
            String message = new String(bytes, UtilRpc.ENCODING);
            byteBuf.writeBytes(bytes);
            String backTime = sf.format(new Date());
            if (header.get("FLOW_ID")!=null && !"".equals(header.get("FLOW_ID"))){
                MessageLogService.msg2log(message,"1",backTime,backTime,header);
            }
        } catch (Exception e) {
            log.info("异常信息:" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
            }
        }
    }

}
//
//    /**
//     * 组装返回报文
//     *
//     * @return
//     * @throws IOException
//     */
//    private String sendRespMsg(JSONObject jsb) {
//
//        String respMsg = "";
//        ByteArrayOutputStream os = null;
//        try {
//            Document doc = new Document();
//
//            Element crm = new Element("CRM");
//            doc.setRootElement(crm);
//
//            Element srv_head = new Element("SRV_HEAD");
//            crm.addContent(srv_head);
//
//            srv_head.addContent(getElement("SERVICE_CODE", jsb.get("SERVICE_CODE").toString()));
//            srv_head.addContent(getElement("UPDATED_SYSTEM_ID", jsb.get("UPDATED_SYSTEM_ID").toString()));
//            srv_head.addContent(getElement("SRC_CREATE_TS", jsb.get("SRC_UPDATED_TS").toString()));
//            srv_head.addContent(getElement("SRC_UPDATED_TS", TIMESTAMPF.format(new Date())));
//            srv_head.addContent(getElement("UPDATED_USER", jsb.get("UPDATED_USER").toString()));
//            srv_head.addContent(getElement("UPDATED_UNIT", jsb.get("UPDATED_UNIT").toString()));
//            srv_head.addContent(getElement("FLOW_ID", jsb.get("FLOW_ID").toString()));
//            srv_head.addContent(getElement("ERROR_CODE", jsb.get("ERROR_CODE")
//                    .toString()));
//            srv_head.addContent(getElement("ERROR_MSG", jsb.get("ERROR_MSG")
//                    .toString()));
//
//            Element srv_body = new Element("SRV_BODY");
//            crm.addContent(srv_body);
//
//            //客户经理信息节点
//            Element cust_belong_arr = new Element("CUST_BELONG_ARR");
//            if (mgrList.size() == 0) {
//                srv_body.addContent(getElement("CUST_BELONG_ARR", ""));
//            } else {
//                srv_body.addContent(cust_belong_arr);
//            }
//
//            if (mgrList.size() > 0) {
//                for (int i = 0; i < mgrList.size(); i++) {
//                    Map<String, Object> map = new HashMap<String, Object>();
//                    map = mgrList.get(i);
//                    Iterator iter = (Iterator) map.keySet().iterator();
//                    while (iter.hasNext()) {
//                        String key = iter.next().toString();
//                        String value = map.get(key) == null ? "" : map.get(key).toString();
//                        cust_belong_arr.addContent(getElement(key, value));
//                    }
//                }
//            }
//
//            //客户分析信息节点
//            Element cust_analyse_arr = new Element("CUST_ANALYSE_ARR");
//            if (anaList.size() == 0) {
//                srv_body.addContent(getElement("CUST_ANALYSE_ARR", ""));
//            } else {
//                srv_body.addContent(cust_analyse_arr);
//            }
//            if (anaList.size() > 0) {
//                for (int i = 0; i < anaList.size(); i++) {
//                    Map<String, Object> map = new HashMap<String, Object>();
//                    map = anaList.get(i);
//                    Iterator iter = (Iterator) map.keySet().iterator();
//                    while (iter.hasNext()) {
//                        String key = iter.next().toString();
//                        String value = map.get(key) == null ? "" : map.get(key).toString();
//                        cust_analyse_arr.addContent(getElement(key, value));
//                    }
//                }
//            }
//
//
//            //客户评级信息节点
//            Element cust_grade_arr = new Element("CUST_GRADE_ARR");
//
//            if (grdList.size() == 0) {
//                srv_body.addContent(getElement("CUST_GRADE_ARR", ""));
//            } else {
//                srv_body.addContent(cust_grade_arr);
//            }
//            if (grdList.size() > 0) {
//                for (int i = 0; i < grdList.size(); i++) {
//                    Map<String, Object> map = new HashMap<String, Object>();
//                    map = grdList.get(i);
//                    Iterator iter = (Iterator) map.keySet().iterator();
//                    while (iter.hasNext()) {
//                        String key = iter.next().toString();
//                        String value = map.get(key) == null ? "" : map.get(key).toString();
//                        cust_grade_arr.addContent(getElement(key, value));
//                    }
//                }
//            }
//
//
//            //客户风险评估信息节点
//            Element cust_eva_arr = new Element("CUST_EVA_ARR");
//
//            if (evaList.size() == 0) {
//                srv_body.addContent(getElement("CUST_EVA_ARR", ""));
//            } else {
//                srv_body.addContent(cust_eva_arr);
//            }
//
//            if (evaList.size() > 0) {
//                for (int i = 0; i < evaList.size(); i++) {
//                    Map<String, Object> map = new HashMap<String, Object>();
//                    map = evaList.get(i);
//                    Iterator iter = (Iterator) map.keySet().iterator();
//                    while (iter.hasNext()) {
//                        String key = iter.next().toString();
//                        String value = map.get(key) == null ? "" : map.get(key).toString();
//                        cust_eva_arr.addContent(getElement(key, value));
//                    }
//                }
//            }
//
//            //客户业务汇总数据信息节点
//            Element cust_buss_inf_arr = new Element("CUST_BUSS_INF_ARR");
//            srv_body.addContent(cust_buss_inf_arr);
//            cust_buss_inf_arr.addContent(getElement("DEPOSIT_TERM_AMT", depositSum));
//            cust_buss_inf_arr.addContent(getElement("LOAN_TERM_AMT", loadSum));
//            cust_buss_inf_arr.addContent(getElement("FINANCE_BALANCE_RMB", financeSum));
//            cust_buss_inf_arr.addContent(getElement("INSSRANCE_AMT", insureSum));
//            cust_buss_inf_arr.addContent(getElement("CREDIT_BAL", creditSum));
//            cust_buss_inf_arr.addContent(getElement("GOLD_LOAN_BAL", goldLoanSum));
//            cust_buss_inf_arr.addContent(getElement("AUM_BAL_RMB", aumBalRmb));
//            cust_buss_inf_arr.addContent(getElement("AUM_YEAR_MAX", aumYearMax));
//
////			Format format = Format.getPrettyFormat();
//            Format format = Format.getRawFormat();
//            format.setEncoding(ENCODING);
//            format.setLineSeparator("");
//            XMLOutputter outputter = new XMLOutputter(format);
//
//            /* 报文流输出 */
//            os = new ByteArrayOutputStream();
//            outputter.output(doc, os);
//            respMsg = os.toString(ENCODING);
//            respMsg = extendZero(
//                    String.valueOf(respMsg.getBytes(ENCODING).length),
//                    HDRDESCLEN).concat(respMsg);
//            log.info("返回报文:" + respMsg);
//        } catch (Exception e) {
//            log.info("异常信息:" + e.getMessage());
//            e.printStackTrace();
//        } finally {
//
//            try {
//                if (os != null) {
//                    os.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return respMsg;
//    }
