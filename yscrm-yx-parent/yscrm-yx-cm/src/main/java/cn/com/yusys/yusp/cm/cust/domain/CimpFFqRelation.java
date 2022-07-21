package cn.com.yusys.yusp.cm.cust.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

/**
 * @author 
 */
@Entity
@Table(name = "CIMP_F_FQ_RELATION")
public class CimpFFqRelation extends BaseDomain implements Serializable {
	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "JOIN_LEFT_TABLE")
    private long joinLeftTable;
	private long joinLeftName;

	@Column(name = "JOIN_RIGHT_TABLE")
    private long joinRightTable;
	private long joinRightName;

	@Column(name = "SS_COL_LEFT")
    private String ssColLeft;

	@Column(name = "JOIN_LEFT_ALIAS")
    private String joinLeftAlias;

	@Column(name = "JOIN_RIGHT_ALIAS")
    private String joinRightAlias;

	@Column(name = "JOIN_LEFT_COL")
    private long joinLeftCol;
	private long joinLeftColName;

	@Column(name = "JOIN_RIGHT_COL")
    private long joinRightCol;
	private long joinRightColName;

    private static final long serialVersionUID = 1L;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getJoinLeftTable() {
        return joinLeftTable;
    }

    public void setJoinLeftTable(long joinLeftTable) {
        this.joinLeftTable = joinLeftTable;
    }
    
    public long getJoinLeftName() {
        return joinLeftName;
    }

    public void setJoinLeftName(long joinLeftName) {
        this.joinLeftName = joinLeftName;
    }
    
    public long getJoinRightName() {
        return joinRightName;
    }

    public void setJoinRightName(long joinRightName) {
        this.joinRightName = joinRightName;
    }

    public long getJoinRightTable() {
        return joinRightTable;
    }
    
    public void setJoinRightTable(long joinRightTable) {
        this.joinRightTable = joinRightTable;
    }
    
   

    public String getSsColLeft() {
        return ssColLeft;
    }

    public void setSsColLeft(String ssColLeft) {
        this.ssColLeft = ssColLeft;
    }

    public String getJoinLeftAlias() {
        return joinLeftAlias;
    }

    public void setJoinLeftAlias(String joinLeftAlias) {
        this.joinLeftAlias = joinLeftAlias;
    }

    public String getJoinRightAlias() {
        return joinRightAlias;
    }

    public void setJoinRightAlias(String joinRightAlias) {
        this.joinRightAlias = joinRightAlias;
    }

    public long getJoinLeftCol() {
        return joinLeftCol;
    }

    public void setJoinLeftCol(long joinLeftCol) {
        this.joinLeftCol = joinLeftCol;
    }
    
    public long getJoinLeftColName() {
        return joinLeftColName;
    }

    public void setJoinLeftColName(long joinLeftColName) {
        this.joinLeftColName = joinLeftColName;
    }
    

    public long getJoinRightCol() {
        return joinRightCol;
    }

    public void setJoinRightCol(long joinRightCol) {
        this.joinRightCol = joinRightCol;
    }
    
    public long getJoinRightColName() {
        return joinRightColName;
    }

    public void setJoinRightColName(long joinRightColName) {
        this.joinRightColName = joinRightColName;
    }
    

}