
package cn.com.yusys.yscrm.cust.person.util;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>prodListType complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="prodListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="prod" type="{http://www.whrcbank.com/service/bd/R17601003044}prodType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prodListType", propOrder = {
    "prod"
})
public class ProdListType {

    protected List<ProdType> prod;

    /**
     * Gets the value of the prod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProdType }
     * 
     * 
     */
    public List<ProdType> getProd() {
        if (prod == null) {
            prod = new ArrayList<ProdType>();
        }
        return this.prod;
    }

	@Override
	public String toString() {
		return "ProdListType [prod=" + prod + "]";
	}

}
