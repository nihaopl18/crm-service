package cn.com.yusys.yscrm.sysview.domain;

/**
 * 职业信息
 *
 * @author: sxm
 * @time: 2021/8/12 15:06
 */
public class OccInfo {
    /**
     * 职业
     */
    private String engInPro;
    /**
     * 工作单位名称
     */
    private String curWorkUnit;
    /**
     * 单位性质
     */
    private String unitNat;
    /**
     * 行业
     */
    private String indOwnUnit;

    public String getEngInPro() {
        return engInPro;
    }

    public void setEngInPro(String engInPro) {
        this.engInPro = engInPro;
    }

    public String getCurWorkUnit() {
        return curWorkUnit;
    }

    public void setCurWorkUnit(String curWorkUnit) {
        this.curWorkUnit = curWorkUnit;
    }

    public String getUnitNat() {
        return unitNat;
    }

    public void setUnitNat(String unitNat) {
        this.unitNat = unitNat;
    }

    public String getIndOwnUnit() {
        return indOwnUnit;
    }

    public void setIndOwnUnit(String indOwnUnit) {
        this.indOwnUnit = indOwnUnit;
    }
}
