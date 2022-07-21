package cn.com.yusys.yscrm.cust.group.web.rest;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.cust.group.domain.OcrmFciCgMember;
import cn.com.yusys.yscrm.cust.group.service.OcrmFciCgMemberService;
import cn.com.yusys.yucrm.custgroup.util.UtilTools;

/**
 * @项目名称: yscrm-entity-cust-group-core模块
 * @类名称: OcrmFciCgMemberResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-18 10:34:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcicgmember")
public class OcrmFciCgMemberResource extends CommonResource<OcrmFciCgMember, String> {
    @Autowired
    private OcrmFciCgMemberService ocrmFciCgMemberService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFciCgMemberService;
    }
    
    /**
	* @方法名称: joinGroup
	* @方法描述: 加入客户群
	* @参数与返回说明: 
	* @算法描述: 
	*/
  	@PostMapping("/joingroup")
  	public ResultDto<Integer> joinGroup(@RequestBody QueryModel model) {
  		ResultDto<Integer> resultDto = null;
  		String[] custIds = ((String) model.getCondition().get("custId")).split(",");
  		String custGroupId = (String) model.getCondition().get("custGroupNo");
  		if (custIds == null || custGroupId.equals("")) {
  			resultDto = new ResultDto<Integer>();
  			resultDto.setMessage("入群失败");
  			resultDto.setCode(-1);
  			return new ResultDto<>(-1);
  		}
  		for (int i = 0; i < custIds.length; i++) {
  			OcrmFciCgMember c = new OcrmFciCgMember();
  			c.setCustGroupId(custGroupId);
  			c.setCustId(custIds[i]);
  			if (ocrmFciCgMemberService.checkBe(c) == 0) {
  				c.setId(UUID.randomUUID().toString().replaceAll("-", ""));
  				UtilTools.addUtl(c);
  				c.setCorpOrgCode("001");
  				ocrmFciCgMemberService.joinGroup(c);
  			};
  		}
  		resultDto = new ResultDto<Integer>();
  		resultDto.setMessage("入群成功");
  		resultDto.setCode(0);
  		return resultDto;
  		
  	}
  	@PostMapping("/uploadtableper")
	public ResultDto<Map<String, Object>> uploadTable(@RequestParam(required = false) String custGroupId,MultipartFile file) {
		ResultDto<Map<String, Object>> rs = null;
		try {
			Map<String, Object> reMap =  this.ocrmFciCgMemberService.dataImportPer(custGroupId, file);
			if (reMap.get("message").equals("succese")) {
				rs = new ResultDto<>(reMap);
				rs.setMessage("总条数："+reMap.get("count")+"导入成功:" + reMap.get("successNum") + "重复数据：" +reMap.get("repeatNum"));
				rs.setCode(0);
				return rs;
				
			}
			rs = new ResultDto<>();
			rs.setMessage("导入失败");
			rs.setCode(-1);
			return rs;
		}catch (Exception e) {
			if ("1".equals(e.getMessage()))  
            {  
				rs.setCode(-1);
		    	rs.setMessage("失败");
            }  
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} // UTF-8
		return rs ;
	}
  	/**
	* @方法名称: outGroup
	* @方法描述: 移出客户群
	* @参数与返回说明: 
	* @算法描述: 
	*/
  		@PostMapping("/outgroup")
  		public ResultDto<Integer> outGroup(@RequestBody QueryModel model) {
  				ResultDto<Integer> resultDto = null;
  				String ids = (String) model.getCondition().get("ids");
  				if (ids == null || ids.equals("")) {
  					resultDto = new ResultDto<Integer>();
  					resultDto.setMessage("移除群失败");
  					resultDto.setCode(-1);
  					return new ResultDto<>(-1);
  				}
  				ocrmFciCgMemberService.deleteByIds(ids);
  				resultDto = new ResultDto<Integer>();
  				resultDto.setCode(0);
  				resultDto.setMessage("移除成功");
  				return resultDto;
  				
  			}
  		/**
  		* @方法名称: getMemberList
  		* @方法描述: 已入群成员查询
  		* @参数与返回说明: 
  		* @算法描述: 
  		*/
  		@GetMapping("/memberlist")
  		public ResultDto<List<Map<Object, String>>> getMemberList(QueryModel model){
  			ResultDto<List<Map<Object, String>>> resultDto = null;
  	  		String custGroupId = (String) model.getCondition().get("custGroupId");
  	  		//根据群编号查询群成员信息sql
  	  		if (custGroupId == null || custGroupId.equals("")) {
  	  			resultDto = new ResultDto<>();
  	  			resultDto.setMessage("查询失败");
  	  			resultDto.setCode(-1);
  	  			return new ResultDto<>(null);
  	  		}
  			List<Map<Object, String>> list = ocrmFciCgMemberService.getMemberList(model);
			return new ResultDto<>(list);
  			
  		}
  		/**
  		* @方法名称: getNoMemberList
  		* @方法描述: 自动刷选入群成员查询
  		* @参数与返回说明: 
  		* @算法描述: 
  		*/
  		@GetMapping("/memberautolist")
  		public ResultDto<List<Map<String, String>>> getAutoMemberList(QueryModel model){
  			ResultDto<List<Map<Object, String>>> resultDto = null;
  	  		String sql = (String) model.getCondition().get("sql");
  	  		if (sql == null) {
  	  			resultDto = new ResultDto<>();
  	  			resultDto.setMessage("查询失败");
  	  			resultDto.setCode(-1);
  	  			return new ResultDto<>(null);
  	  		}
  			List<Map<String, String>> list = ocrmFciCgMemberService.getAutoMemberList(model);
  			return new ResultDto<>(list);
  			
  		}
  		@GetMapping("/memberdeposit")
  		public ResultDto<List<Map<String, String>>> getMemberDeposit(QueryModel model){
  			return new ResultDto<List<Map<String,String>>>(ocrmFciCgMemberService.getMemberDeposit(model));
  		}
  		
  		@GetMapping("/memberloan")
  		public ResultDto<List<Map<String, String>>> getMemberLoan(QueryModel model){
  			return new ResultDto<List<Map<String,String>>>(ocrmFciCgMemberService.getMemberLoan(model));
  		}
  		
  		@GetMapping("/memberpro")
  		public ResultDto<List<Map<String, String>>> getMemberPro(QueryModel model){
  			return new ResultDto<List<Map<String,String>>>(ocrmFciCgMemberService.getMemberPro(model));
  		}
  		@GetMapping("/membercontribution")
  		public ResultDto<List<Map<String, String>>> getMemberContribution(QueryModel model){
  			return new ResultDto<List<Map<String,String>>>(ocrmFciCgMemberService.getMemberContribution(model));
  		}
  		@GetMapping("/membercontribution1")
  		public ResultDto<List<Map<String, String>>> getMemberContribution1(QueryModel model){
  			return new ResultDto<List<Map<String,String>>>(ocrmFciCgMemberService.getMemberContribution1(model));
  		}
  		
  		@GetMapping("/fitproduct")
  		public ResultDto<List<Map<String, String>>> getFitProduct(QueryModel model){
  			return new ResultDto<List<Map<String,String>>>(ocrmFciCgMemberService.getFitProduct(model));
  		}
  		
}
