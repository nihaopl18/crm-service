package cn.com.yusys.climp.qypool.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "LOY_SR_EXCH_SERIAL")
public class LoySrExchSerial extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ORDER_ID", unique = true, nullable = false, length = 50)
    private String  orderId;

    /**
     * 订单编号
     */
    @Column(name = "ORDER_No", unique = false, nullable = false, length = 50)
    private String  orderNo;

    /**
     * 客户号
     */
    @Column(name = "CUST_NO", unique = false, nullable = false, length = 50)
    private String  custNo;

    /**
     * 订单时间
     */
    @Column(name = "ORDER_DT", unique = false, nullable = true, length = 20)
    private Date orderDt;

    /**
     * 兑换渠道
     */
    @Column(name = "ORDER_CHANNEL", unique = false, nullable = true, length = 4)
    private String  orderChannel;

    /**
     * 订单消耗积分
     */
    @Column(name = "SUM_SCORE", unique = false, nullable = true, length = 20)
    private java.math.BigDecimal  sumScore;

    /**
     * 订单成本
     */
    @Column(name = "SUM_CHARGE", unique = false, nullable = true, length = 20)
    private java.math.BigDecimal  sumCharge;

    /**
     * 订单拓展属性
     */
    @Column(name = "EXTEND_DESC", unique = false, nullable = true, length = 20)
    private String  extendDesc;

    /**
     * 订单状态
     */
    @Column(name = "ORDER_STATUS", unique = false, nullable = true, length = 4)
    private String  orderStatus;

    /**
     * 审批状态
     */
    @Column(name = "APP_STATUS", unique = false, nullable = true, length = 4)
    private String  appStatus;

    /**
     * 积分明细id
     */
    @Column(name = "SCD_ID", unique = false, nullable = false, length = 50)
    private String  scdId;

    /**
     * 兑换用户编号
     */
    @Column(name = "OPERATOR_CODE", unique = false, nullable = false, length = 50)
    private String  operatorCode;

    /**
     * 兑换用户机构编号
     */
    @Column(name = "OPERATE_ORG", unique = false, nullable = false, length = 50)
    private String  operateOrg;

    /**
     * 审批用户编号
     */
    @Column(name = "APP_ACCOUNT", unique = false, nullable = false, length = 50)
    private String  appAccount;

    /**
     * 审批时间
     */
    @Column(name = "APP_DT", unique = false, nullable = false, length = 20)
    private Date  appDt;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? "" : orderNo;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? "" : custNo.trim();
    }

    public Date getOrderDt() {
        return orderDt;
    }

    public void setOrderDt(Date orderDt) {
        this.orderDt = orderDt;
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }

    public java.math.BigDecimal getSumScore() {
        return sumScore;
    }

    public void setSumScore(java.math.BigDecimal sumScore) {
        this.sumScore = sumScore == null ? BigDecimal.ZERO : sumScore;
    }

    public java.math.BigDecimal getSumCharge() {
        return sumCharge;
    }

    public void setSumCharge(java.math.BigDecimal sumCharge) {
        this.sumCharge = sumCharge == null ? BigDecimal.ZERO : sumCharge;
    }

    public String getExtendDesc() {
        return extendDesc;
    }

    public void setExtendDesc(String extendDesc) {
        this.extendDesc = extendDesc;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus == null ? "" : appStatus;
    }

    public String getScdId() {
        return scdId;
    }

    public void setScdId(String scdId) {
        this.scdId = scdId;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperateOrg() {
        return operateOrg;
    }

    public void setOperateOrg(String operateOrg) {
        this.operateOrg = operateOrg;
    }

    public String getAppAccount() {
        return appAccount;
    }

    public void setAppAccount(String appAccount) {
        this.appAccount = appAccount;
    }

    public Date getAppDt() {
        return appDt;
    }

    public void setAppDt(Date appDt) {
        this.appDt = appDt;
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
        LoySrExchSerial other = (LoySrExchSerial) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
                && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
                && (this.getCustNo() == null ? other.getCustNo() == null : this.getCustNo().equals(other.getCustNo()))
                && (this.getOrderChannel() == null ? other.getOrderChannel() == null : this.getOrderChannel().equals(other.getOrderChannel()))
                && (this.getExtendDesc() == null ? other.getExtendDesc() == null : this.getExtendDesc().equals(other.getExtendDesc()))
                && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
                && (this.getAppStatus() == null ? other.getAppStatus() == null : this.getAppStatus().equals(other.getAppStatus()))
                && (this.getScdId() == null ? other.getScdId() == null : this.getScdId().equals(other.getScdId()))
                && (this.getOperatorCode() == null ? other.getOperatorCode() == null : this.getOperatorCode().equals(other.getOperatorCode()))
                && (this.getOperateOrg() == null ? other.getOperateOrg() == null : this.getOperateOrg().equals(other.getOperateOrg()))
                && (this.getAppAccount() == null ? other.getAppAccount() == null : this.getAppAccount().equals(other.getAppAccount()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getCustNo() == null) ? 0 : getCustNo().hashCode());
        result = prime * result + ((getOrderChannel() == null) ? 0 : getOrderChannel().hashCode());
        result = prime * result + ((getExtendDesc() == null) ? 0 : getExtendDesc().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getAppStatus() == null) ? 0 : getAppStatus().hashCode());
        result = prime * result + ((getScdId() == null) ? 0 : getScdId().hashCode());
        result = prime * result + ((getOperatorCode() == null) ? 0 : getOperatorCode().hashCode());
        result = prime * result + ((getOperateOrg() == null) ? 0 : getOperateOrg().hashCode());
        result = prime * result + ((getAppAccount() == null) ? 0 : getAppAccount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", custNo=").append(custNo);
        sb.append(", orderChannel=").append(orderChannel);
        sb.append(", extendDesc=").append(extendDesc);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", appStatus=").append(appStatus);
        sb.append(", scdId=").append(scdId);
        sb.append(", operatorCode=").append(operatorCode);
        sb.append(", operateOrg=").append(operateOrg);
        sb.append(", appAccount=").append(appAccount);
        sb.append("]");
        return sb.toString();
    }
}
