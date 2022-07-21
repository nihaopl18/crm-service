package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.repository.mapper.AdminBaseDisplayInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseDisplayInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-06 20:40:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class AdminBaseDisplayInfoService extends CommonService {
    @Autowired
    private AdminBaseDisplayInfoMapper adminBaseDisplayInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return adminBaseDisplayInfoMapper;
    }
    
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist() {
		List<Map<String, Object>> list = this.adminBaseDisplayInfoMapper.querylist();
		return list;
	}
    
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<Object> star(String id) throws Exception {
    	ResultDto<Object> resultDto = new ResultDto<>();
    	try {
    		adminBaseDisplayInfoMapper.star(id);
    	} catch (Exception e) {
			e.printStackTrace();
			resultDto.setCode(500);
		    resultDto.setMessage(e.getMessage());
		}
		return resultDto;
    }
    
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<Object> unstar(String id) throws Exception {
    	ResultDto<Object> resultDto = new ResultDto<>();
    	try {
    		adminBaseDisplayInfoMapper.unstar(id);
    	} catch (Exception e) {
			e.printStackTrace();
			resultDto.setCode(500);
		    resultDto.setMessage(e.getMessage());
		}
		return resultDto;
    }

}
