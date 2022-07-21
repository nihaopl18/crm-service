package com.yusys.streaminghub.rpc.service;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.util.HumpNotationUtil;
import org.jdom.Document;
import org.jdom.Element;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustViewQueryOne {
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
        for (Map.Entry<String,List<ConcurrentHashMap<String,Object>>> en : bodyData.entrySet()){
            String k = en.getKey();
            List<ConcurrentHashMap<String,Object>> vListMap = en.getValue();
            Element interiorLabel = new Element(k);
            if (vListMap.size()==0){
                srv_body.addContent(getElement(k,""));
            }else {
                srv_body.addContent(interiorLabel);
            }
            if (vListMap.size() > 0){
                for (ConcurrentHashMap<String, Object> vElMap : vListMap) {
                    for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                        String kEl = enEL.getKey();
                        String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                        String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                        interiorLabel.addContent(getElement(newKE1,vEl));

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
