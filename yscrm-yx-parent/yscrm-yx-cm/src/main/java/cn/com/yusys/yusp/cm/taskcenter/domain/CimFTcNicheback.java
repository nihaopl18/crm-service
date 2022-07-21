package cn.com.yusys.yusp.cm.taskcenter.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * 商机反馈信息表（CIMP_TC_NICHEBACK_INFO）的持久化类
 * 
 */
@Entity
@Table(name = "CIMP_TC_NICHEBACK_INFO")
public class CimFTcNicheback extends BaseDomain implements Serializable
{
    private static final long serialVersionUID = 1L;

	@Column(name = "TASK_ID")
	private String taskId;
	
	@Column(name = "NICHE_STAGE")
	private String nicheStage;
    
    @Column(name = "YES_NO")
    private String yesNo;
    
    @Column(name = "SITUATION")
    private String situation;

    @Column(name = "FEEDBACK_TIME")
    private String feedbackTime;
    
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

    public String getNicheStage()
    {
        return this.nicheStage;
    }
    
    public void setNicheStage(String nicheStage)
    {
        this.nicheStage = nicheStage;
    }
    
    public String getYesNo()
    {
        return this.yesNo;
    }
    
    public void setYesNo(String yesNo)
    {
        this.yesNo = yesNo;
    }
    
    public String getSituation()
    {
        return this.situation;
    }
    
    public void setSituation(String situation)
    {
        this.situation = situation;
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
