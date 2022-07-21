package cn.com.yusys.yscrm.custpub.web.rest;

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
import cn.com.yusys.yscrm.custpub.domain.OcrmFciNetworkRela;
import cn.com.yusys.yscrm.custpub.service.OcrmFciNetworkRelaService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciNetworkRelaResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 16:23:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcinetworkrela")
public class OcrmFciNetworkRelaResource extends CommonResource<OcrmFciNetworkRela, String> {
    @Autowired
    private OcrmFciNetworkRelaService ocrmFciNetworkRelaService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFciNetworkRelaService;
    }
    
    @GetMapping("/list")
    public ResultDto<List<Map<String, Object>>> getListByModel(QueryModel model){
    	return new ResultDto<List<Map<String, Object>>>(ocrmFciNetworkRelaService.getListByModel(model));
    }
	 /**
		 * 
		* @方法名称: getCustInf
		* @方法描述:获取所辖客户信
		* @参数与返回说明: 
		* @算法描述:
		 */
    @GetMapping("/custlist")
    public ResultDto<List<Map<String, Object>>> getCustInf(String custName){
    	return new ResultDto<List<Map<String, Object>>>(ocrmFciNetworkRelaService.getCustInfo(custName));
    }
    
	 /**
		 * 
		* @方法名称: getdetailById
		* @方法描述:获取客户网络关系图信息
		* @参数与返回说明: 
		* @算法描述:节点信息，连接信息
		 */
    @GetMapping("/detail")
    public ResultDto<Map<String, Object>> getdetailById(String netId){
    	return new ResultDto<Map<String, Object>>(ocrmFciNetworkRelaService.getnetWorkRelaInfoBynetId(netId));
    }
    
    
    @PostMapping("/add")
    public ResultDto<Integer> add(@RequestBody Map<Object, Object> map){
    	int num = ocrmFciNetworkRelaService.add(map);
		return new ResultDto<>(num);
    	
    }
    @PostMapping("/upd")
    public ResultDto<Integer> updFun(@RequestBody Map<Object, Object> map){
    	int num = ocrmFciNetworkRelaService.updFun(map);
		return new ResultDto<>(num);
    	
    }
    @PostMapping("/del")
    public ResultDto<Integer> del(String networkRelaId){
    	//String netId = (String) model.getCondition().get("id");
    	ResultDto<Integer> resultDto = null;
    	int num = ocrmFciNetworkRelaService.del(networkRelaId);
    	if (num == 0) {
    		resultDto = new ResultDto<>();
			resultDto.setCode(-1);
			resultDto.setMessage("删除失败");
			return resultDto;
		}
    	resultDto = new ResultDto<>();
		resultDto.setCode(0);
		resultDto.setMessage("删除成功");
		return resultDto;
    	
    }
}
