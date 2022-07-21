package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemePostRelMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemePostRelService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 19:07:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFSchemePostRelService extends CommonService {
    @Autowired
    private PmaFSchemePostRelMapper pmaFSchemePostRelMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFSchemePostRelMapper;
    }

	public List<Map<String, Object>> queryPost(QueryModel model) {
		List<Map<String, Object>> list = pmaFSchemePostRelMapper.queryPost(model);
		return list;
	}

	/**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案岗位关系表
	 * @参数与返回说明:
	 * @param schemeId 被复制的考核方案编号
	 * @param newSchemeId 新的考核方案编号
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void copySchemeInf(String schemeId, String newSchemeId) throws Exception {
	    try {
	    	pmaFSchemePostRelMapper.copySchemeInf(schemeId, newSchemeId);
	    } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
