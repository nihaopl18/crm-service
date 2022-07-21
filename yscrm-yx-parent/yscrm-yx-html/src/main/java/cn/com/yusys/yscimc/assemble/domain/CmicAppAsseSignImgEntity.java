package cn.com.yusys.yscimc.assemble.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "CMIC_APP_ASSE_SIGN_IMG")
public class CmicAppAsseSignImgEntity {

	/**
	 * 报名组件编号
	 */
	@ApiModelProperty(value = "报名组件编号")
	@Id
	private String signUpId;

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

	private String imgTypeName;

	public String getImgTypeName() {
		return imgTypeName;
	}

	public void setImgTypeName(String imgTypeName) {
		this.imgTypeName = imgTypeName;
	}

	public String getSignUpId() {
		return signUpId;
	}

	public void setSignUpId(String signUpId) {
		this.signUpId = signUpId;
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
}
