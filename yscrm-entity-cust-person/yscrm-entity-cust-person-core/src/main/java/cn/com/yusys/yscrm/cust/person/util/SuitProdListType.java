
package cn.com.yusys.yscrm.cust.person.util;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>suitProdListType complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="suitProdListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="suitProd" type="{http://www.whrcbank.com/service/bd/R17601003044}suitProdType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "suitProdListType", propOrder = {
    "suitProd"
})
public class SuitProdListType {

    protected List<SuitProdType> suitProd;

    /**
     * Gets the value of the suitProd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the suitProd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSuitProd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SuitProdType }
     * 
     * 
     */
    public List<SuitProdType> getSuitProd() {
        if (suitProd == null) {
            suitProd = new ArrayList<SuitProdType>();
        }
        return this.suitProd;
    }

	@Override
	public String toString() {
		return "SuitProdListType [suitProd=" + suitProd + "]";
	}

}
