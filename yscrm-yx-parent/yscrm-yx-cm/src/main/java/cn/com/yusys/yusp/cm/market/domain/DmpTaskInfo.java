package cn.com.yusys.yusp.cm.market.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the DMP_TASK_INFO database table.
 * 
 */
@Entity
@Table(name="DMP_TASK_INFO")
public class DmpTaskInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="BEGIN_DATE")
	private BigDecimal beginDate;

	@Column(name="END_DATE")
	private BigDecimal endDate;

	@Column(name="FREQUNCY")
	private String frequncy;

	@Column(name="PRIORITY")
	private BigDecimal priority;

	@Column(name="TASK_COMMENT")
	private String taskComment;

	@Column(name="TASK_NAME")
	private String taskName;

    public DmpTaskInfo() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(BigDecimal beginDate) {
		this.beginDate = beginDate;
	}

	public BigDecimal getEndDate() {
		return this.endDate;
	}

	public void setEndDate(BigDecimal endDate) {
		this.endDate = endDate;
	}

	public String getFrequncy() {
		return this.frequncy;
	}

	public void setFrequncy(String frequncy) {
		this.frequncy = frequncy;
	}

	public BigDecimal getPriority() {
		return this.priority;
	}

	public void setPriority(BigDecimal priority) {
		this.priority = priority;
	}

	public String getTaskComment() {
		return this.taskComment;
	}

	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

}