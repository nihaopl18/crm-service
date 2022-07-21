package com.yusys.streaminghub.rpc.service;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.util.HumpNotationUtil;
import org.jdom.Document;
import org.jdom.Element;

import java.util.*;

public class CustAssetAndDebtTwo {
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

        //报文分页信息
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

        //返回报文体
        Element srv_body = new Element("SRV_BODY");
        String cust_t_cr = "CUST_TREASURE_CLASS_ARR";
        crm.addContent(srv_body);
        Map<String, List<HashMap<String,Object>>> bodyData =  response.getBodyMapData();
        List<HashMap<String, Object>> datilList = bodyData.get("datilList");
        if(datilList == null || datilList.size() <= 0){
            //没有信息或者有多条信息  则全部送空
            srv_body.addContent(getElement("TOTAL_ASSETS", ""));
            srv_body.addContent(getElement("HIS_TOTAL_EARNINGS", ""));
            srv_body.addContent(getElement("CUST_TREASURE_CLASS_ARR", ""));

        }else{
            //加入汇总信息
            for (HashMap<String, Object> vElMap : datilList) {
                for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                    String kEl = enEL.getKey();
                    String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                    if (!"rowId".equals(kEl)){
                        String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                        srv_body.addContent(getElement(newKE1,vEl));
                    }

                }
            }

            //财富信息
            Element tcrtail = new Element(cust_t_cr);
            List<HashMap<String, Object>> assetList = bodyData.get("assetList");
            if(assetList == null || assetList.size() <= 0){
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
                    if (!"rowId".equals(kEl)){
                        String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                        detail_element.addContent(getElement(newKE1,vEl));
                    }

                }
            }
        }

        //加入理财经理信息
        List<HashMap<String, Object>> finMgrList = bodyData.get("finMgrList");
        if(finMgrList == null || finMgrList.size() <= 0 ){
            srv_body.addContent(getElement("CUST_FINANC_MGR_NM", ""));
            srv_body.addContent(getElement("MOBILEPHONE", ""));
            srv_body.addContent(getElement("OFFICETEL", ""));

        }else{
            for (HashMap<String, Object> vElMap : finMgrList) {
                for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                    String kEl = enEL.getKey();
                    String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                    if (!"rowId".equals(kEl)){
                        String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                        srv_body.addContent(getElement(newKE1,vEl));
                    }

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
