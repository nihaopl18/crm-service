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
 * @date: 2022/4/2 15:41
 */
@ApiModel(value = "PmaFSchemeIndexScoreParam", description = "考核方案评分模型参数配置表")
@Entity
@Table(name = "PMA_SCORE_MODEL_INFO")
public class PmaScoreModelInfo extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID **/
    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID")
    @ApiModelProperty(value = "ID", name = "id", required = false)
    private String id;


    @Column(name = "MODEL_NAME", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "模型名称", name = "modelName", required = false)
    private String modelName;

    @Column(name = "CACL_FORMULA", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "计算公式", name = "caclFormula", required = false)
    private String caclFormula;

    @Column(name = "MODEL_DESC", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "模型描述", name = "modelDesc", required = false)
    private String modelDesc;

    @Column(name = "MODEL_STATUS", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "模型状态", name = "modelStatus", required = false)
    private String modelStatus;


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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCaclFormula() {
        return caclFormula;
    }

    public void setCaclFormula(String caclFormula) {
        this.caclFormula = caclFormula;
    }

    public String getModelDesc() {
        return modelDesc;
    }

    public void setModelDesc(String modelDesc) {
        this.modelDesc = modelDesc;
    }

    public String getModelStatus() {
        return modelStatus;
    }

    public void setModelStatus(String modelStatus) {
        this.modelStatus = modelStatus;
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
}
