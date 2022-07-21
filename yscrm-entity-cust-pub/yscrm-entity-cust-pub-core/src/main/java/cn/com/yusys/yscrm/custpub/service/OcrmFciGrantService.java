package cn.com.yusys.yscrm.custpub.service;

import java.math.BigDecimal;
import java.text.DateFormat;
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

import cn.com.yusys.yscrm.custpub.domain.OcrmFciGrantApply;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciGrantList;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciTrusteeshipApply;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciTrusteeshipList;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciGrantMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.util.UtilTools;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFciGrantService
 * @类描述：客户授权Service
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-16
 */
@Service
public class OcrmFciGrantService extends CommonService{

	@Autowired
	private OcrmFciGrantMapper mapper;
	@Autowired
	private OcrmFciGrantListService ocrmFciGrantListService;
	@Autowired
	private UaaClient uaaClient;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	public  UserInfoDTO getUserInfoDTO() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		return user;
	}
	/**
	* @方法名称: grantList
	* @方法描述: 客户授权历史查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>>grantList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.grantList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: custList
	* @方法描述: 所辖客户查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>>custList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.custList(model);
		PageHelper.clearPage();
		return list;
	}
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int add(Map<String, Object> map) {
		// TODO 自动生成的方法存根
		UserInfoDTO user = getUserInfoDTO();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String[] custIds = ((String) map.get("custId")).split(",");
		String userId = user.getUserId();
		String userName = user.getUserName();
		String grantMgrId = (String) map.get("grantMgrId");
		String	grantMgrName = (String) map.get("grantMgrName");
		String[] custNames = ((String) map.get("custName")).split(",");
		OcrmFciGrantApply ocrmFciGrantApply = new OcrmFciGrantApply();
		BigDecimal ApplyId = mapper.getId();
		ocrmFciGrantApply.setApplyId(ApplyId);
		ocrmFciGrantApply.setCorpOrgCode("001");
		ocrmFciGrantApply.setMgrId(userId);
		ocrmFciGrantApply.setGrantViewType((String) map.get("grantViewType"));
		ocrmFciGrantApply.setGrantViewItem((String) map.get("grantViewItem"));
		ocrmFciGrantApply.setMgrName(userName);
		ocrmFciGrantApply.setGrantMgrId(grantMgrId);
		ocrmFciGrantApply.setGrantMgrName(grantMgrName);
		ocrmFciGrantApply.setSetDate(new Date());
		ocrmFciGrantApply.setSetUserId(userId);
		ocrmFciGrantApply.setSetUserName(userName);
		ocrmFciGrantApply.setGrantReason((String)map.get("grantReason"));
		ocrmFciGrantApply.setGrantStat("1");
		try {
			ocrmFciGrantApply.setDeadLine(df.parse((String) map.get("deadLine")));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		this.mapper.insertSelective(ocrmFciGrantApply);
		for (int i = 0; i < custIds.length; i++) {
			Map<String, Object> cust = new HashMap<String, Object>();
			String custId = custIds[i];
			cust.put("custId", custId);
			cust.put("userId", user.getUserId());
			if (mapper.checkIs(cust) == 0) {
				OcrmFciGrantList ocrmFciGrantList = new OcrmFciGrantList();
				ocrmFciGrantList.setListId(UtilTools.getUUID());
				ocrmFciGrantList.setApplyNo(ApplyId);
				ocrmFciGrantList.setCustId(custId);
				ocrmFciGrantList.setCustName(custNames[i]);
				ocrmFciGrantListService.add(ocrmFciGrantList);
			}
		}
		return 0;
	}
	/**
	* @throws ParseException 
	* @方法名称: grantInsert
	* @方法描述: 客户授权
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> grantInsert(OcrmFciGrantApply record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (record.getCustId().length == 0 || record.getCustName().length == 0) {
			dto.setCode(-1);
			dto.setMessage("未选择授权客户");
		} else if (record.getCustId().length != record.getCustName().length) {
			dto.setCode(-1);
			dto.setMessage("授权客户信息格式有误");
		} else if (record.getGrantMgrId().equals(mapper.getUserId(SecurityUtils.getCurrentUserLogin()))) {
			dto.setCode(-1);
			dto.setMessage("授权人为当前登录人");
		}
//		else if (record.getDeadLine().before(new Date())) {
//			dto.setCode(-1);
//			dto.setMessage("授权有效期小于当前日期");
//		} else if (record.getSetDate().before(new Date())) {
//			dto.setCode(-1);
//			dto.setMessage("授权时间小于当前日期");
//		} 
		else {
			// 设置记录编号
			record.setApplyId(mapper.getId());
			// 设置法人为当前登录机构
			record.setCorpOrgCode(org.getBody().getOrg().getCode());
			// 设置授权状态为已授权
			record.setGrantStat("1");
//			// 设置授权客户经理id
//			record.setGrantMgrId(mapper.getUserId(record.getGrantMgrId()));
			// 设置托管有效期、托管时间
			record.setDeadLine(df.parse(df.format(record.getDeadLine())));
			record.setSetDate(df.parse(df.format(new Date())));
			mapper.insertSelective(record);
			// 新增授权清单客户
			if(record.getCustId().length != 0 && record.getCustName().length != 0) {
				OcrmFciGrantList custObj = new OcrmFciGrantList();
				custObj.setApplyNo(record.getApplyId());
				String[] custId = record.getCustId();
				String[] custName = record.getCustName();
				for(int i=0;i<custId.length;i++) {
//					custObj.setListId(mapper.getListId());
					custObj.setCustId(custId[i]);
					custObj.setCustName(custName[i]);
					mapper.insertCustList(custObj);
				}
			}
			dto.setCode(0);
			dto.setMessage("授权成功");
		}
		return dto;
	}
	/**
	* @方法名称: grantRecover
	* @方法描述: 客户授权回收
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> grantRecover(Map<String, String> map) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String[] ids = map.get("applyId").split(",");
		for(int i=0;i<ids.length;i++) {
			mapper.grantRecover(BigDecimal.valueOf(Long.parseLong(ids[i])));
		}
		dto.setCode(0);
		dto.setMessage("托管回收成功");
		return dto;
	}
	/**
	* @方法名称: getCM
	* @方法描述: 客户经理放大镜
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getCM(QueryModel model) {
		/*List<Map<String, String>> listRole=this.mapper.getRoleCode(model);*/
		List<Map<String,Object>> list;
		/*if(listRole!=null&&listRole.size()==1) {
			if(listRole.get(0).get("roleCode")!=null&&listRole.get(0).get("roleCode").equals("15")) {
				//表示只是客户经理
				PageHelper.startPage(model.getPage(), model.getSize());
				list = this.mapper.getCM1(model);
				PageHelper.clearPage();
			}else {
				PageHelper.startPage(model.getPage(), model.getSize());
				list = this.mapper.getCM(model);
				PageHelper.clearPage();
			}
		}else {
			PageHelper.startPage(model.getPage(), model.getSize());
			list = this.mapper.getCM(model);
			PageHelper.clearPage();
		}*/
		PageHelper.startPage(model.getPage(), model.getSize());
		list = this.mapper.getCM(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: custGrantList
	* @方法描述: 客户授权清单
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>>custGrantList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.custGrantList(model);
		PageHelper.clearPage();
		return list;
	}
	public List<Map<String, String>> myCustListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = mapper.myCustListByModel(model);
		PageHelper.clearPage();
		return list;
	}
	public List<Map<String, String>> getGrantCust(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = mapper.getGrantCust(model);
		PageHelper.clearPage();
		return list;
	}
	public List<Map<String, String>> getGrantList(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = mapper.getGrantList(model);
		PageHelper.clearPage();
		return list;
	}
}
