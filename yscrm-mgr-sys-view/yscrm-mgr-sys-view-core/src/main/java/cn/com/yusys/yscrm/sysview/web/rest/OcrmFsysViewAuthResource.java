package cn.com.yusys.yscrm.sysview.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.sysview.domain.OcrmFsysViewAuth;
import cn.com.yusys.yscrm.sysview.service.OcrmFsysViewAuthService;

/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewAuthResource
 * @类描述: 视图权限
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 19:08:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfsysviewauth")
public class OcrmFsysViewAuthResource extends CommonResource<OcrmFsysViewAuth, String> {
    @Autowired
    private OcrmFsysViewAuthService ocrmFsysViewAuthService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFsysViewAuthService;
    }
    
    /**
	 * 
	* @方法名称: getRecoInfo
	* @方法描述: 根据选择的角色id查询授权数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/queryinfo")
	public ResultDto<List<Map<String, Object>>> getRecoInfo(@RequestParam(required = false) String objectType,
			@RequestParam(required = false) String resType,
			@RequestParam(required = false) String objectId,@RequestParam(required = false) String sysId) {
		List<Map<String, Object>> list=ocrmFsysViewAuthService.getRecoInfo(objectType,resType,objectId,sysId);
		return  new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	* @方法名称:qryViewTree
	* @方法描述:初始化查询右侧视图树
	* @参数与返回说明:
	* @算法描述:
	*/
	@GetMapping("/qryviewtree")
	public ResultDto<List<Map<String, Object>>> qryViewTree(@RequestParam(required = false) String sysId) {
	        List<Map<String, Object>> list = ocrmFsysViewAuthService.qryViewTree(sysId);
	        return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
     * @函数名称:批量保存数据
     * @参数与返回说明:
     * @算法描述:
     */
    @SuppressWarnings("unchecked")
	@PostMapping("/saveinfo")
    public  ResultDto<Object> saveInfo(@RequestBody Map<?, ?> t)
            throws URISyntaxException {
    	 int result=0;
    	 if(t !=null) {
    		 List<Map<String, Object>> menus = (List<Map<String, Object>>) t.get("menuData");
    		 List<Map<String, Object>> ctrs = (List<Map<String, Object>>) t.get("ctrData");
        	 result=ocrmFsysViewAuthService.insertBatch(menus,ctrs);
    	 }
    	 
         return new ResultDto<Object>(result);
    }
    
    /**
	* @方法名称:selectViewTree
	* @方法描述:查询授权的视图树数据
	* @参数与返回说明:
	* @算法描述:
	*/
	@GetMapping("/selectviewtree")
	public ResultDto<List<Map<String, Object>>> selectViewTree(@RequestParam(required = false) String loginCode, @RequestParam(required = false) String sysId) {
	        List<Map<String, Object>> list = ocrmFsysViewAuthService.selectViewTree(loginCode,sysId);
	        return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	* @方法名称:selectContrList
	* @方法描述:查询授权的控制点数据
	* @参数与返回说明:
	* @算法描述:
	*/
	@GetMapping("/selectcontrlist")
	public ResultDto<List<Map<String, Object>>> selectContrList(@RequestParam(required = false) String loginCode, @RequestParam(required = false) String sysId) {
	        List<Map<String, Object>> list = ocrmFsysViewAuthService.selectContrList(loginCode,sysId);
	        return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	* @方法名称:qryGrantList
	* @方法描述:查询通过客户授权授权的某个客户可见的视图菜单
	* @参数与返回说明:
	* @算法描述:
	*/
	@GetMapping("/qrygrantlist")
	public ResultDto<List<Map<String, Object>>> qryGrantList(@RequestParam(required = false) String custId, @RequestParam(required = false) String mgrId) {
	        List<Map<String, Object>> list = ocrmFsysViewAuthService.qryGrantList(custId,mgrId);
	        return new ResultDto<List<Map<String, Object>>>(list);
	}
	
}
