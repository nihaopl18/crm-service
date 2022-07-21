package com.yusys.streaminghub.rpc.service;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.util.HumpNotationUtil;
import org.jdom.Document;
import org.jdom.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CustViewQueryTwo {
    public Document toDoc(RpcResponse response) {
        Document doc = new Document();
        Element crm = new Element("CRM");
        doc.setRootElement(crm);
        Element srv_head = new Element("SRV_HEAD");
        crm.addContent(srv_head);
        Map<String, String> header = response.getHeader();
        for (Map.Entry<String, String> en : header.entrySet()) {
            String k = en.getKey();
            String v = en.getValue();
            Element element = new Element(k).setText(v);
            srv_head.addContent(element);
        }
        if (response.getAppHead()!=null && response.getAppHead().size()>0){
            Element app_head = new Element("app_head");
            crm.addContent(app_head);
            Map<String, String> appHead = response.getAppHead();
            for (Map.Entry<String, String> en : appHead.entrySet()) {
                String k = en.getKey();
                String v = en.getValue();
                Element element = new Element(k).setText(v);
                app_head.addContent(element);
            }

        }
        Element srv_body = new Element("SRV_BODY");
        crm.addContent(srv_body);
        Map<String, List<HashMap<String,Object>>> bodyData =  response.getBodyMapData();
        // 存款信息汇总节点 start
        Element cust_dep_class_arr = new Element("CUST_DEP_CLASS_ARR");
        srv_body.addContent(cust_dep_class_arr);
        List<HashMap<String, Object>> custDepClass = bodyData.get("CUST_DEP_CLASS_ARR");
        if (custDepClass.size() == 0){
            Element cust_dep_class = new Element("CUST_DEP_CLASS");
            cust_dep_class_arr.addContent(cust_dep_class);
            cust_dep_class.addContent(getElement("CTLA_CODE", ""));
            cust_dep_class.addContent(getElement("CTAL_NAME", ""));
            cust_dep_class.addContent(getElement("TERM_BALANCE", ""));
        }
        /*for (int i = 0; i < custDepClass.size(); i++) {
            Element cust_dep_class = new Element("CUST_DEP_CLASS");
            cust_dep_class_arr.addContent(cust_dep_class);
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1 = (Map<String, Object>) custDepClass.get(i);
            Set<String> keySet = map1.keySet();
            for (String obj : keySet) {
                cust_dep_class.addContent(getElement(obj.toString(),
                        notNull(map1.get(obj)).toString()));
            }
        }*/
        //存款信息汇总节点
        for (HashMap<String, Object> vElMap : custDepClass) {
            Element cust_dep_class = new Element("CUST_DEP_CLASS");
            cust_dep_class_arr.addContent(cust_dep_class);
            for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                String kEl = enEL.getKey();
                String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                cust_dep_class_arr.addContent(getElement(newKE1,vEl));

            }
        }
        //存款信息明细节点
        Element dep_acct_dtl_arr = new Element("DEP_ACCT_DTL_ARR");
        srv_body.addContent(dep_acct_dtl_arr);
        List<HashMap<String, Object>> acctDtlArrs = bodyData.get("DEP_ACCT_DTL_ARR");
        for (HashMap<String, Object> vElMap : acctDtlArrs) {
            Element dep_acct_dtl = new Element("DEP_ACCT_DTL");
            dep_acct_dtl_arr.addContent(dep_acct_dtl);
            for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                String kEl = enEL.getKey();
                String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                dep_acct_dtl.addContent(getElement(newKE1,vEl));

            }
        }
        // 電子信息明细节点 start
        Element ele_dep_acct_arr = new Element("ELE_DEP_ACCT_ARR");
        srv_body.addContent(ele_dep_acct_arr);
        List<HashMap<String, Object>> eleDepAcctArrs = bodyData.get("ELE_DEP_ACCT_ARR");
        for (HashMap<String, Object> vElMap : eleDepAcctArrs) {
            Element ele_cash_actt = new Element("ELE_CASH_ACTT");
            ele_dep_acct_arr.addContent(ele_cash_actt);
            for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                String kEl = enEL.getKey();
                String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                ele_cash_actt.addContent(getElement(newKE1,vEl));

            }
        }
        //信用卡溢缴款明细节点
        Element cre_card_execss_arr = new Element("CRE_CARD_EXECSS_ARR");
        srv_body.addContent(cre_card_execss_arr);
        List<HashMap<String, Object>> creCardExecssArr = bodyData.get("CRE_CARD_EXECSS_ARR");
        for (HashMap<String, Object> vElMap : creCardExecssArr) {
            Element cre_card_execss = new Element("CRE_CARD_EXECSS");
            cre_card_execss_arr.addContent(cre_card_execss);
            for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                String kEl = enEL.getKey();
                String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                cre_card_execss.addContent(getElement(newKE1,vEl));

            }
        }

        return doc;
    }

    /**
     * 创建节点
     * @param name
     * @param text
     * @return
     */
    private Element getElement(String name, String text) {
        if ("".equals(text) || text == null){
            return new Element(name).setText("");
        }else {
            return new Element(name).setText(text);
        }
    }

    /**
     * 避免出现null
     */
    public static String notNull(Object obj){
        if (obj == null){
            return "";
        }
        return obj.toString();
    }
}
