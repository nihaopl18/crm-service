package cn.com.yusys.yscrm.info.remind.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: OcrmFwpRemindChlNex
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-19 09:01:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_REMIND_CHL_NEX")
public class OcrmFwpRemindChlNex extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 规则编号 **/
	@Column(name = "RULE_ID", unique = false, nullable = true, length = 32)
	private String ruleId;
	
	/** 渠道编号 **/
	@Column(name = "CHL_ID", unique = false, nullable = true, length = 32)
	private String chlId;
	
	/** 发送渠道模板 **/
	@Column(name = "MESSAGE_MODEL", unique = false, nullable = true, length = 800)
	private String messageModel;
	
	
	/**
	 * @param ruleId
	 */
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId == null ? null : ruleId.trim();
	}
	
    /**
     * @return RuleId
     */	
	public String getRuleId() {
		return this.ruleId;
	}
	
	/**
	 * @param chlId
	 */
	public void setChlId(String chlId) {
		this.chlId = chlId == null ? null : chlId.trim();
	}
	
    /**
     * @return ChlId
     */	
	public String getChlId() {
		return this.chlId;
	}
	
	/**
	 * @param messageModel
	 */
	public void setMessageModel(String messageModel) {
		this.messageModel = messageModel == null ? null : messageModel.trim();
	}
	
    /**
     * @return MessageModel
     */	
	public String getMessageModel() {
		return this.messageModel;
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
        OcrmFwpRemindChlNex other = (OcrmFwpRemindChlNex) that;
		return (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
        	&& (this.getChlId() == null ? other.getChlId() == null : this.getChlId().equals(other.getChlId()))
        	&& (this.getMessageModel() == null ? other.getMessageModel() == null : this.getMessageModel().equals(other.getMessageModel()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getChlId() == null) ? 0 : getChlId().hashCode());
        result = prime * result + ((getMessageModel() == null) ? 0 : getMessageModel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", ruleId=").append(ruleId);
		sb.append(", chlId=").append(chlId);
		sb.append(", messageModel=").append(messageModel);
        sb.append("]");
        return sb.toString();
    }
}