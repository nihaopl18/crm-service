package cn.com.yusys.yscrm.custgrade.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

/**
 */
@Entity
@Table(name = "CUST_GRADE_QUERY")//没有此表
public class CustGradeChangeQuery extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	

}
