package cn.com.yusys.yscrm.cust.org.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.org.domain.OcrmFciOrgRelatInfo;
import cn.com.yusys.yscrm.cust.org.repository.mapper.OcrmFciOrgRelatInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciOrgRelatInfoService
 * @类描述: #服务类
 * @功能描述: 对公涉农个性标识信息
 * @创建人: 15104
 * @创建时间: 2019-02-21 09:34:04
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciOrgRelatInfoService extends CommonService {
    @Autowired
    private OcrmFciOrgRelatInfoMapper ocrmFciOrgRelatInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciOrgRelatInfoMapper;
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
		List<Map<Object, String>>  list = ocrmFciOrgRelatInfoMapper.querylist(model);
		
		PageHelper.clearPage();
		
		return list;
	}
	
	/**
	 * @方法名称: modify
	 * @方法描述: 保存
	 * @param
	 * @return
	 */
	public int save(OcrmFciOrgRelatInfo ocrmFciOrgRelatInfo) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFciOrgRelatInfo.setCorpOrgCode(dto.getBody().getInstu().getCode());//法人机构号
		ocrmFciOrgRelatInfo.setLastOrgId(dto.getBody().getOrg().getCode());//最近更新人机构
		ocrmFciOrgRelatInfo.setLastChgUsr(dto.getBody().getLoginCode());//最近更新人
		ocrmFciOrgRelatInfo.setLastChgDt(new Date());//最近更新日期
		
		if(ocrmFciOrgRelatInfo.getCustId()==null||ocrmFciOrgRelatInfo.getCustId()=="") {
			//表示新增
			this.insertSelective(ocrmFciOrgRelatInfo);
		}
		return this.updateSelective(getMapper(), ocrmFciOrgRelatInfo);
	}
	public int insertRelatInfo(Map relatMap) {
		return this.insertSelective(ocrmFciOrgRelatInfoMapper, relatMap);
	}
	// 涉农个性标识修改
	public int updaterelatInfo(Map c) {
        return ocrmFciOrgRelatInfoMapper.updaterelatInfo(c);
	}
}
