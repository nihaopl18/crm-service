
package cn.com.yusys.yscrm.salesoppor.interfaces;

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
 *         &lt;element name="CstNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BsiPttsNm"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BsiPttsTpCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BisPttsPrd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BsiPttsCont"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BsiPttsValid"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BsiPttsTlr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "cstNo",
    "bsiPttsNm",
    "bsiPttsTpCd",
    "bisPttsPrd",
    "bsiPttsCont",
    "bsiPttsValid",
    "bsiPttsTlr"
})
public class SrvReqBizBody {

    @XmlElement(name = "CstNo", required = true)
    protected String cstNo;
    @XmlElement(name = "BsiPttsNm", required = true)
    protected String bsiPttsNm;
    @XmlElement(name = "BsiPttsTpCd")
    protected String bsiPttsTpCd;
    @XmlElement(name = "BisPttsPrd")
    protected String bisPttsPrd;
    @XmlElement(name = "BsiPttsCont", required = true)
    protected String bsiPttsCont;
    @XmlElement(name = "BsiPttsValid", required = true)
    protected String bsiPttsValid;
    @XmlElement(name = "BsiPttsTlr")
    protected String bsiPttsTlr;

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
     * ��ȡbsiPttsNm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBsiPttsNm() {
        return bsiPttsNm;
    }

    /**
     * ����bsiPttsNm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBsiPttsNm(String value) {
        this.bsiPttsNm = value;
    }

    /**
     * ��ȡbsiPttsTpCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBsiPttsTpCd() {
        return bsiPttsTpCd;
    }

    /**
     * ����bsiPttsTpCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBsiPttsTpCd(String value) {
        this.bsiPttsTpCd = value;
    }

    /**
     * ��ȡbisPttsPrd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBisPttsPrd() {
        return bisPttsPrd;
    }

    /**
     * ����bisPttsPrd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBisPttsPrd(String value) {
        this.bisPttsPrd = value;
    }

    /**
     * ��ȡbsiPttsCont���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBsiPttsCont() {
        return bsiPttsCont;
    }

    /**
     * ����bsiPttsCont���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBsiPttsCont(String value) {
        this.bsiPttsCont = value;
    }

    /**
     * ��ȡbsiPttsValid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBsiPttsValid() {
        return bsiPttsValid;
    }

    /**
     * ����bsiPttsValid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBsiPttsValid(String value) {
        this.bsiPttsValid = value;
    }

    /**
     * ��ȡbsiPttsTlr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBsiPttsTlr() {
        return bsiPttsTlr;
    }

    /**
     * ����bsiPttsTlr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBsiPttsTlr(String value) {
        this.bsiPttsTlr = value;
    }

	@Override
	public String toString() {
		return "SrvReqBizBody [cstNo=" + cstNo + ", bsiPttsNm=" + bsiPttsNm + ", bsiPttsTpCd=" + bsiPttsTpCd
				+ ", bisPttsPrd=" + bisPttsPrd + ", bsiPttsCont=" + bsiPttsCont + ", bsiPttsValid=" + bsiPttsValid
				+ ", bsiPttsTlr=" + bsiPttsTlr + "]";
	}

}
