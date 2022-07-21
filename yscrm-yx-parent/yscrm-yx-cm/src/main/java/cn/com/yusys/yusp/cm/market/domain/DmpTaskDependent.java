package cn.com.yusys.yusp.cm.market.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 流程任务依赖实体类
 **/
@Entity
@Table(name="DMP_TASK_DEPENDENT")
public class DmpTaskDependent {
	@Id
	@Column(name="ID")
	private long id;
	
	public long getId() { return id; }
	public void setId(long id) { this.id=id; }
	
	@Column(name="SERIAL_NUMBER")
	private long serialNumber;	
	
	public long getSerialNumber() { return serialNumber; }
	public void setSerialNumber(long serialNumber) { this.serialNumber=serialNumber; }
	
	@Column(name="DEPENDENT_TYPE")
	private String dependentType;
	
	public String getDependentType() { return dependentType; }
	public void setDependentType(String dependentType) { this.dependentType=dependentType; }
	
	@Column(name="DEPENDENT_CONTENT")
	private String dependentContent;
	
	public String getDependentContent() { return dependentContent; }
	public void setDependentContent(String dependentContent) { this.dependentContent=dependentContent; }
}
