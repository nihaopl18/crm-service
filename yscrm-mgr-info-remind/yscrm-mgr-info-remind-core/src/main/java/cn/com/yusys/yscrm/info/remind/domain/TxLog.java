package cn.com.yusys.yscrm.info.remind.domain;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

/**
 * TxLog entity
 * @author Administrator
 */
@Entity
@Table(name = "TX_LOG")
public class TxLog  extends BaseDomain implements java.io.Serializable {

	// Fields

	private Long txLogId;
	private String txFwId;
	private String txId;
	private String txCode;
	private String txName;
	private String txCnName;
	private String txMethod;
	private Date txDt;
	private Timestamp txReqTm;
	private Timestamp txResTm;
	private String txResult;
	private String txRtnCd;
	private String txRtnMsg;
	private String txSvrIp;
	private String srcSysCd;
	private String srcSysNm;
	private String reqMsg;
	private String resMsg;
	private String custNo;
	private String failInfo;
	private String txResFwId;

	// Constructors

	/** default constructor */
	public TxLog() {
	}

	/** full constructor */
	public TxLog(String txFwId, String txId, String txCode, String txName,
			String txCnName, String txMethod, Date txDt, Timestamp txReqTm,
			Timestamp txResTm, String txResult, String txRtnCd,
			String txRtnMsg, String txSvrIp, String srcSysCd, String srcSysNm,
			String reqMsg, String resMsg,String custNo,String failInfo,String txResFwId) {
		this.txFwId = txFwId;
		this.txId = txId;
		this.txCode = txCode;
		this.txName = txName;
		this.txCnName = txCnName;
		this.txMethod = txMethod;
		this.txDt = txDt;
		this.txReqTm = txReqTm;
		this.txResTm = txResTm;
		this.txResult = txResult;
		this.txRtnCd = txRtnCd;
		this.txRtnMsg = txRtnMsg;
		this.txSvrIp = txSvrIp;
		this.srcSysCd = srcSysCd;
		this.srcSysNm = srcSysNm;
		this.reqMsg = reqMsg;
		this.resMsg = resMsg;
		this.custNo = custNo;
		this.failInfo = failInfo;
		this.txResFwId = txResFwId;
	}

	// Property accessors
	@Id
	@Column(name = "TX_LOG_ID", unique = true, nullable = false)
	public Long getTxLogId() {
		return this.txLogId;
	}

	public void setTxLogId(Long txLogId) {
		this.txLogId = txLogId;
	}

	@Column(name = "TX_FW_ID", length = 20)
	public String getTxFwId() {
		return this.txFwId;
	}

	public void setTxFwId(String txFwId) {
		this.txFwId = txFwId;
	}

	@Column(name = "TX_ID")
	public String getTxId() {
		return this.txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	@Column(name = "TX_CODE", length = 32)
	public String getTxCode() {
		return this.txCode;
	}

	public void setTxCode(String txCode) {
		this.txCode = txCode;
	}

	@Column(name = "TX_NAME", length = 40)
	public String getTxName() {
		return this.txName;
	}

	public void setTxName(String txName) {
		this.txName = txName;
	}

	@Column(name = "TX_CN_NAME", length = 80)
	public String getTxCnName() {
		return this.txCnName;
	}

	public void setTxCnName(String txCnName) {
		this.txCnName = txCnName;
	}

	@Column(name = "TX_METHOD", length = 10)
	public String getTxMethod() {
		return this.txMethod;
	}

	public void setTxMethod(String txMethod) {
		this.txMethod = txMethod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TX_DT", length = 7)
	public Date getTxDt() {
		return this.txDt;
	}

	public void setTxDt(Date txDt) {
		this.txDt = txDt;
	}

	@Column(name = "TX_REQ_TM", length = 11)
	public Timestamp getTxReqTm() {
		return this.txReqTm;
	}

	public void setTxReqTm(Timestamp txReqTm) {
		this.txReqTm = txReqTm;
	}

	@Column(name = "TX_RES_TM", length = 11)
	public Timestamp getTxResTm() {
		return this.txResTm;
	}

	public void setTxResTm(Timestamp txResTm) {
		this.txResTm = txResTm;
	}

	@Column(name = "TX_RESULT", length = 1)
	public String getTxResult() {
		return this.txResult;
	}

	public void setTxResult(String txResult) {
		this.txResult = txResult;
	}

	@Column(name = "TX_RTN_CD", length = 10)
	public String getTxRtnCd() {
		return this.txRtnCd;
	}

	public void setTxRtnCd(String txRtnCd) {
		this.txRtnCd = txRtnCd;
	}

	@Column(name = "TX_RTN_MSG")
	public String getTxRtnMsg() {
		return this.txRtnMsg;
	}

	public void setTxRtnMsg(String txRtnMsg) {
		this.txRtnMsg = txRtnMsg;
	}

	@Column(name = "TX_SVR_IP", length = 64)
	public String getTxSvrIp() {
		return this.txSvrIp;
	}

	public void setTxSvrIp(String txSvrIp) {
		this.txSvrIp = txSvrIp;
	}

	@Column(name = "SRC_SYS_CD", length = 20)
	public String getSrcSysCd() {
		return this.srcSysCd;
	}

	public void setSrcSysCd(String srcSysCd) {
		this.srcSysCd = srcSysCd;
	}

	@Column(name = "SRC_SYS_NM", length = 20)
	public String getSrcSysNm() {
		return this.srcSysNm;
	}

	public void setSrcSysNm(String srcSysNm) {
		this.srcSysNm = srcSysNm;
	}

	@Column(name = "REQ_MSG")
	public String getReqMsg() {
		return this.reqMsg;
	}

	public void setReqMsg(String reqMsg) {
		this.reqMsg = reqMsg;
	}

	@Column(name = "RES_MSG")
	public String getResMsg() {
		return this.resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	@Column(name = "CUST_NO")
	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	@Column(name = "FAIL_INFO")
	public String getFailInfo() {
		return failInfo;
	}

	public void setFailInfo(String failInfo) {
		if(failInfo != null && failInfo.length() > 2000){
			failInfo = failInfo.substring(0,1997)+"...";
		}
		this.failInfo = failInfo;
	}

	@Column(name = "TX_RES_FW_ID")
	public String getTxResFwId() {
		return txResFwId;
	}

	public void setTxResFwId(String txResFwId) {
		this.txResFwId = txResFwId;
	}
}

