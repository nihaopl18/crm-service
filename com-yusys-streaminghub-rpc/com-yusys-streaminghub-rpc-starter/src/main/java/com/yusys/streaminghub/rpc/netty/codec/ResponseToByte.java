package com.yusys.streaminghub.rpc.netty.codec;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.service.*;
import com.yusys.streaminghub.rpc.util.UtilRpc;
import lombok.extern.slf4j.Slf4j;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ResponseToByte {
    public byte[] translateFixedResponse(RpcResponse response) throws UnsupportedEncodingException {
        Map<String, String> header = response.getHeader();
        Map<String, String> body = response.getBody();

        String s = UtilRpc.S_SEPARATION;
        String headMsg;
        String hsb2 = "";

        // 拼装报文头
        String hsb = "";
        hsb = hsb.concat(s).concat("1").concat(s);

        String hsb1 = "";
        for (String k : header.keySet()) {
            hsb1 = hsb1.concat(k).concat(s);
        }
        for (String k : body.keySet()) {
            hsb2 = hsb2.concat(k).concat(s);
        }

        headMsg = hsb1.concat(hsb2);
        int endHasPos = headMsg.lastIndexOf(s);
        if (endHasPos == headMsg.length() - s.length()) {
            headMsg = headMsg.substring(0, endHasPos);
        }

        String[] arryStr = headMsg.split(s);
        int i = arryStr.length;
        String len = extendZero(String.valueOf(i), 2);

        String bsb1 = "";
        for (String v : header.values()) {
            bsb1 = bsb1.concat(v).concat(s);
        }
        String bsb2 = "";
        for (String v : body.values()) {
            bsb2 = bsb2.concat(v).concat(s);
        }
        String bodyMsg = bsb1.concat(bsb2);

        // 长度
        String respMsg = len.concat(hsb).concat(headMsg).concat(s)
                .concat(bodyMsg);
        String msgLength = null;

        msgLength = extendZero(
                String.valueOf(respMsg.getBytes(UtilRpc.ENCODING).length), UtilRpc.HDRDESCLEN);

        String headFlag = "F009";

        respMsg = headFlag.concat(msgLength).concat(respMsg);

        return respMsg.getBytes(UtilRpc.ENCODING);
    }
    public byte[] translateXmlResponse(RpcResponse response, ByteArrayOutputStream os ) throws IOException {
        String respMsg = "";

        Document doc = new Document();

       /* Element crm = new Element("CRM");
        doc.setRootElement(crm);

        Element srv_head = new Element("SRV_HEAD");
        crm.addContent(srv_head);
*/
        Map<String, String> header = response.getHeader();
       /* for (Map.Entry<String, String> en : header.entrySet()) {
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
        crm.addContent(srv_body);*/
        String serviceCode = header.get("SERVICE_CODE");
        switch (serviceCode !=null ? serviceCode : ""){
            case "CUSTVIEW_QUERY_001" :
                doc = new CustViewQueryOne().toDoc(response);
                break;
            case "CUSTVIEW_QUERY_002" :
                doc = new CustViewQueryTwo().toDoc(response);
                break;
            case "CUSTVIEW_QUERY_003" :
                doc = new CustViewQueryThree().toDoc(response);
                break;
            case "CUSTVIEW_QUERY_004" :
                doc = new CustViewQueryFour().toDoc(response);
                break;
            case "CUSTVIEW_QUERY_005" :
                doc = new CustViewQueryFive().toDoc(response);
                break;
            case "CUSTVIEW_QUERY_006" :
                doc = new CustViewQuerySix().toDoc(response);
                break;
            case "MOBLIEBANK_AL_QUERY_001" :
                doc = new CustAssetAndDebtOne().toDoc(response);
                break;
            case "MOBLIEBANK_AL_QUERY_002" :
                doc = new CustAssetAndDebtTwo().toDoc(response);
                break;
            case "MOBLIEBANK_AL_QUERY_003" :
                doc = new CustAssetAndDebtThree().toDoc(response);
                break;
            case "CYBQUERY_0001_000003" :
                doc = new CYBScoreQueryThree().toDoc(response);
                break;
            default:
                doc = new DefaultDoc().toDoc(response);
                break;
        }


       /* Map<String, String> body = response.getBody();
        for (Map.Entry<String, String> en : body.entrySet()) {
            String k = en.getKey();
            String v = en.getValue();
            Element element = new Element(k).setText(v);
            srv_body.addContent(element);
        }*/

        //			Format format = Format.getPrettyFormat();
        Format format = Format.getRawFormat();
        format.setEncoding(UtilRpc.ENCODING);
        format.setLineSeparator("");
        XMLOutputter outputter = new XMLOutputter(format);

        outputter.output(doc, os);
        respMsg = os.toString(UtilRpc.ENCODING);
        respMsg = extendZero(
                String.valueOf(respMsg.getBytes(UtilRpc.ENCODING).length),
                UtilRpc.HDRDESCLEN).concat(respMsg);
//        log.info("返回报文:" + respMsg);
        return respMsg.getBytes(UtilRpc.ENCODING);
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
     * 字符串扩展到指定长度，不够位的前补0
     *
     * @param text
     * @param length
     * @return
     */
    String extendZero(String text, int length) {
        if (text == null || text.length() >= length) return textLimit2NDS(text, length);
        char[] array = new char[length];
        Arrays.fill(array, '0');
        System.arraycopy(text.toCharArray(), 0, array, length - text.length(), text.length());

        return String.valueOf(array);
    }

    /**
     * 限定字段长度 CRM的长度不区分字符集
     *
     * @param text
     * @param maxlen
     * @return
     */
    String textLimit2NDS(String text, int maxlen) {
        if (text == null || "".equals(text)) return "";
        if (maxlen <= 0) return "";

        //替换回车换行
        text = text.replace('\n', ' ');
        text = text.replace('\r', ' ');


        if (text.length() < maxlen) return text;
        return text.substring(0, maxlen);
    }
}
