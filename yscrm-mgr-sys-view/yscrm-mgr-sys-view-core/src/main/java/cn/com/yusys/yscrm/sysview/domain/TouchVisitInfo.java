package cn.com.yusys.yscrm.sysview.domain;

import java.util.List;

/**
 * @author: sxm
 * @time: 2021/8/14 18:02
 */
public class TouchVisitInfo {
    /**
     * 线下拜访
     */
    private List<String> contactDate1;
    /**
     * 营销通话
     */
    private List<String> contactDate2;
    /**
     * 短信触达
     */
    private List<String> contactDate3;
    /**
     * 客户反馈
     */
    private List<String> contactDate4;

    public List<String> getContactDate1() {
        return contactDate1;
    }

    public void setContactDate1(List<String> contactDate1) {
        this.contactDate1 = contactDate1;
    }

    public List<String> getContactDate2() {
        return contactDate2;
    }

    public void setContactDate2(List<String> contactDate2) {
        this.contactDate2 = contactDate2;
    }

    public List<String> getContactDate3() {
        return contactDate3;
    }

    public void setContactDate3(List<String> contactDate3) {
        this.contactDate3 = contactDate3;
    }

    public List<String> getContactDate4() {
        return contactDate4;
    }

    public void setContactDate4(List<String> contactDate4) {
        this.contactDate4 = contactDate4;
    }
}
