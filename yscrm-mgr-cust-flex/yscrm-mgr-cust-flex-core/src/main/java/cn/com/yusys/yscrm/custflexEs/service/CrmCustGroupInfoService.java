package cn.com.yusys.yscrm.custflexEs.service;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custflexEs.domain.CrmCustGroupInfo;
import cn.com.yusys.yscrm.custflexEs.model.CustGroupInfoModel;
import cn.com.yusys.yscrm.custflexEs.repository.mapper.CrmCustGroupInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmCustGroupInfoService
 * @类描述: #客户群信息表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-08 11:13:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class CrmCustGroupInfoService extends CommonService {
	
	private static final Logger log = LoggerFactory.getLogger(CrmCustGroupInfoService.class);
	
    @Autowired
    private CrmCustGroupInfoMapper crmCustGroupInfoMapper;
    
    @Autowired
    private UserInfoService userInfoService;
    
    @Autowired
    private CrmCustGroupRelInfoService relInfoService;
    
//    @Autowired
//    private CrmCustGroupRuleInfoService groupRuleInfoService;
//    
//    @Autowired
//    private CrmCustGroupJoinApproService groupJoinApproService;
//    
//    @Autowired
//    private SequenceTemplateService sequenceTemplateService;

    @Override
    protected CommonMapper<?> getMapper() {
        return crmCustGroupInfoMapper;
    }

    /**
     * @函数名称:queryList
     * @函数描述:客户群列表查询
     * @参数与返回说明:
     * @算法描述:
     */
	public List<Map<String, Object>> queryList(QueryModel model) throws Exception {
		model.getCondition().put("curUserId", userInfoService.getUserInfo().getLoginCode());
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = crmCustGroupInfoMapper.queryList(model);
		PageHelper.clearPage();
		return list;
	}
	
//	/**
//     * @函数名称:upsertCustGroupInfo
//     * @函数描述:维护客户群信息
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
//    public String upsertCustGroupInfo(CrmCustGroupInfo obj) throws Exception {
//    	try {
//			if(StringUtil.isNotEmpty(obj.getGroupId())) {
//				crmCustGroupInfoMapper.updateByPrimaryKey(obj);
//			} else {
//				Map<String, String> map = new HashMap<String, String>();
//				DateTimeFormatter TIME6 = DateTimeFormatter.ofPattern("HHmmss");
//    			String TIME6Str = TIME6.format(LocalDateTime.now());
//				map.put("time", TIME6Str);
//				obj.setGroupId(sequenceTemplateService.getSequenceTemplate("CUST_GROUP_ID", map));	// 新增时，客户群编号使用全局序列号
//				obj.setCreateUser(userInfoService.getUserInfo().getLoginCode());
//				obj.setCreateOrg(userInfoService.getOrgCode());
//				obj.setCreateDt(new Date());
//				crmCustGroupInfoMapper.insertSelective(obj);
//			}
//    		return obj.getGroupId();
//    	} catch (Exception e) {
//    		log.error("upsertCustGroupInfo error groupName:{}", obj.getGroupName(), e);
//    		throw e;
//    	}
//    }
    
//	/**
//     * @函数名称: deleteCustGroupInfo
//     * @函数描述: 删除客户群
//     * @参数与返回说明:
//     * @return
//     *   "-1": groupId为空或不存在
//     *   "-2": 非本人创建的客户群不允许删除
//     *   "-3": 当前日期早于活动引入终止日期，不允许删除
//     *   groupId: 删除成功
//     * @算法描述:
//     */
//    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
//    public String deleteCustGroupInfo(String groupId) throws Exception {
//    	try {
//			if(StringUtil.isNotEmpty(groupId)) {
//				CrmCustGroupInfo groupInfo = crmCustGroupInfoMapper.selectByPrimaryKey(groupId);
//				if(groupInfo != null) {
//					if(userInfoService.getUserInfo().getLoginCode().equals(groupInfo.getCreateUser())) {
//						LocalDate curDate = LocalDate.now();
//						if(groupInfo.getActivityExpiryDate() != null && groupInfo.getActivityExpiryDate().after(curDate.toDate())) {
//							log.warn("curDate:{} is before activityExpiryDate:{}, cannot delete custGroupInfo, groupId:{}", 
//									curDate.toString(), groupInfo.getActivityExpiryDate(), groupId);
//							return "-3";
//						}
//						crmCustGroupInfoMapper.deleteByPrimaryKey(groupId);
//						if("00".equals(groupInfo.getGroupClass())) {
//							// 自定义客户群，删除-客户群成员信息表数据
//							relInfoService.deleteByGroupId(groupId);
//						} else if("01".equals(groupInfo.getGroupClass())){
//							// 规则客户群，删除客户群规则信息数据
//							groupRuleInfoService.deleteByGroupId(groupId);
//						}
//						return groupId;
//					} else {
//						log.warn("currentUser:{} not equal createUser:{}", userInfoService.getUserInfo().getLoginCode(), groupInfo.getCreateUser());
//						return "-2";
//					}
//				} else {
//					log.warn("groupId:{} is not exists in table CRM_CUST_GROUP_INFO", groupId);
//					return "-1";
//				}
//			} else {
//				log.warn("groupId is null, cannot delete custgroupinfo");
//				return "-1";
//			}
//    	} catch (Exception e) {
//    		log.error("deleteCustGroupInfo error groupId:{}", groupId, e);
//    		throw e;
//    	}
//    }
    
//    /**
//     * @函数名称: updateActivityExpiryDate
//     * @函数描述: 更新客户群-活动引入终止日期数据
//     * @参数与返回说明:
//     * @param groupId 客户群编号
//     * @param newActivityExpiryDate 待更新的活动引入终止日期
//     * @return
//     *   "-1": 请求参数为空或groupId不存在，不更新
//     *   "-2": 当前活动引入终止日期早于存量的活动引入终止日期，不更新
//     *   groupId: 更新成功
//     * @算法描述:
//     */
//    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
//    public String updateActivityExpiryDate(String groupId, Date newActivityExpiryDate) throws Exception {
//    	try {
//			if(StringUtil.isNotEmpty(groupId) && newActivityExpiryDate != null) {
//				CrmCustGroupInfo groupInfo = crmCustGroupInfoMapper.selectByPrimaryKey(groupId);
//				if(groupInfo != null) {
//					if(groupInfo.getActivityExpiryDate() != null && groupInfo.getActivityExpiryDate().after(newActivityExpiryDate)) {
//						log.warn("newActivityExpiryDate:{} is before activityExpiryDate:{}, cannot updateActivityExpiryDate, groupId:{}", 
//								newActivityExpiryDate, groupInfo.getActivityExpiryDate(), groupId);
//						return "-2";
//					}
//					crmCustGroupInfoMapper.updateActivityExpiryDate(groupId, newActivityExpiryDate);
//					return groupId;
//				} else {
//					log.warn("groupId:{} is not exists in table CRM_CUST_GROUP_INFO", groupId);
//					return "-1";
//				}
//			} else {
//				log.warn("groupId or newActivityExpiryDate is null, cannot updateActivityExpiryDate");
//				return "-1";
//			}
//    	} catch (Exception e) {
//    		log.error("updateActivityExpiryDate error groupId:{}, newActivityExpiryDate:{}", groupId, newActivityExpiryDate, e);
//    		throw e;
//    	}
//    }
//    
//    /**
//     * @函数名称:queryGroupMember
//     * @函数描述:客户群成员列表查询
//     * @参数与返回说明:
//     * @算法描述:
//     */
//	public List<Map<String, Object>> queryGroupMember(QueryModel model) throws Exception {
//		return relInfoService.queryGroupMember(model);
//	}
	
	/**
     * @函数名称: addCustsToGroup
     * @函数描述: 添加客户到自定义客户群
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public String addCustsToGroup(CustGroupInfoModel model) throws Exception {
    	try {
    		String groupId = model.getGroupId();
    		String custIds = model.getCustIds();
			if(StringUtil.isNotEmpty(groupId) && StringUtil.isNotEmpty(custIds)) {
				CrmCustGroupInfo groupInfo = crmCustGroupInfoMapper.selectByPrimaryKey(groupId);
				if(groupInfo != null) {
					if("00".equals(groupInfo.getGroupClass())) {	// 判断非自定义客户群不允许添加客户
						String[] custIdsArr = custIds.split(",");
						for(String custId: custIdsArr) {
							relInfoService.addCustToCustGroup(groupId, custId);
						}
						return groupId;
					} else {
						log.warn("groupId:{} groupClass:{} cannot add cust", groupId, groupInfo.getGroupClass());
						return "-2";
					}
				} else {
					log.warn("groupId:{} is not exists in table CRM_CUST_GROUP_INFO", groupId);
					return "-1";
				}
			} else {
				log.warn("groupId or custIds is null, cannot addCustsToGroup");
				return "-1";
			}
    	} catch (Exception e) {
    		log.error("addCustsToGroup error groupId:{}, custIds:{}", model.getGroupId(), model.getCustIds(), e);
    		throw e;
    	}
    }
    
//	/**
//     * @函数名称: removeCustsFromGroup
//     * @函数描述: 从客户群成员中删除客户
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
//    public String removeCustsFromGroup(CustGroupInfoModel model) throws Exception {
//    	try {
//    		String groupId = model.getGroupId();
//    		String custIds = model.getCustIds();
//			if(StringUtil.isNotEmpty(groupId) && StringUtil.isNotEmpty(custIds)) {
//				CrmCustGroupInfo groupInfo = crmCustGroupInfoMapper.selectByPrimaryKey(groupId);
//				if(groupInfo != null) {
//					if("00".equals(groupInfo.getGroupClass())) {	// 判断非自定义客户群不允许删除客户
//						return relInfoService.removeCustsFromCustGroup(groupId, custIds);
//					} else {
//						log.warn("groupId:{} groupClass:{} cannot remove cust", groupId, groupInfo.getGroupClass());
//						return "-2";
//					}
//				} else {
//					log.warn("groupId:{} is not exists in table CRM_CUST_GROUP_INFO", groupId);
//					return "-1";
//				}
//			} else {
//				log.warn("groupId or custIds is null, cannot removeCustsFromGroup");
//				return "-1";
//			}
//    	} catch (Exception e) {
//    		log.error("removeCustsFromGroup error groupId:{}, custIds:{}", model.getGroupId(), model.getCustIds(), e);
//    		throw e;
//    	}
//    }
    
//	/**
//     * @函数名称:queryGroupRuleInfoByGroupId
//     * @函数描述:查询规则客户群-查询规则信息
//     * @参数与返回说明:
//     * @算法描述:
//     */
//	public List<Map<String, Object>> queryGroupRuleInfoByGroupId(String groupId) throws Exception {
//		return groupRuleInfoService.queryGroupRuleInfoByGroupId(groupId);
//	}
	
//	/**
//     * @函数名称: upsertGroupRuleInfo
//     * @函数描述: 维护规则客户群-查询规则信息
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
//    public String upsertGroupRuleInfo(CustGroupInfoModel model) throws Exception {
//    	try {
//    		String groupId = model.getGroupId();
//    		List<CrmCustGroupRuleInfo> groupRuleInfoList = model.getGroupRuleInfoList();
//			if(StringUtil.isNotEmpty(groupId) && groupRuleInfoList != null && groupRuleInfoList.size() > 0) {
//				CrmCustGroupInfo groupInfo = crmCustGroupInfoMapper.selectByPrimaryKey(groupId);
//				if(groupInfo != null) {
//					if("01".equals(groupInfo.getGroupClass())) {	// 判断非规则客户群不允许维护规则信息
//						groupRuleInfoService.deleteByGroupId(groupId);
//						for(CrmCustGroupRuleInfo ruleInfo: groupRuleInfoList) {
//							ruleInfo.setGroupId(groupId);
//							ruleInfo.setId(null);
//							groupRuleInfoService.insertSelective(ruleInfo);
//						}
//						return groupId;
//					} else {
//						log.warn("groupId:{} groupClass:{} cannot upsertGroupRuleInfo", groupId, groupInfo.getGroupClass());
//						return "-2";
//					}
//				} else {
//					log.warn("groupId:{} is not exists in table CRM_CUST_GROUP_INFO", groupId);
//					return "-1";
//				}
//			} else {
//				log.warn("groupId or groupRuleInfoList is null, cannot upsertGroupRuleInfo");
//				return "-1";
//			}
//    	} catch (Exception e) {
//    		log.error("upsertGroupRuleInfo error groupId:{}, groupRuleInfoList.size:{}", model.getGroupId(), model.getGroupRuleInfoList().size(), e);
//    		throw e;
//    	}
//    }
    
    /**
     * @函数名称:queryToJoinCustGroupList
     * @函数描述:待加入客户群列表查询
     * @参数与返回说明:
     * @算法描述:
     * 查询本人创建、同级或上级创建的共享型自定义客户群
     */
	public List<Map<String, Object>> queryToJoinCustGroupList(QueryModel model) throws Exception {
		model.getCondition().put("curUserId", userInfoService.getUserInfo().getLoginCode());
		model.getCondition().put("curOrgCode", userInfoService.getOrgCode());
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = crmCustGroupInfoMapper.queryToJoinCustGroupList(model);
		PageHelper.clearPage();
		return list;
	}
	
//	/**
//     * @函数名称: addCustsToGroupApply
//     * @函数描述: 客户加入客户群申请
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
//    public String addCustsToGroupApply(CustGroupInfoModel model) throws Exception {
//    	try {
//    		String groupId = model.getGroupId();
//    		String custIds = model.getCustIds();
//			if(StringUtil.isNotEmpty(groupId) && StringUtil.isNotEmpty(custIds)) {
//				CrmCustGroupInfo groupInfo = crmCustGroupInfoMapper.selectByPrimaryKey(groupId);
//				if(groupInfo != null && "00".equals(groupInfo.getGroupClass())) {
//					String[] custIdsArr = custIds.split(",");
//					if(userInfoService.getUserInfo().getLoginCode().equals(groupInfo.getCreateUser())) {	
//						// 1、本人创建的客户群，直接增加群成员信息
//						for(String custId: custIdsArr) {
//							relInfoService.addCustToCustGroup(groupId, custId);
//						}
//						return "1";
//					} else {
//						// 2、其他共享型客户群，判断是否需要入群审批
//						if("00".equals(groupInfo.getGroupShareType())) {	// 共享型客户群
//							if("1".equals(groupInfo.getIfApprrove())) {
//								// 2-1、入群审批，增加入群审批信息
//								groupJoinApproService.addCustGroupJoinApproInfo(groupInfo, custIdsArr);
//								return "2";
//							} else {
//								// 2-2、不需要入群审批，增加群成员信息
//								for(String custId: custIdsArr) {
//									relInfoService.addCustToCustGroup(groupId, custId);
//								}
//								return "1";
//							}
//						} else {	// 非共享型客户群不允许操作
//							log.warn("groupId:{} groupShareType:{} cannot addCustsToGroupApply", groupId, groupInfo.getGroupShareType());
//							return "-3";
//						}
//					}
//				} else {	// 客户群编号不存在或非自定义客户群
//					log.warn("groupId:{} is not exists or groupClass:{} cannot add cust", groupId, groupInfo.getGroupClass());
//					return "-2";
//				}
//			} else {
//				log.warn("groupId or custIds is null, cannot addCustsToGroupApply");
//				return "-1";
//			}
//    	} catch (Exception e) {
//    		log.error("addCustsToGroupApply error groupId:{}, custIds:{}", model.getGroupId(), model.getCustIds(), e);
//    		throw e;
//    	}
//    }
    
//    /**
//     * @函数名称:getGroupMemberCount
//     * @函数描述:获取客户群成员数量
//     * @参数与返回说明:
//     * @算法描述:
//     *   1、自定义客户群: 直接查询 客户群成员信息表，获取对应客户群数量
//     *   2、规则客户群: 根据客户群规则配置信息，实时查询符合规则的客户数量
//     */
//	public Integer getGroupMemberCount(String groupIds) throws Exception {
//		Set<Object> numSet=new HashSet<Object>();
//		String[] groupIdarr=groupIds.split(","); // 客户群组
//		if(groupIdarr!=null&&groupIdarr.length!=0) {
//			// 循环 传入的客户群ID
//			for(String groupId:groupIdarr) {
//				if(StringUtil.isNotEmpty(groupId)) {
//					CrmCustGroupInfo groupInfo = crmCustGroupInfoMapper.selectByPrimaryKey(groupId);
//					if("00".equals(groupInfo.getGroupClass())) {	// 自定义
//						List<Map<String, Object>> list = relInfoService.queryGroupMemberCount(groupId);
//						for(Map<String, Object> map :list) {
//							numSet.add(map.get("custId"));
//						}
//					} else if("01".equals(groupInfo.getGroupClass())) {	// 规则
//						// 查询客户群配置的规则信息
//						List<Map<String, Object>> conditionList = groupRuleInfoService.queryGroupRuleInfoByGroupId(groupId);
//						if(conditionList == null || conditionList.size() == 0) {
//							log.warn("cust group rule is empty");
//							return 0;
//						}
//						BoolQueryBuilder queryBuilder = CmssFCiFqUtil.buildFqQueryBuilder(conditionList, true);
//						// 处理数据权限
//						if(userInfoService.isMgr()) {
//							queryBuilder.must(QueryBuilders.termQuery("mgrId", userInfoService.getUserInfo().getLoginCode()));
//						} else {
//							queryBuilder.must(QueryBuilders.wildcardQuery("orgSeq", "*" + userInfoService.getOrgCode() + "*"));
//						}
//						NativeSearchQuery searchQuery  = new NativeSearchQueryBuilder()
//								.withQuery(queryBuilder)	// 查询条件
//								.build();
//						// 调用ElasticsearchUtil工具查询数据
//						 //查询出所有的客户数据
//						List<CrmCustFlexibleInfoView> CrmCustlist = ElasticsearchUtil.queryForPageList(searchQuery, CrmCustFlexibleInfoView.class);
//						/**
//						 * 循环列表
//						 */
//						for(CrmCustFlexibleInfoView custInfo:CrmCustlist) {
//							numSet.add(custInfo.getCustId());
//						}
//					}
//				} else {
//					log.warn("param groupId is null cannot getMemberCount");
//					return 0;
//				}
//			}
//		}
//		return 	numSet.size();
//	}
}
