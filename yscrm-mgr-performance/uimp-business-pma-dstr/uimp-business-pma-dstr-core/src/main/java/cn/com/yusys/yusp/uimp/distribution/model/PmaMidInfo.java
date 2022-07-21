package cn.com.yusys.yusp.uimp.distribution.model;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Id;
import java.util.List;

public class PmaMidInfo {

    @Id
    @Generated(GenerationType.UUID)
    private String id;

    private String transactionMark;

    private String avg;

    private String orgName;

    private String orgId;

    private String distributionMode;

    private String dstrSts;

    private String acctNo;

    private String transactionDate;

    private String startDate;

    private String endDate;

    private String transactionAmount;

    private String serviceCharge;

    private String customerNumber;

    private String customerName;

    private String productNumber;

    private String productName;

    private String confirmationDate;

    private String managerId;

    private String managerName;

    private String bussType;

    private String applySts;

    private List<PmaMidDistribute> pmaMidDistributeList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTransactionMark() {
        return transactionMark;
    }

    public void setTransactionMark(String transactionMark) {
        this.transactionMark = transactionMark == null ? null : transactionMark.trim();
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg == null ? null : avg.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getDistributionMode() {
        return distributionMode;
    }

    public void setDistributionMode(String distributionMode) {
        this.distributionMode = distributionMode == null ? null : distributionMode.trim();
    }

    public String getDstrSts() {
        return dstrSts;
    }

    public void setDstrSts(String dstrSts) {
        this.dstrSts = dstrSts == null ? null : dstrSts.trim();
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate == null ? null : transactionDate.trim();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount == null ? null : transactionAmount.trim();
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge == null ? null : serviceCharge.trim();
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber == null ? null : customerNumber.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber == null ? null : productNumber.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(String confirmationDate) {
        this.confirmationDate = confirmationDate == null ? null : confirmationDate.trim();
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getBussType() {
        return bussType;
    }

    public void setBussType(String bussType) {
        this.bussType = bussType;
    }

    public String getApplySts() {
        return applySts;
    }

    public void setApplySts(String applySts) {
        this.applySts = applySts;
    }

    public List<PmaMidDistribute> getPmaMidDistributeList() {
        return pmaMidDistributeList;
    }

    public void setPmaMidDistributeList(List<PmaMidDistribute> pmaMidDistributeList) {
        this.pmaMidDistributeList = pmaMidDistributeList;
    }
}