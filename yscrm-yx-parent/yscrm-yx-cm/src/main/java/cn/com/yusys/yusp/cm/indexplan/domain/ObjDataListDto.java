package cn.com.yusys.yusp.cm.indexplan.domain;

import java.util.List;

public class ObjDataListDto {

        private String objType;
        private String objId;
        private List<DataListDto> dataListDto;
        public void setObjType(String objType) {
            this.objType = objType;
        }
        public String getObjType() {
            return objType;
        }

        public void setObjId(String objId) {
            this.objId = objId;
        }
        public String getObjId() {
            return objId;
        }

    public List<DataListDto> getDataListDto() {
        return dataListDto;
    }

    public void setDataListDto(List<DataListDto> dataListDto) {
        this.dataListDto = dataListDto;
    }
}
