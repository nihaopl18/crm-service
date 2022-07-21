package cn.com.yusys.yscrm.sysview.domain;

import java.util.List;

/**
 * AUM和存款信息
 * @author: sxm
 * @time: 2021/8/12 10:16
 */
public class AumDpsInfo {


    private String userId;

    private List<AumInfo> aumInfos;

    private List<DepositInfo> depositInfos;

    public List<AumInfo> getAumInfos() {
        return aumInfos;
    }

    public void setAumInfos(List<AumInfo> aumInfos) {
        this.aumInfos = aumInfos;
    }

    public List<DepositInfo> getDepositInfos() {
        return depositInfos;
    }

    public void setDepositInfos(List<DepositInfo> depositInfos) {
        this.depositInfos = depositInfos;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
