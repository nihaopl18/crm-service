package cn.com.yusys.yscimc.operation.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Table(name = "ACTIVITY_FIELD_INFO")
public class ActivityFieldInfo {

	/**
	 * 编号
	 */
	@ApiModelProperty(value = "编号")
	@Id
	private String id;

	/**
	 * 开始时间
	 */
	@ApiModelProperty(value = "开始时间")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@ApiModelProperty(value = "结束时间")
	private Date endTime;

	/**
	 * 图片尺寸
	 */
	@ApiModelProperty(value = "图片尺寸")
	private String imageSize;

	/**
	 * 图片地址
	 */
	@ApiModelProperty(value = "图片地址")
	private String imageAddr;

	/**
	 * 栏位编号
	 */
	@ApiModelProperty(value = "栏位编号")
	private String mktPositCode;

	/**
	 * 栏位类型
	 */
	@ApiModelProperty(value = "栏位类型")
	private String fieldType;

	/**
	 * 活动编号
	 */
	@ApiModelProperty(value = "活动编号")
	private String actId;

	/**
	 * 活动地址
	 */
	@ApiModelProperty(value = "活动地址")
	private String actHtmlAddr;

	/**
	 * 组件类型
	 */
	@ApiModelProperty(value = "组件类型")
	private String assemblyType;

	public String getAssemblyType() {
		return assemblyType;
	}

	public void setAssemblyType(String assemblyType) {
		this.assemblyType = assemblyType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getImageSize() {
		return imageSize;
	}

	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}

	public String getImageAddr() {
		return imageAddr;
	}

	public void setImageAddr(String imageAddr) {
		this.imageAddr = imageAddr;
	}

	public String getMktPositCode() {
		return mktPositCode;
	}

	public void setMktPositCode(String mktPositCode) {
		this.mktPositCode = mktPositCode;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getActHtmlAddr() {
		return actHtmlAddr;
	}

	public void setActHtmlAddr(String actHtmlAddr) {
		this.actHtmlAddr = actHtmlAddr;
	}
}
