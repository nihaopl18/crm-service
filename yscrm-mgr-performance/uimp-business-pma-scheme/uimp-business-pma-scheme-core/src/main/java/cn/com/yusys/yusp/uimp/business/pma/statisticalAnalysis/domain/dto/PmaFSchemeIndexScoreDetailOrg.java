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
 * @date 2022/5/9 - 16:24
 */
@Entity
@Table(name = "PMA_F_SCHEME_INDEX_SCORE_DETAIL_ORG")
public class PmaFSchemeIndexScoreDetailOrg extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键 **/
    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID")
    private String id;
    /**
     * 机构评分汇总表ID
     */
    @Column(name = "MAIN_ID")
    private String mainId;
    /**
     * 考核指标编号
     */
    @Column(name = "INDEX_ID")
    private String indexId;
    /**
     * 考核指标名称
     */
    @Column(name = "INDEX_NAME")
    private String INDEX_NAME;
    /**
     *考核指标计划值
     */
    @Column(name = "INDEX_TARGET_VALUE")
    private BigDecimal indexTargetValue;
    /**
     * 考核指标结果值
     */
    @Column(name = "INDEX_RES")
    private BigDecimal indexRes;
    /**
     * 考核指标完成率(%)
     */
    @Column(name = "COMP_RATE")
    private BigDecimal compRate;
    /**
     * 权重
     */
    @Column(name = "SCORE_WEIGHT")
    private BigDecimal scoreWeight;
    /**
     * 考核评分算法
     */
    @Column(name = "SCORE_FORMUAL")
    private String scoreFormual;
    /**
     * 考核指标得分
     */
    @Column(name = "SCORE")
    private BigDecimal score;
    /**
     * 数据日期
     */
    @Column(name = "DATA_DATE")
    private String dataDate;

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
     *创建机构
     */
    @Column(name = "CREATE_ORG")
    private String createOrg;
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

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getINDEX_NAME() {
        return INDEX_NAME;
    }

    public void setINDEX_NAME(String INDEX_NAME) {
        this.INDEX_NAME = INDEX_NAME;
    }

    public BigDecimal getIndexTargetValue() {
        return indexTargetValue;
    }

    public void setIndexTargetValue(BigDecimal indexTargetValue) {
        this.indexTargetValue = indexTargetValue;
    }

    public BigDecimal getIndexRes() {
        return indexRes;
    }

    public void setIndexRes(BigDecimal indexRes) {
        this.indexRes = indexRes;
    }

    public BigDecimal getCompRate() {
        return compRate;
    }

    public void setCompRate(BigDecimal compRate) {
        this.compRate = compRate;
    }

    public BigDecimal getScoreWeight() {
        return scoreWeight;
    }

    public void setScoreWeight(BigDecimal scoreWeight) {
        this.scoreWeight = scoreWeight;
    }

    public String getScoreFormual() {
        return scoreFormual;
    }

    public void setScoreFormual(String scoreFormual) {
        this.scoreFormual = scoreFormual;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
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
