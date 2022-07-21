package cn.com.yusys.yusp.cm.market.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Table;


@Table(name = "YSCIMC_F_MK_ACTI_FISSION_REWARD")
public class YscimcFMkActiFissionReward {

	/**
	 * 编号
	 */
	@ApiModelProperty(value = "编号")
	private String id;

	/**
	 * 裂变组件编号
	 */
	@ApiModelProperty(value = "裂变组件编号")
	private String fissionId;

	/**
	 * 分享次数
	 */
	@ApiModelProperty(value = "分享次数")
	private String frequency;

	/**
	 * 奖品类别
	 */
	@ApiModelProperty(value = "奖品类别")
	private String prizeType;

	/**
	 * 奖品名称
	 */
	@ApiModelProperty(value = "奖品名称")
	private String prizeName;

	/**
	 * 奖品编号
	 */
	@ApiModelProperty(value = "奖品编号")
	private String prizeId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFissionId() {
		return fissionId;
	}

	public void setFissionId(String fissionId) {
		this.fissionId = fissionId;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getPrizeType() {
		return prizeType;
	}

	public void setPrizeType(String prizeType) {
		this.prizeType = prizeType;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public String getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(String prizeId) {
		this.prizeId = prizeId;
	}
}
