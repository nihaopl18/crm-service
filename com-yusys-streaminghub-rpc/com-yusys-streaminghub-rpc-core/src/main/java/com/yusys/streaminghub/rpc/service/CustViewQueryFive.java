package com.yusys.streaminghub.rpc.service;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.util.HumpNotationUtil;
import org.jdom.Document;
import org.jdom.Element;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CustViewQueryFive {
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

        //贷款信息汇总节点
        Element total = new Element("CUST_LOAD_CLASS_ARR");//客户贷款分类信息根节点
        srv_body.addContent(total);
        List<HashMap<String, Object>> custLoadClassArr = bodyData.get("CUST_LOAD_CLASS_ARR");

        for (HashMap<String, Object> vElMap : custLoadClassArr) {
            Element total_element = new Element("CUST_LOAD_CLASS");//客户贷款分类信息子节点
            total.addContent(total_element);
            for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                String kEl = enEL.getKey();
                String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                total_element.addContent(getElement(newKE1,vEl));

            }
        }

        //贷款信息明细节点
        Element detail = new Element("LOAD_BILL_DTL_ARR");//贷款借据明细根节点
        srv_body.addContent(detail);
        List<HashMap<String, Object>> loadBillDtlArr = bodyData.get("LOAD_BILL_DTL_ARR");
        for (HashMap<String, Object> vElMap : loadBillDtlArr) {
            Element detail_element = new Element("INSURE_ACCT_DTL");
            detail.addContent(detail_element);
            for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                String kEl = enEL.getKey();
                String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                detail_element.addContent(getElement(newKE1,vEl));

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
