package cn.com.yusys.yscrm.custpub.domain;

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
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFnetworkCiRela
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 16:28:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_NETWORK_CI_RELA")
public class OcrmFnetworkCiRela extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 关系表编号 **/
	@Id
	@Column(name = "RELA_ID")
	@Generated(GenerationType.UUID)
	private String relaId;
	
	/** 网络关系编号 **/
	@Column(name = "NETWORK_RELA_ID", unique = false, nullable = false, length = 32)
	private String networkRelaId;
	
	/** 起点 **/
	@Column(name = "CUST_ID_MAIN", unique = false, nullable = false, length = 32)
	private String custIdMain;
	
	/** 终点 **/
	@Column(name = "CUST_ID_FROM", unique = false, nullable = false, length = 20)
	private String custIdFrom;
	
	/** 关系名称 **/
	@Column(name = "RELA_NAME", unique = false, nullable = false, length = 2)
	private String relaName;
	
	
	/**
	 * @param relaId
	 */
	public void setRelaId(String relaId) {
		this.relaId = relaId == null ? null : relaId.trim();
	}
	
    /**
     * @return RelaId
     */	
	public String getRelaId() {
		return this.relaId;
	}
	
	/**
	 * @param networkRelaId
	 */
	public void setNetworkRelaId(String networkRelaId) {
		this.networkRelaId = networkRelaId == null ? null : networkRelaId.trim();
	}
	
    /**
     * @return NetworkRelaId
     */	
	public String getNetworkRelaId() {
		return this.networkRelaId;
	}
	
	/**
	 * @param custIdMain
	 */
	public void setCustIdMain(String custIdMain) {
		this.custIdMain = custIdMain == null ? null : custIdMain.trim();
	}
	
    /**
     * @return CustIdMain
     */	
	public String getCustIdMain() {
		return this.custIdMain;
	}
	
	/**
	 * @param custIdFrom
	 */
	public void setCustIdFrom(String custIdFrom) {
		this.custIdFrom = custIdFrom == null ? null : custIdFrom.trim();
	}
	
    /**
     * @return CustIdFrom
     */	
	public String getCustIdFrom() {
		return this.custIdFrom;
	}
	
	/**
	 * @param relaName
	 */
	public void setRelaName(String relaName) {
		this.relaName = relaName == null ? null : relaName.trim();
	}
	
    /**
     * @return RelaName
     */	
	public String getRelaName() {
		return this.relaName;
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
        OcrmFnetworkCiRela other = (OcrmFnetworkCiRela) that;
		return (this.getRelaId() == null ? other.getRelaId() == null : this.getRelaId().equals(other.getRelaId()))
        	&& (this.getNetworkRelaId() == null ? other.getNetworkRelaId() == null : this.getNetworkRelaId().equals(other.getNetworkRelaId()))
        	&& (this.getCustIdMain() == null ? other.getCustIdMain() == null : this.getCustIdMain().equals(other.getCustIdMain()))
        	&& (this.getCustIdFrom() == null ? other.getCustIdFrom() == null : this.getCustIdFrom().equals(other.getCustIdFrom()))
        	&& (this.getRelaName() == null ? other.getRelaName() == null : this.getRelaName().equals(other.getRelaName()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRelaId() == null) ? 0 : getRelaId().hashCode());
        result = prime * result + ((getNetworkRelaId() == null) ? 0 : getNetworkRelaId().hashCode());
        result = prime * result + ((getCustIdMain() == null) ? 0 : getCustIdMain().hashCode());
        result = prime * result + ((getCustIdFrom() == null) ? 0 : getCustIdFrom().hashCode());
        result = prime * result + ((getRelaName() == null) ? 0 : getRelaName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", relaId=").append(relaId);
		sb.append(", networkRelaId=").append(networkRelaId);
		sb.append(", custIdMain=").append(custIdMain);
		sb.append(", custIdFrom=").append(custIdFrom);
		sb.append(", relaName=").append(relaName);
        sb.append("]");
        return sb.toString();
    }
}