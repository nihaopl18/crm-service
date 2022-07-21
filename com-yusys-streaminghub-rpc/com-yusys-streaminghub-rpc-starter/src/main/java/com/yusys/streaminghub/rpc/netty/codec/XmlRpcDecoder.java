package com.yusys.streaminghub.rpc.netty.codec;

import com.yusys.streaminghub.rpc.RpcRequest;
import com.yusys.streaminghub.rpc.netty.IRpcDecoder;
import com.yusys.streaminghub.rpc.service.MessageLogService;
import com.yusys.streaminghub.rpc.util.UtilRpc;
import io.netty.channel.ChannelHandlerContext;
import org.eclipse.jetty.util.ProcessorUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class XmlRpcDecoder implements IRpcDecoder {

    private final Logger log = LoggerFactory.getLogger(XmlRpcDecoder.class);

    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int queryNum = 10;

    int[] rowBounds = new int[2];

    @Override
    public void decode(byte[] bytes, List<Object> outList, ChannelHandlerContext channelHandlerContext) throws Exception {
        String message = new String(bytes, UtilRpc.ENCODING);
        String messageOLOB = message;
        String messageLenStr = message.substring(0, UtilRpc.HDRDESCLEN);
        long messageCharCount = Long.valueOf(messageLenStr);
        message = message.substring(UtilRpc.HDRDESCLEN);
        log.info("【请求报文】:"+message);
        RpcRequest request = new RpcRequest("xml");
        String launchTime = sf.format(new Date());
        Element root = buildParseModule(message);
        // 解析报文头信息
        Element srv_head = root.getChild("SRV_HEAD");
        List<Element> headers = srv_head.getChildren();
        Map<String, String> header = request.getHeader();
        for (Element element : headers) {
            String k=element.getName();
            String v=element.getTextTrim();
            header.put(k, v);
        }
        // 获取翻页信息
        Element app_head = root.getChild("app_head")==null?root.getChild("APP_HEAD"):root.getChild("app_head");
        if (app_head != null){
            request.setAppHead(true);
            // 上翻/下翻标识
            String pgupPgdnString =app_head.getChildTextTrim("PGUP_OR_PGDN") == null ? "" :app_head.getChildTextTrim("PGUP_OR_PGDN");
            request.setPgupPgdn(StringUtils.isEmpty(pgupPgdnString)?null:Integer.valueOf(pgupPgdnString));
            // 记录数
            String totalNumString =app_head.getChildTextTrim("TOTAL_NUM") == null ? "" :app_head.getChildTextTrim("TOTAL_NUM");
            request.setTotalNum(StringUtils.isEmpty(totalNumString)?0:Integer.valueOf(totalNumString));
            // 当前记录号
            String currentNumString =app_head.getChildTextTrim("CURRENT_NUM") == null ? "" :app_head.getChildTextTrim("CURRENT_NUM");
            request.setCurrentNum(StringUtils.isEmpty(currentNumString)?0:Integer.valueOf(currentNumString));
            // 本页第一笔标识
            String pageStartString =app_head.getChildTextTrim("PAGE_START") == null ? "" :app_head.getChildTextTrim("PAGE_START");
            request.setPageStart(StringUtils.isEmpty(pageStartString)?0:Integer.valueOf(pageStartString));
            // 本页最后一笔标识
            String pageEndString =app_head.getChildTextTrim("PAGE_END") == null ? "" :app_head.getChildTextTrim("PAGE_END");
            request.setPageEnd(StringUtils.isEmpty(pageEndString)?0:Integer.valueOf(pageEndString));
        }
        // 解析报文体信息
        Element srv_body = root.getChild("SRV_BODY");
        List<Element> bodies = srv_body.getChildren();
        Map<String, Object> body = request.getBody();
        body.putAll(getBody(bodies));
//        for (Element element : bodies) {
//            String k=element.getName();
//            String v=element.getTextTrim();
//            body.put(k, v);
//        }
        if (header.get("FLOW_ID")!=null && !"".equals(header.get("FLOW_ID"))){
            MessageLogService.msg2log(messageOLOB,"",launchTime,launchTime,header);
        }
        outList.add(request);
    }

    private Map<String, Object> getBody(List<Element> srv_body) {
        Map<String,Object> map = new LinkedHashMap<>();
        for (Element element :srv_body) {
            String k = element.getName();
            List<Element> children = element.getChildren();
            if (children != null && children.size() > 0){
                List<String> names = getChidrenNames(element);
                if (names.size() == 1){
                   List<Map<String,Object>> list = new ArrayList<>();
                    for (Element e : children) {
                        list.add(getBody(e.getChildren()));
                    }
                    map.put(names.get(0),list);
                }else {
                    for (String str : names) {
                        map.put(str,getBody(element.getChildren(str)));
                    }
                }
            }else {
                String v = element.getTextTrim();
                map.put(k, v);
            }
        }
        return map;
    }

    private List<String> getChidrenNames(Element e){
        String name = "";
        List<Element> c = e.getChildren();
        for (Element element : c) {
            String str = element.getName();
            if ("".equals(name)){
                name = str;
            }else if (!name.contains(str)){
                name += ","+str;
            }
        }
        return Arrays.asList(name.split(","));
    }

    private Element buildParseModule(String msg) throws Exception {
        InputStream is = null;

        try {
            byte[] bytes = msg.getBytes(UtilRpc.ENCODING);
            //字符串报文 -> 输入流报文
            is = new ByteArrayInputStream(msg.getBytes(UtilRpc.ENCODING));
            //构建sax文档模型
            SAXBuilder sax = new SAXBuilder();
            //根据文档模型和输入流创建xml文档
            Document dom = sax.build(is);

            //获取根节点
            Element root = dom.getRootElement();

            return root;
        } finally {
            if (is != null) is.close();
        }
    }
//
//    //解析请求报文
//
//    /**
//     * 解析请求报文
//     *
//     * @param msg
//     * @throws Exception
//     */
//    public String parseReqMsg(String msg) throws Exception {
//
//        String resp = "";
//
//        Element root = buildParseModule(msg.substring(HDRDESCLEN));
//
//        jsb.put("SERVICE_CODE", SERVICE_CODE);
//        jsb.put("FLOW_ID", FLOW_ID);
//        jsb.put("UPDATED_USER", UPDATED_USER);
//
//        // 解析报文头信息
//        Element srv_head = root.getChild("SRV_HEAD");
//
//        // 获取报文头值
//        SERVICE_CODE = notNull(srv_head.getChildTextTrim("SERVICE_CODE"));
//        UPDATED_SYSTEM_ID = notNull(srv_head
//                .getChildTextTrim("UPDATED_SYSTEM_ID"));
//        SRC_UPDATED_TS = notNull(srv_head.getChildTextTrim("SRC_UPDATED_TS"));
//        UPDATED_USER = notNull(srv_head.getChildTextTrim("UPDATED_USER"));
//        UPDATED_UNIT = notNull(srv_head.getChildTextTrim("UPDATED_UNIT"));
//        FLOW_ID = notNull(srv_head.getChildTextTrim("FLOW_ID"));
//
//        // 获取翻页信息
//        Element app_head = root.getChild("app_head");
//        if (app_head != null && !"".equals(app_head)) {
//            // 上翻/下翻标识
//            String pgupPgdn = notNull(app_head.getChildTextTrim("PGUP_OR_PGDN"));
//            if (!"".equals(pgupPgdn)) {
//                pgup_or_pgdn = Integer.valueOf(pgupPgdn);
//            }
//            // 记录数
//            String totalNum = notNull(app_head.getChildTextTrim("TOTAL_NUM"));
//            if (!"".equals(totalNum)) {
//                total_num = Integer.valueOf(totalNum);
//            }
//            // 当前记录号
//            String currentNum = notNull(app_head.getChildTextTrim("CURRENT_NUM"));
//            if (!"".equals(currentNum)) {
//                current_num = Integer.valueOf(currentNum);
//            }
//            // 本页第一笔标识
//            String pageStart = notNull(app_head.getChildTextTrim("PAGE_START"));
//            if (!"".equals(pageStart)) {
//                page_start = Integer.valueOf(pageStart);
//            }
//            // 本页最后一笔标识
//            String pageEnd = notNull(app_head.getChildTextTrim("PAGE_END"));
//            if (!"".equals(pageEnd)) {
//                page_end = Integer.valueOf(pageEnd);
//            }
//        }
//
//// 解析报文体信息
//        Element srv_body = root.getChild("SRV_BODY");
//        // 标识
//        FLAG = notNull(srv_body.getChildTextTrim("FLAG"));
//        // 源系统编号
//        SYSTEM_ID = notNull(srv_body.getChildTextTrim("SYSTEM_ID"));
//        //客户经理编号
//        CUST_MGR_NO = notNull(srv_body.getChildTextTrim("CUST_MGR_NO"));
//        //客户经理所属机构编号
//        CUST_MGR_NO_ORG = notNull(srv_body.getChildTextTrim("CUST_MGR_NO_ORG"));
//        // 源系统客户号
//        CUST_ID = notNull(srv_body.getChildTextTrim("CUST_ID"));
//        // 证件号码
//        GLOBAL_ID = notNull(srv_body.getChildTextTrim("GLOBAL_ID"));
//        // 证件类型
//        GLOBAL_TYPE = notNull(srv_body.getChildTextTrim("GLOBAL_TYPE"));
//        // 签发国家
//        GLOBAL_CON = notNull(srv_body.getChildTextTrim("GLOBAL_CON"));
//
//        jsb.put("SERVICE_CODE", SERVICE_CODE);
//        jsb.put("UPDATED_SYSTEM_ID", UPDATED_SYSTEM_ID);
//        jsb.put("SRC_UPDATED_TS", SRC_UPDATED_TS);
//        jsb.put("UPDATED_USER", UPDATED_USER);
//        jsb.put("UPDATED_UNIT", UPDATED_UNIT);
//        jsb.put("FLOW_ID", FLOW_ID);
//        jsb.put("ERROR_CODE", ERROR_CODE);
//        jsb.put("ERROR_MSG", ERROR_MSG);
//
//        jsb.put("pgup_or_pgdn", pgup_or_pgdn);
//        jsb.put("total_num", total_num);
//        jsb.put("current_num", current_num);
//        jsb.put("page_start", page_start);
//        jsb.put("page_end", page_end);
//
//        if ("".equals(FLAG)) {
//            jsb.put("ERROR_CODE", "1002");
//            jsb.put("ERROR_MSG", "FLAG标识内容不允许为空");
//        } else if ("01".equals(FLAG) || "1".equals(FLAG)) {
//            if ("".equals(CUST_ID) || "".equals(SYSTEM_ID)) {
//                jsb.put("ERROR_CODE", "1002");
//                jsb.put("ERROR_MSG", "源系统号与源系统客户号内容不允许为空");
//            } else {
//                jsb.put("CUST_ID", CUST_ID);
//                jsb.put("SYSTEM_ID", SYSTEM_ID);
//                ecif_cust_no = queryEcifNo(jsb);
//            }
//        } else if ("02".equals(FLAG) || "2".equals(FLAG)) {
//            if ("".equals(GLOBAL_ID) || "".equals(GLOBAL_TYPE)
//                    || "".equals(GLOBAL_CON)) {
//                jsb.put("ERROR_CODE", "1002");
//                jsb.put("ERROR_MSG", "客户证件类型、证件号码、签发国家内容不允许为空");
//            } else {
//                jsb.put("GLOBAL_ID", GLOBAL_ID);
//                jsb.put("GLOBAL_TYPE", GLOBAL_TYPE);
//                jsb.put("GLOBAL_CON", GLOBAL_CON);
//                ecif_cust_no = queryEcifCustNo(GLOBAL_ID, GLOBAL_TYPE, GLOBAL_CON);
//            }
//        }
//
//
//        CustAuthorityQuery authority = new CustAuthorityQuery();
//
//        String bank_rela_flag = "";
//        //lchszdev091 Add 20160330  个人网银、手机银行、个人贷款系统不查询管户关系；仅移动进件营销平台查询管户关系
//        log.info("更新系统号：" + UPDATED_SYSTEM_ID + "(个人网银:CYB 手机银行:MBK 个人贷款:YRL  移动进件:MMP)");
//
//        if (UPDATED_SYSTEM_ID.equals(MMP_SYSTEM_ID)) {
//            bank_rela_flag = authority.relaAuthorityQuery(ecif_cust_no, CUST_MGR_NO);
//        } else {
//            bank_rela_flag = "1";
//        }
//
//        if ("".equals(UPDATED_SYSTEM_ID) || UPDATED_SYSTEM_ID == null) {
//            jsb.put("ERROR_CODE", "1007");
//            jsb.put("ERROR_MSG", "报文头请求方系统号UPDATED_SYSTEM_ID字段不能为空");
//            resp = sendRespMsg();
//        } else if ("".equals(ecif_cust_no)) {
//            jsb.put("ERROR_CODE", "1003");
//            jsb.put("ERROR_MSG", "未查询到该客户对应的ecif客户号");
//            resp = sendRespMsg();
//        } else if ("4".equals(bank_rela_flag)) {
//            jsb.put("ERROR_CODE", "1005");
//            jsb.put("ERROR_MSG", "该客户经理非客户主办，无权限查询");
//            resp = sendRespMsg();
//        } else {
//            jsb.put("ECIF_CUST_NO", ecif_cust_no);
//            jsb.put("BANK_RELA_FLAG", bank_rela_flag);
//            jsb.put("CUST_MGR_NO", CUST_MGR_NO);
//            jsb.put("CUST_MGR_NO_ORG", CUST_MGR_NO_ORG);
//            if (CUSTVIEW_SUM_QUERY.equals(SERVICE_CODE)) {
//                //add by renlian 20150611
//                resp = new CustSumBaseInfQuery().queryBaseInf(jsb);
//            } else if (CUSTVIEW_DEPOSIT_QUERY.equals(SERVICE_CODE)) {
//                //add by songbo 20150611
//                resp = new CustDepositAcctQuery().sendRespMsg(jsb);
//            } else if (CUSTVIEW_FINANCE_QUERY.equals(SERVICE_CODE)) {
//                //add by songbo 20150611
//                resp = new CustFinanceAcctQuery().sendRespMsg(jsb);
//            } else if (CUSTVIEW_INSURE_QUERY.equals(SERVICE_CODE)) {
//                //add by guorongchun 20150611
//                resp = new CustInsuranceAcctQuery().queryInsurInfo(jsb);
//            } else if (CUSTVIEW_LOAN_QUERY.equals(SERVICE_CODE)) {
//                //add by guorongchun 20150611
//                resp = new CustLoanAcctQuery().queryLoanInfo(jsb);
//            } else if (CUSTVIEW_CREDIT_QUERY.equals(SERVICE_CODE)) {
//                //add by renlian 20150611
//                resp = new CustCreditAcctQuery().queryCreditInfo(jsb);
//            } else if (CUSTVIEW_GOLDLOAN_QUERY.equals(SERVICE_CODE)) {
//                //add by huangyang 20150611
//                resp = new CustGoldLoanAcctQuery().queryGoldLoanInfo(jsb);
//            }
//        }
//
////		}
//        return resp;
//    }
}
