package cn.com.yusys.yscrm.custpub.web.rest;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.AcrmCustGradeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cn.com.yusys.yscrm.custpub.domain.OcrmFciAdmitBelong;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciBelongHis;
import cn.com.yusys.yscrm.custpub.service.OcrmFciAdmitBelongService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import net.sf.json.JSONArray;

/**
 * @项目名称: yscrm-entity-cust-pub模块
 * @类名称: OcrmFciAdmitBelongResource
 * @类描述: 客户WFCLA
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-25 19:38:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfciadmitbelong")
@Api(value = "ocrmfciadmitbelong", description = "分配调整管理")
public  class OcrmFciAdmitBelongResource extends CommonResource<OcrmFciAdmitBelong, String> {
	@Autowired
    private OcrmFciAdmitBelongService ocrmFciAdmitBelongService;
	
	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return null;
	}
	
	/**
	 * @方法名称: getOrglist
	 * @方法描述: 查询所辖机构
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/getorglist")
	public ResultDto<List<Map<String, Object>>> getOrglist(QueryModel model) {
		List<Map<String, Object>> list = ocrmFciAdmitBelongService.getOrglist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @方法名称: getMgrlist
	 * @方法描述: 查询所辖机构的客户经理
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/getmgrlist")
	public ResultDto<List<Map<String, Object>>> getMgrlist(QueryModel model) {
		List<Map<String, Object>> list = ocrmFciAdmitBelongService.getMgrlist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	* @方法名称:qryOrgId
	* @方法描述:查询当前客户的机构、客户经理（主办）
	* @参数与返回说明:
	* @算法描述:
	*/
	@GetMapping("/qryorgid")
	public ResultDto<List<Map<String, Object>>> qryOrgId(@RequestParam(required = false) String custId) {
	        List<Map<String, Object>> list = ocrmFciAdmitBelongService.qryOrgId(custId);
	        return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	* @方法名称:qryMgrId
	* @方法描述: 查询当前客户的机构、客户经理（协办）
	* @参数与返回说明:
	* @算法描述:
	*/
	@GetMapping("/qrymgrid")
	public ResultDto<List<Map<String, Object>>> qryMgrId(@RequestParam(required = false) String custId) {
	        List<Map<String, Object>> list = ocrmFciAdmitBelongService.qryMgrId(custId);
	        return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	* @方法名称:qryBelongHis
	* @方法描述:查询调整历史
	* @参数与返回说明:
	* @算法描述:
	*/
	@GetMapping("/qrybelonghis")
	@ApiOperation(value = "查询调整历史")
	public ResultDto<List<Map<String, Object>>> qryBelongHis(QueryModel model) {
	        List<Map<String, Object>> list = ocrmFciAdmitBelongService.qryBelongHis(model);
	        return new ResultDto<List<Map<String, Object>>>(list);
	}

	/**
	 * @方法名称:
	 * @方法描述:查询分配调整详情
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/detailebelonghis")
	@ApiOperation(value = "查询分配调整详情")
	public ResultDto<Map<String, Object>> detailebelonghis(String seqno) {
		Map<String, Object> maps = ocrmFciAdmitBelongService.detailebelonghis(seqno);
		return new ResultDto<Map<String, Object>>(maps);
	}
	/**
	 * @方法名称:qryBelongHis
	 * @方法描述:查询客户分层详情
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/Gradelist")
	@ApiOperation(value = "查询客户分层详情")
	public ResultDto<Map<String, Object>> Gradelist(String id) {
		Map<String, Object> maps = ocrmFciAdmitBelongService.Gradelist(id);
		return new ResultDto<Map<String, Object>>(maps);
	}
	/**
	 * @方法名称:
	 * @方法描述:查询分配调整列表
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/qrybelonglist")
	@ApiOperation(value = "查询分配调整列表")
	public ResultDto<List<Map<String, Object>>> qrybelonglist(QueryModel model) {
		List<Map<String, Object>> list = ocrmFciAdmitBelongService.qrybelonglist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	//修改客户等级
	@PostMapping("/updateaumGrade")
	@ApiOperation(value = "修改客户等级")
	public ResultDto<Integer> updateaumGrade(@RequestBody AcrmCustGradeDTO acrmCustGradeDTO) {
		ResultDto<Integer> resultDto = null;
		int num = ocrmFciAdmitBelongService.checkUpNameId(acrmCustGradeDTO.getId());
		if (num == 0) {
			resultDto = new ResultDto<>(ocrmFciAdmitBelongService.insertaumGrade(acrmCustGradeDTO));
			resultDto.setCode(0);
			resultDto.setMessage("修改成功");
			return resultDto;
		}else if (num == 1) {
			resultDto = new ResultDto<>(ocrmFciAdmitBelongService.updateaumGrade(acrmCustGradeDTO));
			resultDto.setCode(0);
			resultDto.setMessage("修改成功");
			return resultDto;
		}
		resultDto = new ResultDto<>(-1);
		resultDto.setCode(-1);
		resultDto.setMessage("修改失败");
		return resultDto;
	}


	/**
	 * 客户分配调整保存
	 * @param nodeData : JSON.stringify(_set.resultsss),//主办信息
              connData : JSON.stringify(_set.resultss),//协办信息
	 * @return
	 *//*
	@SuppressWarnings({ "deprecation", "unchecked", "static-access" })
	@PostMapping("/savebelong")
	public ResultDto<Integer> saveBelong(@RequestBody  Map<?,?> parmas) {
		JSONArray nodeArray =JSONArray.fromObject(parmas.get("nodeData"));
		List<OcrmFciBelongHis> nodeList = nodeArray.toList(nodeArray, OcrmFciBelongHis.class);
		JSONArray connArray =JSONArray.fromObject(parmas.get("connData"));
        List<OcrmFciBelongHis> connList = connArray.toList(connArray, OcrmFciBelongHis.class);
        String isAdmitEnter = (String) parmas.get("isAdmitEnter");
		return new ResultDto<Integer>(ocrmFciAdmitBelongService.saveBelong(nodeList, connList,isAdmitEnter));
	}*/

	/**
	 * 客户分配调整保存
	 * @return
	 */
	@PostMapping("/savebelong")
	public ResultDto<Integer> saveBelong(@RequestBody  Map<String, Object> map) throws Exception {
		return new ResultDto<Integer>(ocrmFciAdmitBelongService.saveBelongadd(map));
	}
	/**
	 * @方法名称: getUpMgrlist
	 * @方法描述: 查询当前主办机构和上级机构的客户经理
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/getupmgrlist")
	public ResultDto<List<Map<String, Object>>> getUpMgrlist(@RequestParam(required = false) String orgCode) {
		List<Map<String, Object>> list = ocrmFciAdmitBelongService.getUpMgrlist(orgCode);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	/**
	 * 判断是否是团队
	 * @param
	 * @return
	 */
	@GetMapping("/isatTeam")
	public ResultDto<Boolean> isatTeam() {
		return new ResultDto(ocrmFciAdmitBelongService.isatTeam());
	}
}