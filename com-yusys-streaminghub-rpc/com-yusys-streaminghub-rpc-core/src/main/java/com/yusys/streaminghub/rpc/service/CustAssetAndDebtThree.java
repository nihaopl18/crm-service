package com.yusys.streaminghub.rpc.service;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.util.HumpNotationUtil;
import org.jdom.Document;
import org.jdom.Element;

import java.util.*;

public class CustAssetAndDebtThree {
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
        crm.addContent(srv_body);

        String detail_arr_arr = "CUST_HIS_EARNINGS_CLASS_ARR";
        Element detail = new Element(detail_arr_arr);
        Map<String, List<HashMap<String,Object>>> bodyData =  response.getBodyMapData();
        List<HashMap<String, Object>> hisELists = bodyData.get("hisELists");
        if(hisELists == null || hisELists.size() <= 0){
            srv_body.addContent(getElement(detail_arr_arr,""));
        }else{
            srv_body.addContent(detail);
        }

        for (HashMap<String, Object> vElMap : hisELists) {
            Element detail_element = new Element("CUST_HIS_EARNINGS_CLASS");
            detail.addContent(detail_element);
            for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                String kEl = enEL.getKey();
                String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                if (!"rowId".equals(kEl)){
                    String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
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
