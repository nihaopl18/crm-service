package cn.com.yusys.climp.acty.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.climp.acty.domain.LoyEngRuleInfo;
import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.climp.acty.repository.mapper.LoyEngRuleInfoMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyEngRuleSetMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyEngTransactionRoutingMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyRlActivityMapper;
import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.sequence.service.SequenceTemplateService;
/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlActivityService
 * @类描述: 积分活动服务类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:08:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyRlActivityService extends CommonService {
	/**日志*/
	private Logger logger = LoggerFactory.getLogger(LoyRlActivityService.class);
    @Autowired
    private LoyRlActivityMapper loyRlActivityMapper;
    @Autowired
    private LoyEngRuleInfoMapper loyEngRuleInfoMapper;
	@Autowired
	private UserInfoService userInfo;
//    @Autowired
//	SequenceConfigService sequenceConfigService;
	@Autowired
    private SequenceTemplateService sequenceConfigService;
    @Autowired
    private LoyEngRuleSetMapper loyEngRuleSetMapper;
    @Autowired
    private LoyEngTransactionRoutingMapper loyEngTransactionRoutingMapper;
    @Override
    protected CommonMapper<?> getMapper() {
        return loyRlActivityMapper;
    }
    /**
    * @方法名称:getActivityInfo
    * @方法描述:查询积分活动信息
    * @参数与返回说明:
    * @算法描述:
     */
    public List<Map<String,String>> getActivityInfo(QueryModel model) {
    	model.setSort("t.create_date desc");
		PageHelper.startPage(model.getPage(), model.getSize());
		model.getCondition().put("loginCode", userInfo.getLoginCode());
		List<Map<String,String>> list = loyRlActivityMapper.getActivityInfo(model);
		PageHelper.clearPage();
		logger.info("查询积分活动信息");
		return list;
	}
    /**
    * @方法名称:getActiveForm
    * @方法描述:根据节点id查询活动
    * @参数与返回说明:
    * @算法描述:
     */
    public LoyRlActivity getActiveForm(String nodeId) {
    	return loyRlActivityMapper.getActiveForm(nodeId);
    }
    
    /**
    * @方法名称:getActivityInfo
    * @方法描述:判断优先级是否重复
    * @参数与返回说明:
    * @算法描述:
     */
    public List<Map<String,String>> priorityList(QueryModel model) {
		List<Map<String,String>> list = loyRlActivityMapper.priorityList(model);
		return list;
	}
    /***
	 * 序列号
	 * @return
	 */
	public String generateNumber() {
//		SequenceConfig seqenceConfig = sequenceConfigService.selectBySeqId("ID_SEQUENCES");
		String id = "";
//		id =  sequenceConfigService.getNextSeq("ID_SEQUENCES",seqenceConfig);
//		try {
			id =  sequenceConfigService.getNextSeq("ID_SEQUENCES");
//		} catch (SequenceConfigException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		return id;
	}
    /**
     * 新增积分活动
     */
    public int insert(Object record) {
    	LoyRlActivity pool = (LoyRlActivity) record;
		// 获取登录用户的机构号
		String orgCode = userInfo.getOrgCode();
		// 获取当前会话信息
		String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			pool.setBeginDate(df.parse(df.format(pool.getBeginDate())));
			pool.setEndDate(df.parse(df.format(pool.getEndDate())));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(pool.getActivityId()==null) {
			pool.setActivityId(generateNumber());//生成id序号
		}
		pool.setCreateDate(new Date());
		pool.setUpdateDate(new Date());
		pool.setCreateUser(loginCode);
		pool.setUpdateUser(loginCode);
		pool.setUpdateOrg(orgCode);
		pool.setCreateOrg(orgCode);
		pool.setWfApprSts("000");// 审批状态默认为未提交
		pool.setUseFlag("0");// 启停用状态 默认为未启用
		logger.info("新增积分活动");
		return this.insertSelective(pool);
	}
	/**
	 * 修改积分活动
	 */
	public int update(Object t) {
		LoyRlActivity pool = (LoyRlActivity) t;
		LoyEngRuleInfo info = new LoyEngRuleInfo();
		// 获取登录用户的机构号
		String orgCode = userInfo.getOrgCode();
		// 获取当前会话信息
		String loginCode = SecurityUtils.getCurrentUserLogin();
		pool.setUpdateDate(new Date());
		pool.setUpdateUser(loginCode);
		pool.setUpdateOrg(orgCode);
		pool.setWfApprSts("000");// 审批状态默认为待发起
		pool.setUseFlag("0");
        BigDecimal bd=new BigDecimal(pool.getActivityId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String D1 = sdf.format(pool.getBeginDate());
        String D2 = sdf.format(pool.getEndDate());
        try {
			Date beginDate =  sdf.parse(D1);
			Date endDate =  sdf.parse(D2);
			info.setBeginDate(beginDate);
			info.setEndDate(endDate);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
//		info.setPoolNo(pool.getPoolNo()); 2019-03-26 chenlin 权益引擎改造
		info.setRuleSetId(bd);
		logger.info("修改积分活动");
		loyEngRuleInfoMapper.updatePoolNo(info);
		loyEngRuleSetMapper.deleteRuleSet(pool.getActivityId());
		loyEngTransactionRoutingMapper.deleteRouting(pool.getActivityId());
		return this.updateSelective(pool);
	}
	/**
	 * 修改积分活动状态
	 */
	public int updateSts(Object t) {
		LoyRlActivity pool = (LoyRlActivity) t;
		// 获取登录用户的机构号
		String orgCode = userInfo.getOrgCode();
		// 获取当前会话信息
		String loginCode = SecurityUtils.getCurrentUserLogin();
		pool.setUpdateDate(new Date());
		pool.setUpdateUser(loginCode);
		pool.setUpdateOrg(orgCode);
		logger.info("修改积分活动");
		return this.updateSelective(pool);
	}
	/**
	* @方法名称:deleteBatch
	* @方法描述:根据活动id删除活动信息
	* @参数与返回说明:
	* @算法描述:
	 */
	public int deleteBatch(String[] idStr,String orgCode) {
		int n = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					Map<String, String> typeMap = new HashMap<>();
					typeMap.put("activityId", idStr[i]);
					typeMap.put("orgCode", orgCode);
					typeMap.put("userCode", loginCode);
					n = n + loyRlActivityMapper.updataActyById(typeMap);
				}
			}
			logger.info("根据活动id删除活动信息");
		}
		return n;
	}
	/**
	* @方法名称:deleteBatchRuleInfo
	* @方法描述:删除规则表
	* @参数与返回说明:
	* @算法描述:
	 */
	public int deleteBatchRuleInfo(String[] idStr) {
		int n = 0;  
		if (idStr != null && !"".equals(idStr.toString())) {
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					Map<String, String> typeMap = new HashMap<>();
					typeMap.put("activityId", idStr[i]);
					n = n + loyEngRuleInfoMapper.updataRuleInfo(typeMap);
				}
			}
			logger.info("批量删除规则信息");
		}
		return n;
	}
	
	/**
	 * 
	 * @方法名称: useIngFn
	 * @方法描述: 批量启用事件
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public int useIngFn(String[] idStr,String orgCode) {
		int n = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					Map<String, String> typeMap = new HashMap<>();
					typeMap.put("activityId", idStr[i]);
					typeMap.put("useflag", "1");
					typeMap.put("orgCode", orgCode);
					typeMap.put("userCode", loginCode);
					n = n + loyRlActivityMapper.updateSts(typeMap);
					loyEngRuleSetMapper.insertRuleSet(idStr[i]);
					loyEngTransactionRoutingMapper.insertRouting(idStr[i]);
				}
			}
			logger.info("批量启用活动信息");
		}
		return n;
	}

	/**
	 * 
	 * @方法名称: unUseIngFn
	 * @方法描述: 批量停用事件
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public int unUseIngFn(String[] idStr,String orgCode) {
		int n = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					Map<String, String> typeMap = new HashMap<>();
					typeMap.put("activityId", idStr[i]);
					typeMap.put("useflag", "0");
					typeMap.put("orgCode", orgCode);
					typeMap.put("userCode", loginCode);
					n = n + loyRlActivityMapper.updateSts(typeMap);
					loyEngRuleSetMapper.deleteRuleSet(idStr[i]);
					loyEngTransactionRoutingMapper.deleteRouting(idStr[i]);
				}
			}
			logger.info("批量停用活动信息");
		}
		return n;
	}
}
