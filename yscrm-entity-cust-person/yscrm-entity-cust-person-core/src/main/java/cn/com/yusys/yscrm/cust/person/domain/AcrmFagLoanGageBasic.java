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
 * @类名称: AcrmFagLoanGageBasic
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-03-14 00:22:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_LOAN_GAGE_BASIC")
public class AcrmFagLoanGageBasic extends BaseDomain implements Serializable{
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
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 担保人客户类型代码 **/
	@Column(name = "CUS_TYP_CD", unique = false, nullable = true, length = 8)
	private String cusTypCd;
	
	/** 担保人贷款卡号 **/
	@Column(name = "COM_LOAN_CARD_NO", unique = false, nullable = true, length = 32)
	private String comLoanCardNo;
	
	/** 质押物名称 **/
	@Column(name = "GAGE_NM", unique = false, nullable = true, length = 120)
	private String gageNm;
	
	/** 质押物类型代码 **/
	@Column(name = "GAGE_TYPE_CD", unique = false, nullable = true, length = 30)
	private String gageTypeCd;
	
	/** 质押物类型细分代码 **/
	@Column(name = "GAGE_TYPE_SUB_CD", unique = false, nullable = true, length = 20)
	private String gageTypeSubCd;
	
	/** 质押物状态代码 **/
	@Column(name = "STATUS_CD", unique = false, nullable = true, length = 30)
	private String statusCd;
	
	/** 币种代码 **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 3)
	private String ccyCd;
	
	/** 评估方式代码 **/
	@Column(name = "EVAL_CD", unique = false, nullable = true, length = 5)
	private String evalCd;
	
	/** 评估人 **/
	@Column(name = "EVAL_PERSON", unique = false, nullable = true, length = 20)
	private String evalPerson;
	
	/** 评估机构 **/
	@Column(name = "EVAL_ORG", unique = false, nullable = true, length = 120)
	private String evalOrg;
	
	/** 评估价值 **/
	@Column(name = "EVAL_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal evalAmt;
	
	/** 我行确认价值 **/
	@Column(name = "BOOK_EVAL_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal bookEvalAmt;
	
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
	@Column(name = "RIGHT_CERT_TYPE_CD", unique = false, nullable = true, length = 20)
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
	
	/** 创建用户编号 **/
	@Column(name = "CREATE_USER_NO", unique = false, nullable = true, length = 20)
	private String createUserNo;
	
	/** 创建机构编号 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 20)
	private String createOrg;
	
	/** 创建日期 **/
	
	@Column(name = "CREATE_DT", unique = false, nullable = true, length = 7)
	private Date createDt;
	
	/** 登记期限 **/
	@Column(name = "BOOK_TERM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal bookTerm;
	
	/** 共有人名称 **/
	@Column(name = "REF_NM", unique = false, nullable = true, length = 250)
	private String refNm;
	
	/** 共同财产标志 **/
	@Column(name = "FLAG1_IND", unique = false, nullable = true, length = 1)
	private String flag1Ind;
	
	/** 保全资产标志 **/
	@Column(name = "FLAG2_IND", unique = false, nullable = true, length = 1)
	private String flag2Ind;
	
	/** 公证标志 **/
	@Column(name = "FLAG3_IND", unique = false, nullable = true, length = 1)
	private String flag3Ind;
	
	/** 监管标志 **/
	@Column(name = "FLAG4_IND", unique = false, nullable = true, length = 1)
	private String flag4Ind;
	
	/** 登记标志 **/
	@Column(name = "FLAG5_IND", unique = false, nullable = true, length = 1)
	private String flag5Ind;
	
	/** 质押物备注 **/
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
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId == null ? null : custId.trim();
	}
	
    /**
     * @return CustId
     */	
	public String getCustId() {
		return this.custId;
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
	 * @param gageNm
	 */
	public void setGageNm(String gageNm) {
		this.gageNm = gageNm == null ? null : gageNm.trim();
	}
	
    /**
     * @return GageNm
     */	
	public String getGageNm() {
		return this.gageNm;
	}
	
	/**
	 * @param gageTypeCd
	 */
	public void setGageTypeCd(String gageTypeCd) {
		this.gageTypeCd = gageTypeCd == null ? null : gageTypeCd.trim();
	}
	
    /**
     * @return GageTypeCd
     */	
	public String getGageTypeCd() {
		return this.gageTypeCd;
	}
	
	/**
	 * @param gageTypeSubCd
	 */
	public void setGageTypeSubCd(String gageTypeSubCd) {
		this.gageTypeSubCd = gageTypeSubCd == null ? null : gageTypeSubCd.trim();
	}
	
    /**
     * @return GageTypeSubCd
     */	
	public String getGageTypeSubCd() {
		return this.gageTypeSubCd;
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
	 * @param evalCd
	 */
	public void setEvalCd(String evalCd) {
		this.evalCd = evalCd == null ? null : evalCd.trim();
	}
	
    /**
     * @return EvalCd
     */	
	public String getEvalCd() {
		return this.evalCd;
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
	 * @param bookEvalAmt
	 */
	public void setBookEvalAmt(java.math.BigDecimal bookEvalAmt) {
		this.bookEvalAmt = bookEvalAmt;
	}
	
    /**
     * @return BookEvalAmt
     */	
	public java.math.BigDecimal getBookEvalAmt() {
		return this.bookEvalAmt;
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
	 * @param createUserNo
	 */
	public void setCreateUserNo(String createUserNo) {
		this.createUserNo = createUserNo == null ? null : createUserNo.trim();
	}
	
    /**
     * @return CreateUserNo
     */	
	public String getCreateUserNo() {
		return this.createUserNo;
	}
	
	/**
	 * @param createOrg
	 */
	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg == null ? null : createOrg.trim();
	}
	
    /**
     * @return CreateOrg
     */	
	public String getCreateOrg() {
		return this.createOrg;
	}
	
	/**
	 * @param createDt
	 */
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
    /**
     * @return CreateDt
     */	
	public Date getCreateDt() {
		return this.createDt;
	}
	
	/**
	 * @param bookTerm
	 */
	public void setBookTerm(java.math.BigDecimal bookTerm) {
		this.bookTerm = bookTerm;
	}
	
    /**
     * @return BookTerm
     */	
	public java.math.BigDecimal getBookTerm() {
		return this.bookTerm;
	}
	
	/**
	 * @param refNm
	 */
	public void setRefNm(String refNm) {
		this.refNm = refNm == null ? null : refNm.trim();
	}
	
    /**
     * @return RefNm
     */	
	public String getRefNm() {
		return this.refNm;
	}
	
	/**
	 * @param flag1Ind
	 */
	public void setFlag1Ind(String flag1Ind) {
		this.flag1Ind = flag1Ind == null ? null : flag1Ind.trim();
	}
	
    /**
     * @return Flag1Ind
     */	
	public String getFlag1Ind() {
		return this.flag1Ind;
	}
	
	/**
	 * @param flag2Ind
	 */
	public void setFlag2Ind(String flag2Ind) {
		this.flag2Ind = flag2Ind == null ? null : flag2Ind.trim();
	}
	
    /**
     * @return Flag2Ind
     */	
	public String getFlag2Ind() {
		return this.flag2Ind;
	}
	
	/**
	 * @param flag3Ind
	 */
	public void setFlag3Ind(String flag3Ind) {
		this.flag3Ind = flag3Ind == null ? null : flag3Ind.trim();
	}
	
    /**
     * @return Flag3Ind
     */	
	public String getFlag3Ind() {
		return this.flag3Ind;
	}
	
	/**
	 * @param flag4Ind
	 */
	public void setFlag4Ind(String flag4Ind) {
		this.flag4Ind = flag4Ind == null ? null : flag4Ind.trim();
	}
	
    /**
     * @return Flag4Ind
     */	
	public String getFlag4Ind() {
		return this.flag4Ind;
	}
	
	/**
	 * @param flag5Ind
	 */
	public void setFlag5Ind(String flag5Ind) {
		this.flag5Ind = flag5Ind == null ? null : flag5Ind.trim();
	}
	
    /**
     * @return Flag5Ind
     */	
	public String getFlag5Ind() {
		return this.flag5Ind;
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
        AcrmFagLoanGageBasic other = (AcrmFagLoanGageBasic) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getSrcNo() == null ? other.getSrcNo() == null : this.getSrcNo().equals(other.getSrcNo()))
        	&& (this.getPawnId() == null ? other.getPawnId() == null : this.getPawnId().equals(other.getPawnId()))
        	&& (this.getGuarNo() == null ? other.getGuarNo() == null : this.getGuarNo().equals(other.getGuarNo()))
        	&& (this.getGuarContNo() == null ? other.getGuarContNo() == null : this.getGuarContNo().equals(other.getGuarContNo()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCusTypCd() == null ? other.getCusTypCd() == null : this.getCusTypCd().equals(other.getCusTypCd()))
        	&& (this.getComLoanCardNo() == null ? other.getComLoanCardNo() == null : this.getComLoanCardNo().equals(other.getComLoanCardNo()))
        	&& (this.getGageNm() == null ? other.getGageNm() == null : this.getGageNm().equals(other.getGageNm()))
        	&& (this.getGageTypeCd() == null ? other.getGageTypeCd() == null : this.getGageTypeCd().equals(other.getGageTypeCd()))
        	&& (this.getGageTypeSubCd() == null ? other.getGageTypeSubCd() == null : this.getGageTypeSubCd().equals(other.getGageTypeSubCd()))
        	&& (this.getStatusCd() == null ? other.getStatusCd() == null : this.getStatusCd().equals(other.getStatusCd()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))
        	&& (this.getEvalCd() == null ? other.getEvalCd() == null : this.getEvalCd().equals(other.getEvalCd()))
        	&& (this.getEvalPerson() == null ? other.getEvalPerson() == null : this.getEvalPerson().equals(other.getEvalPerson()))
        	&& (this.getEvalOrg() == null ? other.getEvalOrg() == null : this.getEvalOrg().equals(other.getEvalOrg()))
                                                	&& (this.getRightCertTypeCd() == null ? other.getRightCertTypeCd() == null : this.getRightCertTypeCd().equals(other.getRightCertTypeCd()))
        	&& (this.getRightCertNo() == null ? other.getRightCertNo() == null : this.getRightCertNo().equals(other.getRightCertNo()))
        	&& (this.getRightOrg() == null ? other.getRightOrg() == null : this.getRightOrg().equals(other.getRightOrg()))
                        	&& (this.getDepotStatusCd() == null ? other.getDepotStatusCd() == null : this.getDepotStatusCd().equals(other.getDepotStatusCd()))
        	&& (this.getBookNo() == null ? other.getBookNo() == null : this.getBookNo().equals(other.getBookNo()))
        	&& (this.getBookOrg() == null ? other.getBookOrg() == null : this.getBookOrg().equals(other.getBookOrg()))
                        	&& (this.getCreateUserNo() == null ? other.getCreateUserNo() == null : this.getCreateUserNo().equals(other.getCreateUserNo()))
        	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
                        	&& (this.getRefNm() == null ? other.getRefNm() == null : this.getRefNm().equals(other.getRefNm()))
        	&& (this.getFlag1Ind() == null ? other.getFlag1Ind() == null : this.getFlag1Ind().equals(other.getFlag1Ind()))
        	&& (this.getFlag2Ind() == null ? other.getFlag2Ind() == null : this.getFlag2Ind().equals(other.getFlag2Ind()))
        	&& (this.getFlag3Ind() == null ? other.getFlag3Ind() == null : this.getFlag3Ind().equals(other.getFlag3Ind()))
        	&& (this.getFlag4Ind() == null ? other.getFlag4Ind() == null : this.getFlag4Ind().equals(other.getFlag4Ind()))
        	&& (this.getFlag5Ind() == null ? other.getFlag5Ind() == null : this.getFlag5Ind().equals(other.getFlag5Ind()))
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
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCusTypCd() == null) ? 0 : getCusTypCd().hashCode());
        result = prime * result + ((getComLoanCardNo() == null) ? 0 : getComLoanCardNo().hashCode());
        result = prime * result + ((getGageNm() == null) ? 0 : getGageNm().hashCode());
        result = prime * result + ((getGageTypeCd() == null) ? 0 : getGageTypeCd().hashCode());
        result = prime * result + ((getGageTypeSubCd() == null) ? 0 : getGageTypeSubCd().hashCode());
        result = prime * result + ((getStatusCd() == null) ? 0 : getStatusCd().hashCode());
        result = prime * result + ((getCcyCd() == null) ? 0 : getCcyCd().hashCode());
        result = prime * result + ((getEvalCd() == null) ? 0 : getEvalCd().hashCode());
        result = prime * result + ((getEvalPerson() == null) ? 0 : getEvalPerson().hashCode());
        result = prime * result + ((getEvalOrg() == null) ? 0 : getEvalOrg().hashCode());
        result = prime * result + ((getRightCertTypeCd() == null) ? 0 : getRightCertTypeCd().hashCode());
        result = prime * result + ((getRightCertNo() == null) ? 0 : getRightCertNo().hashCode());
        result = prime * result + ((getRightOrg() == null) ? 0 : getRightOrg().hashCode());
        result = prime * result + ((getDepotStatusCd() == null) ? 0 : getDepotStatusCd().hashCode());
        result = prime * result + ((getBookNo() == null) ? 0 : getBookNo().hashCode());
        result = prime * result + ((getBookOrg() == null) ? 0 : getBookOrg().hashCode());
        result = prime * result + ((getCreateUserNo() == null) ? 0 : getCreateUserNo().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getRefNm() == null) ? 0 : getRefNm().hashCode());
        result = prime * result + ((getFlag1Ind() == null) ? 0 : getFlag1Ind().hashCode());
        result = prime * result + ((getFlag2Ind() == null) ? 0 : getFlag2Ind().hashCode());
        result = prime * result + ((getFlag3Ind() == null) ? 0 : getFlag3Ind().hashCode());
        result = prime * result + ((getFlag4Ind() == null) ? 0 : getFlag4Ind().hashCode());
        result = prime * result + ((getFlag5Ind() == null) ? 0 : getFlag5Ind().hashCode());
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