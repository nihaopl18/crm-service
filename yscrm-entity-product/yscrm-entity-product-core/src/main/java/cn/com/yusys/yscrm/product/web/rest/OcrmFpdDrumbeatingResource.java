package cn.com.yusys.yscrm.product.web.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.product.domain.OcrmFpdDrumbeating;
import cn.com.yusys.yscrm.product.service.OcrmFpdDrumbeatingService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: OcrmFpdDrumbeatingResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-19 10:36:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfpddrumbeating")
public class OcrmFpdDrumbeatingResource extends CommonResource<OcrmFpdDrumbeating, String> {
    @Autowired
    private OcrmFpdDrumbeatingService ocrmFpdDrumbeatingService;

    @Autowired
   	private UaaClient uaaClient;
    
    @Override
    protected CommonService getCommonService() {
        return ocrmFpdDrumbeatingService;
    }
    
    /**
	 * @方法名称: publicityMaterialQuery
	 * @方法描述: 宣传资料查询
	 * @param 
	 * @return
	 */
	@GetMapping("/publicitymaterialquery/{prodId}")
	public ResultDto<List<Map<String, Object>>> publicityMaterialQuery(QueryModel model, @PathVariable String prodId){
		List<Map<String, Object>> focusCust = ocrmFpdDrumbeatingService.publicityMaterialQuery(model, prodId);
		if(focusCust.size()>0) {
			return new ResultDto<List<Map<String, Object>>>(focusCust);
		}else {
			return null;
		}
	}
	
	/**
	 * @方法名称: ctrateProductInfo
	 * @方法描述: 宣传资料新增
	 * @param 
	 * @return
	 */
	@PostMapping("/createpublicityaaterial")
	public ResultDto<Object> createPublicityAaterial(@RequestBody OcrmFpdDrumbeating ocrmFpdDrumbeating) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFpdDrumbeating.setLastChgUsr(dto.getBody().getLoginCode());
		ocrmFpdDrumbeating.setLastChgDt(new Date());
		ocrmFpdDrumbeating.setCorpOrgCode(dto.getBody().getInstu().getCode());
		ocrmFpdDrumbeatingService.createPublicityAaterial(ocrmFpdDrumbeating);
		return new ResultDto<Object>(ocrmFpdDrumbeating.getId());
	}
	
	/**
	 * @方法名称: updatePublicityAaterial
	 * @方法描述: 宣传资料修改
	 * @param 
	 * @return
	 */
	@PostMapping("/updatepublicityaaterial")
	public ResultDto<Object> updatePublicityAaterial(@RequestBody OcrmFpdDrumbeating ocrmFpdDrumbeating) {
		ocrmFpdDrumbeatingService.updatePublicityAaterial(ocrmFpdDrumbeating);
		return new ResultDto<Object>(ocrmFpdDrumbeating.getId());
	}
	
	/**
	 * @方法名称: deletePublicityAaterial
	 * @方法描述: 宣传资料删除
	 * @param 
	 * @return
	 */
	@PostMapping("/deletepublicityaaterial")
	public int deletePublicityAaterial(@RequestBody Map<String, String> map) {
		String id = map.get("id").toString();
		return ocrmFpdDrumbeatingService.deletePublicityAaterial(id);
	}

}
