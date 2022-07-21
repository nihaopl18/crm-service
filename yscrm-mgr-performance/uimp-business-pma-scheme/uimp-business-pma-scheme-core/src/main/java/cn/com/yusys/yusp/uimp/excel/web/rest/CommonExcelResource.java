package cn.com.yusys.yusp.uimp.excel.web.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.com.yusys.yusp.commons.file.FileManagementCilent;
import cn.com.yusys.yusp.commons.file.FileManagementCilentFactory;
import cn.com.yusys.yusp.commons.util.file.FileTypeUtil;
import cn.com.yusys.yusp.commons.web.rest.exception.Message;
import cn.com.yusys.yusp.commons.web.rest.exception.YuspException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.yuchengtech.report.frame.spreadjs.service.ExcelReaderFactory;
import com.yuchengtech.report.frame.spreadjs.service.IExcelReader;
import com.yuchengtech.report.frame.spreadjs.service.SpreadExportException;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelgrantInf;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelhideInf;
import cn.com.yusys.yusp.uimp.excel.model.ExcelDataModel;
import cn.com.yusys.yusp.uimp.excel.model.ExcelFileModel;
import cn.com.yusys.yusp.uimp.excel.model.ExcelPublishModel;
import cn.com.yusys.yusp.uimp.excel.model.ExcelQuoteModel;
import cn.com.yusys.yusp.uimp.excel.model.ExcelRunModel;
import cn.com.yusys.yusp.uimp.excel.service.CommonExcelService;
import cn.com.yusys.yusp.uimp.spread.service.SchemeSpreadWriterFactory;
import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.util.StringUtil;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: CommonExcelResource
 * @类描述: # 考核方案Excel组件 资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-07 15:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/commonexcel")
public class CommonExcelResource {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExcelResource.class);
	
	@Autowired
	private CommonExcelService commonExcelService;

	@Autowired
	FileManagementCilentFactory fileManagementCilentFactory;
	
	@Value("${info.file.local-disk-path}")
	private String localDiskPath;
	
	@Value("${application.excel.temp-file-dir}")
	private String excelTempFileDir;
	
    /**
	 * @方法名称: indexSelectorQuerylist
	 * @方法描述: 考核方案-指标放大镜-查询列表数据(分页)
	 * @参数与返回说明: 
	 * @param model: condition-type: 1基础指标  2派生指标 0基础/派生都查询
	 * @算法描述: 
	 *   支持查询基础指标、派生指标数据
	 *   返回数据包含指标维度信息
	 */
	@ApiOperation(value = "考核方案-指标放大镜-查询列表数据(分页)", notes = "考核方案-指标放大镜-查询列表数据(分页)")
	@GetMapping("/indexselectorquerylist")
	public ResultDto<List<Map<String, Object>>> indexSelectorQuerylist(QueryModel model) {
		List<Map<String, Object>> list = commonExcelService.indexSelectorQuerylist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @方法名称: queryIndexNameByIndexId
	 * @方法描述: 根据指标编号，查询指标名称，包括基础指标/派生指标
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@GetMapping("/queryindexnamebyindexid")
	public ResultDto<String> queryIndexNameByIndexId(@RequestParam("indexIds") String indexIds) throws Exception {
		ResultDto<String> result = new ResultDto<String>();
    	if(StringUtil.isNotEmpty(indexIds)) {
    		String resultStr = commonExcelService.queryIndexNameByIndexId(indexIds);
    		if("-1".equals(resultStr)) {
    			result.setCode(-2);
       		  	result.setMessage("服务器忙，请稍后重试！");
    		} else if(StringUtil.isEmpty(resultStr)) {
    			result.setCode(-3);
       		  	result.setMessage("无相关数据！");
    		} else {
    			result.setCode(0);
       		  	result.setMessage("操作成功！");
       		  	result.setData(resultStr);
    		}
    	} else {
    		result.setCode(-1);
   		  	result.setMessage("请求参数错误！");
    	}
    	return result;
	}
    
	/**
     * @函数名称:uploadExcelStyle
     * @函数描述:样式excel文件上传
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/uploadexcelstyle")
	public ResultDto<String> uploadExcelStyle(MultipartFile file, HttpServletResponse response) {
		ResultDto<String> result = new ResultDto<String>();
		Map<String, Object> info = new HashMap<String, Object>();
		try {
			String fileName = file.getOriginalFilename();
			fileName = URLDecoder.decode(fileName, "UTF-8");
			String fileNameExt = fileName.substring(fileName.lastIndexOf(".") + 1);

			FileManagementCilent fastDFSClient = fileManagementCilentFactory.getFileManagementCilent();
		    fastDFSClient.initConnection();
			String fileRelatePath = fastDFSClient.uploadFile(file.getBytes(), fileNameExt, null);
			fastDFSClient.closeConnection();
			String filePath = this.localDiskPath + (this.localDiskPath.endsWith(File.separatorChar + "") ? "" : File.separatorChar) + fileRelatePath;
			File uploadFile = new File(filePath);
			IExcelReader reader = ExcelReaderFactory.createReader(uploadFile);
			info = reader.readString();
			uploadFile.delete();
			String message = JSON.toJSONString(info);
			result.setData(message);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new YuspException(new Message("500", "url转码失败","error"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new YuspException(new Message("500", "文件读取失败","error"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new YuspException(new Message("500", "解析excel文件失败，请重新上传","error"));
		}
		return result;
	}
    
    /**
     * @函数名称:saveTemplateAndDesignData
     * @函数描述:保存模板数据及单元格信息数据
     * @参数与返回说明:
     *   返回更新后考核方案对应的模板ID
     * @算法描述:
     */
    @PostMapping("/savetemplateanddesigndata")
	public ResultDto<String> saveTemplateAndDesignData(@RequestBody ExcelDataModel excelDataModel) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		String templateId = commonExcelService.saveTemplateAndDesignData(excelDataModel);
    		result.setData(templateId);
    	} catch (Exception e) {
    		logger.error("resource saveTemplateAndDesignData error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
        return result;
    }
    
    /**
     * @函数名称:getDesignInfoBySchemeId
     * @函数描述:根据考核方案ID，查询excel设计器信息
     * @参数与返回说明:
     * {
     *   tmpInfo: {},  考核方案报表模板数据
     *   commonArray: [],	一般单元格数据集
     *   evalobjArray: [],  考核对象单元格数据集
     *   idxArray: [],  基础指标单元格数据集
     *   evlidxArray: [],  派生指标单元格数据集
     *   formulaArray: [],  公式单元格数据集
     *   orgParamArray: [],  机构参数数据集
     *   postParamArray: [],  岗位参数数据集
     *   svwArray: [],	得分/计价/权重数据集
     *   dutyArray: [], 岗位数据集
     *   orgArray: [], 所属机构数据集
     *   objIdArray: [] 考核对象编号数据集
     * }
     * @算法描述:
     */
    @GetMapping("/getdesigninfobyschemeid/{schemeId}")
    public ResultDto<Map<String, Object>> getDesignInfoBySchemeId(@PathVariable("schemeId") String schemeId) {
    	ResultDto<Map<String, Object>> result = new ResultDto<Map<String, Object>>();
    	try {
    		Map<String, Object> retMap = commonExcelService.getDesignInfoBySchemeId(schemeId);
    		result.setData(retMap);
    	} catch (Exception e) {
    		logger.error("resource getDesignInfoBySchemeId error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @函数名称:getEvlObjBySchemeId
     * @函数描述:根据考核方案ID，查询该考核方案所有考核对象数据
     * @参数与返回说明:
     * {
     *   id: '',  考核对象编号
     *   pId: '03',	默认值03，表示上级节点id
     *   name: '',  考核对象名称
     *   type: '1'  默认值1，表示叶子节点
     * }
     * @算法描述:
     */
    @GetMapping("/getevlobjbyschemeid/{schemeId}")
    public ResultDto<List<Map<String, Object>>> getEvlObjBySchemeId(@PathVariable("schemeId") String schemeId) {
    	ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
    	try {
    		List<Map<String, Object>> retMap = commonExcelService.getEvlObjBySchemeId(schemeId);
    		result.setData(retMap);
    	} catch (Exception e) {
    		logger.error("resource getEvlObjBySchemeId error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @函数名称:getPreviewInfo
     * @函数描述:获取方案预览数据
     * @参数与返回说明:
     * {
     *   tmpInfo: {},  考核方案报表模板数据
     *   commonArray: [],	一般单元格数据集
     *   evalobjArray: [],  考核对象单元格数据集
     *   idxArray: [],  基础指标单元格数据集
     *   evlidxArray: [],  派生指标单元格数据集
     *   formulaArray: [],  公式单元格数据集
     *   orgParamArray: [],  机构参数数据集
     *   postParamArray: [],  岗位参数数据集
     *   svwArray: [],	得分/计价/权重数据集
     *   dutyArray: [], 岗位数据集
     *   orgArray: [], 所属机构数据集
     *   objIdArray: [] 考核对象编号数据集
     * }
     * @算法描述:
     */
    @GetMapping("/getpreviewinfo")
    public ResultDto<Map<String, Object>> getPreviewInfo(@RequestParam("schemeId") String schemeId, 
    		@RequestParam("etlDate") String etlDate, @RequestParam(name="evlObjId", required=false) String evlObjId) {
    	ResultDto<Map<String, Object>> result = new ResultDto<Map<String, Object>>();
    	try {
    		Map<String, Object> retMap = commonExcelService.getPreviewInfo(schemeId, etlDate, evlObjId);
    		result.setData(retMap);
    	} catch (Exception e) {
    		logger.error("resource getPreviewInfo error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @函数名称:runScheme
     * @函数描述:运行考核方案
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/runscheme")
	public ResultDto<String> runScheme(@RequestBody ExcelRunModel excelRunModel) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		Integer code = commonExcelService.runScheme(excelRunModel);
			if(code == -9) {
    			result.setCode(code);
    			result.setMessage("运行失败，请检查请求数据是否正确");
    		}
    	} catch (Exception e) {
    		logger.error("resource runScheme error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
        return result;
    }
    
    /**
     * @函数名称:checkRunResultInfo
     * @函数描述:校验方案运行结果数据是否存在
     * @参数与返回说明:
     * @算法描述:
     * 从方案运行的备份表中校验方案运行结果数据是否存在
     */
    @GetMapping("/checkrunresultinfo")
    public ResultDto<Map<String, Object>> checkRunResultInfo(@RequestParam("schemeId") String schemeId, 
    		@RequestParam("etlDate") String etlDate, @RequestParam(name="evlObjId", required=false) String evlObjId) {
    	ResultDto<Map<String, Object>> result = new ResultDto<Map<String, Object>>();
    	try {
    		Integer code = commonExcelService.checkRunResultInfo(schemeId, etlDate, evlObjId);
    		result.setCode(code);
    		if(code == -1) {
    			result.setMessage("该考核方案在日期" + etlDate + "未运行");
    		} else if(code == -9) {
    			result.setMessage("请求参数错误");
    		}
    	} catch (Exception e) {
    		logger.error("resource checkRunResultInfo error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @函数名称:getRunResultInfo
     * @函数描述:获取方案运行结果数据
     * @参数与返回说明:
     * {
     *   tmpInfo: {},  考核方案报表模板数据
     *   commonArray: [],	一般单元格数据集
     *   evalobjArray: [],  考核对象单元格数据集
     *   idxArray: [],  基础指标单元格数据集
     *   evlidxArray: [],  派生指标单元格数据集
     *   formulaArray: [],  公式单元格数据集
     *   orgParamArray: [],  机构参数数据集
     *   postParamArray: [],  岗位参数数据集
     *   svwArray: [],	得分/计价/权重数据集
     *   dutyArray: [], 岗位数据集
     *   orgArray: [], 所属机构数据集
     *   objIdArray: [], 考核对象编号数据集
     *   hideInfo: {	隐藏行/列数据集
     *     cols: '',    隐藏列索引，$分割
     *     rows: ''     隐藏行索引，$分割
     *   }
     * }
     * @算法描述:
     * 从方案运行的备份表中获取方案运行结果数据
     */
    @GetMapping("/getrunresultinfo")
    public ResultDto<Map<String, Object>> getRunResultInfo(@RequestParam("schemeId") String schemeId, 
    		@RequestParam("etlDate") String etlDate, @RequestParam(name="evlObjId", required=false) String evlObjId) {
    	ResultDto<Map<String, Object>> result = new ResultDto<Map<String, Object>>();
    	try {
    		Map<String, Object> retMap = commonExcelService.getRunResultInfo(schemeId, etlDate, evlObjId);
    		result.setData(retMap);
    	} catch (Exception e) {
    		logger.error("resource getRunResultInfo error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @函数名称:getSchemeRunInfoList
     * @函数描述:考核方案运行状态信息列表查询接口
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
    @GetMapping("/getschemeruninfolist")
	protected ResultDto<List<Map<String, Object>>> getSchemeRunInfoList(QueryModel queryModel) {
		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = commonExcelService.getSchemeRunInfoList(queryModel);
			if (list != null && list.size() > 0) {
				return new ResultDto<List<Map<String, Object>>>(list);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据！");
			}
		} catch (Exception e) {
			logger.error("resource getSchemeRunInfoList error !");
			result.setCode(-2);
			result.setMessage("系统异常");
			e.printStackTrace();
		}
		return result;
	}
    
    /**
     * @函数名称:pubScheme
     * @函数描述:发布考核方案
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/pubscheme")
	public ResultDto<String> pubScheme(@RequestBody ExcelPublishModel excelPublishModel) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		Integer code = commonExcelService.pubScheme(excelPublishModel);
			if(code == -9) {
    			result.setCode(code);
    			result.setMessage("发布失败，请检查请求数据是否正确");
    		}
    	} catch (Exception e) {
    		logger.error("resource runScheme error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
        return result;
    }
    
    /**
     * @函数名称:getSchemeHideInfo
     * @函数描述:考核方案发布隐藏行列信息查询接口
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getschemehideinfo")
	protected ResultDto<PmaFschemeExcelhideInf> getSchemeHideInfo(@RequestParam("schemeId") String schemeId, 
			@RequestParam("etlDate") String etlDate) {
		ResultDto<PmaFschemeExcelhideInf> result = new ResultDto<PmaFschemeExcelhideInf>();
		try {
			PmaFschemeExcelhideInf hideInf = commonExcelService.getSchemeHideInfo(schemeId, etlDate);
			if (hideInf != null) {
				result.setData(hideInf);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据！");
			}
		} catch (Exception e) {
			logger.error("resource getSchemeHideInfo error !");
			result.setCode(-2);
			result.setMessage("系统异常");
			e.printStackTrace();
		}
		return result;
	}
    
    /**
     * @函数名称:getMySchemeInfoList
     * @函数描述:获取我的考核方案列表数据
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getmyschemeinfolist")
    public ResultDto<List<Map<String, Object>>> getMySchemeInfoList(QueryModel queryModel) {
    	ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
    	try {
    		result.setData(commonExcelService.getMySchemeInfoList(queryModel));
    	} catch (Exception e) {
    		logger.error("resource getMySchemeInfoList error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @函数名称:getMySchemeResultInfo
     * @函数描述:获取我的考核方案运行结果数据
     * @参数与返回说明:
     * {
     *   tmpInfo: {},  考核方案报表模板数据
     *   commonArray: [],	一般单元格数据集
     *   evalobjArray: [],  考核对象单元格数据集
     *   idxArray: [],  基础指标单元格数据集
     *   evlidxArray: [],  派生指标单元格数据集
     *   formulaArray: [],  公式单元格数据集
     *   orgParamArray: [],  机构参数数据集
     *   postParamArray: [],  岗位参数数据集
     *   svwArray: [],	得分/计价/权重数据集
     *   dutyArray: [], 岗位数据集
     *   orgArray: [], 所属机构数据集
     *   objIdArray: [], 考核对象编号数据集
     *   hideInfo: {	隐藏行/列数据集
     *     cols: '',    隐藏列索引，$分割
     *     rows: ''     隐藏行索引，$分割
     *   }
     * }
     * @算法描述:
     * 从方案运行的备份表中获取我的考核方案运行结果数据
     */
    @GetMapping("/getmyschemeresultinfo")
    public ResultDto<Map<String, Object>> getMySchemeResultInfo(@RequestParam("schemeId") String schemeId, 
    		@RequestParam("etlDate") String etlDate) {
    	ResultDto<Map<String, Object>> result = new ResultDto<Map<String, Object>>();
    	try {
    		Map<String, Object> retMap = commonExcelService.getMySchemeResultInfo(schemeId, etlDate);
    		result.setData(retMap);
    	} catch (Exception e) {
    		logger.error("resource getMySchemeResultInfo error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @函数名称:getOrgStaffSchemeInfoList
     * @函数描述:获取机构辖内员工考核方案列表数据
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getorgstaffschemeinfolist")
    public ResultDto<List<Map<String, Object>>> getOrgStaffSchemeInfoList(QueryModel queryModel) {
    	ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
    	try {
    		result.setData(commonExcelService.getOrgStaffSchemeInfoList(queryModel));
    	} catch (Exception e) {
    		logger.error("resource getOrgStaffSchemeInfoList error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @函数名称:getOrgStaffSchemeResultInfo
     * @函数描述:获取机构辖内员工考核方案运行结果数据
     * @参数与返回说明:
     * {
     *   tmpInfo: {},  考核方案报表模板数据
     *   commonArray: [],	一般单元格数据集
     *   evalobjArray: [],  考核对象单元格数据集
     *   idxArray: [],  基础指标单元格数据集
     *   evlidxArray: [],  派生指标单元格数据集
     *   formulaArray: [],  公式单元格数据集
     *   orgParamArray: [],  机构参数数据集
     *   postParamArray: [],  岗位参数数据集
     *   svwArray: [],	得分/计价/权重数据集
     *   dutyArray: [], 岗位数据集
     *   orgArray: [], 所属机构数据集
     *   objIdArray: [], 考核对象编号数据集
     *   hideInfo: {	隐藏行/列数据集
     *     cols: '',    隐藏列索引，$分割
     *     rows: ''     隐藏行索引，$分割
     *   }
     * }
     * @算法描述:
     * 从方案运行的备份表中获取机构辖内员工考核方案运行结果数据
     */
    @GetMapping("/getorgstaffschemeresultinfo")
    public ResultDto<Map<String, Object>> getOrgStaffSchemeResultInfo(@RequestParam("schemeId") String schemeId, 
    		@RequestParam("etlDate") String etlDate, @RequestParam(name="evlObjId", required=false) String evlObjId) {
    	ResultDto<Map<String, Object>> result = new ResultDto<Map<String, Object>>();
    	try {
    		Map<String, Object> retMap = commonExcelService.getOrgStaffSchemeResultInfo(schemeId, etlDate, evlObjId);
    		result.setData(retMap);
    	} catch (Exception e) {
    		logger.error("resource getOrgStaffSchemeResultInfo error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @函数名称:getGrantInfBySchemeId
     * @函数描述:获取考核方案授权信息
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getgrantinfbyschemeid")
    public ResultDto<List<PmaFschemeExcelgrantInf>> getGrantInfBySchemeId(QueryModel queryModel) {
    	ResultDto<List<PmaFschemeExcelgrantInf>> result = new ResultDto<List<PmaFschemeExcelgrantInf>>();
    	try {
    		List<PmaFschemeExcelgrantInf> list = commonExcelService.getGrantInfBySchemeId(queryModel);
    		return new ResultDto<List<PmaFschemeExcelgrantInf>>(list);
    	} catch (Exception e) {
    		logger.error("resource getGrantInfBySchemeId error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @函数名称: addGrantInf
     * @函数描述: 新增  考核方案授权信息
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/addgrantinf")
    protected ResultDto<String> addGrantInf(@RequestBody PmaFschemeExcelgrantInf record) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		String res = commonExcelService.addGrantInf(record);
    		if("-9".equals(res)) {
    			result.setCode(-9);
    			result.setMessage("参数为空");
    		} else if("-3".equals(res)) {
    			result.setCode(-3);
    			result.setMessage("授权信息重复");
    		} else {
    			result.setCode(0);
    			result.setMessage("新增成功");
    			result.setData(res);
    		}
    	} catch (Exception e) {
    		logger.error("resource addGrantInf error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
        return result;
    }
    
    /**
     * @函数名称: deleteGrantInf
     * @函数描述: 批量删除授权信息 
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/deletegrantinf")
    protected ResultDto<String> deleteGrantInf(@RequestBody String ids) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		Integer code = commonExcelService.deleteGrantInf(ids);
    		if(code == -9) {
    			result.setCode(code);
    			result.setMessage("参数为空");
    		} else {
    			result.setCode(0);
    			result.setMessage("删除成功");
    		}
    	} catch (Exception e) {
    		logger.error("resource deleteGrantInf error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
        return result;
    }
    
    /**
     * @方法名称: getQuoteSchemeInf
     * @方法描述: 查询-可以引用的考核方案信息
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getquoteschemeinf")
    public ResultDto<List<PmaFschemeExcelgrantInf>> getQuoteSchemeInf(QueryModel queryModel) {
    	ResultDto<List<PmaFschemeExcelgrantInf>> result = new ResultDto<List<PmaFschemeExcelgrantInf>>();
    	try {
    		List<PmaFschemeExcelgrantInf> list = commonExcelService.getQuoteSchemeInf(queryModel);
    		result.setData(list);
    	} catch (Exception e) {
    		logger.error("resource getQuoteSchemeInf error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @函数名称: quoteSchemeInf
     * @函数描述: 引用考核方案信息 
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/quoteschemeinf")
    protected ResultDto<String> quoteSchemeInf(@RequestBody ExcelQuoteModel model) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		Integer code = commonExcelService.quoteSchemeInf(model);
    		if(code == -9) {
    			result.setCode(code);
    			result.setMessage("参数为空");
    		} else {
    			result.setCode(0);
    			result.setMessage("引用成功");
    		}
    	} catch (Exception e) {
    		logger.error("resource quoteSchemeInf error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
        return result;
    }
    
    /**
     * @函数名称:makeSchemeExcelFile
     * @函数描述:创建考核方案excel文件
     * @参数与返回说明:
     * @return excel文件绝对路径
     * @算法描述:
     */
    @PostMapping("/makeschemeexcelfile")
	public ResultDto<String> makeSchemeExcelFile(@RequestBody ExcelFileModel model) {
    	ResultDto<String> result = new ResultDto<String>();
		try {
			String title = model.getTitle(); // excel文件标题
			String schemeId = model.getSchemeId(); // 考核方案编号
			String etlDate = model.getEtlDate(); // 数据日期
			String jsonStr = model.getJsonStr(); // excel内容json
			// 构造临时下载文件名
			String fileName = title + "-" + schemeId + "-" + etlDate + ".xlsx";
			// 生成 临时下载文件
			String filePath = this.excelTempFileDir;
			if (!filePath.endsWith(File.separator)) {
				filePath += File.separator;
			}
			filePath += File.separator;
			File pathFile = new File(filePath + File.separator + "downLoad" + File.separator + fileName);
			if (!pathFile.exists()) {
				pathFile.getParentFile().mkdirs();
			}
			// 设置excel-sheet内容
			SchemeSpreadWriterFactory.createWriter("xlsx", pathFile).write(jsonStr);
			result.setCode(0);
			result.setData(fileName);
		} catch (InvalidFormatException | SpreadExportException e) {
			logger.error("analysis jsonStr error !");
			result.setCode(-9);
			result.setMessage("请检查json格式是否正确");
    		e.printStackTrace();
		} catch (Exception e) {
			logger.error("resource makeSchemeExcelFile error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
		}
		return result;
	}
    
	public static String filterFilePath(String filePath) {
		filePath = filePath.replace(":", "");
		filePath = filePath.replace("\\", "");
		filePath = filePath.replace("/", "");
		filePath = filePath.replace("..", "");
		filePath = filePath.replace("%00", "");
		filePath = filePath.replace("~", "");
		filePath = filePath.replace("\r", "");
		filePath = filePath.replace("\n", "");
		filePath = filePath.replace("%0a", "");
		filePath = filePath.replace("%0d", "");
		return filePath;
	}
    
    /**
     * @函数名称:downloadSchemeExcelFile
     * @函数描述:下载考核方案excel文件
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/downloadschemeexcelfile")
	public void downloadSchemeExcelFile(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		String filePath = request.getParameter("filePath");	// 文件名,非文件路径
    		filePath = filterFilePath(filePath);
    		// 生成 临时下载文件
			String fileAbsolutePath = this.excelTempFileDir;
			if (!fileAbsolutePath.endsWith(File.separator)) {
				fileAbsolutePath += File.separator;
			}
			fileAbsolutePath += File.separator;
			// 生成 临时下载文件
			File file = new File(fileAbsolutePath + File.separator + "downLoad" + File.separator + filePath);
			byte[] downloadFile = downloadFile(file);
			writeFile(FileTypeUtil.getEncodeFileName(request, file.getName()), FileTypeUtil.getMimeType(file.getName()), downloadFile, request, response);
		} catch (IOException e) {
			e.printStackTrace();
			throw new YuspException(new Message("500", "导出考核方案excel文件异常","error"));
		}
	}
    
    public byte[] downloadFile(File file) {
		if (file.exists()) {
			FileInputStream fileInputStream = null;
			try {
				fileInputStream = new FileInputStream(file);
				byte[] buff = fileToByte(fileInputStream, file.length());
				return buff;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fileInputStream != null) {
					try {
						fileInputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
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
	 * @方法名称: del
	 * @方法描述: 删除数据
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "删除数据", notes = "删除数据")
    @PostMapping("/delete")
	public ResultDto<Integer> del(@RequestBody String ids) {
    	return commonExcelService.del(ids);
    }
	
	/**
     * @函数名称:getSchemeResultInfo
     * @函数描述:APP-查询员工/机构考核方案运行结果数据
     * @参数与返回说明:
     * @param tpye: 1员工  2机构
     * @算法描述:
     * 查询已发布的考核方案中：基础指标、派生指标、机构/岗位参数结果值
     * 员工：考核对象是当前登录人的数据
     * 机构：考核对象是当前登录人授权机构及下辖的数据
     */
    @GetMapping("/app/getschemeresultinfo")
    public ResultDto<Map<String, Object>> getSchemeResultInfo(@RequestParam("type") String type, @RequestParam("schemeId") String schemeId, 
    		@RequestParam("etlDate") String etlDate) {
    	ResultDto<Map<String, Object>> result = new ResultDto<Map<String, Object>>();
    	try {
    		Map<String, Object> retMap = commonExcelService.getSchemeResultInfo(type, schemeId, etlDate);
    		result.setData(retMap);
    	} catch (Exception e) {
    		logger.error("resource getSchemeResultInfo error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
}
