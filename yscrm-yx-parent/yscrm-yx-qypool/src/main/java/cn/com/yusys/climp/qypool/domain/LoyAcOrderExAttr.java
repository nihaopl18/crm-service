package cn.com.yusys.climp.qypool.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: LoyAcScoreAccount
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: ZZZ
 * @创建时间: 2019-01-03 17:27:51
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_AC_ORDER_EX_ATTR")
public class LoyAcOrderExAttr  extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID", unique = true, nullable = false, length = 50)
    private String id;

    @Column(name = "ATTR_ID", unique = false, nullable = false, length = 50)
    private String  attrId;
    /**
     * 订单编号
     */
    @Column(name = "ORDER_NO", unique = false, nullable = false, length = 50)
    private String  orderNo;

    /**
     * 属性详情
     */
    @Column(name = "ATTR_DESC", unique = false, nullable = true, length = 3000)
    private String  attrDesc;

    /**
     * 属性名称
     */
    @Column(name = "ATTR_NAME", unique = false, nullable = true, length = 100)
    private String  attrName;

    /**
     * 备注
     */
    @Column(name = "ATTR_REMARK", unique = false, nullable = true, length = 3000)
    private String  attrRemark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId == null ? "" : attrId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? "" : orderNo;
    }

    public String getAttrDesc() {
        return attrDesc;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc == null ? "" : attrDesc;
    }

    public String getAttrName() {
        return attrName;
    }

    public String getAttrRemark() {
        return attrRemark;
    }

    public void setAttrRemark(String attrRemark) {
        this.attrRemark = attrRemark == null ? "" : attrRemark;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? "" : attrName;
    }
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LoyAcOrderExAttr other = (LoyAcOrderExAttr) that;
        return (this.getAttrDesc() == null ? other.getAttrDesc() == null : this.getAttrDesc().equals(other.getAttrDesc()))
                && (this.getAttrId() == null ? other.getAttrId() == null : this.getAttrId().equals(other.getAttrId()))
                && (this.getAttrName() == null ? other.getAttrName() == null : this.getAttrName().equals(other.getAttrName()))
                && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getAttrDesc() == null) ? 0 : getAttrDesc().hashCode());
        result = prime * result + ((getAttrName() == null) ? 0 : getAttrName().hashCode());
        result = prime * result + ((getAttrId() == null) ? 0 : getAttrId().hashCode());

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(attrDesc);
        sb.append(", orderCode=").append(attrId);
        sb.append(", ecifCustId=").append(attrName);
        sb.append(", extendDesc=").append(orderNo);
        sb.append("]");
        return sb.toString();
    }
}
