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

import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgCustInfo;
import cn.com.yusys.yscrm.cust.org.repository.mapper.AcrmFciOrgCustBasicMapper;
import cn.com.yusys.yscrm.cust.org.repository.mapper.OcrmFciCustUpdateHisOrgMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFciOrgCustService
 * @类描述: #服务类
 * @功能描述: 对公客户基本信息
 * @创建人: 15104
 * @创建时间: 2019-02-21 09:32:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciOrgCustBasicService extends CommonService {
    @Autowired
    private AcrmFciOrgCustBasicMapper acrmFciOrgCustMapper;
    
    @Autowired
    private OcrmFciCustUpdateHisOrgMapper ocrmFciCustUpdateHisOrgMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFciOrgCustMapper;
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
		List<Map<Object, String>>  list = acrmFciOrgCustMapper.querylist(model);
		
		PageHelper.clearPage();
		
		return list;
	}
	
	/**
	 * @方法名称: save
	 * @方法描述: 保存
	 * @param
	 * @return
	 */
	public int save(AcrmFciOrgCustInfo acrmFciOrgCust) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(new Date());
		
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		acrmFciOrgCust.setCorpOrgCode(dto.getBody().getInstu().getCode());//法人机构号
		acrmFciOrgCust.setDataDate(today);//数据日期
		acrmFciOrgCust.setLastUpdateSys("CRM");//最近更新系统
		acrmFciOrgCust.setLastUpdateUser(dto.getBody().getLoginCode());//最近更新人
		acrmFciOrgCust.setLastUpdateTm(new Date());//最近更新日期
		acrmFciOrgCust.setLastUpdateOrg(dto.getBody().getOrg().getCode());//最近更新人机构
		
		return this.updateSelective(getMapper(), acrmFciOrgCust);
	}
	
	/**
	 * @方法名称: queryCustUpdateHis
	 * @方法描述: 插入修改历史信息
	 * @param
	 * @return
	 */
	public int changeList(Map ocuh) {
		return this.insertSelective(ocrmFciCustUpdateHisOrgMapper, ocuh);
	}
	
	/**
	 * @方法名称: queryCustUpdateHis
	 * @方法描述: 查询修改历史信息
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> queryCustUpdateHis(QueryModel model,String custId) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list= acrmFciOrgCustMapper.queryCustUpdateHis(custId);
		PageHelper.clearPage();
		return list;
	}
	
	/**
	 * @方法名称: updateIsUse
	 * @方法描述: 修改历史信息有效状态
	 * @param
	 * @return
	 */
	public int updateIsUse(String custId, String updateName) {
		return acrmFciOrgCustMapper.updateIsUse(custId,updateName);
	}

	public List<Map<Object, String>> getlookupItem() {
		// TODO 自动生成的方法存根
		return acrmFciOrgCustMapper.getlookupItem();
	}

	public String getItemName(Map mapCode) {
		// TODO 自动生成的方法存根
		return acrmFciOrgCustMapper.getItemName(mapCode);
	}
}
