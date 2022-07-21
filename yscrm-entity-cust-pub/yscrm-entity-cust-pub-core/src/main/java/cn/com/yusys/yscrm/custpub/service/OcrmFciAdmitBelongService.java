package cn.com.yusys.yscrm.custpub.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import cn.com.yusys.yscrm.custpub.domain.*;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.selectroleUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmFciCustAdmitAllMapper;
import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmFciOrgCustInfoMapper;
import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmFciPerAdmitInfoMapper;
import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmFciPerCustMapper;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciAdmitBelongMapper;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciBelongHisMapper;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciNoadmitBelongMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @项目名称: yscrm-entity-cust-pub模块
 * @类名称: OcrmFciAdmitBelongService
 * @类描述: 客户分配调整
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-25 19:38:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciAdmitBelongService extends CommonService {

	private Logger logger = LoggerFactory.getLogger(OcrmFciAdmitBelongService.class);

	@Autowired
	private OcrmFciAdmitBelongMapper ocrmFciAdmitBelongMapper;

	@Autowired
	private OcrmFciNoadmitBelongMapper ocrmFciNoadmitBelongMapper;
	@Autowired
	private OcrmFciNoadmitBelongService ocrmFciNoadmitBelongService;
	@Autowired
	private OcrmFciBelongHisMapper ocrmFciBelongHisMapper;
	@Autowired
	private OcrmFciAdmitBelongService ocrmFciAdmitBelongService;
	@Autowired
	private AcrmFciPerCustMapper acrmFciPerCustMapper;
	public final static String MGR_ROLE_1 = "R002,R015,R018,R017,R021";
	public final static String MGR_ROLE_2 = "R003,R019,R016,R020";
//    @Autowired
//    private AcrmFciOrgCustMapper acrmFciOrgCustMapper;

	@Autowired
	private AcrmFciOrgCustInfoMapper acrmFciOrgCustInfoMapper;

	@Autowired
	private AcrmFciPerAdmitInfoMapper acrmFciPerAdmitInfoMapper;


	@Autowired
	private AcrmFciCustAdmitAllMapper acrmFciCustAdmitAllMapper;

	@Autowired
	private UaaClient uaaClient;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	@Override
	protected CommonMapper getMapper() {
		// TODO 自动生成的方法存根
		return this.ocrmFciAdmitBelongMapper;
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

	/**
	 * @方法名称: getOrglist
	 * @方法描述: 查询所辖机构
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getOrglist(QueryModel model) {
//		PageHelper.startPage(model.getPage(), model.getSize());
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String orgCode = dto.getBody().getOrg().getCode();
		logger.info("orgCode=====" + orgCode);
		List<Map<String, Object>> list = this.ocrmFciAdmitBelongMapper.getOrglist(orgCode);
//		PageHelper.clearPage();
		return list;
	}

	/**
	 * @方法名称: getMgrlist
	 * @方法描述: 查询所辖机构的客户经理
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getMgrlist(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.ocrmFciAdmitBelongMapper.getMgrlist(model);
		PageHelper.clearPage();
		return list;
	}

	/**
	 * @方法名称:qryOrgId
	 * @方法描述:查询当前客户的机构、客户经理（主办）
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> qryOrgId(String custId) {
		List<Map<String, Object>> list = this.ocrmFciAdmitBelongMapper.qryOrgId(custId);
		return list;
	}


	/**
	 * @方法名称:qryMgrId
	 * @方法描述: 查询当前客户的机构、客户经理（协办）
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> qryMgrId(String custId) {
		List<Map<String, Object>> list = this.ocrmFciAdmitBelongMapper.qryMgrId(custId);
		return list;
	}

	/**
	 * @方法名称:qryBelongHis
	 * @方法描述:查询调整历史
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> qryBelongHis(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		/*if (model.getCondition().containsKey("custId")) {
			if (model.getCondition().get("custId") != null && !model.getCondition().get("custId").equals("")) {
				model.getCondition().put("custId", "%" + model.getCondition().get("custId") + "%");
			}
		}
		if (model.getCondition().containsKey("custName")) {
			if (model.getCondition().get("custName") != null && !model.getCondition().get("custName").equals("")) {
				model.getCondition().put("custName", "%" + model.getCondition().get("custName") + "%");
			}
		}
		if (model.getCondition().containsKey("beginDate")) {
			if (model.getCondition().get("beginDate") != null && !model.getCondition().get("beginDate").equals("")) {
				model.getCondition().put("beginDate",model.getCondition().get("beginDate"));
				*//*model.getCondition().put("beginDate",model.getCondition().get("beginDate")+" 00:00:00");*//*
			}
		}
		if (model.getCondition().containsKey("endDate")) {
			if (model.getCondition().get("endDate") != null && !model.getCondition().get("endDate").equals("")) {
				model.getCondition().put("endDate",model.getCondition().get("endDate"));
				*//*model.getCondition().put("endDate",model.getCondition().get("endDate")+" 00:00:00");*//*
			}
		}*/

		List<Map<String, Object>> list = this.ocrmFciAdmitBelongMapper.qryBelongHis(model);
		PageHelper.clearPage();
		return list;
	}

	/**
	 * 客户分配调整保存
	 *
	 * @param nodeList 主办信息
	 *                 connList 协办信息
	 * @return
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int saveBelong(List<OcrmFciBelongHis> nodeList, List<OcrmFciBelongHis> connList, String isAdmitEnter) {
		int count = 0;
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String orgCode = dto.getBody().getOrg().getCode();
		String loginCode = dto.getBody().getLoginCode();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new Date());
		String belongOrg = "";
		//主办信息
		if (nodeList.size() > 0) {
			for (int i = 0; i < nodeList.size(); i++) {
				//修改准入客户归属信息表
				OcrmFciAdmitBelong belongrecord = new OcrmFciAdmitBelong();
				OcrmFciNoadmitBelong ocrmFciNoadmitBelong = new OcrmFciNoadmitBelong();
				belongrecord.setCustId(nodeList.get(i).getCustId());
				ocrmFciNoadmitBelong.setCustId(nodeList.get(i).getCustId());
				try {
					belongrecord.setLastUpdateTm(new Date(df.parse(time).getTime()));
					ocrmFciNoadmitBelong.setLastUpdateTm(new Date(df.parse(time).getTime()));
				} catch (ParseException e4) {
					// TODO 自动生成的 catch 块
					e4.printStackTrace();
				}
				belongrecord.setLastUpdateOrg(orgCode);
				ocrmFciNoadmitBelong.setLastUpdateOrg(orgCode);
				if ("1".equals(nodeList.get(i).getWorkTranLevel())) {//操作类型主办机构
					belongOrg = nodeList.get(i).getOrgId();
					if (isAdmitEnter.equals("1")) {
						belongrecord.setOrgId(nodeList.get(i).getOrgId());
						belongrecord.setOrgType(nodeList.get(i).getOrgType());
						belongrecord.setOrgName(nodeList.get(i).getOrgName());
						belongrecord.setMgrId("VM" + nodeList.get(i).getOrgId());
						belongrecord.setMgrName(nodeList.get(i).getOrgName() + "虚拟行员");
						belongrecord.setIsAdmitEnter("1");
						ocrmFciAdmitBelongMapper.updateOrgByCustid(belongrecord);
					} else if (isAdmitEnter.equals("0")) {
						ocrmFciNoadmitBelong.setOrgId(nodeList.get(i).getOrgId());
						ocrmFciNoadmitBelong.setOrgType(nodeList.get(i).getOrgType());
						ocrmFciNoadmitBelong.setOrgName(nodeList.get(i).getOrgName());
						ocrmFciNoadmitBelong.setMgrId("VM" + nodeList.get(i).getOrgId());
						ocrmFciNoadmitBelong.setMgrName(nodeList.get(i).getOrgName() + "虚拟行员");
						ocrmFciNoadmitBelong.setMgrType("1");
						ocrmFciNoadmitBelong.setIsAdmitEnter("0");
						ocrmFciNoadmitBelongMapper.updateOrgByCustid(ocrmFciNoadmitBelong);
					}
				} else if ("2".equals(nodeList.get(i).getWorkTranLevel())) {//操作类型主办客户经理
					if (isAdmitEnter.equals("1")) {
						belongOrg = ocrmFciAdmitBelongMapper.getBelongOrgIdByCustId(nodeList.get(i).getCustId());
						belongrecord.setMgrId(nodeList.get(i).getMgrId());
						belongrecord.setMgrType(nodeList.get(i).getMgrType());
						belongrecord.setMgrName(nodeList.get(i).getMgrName());
						belongrecord.setIsAdmitEnter("1");
						ocrmFciAdmitBelongMapper.updateByCustid(belongrecord);
					} else if (isAdmitEnter.equals("0")) {
						belongOrg = ocrmFciNoadmitBelongMapper.getBelongOrgIdByCustId(nodeList.get(i).getCustId());
						ocrmFciNoadmitBelong.setMgrId(nodeList.get(i).getMgrId());
						ocrmFciNoadmitBelong.setMgrType(nodeList.get(i).getMgrType());
						ocrmFciNoadmitBelong.setMgrName(nodeList.get(i).getMgrName());
						ocrmFciNoadmitBelong.setIsAdmitEnter("0");
						ocrmFciNoadmitBelongMapper.updateByCustid(ocrmFciNoadmitBelong);
					}
				}
				//修改准入客户归属调整历史表
				nodeList.get(i).setHisId(getUUID());
				nodeList.get(i).setLastUpdateOrg(orgCode);
				try {
					nodeList.get(i).setAssignDate(new Date(df.parse(time).getTime()));
				} catch (ParseException e3) {
					// TODO 自动生成的 catch 块
					e3.printStackTrace();
				}
				nodeList.get(i).setAssignUser(loginCode);
				ocrmFciBelongHisMapper.insertSelective(nodeList.get(i));
				//修改个人客户基本信息
				AcrmFciPerCust record = new AcrmFciPerCust();
				record.setCustId(nodeList.get(i).getCustId());
				if ("1".equals(nodeList.get(i).getWorkTranLevel())) {//操作类型主办机构
					record.setBelongBrch(nodeList.get(i).getOrgId());
					record.setBelongMgr("VM" + nodeList.get(i).getOrgId());
				} else if ("2".equals(nodeList.get(i).getWorkTranLevel())) {//操作类型主办客户经理
					record.setBelongMgr(nodeList.get(i).getMgrId());
				}
				record.setCustAssignStat("1");
				try {
					record.setLastUpdateTm(new Date(df.parse(time).getTime()));
				} catch (ParseException e4) {
					// TODO 自动生成的 catch 块
					e4.printStackTrace();
				}
				record.setLastUpdateOrg(orgCode);
				if (isAdmitEnter.equals("1")) {
					AcrmFciPerAdmitInfo peradrecord = new AcrmFciPerAdmitInfo();
					peradrecord.setCustId(nodeList.get(i).getCustId());
					if ("1".equals(nodeList.get(i).getWorkTranLevel())) {//操作类型主办机构
						peradrecord.setBelongBrch(nodeList.get(i).getOrgId());
						peradrecord.setBelongMgr("VM" + nodeList.get(i).getOrgId());
					} else if ("2".equals(nodeList.get(i).getWorkTranLevel())) {//操作类型主办客户经理
						peradrecord.setBelongMgr(nodeList.get(i).getMgrId());
					}
					peradrecord.setCustAssignStat("1");
					try {
						peradrecord.setLastUpdateTm(new Date(df.parse(time).getTime()));
					} catch (ParseException e2) {
						// TODO 自动生成的 catch 块
						e2.printStackTrace();
					}
					peradrecord.setLastUpdateOrg(orgCode);
					//准入个人客户基本信息
					acrmFciPerAdmitInfoMapper.updateByPrimaryKeySelective(peradrecord);
				}


				AcrmFciOrgCustInfo custrecord = new AcrmFciOrgCustInfo();
				custrecord.setCustId(nodeList.get(i).getCustId());
				if ("1".equals(nodeList.get(i).getWorkTranLevel())) {//操作类型主办机构
					custrecord.setBelongBrch(nodeList.get(i).getOrgId());
					custrecord.setBelongMgr("VM" + nodeList.get(i).getOrgId());
				} else if ("2".equals(nodeList.get(i).getWorkTranLevel())) {//操作类型主办客户经理
					custrecord.setBelongMgr(nodeList.get(i).getMgrId());
				}
				custrecord.setCustAssignStat("1");
				try {
					custrecord.setLastUpdateTm(new Date(df.parse(time).getTime()));
				} catch (ParseException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				custrecord.setLastUpdateOrg(orgCode);
				if (isAdmitEnter.equals("1")) {
					AcrmFciCustAdmitAll allrecord = new AcrmFciCustAdmitAll();
					allrecord.setCustId(nodeList.get(i).getCustId());
					if ("1".equals(nodeList.get(i).getWorkTranLevel())) {//操作类型主办机构
						allrecord.setBelongBrch(nodeList.get(i).getOrgId());
						allrecord.setBelongMgr("VM" + nodeList.get(i).getOrgId());
					} else if ("2".equals(nodeList.get(i).getWorkTranLevel())) {//操作类型主办客户经理
						allrecord.setBelongMgr(nodeList.get(i).getMgrId());
					}
					try {
						allrecord.setLastUpdateTm(new Date(df.parse(time).getTime()));
					} catch (ParseException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					//准入客户主信息
					acrmFciCustAdmitAllMapper.updateByPrimaryKeySelective(allrecord);
				}

				//修改个人客户基本信息
				acrmFciPerCustMapper.updateByPrimaryKeySelective(record);
				//修改对公客户基本信息
//				acrmFciOrgCustMapper.updateByPrimaryKeySelective(orgrecord);

				//对公客户基本信息（准入非准入）
				acrmFciOrgCustInfoMapper.updateByPrimaryKeySelective(custrecord);
				count++;
			}
		}
		if (connList.size() == 0) {//协办信息
			//先删除调整表的协办信息
			Map<String, Object> params = new HashMap<>();
			if (nodeList.size() > 0) {
				params.put("custId", nodeList.get(0).getCustId());
				if ("1".equals(nodeList.get(0).getWorkTranLevel())) {//协办机构
					if (isAdmitEnter.equals("1")) {
						ocrmFciAdmitBelongMapper.deleteByCustId(params);//先删除协办机构
						ocrmFciAdmitBelongMapper.deletemgrByCustId(params);//先删除协办客户经理
					} else if (isAdmitEnter.equals("0")) {
						ocrmFciNoadmitBelongMapper.deleteByCustId(params);//先删除协办机构
						ocrmFciNoadmitBelongMapper.deletemgrByCustId(params);//先删除协办客户经理
					}
				} else if ("2".equals(nodeList.get(0).getWorkTranLevel())) {//协办客户经理
					/*if (isAdmitEnter.equals("1")) {
						ocrmFciAdmitBelongMapper.deletemgrByCustId(params);//先删除协办客户经理
					}else if (isAdmitEnter.equals("0")) {
						ocrmFciNoadmitBelongMapper.deletemgrByCustId(params);//先删除协办客户经理
					}*/
				}
			}
		}
		if (connList.size() > 0) {//协办信息
			//先删除调整表的协办信息
			Map<String, Object> params = new HashMap<>();
			params.put("custId", connList.get(0).getCustId());
			if ("3".equals(connList.get(0).getWorkTranLevel())) {//协办机构

				if (isAdmitEnter.equals("1")) {
					ocrmFciAdmitBelongMapper.deleteByCustId(params);//先删除协办机构
					ocrmFciAdmitBelongMapper.deletemgrByCustId(params);//先删除协办客户经理
				} else if (isAdmitEnter.equals("0")) {
					ocrmFciNoadmitBelongMapper.deleteByCustId(params);//先删除协办机构
					ocrmFciNoadmitBelongMapper.deletemgrByCustId(params);//先删除协办客户经理
				}
			} else if ("4".equals(connList.get(0).getWorkTranLevel())) {//协办客户经理
				for (int i = 0; i < connList.size(); i++) {
					if (connList.get(i).getMgrIdPre() != null && !connList.get(i).getMgrIdPre().equals("")) {
						//表示为移除时才会删除
						if (isAdmitEnter.equals("1")) {
							params.put("mgrId", connList.get(i).getMgrIdPre());
							ocrmFciAdmitBelongMapper.deletemgrByCustId1(params);//先删除协办客户经理
						} else if (isAdmitEnter.equals("0")) {
							ocrmFciNoadmitBelongMapper.deletemgrByCustId1(params);//先删除协办客户经理
						}
					}
				}
			}
			for (int i = 0; i < connList.size(); i++) {
				connList.get(i).setHisId(getUUID());
				connList.get(i).setLastUpdateOrg(orgCode);
				try {
					connList.get(i).setAssignDate(new Date(df.parse(time).getTime()));
				} catch (ParseException e3) {
					// TODO 自动生成的 catch 块
					e3.printStackTrace();
				}
				connList.get(i).setAssignUser(loginCode);
				ocrmFciBelongHisMapper.insertSelective(connList.get(i));//入调整历史
				OcrmFciAdmitBelong admitrecord = new OcrmFciAdmitBelong();
				OcrmFciNoadmitBelong noadmitrecord = new OcrmFciNoadmitBelong();
				admitrecord.setBelongId(getUUID());
				admitrecord.setCustId(connList.get(i).getCustId());
				noadmitrecord.setBelongId(getUUID());
				noadmitrecord.setCustId(connList.get(i).getCustId());
				if ("3".equals(connList.get(i).getWorkTranLevel())) {//协办机构
					if (isAdmitEnter.equals("1")) {
						admitrecord.setOrgId(connList.get(i).getOrgId());
						if (belongOrg.equals(connList.get(i).getOrgId())) {
							admitrecord.setOrgType("1");
						} else {
							admitrecord.setOrgType("2");
						}
						admitrecord.setOrgName(connList.get(i).getOrgName());
						admitrecord.setMgrId("VM" + connList.get(i).getOrgId());
						admitrecord.setMgrName(connList.get(i).getOrgName() + "虚拟行员");
						admitrecord.setMgrType("2");
					} else if (isAdmitEnter.equals("0")) {
						noadmitrecord.setOrgId(connList.get(i).getOrgId());
						if (belongOrg.equals(connList.get(i).getOrgId())) {
							noadmitrecord.setOrgType("1");
						} else {
							noadmitrecord.setOrgType("2");
						}
						noadmitrecord.setOrgName(connList.get(i).getOrgName());
						noadmitrecord.setMgrId("VM" + connList.get(i).getOrgId());
						noadmitrecord.setMgrName(connList.get(i).getOrgName() + "虚拟行员");
						noadmitrecord.setMgrType("2");
					}

				} else if ("4".equals(connList.get(i).getWorkTranLevel())) {//协办客户经理
					if (isAdmitEnter.equals("1")) {
						admitrecord.setOrgId(connList.get(i).getOrgId());
//						if (belongOrg.equals(connList.get(i).getOrgId())) {
//							admitrecord.setOrgType("1");
//						}else {
//							admitrecord.setOrgType("2");
//						}
						if (connList.get(i).getOrgType() != null) {
							admitrecord.setOrgType(connList.get(i).getOrgType());
						} else if (connList.get(i).getOrgTypePre() != null) {
							admitrecord.setOrgType(connList.get(i).getOrgTypePre());
						}
						admitrecord.setOrgName(connList.get(i).getOrgName());
						admitrecord.setMgrId(connList.get(i).getMgrId());
						admitrecord.setMgrType(connList.get(i).getMgrType());
						admitrecord.setMgrName(connList.get(i).getMgrName());
					} else if (isAdmitEnter.equals("0")) {
						noadmitrecord.setOrgId(connList.get(i).getOrgId());
//						if (belongOrg.equals(connList.get(i).getOrgId())) {
//							noadmitrecord.setOrgType("1");
//						}else {
//							noadmitrecord.setOrgType("2");
//						}
						if (connList.get(i).getOrgType() != null) {
							noadmitrecord.setOrgType(connList.get(i).getOrgType());
						} else if (connList.get(i).getOrgTypePre() != null) {
							noadmitrecord.setOrgType(connList.get(i).getOrgTypePre());
						}
						noadmitrecord.setOrgName(connList.get(i).getOrgName());
						noadmitrecord.setMgrId(connList.get(i).getMgrId());
						noadmitrecord.setMgrType(connList.get(i).getMgrType());
						noadmitrecord.setMgrName(connList.get(i).getMgrName());
					}
				}
				admitrecord.setLastUpdateUser(connList.get(i).getLastUpdateUser());
				admitrecord.setCorpOrgCode("001");//法人
				noadmitrecord.setLastUpdateUser(connList.get(i).getLastUpdateUser());
				noadmitrecord.setCorpOrgCode("001");//法人
				try {
					admitrecord.setLastUpdateTm(new Date(df.parse(time).getTime()));
					noadmitrecord.setLastUpdateTm(new Date(df.parse(time).getTime()));
				} catch (ParseException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				admitrecord.setLastUpdateOrg(orgCode);
				noadmitrecord.setLastUpdateOrg(orgCode);
//				admitrecord.setMgrType("2");
//				admitrecord.setMgrId("VM"+connList.get(i).getOrgId());
//				admitrecord.setMgrName(connList.get(i).getOrgName() + "虚拟行员");
				admitrecord.setIsAdmitEnter(isAdmitEnter);
				if (connList.get(i).getMgrIdPre() != null && connList.get(i).getMgrId() == null) {

				} else {
					this.insertSelective(ocrmFciAdmitBelongMapper, admitrecord);
				}
				count++;
			}
		}
		return count;

	}

	@Transactional(readOnly = true)
	public String getCustByCustIdAndOrgAndMgr(String custId, String mgrId, String orgId) {
		// TODO 自动生成的方法存根
		return ocrmFciAdmitBelongMapper.getCustByCustIdAndOrgAndMgr(custId, mgrId, orgId);
	}

	public int updateHost(String custId, String mgrId, String orgId) {
		Map<String, String> map = new HashMap<>();
		map.put("custId", custId);
		map.put("mgrId", mgrId);
		map.put("orgId", orgId);
		return ocrmFciAdmitBelongMapper.updateHost(map);

	}

	public UserInfoDTO getUser() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		return dto.getBody();
	}

	public int claimAdd(Map<String, String> belong) {
		OcrmFciAdmitBelong ocrmFciAdmitBelong = new OcrmFciAdmitBelong();
		Date date = new Date();
		UserInfoDTO user = getUser();
		ocrmFciAdmitBelong.setBelongId(UtilTools.getUUID());
		ocrmFciAdmitBelong.setCorpOrgCode("001");
		ocrmFciAdmitBelong.setCustId(belong.get("custId"));
		ocrmFciAdmitBelong.setLastUpdateOrg(user.getOrg().getId());
		ocrmFciAdmitBelong.setLastUpdateTm(date);
		ocrmFciAdmitBelong.setMgrId(belong.get("mgrId"));
		ocrmFciAdmitBelong.setLastUpdateUser(user.getUserId());
		ocrmFciAdmitBelong.setMgrName(belong.get("mgrName"));
		ocrmFciAdmitBelong.setMgrType(belong.get("mgrType"));
		ocrmFciAdmitBelong.setOrgId(belong.get("orgId"));
		ocrmFciAdmitBelong.setOrgName(belong.get("orgName"));
		ocrmFciAdmitBelong.setOrgType(belong.get("orgType"));
		ocrmFciAdmitBelong.setIsAdmitEnter("1");
		return insertSelective(getMapper(), ocrmFciAdmitBelong);

	}

	public int transAdd(Map<String, String> belong, Map<String, String> belong1) {
		// TODO 自动生成的方法存根
		OcrmFciAdmitBelong ocrmFciAdmitBelong = ocrmFciAdmitBelongMapper.getBelongByCustIdAndMgrIdAndOrgId(belong);
		OcrmFciAdmitBelong ocrmFciAdmitBelong1 = ocrmFciAdmitBelongMapper.getBelongByCustIdAndMgrIdAndOrgId(belong1);
		String mgrType = ocrmFciAdmitBelong.getMgrType();
		String mgrType1 = ocrmFciAdmitBelong1.getMgrType();
		String orgType = ocrmFciAdmitBelong.getOrgType();
		String orgType1 = ocrmFciAdmitBelong1.getOrgType();
		Date date = new Date();
		UserInfoDTO user = getUser();
		ocrmFciAdmitBelong.setLastUpdateOrg(user.getOrg().getId());
		ocrmFciAdmitBelong.setLastUpdateTm(date);
//		ocrmFciAdmitBelong.setMgrId(belong.get("mgrId"));
		ocrmFciAdmitBelong.setLastUpdateUser(user.getUserId());
		ocrmFciAdmitBelong.setMgrType(mgrType1);
		if (mgrType.equals(mgrType1)) {//如果都是相同的，说明是协办，此时，不需要将主协办机构调换
			ocrmFciAdmitBelong.setOrgType(orgType);
			ocrmFciAdmitBelong1.setOrgType(orgType1);
		} else {//如果主协办换了，那么，将归属表中所有主办机构都要替换
			ocrmFciAdmitBelong.setOrgType(orgType1);
			ocrmFciAdmitBelong1.setOrgType(orgType);
			Map<String, String> map = new HashMap<String, String>();
			map.put("custId", ocrmFciAdmitBelong.getCustId());
			map.put("orgId", ocrmFciAdmitBelong.getOrgId());
			map.put("orgType", orgType1);
			ocrmFciAdmitBelongMapper.updateOrgType(map);
			map.put("custId", ocrmFciAdmitBelong1.getCustId());
			map.put("orgId", ocrmFciAdmitBelong1.getOrgId());
			map.put("orgType", orgType);
			ocrmFciAdmitBelongMapper.updateOrgType(map);
		}
		ocrmFciAdmitBelong1.setLastUpdateOrg(user.getOrg().getId());
		ocrmFciAdmitBelong1.setLastUpdateTm(date);
		ocrmFciAdmitBelong1.setLastUpdateUser(user.getUserId());
		ocrmFciAdmitBelong1.setMgrType(mgrType);
//		ocrmFciAdmitBelong.setMgrName(belong.get("mgrName"));
//		ocrmFciAdmitBelong.setOrgId(belong.get("orgId"));
//		ocrmFciAdmitBelong.setOrgName(belong.get("orgName"));
		int i = updateSelective(getMapper(), ocrmFciAdmitBelong);
		i = updateSelective(getMapper(), ocrmFciAdmitBelong1) + i;
		return i;
	}

	/**
	 * @方法名称: getUpMgrlist
	 * @方法描述: 查询当前机构及上级机构下的客户经理
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getUpMgrlist(String orgCode) {
		List<Map<String, Object>> list = this.ocrmFciAdmitBelongMapper.getUpMgrlist(orgCode);
		return list;
	}

	public int delBelongByCustIdMgrIdOrgId(String custId, String mgrId, String orgId) {
		// TODO 自动生成的方法存根
		Map<String, String> map = new HashMap<>();
		map.put("custId", custId);
		map.put("mgrId", mgrId);
		map.put("orgId", orgId);
		return ocrmFciAdmitBelongMapper.delBelongByCustIdMgrIdOrgId(map);
	}

	public List<Map<String, Object>> getNoAdminBelong(String custId) {
		// TODO 自动生成的方法存根
		return ocrmFciAdmitBelongMapper.getNoAdminBelong(custId);
	}

	public void add(Map<String, Object> map) {
		// TODO 自动生成的方法存根
		this.insertSelective(getMapper(), map);
	}

	public int updMainOrgTypeByOrgId(String string) {
		// TODO 自动生成的方法存根
		return ocrmFciAdmitBelongMapper.updMainOrgTypeByOrgId(string);
	}

	public int updAssistOrgTypeByOrgId(String string) {
		// TODO 自动生成的方法存根
		return ocrmFciAdmitBelongMapper.updAssistOrgTypeByOrgId(string);
	}

	public int deleteByCustIdAndMgrId(Map<String, String> cust) {
		// TODO 自动生成的方法存根
		return ocrmFciAdmitBelongMapper.deleteByCustIdAndMgrId(cust);
	}

	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int saveBelongadd(Map<String, Object> map) throws ParseException {
		UserInfoDTO user = getUserInfoDTO();
		String seqno = (String) map.get("seqno");
		String newseqno = (String) map.get("newseqno");
		List< Map<String,Object>> mappp=new ArrayList<>();
		String userId = user.getUserId();
		String userName = user.getUserName();
		String trustMgrId = (String) map.get("trustMgrId");
		String trustMgrName = (String) map.get("trustMgrName");
		String trustOrgId = (String) map.get("trustOrgId");
		String trustOrgName = (String) map.get("trustOrgName");
		Object mgrTypes = map.get("mgrType");
		String mgrType = String.valueOf(mgrTypes);
		if(StringUtils.isEmpty(mgrType)){
			mgrType= selectroleUtils.getmgrType();
		}

		Map<String, String> mapp = new HashMap<>();
		String strr="";
		List<String> cust=new ArrayList<>();
		LinkedHashSet<String> linklist=new LinkedHashSet<>();
		if(StringUtils.isNotEmpty(seqno)){
			String[] seqnos = seqno.split(",");
			if (seqnos != null && seqnos.length > 0) {
				strr = "in(";
				for (int i = 0; i < seqnos.length; i++) {
					strr += "'" + seqnos[i] + "',";
				}
				strr = strr.substring(0, strr.length() - 1);
				strr += ")";
			}
		}
		mapp.put("strr", strr);
		String[] custIds = null;
		String str="";
		String custId=map.get("custId").toString();
		if (StringUtils.isNotEmpty(custId)) {
			if(StringUtils.isNotEmpty(mapp.get("strr"))){
				mappp= ocrmFciAdmitBelongMapper.selectById(mapp);
			}
			if(mappp.size()>0){
				for(Map<String,Object> m:mappp){
                  if(custId.contains(String.valueOf(m.get("custid")))){
                  	mapp.put("custid",String.valueOf(m.get("custid")));
                  	mapp.put("seqno",String.valueOf(m.get("seqno")));
					  if(StringUtils.isNotEmpty(mapp.get("custid")) && StringUtils.isNotEmpty(mapp.get("seqno"))){
						  ocrmFciAdmitBelongMapper.deleteByCustByIdl(mapp);
						  int count=ocrmFciAdmitBelongMapper.selectCount(mapp);
						  if(count==0){
							  ocrmFciAdmitBelongMapper.deleteByinse(mapp);
						  }
					  }
                  }
				}
				custIds = map.get("custId").toString().split(",");
			}else{
				String[] custIdss = map.get("custId").toString().split(",");
				if (custIdss != null && custIdss.length > 0) {
					str = "in(";
					for (int i = 0; i < custIdss.length; i++) {
						str += "'" + custIdss[i] + "',";
					}
					str = str.substring(0, str.length() - 1);
					str += ")";
				}
				mapp.put("mgrType", mgrType);
				mapp.put("str", str);
				mappp=ocrmFciAdmitBelongMapper.selectmgr(mapp);
				custIds = map.get("custId").toString().split(",");
			}
		}else {
			Map<String,Object> map2=new HashMap<>();
				String value = String.valueOf(map.get("mgrType").toString());
				if (StringUtils.isNotEmpty(value)) {
					map2.put("mgrType", value);
				} else {
					map2.put("mgrType", getmgrType());
				}
				map2.put("_orgCode", user.getOrg().getCode());
				map2.put("_userCode", user.getLoginCode());
				map2.put("mgrId", map.get("mgrId").toString());
				map2.put("assignType", map.get("assignType"));
				map2.put("assignStatus", map.get("assignStatus"));
			    map2.put("figureCode",(String)map.get("figureCode"));
			    map2.put("characterCode",(String)map.get("characterCode"));
				if(StringUtils.isEmpty((String)map.get("assignStatus"))){
				 mappp = this.ocrmFciAdmitBelongMapper.qrybelonglistStringl(map2);
				}else if("00".equals((String)map.get("assignStatus"))){
					mappp = this.ocrmFciAdmitBelongMapper.qrybelonglistString(map2);
				}else{
					mappp = this.ocrmFciAdmitBelongMapper.qrybelonglistStringS(map2);
				}
				if (mappp.size() > 0) {
					for (Map<String, Object> m : mappp) {
						cust.add(String.valueOf(m.get("custid")));
						if(StringUtils.isNotEmpty((String)m.get("seqno"))){
							linklist.add(String.valueOf(m.get("seqno")));
						}
					}
					if(linklist.size()>0){
						String seqnoo=StringUtils.join(linklist.toArray(), ",");
						String[] custt = seqnoo.split(",");
						String strt = "";
						if (custt != null && custt.length > 0) {
							strt = "in(";
							for (int i = 0; i < custt.length; i++) {
									strt += "'" + custt[i] + "',";
							}
							strt = strt.substring(0, strt.length() - 1);
							strt += ")";
						}
						mapp.put("strt",strt);
						ocrmFciAdmitBelongMapper.deleteByCustById(mapp);
						for (int i = 0; i < custt.length; i++) {
							mapp.put("seqno",custt[i]);
							int count=ocrmFciAdmitBelongMapper.selectCount(mapp);
							if(count==0){
								ocrmFciAdmitBelongMapper.deleteByinse(mapp);
							}
						}
					}
					map.put("custId", StringUtils.join(cust.toArray(), ","));
					custIds = map.get("custId").toString().split(",");
				}

		}
		List<CrmFCiBelongHisData> list=new ArrayList<>();
		Date date=simpleDateFormat.parse(simpleDateFormat.format(new Date()));
		if("01".equals((String)map.get("assignStatus")) || "02".equals((String)map.get("assignStatus"))){
			map.put("assignStatus",null);
		}
		for (int i = 0; i < custIds.length; i++) {
			CrmFCiBelongHisData crmFCiBelongHisData = new CrmFCiBelongHisData();
			crmFCiBelongHisData.setSeqno(newseqno);
			crmFCiBelongHisData.setAssignDate(date);
			crmFCiBelongHisData.setAssignType((String) map.get("assignType"));
			crmFCiBelongHisData.setAssignUserName(userName);
			crmFCiBelongHisData.setAssignUserId(userId);
			crmFCiBelongHisData.setChangeReason((String) map.get("changeReason"));
			crmFCiBelongHisData.setCustId(custIds[i]);
			crmFCiBelongHisData.setMgrId(trustMgrId);
			for (Map<String, Object> m : mappp) {
				if(custIds[i].equals(m.get("custid"))){
					crmFCiBelongHisData.setMgrIdPre((String) m.get("mgrid"));
					crmFCiBelongHisData.setMgrNamePre((String) m.get("mgrname"));
					crmFCiBelongHisData.setOrgIdPre((String) m.get("orgid"));
					crmFCiBelongHisData.setOrgNamePre((String) m.get("orgname"));
				}
			}
			crmFCiBelongHisData.setMgrName(trustMgrName);
			crmFCiBelongHisData.setMgrType(mgrType);
			crmFCiBelongHisData.setMgrTypePre(mgrType);
			crmFCiBelongHisData.setOrgId(trustOrgId);
			crmFCiBelongHisData.setOrgName(trustOrgName);
			crmFCiBelongHisData.setAssignStatus((String) map.get("assignStatus"));
			list.add(crmFCiBelongHisData);
		}
		insertList(list);
		if("04".equals((String) map.get("assignStatus"))){
			ocrmFciAdmitBelongMapper.updatebelonghis(getbelong(newseqno));
		}
		return 0;
	}
	private Map<String, Object> getbelong(String bizSeqNo) {
		Map<String, Object> mapp = new HashMap<>();
		Map<String, Object> map = ocrmFciAdmitBelongService.detailebelonghis(bizSeqNo);
		mapp.put("seqno", bizSeqNo);
		mapp.put("mgrIdPre", map.get("mgrIdPre"));
		mapp.put("mgrNamePre", map.get("mgrNamePre"));
		mapp.put("orgIdPre", map.get("orgIdPre"));
		mapp.put("orgNamePre", map.get("orgNamePre"));
		mapp.put("mgrTypePre", map.get("mgrTypePre"));
		mapp.put("mgrId", map.get("mgrId"));
		mapp.put("mgrName", map.get("mgrName"));
		mapp.put("orgId", map.get("orgId"));
		mapp.put("orgName", map.get("orgName"));
		mapp.put("mgrType", map.get("mgrType"));
		return mapp;
	}
	public void insertList(List<CrmFCiBelongHisData> list) {
		int inserlegth=list.size();
		int i=0;
		while (inserlegth >600){
			ocrmFciAdmitBelongMapper.inserthisData(list.subList(i,i+600));
			i=i+600;
			inserlegth=inserlegth - 600;
		}
		if(inserlegth>0){
			ocrmFciAdmitBelongMapper.inserthisData(list.subList(i,i+inserlegth));
		}
	}

	public UserInfoDTO getUserInfoDTO() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		return user;
	}

	public List<Map<String, Object>> qrybelonglist(QueryModel model) {
		UserInfoDTO user = getUserInfoDTO();
		Map<String, Object> map = new HashMap<>();
		String value=String.valueOf(model.getCondition().get("mgrType"));
		if(StringUtils.isNotEmpty(value)){
            map.put("mgrType", value);
        }else{
            map.put("mgrType", getmgrType());
        }
		map.put("_orgCode", user.getOrg().getCode());
		map.put("_userCode", user.getLoginCode());
		map.put("mgrId", model.getCondition().get("mgrId"));
		map.put("orgId", user.getOrg().getCode());
		map.put("figureCode", model.getCondition().get("figureCode"));
		map.put("characterCode", model.getCondition().get("characterCode"));
		map.put("assignType", model.getCondition().get("assignType"));
		map.put("assignStatus", model.getCondition().get("assignStatus"));
        model.getCondition().put("datadate", simpleDateFormat.format(new Date()));
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = new ArrayList<>();
		if ("01".equals(map.get("assignType"))) {
			if(StringUtils.isEmpty((String)map.get("assignStatus"))){
				list = this.ocrmFciAdmitBelongMapper.qrybelonglistlist(map);
			}else if("00".equals(map.get("assignStatus"))){
				list = this.ocrmFciAdmitBelongMapper.qrybelonglistli(map);
			}else{
				list = this.ocrmFciAdmitBelongMapper.qrybelonglistlis(map);
			}
		} else {
			if(StringUtils.isEmpty((String)map.get("assignStatus"))){
				list = this.ocrmFciAdmitBelongMapper.qrybelonglist(map);
			}else if("00".equals(map.get("assignStatus"))){
				list = this.ocrmFciAdmitBelongMapper.qrybelonglistli(map);
			}else{
				list = this.ocrmFciAdmitBelongMapper.qrybelonglistlis(map);
			}
		}
		PageHelper.clearPage();
		return list;
	}

	public String getmgrType() {
		String mgrType = "";
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String selectRole = request.getHeader("selectRole");
		String mgrid = this.ocrmFciAdmitBelongMapper.selectmgrId(selectRole);
		if (StringUtils.isNotEmpty(mgrid)) {
			if (MGR_ROLE_1.contains(mgrid)) {
				mgrType = "1";
			} else if (MGR_ROLE_2.contains(mgrid)) {
				mgrType = "2";
			}
		}
		return mgrType;
	}
    public String getmgType(String selectRole) {
        String mgrType = "";
        String mgrid = this.ocrmFciAdmitBelongMapper.selectmgrId(selectRole);
        if (StringUtils.isNotEmpty(mgrid)) {
            if (MGR_ROLE_1.contains(mgrid)) {
                mgrType = "1";
            } else if (MGR_ROLE_2.contains(mgrid)) {
                mgrType = "2";
            }
        }
        return mgrType;
    }

	public int insertaumGrade(AcrmCustGradeDTO acrmCustGradeDTO) {
		UserInfoDTO user = getUserInfoDTO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = null;
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 1);
		cale.set(Calendar.DAY_OF_MONTH, 0);

		Map<String, String> map = new HashMap<>();
		if(StringUtils.isNotEmpty(acrmCustGradeDTO.getId())){
			map.put("id", acrmCustGradeDTO.getId());
		}else{
			map.put("id", getUUID());
		}
		map.put("custId", acrmCustGradeDTO.getCustId());
		map.put("befModGrade", acrmCustGradeDTO.getBefModGrade());
		map.put("aftModGrade", acrmCustGradeDTO.getAftModGrade());
		map.put("modGraValidFlag", "N");
		map.put("creUserId", user.getUserName());
        if("02".equals(acrmCustGradeDTO.getStatus()) || "01".equals(acrmCustGradeDTO.getStatus())){
			acrmCustGradeDTO.setStatus(null);
		}
		map.put("status", acrmCustGradeDTO.getStatus());

		map.put("expiredDate", format.format(cale.getTime()));
        map.put("effectDate", format.format(new Date()));
		ocrmFciAdmitBelongMapper.insertaumGrade(map);
		return 0;
	}

	public int checkUpNameId(String id) {
		return ocrmFciAdmitBelongMapper.checkUpNameId(id);
	}

	public int updateaumGrade(AcrmCustGradeDTO acrmCustGradeDTO) {
		UserInfoDTO user = getUserInfoDTO();
		Map<String, Object> map = new HashMap<>();
		map.put("id", acrmCustGradeDTO.getId());
		map.put("custId", acrmCustGradeDTO.getCustId());
		map.put("befModGrade", acrmCustGradeDTO.getBefModGrade());
		map.put("aftModGrade", acrmCustGradeDTO.getAftModGrade());
		map.put("modGraValidFlag", "N");
		map.put("creUserId", user.getUserName());
		if("02".equals(acrmCustGradeDTO.getStatus()) || "01".equals(acrmCustGradeDTO.getStatus())){
			acrmCustGradeDTO.setStatus(null);
		}
		map.put("status", acrmCustGradeDTO.getStatus());
		ocrmFciAdmitBelongMapper.updateaumGradeGrade(map);
		return 0;
	}

	public void updatebelong(CrmFCiBelongHisData crmFCiBelongHisData) {
		ocrmFciAdmitBelongMapper.updatebelong(crmFCiBelongHisData);
	}

	public void updateaumGradeGrade(Map<String, Object> map) {
		ocrmFciAdmitBelongMapper.updateaumGradeGrade(map);
	}

	public void updateFci(OcrmFciTrusteeshipApply ocrmFciTrusteeshipApply) {
		ocrmFciAdmitBelongMapper.updateFci(ocrmFciTrusteeshipApply);
	}

	public void updateinformation(Map<String, Object> map) {
		ocrmFciAdmitBelongMapper.updateinformation(map);
		ocrmFciAdmitBelongMapper.updateassets(map);
	}

	public Map<String, Object> detailebelonghis(String seqno) {
		Map<String, Object> map = this.ocrmFciAdmitBelongMapper.detailebelonghis(seqno);
		return map;
	}

	public Map<String, Object> Gradelist(String id) {
		Map<String, Object> map = this.ocrmFciAdmitBelongMapper.Gradelist(id);
		return map;
	}

	public Object isatTeam() {
		Boolean atTeam = true;
		UserInfoDTO user = getUserInfoDTO();
		String Team = this.ocrmFciAdmitBelongMapper.selectTeam(user.getLoginCode());
		if (StringUtils.isNotEmpty(Team)) {
			atTeam = true;
		} else {
			atTeam = false;
		}
		return atTeam;
	}

	public void updatebelonghis(Map<String, Object> mapp) {
		ocrmFciAdmitBelongMapper.updatebelonghis(mapp);
	}

	public AcrmCustVO  selectgrade(String bizSeqNo) {
        AcrmCustVO acrmCustVO = ocrmFciAdmitBelongMapper.selectgrade(bizSeqNo);
		return acrmCustVO;
	}

	public void updateGrade(AcrmCustVO acrmCustVO) {
		ocrmFciAdmitBelongMapper.updateGrade(acrmCustVO);
	}

	public String selectdata(String bizSeqNo) {
		return ocrmFciAdmitBelongMapper.selectdata(bizSeqNo);
	}

	public void updateEsExportQuery(Map<String, Object> map) {
		 ocrmFciAdmitBelongMapper.updateEsExportQuery(map);
	}
	/*public int updateMgrType(Map<String, String> cust) {
		// TODO 自动生成的方法存根
		return ocrmFciAdmitBelongMapper.updateMgrType(cust);
	}*/
}
