package cn.com.yusys.yscrm.product.web.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.product.domain.AcrmFpdProdCatl;
import cn.com.yusys.yscrm.product.service.AcrmFpdProdCatlService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFpdProdCatlResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-01-25 10:59:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfpdprodcatl")
public class AcrmFpdProdCatlResource extends CommonResource<AcrmFpdProdCatl, String> {
    @Autowired
    private AcrmFpdProdCatlService acrmFpdProdCatlService;
    
    @Autowired
   	private UaaClient uaaClient;

    @Override
    protected CommonService getCommonService() {
        return acrmFpdProdCatlService;
    }

    /**
	 * @方法名称: treeListQuery
	 * @方法描述:  产品类别树查询
	 * @param 
	 * @return
	 */
	@GetMapping("/treelistquery")
	public ResultDto<List<Map<String, Object>>> treeListQuery(QueryModel model){
		List<Map<String, Object>> focusCust = acrmFpdProdCatlService.treeListQuery(model);
		if(focusCust.size()>0) {
			return new ResultDto<List<Map<String, Object>>>(focusCust);
		}else {
			return null;
		}
	}
	 /**
		 * @方法名称: treeListQuery
		 * @方法描述:  产品类别树查询
		 * @param 
		 * @return
		 */
		@GetMapping("/custprodtree")
		public ResultDto<List<Map<String, Object>>> custProdTree(QueryModel model){
			List<Map<String, Object>> focusCust = acrmFpdProdCatlService.custProdTree(model);
			if(focusCust.size()>0) {
				return new ResultDto<List<Map<String, Object>>>(focusCust);
			}else {
				return null;
			}
		}
	
	/**
	 * @方法名称: productTreeQuery
	 * @方法描述:  产品类别树点击事件
	 * @param 
	 * @return
	 */
	@GetMapping("/producttreequery")
	public ResultDto<List<Map<String, Object>>> productTreeQuery(String catlCode){
		List<Map<String, Object>> focusCust = acrmFpdProdCatlService.productTreeQuery(catlCode);
		if(focusCust.size()>0) {
			return new ResultDto<List<Map<String, Object>>>(focusCust);
		}else {
			return null;
		}
	}
	
	/**
	 * @方法名称: createproducttree
	 * @方法描述:  产品类别树新增
	 * @param 
	 * @return
	 */
	@PostMapping("/createproducttree")
	public ResultDto<Object> createProductTree(@RequestBody AcrmFpdProdCatl acrmFpdProdCatl) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		acrmFpdProdCatl.setDataDate(sdf.format(new Date()));
		acrmFpdProdCatl.setLastChgSys("CRM");
		acrmFpdProdCatl.setLastChgUsr(dto.getBody().getLoginCode());
		acrmFpdProdCatl.setLastChgTm(new Date());
		acrmFpdProdCatl.setCorpOrgCode(dto.getBody().getInstu().getCode());
		int result = acrmFpdProdCatlService.createProductTree(acrmFpdProdCatl);
		return new ResultDto<Object>(result);
	}
	
	/**
	 * @方法名称: editProductTree
	 * @方法描述:  产品类别树修改
	 * @param 
	 * @return
	 */
	@PostMapping("/editproducttree")
	public ResultDto<Object> editProductTree(@RequestBody AcrmFpdProdCatl acrmFpdProdCatl) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		acrmFpdProdCatl.setLastChgSys("CRM");
		acrmFpdProdCatl.setLastChgUsr(dto.getBody().getLoginCode());
		acrmFpdProdCatl.setLastChgTm(new Date());
		acrmFpdProdCatl.setCorpOrgCode(dto.getBody().getInstu().getCode());
		int result = acrmFpdProdCatlService.editProductTree(acrmFpdProdCatl);
		return new ResultDto<Object>(result);
	}
	
	/**
	 * @方法名称: editProductTree
	 * @方法描述:  产品类别树删除
	 * @param 
	 * @return
	 */
	@PostMapping("/deleteproducttree")
	public int deleteProductTree(@RequestBody Map<String, String> map) {
		String catlCode = map.get("catlCode").toString();
		return acrmFpdProdCatlService.deleteProductTree(catlCode);
	}
	
	/**
	 * @方法名称: displaySchemeQuery
	 * @方法描述:  产品展示方案查询
	 * @param 
	 * @return
	 */
	@GetMapping("/displayschemequery")
	public ResultDto<List<Map<String, Object>>> displaySchemeQuery(QueryModel model){
		List<Map<String, Object>> focusCust = acrmFpdProdCatlService.displaySchemeQuery(model);
		if(focusCust.size()>0) {
			return new ResultDto<List<Map<String, Object>>>(focusCust);
		}else {
			return null;
		}
	}
	
	/**
	 * @方法名称: yufpDptSelectorQuery
	 * @方法描述:  部门选择器查询
	 * @param 
	 * @return
	 */
	@GetMapping("/yufpdptselectorquery")
	public ResultDto<List<Map<String, Object>>> yufpDptSelectorQuery(QueryModel model){
		List<Map<String, Object>> focusCust = acrmFpdProdCatlService.yufpDptSelectorQuery(model);
		if(focusCust.size()>0) {
			return new ResultDto<List<Map<String, Object>>>(focusCust);
		}else {
			return null;
		}
	}
}
