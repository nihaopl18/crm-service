package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.StringUtil;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeIndexRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeIndexScoreMapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeIndexRelService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-20 10:36:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFSchemeIndexRelService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFSchemeIndexRelService.class);
	
    @Autowired
    private PmaFSchemeIndexRelMapper pmaFSchemeIndexRelMapper;


    @Autowired
    private PmaFSchemeIndexScoreMapper pmaFSchemeIndexScoreMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFSchemeIndexRelMapper;
    }
    /**
     * 
     * @param model
     * @return
     */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryIndex(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = pmaFSchemeIndexRelMapper.queryIndex(model);
		PageHelper.clearPage();
		return list;
	}
	 /**
     * 
     * @param model
     * @return
     */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> querySchemeIndex(QueryModel model) {
			PageHelper.startPage(model.getPage(), model.getSize());
			List<Map<String, Object>> list = pmaFSchemeIndexRelMapper.querySchemeIndex(model);//根据方案查询方案中所有指标信息
			PageHelper.clearPage();
			return list;
	}

	@Transactional(readOnly = true)
	public List<Map<String, Object>> querySchemeAndIndex(QueryModel model) {
		String schemeId = (String)model.getCondition().get("schemeId");
		if (!StringUtils.isEmpty(schemeId)) {
			PageHelper.startPage(model.getPage(), model.getSize());
			List<Map<String, Object>> list = pmaFSchemeIndexRelMapper.querySchemeAndIndex(model);//根据方案查询方案中所有指标信息
			PageHelper.clearPage();
			return list;
		}
		return null;
	}
	public Set<String> recursionQueryAllChildren(String indexIds, Set<String> allBaseIndexOfEvlIndexSet) {
	        if (indexIds.indexOf("B") > -1) {// 如果当前节点没有子节点
	            allBaseIndexOfEvlIndexSet.add(indexIds);
	        } else {
	            List<String> directChildrenList = this.queryDirectNodeByNodeId(indexIds);
	            for (String _indexIds : directChildrenList) {// 当前节点已经有子节点无需再对list做判空处理
	                recursionQueryAllChildren(_indexIds, allBaseIndexOfEvlIndexSet);
	            }
	        }
	        return allBaseIndexOfEvlIndexSet;
	    }
	 public List<String> queryDirectNodeByNodeId(String indexId) {
	        List<String> rtList = new ArrayList<String>();
	        String formulStr = "";
	        String evlIndexId = indexId.substring(0, 8);
	        List<Map<String, Object>> list = pmaFSchemeIndexRelMapper.queryEvlIndex(evlIndexId);
	        if (null != list && 0 < list.size()) {
	            formulStr = (String) list.get(0).get("formula");
	            // 正则解析公式中的指标维度ID串(B0000177[01.AA.01])
	            String regex = "[B|E][0-9]+.{10}";
	            Matcher matcher = Pattern.compile(regex).matcher(formulStr);
	            while (matcher.find()) {
	                rtList.add(matcher.group());
	            }
	        }

	        return rtList;
	    }

    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<String> delIndex(Map<String, Object> map) {
        pmaFSchemeIndexRelMapper.delIndex(map);
		pmaFSchemeIndexScoreMapper.deleteScoreBySchemeId(map.get("schemeId").toString(),map.get("indexId").toString(),map.get("applyTypeId").toString(),map.get("balTypeId").toString(),map.get("evlObjType").toString());
        ResultDto<String> result = new ResultDto<String>();
        result.setMessage("删除成功");
        result.setCode(0);
    	return result;
	}
    
	@Transactional(readOnly = true)
	public String queryNames(String objId) {
    	String result = "";
    	List<String> resultList = new ArrayList<String>();
    	try {
    		if(!StringUtil.isEmpty(objId)) {
    			String[] ids = objId.split(",");
    			resultList = this.pmaFSchemeIndexRelMapper.queryNames(ids);
    			if(resultList.size() > 0) {
    				for(String s : resultList) {
    					result += s + ",";
    				}
    				result = result.substring(0, result.length() - 1);
    			}
    		}
    	} catch (Exception e) {
    		result = "-1";
    		e.printStackTrace();
    	}
    	return result;
    }

	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryByMap(QueryModel model) {
		List<Map<String, Object>> list = pmaFSchemeIndexRelMapper.queryByMap(model);
		return list;
	}
	
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryIndexByDash(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = pmaFSchemeIndexRelMapper.queryIndexByDash(model);
		PageHelper.clearPage();
		return list;
	}
	@Transactional(readOnly = true)
	public String queryNamesByDash(String objId) {
    	String result = "";
    	List<String> resultList = new ArrayList<String>();
    	try {
    		if(!StringUtil.isEmpty(objId)) {
    			String[] ids = objId.split(",");
    			resultList = this.pmaFSchemeIndexRelMapper.queryNamesByDash(ids);
    			if(resultList.size() > 0) {
    				for(String s : resultList) {
    					result += s + ",";
    				}
    				result = result.substring(0, result.length() - 1);
    			}
    		}
    	} catch (Exception e) {
    		result = "-1";
    		e.printStackTrace();
    	}
    	return result;
    }
	
	/**
     * @方法名称: deleteBySchemeId
     * @方法描述: 根据考核方案ID，删除数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer deleteBySchemeId(String schemeId) throws Exception {
    	Integer code = 0;
    	try {
    		if(StringUtil.isEmpty(schemeId)) {
    			logger.warn("schemeId is null, can not delete");
    			return -9;
    		}
    		code = pmaFSchemeIndexRelMapper.deleteBySchemeId(schemeId);
    	} catch (Exception e) {
    		logger.error("service deleteBySchemeId error !");
    		logger.error("error schemeId is " + schemeId);
    		e.printStackTrace();
    		throw e;
    	}
    	return code;
    }
    
    /**
     * @方法名称: batchInsert
     * @方法描述: 批量新增数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer batchInsert(List<PmaFSchemeIndexRel> dataList) throws Exception {
    	try {
    		if(dataList != null && dataList.size() > 0) {
    			int resultCount = 0;
    			// 分批次保存
    			int index = dataList.size() / 1000;
		        int remainder = dataList.size() % 1000;
		        for(int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
		        	resultCount += pmaFSchemeIndexRelMapper.batchInsert(dataList.stream().skip(i*1000).limit(1000).collect(Collectors.toList()));
		        }
		        return resultCount;
    		} else {
    			logger.warn("dataList is null, can not batchInsert");
    			return -9;
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案与指标关系表
	 * @参数与返回说明:
	 * @param schemeId 被复制的考核方案编号
	 * @param newSchemeId 新的考核方案编号
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void copySchemeInf(String schemeId, String newSchemeId) throws Exception {
	    try {
	    	pmaFSchemeIndexRelMapper.copySchemeInf(schemeId, newSchemeId);
	    } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryIndexRes(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = pmaFSchemeIndexRelMapper.queryIndexRes(model);
		PageHelper.clearPage();
		return list;
	}

	/**
	 * 评分模型-查询指标信息
	 * @param queryModel 查询参数
	 * @return
	 */
	public List<Map<String, Object>> queryIndexForScore(QueryModel queryModel) {
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = pmaFSchemeIndexRelMapper.queryIndexForScore(queryModel);
		PageHelper.clearPage();
		return list;
	}




}
