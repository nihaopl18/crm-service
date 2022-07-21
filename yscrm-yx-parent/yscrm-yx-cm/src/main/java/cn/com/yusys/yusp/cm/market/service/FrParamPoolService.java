package cn.com.yusys.yusp.cm.market.service;

import cn.com.yusys.yusp.cm.market.domain.FrParamPool;
import cn.com.yusys.yusp.cm.market.repository.mapper.FrParamPoolMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @项目名称：yusp-admin
 * @类名称：FrParamPoolService
 * @类描述：系统参数
 * @功能描述:
 * @创建人：zhangxs4@yusys.com.cn
 * @创建时间：2017-12-16 15:05
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class FrParamPoolService extends CommonService {
	@Autowired
	private FrParamPoolMapper mapper;
	
	private final Logger log = LoggerFactory.getLogger(FrParamPoolService.class);
	
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}

	@Override
	public int insert(Object record) {
		FrParamPool frParamPool = (FrParamPool)record;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		frParamPool.setOpTime(df.format(new Date()));
		return this.insertSelective(record);
	}

	@Override
	public int updateSelective(Object record) {
		FrParamPool frParamPool = (FrParamPool)record;
		//DateTime dateTime = DateTime.now();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		frParamPool.setOpTime(df.format(new Date()));
		return this.updateSelective(getMapper(), record);
	}
	
	
	/**
     * @函数名称:selectByModel
     * @函数描述:重新，支持页面模糊查询
     * @参数与返回说明:
     * @算法描述:
     */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> selectByModel(QueryModel model) {
		if(model.getCondition().containsKey("paramId")) {
			model.getCondition().put("paramId","%"+ model.getCondition().get("paramId")+"%");
		}
		if(model.getCondition().containsKey("paramName")) {
			model.getCondition().put("paramName","%"+ model.getCondition().get("paramName")+"%");
		}
		if(model.getCondition().containsKey("paramType")) {
			model.getCondition().put("paramType", model.getCondition().get("paramType"));
		}
		// 设置分页查询参数(设置到线程变量中了)
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,String>> list=this.mapper.getPropListBycodeOrName( model);
		// 清除线程绑定的分页参数，防止影响同线程的其他查询
		PageHelper.clearPage();
	
		return (List<T>) list;
	}
	/**
     * @函数名称:selectlist
     * @函数描述:重新，支持页面模糊查询
     * @参数与返回说明:
     * @算法描述:
     */
	@SuppressWarnings("unchecked")
	public <T> List<T> selectList(String tabName) {
		
		List<Map<String,String>> list=this.mapper.selectList(tabName);
		// 清除线程绑定的分页参数，防止影响同线程的其他查询
	
		return (List<T>) list;
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> selectByparamid(String paramId) {
		List<Map<String,String>> list=this.mapper.selectByparamid(paramId);
		log.info("service="+paramId);
		return (List<T>) list;
	}
	/**
	 * 
	 * @方法名称: createCheckparamid
	 * @方法描述: 检查新增时字段编号是否重复
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public int createCheckparamid(String paramId) {
		return this.mapper.createCheckparamid(paramId);
	}
	
	
	/**
	 * 
	 * @方法名称: list
	 * @方法描述: 查询字段池全部列表
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> list(String transCode) {
		return mapper.list(transCode);
	}
}

