package cn.com.yusys.yusp.uimp.excel.thread;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeEvlobjRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeEvlobjRelService;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelTmpInfo;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelrunInfo;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelCellInfoService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelEvlindexInfoService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelFormulaInfService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelIndexInfoService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelObjInfoService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelTmpInfoService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExceldutyInfService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelobjidInfService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelorgInfService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelorgparamInfService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelpstparamInfService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelrunInfoService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelsvwInfService;
import cn.com.yusys.yusp.uimp.excel.thread.pool.ExcelFixedThreadPoolManager;
import tk.mybatis.mapper.util.StringUtil;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: SchemeExcelRunManager
 * @类描述: # 考核方案运行线程入口类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-25 11:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class SchemeExcelRunThreadManager {
	
	@Autowired
	private PmaFschemeExcelTmpInfoService tmpInfoService;
	
	@Autowired
	private PmaFschemeExcelCellInfoService cellInfoService;
	
	@Autowired
	private PmaFschemeExcelObjInfoService objInfoService;
	
	@Autowired
	private PmaFschemeExcelIndexInfoService indexInfoService;
	
	@Autowired
	private PmaFschemeExcelEvlindexInfoService evlindexInfoService;
	
	@Autowired
	private PmaFschemeExcelFormulaInfService formulaInfService;
	
	@Autowired
	private PmaFschemeExcelorgparamInfService orgparamInfService;
	
	@Autowired
	private PmaFschemeExcelpstparamInfService pstparamInfService;
	
	@Autowired
	private PmaFschemeExcelsvwInfService svwInfService;
	
	@Autowired
	private PmaFschemeExceldutyInfService dutyInfService;
	
	@Autowired
	private PmaFschemeExcelorgInfService orgInfService;
	
	@Autowired
	private PmaFschemeExcelobjidInfService objIdInfService;
	
	@Autowired
	private PmaFschemeExcelrunInfoService runInfoService;
	
	@Autowired
	private ExcelFixedThreadPoolManager fixedThreadPoolManager;
	
	@Autowired
	private UserInfoService userInfo;
	
	@Autowired
	private PmaFSchemeEvlobjRelMapper evlObjRelMapper;
	
	@Autowired
	private PmaFSchemeEvlobjRelService evlObjRelService;

	/**
	 * @函数名称:process
	 * @函数描述:考核方案运行线程处理入口类
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void process(String schemeId, String templateId, String templateType, String evlObjType, String etlDate,
			PmaFschemeExcelTmpInfo tmpInfo, String etlFlag) {
		// 维护-考核方案报表运行信息表
		PmaFschemeExcelrunInfo runInfo = runInfoService.getRunInfoBySchemeIdAndEtlDate(schemeId, etlDate);
		if(runInfo == null) {
			runInfo = new PmaFschemeExcelrunInfo();
		}
		runInfo.setSchemeId(schemeId);
		runInfo.setEtlDate(etlDate);
		runInfo.setRunStartTime(new Date());
		runInfo.setRunEndTime(null);
		runInfo.setRunStatus("0");	// 运行中
		runInfo.setPubStatus("0");	// 未发布
		runInfo.setCreateUser("1".equals(etlFlag) ? "ETL" : userInfo.getUserInfo().getLoginCode());
		runInfo.setCreateTime(new Date());
		runInfo.setErrMsg("");
		if(StringUtil.isNotEmpty(runInfo.getId())) {
			runInfoService.updateSelective(runInfo);
		} else {
			runInfoService.insertSelective(runInfo);
		}
		fixedThreadPoolManager.execute(schemeId, templateId, templateType, evlObjType, etlDate, tmpInfo, tmpInfoService,
				cellInfoService, objInfoService, indexInfoService, evlindexInfoService, formulaInfService,
				orgparamInfService, pstparamInfService, svwInfService, 
				dutyInfService, orgInfService, objIdInfService,
				runInfo, runInfoService, evlObjRelMapper, evlObjRelService);
	}
}
