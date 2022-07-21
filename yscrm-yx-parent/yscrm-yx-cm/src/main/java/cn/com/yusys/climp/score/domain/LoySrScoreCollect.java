package cn.com.yusys.climp.score.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoySrScoreAccuteSum
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-01-22 15:04:27
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_SR_SCORE_COLLECT")
public class LoySrScoreCollect  extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 主键id **/
    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID", unique = true, nullable = false, length = 50)
    private String id;

    /** 客户号 **/
    @Column(name = "CUST_NO", unique = false, nullable = false, length = 50)
    private String custNo;

    /** 积分时间 **/
    @Column(name = "BUSN_DATE", unique = false, nullable = true, length = 20)
    private Date busnDate;

    /** 积分变更前客户可用积分 **/
    @Column(name = "LAST_SR_ACCUTE", unique = false, nullable = true, length = 20)
    private java.math.BigDecimal lastSrAccute;

    /** 积分值 **/
    @Column(name = "THIS_SUM_SCORE", unique = false, nullable = true, length = 20)
    private java.math.BigDecimal thisSumScore;

    /** 积分变更后客户可用积分 **/
    @Column(name = "CURR_SR_ACCUTE", unique = false, nullable = true, length = 20)
    private java.math.BigDecimal currSrAccute;

    /** 积分明细Id **/
    @Column(name = "SCD_ID", unique = false, nullable = false, length = 50)
    private String scdId;

    /** 积分账户明细Id **/
    @Column(name = "ACCOUNT_CODE", unique = false, nullable = false, length = 50)
    private String accountCode;

    /** 积分操作类型 **/
    @Column(name = "SCORE_DEAL_TYPE", unique = false, nullable = true, length = 4)
    private String scoreDealType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null :custNo.trim();
    }

    public String getScdId() {
        return scdId;
    }

    public void setScdId(String scdId) {
        this.scdId = scdId == null ? null :scdId.trim();
    }

    public Date getBusnDate() {
        return busnDate;
    }

    public void setBusnDate(Date busnDate) {
        this.busnDate = busnDate;
    }

    public BigDecimal getLastSrAccute() {
        return lastSrAccute;
    }

    public void setLastSrAccute(BigDecimal lastSrAccute) {
        this.lastSrAccute = lastSrAccute;
    }

    public BigDecimal getThisSumScore() {
        return thisSumScore;
    }

    public void setThisSumScore(BigDecimal thisSumScore) {
        this.thisSumScore = thisSumScore;
    }

    public BigDecimal getCurrSrAccute() {
        return currSrAccute;
    }

    public void setCurrSrAccute(BigDecimal currSrAccute) {
        this.currSrAccute = currSrAccute;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode == null ? "" : accountCode.trim();
    }

    public String getScoreDealType() {
        return scoreDealType;
    }

    public void setScoreDealType(String scoreDealType) {
        this.scoreDealType = scoreDealType == null ? "" : scoreDealType.trim();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustNo() == null) ? 0 : getCustNo().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LoySrScoreCollect other = (LoySrScoreCollect) that;
        return (this.getCustNo() == null ? other.getCustNo() == null : this.getCustNo().equals(other.getCustNo()))
                && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                ;
    }

    @Override
    public String toString() {StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", custNo=").append(custNo);
        sb.append(", custId=").append(accountCode);
        sb.append(", busnDate=").append(busnDate);
        sb.append(", lastSrAccute=").append(lastSrAccute);
        sb.append(", thisSumScore=").append(thisSumScore);
        sb.append(", currSrAccute=").append(currSrAccute);
        sb.append(", scdId=").append(scdId);
        sb.append("]");
        return sb.toString();
    }
}
