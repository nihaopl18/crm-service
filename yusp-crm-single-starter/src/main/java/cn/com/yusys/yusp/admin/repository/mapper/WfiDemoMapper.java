package cn.com.yusys.yusp.admin.repository.mapper;

import cn.com.yusys.yusp.admin.domain.WfiDemo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface WfiDemoMapper extends CommonMapper<WfiDemo> {
    
    List<WfiDemo> selectAllWfiDemo(QueryModel model);
    
    int insertSelective(WfiDemo record);
    
    int updateByPrimaryKeySelective(WfiDemo record);

    Map<String, String> getUserByOrg(Map map);
}