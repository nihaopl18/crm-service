package cn.com.yusys.yscrm.custpub.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;


/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AdminSmUserAttr
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Songer
 * @创建时间: 2019-02-14 09:45:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ADMIN_SM_USER_ATTR")
public class AdminSmUserAttr extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 登录代码 **/
	@Column(name = "LOGIN_CODE", unique = false, nullable = false, length = 100)
	private String loginCode;
	
	/** 业务条线[1个人2对公3三农4国结5村镇银行] **/
	@Column(name = "BUSI_TYPE", unique = false, nullable = true, length = 1)
	private String busiType;
	
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
	}
	
	/**
	 * @param loginCode
	 */
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode == null ? null : loginCode.trim();
	}
	
    /**
     * @return LoginCode
     */	
	public String getLoginCode() {
		return this.loginCode;
	}
	
	/**
	 * @param busiType
	 */
	public void setBusiType(String busiType) {
		this.busiType = busiType == null ? null : busiType.trim();
	}
	
    /**
     * @return BusiType
     */	
	public String getBusiType() {
		return this.busiType;
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
        AdminSmUserAttr other = (AdminSmUserAttr) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getLoginCode() == null ? other.getLoginCode() == null : this.getLoginCode().equals(other.getLoginCode()))
        	&& (this.getBusiType() == null ? other.getBusiType() == null : this.getBusiType().equals(other.getBusiType()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginCode() == null) ? 0 : getLoginCode().hashCode());
        result = prime * result + ((getBusiType() == null) ? 0 : getBusiType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", loginCode=").append(loginCode);
		sb.append(", busiType=").append(busiType);
        sb.append("]");
        return sb.toString();
    }
}