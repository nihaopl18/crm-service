package cn.com.yusys.yscrm.custgrade.web.rest;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custgrade.domain.OcrmFciPreGradeApplyInfo;
import cn.com.yusys.yscrm.custgrade.service.CustGradeManualEvalService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: CustGradeManualEvalResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-20 16:12:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/custgrademanualeval")
public class CustGradeManualEvalResource extends CommonResource<OcrmFciPreGradeApplyInfo, String> {
    @Autowired
    private CustGradeManualEvalService custGradeManualEvalService;

    @Override
    protected CommonService getCommonService() {
        return custGradeManualEvalService;
    }
    /**
  		* @方法名称: getAll
  		* @方法描述: 查询条件
  		* @参数与返回说明: 
  		* @算法描述: 
  		*/
  	    @GetMapping("/querylist")
  		public ResultDto<List<Map<String, Object>>> getAll(QueryModel queryModel) {
  			List<Map<String, Object>> list = custGradeManualEvalService.getAll(queryModel);
  			return new ResultDto<List<Map<String, Object>>>(list);
  		} 
  	    
  	  @GetMapping("/querylistSingle")
		public ResultDto<List<Map<String, Object>>> getAll2(QueryModel queryModel) {
			List<Map<String, Object>> list = custGradeManualEvalService.getAll2(queryModel);
			return new ResultDto<List<Map<String, Object>>>(list);
		}
  	  
  	    @GetMapping("/querybussinfo")
  		public ResultDto<List<Map<String, Object>>> getBussInfo(QueryModel queryModel) {
  	    	List<Map<String, Object>> list = custGradeManualEvalService.getBussInfo(queryModel);
  			return new ResultDto<List<Map<String, Object>>>(list);
  	    } 
  		/**
  		 * 
  		* @方法名称: addContmeth
  		* @方法描述: 新增
  		* @参数与返回说明: 
  		* @算法描述:
  		 */
  	    @Transactional
  		@PostMapping("/apply")
  		public ResultDto<Object> addContmeth(@RequestBody OcrmFciPreGradeApplyInfo pool) throws URISyntaxException {
  			String idFlag = custGradeManualEvalService.insertPreGradeApply(pool);
  			ResultDto<Object> result=	new ResultDto<Object>("");
  			if(idFlag!=null&&idFlag.equals("-1")) {
  				result.setData(idFlag);
  				result.setCode(-1);
  				result.setMessage("申请记录插入失败，发起申请失败");
  				
  			}else if(idFlag.equals("-2")){
  				result.setData(idFlag);
  				result.setCode(-2);
  				result.setMessage("申请记录已经存在,请耐心等待审批完成");
  			}else {
  				result.setData(idFlag);
  				result.setCode(0);
  				result.setMessage("申请记录以插入表中，可以发起申请");
  			}
  			return result;
  		}
  		
  		 @GetMapping("/queryapplyinfo")
   		public ResultDto<List<Map<String, Object>>> queryApplyInfo(QueryModel queryModel) {
   			List<Map<String, Object>> list = custGradeManualEvalService.queryApplyInfo(queryModel);
   			return new ResultDto<List<Map<String, Object>>>(list);
   		} 
  		@GetMapping("/deleteApply")
   		public ResultDto<String> queryApplyInfo(String ids) {
   			int n = custGradeManualEvalService.deleteApply(ids);
   			return new ResultDto<String>(String.valueOf(n));
   		} 
  		
  		@GetMapping("/querylistByCustId")
  		public ResultDto<List<Map<String, Object>>> querylistByCustId(QueryModel queryModel) {
  			List<Map<String, Object>> list = custGradeManualEvalService.querylistByCustId(queryModel);
  			return new ResultDto<List<Map<String, Object>>>(list);
  		}
  		@GetMapping("/getMgrType")
  		public ResultDto<String> getMgrType(QueryModel queryModel){
  			Map map=new HashMap<String, String>();
  			map.put("custId", queryModel.getCondition().get("custId"));
  			map.put("loginCode", queryModel.getCondition().get("loginCode"));
  			return new ResultDto<String>(custGradeManualEvalService.getMgrType(map));
  		}
}
