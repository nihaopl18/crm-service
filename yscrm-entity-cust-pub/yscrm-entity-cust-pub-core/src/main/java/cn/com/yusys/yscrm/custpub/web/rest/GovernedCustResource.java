package cn.com.yusys.yscrm.custpub.web.rest;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.AcrmCustCount;
import cn.com.yusys.yscrm.custpub.domain.AcrmCustCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAdmitAll;
import cn.com.yusys.yscrm.custpub.service.GovernedCustService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

@RestController
@RequestMapping("/api/governedcust")
public class GovernedCustResource extends CommonResource<AcrmFciCustAdmitAll, String>{

	@Autowired
	private GovernedCustService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.service;
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
			if(custType==null||custType.equals("")) {
				return null;
			}
			/*
			 * custType等于1的时候代表客户类型是零售
			 */
			if (custType.equals("1")) {
				ResultDto<List<Map<String, String>>> resultDto = new ResultDto<List<Map<String,String>>>(service.getListPer(model));
				resultDto.setCode(0);
				resultDto.setMessage("查询成功");
				return resultDto;
			}
			ResultDto<List<Map<String, String>>> resultDto = new ResultDto<List<Map<String,String>>>();
			resultDto.setCode(-1);
			resultDto.setMessage("查询失败");
			return resultDto;
		}
//		@GetMapping("/listperNoAdmit")
//		public ResultDto<List<Map<String, String>>> getListPerNoAdmit(QueryModel model){
//			String custType = (String) model.getCondition().get("custType");
//			/*
//			 * custType等于1的时候代表客户类型是零售
//			 */
//			if(custType==null||custType.equals("")) {
//				return null;
//			}
//			if (custType.equals("1")) {
//				ResultDto<List<Map<String, String>>> resultDto = new ResultDto<List<Map<String,String>>>(service.getListPerNoAdmit(model));
//				resultDto.setCode(0);
//				resultDto.setMessage("查询成功");
//				return resultDto;
//			}
//			ResultDto<List<Map<String, String>>> resultDto = new ResultDto<List<Map<String,String>>>();
//			resultDto.setCode(-1);
//			resultDto.setMessage("查询失败");
//			return resultDto;
//		}
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
				if(custType==null||custType.equals("")) {
					return null;
				}
				if (custType.equals("2")) {
					ResultDto<List<Map<Object, String>>> resultDto = new ResultDto<List<Map<Object,String>>>(service.getListOrg(model));
					resultDto.setCode(0);
					resultDto.setMessage("查询成功");
					return resultDto;
				}
				ResultDto<List<Map<Object, String>>> resultDto = new ResultDto<List<Map<Object,String>>>();
				resultDto.setCode(-1);
				resultDto.setMessage("查询失败");
				return resultDto;
			}
//			@GetMapping("/listorgNoAdmit")
//			public ResultDto<List<Map<Object, String>>> getListOrgNoAdmit(QueryModel model){
//				String custType = (String) model.getCondition().get("custType");
//				/*
//				 * custType等于2的时候代表客户类型是对公
//				 */
//				if(custType==null||custType.equals("")) {
//					return null;
//				}
//				if (custType.equals("2")) {
//					ResultDto<List<Map<Object, String>>> resultDto = new ResultDto<List<Map<Object,String>>>(service.getListOrgNoAdmit(model));
//					resultDto.setCode(0);
//					resultDto.setMessage("查询成功");
//					return resultDto;
//				}
//				ResultDto<List<Map<Object, String>>> resultDto = new ResultDto<List<Map<Object,String>>>();
//				resultDto.setCode(-1);
//				resultDto.setMessage("查询失败");
//				return resultDto;
//			}
			/**
			* @方法名称: getListAll
			* @方法描述: 查询所辖所有客户
			* @参数与返回说明: 
			* @算法描述: 
			*/
				@GetMapping("/listall")
				public ResultDto<List<Map<String, String>>> getListAll(QueryModel model){
					/*
					 * custType等于2的时候代表客户类型是对公
					 */
						ResultDto<List<Map<String, String>>> resultDto = new ResultDto<List<Map<String,String>>>(service.getListAll(model));
						resultDto.setCode(0);
						resultDto.setMessage("查询成功");
						return resultDto;
				}
				
				/**
				* @方法名称: getBusiTypeByUserId
				* @方法描述: 查询用户条线
				* @参数与返回说明: 
				* @算法描述: 
				*/
					@GetMapping("/getbusitype")
					public ResultDto<Map<String, String>> getBusiTypeByUserId(QueryModel model){
						/*
						 * custType等于2的时候代表客户类型是对公
						 */
							ResultDto<Map<String, String>> resultDto = new ResultDto<Map<String,String>>(service.getBusiTypeByUserId(model));
							resultDto.setCode(0);
							resultDto.setMessage("查询成功");
							return resultDto;
					}
					/**
					* @方法名称: getManageCustPerList
					* @方法描述: 查询管户个人客户
					* @参数与返回说明: 
					* @算法描述: 
					*/
						@GetMapping("/managecustper")
						public ResultDto<List<Map<String, String>>> getManageCustPerList(QueryModel model){
							/*
							 * custType等于2的时候代表客户类型是对公
							 */
								ResultDto<List<Map<String, String>>> resultDto = new ResultDto<List<Map<String,String>>>(service.getManageCustPerList(model));
								resultDto.setCode(0);
								resultDto.setMessage("查询成功");
								return resultDto;
						}
						/**
						* @方法名称: getManageCustOrgList
						* @方法描述: 查询管户个人客户
						* @参数与返回说明: 
						* @算法描述: 
						*/
							@GetMapping("/managecustorg")
							public ResultDto<List<Map<String, String>>> getManageCustOrgList(QueryModel model){
								/*
								 * custType等于2的时候代表客户类型是对公
								 */
									ResultDto<List<Map<String, String>>> resultDto = new ResultDto<List<Map<String,String>>>(service.getManageCustOrgList(model));
									resultDto.setCode(0);
									resultDto.setMessage("查询成功");
									return resultDto;
							}


	/**
	 * @方法名称: custQueryList
	 * @方法描述: 查询搜索历史记录
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/custQueryList")
	public ResultDto<List<AcrmCustCountVO>> custQueryList(QueryModel model){
		ResultDto<List<AcrmCustCountVO>> resultDto = new ResultDto<List<AcrmCustCountVO>>(service.custQueryList(model));
		resultDto.setCode(0);
		resultDto.setMessage("查询成功");
		return resultDto;
	}
}