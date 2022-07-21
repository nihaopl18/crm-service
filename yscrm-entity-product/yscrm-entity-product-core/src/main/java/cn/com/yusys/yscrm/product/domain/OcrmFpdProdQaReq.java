package cn.com.yusys.yscrm.product.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdProdQaReq
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-11 17:12:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_PD_PROD_QA_REQ")
public class OcrmFpdProdQaReq extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Column(name = "QUESTION_ID")
	@Generated(GenerationType.UUID)
	private String questionId;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 产品编号 **/
	@Column(name = "PROD_ID", unique = false, nullable = true, length = 30)
	private String prodId;
	
	/** 问题内容 **/
	@Column(name = "QUESTION_CONTENT", unique = false, nullable = true, length = 2000)
	private String questionContent;
	
	/** 提出人 **/
	@Column(name = "QUESTION_MAN", unique = false, nullable = true, length = 30)
	private String questionMan;
	
	/** 提出日期 **/
	@Column(name = "QUESTION_DATE", unique = false, nullable = true, length = 7)
	private Date questionDate;
	
	/** 是否提醒 **/
	@Column(name = "IS_REMIND", unique = false, nullable = true, length = 20)
	private String isRemind;
	
	
	/**
	 * @param lastChgUsr
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
	}
	
    /**
     * @return LastChgUsr
     */	
	public String getLastChgUsr() {
		return this.lastChgUsr;
	}
	
	/**
	 * @param lastChgDt
	 */
	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	
    /**
     * @return LastChgDt
     */	
	public Date getLastChgDt() {
		return this.lastChgDt;
	}
	
	/**
	 * @param questionId
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId == null ? null : questionId.trim();
	}
	
    /**
     * @return QuestionId
     */	
	public String getQuestionId() {
		return this.questionId;
	}
	
	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
	}
	
	/**
	 * @param prodId
	 */
	public void setProdId(String prodId) {
		this.prodId = prodId == null ? null : prodId.trim();
	}
	
    /**
     * @return ProdId
     */	
	public String getProdId() {
		return this.prodId;
	}
	
	/**
	 * @param questionContent
	 */
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent == null ? null : questionContent.trim();
	}
	
    /**
     * @return QuestionContent
     */	
	public String getQuestionContent() {
		return this.questionContent;
	}
	
	/**
	 * @param questionMan
	 */
	public void setQuestionMan(String questionMan) {
		this.questionMan = questionMan == null ? null : questionMan.trim();
	}
	
    /**
     * @return QuestionMan
     */	
	public String getQuestionMan() {
		return this.questionMan;
	}
	
	/**
	 * @param questionDate
	 */
	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}
	
    /**
     * @return QuestionDate
     */	
	public Date getQuestionDate() {
		return this.questionDate;
	}
	
	/**
	 * @param isRemind
	 */
	public void setIsRemind(String isRemind) {
		this.isRemind = isRemind == null ? null : isRemind.trim();
	}
	
    /**
     * @return IsRemind
     */	
	public String getIsRemind() {
		return this.isRemind;
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
        OcrmFpdProdQaReq other = (OcrmFpdProdQaReq) that;
		return (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getQuestionId() == null ? other.getQuestionId() == null : this.getQuestionId().equals(other.getQuestionId()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getProdId() == null ? other.getProdId() == null : this.getProdId().equals(other.getProdId()))
        	&& (this.getQuestionContent() == null ? other.getQuestionContent() == null : this.getQuestionContent().equals(other.getQuestionContent()))
        	&& (this.getQuestionMan() == null ? other.getQuestionMan() == null : this.getQuestionMan().equals(other.getQuestionMan()))
                	&& (this.getIsRemind() == null ? other.getIsRemind() == null : this.getIsRemind().equals(other.getIsRemind()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getQuestionId() == null) ? 0 : getQuestionId().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getProdId() == null) ? 0 : getProdId().hashCode());
        result = prime * result + ((getQuestionContent() == null) ? 0 : getQuestionContent().hashCode());
        result = prime * result + ((getQuestionMan() == null) ? 0 : getQuestionMan().hashCode());
        result = prime * result + ((getIsRemind() == null) ? 0 : getIsRemind().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", questionId=").append(questionId);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", prodId=").append(prodId);
		sb.append(", questionContent=").append(questionContent);
		sb.append(", questionMan=").append(questionMan);
		sb.append(", questionDate=").append(questionDate);
		sb.append(", isRemind=").append(isRemind);
        sb.append("]");
        return sb.toString();
    }
}