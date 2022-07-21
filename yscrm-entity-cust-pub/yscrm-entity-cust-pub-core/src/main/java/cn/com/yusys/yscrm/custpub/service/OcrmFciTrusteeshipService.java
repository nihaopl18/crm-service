package cn.com.yusys.yscrm.custpub.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciAdmitBelongMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custpub.domain.OcrmFciTrusteeshipApply;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciTrusteeshipList;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciGrantMapper;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciTrusteeshipMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.util.UtilTools;

/**
 * @项目名称：crm-service
 * @类名称：OcrmFciTrusteeshipService
 * @类描述：客户托管Service
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-16
 */
@Service
public class OcrmFciTrusteeshipService extends CommonService{
	@Autowired
	private OcrmFciTrusteeshipMapper mapper;
	@Autowired
	private OcrmFciGrantMapper mapperGrant;
	@Autowired
	private OcrmFciTrusteeshipListService ocrmFciTrusteeshipListService;
	@Autowired
	private UaaClient uaaClient;
	@Autowired
	private OcrmFciAdmitBelongMapper ocrmFciAdmitBelongMapper;
	@Autowired
	private OcrmFciAdmitBelongService ocrmFciAdmitBelongService;
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
	* @方法名称: trustList
	* @方法描述: 客户托管历史查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>>trustList(QueryModel model) {
		String apply=(String)model.getCondition().get("applyId");
		BigDecimal applyId=null;
		if(StringUtils.isNotEmpty(apply)){
			applyId=new BigDecimal(apply);
			model.getCondition().put("applyId",applyId);
		}
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.trustList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: custTrustList
	* @方法描述: 客户托管清单
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>>custTrustList(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.custTrustList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @throws ParseException 
	* @方法名称: trustInsert
	* @方法描述: 客户托管
	* @参数与返回说明: 
	* @算法描述:
	**/
//	public ResultDto<Integer>trustInsert(OcrmFciTrusteeshipApply record) throws ParseException {
//		ResultDto<Integer> dto = new ResultDto<Integer>();
//		// 设置日期格式
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		// 获取机构信息	
//		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
//		if (record.getCustId().length == 0 || record.getCustName().length == 0) {
//			dto.setCode(-1);
//			dto.setMessage("未选择托管客户");
//		} else if (record.getTrustMgrId().equals(mapperGrant.getUserId(SecurityUtils.getCurrentUserLogin()))) {
//			dto.setCode(-1);
//			dto.setMessage("托管客户经理为当前登录人");
//		} else if (record.getCustId().length != record.getCustName().length) {
//			dto.setCode(-1);
//			dto.setMessage("托管客户信息格式有误");
//		} 
////		else if (record.getDeadLine().before(new Date())) {
////			dto.setCode(-1);
////			dto.setMessage("托管有效期小于当前日期");
////		} 
////		else if (record.getSetDate().before(new Date())) {
////			dto.setCode(-1);
////			dto.setMessage("托管时间小于当前日期");
////		} 
//		else {
//			// 设置记录编号
//			record.setApplyId(mapper.getId());
//			// 设置托管有效期、托管时间
//			record.setDeadLine(df.parse(df.format(record.getDeadLine())));
//			record.setSetDate(df.parse(df.format(new Date())));
//			// 设置托管状态为已托管
//			record.setTrustStat("1");
//			// 设置托管客户经理id
//			record.setTrustMgrId(mapperGrant.getUserId(record.getTrustMgrId()));
//			// 设置法人为当前登录机构
//			record.setCorpOrgCode(org.getBody().getOrg().getCode());
//			// 新增托管客户信息
//			String[] custId = record.getCustId();
//			String[] custName = record.getCustName();
//			OcrmFciTrusteeshipList custObj = new OcrmFciTrusteeshipList();
//			custObj.setApplyId(record.getApplyId());
//			custObj.setListId(mapper.getListId());
//			int n = 0;
//			for(int i=0;i<custId.length;i++) {
//				custObj.setCustId(custId[i]);
//				custObj.setCustName(custName[i]);
//				if(mapper.getTrustCustId(custObj.getCustId()) == 0) {
//					// 只有未被托管的客户可以托管
//					mapper.trustInsertCust(custObj);	
//				} else {
//					n++;
//				}
//			}
//			if(n == 0) {
//				// 新增托管信息
//				mapper.insertSelective(record);
//				dto.setCode(0);
//				dto.setMessage("托管成功");
//			} else {
//				dto.setCode(-1);
//				dto.setMessage("已被托管的客户不能二次托管");
//				dto.setData(n); // 返回未托管的客户数
//			}
//		}
//		return dto;
//	}
	/**
	* @方法名称: trustRecover
	* @方法描述: 客户托管回收
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer>trustRecover(Map<String, String> map) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String[] ids = map.get("applyId").split(",");
		for(int i=0;i<ids.length;i++) {
			mapper.trustRecover(BigDecimal.valueOf(Long.parseLong(ids[i])));
		}
		dto.setCode(0);
		dto.setMessage("托管回收成功");
		return dto;
	}
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int add(Map<String, Object> map) {
		// TODO 自动生成的方法存根
		UserInfoDTO user = getUserInfoDTO();
		String apply=(String)map.get("applyId");
		String newapply=(String)map.get("newapplyId");
		BigDecimal applyId=null;
		String strr="";
		Map<String,Object> mapp=new HashMap<>();
		if(StringUtils.isNotEmpty(apply)){
			String[] applys = apply.split(",");
			if (applys != null && applys.length > 0) {
				strr = "in(";
				for (int i = 0; i < applys.length; i++) {
					strr += "'" + applys[i] + "',";
				}
				strr = strr.substring(0, strr.length() - 1);
				strr += ")";
			}
		}
		mapp.put("strr",strr);
		String custIdd=(String)map.get("custId");
		List<String> custs=new ArrayList<>();
		LinkedHashSet<String> linklist=new LinkedHashSet<>();
		List<Map<String,Object>> list=new ArrayList<>();
		if(StringUtils.isNotEmpty(custIdd)){
			if(StringUtils.isNotEmpty((String)mapp.get("strr"))){
				list=mapper.selectById(mapp);
			}
			if(list.size()> 0){
				for(Map<String,Object> m:list){
					if(custIdd.contains(String.valueOf(m.get("custid")))){
						mapp.put("custid",String.valueOf(m.get("custid")));
						mapp.put("applyno",m.get("applyno"));
						if(StringUtils.isNotEmpty((String)mapp.get("custid")) && StringUtils.isNotEmpty((String)mapp.get("applyno"))){
							mapper.deleteByCustByIdl(mapp);
							int count=mapper.selectCount(mapp);
							if(count==0){
								Map<String,String> mappp=new HashMap<>();
								mappp.put("custid",String.valueOf(m.get("custid")));
								mappp.put("applyno",String.valueOf(m.get("applyno")));
								ocrmFciAdmitBelongMapper.deleteByinse(mappp);
								mapper.deleteapp(mapp);
							}
						}
					}
				}
			}
		}else{
			mapp.put("trustStat",(String)map.get("trustStat"));
			mapp.put("mgrId",user.getUserId());
			Object mgrTypes = map.get("mgrType");
			String mgrType = String.valueOf(mgrTypes);
			if(StringUtils.isNotEmpty(mgrType)){
				mapp.put("mgrType", mgrType);
			}else{
				mapp.put("mgrType", ocrmFciAdmitBelongService.getmgrType());
			}
			mapp.put("figureCode",(String)map.get("figureCode"));
			mapp.put("characterCode",(String)map.get("characterCode"));
			mapp.put("datadate", simpleDateFormat.format(new Date()));
			if(StringUtils.isEmpty((String)mapp.get("trustStat"))){
				list=mapper.selectcust(mapp);
			}else if("00".equals((String)mapp.get("trustStat"))){
				list=mapper.selectcustmap(mapp);
			}else{
				list=mapper.selectcustma(mapp);
			}
			if (list.size() > 0) {
				for (Map<String, Object> m : list) {
					custs.add(String.valueOf(m.get("custid")));
					if(StringUtils.isNotEmpty((String)m.get("applyid"))){
						linklist.add(String.valueOf(m.get("applyid")));
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
					mapper.deleteByCustById(mapp);
					for (int i = 0; i < custt.length; i++) {
						mapp.put("applyno",custt[i]);
						int count=mapper.selectCount(mapp);
						if(count==0){
							Map<String,String> mappp=new HashMap<>();
							mappp.put("applyno",String.valueOf(custt[i]));
							ocrmFciAdmitBelongMapper.deleteByinse(mappp);
							mapper.deleteapp(mapp);
						}
					}
				}
				map.put("custId", StringUtils.join(custs.toArray(), ","));
			}
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*
		String[] custIds = ((String) map.get("custId")).split(",");
*/
		String CUSTID="CUST_ID";
		String custIds=strToSqlGroupIn(CUSTID,(String)map.get("custId"));
		String userId = user.getUserId();
		String userName = user.getUserName();
		String trustMgrId = (String) map.get("trustMgrId");
		String	trustMgrName = (String) map.get("trustMgrName");
		String[] custNames = ((String) map.get("custName")).split(",");
		OcrmFciTrusteeshipApply ocrmFciTrusteeshipApply = new OcrmFciTrusteeshipApply();
		ocrmFciTrusteeshipApply.setApplyId(new BigDecimal(newapply));
		ocrmFciTrusteeshipApply.setCorpOrgCode("001");
		ocrmFciTrusteeshipApply.setMgrId(userId);
		ocrmFciTrusteeshipApply.setMgrName(userName);
		ocrmFciTrusteeshipApply.setTrustMgrId(trustMgrId);
		ocrmFciTrusteeshipApply.setTrustMgrName(trustMgrName);
		ocrmFciTrusteeshipApply.setSetDate(new Date());
		ocrmFciTrusteeshipApply.setSetUserId(userId);
		ocrmFciTrusteeshipApply.setSetUserName(userName);
		ocrmFciTrusteeshipApply.setTrustReason((String)map.get("trustReason"));
		if("01".equals((String)map.get("trustStat")) || "02".equals((String)map.get("trustStat"))){
			map.put("trustStat",null);
		}
		ocrmFciTrusteeshipApply.setTrustStat((String)map.get("trustStat"));

		try {
			ocrmFciTrusteeshipApply.setDeadLine(df.parse((String) map.get("deadLine")));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		this.mapper.insertSelective(ocrmFciTrusteeshipApply);
		List<OcrmFciTrusteeshipList> lists=new ArrayList<>();
		Map<String,String> mappp=new HashMap<>();
		mappp.put("custIds",custIds);
		List<Map<String,String>> list1=mapper.selectName(mappp);
		for(Map<String,String> m:list1) {
			OcrmFciTrusteeshipList ocrmFciTrusteeshipList = new OcrmFciTrusteeshipList();
				ocrmFciTrusteeshipList.setListId(UtilTools.getUUID());
				ocrmFciTrusteeshipList.setApplyNo(new BigDecimal(newapply));
				ocrmFciTrusteeshipList.setCustId(m.get("custid"));
				ocrmFciTrusteeshipList.setCustName(m.get("custname"));
			    lists.add(ocrmFciTrusteeshipList);
		}
		insertList(lists);
		return 0;
	}

	public void insertList(List<OcrmFciTrusteeshipList> lists) {
		int inserlegth=lists.size();
		int i=0;
		while (inserlegth >600){
			mapper.insertList(lists.subList(i,i+600));
			i=i+600;
			inserlegth=inserlegth - 600;
		}
		if(inserlegth>0){
			mapper.insertList(lists.subList(i,i+inserlegth));
		}
	}

	public String strToSqlGroupIn(String CUSTID,String strIns) {
		int groupNum = 1;
		String groupInArr = new String();
		StringBuffer buffer = new StringBuffer();
		if (StringUtils.isNoneBlank(strIns)) {
			String[] array = strIns.split(",");
			//数组总长度
			int len = array.length;
			//分组数
			int groupCount = len / groupNum;
			for (int k = 0; k < groupCount; k++) {
				groupInArr = new String();
				for (int i = (k * groupNum); i < (k * groupNum + groupNum); i++) {
					if (i > k * groupNum) {
						groupInArr += ",";
					}
					groupInArr += array[i].trim();
				}
				if (k > 0) {
					buffer.append(" or ");
				}
				buffer.append(String.format(" %s in(%s)", CUSTID, strToDbin(groupInArr)));
			}
			if (len % groupNum != 0) {
				//未整除
				groupInArr = new String();
				//处理最后一组数据
				for (int j = (groupCount * groupNum); j < len; j++) {
					if (j > groupCount * groupNum) {
						groupInArr += ",";
					}
					groupInArr += array[j].trim();
				}
				if (buffer.length() > 0) {
					buffer.append(" or ");
				}
				buffer.append(String.format(" %s in(%s)", CUSTID, strToDbin(groupInArr)));
			}
		}
		return buffer.toString();
	}
	public String strToDbin(String str) {
		return String.format("'%s'", StringUtils.join(str.split(","), "','"));
	}

	public List<Map<String, String>> myCustListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		model.getCondition().put("mgrId", getUserInfoDTO().getLoginCode());
		String value=String.valueOf(model.getCondition().get("mgrType"));
		if(StringUtils.isNotEmpty(value)){
			model.getCondition().put("mgrType", value);
		}else{
			model.getCondition().put("mgrType", ocrmFciAdmitBelongService.getmgrType());
		}
		model.getCondition().put("datadate", simpleDateFormat.format(new Date()));
		String trustStat=String.valueOf(model.getCondition().get("trustStat"));
		List<Map<String, String>> list=new ArrayList<>();
		if(StringUtils.isEmpty(trustStat)){
			PageHelper.startPage(model.getPage(),model.getSize());
			list = mapper.myCustListByModel(model);
		}else if("00".equals(trustStat)){
			PageHelper.startPage(model.getPage(),model.getSize());
			list = mapper.myCustListByModelM(model);
		}else{
			PageHelper.startPage(model.getPage(),model.getSize());
			list = mapper.myCustListByModelMS(model);
		}
		PageHelper.clearPage();
		return list;
	}
	public List<Map<String, String>> getTrustCust(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = mapper.getTrustCust(model);
		PageHelper.clearPage();
		return list;
	}
	public List<Map<String, String>> getTrustList(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = mapper.getTrustList(model);
		PageHelper.clearPage();
		return list;
	}

	public Map<String, Object> detailelist(String applyId) {
		Map<String, Object> mapp=new HashMap<>();
		mapp.put("applyId",applyId);
		mapp.put("mgrType",ocrmFciAdmitBelongService.getmgrType());
		Map<String, Object> map= mapper.detailelist(mapp);
		return map;
	}
}
