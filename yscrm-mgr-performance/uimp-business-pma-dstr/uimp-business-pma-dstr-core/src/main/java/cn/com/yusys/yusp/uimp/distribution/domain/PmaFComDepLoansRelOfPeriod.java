package cn.com.yusys.yusp.uimp.distribution.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author:Mr.raop
 * @create:2022-05-16
 */
public class PmaFComDepLoansRelOfPeriod {

    @NotBlank
    private String loansInfoId;

    @NotNull
    private List<PmaFComDepLoansPeriod> periodList;

    public String getLoansInfoId() {
        return loansInfoId;
    }

    public void setLoansInfoId(String loansInfoId) {
        this.loansInfoId = loansInfoId;
    }

    public List<PmaFComDepLoansPeriod> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(List<PmaFComDepLoansPeriod> periodList) {
        this.periodList = periodList;
    }
}
