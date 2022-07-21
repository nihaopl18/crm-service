package cn.com.yusys.yscimc.luckdraw.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscimc.luckdraw.domain.CimcAppLuckDrawCusts;
import cn.com.yusys.yscimc.luckdraw.repository.mapper.CimcAppLuckDrawCustsMapper;
import cn.com.yusys.yscimc.luckdraw.repository.mapper.CmicAppLuckCustHisMapper;
import cn.com.yusys.yscimc.luckdraw.repository.mapper.CmicAppLuckDrawMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimpAppCardInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: yangxiao2
 * @创建时间: 2019-06-11 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CmicAppLuckDrawService extends CommonService{
	@Autowired
	private CmicAppLuckDrawMapper cmicAppLuckDrawMapper;

	@Autowired
    private CimcAppLuckDrawCustsMapper cimcAppLuckDrawCustsMapper;
	
    @Autowired
	private CmicAppLuckCustHisMapper cmicAppLuckCustHisMapper;
    
	@Override
	protected CommonMapper<?> getMapper() {
		return cmicAppLuckDrawMapper;
	}
	public List<Map<String, Object>> getNodeIdByActyid(String nodeId) {
//		List<Map<String, Object>> list = cmicAppLuckDrawMapper.getNodeIdByActyid(nodeId);
		return cmicAppLuckDrawMapper.getNodeIdByActyid(nodeId);
	}
	public List<Map<String, Object>> getLuckDraw(String formId) {
//		List<Map<String, Object>> list = cmicAppLuckDrawMapper.getLuckDraw(formId);
		return cmicAppLuckDrawMapper.getLuckDraw(formId);
	}
	public List<Map<String, Object>> custInfo(String custId, String formId) {
		return cmicAppLuckDrawMapper.custInfo(custId,formId);
	}
	public int addCustInfo(Map<String, Object> dc) {
		return this.insertSelective(cimcAppLuckDrawCustsMapper,dc);
	}
	
	//插入抽奖历史信息
	public void insertHis(Map<String, Object> his) {
		this.insertSelective(cmicAppLuckCustHisMapper, his);
	}
	public void updateCustInfo(String id ,String luckDrawNum) {
//		this.updateSelective(cimcAppLuckDrawCustsMapper, custInfo);
//		Date dt = new Date();
//		String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dt);
		cmicAppLuckDrawMapper.updateCustInfo(id,luckDrawNum);
	}
	public void updateCustInfo(CimcAppLuckDrawCusts ld) {
		this.updateSelective(ld);
	}
	public List<Map<String, Object>> winInfo(String formId) {
		return cmicAppLuckDrawMapper.winInfo(formId);
	}
	public List<Map<String, Object>> displayList() {
		return cmicAppLuckDrawMapper.displayList();
	}
}
