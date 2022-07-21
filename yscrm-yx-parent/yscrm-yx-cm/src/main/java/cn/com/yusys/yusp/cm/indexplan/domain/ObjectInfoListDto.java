package cn.com.yusys.yusp.cm.indexplan.domain;

import java.util.List;

public class ObjectInfoListDto {
    private List<ObjectInfoDto> objectInfoDtoList;
    private List<String> objIdList;

    public List<ObjectInfoDto> getObjectInfoDtoList() {
        return objectInfoDtoList;
    }

    public void setObjectInfoDtoList(List<ObjectInfoDto> objectInfoDtoList) {
        this.objectInfoDtoList = objectInfoDtoList;
    }

    public List<String> getObjIdList() {
        return objIdList;
    }

    public void setObjIdList(List<String> objIdList) {
        this.objIdList = objIdList;
    }
}
