	package cn.com.yusys.yusp.cm.sysKeyWord.domain;

    import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
    import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
    import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.Id;
    import javax.persistence.Table;
    import java.io.Serializable;

@Entity
@Table(name = "cm_f_rc_sys_type")
public class CmFRcSysTypeInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Generated(GenerationType.UUID)
	private String id;

	@Column(name="MODEL_NAME")
	private String modelName;

	@Column(name="MODEL_INFO")
	private String modelInfo;

	@Column(name="MODEL_TYPE")
	private String modelType;

	@Column(name="IS_ENABLE")
	private String isEnable;

	@Column(name="APPLY_TYPE")
	private String applyType;

	@Column(name="CATL_CODE")
	private String catlCode;
	
//	@Column(name="CATL_NAME")
//	private String catlName;
	
	@Column(name="CREAT_USER")
	private String creatUser;
	
	@Column(name="CREAT_DATE")
	private String creatDate;
	
	@Column(name="UPDATA_USER")
	private String updataUser;
	
	@Column(name="UPDATA_DATE")
	private String updataDate;
	
	@Column(name="CREAT_USER_NAME")
	private String creatUserName;
	
	@Column(name="UPDATA_USER_NAME")
	private String updataUserName;
	
	@Column(name="WF_APP_STATUS")
	private String wfAppStatus;
	
	@Column(name="APPLY_OBJECT")
	private String applyObject;
	
	public String getApplyObject() { return applyObject; }
	public void setApplyObject(String applyObject) { this.applyObject=applyObject; }
	
	@Column(name="APPLY_CHANNEL")
	private String applyChannel;
	
	public String getApplyChannel() { return applyChannel; }
	public void setApplyChannel(String applyChannel) { this.applyChannel=applyChannel; }
	
	@Column(name="APPLY_OBJECT_NAME")
	private String applyObjectName;
	
	public String getApplyObjectName() { return applyObjectName; }
	public void setApplyObjectName(String applyObjectName) { this.applyObjectName=applyObjectName; }
	
	@Column(name="APPLY_CHANNEL_NAME")
	private String applyChannelName;
	
	public String getApplyChannelName() { return applyChannelName; }
	public void setApplyChannelName(String applyChannelName) { this.applyChannelName=applyChannelName; }
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelInfo() {
		return modelInfo;
	}

	public void setModelInfo(String modelInfo) {
		this.modelInfo = modelInfo;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getCatlCode() {
		return catlCode;
	}

	public void setCatlCode(String catlCode) {
		this.catlCode = catlCode;
	}	
	
//	public String getCatlName() {
//		return catlName;
//	}
//
//	public void setCatlName(String catlName) {
//		this.catlName = catlName;
//	}
	
	public String getCreatUser() {
		return creatUser;
	}

	public void setCreatUser(String creatUser) {
		this.creatUser = creatUser;
	}
	
	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}
	
	public String getUpdataUser() {
		return updataUser;
	}

	public void setUpdataUser(String updataUser) {
		this.updataUser = updataUser;
	}
	
	public String getUpdataDate() {
		return updataDate;
	}

	public void setUpdataDate(String updataDate) {
		this.updataDate = updataDate;
	}
	
	public String getCreatUserName() {
		return creatUserName;
	}

	public void setCreatUserName(String creatUserName) {
		this.creatUserName = creatUserName;
	}
	
	public String getUpdataUserName() {
		return updataUserName;
	}

	public void setUpdataUserName(String updataUserName) {
		this.updataUserName = updataUserName;
	}
	
	public String getWfAppStatus() {
		return wfAppStatus;
	}

	public void setWfAppStatus(String wfAppStatus) {
		this.wfAppStatus = wfAppStatus;
	}
	
	
}
