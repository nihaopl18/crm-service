package cn.com.yusys.yscrm.sysview.domain;

/**
 * 风险信息
 *
 * @author: sxm
 * @time: 2021/8/13 10:50
 */
public class RiskInfo {
    /**
     * 评估时间
     */
    private String evaDate;
    /**
     * 风险等级
     */
    private String riskLev;
    /**
     * 是否有效
     */
    private String riskStatus;
    /**
     * 评估渠道
     */
    private String evaChannel;
    /**
     * 风险类型
     */
    private String riskType;

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getEvaDate() {
        return evaDate;
    }

    public void setEvaDate(String evaDate) {
        this.evaDate = evaDate;
    }

    public String getEvaChannel() {
        return evaChannel;
    }

    public void setEvaChannel(String evaChannel) {
        this.evaChannel = evaChannel;
    }

    public String getRiskLev() {
        return riskLev;
    }

    public void setRiskLev(String riskLev) {
        this.riskLev = riskLev;
    }

    public String getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }

}
