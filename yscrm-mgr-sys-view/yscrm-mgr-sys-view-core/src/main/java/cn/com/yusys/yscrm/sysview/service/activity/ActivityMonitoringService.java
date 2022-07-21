package cn.com.yusys.yscrm.sysview.service.activity;

import cn.com.yusys.yscrm.sysview.domain.TagAnalysisQuery;
import cn.com.yusys.yscrm.sysview.domain.activity.TodoWorkSRC;
import cn.com.yusys.yscrm.sysview.domain.activity.*;
import cn.com.yusys.yscrm.sysview.repository.mapper.activity.ActivityMonitoringMapper;
import cn.com.yusys.yscrm.sysview.utils.DateUtils;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import com.github.pagehelper.PageHelper;
import org.eclipse.jetty.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: sxm
 * @time: 2021/9/16 10:27
 */
@Service("activityMonitoringService")
public class ActivityMonitoringService {
	@Autowired
	private ActivityMonitoringMapper mapper;
	@Autowired
	private UaaClient uaaClient;

	private String Role;
	private final Logger logger = LoggerFactory.getLogger(ActivityMonitoringService.class);
	//总行授权主管，总行综合管理用户，总行业务管理用户，总行销售推动用户，分行综合管理岗，分行副行长，系统管理员
	public static final String MGR_ROLE_1 = "R006,R008,R009,R010,RO13,R005,R001,R022";
	//分行个贷主管
	public static final String MGR_ROLE_2 = "R016";
	//分行理财主管
	public static final String MGR_ROLE_3 = "R015";
	//团队长
//	public static final String MGR_ROLE_4 = "R018,R019,R004";
	@Value("${role.patrolLeader}")
	public String MGR_ROLE_4;
	//支行行长(理财)
//	public static final String MGR_ROLE_5 = "R017";
	@Value("${role.subbranch}")
	public String  MGR_ROLE_5;
	//总行
//	public static final String MGR_ROLE_6 = "R006,R008,R009,R010,R001";
	@Value("${role.headOffice}")
	public String MGR_ROLE_6;
	//分行
//	public static final String MGR_ROLE_7 = "R013,R005,R016,R015";
	@Value("${role.branch}")
	public String MGR_ROLE_7;
	//客户经理
//	public static final String MGR_ROLE_8 = "R002,R003";
	@Value("${role.customerManage}")
	public String MGR_ROLE_8;
	public String getRoles() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String role = "";
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String selectRole = request.getHeader("selectRole");
		for (ObjBean obj : dto.getBody().getRoles()) {
			if (obj.getId().equals(selectRole)){
				role = obj.getCode();
			}
		}
		if ("".equals(role)){
			role = this.Role;
		}
		return role;
	}

	public Map<String, Object>  getQueryMap() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		Map<String, Object> queryMap = new HashMap<>();
		UserInfoDTO user = dto.getBody();
		queryMap.put("userCode", user.getLoginCode());
		queryMap.put("orgCode", user.getOrg().getCode());
		String lastMonthTime = DateUtils.getMonthTime(-1);
		queryMap.put("startTime", lastMonthTime);
		String roleType = "";
		String role = getRoles();
		if ("R003,R016,R019,R020".contains(role)){
			roleType = "2";
		}else if ("R002,R018,R015,R017,R021".contains(role)){
			roleType = "1";
		}
		return queryMap;
	}

	public UserInfoDTO getUserInfoDTO() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		return user;
	}

	@Transactional(readOnly = true)
	public Map<String, Object> dataOverview() {
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> queryMap = getQueryMap();
		String role = getRoles();
		if(MGR_ROLE_1.contains(role)){
			ActiveIndex all = mapper.allAvgCust(queryMap);
			map.put("all", all);
		}else if (MGR_ROLE_2.contains(role)){
			ActiveIndex loan = mapper.loanAvgCust(queryMap);
			map.put("loan", loan);
		}else if (MGR_ROLE_3.contains(role) || MGR_ROLE_5.contains(role)){
			ActiveIndex financing = mapper.financingAvgCust(queryMap);
			map.put("financing", financing);
		}else if (MGR_ROLE_4.contains(role)){
			ActiveIndex team = mapper.teamAvgCust(queryMap);
			map.put("team", team);
		}
		String firstDayOfThisMonth = DateUtils.getFirstDayOfThisMonth();
		queryMap.put("startTime",firstDayOfThisMonth);
		int currentReport = mapper.workReportCount(queryMap);
		int currentTouch = mapper.dataTouchCustCount(queryMap);
		int currentChange = changeRate(queryMap);
		int currentTodowork = todoWorkRate(queryMap);


		String firstDayOfBeforeMonth = DateUtils.getFirstDayOfBeforeMonth();
		queryMap.put("endTime",firstDayOfThisMonth);
		queryMap.put("startTime", firstDayOfBeforeMonth);
		int lastReport = mapper.workReportCount(queryMap);
		ActiveIndex report = new ActiveIndex();
		report.setNum(Integer.toString(currentReport));
		report.setHb(Float.toString(lastReport == 0 ? (currentReport == 0 ? 0 : 1) : (float) (currentReport - lastReport) / lastReport));
		int lastTouch = mapper.dataTouchCustCount(queryMap);
		ActiveIndex touch = new ActiveIndex();
		touch.setNum(Integer.toString(currentTouch));
		touch.setHb(Float.toString(lastTouch == 0 ? (currentTouch == 0 ? 0 :1) : (float) (currentTouch - lastTouch) / lastTouch));
		int lastChange = changeRate(queryMap);
		ActiveIndex change = new ActiveIndex();
		change.setNum(Integer.toString(currentChange));
		change.setHb(Float.toString(lastChange == 0 ? (currentChange == 0 ? 0 :1) : (float) (currentChange - lastChange) / lastChange));
		int lastTodowork = todoWorkRate(queryMap);
		ActiveIndex todowork = new ActiveIndex();
		todowork.setNum(Integer.toString(currentTodowork));
		todowork.setHb(Float.toString(lastTodowork == 0 ? (currentTodowork == 0 ? 0 :1) : (float) (currentTodowork - lastTodowork) / lastTodowork));
		map.put("report", report);
		map.put("touch", touch);
		map.put("change", change);
		map.put("todowork", todowork);
		return map;
	}

	@Transactional(readOnly = true)
	public List<BelongInfo> belongOverview(String line) {
		String roles = getRoles();
		List<BelongInfo> list = new ArrayList<>();
		List<BelongInfo> resultList = new ArrayList<>();
		Map<String, Object> queryMap = getQueryMap();
		if (MGR_ROLE_1.contains(roles) || MGR_ROLE_2.contains(roles)){
			queryMap.put("line","2");
			list.addAll(mapper.branchBelong(queryMap));
		}
		if (MGR_ROLE_1.contains(roles) || MGR_ROLE_3.contains(roles)){
			queryMap.put("line","1");
			list.addAll(mapper.branchBelong(queryMap));
		}
		if (MGR_ROLE_5.contains(roles)){
			if(((String)queryMap.get("orgCode")).length() > 2){
				list.addAll(mapper.subBranchBelong(queryMap));
			}else {
				queryMap.put("line","1");
				list.addAll(mapper.branchBelong(queryMap));
			}
		}
		if (MGR_ROLE_4.contains(roles)){
			list.addAll(mapper.teamBelong(queryMap));
		}
		Map<String, List<BelongInfo>> map = list.stream().filter(item-> StringUtil.isNotBlank(item.getName())).collect(Collectors.groupingBy(BelongInfo::getName));
		for (Map.Entry<String, List<BelongInfo>> m : map.entrySet()) {
			BelongInfo b = new BelongInfo();
			b.setName(m.getKey());
			for (int i = 0; i < m.getValue().size(); i++) {
				if ("1".equals(m.getValue().get(i).getMgrType())) {
					b.setFinancingCount(m.getValue().get(i).getCount());
				}
				if ("2".equals(m.getValue().get(i).getMgrType())) {
					b.setLoanCount(m.getValue().get(i).getCount());
				}
			}
			resultList.add(b);
		}
		if (line != null && "2".equals(line)){
			Collections.sort(resultList, new Comparator<BelongInfo>() {
				@Override
				public int compare(BelongInfo o1, BelongInfo o2) {
					return -o1.getLoanCount().compareTo(o2.getLoanCount());
				}
			});
		}else {
			Collections.sort(resultList, new Comparator<BelongInfo>() {
				@Override
				public int compare(BelongInfo o1, BelongInfo o2) {
					return -o1.getFinancingCount().compareTo(o2.getFinancingCount());
				}
			});
		}
		return resultList;
	}

	@Transactional(readOnly = true)
	public Map<String, Integer> custManagerOverview() {
		String roles = getRoles();
		Map<String, Integer> map = new HashMap<>();
		Map<String, Object> queryMap = getQueryMap();
		if (MGR_ROLE_1.contains(roles) || MGR_ROLE_2.contains(roles)){
			queryMap.put("line", "2");
			Integer loan = mapper.custManagerNum(queryMap);
			map.put("loan", loan == null? 0:loan);
		}
		if (MGR_ROLE_1.contains(roles) || MGR_ROLE_3.contains(roles) || MGR_ROLE_5.contains(roles)){
			queryMap.put("line", "1");
			Integer financing = mapper.custManagerNum(queryMap);
			map.put("financing", financing == null ? 0 : financing);
		}
		if (MGR_ROLE_1.contains(roles)){
			queryMap.put("line", "0");
			Integer all = mapper.custManagerNum(queryMap);
			map.put("all", all == null ? 0 : all);
		}
		if (MGR_ROLE_4.contains(roles)) {
			Integer team = mapper.getTeamUserId(queryMap);
			map.put("team", team == null ? 0 : team);
		}
		return map;
	}

	@Transactional(readOnly = true)
	public Map<String, Object> touchCustInfo(QueryModel queryModel) {
		String roles = getRoles();
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> queryMap = getQueryMap();
		if (queryModel.getCondition().get("startTime") != null) {
			queryMap.put("startTime", queryModel.getCondition().get("startTime"));
			queryMap.put("endTime", queryModel.getCondition().get("endTime"));
		}
		List<TouchSRC> list = mapper.touchTotal(queryMap);
		Map<String, List<TouchSRC>> resultMap = list.stream()
				.filter(item-> StringUtil.isNotBlank(item.getContactCustId()))
				.collect(Collectors.groupingBy(TouchSRC::getContactCustId));
		map.put("count1", resultMap.size());
		Integer count2 = 0;
		for (TouchSRC touchSRC: list) {
			count2 += touchSRC.getTime();
		}
		map.put("count2", count2);
		Map<String, List<TouchSRC>> resultMap2 = list.stream()
				.filter(item-> StringUtil.isNotBlank(item.getContactType()))
				.collect(Collectors.groupingBy(TouchSRC::getContactType));
		Integer count3 = 0;
		if (resultMap2.get("2") != null && resultMap2.get("2").size() > 0 ){
			for (TouchSRC touchSRC: resultMap2.get("2")) {
				count3 += touchSRC.getTime();
			}
		}
		map.put("count3", count3);
		Integer count4 = 0;
		if (resultMap2.get("1") != null  && resultMap2.get("1").size() > 0 ){
			for (TouchSRC touchSRC: resultMap2.get("1")) {
				count4 += touchSRC.getTime();
			}
		}
		map.put("count4", count4);
		Map<String, List<TouchSRC>> resultMap3 = null;
		if (MGR_ROLE_6.contains(roles)) {
			resultMap3 = list.stream()
					.filter(item-> StringUtil.isNotBlank(item.getUpOrgName()))
					.collect(Collectors.groupingBy(TouchSRC::getUpOrgName));
		}
		if (MGR_ROLE_7.contains(roles)) {
			resultMap3 = list.stream()
					.filter(item-> StringUtil.isNotBlank(item.getOrgName()))
					.collect(Collectors.groupingBy(TouchSRC::getOrgName));
		}
		if (MGR_ROLE_5.contains(roles)){
			if(((String)queryMap.get("orgCode")).length() > 2){
				resultMap3 = list.stream()
						.filter(item-> StringUtil.isNotBlank(item.getCreator()))
						.collect(Collectors.groupingBy(TouchSRC::getCreator));
			}else {
				resultMap3 = list.stream()
						.filter(item-> StringUtil.isNotBlank(item.getOrgName()))
						.collect(Collectors.groupingBy(TouchSRC::getOrgName));
			}
		}
		if (MGR_ROLE_4.contains(roles) || MGR_ROLE_8.contains(roles)) {
			resultMap3 = list.stream()
					.filter(item-> StringUtil.isNotBlank(item.getCreator()))
					.collect(Collectors.groupingBy(TouchSRC::getCreator));
		}
		List<OrgTouchCustInfo> detail = new ArrayList<>();
		if (resultMap3 != null) {
			for (Map.Entry<String, List<TouchSRC>> m : resultMap3.entrySet()) {
				Integer total = 0;
				for (TouchSRC touchSRC : m.getValue()) {
					total += touchSRC.getTime();
				}
				OrgTouchCustInfo orgTouchCustInfo = new OrgTouchCustInfo();
				orgTouchCustInfo.setCount(total);
				orgTouchCustInfo.setName(m.getKey());
				if (MGR_ROLE_6.contains(roles)) {
					orgTouchCustInfo.setId(m.getValue().get(0).getUpOrgId());
				} else if (MGR_ROLE_7.contains(roles)) {
					orgTouchCustInfo.setId(m.getValue().get(0).getOrgId());
				} else if (MGR_ROLE_5.contains(roles)) {
					if (((String) queryMap.get("orgCode")).length() > 2) {
						orgTouchCustInfo.setId(m.getValue().get(0).getCreatorId());
					} else {
						orgTouchCustInfo.setId(m.getValue().get(0).getOrgId());
					}
				} else if (MGR_ROLE_4.contains(roles) || MGR_ROLE_8.contains(roles)) {
					orgTouchCustInfo.setId(m.getValue().get(0).getCreatorId());
				}
				detail.add(orgTouchCustInfo);
			}
		}
		map.put("detail",detail);

		Integer currentCount1 = 0;
		Integer currentCount2 = 0;
		Integer currentCount3 = 0;
		Integer currentCount4 = 0;
		Map<String, Object> queryMap2 = getQueryMap();
		String firstDayOfThisMonth = DateUtils.getFirstDayOfThisMonth();
		queryMap2.put("startTime",firstDayOfThisMonth);
		List<TouchSRC> list1 = mapper.touchTotal(queryMap2);
		Map<String, List<TouchSRC>> resultMap4 = list1.stream()
				.filter(item-> StringUtil.isNotBlank(item.getContactCustId()))
				.collect(Collectors.groupingBy(TouchSRC::getContactCustId));
		currentCount1 = resultMap4.size();
		for (TouchSRC touchSRC: list1) {
			currentCount2 += touchSRC.getTime();
		}
		Map<String, List<TouchSRC>> resultMap5 = list1.stream()
				.filter(item-> StringUtil.isNotBlank(item.getContactType()))
				.collect(Collectors.groupingBy(TouchSRC::getContactType));
		if (resultMap5.get("2") != null  && resultMap5.get("2").size() > 0 ){
			for (TouchSRC touchSRC: resultMap5.get("2")) {
				currentCount3 += touchSRC.getTime();
			}
		}
		if (resultMap5.get("1") != null  && resultMap5.get("1").size() > 0 ){
			for (TouchSRC touchSRC: resultMap5.get("1")) {
				currentCount4 += touchSRC.getTime();
			}
		}

		String firstDayOfBeforeMonth = DateUtils.getFirstDayOfBeforeMonth();
		queryMap2.put("startTime", firstDayOfBeforeMonth);
		queryMap2.put("endTime", firstDayOfThisMonth);
		List<TouchSRC> list2 = mapper.touchTotal(queryMap2);
		Map<String, List<TouchSRC>> resultMap6 = list2.stream()
				.filter(item-> StringUtil.isNotBlank(item.getContactCustId()))
				.collect(Collectors.groupingBy(TouchSRC::getContactCustId));
		Integer lastCount1 = resultMap6.size();
		Integer lastCount2 = 0;
		for (TouchSRC touchSRC: list2) {
			lastCount2 += touchSRC.getTime();
		}
		Map<String, List<TouchSRC>> resultMap7 = list2.stream()
				.filter(item-> StringUtil.isNotBlank(item.getContactType()))
				.collect(Collectors.groupingBy(TouchSRC::getContactType));
		Integer lastCount3 = 0;
		Integer lastCount4 = 0;
		if (resultMap7.get("2") != null && resultMap7.get("2").size() >0){
			for (TouchSRC touchSRC: resultMap7.get("2")) {
				lastCount3 += touchSRC.getTime();
			}
		}
		if (resultMap7.get("1") != null && resultMap7.get("1").size() >0){
			for (TouchSRC touchSRC: resultMap7.get("1")) {
				lastCount4 += touchSRC.getTime();
			}
		}

		Integer ratio1 = 0;
		Integer ratio2 = 0;
		Integer ratio3 = 0;
		Integer ratio4 = 0;
		if (lastCount1 != 0) {
			ratio1 = (int) Math.round((float) (currentCount1 - lastCount1) / lastCount1) * 100;
		} else if (currentCount1 != 0) {
			ratio1 = 100;
		}
		if (lastCount2 != 0) {
			ratio2 = (int) Math.round((float) (currentCount2 - lastCount2) / lastCount2) * 100;
		} else if (currentCount2 != 0) {
			ratio2 = 100;
		}
		if (lastCount3 != 0) {
			ratio3 = (int) Math.round((float) (currentCount3 - lastCount3) / lastCount3) * 100;
		} else if (currentCount3 != 0) {
			ratio3 = 100;
		}
		if (lastCount4 != 0) {
			ratio4 = (int) Math.round((float) (currentCount4 - lastCount4) / lastCount4) * 100;
		} else if (currentCount4 != 0) {
			ratio4 = 100;
		}
		map.put("ratio1", ratio1);
		map.put("ratio2", ratio2);
		map.put("ratio3", ratio3);
		map.put("ratio4", ratio4);

		return map;
	}

	@Transactional(readOnly = true)
	public List<TouchCustInfoExcel> touchCustInfoExcel(TagAnalysisQuery tagAnalysisQuery) {
		Map<String, Object> queryMap = getQueryMap();
		if (tagAnalysisQuery.getStartTime() != null && !"".equals(tagAnalysisQuery.getStartTime())){
			queryMap.put("startTime", tagAnalysisQuery.getStartTime());
			queryMap.put("endTime", tagAnalysisQuery.getEndTime());
		}
		if (tagAnalysisQuery.getDataAuth() != null && !"".equals(tagAnalysisQuery.getDataAuth())){
			queryMap.put("dataAuth1", tagAnalysisQuery.getDataAuth());
		}
		List<TouchSRC> list = mapper.touchTotal(queryMap);
		queryMap.put("startTime", DateUtils.getMonthTime(-2));
		queryMap.put("endTime", DateUtils.getMonthTime(-1));
		List<TouchSRC> lastList = mapper.touchTotal(queryMap);
		Map<String, List<TouchSRC>> resultMap = list.stream()
				.filter(item-> StringUtil.isNotBlank(item.getCreator()))
				.collect(Collectors.groupingBy(TouchSRC::getCreator));
		Map<String, List<TouchSRC>> lastResultMap = lastList.stream()
				.filter(item-> StringUtil.isNotBlank(item.getCreator()))
				.collect(Collectors.groupingBy(TouchSRC::getCreator));

		List<TouchCustInfoExcel> rl = new ArrayList<>();
		for (Map.Entry<String, List<TouchSRC>> m : resultMap.entrySet()) {
			TouchCustInfoExcel touchCustInfoExcel = new TouchCustInfoExcel();
			TouchSRC touchSRC = m.getValue().get(0);
			touchCustInfoExcel.setCreatorName(touchSRC.getCreatorName());
			touchCustInfoExcel.setCreatorId(touchSRC.getCreatorId());
			touchCustInfoExcel.setOrgName(touchSRC.getOrgName());
			touchCustInfoExcel.setOrgId(touchSRC.getOrgId());
			if ("3".equals(touchSRC.getOrgLevel())){
				touchCustInfoExcel.setUpOrgName(touchSRC.getUpOrgName());
				touchCustInfoExcel.setUpOrgId(touchSRC.getUpOrgId());
			}else if ("2".equals(touchSRC.getOrgLevel())){
				touchCustInfoExcel.setUpOrgName("东亚中国总行");
				touchCustInfoExcel.setUpOrgId("500");
			}
			List<TouchSRC> list1 = m.getValue();
			List<TouchSRC> lastList1 = lastResultMap.get(m.getKey());

			Integer time = 0;
			Integer lastTime = 0;
			for (TouchSRC ts: list1) {
				time += ts.getTime();
			}

			Map<String, List<TouchSRC>> numberMap = list1.stream()
					.filter(item-> StringUtil.isNotBlank(item.getContactCustId()))
					.collect(Collectors.groupingBy(TouchSRC::getContactCustId));

			Map<String, List<TouchSRC>> contactType = list1.stream()
					.filter(item-> StringUtil.isNotBlank(item.getContactType()))
					.collect(Collectors.groupingBy(TouchSRC::getContactType));

			Map<String, List<TouchSRC>> lastNumberMap = new HashMap<>();

			Map<String, List<TouchSRC>> lastContactType =new HashMap<>();
			if(lastList1 != null && lastList1.size() > 0){
				for (TouchSRC ts: lastList1) {
					lastTime += ts.getTime();
				}
				lastNumberMap = lastList1.stream()
						.filter(item-> StringUtil.isNotBlank(item.getContactCustId())).collect(Collectors.groupingBy(TouchSRC::getContactCustId));

				lastContactType = lastList1.stream()
						.filter(item-> StringUtil.isNotBlank(item.getContactType()))
						.collect(Collectors.groupingBy(TouchSRC::getContactType));
			}

			touchCustInfoExcel.setTime(time);
			touchCustInfoExcel.setLastTime(lastTime);
			touchCustInfoExcel.setTimeQoq(lastTime == 0 ? (time == 0 ? 0 : 100) : (double)(time-lastTime) / lastTime * 100);

			touchCustInfoExcel.setNumber(numberMap.size());
			touchCustInfoExcel.setLastNumber(lastNumberMap.size());
			touchCustInfoExcel.setNumberQoq(touchCustInfoExcel.getLastNumber() == 0 ? (touchCustInfoExcel.getNumber() == 0 ? 0 : 100) : (double)(touchCustInfoExcel.getNumber()-touchCustInfoExcel.getLastNumber()) / touchCustInfoExcel.getLastNumber() * 100);

			Integer count1 = 0;
			Integer lastCount1 = 0;
			if (contactType.get("1") != null  && contactType.get("1").size() >0){
				for (TouchSRC ts: contactType.get("1")) {
					count1 += ts.getTime();
				}
			}
			if (lastContactType.get("1") != null  && lastContactType.get("1").size() >0){
				for (TouchSRC ts: lastContactType.get("1")) {
					lastCount1 += ts.getTime();
				}
			}
			touchCustInfoExcel.setCount1(count1);
			touchCustInfoExcel.setLastCount1(lastCount1);
			touchCustInfoExcel.setCount1Qoq(lastCount1 == 0 ? (count1 == 0 ? 0 : 100) : (double)(count1-lastCount1) / lastCount1 * 100);

			Integer count2 = 0;
			Integer lastCount2 = 0;
			if (contactType.get("2") != null && contactType.get("2").size() > 0){
				for (TouchSRC ts: contactType.get("2")) {
					count2 += ts.getTime();
				}
			}
			if (lastContactType.get("2") != null  && lastContactType.get("2").size() > 0){
				for (TouchSRC ts: lastContactType.get("2")) {
					lastCount2 += ts.getTime();
				}
			}
			touchCustInfoExcel.setCount2(count2);
			touchCustInfoExcel.setLastCount2(lastCount2);
			touchCustInfoExcel.setCount1Qoq(lastCount2 == 0 ? (count2 == 0 ? 0 : 100) : (double)(count2-lastCount2) / lastCount2 * 100);
			rl.add(touchCustInfoExcel);
		}
		// 排序
		Collections.sort(rl);
		return rl;
	}

	@Transactional(readOnly = true)
	public Map<String, Object> changeRemind(QueryModel queryModel) {
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> queryMap = getQueryMap();
		if (queryModel.getCondition().get("startTime") != null) {
			queryMap.put("startTime", queryModel.getCondition().get("startTime"));
			queryMap.put("endTime", queryModel.getCondition().get("endTime"));
		}else {
			queryMap.put("endTime", DateUtils.getCurrentDate());
		}

		List<ChangeRemindSRC> list = mapper.changeRemindTotal(queryMap);

		Map<String, List<ChangeRemindSRC>> resultMap = list.stream()
				.filter(item-> StringUtil.isNotBlank(item.getState()))
				.collect(Collectors.groupingBy(ChangeRemindSRC::getState));

		Integer count2 = 0;
		Integer count3 = 0;
		Integer aging = 0;
		// 已处理
		if (resultMap.get("0") != null && resultMap.get("0").size() > 0) {
			for (ChangeRemindSRC obj : resultMap.get("0")) {
				count2 += obj.getCount();
				aging += obj.getAging() * obj.getCount();
			}
		}
		// 未处理
		if (resultMap.get("2") != null && resultMap.get("2").size() >0 ) {
			for (ChangeRemindSRC obj : resultMap.get("2")) {
				count3 += obj.getCount();
			}
		}
		Integer total = count2 + count3;
		map.put("total", total);
		map.put("count2", count2);
		map.put("count3", count3);
		map.put("aging", count2 == 0 ? 0 : (float)aging/count2);

		// 各类型异动占比
		List<ChangeRemind> resultList = new ArrayList<>();
		Map<String, List<ChangeRemindSRC>> resultMap1 = list.stream()
				.filter(item-> StringUtil.isNotBlank(item.getTypeId()))
				.collect(Collectors.groupingBy(ChangeRemindSRC::getTypeId));
		for (Map.Entry<String, List<ChangeRemindSRC>> m : resultMap1.entrySet()) {
			ChangeRemind changeRemind = new ChangeRemind();
			ChangeRemind changeRemind2 = new ChangeRemind();
			Integer rateCount1 = 0;
			Integer rateCount2 = 0;
			if (m.getValue().size() != 0) {
				for (ChangeRemindSRC obj : m.getValue()) {
					if ("0".equals(obj.getState())) {
						// 已处理
						rateCount1 += obj.getCount();
					} else {
						// 未处理
						rateCount2 += obj.getCount();
					}
				}
			}
			changeRemind.setTypeId(m.getKey());
			changeRemind.setState("0");
			int rate = 0;
			if((rateCount1 + rateCount2) != 0){
				rate = (int) Math.round((float) rateCount1 / (rateCount1 + rateCount2) * 100);
			}
			changeRemind.setRate(rate);
			resultList.add(changeRemind);
			changeRemind2.setTypeId(m.getKey());
			changeRemind2.setState("2");
			changeRemind2.setRate(100 - rate);
			resultList.add(changeRemind2);
		}
		map.put("detail", resultList);
		return map;
	}

	public List<ChangeRemindExcel> changeRemindExcel(TagAnalysisQuery tagAnalysisQuery) {
		Map<String, Object> queryMap = getQueryMap();
		queryMap.put("endTime", DateUtils.getCurrentDate());
		if (tagAnalysisQuery.getStartTime() != null && !"".equals(tagAnalysisQuery.getStartTime())){
			queryMap.put("startTime", tagAnalysisQuery.getStartTime());
			queryMap.put("endTime", tagAnalysisQuery.getEndTime());
		}
		if (tagAnalysisQuery.getDataAuth() != null && !"".equals(tagAnalysisQuery.getDataAuth())){
			queryMap.put("dataAuth1", tagAnalysisQuery.getDataAuth());
		}
		List<ChangeRemindSRC> list = mapper.changeRemindTotal(queryMap);
		Map<String, List<ChangeRemindSRC>> map = list.stream()
				.filter(item-> StringUtil.isNotBlank(item.getCustId()))
				.collect(Collectors.groupingBy(ChangeRemindSRC::getCustId));
		List<ChangeRemindExcel> resultList = new ArrayList<>();
		for (Map.Entry<String, List<ChangeRemindSRC>> m : map.entrySet()) {
			List<ChangeRemindSRC> list1 = m.getValue();
			ChangeRemindSRC changeRemindSRC = list1.get(0);
			ChangeRemindExcel changeRemindExcel = new ChangeRemindExcel();
			changeRemindExcel.setCustName(changeRemindSRC.getCustName());
			changeRemindExcel.setFinaningMgrUserName(changeRemindSRC.getFinaningMgrUserName());
			changeRemindExcel.setLoanMgrUserName(changeRemindSRC.getLoanMgrUserName());
			Map<String, List<ChangeRemindSRC>> resultMap = list1.stream()
					.filter(item-> StringUtil.isNotBlank(item.getState()))
					.collect(Collectors.groupingBy(ChangeRemindSRC::getState));
			Integer countOfState0 = 0;
			Integer countOfState1 = 0;
			Integer aging = 0;
			// 已处理
			if (resultMap.get("0") != null && resultMap.get("0").size() > 0) {
				Integer countMT0 = 0;
				Integer countTX0 = 0;
				Integer countOD0 = 0;
				Integer countUD0 = 0;
				List<ChangeRemindSRC> list2 = resultMap.get("0");
				Map<String, List<ChangeRemindSRC>> resultMap1 = list2.stream()
						.filter(item-> StringUtil.isNotBlank(item.getTypeId()))
						.collect(Collectors.groupingBy(ChangeRemindSRC::getTypeId));
				if (resultMap1.get("MT") != null && resultMap1.get("MT").size() > 0){
					for (ChangeRemindSRC obj : resultMap1.get("MT")) {
						countMT0 += obj.getCount();
						countOfState0 += obj.getCount();
						aging += obj.getAging() * obj.getCount();
					}
					changeRemindExcel.setCountMT0(countMT0);
				}
				if (resultMap1.get("TX") != null && resultMap1.get("TX").size() > 0){
					for (ChangeRemindSRC obj : resultMap1.get("TX")) {
						countTX0 += obj.getCount();
						countOfState0 += obj.getCount();
						aging += obj.getAging() * obj.getCount();
					}
					changeRemindExcel.setCountTX0(countTX0);
				}
				if (resultMap1.get("OD") != null && resultMap1.get("OD").size() > 0){
					for (ChangeRemindSRC obj : resultMap1.get("OD")) {
						countOD0 += obj.getCount();
						countOfState0 += obj.getCount();
						aging += obj.getAging() * obj.getCount();
					}
					changeRemindExcel.setCountOD0(countOD0);
				}
				if (resultMap1.get("UD") != null && resultMap1.get("UD").size() > 0){
					for (ChangeRemindSRC obj : resultMap1.get("UD")) {
						countUD0 += obj.getCount();
						countOfState0 += obj.getCount();
						aging += obj.getAging() * obj.getCount();
					}
					changeRemindExcel.setCountUD0(countUD0);
				}
			}
			// 未处理
			if (resultMap.get("2") != null && resultMap.get("2").size() > 0) {
				Integer countMT1 = 0;
				Integer countTX1 = 0;
				Integer countOD1 = 0;
				Integer countUD1 = 0;
				List<ChangeRemindSRC> list2 = resultMap.get("2");
				Map<String, List<ChangeRemindSRC>> resultMap1 = list2.stream()
						.filter(item-> StringUtil.isNotBlank(item.getTypeId()))
						.collect(Collectors.groupingBy(ChangeRemindSRC::getTypeId));
				if (resultMap1.get("MT") != null && resultMap1.get("MT").size() > 0){
					for (ChangeRemindSRC obj : resultMap1.get("MT")) {
						countMT1 += obj.getCount();
						countOfState1 += obj.getCount();
					}
					changeRemindExcel.setCountMT1(countMT1);
				}
				if (resultMap1.get("TX") != null && resultMap1.get("TX").size() > 0){
					for (ChangeRemindSRC obj : resultMap1.get("TX")) {
						countTX1 += obj.getCount();
						countOfState1 += obj.getCount();
					}
					changeRemindExcel.setCountTX1(countTX1);
				}
				if (resultMap1.get("OD") != null && resultMap1.get("OD").size() > 0){
					for (ChangeRemindSRC obj : resultMap1.get("OD")) {
						countOD1 += obj.getCount();
						countOfState1 += obj.getCount();
					}
					changeRemindExcel.setCountOD1(countOD1);
				}
				if (resultMap1.get("UD") != null && resultMap1.get("UD").size() > 0){
					for (ChangeRemindSRC obj : resultMap1.get("UD")) {
						countUD1 += obj.getCount();
						countOfState1 += obj.getCount();
					}
					changeRemindExcel.setCountUD1(countUD1);
				}
			}
			Double countMT0Proportion = (changeRemindExcel.getCountMT0() + changeRemindExcel.getCountMT1()) == 0 ? 0 : (changeRemindExcel.getCountMT0() == 0 ? 0 : (double) changeRemindExcel.getCountMT0() / (changeRemindExcel.getCountMT0() + changeRemindExcel.getCountMT1()) * 100);
			changeRemindExcel.setCountMT0Proportion(countMT0Proportion);
			changeRemindExcel.setCountMT1Proportion(changeRemindExcel.getCountMT1() == 0 ? 0 : (100 - countMT0Proportion));

			Double countOD0Proportion = (changeRemindExcel.getCountOD0() + changeRemindExcel.getCountOD1()) == 0 ? 0 : (changeRemindExcel.getCountOD0() == 0 ? 0 : (double) changeRemindExcel.getCountOD0() / (changeRemindExcel.getCountOD0() + changeRemindExcel.getCountOD1()) * 100);
			changeRemindExcel.setCountOD0Proportion(countOD0Proportion);
			changeRemindExcel.setCountOD1Proportion(changeRemindExcel.getCountOD1() == 0 ? 0 : (100 - countOD0Proportion));

			Double countTX0Proportion = (changeRemindExcel.getCountTX0() + changeRemindExcel.getCountTX1()) == 0 ? 0 : (changeRemindExcel.getCountTX0() == 0 ? 0 : (double) changeRemindExcel.getCountTX0() / (changeRemindExcel.getCountTX0() + changeRemindExcel.getCountTX1()) * 100);
			changeRemindExcel.setCountTX0Proportion(countTX0Proportion);
			changeRemindExcel.setCountTX1Proportion(changeRemindExcel.getCountTX1() == 0 ? 0 : (100 - countTX0Proportion));

			Double countUD0Proportion = (changeRemindExcel.getCountUD0() + changeRemindExcel.getCountUD1()) == 0 ? 0 : (changeRemindExcel.getCountUD0() == 0 ? 0 : (double) changeRemindExcel.getCountUD0() / (changeRemindExcel.getCountUD0() + changeRemindExcel.getCountUD1()) * 100);
			changeRemindExcel.setCountUD0Proportion(countUD0Proportion);
			changeRemindExcel.setCountUD1Proportion(changeRemindExcel.getCountUD1() == 0 ? 0 : (100 - countUD0Proportion));

			changeRemindExcel.setCountOfState0(countOfState0);
			changeRemindExcel.setCountOfState1(countOfState1);
			changeRemindExcel.setCountOfStateTotal(countOfState1 + countOfState0);
			changeRemindExcel.setAging(countOfState0 == 0 ? 0 : Math.round((float) aging/countOfState0));
			Double countOfState0Proportion = (countOfState1 + countOfState0) == 0 ? 0 : (countOfState0 == 0 ? 0 : (double) countOfState0 / (countOfState1 + countOfState0) * 100);
			changeRemindExcel.setCountOfState0Proportion(countOfState0Proportion);
			changeRemindExcel.setCountOfState1Proportion(countOfState1 == 0 ? 0 : (100 - countOfState0Proportion));
			resultList.add(changeRemindExcel);
		}
		Collections.sort(resultList);
		return resultList;
	}

	@Transactional(readOnly = true)
	public List<ChangeRemindInfo> changeRemindInfo(String typeId) {
		Map<String, Object> queryMap = getQueryMap();
		queryMap.put("typeId", typeId);
		return mapper.changeRemindInfo(queryMap);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> todoWork(QueryModel queryModel) {
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> queryMap = getQueryMap();
		if (queryModel.getCondition().get("startTime") != null) {
			queryMap.put("startTime", queryModel.getCondition().get("startTime"));
			queryMap.put("endTime", queryModel.getCondition().get("endTime"));
		}

		List<TodoWorkSRC> list = mapper.todoWorkTotal(queryMap);
		list.addAll(mapper.todoWorkSonTotal(queryMap));
		Map<String, List<TodoWorkSRC>> resultMap = list.stream()
				.filter(item-> StringUtil.isNotBlank(item.getTodoWorkState()))
				.collect(Collectors.groupingBy(TodoWorkSRC::getTodoWorkState));
		Integer count1 = 0;
		Integer count2 = 0;
		// 待跟进
		if (resultMap.get("1") != null && resultMap.get("1").size() > 0) {
			for (TodoWorkSRC obj : resultMap.get("1")) {
				count1 += obj.getCount();
			}
		}
		// 已跟进
		if (resultMap.get("2") != null && resultMap.get("2").size() > 0) {
			for (TodoWorkSRC obj : resultMap.get("2")) {
				count2 += obj.getCount();
			}
		}
		map.put("count1", count1);
		map.put("count2", count2);
		map.put("total", count1 + count2);

		// 待办事项完成情况
		List<TodoWork> resultList2 = new ArrayList<>();
		Map<String, List<TodoWorkSRC>> resultMap1 = list.stream()
				.filter(item-> StringUtil.isNotBlank(item.getTodoWorkType()))
				.collect(Collectors.groupingBy(TodoWorkSRC::getTodoWorkType));
		for (Map.Entry<String, List<TodoWorkSRC>> m : resultMap1.entrySet()) {
			TodoWork todoWork = new TodoWork();
			Integer rateCount1 = 0;
			Integer rateCount2 = 0;
			Integer rateCount3 = 0;
			if (m.getValue().size() != 0) {
				for (TodoWorkSRC obj : m.getValue()) {
					if ("1".equals(obj.getTodoWorkState())) {
						rateCount1 += obj.getCount();
					} else {
						rateCount2 += obj.getCount();
					}
				}
			}
			rateCount3=rateCount1 + rateCount2;
			todoWork.setTodoWorkType(m.getValue().get(0).getTodoWorkType());
			todoWork.setTodoWorkState("2");
			int rate = (int) Math.round((float) rateCount2 / (rateCount3) * 100);
			todoWork.setRate(rate);
			TodoWork todoWork2 = new TodoWork();
			todoWork2.setTodoWorkType(m.getValue().get(0).getTodoWorkType());
			todoWork2.setTodoWorkState("1");
			todoWork2.setRate(100 - rate);
			resultList2.add(todoWork2);
			resultList2.add(todoWork);
		}
		map.put("detail", resultList2);

		queryMap.put("task","isTask");
		List<TodoWorkSRC> list2 = mapper.todoWorkTotal(queryMap);
		list2.addAll(mapper.todoWorkSonTotal(queryMap));

		// 待办跟进率
		String roles = getRoles();
		Map<String, List<TodoWorkSRC>> resultMap2 = null;
		Map<String, List<TodoWorkSRC>> resultMap3 = new HashMap<>();
		if (MGR_ROLE_6.contains(roles)) {
			resultMap2 = list.stream()
					.filter(item-> StringUtil.isNotBlank(item.getUpOrgName()))
					.collect(Collectors.groupingBy(TodoWorkSRC::getUpOrgName));
			resultMap3 = list2.stream()
					.filter(item-> StringUtil.isNotBlank(item.getUpOrgName()))
					.collect(Collectors.groupingBy(TodoWorkSRC::getUpOrgName));
		}else if (MGR_ROLE_7.contains(roles)) {
			resultMap2 = list.stream()
					.filter(item-> StringUtil.isNotBlank(item.getOrgName()))
					.collect(Collectors.groupingBy(TodoWorkSRC::getOrgName));
			resultMap3 = list2.stream()
					.filter(item-> StringUtil.isNotBlank(item.getOrgName()))
					.collect(Collectors.groupingBy(TodoWorkSRC::getOrgName));
		}else if (MGR_ROLE_5.contains(roles)){
			if(((String)queryMap.get("orgCode")).length() > 2){
				resultMap2 = list.stream()
						.filter(item-> StringUtil.isNotBlank(item.getOrgName()))
						.collect(Collectors.groupingBy(TodoWorkSRC::getOrgName));
				resultMap3 = list2.stream()
						.filter(item-> StringUtil.isNotBlank(item.getOrgName()))
						.collect(Collectors.groupingBy(TodoWorkSRC::getOrgName));
			}else {
				resultMap2 = list.stream()
						.filter(item-> StringUtil.isNotBlank(item.getFinisher()))
						.collect(Collectors.groupingBy(TodoWorkSRC::getFinisher));
				resultMap3 = list2.stream()
						.filter(item-> StringUtil.isNotBlank(item.getFinisher()))
						.collect(Collectors.groupingBy(TodoWorkSRC::getFinisher));
			}
		}else if (MGR_ROLE_4.contains(roles) || MGR_ROLE_8.contains(roles)) {
			resultMap2 = list.stream()
					.filter(item-> StringUtil.isNotBlank(item.getFinisher()))
					.collect(Collectors.groupingBy(TodoWorkSRC::getFinisher));
			resultMap3 = list2.stream()
					.filter(item-> StringUtil.isNotBlank(item.getFinisher()))
					.collect(Collectors.groupingBy(TodoWorkSRC::getFinisher));
		}

		List<TodoWorkRate> list1 = new ArrayList<>();
		if (resultMap2 != null) {
			for (Map.Entry<String, List<TodoWorkSRC>> m : resultMap2.entrySet()) {
				TodoWorkRate todoWorkRate = new TodoWorkRate();
				Integer rateCount1 = 0;
				Integer rateCount2 = 0;
				if (m.getValue().size() != 0) {
					for (TodoWorkSRC obj : m.getValue()) {
						if ("1".equals(obj.getTodoWorkState())) {
							rateCount1 += obj.getCount();
						} else {
							rateCount2 += obj.getCount();
						}
					}
				}

				Integer taskRateCount1 = 0;
				Integer taskRateCount2 = 0;
				List<TodoWorkSRC> list3 = resultMap3.get(m.getKey());
				if (list3 != null && list3.size() > 0) {
					for (TodoWorkSRC obj : list3) {
						if ("1".equals(obj.getTodoWorkState())) {
							taskRateCount1 += obj.getCount();
						} else {
							taskRateCount2 += obj.getCount();
						}
					}
				}
				todoWorkRate.setName(m.getKey());
				if (MGR_ROLE_6.contains(roles)) {
					todoWorkRate.setOrgId(m.getValue().get(0).getUpOrgId());
					todoWorkRate.setOrgLevel(m.getValue().get(0).getUpOrgLevel());
				} else if (MGR_ROLE_7.contains(roles)) {
					todoWorkRate.setOrgId(m.getValue().get(0).getOrgId());
					todoWorkRate.setOrgLevel(m.getValue().get(0).getOrgLevel());
				} else if (MGR_ROLE_5.contains(roles)) {
					if (((String) queryMap.get("orgCode")).length() > 2) {
						todoWorkRate.setOrgId(m.getValue().get(0).getOrgId());
						todoWorkRate.setOrgLevel(m.getValue().get(0).getOrgLevel());
					} else {
						todoWorkRate.setCreatorId(m.getValue().get(0).getCreatorId());
					}
				} else if (MGR_ROLE_4.contains(roles) || MGR_ROLE_8.contains(roles)) {
					todoWorkRate.setCreatorId(m.getValue().get(0).getCreatorId());
				}
				if ((rateCount1 + rateCount2) != 0) {
					todoWorkRate.setRate((int) Math.round((float) rateCount2 / (rateCount1 + rateCount2) * 100));
				} else {
					todoWorkRate.setRate(0);
				}
				if ((taskRateCount1 + taskRateCount2) != 0) {
					todoWorkRate.setTaskRate((int) Math.round((float) taskRateCount2 / (taskRateCount1 + taskRateCount2) * 100));
				} else {
					todoWorkRate.setTaskRate(0);
				}
				list1.add(todoWorkRate);
			}
		}
		// 排序
		Collections.sort(list1);
		// 添加名次
		for (int i = 0; i < list1.size(); i++) {
			list1.get(i).setRank(i + 1);
		}
		map.put("rateList", list1);
		return map;
	}

	public List<TodoWorkExcel> todoWorkExcel(TagAnalysisQuery tagAnalysisQuery) {
		Map<String, Object> queryMap = getQueryMap();
		if (tagAnalysisQuery.getStartTime() != null && !"".equals(tagAnalysisQuery.getStartTime())){
			queryMap.put("startTime", tagAnalysisQuery.getStartTime());
			queryMap.put("endTime", tagAnalysisQuery.getEndTime());
		}
		if (tagAnalysisQuery.getDataAuth() != null && !"".equals(tagAnalysisQuery.getDataAuth())){
			queryMap.put("dataAuth1", tagAnalysisQuery.getDataAuth());
		}
		List<TodoWorkSRC> list = mapper.todoWorkTotal(queryMap);
		list.addAll(mapper.todoWorkSonTotal(queryMap));
		queryMap.put("task","isTask");
		List<TodoWorkSRC> list1 = mapper.todoWorkTotal(queryMap);
		list1.addAll(mapper.todoWorkSonTotal(queryMap));

		Map<String, List<TodoWorkSRC>> map = list.stream()
				.filter(item-> StringUtil.isNotBlank(item.getFinisher()))
				.collect(Collectors.groupingBy(TodoWorkSRC::getFinisher));
		Map<String, List<TodoWorkSRC>> map1 = list1.stream()
				.filter(item-> StringUtil.isNotBlank(item.getFinisher()))
				.collect(Collectors.groupingBy(TodoWorkSRC::getFinisher));

		List<TodoWorkExcel> resultList = new ArrayList<>();
		for (Map.Entry<String, List<TodoWorkSRC>> m : map.entrySet()) {
			List<TodoWorkSRC> list2 = m.getValue();
			TodoWorkSRC todoWorkSRC = list2.get(0);
			TodoWorkExcel todoWorkExcel = new TodoWorkExcel();
			todoWorkExcel.setCreatorName(todoWorkSRC.getCreatorName());
			todoWorkExcel.setOrgId(todoWorkSRC.getOrgId());
			todoWorkExcel.setOrgName(todoWorkSRC.getOrgName());
			if ("3".equals(todoWorkSRC.getOrgLevel())){
				todoWorkExcel.setUpOrgName(todoWorkSRC.getUpOrgName());
				todoWorkExcel.setUpOrgId(todoWorkSRC.getUpOrgId());
			}else if ("2".equals(todoWorkSRC.getOrgLevel())){
				todoWorkExcel.setUpOrgName("东亚中国总行");
				todoWorkExcel.setUpOrgId("500");
			}
			Map<String, List<TodoWorkSRC>> map2 = list2.stream()
					.filter(item-> StringUtil.isNotBlank(item.getTodoWorkState()))
					.collect(Collectors.groupingBy(TodoWorkSRC::getTodoWorkState));
			//待跟进
			Integer countOfState1 = 0;
			Integer countOfType1 = 0;
			Integer countOfType2 = 0;
			Integer countOfType3 = 0;
			Integer countOfType4 = 0;
			Integer countOfType5 = 0;
			if (map2.get("1") != null && map2.get("1").size() > 0){
				List<TodoWorkSRC> list3 = map2.get("1");
				Map<String, List<TodoWorkSRC>> map3 = list3.stream()
						.filter(item-> StringUtil.isNotBlank(item.getTodoWorkType()))
						.collect(Collectors.groupingBy(TodoWorkSRC::getTodoWorkType));
				//商机
				if (map3.get("1") != null && map3.get("1").size() > 0){
					for (TodoWorkSRC ts: map3.get("1")) {
						countOfState1 += ts.getCount();
						countOfType1 += ts.getCount();
					}
					todoWorkExcel.setCountOfType1(countOfType1);
				}
				//外访
				if (map3.get("2") != null && map3.get("2").size() > 0){
					for (TodoWorkSRC ts: map3.get("2")) {
						countOfState1 += ts.getCount();
						countOfType2 += ts.getCount();
					}
					todoWorkExcel.setCountOfType2(countOfType2);
				}
				//培训\会议
				if (map3.get("3") != null && map3.get("3").size() > 0){
					for (TodoWorkSRC ts: map3.get("3")) {
						countOfState1 += ts.getCount();
						countOfType3 += ts.getCount();
					}
					todoWorkExcel.setCountOfType3(countOfType3);
				}
				//材料整理
				if (map3.get("4") != null && map3.get("4").size() > 0){
					for (TodoWorkSRC ts: map3.get("4")) {
						countOfState1 += ts.getCount();
						countOfType4 += ts.getCount();
					}
					todoWorkExcel.setCountOfType4(countOfType4);
				}
				//客户跟进
				if (map3.get("5") != null && map3.get("5").size() > 0){
					for (TodoWorkSRC ts: map3.get("5")) {
						countOfState1 += ts.getCount();
						countOfType5 += ts.getCount();
					}
					todoWorkExcel.setCountOfType5(countOfType5);
				}
			}
			//已跟进
			Integer countOfState2 = 0;
			Integer countOfType6 = 0;
			Integer countOfType7 = 0;
			Integer countOfType8 = 0;
			Integer countOfType9 = 0;
			Integer countOfType10 = 0;
			if (map2.get("2") != null && map2.get("2").size() > 0){
				List<TodoWorkSRC> list3 = map2.get("2");
				Map<String, List<TodoWorkSRC>> map3 = list3.stream()
						.filter(item-> StringUtil.isNotBlank(item.getTodoWorkType()))
						.collect(Collectors.groupingBy(TodoWorkSRC::getTodoWorkType));
				//商机
				if (map3.get("1") != null && map3.get("1").size() > 0){
					for (TodoWorkSRC ts: map3.get("1")) {
						countOfState2 += ts.getCount();
						countOfType6 += ts.getCount();
					}
					todoWorkExcel.setCountOfType6(countOfType6);
				}
				//外访
				if (map3.get("2") != null && map3.get("2").size() > 0){
					for (TodoWorkSRC ts: map3.get("2")) {
						countOfState2 += ts.getCount();
						countOfType7 += ts.getCount();
					}
					todoWorkExcel.setCountOfType7(countOfType7);
				}
				//培训\会议
				if (map3.get("3") != null && map3.get("3").size() > 0){
					for (TodoWorkSRC ts: map3.get("3")) {
						countOfState2 += ts.getCount();
						countOfType8 += ts.getCount();
					}
					todoWorkExcel.setCountOfType8(countOfType8);
				}
				//材料整理
				if (map3.get("4") != null && map3.get("4").size() > 0){
					for (TodoWorkSRC ts: map3.get("4")) {
						countOfState2 += ts.getCount();
						countOfType9 += ts.getCount();
					}
					todoWorkExcel.setCountOfType9(countOfType9);
				}
				//客户跟进
				if (map3.get("5") != null && map3.get("5").size() > 0){
					for (TodoWorkSRC ts: map3.get("5")) {
						countOfState2 += ts.getCount();
						countOfType10 += ts.getCount();
					}
					todoWorkExcel.setCountOfType10(countOfType10);
				}
			}
            todoWorkExcel.setCountOfState1(countOfState1);
            todoWorkExcel.setCountOfState2(countOfState2);
			todoWorkExcel.setCountOfStateTotal(countOfState1 + countOfState2);
			Double countOfState1Proportion = (countOfState1 + countOfState2) == 0 ? 0 : (countOfState1 == 0 ? 0 : (double)  countOfState1 / (countOfState1 + countOfState2) * 100);
			todoWorkExcel.setCountOfState1Proportion(countOfState1Proportion);
			todoWorkExcel.setRate(countOfState2 == 0 ? 0 : 100 - countOfState1Proportion);
			todoWorkExcel.setCountOfState2Proportion(countOfState2 == 0 ? 0 : (100 - countOfState1Proportion));
			Double countOfType1Proportion = (countOfType6 + countOfType1) == 0 ? 0 : (countOfType1 == 0 ? 0 : (double)  countOfType1 / (countOfType6 + countOfType1) * 100);
			todoWorkExcel.setCountOfType1Proportion(countOfType1Proportion);
			todoWorkExcel.setCountOfType6Proportion(countOfType6 == 0 ? 0 : 100 - countOfType1Proportion);
			Double countOfType2Proportion = (countOfType2 + countOfType7) == 0 ? 0 : (countOfType2 == 0 ? 0 : (double)  countOfType2/(countOfType2 + countOfType7) * 100);
			todoWorkExcel.setCountOfType2Proportion(countOfType2Proportion);
			todoWorkExcel.setCountOfType7Proportion(countOfType7 == 0 ? 0 : (100 - countOfType2Proportion));
			Double countOfType3Proportion = (countOfType3 + countOfType8) == 0 ? 0 : (countOfType3 == 0 ? 0 : (double)  countOfType3/(countOfType3 + countOfType8) * 100);
			todoWorkExcel.setCountOfType3Proportion(countOfType3Proportion);
			todoWorkExcel.setCountOfType8Proportion(countOfType8 == 0 ? 0 : 100 - countOfType3Proportion);
			Double countOfType4Proportion = (countOfType4 + countOfType9) == 0 ? 0 : (countOfType4 == 0 ? 0 : (double) countOfType4/(countOfType4 + countOfType9) * 100);
			todoWorkExcel.setCountOfType4Proportion(countOfType4Proportion);
			todoWorkExcel.setCountOfType9Proportion(countOfType9 == 0 ? 0 : (100 - countOfType4Proportion));
			Double countOfType5Proportion = (countOfType5 + countOfType10) == 0 ? 0 : (countOfType5 == 0 ? 0 : (double) countOfType5 / (countOfType5 + countOfType10) * 100);
			todoWorkExcel.setCountOfType5Proportion(countOfType5Proportion);
			todoWorkExcel.setCountOfType10Proportion(countOfType10 == 0 ? 0 : (100 - countOfType5Proportion));
			List<TodoWorkSRC> list3 = map1.get(m.getKey());
			if (list3 != null && list3.size() > 0){
				Map<String, List<TodoWorkSRC>> map3 = list3.stream()
						.collect(Collectors.groupingBy(TodoWorkSRC::getTodoWorkState));
				Integer taskCountOfState1 = 0;
				if (map3.get("1") != null && map3.get("1").size() >0){
					for (TodoWorkSRC ts: map3.get("1")) {
						taskCountOfState1 += ts.getCount();
					}
				}
				Integer taskCountOfState2 = 0;
				if (map3.get("2") != null && map3.get("2").size() >0){
					for (TodoWorkSRC ts: map3.get("2")) {
						taskCountOfState2 += ts.getCount();
					}
				}
				Double taskRate = (taskCountOfState1 + taskCountOfState2) == 0 ? 0 :  (taskCountOfState2 == 0 ? 0 : (double) taskCountOfState2 / (taskCountOfState1 + taskCountOfState2) * 100);
				todoWorkExcel.setTaskRate(taskRate);
			}

			resultList.add(todoWorkExcel);
		}
		// 排序
		Collections.sort(resultList);
		// 添加名次
		for (int i = 0; i < resultList.size(); i++) {
			resultList.get(i).setRank(i + 1);
		}
		return resultList;
	}

	@Transactional(readOnly = true)
	public List<TodoWorkInfo> todoWorkInfo(String type) {
		Map<String, Object> queryMap = getQueryMap();
		queryMap.put("type", type);
		return mapper.todoWorkInfo(queryMap);
	}

	@Transactional(readOnly = true)
	public List todoWorkDetail(QueryModel queryModel) {
		Map<String, Object> queryMap = getQueryMap();
		if (queryModel.getCondition().get("startTime") != null) {
			queryMap.put("startTime", queryModel.getCondition().get("startTime"));
			queryMap.put("endTime", queryModel.getCondition().get("endTime"));
		}
		String orgLevel = (String) queryModel.getCondition().get("orgLevel");
		queryMap.put("orgCode", queryModel.getCondition().get("orgId"));
		if ("2".equals(orgLevel) || "1".equals(orgLevel)){
			List<TodoWorkRate> list = new ArrayList();
			List<TodoWorkRate> list1 = mapper.subBranchTodoWorkRate(queryMap);
			list1.addAll(mapper.subBranchTodoWorkSonRate(queryMap));
			Map<String, List<TodoWorkRate>> map = list1.stream()
					.filter(item-> StringUtil.isNotBlank(item.getName())).collect(Collectors.groupingBy(TodoWorkRate::getName));
			for (Map.Entry<String, List<TodoWorkRate>> m : map.entrySet()) {
				TodoWorkRate todoWorkRate_1 = new TodoWorkRate();
				Integer count = 0;
				Integer count2 = 0;
				if (m.getValue().size() != 0) {
					for (TodoWorkRate obj : m.getValue()) {
						if ("1".equals(obj.getTodoWorkState())) {
							count += obj.getCount();
						}
						if ("2".equals(obj.getTodoWorkState())) {
							count2 += obj.getCount();
						}
					}
				}
				todoWorkRate_1.setRate((int)Math.round((float) count2/(count+count2) * 100));
				todoWorkRate_1.setName(m.getKey());
				todoWorkRate_1.setOrgId(m.getValue().get(0).getOrgId());
				todoWorkRate_1.setOrgLevel(m.getValue().get(0).getOrgLevel());
				todoWorkRate_1.setCreatorId(m.getValue().get(0).getCreatorId());
				todoWorkRate_1.setTodoWorkState("1");
				todoWorkRate_1.setCount(count);
				list.add(todoWorkRate_1);
			}
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++){
				list.get(i).setRank(i + 1);
			}
			return list;
		}else {
			List<TodoWorkInfo> list = new ArrayList();
			queryMap.put("creatorId", queryModel.getCondition().get("creatorId"));
			list = mapper.todoWorkDetail(queryMap);
			list.addAll(mapper.todoWorkSonDetail(queryMap));
			Collections.sort(list, new Comparator<TodoWorkInfo>() {
				@Override
				public int compare(TodoWorkInfo o1, TodoWorkInfo o2) {
					return o1.getTodoWorkState().compareTo(o2.getTodoWorkState());
				}
			});
			for (int i = 0;i < list.size();i++){
				list.get(i).setTodoWorkId(String.valueOf(i+1));
			}
			return list;
		}
	}

	@Transactional(readOnly = true)
	public Map<String, Object> workReport(QueryModel queryModel) {
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> queryMap = getQueryMap();
		if (queryModel.getCondition().get("startTime") != null) {
			queryMap.put("startTime", queryModel.getCondition().get("startTime"));
			queryMap.put("endTime", queryModel.getCondition().get("endTime"));
		}
		List<WorkReportSRC> list = mapper.workReportTotal(queryMap);


		Map<String, List<WorkReportSRC>> resultMap = list.stream()
				.filter(item-> StringUtil.isNotBlank(item.getWorkReportBusiType()))
				.collect(Collectors.groupingBy(WorkReportSRC::getWorkReportBusiType));
		//日报
		Integer count1 = 0;
		if (resultMap.get("1") != null && resultMap.get("1").size() > 0) {
			Map<String, List<WorkReportSRC>> resultMap1 = resultMap.get("1").stream()
					.filter(item-> StringUtil.isNotBlank(item.getWorkSummary()))
					.collect(Collectors.groupingBy(WorkReportSRC::getWorkSummary));
			List<WorkReport> contenType = new ArrayList<>();
			for (Map.Entry<String, List<WorkReportSRC>> m : resultMap1.entrySet()) {
				//workSummary 1
				if (m.getKey().contains("1") && m.getValue().size() > 0){
					Integer count1_1 = 0;
					for (WorkReportSRC obj : m.getValue()){
						count1_1 += obj.getCount();
						count1 += obj.getCount();
					}
					WorkReport contenType1 = new WorkReport();
					contenType1.setWorkSummary("1");
					contenType1.setCount(count1_1);
					contenType.add(contenType1);
				}
				//workSummary 2
				if (m.getKey().contains("2") && m.getValue().size() > 0){
					Integer count1_2 = 0;
					for (WorkReportSRC obj : m.getValue()){
						count1_2 += obj.getCount();
						count1 += obj.getCount();
					}
					WorkReport contenType2 = new WorkReport();
					contenType2.setWorkSummary("2");
					contenType2.setCount(count1_2);
					contenType.add(contenType2);
				}
				//workSummary 3
				if (m.getKey().contains("3") && m.getValue().size() > 0){
					Integer count1_3 = 0;
					for (WorkReportSRC obj : m.getValue()){
						count1_3 += obj.getCount();
						count1 += obj.getCount();
					}
					WorkReport contenType3 = new WorkReport();
					contenType3.setWorkSummary("3");
					contenType3.setCount(count1_3);
					contenType.add(contenType3);
				}
				//workSummary 4
				if (m.getKey().contains("4") && m.getValue().size() > 0){
					Integer count1_4 = 0;
					for (WorkReportSRC obj : m.getValue()){
						count1_4 += obj.getCount();
						count1 += obj.getCount();
					}
					WorkReport contenType4 = new WorkReport();
					contenType4.setWorkSummary("4");
					contenType4.setCount(count1_4);
					contenType.add(contenType4);
				}
				//workSummary 5
				if (m.getKey().contains("5") && m.getValue().size() > 0){
					Integer count1_5 = 0;
					for (WorkReportSRC obj : m.getValue()){
						count1_5 += obj.getCount();
						count1 += obj.getCount();
					}
					WorkReport contenType5 = new WorkReport();
					contenType5.setWorkSummary("5");
					contenType5.setCount(count1_5);
					contenType.add(contenType5);
				}
			}
			map.put("contentType", contenType);
		}
		//周报
		Integer count2 = 0;
		if(resultMap.get("2") != null  && resultMap.get("2").size() > 0){
			for (WorkReportSRC obj : resultMap.get("2")) {
				count2 += obj.getCount();
			}
		}
		//月报
		Integer count3 = 0;
		if(resultMap.get("3") != null  && resultMap.get("3").size() > 0){
			for (WorkReportSRC obj : resultMap.get("3")) {
				count3 += obj.getCount();
			}
		}
		List<WorkReport> workReportType = new ArrayList<>();
 		WorkReport workReportType1 = new WorkReport();
		workReportType1.setWorkReportBusiType("1");
		workReportType1.setCount(count1);
		workReportType.add(workReportType1);
		WorkReport workReportType2 = new WorkReport();
		workReportType2.setWorkReportBusiType("2");
		workReportType2.setCount(count2);
		workReportType.add(workReportType2);
		WorkReport workReportType3 = new WorkReport();
		workReportType3.setWorkReportBusiType("3");
		workReportType3.setCount(count3);
		workReportType.add(workReportType3);
		map.put("workReportType", workReportType);
		return map;
	}

	public List<WorkReportExcel> workReportExcel(TagAnalysisQuery tagAnalysisQuery) {
		Map<String, Object> queryMap = getQueryMap();
		if (tagAnalysisQuery.getStartTime() != null && !"".equals(tagAnalysisQuery.getStartTime())){
			queryMap.put("startTime", tagAnalysisQuery.getStartTime());
			queryMap.put("endTime", tagAnalysisQuery.getEndTime());
		}
		if (tagAnalysisQuery.getDataAuth() != null && !"".equals(tagAnalysisQuery.getDataAuth())){
			queryMap.put("dataAuth1", tagAnalysisQuery.getDataAuth());
		}
		List<WorkReportSRC> list = mapper.workReportTotal(queryMap);
		List<WorkReportExcel> resultList = new ArrayList<>();
		Map<String, List<WorkReportSRC>> map = list.stream()
				.filter(item-> StringUtil.isNotBlank(item.getCreator()))
				.collect(Collectors.groupingBy(WorkReportSRC::getCreator));
		for (Map.Entry<String, List<WorkReportSRC>> m : map.entrySet()) {
			List<WorkReportSRC> list1 = m.getValue();
			WorkReportSRC workReportSRC = list1.get(0);
			WorkReportExcel workReportExcel = new WorkReportExcel();
			workReportExcel.setCreatorName(workReportSRC.getCreatorName());
			workReportExcel.setOrgName(workReportSRC.getOrgName());
			workReportExcel.setOrgId(workReportSRC.getOrgId());
			if ("3".equals(workReportSRC.getOrgLevel())){
				workReportExcel.setUpOrgName(workReportSRC.getUpOrgName());
				workReportExcel.setUpOrgId(workReportSRC.getUpOrgId());
			}else if ("2".equals(workReportSRC.getOrgLevel())){
				workReportExcel.setUpOrgName("东亚中国总行");
				workReportExcel.setUpOrgId("500");
			}
			Map<String, List<WorkReportSRC>> map1 = list1.stream()
					.filter(item-> StringUtil.isNotBlank(item.getWorkReportBusiType()))
					.collect(Collectors.groupingBy(WorkReportSRC::getWorkReportBusiType));
			Integer count1 = 0;
			if (map1.get("1") != null && map1.get("1").size() > 0){
				Map<String, List<WorkReportSRC>> map2 = map1.get("1").stream()
						.filter(item-> StringUtil.isNotBlank(item.getWorkSummary()))
						.collect(Collectors.groupingBy(WorkReportSRC::getWorkSummary));
				Integer count4 = 0;
				Integer count5 = 0;
				Integer count6 = 0;
				Integer count7 = 0;
				Integer count8 = 0;
				for (Map.Entry<String, List<WorkReportSRC>> m2 : map2.entrySet()) {
					//workSummary 1
					if (m2.getKey().contains("1") && m2.getValue().size() > 0){
						for (WorkReportSRC obj : m2.getValue()){
							count7 += obj.getCount();
							count1 += obj.getCount();
						}
					}
					//workSummary 2
					if (m2.getKey().contains("2") && m2.getValue().size() > 0){
						for (WorkReportSRC obj : m2.getValue()){
							count4 += obj.getCount();
							count1 += obj.getCount();
						}
					}
					//workSummary 3
					if (m2.getKey().contains("3") && m2.getValue().size() > 0){
						for (WorkReportSRC obj : m2.getValue()){
							count6 += obj.getCount();
							count1 += obj.getCount();
						}
					}
					//workSummary 4
					if (m2.getKey().contains("4") && m2.getValue().size() > 0){
						for (WorkReportSRC obj : m2.getValue()){
							count5 += obj.getCount();
							count1 += obj.getCount();
						}
					}
					//workSummary 5
					if (m2.getKey().contains("5") && m2.getValue().size() > 0){
						for (WorkReportSRC obj : m2.getValue()){
							count8 += obj.getCount();
							count1 += obj.getCount();
						}
					}
				}
				workReportExcel.setCount4(count4);
				workReportExcel.setCount5(count5);
				workReportExcel.setCount6(count6);
				workReportExcel.setCount7(count7);
				workReportExcel.setCount8(count8);
			}

			Integer count2 = 0;
			if (map1.get("2") != null && map1.get("2").size() > 0){
				for (WorkReportSRC wrs: map1.get("2")) {
					count2 += wrs.getCount();
				}
			}
			Integer count3 = 0;
			if (map1.get("3") != null && map1.get("3").size() > 0){
				for (WorkReportSRC wrs: map1.get("3")) {
					count3 += wrs.getCount();
				}
			}
			workReportExcel.setCount1(count1);
			workReportExcel.setCount2(count2);
			workReportExcel.setCount3(count3);
			resultList.add(workReportExcel);
		}
		Collections.sort(resultList);
		return resultList;
	}

	@Transactional(readOnly = true)
	public List<WorkReportInfo> workReportInfo(String type) {
		Map<String, Object> queryMap = getQueryMap();
		queryMap.put("type", type);
		return mapper.workReportInfo(queryMap);
	}

	private int changeRate(Map<String, Object> queryMap) {
		// 已处理
		if(queryMap.get("endTime") == null){
			queryMap.put("endTime",DateUtils.getCurrentDate());
		}
		queryMap.put("state", 0);
		Integer count2 = mapper.changeCount(queryMap);
		count2 = count2 == null ? 0 : count2;
		// 未处理
		queryMap.put("state", 2);
		Integer count3 = mapper.changeCount(queryMap);
		count3 = count3 == null ? 0 : count3;
		if ((count2 + count3) == 0){
			return 0;
		}else {
			return (int) Math.round((float) count2 / (count2 + count3) * 100);
		}
	}

	private int todoWorkRate(Map<String, Object> queryMap) {
		// 待跟进
		queryMap.put("state", 1);
		Integer count2 = 0;
		count2 += mapper.todoWorkCount(queryMap);
		count2 += mapper.todoWorkSonCount(queryMap);
		// 已跟进
		queryMap.put("state", 2);
		Integer count3 = 0;
		count3 += mapper.todoWorkCount(queryMap);
		count3 += mapper.todoWorkSonCount(queryMap);
		if ((count2 + count3) == 0){
			return 0;
		}else {
			return (int) Math.round((float) count3 / (count2 + count3) * 100);
		}
	}

	public void export(HttpServletResponse response, TagAnalysisQuery tagAnalysisQuery) throws IOException {
		this.Role = tagAnalysisQuery.getSelectRole();
		if (MGR_ROLE_5.contains(this.Role) || MGR_ROLE_6.contains(this.Role) || MGR_ROLE_7.contains(this.Role) ){
			tagAnalysisQuery.setDataAuth("AND T.ORG_ID IN (SELECT ORG_ID FROM ADMIN_SM_ORG START WITH ORG_ID = #{orgCode} CONNECT BY PRIOR ORG_ID = UP_ORG_ID)");
		}else if (MGR_ROLE_4.contains(this.Role) ){
			tagAnalysisQuery.setDataAuth("AND T.CREATOR_ID IN (SELECT DISTINCT USER_ID FROM OCRM_F_CM_TEAM_CUST_MANAGER WHERE MKT_TEAM_ID IN (SELECT MKT_TEAM_ID FROM OCRM_F_CM_MKT_TEAM WHERE TEAM_LEADER_ID = #{userCOde}))");
		}else if(MGR_ROLE_8.contains(this.Role) ){
			tagAnalysisQuery.setDataAuth("AND　T.CREATOR_ID = #{userCode}");
		}
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		// 这里URLEncoder.encode可以防止中文乱码
		String fileName = URLEncoder.encode("活动量监测", "UTF-8").replaceAll("\\+", "%20");
		response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", DateUtils.getCurrentDate());
		String templateFileName = "templates" + File.separator + "activitymonitoring_templat.xlsx";
		ExcelWriter excelWriter = null;

		excelWriter = EasyExcel.write(response.getOutputStream())
				.withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();
		WriteSheet writeSheet1 = EasyExcel.writerSheet(0, "活动数据概览数据导出").build();
		WriteSheet writeSheet2 = EasyExcel.writerSheet(1, "客户经理概况数据导出").build();
		WriteSheet writeSheet3 = EasyExcel.writerSheet(2, "管户概况数据导出").build();
		WriteSheet writeSheet4 = EasyExcel.writerSheet(3, "客户接触情况数据导出").build();
		WriteSheet writeSheet5 = EasyExcel.writerSheet(4, "异动提醒情况汇总数据导出").build();
		WriteSheet writeSheet6 = EasyExcel.writerSheet(5, "待办事项情况数据导出").build();
		WriteSheet writeSheet7 = EasyExcel.writerSheet(6, "工作报告情况数据导出").build();
		// 填充集合 data
		String startTime = DateUtils.getLastMonthStartTime();
		String endTime = DateUtils.getCurrentDate();
		if (tagAnalysisQuery.getStartTime() != null && !"".equals(tagAnalysisQuery.getStartTime())){
			startTime = tagAnalysisQuery.getStartTime();
			endTime = tagAnalysisQuery.getEndTime();
		}
		map.put("timeBucket", startTime + "-" + endTime);
		excelWriter.fill(map, writeSheet1);
		Map<String,Object> rMap = dataOverview();
		Map<String,Object> map1 = new HashMap<>();
		for (Map.Entry<String,Object> m : rMap.entrySet()) {
			ActiveIndex ai = (ActiveIndex)m.getValue();
			map1.put(m.getKey(),ai == null ? "0" : ai.getNum());
		}
		excelWriter.fill(map1, writeSheet1);
		excelWriter.fill(map, writeSheet2);
		excelWriter.fill(custManagerOverview(), writeSheet2);
		excelWriter.fill(map, writeSheet3);
		List<BelongInfo> list = belongOverview(null);
		excelWriter.fill(list, writeSheet3);
		excelWriter.fill(map, writeSheet4);
		excelWriter.fill(touchCustInfoExcel(tagAnalysisQuery), writeSheet4);
		excelWriter.fill(map, writeSheet5);
		excelWriter.fill(changeRemindExcel(tagAnalysisQuery), writeSheet5);
		excelWriter.fill(map, writeSheet6);
		excelWriter.fill(todoWorkExcel(tagAnalysisQuery), writeSheet6);
		excelWriter.fill(map, writeSheet7);
		excelWriter.fill(workReportExcel(tagAnalysisQuery), writeSheet7);
		// 关闭流
		excelWriter.finish();
	}

}
