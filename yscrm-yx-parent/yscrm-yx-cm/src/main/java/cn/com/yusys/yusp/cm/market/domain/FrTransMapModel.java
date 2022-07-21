package cn.com.yusys.yusp.cm.market.domain;
// default package

import javax.persistence.*;
import java.util.Date;


/**
 * FrTransMapModel entity. @author MyEclipse Persistence Tools
 */
 @Entity
@Table(name="FR_RULE_TRANS_MAPPING") 

public class FrTransMapModel  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private FrTransMapModelId id;
	
	private String paramCode;
	
	
     private int paramPos;
     private String paramDesc;
     private String fieldName;
     private String ruleVisible;
     private String bak;
     private Date opTime;
     private String loginNo;
     private String opOrg;

     private FrTransInfoModel transInfoModel;
     
     private String fieldType; //规则类型
     private String fieldLen; //字段长度
     private String fieldFlag; //字段标识
     private Integer fieldOffset;//字段偏移量
     private String updownFlag; //上下行标识
     

    // Constructors

    /** default constructor */
    public FrTransMapModel() {
    }

	/** minimal constructor */
    public FrTransMapModel(FrTransMapModelId id) {
        this.setId(id);
    }
    
    /** full constructor */
    public FrTransMapModel(FrTransMapModelId id, int paramPos, String paramDesc, String fieldName, String ruleVisible, String bak, Date opTime, String loginNo, String opOrg) {
        this.setId(id);
        this.paramPos = paramPos;
        this.paramDesc = paramDesc;
        this.fieldName = fieldName;
        this.ruleVisible = ruleVisible;
        this.bak = bak;
        this.opTime = opTime;
        this.loginNo = loginNo;
        this.opOrg = opOrg;
    }

   
    // Property accessors
/*    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="transCode", column=@Column(name="TRANS_CODE", nullable=false, length=40) ), 
        @AttributeOverride(name="paramCode", column=@Column(name="PARAM_CODE", nullable=false, length=40) ) } )

    public FrTransMapModelId getId() {
        return this.id;
    }
    
    public void setId(FrTransMapModelId id) {
        this.id = id;
    }*/
    
    
    
  //  @Transient
    @Id
   public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	@ManyToOne
	@JoinColumn(name="TRANS_CODE", insertable=false, updatable=false)
    public FrTransInfoModel getTransInfoModel() {
		return transInfoModel;
	}

	public void setTransInfoModel(FrTransInfoModel transInfoModel) {
		this.transInfoModel = transInfoModel;
	}

	@Column(name="PARAM_POS", precision=22, scale=0)

    public int getParamPos() {
        return this.paramPos;
    }
    
    public void setParamPos(int paramPos) {
        this.paramPos = paramPos;
    }
    
    @Column(name="PARAM_DESC", length=40)

    public String getParamDesc() {
        return this.paramDesc;
    }
    
    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }
    
    @Column(name="FIELD_NAME", length=40)

    public String getFieldName() {
        return this.fieldName;
    }
    
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    
    @Column(name="RULE_VISIBLE", length=1)

    public String getRuleVisible() {
        return this.ruleVisible;
    }
    
    public void setRuleVisible(String ruleVisible) {
        this.ruleVisible = ruleVisible;
    }
    
    @Column(name="BAK", length=1024)

    public String getBak() {
        return this.bak;
    }
    
    public void setBak(String bak) {
        this.bak = bak;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="OP_TIME", length=7)

    public Date getOpTime() {
        return this.opTime;
    }
    
    public void setOpTime(Date opTime) {
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

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldLen() {
		return fieldLen;
	}

	public void setFieldLen(String fieldLen) {
		this.fieldLen = fieldLen;
	}

	public String getFieldFlag() {
		return fieldFlag;
	}

	public void setFieldFlag(String fieldFlag) {
		this.fieldFlag = fieldFlag;
	}

	public Integer getFieldOffset() {
		return fieldOffset;
	}

	public void setFieldOffset(Integer fieldOffset) {
		this.fieldOffset = fieldOffset;
	}

	public String getUpdownFlag() {
		return updownFlag;
	}

	public void setUpdownFlag(String updownFlag) {
		this.updownFlag = updownFlag;
	}

	public FrTransMapModelId getId() {
		return id;
	}

	public void setId(FrTransMapModelId id) {
		this.id = id;
	}
   








}