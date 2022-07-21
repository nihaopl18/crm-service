package cn.com.yusys.yusp.cm.indexplan.domain;

import java.util.List;

public class IndexPlanReturnDto {
        private List<indexDataDto> indexDataDto;
        private List<ObjDataListDto> objDataListDto;
        private int totalSize;

    public List<cn.com.yusys.yusp.cm.indexplan.domain.indexDataDto> getIndexDataDto() {
        return indexDataDto;
    }

    public void setIndexDataDto(List<cn.com.yusys.yusp.cm.indexplan.domain.indexDataDto> indexDataDto) {
        this.indexDataDto = indexDataDto;
    }

    public List<ObjDataListDto> getObjDataListDto() {
        return objDataListDto;
    }

    public void setObjDataListDto(List<ObjDataListDto> objDataListDto) {
        this.objDataListDto = objDataListDto;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
}
