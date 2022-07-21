package cn.com.yusys.yscrm.mktactivity.web.rest;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.text.ParseException;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiAttachRelInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiCustInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiExobjInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiFedbackInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiProductInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiTargetInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActivityInfo;
import cn.com.yusys.yscrm.mktactivity.service.OcrmFMkActiAttachRelService;
import cn.com.yusys.yscrm.mktactivity.service.OcrmFMkActiCustService;
import cn.com.yusys.yscrm.mktactivity.service.OcrmFMkActiExobjService;
import cn.com.yusys.yscrm.mktactivity.service.OcrmFMkActiFedbackService;
import cn.com.yusys.yscrm.mktactivity.service.OcrmFMkActiProductService;
import cn.com.yusys.yscrm.mktactivity.service.OcrmFMkActiTargetService;
import cn.com.yusys.yscrm.mktactivity.service.OcrmFMkActivityService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkActivityResource
 * @类描述：营销活动管理
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-24
 */
@RestController
@RequestMapping("/api/mkt1")
public class OcrmFMkActivityResource extends CommonResource<OcrmFMkActivityInfo, Serializable>{
	@Autowired
	private OcrmFMkActivityService service;
	@Autowired
	private OcrmFMkActiCustService serviceCust;
	@Autowired
	private OcrmFMkActiProductService serviceProduct;
	@Autowired
	private OcrmFMkActiTargetService serviceTarget;
	@Autowired
	private OcrmFMkActiAttachRelService serviceAttach;
	@Autowired
	private OcrmFMkActiExobjService serviceObj;
	@Autowired
	private OcrmFMkActiFedbackService servicefd;
	@Override
	protected CommonService getCommonService() {
		return this.service;
	}
	/**
	* @方法名称: actiListQuery
	* @方法描述: 营销活动信息查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actilistquery")
	public ResultDto<List<Map<String,Object>>> actiListQuery(@Validated QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.actiListQuery(model));
	}
	/**
	* @方法名称: actiListQuery
	* @方法描述: 营销活动信息查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/myactilistquery")
	public ResultDto<List<Map<String,Object>>> myActiListQuery(@Validated QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.myActiListQuery(model));
	}
	/**
	* @方法名称: cmMonitor
	* @方法描述: 客户经理监控
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/cmmonitor")
	public ResultDto<List<Map<String,Object>>>cmMonitor(@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.service.cmMonitor(model));
	}
	/**
	* @方法名称: cmMonitorRelation
	* @方法描述: 客户经理监控执行中数
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/cmmonitorrelation")
	public ResultDto<List<Map<String,Object>>>cmMonitorRelation(@Validated QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.cmMonitorRelation(model));
	}
	/**
	* @方法名称: cmMonitorFail
	* @方法描述: 客户经理监控失败数
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/cmmonitorfail")
	public ResultDto<List<Map<String,Object>>>cmMonitorFail(@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.service.cmMonitorFail(model));
	}
	/**
	* @方法名称: cmMonitorSuccess
	* @方法描述: 客户经理监控成功数
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/cmmonitorsuccess")
	public ResultDto<List<Map<String,Object>>>cmMonitorSuccess(@Validated QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.cmMonitorSuccess(model));
	}
	/**
	* @方法名称: orgMonitor
	* @方法描述: 机构监控
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/orgmonitor")
	public ResultDto<List<Map<String,Object>>>orgMonitor(@Validated QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.orgMonitor(model));
	}
	/**
	* @方法名称: getCustInfoByObj
	* @方法描述: 查询活动关联客户更具执行对象和客户的归属关系
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/getcustinfobyobj")
	public ResultDto<List<Map<String,Object>>>getCustInfoByObj(@RequestParam(name = "actiId", required = true) String actiId,@RequestParam(name = "userId", required = true) String userId) {
		return new ResultDto<List<Map<String,Object>>>(this.service.getCustInfoByObj(actiId,userId));
	}
	/**
	* @方法名称: getProdInfoByAct
	* @方法描述: 查询活动关联产品根据活动ID
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/getprodinfobyact")
	public ResultDto<List<Map<String,Object>>>getProdInfoByAct(String actiId) {
		return new ResultDto<List<Map<String,Object>>>(this.service.getProdInfoByAct(actiId));
	}
	/**
	* @方法名称: orgMonitorRelation
	* @方法描述: 机构监控执行中数
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/orgmonitorrelation")
	public ResultDto<List<Map<String,Object>>>orgMonitorRelation(@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.service.orgMonitorRelation(model));
	}
	/**
	* @方法名称: orgMonitorSuccess
	* @方法描述: 机构监控成功数
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/orgmonitorsuccess")
	public ResultDto<List<Map<String,Object>>>orgMonitorSuccess(@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.service.orgMonitorSuccess(model));
	}
	/**
	* @方法名称: orgMonitorFail
	* @方法描述: 机构监控失败数
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/orgmonitorfail")
	public ResultDto<List<Map<String,Object>>>orgMonitorFail(@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.service.orgMonitorFail(model));
	}
	/**
	* @方法名称: actiMonitor
	* @方法描述: 活动监控
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actimonitor")
	public ResultDto<List<Map<String,Object>>>actiMonitor(@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.service.actiMonitor(model));
	}
	/**
	* @方法名称: actiMonitorRelation
	* @方法描述: 活动监控执行中数
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actimonitorrelation")
	public ResultDto<List<Map<String,Object>>>actiMonitorRelation(@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.service.actiMonitorRelation(model));
	}
	/**
	* @方法名称: actiMonitorSuccess
	* @方法描述: 活动监控成功数
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actimonitorsuccess")
	public ResultDto<List<Map<String,Object>>>actiMonitorSuccess(@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.service.actiMonitorSuccess(model));
	}
	/**
	* @方法名称: actiMonitorFail
	* @方法描述: 活动监控失败数
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actimonitorfail")
	public ResultDto<List<Map<String,Object>>>actiMonitorFail(@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.service.actiMonitorFail(model));
	}
	/**
	* @方法名称: actiProdListQuery
	* @方法描述: 营销活动关联产品信息查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actiprodlistquery")
	public ResultDto<List<Map<String,Object>>> actiProdListQuery(@Validated QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.actiProdListQuery(model));
	}
	/**
	* @方法名称: actiProdFitCust
	* @方法描述: 营销活动关联产品的目标客户
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/prodfitcust")
	public ResultDto<List<Map<String,Object>>> actiProdFitCust( String prodIds) {
		return new ResultDto<List<Map<String,Object>>>(this.serviceCust.prodFitCustInfo(prodIds));
	}
	/**
	* @方法名称: activityTargetInfo
	* @方法描述: 营销活动中指标查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/activitytargetinfo")
	public ResultDto<List<Map<String,Object>>> activityTargetInfo( String actiId) {
		return new ResultDto<List<Map<String,Object>>>(this.service.activityTargetInfo(actiId));
	}
	/**
	* @方法名称: custGroupCustInfo
	* @方法描述: 营销活动中查询客户群中的客户信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/groupcustinfo")
	public ResultDto<List<Map<String,Object>>> custGroupCustInfo( String groupIds) {
		return new ResultDto<List<Map<String,Object>>>(this.serviceCust.custGroupCustInfo(groupIds));
	}
	/**
	* @方法名称: userInfoByNo
	* @方法描述: 根据用户ID或者登陆号查询用户信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/userinfobyno")
	public ResultDto<List<Map<String,Object>>> userInfoByNo( String userIds) {
		return new ResultDto<List<Map<String,Object>>>(this.serviceCust.userInfoByNo(userIds));
	}	
	
	/**
	* @方法名称: getIndexInfoByProdId
	* @方法描述: 营销活动中查询指标信息根据产品编号
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/getindexinfobyprod")
	public ResultDto<List<Map<String,Object>>> getIndexInfoByProdId( QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.serviceCust.getIndexInfoByProdId(model));
	}
	/**
	* @方法名称: actiCustListQuery
	* @方法描述: 营销活动关联客户信息查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/acticustlistquery")
	public ResultDto<List<Map<String,Object>>> actiCustListQuery(QueryModel model) throws ParseException {
		return new ResultDto<List<Map<String,Object>>>(this.service.actiCustListQuery(model));
	}
	/**
	* @方法名称: actiTargetListQuery
	* @方法描述: 营销成效指标执行对象查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actitargetlistquery")
	public ResultDto<List<Map<String,Object>>> actiTargetListQuery(QueryModel model) throws ParseException {
		return new ResultDto<List<Map<String,Object>>>(this.service.actiTargetListQuery(model));
	}
	/**
	* @方法名称: actiFileListQuery
	* @方法描述: 营销活动附件信息查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actifilelistquery")
	public ResultDto<List<Map<String,Object>>> actiFileListQuery(QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.actiFileListQuery(model));
	}
	/**
	* @throws ParseException 
	* @方法名称: activiInsert
	* @方法描述: 销售活动新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actiinsert")
	public ResultDto<Object> activiInsert(@RequestBody Map<String,Object> record) throws URISyntaxException {
		ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			if(record==null) {
				reuslt.setCode(200001);
				reuslt.setMessage("参数为空");
			}else {
				reuslt= this.service.activiInsert(record);
			}
			reuslt.setMessage("success");
			//logger.info("新增商户信息数据");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(-1);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
	}
	/**
	* @throws ParseException 
	* @方法名称: targetDcom
	* @方法描述: 指标分解保存
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/targetdcom")
	public ResultDto<Object> targetDcom(@RequestBody Map<String,Object> record) throws URISyntaxException {
		ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			if(record==null) {
				reuslt.setCode(200001);
				reuslt.setMessage("参数为空");
			}else {
				reuslt= this.service.actiTargetDcom(record);
			}
			reuslt.setMessage("success");
			//logger.info("新增商户信息数据");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(-1);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
	}
	/**
	* @throws ParseException 
	* @方法名称: actDistr
	* @方法描述: 活动分配保存
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actdistr")
	public ResultDto<Object> actDistr(@RequestBody Map<String,Object> record) throws URISyntaxException {
		ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			if(record==null) {
				reuslt.setCode(200001);
				reuslt.setMessage("参数为空");
			}else {
				reuslt= this.service.actiDistr(record);
			}
			reuslt.setMessage("success");
			//logger.info("新增商户信息数据");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(-1);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
	}
	/**
	* @throws ParseException 
	* @方法名称: targetDcom
	* @方法描述: 指标分配保存
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/targetdistr")
	public ResultDto<Object> actiTargetDistr(@RequestBody Map<String,Object> record) throws URISyntaxException {
		ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			if(record==null) {
				reuslt.setCode(200001);
				reuslt.setMessage("参数为空");
			}else {
				reuslt= this.service.actiTargetDistr(record);
			}
			reuslt.setMessage("success");
			//logger.info("新增商户信息数据");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(-1);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiEdit
	* @方法描述: 销售活动修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actiedit")
	public ResultDto<Object> actiEdit(@RequestBody Map<String,Object> record) throws ParseException {
		ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			if(record==null) {
				reuslt.setCode(200001);
				reuslt.setMessage("参数为空");
			}else {
				reuslt= this.service.actiEdit(record);
			}
			reuslt.setMessage("success");
			//logger.info("新增商户信息数据");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiTargetInsert
	* @方法描述: 营销成效指标新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actitargetinsert")
	public ResultDto<Integer> actiTargetInsert(@RequestBody @Validated OcrmFMkActiTargetInfo[] record) throws ParseException {
		return this.serviceTarget.actiTargetInsert(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: actiTargetEdit
	* @方法描述: 营销成效指标修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actitargetedit")
	public ResultDto<Integer> actiTargetEdit(@RequestBody @Validated OcrmFMkActiTargetInfo[] record) throws ParseException {
		return this.serviceTarget.actiTargetEdit(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: actiCustInsert
	* @方法描述: 关联客户新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/acticustinsert")
	public ResultDto<Integer> actiCustInsert(@RequestBody @Validated OcrmFMkActiCustInfo[] record) throws ParseException {
		return this.serviceCust.actiCustInsert(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: actiCustEdit
	* @方法描述: 关联客户修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/acticustedit")
	public ResultDto<Integer> actiCustEdit(@RequestBody @Validated OcrmFMkActiCustInfo[] record) throws ParseException {
		return this.serviceCust.actiCustEdit(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: actiProdInsert
	* @方法描述: 关联产品新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actiprodinsert")
	public ResultDto<Integer> actiProdInsert(@RequestBody @Validated OcrmFMkActiProductInfo[] record) throws ParseException {
		return this.serviceProduct.actiProdInsert(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: actiProdEdit
	* @方法描述: 关联产品修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actiprodedit")
	public ResultDto<Integer> actiProdEdit(@RequestBody @Validated OcrmFMkActiProductInfo[] record) throws ParseException {
		return this.serviceProduct.actiProdEdit(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: actiFileInsert
	* @方法描述: 关联附件新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actifileinsert")
	public ResultDto<Integer> actiFileInsert(@RequestBody @Validated OcrmFMkActiAttachRelInfo[] record) throws ParseException{
		return this.serviceAttach.actiFileInsert(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: actiFileEdit
	* @方法描述: 关联附件修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actifileedit")
	public ResultDto<Integer> actiFileEdit(@RequestBody @Validated OcrmFMkActiAttachRelInfo[] record) throws ParseException{
		return this.serviceAttach.actiFileEdit(record);
	}
	/**
	* @方法名称: actiDel
	* @方法描述: 营销活动删除
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actidel")
	public ResultDto<Integer> actiDel(@RequestBody @Validated OcrmFMkActivityInfo[] record) {
		return this.service.actiDel(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: actiApproval
	* @方法描述: 营销活动提交
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actiapproval")
	public ResultDto<Integer> actiApproval(@RequestBody @Validated OcrmFMkActivityInfo record) throws ParseException {
		return this.service.actiApproval(record);
	}
	/**
	* @throws ParseException 
	 * @方法名称: actiExecute
	* @方法描述: 营销活动执行
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actiexecute")
	public ResultDto<Integer> actiExecute(@RequestBody @Validated OcrmFMkActivityInfo record) throws ParseException {
		return this.service.actiExecute(record);
	}
	/**
	* @throws ParseException 
	 * @throws UnsupportedEncodingException 
	 * @方法名称: actiOff
	* @方法描述: 营销活动关闭
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actioff") 
	public ResultDto<Integer> actiOff(@RequestBody @Validated OcrmFMkActivityInfo record) throws ParseException {
		return this.service.actiOff(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: actiTransfer
	* @方法描述: 营销活动移交
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actitransfer")
	public ResultDto<Integer> actiTransfer(@RequestBody @Validated OcrmFMkActivityInfo record) throws ParseException {
		return this.service.actiTransfer(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: actiTargetDecom
	* @方法描述: 营销活动分配
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actitargetdecom")
	public ResultDto<Integer> actiTargetDecom(@RequestBody @Validated OcrmFMkActiExobjInfo record) throws ParseException {
		return this.serviceObj.actiTargetDecom(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: actiFeedback
	* @方法描述: 营销活动反馈
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/actifeedback")
	public ResultDto<Integer> actiFeedback(@RequestBody @Validated OcrmFMkActiFedbackInfo record) throws ParseException {
		return this.servicefd.actiFeedback(record);
	}
	/**
	* @方法名称: getTargetPie
	* @方法描述: 营销成效指标目标机构占比图
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/gettargetpie")
	public ResultDto<List<Map<String,Object>>> getTargetPie(@Validated QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.serviceTarget.getTargetPie(model));
	}
	/**
	* @方法名称: getTargetBar
	* @方法描述: 营销成效指标目标机构完成情况对比图
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/gettargetbar")
	public ResultDto<List<Map<String,Object>>> getTargetBar(@Validated QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.serviceTarget.getTargetBar(model));
	}
	/**
	* @方法名称: getCmBar
	* @方法描述: 营销成效指标目标客户经理进展图
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/getcmbar")
	public ResultDto<List<Map<String,Object>>> getCmBar(@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.serviceTarget.getCmBar(model));
	}
	/**
	* @方法名称: getCmPie
	* @方法描述: 营销成效指标目标客户经理占比图
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/getcmpie")
	public ResultDto<List<Map<String,Object>>> getCmPie(@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.serviceTarget.getCmPie(model));
	}
	/**
	* @throws ParseException 
	* @方法名称: getActUser
	* @方法描述: 营销活动反馈查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actifedbacklist")
	public ResultDto<List<Map<String,Object>>> actiFedBackList (@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.servicefd.actiFedBackList(model));
	}
	/**
	* @方法名称: actiTree
	* @方法描述: 营销活动分析树
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actitree")
	public ResultDto<List<Map<String,Object>>>actiTree(@Validated QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.actiTree(model));
	}
}
