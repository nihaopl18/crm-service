package cn.com.yusys.climp.score.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface ScoreQueryMapper {
    List<Map<String, String>> getList(Map<String,Object> map);

    List<Map<String, String>> getDetail(QueryModel model);
}
