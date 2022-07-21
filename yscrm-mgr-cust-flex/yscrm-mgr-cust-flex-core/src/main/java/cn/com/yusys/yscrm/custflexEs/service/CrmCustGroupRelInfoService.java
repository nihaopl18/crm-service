package cn.com.yusys.yscrm.custflexEs.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custflexEs.domain.CrmCustGroupRelInfo;
import cn.com.yusys.yscrm.custflexEs.repository.mapper.CrmCustGroupRelInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;

import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmCustGroupRelInfoService
 * @类描述: #客户群成员信息表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-08 15:12:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
@Transactional
public class CrmCustGroupRelInfoService {
	
	private static final Logger log = LoggerFactory.getLogger(CrmCustGroupRelInfoService.class);

    @Autowired
    private CrmCustGroupRelInfoMapper crmCustGroupRelInfoMapper;
	
    /**
     * @函数名称: addCustToCustGroup
     * @函数描述: 添加客户到客户群中
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public String addCustToCustGroup(String groupId, String custId) throws Exception {
    	try {
			if(StringUtil.isNotEmpty(custId) && StringUtil.isNotEmpty(groupId)) {
				CrmCustGroupRelInfo relInfo = crmCustGroupRelInfoMapper.selectByCustIdAndGroupId(groupId, custId);
				if(relInfo == null) {
					crmCustGroupRelInfoMapper.insertRelInfo(groupId, custId, new Date());
					return custId;
				} else {
					log.warn("cust had in group, custId:{} groupId:{}", custId, groupId);
					return "-2";
				}
			} else {
				log.warn("custId or groupId is null cannot addCustToCustGroup");
				return "-1";
			}
    	} catch (Exception e) {
    		log.error("addCustToCustGroup error custId:{} groupId:{}", custId, groupId, e);
    		throw e;
    	}
    }
    
    /**
     * @函数名称: deleteByGroupId
     * @函数描述: 根据客户群编号，删除客户群成员信息表数据
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public String deleteByGroupId(String groupId) throws Exception {
    	try {
			if(StringUtil.isNotEmpty(groupId)) {
				crmCustGroupRelInfoMapper.deleteByGroupId(groupId);
				return groupId;
			} else {
				log.warn("groupId is null cannot deleteByGroupId");
				return "-1";
			}
    	} catch (Exception e) {
    		log.error("deleteByGroupId error groupId:{}", groupId, e);
    		throw e;
    	}
    }
    
    /**
     * @函数名称:queryGroupMember
     * @函数描述:客户群成员列表查询
     * @参数与返回说明:
     * @算法描述:
     */
	public List<Map<String, Object>> queryGroupMember(QueryModel model) throws Exception {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = crmCustGroupRelInfoMapper.queryGroupMember(model);
		PageHelper.clearPage();
		return list;
	}
	
    /**
     * @函数名称: removeCustsFromCustGroup
     * @函数描述: 从客户群成员中删除客户，支持批量
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public String removeCustsFromCustGroup(String groupId, String custIds) throws Exception {
    	try {
			if(StringUtil.isNotEmpty(custIds) && StringUtil.isNotEmpty(groupId)) {
				crmCustGroupRelInfoMapper.removeCustsFromCustGroup(groupId, custIds.split(","));
				return groupId;
			} else {
				log.warn("custIds or groupId is null cannot removeCustsFromCustGroup");
				return "-1";
			}
    	} catch (Exception e) {
    		log.error("removeCustsFromCustGroup error custIds:{} groupId:{}", custIds, groupId, e);
    		throw e;
    	}
    }
    
    /**
     * @函数名称:queryGroupMemberCount
     * @函数描述:根据客户群编号，查询群成员数量
     * @参数与返回说明:
     * @算法描述:
     */
	public List<Map<String, Object>> queryGroupMemberCount(String groupId) throws Exception {
		QueryModel model = new QueryModel();
		model.getCondition().put("groupId", groupId);
		List<Map<String, Object>> list = crmCustGroupRelInfoMapper.queryGroupMember(model);
		return list;
	}
}
