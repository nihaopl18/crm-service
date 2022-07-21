package cn.com.yusys.yusp.cm.indexplan.domain;
import java.util.List;

public class ObjectDataForm {
        private String objType;
        private String objId;
        private List<DataListForm> dataList;

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public List<DataListForm> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListForm> dataList) {
        this.dataList = dataList;
    }
}
