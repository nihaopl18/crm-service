package cn.com.yusys.yscrm.sysview.domain;

/**
 * @author: sxm
 * @time: 2021/8/14 17:59
 */
public class TouchBaseInfo {
    /**
     * 本月线下拜访总次数
     */
    private Integer contact1 = 0;
    /**
     * 上月线下拜访总次数
     */
    private Integer lastContact1 = 0 ;
    /**
     * 本月线下拜访总次数月同比
     */
    private Integer contact2;
    /**
     * 本月通话次数
     */
    private Integer contact3 = 0;
    /**
     * 上月通话次数
     */
    private Integer lastContact3 = 0;
    /**
     * 本月通话次数月同比
     */
    private Integer contact4;
    /**
     * 本月短信触达次数
     */
    private Integer contact5 = 0;
    /**
     * 上月短信触达次数
     */
    private Integer lastContact5 = 0;
    /**
     * 本月短信触达次数月同比
     */
    private Integer contact6;
    /**
     * 客户反馈
     */
    private Integer contact7 = 0;
    /**
     * 上月客户反馈
     */
    private Integer lastContact7 = 0;
    /**
     * 客户反馈月同比
     */
    private Integer contact8;

    public Integer getContact1() {
        return contact1;
    }

    public void setContact1(Integer contact1) {
        this.contact1 = contact1;
    }

    public Integer getLastContact1() {
        return lastContact1;
    }

    public void setLastContact1(Integer lastContact1) {
        this.lastContact1 = lastContact1;
    }

    public Integer getContact2() {
        return contact2;
    }

    public void setContact2(Integer contact2) {
        this.contact2 = contact2;
    }

    public Integer getContact3() {
        return contact3;
    }

    public void setContact3(Integer contact3) {
        this.contact3 = contact3;
    }

    public Integer getLastContact3() {
        return lastContact3;
    }

    public void setLastContact3(Integer lastContact3) {
        this.lastContact3 = lastContact3;
    }

    public Integer getContact4() {
        return contact4;
    }

    public void setContact4(Integer contact4) {
        this.contact4 = contact4;
    }

    public Integer getContact5() {
        return contact5;
    }

    public void setContact5(Integer contact5) {
        this.contact5 = contact5;
    }

    public Integer getLastContact5() {
        return lastContact5;
    }

    public void setLastContact5(Integer lastContact5) {
        this.lastContact5 = lastContact5;
    }

    public Integer getContact6() {
        return contact6;
    }

    public void setContact6(Integer contact6) {
        this.contact6 = contact6;
    }

    public Integer getContact7() {
        return contact7;
    }

    public void setContact7(Integer contact7) {
        this.contact7 = contact7;
    }

    public Integer getLastContact7() {
        return lastContact7;
    }

    public void setLastContact7(Integer lastContact7) {
        this.lastContact7 = lastContact7;
    }

    public Integer getContact8() {
        return contact8;
    }

    public void setContact8(Integer contact8) {
        this.contact8 = contact8;
    }
}
