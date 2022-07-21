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
 * The persistent class for the CIMP_CM_ASSEMINFO database table.
 * 
 */
@Entity
@Table(name="CIMP_CM_ASSEMINFO")
public class CimpCmAsseminfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ASSEMBLY_ANA_METHOD")
	private String assemblyAnaMethod;

	@Id
	@Generated(GenerationType.UUID)
	@Column(name="ASSEMBLY_ID")
	private String assemblyId;

	@Column(name="ASSEMBLY_NAME")
	private String assemblyName;

	@Column(name="ASSEMBLY_STYLE")
	private String assemblyStyle;

	@Column(name="ASSEMBLY_TYPE")
	private String assemblyType;

	@Column(name="CLASS_ID")
	private String classId;

	@Column(name="DATA_TYPE")
	private String dataType;

	@Column(name="SHOW_FORM")
	private String showForm;
	
	@Column(name="SUIT_SCENE")
	private String suitScene;
	
    public CimpCmAsseminfo() {
    }

	public String getAssemblyAnaMethod() {
		return this.assemblyAnaMethod;
	}

	public void setAssemblyAnaMethod(String assemblyAnaMethod) {
		this.assemblyAnaMethod = assemblyAnaMethod;
	}

	public String getAssemblyId() {
		return this.assemblyId;
	}

	public void setAssemblyId(String assemblyId) {
		this.assemblyId = assemblyId;
	}

	public String getAssemblyName() {
		return this.assemblyName;
	}

	public void setAssemblyName(String assemblyName) {
		this.assemblyName = assemblyName;
	}

	public String getAssemblyStyle() {
		return this.assemblyStyle;
	}

	public void setAssemblyStyle(String assemblyStyle) {
		this.assemblyStyle = assemblyStyle;
	}

	public String getAssemblyType() {
		return this.assemblyType;
	}

	public void setAssemblyType(String assemblyType) {
		this.assemblyType = assemblyType;
	}

	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getShowForm() {
		return this.showForm;
	}

	public void setShowForm(String showForm) {
		this.showForm = showForm;
	}

	public String getSuitScene() {
		return suitScene;
	}

	public void setSuitScene(String suitScene) {
		this.suitScene = suitScene;
	}
	
	

}