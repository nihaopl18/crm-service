package cn.com.yusys.yusp.uimp.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @项目名称: yusp-admin
 * @类名称: AutoSeacher
 * @类描述: 配置url
 * @功能描述:
 * @创建时间: 2018-01-15 13:42
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Component
@ConfigurationProperties(prefix = "auto")
@PropertySource(value = "autoSearch.properties")
public class AutoSearch {

    private String url;
    private String user;
    private String org;
    private String grant;
    private String formatDate;
    private String formatmoney;
    private String formatPercent;

    private String modId;

    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getModId() {
        return modId;
    }

    public void setModId(String modId) {
        this.modId = modId;
    }

    /**
     * 导出相关
     */
    private String expUrl;
    private String expWay;

    public String getExpUrl() {
        return expUrl;
    }

    public void setExpUrl(String expUrl) {
        this.expUrl = expUrl;
    }

    public String getExpWay() {
        return expWay;
    }

    public void setExpWay(String expWay) {
        this.expWay = expWay;
    }

    /**
     * 获取放大镜名称
     * @param param
     * @return
     */
    public String  getBigGlass(String param ){
       if(param!=null){
           if(param.equals("0")){
               return getUser();
           }else if(param.equals("1")){
               return getOrg();
           }
       }
       return  "";
    }

    /**
     * 获取格式化函数
     * @param param
     * @return
     */
     public String getFormat(String param){
         if(param!=null){
             if(param.equals("0")){
                 return getFormatmoney();
             }else if(param.equals("1")){
                 return getFormatDate();
             }else if (param.equals("2")){
                 return  getFormatPercent();
             }
         }
         return  "";
     }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getGrant() {
        return grant;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }

    public String getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }

    public String getFormatmoney() {
        return formatmoney;
    }

    public void setFormatmoney(String formatmoney) {
        this.formatmoney = formatmoney;
    }

    public String getFormatPercent() {
        return formatPercent;
    }

    public void setFormatPercent(String formatPercent) {
        this.formatPercent = formatPercent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
