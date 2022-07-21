package cn.com.yusys.yusp.admin.service;

import cn.com.yusys.yusp.admin.domain.WfiDemo;
import cn.com.yusys.yusp.admin.domain.WfiExceptionDemo;
import cn.com.yusys.yusp.admin.repository.mapper.WfiDemoMapper;
import cn.com.yusys.yusp.admin.repository.mapper.WfiExceptionDemoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WfiDemoService {

    @Autowired
    private WfiDemoMapper wfiDemoMapper;
    @Autowired
    private WfiExceptionDemoMapper wfiExceptionDemoMapper;
    @Autowired
    private UaaClient uaaClient;
    public Boolean addWfiDemo(WfiDemo record) {
        int insert=wfiDemoMapper.insertSelective(record);
        return insert>0;
    }
    
    public List<WfiDemo> selectAllWfiDemo(QueryModel model){
    	PageHelper.startPage(model.getPage(), model.getSize());
    	List<WfiDemo> list=wfiDemoMapper.selectAllWfiDemo(model);
    	PageHelper.clearPage();
    	return list;
    }
    
    public Boolean updateWfiDemo(WfiDemo record) {
        int update=wfiDemoMapper.updateByPrimaryKeySelective(record);
        return update>0;
    }
    
    public Boolean insertWfiExceptionDemo(WfiExceptionDemo record) {
        int insert=wfiExceptionDemoMapper.insertSelective(record);
        return insert>0;
    }
    
    public List<WfiExceptionDemo> selectAllExceptionDemo(QueryModel model){
        PageHelper.startPage(model.getPage(), model.getSize());
        List<WfiExceptionDemo> list=wfiExceptionDemoMapper.selectAllExceptionDemo(model);
        PageHelper.clearPage();
        return list;
    }
    
    public Boolean deleteWfiExceptionDemo(String logicSeq) {
        int delete=wfiExceptionDemoMapper.deleteByPrimaryKey(logicSeq);
        return delete>0;
    }

	public List<Map<String, String>> getUserByOrg(List<Map<String, String>> list) {
		String instr="";
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		String userOrg=dto.getBody().getOrg().getCode();
		List<Map<String, String>> existList=new ArrayList<Map<String,String>>();
		if(list!=null&&list.size()>0) {
			for(int i=0;i<list.size();i++) {
				Map map =new HashMap<String, String>();
				map.put("instr", list.get(i).get("loginCode"));
				map.put("userOrg", userOrg);
				Map<String, String> mapList=wfiDemoMapper.getUserByOrg(map);
				if(mapList!=null&&mapList.get("orgId")!=null) {
					existList.add(list.get(i));
				}
			}
		}
		return existList;
	}
}
