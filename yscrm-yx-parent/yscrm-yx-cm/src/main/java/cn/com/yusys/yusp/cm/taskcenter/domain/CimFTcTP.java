package cn.com.yusys.yusp.cm.taskcenter.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 商机信息表（CIMP_TC_TP_INFO）的持久化类
 * 
 */
@Entity
@Table(name = "CIMP_TC_TP_INFO")
public class CimFTcTP extends BaseDomain implements  Serializable
{
    private static final long serialVersionUID = 1L;

	@Column(name = "TASK_ID")
	private String taskId;
	@Column(name = "BIZ_SEQ_NO")
	private String bizSeqNo;
    

    public String getTaskId()
    {
        return this.taskId;
    }
    
    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }
    
    public String getBizSeqNo()
    {
        return this.bizSeqNo;
    }
    
    public void setBizSeqNo(String bizSeqNo)
    {
        this.bizSeqNo = bizSeqNo;
    }

    
}
