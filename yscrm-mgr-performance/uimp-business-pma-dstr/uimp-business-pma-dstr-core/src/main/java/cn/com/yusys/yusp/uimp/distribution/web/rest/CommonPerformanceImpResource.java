package cn.com.yusys.yusp.uimp.distribution.web.rest;

import cn.com.yusys.yusp.commons.exception.YuspException;
import cn.com.yusys.yusp.commons.file.FileManagementCilent;
import cn.com.yusys.yusp.commons.file.FileManagementCilentFactory;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.util.MimeMappingUtils;
import cn.com.yusys.yusp.commons.util.SpringContextUtil;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.distr.thread.PerformanceImpThreadManager;
import cn.com.yusys.yusp.uimp.distr.thread.pool.BatchFixedThreadPoolManager;
import cn.com.yusys.yusp.uimp.distribution.model.InvokeDataModel;
import cn.com.yusys.yusp.uimp.distribution.service.CommonPerformanceImpService;
import cn.com.yusys.yusp.uimp.distribution.service.PmaFperformanceTobatchInfService;
import com.ctrip.framework.apollo.core.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: CommonPerformanceImpResource
 * @类描述: # 业绩批量导入接口 资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-01-09 15:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Api(tags = "业绩批量导入接口")
@RestController
@RequestMapping("/api/commonperformanceimp")
public class CommonPerformanceImpResource {
	
	private static final Logger log = LoggerFactory.getLogger(CommonPerformanceImpResource.class);
	
	@Autowired
	private CommonPerformanceImpService commonPerformanceImpService;
	
	@Autowired
	FileManagementCilentFactory fileManagementCilentFactory;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private PmaFperformanceTobatchInfService pmaFperformanceTobatchInfService;
	
	@Autowired
	private PerformanceImpThreadManager performanceImpThreadManager;
	
	public static String filterFunCode(String funCode) {
		funCode = funCode.replace(":", "");
		funCode = funCode.replace("\\", "");
		funCode = funCode.replace("/", "");
		funCode = funCode.replace("..", "");
		funCode = funCode.replace("%00", "");
		funCode = funCode.replace("~", "");
		funCode = funCode.replace("\r", "");
		funCode = funCode.replace("\n", "");
		funCode = funCode.replace("%0a", "");
		funCode = funCode.replace("%0d", "");
		return funCode;
	}
	
	/**
     * @函数名称:queryList
     * @函数描述:列表查询接口
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
	@ApiOperation(value = "列表查询接口")
    @GetMapping("/querylist")
	protected ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = commonPerformanceImpService.queryList(queryModel);
			if (list != null && list.size() > 0) {
				return new ResultDto<List<Map<String, Object>>>(list);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据！");
			}
		} catch (Exception e) {
			result.setCode(-2);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	@GetMapping("/flushprogress")
	public ResultDto<Integer> flushprogress(@RequestParam String exportId) {
		ResultDto<Integer> result = new ResultDto<Integer>();
		Integer process = this.commonPerformanceImpService.flushprogress(exportId);
		result.setData(process);
		return result;
	}
	
	/**
     * @函数名称:exportTemplete
     * @函数描述:导出接口
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "导出接口")
    @GetMapping("/exportTemplete")
	public void exportTemplete(HttpServletRequest request, HttpServletResponse response) {
		String funCode = request.getParameter("funCode"); // 配置代码
		funCode = filterFunCode(funCode);
		String funName = request.getParameter("funName"); // 配置名称
		String excelHeader = request.getParameter("excelHeader"); // excel表头
		String searchParams = request.getParameter("searchParams"); // 查询条件
		String dataAuth = request.getParameter("dataAuth"); // 机构权限
		String dataBussAuth = request.getParameter("dataBussAuth"); // 条线权限
		try {
			// 构造临时下载文件名
			String fileName = funCode + "_" + "disrImportTemp" + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date()) + ".xlsx";
			// 生成 临时下载文件
			File file = commonPerformanceImpService.exportTemplete(fileName, funCode, funName, excelHeader, searchParams,
					dataAuth, dataBussAuth);
			
			byte[] downloadFile = downloadFile(file);
			writeFile(MimeMappingUtils.getEncodeFileName(request, fileName), MimeMappingUtils.getMimeType(fileName), downloadFile, request, response);
		} catch (IOException e) {
			throw new YuspException("500", "业绩批量导入功能,导出模板异常,导出模板读写异常");
		}
	}
	
	/**
     * @函数名称:exportTempleteByManagerId
     * @函数描述:导出接口-客户经理
     * @参数与返回说明:
     * @算法描述:
     * 根据客户经理编号，导出对应业绩的所有分配信息
     */
	@ApiOperation(value = "导出接口-客户经理")
    @GetMapping("/exportTempleteByManagerId")
	public void exportTempleteByManagerId(HttpServletRequest request, HttpServletResponse response) {
		String funCode = request.getParameter("funCode"); // 配置代码
		funCode = filterFunCode(funCode);
		String funName = request.getParameter("funName"); // 配置名称
		String excelHeader = request.getParameter("excelHeader"); // excel表头
		String managerId = request.getParameter("managerId"); // 查询条件
		try {
			// 构造临时下载文件名
			String fileName = funCode + "_" + "disrImportTemp" + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date()) + ".xlsx";
			// 生成 临时下载文件
			File file = commonPerformanceImpService.exportTempleteByManagerId(fileName, funCode, funName, excelHeader, managerId);
			
			byte[] downloadFile = downloadFile(file);
			writeFile(MimeMappingUtils.getEncodeFileName(request, fileName), MimeMappingUtils.getMimeType(fileName), downloadFile, request, response);
		} catch (IOException e) {
			throw new YuspException("500", "业绩批量导入功能,导出模板异常,导出模板读写异常");
		}
	}
	
	/**
     * @函数名称:importTemplete
     * @函数描述:导入文件接口
     * @参数与返回说明:
     * @param funCode 业绩类型
     * @算法描述:
     */
	@ApiOperation(value = "导入文件接口")
    @PostMapping("/importTemplete")
	public ResultDto<String> importTemplete(MultipartFile file, String funCode, String excelHeader) {
		log.info("开始导入EXCEL...");
		long startTime = System.currentTimeMillis();
		ResultDto<String> result = new ResultDto<String>();
		if(StringUtils.isEmpty(funCode) || StringUtils.isEmpty(excelHeader)) {
			throw new YuspException("500", "请求参数funCode, excelHeader为空");
		}
		if(commonPerformanceImpService.checkBatch()) {
			throw new YuspException("500", "系统正在跑批中请稍后处理");
		}
		String errMsgs = "";
		List<String> errMsgList = new ArrayList<String>();
		try {
			String fileName = file.getOriginalFilename();
			fileName = URLDecoder.decode(fileName, "UTF-8");
			String fileNameExt = fileName.substring(fileName.lastIndexOf(".") + 1);

			FileManagementCilent fastDFSClient = this.fileManagementCilentFactory.getFileManagementCilent();
		    fastDFSClient.initConnection();
			String fileRelatePath = fastDFSClient.uploadFile(file.getBytes(), fileNameExt, null);
			fastDFSClient.closeConnection();
			long endTime = System.currentTimeMillis();
			log.info("读取文件，耗时{}秒", (endTime - startTime) / 1000);
			startTime = System.currentTimeMillis();
			errMsgList = commonPerformanceImpService.processImport(funCode, excelHeader, fileRelatePath, file, fileName, fileNameExt);
			endTime = System.currentTimeMillis();
			log.info("导入EXCEL完毕，耗时{}秒", (endTime - startTime) / 1000);
			startTime = System.currentTimeMillis();
			if(errMsgList != null && errMsgList.size() > 0) {
				for(String errMsg : errMsgList) {
					errMsgs += errMsg + "\n";
				}
				throw new YuspException("500", errMsgs);
			} else {
				result.setCode(0);
				result.setMessage("导入成功");
			}
		} catch (UnsupportedEncodingException e) {
			log.error("performanceImp importTemplete UnsupportedEncodingException: ", e);
			throw new YuspException("500", "url转码失败");
		} catch (IOException e) {
			log.error("performanceImp importTemplete IOException: ", e);
			throw new YuspException("500", "文件读取失败");
		} catch (Exception e) {
			if(!StringUtils.isEmpty(errMsgs)) {
				throw new YuspException("500", errMsgs);
			} else {
				log.error("performanceImp importTemplete error: ", e);
				throw new YuspException("500", "解析excel文件失败，请重新上传");
			}
		}
		return result;
	}
	
	public byte[] downloadFile(File file) {
		if (file.exists()) {
			FileInputStream fileInputStream = null;
			try {
				fileInputStream = new FileInputStream(file);
				byte[] buff = fileToByte(fileInputStream, file.length());
				return buff;
			} catch (Exception e) {
				log.error("downloadFile getFileByte error: ", e);
			} finally {
				if (fileInputStream != null) {
					try {
						fileInputStream.close();
					} catch (IOException e) {
						log.error("fileInputStream close error: ", e);
					}
				}
			}
		}
		return null;
	}
	
	private byte[] fileToByte(InputStream inStream, long fileLength) throws IOException {
		byte[] buffer = new byte[262144];
		byte[] fileBuffer = new byte[(int) fileLength];

		int count = 0;
		int length = 0;

		while ((length = inStream.read(buffer)) != -1) {
			for (int i = 0; i < length; ++i) {
				fileBuffer[(count + i)] = buffer[i];
			}
			count += length;
		}
		return fileBuffer;
	}
	
	private void writeFile(String fileName, String mimeType, byte[] fileByte, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.reset();
		response.setContentType(mimeType + ";charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
	}
	
	/**
     * @函数名称:queryResultList
     * @函数描述:批量导入结果页面-列表查询接口
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
	@ApiOperation(value = "批量导入结果页面-列表查询接口")
    @GetMapping("/queryresultlist")
	protected ResultDto<List<Map<String, Object>>> queryResultList(QueryModel queryModel) {
		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = commonPerformanceImpService.queryResultList(queryModel);
			if (list != null && list.size() > 0) {
				return new ResultDto<List<Map<String, Object>>>(list);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据！");
			}
		} catch (Exception e) {
			log.error("resource queryResultList error: ", e);
			result.setCode(-2);
			result.setMessage("系统异常");
		}
		return result;
	}
	
	/**
     * @函数名称:invokeBatchData
     * @函数描述:批次撤销接口
     * @参数与返回说明:
     * @param batchId 批次号
     * @算法描述:
     */
	@ApiOperation(value = "批次撤销接口")
    @PostMapping("/invokeBatchData")
	public ResultDto<String> invokeBatchData(@RequestBody InvokeDataModel invokeDataModel) {
		ResultDto<String> result = new ResultDto<String>();
		if(commonPerformanceImpService.checkBatch()) {
			throw new YuspException("500", "系统正在跑批中请稍后处理");
		}
		if(StringUtils.isEmpty(invokeDataModel.getFunCode()) || StringUtils.isEmpty(invokeDataModel.getBatchId())) {
			throw new YuspException("500", "请求参数funCode、batchId为空");
		}
		try {
			commonPerformanceImpService.invokeBatchData(invokeDataModel.getFunCode(), invokeDataModel.getBatchId());
			result.setCode(0);
			result.setMessage("撤销成功");
		} catch (Exception e) {
			result.setCode(-2);
			result.setMessage("系统异常");
			log.error("performanceImp invokeBatchData error: ", e);
		}
		return result;
	}
	
	/**
     * @函数名称:exportErrData
     * @函数描述:导出错误数据接口
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "导出错误数据接口")
    @GetMapping("/exportErrData")
	public void exportErrData(HttpServletRequest request, HttpServletResponse response) {
		String funCode = request.getParameter("funCode"); // 配置代码
		funCode = filterFunCode(funCode);
		String funName = request.getParameter("funName"); // 配置名称
		String excelHeader = request.getParameter("excelHeader"); // excel表头
		String batchId = request.getParameter("batchId"); // 批次号
		
		try {
			// 构造临时下载文件名
			String fileName = funCode + "_" + "disrExportErr" + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date()) + ".xlsx";
			// 生成 临时下载文件
			File file = commonPerformanceImpService.exportErrData(fileName, funCode, funName, excelHeader, batchId);
			
			byte[] downloadFile = downloadFile(file);
			writeFile(MimeMappingUtils.getEncodeFileName(request, fileName), MimeMappingUtils.getMimeType(fileName), downloadFile, request, response);
		} catch (IOException e) {
			log.error("performanceImp exportErrData error: ", e);
			throw new YuspException("500", "业绩批量导入功能,导出错误数据接口读写异常");
		}
	}
	
	/**
     * @函数名称:importErrData
     * @函数描述:导入错误数据文件接口
     * @参数与返回说明:
     * @param batchId 批次号
     * @param funCode 业绩类型
     * @param excelHeader excel表头
     * @算法描述:
     */
	@ApiOperation(value = "导入错误数据文件接口")
    @PostMapping("/importErrData")
	public ResultDto<String> importErrData(MultipartFile file, String batchId, String funCode, String excelHeader) {
		ResultDto<String> result = new ResultDto<String>();
		if(StringUtils.isEmpty(funCode) || StringUtils.isEmpty(excelHeader)) {
			throw new YuspException("500", "请求参数funCode, excelHeader为空");
		}
		if(commonPerformanceImpService.checkBatch()) {
			throw new YuspException("500", "系统正在跑批中请稍后处理");
		}
		String errMsgs = "";
		List<String> errMsgList = new ArrayList<String>();
		try {
			String fileName = file.getOriginalFilename();
			fileName = URLDecoder.decode(fileName, "UTF-8");
			String fileNameExt = fileName.substring(fileName.lastIndexOf(".") + 1);

			FileManagementCilent fastDFSClient = this.fileManagementCilentFactory.getFileManagementCilent();
		    fastDFSClient.initConnection();
			String fileRelatePath = fastDFSClient.uploadFile(file.getBytes(), fileNameExt, null);
			fastDFSClient.closeConnection();
			errMsgList = commonPerformanceImpService.processErrImport(batchId, funCode, excelHeader, fileRelatePath, file, fileName, fileNameExt);
			if(errMsgList != null && errMsgList.size() > 0) {
				for(String errMsg : errMsgList) {
					errMsgs += errMsg + "\n";
				}
				throw new YuspException("500", errMsgs);
			} else {
				result.setCode(0);
				result.setMessage("导入成功");
			}
		} catch (UnsupportedEncodingException e) {
			log.error("performanceImp importErrData UnsupportedEncodingException: ", e);
			throw new YuspException("500", "url转码失败");
		} catch (IOException e) {
			log.error("performanceImp importErrData IOException: ", e);
			throw new YuspException("500", "文件读取失败");
		} catch (Exception e) {
			if(!StringUtils.isEmpty(errMsgs)) {
				throw new YuspException("500", errMsgs);
			} else if(e.getCause() != null && e.getCause().getMessage() != null && e.getCause().getMessage().indexOf("ORA-00001") >= 0) {	// 判断是 违反唯一约束条件
				throw new YuspException("500", "存在业绩分配审批中的数据，请在业绩分配完成后重新导入");
			} else {
				log.error("performanceImp importErrData error: ", e);
				throw new YuspException("500", "解析excel文件失败，请重新上传");
			}
		}
		return result;
	}
	
	/**
     * @函数名称:processWorkFlow
     * @函数描述:执行/发起工作流接口
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "执行/发起工作流接口")
    @PostMapping("/processWorkFlow")
	public ResultDto<String> processWorkFlow(@RequestBody Map<String,Object> map) {
		ResultDto<String> result = new ResultDto<String>();
		int a = 0 ;
		if(map.get("batchId") == null || StringUtils.isEmpty(map.get("batchId") + "") || 
				map.get("funCode") == null || StringUtils.isEmpty(map.get("funCode") + "")) {
			throw new YuspException("500", "请求参数batchId, funCode为空");
		}
		try {
			Map<String, Object> retMap = commonPerformanceImpService.processWorkFlow(map.get("batchId") + "", map.get("funCode") + "");
			if(retMap != null) {	// retMap非空，表示需要异步调用工作流
				// 异步发起审批流
				performanceImpThreadManager.process((String) retMap.get("funCode"), (String) retMap.get("batchId"), 
						(List<Map<String, Object>>) retMap.get("instanceList"), (List<String>) retMap.get("pkList"), (String) retMap.get("periodHisTableName"), 
						(String) retMap.get("dtlTableName"), (Boolean) retMap.get("isReStartWf"), (String) retMap.get("workFlow"), 
						(BatchFixedThreadPoolManager) retMap.get("batchFixedThreadPoolManager"), (String) retMap.get("userId"));
			}
			result.setCode(0);
			result.setMessage("执行成功");
			return result;
		} catch (Exception e) {
			if("over syn-execute-max-size".equals(e.getMessage())) {
				result.setCode(-9);
				result.setMessage("待执行数据过多，请耐心等待");
				return result;
			} else {
				log.error("performanceImp processWorkFlow error: ", e);
				throw new YuspException("500", e.getMessage());
			}
		}
	}
	
	/**
     * @函数名称:reInitWorkFlow
     * @函数描述:重新发起工作流接口
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "重新发起工作流接口")
    @PostMapping("/reInitWorkFlow")
	public ResultDto<String> reInitWorkFlow(@RequestBody Map<String,Object> map) {
		ResultDto<String> result = new ResultDto<String>();
		if(map.get("batchId") == null || StringUtils.isEmpty(map.get("batchId") + "") || 
				map.get("funCode") == null || StringUtils.isEmpty(map.get("funCode") + "")) {
			throw new YuspException("500", "请求参数batchId, funCode为空");
		}
		try {
			commonPerformanceImpService.reInitWorkFlow(map.get("batchId") + "", map.get("funCode") + "");
			result.setCode(0);
			result.setMessage("执行成功");
			return result;
		} catch (Exception e) {
			log.error("performanceImp reInitWorkFlow error: ", e);
			throw new YuspException("500", "执行失败");
		}
	}
	
	@GetMapping("/exportTempleteAsync")
	public ResultDto<String> exportTempleteAsync(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("【批量导出】导出EXCEL模板开始...");
		long startTime = System.currentTimeMillis();
		ResultDto<String> result = new ResultDto<String>();
		String funCode = request.getParameter("funCode"); // 配置代码
		funCode = filterFunCode(funCode);
		String funName = request.getParameter("funName"); // 配置名称
		String excelHeader = request.getParameter("excelHeader"); // excel表头
		String newexcelHeader = URLDecoder.decode(excelHeader,"UTF-8");
		String searchParams = request.getParameter("searchParams"); // 查询条件
		String newsearchParams = URLDecoder.decode(searchParams,"UTF-8");
		String dataAuth = request.getParameter("dataAuth"); // 机构权限
		String dataBussAuth = request.getParameter("dataBussAuth"); // 条线权限
		try {
			StringRedisTemplate stringRedisTemplate = SpringContextUtil.getBean("stringRedisTemplate");
			// 构造临时下载文件名
			String fileName = funCode + "_" + "disrImportTemp" + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date()) + ".xlsx";
			// 生成 临时下载文件
			commonPerformanceImpService.exportTempleteAsync(fileName, funCode, funName, newexcelHeader, newsearchParams, dataAuth, dataBussAuth, userInfoService.getGrantOrgCode());
			stringRedisTemplate.opsForValue().set("EXCEL_EXPORTID_" + fileName, "0");
			result.setCode(0);
			result.setData(fileName);
			long endTime = System.currentTimeMillis();
			log.debug("【批量导出】导出EXCEL模板结束,耗时{}秒", (endTime - startTime) / 1000);
			return result;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new YuspException("500", "业绩批量导入功能,导出模板异常,导出模板读写异常");
		}
	}
	
	/**
     * @函数名称:asynProcessWorkFlow
     * @函数描述:异步执行/发起工作流接口
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "异步执行/发起工作流接口")
    @PostMapping("/asynprocessWorkFlow")
	public ResultDto<String> asynProcessWorkFlow(@RequestBody Map<String,Object> map) {
		ResultDto<String> result = new ResultDto<String>();
		if(map.get("batchId") == null || StringUtils.isEmpty(map.get("batchId") + "") || 
				map.get("funCode") == null || StringUtils.isEmpty(map.get("funCode") + "")) {
			throw new YuspException("500", "请求参数batchId, funCode为空");
		}
		try {
			pmaFperformanceTobatchInfService.addToBatchInf(map.get("batchId") + "", map.get("funCode") + "", 
					userInfoService.getUserInfo().getLoginCode(),
					userInfoService.getUserInfo().getRoles().get(0).getCode(),
					userInfoService.getOrgLevel(), userInfoService.getUserInfo().getOrg().getCode(), 
					userInfoService.getGrantOrgCode(), "");
			result.setCode(0);
			result.setMessage("发起执行成功");
			return result;
		} catch (Exception e) {
			log.error("performanceImp asynProcessWorkFlow error: ", e);
			throw new YuspException("500", "系统异常");
		}
	}
}