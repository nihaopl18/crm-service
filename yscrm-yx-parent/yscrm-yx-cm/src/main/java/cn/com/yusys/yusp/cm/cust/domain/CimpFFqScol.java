package cn.com.yusys.yusp.cm.cust.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

/**
 * @author 
 */
@Entity
@Table(name = "CIMP_F_FQ_SCOL")
public class CimpFFqScol extends BaseDomain  implements Serializable {
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "SS_ID")
    private String ssId;

	@Column(name = "SS_COL_ORDER")
    private BigDecimal ssColOrder;

	@Column(name = "SS_COL_ITEM")
    private BigDecimal ssColItem;

	@Column(name = "SS_COL_OP")
    private String ssColOp;

	@Column(name = "SS_COL_VALUE")
    private String ssColValue;

	@Column(name = "SS_COL_JOIN")
    private String ssColJoin;

	@Column(name = "SS_COL_GORDER")
    private BigDecimal ssColGorder;

	@Column(name = "SS_COL_GJOIN")
    private String ssColGjoin;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSsId() {
        return ssId;
    }

    public void setSsId(String ssId) {
        this.ssId = ssId;
    }

    public BigDecimal getSsColOrder() {
        return ssColOrder;
    }

    public void setSsColOrder(BigDecimal ssColOrder) {
        this.ssColOrder = ssColOrder;
    }

    public BigDecimal getSsColItem() {
        return ssColItem;
    }

    public void setSsColItem(BigDecimal ssColItem) {
        this.ssColItem = ssColItem;
    }

    public String getSsColOp() {
        return ssColOp;
    }

    public void setSsColOp(String ssColOp) {
        this.ssColOp = ssColOp;
    }

    public String getSsColValue() {
        return ssColValue;
    }

    public void setSsColValue(String ssColValue) {
        this.ssColValue = ssColValue;
    }

    public String getSsColJoin() {
        return ssColJoin;
    }

    public void setSsColJoin(String ssColJoin) {
        this.ssColJoin = ssColJoin;
    }

    public BigDecimal getSsColGorder() {
        return ssColGorder;
    }

    public void setSsColGorder(BigDecimal ssColGorder) {
        this.ssColGorder = ssColGorder;
    }

    public String getSsColGjoin() {
        return ssColGjoin;
    }

    public void setSsColGjoin(String ssColGjoin) {
        this.ssColGjoin = ssColGjoin;
    }

}