package cn.com.yusys.yscrm.custflexEs.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

;

@Entity
@Table(name = "OCRM_F_ES_EXPORT_QUERY")
public class CrmFEsExportZhQuery implements Serializable{

  private static final long serialVersionUID = 1650545428142808064L;

	/**
	 * id
	 */
  private String seqno;


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
	 * 创建人
	 */
  private String createUser;

	/**
	 * 创建时间
	 */
  private String createDate;

    /**
     * 展示字段中文名称
     */
  private String columnName;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getSeqno() {
        return seqno;
    }

    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }

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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
