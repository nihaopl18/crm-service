package cn.com.yusys.climp.qypool.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommModel
 * @类描述: 商品规格数据实体类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26 14:40:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_COMM_MODEL")
public class LoyQyCommModel extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID", unique = true, nullable = false, length = 50)
	private String id;
	
	/** 商品编号 **/
	@Column(name = "COMM_ID", unique = false, nullable = false, length = 50)
	private String commId;
	
	/** 规格参数 **/
	@Column(name = "MODEL_PARAM", unique = false, nullable = true, length = 3000)
	private String modelParam;
	
	/** 库存数量 **/
	@Column(name = "MODEL_STG_NUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal modelStgNum;
	
	/** 规格现金价值 **/
	@Column(name = "MODEL_M_VALUE", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal modelMvalue;
	
	/** 规格积分价值 **/
	@Column(name = "MODEL_L_VALUE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal modelLvalue;
	
	/** 已售数量 **/
	@Column(name = "MODEL_SAL_NUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal modelSalNum;
	
	/** 预警库存 **/
	@Column(name = "STG_ALARM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal stgAlarm;
	
	/** 默认规则 **/
	@Column(name = "DEFAULT_MODEL", unique = false, nullable = true, length = 20)
	private String defaultModel;
	
	/** 商品购买(兑换)上限 **/
	@Column(name = "PURCHASE_LIMIT", unique = false, nullable = true, length = 20)
	private int purchaseLimit;
	
	/** 删除标识 **/
	@Column(name = "DELETE_STS", unique = false, nullable = true, length = 4)
	private String deleteSts;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 50)
	private String createUser;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	private String createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 50)
	private String createOrg;
	
	/** 最近修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 50)
	private String updateUser;
	
	/** 最近修改时间 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 20)
	private String updateDate;
	
	/** 最近修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 50)
	private String updateOrg;

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? "" : id.trim();
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
	}

	public String getCommId() {
		return commId;
	}

	public void setCommId(String commId) {
		this.commId = commId;
	}

	public void setModelStgNum(java.math.BigDecimal modelStgNum) {
		this.modelStgNum = modelStgNum == null ? BigDecimal.ZERO : modelStgNum;
	}

	/**
	 * @param modelParam
	 */
	public void setModelParam(String modelParam) {
		this.modelParam = modelParam == null ? null : modelParam.trim();
	}
	
    /**
     * @return ModelParam
     */	
	public String getModelParam() {
		return this.modelParam;
	}
	
    /**
     * @return ModelStgNum
     */	
	public BigDecimal getModelStgNum() {
		return this.modelStgNum;
	}
	
	/**
	 * @param modelMvalue
	 */
	public void setModelMvalue(java.math.BigDecimal modelMvalue) {
		this.modelMvalue = modelMvalue;
	}
	
    /**
     * @return ModelMvalue
     */	
	public java.math.BigDecimal getModelMvalue() {
		return this.modelMvalue;
	}
	
	/**
	 * @param modelLvalue
	 */
	public void setModelLvalue(java.math.BigDecimal modelLvalue) {
		this.modelLvalue = modelLvalue;
	}
	
    /**
     * @return ModelLvalue
     */	
	public java.math.BigDecimal getModelLvalue() {
		return this.modelLvalue;
	}
	
	/**
	 * @param modelSalNum
	 */
	public void setModelSalNum(java.math.BigDecimal modelSalNum) {
		this.modelSalNum = modelSalNum == null ? BigDecimal.ZERO : modelSalNum;
	}
	
    /**
     * @return ModelSalNum
     */	
	public java.math.BigDecimal getModelSalNum() {
		return this.modelSalNum;
	}
	
	/**
	 * @param stgAlarm
	 */
	public void setStgAlarm(java.math.BigDecimal stgAlarm) {
		this.stgAlarm = stgAlarm == null ? BigDecimal.ZERO : stgAlarm;
	}
	
    /**
     * @return StgAlarm
     */	
	public java.math.BigDecimal getStgAlarm() {
		return this.stgAlarm;
	}
	
	/**
	 * @param defaultModel
	 */
	public void setDefaultModel(String defaultModel) {
		this.defaultModel = defaultModel == null ? null : defaultModel.trim();
	}
	
    /**
     * @return DefaultModel
     */	
	public String getDefaultModel() {
		return this.defaultModel;
	}
	
	/**
	 * @param purchaseLimit
	 */
	public void setPurchaseLimit(int purchaseLimit) {
		this.purchaseLimit = purchaseLimit;
	}
	
    /**
     * @return PurchaseLimit
     */	
	public int getPurchaseLimit() {
		return this.purchaseLimit;
	}
	
	/**
	 * @param deleteSts
	 */
	public void setDeleteSts(String deleteSts) {
		this.deleteSts = deleteSts == null ? null : deleteSts.trim();
	}
	
    /**
     * @return DeleteSts
     */	
	public String getDeleteSts() {
		return this.deleteSts;
	}
	
	/**
	 * @param createUser
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}
	
    /**
     * @return CreateUser
     */	
	public String getCreateUser() {
		return this.createUser;
	}
	
	/**
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
	}
	
    /**
     * @return CreateDate
     */	
	public String getCreateDate() {
		return this.createDate;
	}
	
	/**
	 * @param createOrg
	 */
	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg == null ? null : createOrg.trim();
	}
	
    /**
     * @return CreateOrg
     */	
	public String getCreateOrg() {
		return this.createOrg;
	}
	
	/**
	 * @param updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}
	
    /**
     * @return UpdateUser
     */	
	public String getUpdateUser() {
		return this.updateUser;
	}
	
	/**
	 * @param updateDate
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate == null ? null : updateDate.trim();
	}
	
    /**
     * @return UpdateDate
     */	
	public String getUpdateDate() {
		return this.updateDate;
	}
	
	/**
	 * @param updateOrg
	 */
	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg == null ? null : updateOrg.trim();
	}
	
    /**
     * @return UpdateOrg
     */	
	public String getUpdateOrg() {
		return this.updateOrg;
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
        LoyQyCommModel other = (LoyQyCommModel) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getCommId() == null ? other.getCommId() == null : this.getCommId().equals(other.getCommId()))
        	&& (this.getModelParam() == null ? other.getModelParam() == null : this.getModelParam().equals(other.getModelParam()))
                                                	&& (this.getDefaultModel() == null ? other.getDefaultModel() == null : this.getDefaultModel().equals(other.getDefaultModel()))
                	&& (this.getDeleteSts() == null ? other.getDeleteSts() == null : this.getDeleteSts().equals(other.getDeleteSts()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
        	&& (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
        	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
        	&& (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
        	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommId() == null) ? 0 : getCommId().hashCode());
        result = prime * result + ((getModelParam() == null) ? 0 : getModelParam().hashCode());
        result = prime * result + ((getDefaultModel() == null) ? 0 : getDefaultModel().hashCode());
        result = prime * result + ((getDeleteSts() == null) ? 0 : getDeleteSts().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", commId=").append(commId);
		sb.append(", modelParam=").append(modelParam);
		sb.append(", modelStgNum=").append(modelStgNum);
		sb.append(", modelMvalue=").append(modelMvalue);
		sb.append(", modelLvalue=").append(modelLvalue);
		sb.append(", modelSalNum=").append(modelSalNum);
		sb.append(", stgAlarm=").append(stgAlarm);
		sb.append(", defaultModel=").append(defaultModel);
		sb.append(", purchaseLimit=").append(purchaseLimit);
		sb.append(", deleteSts=").append(deleteSts);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
        sb.append("]");
        return sb.toString();
    }
}