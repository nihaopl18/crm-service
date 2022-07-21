package cn.com.yusys.yusp.uimp.excel.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

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
import cn.com.yusys.yusp.uimp.excel.thread.SchemeExcelRunThread;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: ExcelFixedThreadPoolManager
 * @类描述: # 考核方案运行线程池管理类，使用java自带的ThreadPoolExecutor，创建固定线程数量的线程池
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-25 11:51:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Component
public class ExcelFixedThreadPoolManager {

	// 线程数
	private static int THREAD_SIZE = 1;

	private ExecutorService executorService;

	@PostConstruct
	public void init() {
		executorService = Executors.newFixedThreadPool(THREAD_SIZE);
	}
	
	public void execute(String schemeId, String templateId, String templateType, String evlObjType, String etlDate,
			PmaFschemeExcelTmpInfo tmpInfo, PmaFschemeExcelTmpInfoService tmpInfoService,
			PmaFschemeExcelCellInfoService cellInfoService, PmaFschemeExcelObjInfoService objInfoService,
			PmaFschemeExcelIndexInfoService indexInfoService, PmaFschemeExcelEvlindexInfoService evlindexInfoService,
			PmaFschemeExcelFormulaInfService formulaInfService, PmaFschemeExcelorgparamInfService orgparamInfService,
			PmaFschemeExcelpstparamInfService pstparamInfService, PmaFschemeExcelsvwInfService svwInfService, 
			PmaFschemeExceldutyInfService dutyInfService, PmaFschemeExcelorgInfService orgInfService,
			PmaFschemeExcelobjidInfService objIdInfService,
			PmaFschemeExcelrunInfo runInfo, PmaFschemeExcelrunInfoService runInfoService,
			PmaFSchemeEvlobjRelMapper evlObjRelMapper, PmaFSchemeEvlobjRelService evlObjRelService) {
		// 提交任务就是将任务对象加入任务队列，等待工作线程去处理
		executorService.execute(new SchemeExcelRunThread(schemeId, templateId, templateType, evlObjType, etlDate,
				tmpInfo, tmpInfoService, cellInfoService, objInfoService, indexInfoService, evlindexInfoService,
				formulaInfService, orgparamInfService, pstparamInfService, svwInfService,
				dutyInfService, orgInfService, objIdInfService,
				runInfo, runInfoService, evlObjRelMapper, evlObjRelService));
	}
}
