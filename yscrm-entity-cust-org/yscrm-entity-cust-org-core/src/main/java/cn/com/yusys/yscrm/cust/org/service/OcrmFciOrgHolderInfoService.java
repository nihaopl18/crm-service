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

import cn.com.yusys.yscrm.cust.org.domain.OcrmFciOrgHolderInfo;
import cn.com.yusys.yscrm.cust.org.repository.mapper.OcrmFciOrgHolderInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciOrgHolderInfoService
 * @类描述: #服务类
 * @功能描述: 股东信息
 * @创建人: 15104
 * @创建时间: 2019-02-17 00:43:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciOrgHolderInfoService extends CommonService {
    @Autowired
    private OcrmFciOrgHolderInfoMapper ocrmFciOrgHolderInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciOrgHolderInfoMapper;
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
		List<Map<Object, String>>  list = ocrmFciOrgHolderInfoMapper.querylist(model);
		
		PageHelper.clearPage();
		
		return list;
	}

	/**
	 * @方法名称: ctrate
	 * @方法描述: 新增
	 * @param
	 * @return
	 */
	public int ctrate(OcrmFciOrgHolderInfo ocrmFciOrgHolderInfo) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFciOrgHolderInfo.setCorpOrgCode(dto.getBody().getInstu().getCode());//法人机构号
		SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd");
		ocrmFciOrgHolderInfo.setDataDate(s.format(new Date()));//数据日期
		ocrmFciOrgHolderInfo.setCratDt(new Date());//创建日期
		ocrmFciOrgHolderInfo.setCratOrgId(dto.getBody().getOrg().getCode());//创建人机构ID
		ocrmFciOrgHolderInfo.setCratUsr(dto.getBody().getLoginCode());//创建人id
		ocrmFciOrgHolderInfo.setLastChgSys("CRM");//最近更新系统
		ocrmFciOrgHolderInfo.setLastChgDt(new Date());//最近更新日期
		ocrmFciOrgHolderInfo.setLastChgUsr(dto.getBody().getLoginCode());//最近更新人
		ocrmFciOrgHolderInfo.setLastChgOrgId(dto.getBody().getOrg().getCode());//最近更新人机构
		
		return this.insertSelective(getMapper(), ocrmFciOrgHolderInfo);
	}

	/**
	 * @方法名称: modify
	 * @方法描述: 修改
	 * @param
	 * @return
	 */
	public int modify(OcrmFciOrgHolderInfo ocrmFciOrgHolderInfo) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd");
		ocrmFciOrgHolderInfo.setDataDate(s.format(new Date()));//数据日期
		ocrmFciOrgHolderInfo.setLastChgSys("CRM");//最近更新系统
		ocrmFciOrgHolderInfo.setLastChgDt(new Date());//最近更新日期
		ocrmFciOrgHolderInfo.setLastChgUsr(dto.getBody().getLoginCode());//最近更新人
		ocrmFciOrgHolderInfo.setLastChgOrgId(dto.getBody().getOrg().getCode());//最近更新人机构
		
		return this.updateSelective(getMapper(), ocrmFciOrgHolderInfo);
	}

	/**
	 * @方法名称: deleteById
	 * @方法描述: 黑名单信息删除
	 * @param
	 * @return
	 */
	public int delete(String id) {
		OcrmFciOrgHolderInfo ocrmFciOrgHolderInfo = new OcrmFciOrgHolderInfo();
		ocrmFciOrgHolderInfo.setId(id);
		return this.delete(ocrmFciOrgHolderInfo);
	}
	
//	/**
//	 * @方法名称: deleteById
//	 * @方法描述: 删除
//	 * @param
//	 * @return
//	 */
//	@PostMapping("/delete")
//	public int deleteByHolderCustId(String holderCustId) {
//		QueryModel queryModel = new QueryModel();
//		queryModel.getCondition().put("holderCustId", holderCustId);
//		return ocrmFciOrgHolderInfoMapper.deleteByHolderCustId(queryModel);
//	}
	
}
