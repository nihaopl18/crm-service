package cn.com.yusys.yusp.cm.market.domain;


import javax.persistence.Table;


@Table(name = "YSCIMC_F_MK_ACTI_FISSION_IMG")
public class YscimcFMkActiFissionImg {

	private String fissionId;

	private String imgType;

	private String imgUrl;

	private String imgSize;

	private String imgTypeName;

	public String getImgTypeName() {
		return imgTypeName;
	}

	public void setImgTypeName(String imgTypeName) {
		this.imgTypeName = imgTypeName;
	}

	public String getFissionId() {
		return fissionId;
	}

	public void setFissionId(String fissionId) {
		this.fissionId = fissionId;
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
