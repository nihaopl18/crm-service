package cn.com.yusys.yusp.cm.cust.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 标签数据来源表（CIM_F_MM_TAG_DATA_SOURCE）的持久化类
 * 
 */
@Entity
@Table(name = "CIM_F_MM_TAG_DATA_SOURCE")
public class CimFMmTagDataSource implements Serializable
{
    private static final long serialVersionUID = 1L;

	@Column(name = "ID")
	private String id;
	
	@Column(name = "SYS_NO")
	private String sysNo;
    
    @Column(name = "TAG_NO")
    private String tagNo;
    
    @Column(name = "DATE_END")
    private Date dateEnd;
    
    @Column(name = "DATE_START")
    private Date dateStart;
    
    @Column(name = "ENTITY_NO")
    private String entityNo;
    
    @Column(name = "ENTITY_PROP")
    private String entityProp;
    
    @Column(name = "ENTITY_TYPE")
    private String entityType;
    
    @Column(name = "STAT_CALIBER")
    private String statCaliber;

    public Date getDateEnd()
    {
        return this.dateEnd;
    }
    
    public CimFMmTagDataSource setDateEnd(Date dateEnd)
    {
        this.dateEnd = dateEnd;
        return this;
    }
    
    public Date getDateStart()
    {
        return this.dateStart;
    }
    
    public CimFMmTagDataSource setDateStart(Date dateStart)
    {
        this.dateStart = dateStart;
        return this;
    }
    
    public String getEntityNo()
    {
        return this.entityNo;
    }
    
    public CimFMmTagDataSource setEntityNo(String entityNo)
    {
        this.entityNo = entityNo;
        return this;
    }
    
    public String getEntityProp()
    {
        return this.entityProp;
    }
    
    public CimFMmTagDataSource setEntityProp(String entityProp)
    {
        this.entityProp = entityProp;
        return this;
    }
    
    public String getEntityType()
    {
        return this.entityType;
    }
    
    public CimFMmTagDataSource setEntityType(String entityType)
    {
        this.entityType = entityType;
        return this;
    }
    
    public String getStatCaliber()
    {
        return this.statCaliber;
    }
    
    public CimFMmTagDataSource setStatCaliber(String statCaliber)
    {
        this.statCaliber = statCaliber;
        return this;
    }
    
    public String getSysNo()
    {
        return this.sysNo;
    }
    
    public CimFMmTagDataSource setSysNo(String sysNo)
    {
        this.sysNo = sysNo;
        return this;
    }
    
    public String getTagNo()
    {
        return this.tagNo;
    }
    
    public CimFMmTagDataSource setTagNo(String tagNo)
    {
        this.tagNo = tagNo;
        return this;
    }
    

    public CimFMmTagDataSource setID(String id)
    {
        this.id = id;
        return this;
    }
    
    public String getID()
    {
        return this.id;
    }
    
}
