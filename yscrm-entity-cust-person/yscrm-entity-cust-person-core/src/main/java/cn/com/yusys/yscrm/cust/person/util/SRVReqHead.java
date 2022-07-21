
package cn.com.yusys.yscrm.cust.person.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SRVReqHead complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SRVReqHead"&gt;
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
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SRVReqHead", namespace = "http://www.whrcbank.com/service/bd/R17601003044R", propOrder = {
    "transCode",
    "userNm",
    "authPw",
    "tlrNo",
    "tlrPwd",
    "brchNo",
    "fileHMac",
    "fileName",
    "fileSendType"
})
public class SRVReqHead {

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
     * ��ȡauthPwd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
   

    public String getAuthPw() {
		return authPw;
	}

	public void setAuthPw(String authPw) {
		this.authPw = authPw;
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
     * ��ȡtelPasswd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
   
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

    public String getTlrPwd() {
		return tlrPwd;
	}

	public void setTlrPwd(String tlrPwd) {
		this.tlrPwd = tlrPwd;
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
     * ��ȡfileAdr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
   
    

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

    public String getFileHMac() {
		return fileHMac;
	}

	public void setFileHMac(String fileHMac) {
		this.fileHMac = fileHMac;
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

	@Override
	public String toString() {
		return "SRVReqHead [transCode=" + transCode + ", userNm=" + userNm + ", authPw=" + authPw + ", tlrNo=" + tlrNo
				+ ", tlrPwd=" + tlrPwd + ", brchNo=" + brchNo + ", fileHMac=" + fileHMac + ", fileName=" + fileName
				+ ", fileSendType=" + fileSendType + "]";
	}

}
