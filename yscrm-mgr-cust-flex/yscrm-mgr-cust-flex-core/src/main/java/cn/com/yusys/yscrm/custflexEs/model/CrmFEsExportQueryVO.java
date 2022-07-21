package cn.com.yusys.yscrm.custflexEs.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

;

@Entity
@Table(name = "OCRM_F_ES_EXPORT_QUERY")
public class CrmFEsExportQueryVO implements Serializable{

  private static final long serialVersionUID = 1650545428142808064L;
    private List<CrmFEsExportQuery> crmFEsExportQueryList;
    private List<CrmFEsExportZhQuery> crmFEsExportZhQueryList;

    public List<CrmFEsExportQuery> getCrmFEsExportQueryList() {
        return crmFEsExportQueryList;
    }

    public void setCrmFEsExportQueryList(List<CrmFEsExportQuery> crmFEsExportQueryList) {
        this.crmFEsExportQueryList = crmFEsExportQueryList;
    }

    public List<CrmFEsExportZhQuery> getCrmFEsExportZhQueryList() {
        return crmFEsExportZhQueryList;
    }

    public void setCrmFEsExportZhQueryList(List<CrmFEsExportZhQuery> crmFEsExportZhQueryList) {
        this.crmFEsExportZhQueryList = crmFEsExportZhQueryList;
    }
}
