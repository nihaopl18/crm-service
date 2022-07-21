package cn.com.yusys.yscrm.cust.org.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.org.domain.OcrmFciOrgBondInfo;
import cn.com.yusys.yscrm.cust.org.repository.mapper.OcrmFciOrgBondInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciOrgBondInfoService
 * @类描述: #服务类
 * @功能描述: 债券信息
 * @创建人: 15104
 * @创建时间: 2019-02-17 00:56:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciOrgBondInfoService extends CommonService {
    @Autowired
    private OcrmFciOrgBondInfoMapper ocrmFciOrgBondInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciOrgBondInfoMapper;
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
		List<Map<Object, String>>  list = ocrmFciOrgBondInfoMapper.querylist(model);
		
		PageHelper.clearPage();
		
		return list;
	}

	/**
	 * @方法名称: ctrate
	 * @方法描述: 新增
	 * @param
	 * @return
	 */
	public int ctrate(OcrmFciOrgBondInfo ocrmFciOrgBondInfo) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFciOrgBondInfo.setCorpOrgCode(dto.getBody().getInstu().getCode());//法人机构号
		SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd");
		ocrmFciOrgBondInfo.setDataDate(s.format(new Date()));//数据日期
		ocrmFciOrgBondInfo.setCratDt(new Date());//创建日期
		ocrmFciOrgBondInfo.setCratOrgId(dto.getBody().getOrg().getCode());//创建人机构ID
		ocrmFciOrgBondInfo.setCratUsr(dto.getBody().getUserCode());//创建人id
		ocrmFciOrgBondInfo.setLastChgSys("CRM");//最近更新系统
		ocrmFciOrgBondInfo.setLastChgDt(new Date());//最近更新日期
		ocrmFciOrgBondInfo.setLastChgUsr(dto.getBody().getUserCode());//最近更新人
		ocrmFciOrgBondInfo.setLastChgOrgId(dto.getBody().getOrg().getCode());//最近更新人机构
		
		return this.insertSelective(getMapper(), ocrmFciOrgBondInfo);
	}

	/**
	 * @方法名称: modify
	 * @方法描述: 修改
	 * @param
	 * @return
	 */
	public int modify(OcrmFciOrgBondInfo ocrmFciOrgBondInfo) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd");
		ocrmFciOrgBondInfo.setDataDate(s.format(new Date()));//数据日期
		ocrmFciOrgBondInfo.setLastChgSys("CRM");//最近更新系统
		ocrmFciOrgBondInfo.setLastChgDt(new Date());//最近更新日期
		ocrmFciOrgBondInfo.setLastChgUsr(dto.getBody().getUserCode());//最近更新人
		ocrmFciOrgBondInfo.setLastChgOrgId(dto.getBody().getOrg().getCode());//最近更新人机构
		
		return this.updateSelective(getMapper(), ocrmFciOrgBondInfo);
	}

	/**
	 * @方法名称: deleteById
	 * @方法描述: 删除
	 * @param
	 * @return
	 */
	@PostMapping("/delete")
	public int deleteByBondId(String bondId) {
		QueryModel queryModel = new QueryModel();
		queryModel.getCondition().put("bondId", bondId);
		return ocrmFciOrgBondInfoMapper.deleteByBondId(queryModel);
	}
	
}
