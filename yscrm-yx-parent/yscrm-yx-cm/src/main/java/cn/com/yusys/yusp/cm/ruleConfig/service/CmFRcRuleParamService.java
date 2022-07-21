package cn.com.yusys.yusp.cm.ruleConfig.service;

import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRuleParam;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcRuleParamMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcRuleParamService
 * @类描述: 引用参数配置服务类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-10-11 14:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcRuleParamService extends CommonService{

	private Logger logger = LoggerFactory.getLogger(CmFRcRuleParamService.class);
	@Autowired
	private CmFRcRuleParamMapper mapper;
	
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}
	/**
	 * 
	* @方法名称: getParamList
	* @方法描述: 查询引用参数列表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<CmFRcRuleParam> getParamList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcRuleParam> list = mapper.getParamList(model);
		PageHelper.clearPage();
		return list;
	}
	
	/**
	 * 新增引用参数
	 */
	public int insert(Object record) {
		CmFRcRuleParam pool = (CmFRcRuleParam) record;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		logger.info("引用参数新增数据：【新增引用参数：" + pool.getParamName() + "】 "
				+ df.format(new Date()));
		return this.insertSelective(pool);
	}

	/**
	 * 修改引用参数
	 */
	public int update(Object t) {
		CmFRcRuleParam pool = (CmFRcRuleParam) t;
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
	public int deleteBatch(String[] idStr) {
		int n = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					n = n + this.deleteByPrimaryKey(idStr[i]);
				}
			}
			logger.info("引用参数批量删除  【主键：" + idStr + "】 " + df.format(new Date()));
		}
		return n;
	}
}
