package cn.com.yusys.yscimc.myscore.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: LoySrCustScore
 * @类描述: #用户积分表
 * @功能描述: 
 * @创建人: yangxiao2
 * @创建时间: 2019-05-31 10:50:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
/** 客户积分总表 **/
@Table(name = "LOY_SR_CUST_SCORE")
public class LoySrCustScore extends BaseDomain implements Serializable{
	
	private static final long serialVersionUID = -1717143599101576554L;
	
	/** 记录id **/
	@Id
	@Column(name = "ID")
	private long id;
	
	public long getId() { return id; }
	public void setId(long id) { this.id=id; }
	
	/** 客户号 **/
	@Column(name = "CUST_ID")
	private String custId;
	
	public String getCustId() { return custId; }
	public void setCustId(String custId) { this.custId=custId; }
	
	/** 总积分数 **/
	@Column(name = "TOTAL_NUM")
	private long totalNum;
	
	public long getTotalNum() { return totalNum; }
	public void setTotalNum(long totalNum) { this.totalNum=totalNum; }
	
	/** 可用积分数 **/
	@Column(name = "SCORE_NUM")
	private long scoreNum;
	
	public long getScoreNum() { return scoreNum; }
	public void setScoreNum(long scoreNum) { this.scoreNum=scoreNum; }
	
	/** 冻结积分数 **/
	@Column(name = "FREEZE_NUM")
	private String freezeNum;
	
	public String getFreezeNum() { return freezeNum; }
	public void setFreezeNum(String freezeNum) { this.freezeNum=freezeNum; }
	
	/** 过期积分数 **/
	@Column(name = "NUNACC_NUM")
	private double nunaccNum;
	
	public double getNunaccNum() { return nunaccNum; }
	public void setNunaccNum(double nunaccNum) { this.nunaccNum=nunaccNum; }
	
	/** 本月末失效积分 **/
	@Column(name = "NEXT_INVALID_NUM")
	private double nextInvalidNum;
	
	public double getNextInvalidNum() { return nextInvalidNum; }
	public void setNextInvalidNum(double nextInvalidNum) { this.nextInvalidNum=nextInvalidNum; }
	
	/** 兑换积分数 **/
	@Column(name = "COST_NUM")
	private double costNum;
	
	public double getCostNum() { return costNum; }
	public void setCostNum(double costNum) { this.costNum=costNum; }
	
	/** 法人机构号 **/
	@Column(name = "FR_ID")
	private String frId;
	
	public String getFrId() { return frId; }
	public void setFrId(String frId) { this.frId=frId; }
	
	/** 最近更新时间 **/
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	public Date getUpdateDate() { return updateDate; }
	public void setUpdateDate(Date updateDate) { this.updateDate=updateDate; }
}
