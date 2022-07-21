package cn.com.yusys.yscrm.mktactivity.web.rest;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiExcRecordInfo;
import cn.com.yusys.yscrm.mktactivity.service.OcrmFMkActiExcRecordService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkActiExcRecordResource
 * @类描述：营销活动明细
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-29
 */
@RestController
@RequestMapping("/api/mktrecord")
public class OcrmFMkActiExcRecordResource extends CommonResource<OcrmFMkActiExcRecordInfo,Serializable> {
	@Autowired
	private OcrmFMkActiExcRecordService service;
	@Override
	protected CommonService getCommonService() {
		return this.service;
	}
	/** 
	* @方法名称: actiDetailListQuery
	* @方法描述: 营销活动明细查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actidetaillistquery")
	public ResultDto<List<Map<String,Object>>> actiDetailListQuery(QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.actiDetailListQuery(model));
	}
	/** 
	* @方法名称: actiExeDetailListQuery
	* @方法描述: 营销活动执行明细查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actiexedetaillistquery")
	public ResultDto<List<Map<String,Object>>> actiExeDetailListQuery(QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.actiExeDetailListQuery(model));
	}
	/**
	* @throws ParseException 
	* @方法名称: actiTargetInsert
	* @方法描述: 营销活动明细新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actiexedetailinsert")
	public ResultDto<Integer> actiExeDetailInsert(@RequestBody @Validated OcrmFMkActiExcRecordInfo record) throws ParseException {
		return this.service.actiExeDetailInsert(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: actiExeDetailEdit
	* @方法描述: 营销活动明细修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actiexedetailedit")
	public ResultDto<Integer> actiExeDetailEdit(@RequestBody @Validated OcrmFMkActiExcRecordInfo record) throws ParseException {
		return this.service.actiExeDetailEdit(record);
	}
	/** 
	* @方法名称: actiExeDetailDel
	* @方法描述: 营销活动明细删除
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actiexedetaildel")
	public ResultDto<Integer> actiExeDetailDel(@RequestBody @Validated OcrmFMkActiExcRecordInfo[] record) {
		return this.service.actiExeDetailDel(record);
	}
}
