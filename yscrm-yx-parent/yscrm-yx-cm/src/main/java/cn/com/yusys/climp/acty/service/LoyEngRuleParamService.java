package cn.com.yusys.climp.acty.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.climp.acty.domain.LoyEngRuleParam;
import cn.com.yusys.climp.acty.repository.mapper.LoyEngRuleParamMapper;
import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.sequence.service.SequenceTemplateService;

/**
 * 
 * @项目名称：yusp-climp-acty-core
 * @类名称：LoyEngRuleParamService
 * @类描述：引用参数服务类
 * @功能描述:
 * @创建人：chenlin2@yusys.com.cn
 * @创建时间：2018-12-28 10:43
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class LoyEngRuleParamService  extends CommonService{
	/**日志*/
	private Logger logger = LoggerFactory.getLogger(LoyEngRuleParamService.class);
	
	@Autowired
	private LoyEngRuleParamMapper mapper;
	
	@Autowired
	private UserInfoService userInfo;
	
//	@Autowired
//	SequenceConfigService sequenceConfigService;
	@Autowired
    private SequenceTemplateService sequenceConfigService;

	@Override
	protected CommonMapper<?> getMapper() {
		// TODO 自动生成的方法存根
		return this.mapper;
	}

	/**
	 * 
	* @方法名称: getParamList
	* @方法描述: 判断参数编号是否重复
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<LoyEngRuleParam> getParamList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<LoyEngRuleParam> list = mapper.getParamList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	 * 
	* @方法名称: getRuleParamList
	* @方法描述: 查询引用参数列表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<LoyEngRuleParam> getRuleParamList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<LoyEngRuleParam> list = mapper.getRuleParamList(model);
		PageHelper.clearPage();
		return list;
	}
	/***
	 * 序列号
	 * @return
	 */
	public String generateNumber() {
//		SequenceConfig seqenceConfig = sequenceConfigService.selectBySeqId("ID_SEQUENCES");
		String id = "";
		id =  sequenceConfigService.getNextSeq("ID_SEQUENCES");
//		try {
//			id =  sequenceConfigService.getNextSeq("ID_SEQUENCES", seqenceConfig);
//		} catch (SequenceConfigException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		return id;
	}
	/**
	 * 新增引用参数
	 */
	public int insert(Object record) { 
		LoyEngRuleParam pool = (LoyEngRuleParam) record;
		// 获取登录用户的机构号
		String orgCode = userInfo.getOrgCode();
		// 获取当前会话信息
		String loginCode = SecurityUtils.getCurrentUserLogin();
		pool.setId(Long.parseLong(generateNumber()));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		pool.setCreateDate(new Date());
		pool.setUpdateDate(new Date());
		pool.setCreateUser(loginCode);
		pool.setUpdateUser(loginCode);
		pool.setUpdateOrg(orgCode);
		pool.setCreateOrg(orgCode);
		logger.info("引用参数新增数据：【新增引用参数：" + pool.getParamName() + "】 "
				+ df.format(new Date()));
		return this.insertSelective(pool);
	}

	/**
	 * 修改引用参数
	 */
	public int update(Object t) {
		LoyEngRuleParam pool = (LoyEngRuleParam) t;
		// 获取登录用户的机构号
		String orgCode = userInfo.getOrgCode();
		// 获取当前会话信息
		String loginCode = SecurityUtils.getCurrentUserLogin();
		pool.setUpdateDate(new Date());
		pool.setUpdateUser(loginCode);
		pool.setUpdateOrg(orgCode);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		logger.info("引用参数修改数据：【修改引用参数：" + pool.getParamName() + "】的相关数据； "
				+ df.format(new Date()));
		return this.updateSelective(pool);
	}
	/**
	 * 引用参数批量删除
	 * @param idStr
	 * @return
	 */
	public int batchDelete(String[] idStr) {
		int count = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					count = count + this.deleteByPrimaryKey(idStr[i]);
				}
			}
			logger.info("引用参数批量删除  【主键：" + idStr + "】 " + df.format(new Date()));
		}
		return count;
	}
}
