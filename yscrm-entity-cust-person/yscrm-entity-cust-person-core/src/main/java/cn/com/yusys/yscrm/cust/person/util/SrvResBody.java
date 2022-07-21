
package cn.com.yusys.yscrm.cust.person.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SrvResBody complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SrvResBody"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bizHeader" type="{http://www.whrcbank.com/service/hd/crm}SRVResHead"/&gt;
 *         &lt;element name="bizBody" type="{http://www.whrcbank.com/service/bd/R17601003044}SrvResBizBody"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SrvResBody", propOrder = {
    "bizHeader",
    "bizBody"
})
public class SrvResBody {

    @XmlElement(required = true)
    protected SRVResHead bizHeader;
    @XmlElement(required = true)
    protected SrvResBizBody bizBody;

    /**
     * 获取bizHeader属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SRVResHead }
     *     
     */
    public SRVResHead getBizHeader() {
        return bizHeader;
    }

    /**
     * 设置bizHeader属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SRVResHead }
     *     
     */
    public void setBizHeader(SRVResHead value) {
        this.bizHeader = value;
    }

    /**
     * 获取bizBody属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SrvResBizBody }
     *     
     */
    public SrvResBizBody getBizBody() {
        return bizBody;
    }

    /**
     * 设置bizBody属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SrvResBizBody }
     *     
     */
    public void setBizBody(SrvResBizBody value) {
        this.bizBody = value;
    }

}
