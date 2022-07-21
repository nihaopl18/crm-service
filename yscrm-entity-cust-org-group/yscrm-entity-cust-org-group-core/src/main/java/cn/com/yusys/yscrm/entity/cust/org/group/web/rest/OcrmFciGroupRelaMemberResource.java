package cn.com.yusys.yscrm.entity.cust.org.group.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.entity.cust.org.group.domain.OcrmFciGroupRelaMember;
import cn.com.yusys.yscrm.entity.cust.org.group.service.OcrmFciGroupRelaMemberService;

/**
 * @项目名称: yscrm-entity-cust-org-group-core模块
 * @类名称: OcrmFciGroupRelaMemberResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 19:13:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcigrouprelamember")
public class OcrmFciGroupRelaMemberResource extends CommonResource<OcrmFciGroupRelaMember, String> {
    @Autowired
    private OcrmFciGroupRelaMemberService ocrmFciGroupRelaMemberService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFciGroupRelaMemberService;
    }
    @GetMapping("/list")
    public ResultDto<Map<String, Object>> getList(String groupNo){
    	return new ResultDto<Map<String, Object>>(ocrmFciGroupRelaMemberService.getList(groupNo));
    }
	/**
	 * 
	* @方法名称: deleteInfo
	* @方法描述: 删除相关数据
	* @参数与返回说明: 
	* @算法描述:
	 */
    @PostMapping("/delete")
    public ResultDto<Object> deleteInfo(String groupNo){
    	ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			ocrmFciGroupRelaMemberService.deleteInfo(groupNo);
			reuslt.setMessage("success");
			//logger.info("删除商户数据");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
    }
    @PostMapping("/save")
    public ResultDto<Integer> save(@RequestBody Map<Object, Object> map){
    	return new ResultDto<Integer>(ocrmFciGroupRelaMemberService.add(map));
    }
    @GetMapping("/getmemberinfo")
    public ResultDto<List<Map<String, Object>>> getMemberInfo(String groupNo,String custName){
    	return new ResultDto<List<Map<String, Object>>>(ocrmFciGroupRelaMemberService.getMembersByGroupNo(groupNo,custName));
    }
}
