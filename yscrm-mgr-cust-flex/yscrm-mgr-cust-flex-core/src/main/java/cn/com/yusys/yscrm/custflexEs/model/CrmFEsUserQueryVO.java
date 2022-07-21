package cn.com.yusys.yscrm.custflexEs.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

;

@Entity
@Table(name = "OCRM_F_ES_USER_QUERY")
public class CrmFEsUserQueryVO implements Serializable{
    private static final long serialVersionUID = 1975302933232497152L;

    /**
     * id
     */
    private String seqno;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

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
     * 类型（01：查询条件  02：展示列）
     */
    private String queryType;

    /**
     * 更新时间
     */
    private String updateDate;

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
    public String getSeqno() {
        return seqno;
    }

    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


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


    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }


    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
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
