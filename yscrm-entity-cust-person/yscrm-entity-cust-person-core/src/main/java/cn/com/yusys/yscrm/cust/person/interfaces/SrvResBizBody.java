
package cn.com.yusys.yscrm.cust.person.interfaces;

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
 *         &lt;element name="CstNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ClrDt"&gt;
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
 *         &lt;element name="OpenBrc"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AccNm"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CcyCd"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DepBal"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AvlBal"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CrdtTpCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CrdtNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccSt"&gt;
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
    "cstNo",
    "clrDt",
    "rspCode",
    "openBrc",
    "accNm",
    "ccyCd",
    "depBal",
    "avlBal",
    "crdtTpCd",
    "crdtNo",
    "accSt",
    "rspMsg",
    "ntcInf"
})
public class SrvResBizBody {

    @XmlElement(name = "CstNo", required = true)
    protected String cstNo;
    @XmlElement(name = "ClrDt", required = true)
    protected String clrDt;
    @XmlElement(name = "RspCode", required = true)
    protected String rspCode;
    @XmlElement(name = "OpenBrc", required = true)
    protected String openBrc;
    @XmlElement(name = "AccNm", required = true)
    protected String accNm;
    @XmlElement(name = "CcyCd", required = true)
    protected String ccyCd;
    @XmlElement(name = "DepBal", required = true)
    protected String depBal;
    @XmlElement(name = "AvlBal", required = true)
    protected String avlBal;
    @XmlElement(name = "CrdtTpCd")
    protected String crdtTpCd;
    @XmlElement(name = "CrdtNo")
    protected String crdtNo;
    @XmlElement(name = "AccSt", required = true)
    protected String accSt;
    @XmlElement(name = "RspMsg", required = true)
    protected String rspMsg;
    @XmlElement(name = "NtcInf", required = true)
    protected String ntcInf;

    /**
     * ��ȡcstNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCstNo() {
        return cstNo;
    }

    /**
     * ����cstNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCstNo(String value) {
        this.cstNo = value;
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
     * ��ȡopenBrc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpenBrc() {
        return openBrc;
    }

    /**
     * ����openBrc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpenBrc(String value) {
        this.openBrc = value;
    }

    /**
     * ��ȡaccNm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccNm() {
        return accNm;
    }

    /**
     * ����accNm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccNm(String value) {
        this.accNm = value;
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
     * ��ȡdepBal���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepBal() {
        return depBal;
    }

    /**
     * ����depBal���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepBal(String value) {
        this.depBal = value;
    }

    /**
     * ��ȡavlBal���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvlBal() {
        return avlBal;
    }

    /**
     * ����avlBal���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvlBal(String value) {
        this.avlBal = value;
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
     * ��ȡaccSt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccSt() {
        return accSt;
    }

    /**
     * ����accSt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccSt(String value) {
        this.accSt = value;
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
		return "SrvResBizBody [cstNo=" + cstNo + ", clrDt=" + clrDt + ", rspCode=" + rspCode + ", openBrc=" + openBrc
				+ ", accNm=" + accNm + ", ccyCd=" + ccyCd + ", depBal=" + depBal + ", avlBal=" + avlBal + ", crdtTpCd="
				+ crdtTpCd + ", crdtNo=" + crdtNo + ", accSt=" + accSt + ", rspMsg=" + rspMsg + ", ntcInf=" + ntcInf
				+ "]";
	}

}
