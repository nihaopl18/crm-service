package cn.com.yusys.yusp.dycrm.todowork.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.RemindInfo;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.service.RemindInfoService;
import cn.com.yusys.yscrm.pcrm.common.util.ExcelFillCellMergeStrategy;
import cn.com.yusys.yusp.dycrm.todowork.domain.TodoWorkExcle;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.dycrm.todowork.domain.OcrmFwpTodoWork;
import cn.com.yusys.yusp.dycrm.todowork.domain.OcrmFwpTodoWorkSon;
import cn.com.yusys.yusp.dycrm.todowork.repository.mapper.OcrmFwpTodoWorkMapper;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @version 1.0.0
 * @项目名称: dycrm-todowork模块
 * @类名称: OcrmFwpTodoWorkService
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
public class OcrmFwpTodoWorkService extends CommonService {
	@Autowired
	private OcrmFwpTodoWorkMapper ocrmFwpTodoWorkMapper;

	@Autowired
	private OcrmFwpTodoWorkSonService ocrmFwpTodoWorkSonService;

	@Autowired
	private TodoworkAndCustContactService todoworkAndCustContactService;

	@Autowired
	private RemindInfoService remindInfoService;

	@Autowired
	private UaaClient uaaClient;

	@Override
	protected CommonMapper<?> getMapper() {
		return ocrmFwpTodoWorkMapper;
	}

	/**
	 * @方法名称: addOneTodoWork
	 * @方法描述: 新增一次性待办事项
	 * @参数与返回说明:
	 * @算法描述: 新增待办事项表
	 */
	public int addOneTodoWork(OcrmFwpTodoWork ocrmFwpTodoWork) {
		// TODO 增加异常处理
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		if (ocrmFwpTodoWork.getCreatorId() == null || "".equals(ocrmFwpTodoWork.getCreatorId())) {
			ocrmFwpTodoWork.setCreatorId(dto.getBody().getLoginCode());
		}
		if (ocrmFwpTodoWork.getCreatorName() == null || "".equals(ocrmFwpTodoWork.getCreatorName())) {
			ocrmFwpTodoWork.setCreatorName(dto.getBody().getUserName());
		}
		if (ocrmFwpTodoWork.getCreatorOrgId() == null || "".equals(ocrmFwpTodoWork.getCreatorOrgId())) {
			ocrmFwpTodoWork.setCreatorOrgId(dto.getBody().getOrg().getId());
		}
		if (ocrmFwpTodoWork.getCreatorOrgName() == null || "".equals(ocrmFwpTodoWork.getCreatorOrgName())) {
			ocrmFwpTodoWork.setCreatorOrgName(dto.getBody().getOrg().getName());
		}
		if (ocrmFwpTodoWork.getIsDelete() == null || "".equals(ocrmFwpTodoWork.getIsDelete())) {
			ocrmFwpTodoWork.setIsDelete("N");
		}

		if (ocrmFwpTodoWork.getCreateDate() == null) {
			ocrmFwpTodoWork.setCreateDate(new Date());
		}
		if (ocrmFwpTodoWork.getTodoWorkState() == null || "".equals(ocrmFwpTodoWork.getTodoWorkState())) {
			ocrmFwpTodoWork.setTodoWorkState("1");
		}
		if (ocrmFwpTodoWork.getIsNotice() == null || "".equals(ocrmFwpTodoWork.getIsNotice())) {
			ocrmFwpTodoWork.setIsNotice("N");
		}
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		try {
			if (ocrmFwpTodoWork.getCreateDate() != null) {
				time = s.format(ocrmFwpTodoWork.getCreateDate());
				ocrmFwpTodoWork.setCreateDate(s.parse(time));
			}
			if (ocrmFwpTodoWork.getStartDate() != null) {
				time = s.format(ocrmFwpTodoWork.getStartDate());
				ocrmFwpTodoWork.setStartDate(s.parse(time));
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		int result = 0;
		if (ocrmFwpTodoWork.getFinisher() != null || !"".equals(ocrmFwpTodoWork.getFinisher())) {
			String[] finishers = ocrmFwpTodoWork.getFinisher().split(";");
			List<RemindInfo> list = new ArrayList<>();
			for (int i = 0; i < finishers.length; i++) {
				ocrmFwpTodoWork.setFinisher(finishers[i]);
				ocrmFwpTodoWork.setTodoWorkId(getUuid());
				if (ocrmFwpTodoWork.getFinisher().indexOf(ocrmFwpTodoWork.getCreatorId()) == -1){
					list.add(addRemindInfo(ocrmFwpTodoWork));
				}
				result += this.insertSelective(ocrmFwpTodoWork);
			}
			remindInfoService.addlist(list);
			return result;
		}
		result = this.insertSelective(ocrmFwpTodoWork);
		return result;
	}

	private RemindInfo addRemindInfo(OcrmFwpTodoWork ocrmFwpTodoWork) {
		RemindInfo acrmFwpRemindInfo = new RemindInfo();
		acrmFwpRemindInfo.setBusiId(ocrmFwpTodoWork.getTodoWorkId());
		acrmFwpRemindInfo.setReceUserId(ocrmFwpTodoWork.getFinisher().split("/")[0]);
		acrmFwpRemindInfo.setReceUserName(ocrmFwpTodoWork.getFinisher().split("/")[1]);
		acrmFwpRemindInfo.setRemindClass("APP");
		acrmFwpRemindInfo.setRemindType("APP-01");
		acrmFwpRemindInfo.setInfoText("【"+ocrmFwpTodoWork.getCreatorName()+ "/" +ocrmFwpTodoWork.getCreatorId()+"】下发了一条待办，请关注！");
		return acrmFwpRemindInfo;
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

	/**
	 * @方法名称: addCyCleTodoWork
	 * @方法描述: 新增周期性待办事项
	 * @参数与返回说明:
	 * @算法描述: 新增待办事项表
	 */
	public int addCyCleTodoWork(OcrmFwpTodoWork ocrmFwpTodoWork) {
		// TODO 增加异常处理
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		if (ocrmFwpTodoWork.getCreatorId() == null || "".equals(ocrmFwpTodoWork.getCreatorId())) {
			ocrmFwpTodoWork.setCreatorId(dto.getBody().getLoginCode());
		}
		if (ocrmFwpTodoWork.getCreatorName() == null || "".equals(ocrmFwpTodoWork.getCreatorName())) {
			ocrmFwpTodoWork.setCreatorName(dto.getBody().getUserName());
		}
		if (ocrmFwpTodoWork.getCreatorOrgId() == null || "".equals(ocrmFwpTodoWork.getCreatorOrgId())) {
			ocrmFwpTodoWork.setCreatorOrgId(dto.getBody().getOrg().getId());
		}
		if (ocrmFwpTodoWork.getCreatorOrgName() == null || "".equals(ocrmFwpTodoWork.getCreatorOrgName())) {
			ocrmFwpTodoWork.setCreatorOrgName(dto.getBody().getOrg().getName());
		}
		if (ocrmFwpTodoWork.getIsDelete() == null || "".equals(ocrmFwpTodoWork.getIsDelete())) {
			ocrmFwpTodoWork.setIsDelete("N");
		}

		if (ocrmFwpTodoWork.getCreateDate() == null) {
			ocrmFwpTodoWork.setCreateDate(new Date());
		}
		if (ocrmFwpTodoWork.getTodoWorkState() == null || "".equals(ocrmFwpTodoWork.getTodoWorkState())) {
			ocrmFwpTodoWork.setTodoWorkState("1");
		}
		if (ocrmFwpTodoWork.getIsNotice() == null || "".equals(ocrmFwpTodoWork.getIsNotice())) {
			ocrmFwpTodoWork.setIsNotice("Y");
		}
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		try {
			if (ocrmFwpTodoWork.getCreateDate() != null) {
				time = s.format(ocrmFwpTodoWork.getCreateDate());
				ocrmFwpTodoWork.setCreateDate(s.parse(time));
			}
			if (ocrmFwpTodoWork.getStartDate() != null) {
				time = s.format(ocrmFwpTodoWork.getStartDate());
				ocrmFwpTodoWork.setStartDate(s.parse(time));
			}
			if (ocrmFwpTodoWork.getEndDate() != null) {
				time = s.format(ocrmFwpTodoWork.getEndDate());
				ocrmFwpTodoWork.setEndDate(s.parse(time));
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		List<Date> startDates = this.getStartDates(ocrmFwpTodoWork.getNoticeCycle(), ocrmFwpTodoWork.getStartDate(),
				ocrmFwpTodoWork.getEndDate());
		OcrmFwpTodoWorkSon ocrmFwpTodoWorkSon = new OcrmFwpTodoWorkSon();
		ocrmFwpTodoWorkSon.setRelationCust(ocrmFwpTodoWork.getRelationCust());
		ocrmFwpTodoWorkSon.setTodoWorkType(ocrmFwpTodoWork.getTodoWorkType());
		ocrmFwpTodoWorkSon.setTodoWorkTitle(ocrmFwpTodoWork.getTodoWorkTitle());
		ocrmFwpTodoWorkSon.setTodoWorkContent(ocrmFwpTodoWork.getTodoWorkContent());
		ocrmFwpTodoWorkSon.setContactType(ocrmFwpTodoWork.getContactType());
		ocrmFwpTodoWorkSon.setContactGoal(ocrmFwpTodoWork.getContactGoal());
		int result = 0;
		if (ocrmFwpTodoWork.getFinisher() != null || !"".equals(ocrmFwpTodoWork.getFinisher())) {
			String[] finishers = ocrmFwpTodoWork.getFinisher().split(";");
			List<RemindInfo> list = new ArrayList<>();
			for (int i = 0; i < finishers.length; i++) {
				String toDoWorkId = this.getUuid();
				ocrmFwpTodoWork.setTodoWorkId(toDoWorkId);
				ocrmFwpTodoWork.setFinisher(finishers[i]);
				if (ocrmFwpTodoWork.getFinisher().indexOf(ocrmFwpTodoWork.getCreatorId()) == -1){
					list.add(addRemindInfo(ocrmFwpTodoWork));
				}
				ocrmFwpTodoWorkSon.setNoticeId(toDoWorkId);
				ocrmFwpTodoWorkSon.setFinisher(finishers[i]);
				result += ocrmFwpTodoWorkSonService.addCyCleTodoWork(ocrmFwpTodoWorkSon, startDates);
				this.insertSelective(ocrmFwpTodoWork);
				result += 1;
			}
			remindInfoService.addlist(list);
			return result;
		}else {
			String toDoWorkId = this.getUuid();
			ocrmFwpTodoWork.setTodoWorkId(toDoWorkId);
			ocrmFwpTodoWorkSon.setNoticeId(toDoWorkId);
			ocrmFwpTodoWorkSonService.addCyCleTodoWork(ocrmFwpTodoWorkSon, startDates);
			result = this.insertSelective(ocrmFwpTodoWork);
			return result;
		}
	}

	public List<Date> getStartDates(String noticeCycle, Date startDate, Date endDate) {
		List<Date> startDates = new ArrayList<Date>();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar ca = Calendar.getInstance();
		ca.setTime(startDate);
		String year = "" + ca.get(Calendar.YEAR);// 年份数值
		int monthInt = ca.get(Calendar.MONTH) + 1;// 第几个月
		int dayInt = ca.get(Calendar.DAY_OF_MONTH);// 号
		long sDate = startDate.getTime();
		long eDate = endDate.getTime();
		if ("4".equals(noticeCycle)) {
			String day = (dayInt < 10 ? "0" : "") + dayInt;
			while (sDate <= eDate) {
				startDates.add(startDate);
				monthInt += 1;
				String month = (monthInt < 10 ? "0" : "") + monthInt;
				try {
					startDate = s.parse(year + "-" + month + "-" + day + " " + s.format(startDate).split("\\s+")[1]);
				} catch (ParseException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				sDate = startDate.getTime();
			}
		} else {
			String month = (monthInt < 10 ? "0" : "") + monthInt;
			int cycle = 0;
			if ("1".equals(noticeCycle)) {
				cycle = 1;
			}
			if ("2".equals(noticeCycle)) {
				cycle = 7;
			}
			if ("3".equals(noticeCycle)) {
				cycle = 14;
			}
			while (sDate <= eDate) {
				startDates.add(startDate);
				dayInt += cycle;
				String day = (dayInt < 10 ? "0" : "") + dayInt;
				try {
					startDate = s.parse(year + "-" + month + "-" + day + " " + s.format(startDate).split("\\s+")[1]);
				} catch (ParseException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				sDate = startDate.getTime();
			}
		}
		return startDates;
	}

	public List<Map<String, Object>> queryMainlist(QueryModel queryModel) {
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, Object> condition = queryModel.getCondition();
		String finisher = (String) condition.get("finisher");
		if (finisher != null && !"".equals(finisher)) {
			finisher = "%" + finisher + "%";
			condition.put("finisher", finisher);
		}
		String mySelect = (String) condition.get("mySelect");
		if (mySelect != null && !"".equals(mySelect)) {
			mySelect = "%" + mySelect + "%";
			condition.put("mySelect", mySelect);
		}
		String todoWorkTitle = (String) condition.get("todoWorkTitle");
		if (todoWorkTitle != null && !"".equals(todoWorkTitle)) {
			todoWorkTitle = "%" + todoWorkTitle + "%";
			condition.put("todoWorkTitle", todoWorkTitle);
		}
		String relationCust = (String) condition.get("relationCust");
		if (relationCust != null && !"".equals(relationCust)) {
			relationCust = "%" + relationCust + "%";
			condition.put("relationCust", relationCust);
		}
		if (condition.get("rangeDate") instanceof List) {
			List<String> rangeDate = (List<String>) condition.get("rangeDate");
			if (rangeDate != null && rangeDate.size() == 2) {
				condition.put("startDate", rangeDate.get(0).trim());
				condition.put("endDate", rangeDate.get(1).trim());
			}
		}
		List<Map<String, Object>> list = ocrmFwpTodoWorkMapper.queryMainlist(queryModel);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, Object>> queryDetail(QueryModel queryModel) {
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> listF = ocrmFwpTodoWorkMapper.queryDetail(queryModel);
		for (Iterator<Map<String, Object>> iterator = listF.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			String isNotice = (String) map.get("isNotice");
			if ("Y".equals(isNotice)) {
				List<Map<String, Object>> listS = ocrmFwpTodoWorkSonService.queryByToDoWorkId(queryModel);
				map.put("sonToDo", listS);
			}
		}
		PageHelper.clearPage();
		return listF;
	}

	/**
	 * @description: 根据用户ID查询用户关联角色
	 * @author hujun3
	 * @date 2021/09/16 21:46:35
	 **/
	public List<Map<String, Object>> getUserRoleInfo(String userId) {
		List<Map<String, Object>> listF = ocrmFwpTodoWorkMapper.getUserRoleInfo(userId);
		return listF;
	}

	public int deleteOne(List<String> todoWorkId) {
		// TODO 增加异常处理
		int result = 0;
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> map = new HashMap<>();
		map.put("todoWorkIds",todoWorkId);
		map.put("lastChgUsrId",dto.getBody().getLoginCode());
		map.put("lastChgUsrName",dto.getBody().getUserName());
		map.put("lastChgUsrOrgId",dto.getBody().getOrg().getId());
		map.put("lastChgUsrOrgName",dto.getBody().getOrg().getName());
		map.put("lastChgDate",s.format(new Date()));

		result = ocrmFwpTodoWorkMapper.deleteOne(map);
		return result;
	}

	public int deleteCycle(List<String> todoWorkId) {
		// TODO 自动生成的方法存根
		int result = ocrmFwpTodoWorkSonService.deleteByNoticeId(todoWorkId);
		List<OcrmFwpTodoWorkSon> sonList = ocrmFwpTodoWorkSonService.queryState(todoWorkId);
		if (sonList.size() > 0) {
			List<String> todoWorkIds = new ArrayList<>();
			Map<String, List<OcrmFwpTodoWorkSon>> sonMap = sonList.stream().collect(Collectors.groupingBy(OcrmFwpTodoWorkSon::getNoticeId));
			for (Map.Entry<String, List<OcrmFwpTodoWorkSon>> m : sonMap.entrySet()) {
				todoWorkIds.add(m.getKey());
			}
			if (todoWorkIds.size() > 0){
				this.updateToDoWorkState(todoWorkIds);
			}
 		}
		this.deleteOne(todoWorkId);
		return result;
	}

	public int deleteSon(List<String> todoWorkId) {
		// TODO 自动生成的方法存根
		return ocrmFwpTodoWorkSonService.deleteByTodoWorkId(todoWorkId);
	}

	public int updateOne(OcrmFwpTodoWork ocrmFwpTodoWork) {
		// TODO 增加异常处理
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		if (ocrmFwpTodoWork.getLastChgUsrId() == null || "".equals(ocrmFwpTodoWork.getLastChgUsrId())) {
			ocrmFwpTodoWork.setLastChgUsrId(dto.getBody().getLoginCode());
		}
		if (ocrmFwpTodoWork.getLastChgUsrName() == null || "".equals(ocrmFwpTodoWork.getLastChgUsrName())) {
			ocrmFwpTodoWork.setLastChgUsrName(dto.getBody().getUserName());
		}
		if (ocrmFwpTodoWork.getLastChgUsrOrgId() == null || "".equals(ocrmFwpTodoWork.getLastChgUsrOrgId())) {
			ocrmFwpTodoWork.setLastChgUsrOrgId(dto.getBody().getOrg().getId());
		}
		if (ocrmFwpTodoWork.getLastChgUsrOrgName() == null || "".equals(ocrmFwpTodoWork.getLastChgUsrOrgName())) {
			ocrmFwpTodoWork.setLastChgUsrOrgName(dto.getBody().getOrg().getName());
		}
		if (ocrmFwpTodoWork.getLastChgDate() == null) {
			ocrmFwpTodoWork.setLastChgDate(new java.util.Date());
		}
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		try {
			if (ocrmFwpTodoWork.getLastChgDate() != null) {
				time = s.format(ocrmFwpTodoWork.getLastChgDate());
				ocrmFwpTodoWork.setLastChgDate(s.parse(time));
			}
			if (ocrmFwpTodoWork.getStartDate() != null) {
				time = s.format(ocrmFwpTodoWork.getStartDate());
				ocrmFwpTodoWork.setStartDate(s.parse(time));
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ocrmFwpTodoWorkMapper.updateOne(ocrmFwpTodoWork);
	}

	public int updateCyCle(OcrmFwpTodoWork ocrmFwpTodoWork) {
		// TODO 自动生成的方法存根
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		if (ocrmFwpTodoWork.getLastChgUsrId() == null || "".equals(ocrmFwpTodoWork.getLastChgUsrId())) {
			ocrmFwpTodoWork.setLastChgUsrId(dto.getBody().getLoginCode());
		}
		if (ocrmFwpTodoWork.getLastChgUsrName() == null || "".equals(ocrmFwpTodoWork.getLastChgUsrName())) {
			ocrmFwpTodoWork.setLastChgUsrName(dto.getBody().getUserName());
		}
		if (ocrmFwpTodoWork.getLastChgUsrOrgId() == null || "".equals(ocrmFwpTodoWork.getLastChgUsrOrgId())) {
			ocrmFwpTodoWork.setLastChgUsrOrgId(dto.getBody().getOrg().getId());
		}
		if (ocrmFwpTodoWork.getLastChgUsrOrgName() == null || "".equals(ocrmFwpTodoWork.getLastChgUsrOrgName())) {
			ocrmFwpTodoWork.setLastChgUsrOrgName(dto.getBody().getOrg().getName());
		}
		if (ocrmFwpTodoWork.getLastChgDate() == null) {
			ocrmFwpTodoWork.setLastChgDate(new java.util.Date());
		}
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		try {
			if (ocrmFwpTodoWork.getLastChgDate() != null) {
				time = s.format(ocrmFwpTodoWork.getLastChgDate());
				ocrmFwpTodoWork.setLastChgDate(s.parse(time));
			}
			if (ocrmFwpTodoWork.getStartDate() != null) {
				time = s.format(ocrmFwpTodoWork.getStartDate());
				ocrmFwpTodoWork.setStartDate(s.parse(time));
			}
			if (ocrmFwpTodoWork.getEndDate() != null) {
				time = s.format(ocrmFwpTodoWork.getEndDate());
				ocrmFwpTodoWork.setEndDate(s.parse(time));
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		List<Date> startDates = this.getStartDates(ocrmFwpTodoWork.getNoticeCycle(), ocrmFwpTodoWork.getStartDate(),
				ocrmFwpTodoWork.getEndDate());
		OcrmFwpTodoWorkSon ocrmFwpTodoWorkSon = new OcrmFwpTodoWorkSon();
		ocrmFwpTodoWorkSon.setRelationCust(ocrmFwpTodoWork.getRelationCust());
		ocrmFwpTodoWorkSon.setTodoWorkType(ocrmFwpTodoWork.getTodoWorkType());
		ocrmFwpTodoWorkSon.setTodoWorkTitle(ocrmFwpTodoWork.getTodoWorkTitle());
		ocrmFwpTodoWorkSon.setTodoWorkContent(ocrmFwpTodoWork.getTodoWorkContent());
		ocrmFwpTodoWorkSon.setNoticeId(ocrmFwpTodoWork.getTodoWorkId());
		ocrmFwpTodoWorkSon.setFinisher(ocrmFwpTodoWork.getFinisher());
		int result = ocrmFwpTodoWorkSonService.updateCyCle(ocrmFwpTodoWorkSon, startDates);
		result += ocrmFwpTodoWorkMapper.updateCyCle(ocrmFwpTodoWork);
		return result;
	}

	public int updateToDoWorkState(List<String> todoWorkId) {
		// TODO 自动生成的方法存根
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> map = new HashMap<>();
		map.put("todoWorkIds",todoWorkId);
		map.put("lastChgUsrId",dto.getBody().getLoginCode());
		map.put("lastChgUsrName",dto.getBody().getUserName());
		map.put("lastChgUsrOrgId",dto.getBody().getOrg().getId());
		map.put("lastChgUsrOrgName",dto.getBody().getOrg().getName());
		map.put("lastChgDate",s.format(new Date()));
		int result = ocrmFwpTodoWorkMapper.updateToDoWorkState(map);
		List<OcrmFwpTodoWork> list = ocrmFwpTodoWorkMapper.listConTactByTodoWorkIds(map);
		if (list != null && list.size() > 0){
			todoworkAndCustContactService.addTodoWorks(list);
		}
		return result;
	}

	public int updateToDoWorkSonState(List<String> todoWorkId) {
		// TODO 自动生成的方法存根
		int result = ocrmFwpTodoWorkSonService.updateToDoWorkState(todoWorkId);
		return result;
	}
	public void export(QueryModel model, HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		// 这里URLEncoder.encode可以防止中文乱码
		String fileName = URLEncoder.encode("待办事项", "UTF-8").replaceAll("\\+", "%20");
		response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
		String templateFileName = "templates" + File.separator + "todowork_templat.xlsx";
		ExcelWriter excelWriter = null;

		excelWriter = EasyExcel.write(response.getOutputStream())
				.withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();
		WriteSheet writeSheet1 = EasyExcel.writerSheet(0, "一次性待办").build();
		WriteSheet writeSheet2 = EasyExcel.writerSheet(1, "周期性待办").registerWriteHandler(new ExcelFillCellMergeStrategy(new int[]{0,1,2,3,4,5,6,7,8,9},1)).build();

		excelWriter.fill(ocrmFwpTodoWorkMapper.queryOneDetail(model), writeSheet1);
		List<TodoWorkExcle> list = ocrmFwpTodoWorkMapper.queryCycleDetail(model);
		Map<String,List<TodoWorkExcle>> resultMap = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		resultMap.putAll(list.stream().collect(Collectors.groupingBy(TodoWorkExcle::getCreateDate)));
		int i = 1;
		for (Map.Entry<String,List<TodoWorkExcle>> m: resultMap.entrySet()) {
			List<TodoWorkExcle> list1 = m.getValue();
			TodoWorkExcle todoWorkExcle = list1.get(0);
			int j = 1;
			for (TodoWorkExcle twe: list1) {
				twe.setTodoWorkId(String.valueOf(i));
				twe.setSonTodoWorkId(String.valueOf(j));
				twe.setIsNotice(todoWorkExcle.getIsNotice());
				twe.setTodoWorkType(todoWorkExcle.getTodoWorkType());
				twe.setTodoWorkTitle(todoWorkExcle.getTodoWorkTitle());
				twe.setCreatorName(todoWorkExcle.getCreatorName());
				twe.setCreatorId(todoWorkExcle.getCreatorId());
				twe.setCreateDate(todoWorkExcle.getCreateDate());
				twe.setNoticeCycle(todoWorkExcle.getNoticeCycle());
				twe.setStartDate(todoWorkExcle.getStartDate());
				twe.setEndDate(todoWorkExcle.getEndDate());
				j++;
			}
			i++;
		}
		excelWriter.fill(list, FillConfig.builder().forceNewRow(Boolean.TRUE).build(), writeSheet2);

		// 关闭流
		excelWriter.finish();
	}


//	public int export1(QueryModel model, HttpServletResponse response) throws IOException {
//		int ret = 0;
//		List<TodoWorkExcle> oneList = ocrmFwpTodoWorkMapper.queryOneDetail(model);
////				(List<Map<String, Object>>) model.getCondition().get("oneList");// 一次性待办事项
//		List<TodoWorkExcle> cycleList = ocrmFwpTodoWorkMapper.queryCycleDetail(model);
////				(List<Map<String, Object>>) model.getCondition().get("cycleList");// 周期性待办事项
//		List<Map<String, Object>> colList = (List<Map<String, Object>>) model.getCondition().get("colunmNamelist");// 表头参数
//		List<List<CellInfo>> oneDatalist = new ArrayList<List<CellInfo>>();
//		List<List<CellInfo>> cycleDatalist = new ArrayList<List<CellInfo>>();
//		List<Map<String, Object>> exportDataList = new ArrayList<Map<String, Object>>();
//		List<List<CellInfo>> headerTwo = new ArrayList<List<CellInfo>>();
//		String cols = "";
//		String colskey = "";
//		List<CellInfo> heads = new ArrayList<CellInfo>();
//		for (int k = 0; k < colList.size(); k++) {// 遍历表头数据
//			if (k == 0) {
//				cols = (String) colList.get(k).get("name");
//				colskey = (String) colList.get(k).get("ename");
//			} else {
//				cols = cols + "," + (String) colList.get(k).get("name");
//				colskey = colskey + "," + (String) colList.get(k).get("ename");
//			}
//			heads.add(new CellInfo((String) colList.get(k).get("name")));// 字段名
//		}
//		// 表头list
//		if (heads.size() > 0) {
//			headerTwo.add(heads);
//		}
//		// logger.info("灵活查询结果数据导出export dataList.size="+OneTableDataList.size());
//		if ((oneList.size() + cycleList.size()) > 50000) {
//			response.setContentType("text/html;charset=utf-8");
//			response.getWriter().write("<script>alert('数据量过大，禁止导出！');</script>");
//			response.getWriter().write("<script>window.close();window.history.go(-1);</script>");
//			response.getWriter().flush();
//		} else {
//			String data = "";
//			String[] colkey = colskey.split(",");
//			if (oneList.size() > 0) {
//				List<CellInfo> oneData;
//				for (int m = 0; m < oneList.size(); m++) {
//					oneData = new ArrayList<CellInfo>();
//					for (int b = 0; b < colkey.length; b++) {
//						String colName = colkey[b];
//						Object dataTemp = oneList.get(m).get(colName);
//						data = String.valueOf(dataTemp);
//						if ("null".equals(data)) {
//							data = "";
//						} else {
//							if ("todoWorkType".equals(colName)) {
//								if ("1".equals(data)) {
//									data = "商机";
//								} else if ("2".equals(data)) {
//									data = "外访";
//								} else if ("3".equals(data)) {
//									data = "培训\\会议";
//								} else if ("4".equals(data)) {
//									data = "材料整理";
//								} else if ("5".equals(data)) {
//									data = "客户跟进";
//								}
//							} else if ("todoWorkState".equals(colName)) {
//								if ("1".equals(data)) {
//									data = "待跟进";
//								} else if ("2".equals(data)) {
//									data = "已跟进";
//								}
//							}
//						}
//						oneData.add(new CellInfo(data));
//					}
//					oneDatalist.add(oneData);
//				}
//			}
//			if (cycleList.size() > 0) {
//				List<CellInfo> cycleData;
//				for (int n = 0; n < cycleList.size(); n++) {
//					cycleData = new ArrayList<CellInfo>();
//					for (int b = 0; b < colkey.length; b++) {
//						String colName = colkey[b];
//						Object dataTemp = cycleList.get(n).get(colName);
//						data = String.valueOf(dataTemp);
//						if ("null".equals(data)) {
//							data = "";
//						} else {
//							if ("todoWorkType".equals(colName)) {
//								if ("1".equals(data)) {
//									data = "商机";
//								} else if ("2".equals(data)) {
//									data = "外访";
//								} else if ("3".equals(data)) {
//									data = "培训\\会议";
//								} else if ("4".equals(data)) {
//									data = "材料整理";
//								} else if ("5".equals(data)) {
//									data = "客户跟进";
//								}
//							} else if ("todoWorkState".equals(colName)) {
//								if ("1".equals(data)) {
//									data = "待跟进";
//								} else if ("2".equals(data)) {
//									data = "已跟进";
//								}
//							}
//						}
//						cycleData.add(new CellInfo(data));
//					}
//					cycleDatalist.add(cycleData);
//				}
//			}
//			if (oneDatalist.size() > 0) {
//				Map<String, Object> mapO = new HashMap<String, Object>();
//				mapO.put("sheetName", "一次性待办事项");// sheet名
//				mapO.put("headerLength", colList.size());// 表头长度
//				mapO.put("header", headerTwo);// 表头
//				mapO.put("data", oneDatalist);// 数据
//				exportDataList.add(mapO);
//			}
//			if (cycleDatalist.size() > 0) {
//				Map<String, Object> mapC = new HashMap<String, Object>();
//				mapC.put("sheetName", "周期性待办事项");// sheet名
//				mapC.put("headerLength", colList.size());// 表头长度
//				mapC.put("header", headerTwo);// 表头
//				mapC.put("data", cycleDatalist);// 数据
//				exportDataList.add(mapC);
//			}
//			// logger.info("灵活查询结果数据导出export data="+exportDataList);
//			Calendar cal = Calendar.getInstance();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String date = sdf.format(cal.getTime()) + "待办事项导出结果";
//			try {
//				date = new String(date.getBytes("utf-8"), "ISO8859-1");
//			} catch (UnsupportedEncodingException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			//
//			SXSSFWorkbook workbook = this.exportExcel(exportDataList);
//			//
//			response.reset();
//			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
//			response.addHeader("Content-Disposition", "attachment; filename=\"" + date + ".xlsx\"");
//			OutputStream outputStream = null;
//			try {
//				outputStream = response.getOutputStream();
//				workbook.write(outputStream);
//				outputStream.flush();
//			} catch (IOException e) {
//				ret = 1;
//			} finally {
//				try {
//					outputStream.close();
//				} catch (IOException e) {
//					ret = 1;
//				}
//			}
//		}
//		return ret;
//	}
//
//	// 导出
//	public SXSSFWorkbook exportExcel(List<Map<String, Object>> datas) throws IOException {
//		// logger.info("业务数据导出exportExcel begin");
//		// 创建工作簿
//		SXSSFWorkbook workbook = new SXSSFWorkbook();
//
//		// 表头的样式
//		// 字体
//		Font titleFont = workbook.createFont(); // 创建字体对象
//		titleFont.setFontHeightInPoints((short) 11); // 设置字体大小
//		titleFont.setFontName("微软雅黑"); // 设置为黑体字
//		// 表数据的样式
//		// 字体
//		Font font = workbook.createFont(); // 创建字体对象
//		font.setFontHeightInPoints((short) 11); // 设置字体大小
//		font.setFontName("微软雅黑"); // 设置为黑体字
//
//		for (Map<String, Object> map : datas) {
//			String sheetName = map.get("sheetName").toString();
//			int headerLength = (int) map.get("headerLength");
//			List<List<CellInfo>> header = (List<List<CellInfo>>) map.get("header");
//			List<List<CellInfo>> data = (List<List<CellInfo>>) map.get("data");
//			// 创建Sheet
//			SXSSFSheet sheet = workbook.createSheet(sheetName);
//			// 设置表格默认列宽度为20个字节
//			sheet.setDefaultColumnWidth(20);
//			// 设置第一行 （单位信息，定制）
//			int rowNum = -1;
//			// 表头
//			for (int i = 0; i < header.size(); i++) {
//				// 行
//				rowNum++;
//				// logger.info("业务数据导出exportExcel header="+rowNum);
//				SXSSFRow row = sheet.createRow(rowNum);
//				List<CellInfo> cols = header.get(i);
//				// 创建列
//				int colNum = 0;
//				for (int j = 0; j < cols.size(); j++) {
//					SXSSFCell cell = row.createCell(colNum);
//					cell.setCellValue(cols.get(j).getContent());
//					int firstRow = rowNum;
//					int lastRow = rowNum;
//					int firstCol = colNum;
//					int lastCol = colNum;
//					boolean merge = false;
//					if (cols.get(j).getRowSpan() > 1) {
//						lastRow += cols.get(j).getRowSpan() - 1;
//						merge = true;
//					}
//					if (cols.get(j).getColSpan() > 1) {
//						for (int k = 0; k < cols.get(j).getColSpan() - 1; k++) {
//							colNum++;
//							SXSSFCell tmpCell = row.createCell(colNum);
//							tmpCell.setCellValue(cols.get(j).getContent());
//						}
//						lastCol = colNum;
//						merge = true;
//					}
//					colNum++;
//					// logger.info("业务数据导出exportExcel header getColSpan merge="+merge);
//					if (merge) {
//						sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
//					}
//				}
//			}
//			// 表格数据
//			// logger.info("业务数据导出+模板data.size()="+data.size());
//			if (data.size() > 0) {
//				for (int i = 0; i < data.size(); i++) {
//					// 行
//					rowNum++;
//					// logger.info("业务数据导出exportExcel data="+rowNum);
//					SXSSFRow row = sheet.createRow(rowNum);
//					List<CellInfo> cols = data.get(i);
//					// 创建列
//					int colNum = 0;
//					for (int j = 0; j < cols.size(); j++) {
//						SXSSFCell cell = row.createCell(colNum);
//						// cell.setCellStyle(style);
//						cell.setCellValue(cols.get(j).getContent());
//						int firstRow = rowNum;
//						int lastRow = rowNum;
//						int firstCol = colNum;
//						int lastCol = colNum;
//						boolean merge = false;
//						if (cols.get(j).getRowSpan() > 1) {
//							lastRow += cols.get(j).getRowSpan() - 1;
//							merge = true;
//						}
//						// 如果跨行则先创建被合并的单元格（主要是不创建的话，合并后的样式引用有问题）
//						if (cols.get(j).getColSpan() > 1) {
//							for (int k = 0; k < cols.get(j).getColSpan() - 1; k++) {
//								colNum++;
//								SXSSFCell tmpCell = row.createCell(colNum);
//								tmpCell.setCellValue(cols.get(j).getContent());
//							}
//							lastCol = colNum;
//							merge = true;
//						}
//						colNum++;
//						if (merge) {
//							sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
//						}
//					}
//				}
//			}
//			rowNum++;
//		}
//		// logger.info("业务数据导出exportExcel end");
//		return workbook;
//	}

	public List<Map<String, Object>> indexQuery(QueryModel queryModel) {
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, Object> condition = queryModel.getCondition();
		String finisher = (String) condition.get("finisher");
		if (finisher != null && !"".equals(finisher)) {
			finisher = "%" + finisher + "%";
			condition.put("finisher", finisher);
		}
		List<Map<String, Object>> list = ocrmFwpTodoWorkMapper.indexQuery(queryModel);
		PageHelper.clearPage();
		return list;
	}


	public List<Map<String, Object>> queryFinished(QueryModel queryModel) {
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, Object> condition = queryModel.getCondition();
		String finisher = (String) condition.get("finisher");
		if (finisher != null && !"".equals(finisher)) {
			finisher = "%" + finisher + "%";
			condition.put("finisher", finisher);
		}
		List<Map<String, Object>> list = ocrmFwpTodoWorkMapper.queryFinished(queryModel);
		PageHelper.clearPage();
		return list;
	}
	public Map<String, List<String>> selectDataNum(QueryModel queryModel) {
		// TODO 自动生成的方法存根
		Map<String, Object> condition = queryModel.getCondition();
		Map<String, List<String>> map = new TreeMap<String, List<String>>();
		List<String> todowork = new ArrayList<String>();
		List<String> workReport = new ArrayList<String>();
		String finisher = (String) condition.get("userId");
		if (finisher != null && !"".equals(finisher)) {
			finisher = "%" + finisher + "%";
			condition.put("finisher", finisher);
		}
		String startDate = (String) condition.get("startDate");
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		try {
			Date monDay = s.parse(startDate);
			ca.setTime(monDay);
			if (ca.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				for (int i = 0; i < 7; i++) {
					queryModel.getCondition().put("startDate", s.format(ca.getTime()));
					int num_todo = ocrmFwpTodoWorkMapper.selectTodoNum(queryModel);
					if (num_todo != 0) {
						todowork.add(s.format(ca.getTime()));
					}
					int num_report = ocrmFwpTodoWorkMapper.selectReportNum(queryModel);
					if (num_report != 0) {
						workReport.add(s.format(ca.getTime()));
					}
					ca.add(Calendar.DATE, 1);
				}
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		map.put("todowork", todowork);
		map.put("workReport", workReport);
		return map;
	}

}
