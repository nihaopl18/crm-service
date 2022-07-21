package com.yusys.streaminghub.rpc.service;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.util.HumpNotationUtil;
import org.jdom.Document;
import org.jdom.Element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustViewQuerySix {
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
        Map<String, List<ConcurrentHashMap<String,Object>>> bodyData =  response.getBodyData();

        // 添加汇总信息
        Element cust_credit_class_arr = new Element(
                "CUST_CREDIT_CLASS_ARR");

        List<ConcurrentHashMap<String, Object>> custCreditClassArr = bodyData.get("CUST_CREDIT_CLASS_ARR");

        if (custCreditClassArr.size() == 0) {
            srv_body.addContent(getElement("CUST_CREDIT_CLASS_ARR",""));
        }else{
            srv_body.addContent(cust_credit_class_arr);
        }

        for (ConcurrentHashMap<String, Object> vElMap : custCreditClassArr) {
            Element cust_credit_class = new Element("CUST_CREDIT_CLASS");
            cust_credit_class_arr.addContent(cust_credit_class);
            for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                String kEl = enEL.getKey();
                String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                cust_credit_class.addContent(getElement(newKE1,vEl));

            }
        }


        Element credit_acct_dtl_arr = new Element("CREDIT_ACCT_DTL_ARR");
        List<ConcurrentHashMap<String, Object>> creditAcctDtlArr = bodyData.get("CREDIT_ACCT_DTL_ARR");
        // 添加list信息
        if(creditAcctDtlArr.size() == 0){
            srv_body.addContent(getElement("CREDIT_ACCT_DTL_ARR", ""));
        }else{
            srv_body.addContent(credit_acct_dtl_arr);
        }
        for (ConcurrentHashMap<String, Object> vElMap : creditAcctDtlArr) {
            Element credit_acct_dtl = new Element("CREDIT_ACCT_DTL");
            credit_acct_dtl_arr.addContent(credit_acct_dtl);
            for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                String kEl = enEL.getKey();
                String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                credit_acct_dtl.addContent(getElement(newKE1,vEl));

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

}
