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
 * @description:
 * @author: Zhan YongQiang
 * @date: 2022/4/2 15:37
 */
@ApiModel(value = "PmaFSchemeIndexScoreParam", description = "考核方案评分模型参数配置表")
@Entity
@Table(name = "PMA_SCORE_MODEL_PARAMS")
public class PmaScoreModelParams extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID **/
    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID")
    @ApiModelProperty(value = "ID", name = "id", required = false)
    private String id;


    @Column(name = "EN_NAME", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "参数英文名", name = "enName", required = false)
    private String enName;

    @Column(name = "CN_NAME", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "参数中文名", name = "cnName", required = false)
    private String cnName;


    @Column(name = "PARAM_SOURCE_TYPE", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "参数来源类型", name = "paramSourceType", required = false)
    private String paramSourceType;

    @Column(name = "PARAM_SOURCE", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "参数来源", name = "paramSource", required = false)
    private String paramSource;


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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getParamSourceType() {
        return paramSourceType;
    }

    public void setParamSourceType(String paramSourceType) {
        this.paramSourceType = paramSourceType;
    }

    public String getParamSource() {
        return paramSource;
    }

    public void setParamSource(String paramSource) {
        this.paramSource = paramSource;
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

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
}
