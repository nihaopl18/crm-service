package cn.com.yusys.yscrm.custpub.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAdmitAll;
import cn.com.yusys.yscrm.custpub.service.AllCustService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

@RestController
@RequestMapping("/api/allcust")
public class AllCustResource extends CommonResource<AcrmFciCustAdmitAll, String>{

	@Autowired
	private AllCustService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return null;
	}
	/**
	* @方法名称: getList
	* @方法描述: 全行客户查询
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@GetMapping("/list") 
	public ResultDto<List<Map<String, String>>> getList(QueryModel model){
		ResultDto<List<Map<String, String>>> resultDto = new ResultDto<List<Map<String,String>>>(service.getList(model));
		return resultDto;
	}
	/**
	* @方法名称: getOrgLev
	* @方法描述: 获取机构层级
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/orglev")
	public ResultDto<Integer> getOrgLev(@RequestBody Map<String, String> map){
		ResultDto<Integer> resultDto = new ResultDto<Integer>(service.getOrgLev(map));
		return resultDto;
	}
	@GetMapping("/memberdeposit")
		public ResultDto<List<Map<String, String>>> getMemberDeposit(QueryModel model){
			return new ResultDto<List<Map<String,String>>>(service.getMemberDeposit(model));
		}
		
		@GetMapping("/memberloan")
		public ResultDto<List<Map<String, String>>> getMemberLoan(QueryModel model){
			return new ResultDto<List<Map<String,String>>>(service.getMemberLoan(model));
		}
		
		@GetMapping("/memberpro")
		public ResultDto<List<Map<String, String>>> getMemberPro(QueryModel model){
			return new ResultDto<List<Map<String,String>>>(service.getMemberPro(model));
		}
		@GetMapping("/membercontribution")
		public ResultDto<List<Map<String, String>>> getMemberContribution(QueryModel model){
			return new ResultDto<List<Map<String,String>>>(service.getMemberContribution(model));
		}
		@GetMapping("/fitproduct")
		public ResultDto<List<Map<String, String>>> getFitProduct(QueryModel model){
			return new ResultDto<List<Map<String,String>>>(service.getFitProduct(model));
		}
		
		/**
		 * 获取当前机构的一级机构，若当前机构层级为1或2，返回当前机构为一级机构
		 */
		@GetMapping("/getlevel")
			public ResultDto<Map<String, String>> getLevel(String orgId){
				 Map<String, String> orgInfo = service.getOrgLevel(orgId);
				 int num =  Integer.parseInt(orgInfo.get("orgLevel"));
				 String sql = "SELECT ORG_CODE FROM ADMIN_SM_ORG WHERE ORG_CODE = ";
				 if (num > 3) {
					 for (int i = 0; i < num - 3; i++) {
						 if (i == num - 4) {
							 sql += "( SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE =\'" + orgId +"\'";
							}else {
								sql += "( SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE =";
							}
						}
					 for (int i = 0; i < num - 3; i++) {
							sql += ")";
						}
				}else{
					sql += "\'" + orgId +"\'";
				}
				Map<String, String>	map = new HashMap<>();
				orgInfo.put("sql", sql);
				map.put("oneOrg",service.getOneOrg(orgInfo).get("orgCode"));
				map.put("busiType",service.getBusiType().get("busiType"));
				return new ResultDto<>(map);
			}
		/**
		 * 所辖机构号
		 */
		@GetMapping("/mypowerorg")
		public ResultDto<Map<String, String>> getMyPowerOrg(QueryModel model){
				ResultDto<Map<String, String>> resultDto = new ResultDto<Map<String,String>>(service.getMyOrgByUserId(model));
				resultDto.setCode(0);
				resultDto.setMessage("查询成功");
				return resultDto;
		}
		/**
		 * 获取条线信息
		 */
		@GetMapping("/mybusitype")
		public ResultDto<Map<String, String>> getMyBusiType(){
				ResultDto<Map<String, String>> resultDto = new ResultDto<Map<String,String>>(service.getBusiType());
				resultDto.setCode(0);
				resultDto.setMessage("查询成功");
				return resultDto;
		}
		
		@GetMapping("/getUserNameByUserId")
		public ResultDto<Map<String, String>> getUserNameByUserId(String lastUser){
			return new ResultDto<Map<String, String>>(service.getUserNameByUserId(lastUser));
		}
		/**
		 * 查询机构
		 */
		@GetMapping("/getorgtree")
		public ResultDto<List<Map<String, String>>> getorgtree(QueryModel model){
				ResultDto<List<Map<String, String>>> resultDto = new ResultDto<List<Map<String,String>>>(service.getorgtree(model));
				resultDto.setCode(0);
				resultDto.setMessage("查询成功");
				return resultDto;
		}
}
