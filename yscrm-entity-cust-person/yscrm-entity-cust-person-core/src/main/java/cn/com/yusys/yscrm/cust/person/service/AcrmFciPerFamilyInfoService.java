package cn.com.yusys.yscrm.cust.person.service;



import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerFamilyInfo;
import cn.com.yusys.yscrm.cust.person.repository.mapper.AcrmFciPerFamilyInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFciPerFamilyInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-29 10:39:35
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciPerFamilyInfoService extends CommonService {
    @Autowired
    private AcrmFciPerFamilyInfoMapper acrmFciPerFamilyInfoMapper;
	private static final String CUST_ID = "custId";
	private static final String POPU_NUM = "popuNum";
	private static final String LABOR_NUM = "laborNum";
	private static final String LAST_CHG_SYS = "lastChgSys";
	private static final String LAST_CHG_USR = "lastChgUsr";
	private static final String CORP_ORG_CODE = "corpOrgCode";

	@Override
    protected CommonMapper<?> getMapper() {
        return this.acrmFciPerFamilyInfoMapper;
    }
	@Transactional(readOnly = true) 
	public List<Map<Object, String>> getFamilyList(QueryModel model,String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put(CUST_ID, custId);
		// TODO 自动生成的方法存根
		return acrmFciPerFamilyInfoMapper.getFamilyList(paramMap);
	}
	// 基本信息修改
	public int updatebaseInfo(Map c) {
		AcrmFciPerFamilyInfo acrmFciPerFamilyInfo=new AcrmFciPerFamilyInfo();
//		if(c.get(CUST_ID)!=null) {
//			acrmFciPerFamilyInfo.setCustId(c.get(CUST_ID).toString());
//		}
		if(c.get(CUST_ID)!=null) {
			acrmFciPerFamilyInfo.setCustId(c.get(CUST_ID).toString());
		}
		if(c.get("householderName")!=null) {
			acrmFciPerFamilyInfo.setHouseholderName(c.get("householderName").toString());
		}
		if(c.get(POPU_NUM)!=null&&!c.get(POPU_NUM).equals("")) {
			String popuNumStr=c.get(POPU_NUM).toString();
	    	BigDecimal bd=new BigDecimal(popuNumStr);
			acrmFciPerFamilyInfo.setPopuNum(bd);
		}
		if(c.get("famAddr")!=null) {
			acrmFciPerFamilyInfo.setFamAddr(c.get("famAddr").toString());
		}
		if(c.get("countAreaCd")!=null) {
			acrmFciPerFamilyInfo.setCountAreaCd(c.get("countAreaCd").toString());
		}
		if(c.get(LABOR_NUM)!=null&&!c.get(LABOR_NUM).equals("")) {
			String laborNumStr=c.get(LABOR_NUM).toString();
	    	BigDecimal bd=new BigDecimal(laborNumStr);
			acrmFciPerFamilyInfo.setLaborNum(bd);
		}
		if(c.get("itemAndScal")!=null) {
			acrmFciPerFamilyInfo.setItemAndScal(c.get("itemAndScal").toString());
		}
		if(c.get("homeTelNo")!=null) {
			acrmFciPerFamilyInfo.setHomeTelNo(c.get("homeTelNo").toString());
		}
		
		if(c.get(LAST_CHG_SYS)!=null) {
			acrmFciPerFamilyInfo.setLastChgSys(c.get(LAST_CHG_SYS).toString());
		}
		if(c.get(LAST_CHG_USR)!=null) {
			acrmFciPerFamilyInfo.setLastChgUsr(c.get(LAST_CHG_USR).toString());
		}
		if(c.get(CORP_ORG_CODE)!=null) {
			acrmFciPerFamilyInfo.setCorpOrgCode(c.get(CORP_ORG_CODE).toString());
		}
		acrmFciPerFamilyInfo.setLastChgDt(new Date());
		if(c.get("lastChgDt")==null) {
			return this.insertSelective(acrmFciPerFamilyInfo);
		}
		return this.updateSelective(acrmFciPerFamilyInfo);
	}
	// 更多信息修改
	public int updatemoreInfo(Map c,int basecode) {
		AcrmFciPerFamilyInfo acrmFciPerFamilyInfo=new AcrmFciPerFamilyInfo();
//		if(c.get("id")!=null) {
//			acrmFciPerFamilyInfo.setId(c.get("id").toString());
//		}
		if(c.get(CUST_ID)!=null) {
			acrmFciPerFamilyInfo.setCustId(c.get(CUST_ID).toString());
		}
		if(c.get("famBadRec")!=null) {
			acrmFciPerFamilyInfo.setFamBadRec(c.get("famBadRec").toString());
		}
		
		if(c.get("creditAmt")!=null &&!c.get("creditAmt").equals("")) {
			String creditAmtStr=c.get("creditAmt").toString();
	    	BigDecimal bd=new BigDecimal(creditAmtStr);
			acrmFciPerFamilyInfo.setCreditAmt(bd);
		}
		if(c.get("houseStat")!=null) {
			acrmFciPerFamilyInfo.setHouseStat(c.get("houseStat").toString());
		}
		if(c.get("carFlg")!=null) {
			acrmFciPerFamilyInfo.setCarFlg(c.get("carFlg").toString());
		}
		if(c.get("plateNo1")!=null) {
			acrmFciPerFamilyInfo.setPlateNo1(c.get("plateNo1").toString());
		}
		if(c.get("plateNo2")!=null) {
			acrmFciPerFamilyInfo.setPlateNo2(c.get("plateNo2").toString());
		}
		if(c.get("plateNo3")!=null) {
			acrmFciPerFamilyInfo.setPlateNo3(c.get("plateNo3").toString());
		}
		if(c.get("carInsurDt1")!=null) {
			acrmFciPerFamilyInfo.setCarInsurDt1(c.get("carInsurDt1").toString().replace("-", ""));
		}
		if(c.get("carInsurDt2")!=null) {
			acrmFciPerFamilyInfo.setCarInsurDt2(c.get("carInsurDt2").toString().replace("-", ""));
		}
		if(c.get("carInsurDt3")!=null) {
			acrmFciPerFamilyInfo.setCarInsurDt3(c.get("carInsurDt3").toString().replace("-", ""));
		}
		if(c.get("harmonyDesc")!=null) {
			acrmFciPerFamilyInfo.setHarmonyDesc(c.get("harmonyDesc").toString());
		}
		if(c.get("famDebtRec")!=null) {
			acrmFciPerFamilyInfo.setFamDebtRec(c.get("famDebtRec").toString());
		}
		if(c.get("creditRec")!=null) {
			acrmFciPerFamilyInfo.setCreditRec(c.get("creditRec").toString());
		}
		if(c.get("others")!=null) {
			acrmFciPerFamilyInfo.setOthers(c.get("others").toString());
		}
		if(c.get("famCreditFlg")!=null) {
			acrmFciPerFamilyInfo.setFamCreditFlg(c.get("famCreditFlg").toString());
		}
		if(c.get("famEconStat")!=null) {
			acrmFciPerFamilyInfo.setFamEconStat(c.get("famEconStat").toString());
		}
		if(c.get("villageEval")!=null) {
			acrmFciPerFamilyInfo.setVillageEval(c.get("villageEval").toString());
		}
		if(c.get(LAST_CHG_SYS)!=null) {
			acrmFciPerFamilyInfo.setLastChgSys(c.get(LAST_CHG_SYS).toString());
		}
		if(c.get(LAST_CHG_USR)!=null) {
			acrmFciPerFamilyInfo.setLastChgUsr(c.get(LAST_CHG_USR).toString());
		}
		if(c.get(CORP_ORG_CODE)!=null) {
			acrmFciPerFamilyInfo.setCorpOrgCode(c.get(CORP_ORG_CODE).toString());
		}
		acrmFciPerFamilyInfo.setLastChgDt(new Date());
		if(basecode>0) {
			return this.updateSelective(acrmFciPerFamilyInfo);
		}
		return 0;
	}

}
