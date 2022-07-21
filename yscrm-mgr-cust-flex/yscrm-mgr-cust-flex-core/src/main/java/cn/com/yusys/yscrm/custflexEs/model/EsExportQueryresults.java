package cn.com.yusys.yscrm.custflexEs.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

;

@Entity
@Table(name = "OCRM_F_ES_EXPORT_QUERY")
public class EsExportQueryresults implements Serializable{

  private static final long serialVersionUID = 1650545428142808064L;


	/**
	 * 排序值
	 */
  private String sortType;

	/**
	 * 展示字段名称
	 */
  private String columnEName;

	/**
	 * 类型
	 */
  private String fieldType;
    /**
     * 展示字段中文名称
     */
    private String columnName;
    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getColumnEName() {
        return columnEName;
    }

    public void setColumnEName(String columnEName) {
        this.columnEName = columnEName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
