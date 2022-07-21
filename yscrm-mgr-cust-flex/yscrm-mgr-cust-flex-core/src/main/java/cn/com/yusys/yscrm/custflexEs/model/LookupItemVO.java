package cn.com.yusys.yscrm.custflexEs.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

;

@Entity
@Table(name = "OCRM_F_ES_USER_QUERY")
public class LookupItemVO implements Serializable{

  private static final long serialVersionUID = 1975302933232497152L;



	/**
	 * 属性名
	 */
  private String notes;

	/**
	 * 字典码值
	 */
  private String colNameE;

	/**
	 * 码值编号
	 */
  private String lookupItemCode;
    /**
     * 码值名称
     */
    private String lookupItemName;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getColNameE() {
        return colNameE;
    }

    public void setColNameE(String colNameE) {
        this.colNameE = colNameE;
    }

    public String getLookupItemCode() {
        return lookupItemCode;
    }

    public void setLookupItemCode(String lookupItemCode) {
        this.lookupItemCode = lookupItemCode;
    }

    public String getLookupItemName() {
        return lookupItemName;
    }

    public void setLookupItemName(String lookupItemName) {
        this.lookupItemName = lookupItemName;
    }
}
