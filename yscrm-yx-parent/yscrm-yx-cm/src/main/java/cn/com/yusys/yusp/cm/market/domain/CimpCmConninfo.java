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
 * 流程模板——节点连线实体
 * 
 */
@Entity
@Table(name="CIMP_CM_CONNINFO")
public class CimpCmConninfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Generated(GenerationType.UUID)
	@Column(name="CONN_ID")
	private String connId;

	private String connecter;

	@Column(name="END_POINTS")
	private String endPoints;

	@Column(name="OVERLAY_ARROW")
	private String overlayArrow;

	@Column(name="OVERLAY_LABEL")
	private String overlayLabel;

	@Column(name="SOURCE_ID")
	private String sourceId;

	@Column(name="TARGET_ID")
	private String targetId;

	@Column(name="TEMP_ID")
	private String tempId;

    public CimpCmConninfo() {
    }

	public String getConnId() {
		return this.connId;
	}

	public void setConnId(String connId) {
		this.connId = connId;
	}

	public String getConnecter() {
		return this.connecter;
	}

	public void setConnecter(String connecter) {
		this.connecter = connecter;
	}

	public String getEndPoints() {
		return this.endPoints;
	}

	public void setEndPoints(String endPoints) {
		this.endPoints = endPoints;
	}

	public String getOverlayArrow() {
		return this.overlayArrow;
	}

	public void setOverlayArrow(String overlayArrow) {
		this.overlayArrow = overlayArrow;
	}

	public String getOverlayLabel() {
		return this.overlayLabel;
	}

	public void setOverlayLabel(String overlayLabel) {
		this.overlayLabel = overlayLabel;
	}

	public String getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getTargetId() {
		return this.targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getTempId() {
		return this.tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

}