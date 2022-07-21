package cn.com.yusys.yscrm.cust.person.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagLoanPawnInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-03-14 00:05:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_LOAN_PAWN_INFO")
public class AcrmFagLoanPawnInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 数据来源 **/
	@Id
	@Column(name = "SRC_NO")
	@Generated(GenerationType.UUID)
	private String srcNo;
	/** 担保品ID **/
	@Id
	@Column(name = "PAWN_ID")
	@Generated(GenerationType.UUID)
	private String pawnId;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 数据日期 **/
	
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 担保品编号 **/
	@Column(name = "GUAR_NO", unique = false, nullable = true, length = 40)
	private String guarNo;
	
	/** 担保合同编号 **/
	@Column(name = "GUAR_CONT_NO", unique = false, nullable = true, length = 40)
	private String guarContNo;
	
	/** 担保人客户编号 **/
	@Column(name = "GUAR_CUST_NO", unique = false, nullable = true, length = 32)
	private String guarCustNo;
	
	/** 担保人客户类型代码 **/
	@Column(name = "CUS_TYP_CD", unique = false, nullable = true, length = 8)
	private String cusTypCd;
	
	/** 担保人贷款卡号 **/
	@Column(name = "COM_LOAN_CARD_NO", unique = false, nullable = true, length = 32)
	private String comLoanCardNo;
	
	/** 抵押物名称 **/
	@Column(name = "PAWN_NM", unique = false, nullable = true, length = 200)
	private String pawnNm;
	
	/** 抵押物类型代码 **/
	@Column(name = "PAWN_TYPE_CD", unique = false, nullable = true, length = 20)
	private String pawnTypeCd;
	
	/** 抵押物类型细分代码 **/
	@Column(name = "PAWN_TYPE_SUB_CD", unique = false, nullable = true, length = 20)
	private String pawnTypeSubCd;
	
	/** 抵押物状态代码 **/
	@Column(name = "STATUS_CD", unique = false, nullable = true, length = 5)
	private String statusCd;
	
	/** 币种代码 **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 3)
	private String ccyCd;
	
	/** 评估方式代码 **/
	@Column(name = "EVAL_TYPE_CD", unique = false, nullable = true, length = 20)
	private String evalTypeCd;
	
	/** 评估人 **/
	@Column(name = "EVAL_PERSON", unique = false, nullable = true, length = 20)
	private String evalPerson;
	
	/** 评估机构名称 **/
	@Column(name = "EVAL_ORG", unique = false, nullable = true, length = 120)
	private String evalOrg;
	
	/** 评估价值 **/
	@Column(name = "EVAL_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal evalAmt;
	
	/** 我行确认价值 **/
	@Column(name = "BOOK_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal bookAmt;
	
	/** 评估日期 **/
	
	@Column(name = "EVAL_DT", unique = false, nullable = true, length = 7)
	private Date evalDt;
	
	/** 评估到期日期 **/
	
	@Column(name = "EVAL_END_DT", unique = false, nullable = true, length = 7)
	private Date evalEndDt;
	
	/** 我行已设定担保额 **/
	@Column(name = "OUR_SET_GUARANTY_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal ourSetGuarantyAmt;
	
	/** 权属证件类型代码 **/
	@Column(name = "RIGHT_CERT_TYPE_CD", unique = false, nullable = true, length = 5)
	private String rightCertTypeCd;
	
	/** 权属证件号 **/
	@Column(name = "RIGHT_CERT_NO", unique = false, nullable = true, length = 200)
	private String rightCertNo;
	
	/** 权属登记机关 **/
	@Column(name = "RIGHT_ORG", unique = false, nullable = true, length = 80)
	private String rightOrg;
	
	/** 入库时间 **/
	
	@Column(name = "IN_DT", unique = false, nullable = true, length = 7)
	private Date inDt;
	
	/** 出库时间 **/
	
	@Column(name = "OUT_DT", unique = false, nullable = true, length = 7)
	private Date outDt;
	
	/** 出入库状态代码 **/
	@Column(name = "DEPOT_STATUS_CD", unique = false, nullable = true, length = 5)
	private String depotStatusCd;
	
	/** 登记编号 **/
	@Column(name = "BOOK_NO", unique = false, nullable = true, length = 200)
	private String bookNo;
	
	/** 登记机构 **/
	@Column(name = "BOOK_ORG", unique = false, nullable = true, length = 200)
	private String bookOrg;
	
	/** 登记日期 **/
	
	@Column(name = "BOOK_DT", unique = false, nullable = true, length = 7)
	private Date bookDt;
	
	/** 登记到期日 **/
	
	@Column(name = "BOOK_END_DT", unique = false, nullable = true, length = 7)
	private Date bookEndDt;
	
	/** 共有人名称 **/
	@Column(name = "COMMON_OWNER_NM", unique = false, nullable = true, length = 100)
	private String commonOwnerNm;
	
	/** 承租人名称 **/
	@Column(name = "RENTER_NM", unique = false, nullable = true, length = 100)
	private String renterNm;
	
	/** 是否将全部财产抵押我行标志 **/
	@Column(name = "WHOLE_MORTAGAGE_OUR_IND", unique = false, nullable = true, length = 1)
	private String wholeMortagageOurInd;
	
	/** 是否所有权有争议标志 **/
	@Column(name = "PROPERTY_DISPUTED_IND", unique = false, nullable = true, length = 1)
	private String propertyDisputedInd;
	
	/** 是否租赁或已许可他人使用标志 **/
	@Column(name = "RENTAL_IND", unique = false, nullable = true, length = 1)
	private String rentalInd;
	
	/** 是否登记标志 **/
	@Column(name = "IF_BOOK", unique = false, nullable = true, length = 1)
	private String ifBook;
	
	/** 是否共有人标志 **/
	@Column(name = "COMMON_ASSETS_IND", unique = false, nullable = true, length = 1)
	private String commonAssetsInd;
	
	/** 抵押物备注 **/
	@Column(name = "REMARKS", unique = false, nullable = true, length = 250)
	private String remarks;
	
	/** 担保人客户名称 **/
	@Column(name = "GUAR_CUST_NM", unique = false, nullable = true, length = 200)
	private String guarCustNm;
	
	
	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
	}
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	
    /**
     * @return DataDate
     */	
	public String getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param srcNo
	 */
	public void setSrcNo(String srcNo) {
		this.srcNo = srcNo == null ? null : srcNo.trim();
	}
	
    /**
     * @return SrcNo
     */	
	public String getSrcNo() {
		return this.srcNo;
	}
	
	/**
	 * @param pawnId
	 */
	public void setPawnId(String pawnId) {
		this.pawnId = pawnId == null ? null : pawnId.trim();
	}
	
    /**
     * @return PawnId
     */	
	public String getPawnId() {
		return this.pawnId;
	}
	
	/**
	 * @param guarNo
	 */
	public void setGuarNo(String guarNo) {
		this.guarNo = guarNo == null ? null : guarNo.trim();
	}
	
    /**
     * @return GuarNo
     */	
	public String getGuarNo() {
		return this.guarNo;
	}
	
	/**
	 * @param guarContNo
	 */
	public void setGuarContNo(String guarContNo) {
		this.guarContNo = guarContNo == null ? null : guarContNo.trim();
	}
	
    /**
     * @return GuarContNo
     */	
	public String getGuarContNo() {
		return this.guarContNo;
	}
	
	/**
	 * @param guarCustNo
	 */
	public void setGuarCustNo(String guarCustNo) {
		this.guarCustNo = guarCustNo == null ? null : guarCustNo.trim();
	}
	
    /**
     * @return GuarCustNo
     */	
	public String getGuarCustNo() {
		return this.guarCustNo;
	}
	
	/**
	 * @param cusTypCd
	 */
	public void setCusTypCd(String cusTypCd) {
		this.cusTypCd = cusTypCd == null ? null : cusTypCd.trim();
	}
	
    /**
     * @return CusTypCd
     */	
	public String getCusTypCd() {
		return this.cusTypCd;
	}
	
	/**
	 * @param comLoanCardNo
	 */
	public void setComLoanCardNo(String comLoanCardNo) {
		this.comLoanCardNo = comLoanCardNo == null ? null : comLoanCardNo.trim();
	}
	
    /**
     * @return ComLoanCardNo
     */	
	public String getComLoanCardNo() {
		return this.comLoanCardNo;
	}
	
	/**
	 * @param pawnNm
	 */
	public void setPawnNm(String pawnNm) {
		this.pawnNm = pawnNm == null ? null : pawnNm.trim();
	}
	
    /**
     * @return PawnNm
     */	
	public String getPawnNm() {
		return this.pawnNm;
	}
	
	/**
	 * @param pawnTypeCd
	 */
	public void setPawnTypeCd(String pawnTypeCd) {
		this.pawnTypeCd = pawnTypeCd == null ? null : pawnTypeCd.trim();
	}
	
    /**
     * @return PawnTypeCd
     */	
	public String getPawnTypeCd() {
		return this.pawnTypeCd;
	}
	
	/**
	 * @param pawnTypeSubCd
	 */
	public void setPawnTypeSubCd(String pawnTypeSubCd) {
		this.pawnTypeSubCd = pawnTypeSubCd == null ? null : pawnTypeSubCd.trim();
	}
	
    /**
     * @return PawnTypeSubCd
     */	
	public String getPawnTypeSubCd() {
		return this.pawnTypeSubCd;
	}
	
	/**
	 * @param statusCd
	 */
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd == null ? null : statusCd.trim();
	}
	
    /**
     * @return StatusCd
     */	
	public String getStatusCd() {
		return this.statusCd;
	}
	
	/**
	 * @param ccyCd
	 */
	public void setCcyCd(String ccyCd) {
		this.ccyCd = ccyCd == null ? null : ccyCd.trim();
	}
	
    /**
     * @return CcyCd
     */	
	public String getCcyCd() {
		return this.ccyCd;
	}
	
	/**
	 * @param evalTypeCd
	 */
	public void setEvalTypeCd(String evalTypeCd) {
		this.evalTypeCd = evalTypeCd == null ? null : evalTypeCd.trim();
	}
	
    /**
     * @return EvalTypeCd
     */	
	public String getEvalTypeCd() {
		return this.evalTypeCd;
	}
	
	/**
	 * @param evalPerson
	 */
	public void setEvalPerson(String evalPerson) {
		this.evalPerson = evalPerson == null ? null : evalPerson.trim();
	}
	
    /**
     * @return EvalPerson
     */	
	public String getEvalPerson() {
		return this.evalPerson;
	}
	
	/**
	 * @param evalOrg
	 */
	public void setEvalOrg(String evalOrg) {
		this.evalOrg = evalOrg == null ? null : evalOrg.trim();
	}
	
    /**
     * @return EvalOrg
     */	
	public String getEvalOrg() {
		return this.evalOrg;
	}
	
	/**
	 * @param evalAmt
	 */
	public void setEvalAmt(java.math.BigDecimal evalAmt) {
		this.evalAmt = evalAmt;
	}
	
    /**
     * @return EvalAmt
     */	
	public java.math.BigDecimal getEvalAmt() {
		return this.evalAmt;
	}
	
	/**
	 * @param bookAmt
	 */
	public void setBookAmt(java.math.BigDecimal bookAmt) {
		this.bookAmt = bookAmt;
	}
	
    /**
     * @return BookAmt
     */	
	public java.math.BigDecimal getBookAmt() {
		return this.bookAmt;
	}
	
	/**
	 * @param evalDt
	 */
	public void setEvalDt(Date evalDt) {
		this.evalDt = evalDt;
	}
	
    /**
     * @return EvalDt
     */	
	public Date getEvalDt() {
		return this.evalDt;
	}
	
	/**
	 * @param evalEndDt
	 */
	public void setEvalEndDt(Date evalEndDt) {
		this.evalEndDt = evalEndDt;
	}
	
    /**
     * @return EvalEndDt
     */	
	public Date getEvalEndDt() {
		return this.evalEndDt;
	}
	
	/**
	 * @param ourSetGuarantyAmt
	 */
	public void setOurSetGuarantyAmt(java.math.BigDecimal ourSetGuarantyAmt) {
		this.ourSetGuarantyAmt = ourSetGuarantyAmt;
	}
	
    /**
     * @return OurSetGuarantyAmt
     */	
	public java.math.BigDecimal getOurSetGuarantyAmt() {
		return this.ourSetGuarantyAmt;
	}
	
	/**
	 * @param rightCertTypeCd
	 */
	public void setRightCertTypeCd(String rightCertTypeCd) {
		this.rightCertTypeCd = rightCertTypeCd == null ? null : rightCertTypeCd.trim();
	}
	
    /**
     * @return RightCertTypeCd
     */	
	public String getRightCertTypeCd() {
		return this.rightCertTypeCd;
	}
	
	/**
	 * @param rightCertNo
	 */
	public void setRightCertNo(String rightCertNo) {
		this.rightCertNo = rightCertNo == null ? null : rightCertNo.trim();
	}
	
    /**
     * @return RightCertNo
     */	
	public String getRightCertNo() {
		return this.rightCertNo;
	}
	
	/**
	 * @param rightOrg
	 */
	public void setRightOrg(String rightOrg) {
		this.rightOrg = rightOrg == null ? null : rightOrg.trim();
	}
	
    /**
     * @return RightOrg
     */	
	public String getRightOrg() {
		return this.rightOrg;
	}
	
	/**
	 * @param inDt
	 */
	public void setInDt(Date inDt) {
		this.inDt = inDt;
	}
	
    /**
     * @return InDt
     */	
	public Date getInDt() {
		return this.inDt;
	}
	
	/**
	 * @param outDt
	 */
	public void setOutDt(Date outDt) {
		this.outDt = outDt;
	}
	
    /**
     * @return OutDt
     */	
	public Date getOutDt() {
		return this.outDt;
	}
	
	/**
	 * @param depotStatusCd
	 */
	public void setDepotStatusCd(String depotStatusCd) {
		this.depotStatusCd = depotStatusCd == null ? null : depotStatusCd.trim();
	}
	
    /**
     * @return DepotStatusCd
     */	
	public String getDepotStatusCd() {
		return this.depotStatusCd;
	}
	
	/**
	 * @param bookNo
	 */
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo == null ? null : bookNo.trim();
	}
	
    /**
     * @return BookNo
     */	
	public String getBookNo() {
		return this.bookNo;
	}
	
	/**
	 * @param bookOrg
	 */
	public void setBookOrg(String bookOrg) {
		this.bookOrg = bookOrg == null ? null : bookOrg.trim();
	}
	
    /**
     * @return BookOrg
     */	
	public String getBookOrg() {
		return this.bookOrg;
	}
	
	/**
	 * @param bookDt
	 */
	public void setBookDt(Date bookDt) {
		this.bookDt = bookDt;
	}
	
    /**
     * @return BookDt
     */	
	public Date getBookDt() {
		return this.bookDt;
	}
	
	/**
	 * @param bookEndDt
	 */
	public void setBookEndDt(Date bookEndDt) {
		this.bookEndDt = bookEndDt;
	}
	
    /**
     * @return BookEndDt
     */	
	public Date getBookEndDt() {
		return this.bookEndDt;
	}
	
	/**
	 * @param commonOwnerNm
	 */
	public void setCommonOwnerNm(String commonOwnerNm) {
		this.commonOwnerNm = commonOwnerNm == null ? null : commonOwnerNm.trim();
	}
	
    /**
     * @return CommonOwnerNm
     */	
	public String getCommonOwnerNm() {
		return this.commonOwnerNm;
	}
	
	/**
	 * @param renterNm
	 */
	public void setRenterNm(String renterNm) {
		this.renterNm = renterNm == null ? null : renterNm.trim();
	}
	
    /**
     * @return RenterNm
     */	
	public String getRenterNm() {
		return this.renterNm;
	}
	
	/**
	 * @param wholeMortagageOurInd
	 */
	public void setWholeMortagageOurInd(String wholeMortagageOurInd) {
		this.wholeMortagageOurInd = wholeMortagageOurInd == null ? null : wholeMortagageOurInd.trim();
	}
	
    /**
     * @return WholeMortagageOurInd
     */	
	public String getWholeMortagageOurInd() {
		return this.wholeMortagageOurInd;
	}
	
	/**
	 * @param propertyDisputedInd
	 */
	public void setPropertyDisputedInd(String propertyDisputedInd) {
		this.propertyDisputedInd = propertyDisputedInd == null ? null : propertyDisputedInd.trim();
	}
	
    /**
     * @return PropertyDisputedInd
     */	
	public String getPropertyDisputedInd() {
		return this.propertyDisputedInd;
	}
	
	/**
	 * @param rentalInd
	 */
	public void setRentalInd(String rentalInd) {
		this.rentalInd = rentalInd == null ? null : rentalInd.trim();
	}
	
    /**
     * @return RentalInd
     */	
	public String getRentalInd() {
		return this.rentalInd;
	}
	
	/**
	 * @param ifBook
	 */
	public void setIfBook(String ifBook) {
		this.ifBook = ifBook == null ? null : ifBook.trim();
	}
	
    /**
     * @return IfBook
     */	
	public String getIfBook() {
		return this.ifBook;
	}
	
	/**
	 * @param commonAssetsInd
	 */
	public void setCommonAssetsInd(String commonAssetsInd) {
		this.commonAssetsInd = commonAssetsInd == null ? null : commonAssetsInd.trim();
	}
	
    /**
     * @return CommonAssetsInd
     */	
	public String getCommonAssetsInd() {
		return this.commonAssetsInd;
	}
	
	/**
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}
	
    /**
     * @return Remarks
     */	
	public String getRemarks() {
		return this.remarks;
	}
	
	/**
	 * @param guarCustNm
	 */
	public void setGuarCustNm(String guarCustNm) {
		this.guarCustNm = guarCustNm == null ? null : guarCustNm.trim();
	}
	
    /**
     * @return GuarCustNm
     */	
	public String getGuarCustNm() {
		return this.guarCustNm;
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
        AcrmFagLoanPawnInfo other = (AcrmFagLoanPawnInfo) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getSrcNo() == null ? other.getSrcNo() == null : this.getSrcNo().equals(other.getSrcNo()))
        	&& (this.getPawnId() == null ? other.getPawnId() == null : this.getPawnId().equals(other.getPawnId()))
        	&& (this.getGuarNo() == null ? other.getGuarNo() == null : this.getGuarNo().equals(other.getGuarNo()))
        	&& (this.getGuarContNo() == null ? other.getGuarContNo() == null : this.getGuarContNo().equals(other.getGuarContNo()))
        	&& (this.getGuarCustNo() == null ? other.getGuarCustNo() == null : this.getGuarCustNo().equals(other.getGuarCustNo()))
        	&& (this.getCusTypCd() == null ? other.getCusTypCd() == null : this.getCusTypCd().equals(other.getCusTypCd()))
        	&& (this.getComLoanCardNo() == null ? other.getComLoanCardNo() == null : this.getComLoanCardNo().equals(other.getComLoanCardNo()))
        	&& (this.getPawnNm() == null ? other.getPawnNm() == null : this.getPawnNm().equals(other.getPawnNm()))
        	&& (this.getPawnTypeCd() == null ? other.getPawnTypeCd() == null : this.getPawnTypeCd().equals(other.getPawnTypeCd()))
        	&& (this.getPawnTypeSubCd() == null ? other.getPawnTypeSubCd() == null : this.getPawnTypeSubCd().equals(other.getPawnTypeSubCd()))
        	&& (this.getStatusCd() == null ? other.getStatusCd() == null : this.getStatusCd().equals(other.getStatusCd()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))
        	&& (this.getEvalTypeCd() == null ? other.getEvalTypeCd() == null : this.getEvalTypeCd().equals(other.getEvalTypeCd()))
        	&& (this.getEvalPerson() == null ? other.getEvalPerson() == null : this.getEvalPerson().equals(other.getEvalPerson()))
        	&& (this.getEvalOrg() == null ? other.getEvalOrg() == null : this.getEvalOrg().equals(other.getEvalOrg()))
                                                	&& (this.getRightCertTypeCd() == null ? other.getRightCertTypeCd() == null : this.getRightCertTypeCd().equals(other.getRightCertTypeCd()))
        	&& (this.getRightCertNo() == null ? other.getRightCertNo() == null : this.getRightCertNo().equals(other.getRightCertNo()))
        	&& (this.getRightOrg() == null ? other.getRightOrg() == null : this.getRightOrg().equals(other.getRightOrg()))
                        	&& (this.getDepotStatusCd() == null ? other.getDepotStatusCd() == null : this.getDepotStatusCd().equals(other.getDepotStatusCd()))
        	&& (this.getBookNo() == null ? other.getBookNo() == null : this.getBookNo().equals(other.getBookNo()))
        	&& (this.getBookOrg() == null ? other.getBookOrg() == null : this.getBookOrg().equals(other.getBookOrg()))
                        	&& (this.getCommonOwnerNm() == null ? other.getCommonOwnerNm() == null : this.getCommonOwnerNm().equals(other.getCommonOwnerNm()))
        	&& (this.getRenterNm() == null ? other.getRenterNm() == null : this.getRenterNm().equals(other.getRenterNm()))
        	&& (this.getWholeMortagageOurInd() == null ? other.getWholeMortagageOurInd() == null : this.getWholeMortagageOurInd().equals(other.getWholeMortagageOurInd()))
        	&& (this.getPropertyDisputedInd() == null ? other.getPropertyDisputedInd() == null : this.getPropertyDisputedInd().equals(other.getPropertyDisputedInd()))
        	&& (this.getRentalInd() == null ? other.getRentalInd() == null : this.getRentalInd().equals(other.getRentalInd()))
        	&& (this.getIfBook() == null ? other.getIfBook() == null : this.getIfBook().equals(other.getIfBook()))
        	&& (this.getCommonAssetsInd() == null ? other.getCommonAssetsInd() == null : this.getCommonAssetsInd().equals(other.getCommonAssetsInd()))
        	&& (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
        	&& (this.getGuarCustNm() == null ? other.getGuarCustNm() == null : this.getGuarCustNm().equals(other.getGuarCustNm()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getSrcNo() == null) ? 0 : getSrcNo().hashCode());
        result = prime * result + ((getPawnId() == null) ? 0 : getPawnId().hashCode());
        result = prime * result + ((getGuarNo() == null) ? 0 : getGuarNo().hashCode());
        result = prime * result + ((getGuarContNo() == null) ? 0 : getGuarContNo().hashCode());
        result = prime * result + ((getGuarCustNo() == null) ? 0 : getGuarCustNo().hashCode());
        result = prime * result + ((getCusTypCd() == null) ? 0 : getCusTypCd().hashCode());
        result = prime * result + ((getComLoanCardNo() == null) ? 0 : getComLoanCardNo().hashCode());
        result = prime * result + ((getPawnNm() == null) ? 0 : getPawnNm().hashCode());
        result = prime * result + ((getPawnTypeCd() == null) ? 0 : getPawnTypeCd().hashCode());
        result = prime * result + ((getPawnTypeSubCd() == null) ? 0 : getPawnTypeSubCd().hashCode());
        result = prime * result + ((getStatusCd() == null) ? 0 : getStatusCd().hashCode());
        result = prime * result + ((getCcyCd() == null) ? 0 : getCcyCd().hashCode());
        result = prime * result + ((getEvalTypeCd() == null) ? 0 : getEvalTypeCd().hashCode());
        result = prime * result + ((getEvalPerson() == null) ? 0 : getEvalPerson().hashCode());
        result = prime * result + ((getEvalOrg() == null) ? 0 : getEvalOrg().hashCode());
        result = prime * result + ((getRightCertTypeCd() == null) ? 0 : getRightCertTypeCd().hashCode());
        result = prime * result + ((getRightCertNo() == null) ? 0 : getRightCertNo().hashCode());
        result = prime * result + ((getRightOrg() == null) ? 0 : getRightOrg().hashCode());
        result = prime * result + ((getDepotStatusCd() == null) ? 0 : getDepotStatusCd().hashCode());
        result = prime * result + ((getBookNo() == null) ? 0 : getBookNo().hashCode());
        result = prime * result + ((getBookOrg() == null) ? 0 : getBookOrg().hashCode());
        result = prime * result + ((getCommonOwnerNm() == null) ? 0 : getCommonOwnerNm().hashCode());
        result = prime * result + ((getRenterNm() == null) ? 0 : getRenterNm().hashCode());
        result = prime * result + ((getWholeMortagageOurInd() == null) ? 0 : getWholeMortagageOurInd().hashCode());
        result = prime * result + ((getPropertyDisputedInd() == null) ? 0 : getPropertyDisputedInd().hashCode());
        result = prime * result + ((getRentalInd() == null) ? 0 : getRentalInd().hashCode());
        result = prime * result + ((getIfBook() == null) ? 0 : getIfBook().hashCode());
        result = prime * result + ((getCommonAssetsInd() == null) ? 0 : getCommonAssetsInd().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getGuarCustNm() == null) ? 0 : getGuarCustNm().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append("]");
        return sb.toString();
    }
}