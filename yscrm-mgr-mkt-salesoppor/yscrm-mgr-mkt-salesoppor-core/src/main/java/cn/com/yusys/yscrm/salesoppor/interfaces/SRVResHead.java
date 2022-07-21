
package cn.com.yusys.yscrm.salesoppor.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SRVResHead complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SRVResHead"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TransCode"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="UserNm" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AuthPwd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TlrNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TelPasswd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="BrchNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FileAdr" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FileSendType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="SvrDt"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SvrTm"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SerSeqNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="RcrdNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SRVResHead", namespace = "http://www.whrcbank.com/service/bd/R17602003046R", propOrder = {
    "transCode",
    "userNm",
    "authPw",
    "tlrNo",
    "tlrPwd",
    "brchNo",
    "fileHMac",
    "fileName",
    "fileSendType",
    "svrDt",
    "svrTm",
    "svrSeqNo",
    "rowNum"
})
public class SRVResHead {

    @XmlElement(name = "TransCode", required = true)
    protected String transCode;
    @XmlElement(name = "UserNm", required = true)
    protected String userNm;
    @XmlElement(name = "AuthPw", required = true)
    protected String authPw;
    @XmlElement(name = "TlrNo", required = true)
    protected String tlrNo;
    @XmlElement(name = "TlrPwd", required = true)
    protected String tlrPwd;
    @XmlElement(name = "BrchNo", required = true)
    protected String brchNo;
    @XmlElement(name = "FileHMac", required = true)
    protected String fileHMac;
    @XmlElement(name = "FileName", required = true)
    protected String fileName;
    @XmlElement(name = "FileSendType", required = true)
    protected String fileSendType;
    @XmlElement(name = "SvrDt", required = true)
    protected String svrDt;
    @XmlElement(name = "SvrTm", required = true)
    protected String svrTm;
    @XmlElement(name = "SvrSeqNo", required = true)
    protected String svrSeqNo;
    @XmlElement(name = "RowNum", required = true)
    protected String rowNum;

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
     * ��ȡuserNm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserNm() {
        return userNm;
    }

    /**
     * ����userNm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserNm(String value) {
        this.userNm = value;
    }

    

    /**
     * ��ȡtlrNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTlrNo() {
        return tlrNo;
    }

    /**
     * ����tlrNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTlrNo(String value) {
        this.tlrNo = value;
    }

   

    /**
     * ��ȡbrchNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrchNo() {
        return brchNo;
    }

    /**
     * ����brchNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrchNo(String value) {
        this.brchNo = value;
    }

   

    /**
     * ��ȡfileName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * ����fileName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * ��ȡfileSendType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileSendType() {
        return fileSendType;
    }

    /**
     * ����fileSendType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileSendType(String value) {
        this.fileSendType = value;
    }

    /**
     * ��ȡsvrDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvrDt() {
        return svrDt;
    }

    /**
     * ����svrDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvrDt(String value) {
        this.svrDt = value;
    }

    /**
     * ��ȡsvrTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvrTm() {
        return svrTm;
    }

    /**
     * ����svrTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvrTm(String value) {
        this.svrTm = value;
    }

	public String getAuthPw() {
		return authPw;
	}

	public void setAuthPw(String authPw) {
		this.authPw = authPw;
	}

	public String getTlrPwd() {
		return tlrPwd;
	}

	public void setTlrPwd(String tlrPwd) {
		this.tlrPwd = tlrPwd;
	}

	public String getFileHMac() {
		return fileHMac;
	}

	public void setFileHMac(String fileHMac) {
		this.fileHMac = fileHMac;
	}

	public String getSvrSeqNo() {
		return svrSeqNo;
	}

	public void setSvrSeqNo(String svrSeqNo) {
		this.svrSeqNo = svrSeqNo;
	}

	public String getRowNum() {
		return rowNum;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

   
}
