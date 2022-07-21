package cn.com.yusys.yscrm.cust.org.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.org.domain.OcrmFciOrgManageInfo;
import cn.com.yusys.yscrm.cust.org.repository.mapper.OcrmFciOrgManageInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciOrgManageInfoService
 * @类描述: #服务类
 * @功能描述: 对公客户经营信息
 * @创建人: 15104
 * @创建时间: 2019-02-21 09:39:51
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciOrgManageInfoService extends CommonService {
    @Autowired
    private OcrmFciOrgManageInfoMapper ocrmFciOrgManageInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciOrgManageInfoMapper;
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
		List<Map<Object, String>>  list = ocrmFciOrgManageInfoMapper.querylist(model);
		
		PageHelper.clearPage();
		
		return list;
	}
	
	/**
	 * @方法名称: modify
	 * @方法描述: 保存
	 * @param
	 * @return
	 */
	public int save(OcrmFciOrgManageInfo ocrmFciOrgManageInfo) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFciOrgManageInfo.setCorpOrgCode(dto.getBody().getInstu().getCode());//法人机构号
		SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd");
		ocrmFciOrgManageInfo.setDataDate(s.format(new Date()));//数据日期
		ocrmFciOrgManageInfo.setLastChgSys("CRM");//最近更新系统
		ocrmFciOrgManageInfo.setLastChgUsr(dto.getBody().getLoginCode());//最近更新人
		ocrmFciOrgManageInfo.setLastChgDt(new Date());//最近更新日期
		if(ocrmFciOrgManageInfo.getId() == null || ocrmFciOrgManageInfo.getId().equals("")) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			ocrmFciOrgManageInfo.setId(id);
			return this.insertSelective(getMapper(), ocrmFciOrgManageInfo);
		} else {
			return this.updateSelective(getMapper(), ocrmFciOrgManageInfo);
		}
	}
	
}
