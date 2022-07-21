package cn.com.yusys.yusp.cm.marketanlaty.service;


import cn.com.yusys.yusp.cm.marketanlaty.repository.mapper.MergeOcrmFMkActiFedbackMapper;
import cn.com.yusys.yusp.cm.marketanlaty.repository.mapper.MergeOcrmFMkActiTargetMapper;
import cn.com.yusys.yusp.cm.marketanlaty.repository.mapper.MergeOcrmFMkActivityMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkActiFedbackMapper
 * @类描述：营销活动反馈
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-30 
 */
@Service
public class OcrmFMkActiAnlatyService extends CommonService {
	@Autowired
	private MergeOcrmFMkActiFedbackMapper mapper;
	@Autowired
	private MergeOcrmFMkActivityMapper actmapper;
	@Autowired
	private MergeOcrmFMkActiTargetMapper mapperTarget;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* @方法名称: actiTree
	* @方法描述: 营销活动分析树
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>actiTree(QueryModel model) {
		return actmapper.actiTree(model);
	}
	/**
	* @throws ParseException 
	* @方法名称: getActUser
	* @方法描述: 营销活动反馈查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> actiFedBackList (QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.actiFedBackList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: actiAnlatyTarget
	* @方法描述: 营销成效分析指标查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>> actiAnlatyTarget(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> tar = new ArrayList<Map<String,Object>>();
		if(model.getCondition().get("exeObjType")!=null) {
			tar= mapperTarget.targetList(model);
		}
		return tar;
	}
	/**
	* @方法名称: getTargetPie
	* @方法描述: 营销成效指标目标机构占比图
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getTargetPie(QueryModel model) {
		return mapperTarget.getTargetPie(model);
	}
	/**
	* @方法名称: getTargetBar
	* @方法描述: 营销成效指标目标机构完成情况对比图
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getTargetBar(QueryModel model) {
		return mapperTarget.getTargetBar(model);
	}
	/**
	* @方法名称: getCmBar
	* @方法描述: 营销成效指标目标客户经理进展图
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getCmBar(QueryModel model) {
		return mapperTarget.getCmBar(model);
	}
	/**
	* @方法名称: getCmPie
	* @方法描述: 营销成效指标目标客户经理占比图
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getCmPie(QueryModel model){
		return mapperTarget.getCmPie(model);
	}
}
