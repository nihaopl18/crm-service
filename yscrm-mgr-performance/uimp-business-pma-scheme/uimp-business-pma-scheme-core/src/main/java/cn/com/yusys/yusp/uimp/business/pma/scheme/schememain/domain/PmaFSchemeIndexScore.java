package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @description: 考核方案评分表
 * @author: Zhan YongQiang
 * @date: 2022/4/2 15:13
 */

@ApiModel(value = "PamFSchemeIndexScore", description = "考核方案评分模型配置表")
@Entity
@Table(name = "PMA_F_SCHEME_INDEX_SCORE")
public class PmaFSchemeIndexScore extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    /** ID **/
    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID")
    @ApiModelProperty(value = "ID", name = "id", required = false)
    private String id;

    @Column(name = "SCHEME_ID", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "考核方案ID", name = "schemeId", required = false)
    private String schemeId;

    //@Column(name = "OBJ_ID", unique = false, nullable = true, length = 50)
    //@ApiModelProperty(value = "考核对象ID", name = "objId", required = false)
    //private String objId;

    @Column(name = "INDEX_ID", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "指标ID", name = "indexId", required = false)
    private String indexId;


    @Column(name = "APPLY_TYPE_ID", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "指标应用类型", name = "applyTypeId", required = false)
    private String applyTypeId;


    @Column(name = "BAL_TYPE_ID", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "指标余额类型", name = "BAL_TYPE_ID", required = false)
    private String balTypeId;


    @Column(name = "EVL_OBJ_TYPE", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "评价对象类型", name = "EVL_OBJ_TYPE", required = false)
    private String evlObjType;

    @Column(name = "CURRENCY", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "币种", name = "currency", required = false)
    private String currency;

    @Column(name = "SCORE_MODEL_ID", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "考核评分模型", name = "scoreModelId", required = false)
    private String scoreModelId;

    @Column(name = "SCORE_FORMULA", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "评分模型公式", name = "scoreFormula", required = false)
    private String scoreFormula;

    @Column(name = "SCORE_WEIGHT", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "评分模型权重", name = "scoreWeight", required = false)
    private String scoreWeight;


    /** 创建者ID **/
    @Column(name = "CREATOR", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "创建者ID", name = "creator", required = false)
    private String creator;

    /** 创建日期 **/
    @Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
    @ApiModelProperty(value = "创建日期", name = "createDate", required = false)
    private String createDate;

    /** 最后修改者ID **/
    @Column(name = "UPDATER_ID", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "最后修改者ID", name = "updaterId", required = false)
    private String updaterId;

    /** 最后更新日期 **/
    @Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 20)
    @ApiModelProperty(value = "最后更新日期", name = "updateDate", required = false)
    private String updateDate;


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

    //public String getObjId() {
    //    return objId;
    //}
    //
    //public void setObjId(String objId) {
    //    this.objId = objId;
    //}

    public String getScoreModelId() {
        return scoreModelId;
    }

    public void setScoreModelId(String scoreModelId) {
        this.scoreModelId = scoreModelId;
    }

    public String getScoreFormula() {
        return scoreFormula;
    }

    public void setScoreFormula(String scoreFormula) {
        this.scoreFormula = scoreFormula;
    }

    public String getScoreWeight() {
        return scoreWeight;
    }

    public void setScoreWeight(String scoreWeight) {
        this.scoreWeight = scoreWeight;
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

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getApplyTypeId() {
        return applyTypeId;
    }

    public void setApplyTypeId(String applyTypeId) {
        this.applyTypeId = applyTypeId;
    }

    public String getBalTypeId() {
        return balTypeId;
    }

    public void setBalTypeId(String balTypeId) {
        this.balTypeId = balTypeId;
    }

    public String getEvlObjType() {
        return evlObjType;
    }

    public void setEvlObjType(String evlObjType) {
        this.evlObjType = evlObjType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
