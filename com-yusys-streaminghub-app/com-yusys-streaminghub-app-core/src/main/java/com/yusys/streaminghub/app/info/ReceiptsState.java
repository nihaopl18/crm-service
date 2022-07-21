package com.yusys.streaminghub.app.info;

public class ReceiptsState {
    String state;
    String message;
    String  receiptsNo;
    String data;
    long ctime;
    public ReceiptsState() {
    }

    public ReceiptsState(String state, String message, String receiptsNo) {
        this.state = state;
        this.message = message;
        this.receiptsNo = receiptsNo;
        this.ctime=System.currentTimeMillis();
    }
    public ReceiptsState(String state, String message, String receiptsNo, String data) {
        this.state = state;
        this.message = message;
        this.receiptsNo = receiptsNo;
        this.data=data;
        this.ctime=System.currentTimeMillis();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceiptsNo() {
        return receiptsNo;
    }

    public void setReceiptsNo(String receiptsNo) {
        this.receiptsNo = receiptsNo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }
}
