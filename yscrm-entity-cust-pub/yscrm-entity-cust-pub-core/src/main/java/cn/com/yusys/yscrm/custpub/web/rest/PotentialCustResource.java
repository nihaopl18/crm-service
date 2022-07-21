package cn.com.yusys.yscrm.custpub.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.db2.jcc.am.ne;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAdmitAll;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciOrgCustInfo;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciPerAdmitInfo;
import cn.com.yusys.yscrm.custpub.service.PotentialCustService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
/**
 * @项目名称：crm-service
 * @类名称：PotentialCustResource
 * @类描述：潜在客户管理Resource
 * @功能描述:
 * @创建人：houyx3
 * @创建时间：2019-01-31
 */
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: PotentialCustResource
 * @类描述: 潜在客户管理
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-01-31 16:45:04
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/potentialcust")
public class PotentialCustResource extends CommonResource<AcrmFciCustAdmitAll, String> {

	@Autowired
	private PotentialCustService potentialCustService;
	private static final String CUST_TYPE = "custType";
	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.potentialCustService;
	}

	/**
	 * @方法名称: getListByModel
	 * @方法描述: 潜在客户查询
	 * @参数与返回说明:
	 * @算法描述:
	 **/
	@GetMapping("/list")
	public ResultDto<List<Map<String, String>>> getListByModel(QueryModel model) {
		ResultDto<List<Map<String, String>>> resultDto = new ResultDto<List<Map<String, String>>>(
				potentialCustService.getListByModel(model));
		return resultDto;
	}

	/**
	 * @方法名称: addOrg
	 * @方法描述: 潜在客户新增对公
	 * @参数与返回说明:
	 * @算法描述:
	 **/
	@PostMapping("/addorg")
	public ResultDto<Integer> addOrg(@RequestBody Map<String, String> map) {
		int num = potentialCustService.addOrg(map);
		if (num != 0) {
			ResultDto<Integer> resultDto = new ResultDto<>(num);
			resultDto.setCode(0);
			resultDto.setMessage("新增成功");
			return resultDto;
		}
		ResultDto<Integer> resultDto = new ResultDto<>();
		resultDto.setCode(-1);
		resultDto.setMessage("用户已存在，新增失败");
		return resultDto;

	}

	/**
	 * @方法名称: updateOrg
	 * @方法描述: 潜在客户修改（对公）
	 * @参数与返回说明:
	 * @算法描述:
	 **/
	@PostMapping("/updateorg")
	public ResultDto<Integer> updateOrg(@RequestBody Map<String, String> map) {
		int num = potentialCustService.updateOrg(map);
		if (num != 0) {
			ResultDto<Integer> resultDto = new ResultDto<>(num);
			resultDto.setCode(0);
			resultDto.setMessage("修改成功");
			return resultDto;
		}
		ResultDto<Integer> resultDto = new ResultDto<>();
		resultDto.setCode(-1);
		resultDto.setMessage("修改失败");
		return resultDto;

	}

	/**
	 * @方法名称: addPer
	 * @方法描述: 潜在客户新增（对私
	 * @参数与返回说明:
	 * @算法描述:
	 **/
	@PostMapping("/addper")
	public ResultDto<Integer> addPer(@RequestBody Map<String, String> map) {
		int num = potentialCustService.addPer(map);
		if (num != 0) {
			ResultDto<Integer> resultDto = new ResultDto<>(num);
			resultDto.setCode(0);
			resultDto.setMessage("新增成功");
			return resultDto;
		}
		ResultDto<Integer> resultDto = new ResultDto<>();
		resultDto.setCode(-1);
		resultDto.setMessage("用户已存在,新增失败");
		return resultDto;

	}

	/**
	 * @方法名称: updatePer
	 * @方法描述: 潜在客户修改（对私
	 * @参数与返回说明:
	 * @算法描述:
	 **/
	@PostMapping("/updateper")
	public ResultDto<Integer> updatePer(@RequestBody Map<String, String> map) {
		int num = potentialCustService.updatePer(map);
		if (num != 0) {
			ResultDto<Integer> resultDto = new ResultDto<>(num);
			resultDto.setCode(0);
			resultDto.setMessage("修改成功");
			return resultDto;
		}
		ResultDto<Integer> resultDto = new ResultDto<>();
		resultDto.setCode(-1);
		resultDto.setMessage("修改失败");
		return resultDto;

	}

	/**
	 * @方法名称: isCustMgr
	 * @方法描述: 潜在客户修改（对私
	 * @参数与返回说明:
	 * @算法描述:
	 **/
	@GetMapping("/iscustmgr")
	public ResultDto<Map<String, String>> isCustMgr(QueryModel model) {
		String userId = (String) model.getCondition().get("userId");
		return new ResultDto<Map<String, String>>(potentialCustService.isCustMgr(userId));

	}

	/**
	 * @方法名称: uploadTable
	 * @方法描述: 潜在客户批量导入
	 * @参数与返回说明:
	 * @算法描述:
	 **/
	@PostMapping("/uploadtableper")
	public ResultDto<Map<String, Object>> uploadTable(@RequestParam(required = false) String flag, MultipartFile file) {
		ResultDto<Map<String, Object>> rs = null;
		try {
			Map<String, Object> reMap = this.potentialCustService.dataImportPer(flag, file);
			if (reMap.get("message").equals("succese")) {
				rs = new ResultDto<>(reMap);
				rs.setMessage("总条数：" + reMap.get("count") + "导入成功:" + reMap.get("successNum") + "重复数据："
						+ reMap.get("repeatNum"));
				rs.setCode(0);
				return rs;

			}
			rs = new ResultDto<>();
			rs.setMessage("导入失败");
			rs.setCode(-1);
			return rs;
		} catch (Exception e) {
			if ("1".equals(e.getMessage())) {
				rs.setCode(-1);
				rs.setMessage("失败");
			}
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} // UTF-8
		return rs;
	}

	@PostMapping("/delete")
	protected ResultDto<Integer> deletePer(@RequestBody Map<?, ?> list) {
		Integer result = 0;
		if (list.get("ids") != null && !"".equals((list.get("ids")+"").trim())&&
				list.get(CUST_TYPE) != null && !"".equals((list.get(CUST_TYPE)+"").trim())) {
			result=potentialCustService.delete(list.get("ids")+"",list.get(CUST_TYPE)+"");
		}
		return new ResultDto<Integer>(result);
	}
}
