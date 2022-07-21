package cn.com.yusys.yscrm.custgrade.web.rest;

import java.util.List;
import java.util.Map;

import org.bouncycastle.util.Integers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custgrade.domain.OcrmFciGradeScheme;
import cn.com.yusys.yscrm.custgrade.service.CustGradeSchemeService;
import cn.com.yusys.yscrm.custgrade.util.UtilsCommon;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: OcrmFciGradeSchemeResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-18 11:14:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/custgradescheme")
public class CustGradeSchemeResource extends CommonResource<OcrmFciGradeScheme, String> {
    @Autowired
    private CustGradeSchemeService CustGradeSchemeService;
    @Autowired
    private UtilsCommon util;
    @Override
    protected CommonService getCommonService() {
        return CustGradeSchemeService;
    }
    @RequestMapping("/querylist")
    public ResultDto<List<Map<String,Object>>> queryList(QueryModel model){
    	List<Map<String,Object>> list=this.CustGradeSchemeService.queryList(model);
    	return new ResultDto<List<Map<String,Object>>>(list);
    }
    @RequestMapping("/queryperiodlist")
    public ResultDto<List<Map<String,Object>>> queryPeriodList(QueryModel model){
    	List<Map<String,Object>> list=this.CustGradeSchemeService.queryPeriodList(model);
    	return new ResultDto<List<Map<String,Object>>>(list);
    }  
    @RequestMapping("/querygradelevel")
    public ResultDto<List<Map<String,Object>>> queryGradeLevel(QueryModel model){
    	List<Map<String,Object>> list=this.CustGradeSchemeService.queryGradeLevel(model);
    	return new ResultDto<List<Map<String,Object>>>(list);
    }   
    @RequestMapping("/querydetail")
    public ResultDto<List<Map<String,Object>>> queryDetail(QueryModel model){
    	List<Map<String,Object>> list=this.CustGradeSchemeService.queryDetail(model);
    	return new ResultDto<List<Map<String,Object>>>(list);
    }
    @RequestMapping("/querybaseindex")
    public ResultDto<List<Map<String,Object>>> queryBaseIndex(QueryModel model){
    	List<Map<String,Object>> list=this.CustGradeSchemeService.queryBaseIndex(model);
    	return new ResultDto<List<Map<String,Object>>>(list);
    }
	/**
	 * 删除
	 * 
	 * @param schemeId
	 * @return
	 */
	@RequestMapping("/delete")
	public void deleteBySchemeId(@RequestBody Map<String,String> schemeId) {
		Integer n = Integers.valueOf(CustGradeSchemeService.deleteBySchemeId(schemeId.get("schemeId")));
	}
    /**
     * 启用 
     * @param map
     * @return
     */
	@RequestMapping("/enable")
	public ResultDto<String> enable(@RequestBody Map<String,String> schemeId) {
	  boolean isUserFlag= CustGradeSchemeService.enable(schemeId.get("schemeId"));
	  ResultDto<String> result=	new ResultDto<String>("启用成功");
	  if(!isUserFlag) {
		  result.setData("启用失败");
		  result.setCode(-1);
		  result.setMessage("同一方案类型，同一适用客户类型只能有一套启用的方案！");
	  }
		return result;
	}
	  /**
     * 禁用 
     * @param map
     * @return
     */
	@RequestMapping("/disenable")
	public ResultDto<String> disEnable(@RequestBody Map<String,String> schemeId) {
	   CustGradeSchemeService.disEnable(schemeId.get("schemeId"));
	  ResultDto<String> result=	new ResultDto<String>("禁用成功");
//	  if(!isUserFlag) {
//		  result.setData("启用失败");
//		  result.setCode(-1);
//		  result.setMessage("同一方案类型，同一适用客户类型只能有一套启用的方案！");
//	  }
		return result;
	}
    @RequestMapping("/insert")
    public ResultDto<String> insert(@RequestBody Map<String,Object> map){
    	// 方案表数据 单条
    	//UtilsCommon util=new UtilsCommon();
    	OcrmFciGradeScheme gs= util.map2Object((Map<String,Object>)map.get("model"),OcrmFciGradeScheme.class) ;
    	// 标准表数据 多条
       List<Object> listGstand=(List<Object>) map.get("standardData");
    	// 标准参数表数据  list<Map> 
    	Map<String,List<Object>> mapGl=(Map<String, List<Object>>) map.get("levelDataObject");
       int n= this.CustGradeSchemeService.insertGs(gs,listGstand,mapGl);
 	   ResultDto<String> result=	new ResultDto<String>("新增成功");
       if(n==-1) {
    	  result.setData("新增失败");
 		  result.setCode(-1);
 		  result.setMessage("同一方案类型，同一适用客户类型只能有一套启用的方案！");
    	}
    	return result;
    }
    @RequestMapping("/updategs")
    public ResultDto<String> update(@RequestBody Map<String,Object> map){
    	// 方案表数据 单条
    	//UtilsCommon util=new UtilsCommon();
    	OcrmFciGradeScheme gs= util.map2Object((Map<String,Object>)map.get("model"),OcrmFciGradeScheme.class) ;
    	// 标准表数据 多条
       List<Object> listGstand=(List<Object>) map.get("standardData");
    	// 标准参数表数据  list<Map> 
    	Map<String,List<Object>> mapGl=(Map<String, List<Object>>) map.get("levelDataObject");
       int n= this.CustGradeSchemeService.updateGs(gs,listGstand,mapGl);
 	   ResultDto<String> result=	new ResultDto<String>("修改成功");
       if(n==-1) {
    	  result.setData("修改失败");
 		  result.setCode(-1);
 		  result.setMessage("同一方案类型，同一适用客户类型只能有一套启用的方案！");
    	}
    	return result;
    }
}
