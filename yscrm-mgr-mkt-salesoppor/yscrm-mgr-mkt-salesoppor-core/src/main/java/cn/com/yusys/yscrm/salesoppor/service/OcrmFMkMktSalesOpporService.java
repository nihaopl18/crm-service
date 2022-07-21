package cn.com.yusys.yscrm.salesoppor.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.salesoppor.domain.OcrmFMkMktSalesOpporInfo;
import cn.com.yusys.yscrm.salesoppor.repository.mapper.OcrmFMkMktSalesOpporMapper;
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
 * @类名称：OcrmFMkMktSalesOpporService
 * @类描述：商机管理相关Service
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-14
 */
@Service
public class OcrmFMkMktSalesOpporService extends CommonService{
	@Autowired
	private OcrmFMkMktSalesOpporMapper mapper;
	@Autowired
	private UaaClient uaaClient;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* @方法名称: opporListQuery
	* @方法描述: 获取商机池信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>> opporListQuery(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.opporListQuery(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: opporDel
	* @方法描述: 删除商机
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> opporDel(OcrmFMkMktSalesOpporInfo record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		int fail_no = 0;
		String[] arr = record.getBusinessNo().split(",");
		for(int i=0;i<arr.length;i++) {
			// 判断商机是否可以删除
			if("4".equals(mapper.getBusiStat(record.getBusinessNo()))) {
				fail_no++;
			} else {
				// 删除商机
				mapper.opporDel(arr[i]);
				// 删除商机关联营销活动
				mapper.opporActiDel(arr[i]);
			}
		}
		if(fail_no == 0) {
			dto.setCode(0);
		} else {
			dto.setCode(-1);
		}
		dto.setMessage("共有" + fail_no + "条商机未删除");
		return dto;
	}
	/**
	* @方法名称: myOpporListQuery
	* @方法描述: 获取客户经理商机信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> myOpporListQuery(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.myOpporListQuery(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @throws ParseException 
	* @方法名称: opporInsert
	* @方法描述: 新增商机
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> opporInsert(OcrmFMkMktSalesOpporInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		if("".equals(record.getCustGroupId()) || record.getCustGroupId() == null) {
			// 设置商机编号
			record.setBusinessNo(getUUID());
			// 生成单个商机
			if(mapper.sameBusinessNo(record) == 0 &&
			   mapper.sameBusinessName(record) == 0) {
				// 设置商机状态
				if("".equals(record.getExecuteUser()) || record.getExecuteUser() == null || "VM".equals(record.getExecuteUser().substring(0,2))) {
					record.setBusinessState("1"); // 无执行人设为待分配
				} else {
					record.setBusinessState("0"); // 有执行人设为暂存
				}
				// 设置实际达成金额默认为零
				record.setReachAmount(0);
				// 设置创建人、最近维护人、分配人为当前登录人
				record.setCreateUser(SecurityUtils.getCurrentUserLogin());
				record.setUpdataUser(SecurityUtils.getCurrentUserLogin());
				record.setAssignUser(SecurityUtils.getCurrentUserLogin());
				// 设置创建机构、最近维护机构、分配机构
				record.setCreateOrg(org.getBody().getOrg().getCode());
				record.setUpdataOrg(org.getBody().getOrg().getCode());
				record.setAssignOrg(org.getBody().getOrg().getCode());
				// 设置创建日期、最近维护日期、分配日期为当前日期
				record.setCreateDate(df.parse(df.format(new Date())));
				record.setUpdataDate(record.getCreateDate());
				record.setAssignDate(record.getCreateDate());
				// 设置商机来源为手动创建
				record.setBusinessSource("0");
				// 设置执行人
				if("".equals(record.getExecuteUser()) || record.getExecuteUser() == null) {
					// 执行人为空设置为虚拟客户经理
					record.setExecuteOrg(org.getBody().getOrg().getCode());
					record.setExecuteUser("VM"+ record.getExecuteOrg());
				}
				mapper.insertSelective(record);
				dto.setCode(0);
				dto.setMessage("新增成功");
			} else {
				// 编号名称重复
				dto.setCode(-1);
				dto.setMessage("商机编号或名称重复");
			}
		} else {
			// 根据客户群编号批量生成商机
			List<Map<String,Object>> custList = mapper.getGroupCustList(record.getCustGroupId());
			Iterator<Map<String, Object>> it = custList.iterator();
			int n = 0;
			if(mapper.sameBusinessName(record) == 0) {
				// 设置商机状态为暂存
				record.setBusinessState("0");
				// 设置实际达成金额默认为零
				record.setReachAmount(0);
				// 设置创建人、最近维护人、分配人为当前登录人
				record.setCreateUser(SecurityUtils.getCurrentUserLogin());
				record.setUpdataUser(SecurityUtils.getCurrentUserLogin());
				record.setAssignUser(SecurityUtils.getCurrentUserLogin());
				// 设置创建机构、最近维护机构、分配机构
				record.setCreateOrg(org.getBody().getOrg().getCode());
				record.setUpdataOrg(org.getBody().getOrg().getCode());
				record.setAssignOrg(org.getBody().getOrg().getCode());
				// 设置创建日期、最近维护日期、分配日期为当前日期
				record.setCreateDate(df.parse(df.format(new Date())));
				record.setUpdataDate(record.getCreateDate());
				record.setAssignDate(record.getCreateDate());
				// 设置商机来源为内部名单批量创建
				record.setBusinessSource("3");
				while(it.hasNext()) {
					// 设置商机编号
					record.setBusinessNo(getUUID());
					// 设置客户编号
					record.setCustId(it.next().get("custId").toString());
					// 设置商机名称为客户编号+产品名称
					record.setBusinessName("客户：" + record.getCustId() + "对应产品" + record.getContactProdName() + "的批量商机");
					// 设置客户联系人
					if(it.next().get("contName") != null) {
						record.setCustContact(it.next().get("contName").toString());
					}
					// 设置客户联系方式
					if(it.next().get("contMeth") != null) {
						record.setCustConcactInfo(it.next().get("contMeth").toString());
					}
					// 批量生成商机执行人为虚拟客户经理
					record.setExecuteOrg(org.getBody().getOrg().getCode());
					record.setExecuteUser("VM"+ record.getExecuteOrg());
					// 新增商机
					mapper.insertSelective(record);
					n++;
				}	
			}
			dto.setCode(0);
			dto.setMessage("批量生成商机成功");
			dto.setData(n);
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: opporEdit
	* @方法描述: 修改商机
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> opporEdit(OcrmFMkMktSalesOpporInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		if(mapper.sameBusinessName(record) == 0) {
			// 设置最近维护人、分配人为当前登录人
			record.setUpdataUser(SecurityUtils.getCurrentUserLogin());
			record.setAssignUser(SecurityUtils.getCurrentUserLogin());
			// 设置最近维护机构、分配机构
			record.setUpdataOrg(org.getBody().getOrg().getCode());
			record.setAssignOrg(org.getBody().getOrg().getCode());
			// 设置最近维护日期、分配日期为当前日期
			record.setUpdataDate(df.parse(df.format(new Date())));
			record.setAssignDate(record.getUpdataDate());
			// 设置执行人
			if("".equals(record.getExecuteUser())) {
				// 执行人为空设置为虚拟客户经理
				record.setExecuteOrg(org.getBody().getOrg().getCode());
				record.setExecuteUser("VM"+ record.getExecuteOrg());
			}
			mapper.updateByPrimaryKeySelective(record);
			dto.setCode(0);
			dto.setMessage("修改成功");
		} else {
			// 商机编号名称重复
			dto.setCode(-1);
			dto.setMessage("商机名称重复");
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: opporAssign
	* @方法描述: 商机分配
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> opporAssign(OcrmFMkMktSalesOpporInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if(!"1".equals(record.getBusinessState()) && !"0".equals(record.getBusinessState())) {
			dto.setCode(-1);
			dto.setMessage("商机不是暂存或待分配状态");
		} else if (record.getExecuteUser().substring(0,2).equals("VM") && !"Q1".equals(mapper.custState(record.getCustId()))) {
			dto.setCode(-1);
			dto.setMessage("商机不能分配给虚拟客户经理");
		} 
//		else if (!mapper.getOrgId(record.getExecuteUser()).equals(record.getExecuteOrg())) {
//			dto.setCode(-1);
//			dto.setMessage("执行机构与执行人不匹配");
//		} 
		else {
			// 获取机构信息	
			ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
			// 设置商机状态为执行中
			record.setBusinessState("4");
			// 设置分配人、分配机构、分配日期
			record.setAssignUser(SecurityUtils.getCurrentUserLogin());
			record.setAssignDate(df.parse(df.format(new Date())));
			record.setAssignOrg(org.getBody().getOrg().getCode());
			mapper.opporAssign(record);
			// 新增客户经理归属关系
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("belongId", getUUID());
			map.put("custId", record.getCustId());
			map.put("orgType", "2");
			map.put("mgrType", "2");
			map.put("userId", record.getExecuteUser());
			mapper.addCustBelong(map);
			dto.setCode(0);
			dto.setMessage("分配成功");
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: opporReceiveUp
	* @方法描述: 商机认领提交
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> opporReceiveUp(OcrmFMkMktSalesOpporInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		if(!"1".equals(record.getBusinessState())) {
			dto.setCode(-1);
			dto.setMessage("只能认领待分配的商机");
		} else {
			// 设置认领人、认领日期、认领人机构
			record.setReceiveUser(SecurityUtils.getCurrentUserLogin());
			record.setReceiveDate(df.parse(df.format(new Date())));
			record.setReceiveOrg(org.getBody().getOrg().getCode());
			// 设置商机状态为待审批
			record.setBusinessState("3");
			mapper.opporReceive(record);
			// 新增客户经理归属关系
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("belongId", getUUID());
			map.put("custId", record.getCustId());
			map.put("orgType", "2");
			map.put("mgrType", "2");
			map.put("userId", record.getExecuteUser());
			mapper.addCustBelong(map);
			dto.setCode(0);
			dto.setMessage("认领成功");
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: opporReceive
	* @方法描述: 商机认领
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> opporReceive(OcrmFMkMktSalesOpporInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if(!"3".equals(record.getBusinessState())) {
			dto.setCode(-1);
			dto.setMessage("只能处理待审批的商机");
		} else {
			// 认领日期格式化
			record.setReceiveDate(df.parse(df.format(record.getReceiveDate())));
			// 设置商机状态为执行中
			record.setBusinessState("4");
			mapper.opporReceive(record);
			dto.setCode(0);
			dto.setMessage("认领成功");
		}
		return dto;
	}
	/**
	* @方法名称: opporBack
	* @方法描述: 商机退回
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> opporBack(OcrmFMkMktSalesOpporInfo record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 只能退回执行中的商机
		if(!"4".equals(record.getBusinessState())) {
			dto.setCode(-1);
			dto.setMessage("只能退回执行中的商机");
		} else {
			mapper.opporBack(record);
			// 删除客户经理归属关系
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("custId", record.getCustId());
			map.put("mgrId",mapper.getUserId(SecurityUtils.getCurrentUserLogin()));
			dto.setCode(0);
			dto.setMessage("退回成功");
		}
		return dto;
	}
	/**
	* @方法名称: opporOff
	* @方法描述: 商机关闭
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> opporOff(OcrmFMkMktSalesOpporInfo record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 判断关闭状态
		if("1".equals(record.getOffStat())) {
			record.setBusinessState("8");
		} else if ("2".equals(record.getOffStat())) {
			record.setBusinessState("7");
		} else {
			dto.setCode(-1);
			dto.setMessage("关闭状态格式错误");
		}
		if("2".equals(mapper.custType(record.getCustId())) && 
				"7".equals(record.getBusinessState())) {
			// 潜在客户的商机只能成功关闭或退回。
			dto.setCode(-1);
			dto.setMessage(" 潜在客户的商机只能成功关闭或退回。");
		} else {
			dto.setCode(0);
			dto.setMessage("关闭成功");
			mapper.opporOff(record);
		}
		return dto;
	}
	/**
	* @方法名称: getCustData
	* @方法描述: 返回客户信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>getCustData(String custId){
		return mapper.getCustData(custId);
	}
	/**
	 * @方法名称: getUUID
	 * @方法描述: UUID生成器
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	private String getUUID() {
		return UUID.randomUUID().toString().toLowerCase().replace("-", "");
	}
}
