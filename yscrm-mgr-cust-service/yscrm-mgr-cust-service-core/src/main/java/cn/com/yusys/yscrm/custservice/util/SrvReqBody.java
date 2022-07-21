
package cn.com.yusys.yscrm.custservice.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SrvReqBody complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SrvReqBody"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bizHeader" type="{http://www.whrcbank.com/service/hd/crm}SRVReqHead"/&gt;
 *         &lt;element name="bizBody" type="{http://www.whrcbank.com/service/bd/R17602003045}SrvReqBizBody"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SrvReqBody", propOrder = {
    "bizHeader",
    "bizBody"
})
public class SrvReqBody {

    @XmlElement(required = true)
    protected SRVReqHead bizHeader;
    @XmlElement(required = true)
    protected SrvReqBizBody bizBody;

    /**
     * ��ȡbizHeader���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SRVReqHead }
     *     
     */
    public SRVReqHead getBizHeader() {
        return bizHeader;
    }

    /**
     * ����bizHeader���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SRVReqHead }
     *     
     */
    public void setBizHeader(SRVReqHead value) {
        this.bizHeader = value;
    }

    /**
     * ��ȡbizBody���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SrvReqBizBody }
     *     
     */
    public SrvReqBizBody getBizBody() {
        return bizBody;
    }

    /**
     * ����bizBody���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SrvReqBizBody }
     *     
     */
    public void setBizBody(SrvReqBizBody value) {
        this.bizBody = value;
    }

	@Override
	public String toString() {
		return "SrvReqBody [bizHeader=" + bizHeader + ", bizBody=" + bizBody + "]";
	}

}
