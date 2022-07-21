
package cn.com.yusys.yscrm.cust.person.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SrvReqBizBody complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SrvReqBizBody"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TransCode"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AccNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="IC_CardSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
 *         &lt;element name="ClrDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TxnInd"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FeeFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeCode1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeDesc1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeCcy1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeAmt1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeAcctNo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePaySrc1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayAcctNo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayAcctName1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayTime1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeRalAcctNo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeCode2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeDesc2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeCcy2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeAmt2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeAcctNo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePaySrc2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayAcctNo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayAcctName2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayTime2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeRalAcctNo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeCode3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeDesc3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeCcy3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeAmt3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeAcctNo3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePaySrc3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayAcctNo3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayAcctName3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayTime3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeRalAcctNo3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeCode4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeDesc4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeCcy4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeAmt4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeAcctNo4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePaySrc4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayAcctNo4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayAcctName4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayTime4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeRalAcctNo4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeCode5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeDesc5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeCcy5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeAmt5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeAcctNo5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePaySrc5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayAcctNo5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayAcctName5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeePayTime5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeRalAcctNo5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TxnSysCd"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="IC_ARQCDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SndTrckInf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ThrdTrckInf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TermId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TxnInsNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PsbkPrtNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CcyCd"&gt;
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
 *         &lt;element name="Passwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SafeCtrlInf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CrdtTpCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CrdtNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MacBuf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SrvReqBizBody", propOrder = {
    "transCode",
    "accNo",
    "icCardSeq",
    "txnChnlNo",
    "txnSerSeqNo",
    "frntTm",
    "frntDt",
    "clrDt",
    "txnInd",
    "feeFlag",
    "feeCode1",
    "feeDesc1",
    "feeCcy1",
    "feeAmt1",
    "feeAcctNo1",
    "feePaySrc1",
    "feePayAcctNo1",
    "feePayAcctName1",
    "feePayTime1",
    "feeRalAcctNo1",
    "feeCode2",
    "feeDesc2",
    "feeCcy2",
    "feeAmt2",
    "feeAcctNo2",
    "feePaySrc2",
    "feePayAcctNo2",
    "feePayAcctName2",
    "feePayTime2",
    "feeRalAcctNo2",
    "feeCode3",
    "feeDesc3",
    "feeCcy3",
    "feeAmt3",
    "feeAcctNo3",
    "feePaySrc3",
    "feePayAcctNo3",
    "feePayAcctName3",
    "feePayTime3",
    "feeRalAcctNo3",
    "feeCode4",
    "feeDesc4",
    "feeCcy4",
    "feeAmt4",
    "feeAcctNo4",
    "feePaySrc4",
    "feePayAcctNo4",
    "feePayAcctName4",
    "feePayTime4",
    "feeRalAcctNo4",
    "feeCode5",
    "feeDesc5",
    "feeCcy5",
    "feeAmt5",
    "feeAcctNo5",
    "feePaySrc5",
    "feePayAcctNo5",
    "feePayAcctName5",
    "feePayTime5",
    "feeRalAcctNo5",
    "vNo",
    "txnSysCd",
    "icarqcdt",
    "sndTrckInf",
    "thrdTrckInf",
    "termId",
    "txnInsNo",
    "psbkPrtNo",
    "ccyCd",
    "txnTlrNo",
    "passwd",
    "safeCtrlInf",
    "crdtTpCd",
    "crdtNo",
    "macBuf"
})
public class SrvReqBizBody {

    @XmlElement(name = "TransCode", required = true)
    protected String transCode;
    @XmlElement(name = "AccNo", required = true)
    protected String accNo;
    @XmlElement(name = "IC_CardSeq")
    protected String icCardSeq;
    @XmlElement(name = "TxnChnlNo", required = true)
    protected String txnChnlNo;
    @XmlElement(name = "TxnSerSeqNo", required = true)
    protected String txnSerSeqNo;
    @XmlElement(name = "FrntTm", required = true)
    protected String frntTm;
    @XmlElement(name = "FrntDt", required = true)
    protected String frntDt;
    @XmlElement(name = "ClrDt")
    protected String clrDt;
    @XmlElement(name = "TxnInd", required = true)
    protected String txnInd;
    @XmlElement(name = "FeeFlag")
    protected String feeFlag;
    @XmlElement(name = "FeeCode1")
    protected String feeCode1;
    @XmlElement(name = "FeeDesc1")
    protected String feeDesc1;
    @XmlElement(name = "FeeCcy1")
    protected String feeCcy1;
    @XmlElement(name = "FeeAmt1")
    protected String feeAmt1;
    @XmlElement(name = "FeeAcctNo1")
    protected String feeAcctNo1;
    @XmlElement(name = "FeePaySrc1")
    protected String feePaySrc1;
    @XmlElement(name = "FeePayAcctNo1")
    protected String feePayAcctNo1;
    @XmlElement(name = "FeePayAcctName1")
    protected String feePayAcctName1;
    @XmlElement(name = "FeePayTime1")
    protected String feePayTime1;
    @XmlElement(name = "FeeRalAcctNo1")
    protected String feeRalAcctNo1;
    @XmlElement(name = "FeeCode2")
    protected String feeCode2;
    @XmlElement(name = "FeeDesc2")
    protected String feeDesc2;
    @XmlElement(name = "FeeCcy2")
    protected String feeCcy2;
    @XmlElement(name = "FeeAmt2")
    protected String feeAmt2;
    @XmlElement(name = "FeeAcctNo2")
    protected String feeAcctNo2;
    @XmlElement(name = "FeePaySrc2")
    protected String feePaySrc2;
    @XmlElement(name = "FeePayAcctNo2")
    protected String feePayAcctNo2;
    @XmlElement(name = "FeePayAcctName2")
    protected String feePayAcctName2;
    @XmlElement(name = "FeePayTime2")
    protected String feePayTime2;
    @XmlElement(name = "FeeRalAcctNo2")
    protected String feeRalAcctNo2;
    @XmlElement(name = "FeeCode3")
    protected String feeCode3;
    @XmlElement(name = "FeeDesc3")
    protected String feeDesc3;
    @XmlElement(name = "FeeCcy3")
    protected String feeCcy3;
    @XmlElement(name = "FeeAmt3")
    protected String feeAmt3;
    @XmlElement(name = "FeeAcctNo3")
    protected String feeAcctNo3;
    @XmlElement(name = "FeePaySrc3")
    protected String feePaySrc3;
    @XmlElement(name = "FeePayAcctNo3")
    protected String feePayAcctNo3;
    @XmlElement(name = "FeePayAcctName3")
    protected String feePayAcctName3;
    @XmlElement(name = "FeePayTime3")
    protected String feePayTime3;
    @XmlElement(name = "FeeRalAcctNo3")
    protected String feeRalAcctNo3;
    @XmlElement(name = "FeeCode4")
    protected String feeCode4;
    @XmlElement(name = "FeeDesc4")
    protected String feeDesc4;
    @XmlElement(name = "FeeCcy4")
    protected String feeCcy4;
    @XmlElement(name = "FeeAmt4")
    protected String feeAmt4;
    @XmlElement(name = "FeeAcctNo4")
    protected String feeAcctNo4;
    @XmlElement(name = "FeePaySrc4")
    protected String feePaySrc4;
    @XmlElement(name = "FeePayAcctNo4")
    protected String feePayAcctNo4;
    @XmlElement(name = "FeePayAcctName4")
    protected String feePayAcctName4;
    @XmlElement(name = "FeePayTime4")
    protected String feePayTime4;
    @XmlElement(name = "FeeRalAcctNo4")
    protected String feeRalAcctNo4;
    @XmlElement(name = "FeeCode5")
    protected String feeCode5;
    @XmlElement(name = "FeeDesc5")
    protected String feeDesc5;
    @XmlElement(name = "FeeCcy5")
    protected String feeCcy5;
    @XmlElement(name = "FeeAmt5")
    protected String feeAmt5;
    @XmlElement(name = "FeeAcctNo5")
    protected String feeAcctNo5;
    @XmlElement(name = "FeePaySrc5")
    protected String feePaySrc5;
    @XmlElement(name = "FeePayAcctNo5")
    protected String feePayAcctNo5;
    @XmlElement(name = "FeePayAcctName5")
    protected String feePayAcctName5;
    @XmlElement(name = "FeePayTime5")
    protected String feePayTime5;
    @XmlElement(name = "FeeRalAcctNo5")
    protected String feeRalAcctNo5;
    @XmlElement(name = "VNo")
    protected String vNo;
    @XmlElement(name = "TxnSysCd", required = true)
    protected String txnSysCd;
    @XmlElement(name = "IC_ARQCDT")
    protected String icarqcdt;
    @XmlElement(name = "SndTrckInf")
    protected String sndTrckInf;
    @XmlElement(name = "ThrdTrckInf")
    protected String thrdTrckInf;
    @XmlElement(name = "TermId")
    protected String termId;
    @XmlElement(name = "TxnInsNo", required = true)
    protected String txnInsNo;
    @XmlElement(name = "PsbkPrtNo")
    protected String psbkPrtNo;
    @XmlElement(name = "CcyCd", required = true)
    protected String ccyCd;
    @XmlElement(name = "TxnTlrNo", required = true)
    protected String txnTlrNo;
    @XmlElement(name = "Passwd")
    protected String passwd;
    @XmlElement(name = "SafeCtrlInf")
    protected String safeCtrlInf;
    @XmlElement(name = "CrdtTpCd")
    protected String crdtTpCd;
    @XmlElement(name = "CrdtNo")
    protected String crdtNo;
    @XmlElement(name = "MacBuf")
    protected String macBuf;

    /**
     * ��ȡtransCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransCode() {
        return transCode;
    }

    /**
     * ����transCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransCode(String value) {
        this.transCode = value;
    }

    /**
     * ��ȡaccNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccNo() {
        return accNo;
    }

    /**
     * ����accNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccNo(String value) {
        this.accNo = value;
    }

    /**
     * ��ȡicCardSeq���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICCardSeq() {
        return icCardSeq;
    }

    /**
     * ����icCardSeq���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICCardSeq(String value) {
        this.icCardSeq = value;
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
     * ��ȡclrDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClrDt() {
        return clrDt;
    }

    /**
     * ����clrDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClrDt(String value) {
        this.clrDt = value;
    }

    /**
     * ��ȡtxnInd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnInd() {
        return txnInd;
    }

    /**
     * ����txnInd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnInd(String value) {
        this.txnInd = value;
    }

    /**
     * ��ȡfeeFlag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeFlag() {
        return feeFlag;
    }

    /**
     * ����feeFlag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeFlag(String value) {
        this.feeFlag = value;
    }

    /**
     * ��ȡfeeCode1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeCode1() {
        return feeCode1;
    }

    /**
     * ����feeCode1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCode1(String value) {
        this.feeCode1 = value;
    }

    /**
     * ��ȡfeeDesc1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeDesc1() {
        return feeDesc1;
    }

    /**
     * ����feeDesc1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeDesc1(String value) {
        this.feeDesc1 = value;
    }

    /**
     * ��ȡfeeCcy1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeCcy1() {
        return feeCcy1;
    }

    /**
     * ����feeCcy1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCcy1(String value) {
        this.feeCcy1 = value;
    }

    /**
     * ��ȡfeeAmt1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAmt1() {
        return feeAmt1;
    }

    /**
     * ����feeAmt1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAmt1(String value) {
        this.feeAmt1 = value;
    }

    /**
     * ��ȡfeeAcctNo1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAcctNo1() {
        return feeAcctNo1;
    }

    /**
     * ����feeAcctNo1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAcctNo1(String value) {
        this.feeAcctNo1 = value;
    }

    /**
     * ��ȡfeePaySrc1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePaySrc1() {
        return feePaySrc1;
    }

    /**
     * ����feePaySrc1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePaySrc1(String value) {
        this.feePaySrc1 = value;
    }

    /**
     * ��ȡfeePayAcctNo1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayAcctNo1() {
        return feePayAcctNo1;
    }

    /**
     * ����feePayAcctNo1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayAcctNo1(String value) {
        this.feePayAcctNo1 = value;
    }

    /**
     * ��ȡfeePayAcctName1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayAcctName1() {
        return feePayAcctName1;
    }

    /**
     * ����feePayAcctName1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayAcctName1(String value) {
        this.feePayAcctName1 = value;
    }

    /**
     * ��ȡfeePayTime1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayTime1() {
        return feePayTime1;
    }

    /**
     * ����feePayTime1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayTime1(String value) {
        this.feePayTime1 = value;
    }

    /**
     * ��ȡfeeRalAcctNo1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeRalAcctNo1() {
        return feeRalAcctNo1;
    }

    /**
     * ����feeRalAcctNo1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeRalAcctNo1(String value) {
        this.feeRalAcctNo1 = value;
    }

    /**
     * ��ȡfeeCode2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeCode2() {
        return feeCode2;
    }

    /**
     * ����feeCode2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCode2(String value) {
        this.feeCode2 = value;
    }

    /**
     * ��ȡfeeDesc2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeDesc2() {
        return feeDesc2;
    }

    /**
     * ����feeDesc2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeDesc2(String value) {
        this.feeDesc2 = value;
    }

    /**
     * ��ȡfeeCcy2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeCcy2() {
        return feeCcy2;
    }

    /**
     * ����feeCcy2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCcy2(String value) {
        this.feeCcy2 = value;
    }

    /**
     * ��ȡfeeAmt2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAmt2() {
        return feeAmt2;
    }

    /**
     * ����feeAmt2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAmt2(String value) {
        this.feeAmt2 = value;
    }

    /**
     * ��ȡfeeAcctNo2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAcctNo2() {
        return feeAcctNo2;
    }

    /**
     * ����feeAcctNo2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAcctNo2(String value) {
        this.feeAcctNo2 = value;
    }

    /**
     * ��ȡfeePaySrc2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePaySrc2() {
        return feePaySrc2;
    }

    /**
     * ����feePaySrc2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePaySrc2(String value) {
        this.feePaySrc2 = value;
    }

    /**
     * ��ȡfeePayAcctNo2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayAcctNo2() {
        return feePayAcctNo2;
    }

    /**
     * ����feePayAcctNo2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayAcctNo2(String value) {
        this.feePayAcctNo2 = value;
    }

    /**
     * ��ȡfeePayAcctName2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayAcctName2() {
        return feePayAcctName2;
    }

    /**
     * ����feePayAcctName2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayAcctName2(String value) {
        this.feePayAcctName2 = value;
    }

    /**
     * ��ȡfeePayTime2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayTime2() {
        return feePayTime2;
    }

    /**
     * ����feePayTime2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayTime2(String value) {
        this.feePayTime2 = value;
    }

    /**
     * ��ȡfeeRalAcctNo2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeRalAcctNo2() {
        return feeRalAcctNo2;
    }

    /**
     * ����feeRalAcctNo2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeRalAcctNo2(String value) {
        this.feeRalAcctNo2 = value;
    }

    /**
     * ��ȡfeeCode3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeCode3() {
        return feeCode3;
    }

    /**
     * ����feeCode3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCode3(String value) {
        this.feeCode3 = value;
    }

    /**
     * ��ȡfeeDesc3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeDesc3() {
        return feeDesc3;
    }

    /**
     * ����feeDesc3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeDesc3(String value) {
        this.feeDesc3 = value;
    }

    /**
     * ��ȡfeeCcy3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeCcy3() {
        return feeCcy3;
    }

    /**
     * ����feeCcy3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCcy3(String value) {
        this.feeCcy3 = value;
    }

    /**
     * ��ȡfeeAmt3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAmt3() {
        return feeAmt3;
    }

    /**
     * ����feeAmt3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAmt3(String value) {
        this.feeAmt3 = value;
    }

    /**
     * ��ȡfeeAcctNo3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAcctNo3() {
        return feeAcctNo3;
    }

    /**
     * ����feeAcctNo3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAcctNo3(String value) {
        this.feeAcctNo3 = value;
    }

    /**
     * ��ȡfeePaySrc3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePaySrc3() {
        return feePaySrc3;
    }

    /**
     * ����feePaySrc3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePaySrc3(String value) {
        this.feePaySrc3 = value;
    }

    /**
     * ��ȡfeePayAcctNo3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayAcctNo3() {
        return feePayAcctNo3;
    }

    /**
     * ����feePayAcctNo3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayAcctNo3(String value) {
        this.feePayAcctNo3 = value;
    }

    /**
     * ��ȡfeePayAcctName3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayAcctName3() {
        return feePayAcctName3;
    }

    /**
     * ����feePayAcctName3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayAcctName3(String value) {
        this.feePayAcctName3 = value;
    }

    /**
     * ��ȡfeePayTime3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayTime3() {
        return feePayTime3;
    }

    /**
     * ����feePayTime3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayTime3(String value) {
        this.feePayTime3 = value;
    }

    /**
     * ��ȡfeeRalAcctNo3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeRalAcctNo3() {
        return feeRalAcctNo3;
    }

    /**
     * ����feeRalAcctNo3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeRalAcctNo3(String value) {
        this.feeRalAcctNo3 = value;
    }

    /**
     * ��ȡfeeCode4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeCode4() {
        return feeCode4;
    }

    /**
     * ����feeCode4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCode4(String value) {
        this.feeCode4 = value;
    }

    /**
     * ��ȡfeeDesc4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeDesc4() {
        return feeDesc4;
    }

    /**
     * ����feeDesc4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeDesc4(String value) {
        this.feeDesc4 = value;
    }

    /**
     * ��ȡfeeCcy4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeCcy4() {
        return feeCcy4;
    }

    /**
     * ����feeCcy4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCcy4(String value) {
        this.feeCcy4 = value;
    }

    /**
     * ��ȡfeeAmt4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAmt4() {
        return feeAmt4;
    }

    /**
     * ����feeAmt4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAmt4(String value) {
        this.feeAmt4 = value;
    }

    /**
     * ��ȡfeeAcctNo4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAcctNo4() {
        return feeAcctNo4;
    }

    /**
     * ����feeAcctNo4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAcctNo4(String value) {
        this.feeAcctNo4 = value;
    }

    /**
     * ��ȡfeePaySrc4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePaySrc4() {
        return feePaySrc4;
    }

    /**
     * ����feePaySrc4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePaySrc4(String value) {
        this.feePaySrc4 = value;
    }

    /**
     * ��ȡfeePayAcctNo4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayAcctNo4() {
        return feePayAcctNo4;
    }

    /**
     * ����feePayAcctNo4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayAcctNo4(String value) {
        this.feePayAcctNo4 = value;
    }

    /**
     * ��ȡfeePayAcctName4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayAcctName4() {
        return feePayAcctName4;
    }

    /**
     * ����feePayAcctName4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayAcctName4(String value) {
        this.feePayAcctName4 = value;
    }

    /**
     * ��ȡfeePayTime4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayTime4() {
        return feePayTime4;
    }

    /**
     * ����feePayTime4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayTime4(String value) {
        this.feePayTime4 = value;
    }

    /**
     * ��ȡfeeRalAcctNo4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeRalAcctNo4() {
        return feeRalAcctNo4;
    }

    /**
     * ����feeRalAcctNo4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeRalAcctNo4(String value) {
        this.feeRalAcctNo4 = value;
    }

    /**
     * ��ȡfeeCode5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeCode5() {
        return feeCode5;
    }

    /**
     * ����feeCode5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCode5(String value) {
        this.feeCode5 = value;
    }

    /**
     * ��ȡfeeDesc5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeDesc5() {
        return feeDesc5;
    }

    /**
     * ����feeDesc5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeDesc5(String value) {
        this.feeDesc5 = value;
    }

    /**
     * ��ȡfeeCcy5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeCcy5() {
        return feeCcy5;
    }

    /**
     * ����feeCcy5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCcy5(String value) {
        this.feeCcy5 = value;
    }

    /**
     * ��ȡfeeAmt5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAmt5() {
        return feeAmt5;
    }

    /**
     * ����feeAmt5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAmt5(String value) {
        this.feeAmt5 = value;
    }

    /**
     * ��ȡfeeAcctNo5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAcctNo5() {
        return feeAcctNo5;
    }

    /**
     * ����feeAcctNo5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAcctNo5(String value) {
        this.feeAcctNo5 = value;
    }

    /**
     * ��ȡfeePaySrc5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePaySrc5() {
        return feePaySrc5;
    }

    /**
     * ����feePaySrc5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePaySrc5(String value) {
        this.feePaySrc5 = value;
    }

    /**
     * ��ȡfeePayAcctNo5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayAcctNo5() {
        return feePayAcctNo5;
    }

    /**
     * ����feePayAcctNo5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayAcctNo5(String value) {
        this.feePayAcctNo5 = value;
    }

    /**
     * ��ȡfeePayAcctName5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayAcctName5() {
        return feePayAcctName5;
    }

    /**
     * ����feePayAcctName5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayAcctName5(String value) {
        this.feePayAcctName5 = value;
    }

    /**
     * ��ȡfeePayTime5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeePayTime5() {
        return feePayTime5;
    }

    /**
     * ����feePayTime5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeePayTime5(String value) {
        this.feePayTime5 = value;
    }

    /**
     * ��ȡfeeRalAcctNo5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeRalAcctNo5() {
        return feeRalAcctNo5;
    }

    /**
     * ����feeRalAcctNo5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeRalAcctNo5(String value) {
        this.feeRalAcctNo5 = value;
    }

    /**
     * ��ȡvNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVNo() {
        return vNo;
    }

    /**
     * ����vNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVNo(String value) {
        this.vNo = value;
    }

    /**
     * ��ȡtxnSysCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnSysCd() {
        return txnSysCd;
    }

    /**
     * ����txnSysCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnSysCd(String value) {
        this.txnSysCd = value;
    }

    /**
     * ��ȡicarqcdt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICARQCDT() {
        return icarqcdt;
    }

    /**
     * ����icarqcdt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICARQCDT(String value) {
        this.icarqcdt = value;
    }

    /**
     * ��ȡsndTrckInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSndTrckInf() {
        return sndTrckInf;
    }

    /**
     * ����sndTrckInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSndTrckInf(String value) {
        this.sndTrckInf = value;
    }

    /**
     * ��ȡthrdTrckInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThrdTrckInf() {
        return thrdTrckInf;
    }

    /**
     * ����thrdTrckInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThrdTrckInf(String value) {
        this.thrdTrckInf = value;
    }

    /**
     * ��ȡtermId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermId() {
        return termId;
    }

    /**
     * ����termId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermId(String value) {
        this.termId = value;
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
     * ��ȡpsbkPrtNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsbkPrtNo() {
        return psbkPrtNo;
    }

    /**
     * ����psbkPrtNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsbkPrtNo(String value) {
        this.psbkPrtNo = value;
    }

    /**
     * ��ȡccyCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcyCd() {
        return ccyCd;
    }

    /**
     * ����ccyCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcyCd(String value) {
        this.ccyCd = value;
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
     * ��ȡpasswd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * ����passwd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPasswd(String value) {
        this.passwd = value;
    }

    /**
     * ��ȡsafeCtrlInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSafeCtrlInf() {
        return safeCtrlInf;
    }

    /**
     * ����safeCtrlInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSafeCtrlInf(String value) {
        this.safeCtrlInf = value;
    }

    /**
     * ��ȡcrdtTpCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrdtTpCd() {
        return crdtTpCd;
    }

    /**
     * ����crdtTpCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrdtTpCd(String value) {
        this.crdtTpCd = value;
    }

    /**
     * ��ȡcrdtNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrdtNo() {
        return crdtNo;
    }

    /**
     * ����crdtNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrdtNo(String value) {
        this.crdtNo = value;
    }

    /**
     * ��ȡmacBuf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacBuf() {
        return macBuf;
    }

    /**
     * ����macBuf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacBuf(String value) {
        this.macBuf = value;
    }

	@Override
	public String toString() {
		return "SrvReqBizBody [transCode=" + transCode + ", accNo=" + accNo + ", icCardSeq=" + icCardSeq
				+ ", txnChnlNo=" + txnChnlNo + ", txnSerSeqNo=" + txnSerSeqNo + ", frntTm=" + frntTm + ", frntDt="
				+ frntDt + ", clrDt=" + clrDt + ", txnInd=" + txnInd + ", feeFlag=" + feeFlag + ", feeCode1=" + feeCode1
				+ ", feeDesc1=" + feeDesc1 + ", feeCcy1=" + feeCcy1 + ", feeAmt1=" + feeAmt1 + ", feeAcctNo1="
				+ feeAcctNo1 + ", feePaySrc1=" + feePaySrc1 + ", feePayAcctNo1=" + feePayAcctNo1 + ", feePayAcctName1="
				+ feePayAcctName1 + ", feePayTime1=" + feePayTime1 + ", feeRalAcctNo1=" + feeRalAcctNo1 + ", feeCode2="
				+ feeCode2 + ", feeDesc2=" + feeDesc2 + ", feeCcy2=" + feeCcy2 + ", feeAmt2=" + feeAmt2
				+ ", feeAcctNo2=" + feeAcctNo2 + ", feePaySrc2=" + feePaySrc2 + ", feePayAcctNo2=" + feePayAcctNo2
				+ ", feePayAcctName2=" + feePayAcctName2 + ", feePayTime2=" + feePayTime2 + ", feeRalAcctNo2="
				+ feeRalAcctNo2 + ", feeCode3=" + feeCode3 + ", feeDesc3=" + feeDesc3 + ", feeCcy3=" + feeCcy3
				+ ", feeAmt3=" + feeAmt3 + ", feeAcctNo3=" + feeAcctNo3 + ", feePaySrc3=" + feePaySrc3
				+ ", feePayAcctNo3=" + feePayAcctNo3 + ", feePayAcctName3=" + feePayAcctName3 + ", feePayTime3="
				+ feePayTime3 + ", feeRalAcctNo3=" + feeRalAcctNo3 + ", feeCode4=" + feeCode4 + ", feeDesc4=" + feeDesc4
				+ ", feeCcy4=" + feeCcy4 + ", feeAmt4=" + feeAmt4 + ", feeAcctNo4=" + feeAcctNo4 + ", feePaySrc4="
				+ feePaySrc4 + ", feePayAcctNo4=" + feePayAcctNo4 + ", feePayAcctName4=" + feePayAcctName4
				+ ", feePayTime4=" + feePayTime4 + ", feeRalAcctNo4=" + feeRalAcctNo4 + ", feeCode5=" + feeCode5
				+ ", feeDesc5=" + feeDesc5 + ", feeCcy5=" + feeCcy5 + ", feeAmt5=" + feeAmt5 + ", feeAcctNo5="
				+ feeAcctNo5 + ", feePaySrc5=" + feePaySrc5 + ", feePayAcctNo5=" + feePayAcctNo5 + ", feePayAcctName5="
				+ feePayAcctName5 + ", feePayTime5=" + feePayTime5 + ", feeRalAcctNo5=" + feeRalAcctNo5 + ", vNo=" + vNo
				+ ", txnSysCd=" + txnSysCd + ", icarqcdt=" + icarqcdt + ", sndTrckInf=" + sndTrckInf + ", thrdTrckInf="
				+ thrdTrckInf + ", termId=" + termId + ", txnInsNo=" + txnInsNo + ", psbkPrtNo=" + psbkPrtNo
				+ ", ccyCd=" + ccyCd + ", txnTlrNo=" + txnTlrNo + ", passwd=" + passwd + ", safeCtrlInf=" + safeCtrlInf
				+ ", crdtTpCd=" + crdtTpCd + ", crdtNo=" + crdtNo + ", macBuf=" + macBuf + "]";
	}

}
