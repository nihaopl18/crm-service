package cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.web.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.yusys.yusp.commons.file.FileManagementCilent;
import cn.com.yusys.yusp.commons.file.FileManagementCilentFactory;
import cn.com.yusys.yusp.commons.web.rest.exception.Message;
import cn.com.yusys.yusp.commons.web.rest.exception.YuspException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.domain.PmaFImpFillInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.service.PmaFImpFillInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFImpFillInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-15 17:34:04
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafimpfillinfo")
@Api(tags = "指标值补录")
public class PmaFImpFillInfoResource extends CommonResource<PmaFImpFillInfo, String> {
    @Autowired
    private PmaFImpFillInfoService pmaFImpFillInfoService;
	@Autowired
	private FileManagementCilentFactory fileManagementCilentFactory;
	@Value("${application.excel.temp-file-dir}")
	private String excelTempFileDir;
	
	@Value("${info.file.local-disk-path}")
	private String localDiskPath;
	
    @Override
    protected CommonService getCommonService() {
        return pmaFImpFillInfoService;
    }
	/**
	 * @方法名称: querylist
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
	@GetMapping("/querylist")
	public ResultDto<List<PmaFImpFillInfo>> querylist(QueryModel model) {
		List<PmaFImpFillInfo> list = this.pmaFImpFillInfoService.querylist(model);
		return new ResultDto<List<PmaFImpFillInfo>>(list);
	}
	
	/** 
     * <pre>
     * 功能描述: 模板下载（在服务器上生成模板 ）
     * @Title: downLoadTemplete 
     * @author: chenhx    
     * </pre>
     */ 
	@ApiOperation(value = "模板下载（在服务器上生成模板 ）", notes = "模板下载（在服务器上生成模板 ）")
//	@PostMapping("/downLoadTemplete")
	@GetMapping("/downLoadTemplete")
    public void downLoadTemplete(QueryModel queryModel, HttpServletRequest request, HttpServletResponse response) {
		try {
			this.pmaFImpFillInfoService.export(queryModel, request, response);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
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
	public ResultDto<Map<String,Object>> importTemplete(MultipartFile file) {
//		file.get
		ResultDto<Map<String,Object>> result = new ResultDto<Map<String,Object>>();
		String errMsgs = "";
		List<String> errMsgList = new ArrayList<String>();
		try {
			String fileName = file.getOriginalFilename();
			fileName = URLDecoder.decode(fileName, "UTF-8");
			String fileNameExt = fileName.substring(fileName.lastIndexOf(".") + 1);

			FileManagementCilent fileManagementCilent = this.fileManagementCilentFactory.getFileManagementCilent();
			fileManagementCilent.initConnection();
			String fileRelatePath = fileManagementCilent.uploadFile(file.getBytes(), fileNameExt, null);
			fileManagementCilent.closeConnection();

			errMsgList = pmaFImpFillInfoService.processImport(fileRelatePath, file, fileName);
			List<Map<String,String>> erroList=new ArrayList<Map<String,String>>();
			if(errMsgList != null && errMsgList.size() > 0) {
				for(int i=0;i<errMsgList.size();i++) {
					 Map<String,String> map=new HashMap<String,String>();
					 map.put("errorNa", errMsgList.get(i));
					 erroList.add(map);
				}
				/*for(String errMsg : errMsgList) {
					errMsgs += errMsg + "\n";
				}
				throw new YuspException("500", errMsgs);*/
				 Map<String,Object> map1=new HashMap<String,Object>();
				 map1.put("code", "1");
				 map1.put("erroList", erroList);
				 result.setData(map1);
				
			} else {
			    Map<String,Object> map=new HashMap<String,Object>();
			    map.put("code", "0");
				result.setData(map);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new YuspException(new Message("500", "url转码失败","error"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new YuspException(new Message("500", "文件读取失败","error"));
		} catch (Exception e) {
			e.printStackTrace();
			if(!StringUtils.isEmpty(errMsgs)) {
				throw new YuspException(new Message("500", errMsgs,"error"));
			} else {
				throw new YuspException(new Message("500", "解析excel文件失败，请重新上传","error"));
			}
		}
		return result;
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
    	return pmaFImpFillInfoService.delete(ids);
    }
	
	@ApiOperation(value = "修改指标值", notes = "修改指标值")
    @PostMapping("/modify")
	public ResultDto<PmaFImpFillInfo> modify(@RequestBody PmaFImpFillInfo pmaFImpFillInfo) throws Exception {
    	return pmaFImpFillInfoService.modify(pmaFImpFillInfo);
    }
}
