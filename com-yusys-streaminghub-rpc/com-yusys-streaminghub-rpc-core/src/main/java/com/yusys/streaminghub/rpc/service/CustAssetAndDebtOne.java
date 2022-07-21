package com.yusys.streaminghub.rpc.service;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.util.HumpNotationUtil;
import org.jdom.Document;
import org.jdom.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustAssetAndDebtOne {
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

        //由于存在两个循环数据，因此这里不对这些做处理，不送翻页信息
        Element srv_body = new Element("SRV_BODY");
        String cust_d_cr = "CUST_DEPOSIT_CLASS_ARR";
        String cust_t_cr = "CUST_TREASURE_CLASS_ARR";
        crm.addContent(srv_body);

        Map<String, List<HashMap<String,Object>>> bodyData =  response.getBodyMapData();

        List<HashMap<String, Object>> dasList = bodyData.get("CUST_DEPOSIT");
        if(dasList == null || dasList.size() != 1  ){
            //没有信息或者有多条信息  则全部送空
            srv_body.addContent(getElement("TOTAL_ASSETS", ""));
            srv_body.addContent(getElement("TOTAL_INDEBTEDNESS", ""));
            srv_body.addContent(getElement("CUST_DEPOSIT", ""));
            srv_body.addContent(getElement("CUST_TREASURE", ""));
            srv_body.addContent(getElement("CARD_DEBIT_TOTAL_MONEY", ""));
            srv_body.addContent(getElement("LOAN_DEBIT_TOTAL_MONEY", ""));
            //循环体也为空
            srv_body.addContent(getElement(cust_d_cr, ""));
            srv_body.addContent(getElement(cust_t_cr, ""));

        }else {
            for (HashMap<String, Object> vElMap : dasList) {
                for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                    String kEl = enEL.getKey();
                    String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                    String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                    srv_body.addContent(getElement(newKE1,vEl));

                }
            }

            //存款信息
            Element dcrtail = new Element(cust_d_cr);
            List<HashMap<String, Object>> depositList = bodyData.get("CUST_DEPOSIT_CLASS_ARR");
            if(depositList.size() == 0){
                srv_body.addContent(getElement(cust_d_cr, ""));
            }else{
                srv_body.addContent(dcrtail);
            }
            for (HashMap<String, Object> vElMap : depositList) {
                Element detail_element = new Element("CUST_DEPOSIT_CLASS");
                dcrtail.addContent(detail_element);
                for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                    String kEl = enEL.getKey();
                    String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                    String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                    if ("rowId".equals(kEl)){
                        continue;
                    }
                    detail_element.addContent(getElement(newKE1,vEl));

                }
            }

            //财富信息
            Element tcrtail = new Element(cust_t_cr);
            List<HashMap<String, Object>> assetList = bodyData.get("CUST_TREASURE_CLASS_ARR");
            if(assetList.size() == 0){
                srv_body.addContent(getElement(cust_t_cr, ""));
            }else{
                srv_body.addContent(tcrtail);
            }
            for (HashMap<String, Object> vElMap : assetList) {
                Element detail_element = new Element("CUST_TREASURE_CLASS");
                tcrtail.addContent(detail_element);
                for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                    String kEl = enEL.getKey();
                    String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                    String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                    if ("rowId".equals(kEl)){
                        continue;
                    }
                    detail_element.addContent(getElement(newKE1,vEl));

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
