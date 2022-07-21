package cn.com.yusys.yscrm.custmgr.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

;

@Entity
public class CrmupdateTriumphVO implements Serializable{

  private static final long serialVersionUID = 1493642054106877440L;
    /**
     * 客户经理编码
     */
  private String mgr_id;
    /**
     * 修改后机构编码
     */
  private String triorgId;

    public String getMgr_id() {
        return mgr_id;
    }

    public void setMgr_id(String mgr_id) {
        this.mgr_id = mgr_id;
    }

    public String getTriorgId() {
        return triorgId;
    }

    public void setTriorgId(String triorgId) {
        this.triorgId = triorgId;
    }
}
