package cn.com.yusys.yusp.cm.market.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the CIMP_CM_NODES_DISPLAY database table.
 * 
 */
@Entity
@Table(name="CIMP_CM_NODES_DISPLAY")
public class CimpCmNodesDisplay extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Generated(GenerationType.UUID)
	@Column(name="FORM_ID")
	private String formId;

	@Column(name="NODE_ID")
	private String nodeId;

	@Column(name="SHOW_FORM")
	private String showForm;

    public CimpCmNodesDisplay() {
    }

	public String getFormId() {
		return this.formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getShowForm() {
		return this.showForm;
	}

	public void setShowForm(String showForm) {
		this.showForm = showForm;
	}

}