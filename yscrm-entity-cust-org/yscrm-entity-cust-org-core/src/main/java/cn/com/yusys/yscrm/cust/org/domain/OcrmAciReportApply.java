package cn.com.yusys.yscrm.cust.org.domain;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * @项目名称: aaa模块
 * @类名称: OcrmAciReportApply
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-03-04 20:12:06
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_A_CI_REPORT_APPLY")
public class OcrmAciReportApply extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** INSTANCEID **/
	@Id
	@Column(name = "BIZSEQNO")
	@Generated(GenerationType.UUID)
	private String bizseqno;
	/** PARAMS **/
	@Column(name = "PARAMS", unique = false, nullable = true, length = 4000)
	private String params;
	
	
	/**
	 * @param bizseqno
	 */
	public void setBizseqno(String bizseqno) {
		this.bizseqno = bizseqno == null ? null : bizseqno.trim();
	}
	
    /**
     * @return Bizseqno
     */	
	public String getBizseqno() {
		return this.bizseqno;
	}
	
	
   
	/**
	 * @param params
	 */
	public void setParams(String params) {
		this.params = params;
	}
	
    /**
     * @return Params
     */	
	public String getParams() {
		return this.params;
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
        OcrmAciReportApply other = (OcrmAciReportApply) that;
		return (this.getBizseqno() == null ? other.getBizseqno() == null : this.getBizseqno().equals(other.getBizseqno()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBizseqno() == null) ? 0 : getBizseqno().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", bizseqno=").append(bizseqno);
		sb.append(", params=").append(params);
        sb.append("]");
        return sb.toString();
    }
}
