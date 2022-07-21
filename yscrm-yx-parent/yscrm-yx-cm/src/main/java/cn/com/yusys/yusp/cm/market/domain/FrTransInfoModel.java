package cn.com.yusys.yusp.cm.market.domain;
// default package

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * FrTransInfoModel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="FR_RULE_TRANS_INFO")
public class FrTransInfoModel extends BaseDomain implements java.io.Serializable {
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String transCode;
     private String busiCode;
     private String transName;
     private String chanId;
     private String eventType;
     private String transType;
     private String transState;
     private String bak;
     private String tabName;
     private String opTime;
     private String loginNo;
     private String opOrg;


    // Constructors

    /** default constructor */
    public FrTransInfoModel() {
    }

	/** minimal constructor */
    public FrTransInfoModel(String transCode, String busiCode, String transName, String chanId, String eventType, String transType, String transState) {
        this.transCode = transCode;
        this.busiCode = busiCode;
        this.transName = transName;
        this.chanId = chanId;
        this.eventType = eventType;
        this.transType = transType;
        this.transState = transState;
    }
    
    /** full constructor */
    public FrTransInfoModel(String transCode, String busiCode, String transName, String chanId, String eventType, String transType, String transState, String bak, String tabName, String opTime, String loginNo, String opOrg) {
        this.transCode = transCode; 
        this.busiCode = busiCode;
        this.transName = transName;
        this.chanId = chanId;
        this.eventType = eventType;
        this.transType = transType;
        this.transState = transState;
        this.bak = bak;
        this.tabName = tabName;
        this.opTime = opTime;
        this.loginNo = loginNo;
        this.opOrg = opOrg;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="TRANS_CODE", unique=true, nullable=false, length=40)

    public String getTransCode() {
        return this.transCode;
    }
    
    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }
    
    @Column(name="BUSI_CODE", nullable=false, length=40)

    public String getBusiCode() {
        return this.busiCode;
    }
    
    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }
    
    @Column(name="TRANS_NAME", nullable=false, length=100)

    public String getTransName() {
        return this.transName;
    }
    
    public void setTransName(String transName) {
        this.transName = transName;
    }
    
    @Column(name="CHAN_ID", nullable=false, precision=22, scale=0)

    public String getChanId() {
        return this.chanId;
    }
    
    public void setChanId(String chanId) {
        this.chanId = chanId;
    }
    
    @Column(name="EVENT_TYPE", nullable=false, precision=22, scale=0)

    public String getEventType() {
        return this.eventType;
    }
    
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    
    @Column(name="TRANS_TYPE", nullable=false, precision=22, scale=0)

    public String getTransType() {
        return this.transType;
    }
    
    public void setTransType(String transType) {
        this.transType = transType;
    }
    
    @Column(name="TRANS_STATE", nullable=false, precision=22, scale=0)

    public String getTransState() {
        return this.transState;
    }
    
    public void setTransState(String transState) {
        this.transState = transState;
    }
    
    @Column(name="BAK", length=1024)

    public String getBak() {
        return this.bak;
    }
    
    public void setBak(String bak) {
        this.bak = bak;
    }
    
    @Column(name="TAB_NAME", length=100)

    public String getTabName() {
        return this.tabName;
    }
    
    public void setTabName(String tabName) {
        this.tabName = tabName;
    }
    
    @Column(name="OP_TIME", length=20)
    
    public String getOpTime() {
		return opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}
    
    @Column(name="LOGIN_NO", length=40)

    public String getLoginNo() {
        return this.loginNo;
    }

	public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }
    
    @Column(name="OP_ORG", length=40)

    public String getOpOrg() {
        return this.opOrg;
    }
    
    public void setOpOrg(String opOrg) {
        this.opOrg = opOrg;
    }
   








}