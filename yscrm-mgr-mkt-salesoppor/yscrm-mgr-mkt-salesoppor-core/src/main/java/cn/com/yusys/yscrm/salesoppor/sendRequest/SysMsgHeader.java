
package cn.com.yusys.yscrm.salesoppor.sendRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SysMsgHeader complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SysMsgHeader"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="msgId"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="msgDate"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value="\d{4}-\d{2}-\d{2}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="msgTime"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value="\d{2}:\d{2}:\d{2}.\d{3}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="servCd"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value=".+"/&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="operation"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sysCd"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value=".+"/&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="bizId"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="bizType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="orgCd"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="resCd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="resText" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bizResCd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bizResText" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ver"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="authId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="authPara" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="authContext" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pinIndex" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pinValue" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SysMsgHeader", namespace = "http://www.whrcbank.com/common/header/in", propOrder = {
    "msgId",
    "msgDate",
    "msgTime",
    "servCd",
    "operation",
    "sysCd",
    "bizId",
    "bizType",
    "orgCd",
    "resCd",
    "resText",
    "bizResCd",
    "bizResText",
    "ver",
    "authId",
    "authPara",
    "authContext",
    "pinIndex",
    "pinValue"
})
public class SysMsgHeader {

    @XmlElement(required = true)
    protected String msgId;
    @XmlElement(required = true)
    protected String msgDate;
    @XmlElement(required = true)
    protected String msgTime;
    @XmlElement(required = true)
    protected String servCd;
    @XmlElement(required = true)
    protected String operation;
    @XmlElement(required = true)
    protected String sysCd;
    @XmlElement(required = true)
    protected String bizId;
    @XmlElement(required = true)
    protected String bizType;
    @XmlElement(required = true)
    protected String orgCd;
    @XmlElement(required = true)
    protected String resCd;
    @XmlElement(required = true)
    protected String resText;
    @XmlElement(required = true)
    protected String bizResCd;
    @XmlElement(required = true)
    protected String bizResText;
    @XmlElement(required = true)
    protected String ver;
    @XmlElement(required = true)
    protected String authId;
    @XmlElement(required = true)
    protected String authPara;
    @XmlElement(required = true)
    protected String authContext;
    @XmlElement(required = true)
    protected String pinIndex;
    @XmlElement(required = true)
    protected String pinValue;

    /**
     * ��ȡmsgId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * ����msgId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgId(String value) {
        this.msgId = value;
    }

    /**
     * ��ȡmsgDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgDate() {
        return msgDate;
    }

    /**
     * ����msgDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgDate(String value) {
        this.msgDate = value;
    }

    /**
     * ��ȡmsgTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgTime() {
        return msgTime;
    }

    /**
     * ����msgTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgTime(String value) {
        this.msgTime = value;
    }

    /**
     * ��ȡservCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServCd() {
        return servCd;
    }

    /**
     * ����servCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServCd(String value) {
        this.servCd = value;
    }

    /**
     * ��ȡoperation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * ����operation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * ��ȡsysCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysCd() {
        return sysCd;
    }

    /**
     * ����sysCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysCd(String value) {
        this.sysCd = value;
    }

    /**
     * ��ȡbizId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * ����bizId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizId(String value) {
        this.bizId = value;
    }

    /**
     * ��ȡbizType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * ����bizType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizType(String value) {
        this.bizType = value;
    }

    /**
     * ��ȡorgCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgCd() {
        return orgCd;
    }

    /**
     * ����orgCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgCd(String value) {
        this.orgCd = value;
    }

    /**
     * ��ȡresCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResCd() {
        return resCd;
    }

    /**
     * ����resCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResCd(String value) {
        this.resCd = value;
    }

    /**
     * ��ȡresText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResText() {
        return resText;
    }

    /**
     * ����resText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResText(String value) {
        this.resText = value;
    }

    /**
     * ��ȡbizResCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizResCd() {
        return bizResCd;
    }

    /**
     * ����bizResCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizResCd(String value) {
        this.bizResCd = value;
    }

    /**
     * ��ȡbizResText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizResText() {
        return bizResText;
    }

    /**
     * ����bizResText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizResText(String value) {
        this.bizResText = value;
    }

    /**
     * ��ȡver���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVer() {
        return ver;
    }

    /**
     * ����ver���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVer(String value) {
        this.ver = value;
    }

    /**
     * ��ȡauthId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthId() {
        return authId;
    }

    /**
     * ����authId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthId(String value) {
        this.authId = value;
    }

    /**
     * ��ȡauthPara���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthPara() {
        return authPara;
    }

    /**
     * ����authPara���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthPara(String value) {
        this.authPara = value;
    }

    /**
     * ��ȡauthContext���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthContext() {
        return authContext;
    }

    /**
     * ����authContext���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthContext(String value) {
        this.authContext = value;
    }

    /**
     * ��ȡpinIndex���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPinIndex() {
        return pinIndex;
    }

    /**
     * ����pinIndex���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPinIndex(String value) {
        this.pinIndex = value;
    }

    /**
     * ��ȡpinValue���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPinValue() {
        return pinValue;
    }

    /**
     * ����pinValue���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPinValue(String value) {
        this.pinValue = value;
    }

	@Override
	public String toString() {
		return "SysMsgHeader [msgId=" + msgId + ", msgDate=" + msgDate + ", msgTime=" + msgTime + ", servCd=" + servCd
				+ ", operation=" + operation + ", sysCd=" + sysCd + ", bizId=" + bizId + ", bizType=" + bizType
				+ ", orgCd=" + orgCd + ", resCd=" + resCd + ", resText=" + resText + ", bizResCd=" + bizResCd
				+ ", bizResText=" + bizResText + ", ver=" + ver + ", authId=" + authId + ", authPara=" + authPara
				+ ", authContext=" + authContext + ", pinIndex=" + pinIndex + ", pinValue=" + pinValue + "]";
	}

}
