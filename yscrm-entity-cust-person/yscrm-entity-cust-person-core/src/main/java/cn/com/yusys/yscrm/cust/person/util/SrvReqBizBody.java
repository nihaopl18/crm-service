
package cn.com.yusys.yscrm.cust.person.util;

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
 *         &lt;element name="CstNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CstNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CrdtTpCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CrdtNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "cstNm",
    "crdtTpCd",
    "crdtNo",
    "accNo"
})
public class SrvReqBizBody {

    @XmlElement(name = "CstNo")
    protected String cstNo;
    @XmlElement(name = "CstNm")
    protected String cstNm;
    @XmlElement(name = "CrdtTpCd")
    protected String crdtTpCd;
    @XmlElement(name = "CrdtNo")
    protected String crdtNo;
    @XmlElement(name = "AccNo")
    protected String accNo;

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
     * ��ȡcstNm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCstNm() {
        return cstNm;
    }

    /**
     * ����cstNm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCstNm(String value) {
        this.cstNm = value;
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

	@Override
	public String toString() {
		return "SrvReqBizBody [cstNo=" + cstNo + ", cstNm=" + cstNm + ", crdtTpCd=" + crdtTpCd + ", crdtNo=" + crdtNo
				+ ", accNo=" + accNo + "]";
	}

}
