package cn.com.yusys.yscimc.luckdraw.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimcAppLuckDrawCusts
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: zhanghan2
 * @创建时间: 2019-06-19 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "CMIC_APP_LUCK_CUST_HIS")
public class CmicAppLuckCustHis extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 编号 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 抽奖客户信息ID **/
	@Column(name = "DRAW_CUST_ID")
	private String drawCustId;
	
	/** 奖品ID **/
	@Column(name = "PRIZE_ID")
	private String prizeId;
	
	/** 创建日期 **/
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 20)
	private Date cratDt;
	
	/** 奖品名称  **/
	@Column(name = "PRIZE_NAME")
	private String prizeName;
	
	/** NODE_ID **/
	@Column(name = "NODE_ID", unique = false, nullable = true, length = 100)
	private String nodeId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDrawCustId() {
		return drawCustId;
	}

	public void setDrawCustId(String drawCustId) {
		this.drawCustId = drawCustId;
	}

	public String getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(String prizeId) {
		this.prizeId = prizeId;
	}

	public Date getCratDt() {
		return cratDt;
	}

	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
}
