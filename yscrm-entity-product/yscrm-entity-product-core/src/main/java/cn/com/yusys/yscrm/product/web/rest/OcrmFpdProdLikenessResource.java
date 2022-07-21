package cn.com.yusys.yscrm.product.web.rest;

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

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yscrm.product.domain.AcrmFpdProdInfo;
import cn.com.yusys.yscrm.product.domain.OcrmFpdProdLikeness;
import cn.com.yusys.yscrm.product.service.OcrmFpdProdLikenessService;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdProdLikenessResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-11 10:26:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfpdprodlikeness")
public class OcrmFpdProdLikenessResource extends CommonResource<OcrmFpdProdLikeness, String> {
    @Autowired
    private OcrmFpdProdLikenessService ocrmFpdProdLikenessService;

    @Autowired
   	private UaaClient uaaClient;
    
    @Override
    protected CommonService getCommonService() {
        return ocrmFpdProdLikenessService;
    }

    /**
     * @方法名称: similarProductsQuery
	 * @方法描述: 类似产品查询
	 * @param 
	 * @return
	 */
	@GetMapping("/similarproductsquery/{prodId}")
	public ResultDto<List<Map<String, Object>>> similarProductsQuery(QueryModel model,@PathVariable String prodId){
		List<Map<String, Object>> focusCust = ocrmFpdProdLikenessService.similarProductsQuery(model,prodId);
		if(focusCust.size()>0) {
			return new ResultDto<List<Map<String, Object>>>(focusCust);
		}else {
			return null;
		}
	}
	
	/**
	 * @方法名称: ctrateProductInfo
	 * @方法描述: 类似产品新增
	 * @param 
	 * @return
	 */
	@PostMapping("/createsimilarproducts")
	public ResultDto<Object> createSimilarProducts(@RequestBody OcrmFpdProdLikeness ocrmFpdProdLikeness) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFpdProdLikeness.setLastChgUsr(dto.getBody().getLoginCode());
		ocrmFpdProdLikeness.setLastChgDt(new Date());
		ocrmFpdProdLikeness.setCorpOrgCode(dto.getBody().getInstu().getCode());
		ocrmFpdProdLikeness.setProdId(ocrmFpdProdLikeness.getProdId());
		int result = ocrmFpdProdLikenessService.createSimilarProducts(ocrmFpdProdLikeness);
		return new ResultDto<Object>(result);
	}
	
	/**
	 * @方法名称: deleteSimilarProducts
	 * @方法描述: 类似产品删除
	 * @param 
	 * @return
	 */
	@PostMapping("/deletesimilarproducts")
	public int deleteSimilarProducts(@RequestBody Map<String, String> map) {
		String likenessId = map.get("likenessId").toString();
		return ocrmFpdProdLikenessService.deleteSimilarProducts(likenessId);
	}
}
