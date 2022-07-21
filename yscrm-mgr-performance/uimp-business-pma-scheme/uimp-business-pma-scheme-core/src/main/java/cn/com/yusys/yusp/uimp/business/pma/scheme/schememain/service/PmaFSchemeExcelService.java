package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.sequence.service.SequenceTemplateService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFScheme;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexSplit;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeOrgRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemePostRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeSperuleRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeExcelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeIndexRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeIndexSplitMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeOrgRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemePostRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeSperuleRelMapper;
import tk.mybatis.mapper.util.StringUtil;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeExcelService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 15:01:33
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFSchemeExcelService extends CommonService {
	private static String BASE_SEQ="SCHEME_ID_SEQ";
    @Autowired
    private PmaFSchemeExcelMapper pmaFSchemeExcelMapper;
    
    @Autowired
    private PmaFSchemeOrgRelMapper pmaFSchemeOrgRelMapper;
    
    @Autowired
    private PmaFSchemePostRelMapper pmaFSchemePostRelMapper;
    
    @Autowired
    private PmaFSchemeSperuleRelMapper pmaFSchemeSperuleRelMapper;
    
    @Autowired
    private PmaFSchemeIndexRelMapper pmaFSchemeIndexRelMapper;
    
    @Autowired
    private PmaFSchemeIndexSplitMapper pmaFSchemeIndexSplitMapper;
    
    @Autowired
    private UserInfoService userInfoService;
    
    @Autowired
    private SequenceTemplateService sequenceTemplateService;
    
    @Autowired
    private PmaFSchemeIndexRelService pmaFSchemeIndexRelService;
    

    
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFSchemeExcelMapper;
    }
	@Transactional(readOnly = true)
	public List<Map<String, Object>> querylist(QueryModel model) {
        String orgId = userInfoService.getOrgCode();
        model.getCondition().put("orgId", orgId);
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = pmaFSchemeExcelMapper.listByModel(model);
		PageHelper.clearPage();
		return list;
    }
	
	@Transactional(readOnly = true)
	public String queryNames(String schemeId) {
    	String result = "";
    	List<String> resultList = new ArrayList<String>();
    	try {
    		if(!StringUtil.isEmpty(schemeId)) {
    			String[] ids = schemeId.split(",");
    			resultList = this.pmaFSchemeExcelMapper.queryNames(ids);
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
    
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<PmaFScheme> addInfo(PmaFScheme pmaFScheme) {
		UserInfoDTO user = getUser();
    	pmaFScheme.setCreator(user.getLoginCode());
    	pmaFScheme.setSchemeId(sequenceTemplateService.getSequenceTemplate(BASE_SEQ, new HashMap<String,String>()));
    	pmaFScheme.setOrgId(userInfoService.getOrgCode());
    	pmaFScheme.setStatFlag("0");
    	pmaFScheme.setIsExcel("0");
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    	pmaFScheme.setCreateDate(dateFormat.format(new Date()));
    	ResultDto<PmaFScheme> result = new ResultDto<PmaFScheme>();
    	this.pmaFSchemeExcelMapper.insertSelective(pmaFScheme);
    	result.setData(pmaFScheme);
    	result.setMessage("新增方案成功");
        result.setCode(0);
    	return result;
    }
    private UserInfoDTO getUser() {
    	UserInfoDTO user = userInfoService.getUserInfo();
    	return user;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<String> addObj(Map<String, Object> map) {
    	ResultDto<String> result = new ResultDto<String>();
        String schemeId = map.get("schemeId").toString();// 考核方案id
        String evlObjType = map.get("evlObjType").toString();// 考核对象类型
        String postId = map.get("postId").toString();// 岗位编码
        String postName = map.get("postName").toString();// 岗位名称
        String objId = map.get("objId").toString();// 特殊规则人员列表
        String orgId = map.get("orgId").toString();// 所选机构
        String specialValue = map.get("specialValue").toString();// 特殊规则(仅选中生效,失效)
        if (orgId.toString().length() > 0) {
            String orgIdStr[] = orgId.toString().split(",");
            pmaFSchemeExcelMapper.delorg(schemeId);
            for (int i = 0; i < orgIdStr.length; i++) {
            	PmaFSchemeOrgRel pmaFSchemeOrgRel = new PmaFSchemeOrgRel();
            	pmaFSchemeOrgRel.setOrgId(orgIdStr[i]);
            	pmaFSchemeOrgRel.setSchemeId(schemeId);
            	pmaFSchemeOrgRelMapper.insertSelective(pmaFSchemeOrgRel);
			}
        }
        if (postId.toString().length() > 0) {
            String postIdStr[] = postId.toString().split(",");
            String postNameStr[] = postName.toString().split(",");
            pmaFSchemeExcelMapper.delpost(schemeId);
            for (int i = 0; i < postIdStr.length; i++) {
            	PmaFSchemePostRel pmaFSchemePostRel = new PmaFSchemePostRel();
            	pmaFSchemePostRel.setPostId(postIdStr[i]);
            	pmaFSchemePostRel.setPostName(postNameStr[i]);
            	pmaFSchemePostRel.setSchemeId(schemeId);
            	pmaFSchemePostRelMapper.insertSelective(pmaFSchemePostRel);
			}
        }
    	pmaFSchemeExcelMapper.delsperule(schemeId);
        if (objId.toString().length() > 0) {
        	String objIdStr[] = objId.toString().split(",");
            for (int i = 0; i < objIdStr.length; i++) {
            	PmaFSchemeSperuleRel pmaFSchemeSperuleRel = new PmaFSchemeSperuleRel();
            	pmaFSchemeSperuleRel.setEvlObjId(objIdStr[i]);
            	pmaFSchemeSperuleRel.setEvlObjType(evlObjType);
            	pmaFSchemeSperuleRel.setSchemeId(schemeId);
            	pmaFSchemeSperuleRelMapper.insertSelective(pmaFSchemeSperuleRel);
			}
        	
        }
        pmaFSchemeExcelMapper.delobj(schemeId);
        if (evlObjType != "" && "01".equals(evlObjType)) {// 考核对象为员工
        	if ("0".equals(specialValue)) {
        		pmaFSchemeExcelMapper.delpost(schemeId);
        		pmaFSchemeExcelMapper.insertObj(schemeId);
        	}else {
        		pmaFSchemeExcelMapper.insertObjNew(schemeId);
        	}
        }else {
        	pmaFSchemeExcelMapper.insertOrgObjNew(schemeId,evlObjType);
        }
        pmaFSchemeExcelMapper.updateSchemeInfo(schemeId, specialValue);
        result.setMessage("新增成功");
        result.setCode(0);
    	return result;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<String> addIndex(Map<String, Object> map) {
    	ResultDto<String> result = new ResultDto<String>();
		UserInfoDTO user = getUser();
        String schemeId = map.get("schemeId").toString();
        String indexType = map.get("indexType").toString();
        String indexId = map.get("indexId").toString();
        String balTypeId = map.get("balTypeId").toString();
        String evlObjType = map.get("evlObjType").toString();
        String applyTypeId = map.get("applyTypeId").toString();
        

        String co = pmaFSchemeExcelMapper.queryIndexCount(map);
        if(co.equals("0")) {
            PmaFSchemeIndexRel pmaFSchemeIndexRel = new PmaFSchemeIndexRel();
            pmaFSchemeIndexRel.setApplyTypeId(applyTypeId);
            pmaFSchemeIndexRel.setBalTypeId(balTypeId);
            pmaFSchemeIndexRel.setEvlObjType(evlObjType);
            pmaFSchemeIndexRel.setIndexId(indexId);
            pmaFSchemeIndexRel.setIndexType(indexType);
            pmaFSchemeIndexRel.setSchemeId(schemeId);
            pmaFSchemeIndexRel.setCreator(user.getLoginCode());
        	pmaFSchemeIndexRelMapper.insertSelective(pmaFSchemeIndexRel);
            result.setMessage("新增成功");
            result.setCode(0);
        	return result;
        }else {
            result.setMessage("新增指标失败");
            result.setCode(1);
        	return result;
        }
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<PmaFScheme> editInfo(PmaFScheme pmaFScheme) {
		UserInfoDTO user = this.getUser();
    	ResultDto<PmaFScheme> result = new ResultDto<PmaFScheme>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		pmaFScheme.setUpdaterId(user.getLoginCode());
		pmaFScheme.setUpdateDate(dateFormat.format(new Date()));
		this.pmaFSchemeExcelMapper.updateByPrimaryKeySelective(pmaFScheme);
		result.setData(pmaFScheme);
		result.setMessage("修改方案成功");
		result.setCode(0);
    	return result;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<String> delScheme(String schemeId) {
    	ResultDto<String> result = new ResultDto<String>();
    	pmaFSchemeExcelMapper.delinfo(schemeId);
    	pmaFSchemeExcelMapper.delobj(schemeId);
    	pmaFSchemeExcelMapper.delorg(schemeId);
    	pmaFSchemeExcelMapper.delpost(schemeId);
    	pmaFSchemeExcelMapper.delsperule(schemeId);
    	pmaFSchemeExcelMapper.delindex(schemeId);
    	pmaFSchemeExcelMapper.delsplit(schemeId);
        result.setMessage("删除成功");
        result.setCode(0);
    	return result;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<String> schemePub(Map<String, Object> map) {
    	String schemeId = map.get("schemeId").toString();
    	String statFlag = map.get("statFlag").toString();
    	pmaFSchemeExcelMapper.schemePub(schemeId, statFlag);
    	ResultDto<String> result = new ResultDto<String>();
        result.setMessage("处理成功");
        result.setCode(0);
    	return result;
	}
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryHomePageIndex(QueryModel model) {
        String orgId = userInfoService.getOrgCode();
        model.getCondition().put("orgId", orgId);
		List<Map<String, Object>> list = pmaFSchemeExcelMapper.queryHomePageIndex(model);
		return list;
    }
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryHomePageIndexNew(QueryModel model) {
		String indexS="";
		String[] indexIdStrs;
        String userId = userInfoService.getUserInfo().getLoginCode();
        model.getCondition().put("userId", userId);
        if(model.getCondition().get("indexId")!=null&&!model.getCondition().get("indexId").equals("")) {
    		indexS=model.getCondition().get("indexId").toString();
    		indexIdStrs=indexS.split(",");
    		model.getCondition().put("indexId", indexIdStrs);
    		model.getCondition().put("indexIdSize", indexIdStrs.length);
		}
		List<Map<String, Object>> list = pmaFSchemeExcelMapper.queryHomePageIndexNew(model);
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<String> addSplit(Map<String, Object> map) {
		Set<String> allBaseIndexOfEvlIndexSet = new HashSet<String>();//用于存储所有方案拆分出来的基础指标
		List<Map<String, Object>> list = pmaFSchemeExcelMapper.querySchemeIndex(map.get("schemeId").toString());//根据方案查询方案中所有指标信息
		if (null != list && 0 < list.size()){
	            for (int i = 0; i < list.size(); i++) 
	            {
	            	allBaseIndexOfEvlIndexSet= pmaFSchemeIndexRelService.recursionQueryAllChildren(list.get(i).get("schemeIndexId").toString(), allBaseIndexOfEvlIndexSet);
	            }
	    }
		pmaFSchemeIndexSplitMapper.deleteIndex(map.get("schemeId").toString());
		if(null != allBaseIndexOfEvlIndexSet && 0 < allBaseIndexOfEvlIndexSet.size()) {
			Iterator<String> iterator = allBaseIndexOfEvlIndexSet.iterator();
			while (iterator.hasNext()){
				String indexs = iterator.next();
			    PmaFSchemeIndexSplit pmaFSchemeIndexSplit = new PmaFSchemeIndexSplit();
				String indexId = indexs.substring(0,8);
				pmaFSchemeIndexSplit.setIndexId(indexId);
				String []dim = indexs.substring(9,17).split(",");
				pmaFSchemeIndexSplit.setBalTypeId(dim[0]);
				pmaFSchemeIndexSplit.setApplyTypeId(dim[1]);
				pmaFSchemeIndexSplit.setEvlObjType(dim[2]);
				pmaFSchemeIndexSplit.setIndexType("01");
				pmaFSchemeIndexSplit.setSchemeId(map.get("schemeId").toString());
				pmaFSchemeIndexSplitMapper.insertSelective(pmaFSchemeIndexSplit);
	        }	
			
		}
    	ResultDto<String> result = new ResultDto<String>();
        result.setMessage("处理成功");
        result.setCode(0);
    	return result;
	}
    
    /**
     * @函数名称: copySchemeInf
     * @函数描述: 复制考核方案信息-考核方案基础信息表
     * @参数与返回说明:
     * @param schemeId 被复制的考核方案编号
     * @param menuId 当前-考核方案目录编号
     * @return 新的考核方案编号
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public String copySchemeInf(String schemeId, String menuId) throws Exception {
        try {
			UserInfoDTO user = getUser();
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	        String newSchemeId = sequenceTemplateService.getSequenceTemplate(BASE_SEQ, new HashMap<String,String>());
	        pmaFSchemeExcelMapper.copySchemeInf(schemeId, newSchemeId, menuId, user.getLoginCode(), userInfoService.getOrgCode(), dateFormat.format(new Date()));
	        return newSchemeId;
        } catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }
}
