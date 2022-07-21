package cn.com.yusys.yscrm.custflexEs.web.rest;

import cn.com.yusys.yscrm.custflexEs.domain.CrmFCiFqDbcol;
import cn.com.yusys.yscrm.custflexEs.domain.FileVO;
import cn.com.yusys.yscrm.custflexEs.model.*;
import cn.com.yusys.yscrm.custflexEs.service.CmssFCiFqService;
import cn.com.yusys.yscrm.custflexEs.vo.CrmFCiFqObjNodeVo;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.util.StringUtil;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CmssFCiFqResource
 * @类描述: #灵活查询 公共资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-29 12:31:44
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Api(tags = "灵活查询")
@RestController
@RequestMapping("/api/cmssfcifq")
public class CmssFCiFqResource {
	
	private static final Logger log = LoggerFactory.getLogger(CmssFCiFqResource.class);
	
	@Autowired
	private CmssFCiFqService cmssFCiFqService;

	@Value("${application.localDiskPath}")
	private String export;
	/**
     * @函数名称:queryFqTreeData
     * @函数描述:查询灵活查询左侧树数据
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "查询灵活查询左侧树数据", notes = "灵活查询组件-查询左侧树数据")
    @GetMapping("/queryfqtreedata")
	protected ResultDto<List<CrmFCiFqObjNodeVo>> queryFqTreeData(QueryModel queryModel) {
		ResultDto<List<CrmFCiFqObjNodeVo>> result = new ResultDto<List<CrmFCiFqObjNodeVo>>();
		try {
			List<CrmFCiFqObjNodeVo> list = cmssFCiFqService.queryFqTreeData(queryModel);
			if (list != null && list.size() > 0) {
				return new ResultDto<List<CrmFCiFqObjNodeVo>>(list);
			} else {
				result.setCode(-1);
				result.setMessage("获取灵活查询配置信息失败，请联系系统管理员！");
			}
		} catch (Exception e) {
			result.setCode(-9);
			result.setMessage("查询异常");
			log.error("query fqTreeData data error", e);
		}
		return result;
	}
	
	/**
     * @函数名称:queryDbColInfo
     * @函数描述:查询灵活查询-字段属性信息
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "查询灵活查询-字段属性信息", notes = "灵活查询组件-查询字段屬性数据")
	@GetMapping("/querydbcolinfo")
	public ResultDto<CrmFCiFqDbcol> queryDbColInfo(QueryModel model) {
		ResultDto<CrmFCiFqDbcol> result = new ResultDto<CrmFCiFqDbcol>();
		try {
			CrmFCiFqDbcol obj = cmssFCiFqService.queryDbColInfo(model);
			if (obj != null) {
				return new ResultDto<CrmFCiFqDbcol>(obj);
			} else {
				result.setCode(-1);
				result.setMessage("获取字段属性信息失败，请联系系统管理员！");
			}
		} catch (Exception e) {
			result.setCode(-9);
			result.setMessage("查询异常");
			log.error("query dbColInfo data error", e);
		}
		return result;
	}
	
	/**
     * @函数名称:queryResult
     * @函数描述:灵活查询结果接口
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "灵活查询结果接口", notes = "灵活查询组件-分页查询结果")
	@GetMapping("/queryresult")
	public ResultDto<List<Map<String, Object>>> queryResult(QueryModel model) {
		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
		try {
			ResultDto<List<Map<String, Object>>> resultDto = cmssFCiFqService.queryResult(model);
			if (resultDto != null && resultDto.getData().size() > 0) {
				return resultDto;
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据");
			}
		} catch (Exception e) {
			result.setCode(-9);
			result.setMessage("查询异常");
			log.error("query result data error", e);
		}
		return result;
	}
	
	/**
     * @函数名称:querySolutionList
     * @函数描述:查询灵活查询方案列表信息
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "查询灵活查询方案列表信息", notes = "灵活查询组件-查询灵活查询方案列表信息")
	@GetMapping("/querysolutionlist")
	public ResultDto<List<Map<String, Object>>> querySolutionList(QueryModel model) {
		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = cmssFCiFqService.querySolutionList(model);
			if (list != null && list.size() > 0) {
				return new ResultDto<List<Map<String, Object>>>(list);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据");
			}
		} catch (Exception e) {
			result.setCode(-9);
			result.setMessage("查询异常");
			log.error("query solution result data error", e);
		}
		return result;
	}
	
	/**
     * @函数名称:checkSsNameIsRepeat
     * @函数描述:判断方案名称是否重复
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "判断方案名称是否重复", notes = "灵活查询组件-判断方案名称是否重复")
	@GetMapping("/checkssnameisrepeat")
	public ResultDto<String> checkSsNameIsRepeat(@RequestParam("ssName") String ssName) {
		ResultDto<String> result = new ResultDto<String>();
		try {
			String res = cmssFCiFqService.checkSsNameIsRepeat(ssName);
			result.setData(res);
		} catch (Exception e) {
			result.setCode(-9);
			result.setMessage("查询异常");
			log.error("check ssname isrepeat error", e);
		}
		return result;
	}
	
	/**
     * @函数名称:queryFqScolBySsid
     * @函数描述:查询-灵活查询方案-查询条件信息
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "查询-灵活查询方案-查询条件信息", notes = "灵活查询组件-查询-灵活查询方案-查询条件信息")
	@GetMapping("/queryfqscolbyssid")
	public ResultDto<List<Map<String, Object>>> queryFqScolBySsid(@RequestParam("ssId") String ssId) {
		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = cmssFCiFqService.queryFqScolBySsid(ssId);
			if (list != null && list.size() > 0) {
				return new ResultDto<List<Map<String, Object>>>(list);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据");
			}
		} catch (Exception e) {
			result.setCode(-9);
			result.setMessage("查询异常");
			log.error("query solution-scol result data error", e);
		}
		return result;
	}
	
	/**
     * @函数名称: deleteFqSolutionInfo
     * @函数描述: 删除灵活查询方案信息
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "删除灵活查询方案信息", notes = "灵活查询组件-支持批量删除方案信息")
    @PostMapping("/deletefqsolutioninfo")
    protected ResultDto<String> deleteFqSolutionInfo(@RequestBody String ids) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		Integer count = cmssFCiFqService.deleteFqSolutionInfo(ids);
    		if(count > 0) {
    			result.setCode(0);
    			result.setMessage("删除成功");
    		} else if(count == -1) {
    			result.setCode(-1);
    			result.setMessage("请求参数为空");
    		}
    	} catch (Exception e) {
			result.setCode(-9);
			result.setMessage("执行异常");
			log.error("deleteFqSolutionInfo error", e);
    	}
        return result;
    }
	
	/**
     * @函数名称: upsertFqSolutionInfo
     * @函数描述: 维护灵活查询方案信息
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "维护灵活查询方案信息", notes = "灵活查询组件-维护灵活查询方案信息")
    @PostMapping("/upsertfqsolutioninfo")
    protected ResultDto<String> upsertFqSolutionInfo(@RequestBody CrmFCiFqSsolutionModel model) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		String id = cmssFCiFqService.upsertFqSolutionInfo(model);
			result.setCode(0);
			result.setMessage("执行成功");
			result.setData(id);
    	} catch (Exception e) {
			result.setCode(-9);
			result.setMessage("执行异常");
			log.error("upsertFqSolution data error", e);
    	}
        return result;
    }
	
	/**
     * @函数名称:getFqMarkParam
     * @函数描述:营销活动参数查询接口
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "营销活动参数查询接口", notes = "灵活查询组件-营销活动参数查询接口")
	@GetMapping("/getfqmarkparam")
	public ResultDto<Map<String, Object>> getFqMarkParam(QueryModel model) {
		ResultDto<Map<String, Object>> result = new ResultDto<Map<String, Object>>();
		try {
			Map<String, Object> params = cmssFCiFqService.buildFqMarkParam(model);
			result.setData(params);
			return result;
		} catch (Exception e) {
			result.setCode(-9);
			result.setMessage("查询异常");
			log.error("query result data error", e);
		}
		return result;
	}

	//更新默认查询
	@PostMapping("/updateEsUserQuery")
	@ApiOperation(value = "更新默认查询")
	public ResultDto<Integer> updateEsUserQuery(@RequestBody CrmFEsUserQuery crmFEsUserQuery) throws InvocationTargetException, IllegalAccessException {
		ResultDto<Integer> resultDto = new ResultDto<>();
		int value= 0;
		try {
			value = cmssFCiFqService.updateEsUserQuery(crmFEsUserQuery);
		} catch (InvocationTargetException e) {

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if(value==0){
				resultDto.setCode(0);
				resultDto.setMessage("修改成功");
				return resultDto;
			}else{
				resultDto.setCode(-1);
				resultDto.setMessage("修改失败！用户名或者显示类型为空！");
				return resultDto;
			}
	}

	//默认查询
	@GetMapping("/EsUserQueryList")
	@ApiOperation(value = "默认查询")
	public ResultDto<List<CrmFEsUserQueryVO>> getEsUserQueryList(String userId) {
		return new ResultDto<List<CrmFEsUserQueryVO>>(cmssFCiFqService.getEsUserQueryList(userId));
	}

	//导出excel保存
	@PostMapping("/insertEsExportQuery")
	@ApiOperation(value = "导出excel保存")
	public ResultDto<String> insertEsExportQuery(@RequestBody QueryModel model) throws InvocationTargetException, IllegalAccessException {
		ResultDto<String> resultDto = new ResultDto<>();
		String value= "";
		try {
			value = cmssFCiFqService.insertEsExportQuery(model);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if(StringUtils.isNotEmpty(value)){
			resultDto.setCode(0);
			resultDto.setMessage("保存成功");
			resultDto.setData(value);
			return resultDto;
		}else{
			resultDto.setCode(-1);
			resultDto.setMessage("保存失败！");
			return resultDto;
		}
	}
	//默认查询
	@GetMapping("/EsExportQueryList")
	@ApiOperation(value = "查询导出列表")
	public ResultDto<CrmFEsExportQueryVO> getEsExportQueryList(QueryModel model) {
		return new ResultDto<CrmFEsExportQueryVO>(cmssFCiFqService.getEsExportQueryList(model));
	}

	/**
	 * 导出客户列表
	 *
	 * @param
	 */
	@GetMapping("/exportExportQuery")
	@ApiOperation(value = "下载es客户列表")
	public void exportExportQuery(HttpServletResponse response, QueryModel model) {
		try {
			String seqno=(String) model.getCondition().get("seqno");
			if(StringUtil.isEmpty(seqno)){
				return;
			}
			cmssFCiFqService.exportExportQuery(response,seqno);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("导出失败");
		}
	}
    //删除下载信息
    @PostMapping("/deleteExportQuery")
    @ApiOperation(value = "删除下载信息")
    public ResultDto<Integer> deleteExportQuery(@RequestBody String seqno) {
        ResultDto<Integer> resultDto = null;
        resultDto = new ResultDto<>(cmssFCiFqService.deleteExportQuery(seqno));
        resultDto.setCode(0);
        resultDto.setMessage("删除成功");
        return resultDto;
    }


	@ApiOperation(value = "解析上传文件")
	@PostMapping("/uploadConditions")
	public ResultDto<Map<String, Object>> uploadTable(@RequestBody FileVO file){
		MultipartFile mfile =null;
		ResultDto<Map<String, Object>> rs = null;
		try {
			if (file != null) {
				mfile =getMulFileByPath(file.getFilePath(), file.getFileName());
			}
			Map<String, Object> reMap =this.cmssFCiFqService.uploadtriumph(mfile);
			if (reMap.get("message").equals("succese")) {
				rs = new ResultDto<>(reMap);
				rs.setData((Map<String, Object>) reMap.get("data"));
				rs.setMessage("导入成功！");
				rs.setCode(0);
				return rs;
			}else if (reMap.get("message").equals("error")){
				rs = new ResultDto<>();
				rs.setMessage((String) reMap.get("error"));
				rs.setCode(-1);
				return rs;
			}
		}catch (Exception e) {
			rs.setCode(-1);
			rs.setMessage(e.getMessage());
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} // UTF-8
		return rs ;
	}


	private  MultipartFile getMulFileByPath(String picPath,String fileName) throws Exception {
		String filePa=export+ File.separator+"/"+picPath;
		FileInputStream fileInputStream = new FileInputStream(filePa);
		MultipartFile multipartFile = new MockMultipartFile(fileName, fileName,
				ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
		return multipartFile;
	}

}
