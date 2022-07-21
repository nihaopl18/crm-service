package cn.com.yusys.yscrm.custmgr.web.rest;

import java.io.*;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custmgr.domain.*;
import com.ecc.emp.web.multipart.commons.CommonsMultipartFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;

import cn.com.yusys.yscrm.custmgr.service.AcrmFcmCustmgrPerfService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @项目名称: yusp-crm-entity-cust-mgr模块
 * @类名称: AcrmFcmCustmgrPerfResource
 * @类描述: #客户经理管理-业绩明细查询资源类
 * @功能描述: 
 * @创建人: luhy1
 * @创建时间: 2019-01-22 17:25:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfcmcustmgrperf")
@Api(value = "acrmfcmcustmgrper", description = "客户经理业绩管理")
public class AcrmFcmCustmgrPerfResource extends CommonResource<AcrmFcmCustmgrPerf, String> {

    @Autowired
    private AcrmFcmCustmgrPerfService acrmFcmCustmgrPerfService;

	@Value("${application.localDiskPath}")
	private String export;

    @Override
    protected CommonService getCommonService() {
    	return acrmFcmCustmgrPerfService;
    }
    private final Logger log = LoggerFactory.getLogger(AcrmFcmCustmgrPerfResource.class);

    /**
	 * 客户经理视图-业绩明细列表查询
	 * 
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/querylist/{mgrId}")
	public ResultDto<List<Map<String, Object>>> queryListByMgrId(QueryModel queryModel,@PathVariable String mgrId) {
		List<Map<String, Object>> list = acrmFcmCustmgrPerfService.queryListByMgrId(queryModel,mgrId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * 客户经理管理-业绩明细列表查询
	 * 
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/queryerlist")
	public ResultDto<List<Map<String, Object>>> queryerList(QueryModel queryModel) {
		List<Map<String, Object>> list = acrmFcmCustmgrPerfService.queryerList(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	/**
	 * 业绩管理分配页面查询
	 *
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/triumphlist")
	@ApiOperation(value = "业绩管理分配页面查询")
	public ResultDto<CrmTriumphVO> triumphlist(QueryModel queryModel) {
		return new ResultDto<CrmTriumphVO>(acrmFcmCustmgrPerfService.triumphlist(queryModel));
	}

	/**
	 * 保存业绩分配
	 *
	 * @param
	 * @return
	 */
	@PostMapping("/addtriumph")
	@ApiOperation(value = "保存业绩分配")
	public ResultDto<Integer> addtriumph(@RequestBody CrmTriumphVOVO crmTriumphVO) throws Exception {
		ResultDto<Integer> resultDto = null;
			resultDto = new ResultDto<>(acrmFcmCustmgrPerfService.inserttriumph(crmTriumphVO));
			resultDto.setCode(0);
			resultDto.setMessage("分配成功");
			return resultDto;
	}

    @ApiOperation(value = "解析上传文件")
	@PostMapping("/uploadtriumph")
	public ResultDto<Map<String, Object>> uploadTable(@RequestBody FileVO file){
		MultipartFile  mfile =null;
        ResultDto<Map<String, Object>> rs = null;
		try {
		if (file != null) {
             mfile =getMulFileByPath(file.getFilePath(), file.getFileName());
        }
			Map<String, Object> reMap =this.acrmFcmCustmgrPerfService.uploadtriumph(file,mfile);
			if (reMap.get("message").equals("succese")) {
				rs = new ResultDto<>(reMap);
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
		String filePa=export+File.separator+"/"+picPath;
		FileInputStream fileInputStream = new FileInputStream(filePa);
		MultipartFile multipartFile = new MockMultipartFile(fileName, fileName,
				ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
		return multipartFile;
	}


	/**
     * 查询aum业绩明细列表
     *
     * @param queryModel
     * @return
     */
    @GetMapping("/queryaumdetailedlist")
    @ApiOperation(value = "查询aum业绩明细列表")
    public ResultDto<List<CrmFYyTriumphAumDetailed>> queryaumdetailedlist(QueryModel queryModel) throws Exception {
        return new ResultDto<List<CrmFYyTriumphAumDetailed>>(acrmFcmCustmgrPerfService.queryaumdetailedlist(queryModel));
    }

	/**
	 * 查询存款业绩明细列表
	 *
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/querydepositdetailedlist")
	@ApiOperation(value = "查询存款业绩明细列表")
	public ResultDto<List<CrmFYyTriumphDepositDetailed>> querydepositdetailedlist(QueryModel queryModel) throws Exception {
		return new ResultDto<List<CrmFYyTriumphDepositDetailed>>(acrmFcmCustmgrPerfService.querydepositdetailedlist(queryModel));
	}

	/**
	 * 查询贷款业绩明细列表
	 *
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/queryloandetailedlist")
	@ApiOperation(value = "查询贷款业绩明细列表")
	public ResultDto<List<CrmFYyTriumphLoanDetailed>> queryloandetailedlist(QueryModel queryModel) throws Exception {
		return new ResultDto<List<CrmFYyTriumphLoanDetailed>>(acrmFcmCustmgrPerfService.queryloandetailedlist(queryModel));
	}

	/**
	 * 查询手续费业绩明细列表
	 *
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/querychargedetailedlist")
	@ApiOperation(value = "查询手续费业绩明细列表")
	public ResultDto<List<CrmFYyTriumphCharge>> querychargedetailedlist(QueryModel queryModel) throws Exception {
		return new ResultDto<List<CrmFYyTriumphCharge>>(acrmFcmCustmgrPerfService.querychargedetailedlist(queryModel));
	}

	/**
	 * 查询业绩查看列表
	 *
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/Querylist")
	@ApiOperation(value = "查询业绩查看列表")
	public ResultDto<CrmTriumphlookVO> Querylist(QueryModel queryModel) throws Exception {
		return new ResultDto<CrmTriumphlookVO>(acrmFcmCustmgrPerfService.Querylist(queryModel));
	}

	/**
	 * 查询业绩分析柱状图列表
	 *
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/Querydetalist")
	@ApiOperation(value = "查询业绩分析柱状图列表")
	public ResultDto<List<CrmFYyTriumphLookUp>> Querydetalist(QueryModel queryModel) throws Exception {
		return new ResultDto<List<CrmFYyTriumphLookUp>>(acrmFcmCustmgrPerfService.Querydetalist(queryModel));
	}

	/**
	 * 查询业绩分析月度统计列表
	 *
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/Querymonthdetalist")
	@ApiOperation(value = "查询业绩分析月度统计列表")
	public ResultDto<List<CrmFYyTriumphLookUp>> Querymonthdetalist(QueryModel queryModel) throws Exception {
		return new ResultDto<List<CrmFYyTriumphLookUp>>(acrmFcmCustmgrPerfService.Querymonthdetalist(queryModel));
	}
	/**
	 * 查询业绩分析ppop列表
	 *
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/Querydetappoplist")
	@ApiOperation(value = "查询业绩分析ppop列表")
	public ResultDto<lookupVO> Querydetappoplist(QueryModel queryModel) throws Exception {
		return new ResultDto<lookupVO>(acrmFcmCustmgrPerfService.Querydetappoplist(queryModel));
	}
/*
     @Test
    public void test() throws Exception {
    FileVO fileVO=new FileVO();
    fileVO.setBusNo("87ff48df9f4a4f098533816e638897ae");
    fileVO.setFileName("2021年分行销售人员模拟利润模板（数据模板）_已标注.xlsx");
    fileVO.setFilePath("12/18/20211029102713851-117B5137.xlsx");
    fileVO.setFileId("b91aff89a0d74173aa9f980928d786e5");
		 ResultDto<Map<String, Object>> mapResultDto= uploadTable(fileVO);
    }*/

	/**
	 * 查询上传文件列表
	 *
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/uploadlist")
	@ApiOperation(value = "查询上传文件列表")
	public ResultDto<List<Map<String,Object>>> uploadlist(QueryModel queryModel) {
		return new ResultDto<List<Map<String,Object>>>(acrmFcmCustmgrPerfService.uploadlist(queryModel));
	}


    @ApiOperation(value = "指标分析数据导出")
	@GetMapping("/exporttriumphlook")
    public void exporttriumphlook(HttpServletResponse response,QueryModel queryModel){
        try {
            acrmFcmCustmgrPerfService.exporttriumphlook(response,queryModel);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("导出失败");
        }
    }


	@ApiOperation(value = "业绩查看导出")
	@GetMapping("/exporttriump")
	public void exporttriump(HttpServletResponse response,QueryModel queryModel){
		try {
			acrmFcmCustmgrPerfService.exporttriump(response,queryModel);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("导出失败");
		}
	}

	@ApiOperation(value = "aum详情导出")
	@GetMapping("/exportAumdetailed")
	public void exportAumdetailed(HttpServletResponse response,QueryModel queryModel){
		try {
			acrmFcmCustmgrPerfService.exportAumdetailed(response,queryModel);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("导出失败");
		}
	}

	@ApiOperation(value = "存款详情导出")
	@GetMapping("/exportdepositdetailed")
	public void exportdepositdetailed(HttpServletResponse response,QueryModel queryModel){
		try {
			acrmFcmCustmgrPerfService.exportdepositdetailed(response,queryModel);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("导出失败");
		}
	}
	@ApiOperation(value = "贷款详情导出")
	@GetMapping("/exportloandetailed")
	public void exportloandetailed(HttpServletResponse response,QueryModel queryModel){
		try {
			acrmFcmCustmgrPerfService.exportloandetailed(response,queryModel);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("导出失败");
		}
	}

	@ApiOperation(value = "手续费详情导出")
	@GetMapping("/exportchargedetailed")
	public void exportchargedetailed(HttpServletResponse response,QueryModel queryModel){
		try {
			acrmFcmCustmgrPerfService.exportchargedetailed(response,queryModel);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("导出失败");
		}
	}

    /**
     * 客户经理调岗后，更新业绩
     *
     * @param
     * @return
     */
    @PostMapping("/updatetriumph")
    @ApiOperation(value = "角色修改后，更新业绩")
    public ResultDto<Integer> updatetriumph(@RequestBody CrmupdateTriumphVO crmupdateTriumphVO) {
        ResultDto<Integer> resultDto = null;
        /*resultDto = new ResultDto<>(acrmFcmCustmgrPerfService.updatetriumph(crmTriumphVO));*/
        resultDto.setCode(0);
        resultDto.setMessage("分配成功");
        return resultDto;
    }
}
