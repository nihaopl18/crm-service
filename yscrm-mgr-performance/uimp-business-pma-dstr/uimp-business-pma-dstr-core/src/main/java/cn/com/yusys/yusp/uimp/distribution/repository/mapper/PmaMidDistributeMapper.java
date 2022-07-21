package cn.com.yusys.yusp.uimp.distribution.repository.mapper;


import cn.com.yusys.yusp.uimp.distribution.model.PmaMidDistribute;

import java.util.List;

public interface PmaMidDistributeMapper {
    int deleteByPrimaryKey(String id);

    int insert(PmaMidDistribute record);

    int insertSelective(PmaMidDistribute record);

    PmaMidDistribute selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PmaMidDistribute record);

    int updateByPrimaryKey(PmaMidDistribute record);

    List<PmaMidDistribute> selectList(PmaMidDistribute record);
}