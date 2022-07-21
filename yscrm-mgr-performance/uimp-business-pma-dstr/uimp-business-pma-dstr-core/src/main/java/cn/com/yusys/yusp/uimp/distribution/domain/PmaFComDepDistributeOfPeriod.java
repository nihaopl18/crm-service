package cn.com.yusys.yusp.uimp.distribution.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author:Mr.raop
 * @create:2022-05-13
 */
public class PmaFComDepDistributeOfPeriod  {

    @NotBlank
    private String acctInfoId;

    @NotNull
    private List<PmaFComDepPeriod>  periodList;

    public String getAcctInfoId() {
        return acctInfoId;
    }

    public void setAcctInfoId(String acctInfoId) {
        this.acctInfoId = acctInfoId;
    }

    public List<PmaFComDepPeriod> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(List<PmaFComDepPeriod> periodList) {
        this.periodList = periodList;
    }

}
