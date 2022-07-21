package cn.com.yusys.yscrm.info.workreport.web.rest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.info.workreport.domain.OcrmFwpCustomerContact;
import cn.com.yusys.yscrm.info.workreport.service.OcrmFwpCustomerContactService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import cn.com.yusys.yscrm.info.workreport.domain.OcrmFwpWorkReport;
import cn.com.yusys.yscrm.info.workreport.service.OcrmFwpWorkReportService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0.0
 * @项目名称: yscrm-mgr-info-workreport-core模块
 * @类名称: OcrmFwpWorkReportResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: lixt1
 * @创建时间: 2019-01-28 20:32:24
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/infoworkreport")
public class OcrmFwpWorkReportResource extends CommonResource<OcrmFwpWorkReport, String> {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OcrmFwpWorkReportService ocrmFwpWorkReportService;

    @Autowired
    private OcrmFwpCustomerContactService ocrmFwpCustomerContactService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFwpWorkReportService;
    }

    /**
     * @函数名称:queryList
     * @函数描述:查询对象列表，公共API接口
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/querylist")
    @Timed
    protected ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
        List<Map<String, Object>> list = ocrmFwpWorkReportService.listByModel(queryModel);
        return new ResultDto<>(list);
    }
    
    @GetMapping("/queryMlist")
    @Timed
    protected ResultDto<List<Map<String, Object>>> queryMlist(QueryModel queryModel) {
        List<Map<String, Object>> list = ocrmFwpWorkReportService.queryMlist(queryModel);
        return new ResultDto<>(list);
    }

    @GetMapping("/queryConTact")
    @Timed
    protected ResultDto<List<Map<String, Object>>> queryConTact(QueryModel queryModel) {
        List<Map<String, Object>> list = ocrmFwpCustomerContactService.queryConTact(queryModel);
        return new ResultDto<>(list);
    }
    /**
     * @函数名称:queryDetail
     * @函数描述:查询单个对象，公共API接口
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/querydetail")
    @Timed
    protected ResultDto<List<Map<String, Object>>> queryDetail(@RequestParam(value = "workReportId") String workReportId) {
        List<Map<String, Object>> ocrmFwpCustomerContact = ocrmFwpCustomerContactService.selectByWorkReportIds(workReportId,"N");
        return new ResultDto<>(ocrmFwpCustomerContact);
    }

    @GetMapping("/detail")
    @Timed
    protected ResultDto<Map<String, Object>> detail(@RequestParam(value = "workReportId") String workReportId) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> workReport = ocrmFwpWorkReportService.detail(workReportId);
        map.put("workReport",workReport);
        String workReportBusiType = (String)workReport.get(0).get("workReportBusiType");
        String workSummary = (String)workReport.get(0).get("workSummary");
        if ("1".equals(workReportBusiType) && workSummary.contains("1")){
            List<Map<String, Object>> custContact = ocrmFwpCustomerContactService.selectByWorkReportIds(workReportId,null);
            map.put("custContact",custContact);
        }
        return new ResultDto<>(workReport.size(),map);
    }

    /**
     * @函数名称:chkData
     * @函数描述:查询 同一报告人、同一报告周期内，是否有重复的工作报告
     * @参数与返回说明:reporterId报告人id， workReportBusiType报告业务类型， reportDate报告生成日期
     * @算法描述:
     */
    @GetMapping("/chkdata")
    @Timed
    protected ResultDto<List<String>> chkData(@RequestParam(value = "creatorId", required = true) String creatorId,
                                         @RequestParam(value = "workReportBusiType", required = true) String workReportBusiType,
                                         @RequestParam(value = "startDate", required = true) String startDate) {
        List<String> result = ocrmFwpWorkReportService.chkData(creatorId, workReportBusiType, startDate);
        return new ResultDto<>(result);
    }

	/**
	 * @函数名称:addReport
	 * @函数描述:创建工作报告
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/add")
	@Timed
	protected ResultDto<Map<String, Integer>> addReport(@RequestBody Map<String, Object> map)
			throws URISyntaxException {
		Map<String, Integer> resMap = new HashMap<>();
		OcrmFwpWorkReport ocrmFwpWorkReport = new OcrmFwpWorkReport();
		ObjectMapper jsonObj = new ObjectMapper();
		try {
			ocrmFwpWorkReport = jsonObj.readValue((String) map.get("workReport"),
					OcrmFwpWorkReport.class);
		} catch (JsonParseException var4) {
			this.log.error("将查询条件workReport转换为OcrmFwpWorkReport对象出错", var4);
		} catch (JsonMappingException var5) {
			this.log.error("将查询条件workReport转换为OcrmFwpWorkReport对象出错", var5);
		} catch (IOException var6) {
			this.log.error("将查询条件workReport转换为OcrmFwpWorkReport对象出错", var6);
		}
		if (map.get("customerContact") != null) {
			int addCustomerContact = ocrmFwpCustomerContactService.addCustomerContacts(
					(List<String>) map.get("customerContact") , ocrmFwpWorkReport.getIsDraft());
			resMap.put("addCustomerContact", addCustomerContact);
		}
        int addOcrmFwpWorkReport = ocrmFwpWorkReportService.addReport(ocrmFwpWorkReport);
        resMap.put("addOcrmFwpWorkReport", addOcrmFwpWorkReport);
		return new ResultDto<>(resMap);
	}

    @PostMapping("/addCustContact")
    @Timed
    protected ResultDto<Integer> addCustContact(@RequestBody OcrmFwpCustomerContact ocrmFwpCustomerContact) throws URISyntaxException {
        return new ResultDto<>(ocrmFwpCustomerContactService.addCustContact(ocrmFwpCustomerContact));
    }

    @PostMapping("/updateCustContact")
    @Timed
    protected ResultDto<Integer> updateCustContact(@RequestBody OcrmFwpCustomerContact ocrmFwpCustomerContact) throws URISyntaxException {
        return new ResultDto<>(ocrmFwpCustomerContactService.updateCustContact(ocrmFwpCustomerContact));
    }
    /**
     * @函数名称:updateContent
     * @函数描述:根据 报告编号 更新 ： 工作内容、工作困难、工作小结
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/updatecontent")
    @Timed
    protected ResultDto<Integer> updateContent(@RequestBody OcrmFwpWorkReport ocrmFwpWorkReport) throws URISyntaxException {
        int result = ocrmFwpWorkReportService.updateContent(ocrmFwpWorkReport);
        return new ResultDto<>(result);
    }

    @PostMapping("/updateWorkReport")
    @Timed
    protected ResultDto<Map<String, Object>> updateWorkReport(@RequestBody Map<String, Object> map) throws URISyntaxException {
        OcrmFwpWorkReport ocrmFwpWorkReport = new OcrmFwpWorkReport();
        ObjectMapper jsonObj = new ObjectMapper();
        Map<String, Object> resMap = new HashMap<>();
        try {
            ocrmFwpWorkReport = (OcrmFwpWorkReport) jsonObj.readValue((String) map.get("workReport"), OcrmFwpWorkReport.class);
        } catch (JsonParseException var4) {
            this.log.error("将查询条件workReport转换为OcrmFwpWorkReport对象出错", var4);
        } catch (JsonMappingException var5) {
            this.log.error("将查询条件workReport转换为OcrmFwpWorkReport对象出错", var5);
        } catch (IOException var6) {
            this.log.error("将查询条件workReport转换为OcrmFwpWorkReport对象出错", var6);
        }
        int updateCustomerContact = 0;
        int updateWorkReport = 0;
        if (map.get("customerContact") != null) {
            updateCustomerContact = ocrmFwpCustomerContactService.updateCustomerContacts((List<String>) map.get("customerContact"), ocrmFwpWorkReport.getWorkReportId(), ocrmFwpWorkReport.getIsDraft());
        }else {
            updateCustomerContact = ocrmFwpCustomerContactService.deleteByWorkReportIds(ocrmFwpWorkReport.getWorkReportId());
        }
        updateWorkReport = ocrmFwpWorkReportService.updateWorkReport(ocrmFwpWorkReport);
        resMap.put("updateWorkReport", updateWorkReport);
        resMap.put("updateCustomerContact", updateCustomerContact);
        return new ResultDto<>(resMap);
    }

    /**
     * @函数名称:delete
     * @函数描述:删除 - 根据 报告编号字段 逻辑删除
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/delete")
    @Timed
    protected ResultDto<Map<String, Integer>> delete(@RequestBody OcrmFwpWorkReport ocrmFwpWorkReport) {
        Map<String, Integer> map = new HashMap<>();
        int deleteWorkReport = ocrmFwpWorkReportService.deleteByWorkReportIds(ocrmFwpWorkReport);
        map.put("deleteWorkReport", deleteWorkReport);
        int deleteCustomerContact = ocrmFwpCustomerContactService.deleteByWorkReportIds(ocrmFwpWorkReport.getWorkReportId());
        map.put("deleteCustomerContact", deleteCustomerContact);
        return new ResultDto<>(map);
    }

    @GetMapping("/deleteCustContact")
    @Timed
    protected ResultDto<Integer> deleteCustomerContact(@RequestParam(value = "customerContactId") String customerContactId) throws URISyntaxException {
        return new ResultDto<>(ocrmFwpCustomerContactService.deleteCustContact(customerContactId));
    }

    /**
     * @方法名称: getUuid
     * @方法描述: 生成workReportId
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping({"/createWorkReportId"})
    @Timed
    public ResultDto<String> getUuid() {
        String uuid = ocrmFwpWorkReportService.getUuid();
        return new ResultDto<>(uuid);
    }

    /**
     * @方法名称: export
     * @方法描述: 查询结果导出
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response, QueryModel model) throws IOException {
        try {
            this.ocrmFwpWorkReportService.export(model, response);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("导出失败");
        }
    }
}
