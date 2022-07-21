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

import static com.yusys.streaminghub.rpc.service.CustViewQueryTwo.notNull;

public class CustViewQueryThree {
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
// 理財帳戶信息汇总节点 start
        Element cust_fina_class_arr = new Element("CUST_FINA_CLASS_ARR");
        srv_body.addContent(cust_fina_class_arr);
        List<HashMap<String, Object>> custFinaClassArr = bodyData.get("CUST_FINA_CLASS_ARR");
        if (custFinaClassArr == null || custFinaClassArr.size() == 0) {
            Element cust_fina_class = new Element("CUST_FINA_CLASS");
            cust_fina_class_arr.addContent(cust_fina_class);
            cust_fina_class.addContent(getElement("CTLA_CODE", ""));
            cust_fina_class.addContent(getElement("CTAL_NAME", ""));
            cust_fina_class.addContent(getElement("TOTAL_VOL", ""));
        }else {

            for (HashMap<String, Object> vElMap : custFinaClassArr) {
                Element cust_dep_class = new Element("CUST_DEP_CLASS");
                cust_fina_class_arr.addContent(cust_dep_class);
                for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                    String kEl = enEL.getKey();
                    String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                    String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                    cust_fina_class_arr.addContent(getElement(newKE1,vEl));

                }
            }
        }
        // 理財帳戶信息汇总节点 end

        // 理財帳戶明细节点 start
        Element fina_acct_dtl_arr = new Element("FINA_ACCT_DTL_ARR");
        srv_body.addContent(fina_acct_dtl_arr);
        List<HashMap<String, Object>> finaAcctDtlArr = bodyData.get("FINA_ACCT_DTL_ARR");
        if (custFinaClassArr != null && custFinaClassArr.size() > 0) {

            for (HashMap<String, Object> vElMap : finaAcctDtlArr) {
                Element fina_acct_dtl = new Element("FINA_ACCT_DTL");
                fina_acct_dtl_arr.addContent(fina_acct_dtl);
                for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                    String kEl = enEL.getKey();
                    String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                    String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                    fina_acct_dtl.addContent(getElement(newKE1,vEl));

                }
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
