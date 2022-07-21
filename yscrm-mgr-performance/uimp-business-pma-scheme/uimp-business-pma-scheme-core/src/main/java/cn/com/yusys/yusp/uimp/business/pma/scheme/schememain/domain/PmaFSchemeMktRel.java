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
 * @date: 2022/5/20 10:47
 */
@ApiModel(value = "PmaFSchemeMktRel", description = "考核方案客户经理关系表")
@Entity
@Table(name = "PMA_F_SCHEME_MKT_REL")
public class PmaFSchemeMktRel extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ID **/
    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID")
    @ApiModelProperty(value = "ID", name = "id", required = false)
    private String id;

    /** 考核方案ID **/
    @Column(name = "SCHEME_ID", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "考核方案ID", name = "schemeId", required = false)
    private String schemeId;

    /** 机构ID **/
    @Column(name = "MKT_ID", unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "客户经理ID", name = "mktId", required = false)
    private String mktId;

    /** 机构名称 **/
    @Column(name = "MKT_NAME", unique = false, nullable = true, length = 100)
    @ApiModelProperty(value = "客户经理名称", name = "mktName", required = false)
    private String mktName;

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

    public String getMktId() {
        return mktId;
    }

    public void setMktId(String mktId) {
        this.mktId = mktId;
    }

    public String getMktName() {
        return mktName;
    }

    public void setMktName(String mktName) {
        this.mktName = mktName;
    }
}
