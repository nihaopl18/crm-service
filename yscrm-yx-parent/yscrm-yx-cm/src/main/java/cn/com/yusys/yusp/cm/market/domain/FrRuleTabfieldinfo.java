package cn.com.yusys.yusp.cm.market.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 
 */
@Table(name="FR_RULE_TABFIELDINFO")
public class FrRuleTabfieldinfo extends BaseDomain implements Serializable {
	
	@Id
	@Generated(GenerationType.UUID)
	@Column(name="TAB_NAME")
	private String tabName;

    private String fieldName;
    
    private String fieldDesc;

    private String fieldType;

    private Integer fieldLen;

    private Integer fieldScale;

    private Long seqNo;

    private String keyFlag;

    private String defValue;
    
    private String nvlFlag;

    private static final long serialVersionUID = 1L;

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }
    
    public String getNvlFlag() {
        return nvlFlag;
    }

    public void setNvlFlag(String nvlFlag) {
        this.nvlFlag = nvlFlag;
    }
    
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    
    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Integer getFieldLen() {
        return fieldLen;
    }

    public void setFieldLen(Integer fieldLen) {
        this.fieldLen = fieldLen;
    }

    public Integer getFieldScale() {
        return fieldScale;
    }

    public void setFieldScale(Integer fieldScale) {
        this.fieldScale = fieldScale;
    }

    public Long getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Long seqNo) {
        this.seqNo = seqNo;
    }

    public String getKeyFlag() {
        return keyFlag;
    }

    public void setKeyFlag(String keyFlag) {
        this.keyFlag = keyFlag;
    }

    public String getDefValue() {
        return defValue;
    }

    public void setDefValue(String defValue) {
        this.defValue = defValue;
    }

}
