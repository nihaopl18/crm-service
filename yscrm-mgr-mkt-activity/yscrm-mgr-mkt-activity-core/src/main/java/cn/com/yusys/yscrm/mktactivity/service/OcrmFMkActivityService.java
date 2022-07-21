package cn.com.yusys.yscrm.mktactivity.service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiAttachRelInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiCustInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiExobjInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiProductInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiTargetInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiTransApplyInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActivityInfo;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActiAttachRelMapper;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActiCustMapper;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActiExobjMapper;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActiProductMapper;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActiTargetMapper;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActivityMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkActivityService
 * @类描述：营销活动管理
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-24
 */
@Service
public class OcrmFMkActivityService extends CommonService{
	@Autowired
	private OcrmFMkActivityMapper mapper;
	@Autowired
	private OcrmFMkActiCustMapper mapperCust;
	@Autowired
	private OcrmFMkActiProductMapper mapperProd;
	@Autowired
	private OcrmFMkActiTargetMapper mapperTarget;
	@Autowired
	private OcrmFMkActiAttachRelMapper mapperFile;
	
	@Autowired
	private OcrmFMkActiExobjMapper tragetObjMapper;
	@Autowired
	private UaaClient uaaClient;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* @方法名称: actiListQuery
	* @方法描述: 营销活动信息查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>> actiListQuery(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		model.getCondition().put("org", org.getBody().getOrg().getCode());
		List<Map<String,Object>> list = mapper.actiListQuery(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: myActiListQuery
	* @方法描述: 我的营销活动信息查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>> myActiListQuery(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		model.getCondition().put("userId", org.getBody().getUserId());
		List<Map<String,Object>> list = mapper.myActiListQuery(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: cmMonitor
	* @方法描述: 客户经理监控
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>cmMonitor(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.cmMonitor(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: cmMonitorRelation
	* @方法描述: 客户经理监控执行中数
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>cmMonitorRelation(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.cmMonitorRelation(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: cmMonitorSuccess
	* @方法描述: 客户经理监控成功数
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>cmMonitorSuccess(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.cmMonitorSuccess(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: cmMonitorFail
	* @方法描述: 客户经理监控失败数
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>cmMonitorFail(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.cmMonitorFail(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @throws ParseException 
	* @方法名称: activityTargetInfo
	* @方法描述: 查询活动指标信息
	* @参数与返回说明: 
	* @算法描述:
	**/
  public List<Map<String,Object>> activityTargetInfo(String actiIds){
		 List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
		 BigDecimal actiId=null;
		 if(actiIds ==null) {
			 actiId=new BigDecimal("0");
		 }else {
			 actiId=new BigDecimal(actiIds);
		 }
		 result=mapperTarget.ActiviTargetByActivity(actiId);
		 return result;
	 }
	/**
	* @throws ParseException 
	* @方法名称: getCustInfoByObj
	* @方法描述: 查询活动关联客户根据执行对象和客户的归属关系
	* @参数与返回说明: 
	* @算法描述:
	**/
  public List<Map<String,Object>> getCustInfoByObj(String actiIds,String userId){
		 List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
		 Map<String,Object> param=new HashMap<String,Object>();
		 BigDecimal actiId=null;
		 if(actiIds ==null) {
			 actiId=new BigDecimal("0");
		 }else {
			 actiId=new BigDecimal(actiIds);
		 }
		 param.put("actiId", actiId);
		 param.put("userId", userId);
		 result=mapperCust.getCustInfoByObj(param);
		 return result;
	 }
	/**
	* @throws ParseException 
	* @方法名称: getProdInfoByAct
	* @方法描述: 查询活动关联产品信息
	* @参数与返回说明: 根据活动编号查询关联产品信息
	* @算法描述:
	**/
  public List<Map<String,Object>> getProdInfoByAct(String actiIds){
		 List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
		 Map<String,Object> param=new HashMap<String,Object>();
		 BigDecimal actiId=null;
		 if(actiIds ==null) {
			 actiId=new BigDecimal("0");
		 }else {
			 actiId=new BigDecimal(actiIds);
		 }
		 param.put("actiId", actiId);
		 result=mapperProd.getProdInfoByAct(param);
		 return result;
	 }
	/**
	* @方法名称: orgMonitor
	* @方法描述: 机构监控
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>orgMonitor(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.orgMonitor(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: orgMonitorRelation
	* @方法描述: 机构监控执行中数
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>orgMonitorRelation(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.orgMonitorRelation(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: orgMonitorSuccess
	* @方法描述: 机构监控成功数
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>orgMonitorSuccess(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.orgMonitorSuccess(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: orgMonitorFail
	* @方法描述: 机构监控失败数
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>orgMonitorFail(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.orgMonitorFail(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: actiMonitor
	* @方法描述: 活动监控
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>actiMonitor(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.actiMonitor(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: actiMonitorRelation
	* @方法描述: 活动监控执行中数
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>actiMonitorRelation(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.actiMonitorRelation(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: actiMonitorSuccess
	* @方法描述: 活动监控成功数
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>actiMonitorSuccess(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.actiMonitorSuccess(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: actiMonitorFail
	* @方法描述: 活动监控失败数
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>actiMonitorFail(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.actiMonitorFail(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: actiProdListQuery
	* @方法描述: 营销活动关联产品信息查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>> actiProdListQuery(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.actiProdListQuery(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: actiCustListQuery
	* @方法描述: 营销活动关联客户信息查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>> actiCustListQuery(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.actiCustListQuery(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: actiTargetListQuery
	* @方法描述: 营销成效指标查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>> actiTargetListQuery(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		if(model.getCondition().get("exeObjType")!=null) {
			if(model.getCondition().get("exeObjType").equals("1")) {//机构类
				list = mapper.actiOrgTargetListQuery(model);
				for(int i=0;i<list.size();i++) {
					Map<String,Object> info=list.get(i);
					Map<String,Object> param=new HashMap<String,Object>();
					param.put("objId", info.get("exeObjCode").toString());
					param.put("actiId", info.get("actiId"));
					List<Map<String,Object>> tar= mapperTarget.ActiviTargetByObj(param);
					for(int s=0;s<tar.size();s++) {//循环添加指标的初期值和目标值
						Map<String,Object> tt=tar.get(s);
						info.put("orignalVal"+tt.get("targetCode").toString(), tt.get("orignalVal"));
						info.put("targetValue"+tt.get("targetCode").toString(), tt.get("targetValue"));
					}
				}
			}else if(model.getCondition().get("exeObjType").equals("0")) {//用户类
				list = mapper.actiUserTargetListQuery(model);
				for(int i=0;i<list.size();i++) {
					Map<String,Object> info=list.get(i);
					Map<String,Object> param=new HashMap<String,Object>();
					param.put("objId", info.get("exeObjCode").toString());
					param.put("actiId", info.get("actiId"));
					List<Map<String,Object>> tar= mapperTarget.ActiviTargetByObj(param);
					for(int s=0;s<tar.size();s++) {//循环添加指标的初期值和目标值
						Map<String,Object> tt=tar.get(s);
						info.put("orignalVal"+tt.get("targetCode").toString(), tt.get("orignalVal"));
						info.put("targetValue"+tt.get("targetCode").toString(), tt.get("targetValue"));
					}
				}
			}
			
		}
		
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: actiFileListQuery
	* @方法描述: 营销活动附件信息查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>> actiFileListQuery(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.actiFileListQuery(model);
		PageHelper.clearPage();
		return list;
	}     
	      
	/**
	* @throws ParseException 
	* @方法名称: activiInsert
	* @方法描述: 销售活动新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	 @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> activiInsert(Map<String,Object> info) throws ParseException {
		ResultDto<Object> dto = new ResultDto<Object>();
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		OcrmFMkActivityInfo record;
		try {
			//record = (OcrmFMkActivityInfo) mapToObject(map,OcrmFMkActivityInfo.class);
			 record =JSON.parseObject(info.get("baseInfo").toString(),OcrmFMkActivityInfo.class);
			// 设置主键
			record.setActiId(mapper.getSeq());
			// 营销活动名称验重
			if(mapper.actiSameName(record) != 0) {
				dto.setCode(-1);
				dto.setMessage("营销活动名称重复");
			} else {
				// 设置营销状态为暂存、父营销活动为根节点
				record.setActiStat("0");
				record.setMktAppState("0");
				record.setParentActiId(BigDecimal.valueOf(0));
				// 设置日期格式
				record.setPstartDate(df.parse(df.format(record.getPstartDate())));
				record.setPendDate(df.parse(df.format(record.getPendDate())));
				// 设置创建信息
				record.setCreateDate(df.parse(df.format(new Date())));
				record.setCreateOrg(org.getBody().getOrg().getCode());
				record.setCreateUser(SecurityUtils.getCurrentUserLogin());
				// 设置最新更新信息
				record.setLastUpdateOrg(record.getCreateOrg());
				record.setLastUpdateTm(record.getCreateDate());
				record.setLastUpdateUser(record.getCreateUser());
				record.setMktRespPersonOrg(record.getCreateOrg());
				mapper.insertSelective(record);
				actiCustInsert(info,record.getActiId());//客户信息
				actiProdInsert(info,record.getActiId());//产品信息
				//actiFileInsert(info,record.getActiId());//附件信息
				actiTargetInsert(info,record.getActiId());//指标信息
				dto.setCode(0);
				dto.setMessage("新增成功");
				dto.setData(record.getActiId().intValue());
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiEdit
	* @方法描述: 销售活动修改
	* @参数与返回说明: 先删除关联信息，在新增关联信息
	* @算法描述:
	**/
	 @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> actiEdit(Map<String,Object> info) throws ParseException {
		ResultDto<Object> dto = new ResultDto<Object>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		OcrmFMkActivityInfo record =JSON.parseObject(info.get("baseInfo").toString(),OcrmFMkActivityInfo.class);
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		if(mapper.actiSameName(record) != 0) {
			// 营销活动名称验重
			dto.setCode(-1);
			dto.setMessage("营销活动名称重复");
		}  else {
			// 设置营销状态为暂存
			record.setActiStat("0");
			// 设置日期格式
			record.setPstartDate(df.parse(df.format(record.getPstartDate())));
			record.setPendDate(df.parse(df.format(record.getPendDate())));
			// 设置最新更新信息
			record.setLastUpdateOrg(org.getBody().getOrg().getCode());
			record.setLastUpdateTm(df.parse(df.format(new Date())));
			record.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
			mapper.updateByPrimaryKeySelective(record);
			//先删除关联信息，在新增
			mapperCust.lastCustDel(record.getActiId());
			mapperProd.lastProdDel(record.getActiId());
			mapperTarget.lastTargetDel(record.getActiId());
			mapperFile.lastFileDel(record.getActiId());
			tragetObjMapper.lastExobjDel(record.getActiId());
			actiCustInsert(info,record.getActiId());//客户信息
			actiProdInsert(info,record.getActiId());//产品信息
			actiFileInsert(info,record.getActiId());//附件信息
			actiTargetInsert(info,record.getActiId());//指标信息
			dto.setCode(0);
			dto.setMessage("修改成功");
		}
		return dto;
	}
		/**
		* @throws ParseException 
		* @方法名称: actiTargetDcom
		* @方法描述: 营销成效指标分解保存
		* @参数与返回说明: 先删除相关的指标设置，然后在新增
		* @算法描述:
		**/
		 @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
		public ResultDto<Object> actiTargetDcom(Map<String,Object> map) throws ParseException {
			ResultDto<Object> dto = new ResultDto<Object>();
			if(map.get("actiId")==null) {
				dto.setCode(-1);
				dto.setMessage("没有活动主键信息");
			}else {
				BigDecimal actiId=new BigDecimal(map.get("actiId").toString());
				List taskInfo =  JSON.parseObject(map.get("taskInfo").toString(),List.class);
				List<String> objCode=new ArrayList<String>();
				for(int i=0;i<taskInfo.size();i++) {
					Map<String,Object> task = JSON.parseObject(taskInfo.get(i).toString(),Map.class);
					objCode.add(task.get("exeObjCode").toString());
				}
				Map<String,Object> param=new HashMap<String,Object>();
				param.put("actiId", actiId);
				param.put("objCode", objCode);
				mapper.delTargetObjByOrg(param);//删除机构下的指标执行对象数据
				mapper.delTargetByOrg(param);//先删除对应机构下的所有指标设置数据
				actiTargetInsert(map,actiId);//然后在保存信息
				dto.setCode(0);
				dto.setMessage("新增成功");
			}
			return dto;
		}
			/**
			* @throws ParseException 
			* @方法名称: actiDistr
			* @方法描述: 营销活动分配保存
			* @参数与返回说明: 先删除相关的指标设置，然后在新增
			* @算法描述:
			**/
			 @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
			public ResultDto<Object> actiDistr(Map<String,Object> map) throws ParseException {
				ResultDto<Object> dto = new ResultDto<Object>();
				if(map.get("actiId")==null) {
					dto.setCode(-1);
					dto.setMessage("没有活动主键信息");
				}else {
					// 获取机构信息	
					ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
					// 设置日期格式
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					BigDecimal actiId=new BigDecimal(map.get("actiId").toString());
					List taskInfo =  JSON.parseObject(map.get("taskInfo").toString(),List.class);
					List<String> objCode=new ArrayList<String>();
					for(int i=0;i<taskInfo.size();i++) {
						Map<String,Object> task = JSON.parseObject(taskInfo.get(i).toString(),Map.class);
						objCode.add(task.get("exeObjCode").toString());
					}
					Map<String,Object> param=new HashMap<String,Object>();
					param.put("actiId", actiId);
					param.put("objCode", objCode);
					mapper.delTargetObjByOrg(param);//删除机构下的指标执行对象数据
					mapper.delTargetByOrg(param);//先删除对应机构下的所有指标设置数据
					actiTargetInsert(map,actiId);//然后在保存信息
					Map<String,Object> param2=new HashMap<String,Object>();
					param2.put("actiId", actiId);
					param2.put("lastUpdateTm", df.parse(df.format(new Date())));
					param2.put("lastUpdateOrg", org.getBody().getOrg().getCode());
					param2.put("lastUpdateUser", SecurityUtils.getCurrentUserLogin());
					mapper.actiRelease(param2);//修改营销活动的活动状态未以下达
					dto.setCode(0);
					dto.setMessage("新增成功");
				}
				return dto;
			}
			/**
			* @throws ParseException 
			* @方法名称: actiTargetDistr
			* @方法描述: 营销成效指标分解-修改执行对象和关联客户的主办客户经理
			* @参数与返回说明: 先删除相关的指标设置，然后在新增
			* @算法描述:
			**/
			 @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
			public ResultDto<Object> actiTargetDistr(Map<String,Object> map) throws ParseException {
				ResultDto<Object> dto = new ResultDto<Object>();
				// 获取机构信息	
				ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
				if(map.get("actiId")==null) {
					dto.setCode(-1);
					dto.setMessage("没有活动主键信息");
				}else {
					// 设置日期格式
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					BigDecimal actiId=new BigDecimal(map.get("actiId").toString());
					map.put("actiId", actiId);
					map.put("lastUpdateTm", df.parse(df.format(new Date())));
					map.put("lastUpdateOrg", org.getBody().getOrg().getCode());
					map.put("lastUpdateUser", SecurityUtils.getCurrentUserLogin());
					mapper.actiCustDcom(map);//修改关联客户中的主办经理
					mapper.actiCustTaskObj(map);//修改指标执行对象信息
					mapper.actiCustTaskInfo(map);//修改指标数据中的执行对象信息
					dto.setCode(0);
					dto.setMessage("操作成功");
				}
				return dto;
			}
	/**
	* @throws ParseException 
	* @方法名称: actiTargetInsert
	* @方法描述: 营销成效指标新增
	* @参数与返回说明: 执行对象和指标是一对多的关系，所以先保存对象信息，在循环保存指标信息
	* @算法描述:
	**/
	 @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Integer> actiTargetInsert(Map<String,Object> map,BigDecimal activityId) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		List taskInfo =  JSON.parseObject(map.get("taskInfo").toString(),List.class);
		List selectTaskInfo =  JSON.parseObject(map.get("selectTaskInfo").toString(),List.class);
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		
		for(int i=0;i<taskInfo.size();i++) {
			Map<String,Object> task = JSON.parseObject(taskInfo.get(i).toString(),Map.class);
			OcrmFMkActiExobjInfo obj = JSON.parseObject(taskInfo.get(i).toString(),OcrmFMkActiExobjInfo.class);
			obj.setObjId(mapper.getSeq());
			obj.setActiId(activityId);//设置活动ID
			// 设置创建信息
			obj.setCreateDate(df.parse(df.format(new Date())));
			obj.setCreateOrg(org.getBody().getOrg().getCode());
			obj.setCreateUser(SecurityUtils.getCurrentUserLogin());
			// 设置更新信息
			obj.setUpdateDate(obj.getCreateDate());
			obj.setUpdateOrg(obj.getCreateOrg());
			obj.setUpdateUser(obj.getCreateUser());
			tragetObjMapper.insertSelective(obj);
			
			for(int j=0;j<selectTaskInfo.size();j++) {//循环保存指标信息
				Map<String,Object> mapinfo = JSON.parseObject(selectTaskInfo.get(j).toString(),Map.class);
				OcrmFMkActiTargetInfo record=new OcrmFMkActiTargetInfo();
				record.setTargetId(mapper.getSeq());
				record.setExeObjType(obj.getExeObjType()); // 对象类型
				record.setExeObjCode(obj.getExeObjCode()); // 对象ID
				record.setExeObjName(obj.getExeObjName()); // 对象名
				record.setActiId(activityId);//设置活动ID
				record.setTargetCode(mapinfo.get("targetCode").toString());
				record.setTargetName(mapinfo.get("targetName").toString());
				String flag1="targetValue"+mapinfo.get("targetCode").toString();
				if(task.get(flag1)!=null) {//设置初期值
					record.setTargetValue(new BigDecimal(task.get(flag1).toString()));
				}else {
					record.setTargetValue(new BigDecimal("0"));
				}
				String flag2="orignalValt"+mapinfo.get("targetCode").toString();
				if(task.get(flag2)!=null) {//设置目标值
					record.setOrignalVal(new BigDecimal(task.get(flag1).toString()));
				}else {
					record.setOrignalVal(new BigDecimal("0"));
				}
				// 设置创建信息
				record.setCreateDate(df.parse(df.format(new Date())));
				record.setCreateOrg(org.getBody().getOrg().getCode());
				record.setCreateUser(SecurityUtils.getCurrentUserLogin());
				// 设置更新信息
				record.setUpdateDate(record.getCreateDate());
				record.setUpdateOrg(record.getCreateOrg());
				record.setUpdateUser(record.getCreateUser());
				mapperTarget.insertSelective(record);
				
			}
		}
		
		
		dto.setCode(0);
		dto.setMessage("新增成功");
		return dto;
	}

	/**
	* @throws ParseException 
	* @方法名称: actiCustInsert
	* @方法描述: 关联客户新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiCustInsert(Map<String,Object> map,BigDecimal activityId) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		List custInfo =  JSON.parseObject(map.get("custInfo").toString(),List.class);
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		for(int i=0;i<custInfo.size();i++) {
			OcrmFMkActiCustInfo record = JSON.parseObject(custInfo.get(i).toString(),OcrmFMkActiCustInfo.class);
			// 设置主键
			record.setRecordId(mapper.getSeq());
			record.setActiId(activityId);//设置活动ID
			// 设置关联客户日期
			record.setRelationDate(df.parse(df.format(record.getRelationDate())));
			// 设置创建信息
			record.setCreateDate(df.parse(df.format(new Date())));
			record.setCreateOrg(org.getBody().getOrg().getCode());
			record.setCreateUser(SecurityUtils.getCurrentUserLogin());
			// 设置更新信息
			record.setUpdateDate(record.getCreateDate());
			record.setUpdateOrg(record.getCreateOrg());
			record.setUpdateUser(record.getCreateUser());
			mapperCust.insertSelective(record);
		}
		dto.setCode(0);
		dto.setMessage("新增成功");
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiProdInsert
	* @方法描述: 关联产品新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiProdInsert( Map<String,Object> map,BigDecimal activityId) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		List prodInfo =  JSON.parseObject(map.get("prodInfo").toString(),List.class);
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		for(int i=0;i<prodInfo.size();i++) {
			OcrmFMkActiProductInfo record=JSON.parseObject(prodInfo.get(i).toString(),OcrmFMkActiProductInfo.class);
			// 设置主键
			record.setRecordId(mapper.getSeq());
			record.setActiId(activityId);//设置活动ID
			// 设置创建信息
			record.setCreateDate(df.parse(df.format(new Date())));
			record.setCreateOrg(org.getBody().getOrg().getCode());
			record.setCreateUser(SecurityUtils.getCurrentUserLogin());
			// 设置更新信息
			record.setUpdateDate(record.getCreateDate());
			record.setUpdateOrg(record.getCreateOrg());
			record.setUpdateUser(record.getCreateUser());
			mapperProd.insertSelective(record);
		}
		dto.setCode(0);
		dto.setMessage("新增成功");
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiFileInsert
	* @方法描述: 关联附件新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiFileInsert( Map<String,Object> map,BigDecimal activityId) throws ParseException{
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if(map.get("fileInfo")!=null&&!map.get("fileInfo").equals("null")) {
			List fileInfo =  JSON.parseObject(map.get("fileInfo").toString(),List.class);
			// 获取机构信息	
			ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
			for(int i=0;i<fileInfo.size();i++) {
				OcrmFMkActiAttachRelInfo record=JSON.parseObject(fileInfo.get(i).toString(),OcrmFMkActiAttachRelInfo.class);
				// 设置主键
				record.setRecordId(mapper.getSeq());
				record.setActiId(activityId);//设置活动ID
				// 设置创建信息
				record.setCreateDate(df.parse(df.format(new Date())));
				record.setCreateOrg(org.getBody().getOrg().getCode());
				record.setCreateUser(SecurityUtils.getCurrentUserLogin());
				// 设置更新信息
				record.setUpdateDate(record.getCreateDate());
				record.setUpdateOrg(record.getCreateOrg());
				record.setUpdateUser(record.getCreateUser());
				mapperFile.insertSelective(record);
			}
			dto.setCode(0);
			dto.setMessage("新增成功");
		}
		
		return dto;
	}
	/**
	* @方法名称: actiDel
	* @方法描述: 营销活动删除
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiDel(OcrmFMkActivityInfo[] record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		if(record.length == 0) {
			dto.setCode(-1);
			dto.setMessage("未选择数据");
		} else {
			for(int i=0;i<record.length;i++) {
				mapper.actiDel(record[i].getActiId());
				// 删除关联数据
				mapperCust.lastCustDel(record[i].getActiId());
				mapperProd.lastProdDel(record[i].getActiId());
				mapperTarget.lastTargetDel(record[i].getActiId());
				mapperFile.lastFileDel(record[i].getActiId());
			}
			dto.setCode(0);
			dto.setMessage("删除成功");
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiApproval
	* @方法描述: 营销活动提交
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiApproval(OcrmFMkActivityInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
			record.setLastUpdateOrg(org.getBody().getOrg().getCode());
			record.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
			record.setLastUpdateTm(df.parse(df.format(new Date())));
			mapper.actiApproval(record);
			dto.setCode(0);
			dto.setMessage("提交成功");
		return dto;
	}
	/**
	* @throws ParseException 
	 * @方法名称: actiExecute
	* @方法描述: 营销活动执行
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiExecute(OcrmFMkActivityInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		record.setLastUpdateOrg(org.getBody().getOrg().getCode());
		record.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		record.setLastUpdateTm(df.parse(df.format(new Date())));
		mapper.actiExecute(record);
		// 执行活动对应指标生成子活动
		List<Map<String,Object>> node = mapper.getSonNode(record.getActiId());
		Map<String,Object> map = new HashMap<String,Object>();
		if(node != null) {
			Iterator<Map<String,Object>> it = node.iterator();
			BigDecimal parentId = record.getActiId();
			String parentName = record.getActiName();
			while(it.hasNext()) {
				map = it.next();
				// 生成子活动名
				record.setActiName(parentName + "("+map.get("actiName").toString() +")");
				// 生成子活动活动负责人
				if("0".equals(map.get("exeObjType").toString())) {
					record.setMktRespPerson(map.get("exeObjCode").toString());
					record.setMktRespPersonOrg("");
				} else if ("1".equals(map.get("exeObjType").toString())) {
					record.setMktRespPerson("");
					record.setMktRespPersonOrg(map.get("exeObjCode").toString());
				}
				// 生成父活动id,活动id
				record.setParentActiId(parentId);
				record.setActiId(mapper.getSeq());
				// 新增子活动
				mapper.insertSelective(record);
			}
		}
		dto.setCode(0);
		dto.setMessage("执行成功");
		return dto;
	}
	/**
	* @throws ParseException 
	 * @方法名称: actiUpSuccess
	* @方法描述: 营销活动审批成功
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiUpSuccess(OcrmFMkActivityInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
			record.setLastUpdateOrg(org.getBody().getOrg().getCode());
			record.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
			record.setLastUpdateTm(df.parse(df.format(new Date())));
			mapper.actiUpSuccess(record);
			dto.setCode(0);
			dto.setMessage("提交成功");
		
		return dto;
	}
	/**
	* @throws ParseException 
	 * @方法名称: actiUpFailed
	* @方法描述: 营销活动审批失败
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiUpFailed(OcrmFMkActivityInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
			record.setLastUpdateOrg(org.getBody().getOrg().getCode());
			record.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
			record.setLastUpdateTm(df.parse(df.format(new Date())));
			mapper.actiUpFailed(record);
			dto.setCode(0);
			dto.setMessage("提交失败");
		
		return dto;
	}
	/**
	* @throws ParseException 
	 * @throws UnsupportedEncodingException 
	 * @方法名称: actiOff
	* @方法描述: 营销活动关闭
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiOff(OcrmFMkActivityInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
			record.setAendDate(df.parse(df.format(new Date())));
			record.setLastUpdateOrg(org.getBody().getOrg().getCode());
			record.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
			record.setLastUpdateTm(df.parse(df.format(new Date())));
			mapper.actiOff(record);
			dto.setCode(0);
			dto.setMessage("关闭成功");
		
		return dto;	
	}
	/**
	* @throws ParseException 
	* @方法名称: actiTransfer
	* @方法描述: 营销活动移交
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiTransfer(OcrmFMkActivityInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		//更新营销活动的负责人
		OcrmFMkActivityInfo pool=mapper.selectByPrimaryKey(record.getActiId());
		pool.setMktRespPerson(record.getMktRespPerson());
		// 最近更新信息
		pool.setLastUpdateTm(df.parse(df.format(new Date())));
		pool.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		pool.setLastUpdateOrg(org.getBody().getOrg().getCode());
		mapper.updateByPrimaryKeySelective(pool);
		// 构建营销活动移交实体类-保存移交历史记录
		OcrmFMkActiTransApplyInfo transObj = new OcrmFMkActiTransApplyInfo();
		// 设置主键
		transObj.setRecordId(mapper.getSeq());
		// 设置移交信息
		transObj.setActiId(record.getActiId());
		transObj.setActiName(record.getActiName());
		// 创建信息
		transObj.setCreateDate(df.parse(df.format(new Date())));
		transObj.setCreateOrg(org.getBody().getOrg().getCode());
		transObj.setCreateUser(SecurityUtils.getCurrentUserLogin());
		// 最近更新信息
		transObj.setUpdateDate(transObj.getCreateDate());
		transObj.setUpdateUser(transObj.getCreateUser());
		transObj.setUpdateOrg(transObj.getCreateOrg());
		// 移交人为当前登录人
		transObj.setFromUser(SecurityUtils.getCurrentUserLogin());
		// 接收人为营销活动负责人
		transObj.setToUser(record.getMktRespPerson());
		transObj.setMoveDate(transObj.getCreateDate());
		// 备注设置为空
		transObj.setRemark("");
		mapper.actiTransfer(transObj);
		dto.setCode(0);
		dto.setMessage("移交成功");
		return dto;
	}
	/**
	* @方法名称: actiTree
	* @方法描述: 营销活动分析树
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>actiTree(QueryModel model) {
		return mapper.actiTree(model);
	}
	/**
	* @throws ParseException 
	 * @方法名称: actiErrorDel
	* @方法描述: 营销活动输入错误删除
	* @参数与返回说明: 
	* @算法描述:
	**/
	public void actiErrorDel(BigDecimal actiId) {
		mapper.actiDel(actiId);
		// 删除关联数据
		mapperCust.lastCustDel(actiId);
		mapperProd.lastProdDel(actiId);
		mapperTarget.lastTargetDel(actiId);
		mapperFile.lastFileDel(actiId);
	}
}
