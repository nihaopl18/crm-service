package cn.com.yusys.yusp.cm.taskcenter.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * 商机信息表（CIMP_TC_NICHE_INFO）的持久化类
 * 
 */
@Entity
@Table(name = "CIMP_TC_NICHE_INFO")
public class CimFTcNiche extends BaseDomain implements Serializable
{
    private static final long serialVersionUID = 1L;

	@Column(name = "TASK_ID")
	private String taskId;
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "NICHE_ID")
	private String nicheId;
    
    public String getNicheName() {
		return nicheName;
	}

	public void setNicheName(String nicheName) {
		this.nicheName = nicheName;
	}

	@Column(name = "NICHE_NAME")
    private String nicheName;
    
    @Column(name = "NICHE_STATE")
    private String nicheState;
    
    @Column(name = "NICHE_STAGE")
    private String nicheStage;

    @Column(name = "NICHE_TYPE")
    private String nicheType;

    @Column(name = "NICHE_START_DT")
    private Date nicheStartDt;

    @Column(name = "NICHE_END_DT")
    private Date nicheEndDt;

    @Column(name = "NICHE_EFFECTIVE_DT")
    private Date nicheEffectiveDt;

    @Column(name = "NICHE_CONTENT")
    private String nicheContent;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "CUSTOMER_CONTACTS")
    private String customerContacts;

    @Column(name = "ESTIMATED_AMOUNT")
    private String estimatedAmount;

    @Column(name = "COST_BUDGET")
    private String costBudget;

    @Column(name = "NICHE_RISE_DT")
    private Date nicheRiseDt;

    @Column(name = "LAST_UPDATE_DT")
    private Date lastUpdateDt;
    
    @Column(name = "LAST_UPDATE_USER")
    private String lastUpdateUser;
    
    @Column(name = "EXECUTE_USER")
    private String executeUser;
    
    @Column(name = "EXECUTE_AGENCY")
    private String executeAgency;
    
    @Column(name = "SITUATION")
    private String situation;
    
    public String getTaskId()
    {
        return this.taskId;
    }
    
    public  void setTaskId(String taskId)
    {
        this.taskId = taskId;
        
    }

    public String getNicheId()
    {
        return this.nicheId;
    }
    
    public  void setNicheId(String nicheId)
    {
        this.nicheId = nicheId;
        
    }
    public String getNicheState()
    {
        return this.nicheState;
    }
    
    public  void setNicheState(String nicheState)
    {
        this.nicheState = nicheState;
        
    }
    
    public String getNicheStage()
    {
        return this.nicheStage;
    }
    
    public  void setNicheStage(String nicheStage)
    {
        this.nicheStage = nicheStage;
        
    }
    
    public String getNicheType()
    {
        return this.nicheType;
    }
    
    public  void setNicheType(String nicheType)
    {
        this.nicheType = nicheType;
        
    }
    
    public Date getNicheStartDt()
    {
        return this.nicheStartDt;
    }
    
    public void setNicheStartDt(Date nicheStartDt)
    {
        this.nicheStartDt = nicheStartDt;
        
    }

    public Date getNicheEndDt()
    {
        return this.nicheEndDt;
    }
    
    public  void setNicheEndDt(Date nicheEndDt)
    {
        this.nicheEndDt = nicheEndDt;
        
    }
    
    public Date getNicheEffectiveDt()
    {
        return this.nicheEffectiveDt;
    }
    
    public void setNicheEffectiveDt(Date nicheEffectiveDt)
    {
        this.nicheEffectiveDt = nicheEffectiveDt;
        
    }
    
    public String getNicheContent()
    {
        return this.nicheContent;
    }
    
    public void setNicheContent(String nicheContent)
    {
        this.nicheContent = nicheContent;
        
    }
    
    public String getCustomerName()
    {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
        
    }
    
    public String getCustomerContacts()
    {
        return this.customerContacts;
    }
    
    public void setCustomerContacts(String customerContacts)
    {
        this.customerContacts = customerContacts;
        
    }
    
    public String getEstimatedAmount()
    {
        return this.estimatedAmount;
    }
    
    public void setEstimatedAmount(String estimatedAmount)
    {
        this.estimatedAmount = estimatedAmount;
        
    }
    
    public String getCostBudget()
    {
        return this.costBudget;
    }
    
    public void setCostBudget(String costBudget)
    {
        this.costBudget = costBudget;
        
    }
    
    public Date getNicheRiseDt()
    {
        return this.nicheRiseDt;
    }
    
    public void setNicheRiseDt(Date nicheRiseDt)
    {
        this.nicheRiseDt = nicheRiseDt;
        
    }
    
    public Date getLastUpdateDt()
    {
        return this.lastUpdateDt;
    }
    
    public void setLastUpdateDt(Date lastUpdateDt)
    {
        this.lastUpdateDt = lastUpdateDt;
        
    }

    public String getLastUpdateUser()
    {
        return this.lastUpdateUser;
    }
    
    public void setLastUpdateUser(String lastUpdateUser)
    {
        this.lastUpdateUser = lastUpdateUser;
        
    }
    public String getExecuteUser()
    {
        return this.executeUser;
    }
    
    public void setExecuteUser(String executeUser)
    {
        this.executeUser = executeUser;
        
    }
    public String getExecuteAgency()
    {
        return this.executeAgency;
    }
    
    public void setExecuteAgency(String executeAgency)
    {
        this.executeAgency = executeAgency;
        
    }
    public String getSituation()
    {
        return this.situation;
    }
    
    public void setSituation(String situation)
    {
        this.situation = situation;
        
    }

    
}
