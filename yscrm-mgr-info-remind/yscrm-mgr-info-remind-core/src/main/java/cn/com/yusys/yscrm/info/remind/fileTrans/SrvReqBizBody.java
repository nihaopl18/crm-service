
package cn.com.yusys.yscrm.info.remind.fileTrans;

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
 *         &lt;element name="localAppCode"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="localNodeCode"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="localFilePath"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="localFileName"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="remoteAppCode"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="remoteNodeCode"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="remoteFilePath"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="remoteFileName"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="transFlag"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="isEncrypt"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="isCompress"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="isPassServer"&gt;
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
@XmlType(name = "SrvReqBizBody", propOrder = {
    "localAppCode",
    "localNodeCode",
    "localFilePath",
    "localFileName",
    "remoteAppCode",
    "remoteNodeCode",
    "remoteFilePath",
    "remoteFileName",
    "transFlag",
    "isEncrypt",
    "isCompress",
    "isPassServer"
})
public class SrvReqBizBody {

    @XmlElement(required = true)
    protected String localAppCode;
    @XmlElement(required = true)
    protected String localNodeCode;
    @XmlElement(required = true)
    protected String localFilePath;
    @XmlElement(required = true)
    protected String localFileName;
    @XmlElement(required = true)
    protected String remoteAppCode;
    @XmlElement(required = true)
    protected String remoteNodeCode;
    @XmlElement(required = true)
    protected String remoteFilePath;
    @XmlElement(required = true)
    protected String remoteFileName;
    @XmlElement(required = true)
    protected String transFlag;
    @XmlElement(required = true)
    protected String isEncrypt;
    @XmlElement(required = true)
    protected String isCompress;
    @XmlElement(required = true)
    protected String isPassServer;

    /**
     * ��ȡlocalAppCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalAppCode() {
        return localAppCode;
    }

    /**
     * ����localAppCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalAppCode(String value) {
        this.localAppCode = value;
    }

    /**
     * ��ȡlocalNodeCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalNodeCode() {
        return localNodeCode;
    }

    /**
     * ����localNodeCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalNodeCode(String value) {
        this.localNodeCode = value;
    }

    /**
     * ��ȡlocalFilePath���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalFilePath() {
        return localFilePath;
    }

    /**
     * ����localFilePath���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalFilePath(String value) {
        this.localFilePath = value;
    }

    /**
     * ��ȡlocalFileName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalFileName() {
        return localFileName;
    }

    /**
     * ����localFileName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalFileName(String value) {
        this.localFileName = value;
    }

    /**
     * ��ȡremoteAppCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteAppCode() {
        return remoteAppCode;
    }

    /**
     * ����remoteAppCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteAppCode(String value) {
        this.remoteAppCode = value;
    }

    /**
     * ��ȡremoteNodeCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteNodeCode() {
        return remoteNodeCode;
    }

    /**
     * ����remoteNodeCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteNodeCode(String value) {
        this.remoteNodeCode = value;
    }

    /**
     * ��ȡremoteFilePath���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteFilePath() {
        return remoteFilePath;
    }

    /**
     * ����remoteFilePath���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteFilePath(String value) {
        this.remoteFilePath = value;
    }

    /**
     * ��ȡremoteFileName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteFileName() {
        return remoteFileName;
    }

    /**
     * ����remoteFileName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteFileName(String value) {
        this.remoteFileName = value;
    }

    /**
     * ��ȡtransFlag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransFlag() {
        return transFlag;
    }

    /**
     * ����transFlag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransFlag(String value) {
        this.transFlag = value;
    }

    /**
     * ��ȡisEncrypt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsEncrypt() {
        return isEncrypt;
    }

    /**
     * ����isEncrypt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsEncrypt(String value) {
        this.isEncrypt = value;
    }

    /**
     * ��ȡisCompress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsCompress() {
        return isCompress;
    }

    /**
     * ����isCompress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsCompress(String value) {
        this.isCompress = value;
    }

    /**
     * ��ȡisPassServer���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsPassServer() {
        return isPassServer;
    }

    /**
     * ����isPassServer���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsPassServer(String value) {
        this.isPassServer = value;
    }

	@Override
	public String toString() {
		return "SrvReqBizBody [localAppCode=" + localAppCode + ", localNodeCode=" + localNodeCode + ", localFilePath="
				+ localFilePath + ", localFileName=" + localFileName + ", remoteAppCode=" + remoteAppCode
				+ ", remoteNodeCode=" + remoteNodeCode + ", remoteFilePath=" + remoteFilePath + ", remoteFileName="
				+ remoteFileName + ", transFlag=" + transFlag + ", isEncrypt=" + isEncrypt + ", isCompress="
				+ isCompress + ", isPassServer=" + isPassServer + "]";
	}

}
