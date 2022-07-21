package cn.com.yusys.yscrm.cust.person.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciBlackListInfo;
import cn.com.yusys.yscrm.cust.person.repository.mapper.AcrmFciBlackListInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFciBlackListInfoService
 * @类描述: #服务类
 * @功能描述: 黑名单信息
 * @创建人: 15104
 * @创建时间: 2019-02-12 16:07:29
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciBlackListInfoService extends CommonService {
	@Autowired
	private AcrmFciBlackListInfoMapper acrmFciBlackListInfoMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return acrmFciBlackListInfoMapper;
	}

	@Autowired
   	private UaaClient uaaClient;
	
	/**
	 * @方法名称: querylist
	 * @方法描述: 黑名单信息查询
	 * @param
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> querylist(QueryModel model, String custId) {
    	PageHelper.startPage(model.getPage(), model.getSize());
    	
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		
		List<Map<Object, String>>  list = acrmFciBlackListInfoMapper.querylist(paramMap);
		PageHelper.clearPage();
		
		return list;
	}

	/**
	 * @方法名称: ctrate
	 * @方法描述: 黑名单信息新增
	 * @param
	 * @return
	 */
	public int ctrate(AcrmFciBlackListInfo acrmFciBlackListInfo) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		DateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		acrmFciBlackListInfo.setDataDate(new Date());//数据日期
		acrmFciBlackListInfo.setCorpOrgCode(dto.getBody().getInstu().getCode());//法人机构号
		acrmFciBlackListInfo.setCustType("1");//客户类型 1-对私 2-对公
		acrmFciBlackListInfo.setInputId(dto.getBody().getLoginCode());//登记人
		acrmFciBlackListInfo.setInputDate(new Date());//登记日期
		acrmFciBlackListInfo.setIssueInst(dto.getBody().getOrg().getCode());//发布机构
		acrmFciBlackListInfo.setLastChgSys("CRM");//最近更新系统
		acrmFciBlackListInfo.setLastChgUsr(dto.getBody().getLoginCode());//最近更新人ID
		acrmFciBlackListInfo.setLastChgDt(new Date());//最近更新日期
		
		return this.insertSelective(getMapper(), acrmFciBlackListInfo);
	}

	/**
	 * @方法名称: modify
	 * @方法描述: 黑名单信息修改
	 * @param
	 * @return
	 */
	public int modify(AcrmFciBlackListInfo acrmFciBlackListInfo) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		acrmFciBlackListInfo.setLastChgSys("CRM");//最近更新系统
		acrmFciBlackListInfo.setLastChgUsr(dto.getBody().getLoginCode());//最近更新人ID
		acrmFciBlackListInfo.setLastChgDt(new Date());//最近更新日期
		acrmFciBlackListInfo.setInputDate(new Date());//登记日期
		
		return this.updateSelective(getMapper(), acrmFciBlackListInfo);
	}

	/**
	 * @方法名称: deleteById
	 * @方法描述: 黑名单信息删除
	 * @param
	 * @return
	 */
	public int delete(String id) {
		AcrmFciBlackListInfo acrmFciBlackListInfo = new AcrmFciBlackListInfo();
		acrmFciBlackListInfo.setId(id);
		return this.delete(acrmFciBlackListInfo);
	}
	
}
