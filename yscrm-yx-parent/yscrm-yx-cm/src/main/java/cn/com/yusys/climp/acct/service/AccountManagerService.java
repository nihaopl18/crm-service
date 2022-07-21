package cn.com.yusys.climp.acct.service;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import cn.com.yusys.climp.acct.domain.LoyAcScoreAccount;
import cn.com.yusys.climp.acct.repository.mapper.AccountManagerMapper;
import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: AccountManagerService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2018-12-27 10:50:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AccountManagerService extends CommonService {
    @Autowired
    private AccountManagerMapper accountManagerMapper;

	@Autowired
	private UserInfoService clientService;
	
    @Override
    protected CommonMapper<?> getMapper() {
        return this.accountManagerMapper;
    }
    
    //账户信息查询
	public List<Map<String, Object>> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		return accountManagerMapper.getList(model);
	}
    
    //账户信息查询
	public List<Map<String, Object>> getApprovalList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		return accountManagerMapper.getApprovalList(model);
	}

	//账户新增
	public LoyAcScoreAccount addAcount(LoyAcScoreAccount lasa) {
		if (this.insertSelective(getMapper(), lasa) != 1) {
			return null;
		}
		return lasa;
	}

	//账户修改
	public LoyAcScoreAccount updateAcount(LoyAcScoreAccount lasa) {
		if (this.updateSelective(getMapper(), lasa) != 1) {
			return null;
		}
		return lasa;
	}

	//账户删除
	public ResultDto<Integer> delAcct(String id) {
		// TODO 自动生成的方法存根
		return accountManagerMapper.delAcct(id);
	}

	public String getSeq() {
		// TODO 自动生成的方法存根
		return accountManagerMapper.getSeq();
	}
	
	 /*
	  * 更新任务状态
	  * */
	public int updateSts(LoyAcScoreAccount lp) {
		// 获取登录用户的机构号
		String orgCode = clientService.getOrgCode();
		// 设置最新更新人
		lp.setUpdateUser(SecurityUtils.getCurrentUserLogin());
		lp.setUpdateOrg(orgCode);
		lp.setUpdateDate(new Date());
		return this.updateSelective(getMapper(), lp);
	}
	 /*
	  * 审批通过后更新任务状态
	  * */
	public void updateStsSs(String BizSeqNo) {
		// 获取登录用户的机构号
		String orgCode = clientService.getOrgCode();
		// 设置最新更新人
		LoyAcScoreAccount c = new LoyAcScoreAccount();
		c.setUpdateUser(SecurityUtils.getCurrentUserLogin());
		c.setUpdateOrg(orgCode);
		c.setWfApprSts("997");
		c.setAccountId(BizSeqNo);
		c.setUpdateDate(new Date());
		this.updateSelective(getMapper(), c);
		}
	 /*
	  * 审批退回更新任务状态
	  * */
	public void updateStsBack(String BizSeqNo) {
		// 获取登录用户的机构号
		String orgCode = clientService.getOrgCode();
		// 设置最新更新人
		LoyAcScoreAccount c = new LoyAcScoreAccount();
		c.setUpdateUser(SecurityUtils.getCurrentUserLogin());
		c.setWfApprSts("993");
		c.setUpdateOrg(orgCode);
		c.setAccountId(BizSeqNo);
		c.setUpdateDate(new Date());
		this.updateSelective(getMapper(), c);
		}
	/*
	  * 账户类型查询
	  * */
	public List<Map<String, Object>> acctStsQuery(String acctTypeId){
		return accountManagerMapper.acctStsQuery(acctTypeId);
	}
	public List<Map<String, Object>> checkAcct(String acctNo) {
		// TODO 自动生成的方法存根
		 return accountManagerMapper.checkAcct(acctNo);
	}

	public List<Map<String, Object>> checkAcctName(Map acctMap) {
		// TODO 自动生成的方法存根
		return accountManagerMapper.checkAcctName(acctMap);
	}

}
