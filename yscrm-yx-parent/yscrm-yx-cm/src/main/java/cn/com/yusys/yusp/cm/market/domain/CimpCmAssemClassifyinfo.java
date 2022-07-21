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
 * The persistent class for the CIMP_CM_ASSEM_CLASSIFYINFO database table.
 * 
 */
@Entity
@Table(name="CIMP_CM_ASSEM_CLASSIFYINFO")
public class CimpCmAssemClassifyinfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CLASS_COLOR")
	private String classColor;

	@Column(name="CLASS_ICON")
	private String classIcon;
	
	@Id
	@Generated(GenerationType.UUID)
	@Column(name="CLASS_ID")
	private String classId;

	@Column(name="CLASS_NAME")
	private String className;

	@Column(name="CLASS_STYLE")
	private String classStyle;

    public CimpCmAssemClassifyinfo() {
    }

	public String getClassColor() {
		return this.classColor;
	}

	public void setClassColor(String classColor) {
		this.classColor = classColor;
	}

	public String getClassIcon() {
		return this.classIcon;
	}

	public void setClassIcon(String classIcon) {
		this.classIcon = classIcon;
	}

	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassStyle() {
		return this.classStyle;
	}

	public void setClassStyle(String classStyle) {
		this.classStyle = classStyle;
	}

}