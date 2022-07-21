package cn.com.yusys.yscrm.salesoppor.web.rest;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.salesoppor.domain.OcrmFMkMktActivityInfo;
import cn.com.yusys.yscrm.salesoppor.service.OcrmFMkMktActivityService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkMktActivityResource
 * @类描述：营销活动明细相关Resource
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-22
 */
@RestController
@RequestMapping("/api/salesactiv")
public class OcrmFMkMktActivityResource extends CommonResource<OcrmFMkMktActivityInfo, Serializable>{
	@Autowired
	private OcrmFMkMktActivityService service;
	@Override 
	protected CommonService getCommonService() {
		return this.service;
	}
	/**
	* @方法名称: opporListQuery
	* @方法描述: 销售活动查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/activilistquery")
	public ResultDto<List<Map<String,Object>>> activiListQuery(@Validated QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.activiListQuery(model));
	}
	/**
	* @throws ParseException 
	* @方法名称: activiInsert
	* @方法描述: 销售活动新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/activiinsert")
	public ResultDto<Integer> activiInsert(@RequestBody @Validated OcrmFMkMktActivityInfo record) throws ParseException {
		return this.service.activiInsert(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: activiUpdate
	* @方法描述: 销售活动修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/activiupdate")
	public ResultDto<Integer> activiUpdate(@RequestBody @Validated OcrmFMkMktActivityInfo record) throws ParseException {
		return this.service.activiUpdate(record);
	}
	/**
	* @方法名称: activiDel
	* @方法描述: 销售活动删除
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actividelete/{ids}")
	public ResultDto<Integer> activiDel(@Validated @PathVariable String ids) {
		return this.service.activiDel(ids);
	}
	
}
