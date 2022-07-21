package cn.com.yusys.yusp.cm.market.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the CIMP_CM_NODEINFO database table.
 * 
 */
@Entity
@Table(name="CIMP_CM_NODEINFO")
public class CimpCmNodeinfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ALLOW_LOOP_BACK")
	private String allowLoopBack;

	@Column(name="ASSEMBLY_ID")
	private String assemblyId;

	@Column(name="IS_SOURCE")
	private String isSource;

	@Column(name="IS_TARGET")
	private String isTarget;

	@Column(name="MAX_CONNECTIONS")
	private BigDecimal maxConnections;
	
	@Id
	@Generated(GenerationType.UUID)
	@Column(name="NODE_ID")
	private String nodeId;

	@Column(name="NODE_NAME")
	private String nodeName;

	@Column(name="NODE_OVERVIEW")
	private String nodeOverview;

	@Column(name="NODE_STATE")
	private String nodeState;

	@Column(name="OFFSET_X")
	private BigDecimal offsetX;

	@Column(name="OFFSET_Y")
	private BigDecimal offsetY;

	private String remark;

	@Column(name="SHOW_FORM")
	private String showForm;

	@Column(name="TEMP_ID")
	private String tempId;

    public CimpCmNodeinfo() {
    }

	public String getAllowLoopBack() {
		return this.allowLoopBack;
	}

	public void setAllowLoopBack(String allowLoopBack) {
		this.allowLoopBack = allowLoopBack;
	}

	public String getAssemblyId() {
		return this.assemblyId;
	}

	public void setAssemblyId(String assemblyId) {
		this.assemblyId = assemblyId;
	}

	public String getIsSource() {
		return this.isSource;
	}

	public void setIsSource(String isSource) {
		this.isSource = isSource;
	}

	public String getIsTarget() {
		return this.isTarget;
	}

	public void setIsTarget(String isTarget) {
		this.isTarget = isTarget;
	}

	public BigDecimal getMaxConnections() {
		return this.maxConnections;
	}

	public void setMaxConnections(BigDecimal maxConnections) {
		this.maxConnections = maxConnections;
	}

	public String getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return this.nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getNodeOverview() {
		return this.nodeOverview;
	}

	public void setNodeOverview(String nodeOverview) {
		this.nodeOverview = nodeOverview;
	}

	public String getNodeState() {
		return this.nodeState;
	}

	public void setNodeState(String nodeState) {
		this.nodeState = nodeState;
	}

	public BigDecimal getOffsetX() {
		return this.offsetX;
	}

	public void setOffsetX(BigDecimal offsetX) {
		this.offsetX = offsetX;
	}

	public BigDecimal getOffsetY() {
		return this.offsetY;
	}

	public void setOffsetY(BigDecimal offsetY) {
		this.offsetY = offsetY;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getShowForm() {
		return this.showForm;
	}

	public void setShowForm(String showForm) {
		this.showForm = showForm;
	}

	public String getTempId() {
		return this.tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	@Override
	public String toString() {
		return "CimpCmNodeinfo{" +
				"allowLoopBack='" + allowLoopBack + '\'' +
				", assemblyId='" + assemblyId + '\'' +
				", isSource='" + isSource + '\'' +
				", isTarget='" + isTarget + '\'' +
				", maxConnections=" + maxConnections +
				", nodeId='" + nodeId + '\'' +
				", nodeName='" + nodeName + '\'' +
				", nodeOverview='" + nodeOverview + '\'' +
				", nodeState='" + nodeState + '\'' +
				", offsetX=" + offsetX +
				", offsetY=" + offsetY +
				", remark='" + remark + '\'' +
				", showForm='" + showForm + '\'' +
				", tempId='" + tempId + '\'' +
				'}';
	}
}