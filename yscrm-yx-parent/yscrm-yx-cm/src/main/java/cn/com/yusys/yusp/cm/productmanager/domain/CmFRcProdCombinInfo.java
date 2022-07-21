package cn.com.yusys.yusp.cm.productmanager.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CM_F_RC_PROD_COMBIN")
public class CmFRcProdCombinInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private String id;
	
	public String getId() { return id; }
	public void setId(String id) { this.id=id; }
	
	@Column(name="PRODUCT_ID")
	private String productId;
	
	public String getProductId() { return productId; }
	public void setProductId(String productId) { this.productId=productId; }
	
	@Column(name="PARENT_PROD_ID")
	private String parentProdId;
	
	public String getParentProdId() { return parentProdId; }
	public void setParentProdId(String parentProdId) { this.parentProdId=parentProdId; }
	
	@Column(name="PARENT_PROD_NAME")
	private String parentProdName;
	
	public String getParentProdName() { return parentProdName; }
	public void setParentProdName(String parentProdName) { this.parentProdName=parentProdName; }
	
	@Column(name="PARENT_PROD_RISK")
	private String parentProdRisk;
	
	public String getParentProdRisk() { return parentProdRisk; }	
	public void setParentProdRisk(String parentProdRisk) { this.parentProdRisk=parentProdRisk; }
	
	@Column(name="PARENT_PROD_INCOME")
	private String parentProdIncome;
	
	public String getParentProdIncome() { return parentProdIncome; }
	public void setParentProdIncome(String parentProdIncome) { this.parentProdIncome=parentProdIncome; }
	
	@Column(name="PARENT_PROD_WEIGHT")
	private String parentProdWeight;
	
	public String getParentProdWeight() { return parentProdWeight; }
	public void setParentProdWeight(String parentProdWeight) { this.parentProdWeight=parentProdWeight; }
	
	@Column(name="CREAT_USER")
	private String creatUser;
	
	public String getCreatUser() { return creatUser; }
	public void setCreatUser(String creatUser) { this.creatUser=creatUser; }
	
	@Column(name="CREAT_DATE")
	private Date creatDate;
	
	public Date getCreatDate() { return creatDate; }
	public void setCreatDate(Date creatDate) { this.creatDate=creatDate; }
	
	@Column(name="UPDATA_USER")
	private String updataUser;
	
	public String getUpdataUser() { return updataUser; }
	public void setUpdataUser(String updataUser) { this.updataUser=updataUser; }
	
	@Column(name="UPDATA_DATE")
	private Date updataDate;
	
	public Date getUpdataDate() { return updataDate; }
	public void setUpdataDate(Date updataDate) { this.updataDate=updataDate; }
	
}
