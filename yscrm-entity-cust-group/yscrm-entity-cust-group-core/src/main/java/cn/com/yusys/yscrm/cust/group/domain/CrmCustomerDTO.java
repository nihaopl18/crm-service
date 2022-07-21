package cn.com.yusys.yscrm.cust.group.domain;


import groovy.transform.EqualsAndHashCode;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
public class CrmCustomerDTO implements Serializable {

    private static final long serialVersionUID = 1613148922215118848L;
    private int page;
    private int size = 10;
    private String sort;
    /**
     * 数字型查询集
     **/
    @ApiModelProperty(value = "数字型查询集")
    private String figureCode;

    /**
     * 字符型查询集
     **/
    @ApiModelProperty(value = "字符型查询集")
    private String characterCode;
    /**
     * 证件类型
     **/
    @ApiModelProperty(value = "证件类型")
    private String custType;
    /**
     * 证件号
     **/
    @ApiModelProperty(value = "证件号")
    private String certNo;
    /**
     * 卡号
     **/
    @ApiModelProperty(value = "卡号")
    private String cardNo;

    /**
     * 持有产品编号
     **/
    @ApiModelProperty(value = "持有产品编号")
    private String prodId;
    /**
     * 持有产品名称
     **/
    @ApiModelProperty(value = "持有产品名称")
    private String prodName;

    /**
     * AUM余额开始（万元）
     */
    @ApiModelProperty(value = "AUM余额开始（万元）")
    private String aumBalanceStart;

    /**
     * AUM余额截止（万元）
     */
    @ApiModelProperty(value = "AUM余额截止（万元）")
    private String aumBalanceEnd;

    /**
     * 客户等级
     */
    @ApiModelProperty(value = "客户等级")
    private String custGrade;

    /** 地区
     **/
    @ApiModelProperty(value = "地区")
    private String countAreaCd;

    /** 年龄区间
     **/
    @ApiModelProperty(value = "年龄区间")
    private String ageGroup;

    /** 近一月到期编号
     **/
    @ApiModelProperty(value = "近一月到期编号")
    private String expireNo;
    /** 近一月到期名称
     **/
    @ApiModelProperty(value = "近一月到期名称")
    private String expireName;

    /** 客户标签编码
     **/
    @ApiModelProperty(value = "客户标签编码")
    private String tagNo;

    /** 客户标签名称
     **/
    @ApiModelProperty(value = "客户标签名称")
    private String tagName;

    /** 登录人编码
     **/
    @ApiModelProperty(value = "登录人编码")
    private String _userCode;

    /** 登录人机构
     **/
    @ApiModelProperty(value = "登录人机构")
    private String _orgCode;
    /** 机构
     **/
    @ApiModelProperty(value = "机构")
    private String orgIdAuth;
    /** 权限
     **/
    @ApiModelProperty(value = "权限")
    private String dataAuth;
    /**
     * 查询条件
     */
    @ApiModelProperty(value = "查询条件")
    private String queryCriteria;

    /**
     * 查询类型（01 公共池 02 基础客户查询）
     */
    @ApiModelProperty(value = "查询类型（01 公共池 02 基础客户查询）")
    private String custQueryType;

    /**
     * 最新日期
     */
    private String dataDate;

    /**
     * 用戶類型
     */
    private String mgrType;
 /**
     * 兩地一本通客戶
     */
    private String isOnePaperCust;
    /**
     * 合格投資者认证
     */
    private String isAccreditedInvestor;

    /**
     * 理财客户
     */
    private String isFinCust;
    /**
     * 车位分期客户
     */
    private String isParkingInstallment;
    /**
     * 个人房产按揭贷款客户
     */
    private String isPerHouseLoan;

    /**
     * 法人房产按揭贷款客户
     */
    private String isLegalHouseLoan;

    /**
     * 信用卡客户
     */
    private String isCreditCardCust;

    /**
     * 近一个月到期定期存款
     */
    private String isfixedDepositMature;


    /**
     * 近一个月到期贷款
     */
    private String isLoanMature;

    /**
     * 近一个月到期理财产品
     */
    private String isFinMature;

    private String loanValue;
    private String loanValueValue;
    /**
     * 黑名单
     */
    private String isMktBlack;
    public String getCustQueryType() {
        return custQueryType;
    }

    public void setCustQueryType(String custQueryType) {
        this.custQueryType = custQueryType;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getFigureCode() {
        return figureCode;
    }

    public void setFigureCode(String figureCode) {
        this.figureCode = figureCode;
    }

    public String getCharacterCode() {
        return characterCode;
    }

    public void setCharacterCode(String characterCode) {
        this.characterCode = characterCode;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getAumBalanceStart() {
        return aumBalanceStart;
    }

    public void setAumBalanceStart(String aumBalanceStart) {
        this.aumBalanceStart = aumBalanceStart;
    }

    public String getAumBalanceEnd() {
        return aumBalanceEnd;
    }

    public void setAumBalanceEnd(String aumBalanceEnd) {
        this.aumBalanceEnd = aumBalanceEnd;
    }

    public String getCustGrade() {
        return custGrade;
    }

    public void setCustGrade(String custGrade) {
        this.custGrade = custGrade;
    }

    public String getCountAreaCd() {
        return countAreaCd;
    }

    public void setCountAreaCd(String countAreaCd) {
        this.countAreaCd = countAreaCd;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getExpireNo() {
        return expireNo;
    }

    public void setExpireNo(String expireNo) {
        this.expireNo = expireNo;
    }

    public String getExpireName() {
        return expireName;
    }

    public void setExpireName(String expireName) {
        this.expireName = expireName;
    }

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getOrgIdAuth() {
        return orgIdAuth;
    }

    public void setOrgIdAuth(String orgIdAuth) {
        this.orgIdAuth = orgIdAuth;
    }

    public String getDataAuth() {
        return dataAuth;
    }

    public void setDataAuth(String dataAuth) {
        this.dataAuth = dataAuth;
    }

    public String getQueryCriteria() {
        return queryCriteria;
    }

    public void setQueryCriteria(String queryCriteria) {
        this.queryCriteria = queryCriteria;
    }

    public void set_userCode(String _userCode) {
        this._userCode = _userCode;
    }

    public String get_orgCode() {
        return _orgCode;
    }

    public void set_orgCode(String _orgCode) {
        this._orgCode = _orgCode;
    }

    public String get_userCode() {
        return _userCode;
    }
    public void get_orgCode(String _orgCode) {
        this._orgCode = _orgCode;
    }

    public String getMgrType() {
        return mgrType;
    }

    public void setMgrType(String mgrType) {
        this.mgrType = mgrType;
    }

    public String getIsOnePaperCust() {
        return isOnePaperCust;
    }

    public void setIsOnePaperCust(String isOnePaperCust) {
        this.isOnePaperCust = isOnePaperCust;
    }

    public String getIsAccreditedInvestor() {
        return isAccreditedInvestor;
    }

    public void setIsAccreditedInvestor(String isAccreditedInvestor) {
        this.isAccreditedInvestor = isAccreditedInvestor;
    }

    public String getIsFinCust() {
        return isFinCust;
    }

    public void setIsFinCust(String isFinCust) {
        this.isFinCust = isFinCust;
    }

    public String getIsParkingInstallment() {
        return isParkingInstallment;
    }

    public void setIsParkingInstallment(String isParkingInstallment) {
        this.isParkingInstallment = isParkingInstallment;
    }

    public String getIsPerHouseLoan() {
        return isPerHouseLoan;
    }

    public void setIsPerHouseLoan(String isPerHouseLoan) {
        this.isPerHouseLoan = isPerHouseLoan;
    }

    public String getIsLegalHouseLoan() {
        return isLegalHouseLoan;
    }

    public void setIsLegalHouseLoan(String isLegalHouseLoan) {
        this.isLegalHouseLoan = isLegalHouseLoan;
    }

    public String getIsCreditCardCust() {
        return isCreditCardCust;
    }

    public void setIsCreditCardCust(String isCreditCardCust) {
        this.isCreditCardCust = isCreditCardCust;
    }

    public String getIsfixedDepositMature() {
        return isfixedDepositMature;
    }

    public void setIsfixedDepositMature(String isfixedDepositMature) {
        this.isfixedDepositMature = isfixedDepositMature;
    }

    public String getIsLoanMature() {
        return isLoanMature;
    }

    public void setIsLoanMature(String isLoanMature) {
        this.isLoanMature = isLoanMature;
    }

    public String getIsFinMature() {
        return isFinMature;
    }

    public void setIsFinMature(String isFinMature) {
        this.isFinMature = isFinMature;
    }

    public String getLoanValue() {
        return loanValue;
    }

    public void setLoanValue(String loanValue) {
        this.loanValue = loanValue;
    }

    public String getLoanValueValue() {
        return loanValueValue;
    }

    public void setLoanValueValue(String loanValueValue) {
        this.loanValueValue = loanValueValue;
    }

    public String getIsMktBlack() {
        return isMktBlack;
    }

    public void setIsMktBlack(String isMktBlack) {
        this.isMktBlack = isMktBlack;
    }
}
