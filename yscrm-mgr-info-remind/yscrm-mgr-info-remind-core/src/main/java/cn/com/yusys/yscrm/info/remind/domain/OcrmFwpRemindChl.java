package cn.com.yusys.yscrm.info.remind.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: OcrmFwpRemindChl
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-25 15:17:51
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_REMIND_CHL")
public class OcrmFwpRemindChl extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 渠道编号 **/
	@Id
	@Column(name = "CHL_ID")
	@Generated(GenerationType.UUID)
	private String chlId;
	
	/** 渠道名称 **/
	@Column(name = "CHL_NAME", unique = false, nullable = true, length = 32)
	private String chlName;
	
	/** 渠道服务端IP **/
	@Column(name = "HOST", unique = false, nullable = true, length = 50)
	private String host;
	
	/** 渠道服务端端口 **/
	@Column(name = "PORT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal port;
	
	/** 渠道服务端登录名 **/
	@Column(name = "USER_NAME", unique = false, nullable = true, length = 50)
	private String userName;
	
	/** 渠道服务端登录密码 **/
	@Column(name = "PASS_WORD", unique = false, nullable = true, length = 50)
	private String passWord;
	
	/** 渠道服务端文件路径 **/
	@Column(name = "REMOTE_PATH", unique = false, nullable = true, length = 50)
	private String remotePath;
	
	/** 本地文件存储路径 **/
	@Column(name = "LOCAL_PATH", unique = false, nullable = true, length = 50)
	private String localPath;
	
	/** 数据文件-业务代码 **/
	@Column(name = "DATA_BUSI_CODE", unique = false, nullable = true, length = 50)
	private String dataBusiCode;
	
	/** 数据文件-手机所属运营商id **/
	@Column(name = "DATA_MOBILE_ID", unique = false, nullable = true, length = 50)
	private String dataMobileId;
	
	/** 数据文件-机构代码 **/
	@Column(name = "DATA_ORG_ID", unique = false, nullable = true, length = 50)
	private String dataOrgId;
	
	/** 描述文件-业务标识 **/
	@Column(name = "INFO_BUSI_TYPE_ID", unique = false, nullable = true, length = 50)
	private String infoBusiTypeId;
	
	/** 描述文件-业务名称 **/
	@Column(name = "INFO_BUSI_NAME", unique = false, nullable = true, length = 50)
	private String infoBusiName;
	
	
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
	 * @param chlName
	 */
	public void setChlName(String chlName) {
		this.chlName = chlName == null ? null : chlName.trim();
	}
	
    /**
     * @return ChlName
     */	
	public String getChlName() {
		return this.chlName;
	}
	
	/**
	 * @param host
	 */
	public void setHost(String host) {
		this.host = host == null ? null : host.trim();
	}
	
    /**
     * @return Host
     */	
	public String getHost() {
		return this.host;
	}
	
	/**
	 * @param port
	 */
	public void setPort(java.math.BigDecimal port) {
		this.port = port;
	}
	
    /**
     * @return Port
     */	
	public java.math.BigDecimal getPort() {
		return this.port;
	}
	
	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}
	
    /**
     * @return UserName
     */	
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * @param passWord
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord == null ? null : passWord.trim();
	}
	
    /**
     * @return PassWord
     */	
	public String getPassWord() {
		return this.passWord;
	}
	
	/**
	 * @param remotePath
	 */
	public void setRemotePath(String remotePath) {
		this.remotePath = remotePath == null ? null : remotePath.trim();
	}
	
    /**
     * @return RemotePath
     */	
	public String getRemotePath() {
		return this.remotePath;
	}
	
	/**
	 * @param localPath
	 */
	public void setLocalPath(String localPath) {
		this.localPath = localPath == null ? null : localPath.trim();
	}
	
    /**
     * @return LocalPath
     */	
	public String getLocalPath() {
		return this.localPath;
	}
	
	/**
	 * @param dataBusiCode
	 */
	public void setDataBusiCode(String dataBusiCode) {
		this.dataBusiCode = dataBusiCode == null ? null : dataBusiCode.trim();
	}
	
    /**
     * @return DataBusiCode
     */	
	public String getDataBusiCode() {
		return this.dataBusiCode;
	}
	
	/**
	 * @param dataMobileId
	 */
	public void setDataMobileId(String dataMobileId) {
		this.dataMobileId = dataMobileId == null ? null : dataMobileId.trim();
	}
	
    /**
     * @return DataMobileId
     */	
	public String getDataMobileId() {
		return this.dataMobileId;
	}
	
	/**
	 * @param dataOrgId
	 */
	public void setDataOrgId(String dataOrgId) {
		this.dataOrgId = dataOrgId == null ? null : dataOrgId.trim();
	}
	
    /**
     * @return DataOrgId
     */	
	public String getDataOrgId() {
		return this.dataOrgId;
	}
	
	/**
	 * @param infoBusiTypeId
	 */
	public void setInfoBusiTypeId(String infoBusiTypeId) {
		this.infoBusiTypeId = infoBusiTypeId == null ? null : infoBusiTypeId.trim();
	}
	
    /**
     * @return InfoBusiTypeId
     */	
	public String getInfoBusiTypeId() {
		return this.infoBusiTypeId;
	}
	
	/**
	 * @param infoBusiName
	 */
	public void setInfoBusiName(String infoBusiName) {
		this.infoBusiName = infoBusiName == null ? null : infoBusiName.trim();
	}
	
    /**
     * @return InfoBusiName
     */	
	public String getInfoBusiName() {
		return this.infoBusiName;
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
        OcrmFwpRemindChl other = (OcrmFwpRemindChl) that;
		return (this.getChlId() == null ? other.getChlId() == null : this.getChlId().equals(other.getChlId()))
        	&& (this.getChlName() == null ? other.getChlName() == null : this.getChlName().equals(other.getChlName()))
        	&& (this.getHost() == null ? other.getHost() == null : this.getHost().equals(other.getHost()))
                	&& (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
        	&& (this.getPassWord() == null ? other.getPassWord() == null : this.getPassWord().equals(other.getPassWord()))
        	&& (this.getRemotePath() == null ? other.getRemotePath() == null : this.getRemotePath().equals(other.getRemotePath()))
        	&& (this.getLocalPath() == null ? other.getLocalPath() == null : this.getLocalPath().equals(other.getLocalPath()))
        	&& (this.getDataBusiCode() == null ? other.getDataBusiCode() == null : this.getDataBusiCode().equals(other.getDataBusiCode()))
        	&& (this.getDataMobileId() == null ? other.getDataMobileId() == null : this.getDataMobileId().equals(other.getDataMobileId()))
        	&& (this.getDataOrgId() == null ? other.getDataOrgId() == null : this.getDataOrgId().equals(other.getDataOrgId()))
        	&& (this.getInfoBusiTypeId() == null ? other.getInfoBusiTypeId() == null : this.getInfoBusiTypeId().equals(other.getInfoBusiTypeId()))
        	&& (this.getInfoBusiName() == null ? other.getInfoBusiName() == null : this.getInfoBusiName().equals(other.getInfoBusiName()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChlId() == null) ? 0 : getChlId().hashCode());
        result = prime * result + ((getChlName() == null) ? 0 : getChlName().hashCode());
        result = prime * result + ((getHost() == null) ? 0 : getHost().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPassWord() == null) ? 0 : getPassWord().hashCode());
        result = prime * result + ((getRemotePath() == null) ? 0 : getRemotePath().hashCode());
        result = prime * result + ((getLocalPath() == null) ? 0 : getLocalPath().hashCode());
        result = prime * result + ((getDataBusiCode() == null) ? 0 : getDataBusiCode().hashCode());
        result = prime * result + ((getDataMobileId() == null) ? 0 : getDataMobileId().hashCode());
        result = prime * result + ((getDataOrgId() == null) ? 0 : getDataOrgId().hashCode());
        result = prime * result + ((getInfoBusiTypeId() == null) ? 0 : getInfoBusiTypeId().hashCode());
        result = prime * result + ((getInfoBusiName() == null) ? 0 : getInfoBusiName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", chlId=").append(chlId);
		sb.append(", chlName=").append(chlName);
		sb.append(", host=").append(host);
		sb.append(", port=").append(port);
		sb.append(", userName=").append(userName);
		sb.append(", passWord=").append(passWord);
		sb.append(", remotePath=").append(remotePath);
		sb.append(", localPath=").append(localPath);
		sb.append(", dataBusiCode=").append(dataBusiCode);
		sb.append(", dataMobileId=").append(dataMobileId);
		sb.append(", dataOrgId=").append(dataOrgId);
		sb.append(", infoBusiTypeId=").append(infoBusiTypeId);
		sb.append(", infoBusiName=").append(infoBusiName);
        sb.append("]");
        return sb.toString();
    }
}