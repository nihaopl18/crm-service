package cn.com.yusys.yscrm.info.remind.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import cn.com.yusys.yscrm.info.remind.domain.OcrmFciCustAdmitTarget;
import cn.com.yusys.yscrm.info.remind.repository.mapper.OcrmFciCustAdmitTargetMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

@Service
public class OcrmFciCustAdmitTargetService extends CommonService {

	@Autowired
	private OcrmFciCustAdmitTargetMapper mapper;

	@Override
	protected CommonMapper getMapper() {
		return mapper;
	}

	private int num;
	
	public List<Map<String, Object>> queryList() {
		List<Map<String, Object>> list = mapper.queryList();
		return list;
	}

	public Integer save(QueryModel model) {
		ArrayList perlist = (ArrayList) model.getCondition().get("perArr");
		ArrayList orglist = (ArrayList) model.getCondition().get("orgArr");
		String userId=(String) model.getCondition().get("lastChgUserId");
		String userName=(String) model.getCondition().get("lastChgUserName");
		Date date=new Date();
		Map map=model.getCondition();
		isExist("11",perlist,null,userId,userName,date);
		isExist("12",perlist,null,userId,userName,date);
		isExist("13",perlist,new BigDecimal(Double.parseDouble("".equals(map.get("target13")+"")?"0":map.get("target13")+"")),userId,userName,date);
		isExist("15",perlist,new BigDecimal(Double.parseDouble("".equals(map.get("target15")+"")?"0":map.get("target15")+"")),userId,userName,date);
		isExist("16",perlist,new BigDecimal(Double.parseDouble("".equals(map.get("target16")+"")?"0":map.get("target16")+"")),userId,userName,date);
		isExist("17",perlist,null,userId,userName,date);
		isExist("18",perlist,new BigDecimal(Double.parseDouble("".equals(map.get("target18")+"")?"0":map.get("target18")+"")),userId,userName,date);
		isExist("21",orglist,null,userId,userName,date);
		isExist("22",orglist,null,userId,userName,date);
		isExist("23",orglist,new BigDecimal(Double.parseDouble("".equals(map.get("target23")+"")?"0":map.get("target23")+"")),userId,userName,date);
		isExist("24",orglist,new BigDecimal(Double.parseDouble("".equals(map.get("target24")+"")?"0":map.get("target24")+"")),userId,userName,date);
		isExist("25",orglist,new BigDecimal(Double.parseDouble("".equals(map.get("target25")+"")?"0":map.get("target25")+"")),userId,userName,date);
		return num;
	}
	
	public void isExist(String str,ArrayList arrlist,BigDecimal targetValue,String userId,String userName,Date date) {
		OcrmFciCustAdmitTarget admit=new OcrmFciCustAdmitTarget();
		admit.setCustType(str.substring(0,1));
		admit.setTargetId(str.substring(1,2));
		admit.setLastChgUserId(userId);
		admit.setLastChgUserName(userName);
		admit.setLastChgDate(date);
		if(arrlist.indexOf(str)!=-1) {
			admit.setTargetStatus("1");
			admit.setTargetValue(targetValue);
		}else {
			admit.setTargetStatus("0");
		}
		int i=mapper.update(admit);
		num++;
		System.out.println(i);
	}
}
