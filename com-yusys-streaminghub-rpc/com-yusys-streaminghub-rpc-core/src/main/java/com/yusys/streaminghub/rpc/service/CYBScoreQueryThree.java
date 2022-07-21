package com.yusys.streaminghub.rpc.service;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.util.HumpNotationUtil;
import org.jdom.Document;
import org.jdom.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CYBScoreQueryThree {
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


        Map body = response.getBody();
        HashMap<String, Object> systemtotal = (HashMap<String, Object>)body.get("SYSTEMTOTAL");

        for (Map.Entry<String, Object> en : systemtotal.entrySet()) {
            String k = en.getKey();
            String v = en.getValue() == null ? "" : en.getValue().toString();
            Element element = new Element(k).setText(v);
            srv_body.addContent(element);
        }

        Element score_det_arr_arr = new Element("SCORE_DET_ARR_ARR");
        srv_body.addContent(score_det_arr_arr);

        List<HashMap<String, Object>> scoreDetArrArr = (List<HashMap<String, Object>>)body.get("SCORE_DET_ARR_ARR");
        if (scoreDetArrArr.size() == 0 ){
            Element score_det_arr = new Element("SCORE_DET_ARR");
            score_det_arr_arr.addContent(score_det_arr);
            score_det_arr.addContent(getElement("SCORE_DEAL_TYPE", ""));
            score_det_arr.addContent(getElement("SCORE", ""));
            score_det_arr.addContent(getElement("DEAL_DT", ""));
            score_det_arr.addContent(getElement("LAST_SCORE", ""));
            score_det_arr.addContent(getElement("NEXT_SCORE", ""));
            score_det_arr.addContent(getElement("SCD_FK_ID", ""));
        }
        for (HashMap<String, Object> vElMap : scoreDetArrArr) {
            Element score_det_arr = new Element("SCORE_DET_ARR");
            score_det_arr_arr.addContent(score_det_arr);
            for (Map.Entry<String, Object> enEL : vElMap.entrySet()) {
                String kEl = enEL.getKey();
                String newKE1 = HumpNotationUtil.humpToUnderline(kEl);
                if (!"rowId".equals(kEl)){
                    String vEl = enEL.getValue() == null ? "":enEL.getValue().toString();
                    score_det_arr.addContent(getElement(newKE1,vEl));
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
