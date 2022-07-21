package cn.com.yusys.yusp.cm.taskcenter.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * 我的任务信息表（CIMP_TC_MYTASK_INFO）的持久化类
 * 
 */
@Entity
@Table(name = "CIMP_TC_MYTASK_INFO")
public class CimFTcMyTask extends BaseDomain implements Serializable
{
    private static final long serialVersionUID = 1L;

	@Column(name = "TASK_ID")
	private String taskId;
	
	@Column(name = "ALLOT_USER")
	private String allotUser;
    
    @Column(name = "ALLOT_TIME")
    private Date allotTime;
    
    @Column(name = "DUTY_USER")
    private String dutyUser;

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

    public String getAllotUser()
    {
        return this.allotUser;
    }
    
    public void setAllotUser(String allotUser)
    {
        this.allotUser = allotUser;
    }
    
    public Date getAllotTime()
    {
        return this.allotTime;
    }
    
    public void setAllotTime(Date allotTime)
    {
        this.allotTime = allotTime;
    }
    
    public String getDutyUser()
    {
        return this.dutyUser;
    }
    
    public void setDutyUser(String dutyUser)
    {
        this.dutyUser = dutyUser;
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
