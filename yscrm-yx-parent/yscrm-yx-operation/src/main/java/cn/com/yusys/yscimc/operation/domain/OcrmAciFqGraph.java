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
 * @项目名称:yscrm-mgr-cust-flex模块
 * @类名称: OcrmAciFqGraph
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: zhangxs4
 * @创建时间: 2019-02-24 11:50:36
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "CIMP_A_CI_FQ_GRAPH")
public class OcrmAciFqGraph extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 图表编号
     **/
    @Id
    @Column(name = "GRAPH_ID")
    @Generated(GenerationType.UUID)
    private String graphId;

    /**
     * 图表名称
     **/
    @Column(name = "GRAPH_NAME", unique = false, nullable = true, length = 100)
    private String graphName;

    /**
     * 图表查询sql
     **/
    @Column(name = "GRAPH_SQL", unique = false, nullable = true, length = 800)
    private String graphSql;

    /**
     * 图表大小
     **/
    @Column(name = "GRAPH_SIZE", unique = false, nullable = true, length = 20)
    private String graphSize;

    /**
     * 图表类型
     **/
    @Column(name = "GRAPH_TYPE", unique = false, nullable = true, length = 30)
    private String graphType;

    /**
     * 图表信息
     **/
    @Column(name = "GRAPH_INFO", unique = false, nullable = true, length = 500)
    private String graphInfo;

    /**
     * 转码信息
     **/
    @Column(name = "LOOKUP_INFO", unique = false, nullable = true, length = 400)
    private String lookupInfo;

    /**
     * 创建人
     **/
    @Column(name = "CREATE_USER", unique = false, nullable = true, length = 32)
    private String createUser;

    /**
     * 发布机构
     **/
    @Column(name = "CREATE_ORG", unique = false, nullable = true, length = 32)
    private String createOrg;

    /**
     * 创建时间
     **/
    @Column(name = "CREATE_DATE")
    private Date createDate;


    /**
     * @param graphId
     */
    public void setGraphId(String graphId) {
        this.graphId = graphId == null ? null : graphId.trim();
    }

    /**
     * @return GraphId
     */
    public String getGraphId() {
        return this.graphId;
    }

    /**
     * @param graphName
     */
    public void setGraphName(String graphName) {
        this.graphName = graphName == null ? null : graphName.trim();
    }

    /**
     * @return GraphName
     */
    public String getGraphName() {
        return this.graphName;
    }

    /**
     * @param graphSql
     */
    public void setGraphSql(String graphSql) {
        this.graphSql = graphSql == null ? null : graphSql.trim();
    }

    /**
     * @return GraphSql
     */
    public String getGraphSql() {
        return this.graphSql;
    }

    /**
     * @param graphSize
     */
    public void setGraphSize(String graphSize) {
        this.graphSize = graphSize == null ? null : graphSize.trim();
    }

    /**
     * @return GraphSize
     */
    public String getGraphSize() {
        return this.graphSize;
    }

    /**
     * @param graphType
     */
    public void setGraphType(String graphType) {
        this.graphType = graphType == null ? null : graphType.trim();
    }

    /**
     * @return GraphType
     */
    public String getGraphType() {
        return this.graphType;
    }

    /**
     * @param graphInfo
     */
    public void setGraphInfo(String graphInfo) {
        this.graphInfo = graphInfo == null ? null : graphInfo.trim();
    }

    /**
     * @return GraphInfo
     */
    public String getGraphInfo() {
        return this.graphInfo;
    }

    /**
     * @param lookupInfo
     */
    public void setLookupInfo(String lookupInfo) {
        this.lookupInfo = lookupInfo == null ? null : lookupInfo.trim();
    }

    /**
     * @return LookupInfo
     */
    public String getLookupInfo() {
        return this.lookupInfo;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * @return CreateUser
     */
    public String getCreateUser() {
        return this.createUser;
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
        OcrmAciFqGraph other = (OcrmAciFqGraph) that;
        return (this.getGraphId() == null ? other.getGraphId() == null : this.getGraphId().equals(other.getGraphId()))
                && (this.getGraphName() == null ? other.getGraphName() == null : this.getGraphName().equals(other.getGraphName()))
                && (this.getGraphSql() == null ? other.getGraphSql() == null : this.getGraphSql().equals(other.getGraphSql()))
                && (this.getGraphSize() == null ? other.getGraphSize() == null : this.getGraphSize().equals(other.getGraphSize()))
                && (this.getGraphType() == null ? other.getGraphType() == null : this.getGraphType().equals(other.getGraphType()))
                && (this.getGraphInfo() == null ? other.getGraphInfo() == null : this.getGraphInfo().equals(other.getGraphInfo()))
                && (this.getLookupInfo() == null ? other.getLookupInfo() == null : this.getLookupInfo().equals(other.getLookupInfo()))
                && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                && (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGraphId() == null) ? 0 : getGraphId().hashCode());
        result = prime * result + ((getGraphName() == null) ? 0 : getGraphName().hashCode());
        result = prime * result + ((getGraphSql() == null) ? 0 : getGraphSql().hashCode());
        result = prime * result + ((getGraphSize() == null) ? 0 : getGraphSize().hashCode());
        result = prime * result + ((getGraphType() == null) ? 0 : getGraphType().hashCode());
        result = prime * result + ((getGraphInfo() == null) ? 0 : getGraphInfo().hashCode());
        result = prime * result + ((getLookupInfo() == null) ? 0 : getLookupInfo().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append(", graphId=").append(graphId);
        sb.append(", graphName=").append(graphName);
        sb.append(", graphSql=").append(graphSql);
        sb.append(", graphSize=").append(graphSize);
        sb.append(", graphType=").append(graphType);
        sb.append(", graphInfo=").append(graphInfo);
        sb.append(", lookupInfo=").append(lookupInfo);
        sb.append(", createUser=").append(createUser);
        sb.append(", createOrg=").append(createOrg);
        sb.append(", createDate=").append(createDate);
        sb.append("]");
        return sb.toString();
    }
}