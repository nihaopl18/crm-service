package com.yusys.streaminghub.rpc;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class RpcResponse<T> {
    String contentType = "fixed";//响应格式：fixed|xml
    Map<String, String> header;
    Map<String, Object> body;
    Map<String, String> appHead;
    Map<String, List<ConcurrentHashMap<String,Object>>> bodyData;
    Map<String, List<Map<String,Object>>> bodyMapData;


    public RpcResponse() {
        this("fixed");
    }

    public RpcResponse(String contentType) {
        this.contentType = contentType;
        this.header = new LinkedHashMap<>();
        this.body = new LinkedHashMap<>();
        this.appHead = new LinkedHashMap<>();
        this.bodyData = new LinkedHashMap<>();
        this.bodyMapData = new LinkedHashMap<>();
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Map<String, List<ConcurrentHashMap<String, Object>>> getBodyData() {
        return bodyData;
    }

    public void setBodyData(Map<String, List<ConcurrentHashMap<String, Object>>> bodyData) {
        this.bodyData = bodyData;
    }

    public Map<String, String> getAppHead() {
        return appHead;
    }

    public void setAppHead(Map<String, String> appHead) {
        this.appHead = appHead;
    }

    public Map<String, List<Map<String, Object>>> getBodyMapData() {
        return bodyMapData;
    }

    public void setBodyMapData(Map<String, List<Map<String, Object>>> bodyMapData) {
        this.bodyMapData = bodyMapData;
    }
}
