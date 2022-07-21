package cn.com.yusys.yscimc.assemble.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Table(name = "CMIC_APP_ASSEMBLE_SIGN_UP")
public class CmicAppAssembleSignUpEntity {

	/**
	 * 编号
	 */
	@ApiModelProperty(value = "编号")
	@Id
	private String id;

	/**
	 * 标题
	 */
	@ApiModelProperty(value = "标题")
	private String signUpTitle;

	/**
	 * 开始时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	@ApiModelProperty(value = "开始时间")
	private Date actStartTime;

	/**
	 * 结束时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	@ApiModelProperty(value = "结束时间")
	private Date actEndTime;

	/**
	 * 限制人数
	 */
	@ApiModelProperty(value = "限制人数")
	private String limitcustflag;

	/**
	 * 限制类型
	 */
	@ApiModelProperty(value = "限制类型")
	private String limittype;

	/**
	 * 限制数量
	 */
	@ApiModelProperty(value = "限制数量")
	private String limitnum;

	/**
	 * 图片地址
	 */
	@ApiModelProperty(value = "图片地址")
	private String imageurl;

	/**
	 * 内容
	 */
	@ApiModelProperty(value = "内容")
	private String content;

	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人")
	private String creatorId;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	@ApiModelProperty(value = "创建时间")
	private Date createDate;

	/**
	 * 最新变更用户
	 */
	@ApiModelProperty(value = "最新变更用户")
	private String lastChgUsr;

	/**
	 * 最新变更时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	@ApiModelProperty(value = "最新变更时间")
	private Date lastChgDt;

	/**
	 * 活动页面路径
	 */
	@ApiModelProperty(value = "活动页面路径")
	private String actHtml;

	private String actHtmlContent;

	private String imageSize;

	public String getImageSize() {
		return imageSize;
	}

	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}

	public String getActHtmlContent() {
		return actHtmlContent;
	}

	public void setActHtmlContent(String actHtmlContent) {
		this.actHtmlContent = actHtmlContent;
	}

	public String getActHtml() {
		return actHtml;
	}

	public void setActHtml(String actHtml) {
		this.actHtml = actHtml;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSignUpTitle() {
		return signUpTitle;
	}

	public void setSignUpTitle(String signUpTitle) {
		this.signUpTitle = signUpTitle;
	}

	public Date getActStartTime() {
		return actStartTime;
	}

	public void setActStartTime(Date actStartTime) {
		this.actStartTime = actStartTime;
	}

	public Date getActEndTime() {
		return actEndTime;
	}

	public void setActEndTime(Date actEndTime) {
		this.actEndTime = actEndTime;
	}

	public String getLimitcustflag() {
		return limitcustflag;
	}

	public void setLimitcustflag(String limitcustflag) {
		this.limitcustflag = limitcustflag;
	}

	public String getLimittype() {
		return limittype;
	}

	public void setLimittype(String limittype) {
		this.limittype = limittype;
	}

	public String getLimitnum() {
		return limitnum;
	}

	public void setLimitnum(String limitnum) {
		this.limitnum = limitnum;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastChgUsr() {
		return lastChgUsr;
	}

	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr;
	}

	public Date getLastChgDt() {
		return lastChgDt;
	}

	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
}
