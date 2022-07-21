package cn.com.yusys.yusp.uimp.business.pma.app.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.app.repository.mapper.AppRemindMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * @项目名称: uimp-business-pma-app-core模块
 * @类名称: AppRemindService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-06 10:48:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class AppRemindService extends CommonService {
	
    @Autowired
    private AppRemindMapper appRemindMapper;
    
    @Autowired
	private UserInfoService userInfoService;

    @Override
    protected CommonMapper<?> getMapper() {
        return appRemindMapper;
    }	
    
    /**
     * 查询
     * @param model
     * @return
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryAll() {
//    	String receUser = userInfoService.getGrantOrgCode();
    	String receUser = userInfoService.getUserInfo().getLoginCode();
		List<Map<String, Object>> list = this.appRemindMapper.queryAll(receUser);
		return list;
	}
    
    /**
     * 查询待办任务列表(根据业务分组)
     * @param model
     * @return
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryTodoGroupList() {
//    	String receUser = userInfoService.getGrantOrgCode();
    	String receUser = userInfoService.getUserInfo().getLoginCode();
		List<Map<String, Object>> list = this.appRemindMapper.queryTodoGroupList(receUser);
		return list;
	}

    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryTodoMenu(String funCode) {
    	funCode = "pages/content/bussiness/distributionmanage/commonDstrVet/commonDstrVet?funCode=" + funCode;
    	List<Map<String, Object>> list = this.appRemindMapper.queryTodoMenu(funCode);
		return list;
    }
}
