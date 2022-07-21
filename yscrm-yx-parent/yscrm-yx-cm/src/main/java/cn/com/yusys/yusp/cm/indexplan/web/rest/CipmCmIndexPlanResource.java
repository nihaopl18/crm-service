package cn.com.yusys.yusp.cm.indexplan.web.rest;

import cn.com.yusys.yusp.cm.indexplan.domain.*;
import cn.com.yusys.yusp.cm.indexplan.service.CimpCmIndexPlanService;
import cn.com.yusys.yusp.cm.market.vo.OrgIndexRemainVo;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 营销成效策划指标
 * 
 * @author zhanghan3 20181120
 */
@RestController
@RequestMapping("/api/indexplan")
public class CipmCmIndexPlanResource extends CommonResource<CimpCmAssemblyAnalysis, Serializable> {

	private static final String String = null;
	@Autowired
	private CimpCmIndexPlanService indexPlanService;

	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.indexPlanService;
	}

	@GetMapping("/list")
	public ResultDto<List<Map<String, Object>>> titleList(String nodeId) {
		return new ResultDto<List<Map<String, Object>>>(this.indexPlanService.getTitle(nodeId));
	}

	// 根据流程产品返回信息用于组装字段
	@PostMapping("/proIndexList")
	public ResultDto<List<Map<String, Object>>> proIndexList(String nodeId) {
		return new ResultDto<List<Map<String, Object>>>(this.indexPlanService.getTitle(nodeId));
	}

//	@GetMapping("/targetquery")
//	public ResultDto<List<Map<String, Object>>> targetQuery(QueryModel model) {
//		List<Map<String, Object>> ids = new ArrayList<>();
//		if(model.getCondition().get("name") != null && !model.getCondition().get("name").equals("")) {
//			ids = (List<Map<String, Object>>) model.getCondition().get("name");
//			String nodeId = (java.lang.String) model.getCondition().get("nodeId");
//			return new ResultDto<List<Map<String, Object>>>(indexPlanService.targetQuery(ids, nodeId));
//		} else {
//			return null;
//		}
//	}
	@GetMapping("/targetquery")
	public IndexPlanReturnDto targetQuery(QueryModel model) {
		String nodeId = (java.lang.String) model.getCondition().get("nodeId");
		return indexPlanService.targetQuery(nodeId);
	}
//	@PostMapping("/indexremainquery")
//	public List<OrgIndexRemainVo> indexRemainQuery(@RequestBody ObjectInfo objectInfo) {
//		return indexPlanService.indexRemainQuery(objectInfo);
//	}
	@PostMapping("/indexremainquery")
	public ResultDto<?> indexRemainQuery(@RequestBody ObjectInfo objectInfo) {
		List<OrgIndexRemainVo> orgIndexRemainVos = indexPlanService.indexRemainQuery(objectInfo);
		if (orgIndexRemainVos == null){
			return new ResultDto(-1,"查询失败");
		}else if (orgIndexRemainVos.size()>0){
			return new ResultDto<>(orgIndexRemainVos.size(),orgIndexRemainVos);
		}else {
			return new ResultDto(-1,"查询失败");
		}
	}

	@PostMapping("/indexdistributionquery")
	public ResultDto<?> indexDistributionQuery(@RequestBody ObjectInfo objectInfo) {
		IndexPlanReturnDto indexPlanReturnDto = indexPlanService.indexDistributionQuery(objectInfo);
		if (indexPlanReturnDto!=null){
			return new ResultDto<>(indexPlanReturnDto.getTotalSize(),indexPlanReturnDto);
		}else {
			return new ResultDto(-1,"查询失败");
		}

//		ResultDto.createSuccess(indexPlanReturnDto);
//		return
	}
//	@PostMapping("/save")
//	public int saveAssembly(@RequestBody Map<String, Object> map) throws ParseException {
//		List<Map<String, Object>> tabeDataList = (List<Map<String, Object>>) map.get("ObjDataList");
//		List<Map<String, Object>> targetIdList = (List<Map<String, Object>>) map.get("indexData");
//		String nodeId = (java.lang.String) map.get("nodeId");
//		int r = 0;
//		BigDecimal b = new BigDecimal(0);
//		// 保存前先清除参与数据
//		this.indexPlanService.deleteAssembly(nodeId);
//		for (int i = 0; i < tabeDataList.size(); i++) {
//			Map objMap = tabeDataList.get(i);
//			for (int j = 0; j < targetIdList.size(); j++) {
//				// 获取当前用户code
//				String loginCode = SecurityUtils.getCurrentUserLogin();
//				// 获取当前日期
//				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//				// 获取ID
//				String uuid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
//				// 获取 对象类型
//				String objType = (String) tabeDataList.get(i).get("objType");
//				// 获取对象ID
//				String objId = (String) tabeDataList.get(i).get("objId");
//				// 获取当前条数据
//				Map id = targetIdList.get(j);
//				CimpCmAssemblyAnalysis cimpCmAssemblyAnalysis = new CimpCmAssemblyAnalysis();
//				String targetId = (String) id.get("targetId");
//
//				cimpCmAssemblyAnalysis.setNodId(nodeId);
//
//				String s=Integer.toString(j+1);
//				String tar = "tar"+s;
////				StringBuilder tar2 = new StringBuilder();
////		        tar = tar2.toString();
//				String num=objMap.get(tar).toString();
//				if (objMap.get(tar) != null && !objMap.get(tar).equals("")) {
//					cimpCmAssemblyAnalysis.setTargetValue(new BigDecimal(objMap.get(tar).toString()));
//				} else {
//					cimpCmAssemblyAnalysis.setTargetValue(b);
//				}
//				cimpCmAssemblyAnalysis.setAssemblyId(uuid);
//				cimpCmAssemblyAnalysis.setIndexId(targetId);
//				cimpCmAssemblyAnalysis.setObjType(objType);
//				cimpCmAssemblyAnalysis.setObjId(objId);
//				cimpCmAssemblyAnalysis.setCratDt(df.parse(df.format(new Date())));
//				cimpCmAssemblyAnalysis.setLastChgDt(df.parse(df.format(new Date())));
//				cimpCmAssemblyAnalysis.setCratUsr(loginCode);
//				cimpCmAssemblyAnalysis.setLastChgUsr(loginCode);
//				this.indexPlanService.add(cimpCmAssemblyAnalysis);
//
//			}
//		}
//		return r;
//	}
	@PostMapping("/save")
	public int saveAssembly(@RequestBody IndexPlanSaveForm indexPlanSaveForm) throws ParseException {
		return this.indexPlanService.saveAssembly(indexPlanSaveForm);
	}
	@PostMapping("/datacheck")
	public ResultDto<String> dataCheck(@RequestBody IndexPlanSaveForm indexPlanSaveForm) throws ParseException {
		return new ResultDto<>(indexPlanService.dataCheck(indexPlanSaveForm));
	}

	@PostMapping("/savewaitdistribution")
	public int saveWaitDistribution(@RequestBody IndexPlanSaveForm indexPlanSaveForm){
		return this.indexPlanService.saveWaitDistribution(indexPlanSaveForm);

	}
	@PostMapping("/saveindex")
	public int saveindex(@RequestBody IndexPlanSaveForm indexPlanSaveForm) throws ParseException {
		int saveindex = indexPlanService.saveindex(indexPlanSaveForm);
		return 0;
	}
	@PostMapping("/editindex")
	public int editIndex(@RequestBody IndexPlanSaveForm indexPlanSaveForm) throws ParseException {
		int editIndex = indexPlanService.editIndex(indexPlanSaveForm);
		return 0;
	}
	/**
	 *
	 * @param indexPlanSaveForm
	 * @return
	 * @throws ParseException
	 */
	@PostMapping("/addindexplan")
	public int addIndexPlan(@RequestBody IndexPlanSaveForm indexPlanSaveForm) throws ParseException {
		// TODO
		List<ObjectDataForm> objectDataFormList = indexPlanSaveForm.getObjectDataFormList();
		List<IndexDataFormList> indexDataFormList = indexPlanSaveForm.getIndexDataFormList();
		//获取节点nodeId
		java.lang.String nodeId = indexPlanSaveForm.getNodeId();


		return 0;
	}
	@PostMapping("/updateindexplan")
	public int updateIndexPlan(@RequestBody IndexPlanSaveForm indexPlanSaveForm) throws ParseException {
		// TODO
		List<ObjectDataForm> objectDataFormList = indexPlanSaveForm.getObjectDataFormList();
		List<IndexDataFormList> indexDataFormList = indexPlanSaveForm.getIndexDataFormList();
		//获取节点nodeId
		java.lang.String nodeId = indexPlanSaveForm.getNodeId();


		return 0;
	}
	// 查询流程中客户
	@GetMapping("/custquery")
	public ResultDto<List<Map<String, Object>>> custQuery(QueryModel model) {
		String flowId = (java.lang.String) model.getCondition().get("flowId");
		return new ResultDto<List<Map<String, Object>>>(indexPlanService.custQuery(flowId,model));
	}

	// 查询流程中产品
	@GetMapping("/proquery")
	public ResultDto<List<Map<String, Object>>> proQuery(QueryModel model) {
		String flowId = (java.lang.String) model.getCondition().get("flowId");
		return new ResultDto<List<Map<String, Object>>>(indexPlanService.proQuery(flowId));
	}

	// 查询流程汇总渠道
	@GetMapping("/chaquery")
	public ResultDto<List<Map<String, Object>>> chaQuery(QueryModel model) {
		String flowId = (java.lang.String) model.getCondition().get("flowId");
		return new ResultDto<List<Map<String, Object>>>(indexPlanService.chaQuery(flowId,model));
	}

	// 查询机构信息
	@GetMapping("/orgquery")
	public ResultDto<List<Map<String, Object>>> orgQuery() {
		return new ResultDto<List<Map<String, Object>>>(indexPlanService.orgQuery());
	}

	// 客户经理放大镜查询逻辑
	@GetMapping("/customerquery")
	public ResultDto<List<Map<String, Object>>> customerQuery(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(indexPlanService.customerquery(model));
	}
	@GetMapping("/customerquerybyorgid")
	public ResultDto<List<Map<String, Object>>> customerQueryByOrgId(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(indexPlanService.customerQueryByOrgId(model));
	}
	// 客户经理放大镜查询逻辑
	@GetMapping("/customerbylogincode")
	public ResultDto<List<Map<String, Object>>> customerByLoginCode(QueryModel model) {
		String customerLogCode = (java.lang.String) model.getCondition().get("customerLogCode");
		return new ResultDto<List<Map<String, Object>>>(indexPlanService.customerByLoginCode(customerLogCode));
	}

	// 查询流程中渠道信息
	@PostMapping("/chabox")
	public ResultDto<List<Map<String, Object>>> chaBox(String nodeId,QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(indexPlanService.chaQuery(nodeId,model));
	}

	/**
	 * 以机构为维度查询指标
	 * @param model 查询条件
	 * @return
	 */
	@GetMapping("/taskDataForOrgUrl")
	public ResultDto<List<Map<String, Object>>> taskDataForOrgUrl(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(indexPlanService.taskDataForOrgUrl(model));
	}

	/**
	 * 以客户经理为维度查询指标
	 * @param model 查询条件
	 * @return
	 */
	@GetMapping("/taskDataForMgrUrl")
	public ResultDto<List<Map<String, Object>>> taskDataForMgrUrl(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(indexPlanService.taskDataForMgrUrl(model));
	}

}
