package cn.com.yusys.climp.score.service;

import cn.com.yusys.climp.qypool.service.UserInfoService;
import cn.com.yusys.climp.score.repository.mapper.ScoreQueryMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoreQueryService {
    private Logger logger = LoggerFactory.getLogger(ScoreQueryService.class);

    @Autowired
    private ScoreQueryMapper scoreQueryMapper;
    @Autowired
    private UserInfoService userInfoService;

    public List<Map<String, String>> getList(QueryModel model) throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("condition",model.getCondition());
        map.putAll(getUserMap());
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, String>> list = scoreQueryMapper.getList(map);
        PageHelper.clearPage();
        return list;
    }

    public List<Map<String, String>> getDetail(QueryModel model) throws Exception{
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, String>> list = scoreQueryMapper.getDetail(model);
        PageHelper.clearPage();
        return list;
    }
    private Map<String,String> getUserMap(){
        Map<String,String> map = new HashMap<>();
        map.put("_userCode", userInfoService.getLoginCode());
        map.put("_orgCode",userInfoService.getOrgCode());
        return map;
    }
}
