package cn.com.yusys.yscimc.luckdraw.web.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscimc.assemble.domain.CmicAppAssembleCusts;
import cn.com.yusys.yscimc.luckdraw.domain.CimcAppLuckDrawCusts;
import cn.com.yusys.yscimc.luckdraw.repository.mapper.CimcAppLuckDrawCustsMapper;
import cn.com.yusys.yscimc.luckdraw.service.CmicAppLuckDrawService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CmicAppLuckDrawResource
 * @类描述: #资源类
 * @功能描述: 抽奖组件接口 
 * @创建人: zhanghan3
 * @创建时间: 2019-07-04 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmicappluckdraw")
public class CmicAppLuckDrawResource extends CommonResource<CmicAppAssembleCusts, String> {
    @Autowired
    private CmicAppLuckDrawService cmicAppLuckDrawService;

    @Override
    protected CommonService getCommonService() {
        return cmicAppLuckDrawService;
    }
    /**
	 * 
	* @方法名称:getNodeIdByActyid
	* @方法描述:根据nodeId获取抽奖formID
	* @参数与返回说明:nodeId
	* @算法描述:
	 */
    @GetMapping("/getnodeidbyactyid")
    public ResultDto<List<Map<String, Object>>> getNodeIdByActyid(@RequestParam(required = false) String nodeId){
    	return new ResultDto<List<Map<String, Object>>>(cmicAppLuckDrawService.getNodeIdByActyid(nodeId));
    }
    
    /**
	 * 
	* @方法名称:getLuckDraw
	* @方法描述:根据formid查询抽奖信息
	* @参数与返回说明:formId
	* @算法描述:
	 */
    @GetMapping("/getluckdraw")
    public ResultDto<List<Map<String, Object>>> getLuckDraw(@RequestParam(required = false) String formId){
    	return new ResultDto<List<Map<String, Object>>>(cmicAppLuckDrawService.getLuckDraw(formId));
    }
    
    /**
	 * 
	* @方法名称:custInfo
	* @方法描述:根据formid查询参客户信息
	* @参数与返回说明:custId
	* @算法描述:
	 */
    @GetMapping("/custinfo")
    public ResultDto<List<Map<String, Object>>> custInfo(@RequestParam("custId") String custId,@RequestParam("formId") String formId){
    	List<Map<String, Object>> list = cmicAppLuckDrawService.custInfo(custId,formId);
    	if (list == null || list.size() == 0) {
    	// 生成 主键ID
    		Map<String ,Object> dc  = new HashMap<>();
    		String uuid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
    		dc.put("id", uuid);
    		dc.put("custId", custId);
    		dc.put("formId", formId);
    		dc.put("crarDt", new Date());
    		dc.put("luckDrawNum", "10");
//    		dc.setId(uuid);
//    		dc.setCustId(custId);
//    		dc.setFormId(formId);
//    		dc.setCratDt(new Date());
    		cmicAppLuckDrawService.addCustInfo(dc);
    		list.add(dc);
    	}
    	return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
	 * 
	* @方法名称:updateCustInfo
	* @方法描述:保存抽奖历史更新用户抽奖信息
	* @参数与返回说明:formId
	* @算法描述:
	 */
    @GetMapping("/updatecustinfo")
    public ResultDto<List<Map<String, Object>>> updateCustInfo(@RequestParam(required = false) Map<String,Object> model){
    	Map<String , Object> his = new HashMap<>();
    	Map<String , Object> custInfo = new HashMap<>();
    	//抽奖历史表关联ID
    	String drawCustId = (String) model.get("drawCustId");
    	his.put("drawCustId", drawCustId);
    	//奖品ID
    	if(model.get("prizeId") != null && !"".equals(model.get("prizeId"))) {
    		String prizeId = (String) model.get("prizeId");
    		his.put("prizeId", prizeId);
    		his.put("prizeName", model.get("prizeName"));
    	}
    	his.put("cratDt", new Date());
    	String uuid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
    	his.put("id", uuid);
    	cmicAppLuckDrawService.insertHis(his);
    	
    	//客户信息主键ID
    	custInfo.put("id", drawCustId);
    	//剩余抽奖次数
    	CimcAppLuckDrawCusts ld = new CimcAppLuckDrawCusts();
    	String luckDrawNum = (String) model.get("luckDrawNum");
//    	BigDecimal bd=new BigDecimal(luckDrawNum);
//    	custInfo.put("luckDrawNum", bd);
    	custInfo.put("lastChgDt", new Date());
    	cmicAppLuckDrawService.updateCustInfo(drawCustId,luckDrawNum);
//    	ld.setId(drawCustId);
//    	ld.setLastChgDt(new Date());
//    	ld.setLuckDrawNum(bd);
//    	cmicAppLuckDrawService.updateCustInfo(ld);

    	List<Map<String, Object>> list =new ArrayList();
    	Map<String , Object> map = new HashMap<>();
    	map.put("msg", "抽奖成功");
    	list.add(map);
    	return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
	 * 
	* @方法名称:custInfo
	* @方法描述:根据formid查询参与拼团客户信息
	* @参数与返回说明:custId
	* @算法描述:
	 */
    @GetMapping("/wininfo")
    public ResultDto<List<Map<String, Object>>> winInfo(@RequestParam("formId") String formId){
    	List<Map<String, Object>> list = cmicAppLuckDrawService.winInfo(formId);
    	return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
	 * 
	* @方法名称:custInfo
	* @方法描述:根据formid查询参客户信息
	* @参数与返回说明:custId
	* @算法描述:
	 */
    @GetMapping("/divisionupdate")
    public ResultDto<List<Map<String, Object>>> divisionUpdate(@RequestParam("custId") String custId,@RequestParam("formId") String formId){
    	List<Map<String, Object>> cust = cmicAppLuckDrawService.custInfo(custId,formId);
    	Map<String , Object> map = new HashMap<>();
    	if(cust != null && cust.size() != 0) {
    		String id = (String) cust.get(0).get("id");
    		int a = Integer.parseInt(String.valueOf(cust.get(0).get("luckDrawNum")))+1;
    		String luckDrawNum = String.valueOf(a);
    		cmicAppLuckDrawService.updateCustInfo(id, luckDrawNum);
    		map.put("msg", "推荐人客户"+custId+"裂变奖励成功");
    	} else {
    		map.put("msg", "推荐人客户"+custId+"不存在");
    	}
    	List<Map<String, Object>> list =new ArrayList();
    	list.add(map);
    	return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
	 * 
	* @方法名称:displaylist
	* @方法描述:查询素材信息
	* @参数与返回说明:
	* @算法描述:
	 */
 	@GetMapping("/displaylist")
 	public ResultDto<List<Map<String, Object>>> displayList() {
 		return new ResultDto<List<Map<String, Object>>>(cmicAppLuckDrawService.displayList());
 	}
}
