package cn.com.yusys.yscimc.operation.domain.dto;

import cn.com.yusys.yscimc.operation.domain.vo.IndexPlanInfoVo;

import java.util.List;

/**
 * @Author Lenovo
 * @Data 2021/12/13 21:00
 */
public class IndexPlanInfoDto {

    private List<IndexPlanInfoVo> indexPlanInfoVoList;

    public List<IndexPlanInfoVo> getIndexPlanInfoVoList() {
        return indexPlanInfoVoList;
    }

    public IndexPlanInfoDto setIndexPlanInfoVoList(List<IndexPlanInfoVo> indexPlanInfoVoList) {
        this.indexPlanInfoVoList = indexPlanInfoVoList;
        return this;
    }
}
