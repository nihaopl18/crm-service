package cn.com.yusys.yscrm.custpub.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAdmitAll;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciAttenCust;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciAttenCustMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciAttenCustService
 * @类描述: 关注客户服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-28 17:25:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciAttenCustService extends CommonService {
    @Autowired
    private OcrmFciAttenCustMapper ocrmFciAttenCustMapper;
    @Autowired
    private UaaClient uaaClient;
    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFciAttenCustMapper;
    }
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public List<Map<String, String>> getListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
    	PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = ocrmFciAttenCustMapper.getListByModel(model);
		PageHelper.clearPage();
		return list;
	}
    @Transactional(readOnly = true)
	public List<AcrmFciCustAdmitAll> getCustsById(List<String> lists) {
		// TODO 自动生成的方法存根
		return ocrmFciAttenCustMapper.getCustsById(lists);
	}
    public  UserInfoDTO getUserInfoDTO() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		return user;
	}
    @Transactional(readOnly = true)
    public int deleteByCustIdAndUserId(String custId,String userId) {
    	
		return ocrmFciAttenCustMapper.deleteByCustIdAndUserId(custId,userId);
    	
    }
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int join(List<AcrmFciCustAdmitAll> acrmFciCustAdmitAlls, String attentType,
			String userId) {
		// TODO 自动生成的方法存根
		int num= 0;
		for (int i = 0; i < acrmFciCustAdmitAlls.size(); i++) {
			AcrmFciCustAdmitAll acrmFciCustAdmitAll = acrmFciCustAdmitAlls.get(i);
			OcrmFciAttenCust ocrmFciAttenCust = new OcrmFciAttenCust();
			ocrmFciAttenCust.setCustId(acrmFciCustAdmitAll.getCustId());
			ocrmFciAttenCust.setCustName(acrmFciCustAdmitAll.getCustName());
			ocrmFciAttenCust.setCustType(acrmFciCustAdmitAll.getCustType());
			ocrmFciAttenCust.setAttentType(attentType);
			ocrmFciAttenCust.setUserId(userId);
			ocrmFciAttenCust.setLastUpdateTm(new Date());
			UserInfoDTO user = getUserInfoDTO();
			ocrmFciAttenCust.setLastUpdateUser(user.getLoginCode());
			ocrmFciAttenCust.setAttenId(UtilTools.getUUID());
			deleteByCustIdAndUserId(acrmFciCustAdmitAll.getCustId(),userId);
			if (insertSelective(getMapper(), ocrmFciAttenCust) == 1) {
				num++;
			}
		}
		return num;
	}

}
