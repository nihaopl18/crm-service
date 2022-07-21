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

import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgKeyMan;
import cn.com.yusys.yscrm.cust.org.repository.mapper.OcrmFciOrgKeyManMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciOrgKeyManService
 * @类描述: #服务类
 * @功能描述: 关键人信息
 * @创建人: 15104
 * @创建时间: 2019-02-17 00:48:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciOrgKeyManService extends CommonService {
    @Autowired
    private OcrmFciOrgKeyManMapper ocrmFciOrgKeyManMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciOrgKeyManMapper;
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
	public List<Map<Object, String>> querylist(QueryModel model, String custId,String topfive) {
		PageHelper.startPage(model.getPage(), model.getSize());
		
		model.getCondition().put("custId", custId);
		model.getCondition().put("topfive", topfive);
		
		List<Map<Object, String>>  list = ocrmFciOrgKeyManMapper.querylist(model);
		
		PageHelper.clearPage();
		
		return list;
	}

	/**
	 * @方法名称: ctrate
	 * @方法描述: 新增
	 * @param
	 * @return
	 */
	public int ctrate(AcrmFciOrgKeyMan ocrmFciOrgKeyMan) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFciOrgKeyMan.setCorpOrgCode(dto.getBody().getInstu().getCode());//法人机构号
		SimpleDateFormat f=new SimpleDateFormat("yyyyMMdd");
		ocrmFciOrgKeyMan.setDataDate(f.format(new Date()));//数据日期
		ocrmFciOrgKeyMan.setCratDt(new Date());//创建日期
		ocrmFciOrgKeyMan.setCratOrgId(dto.getBody().getOrg().getCode());//创建人机构ID
		ocrmFciOrgKeyMan.setCratUsr(dto.getBody().getLoginCode());//创建人id
		ocrmFciOrgKeyMan.setLastChgSys("CRM");//最近更新系统
		ocrmFciOrgKeyMan.setLastChgDt(new Date());//最近更新日期
		ocrmFciOrgKeyMan.setLastChgUsr(dto.getBody().getLoginCode());//最近更新人
		//ocrmFciOrgKeyMan.setId(dto.getBody().getOrg().getCode());//最近更新人机构
		
		return this.insertSelective(getMapper(), ocrmFciOrgKeyMan);
	}

	/**
	 * @方法名称: modify
	 * @方法描述: 修改
	 * @param
	 * @return
	 */
	public int modify(AcrmFciOrgKeyMan ocrmFciOrgKeyMan) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		SimpleDateFormat f=new SimpleDateFormat("yyyyMMdd");
		ocrmFciOrgKeyMan.setDataDate(f.format(new Date()));//数据日期
		ocrmFciOrgKeyMan.setLastChgSys("CRM");//最近更新系统
		ocrmFciOrgKeyMan.setLastChgDt(new Date());//最近更新日期
		ocrmFciOrgKeyMan.setLastChgUsr(dto.getBody().getLoginCode());//最近更新人
//		ocrmFciOrgKeyMan.setId(dto.getBody().getOrg().getCode());//最近更新人机构
		
		return this.updateSelective(getMapper(), ocrmFciOrgKeyMan);
	}

	/**
	 * @方法名称: deleteById
	 * @方法描述: 删除
	 * @param
	 * @return
	 */
	@PostMapping("/delete")
	public int deleteById(String id) {
		QueryModel queryModel = new QueryModel();
		queryModel.getCondition().put("id", id);
		return ocrmFciOrgKeyManMapper.deleteById(queryModel);
	}
	
}
