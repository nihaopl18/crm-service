
package cn.com.yusys.yscrm.salesoppor.sendRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SrvResBizBody complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SrvResBizBody"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TransTpCd"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TxnChnlNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TxnSerSeqNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FrntTm"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FrntDt"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="RspCode"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="RspMsg"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TxnInsNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TxnTlrNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SerSeqNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="NtcInf"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SrvResBizBody", propOrder = {
    "epsTranCode",
    "txnChnlNo",
    "txnSerSeqNo",
    "frntTm",
    "frntDt",
    "rspCode",
    "rspMsg",
    "txnInsNo",
    "txnTlrNo",
    "serSeqNo",
    "ntcInf"
})
public class SrvResBizBody {

    @XmlElement(name = "EpsTranCode", required = true)
    protected String epsTranCode;
    @XmlElement(name = "TxnChnlNo", required = true)
    protected String txnChnlNo;
    @XmlElement(name = "TxnSerSeqNo", required = true)
    protected String txnSerSeqNo;
    @XmlElement(name = "FrntTm", required = true)
    protected String frntTm;
    @XmlElement(name = "FrntDt", required = true)
    protected String frntDt;
    @XmlElement(name = "RspCode", required = true)
    protected String rspCode;
    @XmlElement(name = "RspMsg", required = true)
    protected String rspMsg;
    @XmlElement(name = "TxnInsNo", required = true)
    protected String txnInsNo;
    @XmlElement(name = "TxnTlrNo", required = true)
    protected String txnTlrNo;
    @XmlElement(name = "SerSeqNo", required = true)
    protected String serSeqNo;
    @XmlElement(name = "NtcInf", required = true)
    protected String ntcInf;

   

    public String getEpsTranCode() {
		return epsTranCode;
	}

	public void setEpsTranCode(String epsTranCode) {
		this.epsTranCode = epsTranCode;
	}

	/**
     * ��ȡtxnChnlNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnChnlNo() {
        return txnChnlNo;
    }

    /**
     * ����txnChnlNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnChnlNo(String value) {
        this.txnChnlNo = value;
    }

    /**
     * ��ȡtxnSerSeqNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnSerSeqNo() {
        return txnSerSeqNo;
    }

    /**
     * ����txnSerSeqNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnSerSeqNo(String value) {
        this.txnSerSeqNo = value;
    }

    /**
     * ��ȡfrntTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrntTm() {
        return frntTm;
    }

    /**
     * ����frntTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrntTm(String value) {
        this.frntTm = value;
    }

    /**
     * ��ȡfrntDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrntDt() {
        return frntDt;
    }

    /**
     * ����frntDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrntDt(String value) {
        this.frntDt = value;
    }

    /**
     * ��ȡrspCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRspCode() {
        return rspCode;
    }

    /**
     * ����rspCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRspCode(String value) {
        this.rspCode = value;
    }

    /**
     * ��ȡrspMsg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRspMsg() {
        return rspMsg;
    }

    /**
     * ����rspMsg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRspMsg(String value) {
        this.rspMsg = value;
    }

    /**
     * ��ȡtxnInsNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnInsNo() {
        return txnInsNo;
    }

    /**
     * ����txnInsNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnInsNo(String value) {
        this.txnInsNo = value;
    }

    /**
     * ��ȡtxnTlrNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnTlrNo() {
        return txnTlrNo;
    }

    /**
     * ����txnTlrNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnTlrNo(String value) {
        this.txnTlrNo = value;
    }

    /**
     * ��ȡserSeqNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerSeqNo() {
        return serSeqNo;
    }

    /**
     * ����serSeqNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerSeqNo(String value) {
        this.serSeqNo = value;
    }

    /**
     * ��ȡntcInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNtcInf() {
        return ntcInf;
    }

    /**
     * ����ntcInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNtcInf(String value) {
        this.ntcInf = value;
    }

	@Override
	public String toString() {
		return "SrvResBizBody [epsTranCode=" + epsTranCode + ", txnChnlNo=" + txnChnlNo + ", txnSerSeqNo=" + txnSerSeqNo
				+ ", frntTm=" + frntTm + ", frntDt=" + frntDt + ", rspCode=" + rspCode + ", rspMsg=" + rspMsg
				+ ", txnInsNo=" + txnInsNo + ", txnTlrNo=" + txnTlrNo + ", serSeqNo=" + serSeqNo + ", ntcInf=" + ntcInf
				+ "]";
	}

}
