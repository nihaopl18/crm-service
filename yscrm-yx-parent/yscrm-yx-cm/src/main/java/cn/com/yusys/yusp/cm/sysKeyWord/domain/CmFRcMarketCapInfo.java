package cn.com.yusys.yusp.cm.sysKeyWord.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CM_F_RC_PROD_CAP")
public class CmFRcMarketCapInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CATL_CODE")
	private long catlCode;
	
	public long getCatlCode() { return catlCode; }
	public void setCatlCode(long catlCode) { this.catlCode=catlCode; }
	
	@Column(name="CYCLE_TIME")
	private long cycleTime;
	
	public long getCycleTime() { return cycleTime; }
	public void setCycleTime(long cycleTime) { this.cycleTime=cycleTime; }
	
	@Column(name="CAP_TIME")
	private long capTime;
	
	public long getCapTime() { return capTime; }
	public void setCapTime(long capTime) { this.capTime=capTime; }
	
}
