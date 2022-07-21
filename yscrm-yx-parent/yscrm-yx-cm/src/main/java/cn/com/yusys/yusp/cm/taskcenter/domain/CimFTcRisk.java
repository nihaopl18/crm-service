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
 * 风险信息表（CIMP_TC_RISK_INFO）的持久化类
 * 
 */
@Entity
@Table(name = "CIMP_TC_RISK_INFO")
public class CimFTcRisk extends BaseDomain implements Serializable
{
    private static final long serialVersionUID = 1L;

	@Column(name = "TASK_ID")
	private String taskId;
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "RISK_ID")
	private String riskId;
    
    @Column(name = "EXECUTE_USER")
    private String executeUser;
    
    @Column(name = "FEEDBACK_CONTENT")
    private String feedbackContent;
    
    @Column(name = "EXECUTION")
    private String execution;

    @Column(name = "FEEDBACK_TIME")
    private String feedbackTime;
    
    @Column(name = "RISK_CONTENT")
    private String riskContent;
    
    @Column(name = "CUSTOMER_ID")
    private String customerId;


    @Column(name = "LAST_UPDATE_DT")
    private Date lastUpdateDt;
    
    @Column(name = "LAST_UPDATE_USER")
    private String lastUpdateUser;
    
    public String getTaskId()
    {
        return this.taskId;
    }
    
    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getRiskId()
    {
        return this.riskId;
    }
    
    public void setRiskId(String riskId)
    {
        this.riskId = riskId;
    }
    public String getExecuteUser()
    {
        return this.executeUser;
    }
    
    public void setExecuteUser(String executeUser)
    {
        this.executeUser = executeUser;
    }
    
    public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getRiskContent() {
		return riskContent;
	}

	public void setRiskContent(String riskContent) {
		this.riskContent = riskContent;
	}

	public String getFeedbackContent()
    {
        return this.feedbackContent;
    }
    
    public void setFeedbackContent(String feedbackContent)
    {
        this.feedbackContent = feedbackContent;
    }
    
    public String getExecution()
    {
        return this.execution;
    }
    
    public void setExecution(String execution)
    {
        this.execution = execution;
    }
    
    public String getFeedbackTime()
    {
        return this.feedbackTime;
    }
    
    public void setFeedbackTime(String feedbackTime)
    {
        this.feedbackTime = feedbackTime;
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

    
}
