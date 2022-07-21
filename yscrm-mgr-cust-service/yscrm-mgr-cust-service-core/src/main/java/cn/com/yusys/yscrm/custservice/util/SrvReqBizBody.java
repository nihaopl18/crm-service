
package cn.com.yusys.yscrm.custservice.util;

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
 *         &lt;element name="FreeBackTpCd"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PcsInd"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FreeBackChnl"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FreeBackTitle"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FreeBackCont"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *               &lt;pattern value=".+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FreeBackCst"&gt;
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
    "cstNo",
    "freeBackTpCd",
    "pcsInd",
    "freeBackChnl",
    "freeBackTitle",
    "freeBackCont",
    "freeBackCst"
})
public class SrvReqBizBody {

    @XmlElement(name = "CstNo", required = true)
    protected String cstNo;
    @XmlElement(name = "FreeBackTpCd", required = true)
    protected String freeBackTpCd;
    @XmlElement(name = "PcsInd", required = true)
    protected String pcsInd;
    @XmlElement(name = "FreeBackChnl", required = true)
    protected String freeBackChnl;
    @XmlElement(name = "FreeBackTitle", required = true)
    protected String freeBackTitle;
    @XmlElement(name = "FreeBackCont", required = true)
    protected String freeBackCont;
    @XmlElement(name = "FreeBackCst", required = true)
    protected String freeBackCst;

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
     * ��ȡfreeBackTpCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeBackTpCd() {
        return freeBackTpCd;
    }

    /**
     * ����freeBackTpCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeBackTpCd(String value) {
        this.freeBackTpCd = value;
    }

    /**
     * ��ȡpcsInd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPcsInd() {
        return pcsInd;
    }

    /**
     * ����pcsInd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPcsInd(String value) {
        this.pcsInd = value;
    }

    /**
     * ��ȡfreeBackChnl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeBackChnl() {
        return freeBackChnl;
    }

    /**
     * ����freeBackChnl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeBackChnl(String value) {
        this.freeBackChnl = value;
    }

    /**
     * ��ȡfreeBackTitle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeBackTitle() {
        return freeBackTitle;
    }

    /**
     * ����freeBackTitle���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeBackTitle(String value) {
        this.freeBackTitle = value;
    }

    /**
     * ��ȡfreeBackCont���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeBackCont() {
        return freeBackCont;
    }

    /**
     * ����freeBackCont���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeBackCont(String value) {
        this.freeBackCont = value;
    }

    /**
     * ��ȡfreeBackCst���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeBackCst() {
        return freeBackCst;
    }

    /**
     * ����freeBackCst���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeBackCst(String value) {
        this.freeBackCst = value;
    }

	@Override
	public String toString() {
		return "SrvReqBizBody [cstNo=" + cstNo + ", freeBackTpCd=" + freeBackTpCd + ", pcsInd=" + pcsInd
				+ ", freeBackChnl=" + freeBackChnl + ", freeBackTitle=" + freeBackTitle + ", freeBackCont="
				+ freeBackCont + ", freeBackCst=" + freeBackCst + "]";
	}

}
