	package cn.com.yusys.yscrm.mktactivity.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiExcRecordInfo;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActiExcRecordMapper;
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
 * @类名称：OcrmFMkActiExcRecordService
 * @类描述：营销活动明细
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-29
 */
@Service
public class OcrmFMkActiExcRecordService extends CommonService{
	@Autowired
	private OcrmFMkActiExcRecordMapper mapper;
	@Autowired
	private UaaClient uaaClient;
	@Autowired
	private OcrmFMkActivityMapper mapperAct;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/** 
	* @方法名称: actiDetailListQuery
	* @方法描述: 营销活动明细查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>> actiDetailListQuery(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		if(model.getCondition().get("actiId") ==null) {
			model.getCondition().put("actiId", new BigDecimal("0"));
		}else {
			String actiId=model.getCondition().get("actiId").toString();
			model.getCondition().put("actiId", new BigDecimal(actiId));
		}
		List<Map<String,Object>> list = mapper.actiDetailListQuery(model);
		PageHelper.clearPage();
		return list;
	}
	/** 
	* @方法名称: actiExeDetailListQuery
	* @方法描述: 营销活动执行明细查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>> actiExeDetailListQuery(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		if(model.getCondition().get("actiId") ==null) {
			model.getCondition().put("actiId", new BigDecimal("0"));
		}else {
			String actiId=model.getCondition().get("actiId").toString();
			model.getCondition().put("actiId", new BigDecimal(actiId));
		}
		List<Map<String,Object>> list = mapper.actiExeDetailListQuery(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @throws ParseException 
	* @方法名称: judgeExeSts
	* @方法描述: 营销活动关联客户执行结果状态
	* @参数与返回说明: 
	* @算法描述:
	**/
	public String judgeExeSts(String custId,BigDecimal actiId) {
		String result="";
		Map<String,Object> param =new HashMap<String,Object>();
		param.put("custId", custId);
		param.put("actiId", actiId);
		List<Map<String,Object>> list1=mapper.countActiExeDetailList(param);//总数
		Long allNum=Long.parseLong(list1.get(0).get("allNum").toString());
		param.put("sts", "1");
		List<Map<String,Object>> list2=mapper.countActiExeDetailList(param);//执行中的总数
		Long exeNum=Long.parseLong(list2.get(0).get("allNum").toString());
		param.put("sts", "2");
		List<Map<String,Object>> list3=mapper.countActiExeDetailList(param);//成功的总数
		Long sucessNum=Long.parseLong(list3.get(0).get("allNum").toString());
		param.put("sts", "3");
		List<Map<String,Object>> list4=mapper.countActiExeDetailList(param);//失败的总数
		Long failNum=Long.parseLong(list4.get(0).get("allNum").toString());
		if(exeNum>0) {//有一个执行中，则关联客户表中变为执行中
			result="1";
		}
		if(failNum==allNum) {//所有的失败则为失败关闭
			result="3";
		}
		if((failNum+sucessNum)==allNum) {//所有明细都关闭后，有一个执行成功，则关联客户表中变为成功关闭
			result="2";
		}
		return result;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiExeDetailInsert
	* @方法描述: 营销活动执行明细新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiExeDetailInsert(OcrmFMkActiExcRecordInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		// 获取主键id，创建信息
		record.setRecordId(mapperAct.getSeq());
		record.setExecutorDate(df.parse(df.format(record.getExecutorDate())));
		record.setCreateDate(df.parse(df.format(new Date())));
		record.setCreateUser(SecurityUtils.getCurrentUserLogin());
		record.setCreateOrg(org.getBody().getOrg().getCode());
		record.setUpdateDate(record.getCreateDate());
		record.setUpdateOrg(record.getCreateOrg());
		record.setUpdateUser(record.getCreateUser());
		mapper.insertSelective(record);
		String sts=judgeExeSts(record.getCustId(),record.getActiId());
		if(!"".equals(sts)) {//修改关联客户的目标阶段信息
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("actiId", record.getActiId());
			params.put("custId", record.getCustId());
			params.put("sts", sts);
			params.put("lastUpdateTm", df.parse(df.format(new Date())));
			params.put("lastUpdateOrg", org.getBody().getOrg().getCode());
			params.put("lastUpdateUser", SecurityUtils.getCurrentUserLogin());
			mapper.updateCustStep(params);
		}
		dto.setCode(0);
		dto.setMessage("新增成功"); 
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiExeDetailEdit
	* @方法描述: 营销活动执行明细修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiExeDetailEdit(OcrmFMkActiExcRecordInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
			// 获取更新信息
			record.setExecutorDate(df.parse(df.format(record.getExecutorDate())));
			record.setUpdateDate(df.parse(df.format(new Date())));
			record.setUpdateOrg(org.getBody().getOrg().getCode());
			record.setUpdateUser(SecurityUtils.getCurrentUserLogin());
			mapper.updateByPrimaryKeySelective(record);
			String sts=judgeExeSts(record.getCustId(),record.getActiId());
			if(!"".equals(sts)) {//修改关联客户的目标阶段信息
				Map<String,Object> params=new HashMap<String,Object>();
				params.put("actiId", record.getActiId());
				params.put("custId", record.getCustId());
				params.put("sts", sts);
				params.put("lastUpdateTm", df.parse(df.format(new Date())));
				params.put("lastUpdateOrg", org.getBody().getOrg().getCode());
				params.put("lastUpdateUser", SecurityUtils.getCurrentUserLogin());
				mapper.updateCustStep(params);
			}
			dto.setCode(0);
			dto.setMessage("更新成功");
		
		return dto;
	}
	/** 
	* @方法名称: actiExeDetailDel
	* @方法描述: 营销活执行动明细删除
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiExeDetailDel(OcrmFMkActiExcRecordInfo[] record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		for(int i=0;i<record.length;i++) {
			mapper.actiExeDetailDel(record[i].getRecordId());
		}
		dto.setCode(0);
		dto.setMessage("删除成功");
		return dto;
	}
}