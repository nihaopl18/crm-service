package cn.com.yusys.yusp.uimp.audit.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.uimp.audit.domain.PmaFAppointAuditInfo;
import cn.com.yusys.yusp.uimp.audit.repository.mapper.PmaFAppointAuditInfoMapper;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFAppointAuditInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-02 14:45:33
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFAppointAuditInfoService extends CommonService {
    @Autowired
    private PmaFAppointAuditInfoMapper pmaFAppointAuditInfoMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFAppointAuditInfoMapper;
    }
    
    
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) {
//    	User user = getUser();
//    	model.getCondition().put("applyUserId", user.getLoginCode());
    	model.getCondition().put("applyUserId", userInfoService.getUserInfo().getLoginCode());
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.pmaFAppointAuditInfoMapper.listByModel(model);
		PageHelper.clearPage();
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFAppointAuditInfo> add (PmaFAppointAuditInfo pmaFAppointAuditInfo) throws Exception {
    	ResultDto<PmaFAppointAuditInfo> result = new ResultDto<PmaFAppointAuditInfo>();
    	//判断机构是实体营业网点，判断逻辑
    	int count = this.pmaFAppointAuditInfoMapper.queryByOrg(pmaFAppointAuditInfo.getAppointOrgId());
    	if(count == 0) {
        	result.setMessage("预约机构不是实体营业网点，请重新选择");
            result.setCode(-1);
        	return result;
    	}
    	pmaFAppointAuditInfo.setStartDate(pmaFAppointAuditInfo.getStartDate().replace("-", ""));
    	pmaFAppointAuditInfo.setEndDate(pmaFAppointAuditInfo.getEndDate().replace("-", ""));
    	pmaFAppointAuditInfo.setApplyTime(pmaFAppointAuditInfo.getApplyTime().replace("-", ""));
    	pmaFAppointAuditInfo.setApplyUserId(userInfoService.getUserInfo().getLoginCode());
    	pmaFAppointAuditInfo.setApplyUserName(userInfoService.getUserInfo().getUserName());
    	pmaFAppointAuditInfo.setEtlRes("0");
    	QueryModel model = new QueryModel();
    	model.getCondition().put("cardId",pmaFAppointAuditInfo.getCardId());
    	model.getCondition().put("busType",pmaFAppointAuditInfo.getBusType());
    	model.getCondition().put("appointPhone",pmaFAppointAuditInfo.getAppointPhone());
    	model.getCondition().put("appointOrgId",pmaFAppointAuditInfo.getAppointOrgId());
    	model.getCondition().put("etlRes",pmaFAppointAuditInfo.getEtlRes());
    	String countnum = this.pmaFAppointAuditInfoMapper.selectCount(model);
    	if(countnum.equals("0")) {
        	this.pmaFAppointAuditInfoMapper.insertSelective(pmaFAppointAuditInfo);
        	result.setData(pmaFAppointAuditInfo);
        	result.setMessage("新增预约成功");
            result.setCode(0);
        	return result;
    	}else {
    		result.setData(pmaFAppointAuditInfo);
        	result.setMessage("该客户在"+pmaFAppointAuditInfo.getAppointOrgId()+"机构已被他人预约，不允许重复预约！");
            result.setCode(1);
        	return result;
    	}

    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> delete (String  ids){
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	String[] id = ids.split(",");
    	for (int i =0 ;i < id.length ; i++) {	
    		pmaFAppointAuditInfoMapper.deleteByIds(id[i]);
    	}
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
    private UserInfoDTO getUser() {
		UserInfoDTO user = userInfoService.getUserInfo();
    	return user;
    }
}
