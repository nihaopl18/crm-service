
package cn.com.yusys.yscrm.cust.person.util;

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
 *         &lt;element name="CstNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CstNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CrdtTpCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CrdtNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ValLvl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SvcLvl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CphsCtbd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CstMgrNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CstMgrMblPhNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="prodList" type="{http://www.whrcbank.com/service/bd/R17601003044}prodListType" minOccurs="0"/&gt;
 *         &lt;element name="suitProdList" type="{http://www.whrcbank.com/service/bd/R17601003044}suitProdListType" minOccurs="0"/&gt;
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
    "cstNm",
    "crdtTpCd",
    "crdtNo",
    "aum",
    "valLvl",
    "svcLvl",
    "cphsCtbd",
    "cstMgrNo",
    "cstMgrMblPhNo",
    "prodList",
    "suitProdList"
})
public class SrvResBizBody {

    @XmlElement(name = "CstNo")
    protected String cstNo;
    @XmlElement(name = "CstNm")
    protected String cstNm;
    @XmlElement(name = "CrdtTpCd")
    protected String crdtTpCd;
    @XmlElement(name = "CrdtNo")
    protected String crdtNo;
    @XmlElement(name = "AUM")
    protected String aum;
    @XmlElement(name = "ValLvl")
    protected String valLvl;
    @XmlElement(name = "SvcLvl")
    protected String svcLvl;
    @XmlElement(name = "CphsCtbd")
    protected String cphsCtbd;
    @XmlElement(name = "CstMgrNo")
    protected String cstMgrNo;
    @XmlElement(name = "CstMgrMblPhNo")
    protected String cstMgrMblPhNo;
    protected ProdListType prodList;
    protected SuitProdListType suitProdList;

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
     * ��ȡaum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUM() {
        return aum;
    }

    /**
     * ����aum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUM(String value) {
        this.aum = value;
    }

    /**
     * ��ȡvalLvl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValLvl() {
        return valLvl;
    }

    /**
     * ����valLvl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValLvl(String value) {
        this.valLvl = value;
    }

    /**
     * ��ȡsvcLvl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvcLvl() {
        return svcLvl;
    }

    /**
     * ����svcLvl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvcLvl(String value) {
        this.svcLvl = value;
    }

    /**
     * ��ȡcphsCtbd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCphsCtbd() {
        return cphsCtbd;
    }

    /**
     * ����cphsCtbd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCphsCtbd(String value) {
        this.cphsCtbd = value;
    }

    /**
     * ��ȡcstMgrNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCstMgrNo() {
        return cstMgrNo;
    }

    /**
     * ����cstMgrNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCstMgrNo(String value) {
        this.cstMgrNo = value;
    }

    /**
     * ��ȡcstMgrMblPhNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCstMgrMblPhNo() {
        return cstMgrMblPhNo;
    }

    /**
     * ����cstMgrMblPhNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCstMgrMblPhNo(String value) {
        this.cstMgrMblPhNo = value;
    }

    /**
     * ��ȡprodList���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ProdListType }
     *     
     */
    public ProdListType getProdList() {
        return prodList;
    }

    /**
     * ����prodList���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ProdListType }
     *     
     */
    public void setProdList(ProdListType value) {
        this.prodList = value;
    }

    /**
     * ��ȡsuitProdList���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SuitProdListType }
     *     
     */
    public SuitProdListType getSuitProdList() {
        return suitProdList;
    }

    /**
     * ����suitProdList���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SuitProdListType }
     *     
     */
    public void setSuitProdList(SuitProdListType value) {
        this.suitProdList = value;
    }

}
