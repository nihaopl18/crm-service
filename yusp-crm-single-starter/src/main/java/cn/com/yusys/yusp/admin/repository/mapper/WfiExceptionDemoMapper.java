package cn.com.yusys.yusp.admin.repository.mapper;

import cn.com.yusys.yusp.admin.domain.WfiExceptionDemo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface WfiExceptionDemoMapper extends CommonMapper<WfiExceptionDemo> {
    
    int insertSelective(WfiExceptionDemo record);
    
    List<WfiExceptionDemo> selectAllExceptionDemo(QueryModel model);

}