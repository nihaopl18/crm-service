package cn.com.yusys.yscrm.cust.group.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.cust.group.domain.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.cust.group.service.OcrmFciCgBaseService;
import cn.com.yusys.yscrm.cust.group.service.OcrmFciCgMemberService;

import javax.servlet.http.HttpServletResponse;

/**
 * @项目名称: yscrm-entity-cust-group-core模块
 * @类名称: OcrmFciCgBaseResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-18 10:34:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcicgbase")
@Api(value = "ocrmfcicgbase", description = "客群管理")
public class OcrmFciCgBaseResource extends CommonResource<OcrmFciCgBase, String> {
    @Autowired
    private OcrmFciCgBaseService ocrmFciCgBaseService;
    
    @Autowired
    private OcrmFciCgMemberService ocrmFciCgMemberService;


	private static final String CUST_GROUP_NAME = "custGroupName";
	private final Logger log = LoggerFactory.getLogger(OcrmFciCgBaseResource.class);
    @Override
    protected CommonService getCommonService() {
        return ocrmFciCgBaseService;
    }
    
    	//新增客户群
    	@PostMapping("/add")
    	public ResultDto<OcrmFciCgBase> add(@RequestBody Map<String, String> c) {
    		ResultDto<OcrmFciCgBase> resultDto = null;
    		if (ocrmFciCgBaseService.checkName(c.get(CUST_GROUP_NAME)) == 0) {
    			resultDto = new ResultDto<OcrmFciCgBase>(ocrmFciCgBaseService.add(c));
    			resultDto.setMessage("新增成功");
    			resultDto.setCode(0);
    			return resultDto;
    		}
    		resultDto = new ResultDto<OcrmFciCgBase>();
    		resultDto.setMessage("新增失败,名称重复");
    		resultDto.setCode(-1);
    		return resultDto;
    	}
  	
  		//删除客户群并删除群成员
  		@PostMapping("/del")
  		public ResultDto<Integer> del(@RequestBody QueryModel model) {
  			String ids = (String) model.getCondition().get("custGroupId");
  			String[] id = ids.split(",");
  			for (int i = 0; i < id.length; i++) {
  				if (getCommonService().deleteByIds(id[i]) == 1) {
  					ocrmFciCgMemberService.delMemberByGroupId(id[i]);
  				}
  				
  			}
  			ResultDto<Integer> resultDto = new ResultDto<Integer>();
  			resultDto.setCode(0);
  			resultDto.setMessage("删除成功");
  			return resultDto;
  		}
  		
  			//修改
  			@PostMapping("/updateFun")
  			public ResultDto<Integer> updateFun(@RequestBody OcrmFciCgBase c) {
  				ResultDto<Integer> resultDto = null;
  				int num = ocrmFciCgBaseService.checkUpName(c.getCustGroupId(), c.getCustGroupName());
  				if (num == 0) {
  					resultDto = new ResultDto<>(ocrmFciCgBaseService.updateFun(c));
  					resultDto.setCode(0);
  					resultDto.setMessage("修改成功");
  					return resultDto;
  				}
  				resultDto = new ResultDto<>(-1);
  				resultDto.setCode(-1);
  				resultDto.setMessage("修改失败，名称已存在");
  				return resultDto;
  			}
  			
  			//查询客户群基本信息列表信息
  			@GetMapping("/list")
  			public ResultDto<List<Map<Object,String>>> getListByModel(QueryModel queryModel) {
  				return new ResultDto<List<Map<Object,String>>>(ocrmFciCgBaseService.getListByModel(queryModel));
  			}
  			
  		//查询客户群基本信息信息
  			@GetMapping("/getcustgroupinfo")
  			public ResultDto<Map<String,String>> getGroupInfoByModel(QueryModel queryModel) {
  				return new ResultDto<Map<String,String>>(ocrmFciCgBaseService.getGroupInfoByModel(queryModel));
  			}

  			@GetMapping("/checkName")
  			public ResultDto<Integer> checkName(QueryModel model){
  				return new ResultDto<>(ocrmFciCgBaseService.checkName((String) model.getCondition().get(CUST_GROUP_NAME)));
  			}
  			/**
  			 * 修改自动筛选群
  			 */
  			@PostMapping("/updateAuto")
			public ResultDto<OcrmFciCgBase> updateAuto(@RequestBody OcrmFciCgBase c) {
				ResultDto<OcrmFciCgBase> resultDto = null;
				OcrmFciCgBase ocrmFciCgBase = ocrmFciCgBaseService.updateAuto(c);
				if ( ocrmFciCgBase!= null) {
					resultDto = new ResultDto<>(ocrmFciCgBase);
					resultDto.setCode(0);
					resultDto.setMessage("修改成功");
					return resultDto;
				}
				resultDto = new ResultDto<>();
				resultDto.setCode(-1);
				resultDto.setMessage("修改失败，名称已存在");
				return resultDto;
			}
  			@GetMapping("/getlevel")
  			public ResultDto<Map<String, String>> getLevel(String orgId){
  				 Map<String, String> orgInfo = ocrmFciCgBaseService.getOrgLevel(orgId);
  				 int num =  Integer.parseInt(orgInfo.get("orgLevel"));
  				 String sql = "SELECT ORG_CODE FROM ADMIN_SM_ORG WHERE ORG_CODE = ";
  				 if (num > 2) {
  					 
  					 for (int i = 0; i < num - 2; i++) {
  						 if (i == num - 3) {
  							 sql += "( SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE =\'" + orgId +"\'";
  							}else {
  								sql += "( SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE =";
  							}
  						}
  					 for (int i = 0; i < num - 2; i++) {
  							sql += ")";
  						}
  				}else{
  					sql += "\'" + orgId +"\'";
  				}
  				Map<String, String>	map = new HashMap<>();
  				orgInfo.put("sql", sql);
  				map.put("oneOrg",ocrmFciCgBaseService.getOneOrg(orgInfo).get("orgCode"));
  				return new ResultDto<>(map);
  			}

	//客户客群查询
	@GetMapping("/customerList")
	@ApiOperation(value = "客户客群筛选")
	public ResultDto<List<CrmFCgPreparationVO>> customerList(CrmCustomerDTO crmCustomerDTO) {
		return new ResultDto<List<CrmFCgPreparationVO>>(ocrmFciCgBaseService.getcustomerList(crmCustomerDTO));
	}

	//公共池客户查询
	@GetMapping("/publiccustomerList")
	@ApiOperation(value = "公共池客户查询")
	public ResultDto<List<CrmFCgPreparationVO>> publiccustomerList(CrmCustomerDTO crmCustomerDTO) {
		return new ResultDto<List<CrmFCgPreparationVO>>(ocrmFciCgBaseService.getcustomerList(crmCustomerDTO));
	}
	//新增客户群信息
	@PostMapping("/insertBase")
	@ApiOperation(value = "新增客户群信息")
	public ResultDto<Integer> insertBase(@RequestBody CrmFCissCgBaseInfoDTO crmFCissCgBaseInfoDTO) {
		ResultDto<Integer> resultDto = null;
		int num = ocrmFciCgBaseService.checkUpNameName(crmFCissCgBaseInfoDTO.getfCissCgBase().getCustGroupId(),crmFCissCgBaseInfoDTO.getfCissCgBase().getCustGroupName());
		if (num == 0) {
			resultDto = new ResultDto<>(ocrmFciCgBaseService.insertBase(crmFCissCgBaseInfoDTO));
			resultDto.setCode(0);
			resultDto.setMessage("新增成功");
			return resultDto;
		}else if(num==1 && StringUtils.isEmpty(crmFCissCgBaseInfoDTO.getfCissCgBase().getCustGroupName())){
			resultDto = new ResultDto<>(ocrmFciCgBaseService.insertBase(crmFCissCgBaseInfoDTO));
			resultDto.setCode(0);
			resultDto.setMessage("新增成功");
			return resultDto;
		}
		resultDto = new ResultDto<>(-1);
		resultDto.setCode(-1);
		resultDto.setMessage("新增失败，名称已存在");
		return resultDto;
	}

	//加入灵活查询客户群信息
	@PostMapping("/insertlinBase")
	@ApiOperation(value = "加入灵活查询客户群信息")
	public ResultDto<Integer> insertlinBase(@RequestBody CrmFCissCgInfoDTO crmFCissCgInfoDTO) {
		ResultDto<Integer> resultDto = null;
		int num = ocrmFciCgBaseService.checkUpNameName(crmFCissCgInfoDTO.getfCissCgBase().getCustGroupId(),crmFCissCgInfoDTO.getfCissCgBase().getCustGroupName());
		//新客群
		if (num == 0) {
			resultDto = new ResultDto<>(ocrmFciCgBaseService.insertlinBase(crmFCissCgInfoDTO));
			resultDto.setCode(0);
			resultDto.setMessage("新增成功");
			return resultDto;
		}else if(num==1 && StringUtils.isEmpty(crmFCissCgInfoDTO.getfCissCgBase().getCustGroupName())){
			//已有客群
			resultDto = new ResultDto<>(ocrmFciCgBaseService.insertlinBase(crmFCissCgInfoDTO));
			resultDto.setCode(0);
			resultDto.setMessage("新增成功");
			return resultDto;
		}
		resultDto = new ResultDto<>(-1);
		resultDto.setCode(-1);
		resultDto.setMessage("新增失败，名称已存在");
		return resultDto;
	}
	//修改客户群信息
	@PostMapping("/updateBase")
	@ApiOperation(value = "修改客户群信息")
	public ResultDto<Integer> updateBase(@RequestBody CrmFCissCgBase crmFCissCgBase) {
		ResultDto<Integer> resultDto = null;
		int num = ocrmFciCgBaseService.checkUpNameId(crmFCissCgBase.getCustGroupId());
		if (num == 1) {
			resultDto = new ResultDto<>(ocrmFciCgBaseService.updateBase(crmFCissCgBase));
			resultDto.setCode(0);
			resultDto.setMessage("修改成功");
			return resultDto;
		}
		resultDto = new ResultDto<>(-1);
		resultDto.setCode(-1);
		resultDto.setMessage("修改失败，客群不存在");
		return resultDto;
	}

	//查询客户群基本信息列表信息
	@GetMapping("/queryBaselist")
	@ApiOperation(value = "查询客户群基本信息列表信息")
	public ResultDto<List<CrmFCissCgBaseVO>> queryBaselist(CrmBaseDTO crmBaseDTO) {
        return new ResultDto<List<CrmFCissCgBaseVO>>(ocrmFciCgBaseService.queryBaselist(crmBaseDTO));
	}
	//查询客户群基本信息列表信息
	@GetMapping("/querycustomet")
	@ApiOperation(value = "查询单个客户群基本信息")
	public ResultDto<CrmFCissCgBaseVO> querycustomet(String custGroupId) {
		return new ResultDto<CrmFCissCgBaseVO>(ocrmFciCgBaseService.querycustomet(custGroupId));
	}

    //管户所属客户群信息
    @GetMapping("/querycust")
    @ApiOperation(value = "管户所属客户群信息")
    public ResultDto<List<CrmFCissCgBaseVO>> querycust(String custId) {
        return new ResultDto<List<CrmFCissCgBaseVO>>(ocrmFciCgBaseService.querycust(custId));
    }
	//查询客户群客户列表
	@GetMapping("/queryBaseCustomerlist")
	@ApiOperation(value = "查询客户群客户列表")
	public ResultDto<List<CrmFCgPreparationVO>> queryBaseCustomerlist(CrmBasePreparDTO crmBasePreparDTO) {
		return new ResultDto<List<CrmFCgPreparationVO>>(ocrmFciCgBaseService.queryBaseCustomerlist(crmBasePreparDTO));
	}

	//历史变动客户列表信息
	@GetMapping("/queryjournallist")
	@ApiOperation(value = "历史变动客户列表信息")
	public ResultDto<List<CrmFCgPreparationVO>> queryjournallist(CrmBasePreparDTO crmBasePreparDTO) {
		return new ResultDto<List<CrmFCgPreparationVO>>(ocrmFciCgBaseService.queryjournallist(crmBasePreparDTO));
	}
	//移除客户
	@PostMapping("/deleteBaseCustomer")
	@ApiOperation(value = "移除客户")
	public ResultDto<Integer> deleteBaseCustomer(@RequestBody CrmBaseCuDTO crmBaseCuDTO) {
		ResultDto<Integer> resultDto = null;
		resultDto = new ResultDto<>(ocrmFciCgBaseService.deleteBaseCustomer(crmBaseCuDTO));
		resultDto.setCode(0);
		resultDto.setMessage("删除成功");
		return resultDto;
	}

	//解散客群
	@PostMapping("/deleteCustomer")
	@ApiOperation(value = "解散客群")
	public ResultDto<Integer> deleteCustomer(@RequestBody CrmBaseCuDTO crmBaseCuDTO) {
		ResultDto<Integer> resultDto = null;
		resultDto = new ResultDto<>(ocrmFciCgBaseService.deleteCustomer(crmBaseCuDTO));
		resultDto.setCode(0);
		resultDto.setMessage("删除成功");
		return resultDto;
	}

	//查询历史变动
	@GetMapping("/Selectjournal")
	@ApiOperation(value = "查询历史变动")
	public ResultDto<List<CrmFCgJournalVO>> Selectjournal(CrmBasePreparDTO crmBasePreparDTO) {
		return new ResultDto<List<CrmFCgJournalVO>>(ocrmFciCgBaseService.Selectjournal(crmBasePreparDTO));
	}

	//查询客群分析信息
	@GetMapping("/queryIndexStatuslist")
	@ApiOperation(value = "查询客群分析信息")
	public ResultDto<Map<String, List<Map<String, Object>>>> queryIndexStatuslist(CrmIndexStatusDTO crmIndexStatusDTO) throws Exception {
		return new ResultDto<Map<String, List<Map<String, Object>>>>(ocrmFciCgBaseService.queryIndexStatuslist(crmIndexStatusDTO));
	}

	/**
	 * 导出客户列表
	 *
	 * @param
	 */
	@GetMapping("/export")
	@ApiOperation(value = "导出客户列表")
	public void daochuStatisticToExcel(HttpServletResponse response,QueryModel model) {
		try {
			ocrmFciCgBaseService.export(response,model);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("导出失败");
		}
	}

	/**
	 * 导出客群分析
	 *
	 * @param
	 */
	@GetMapping("/IndexStatusExcel")
	@ApiOperation(value = "导出客群分析")
	public void IndexStatusExcel(HttpServletResponse response,CrmIndexStatusDTO crmIndexStatusDTO) {
		try {
			ocrmFciCgBaseService.IndexStatusExcel(response,crmIndexStatusDTO);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("导出失败");
		}
	}
    //全行客户查询
    @GetMapping("/wholecustomerList")
    @ApiOperation(value = "全行客户查询")
    public ResultDto<List<CrmFCgUserVO>> wholecustomerList(CustomererDTO customererDTO) {
        return new ResultDto<List<CrmFCgUserVO>>(ocrmFciCgBaseService.wholecustomerList(customererDTO));
    }

	//产品信息检索
	@GetMapping("/queryprodlist")
	@ApiOperation(value = "产品信息检索")
	public ResultDto<List<Map<String, Object>>> queryprodlist(ProdDTO prodDTO){
		return new ResultDto<List<Map<String, Object>>>(ocrmFciCgBaseService.queryprodlist(prodDTO));
	}

	//查询辖下客户经理编号
	@GetMapping("/querymgrlist")
	@ApiOperation(value = "查询辖下客户经理编号")
	public ResultDto<Map<String, Object>> querymgrlist(){
		return new ResultDto<Map<String, Object>>(ocrmFciCgBaseService.querymgrlist());
	}
}
