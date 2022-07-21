package cn.com.yusys.yusp.uimp.base.domain;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * 考核指标事实表-团队
 *
 * @author lichangci
 * @email licc11@yusys.com.cn
 * @date 2022-05-10 17:37:05
 */
@Table(name = "PMA_F_PERFORMANCE_RESULT_TEAM")
public class PmaFPerformanceResultTeamEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 考核方案编号
     */
    private String schemeId;
    /**
     * 考核方案名称
     */
    private String schemeName;
    /**
     * 考核周期
     */
    private String schemeCycle;
    /**
     * 团队编号
     */
    private String teamId;
    /**
     * 团队名称
     */
    private String teamName;
    /**
     * 团队长编号
     */
    private String teamleaderId;
    /**
     * 团队长姓名
     */
    private String teamleaderName;
    /**
     * 所属分行编号
     */
    private String branchId;
    /**
     * 所属分行名称
     */
    private String branchName;
    /**
     * 所属机构编号
     */
    private String orgId;
    /**
     * 所属机构名称
     */
    private String orgName;
    /**
     * 指标编号
     */
    private String indexId;
    /**
     * 指标名称
     */
    private String indexName;
    /**
     * 指标计划目标值
     */
    private Integer indexTargetValue;
    /**
     * 指标结果值
     */
    private Integer indexRes;
    /**
     * 指标完成率
     */
    private Integer compRate;
    /**
     * 创建者ID
     */
    private String creator;
    /**
     * 创建日期
     */
    private String createDate;
    /**
     * 创建机构
     */
    private String createOrg;
    /**
     * 修改者ID
     */
    private String updaterId;
    /**
     * 修改日期
     */
    private String updateDate;
    /**
     * 修改机构
     */
    private String updateOrg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getSchemeCycle() {
        return schemeCycle;
    }

    public void setSchemeCycle(String schemeCycle) {
        this.schemeCycle = schemeCycle;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamleaderId() {
        return teamleaderId;
    }

    public void setTeamleaderId(String teamleaderId) {
        this.teamleaderId = teamleaderId;
    }

    public String getTeamleaderName() {
        return teamleaderName;
    }

    public void setTeamleaderName(String teamleaderName) {
        this.teamleaderName = teamleaderName;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public Integer getIndexTargetValue() {
        return indexTargetValue;
    }

    public void setIndexTargetValue(Integer indexTargetValue) {
        this.indexTargetValue = indexTargetValue;
    }

    public Integer getIndexRes() {
        return indexRes;
    }

    public void setIndexRes(Integer indexRes) {
        this.indexRes = indexRes;
    }

    public Integer getCompRate() {
        return compRate;
    }

    public void setCompRate(Integer compRate) {
        this.compRate = compRate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateOrg() {
        return updateOrg;
    }

    public void setUpdateOrg(String updateOrg) {
        this.updateOrg = updateOrg;
    }
}
