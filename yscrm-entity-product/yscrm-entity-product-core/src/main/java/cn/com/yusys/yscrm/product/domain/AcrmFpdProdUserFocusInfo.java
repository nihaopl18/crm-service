package cn.com.yusys.yscrm.product.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFpdProdUserFocusInfo
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2022-03-18 14:45:55
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_PD_PROD_USER_FOCUS_INFO")
public class AcrmFpdProdUserFocusInfo  extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 用户ID **/
    @Column(name = "USER_ID", unique = false, nullable = true, length = 50)
    private String userId;

    /** 用户名称 **/
    @Column(name = "USER_NAME", unique = false, nullable = true, length = 50)
    private String userName;

    /** 产品代码 **/
    @Column(name = "PROD_CODE", unique = false, nullable = true, length = 50)
    private String prodCode;

    /** 原产品代码 **/
    @Column(name = "SRC_PROD_CODE", unique = false, nullable = true, length = 50)
    private String srcProdCode;

    /** 关注时间 **/
    @Column(name = "FOCUS_DATE", unique = false, nullable = true, length = 20)
    private String focusDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode == null ? null : prodCode;
    }

    public String getSrcProdCode() {
        return srcProdCode;
    }

    public void setSrcProdCode(String srcProdCode) {
        this.srcProdCode = srcProdCode == null ? null : srcProdCode;
    }

    public String getFocusDate() {
        return focusDate;
    }

    public void setFocusDate(String focusDate) {
        this.focusDate = focusDate == null ? null : focusDate;
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
        AcrmFpdProdUserFocusInfo other = (AcrmFpdProdUserFocusInfo) that;
        return  (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
                && (this.getProdCode() == null ? other.getProdCode() == null : this.getProdCode().equals(other.getProdCode()))
                && (this.getSrcProdCode() == null ? other.getSrcProdCode() == null : this.getSrcProdCode().equals(other.getSrcProdCode()))
                && (this.getFocusDate() == null ? other.getFocusDate() == null : this.getFocusDate().equals(other.getFocusDate()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getProdCode() == null) ? 0 : getProdCode().hashCode());
        result = prime * result + ((getSrcProdCode() == null) ? 0 : getSrcProdCode().hashCode());
        result = prime * result + ((getFocusDate() == null) ? 0 : getFocusDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", prodCode=").append(prodCode);
        sb.append(", srcProdCode=").append(srcProdCode);
        sb.append(", focusDate=").append(focusDate);
        sb.append("]");
        return sb.toString();
    }
}
