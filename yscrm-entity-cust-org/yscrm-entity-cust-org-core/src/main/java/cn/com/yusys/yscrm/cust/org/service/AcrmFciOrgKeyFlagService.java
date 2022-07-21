package cn.com.yusys.yscrm.cust.org.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgKeyFlag;
import cn.com.yusys.yscrm.cust.org.repository.mapper.AcrmFciOrgKeyFlagMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import net.sf.json.util.JSONStringer;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFciOrgKeyFlagService
 * @类描述: #服务类
 * @功能描述: 对公重要标志信息
 * @创建人: 15104
 * @创建时间: 2019-02-21 09:33:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciOrgKeyFlagService extends CommonService {
    @Autowired
    private AcrmFciOrgKeyFlagMapper acrmFciOrgKeyFlagMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFciOrgKeyFlagMapper;
    }

    @Autowired
   	private UaaClient uaaClient;
    
    /**
	 * @方法名称: querylist
	 * @方法描述: 查询
	 * @param
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> querylist(QueryModel model, String custId) {
		PageHelper.startPage(model.getPage(), model.getSize());
		
		model.getCondition().put("custId", custId);
		List<Map<Object, String>>  list = acrmFciOrgKeyFlagMapper.querylist(model);
		
		PageHelper.clearPage();
		
		return list;
	}
	
	/**
	 * @方法名称: modify
	 * @方法描述: 保存
	 * @param
	 * @return
	 */
	public int save(Map c) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(new Date());
		AcrmFciOrgKeyFlag acrmFciOrgKeyFlag=new AcrmFciOrgKeyFlag();
		String impString="";
		String importId=c.get("importId").toString();
		impString=c.get("importData").toString();
		JSONObject impJson =   JSONObject.fromObject(impString);   
		acrmFciOrgKeyFlag =(AcrmFciOrgKeyFlag)JSONObject.toBean(impJson,AcrmFciOrgKeyFlag.class);
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		acrmFciOrgKeyFlag.setCorpOrgCode(dto.getBody().getInstu().getCode());//法人机构号
		acrmFciOrgKeyFlag.setDataDate(today);//数据日期
		acrmFciOrgKeyFlag.setLastChgSys("CRM");//最近更新系统
		acrmFciOrgKeyFlag.setLastChgUsr(dto.getBody().getLoginCode());//最近更新人
		acrmFciOrgKeyFlag.setLastChgDt(new Date());//最近更新日期
		if(importId==null||importId.equals("")) {
//			acrmFciOrgKeyFlag.setListFlg(String.valueOf(c.get("listFlg")));
//			acrmFciOrgKeyFlag.setMiniComFlg(String.valueOf(c.get("miniComFlg")));
//			acrmFciOrgKeyFlag.setGroupCustFlg(String.valueOf(c.get("groupCustFlg")));
//			acrmFciOrgKeyFlag.setFamFlg(String.valueOf(c.get("famFlg")));
//			acrmFciOrgKeyFlag.setMiniComFlg(String.valueOf(c.get("limitIndusFlg")));
//			acrmFciOrgKeyFlag.setMiniComFlg(String.valueOf(c.get("dhghFlg")));
//			acrmFciOrgKeyFlag.setMiniComFlg(String.valueOf(c.get("loanFlg")));
//			acrmFciOrgKeyFlag.setMiniComFlg(String.valueOf(c.get("creditCustFlg")));
//			acrmFciOrgKeyFlag.setMiniComFlg(String.valueOf(c.get("irRightFlg")));
//			acrmFciOrgKeyFlag.setMiniComFlg(String.valueOf(c.get("fexcPrmNo")));
//			acrmFciOrgKeyFlag.setMiniComFlg(String.valueOf(c.get("gatFlg")));
//			acrmFciOrgKeyFlag.setMiniComFlg(String.valueOf(c.get("listFlg")));
			return this.insertSelective(getMapper(), acrmFciOrgKeyFlag);
		}else {
			return this.updateSelective(getMapper(), acrmFciOrgKeyFlag);
		}
	}
	
}
