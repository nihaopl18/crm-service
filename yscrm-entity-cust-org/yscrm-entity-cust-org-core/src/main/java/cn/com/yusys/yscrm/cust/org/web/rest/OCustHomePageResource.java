package cn.com.yusys.yscrm.cust.org.web.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgHoldPro;
import cn.com.yusys.yscrm.cust.org.service.OCustHomePageService;

/**
 * @项目名称: yscrm-entity-cust-org-core模块
 * @类名称: AcrmFciOrgHoldProResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-22 14:59:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocusthomepage")
public class OCustHomePageResource extends CommonResource<AcrmFciOrgHoldPro, String> {
    @Autowired
    private OCustHomePageService oCustHomePageService;

    @Override
    protected CommonService getCommonService() {
        return this.oCustHomePageService;
    }
    /**
 	 * @方法名称: queryProductTagList
 	 * @方法描述:产品标签
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/queryorgproducttaglist/{custId}")
	public ResultDto<List<Map<String, Object>>> queryOrgProductTagList(@PathVariable String custId) {
		List<Map<String, Object>> list = oCustHomePageService.queryOProductTagList(custId);
		List<Map<String, Object>> namelist=new ArrayList<Map<String, Object>>();
		
		if(list.size()!=0) {
			if(list.get(0).get("basicHou")!=null) {//基本户
				if(list.get(0).get("basicHou").toString().equals("1")){		
					Map<String,Object> basicHou=new HashMap<String,Object>();
					basicHou.put("name", "活期存款");
					basicHou.put("type", "warning");
					namelist.add(basicHou);
				}else {
					Map<String,Object> basicHou=new HashMap<String,Object>();
					basicHou.put("name", "活期存款");
					basicHou.put("type", "gary");
					namelist.add(basicHou);
				}
			}
			if(list.get(0).get("regDep")!=null) {//定期存款
				if(list.get(0).get("regDep").toString().equals("1")){		
					Map<String,Object> regDep=new HashMap<String,Object>();
					regDep.put("name", "定期存款");
					regDep.put("type", "danger");
					namelist.add(regDep);
				}else {
					Map<String,Object> regDep=new HashMap<String,Object>();
					regDep.put("name", "定期存款");
					regDep.put("type", "gray");
					namelist.add(regDep);
				}
			}
			if(list.get(0).get("altPayroll")!=null) {//代发工资
				if(list.get(0).get("altPayroll").toString().equals("1")){		
					Map<String,Object> altPayroll=new HashMap<String,Object>();
					altPayroll.put("name", "代发工资");
					altPayroll.put("type", "primary");
					namelist.add(altPayroll);
				}else {
					Map<String,Object> altPayroll=new HashMap<String,Object>();
					altPayroll.put("name", "代发工资");
					altPayroll.put("type", "gray");
					namelist.add(altPayroll);
				}
			}
			if(list.get(0).get("genLoans")!=null) {//一般贷款
				if(list.get(0).get("genLoans").toString().equals("1")){		
					Map<String,Object> genLoans=new HashMap<String,Object>();
					genLoans.put("name", "一般贷款");
					genLoans.put("type", "success");
					namelist.add(genLoans);
				}else {
					Map<String,Object> genLoans=new HashMap<String,Object>();
					genLoans.put("name", "一般贷款");
					genLoans.put("type", "gray");
					namelist.add(genLoans);
				}
			}
			if(list.get(0).get("bankAcc")!=null) {//银承
				if(list.get(0).get("bankAcc").toString().equals("1")){		
					Map<String,Object> bankAcc=new HashMap<String,Object>();
					bankAcc.put("name", "银承");
					bankAcc.put("type", "warning");
					namelist.add(bankAcc);
				}else {
					Map<String,Object> bankAcc=new HashMap<String,Object>();
					bankAcc.put("name", "银承");
					bankAcc.put("type", "gray");
					namelist.add(bankAcc);
				}
			}
			if(list.get(0).get("discount")!=null) {//贴现
				if(list.get(0).get("discount").toString().equals("1")){		
					Map<String,Object> discount=new HashMap<String,Object>();
					discount.put("name", "贴现");
					discount.put("type", "danger");
					namelist.add(discount);
				}else {
					Map<String,Object> discount=new HashMap<String,Object>();
					discount.put("name", "贴现");
					discount.put("type", "gray");
					namelist.add(discount);
				}
			}
			if(list.get(0).get("factoring")!=null) {//保理
				if(list.get(0).get("factoring").toString().equals("1")){		
					Map<String,Object> factoring=new HashMap<String,Object>();
					factoring.put("name", "保理");
					factoring.put("type", "success");
					namelist.add(factoring);
				}else {
					Map<String,Object> factoring=new HashMap<String,Object>();
					factoring.put("name", "保理");
					factoring.put("type", "gray");
					namelist.add(factoring);
				}
			}
			if(list.get(0).get("letOfGua")!=null) {//保函
				if(list.get(0).get("letOfGua").toString().equals("1")){		
					Map<String,Object> letOfGua=new HashMap<String,Object>();
					letOfGua.put("name", "保函");
					letOfGua.put("type", "warning");
					namelist.add(letOfGua);
				}else {
					Map<String,Object> letOfGua=new HashMap<String,Object>();
					letOfGua.put("name", "保函");
					letOfGua.put("type", "gray");
					namelist.add(letOfGua);
				}
			}
			if(list.get(0).get("creCer")!=null) {//信用证
				if(list.get(0).get("creCer").toString().equals("1")){		
					Map<String,Object> creCer=new HashMap<String,Object>();
					creCer.put("name", "信用证");
					creCer.put("type", "primary");
					namelist.add(creCer);
				}else {
					Map<String,Object> creCer=new HashMap<String,Object>();
					creCer.put("name", "信用证");
					creCer.put("type", "gray");
					namelist.add(creCer);
				}
			}
			if(list.get(0).get("natKnot")!=null) {
				if(list.get(0).get("natKnot").toString().equals("1")){		
					Map<String,Object> natKnot=new HashMap<String,Object>();
					natKnot.put("name", "国结");
					natKnot.put("type", "success");
					namelist.add(natKnot);
				}else {
					Map<String,Object> natKnot=new HashMap<String,Object>();
					natKnot.put("name", "国结");
					natKnot.put("type", "gray");
					namelist.add(natKnot);
				}
			}
			if(list.get(0).get("financial")!=null) {
				if(list.get(0).get("financial").toString().equals("1")){		
					Map<String,Object> financial=new HashMap<String,Object>();
					financial.put("name", "理财");
					financial.put("type", "warning");
					namelist.add(financial);
				}else {
					Map<String,Object> financial=new HashMap<String,Object>();
					financial.put("name", "理财");
					financial.put("type", "gray");
					namelist.add(financial);
				}
			}
			if(list.get(0).get("insurance")!=null) {
				if(list.get(0).get("insurance").toString().equals("1")){		
					Map<String,Object> insurance=new HashMap<String,Object>();
					insurance.put("name", "保险");
					insurance.put("type", "danger");
					namelist.add(insurance);
				}else {
					Map<String,Object> insurance=new HashMap<String,Object>();
					insurance.put("name", "保险");
					insurance.put("type", "gray");
					namelist.add(insurance);
				}
			}
			if(list.get(0).get("fund")!=null) {//基金
				if(list.get(0).get("fund").toString().equals("1")){		
					Map<String,Object> fund=new HashMap<String,Object>();
					fund.put("name", "基金");
					fund.put("type", "success");
					namelist.add(fund);
				}else {
					Map<String,Object> fund=new HashMap<String,Object>();
					fund.put("name", "基金");
					fund.put("type", "gray");
					namelist.add(fund);
				}
			}
			if(list.get(0).get("preMet")!=null) {
				if(list.get(0).get("preMet").toString().equals("1")){		
					Map<String,Object> preMet=new HashMap<String,Object>();
					preMet.put("name", "贵金属");
					preMet.put("type", "warning");
					namelist.add(preMet);
				}else {
					Map<String,Object> preMet=new HashMap<String,Object>();
					preMet.put("name", "贵金属");
					preMet.put("type", "gray");
					namelist.add(preMet);
				}
			}
			if(list.get(0).get("onlBankSer")!=null) {//网银
				if(list.get(0).get("onlBankSer").toString().equals("1")){		
					Map<String,Object> onlBankSer=new HashMap<String,Object>();
					onlBankSer.put("name", "网银");
					onlBankSer.put("type", "primary");
					namelist.add(onlBankSer);
				}else {
					Map<String,Object> onlBankSer=new HashMap<String,Object>();
					onlBankSer.put("name", "网银");
					onlBankSer.put("type", "gray");
					namelist.add(onlBankSer);
				}
			}
			if(list.get(0).get("teleBank")!=null) {
				if(list.get(0).get("teleBank").toString().equals("1")){		
					Map<String,Object> teleBank=new HashMap<String,Object>();
					teleBank.put("name", "电话银行");
					teleBank.put("type", "success");
					namelist.add(teleBank);
				}else {
					Map<String,Object> teleBank=new HashMap<String,Object>();
					teleBank.put("name", "电话银行");
					teleBank.put("type", "gray");
					namelist.add(teleBank);
				}
			}
			if(list.get(0).get("sms")!=null) {//短信
				if(list.get(0).get("sms").toString().equals("1")){		
					Map<String,Object> sms=new HashMap<String,Object>();
					sms.put("name", "短信");
					sms.put("type", "warning");
					namelist.add(sms);
				}else {
					Map<String,Object> sms=new HashMap<String,Object>();
					sms.put("name", "短信");
					sms.put("type", "gray");
					namelist.add(sms);
				}
			}
			if(list.get(0).get("posMac")!=null) {
				if(list.get(0).get("posMac").toString().equals("1")){		
					Map<String,Object> posMac=new HashMap<String,Object>();
					posMac.put("name", "POS机");
					posMac.put("type", "danger");
					namelist.add(posMac);
				}else {
					Map<String,Object> posMac=new HashMap<String,Object>();
					posMac.put("name", "POS机");
					posMac.put("type", "gray");
					namelist.add(posMac);
				}
			}
			if(list.get(0).get("caizhiBao")!=null) {//财智宝
				if(list.get(0).get("caizhiBao").toString().equals("1")){		
					Map<String,Object> caizhiBao=new HashMap<String,Object>();
					caizhiBao.put("name", "财智宝");
					caizhiBao.put("type", "success");
					namelist.add(caizhiBao);
				}else {
					Map<String,Object> caizhiBao=new HashMap<String,Object>();
					caizhiBao.put("name", "财智宝");
					caizhiBao.put("type", "gray");
					namelist.add(caizhiBao);
				}
			}
			if(list.get(0).get("largeCer")!=null) {
				if(list.get(0).get("largeCer").toString().equals("1")){		
					Map<String,Object> largeCer=new HashMap<String,Object>();
					largeCer.put("name", "大额存单");
					largeCer.put("type", "primary");
					namelist.add(largeCer);
				}else {
					Map<String,Object> largeCer=new HashMap<String,Object>();
					largeCer.put("name", "大额存单");
					largeCer.put("type", "gray");
					namelist.add(largeCer);
				}
			}
		
			
		}
		return new ResultDto<List<Map<String, Object>>>(namelist);
	}
    /**
   	 * @方法名称: getPerCustTrend
   	 * @方法描述: 柱形图路径
   	 * @参数与返回说明:
   	 * @算法描述:
   	 */
      @SuppressWarnings("rawtypes")
  	@GetMapping("/queryorgbusssum/{custId}")
  	public ResultDto<Map<String, Object>> queryOrgBussSum(@PathVariable String custId) {
  		Map<String, Object> map = new HashMap<String, Object>();
  		map.put("xaxis", this.oCustHomePageService.getBussXaxisArray(custId));
  		Map resultMap = this.oCustHomePageService.getOrgBussSumList(custId);
  		map.put("aum1", resultMap.get("aum1"));
  		map.put("aum2", resultMap.get("aum2"));
  		map.put("aum3", resultMap.get("aum3"));
  		map.put("aum4", resultMap.get("aum4"));
  		map.put("aum5", resultMap.get("aum5"));
  		map.put("aum6", resultMap.get("aum6"));
  		map.put("aum7", resultMap.get("aum7"));
  		map.put("aum8", resultMap.get("aum8"));
  		map.put("aum9", resultMap.get("aum9"));
  		map.put("aum10", resultMap.get("aum10"));
  		map.put("aum11", resultMap.get("aum11"));
  		/*
  		map.put("aum12", resultMap.get("aum12"));
  		map.put("aum13", resultMap.get("aum13"));*/
  		
  		return new ResultDto<Map<String, Object>>(map);
  	}
      /**
     	 * @方法名称: queryOrgMonBussSum
     	 * @方法描述: 趋势图路径
     	 * @参数与返回说明:
     	 * @算法描述:
     	 */
        @SuppressWarnings("rawtypes")
    	@GetMapping("/queryorgmonbusssum/{custId}")
    	public ResultDto<Map<String, Object>> queryOrgMonBussSum(@PathVariable String custId) {
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("xaxis", this.oCustHomePageService.getBussMonXaxisArray(custId));
    		Map resultMap = this.oCustHomePageService.getOrgBussMonSumList(custId);
    		map.put("aum1", resultMap.get("aum1"));
    		map.put("aum2", resultMap.get("aum2"));
    		map.put("aum3", resultMap.get("aum3"));
    		map.put("aum4", resultMap.get("aum4"));
    		map.put("aum5", resultMap.get("aum5"));
    		map.put("aum6", resultMap.get("aum6"));
    		map.put("aum7", resultMap.get("aum7"));
    		map.put("aum8", resultMap.get("aum8"));
    		map.put("aum9", resultMap.get("aum9"));
    		map.put("aum10", resultMap.get("aum10"));
    		map.put("aum11", resultMap.get("aum11"));
    		map.put("aum12", resultMap.get("aum12"));
    		map.put("aum13", resultMap.get("aum13"));
    		
    		return new ResultDto<Map<String, Object>>(map);
    	}
        /**
     	 * @方法名称: queryOrgReportList
     	 * @方法描述:贡献度占比
     	 * @参数与返回说明:
     	 * @算法描述:
     	 */
        @GetMapping("/queryorgreportlist/{custId}")
    	public ResultDto<List<Map<String, Object>>> queryOrgReportList(@PathVariable String custId) {
    		List<Map<String, Object>> list = oCustHomePageService.queryOrgReportList(custId);
    		return new ResultDto<List<Map<String, Object>>>(list);
    	}
        /**
       	 * @方法名称: queryBussList
       	 * @方法描述:业务汇总
       	 * @参数与返回说明:
       	 * @算法描述:
       	 */
          @GetMapping("/querybussList/{custId}")
      	public ResultDto<List<Map<String, Object>>> queryBussList(@PathVariable String custId) {
      		List<Map<String, Object>> list = oCustHomePageService.queryBussList(custId);
      		if(list.size()==0) {
    			Map<String, Object>  map=new 	HashMap<String, Object>();
    			map.put("loanBal", "");
    			map.put("silverDiscount", "");
    			map.put("disGuaranTick", "");
    			map.put("finFactInvoice", "");
    			map.put("finUnderImpExp", "");
    			map.put("totalLiaState", "");
    			map.put("unpaidBankAccBill", "");
    			map.put("unpaidLc", "");
    			map.put("unpaidSblc", "");
    			map.put("unpaidGuar", "");
    			map.put("unpaidForExcg", "");
    			map.put("offBalSheet", "");
    			map.put("creditLine", "");
    			map.put("creditDate", "");
    			map.put("availCredit", "");
    			map.put("riskLevel", "");
    			
    			list.add(map);
    		}
      		return new ResultDto<List<Map<String, Object>>>(list);
      	}
}
