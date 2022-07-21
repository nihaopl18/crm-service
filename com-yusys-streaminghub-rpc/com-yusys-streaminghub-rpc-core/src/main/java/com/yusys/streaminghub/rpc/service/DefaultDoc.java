package com.yusys.streaminghub.rpc.service;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.util.HumpNotationUtil;
import org.jdom.Document;
import org.jdom.Element;

import java.util.List;
import java.util.Map;

public class DefaultDoc {
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
        Map<String, Object> body = response.getBody();
        getBody(body,srv_body);
//        for (Map.Entry<String, String> en : body.entrySet()) {
//            String k = en.getKey();
//            String v = en.getValue();
//            Element element = new Element(k).setText(v);
//            srv_body.addContent(element);
//        }
        return doc;
    }

    private void getBody(Map<String, Object> body, Element srv_body) {
        for (Map.Entry<String, Object> en : body.entrySet()) {
            String k = HumpNotationUtil.humpToUnderline(en.getKey());
            Object v = en.getValue();
            if (v instanceof List){
                Element root = new Element(k+"_ARR");
                List<Map<String,Object>> list = (List<Map<String, Object>>) v;
                srv_body.addContent(root);
                for (Map<String, Object> map : list) {
                    Element e = new Element(k);
                    root.addContent(e);
                    getBody(map,e);
                }
            }else if (v instanceof Map){
                Map<String, Object> map = (Map<String, Object>) v;
                Element e = new Element(k);
                srv_body.addContent(e);
                for (Map.Entry<String, Object> enEL : map.entrySet()) {
                    String kEl = enEL.getKey();
                    String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                    String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                    e.addContent(new Element(newKE1).setText(vEl));

                }
            }
            else {
                if (!"rowId".equals(k) && !"ROW_ID".equals(k)){
                    Element element = new Element(k).setText(v ==null ? "" : v.toString());
                    srv_body.addContent(element);
                }
            }
        }
    }
}
