package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeOrgRelMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeOrgRelService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 18:13:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFSchemeOrgRelService extends CommonService {
    @Autowired
    private PmaFSchemeOrgRelMapper pmaFSchemeOrgRelMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFSchemeOrgRelMapper;
    }

	public List<Map<String, Object>> queryOrg(QueryModel model) {
		List<Map<String, Object>> list = pmaFSchemeOrgRelMapper.queryOrg(model);
		return list;
	}

	public List<Map<String, Object>> queryOrgList(QueryModel model) {
		List<Map<String, Object>> list = pmaFSchemeOrgRelMapper.queryOrgList(model);
		return list;
	}

	/**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案机构关系表
	 * @参数与返回说明:
	 * @param schemeId 被复制的考核方案编号
	 * @param newSchemeId 新的考核方案编号
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void copySchemeInf(String schemeId, String newSchemeId) throws Exception {
	    try {
	      pmaFSchemeOrgRelMapper.copySchemeInf(schemeId, newSchemeId);
	    } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
