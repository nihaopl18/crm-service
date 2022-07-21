package cn.com.yusys.yscrm.custflexEs.model;;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_ES_USER_QUERY")
public class CrmFEsUserQuery implements Serializable{

  private static final long serialVersionUID = 1975302933232497152L;



	/**
	 * 用户id
	 */
  private String userId;

	/**
	 * 用户名称
	 */
  private String userName;

	/**
	 * 类型（01：查询条件  02：展示列）
	 */
  private String queryType;

    /**
     * 默认信息
     */
    private List<CrmFEsUserQueryDTO> CrmFEsUserQueryDTOList=new ArrayList<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public List<CrmFEsUserQueryDTO> getCrmFEsUserQueryDTOList() {
        return CrmFEsUserQueryDTOList;
    }

    public void setCrmFEsUserQueryDTOList(List<CrmFEsUserQueryDTO> crmFEsUserQueryDTOList) {
        CrmFEsUserQueryDTOList = crmFEsUserQueryDTOList;
    }
}
