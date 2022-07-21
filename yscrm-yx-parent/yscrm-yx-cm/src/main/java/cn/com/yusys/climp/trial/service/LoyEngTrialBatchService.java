package cn.com.yusys.climp.trial.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.climp.trial.domain.LoyEngTrialBatch;
import cn.com.yusys.climp.trial.repository.mapper.LoyEngTrialBatchMapper;
import cn.com.yusys.climp.trial.web.rest.LoyEngTrialBatchResource;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @项目名称: yusp-climp-trial模块
 * @类名称: LoyEngTrialBatchService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: hujun3
 * @创建时间: 2019-01-03 16:49:16
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyEngTrialBatchService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(LoyEngTrialBatchService.class);
	@Autowired
	private LoyEngTrialBatchMapper loyEngTrialBatchMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return loyEngTrialBatchMapper;
	}

	/**
	 * @方法名称: insertInfo
	 * @方法描述: 新增用户数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public int insertInfo(LoyEngTrialBatch pool) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		pool.setStatus("0");
		pool.setUpdateTime(df.format(new Date()));
		int n = loyEngTrialBatchMapper.insertSelective(pool);
		return n;
	}

	/**
	 * 
	 * @方法名称: queryTrialBatchByPage
	 * @方法描述: 查询试算批次信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryTrialBatchByPage(QueryModel param) {
		PageHelper.startPage(param.getPage(), param.getSize());
		List<Map<String, Object>> result = this.loyEngTrialBatchMapper.queryTrialBatchByPage(param);
		PageHelper.clearPage();
		return result;
	}

	/**
	 * 
	* @方法名称: startTrialEngine
	* @方法描述: 启动试算引擎
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public LoyEngTrialBatch startTrialEngine(String bno,String activityId){
			Map<String,String> param=new HashMap<String,String>();
			param.put("bno", bno);
			param.put("activityId", activityId);
			LoyEngTrialBatch tb = (LoyEngTrialBatch) loyEngTrialBatchMapper.queryTrialBatchByBno(param);
	    	//更新状态为计算中
			
			loyEngTrialBatchMapper.updateTrialBatchByBno(param);
	    	//重新增加试算路由
			loyEngTrialBatchMapper.deleteTrialRount();
			loyEngTrialBatchMapper.addTrialRount(param);
			return tb;
	}
	/**
	 * 
	* @方法名称: deleteBatch
	* @方法描述: 删除批次信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public void deleteBatch(String bno){
		Map<String,String> param=new HashMap<String,String>();
		param.put("bno", bno);
		 loyEngTrialBatchMapper.deleteTrialBatch(param);
		 logger.info("删除批次信息");
	}
	/**
	 * 
	 * @方法名称: queryOrgReport
	 * @方法描述: 查询机构汇总信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryOrgReport(QueryModel param) {
		PageHelper.startPage(param.getPage(), param.getSize());
		List<Map<String, Object>> result = this.loyEngTrialBatchMapper.queryOrgReport(param);
		PageHelper.clearPage();
		return result;
	}

	/**
	 * 
	 * @方法名称: queryProdReport
	 * @方法描述: 查询产品汇总信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryProdReport(QueryModel param) {
		PageHelper.startPage(param.getPage(), param.getSize());
		List<Map<String, Object>> result = this.loyEngTrialBatchMapper.queryProdReport(param);
		PageHelper.clearPage();
		return result;
	}

	/**
	 * 
	 * @方法名称: queryOrgProdReport
	 * @方法描述: 查询产品和机构汇总信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryOrgProdReport(QueryModel param) {
		PageHelper.startPage(param.getPage(), param.getSize());
		List<Map<String, Object>> result = this.loyEngTrialBatchMapper.queryOrgProdReport(param);
		PageHelper.clearPage();
		return result;
	}
	/**
	 * 
	 * @方法名称: queryTransactionCode
	 * @方法描述: 查询交易类型数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryTransactionCode() {
		List<Map<String, Object>> result = this.loyEngTrialBatchMapper.queryTransactionCode();
		return result;
	}
	/**
	 * 
	 * @方法名称: queryTrialBatchNow
	 * @方法描述: 查询未完成的试算批次信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryTrialBatchNow() {
		List<Map<String, Object>> result = this.loyEngTrialBatchMapper.queryTrialBatchNow();
		return result;
	}
	
	/**
	 * 
	 * @方法名称: queryPropInfo
	 * @方法描述: 查询系统参数信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public String  queryPropInfo(String name) {
		String propValue="";
		Map<String,String> param=new HashMap<String,String>();
		param.put("propName", name);
		List<Map<String, Object>> data = this.loyEngTrialBatchMapper.queryPropInfo(param);
		if(!data.isEmpty()) {
			propValue=data.get(0).get("propValue").toString();
		}
		return propValue;
	}
}
