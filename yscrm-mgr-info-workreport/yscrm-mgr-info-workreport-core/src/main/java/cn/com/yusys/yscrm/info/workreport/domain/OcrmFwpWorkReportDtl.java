package cn.com.yusys.yscrm.info.workreport.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-mgr-info-workreport-core模块
 * @类名称: OcrmFwpWorkReportDtl
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Bronze
 * @创建时间: 2019-01-29 17:00:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_WORK_REPORT_DTL")
public class OcrmFwpWorkReportDtl extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 报告编号 **/
	@Column(name = "REPORT_ID", unique = false, nullable = true, length = 32)
	private String reportId;
	
	/** 报告周期 **/
	@Column(name = "REPORT_CYCLE", unique = false, nullable = true, length = 30)
	private String reportCycle;
	
	/** 日/周/月提升客户数 **/
	@Column(name = "REPORT_SUB", unique = false, nullable = true, length = 10)
	private long reportSub;
	
	/** 日/周/月维护客户数 **/
	@Column(name = "REPORT_SUB1", unique = false, nullable = true, length = 10)
	private long reportSub1;
	
	/** 日/周/月新增管户客户数 **/
	@Column(name = "REPORT_SUB2", unique = false, nullable = true, length = 10)
	private long reportSub2;
	
	/** 日/周/月新增潜在客户数 **/
	@Column(name = "REPORT_SUB3", unique = false, nullable = true, length = 10)
	private long reportSub3;
	
	/** 日/周/月接触客户次数 **/
	@Column(name = "REPORT_SUB4", unique = false, nullable = true, length = 10)
	private long reportSub4;
	
	/** 日/周/月联系活动接触次数 **/
	@Column(name = "REPORT_SUB5", unique = false, nullable = true, length = 10)
	private long reportSub5;
	
	/** 日/周/月拜访客户次数 **/
	@Column(name = "REPORT_SUB6", unique = false, nullable = true, length = 10)
	private long reportSub6;
	
	/** 日/周/月接待客户次数 **/
	@Column(name = "REPORT_SUB7", unique = false, nullable = true, length = 10)
	private long reportSub7;
	
	/** 日/周/月接触客户电话次数 **/
	@Column(name = "REPORT_SUB8", unique = false, nullable = true, length = 10)
	private long reportSub8;
	
	/** 日/周/月接触发送短信次数 **/
	@Column(name = "REPORT_SUB9", unique = false, nullable = true, length = 10)
	private long reportSub9;
	
	/** 日/周/月接触发送微信次数 **/
	@Column(name = "REPORT_SUB10", unique = false, nullable = true, length = 10)
	private long reportSub10;
	
	/** 日/周/月接触发送邮件次数 **/
	@Column(name = "REPORT_SUB11", unique = false, nullable = true, length = 10)
	private long reportSub11;
	
	/** 日/周/月接触发送QQ次数 **/
	@Column(name = "REPORT_SUB12", unique = false, nullable = true, length = 10)
	private long reportSub12;
	
	/** 日/周/月新增管理资产余额 **/
	@Column(name = "REPORT_SUB13", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal reportSub13;
	
	/** 日/周/月销售理财产品金额 **/
	@Column(name = "REPORT_SUB14", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal reportSub14;
	
	/** 日/周/月新增销售保险额度 **/
	@Column(name = "REPORT_SUB15", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal reportSub15;
	
	/** 日/周/月新增贷款余额 **/
	@Column(name = "REPORT_SUB16", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal reportSub16;
	
	/** 日/周/月新增存款余额 **/
	@Column(name = "REPORT_SUB17", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal reportSub17;
	
	/** 日/周/月新增其他中间业务产品 **/
	@Column(name = "REPORT_SUB18", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal reportSub18;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
	}
	
	/**
	 * @param reportId
	 */
	public void setreportId(String reportId) {
		this.reportId = reportId == null ? null : reportId.trim();
	}
	
    /**
     * @return reportId
     */	
	public String getreportId() {
		return this.reportId;
	}
	
	/**
	 * @param reportCycle
	 */
	public void setReportCycle(String reportCycle) {
		this.reportCycle = reportCycle == null ? null : reportCycle.trim();
	}
	
    /**
     * @return ReportCycle
     */	
	public String getReportCycle() {
		return this.reportCycle;
	}
	
	/**
	 * @param reportSub
	 */
	public void setReportSub(long reportSub) {
		this.reportSub = reportSub;
	}
	
    /**
     * @return ReportSub
     */	
	public long getReportSub() {
		return this.reportSub;
	}
	
	/**
	 * @param reportSub1
	 */
	public void setReportSub1(long reportSub1) {
		this.reportSub1 = reportSub1;
	}
	
    /**
     * @return ReportSub1
     */	
	public long getReportSub1() {
		return this.reportSub1;
	}
	
	/**
	 * @param reportSub2
	 */
	public void setReportSub2(long reportSub2) {
		this.reportSub2 = reportSub2;
	}
	
    /**
     * @return ReportSub2
     */	
	public long getReportSub2() {
		return this.reportSub2;
	}
	
	/**
	 * @param reportSub3
	 */
	public void setReportSub3(long reportSub3) {
		this.reportSub3 = reportSub3;
	}
	
    /**
     * @return ReportSub3
     */	
	public long getReportSub3() {
		return this.reportSub3;
	}
	
	/**
	 * @param reportSub4
	 */
	public void setReportSub4(long reportSub4) {
		this.reportSub4 = reportSub4;
	}
	
    /**
     * @return ReportSub4
     */	
	public long getReportSub4() {
		return this.reportSub4;
	}
	
	/**
	 * @param reportSub5
	 */
	public void setReportSub5(long reportSub5) {
		this.reportSub5 = reportSub5;
	}
	
    /**
     * @return ReportSub5
     */	
	public long getReportSub5() {
		return this.reportSub5;
	}
	
	/**
	 * @param reportSub6
	 */
	public void setReportSub6(long reportSub6) {
		this.reportSub6 = reportSub6;
	}
	
    /**
     * @return ReportSub6
     */	
	public long getReportSub6() {
		return this.reportSub6;
	}
	
	/**
	 * @param reportSub7
	 */
	public void setReportSub7(long reportSub7) {
		this.reportSub7 = reportSub7;
	}
	
    /**
     * @return ReportSub7
     */	
	public long getReportSub7() {
		return this.reportSub7;
	}
	
	/**
	 * @param reportSub8
	 */
	public void setReportSub8(long reportSub8) {
		this.reportSub8 = reportSub8;
	}
	
    /**
     * @return ReportSub8
     */	
	public long getReportSub8() {
		return this.reportSub8;
	}
	
	/**
	 * @param reportSub9
	 */
	public void setReportSub9(long reportSub9) {
		this.reportSub9 = reportSub9;
	}
	
    /**
     * @return ReportSub9
     */	
	public long getReportSub9() {
		return this.reportSub9;
	}
	
	/**
	 * @param reportSub10
	 */
	public void setReportSub10(long reportSub10) {
		this.reportSub10 = reportSub10;
	}
	
    /**
     * @return ReportSub10
     */	
	public long getReportSub10() {
		return this.reportSub10;
	}
	
	/**
	 * @param reportSub11
	 */
	public void setReportSub11(long reportSub11) {
		this.reportSub11 = reportSub11;
	}
	
    /**
     * @return ReportSub11
     */	
	public long getReportSub11() {
		return this.reportSub11;
	}
	
	/**
	 * @param reportSub12
	 */
	public void setReportSub12(long reportSub12) {
		this.reportSub12 = reportSub12;
	}
	
    /**
     * @return ReportSub12
     */	
	public long getReportSub12() {
		return this.reportSub12;
	}
	
	/**
	 * @param reportSub13
	 */
	public void setReportSub13(java.math.BigDecimal reportSub13) {
		this.reportSub13 = reportSub13;
	}
	
    /**
     * @return ReportSub13
     */	
	public java.math.BigDecimal getReportSub13() {
		return this.reportSub13;
	}
	
	/**
	 * @param reportSub14
	 */
	public void setReportSub14(java.math.BigDecimal reportSub14) {
		this.reportSub14 = reportSub14;
	}
	
    /**
     * @return ReportSub14
     */	
	public java.math.BigDecimal getReportSub14() {
		return this.reportSub14;
	}
	
	/**
	 * @param reportSub15
	 */
	public void setReportSub15(java.math.BigDecimal reportSub15) {
		this.reportSub15 = reportSub15;
	}
	
    /**
     * @return ReportSub15
     */	
	public java.math.BigDecimal getReportSub15() {
		return this.reportSub15;
	}
	
	/**
	 * @param reportSub16
	 */
	public void setReportSub16(java.math.BigDecimal reportSub16) {
		this.reportSub16 = reportSub16;
	}
	
    /**
     * @return ReportSub16
     */	
	public java.math.BigDecimal getReportSub16() {
		return this.reportSub16;
	}
	
	/**
	 * @param reportSub17
	 */
	public void setReportSub17(java.math.BigDecimal reportSub17) {
		this.reportSub17 = reportSub17;
	}
	
    /**
     * @return ReportSub17
     */	
	public java.math.BigDecimal getReportSub17() {
		return this.reportSub17;
	}
	
	/**
	 * @param reportSub18
	 */
	public void setReportSub18(java.math.BigDecimal reportSub18) {
		this.reportSub18 = reportSub18;
	}
	
    /**
     * @return ReportSub18
     */	
	public java.math.BigDecimal getReportSub18() {
		return this.reportSub18;
	}
	
	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
	}


    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OcrmFwpWorkReportDtl other = (OcrmFwpWorkReportDtl) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getreportId() == null ? other.getreportId() == null : this.getreportId().equals(other.getreportId()))
        	&& (this.getReportCycle() == null ? other.getReportCycle() == null : this.getReportCycle().equals(other.getReportCycle()))
                                                                                                                                                                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getreportId() == null) ? 0 : getreportId().hashCode());
        result = prime * result + ((getReportCycle() == null) ? 0 : getReportCycle().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", reportId=").append(reportId);
		sb.append(", reportCycle=").append(reportCycle);
		sb.append(", reportSub=").append(reportSub);
		sb.append(", reportSub1=").append(reportSub1);
		sb.append(", reportSub2=").append(reportSub2);
		sb.append(", reportSub3=").append(reportSub3);
		sb.append(", reportSub4=").append(reportSub4);
		sb.append(", reportSub5=").append(reportSub5);
		sb.append(", reportSub6=").append(reportSub6);
		sb.append(", reportSub7=").append(reportSub7);
		sb.append(", reportSub8=").append(reportSub8);
		sb.append(", reportSub9=").append(reportSub9);
		sb.append(", reportSub10=").append(reportSub10);
		sb.append(", reportSub11=").append(reportSub11);
		sb.append(", reportSub12=").append(reportSub12);
		sb.append(", reportSub13=").append(reportSub13);
		sb.append(", reportSub14=").append(reportSub14);
		sb.append(", reportSub15=").append(reportSub15);
		sb.append(", reportSub16=").append(reportSub16);
		sb.append(", reportSub17=").append(reportSub17);
		sb.append(", reportSub18=").append(reportSub18);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}