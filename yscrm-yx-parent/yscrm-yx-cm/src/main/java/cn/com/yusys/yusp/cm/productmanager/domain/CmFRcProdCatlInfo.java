package cn.com.yusys.yusp.cm.productmanager.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CM_F_RC_PROD_CATL")
public class CmFRcProdCatlInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CATL_CODE")
	private long catlCode;
	
	public long getCatlCode() { return catlCode; }
	public void setCatlCode(long catlCode) { this.catlCode=catlCode; }
	
	@Column(name="CATL_NAME")
	private String catlName;
	
	public String getCatlName() { return catlName; }
	public void setCatlName(String catlName) { this.catlName=catlName; }
	
	@Column(name="CATL_PARENT")
	private long catlParent;
	
	public long getCatlParent() { return catlParent; }
	public void setCatlParent(long catlParent) { this.catlParent=catlParent; }
	
	@Column(name="CATL_LEVEL")
	private int catlLevel;
	
	public int getCatlLevel() { return catlLevel; }
	public void setCatlLevel(int catlLevel) { this.catlLevel=catlLevel; }
	
	@Column(name="CATL_ORDER")
	private int catlOrder;
	
	public int getCatlOrder() { return catlOrder; }
	public void setCatlOrder(int catlOrder) { this.catlOrder=catlOrder; }
	
	@Column(name="VIEW_DETAIL")
	private String viewDetail;
	
	public String getViewDetail() { return viewDetail; }
	public void setViewDetail(String viewDetail) { this.viewDetail=viewDetail; }
	
	@Column(name="CATL_BUS_ID")
	private String catlBusId;
	
	public String getCatlBusId() { return catlBusId; }
	public void setCatlBusId(String catlBusId) { this.catlBusId=catlBusId; }
	
	@Column(name="PROD_VIEW")
	private String prodView;
	
	public String getProdView() { return prodView; }
	public void setProdView(String prodView) { this.prodView=prodView; }
	
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
