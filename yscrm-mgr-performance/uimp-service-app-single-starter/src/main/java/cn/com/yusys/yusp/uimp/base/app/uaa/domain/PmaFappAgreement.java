package cn.com.yusys.yusp.uimp.base.app.uaa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-base-core模块
 * @类名称: PmaFappAgreement
 * @类描述: OCRM_F_APP_AGREEMENT数据实体类
 * @功能描述: 
 * @创建人: sawyer
 * @创建时间: 2019-07-17 17:29:20
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_APP_AGREEMENT")
public class PmaFappAgreement extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 用户安全保密协议 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "AGREEMENT_CONTENT")
	private String agreementContent;

	/**
	 * @param agreementContent
	 */
	public void setAgreementContent(String agreementContent) {
		this.agreementContent = agreementContent == null ? null : agreementContent.trim();
	}
	
    /**
     * @return AgreementContent
     */	
	public String getAgreementContent() {
		return this.agreementContent;
	}


}