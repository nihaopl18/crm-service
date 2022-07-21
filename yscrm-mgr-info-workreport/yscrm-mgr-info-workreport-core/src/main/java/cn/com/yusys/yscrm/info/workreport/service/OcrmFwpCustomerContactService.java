package cn.com.yusys.yscrm.info.workreport.service;

import cn.com.yusys.yscrm.info.workreport.domain.OcrmFwpCustomerContact;
import cn.com.yusys.yscrm.info.workreport.domain.OcrmFwpTodoWork;
import cn.com.yusys.yscrm.info.workreport.repository.mapper.OcrmFwpCustomerContactMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @version 1.0.0
 * @项目名称: yscrm-mgr-info-workreport-core模块
 * @类名称: OcrmFwpWorkReportService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: lixt1
 * @创建时间: 2019-01-28 20:32:24
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFwpCustomerContactService extends CommonService {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private OcrmFwpCustomerContactMapper ocrmFwpCustomerContactMapper;

	@Autowired
	private CustomerAndTodoWorkService customerAndTodoWorkService;

	@Autowired
	private UaaClient uaaClient;

	@Override
	protected CommonMapper<?> getMapper() {
		return ocrmFwpCustomerContactMapper;
	}

	public String getUuid() {
		OgnlContext contxet = new OgnlContext();
		try {
			Object ognl = Ognl.parseExpression("@java.util.UUID@randomUUID().toString().replace(\"-\", \"\")");
			return Ognl.getValue(ognl, contxet, contxet.getRoot()).toString();
		} catch (OgnlException var3) {
			var3.printStackTrace();
			return null;
		}
	}

	public int addTodoWork(OcrmFwpCustomerContact ocrmFwpCustomerContact) {
		OcrmFwpTodoWork ocrmFwpTodoWork = new OcrmFwpTodoWork();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ocrmFwpTodoWork.setStartDate(ocrmFwpCustomerContact.getNextContactDate());
		String startDate = s.format(ocrmFwpTodoWork.getStartDate());
		try{
			ocrmFwpTodoWork.setStartDate(s.parse(startDate));
		}
		catch (ParseException e){
			log.error("日期格式化出错" + e);
		}
		ocrmFwpTodoWork.setRelationCust(ocrmFwpCustomerContact.getContactCustName() + "/" + ocrmFwpCustomerContact.getContactCustId());
		String contactGoal = ocrmFwpCustomerContact.getContactGoal();
		if("1".equals(contactGoal)) {
			contactGoal = "产品营销";
		}else if ("2".equals(contactGoal)) {
			contactGoal = "客户关怀";
		}
		ocrmFwpTodoWork.setTodoWorkTitle(contactGoal);
		ocrmFwpTodoWork.setTodoWorkContent("客户跟进;" + contactGoal + ";" + ocrmFwpCustomerContact.getProduct() == null ? "" : ocrmFwpCustomerContact.getProduct());
		ocrmFwpTodoWork.setFinisher(ocrmFwpCustomerContact.getCreatorName() + "-"+ ocrmFwpCustomerContact.getCreatorId());
		ocrmFwpTodoWork.setCreatorId(ocrmFwpCustomerContact.getCreatorId());
		ocrmFwpTodoWork.setCreatorName(ocrmFwpCustomerContact.getCreatorName());
		ocrmFwpTodoWork.setCreatorOrgId(ocrmFwpCustomerContact.getCreatorOrgId());
		ocrmFwpTodoWork.setCreatorOrgName(ocrmFwpCustomerContact.getCreatorOrgName());
		ocrmFwpTodoWork.setCreateDate(ocrmFwpCustomerContact.getCreateDate());
		return customerAndTodoWorkService.addOneTodoWork(ocrmFwpTodoWork);
	}

	public int addCustomerContacts(List<String> ocrmFwpCustomerContacts, String isDraft) {
		int sum = 0;
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		OcrmFwpCustomerContact ocrmFwpCustomerContact = null;
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		for (String item : ocrmFwpCustomerContacts) {
			ocrmFwpCustomerContact = new OcrmFwpCustomerContact();
			ObjectMapper jsonObj = new ObjectMapper();
			try {
				ocrmFwpCustomerContact = (OcrmFwpCustomerContact) jsonObj.readValue(item, OcrmFwpCustomerContact.class);
			} catch (JsonParseException var4) {
				this.log.error("将customerContact转换为ocrmFwpCustomerContact对象出错", var4);
			} catch (JsonMappingException var5) {
				this.log.error("将customerContact转换为ocrmFwpCustomerContact对象出错", var5);
			} catch (IOException var6) {
				this.log.error("将customerContact转换为ocrmFwpCustomerContact对象出错", var6);
			}
			if (ocrmFwpCustomerContact.getCreatorId() == null || "".equals(ocrmFwpCustomerContact.getCreatorId())) {
				ocrmFwpCustomerContact.setCreatorId(dto.getBody().getLoginCode());
			}
			if (ocrmFwpCustomerContact.getCreatorName() == null || "".equals(ocrmFwpCustomerContact.getCreatorName())) {
				ocrmFwpCustomerContact.setCreatorName(dto.getBody().getUserName());
			}
			if (ocrmFwpCustomerContact.getCreatorOrgId() == null
					|| "".equals(ocrmFwpCustomerContact.getCreatorOrgId())) {
				ocrmFwpCustomerContact.setCreatorOrgId(dto.getBody().getOrg().getId());
			}
			if (ocrmFwpCustomerContact.getCreatorOrgName() == null
					|| "".equals(ocrmFwpCustomerContact.getCreatorOrgName())) {
				ocrmFwpCustomerContact.setCreatorOrgName(dto.getBody().getOrg().getName());
			}
			if (ocrmFwpCustomerContact.getIsDelete() == null || "".equals(ocrmFwpCustomerContact.getIsDelete())) {
				ocrmFwpCustomerContact.setIsDelete("N");
			}
			if (ocrmFwpCustomerContact.getCreateDate() == null) {
				ocrmFwpCustomerContact.setCreateDate(new java.util.Date());
			}
			if (ocrmFwpCustomerContact.getIsDraft() == null || "".equals(ocrmFwpCustomerContact.getIsDraft())){
				ocrmFwpCustomerContact.setIsDraft(isDraft);
			}
			try {
				if (ocrmFwpCustomerContact.getCreateDate() != null) {
					time = s.format(ocrmFwpCustomerContact.getCreateDate());
					ocrmFwpCustomerContact.setCreateDate(s.parse(time));
				}
				if (ocrmFwpCustomerContact.getContactDate() != null) {
					time = s.format(ocrmFwpCustomerContact.getContactDate());
					ocrmFwpCustomerContact.setContactDate(s.parse(time));
				}
				if (ocrmFwpCustomerContact.getNextContactDate() != null) {
					time = s.format(ocrmFwpCustomerContact.getNextContactDate()).split("\\s+")[0] + " 23:59:59";
					ocrmFwpCustomerContact.setNextContactDate(s.parse(time));
					if ("N".equals(isDraft)){
						addTodoWork(ocrmFwpCustomerContact);
					}
				}
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if (ocrmFwpCustomerContact.getCustomerContactId() == null) {
				ocrmFwpCustomerContact.setCustomerContactId(this.getUuid());
				ocrmFwpCustomerContact.setSourceTable("0");
				ocrmFwpCustomerContactMapper.insertSelective(ocrmFwpCustomerContact);
			}else {
				if (ocrmFwpCustomerContact.getLastChgUsrId() == null || "".equals(ocrmFwpCustomerContact.getLastChgUsrId())) {
					ocrmFwpCustomerContact.setLastChgUsrId(dto.getBody().getLoginCode());
				}
				if (ocrmFwpCustomerContact.getLastChgUsrName() == null || "".equals(ocrmFwpCustomerContact.getLastChgUsrName())) {
					ocrmFwpCustomerContact.setLastChgUsrName(dto.getBody().getUserName());
				}
				if (ocrmFwpCustomerContact.getLastChgUsrOrgId() == null || "".equals(ocrmFwpCustomerContact.getLastChgUsrOrgId())) {
					ocrmFwpCustomerContact.setLastChgUsrOrgId(dto.getBody().getOrg().getId());
				}
				if (ocrmFwpCustomerContact.getLastChgUsrOrgName() == null || "".equals(ocrmFwpCustomerContact.getLastChgUsrOrgName())) {
					ocrmFwpCustomerContact.setLastChgUsrOrgName(dto.getBody().getOrg().getName());
				}
				if (ocrmFwpCustomerContact.getLastChgDate() == null) {
					ocrmFwpCustomerContact.setLastChgDate(new java.util.Date());
				}
				if (ocrmFwpCustomerContact.getLastChgDate() != null) {
					time = s.format(ocrmFwpCustomerContact.getLastChgDate());
					try {
						ocrmFwpCustomerContact.setLastChgDate(s.parse(time));
					} catch (ParseException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				ocrmFwpCustomerContactMapper.updateCustomerContact(ocrmFwpCustomerContact);
			}
			sum += 1;
		}
		return sum;
	}

	public int deleteByWorkReportIds(String workReportIds) {
		int result = 0;
		List<Map<String, Object>> customerContacts = this.selectByWorkReportIds(workReportIds,"N");
		OcrmFwpCustomerContact ocrmFwpCustomerContact = new OcrmFwpCustomerContact();
		List<String> customerContactIds = new ArrayList<String>();
		for (Map<String, Object> customerContact : customerContacts) {
			if ("N".equals((String) customerContact.get("isDelete"))) {
				customerContactIds.add((String) customerContact.get("customerContactId"));
			}
		}
		if (customerContactIds.size() <= 0) {
			return result;
		}
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		ocrmFwpCustomerContact.setLastChgUsrId(dto.getBody().getLoginCode());
		ocrmFwpCustomerContact.setLastChgUsrName(dto.getBody().getUserName());
		ocrmFwpCustomerContact.setLastChgUsrOrgId(dto.getBody().getOrg().getId());
		ocrmFwpCustomerContact.setLastChgUsrOrgName(dto.getBody().getOrg().getName());
		ocrmFwpCustomerContact.setIsDelete("Y");
		ocrmFwpCustomerContact.setLastChgDate(new java.util.Date());
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		try {
			if (ocrmFwpCustomerContact.getLastChgDate() != null) {
				time = s.format(ocrmFwpCustomerContact.getLastChgDate());
				ocrmFwpCustomerContact.setLastChgDate(s.parse(time));
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ocrmFwpCustomerContact", ocrmFwpCustomerContact);
		map.put("customerContactIds", customerContactIds);
		result = ocrmFwpCustomerContactMapper.deleteByWorkReportIds(map);
		result += ocrmFwpCustomerContactMapper.deleteByWorkReportIdsAndSource(map);
		return result;
	}

	public List<Map<String, Object>> selectByWorkReportIds(String workReportIds,String isDelete) {
		String[] workReportId = null;
		if (workReportIds != null && !"".equals(workReportIds)) {
			workReportId = workReportIds.split(",");
		}
		return ocrmFwpCustomerContactMapper.selectByWorkReportId(workReportId,isDelete);
	}

	public int updateCustomerContacts(List<String> ocrmFwpCustomerContacts, String WorkReportId, String isDraft) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		int sum = this.deleteByWorkReportIds(WorkReportId);
		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
		String time = "";
		OcrmFwpCustomerContact ocrmFwpCustomerContact = null;
		for (String item : ocrmFwpCustomerContacts) {
			ocrmFwpCustomerContact = new OcrmFwpCustomerContact();
			ObjectMapper jsonObj = new ObjectMapper();
			try {
				ocrmFwpCustomerContact = (OcrmFwpCustomerContact) jsonObj.readValue(item, OcrmFwpCustomerContact.class);
			} catch (JsonParseException var4) {
				this.log.error("将customerContact转换为ocrmFwpCustomerContact对象出错", var4);
			} catch (JsonMappingException var5) {
				this.log.error("将customerContact转换为ocrmFwpCustomerContact对象出错", var5);
			} catch (IOException var6) {
				this.log.error("将customerContact转换为ocrmFwpCustomerContact对象出错", var6);
			}
			ocrmFwpCustomerContact.setIsDelete("N");
			if (ocrmFwpCustomerContact.getCustomerContactId() != null
					&& !"".equals(ocrmFwpCustomerContact.getCustomerContactId())) {
				if (ocrmFwpCustomerContact.getLastChgUsrId() == null
						|| "".equals(ocrmFwpCustomerContact.getLastChgUsrId())) {
					ocrmFwpCustomerContact.setLastChgUsrId(dto.getBody().getLoginCode());
				}
				if (ocrmFwpCustomerContact.getLastChgUsrName() == null
						|| "".equals(ocrmFwpCustomerContact.getLastChgUsrName())) {
					ocrmFwpCustomerContact.setLastChgUsrName(dto.getBody().getUserName());
				}
				if (ocrmFwpCustomerContact.getLastChgUsrOrgId() == null
						|| "".equals(ocrmFwpCustomerContact.getLastChgUsrOrgId())) {
					ocrmFwpCustomerContact.setLastChgUsrOrgId(dto.getBody().getOrg().getId());
				}
				if (ocrmFwpCustomerContact.getLastChgUsrOrgName() == null
						|| "".equals(ocrmFwpCustomerContact.getLastChgUsrOrgName())) {
					ocrmFwpCustomerContact.setLastChgUsrOrgName(dto.getBody().getOrg().getName());
				}
				if (ocrmFwpCustomerContact.getLastChgDate() == null) {
					ocrmFwpCustomerContact.setLastChgDate(new java.util.Date());
				}
				if (ocrmFwpCustomerContact.getLastChgDate() != null) {
					time = s.format(ocrmFwpCustomerContact.getLastChgDate());
					ocrmFwpCustomerContact.setLastChgDate(Date.valueOf(time));
				}
				if (ocrmFwpCustomerContact.getCreateDate() != null) {
					time = s.format(ocrmFwpCustomerContact.getCreateDate());
					ocrmFwpCustomerContact.setCreateDate(Date.valueOf(time));
				}
				if (ocrmFwpCustomerContact.getContactDate() != null) {
					time = s.format(ocrmFwpCustomerContact.getContactDate());
					ocrmFwpCustomerContact.setContactDate(Date.valueOf(time));
				}
				if (ocrmFwpCustomerContact.getNextContactDate() != null) {
					time = s.format(ocrmFwpCustomerContact.getNextContactDate());
					ocrmFwpCustomerContact.setNextContactDate(Date.valueOf(time));
					if ("N".equals(isDraft)){
						addTodoWork(ocrmFwpCustomerContact);
					}
				}
				ocrmFwpCustomerContact.setIsDraft(isDraft);
				ocrmFwpCustomerContactMapper.updateCustomerContact(ocrmFwpCustomerContact);
			} else {
				if (ocrmFwpCustomerContact.getCreatorId() == null || "".equals(ocrmFwpCustomerContact.getCreatorId())) {
					ocrmFwpCustomerContact.setCreatorId(dto.getBody().getLoginCode());
				}
				if (ocrmFwpCustomerContact.getCreatorName() == null
						|| "".equals(ocrmFwpCustomerContact.getCreatorName())) {
					ocrmFwpCustomerContact.setCreatorName(dto.getBody().getUserName());
				}
				if (ocrmFwpCustomerContact.getCreatorOrgId() == null
						|| "".equals(ocrmFwpCustomerContact.getCreatorOrgId())) {
					ocrmFwpCustomerContact.setCreatorOrgId(dto.getBody().getOrg().getId());
				}
				if (ocrmFwpCustomerContact.getCreatorOrgName() == null
						|| "".equals(ocrmFwpCustomerContact.getCreatorOrgName())) {
					ocrmFwpCustomerContact.setCreatorOrgName(dto.getBody().getOrg().getName());
				}
				if (ocrmFwpCustomerContact.getContactDate() == null) {
					ocrmFwpCustomerContact.setContactDate(new java.util.Date());
				}
				if (ocrmFwpCustomerContact.getCreateDate() != null) {
					time = s.format(ocrmFwpCustomerContact.getCreateDate());
					ocrmFwpCustomerContact.setCreateDate(Date.valueOf(time));
				}
				if (ocrmFwpCustomerContact.getContactDate() != null) {
					time = s.format(ocrmFwpCustomerContact.getContactDate());
					ocrmFwpCustomerContact.setContactDate(Date.valueOf(time));
				}
				if (ocrmFwpCustomerContact.getNextContactDate() != null) {
					time = s.format(ocrmFwpCustomerContact.getNextContactDate());
					ocrmFwpCustomerContact.setNextContactDate(Date.valueOf(time));
					if ("N".equals(isDraft)){
						addTodoWork(ocrmFwpCustomerContact);
					}
				}
				if (ocrmFwpCustomerContact.getIsDraft() == null || "".equals(ocrmFwpCustomerContact.getIsDraft())){
					ocrmFwpCustomerContact.setIsDraft(isDraft);
				}
				ocrmFwpCustomerContactMapper.insertSelective(ocrmFwpCustomerContact);
				sum += 1;
			}
		}
		return sum;
	}

	public void updateStatus(String workReportId, String s) {
		ocrmFwpCustomerContactMapper.updateStatus(workReportId,s);
	}

    public List<Map<String, Object>> queryConTact(QueryModel queryModel) {
		return ocrmFwpCustomerContactMapper.queryConTact(queryModel);
    }

	public Integer addCustContact(OcrmFwpCustomerContact ocrmFwpCustomerContact){
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		ocrmFwpCustomerContact.setCustomerContactId(this.getUuid());
		if ("2".equals(ocrmFwpCustomerContact.getSourceTable())){
			ocrmFwpCustomerContact.setIsDraft("N");
			ocrmFwpCustomerContact.setIsDelete("N");
		}
		ocrmFwpCustomerContact.setCreateDate(new java.util.Date());
		ocrmFwpCustomerContact.setCreatorId(dto.getBody().getLoginCode());
		ocrmFwpCustomerContact.setCreatorName(dto.getBody().getUserName());
		ocrmFwpCustomerContact.setCreatorOrgId(dto.getBody().getOrg().getId());
		ocrmFwpCustomerContact.setCreatorOrgName(dto.getBody().getOrg().getName());
		return ocrmFwpCustomerContactMapper.insertSelective(ocrmFwpCustomerContact);
	}

	public Integer updateCustContact(OcrmFwpCustomerContact ocrmFwpCustomerContact){
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		ocrmFwpCustomerContact.setLastChgDate(new java.util.Date());
		ocrmFwpCustomerContact.setLastChgUsrId(dto.getBody().getLoginCode());
		ocrmFwpCustomerContact.setLastChgUsrName(dto.getBody().getUserName());
		ocrmFwpCustomerContact.setLastChgUsrOrgId(dto.getBody().getOrg().getId());
		ocrmFwpCustomerContact.setLastChgUsrOrgName(dto.getBody().getOrg().getName());
		ocrmFwpCustomerContact.setIsDraft("N");
		ocrmFwpCustomerContact.setIsDelete("N");
		return ocrmFwpCustomerContactMapper.updateCustomerContact(ocrmFwpCustomerContact);
	}

	public Integer deleteCustContact(String customerContactId){
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		Map<String,String> map = new HashMap<>();
		map.put("customerContactId",customerContactId);
		map.put("lastChgUsrId",dto.getBody().getLoginCode());
		map.put("lastChgUsrName",dto.getBody().getUserName());
		map.put("lastChgUsrOrgId",dto.getBody().getOrg().getId());
		map.put("lastChgUsrOrgName",dto.getBody().getOrg().getName());
		map.put("lastChgDate",s.format(new java.util.Date()));
		return ocrmFwpCustomerContactMapper.deletecustomerContact(map);
	}
}
