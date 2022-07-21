package cn.com.yusys.yscrm.mgr.sys.pdplan.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdShowPlan;
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdTable;
import cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper.OcrmFpdProdShowColumnMapper;
import cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper.OcrmFpdProdShowPlanMapper;
import cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper.OcrmFpdProdShowRMapper;
import cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper.OcrmFpdProdShowTableMapper;
/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowPlanService
 * @类描述: 产品展示方案
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-23 19:29:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFpdProdShowPlanService extends CommonService {
	/*
	 * 产品展示方案Mapper
	 */
    @Autowired
    private OcrmFpdProdShowPlanMapper ocrmFpdProdShowPlanMapper;
    /*
	 * 产品展示方案关系Mapper
	 */
    @Autowired
    private OcrmFpdProdShowRMapper ocrmFpdProdShowRMapper;
    /*
	 * 产品展示方案关联数据表Mapper
	 */
    @Autowired
    private OcrmFpdProdShowTableMapper ocrmFpdProdShowTableMapper;
    /*
	 * 产品展示方案关联属性Mapper
	 */
    @Autowired
    private OcrmFpdProdShowColumnMapper ocrmFpdProdShowColumnMapper ;
    
    @Autowired
    private UaaClient  uaaClient;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFpdProdShowPlanMapper;
    }
    
    public  UserInfoDTO getUserInfoDTO() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		return user;
	}
    /*
     * 产品展示方案修改方法
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int updateFun(OcrmFpdProdShowPlan ocrmFpdProdShowPlan) {
		// TODO 自动生成的方法存根
    	UserInfoDTO user = getUserInfoDTO();
    	ocrmFpdProdShowPlan.setUpdateDate(new Date());
    	ocrmFpdProdShowPlan.setUpdateUser(user.getUserId());
		return updateSelective(getMapper(), ocrmFpdProdShowPlan);
	}
    /*
     * 产品展示方案新增方法
     */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public OcrmFpdProdShowPlan add(OcrmFpdProdShowPlan ocrmFpdProdShowPlan) {
		// TODO 自动生成的方法存根
		UserInfoDTO user = getUserInfoDTO();
		Date date = new Date();
//		UtilTools.createUtl(ocrmFpdProdShowPlan);
//		UtilTools.updateUtl(ocrmFpdProdShowPlan);
//		ocrmFpdProdShowPlan.setCreateOrg(UtilTools.getUserInfoDTO().getOrg().getCode());
		ocrmFpdProdShowPlan.setPlanId(UtilTools.getUUID());
		ocrmFpdProdShowPlan.setCreateDate(date);
		ocrmFpdProdShowPlan.setUpdateDate(date);
		ocrmFpdProdShowPlan.setCreateUser(user.getUserId());
		ocrmFpdProdShowPlan.setCreateOrg(user.getOrg().getCode());
		ocrmFpdProdShowPlan.setUpdateUser(user.getUserId());
		if (insertSelective(getMapper(), ocrmFpdProdShowPlan) == 1) {
			return ocrmFpdProdShowPlan;
		}
		return null;
	}
	/*
	 * 产品展示方案列表信息
	 */
	@Transactional(readOnly = true)
	public List<Map<String, String>> getListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = ocrmFpdProdShowPlanMapper.getListByModel(model);
		PageHelper.clearPage();
		return list;
	}
	/*
	 * 检查方案名称是否已经存在
	 */
	@Transactional(readOnly = true)
	public int checkPlanName(String planName) {
		// TODO 自动生成的方法存根
		int num = ocrmFpdProdShowPlanMapper.checkPlanName(planName);
		return num;
	}
	public int checkUpdPlanName(String planId, String planName) {
		// TODO 自动生成的方法存根
		return ocrmFpdProdShowPlanMapper.checkUpdPlanName(planId,planName);
	}
	public int del(String ids) {
		// TODO 自动生成的方法存根
		String[] id = ids.split(",");
		int num = 0;
		for (int i = 0; i < id.length; i++) {
			String planId = id[i];
			ocrmFpdProdShowColumnMapper.deleteByPlanId(planId);
			ocrmFpdProdShowPlanMapper.delById(planId);
			ocrmFpdProdShowRMapper.deleteByPlanId(planId);
			ocrmFpdProdShowTableMapper.deleteByPlanId(planId);
			num++;
		}
		return num;
	}

}
