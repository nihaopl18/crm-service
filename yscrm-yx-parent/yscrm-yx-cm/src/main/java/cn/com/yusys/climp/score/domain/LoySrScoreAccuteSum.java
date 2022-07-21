package cn.com.yusys.climp.score.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


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
@Table(name = "LOY_SR_SCORE_ACCUTE_SUM")
public class LoySrScoreAccuteSum extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;

	/** 积分明细Id **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "SCD_ID", unique = true, nullable = false, length = 50)
	private String scdId;

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
	
	/** 本次累积积分占比 **/
	@Column(name = "THIS_SUM_RATIO", unique = false, nullable = true, length = 26)
	private java.math.BigDecimal thisSumRatio;
	
	/** 被冲正明细id **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 50)
	private String remark;

	/** 积分操作类型 **/
	@Column(name = "SCORE_DEAL_TYPE", unique = false, nullable = true, length = 4)
	private String scoreDealType;

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	/**
	 * @param busnDate
	 */
	public void setBusnDate(Date busnDate) {
		this.busnDate = busnDate;
	}
	
    /**
     * @return BusnDate
     */	
	public Date getBusnDate() {
		return this.busnDate;
	}
	
	/**
	 * @param lastSrAccute
	 */
	public void setLastSrAccute(java.math.BigDecimal lastSrAccute) {
		this.lastSrAccute = lastSrAccute;
	}
	
    /**
     * @return LastSrAccute
     */	
	public java.math.BigDecimal getLastSrAccute() {
		return this.lastSrAccute;
	}
	
	/**
	 * @param thisSumScore
	 */
	public void setThisSumScore(java.math.BigDecimal thisSumScore) {
		this.thisSumScore = thisSumScore;
	}
	
    /**
     * @return ThisSumScore
     */	
	public java.math.BigDecimal getThisSumScore() {
		return this.thisSumScore;
	}
	
	/**
	 * @param currSrAccute
	 */
	public void setCurrSrAccute(java.math.BigDecimal currSrAccute) {
		this.currSrAccute = currSrAccute;
	}
	
    /**
     * @return CurrSrAccute
     */	
	public java.math.BigDecimal getCurrSrAccute() {
		return this.currSrAccute;
	}
	
	/**
	 * @param thisSumRatio
	 */
	public void setThisSumRatio(java.math.BigDecimal thisSumRatio) {
		this.thisSumRatio = thisSumRatio;
	}
	
    /**
     * @return ThisSumRatio
     */	
	public java.math.BigDecimal getThisSumRatio() {
		return this.thisSumRatio;
	}

	public String getScdId() {
		return scdId;
	}

	public void setScdId(String scdId) {
		this.scdId = scdId == null ? "" : scdId;
	}

	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
	}

	public String getScoreDealType() {
		return scoreDealType;
	}

	public void setScoreDealType(String scoreDealType) {
		this.scoreDealType = scoreDealType == null ? "" : scoreDealType.trim();
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
        LoySrScoreAccuteSum other = (LoySrScoreAccuteSum) that;
		return (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", busnDate=").append(busnDate);
		sb.append(", lastSrAccute=").append(lastSrAccute);
		sb.append(", thisSumScore=").append(thisSumScore);
		sb.append(", currSrAccute=").append(currSrAccute);
		sb.append(", thisSumRatio=").append(thisSumRatio);
		sb.append(", scdId=").append(scdId);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}