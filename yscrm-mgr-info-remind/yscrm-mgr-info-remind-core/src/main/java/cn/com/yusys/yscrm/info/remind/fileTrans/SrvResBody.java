
package cn.com.yusys.yscrm.info.remind.fileTrans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SrvResBody complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SrvResBody"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bizHeader" type="{http://www.whrcbank.com/service/bd/R14002000312}SRVResHead"/&gt;
 *         &lt;element name="bizBody" type="{http://www.whrcbank.com/service/bd/R14002000312}SrvResBizBody"/&gt;
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
     * ��ȡbizHeader���Ե�ֵ��
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
     * ����bizHeader���Ե�ֵ��
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
     * ��ȡbizBody���Ե�ֵ��
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
     * ����bizBody���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SrvResBizBody }
     *     
     */
    public void setBizBody(SrvResBizBody value) {
        this.bizBody = value;
    }

	@Override
	public String toString() {
		return "SrvResBody [bizHeader=" + bizHeader + ", bizBody=" + bizBody + "]";
	}

}
