package cn.com.yusys.yscrm.cust.person.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.person.repository.mapper.AcrmFagSaveInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagSaveInfoService
 * @类描述: #服务类
 * @功能描述: 账户信息-个人存款信息
 * @创建人: 15104
 * @创建时间: 2019-01-28 17:33:54
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFagSaveInfoService extends CommonService {
    @Autowired
    private AcrmFagSaveInfoMapper acrmFagSaveInfoMapper;
    @Autowired
    private UaaClient uaaClient;
    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFagSaveInfoMapper;
    }

    @Transactional(readOnly = true) 
   	public List<Map<Object, String>> queryCustDepositByCustId(QueryModel model, String custId) {
    	
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		Map<String,String> map=this.getMgrType(custId, dto.getBody().getLoginCode());
//		List<ObjBean> roles=dto.getBody().getRoles();
//		for(ObjBean obj:roles) {
//			if("15".equals(obj.getCode())||"115".equals(obj.getCode())) {
//    			//客户经理
//    		}else if("117".equals(obj.getCode())) {
//    			//二级支行
//    		}else if("114".equals(obj.getCode())||"107".equals(obj.getCode())||"108".equals(obj.getCode())) {
//    			//一级支行
//    		}else {
//    			
//    		}
//		}
		PageHelper.startPage(model.getPage(), model.getSize());
		if(map!=null&&map.size()>0) {
			String mgrType=map.get("mgrType");
			if(!"1".equals(mgrType)) {
				//不是主办客户经理
				paramMap.put("orgIdMgr", dto.getBody().getOrg().getCode());
				List<Map<Object, String>>  list = acrmFagSaveInfoMapper.querySaveInfoByCustId(paramMap);
				PageHelper.clearPage();
				return list;
			}
		}
		List<Map<Object, String>>  list = acrmFagSaveInfoMapper.querySaveInfoByCustId(paramMap);
		PageHelper.clearPage();

		return list;
   	}
    public Map<String,String> getMgrType(String custId,String loginCode){
    	Map<String, String> map=new HashMap<String,String>();
    	map.put("custId", custId);
    	map.put("loginCode", loginCode);
    	return acrmFagSaveInfoMapper.getMgrType(map);
    }
}
