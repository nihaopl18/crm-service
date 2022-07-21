package cn.com.yusys.yscrm.mgr.sys.pdplan.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdShowR;
import cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper.OcrmFpdProdShowPlanMapper;
import cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper.OcrmFpdProdShowRMapper;
/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowRService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-24 19:39:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFpdProdShowRService extends CommonService {
    @Autowired
    private OcrmFpdProdShowRMapper ocrmFpdProdShowRMapper;
    
    /*
     * 展示方案Mapper
     */
    @Autowired
    private OcrmFpdProdShowPlanMapper ocrmFpdProdShowPlanMapper;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFpdProdShowRMapper;
    }
    
    @Transactional(readOnly = true)
	public OcrmFpdProdShowR getEntityByPlanId(String planId) {
		// TODO 自动生成的方法存根
		return ocrmFpdProdShowRMapper.getEntityByPlanId(planId);
	}
    
	/**
   	* @方法名称: save
   	* @方法描述: 先删除当前存在的方案配置再添加新的
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int save(OcrmFpdProdShowR ocrmFpdProdShowR) {
		// TODO 自动生成的方法存根
		ocrmFpdProdShowRMapper.deleteByPlanId(ocrmFpdProdShowR.getPlanId());
		ocrmFpdProdShowR.setRid(UUID.randomUUID().toString().replaceAll("-", ""));
		UtilTools.updateUtl(ocrmFpdProdShowR);
		return insertSelective(getMapper(), ocrmFpdProdShowR);
	}
	@Transactional(readOnly = true)
	public int trialQuery(OcrmFpdProdShowR ocrmFpdProdShowR) {
		// TODO 自动生成的方法存根
		String sql = null;
		int num = 0;
		if (ocrmFpdProdShowPlanMapper.getPlanType(ocrmFpdProdShowR.getPlanId()).equals("1")) {
			sql = "SELECT COUNT(*) " + ocrmFpdProdShowR.getRfrom() +" "+ ocrmFpdProdShowR.getRwhere();
			try {
				ocrmFpdProdShowRMapper.trialQuery(sql);
			} catch (Exception e) {
				// TODO: handle exception
				num = -1;
			}
			return num;
		}
		sql = "SELECT COUNT(*) " + ocrmFpdProdShowR.getRfrom() +" "+ ocrmFpdProdShowR.getRwhere();
		
		try {
			ocrmFpdProdShowRMapper.trialQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
			num = -1;
		}
		return num;
	}

}
