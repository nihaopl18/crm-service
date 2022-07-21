package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.dto;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author sandMan
 * @date 2022/5/9 - 16:19
 */

@Entity
@Table(name = "PMA_F_SCHEME_INDEX_SCORE_SUM_ORG")
public class PmaFSchemeIndexScoreSumOrg extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 主键 **/
    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID")
    private String id;
    /**
     * 考核周期
     */
    @Column(name = "SCHEME_CYCLE")
    private String schemeCycle;
    /**
     * 机构编号
     */
    @Column(name = "ORG_CODE")
    private String orgCode;
    /**
     * 机构名称
     */
    @Column(name = "ORG_NAME")
    private String orgName;
    /**
     * 考核方案编号
     */
    @Column(name = "SCHEME_ID")
    private String schemeId;
    /**
     * 考核方案名称
     */
    @Column(name = "SCHEME_NAME")
    private String schemeName;
    /**
     * 总评分
     */
    @Column(name = "TOTAL_SCORE")
    private BigDecimal totalScore;
    /**
     * 创建者ID
     */
    @Column(name = "CREATOR")
    private String creator;
    /**
     * 创建日期
     */
    @Column(name = "CREATE_DATE")
    private String createDate;
    /**
     * 修改者ID
     */
    @Column(name = "UPDATER_ID")
    private String updaterId;
    /**
     * 修改日期
     */
    @Column(name = "UPDATE_DATE")
    private String updateDate;
    /**
     *创建机构
     */
    @Column(name = "CREATE_ORG")
    private String createOrg;
    /**
     *修改机构
     */
    @Column(name = "UPDATE_ORG")
    private String updateOrg;

    public static long getSerialVersionUID() {
        return 1L;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchemeCycle() {
        return schemeCycle;
    }

    public void setSchemeCycle(String schemeCycle) {
        this.schemeCycle = schemeCycle;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
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

    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg;
    }

    public String getUpdateOrg() {
        return updateOrg;
    }

    public void setUpdateOrg(String updateOrg) {
        this.updateOrg = updateOrg;
    }
}
