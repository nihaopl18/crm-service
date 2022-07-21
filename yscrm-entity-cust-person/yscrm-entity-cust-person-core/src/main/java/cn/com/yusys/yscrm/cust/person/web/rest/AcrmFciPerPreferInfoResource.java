package cn.com.yusys.yscrm.cust.person.web.rest;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerPreferInfo;
import cn.com.yusys.yscrm.cust.person.service.AcrmFciPerPreferInfoService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;


/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFciPerPreferInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 20:34:06
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfciperpreferinfo")
public class AcrmFciPerPreferInfoResource extends CommonResource<AcrmFciPerPreferInfo, String> {
    @Autowired
    private AcrmFciPerPreferInfoService acrmFciPerPreferInfoService;

    @Override
    protected CommonService getCommonService() {
        return this.acrmFciPerPreferInfoService;
    }
    @Autowired
   	private UaaClient uaaClient;
    
    @GetMapping("/queryperprelist/{custId}") 
    public ResultDto<List<Map<Object, String>>> queryPerpreList(QueryModel model,@PathVariable String custId){
    	List<Map<Object, String>> list = acrmFciPerPreferInfoService.getPerpreList(model,custId);
		return new ResultDto<List<Map<Object, String>>>(list);
    }
    @PostMapping("/updateperpre")
	public ResultDto<Integer> updatePerpre(@RequestBody Map c) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		String orgCode = dto.getBody().getOrg().getCode();
		String loginCode=dto.getBody().getLoginCode();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String currDate=df.format(new Date());// new Date()为获取当前系统时间
		ResultDto<Integer> resultDto = null;
		AcrmFciPerPreferInfo acrmFciPerPreferInfo=new AcrmFciPerPreferInfo();
		String custId="";
		String id="";
		int perprecode=0;
		

		if(c.get("custId")!=null) {
			custId=c.get("custId").toString();
			acrmFciPerPreferInfo.setCustId(custId);
		}
		if(c.get("chnCd")!=null) {//电子渠道
		
		    String chnCdStr=c.get("chnCd").toString().replace("[", "");
		    String chnCd=chnCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setChnCd(chnCd.replace("]", ""));
		
		}
		if(c.get("chnOth")!=null) {//其他
			
		    String chnOth=c.get("chnOth").toString();
			acrmFciPerPreferInfo.setChnOth(chnOth);
		}
		if(c.get("invCd")!=null) {//喜好投资类型
			 String invCdStr=c.get("invCd").toString().replace("[", "");
			 String invCd=invCdStr.replace(" ", "");//去除空格
			 acrmFciPerPreferInfo.setInvCd(invCd.replace("]", ""));
		}
		if(c.get("invOth")!=null) {//其他
			String invOth=c.get("invOth").toString();
			acrmFciPerPreferInfo.setInvOth(invOth);
		}
		if(c.get("consBrandCd")!=null) {//喜好品牌类型
			String	consBrandCdStr=c.get("consBrandCd").toString().replace("[", "");
			String consBrandCd=consBrandCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setConsBrandCd(consBrandCd.replace("]", ""));
		}
		if(c.get("consOth")!=null) {//其他
			String	consOth=c.get("consOth").toString();
			acrmFciPerPreferInfo.setConsOth(consOth);
		}
		if(c.get("finAdviCd")!=null) {//理财服务
			String finAdviCdStr=c.get("finAdviCd").toString().replace("[", "");
			String finAdviCd=finAdviCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setFinAdviCd(finAdviCd.replace("]", ""));
		}
		if(c.get("finOth")!=null) {//其他
			String finOth=c.get("finOth").toString();
			acrmFciPerPreferInfo.setFinOth(finOth);
		}
		if(c.get("contCd")!=null) {//理财经理的联系方式
			String contCdStr=c.get("contCd").toString().replace("[", "");
			String contCd=contCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setContCd(contCd.replace("]", ""));
		}
		if(c.get("contOth")!=null) {//其他
			String contOth=c.get("contOth").toString();
			acrmFciPerPreferInfo.setContOth(contOth);
		}
		if(c.get("saloCd")!=null) {//沙龙活动
			String saloCdStr=c.get("saloCd").toString().replace("[", "");
			String saloCd=saloCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setSaloCd(saloCd.replace("]", ""));
		}
		if(c.get("saloOth")!=null) {//其他
			String saloOth=c.get("saloOth").toString();
			acrmFciPerPreferInfo.setSaloOth(saloOth);
		}
		if(c.get("hobbCd")!=null) {//兴趣爱好
			String hobbCdStr=c.get("hobbCd").toString().replace("[", "");
			String hobbCd=hobbCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setHobbCd(hobbCd.replace("]", ""));
		}
		if(c.get("hobbOth")!=null) {//其他
			String hobbOth=c.get("hobbOth").toString();
			acrmFciPerPreferInfo.setHobbOth(hobbOth);
		}
		if(c.get("contTimeCd")!=null) {//联系的时间
			String contTimeCdStr=c.get("contTimeCd").toString().replace("[", "");
			String contTimeCd=contTimeCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setContTimeCd(contTimeCd.replace("]", ""));
		}
		if(c.get("invTermCd")!=null) {//投资周期
			String invTermCdStr=c.get("invTermCd").toString().replace("[", "");
			String invTermCd=invTermCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setInvTermCd(invTermCd.replace("]", ""));
		}
		if(c.get("faithCd")!=null) {//其他信息
			String faithCd=c.get("faithCd").toString();
			acrmFciPerPreferInfo.setFaithCd(faithCd);
		}
		if(c.get("taboo")!=null) {//其他信息
			String taboo=c.get("taboo").toString();
			acrmFciPerPreferInfo.setTaboo(taboo);
		}
		if(c.get("specNeed")!=null) {//其他信息
			String specNeed=c.get("specNeed").toString();
			acrmFciPerPreferInfo.setSpecNeed(specNeed);
		}
		if(c.get("remarks")!=null) {//其他信息
			String remarks=c.get("remarks").toString();
			acrmFciPerPreferInfo.setRemarks(remarks);
		}
		
		if(c.get("finBusiCd")!=null) {//金融业务
			String finBusiCdStr=c.get("finBusiCd").toString().replace("[", "");
			String finBusiCd=finBusiCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setFinBusiCd(finBusiCd.replace("]", "").trim());
		}
		if(c.get("finBusiOth")!=null) {//其他
			String finBusiOth=c.get("finBusiOth").toString();
			acrmFciPerPreferInfo.setFinBusiOth(finBusiOth);
		}
		if(c.get("arderCd")!=null) {//休闲类型
			String arderCdStr=c.get("arderCd").toString().replace("[", "");
			String arderCd=arderCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setArderCd(arderCd.replace("]", ""));
		}
		if(c.get("arderOth")!=null) {//其他
			String arderOth=c.get("arderOth").toString();
			acrmFciPerPreferInfo.setArderOth(arderOth);
		}
		if(c.get("mediaCd")!=null) {//媒体类型
			String mediaCdStr=c.get("mediaCd").toString().replace("[", "");
			String mediaCd=mediaCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setMediaCd(mediaCd.replace("]", ""));
		}
		if(c.get("mediaOth")!=null) {//其他
			String mediaOth=c.get("mediaOth").toString();
			acrmFciPerPreferInfo.setMediaOth(mediaOth);
		}
		if(c.get("sportCd")!=null) {//运动类型
			String sportCdStr=c.get("sportCd").toString().replace("[", "");
			String sportCd=sportCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setSportCd(sportCd.replace("]", ""));
		}
		if(c.get("sportOth")!=null) {//其他
			String sportOth=c.get("sportOth").toString();
			acrmFciPerPreferInfo.setSportOth(sportOth);
		}
		if(c.get("magazCd")!=null) {//杂志类型
			String magazCdStr=c.get("magazCd").toString().replace("[", "");
			String magazCd=magazCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setMagazCd(magazCd.replace("]", ""));
		}
		if(c.get("magazOth")!=null) {//其他
			String magazOth=c.get("magazOth").toString();
			acrmFciPerPreferInfo.setMagazOth(magazOth);
		}
		if(c.get("tvshowCd")!=null) {//电视节目类型
			String tvshowCdStr=c.get("tvshowCd").toString().replace("[", "");
			String tvshowCd=tvshowCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setTvshowCd(tvshowCd.replace("]", ""));
		}
		if(c.get("tvshowOth")!=null) {//其他
			String tvshowOth=c.get("tvshowOth").toString();
			acrmFciPerPreferInfo.setTvshowOth(tvshowOth);
		}
		if(c.get("petCd")!=null) {//宠物类型
			String petCdStr=c.get("petCd").toString().replace("[", "");
			String petCd=petCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setPetCd(petCd.replace("]", ""));
		}
		if(c.get("petOth")!=null) {//其他
			String petOth=c.get("petOth").toString();
			acrmFciPerPreferInfo.setPetOth(petOth);
		}
		if(c.get("collCd")!=null) {//收藏类型
			String collCdStr=c.get("collCd").toString().replace("[", "");
			String collCd=collCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setCollCd(collCd.replace("]", ""));
		}
		if(c.get("collOth")!=null) {//其他
			String collOth=c.get("collOth").toString();
			acrmFciPerPreferInfo.setCollOth(collOth);
		}
		if(c.get("consCd")!=null) {//消费习惯
			String consCdStr=c.get("consCd").toString().replace("[", "");
			String consCd=consCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setConsCd(consCd.replace("]", ""));
		}
		if(c.get("consChnCd")!=null) {//消费渠道
			String consChnCdStr=c.get("consChnCd").toString().replace("[", "");
			String consChnCd=consChnCdStr.replace(" ", "");//去除空格
			acrmFciPerPreferInfo.setConsChnCd(consChnCd.replace("]", ""));
		}
		QueryModel querymodel=new QueryModel();
		List<Map<Object, String>> list = acrmFciPerPreferInfoService.getPerpreList(querymodel,custId);
		
		if(list.size()!=0) {//修改
			acrmFciPerPreferInfo.setLastChgSys("CRM");
//			acrmFciPerPreferInfo.setId(list.get(0).get("id"));
			//acrmFciPerPreferInfo.setLastChgDt(currDate);
			acrmFciPerPreferInfo.setLastChgUsr(loginCode);
			perprecode=acrmFciPerPreferInfoService.updateperpre(acrmFciPerPreferInfo);
		}else {//新增
			acrmFciPerPreferInfo.setLastChgSys("CRM");
			//acrmFciPerPreferInfo.setLastChgDt(currDate);
			acrmFciPerPreferInfo.setLastChgUsr(loginCode);
			perprecode=	acrmFciPerPreferInfoService.insertperpre(acrmFciPerPreferInfo);
		}
	

	    if(perprecode!=0) {
	     	resultDto = new ResultDto<Integer>();
	 		resultDto.setMessage("操作成功");
	 		resultDto.setCode(0);
	    }
			return resultDto;	
		}
}
