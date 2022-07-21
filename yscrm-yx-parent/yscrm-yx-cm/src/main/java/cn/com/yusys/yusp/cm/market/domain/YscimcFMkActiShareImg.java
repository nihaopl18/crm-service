package cn.com.yusys.yusp.cm.market.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Table;

@Table(name = "YSCIMC_F_MK_ACTI_SHARE_IMG")
public class YscimcFMkActiShareImg {

	/**
	 * 分享组件编号
	 */
	@ApiModelProperty(value = "分享组件编号")
	private String shareId;

	/**
	 * 图片类型
	 */
	@ApiModelProperty(value = "图片类型")
	private String imgType;

	/**
	 * 图片地址
	 */
	@ApiModelProperty(value = "图片地址")
	private String imgUrl;

	/**
	 * 图片大小
	 */
	@ApiModelProperty(value = "图片大小")
	private String imgSize;

	/**
	 * 图片类型名称
	 */
	@ApiModelProperty(value = "图片类型名称")
	private String imgTypeName;

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgSize() {
		return imgSize;
	}

	public void setImgSize(String imgSize) {
		this.imgSize = imgSize;
	}

	public String getImgTypeName() {
		return imgTypeName;
	}

	public void setImgTypeName(String imgTypeName) {
		this.imgTypeName = imgTypeName;
	}
}
