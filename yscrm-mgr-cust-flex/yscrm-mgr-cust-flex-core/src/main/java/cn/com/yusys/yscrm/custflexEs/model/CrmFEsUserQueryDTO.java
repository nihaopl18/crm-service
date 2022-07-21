package cn.com.yusys.yscrm.custflexEs.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

;

@Entity
public class CrmFEsUserQueryDTO implements Serializable{

    private static final long serialVersionUID = 1975302933232497152L;



    /**
     * 属性
     */
    private String attributeNo;

    /**
     * 属性名称
     */
    private String attributeName;

    /**
     * 操作符
     */
    private String operatorNo;

    /**
     * 操作符名称
     */
    private String operatorName;

    /**
     * 属性值
     */
    private String attributeValue;
    /**
     * 属性id
     */
    private String id;

    /**
     * 属性类型
     */
    private String fieldType;
    /**
     * 属性值类型
     */
    private String items;
    /**
     * 操作符类型
     */
    private String sections;
    public String getAttributeNo() {
        return attributeNo;
    }

    public void setAttributeNo(String attributeNo) {
        this.attributeNo = attributeNo;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getSections() {
        return sections;
    }

    public void setSections(String sections) {
        this.sections = sections;
    }
}
