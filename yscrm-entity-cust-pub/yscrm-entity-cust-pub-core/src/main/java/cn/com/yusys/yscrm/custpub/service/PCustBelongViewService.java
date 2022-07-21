package cn.com.yusys.yscrm.custpub.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciCgMember;
import cn.com.yusys.yscrm.custpub.repository.mapper.PCustBelongViewMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciCgMemberService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-12 19:54:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PCustBelongViewService extends CommonService {
    @Autowired
    private PCustBelongViewMapper pCustBelongViewMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.pCustBelongViewMapper;
    }
    /**
	* @方法名称:queryBelongMgr
	* @方法描述:查询当前客户的机构、客户经理
	* @参数与返回说明:
	* @算法描述:
	*/
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryBelongGroup(String custId,QueryModel model) {
		PageHelper.startPage(model.getPage(),model.getSize());
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("custId", custId);
		List<Map<String, Object>> list =  pCustBelongViewMapper.queryBelongGroup(paramMap);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称:queryBelongMgr
	* @方法描述:查询当前客户的机构、客户经理
	* @参数与返回说明:
	* @算法描述:
	*/
//	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryBelongMgr(String custId,QueryModel model) {
		PageHelper.startPage(model.getPage(),model.getSize());
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("custId", custId);
		List<Map<String, Object>> list =  pCustBelongViewMapper.queryBelongMgr(paramMap);
		PageHelper.clearPage();
		return list;
	}
	@Transactional(readOnly = true)
	public List<Map<String, Object>> qryBelongHis(QueryModel model,String custId) {
		PageHelper.startPage(model.getPage(),model.getSize());
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("custId", custId);
		List<Map<String, Object>> list =  pCustBelongViewMapper.qryBelongHis(paramMap);
		PageHelper.clearPage();
		return list;
	}
}
