package cn.com.yusys.yscrm.custmgr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yscrm.custmgr.repository.mapper.OcrmFcmCustMgrQuitApplyMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFcmCustMgrQuitApplyService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: luhy1@yusys.com.cn
 * @创建时间: 2019-01-28 14:26:31
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFcmCustMgrQuitApplyService extends CommonService {
	@Autowired
	private OcrmFcmCustMgrQuitApplyMapper ocrmFcmCustMgrQuitApplyMapper;
	
	@Autowired
   	private UaaClient uaaClient;

	@Override
	protected CommonMapper<?> getMapper() {
		return ocrmFcmCustMgrQuitApplyMapper;
	}
	
	/**
 	 * @方法名称: queryQuitCustMgrApply
 	 * @方法描述: 查询退出客户经理信息
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryQuitCustMgrApply(String id) {
		List<Map<String, Object>> list = ocrmFcmCustMgrQuitApplyMapper.queryQuitCustMgrApply(id);
		return list;
    }
	
	/**
	 * 提交
	 * @param bizSeqNo 业务流水号
	 */
	public void submit(String bizSeqNo) {
		this.ocrmFcmCustMgrQuitApplyMapper.custMgrQuitSubmit(bizSeqNo);
	}
	
	/**
	 * 通过
	 * @param bizSeqNo 业务流水号
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public void pass(String bizSeqNo,String mgrId,String orgId,String orgName) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		//1、修改审批申请状态
		this.ocrmFcmCustMgrQuitApplyMapper.custMgrQuitPass(bizSeqNo);
		//2、修改客户经理归属信息，退出后归属到该机构对应虚拟客户经理上，虚拟客户经理规则：VM+机构号
		String vMgrId = "VM"+orgId;
		String vMgrName = orgName + "虚拟客户经理";
		this.ocrmFcmCustMgrQuitApplyMapper.updateCustMgrBelongInfo(mgrId, dto.getBody().getLoginCode(), dto.getBody().getOrg().getCode(), vMgrId, vMgrName);
		//3、删除客户经理表
		this.ocrmFcmCustMgrQuitApplyMapper.deleteCustMgrInfo(mgrId);
	}
	
	/**
	 * 否决
	 * @param bizSeqNo 业务流水号
	 */
	public void refuse(String bizSeqNo) {
		this.ocrmFcmCustMgrQuitApplyMapper.custMgrQuitRefuse(bizSeqNo);
	}

}
