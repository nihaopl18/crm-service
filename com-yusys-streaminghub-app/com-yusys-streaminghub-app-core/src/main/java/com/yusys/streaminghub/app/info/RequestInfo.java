package com.yusys.streaminghub.app.info;

public class RequestInfo {

    String url;
    String method;
    String appId;
    String module;
    String user;
    String password;
    String nonce;
    String sign;
    String[] argNames;
    String[] argTypes;
    Object[] argValues;
    Object extra;//预留向后台app传附加数据使用
    boolean cached;//是否使用缓冲取数
    public RequestInfo() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String[] getArgNames() {
        return argNames;
    }

    public void setArgNames(String[] argNames) {
        this.argNames = argNames;
    }

    public String[] getArgTypes() {
        return argTypes;
    }

    public void setArgTypes(String[] argTypes) {
        this.argTypes = argTypes;
    }

    public Object[] getArgValues() {
        return argValues;
    }

    public void setArgValues(Object[] argValues) {
        this.argValues = argValues;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public boolean isCached() {
        return cached;
    }

    public void setCached(boolean cached) {
        this.cached = cached;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(method);
        sb.append(" ");
        sb.append(url);
        sb.append(" (");
        for (String name : argNames) {
            sb.append(String.format("%s,", name));
        }
        if (sb.lastIndexOf(",") > -1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(")");
        return sb.toString();
    }
}
