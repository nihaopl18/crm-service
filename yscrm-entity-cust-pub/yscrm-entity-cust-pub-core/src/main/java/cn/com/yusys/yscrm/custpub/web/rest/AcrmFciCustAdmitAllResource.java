package cn.com.yusys.yscrm.custpub.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAdmitAll;
import cn.com.yusys.yscrm.custpub.service.AcrmFciCustAdmitAllService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciCustAdmitAllResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-04 16:56:32
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfcicustadmitall")
public class AcrmFciCustAdmitAllResource extends CommonResource<AcrmFciCustAdmitAll, String> {
    @Autowired
    private AcrmFciCustAdmitAllService acrmFciCustAdmitAllService;

    @Override
    protected CommonService getCommonService() {
        return this.acrmFciCustAdmitAllService;
    }
    /**
	* @方法名称: getListPer
	* @方法描述: 查询所辖零售客户
	* @参数与返回说明: 
	* @算法描述: 
	*/
		@GetMapping("/listper")
		public ResultDto<List<Map<String, String>>> getListPer(QueryModel model){
			String custType = (String) model.getCondition().get("custType");
			/*
			 * custType等于1的时候代表客户类型是零售
			 */
			if (custType.equals("1")) {
				ResultDto<List<Map<String, String>>> resultDto = new ResultDto<List<Map<String,String>>>(acrmFciCustAdmitAllService.getListPer(model));
				resultDto.setCode(0);
				resultDto.setMessage("查询成功");
				return resultDto;
			}
			ResultDto<List<Map<String, String>>> resultDto = new ResultDto<List<Map<String,String>>>();
			resultDto.setCode(-1);
			resultDto.setMessage("查询失败");
			return resultDto;
		}
		/**
		* @方法名称: getListOrg
		* @方法描述: 查询所辖对公客户
		* @参数与返回说明: 
		* @算法描述: 
		*/
			@GetMapping("/listorg")
			public ResultDto<List<Map<Object, String>>> getListOrg(QueryModel model){
				String custType = (String) model.getCondition().get("custType");
				/*
				 * custType等于2的时候代表客户类型是对公
				 */
				if (custType.equals("2")) {
					ResultDto<List<Map<Object, String>>> resultDto = new ResultDto<List<Map<Object,String>>>(acrmFciCustAdmitAllService.getListOrg(model));
					resultDto.setCode(0);
					resultDto.setMessage("查询成功");
					return resultDto;
				}
				ResultDto<List<Map<Object, String>>> resultDto = new ResultDto<List<Map<Object,String>>>();
				resultDto.setCode(-1);
				resultDto.setMessage("查询失败");
				return resultDto;
			}
}
