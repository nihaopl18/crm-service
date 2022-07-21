package cn.com.yusys.yscrm.cust.person.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.person.domain.OcrmFciCustFeedbackInfo;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciCustFeedbackInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciCustFeedbackInfoService
 * @类描述: #服务类
 * @功能描述: 客户反馈信息
 * @创建人: 15104
 * @创建时间: 2019-02-14 17:57:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciCustFeedbackInfoService extends CommonService {
    @Autowired
    private OcrmFciCustFeedbackInfoMapper ocrmFciCustFeedbackInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciCustFeedbackInfoMapper;
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
		List<Map<Object, String>>  list = ocrmFciCustFeedbackInfoMapper.querylist(model);
		
		PageHelper.clearPage();
		
		return list;
	}

	/**
	 * @方法名称: ctrate
	 * @方法描述: 新增
	 * @param
	 * @return
	 */
	public int ctrate(OcrmFciCustFeedbackInfo ocrmFciCustFeedbackInfo) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
//		ocrmFciCustFeedbackInfo.setCustType("1");//客户类型 1-对私 2-对公
		ocrmFciCustFeedbackInfo.setCorpOrgCode(dto.getBody().getInstu().getCode());//法人机构号
		ocrmFciCustFeedbackInfo.setConductorId(dto.getBody().getLoginCode());//创建人ID
//		ocrmFciCustFeedbackInfo.setConductorName(dto.getBody().getUserName());//创建人姓名
		ocrmFciCustFeedbackInfo.setConductorOrgId(dto.getBody().getOrg().getCode());//创建人机构ID
		ocrmFciCustFeedbackInfo.setConductorOrgName(dto.getBody().getOrg().getName());//创建人机构名称
		ocrmFciCustFeedbackInfo.setIsProcessed("0");
		
		return this.insertSelective(getMapper(), ocrmFciCustFeedbackInfo);
	}

	/**
	 * @方法名称: modify
	 * @方法描述: 修改
	 * @param
	 * @return
	 */
	public int modify(OcrmFciCustFeedbackInfo ocrmFciCustFeedbackInfo) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFciCustFeedbackInfo.setCorpOrgCode(dto.getBody().getInstu().getCode());//法人机构号
		ocrmFciCustFeedbackInfo.setConductorId(dto.getBody().getLoginCode());//创建人ID
		ocrmFciCustFeedbackInfo.setConductorName(dto.getBody().getUserName());//创建人姓名
		ocrmFciCustFeedbackInfo.setConductorOrgId(dto.getBody().getOrg().getCode());//创建人机构ID
		ocrmFciCustFeedbackInfo.setConductorOrgName(dto.getBody().getOrg().getName());//创建人机构名称
		ocrmFciCustFeedbackInfo.setConductTm(new Date());//处理时间
		
		return this.updateSelective(getMapper(), ocrmFciCustFeedbackInfo);
	}

	/**
	 * @方法名称: deleteById
	 * @方法描述: 删除
	 * @param
	 * @return
	 */
	@PostMapping("/delete")
	public int deleteByFeedbackId(String feedbackId) {
		QueryModel queryModel = new QueryModel();
		queryModel.getCondition().put("feedbackId", feedbackId);
		return ocrmFciCustFeedbackInfoMapper.deleteByFeedbackId(queryModel);
	}
}
