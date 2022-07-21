
package cn.com.yusys.yscrm.salesoppor.sendRequest;

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
 *         &lt;element name="MsgLen" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TransCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MsgType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FileSendType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MacBuf" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="SvcName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MsgAgreement" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SRVResHead", namespace = "http://www.whrcbank.com/service/hd/lis", propOrder = {
    "msgLen",
    "transCode",
    "msgType",
    "fileSendType",
    "macBuf",
    "svcName",
    "msgAgreement"
})
public class SRVResHead {

    @XmlElement(name = "MsgLen", required = true)
    protected String msgLen;
    @XmlElement(name = "TransCode", required = true)
    protected String transCode;
    @XmlElement(name = "MsgType", required = true)
    protected String msgType;
    @XmlElement(name = "FileSendType", required = true)
    protected String fileSendType;
    @XmlElement(name = "MacBuf", required = true)
    protected String macBuf;
    @XmlElement(name = "SvcName", required = true)
    protected String svcName;
    @XmlElement(name = "MsgAgreement", required = true)
    protected String msgAgreement;

    /**
     * ��ȡmsgLen���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgLen() {
        return msgLen;
    }

    /**
     * ����msgLen���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgLen(String value) {
        this.msgLen = value;
    }

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
     * ��ȡmsgType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * ����msgType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgType(String value) {
        this.msgType = value;
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

    /**
     * ��ȡsvcName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvcName() {
        return svcName;
    }

    /**
     * ����svcName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvcName(String value) {
        this.svcName = value;
    }

    /**
     * ��ȡmsgAgreement���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgAgreement() {
        return msgAgreement;
    }

    /**
     * ����msgAgreement���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgAgreement(String value) {
        this.msgAgreement = value;
    }

	@Override
	public String toString() {
		return "SRVResHead [msgLen=" + msgLen + ", transCode=" + transCode + ", msgType=" + msgType + ", fileSendType="
				+ fileSendType + ", macBuf=" + macBuf + ", svcName=" + svcName + ", msgAgreement=" + msgAgreement + "]";
	}

}
