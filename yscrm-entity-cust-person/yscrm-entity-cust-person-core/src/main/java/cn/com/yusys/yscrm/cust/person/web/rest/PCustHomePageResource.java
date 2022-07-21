package cn.com.yusys.yscrm.cust.person.web.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.cust.person.domain.AcrmFciCommAumContriInfo;
import cn.com.yusys.yscrm.cust.person.service.PCustHomePageService;


/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmLevelRateResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 09:58:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pcusthomepage")
public class PCustHomePageResource extends CommonResource<AcrmFciCommAumContriInfo, String> {
    @Autowired
    private PCustHomePageService pCustHomePageService;

    @Override
    protected CommonService getCommonService() {
        return this.pCustHomePageService;
    }
    
    /**
 	 * @方法名称: queryPerCustGradeDist
 	 * @方法描述:AUM占比
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/querypercustgradedist/{custId}")
	public ResultDto<List<Map<String, Object>>> queryPerCustGradeDist(@PathVariable String custId) {
		List<Map<String, Object>> list = pCustHomePageService.queryPerAumContriList(custId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
    
    /**
   	 * @方法名称: queryPerReportList
   	 * @方法描述:贡献度占比
   	 * @参数与返回说明:
   	 * @算法描述:
   	 */
      @GetMapping("/queryperreportlist/{custId}")
  	public ResultDto<List<Map<String, Object>>> queryPerReportList(@PathVariable String custId) {
  		List<Map<String, Object>> list = pCustHomePageService.queryPerReportList(custId);
  		return new ResultDto<List<Map<String, Object>>>(list);
  	}
    /**
 	 * @方法名称: queryDiscountList
 	 * @方法描述:优惠名称
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/querydiscountlist/{custId}")
	public ResultDto<List<Map<String, Object>>> queryDiscountList(@PathVariable String custId) {
		List<Map<String, Object>> list = pCustHomePageService.queryDiscountList(custId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
    /**
   	 * @方法名称: queryProductList
   	 * @方法描述:推荐的产品
   	 * @参数与返回说明:
   	 * @算法描述:
   	 */
      @GetMapping("/queryproductlist/{custId}")
  	public ResultDto<List<Map<String, Object>>> queryProductList(@PathVariable String custId) {
  		List<Map<String, Object>> list = pCustHomePageService.queryProductList(custId);
  		return new ResultDto<List<Map<String, Object>>>(list);
  	}
  /**
 	 * @方法名称: queryProductTagList
 	 * @方法描述:产品标签
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/queryproducttaglist/{custId}")
	public ResultDto<List<Map<String, Object>>> queryProductTagList(@PathVariable String custId) {
		List<Map<String, Object>> list = pCustHomePageService.queryProductTagList(custId);
		List<Map<String, Object>> namelist=new ArrayList<Map<String, Object>>();
		
		if(list.size()!=0) {
			if(list.get(0).get("curre")!=null) {//活期
				if(list.get(0).get("curre").toString().equals("1")){		
					Map<String,Object> curre=new HashMap<String,Object>();
					curre.put("name", "活期");
					curre.put("type", "warning");
					namelist.add(curre);
				}else {
					Map<String,Object> curre=new HashMap<String,Object>();
					curre.put("name", "活期");
					curre.put("type", "gray");
					namelist.add(curre);
				}
			}
			if(list.get(0).get("regular")!=null) {//定期
				if(list.get(0).get("regular").toString().equals("1")){		
					Map<String,Object> regular=new HashMap<String,Object>();
					regular.put("name", "定期");
					regular.put("type", "success");
					namelist.add(regular);
				}else {
					Map<String,Object> regular=new HashMap<String,Object>();
					regular.put("name", "定期");
					regular.put("type", "gray");
					namelist.add(regular);
				}
			}
			if(list.get(0).get("loan")!=null) {//贷款
				if(list.get(0).get("loan").toString().equals("1")){		
					Map<String,Object> loan=new HashMap<String,Object>();
					loan.put("name", "贷款");
					loan.put("type", "primary");
					namelist.add(loan);
				}else {
					Map<String,Object> loan=new HashMap<String,Object>();
					loan.put("name", "贷款");
					loan.put("type", "gray");
					namelist.add(loan);
				}
			}
			if(list.get(0).get("financial")!=null) {//理财
				if(list.get(0).get("financial").toString().equals("1")){		
					Map<String,Object> financial=new HashMap<String,Object>();
					financial.put("name", "理财");
					financial.put("type", "success");
					namelist.add(financial);
				}else {
					Map<String,Object> financial=new HashMap<String,Object>();
					financial.put("name", "理财");
					financial.put("type", "gray");
					namelist.add(financial);
				}
			}
			if(list.get(0).get("insurance")!=null) {//保险
				if(list.get(0).get("insurance").toString().equals("1")){		
					Map<String,Object> insurance=new HashMap<String,Object>();
					insurance.put("name", "保险");
					insurance.put("type", "warning");
					namelist.add(insurance);
				}else {
					Map<String,Object> insurance=new HashMap<String,Object>();
					insurance.put("name", "保险");
					insurance.put("type", "gray");
					namelist.add(insurance);
				}
			}
			if(list.get(0).get("nobleMetal")!=null) {//贵金属
				if(list.get(0).get("nobleMetal").toString().equals("1")){		
					Map<String,Object> nobleMetal=new HashMap<String,Object>();
					nobleMetal.put("name", "贵金属");
					nobleMetal.put("type", "danger");
					namelist.add(nobleMetal);
				}else {
					Map<String,Object> nobleMetal=new HashMap<String,Object>();
					nobleMetal.put("name", "贵金属");
					nobleMetal.put("type", "gray");
					namelist.add(nobleMetal);
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
			if(list.get(0).get("onlineBank")!=null) {//网上银行
				if(list.get(0).get("onlineBank").toString().equals("1")){		
					Map<String,Object> onlineBank=new HashMap<String,Object>();
					onlineBank.put("name", "网上银行");
					onlineBank.put("type", "primary");
					namelist.add(onlineBank);
				}else {
					Map<String,Object> onlineBank=new HashMap<String,Object>();
					onlineBank.put("name", "网上银行");
					onlineBank.put("type", "gray");
					namelist.add(onlineBank);
				}
			}
			if(list.get(0).get("mobileBank")!=null) {//手机银行
				if(list.get(0).get("mobileBank").toString().equals("1")){		
					Map<String,Object> mobileBank=new HashMap<String,Object>();
					mobileBank.put("name", "手机银行");
					mobileBank.put("type", "primary");
					namelist.add(mobileBank);
				}else {
					Map<String,Object> mobileBank=new HashMap<String,Object>();
					mobileBank.put("name", "手机银行");
					mobileBank.put("type", "gray");
					namelist.add(mobileBank);
				}
			}
			if(list.get(0).get("wechatBank")!=null) {
				if(list.get(0).get("wechatBank").toString().equals("1")){		
					Map<String,Object> wechatBank=new HashMap<String,Object>();
					wechatBank.put("name", "微信银行");
					wechatBank.put("type", "success");
					namelist.add(wechatBank);
				}else {
					Map<String,Object> wechatBank=new HashMap<String,Object>();
					wechatBank.put("name", "微信银行");
					wechatBank.put("type", "gray");
					namelist.add(wechatBank);
				}
			}
			if(list.get(0).get("quickPay")!=null) {
				if(list.get(0).get("quickPay").toString().equals("1")){		
					Map<String,Object> quickPay=new HashMap<String,Object>();
					quickPay.put("name", "快捷支付");
					quickPay.put("type", "warning");
					namelist.add(quickPay);
				}else {
					Map<String,Object> quickPay=new HashMap<String,Object>();
					quickPay.put("name", "快捷支付");
					quickPay.put("type", "gray");
					namelist.add(quickPay);
				}
			}
			if(list.get(0).get("telBank")!=null) {
				if(list.get(0).get("telBank").toString().equals("1")){		
					Map<String,Object> telBank=new HashMap<String,Object>();
					telBank.put("name", "电话银行");
					telBank.put("type", "danger");
					namelist.add(telBank);
				}else {
					Map<String,Object> telBank=new HashMap<String,Object>();
					telBank.put("name", "电话银行");
					telBank.put("type", "gray");
					namelist.add(telBank);
				}
			}
//			if(list.get(0).get("telBankTrans")!=null) {//电话银行转账
//				if(list.get(0).get("telBankTrans").toString().equals("1")){		
//					Map<String,Object> telBankTrans=new HashMap<String,Object>();
//					telBankTrans.put("name", "电话银行转账");
//					telBankTrans.put("type", "success");
//					namelist.add(telBankTrans);
//				}else {
//					Map<String,Object> telBankTrans=new HashMap<String,Object>();
//					telBankTrans.put("name", "电话银行转账");
//					telBankTrans.put("type", "gray");
//					namelist.add(telBankTrans);
//				}
//			}
			if(list.get(0).get("message")!=null) {
				if(list.get(0).get("message").toString().equals("1")){		
					Map<String,Object> message=new HashMap<String,Object>();
					message.put("name", "短信");
					message.put("type", "danger");
					namelist.add(message);
				}else {
					Map<String,Object> message=new HashMap<String,Object>();
					message.put("name", "短信");
					message.put("type", "gray");
					namelist.add(message);
				}
			}
			if(list.get(0).get("creditCard")!=null) {//信用卡
				if(list.get(0).get("creditCard").toString().equals("1")){		
					Map<String,Object> creditCard=new HashMap<String,Object>();
					creditCard.put("name", "信用卡");
					creditCard.put("type", "primary");
					namelist.add(creditCard);
				}else {
					Map<String,Object> creditCard=new HashMap<String,Object>();
					creditCard.put("name", "信用卡");
					creditCard.put("type", "gray");
					namelist.add(creditCard);
				}
			}
			if(list.get(0).get("socialSecurityCard")!=null) {
				if(list.get(0).get("socialSecurityCard").toString().equals("1")){		
					Map<String,Object> socialSecurityCard=new HashMap<String,Object>();
					socialSecurityCard.put("name", "社保卡");
					socialSecurityCard.put("type", "success");
					namelist.add(socialSecurityCard);
				}else {
					Map<String,Object> socialSecurityCard=new HashMap<String,Object>();
					socialSecurityCard.put("name", "社保卡");
					socialSecurityCard.put("type", "gray");
					namelist.add(socialSecurityCard);
				}
			}
			if(list.get(0).get("icGoldCard")!=null) {//IC金卡
				if(list.get(0).get("icGoldCard").toString().equals("1")){		
					Map<String,Object> icGoldCard=new HashMap<String,Object>();
					icGoldCard.put("name", "IC金卡");
					icGoldCard.put("type", "warning");
					namelist.add(icGoldCard);
				}else {
					Map<String,Object> icGoldCard=new HashMap<String,Object>();
					icGoldCard.put("name", "IC金卡");
					icGoldCard.put("type", "gray");
					namelist.add(icGoldCard);
				}
			}
//			if(list.get(0).get("houseProFundCard")!=null) {
//				if(list.get(0).get("houseProFundCard").toString().equals("1")){		
//					Map<String,Object> houseProFundCard=new HashMap<String,Object>();
//					houseProFundCard.put("name", "住房公积金卡");
//					houseProFundCard.put("type", "danger");
//					namelist.add(houseProFundCard);
//				}else {
//					Map<String,Object> houseProFundCard=new HashMap<String,Object>();
//					houseProFundCard.put("name", "住房公积金卡");
//					houseProFundCard.put("type", "gray");
//					namelist.add(houseProFundCard);
//				}
//			}
//			if(list.get(0).get("thirdDartyDep")!=null) {//第三方存管
//				if(list.get(0).get("thirdDartyDep").toString().equals("1")){		
//					Map<String,Object> thirdDartyDep=new HashMap<String,Object>();
//					thirdDartyDep.put("name", "第三方存管");
//					thirdDartyDep.put("type", "success");
//					namelist.add(thirdDartyDep);
//				}else {
//					Map<String,Object> thirdDartyDep=new HashMap<String,Object>();
//					thirdDartyDep.put("name", "第三方存管");
//					thirdDartyDep.put("type", "gray");
//					namelist.add(thirdDartyDep);
//				}
//			}
			if(list.get(0).get("ledoTreasure")!=null) {
				if(list.get(0).get("ledoTreasure").toString().equals("1")){		
					Map<String,Object> ledoTreasure=new HashMap<String,Object>();
					ledoTreasure.put("name", "智能存款");
					ledoTreasure.put("type", "primary");
					namelist.add(ledoTreasure);
				}else {
					Map<String,Object> ledoTreasure=new HashMap<String,Object>();
					ledoTreasure.put("name", "智能存款");
					ledoTreasure.put("type", "gray");
					namelist.add(ledoTreasure);
				}
			}
			if(list.get(0).get("certificateDeposit")!=null) {//大额存单
				if(list.get(0).get("certificateDeposit").toString().equals("1")){		
					Map<String,Object> certificateDeposit=new HashMap<String,Object>();
					certificateDeposit.put("name", "大额存单");
					certificateDeposit.put("type", "success");
					namelist.add(certificateDeposit);
				}else {
					Map<String,Object> certificateDeposit=new HashMap<String,Object>();
					certificateDeposit.put("name", "大额存单");
					certificateDeposit.put("type", "gray");
					namelist.add(certificateDeposit);
				}
			}
			
		}
		return new ResultDto<List<Map<String, Object>>>(namelist);
	}
   /**
     	 * @方法名称: queryVisitlist
     	 * @方法描述:接触信息
     	 * @参数与返回说明:
     	 * @算法描述:
     	 */
    @GetMapping("/queryvisitlist/{custId}")
	public ResultDto<List<Map<String, Object>>> queryVisitlist(@PathVariable String custId) {
		List<Map<String, Object>> list = pCustHomePageService.queryVisitlist(custId);
		if(list.size()==0) {
			Map<String, Object>  map=new 	HashMap<String, Object>();
			map.put("visitTypeName", "");
			map.put("visitStartDate", "");
			map.put("visitorName", "");
			list.add(map);
		}
		return new ResultDto<List<Map<String, Object>>>(list);
	}
    /**
 	 * @方法名称: getPerCustTrend
 	 * @方法描述: 业务汇总月趋势图路径
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @SuppressWarnings("rawtypes")
	@GetMapping("/queryperbussmonsum/{custId}")
	public ResultDto<Map<String, Object>> queryPerBussMonSum(@PathVariable String custId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xaxis", this.pCustHomePageService.getXaxisMonArray(custId));
		Map resultMap = this.pCustHomePageService.queryPerBussMonSum(custId);
		map.put("aum1", resultMap.get("aum1"));
		
		map.put("aum2", resultMap.get("aum2"));
		map.put("aum3", resultMap.get("aum3"));
		map.put("aum4", resultMap.get("aum4"));
		map.put("aum5", resultMap.get("aum5"));
		
		map.put("aum6", resultMap.get("aum6"));
		map.put("aum7", resultMap.get("aum7"));
		map.put("aum8", resultMap.get("aum8"));
		map.put("aum13", resultMap.get("aum13"));
		
		map.put("aum9", resultMap.get("aum9"));
		map.put("aum10", resultMap.get("aum10"));
		
		map.put("aum11", resultMap.get("aum11"));
		map.put("aum12", resultMap.get("aum12"));
	
		
		return new ResultDto<Map<String, Object>>(map);
	}
    /**
 	 * @方法名称: queryPerBussSum
 	 * @方法描述:存贷理信息
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
	 @GetMapping("/queryperbusssum/{custId}")
	public ResultDto<Map<String, Object>> queryPerBussSum(@PathVariable String custId) {
		//List<Map<String, Object>> list = pCustHomePageService.queryPerBussSum(custId);
		//return new ResultDto<List<Map<String, Object>>>(list);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xaxis", this.pCustHomePageService.getXaxisArray(custId));
		Map resultMap = this.pCustHomePageService.queryPerBussSum(custId);
		map.put("aum1", resultMap.get("aum1"));
		map.put("aum2", resultMap.get("aum2"));
		map.put("aum3", resultMap.get("aum3"));
		
		map.put("aum4", resultMap.get("aum4"));
		map.put("aum5", resultMap.get("aum5"));
		map.put("aum6", resultMap.get("aum6"));
		
		map.put("aum7", resultMap.get("aum7"));
		map.put("aum8", resultMap.get("aum8"));
		map.put("aum9", resultMap.get("aum9"));
		
	
	
		
		return new ResultDto<Map<String, Object>>(map);
	}
   
}
