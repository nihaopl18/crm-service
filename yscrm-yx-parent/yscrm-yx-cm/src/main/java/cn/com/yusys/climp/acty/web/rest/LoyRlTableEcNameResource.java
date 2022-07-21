package cn.com.yusys.climp.acty.web.rest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.climp.acty.domain.LoyRlTableEcName;
import cn.com.yusys.climp.acty.service.LoyRlTableEcNameService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlTableEcNameResource
 * @类描述: 表汉化资源类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:46:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/tableecname")
public class LoyRlTableEcNameResource extends CommonResource<LoyRlTableEcName, String> {
    @Autowired
    private LoyRlTableEcNameService loyRlTableEcNameService;

    @Override
    protected CommonService getCommonService() {
        return loyRlTableEcNameService;
    }

    /**
	 * 查询表名信息
	 * @param typeId
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/tablelist")
	public ResultDto<List<LoyRlTableEcName>> getTableByTypeId(@RequestParam(required = false) String typeId) {
    	List<LoyRlTableEcName> list = loyRlTableEcNameService.getTableByTypeId(typeId);
		return new ResultDto<List<LoyRlTableEcName>>(list);
	}
	/**
	 * 保存表名汉化
	 * @param t
	 * @return
	 * @throws URISyntaxException
	 */
	
	@PostMapping("/savetabandfield")
    public  ResultDto<Object> saveTabAndField(@RequestBody ArrayList<LoyRlTableEcName> t)
            throws URISyntaxException {
    	 List<LoyRlTableEcName> list = t;
    	 loyRlTableEcNameService.saveTabAndField(list);
         return new ResultDto<Object>();
    }
	/**
	 * 
	* @方法名称:checkUsed
	* @方法描述:检查是否被活动使用
	* @参数与返回说明:
	* @算法描述:
	 */
	@GetMapping("checkused")
	public ResultDto<Integer> checkUsed(String tableId){
		LoyRlTableEcName table = loyRlTableEcNameService.selectByPrimaryKey(tableId);
		List<LoyRlActivity> data = loyRlTableEcNameService.getRuleByTrans(table.getTransactionCode());
		return new ResultDto<Integer>(data.size());
	}
	/**
	 * 删除表汉化
	 * @param ids
	 * @return
	 */
	@PostMapping("/deletetab")
	public ResultDto<Map<String, Object>> deleteTab(@RequestBody Map<?,?> map) {
		String tableId = map.get("tableId").toString();
		String orgCode = map.get("orgCode").toString();
		ResultDto<Map<String, Object>> reuslt=new ResultDto<Map<String, Object>>();
		try {
			LoyRlTableEcName table = loyRlTableEcNameService.selectByPrimaryKey(tableId);
			List<LoyRlActivity> data = loyRlTableEcNameService.getRuleByTrans(table.getTransactionCode());
	    	if(data.size()>0) {
	    		reuslt.setCode(200001);
				reuslt.setMessage("该表已被积分活动使用不能删除！");
	    	}else {
	    		loyRlTableEcNameService.deletetab(tableId,orgCode);
	    		reuslt.setCode(0);
	    		reuslt.setMessage("表删除成功！");
	    	}
		}catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
}
