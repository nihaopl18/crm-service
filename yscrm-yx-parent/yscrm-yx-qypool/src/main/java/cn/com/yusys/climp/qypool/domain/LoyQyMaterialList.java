package cn.com.yusys.climp.qypool.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

@Entity
@Table(name = "LOY_QY_MATERIAL_LIST")
public class LoyQyMaterialList extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	public String getId() {return this.id;}
	public void setId(String id) { this.id = id; }
	
	@Column(name = "MATERIAL_NAME")
	private String materialName;
	
	public String getMaterialName() { return materialName; }
	public void setMaterialName(String materialName) { this.materialName=materialName; }
	
	@Column(name = "APPLY_PORT")
	private String applyPort;
	
	public String getApplyPort() { return applyPort; }
	public void setApplyPort(String applyPort) { this.applyPort=applyPort; }
	
	@Column(name = "MATERIAL_TYPE")
	private String materialType;
	
	public String getMaterialType() { return materialType; }
	public void setMaterialType(String materialType) { this.materialType=materialType; }
	
	@Column(name = "MATERIAL_STS")
	private String materialSts;
	
	public String getMaterialSts() { return materialSts; }
	public void setMaterialSts(String materialSts) { this.materialSts = materialSts; }
	
	@Column(name = "UPLOAD_FILE")
	private String uploadFile;
	
	public String getUploadFile() { return uploadFile; }
	public void setUploadFile(String uploadFile) { this.uploadFile=uploadFile; }
	
	@Column(name = "UPLOAD_FILE_ID")
	private String uploadFileId;
	
	public String getUploadFileId() { return uploadFileId; }
	public void setUploadFileId(String uploadFileId) { this.uploadFileId=uploadFileId; }
	
	@Column(name = "UPLOAD_LINK")
	private String uploadLink;
	
	public String getUploadLink() { return uploadLink; }
	public void setUploadLink(String uploadLink) { this.uploadLink=uploadLink; }
	
	@Column(name = "UPLOAD_APPROAL")
	private String uploadApproal;
	
	public String getUploadApproal() { return uploadApproal; }
	public void setUploadApproal(String uploadApproal) { this.uploadApproal=uploadApproal; }
	
	@Column(name = "UPLOAD_APPROAL_ID")
	private String uploadApproalId;
	
	public String getUploadApproalId() { return uploadApproalId; }
	public void setUploadApproalId(String uploadApproalId) { this.uploadApproalId=uploadApproalId; }
	
	@Column(name = "APPLY_FIELD")
	private String applyField;
	
	public String getApplyField() { return applyField; }
	public void setApplyField(String applyField) { this.applyField=applyField; }
	
	@Column(name = "APPLY_SIZE")
	private String applySize;
	
	public String getApplySize() { return applySize; }
	public void setApplySize(String applySize) { this.applySize=applySize; }
	
	@Column(name = "VISIABLE_RANG")
	private String visiableRang;
	
	public String getVisiableRang() { return visiableRang; }
	public void setVisiableRang(String visiableRang) { this.visiableRang=visiableRang; }
	
	@Column(name = "APPLY_ORG")
	private String applyOrg;
	
	public String getApplyOrg() { return applyOrg; }
	public void setApplyOrg(String applyOrg) { this.applyOrg=applyOrg; }
	
	@Column(name = "APPLY_DPT")
	private String applyDpt;
	
	public String getApplyDpt() { return applyDpt; }
	public void setApplyDpt(String applyDpt) { this.applyDpt=applyDpt; }
	
	@Column(name = "CREATE_USER")
	private String createUser;
	
	public String getCreateUser() { return createUser; }
	public void setCreateUser(String createUser) { this.createUser=createUser; }
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	public Date getCreateDate() { return createDate; }
	public void setCreateDate(Date createDate) { this.createDate=createDate; }
	
	@Column(name = "CREATE_ORG")
	private String createOrg;
	
	public String getCreateOrg() { return createOrg; }
	public void setCreateOrg(String createOrg) { this.createOrg=createOrg; }
	
	@Column(name = "UPDATE_USER")
	private String updateUser;
	
	public String getUpdateUser() { return updateUser; }
	public void setUpdateUser(String updateUser) { this.updateUser=updateUser; }
	
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	public Date getUpdateDate() { return updateDate; }
	public void setUpdateDate(Date updateDate) { this.updateDate=updateDate; }
	
	@Column(name = "UPDATE_ORG")
	private String updateOrg;
	
	public String getUpdateOrg() { return updateOrg; }
	public void setUpdateOrg(String updateOrg) { this.updateOrg=updateOrg; }
	
	@Column(name = "NATURAL_SIZE")
	private String naturalSize;
	
	public String getNaturalSize() { return naturalSize; }
	public void setNaturalSize(String naturalSize) { this.naturalSize=naturalSize; }
	
	@Column(name = "DETAIL_CONTENT")
	private String detailContent;
	
	public String getDetailContent() { return detailContent; }
	public void setDetailContent(String detailContent) { this.detailContent = detailContent; }
	
	@Column(name = "IMG_THUMBNAIL_ID")
	private String imgThumbNailId;
	
	public String getImgThumbNailId() { return this.imgThumbNailId; }
	public void setImgThumbNailId(String imgThumbNailId) { this.imgThumbNailId = imgThumbNailId; }
	
	@Column(name = "IMG_THUMBNAIL")
	private String imgThumbNail;
	
	public String getImgThumbNail() {return this.imgThumbNail; }
	public void setImgThumbNail(String imgThumbNail) {this.imgThumbNail = imgThumbNail;}
}	
	