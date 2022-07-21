package cn.com.yusys.yscrm.sysview.domain;

/**
 * 家庭信息
 * @author: sxm
 * @time: 2021/8/12 15:12
 */
public class FamInfo {
    /**
     * 婚姻状况
     */
    private String marriStat;
    /**
     * 家庭人口数
     */
    private String familyMember;

    public String getMarriStat() {
        return marriStat;
    }

    public void setMarriStat(String marriStat) {
        this.marriStat = marriStat;
    }

    public String getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(String familyMember) {
        this.familyMember = familyMember;
    }
}
