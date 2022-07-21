package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/9/14 10:50
 */
public class SystemUseInfoVO implements Serializable {
	private static final long serialVersionUID = -180692473675166863L;
	/**
	 * 系统月活用户占比
	 */
	private String proportion;
	/**
	 * 上个月月活用户占比
	 */
	private String lastProportion;

	private Integer proportionCompare;
	/**
	 * 近一月登录系统人数
	 */
	private Integer MAU;
	/**
	 * 上个月登录系统人数
	 */
	private Integer lastMAU;

	private Integer MAUCompare;
	/**
	 * 近一月系统登录次数
	 */
	private Integer logins;
	/**
	 * 上个月系统登录次数
	 */
	private Integer lastLogins;

	private Integer loginsCompare;

	public String getProportion() {
		return proportion;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion == null ? null : proportion.trim();
	}

	public String getLastProportion() {
		return lastProportion;
	}

	public void setLastProportion(String lastProportion) {
		this.lastProportion = lastProportion == null ? null : lastProportion;
	}

	public Integer getProportionCompare() {
		return proportionCompare;
	}

	public void setProportionCompare(Integer proportionCompare) {
		this.proportionCompare = proportionCompare;
	}

	public Integer getMAU() {
		return MAU;
	}

	public void setMAU(Integer MAU) {
		this.MAU = MAU;
	}

	public Integer getLastMAU() {
		return lastMAU;
	}

	public void setLastMAU(Integer lastMAU) {
		this.lastMAU = lastMAU;
	}

	public Integer getMAUCompare() {
		return MAUCompare;
	}

	public void setMAUCompare(Integer MAUCompare) {
		this.MAUCompare = MAUCompare;
	}

	public Integer getLogins() {
		return logins;
	}

	public void setLogins(Integer logins) {
		this.logins = logins;
	}

	public Integer getLastLogins() {
		return lastLogins;
	}

	public void setLastLogins(Integer lastLogins) {
		this.lastLogins = lastLogins;
	}

	public Integer getLoginsCompare() {
		return loginsCompare;
	}

	public void setLoginsCompare(Integer loginsCompare) {
		this.loginsCompare = loginsCompare;
	}
}
