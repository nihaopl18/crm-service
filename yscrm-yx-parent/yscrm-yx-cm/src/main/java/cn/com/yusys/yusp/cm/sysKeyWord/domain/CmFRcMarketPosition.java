package cn.com.yusys.yusp.cm.sysKeyWord.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CM_F_RC_MARKET_POSITION")
public class CmFRcMarketPosition extends BaseDomain implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	public String getId() { return id; }
	public void setId(String id) { this.id=id; }
	
	@Column(name="CHANNEL_ID")
	private String channelId;
	
	public String getChannelId() { return channelId; }
	public void setChannelId(String channelId) { this.channelId=channelId; }
	
	@Column(name="MKT_SET")
	private String mktSet;
	
	public String getMktSet() { return mktSet; }
	public void setMktSet(String mktSet) { this.mktSet=mktSet; }
	
	@Column(name="MKT_SET_TYPE")
	private String mktSetType;
	
	public String getMktSetType() { return mktSetType; }
	public void setMktSetType(String mktSetType) { this.mktSetType=mktSetType; }
	
	@Column(name="MKT_SET_SIZE")
	private String mktSetSize;
	
	public String getMktSetSize() { return mktSetSize; }
	public void setMktSetSize(String mktSetSize) { this.mktSetSize=mktSetSize; }
}
