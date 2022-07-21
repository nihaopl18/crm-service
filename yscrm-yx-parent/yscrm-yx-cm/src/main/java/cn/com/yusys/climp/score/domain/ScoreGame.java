package cn.com.yusys.climp.score.domain;

import cn.com.yusys.climp.utils.file.ExeclTitle;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/*
名单制积分赠送
 */
@Entity
@Table(name = "LOY_SR_SCORE_GAME_FT_TMP")
public class ScoreGame extends BaseDomain implements Serializable,Comparable<ScoreGame> {
	private static final long serialVersionUID = 1L;

	/*
	 注解对应表名称，表名与字段通过注解映射，不需要导入的字段不需要加注解
	 */
	@ExeclTitle("序号")
	@Column(name = "SERIAL_NUM", unique = false, nullable = true, length = 32)
	private String serialNum;

	@ExeclTitle("源系统编号")
	@Column(name = "SYS_CODE", unique = false, nullable = true, length = 32)
	private String sysCode;

	@ExeclTitle("源系统客户号")
	@Column(name = "CUSTOMER_NO", unique = false, nullable = true, length = 32)
	private String customerNo;

	@ExeclTitle("客户姓名")
	@Column(name = "CUSTOMERR_NAME", unique = false, nullable = true, length = 32)
	private String customerName;

	@ExeclTitle("赠送积分")
	@Column(name = "DONATE_SCOERS", unique = false, nullable = true, length = 32)
	private String donateScores;

	@ExeclTitle("截止有效期")
	@Column(name = "DISABLED_DT", unique = false, nullable = true, length = 32)
	private String disabledDt;

	@ExeclTitle("活动描述")
	@Column(name = "GAME_DESC", unique = false, nullable = true, length = 32)
	private String gameDesc;

	@ExeclTitle("批次号")
	@Column(name = "IMPORT_CODE", unique = false, nullable = true, length = 32)
	private String importCode;

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum == null ? "" : serialNum.trim();
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode == null ? "" : sysCode.trim();
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo == null ? "" : customerNo.trim();
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName == null ? "" : customerName.trim();
	}

	public String getDonateScores() {
		return donateScores;
	}

	public void setDonateScores(String donateScores) {
		this.donateScores = donateScores == null ? "" : donateScores.trim();
	}

	public String getDisabledDt() {
		return disabledDt;
	}

	public void setDisabledDt(String disabledDt) {
		this.disabledDt = disabledDt == null ? "" : disabledDt.trim();
	}

	public String getGameDesc() {
		return gameDesc;
	}

	public void setGameDesc(String gameDesc) {
		this.gameDesc = gameDesc == null ? "" : gameDesc.trim();
	}

	public String getImportCode() {
		return importCode;
	}

	public void setImportCode(String importCode) {
		this.importCode = importCode == null ? "" : importCode.trim();
	}

	@Override
	public int compareTo(ScoreGame o) {
		return o.getSerialNum().compareTo(this.getSerialNum());
	}
}