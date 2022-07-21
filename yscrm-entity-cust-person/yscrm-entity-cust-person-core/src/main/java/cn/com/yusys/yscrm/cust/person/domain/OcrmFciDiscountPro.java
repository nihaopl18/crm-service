package cn.com.yusys.yscrm.cust.person.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciDiscountPro
 * @类描述: #数据实体类
 * @功能描述: 客户优惠信息
 * @创建人: 15104
 * @创建时间: 2019-02-14 16:33:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_DISCOUNT_PRO")
public class OcrmFciDiscountPro extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 优惠方案ID **/
	@Id
	@Column(name = "DISCOUNT_PRO_ID")
	@Generated(GenerationType.UUID)
	private String discountProId;
	
	/** 优惠方案名称 **/
	@Column(name = "DISCOUNT_PRO_NAME", unique = false, nullable = true, length = 200)
	private String discountProName;
	
	/** 优惠方案内容 **/
	@Column(name = "DISCOUNT_PRO_CONTENT", unique = false, nullable = true, length = 4000)
	private String discountProContent;
	
	
	/**
	 * @param discountProId
	 */
	public void setDiscountProId(String discountProId) {
		this.discountProId = discountProId == null ? null : discountProId.trim();
	}
	
    /**
     * @return DiscountProId
     */	
	public String getDiscountProId() {
		return this.discountProId;
	}
	
	/**
	 * @param discountProName
	 */
	public void setDiscountProName(String discountProName) {
		this.discountProName = discountProName == null ? null : discountProName.trim();
	}
	
    /**
     * @return DiscountProName
     */	
	public String getDiscountProName() {
		return this.discountProName;
	}
	
	/**
	 * @param discountProContent
	 */
	public void setDiscountProContent(String discountProContent) {
		this.discountProContent = discountProContent == null ? null : discountProContent.trim();
	}
	
    /**
     * @return DiscountProContent
     */	
	public String getDiscountProContent() {
		return this.discountProContent;
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
        OcrmFciDiscountPro other = (OcrmFciDiscountPro) that;
		return (this.getDiscountProId() == null ? other.getDiscountProId() == null : this.getDiscountProId().equals(other.getDiscountProId()))
        	&& (this.getDiscountProName() == null ? other.getDiscountProName() == null : this.getDiscountProName().equals(other.getDiscountProName()))
        	&& (this.getDiscountProContent() == null ? other.getDiscountProContent() == null : this.getDiscountProContent().equals(other.getDiscountProContent()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDiscountProId() == null) ? 0 : getDiscountProId().hashCode());
        result = prime * result + ((getDiscountProName() == null) ? 0 : getDiscountProName().hashCode());
        result = prime * result + ((getDiscountProContent() == null) ? 0 : getDiscountProContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", discountProId=").append(discountProId);
		sb.append(", discountProName=").append(discountProName);
		sb.append(", discountProContent=").append(discountProContent);
        sb.append("]");
        return sb.toString();
    }
}