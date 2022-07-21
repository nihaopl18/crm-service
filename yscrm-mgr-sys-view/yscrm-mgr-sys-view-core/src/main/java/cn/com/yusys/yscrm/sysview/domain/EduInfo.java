package cn.com.yusys.yscrm.sysview.domain;

/**
 * @author: sxm
 * @time: 2021/8/12 15:05
 */
public class EduInfo {
    /**
     * 最高学位
     */
    private String higEduDgr;
    /**
     * 最后毕业院校
     */
    private String comSch;
    /**
     * 所学专业
     */
    private String schMajor;
    /**
     * 毕业时间
     */
    private String endDate;

    public String getHigEduDgr() {
        return higEduDgr;
    }

    public void setHigEduDgr(String higEduDgr) {
        this.higEduDgr = higEduDgr;
    }

    public String getComSch() {
        return comSch;
    }

    public void setComSch(String comSch) {
        this.comSch = comSch;
    }

    public String getSchMajor() {
        return schMajor;
    }

    public void setSchMajor(String schMajor) {
        this.schMajor = schMajor;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
