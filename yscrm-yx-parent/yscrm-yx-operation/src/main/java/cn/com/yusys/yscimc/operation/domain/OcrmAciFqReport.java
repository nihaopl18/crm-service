package cn.com.yusys.yscimc.operation.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * @version 1.0.0
 * @项目名称: yscrm-mgr-cust-flex模块
 * @类名称: OcrmAciFqReport
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: zhangxs4
 * @创建时间: 2019-02-12 15:07:22
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "CIMP_A_CI_FQ_REPORT")
public class OcrmAciFqReport extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 报表编号
     **/
    @Id
    @Column(name = "REPORT_ID")
    @Generated(GenerationType.UUID)
    private String reportId;

    /**
     * 报表名称
     **/
    @Column(name = "REPORT_NAME", unique = false, nullable = true, length = 100)
    private String reportName;

    /**
     * 查询sql
     **/
    @Column(name = "REPORT_SQL", unique = false, nullable = true, length = 2000)
    private String reportSql;

    /**
     * 结果集ID
     **/
    @Column(name = "SS_RESULT", unique = false, nullable = true, length = 1000)
    private String ssResult;

    /**
     * 排序标识
     **/
    @Column(name = "SS_SORT", unique = false, nullable = true, length = 100)
    private String ssSort;

    /**
     * 方案类型
     **/
    @Column(name = "SS_TYPE", unique = false, nullable = true, length = 20)
    private String ssType;

    /**
     * 发布人员
     **/
    @Column(name = "CREATER", unique = false, nullable = true, length = 50)
    private String creater;

    /**
     * 发布机构
     **/
    @Column(name = "CREATE_ORG", unique = false, nullable = true, length = 20)
    private String createOrg;

    /**
     * 发布时间
     **/
    @Column(name = "CREATE_DATE")
    private Date createDate;

    /**
     * 数据加工临时表
     **/
    @Column(name = "DATA_PROCESSING_TABLE", unique = false, nullable = true, length = 100)
    private String dataProcessingTable;

    /**
     * 筛选数目
     **/
    @Column(name = "TOP_NUM", unique = false, nullable = true, length = 38)
    private java.math.BigDecimal topNum;


    /**
     * @param reportId
     */
    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    /**
     * @return ReportId
     */
    public String getReportId() {
        return this.reportId;
    }

    /**
     * @param reportName
     */
    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

    /**
     * @return ReportName
     */
    public String getReportName() {
        return this.reportName;
    }

    /**
     * @param reportSql
     */
    public void setReportSql(String reportSql) {
        this.reportSql = reportSql == null ? null : reportSql.trim();
    }

    /**
     * @return ReportSql
     */
    public String getReportSql() {
        return this.reportSql;
    }

    /**
     * @param ssResult
     */
    public void setSsResult(String ssResult) {
        this.ssResult = ssResult == null ? null : ssResult.trim();
    }

    /**
     * @return SsResult
     */
    public String getSsResult() {
        return this.ssResult;
    }

    /**
     * @param ssSort
     */
    public void setSsSort(String ssSort) {
        this.ssSort = ssSort == null ? null : ssSort.trim();
    }

    /**
     * @return SsSort
     */
    public String getSsSort() {
        return this.ssSort;
    }

    /**
     * @param ssType
     */
    public void setSsType(String ssType) {
        this.ssType = ssType == null ? null : ssType.trim();
    }

    /**
     * @return SsType
     */
    public String getSsType() {
        return this.ssType;
    }

    /**
     * @param creater
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * @return Creater
     */
    public String getCreater() {
        return this.creater;
    }

    /**
     * @param createOrg
     */
    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg == null ? null : createOrg.trim();
    }

    /**
     * @return CreateOrg
     */
    public String getCreateOrg() {
        return this.createOrg;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return CreateDate
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * @param dataProcessingTable
     */
    public void setDataProcessingTable(String dataProcessingTable) {
        this.dataProcessingTable = dataProcessingTable == null ? null : dataProcessingTable.trim();
    }

    /**
     * @return DataProcessingTable
     */
    public String getDataProcessingTable() {
        return this.dataProcessingTable;
    }

    /**
     * @param topNum
     */
    public void setTopNum(java.math.BigDecimal topNum) {
        this.topNum = topNum;
    }

    /**
     * @return TopNum
     */
    public java.math.BigDecimal getTopNum() {
        return this.topNum;
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
        OcrmAciFqReport other = (OcrmAciFqReport) that;
        return (this.getReportName() == null ? other.getReportName() == null : this.getReportName().equals(other.getReportName()))
                && (this.getReportSql() == null ? other.getReportSql() == null : this.getReportSql().equals(other.getReportSql()))
                && (this.getSsResult() == null ? other.getSsResult() == null : this.getSsResult().equals(other.getSsResult()))
                && (this.getSsSort() == null ? other.getSsSort() == null : this.getSsSort().equals(other.getSsSort()))
                && (this.getSsType() == null ? other.getSsType() == null : this.getSsType().equals(other.getSsType()))
                && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
                && (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
                && (this.getDataProcessingTable() == null ? other.getDataProcessingTable() == null : this.getDataProcessingTable().equals(other.getDataProcessingTable()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReportName() == null) ? 0 : getReportName().hashCode());
        result = prime * result + ((getReportSql() == null) ? 0 : getReportSql().hashCode());
        result = prime * result + ((getSsResult() == null) ? 0 : getSsResult().hashCode());
        result = prime * result + ((getSsSort() == null) ? 0 : getSsSort().hashCode());
        result = prime * result + ((getSsType() == null) ? 0 : getSsType().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getDataProcessingTable() == null) ? 0 : getDataProcessingTable().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reportId=").append(reportId);
        sb.append(", reportName=").append(reportName);
        sb.append(", reportSql=").append(reportSql);
        sb.append(", ssResult=").append(ssResult);
        sb.append(", ssSort=").append(ssSort);
        sb.append(", ssType=").append(ssType);
        sb.append(", creater=").append(creater);
        sb.append(", createOrg=").append(createOrg);
        sb.append(", createDate=").append(createDate);
        sb.append(", dataProcessingTable=").append(dataProcessingTable);
        sb.append(", topNum=").append(topNum);
        sb.append("]");
        return sb.toString();
    }
}