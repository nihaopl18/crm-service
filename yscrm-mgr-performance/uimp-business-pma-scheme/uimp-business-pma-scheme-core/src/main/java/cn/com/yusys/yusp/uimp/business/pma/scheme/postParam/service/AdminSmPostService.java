package cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain.AdminSmPost;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.repository.mapper.AdminSmPostMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: AdminSmPostService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-13 17:39:44
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class AdminSmPostService extends CommonService {
    @Autowired
    private AdminSmPostMapper adminSmPostMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return adminSmPostMapper;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist() {	
		List<Map<String, Object>> list = this.adminSmPostMapper.querylist();
		return list;
	}
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylistbyid(String postId) {	
		List<Map<String, Object>> list = this.adminSmPostMapper.querylistbyid(postId);
		return list;
	}
}
