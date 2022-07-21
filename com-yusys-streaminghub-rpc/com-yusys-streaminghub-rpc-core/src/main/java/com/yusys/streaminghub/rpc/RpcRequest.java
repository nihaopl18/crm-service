package com.yusys.streaminghub.rpc;

import java.util.LinkedHashMap;
import java.util.Map;

public class RpcRequest {
    String contentType;//响应格式：fixed|xml
    Map<String, String> header;
    Map<String, Object> body;
    boolean appHead = false;
    Integer pgupPgdn;
    int totalNum;
    int currentNum;
    int pageStart;
    int pageEnd;
    private int queryNum = 10;
    private int pageNum ;


    public RpcRequest() {
        this("fixed");
    }

    public RpcRequest(String contentType) {
        this.contentType = contentType;
        this.header = new LinkedHashMap<>();
        this.body = new LinkedHashMap<>();
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
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

    public Integer getPgupPgdn() {
        return pgupPgdn;
    }

    public void setPgupPgdn(Integer pgupPgdn) {
        this.pgupPgdn = pgupPgdn;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }

    public int getQueryNum() {
        return queryNum;
    }

    public void setQueryNum(int queryNum) {
        this.queryNum = queryNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public boolean isAppHead() {
        return appHead;
    }

    public void setAppHead(boolean appHead) {
        this.appHead = appHead;
    }
}
