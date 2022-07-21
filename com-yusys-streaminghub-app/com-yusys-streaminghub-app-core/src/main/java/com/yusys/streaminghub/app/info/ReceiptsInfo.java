package com.yusys.streaminghub.app.info;
/*
收单信息
 */

public class ReceiptsInfo {
    String id;
    RequestInfo request;
    long ctime;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public RequestInfo getRequest() {
        return request;
    }

    public void setRequest(RequestInfo request) {
        this.request = request;
    }
}
