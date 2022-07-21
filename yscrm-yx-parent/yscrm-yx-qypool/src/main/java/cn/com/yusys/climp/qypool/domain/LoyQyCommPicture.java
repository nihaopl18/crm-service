package cn.com.yusys.climp.qypool.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;


/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommPicture
 * @类描述: 商品图片数据实体类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26 14:40:21
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_COMM_PICTURE")
public class LoyQyCommPicture extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID", unique = true, nullable = false, length = 50)
	private String id;
	
	/** 商品ID **/
	@Column(name = "COMM_ID", unique = false, nullable = false, length = 50)
	private String commId;
	
	/** 商品图片名称 **/
	@Column(name = "PICTURE_NAME", unique = false, nullable = true, length = 100)
	private String pictureName;
	
	/** 商品图片路径 **/
	@Column(name = "PICTURE_PATH", unique = false, nullable = true, length = 100)
	private String picturePath;
	
	/** 图片类型 **/
	@Column(name = "PICTURE_TYPE", unique = false, nullable = true, length = 4)
	private String pictureType;
	
	/** 图片顺序 **/
	@Column(name = "PICTURE_ORDER", unique = false, nullable = true, length = 20)
	private String pictureOrder;
	
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
		this.id = id == null ? null : id.trim();
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

	/**
	 * @param pictureName
	 */
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName == null ? null : pictureName.trim();
	}
	
    /**
     * @return PictureName
     */	
	public String getPictureName() {
		return this.pictureName;
	}
	
	/**
	 * @param picturePath
	 */
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath == null ? null : picturePath.trim();
	}
	
    /**
     * @return PicturePath
     */	
	public String getPicturePath() {
		return this.picturePath;
	}
	
	/**
	 * @param pictureType
	 */
	public void setPictureType(String pictureType) {
		this.pictureType = pictureType == null ? null : pictureType.trim();
	}
	
    /**
     * @return PictureType
     */	
	public String getPictureType() {
		return this.pictureType;
	}
	
	/**
	 * @param pictureOrder
	 */
	public void setPictureOrder(String pictureOrder) {
		this.pictureOrder = pictureOrder == null ? null : pictureOrder.trim();
	}
	
    /**
     * @return PictureOrder
     */	
	public String getPictureOrder() {
		return this.pictureOrder;
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
        LoyQyCommPicture other = (LoyQyCommPicture) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getCommId() == null ? other.getCommId() == null : this.getCommId().equals(other.getCommId()))
        	&& (this.getPictureName() == null ? other.getPictureName() == null : this.getPictureName().equals(other.getPictureName()))
        	&& (this.getPicturePath() == null ? other.getPicturePath() == null : this.getPicturePath().equals(other.getPicturePath()))
        	&& (this.getPictureType() == null ? other.getPictureType() == null : this.getPictureType().equals(other.getPictureType()))
        	&& (this.getPictureOrder() == null ? other.getPictureOrder() == null : this.getPictureOrder().equals(other.getPictureOrder()))
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
        result = prime * result + ((getPictureName() == null) ? 0 : getPictureName().hashCode());
        result = prime * result + ((getPicturePath() == null) ? 0 : getPicturePath().hashCode());
        result = prime * result + ((getPictureType() == null) ? 0 : getPictureType().hashCode());
        result = prime * result + ((getPictureOrder() == null) ? 0 : getPictureOrder().hashCode());
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
		sb.append(", pictureName=").append(pictureName);
		sb.append(", picturePath=").append(picturePath);
		sb.append(", pictureType=").append(pictureType);
		sb.append(", pictureOrder=").append(pictureOrder);
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