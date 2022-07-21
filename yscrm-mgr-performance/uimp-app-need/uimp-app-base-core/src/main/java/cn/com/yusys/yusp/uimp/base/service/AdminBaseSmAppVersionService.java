package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseSmAppVersion;
import cn.com.yusys.yusp.uimp.base.repository.mapper.AdminBaseSmAppVersionMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: AdminBaseSmAppVersionService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-01-15 17:30:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AdminBaseSmAppVersionService extends CommonService {
    @Autowired
    private AdminBaseSmAppVersionMapper adminBaseSmAppVersionMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return adminBaseSmAppVersionMapper;
    }
    
    public List<Map<String, Object>> queryList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = adminBaseSmAppVersionMapper.queryList(model);
		PageHelper.clearPage();
		return list;
	}

    public Map<String,Object> queryByApk() {
		QueryModel model = new QueryModel();
		Map<String, Object> map = new HashMap<String, Object>();
		//查询安卓
		model.getCondition().put("versionBelong", "0");
		List<Map<String, Object>> listOne = adminBaseSmAppVersionMapper.queryList(model);
		if(listOne.size() > 0) {
			if(listOne.get(0).get("downloadUrl").toString() != null) {
				map.put("androidUrl", listOne.get(0).get("downloadUrl").toString());
			}
		}
		//查询ios
		model.getCondition().put("versionBelong", "1");
		List<Map<String, Object>> listTwo = adminBaseSmAppVersionMapper.queryList(model);
		if(listTwo.size() > 0) {
			if(listTwo.get(0).get("downloadUrl").toString() != null) {
				map.put("iphoneUrl", listOne.get(0).get("downloadUrl").toString());
			}
		}
		return map;
	}
    
    public String insert(AdminBaseSmAppVersion adminBaseSmAppVersion) {
		if(adminBaseSmAppVersion.getId() == null) {
			this.insertSelective(adminBaseSmAppVersionMapper,adminBaseSmAppVersion);
	    	return adminBaseSmAppVersion.getId();
		}else {
			this.updateSelective(adminBaseSmAppVersionMapper,adminBaseSmAppVersion);
	    	return adminBaseSmAppVersion.getId();
		}
	}
    
    public int delete(String id) {
		int result = adminBaseSmAppVersionMapper.deleteByIds(id);
		return result;
	}
}
