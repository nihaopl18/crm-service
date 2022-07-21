package cn.com.yusys.yusp.dycrm.todowork.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.dycrm.todowork.domain.OcrmFwpTodoWork;
import cn.com.yusys.yusp.dycrm.todowork.domain.OcrmFwpTodoWorkSon;
import cn.com.yusys.yusp.dycrm.todowork.repository.mapper.OcrmFwpTodoWorkSonMapper;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @version 1.0.0
 * @项目名称: dycrm-todowork模块
 * @类名称: ocrmFwpToDoWorkSonSonService
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
public class OcrmFwpTodoWorkSonService extends CommonService {
	@Autowired
	private OcrmFwpTodoWorkSonMapper ocrmFwpTodoWorkSonMapper;

	@Autowired
	private OcrmFwpTodoWorkService ocrmFwpTodoWorkService;

	@Autowired
	private TodoworkAndCustContactService todoworkAndCustContactService;

	@Autowired
	private UaaClient uaaClient;

	@Override
	protected CommonMapper<?> getMapper() {
		return ocrmFwpTodoWorkSonMapper;
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

	public int addCyCleTodoWork(OcrmFwpTodoWorkSon ocrmFwpTodoWorkSon, List<Date> startDate) {
		// TODO 自动生成的方法存根
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		if (ocrmFwpTodoWorkSon.getCreatorId() == null || "".equals(ocrmFwpTodoWorkSon.getCreatorId())) {
			ocrmFwpTodoWorkSon.setCreatorId(dto.getBody().getLoginCode());
		}
		if (ocrmFwpTodoWorkSon.getCreatorName() == null || "".equals(ocrmFwpTodoWorkSon.getCreatorName())) {
			ocrmFwpTodoWorkSon.setCreatorName(dto.getBody().getUserName());
		}
		if (ocrmFwpTodoWorkSon.getCreatorOrgId() == null || "".equals(ocrmFwpTodoWorkSon.getCreatorOrgId())) {
			ocrmFwpTodoWorkSon.setCreatorOrgId(dto.getBody().getOrg().getId());
		}
		if (ocrmFwpTodoWorkSon.getCreatorOrgName() == null || "".equals(ocrmFwpTodoWorkSon.getCreatorOrgName())) {
			ocrmFwpTodoWorkSon.setCreatorOrgName(dto.getBody().getOrg().getName());
		}
		if (ocrmFwpTodoWorkSon.getIsDelete() == null || "".equals(ocrmFwpTodoWorkSon.getIsDelete())) {
			ocrmFwpTodoWorkSon.setIsDelete("N");
		}

		if (ocrmFwpTodoWorkSon.getCreateDate() == null) {
			ocrmFwpTodoWorkSon.setCreateDate(new java.util.Date());
		}
		if (ocrmFwpTodoWorkSon.getTodoWorkState() == null || "".equals(ocrmFwpTodoWorkSon.getTodoWorkState())) {
			ocrmFwpTodoWorkSon.setTodoWorkState("1");
		}
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		try {
			if (ocrmFwpTodoWorkSon.getCreateDate() != null) {
				time = s.format(ocrmFwpTodoWorkSon.getCreateDate());
				ocrmFwpTodoWorkSon.setCreateDate(s.parse(time));
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		int result = 0;
		for (Iterator<Date> iterator = startDate.iterator(); iterator.hasNext();) {
			Date date = (Date) iterator.next();
			time = s.format(date);
			ocrmFwpTodoWorkSon.setTodoWorkId(this.getUuid());
			try {
				ocrmFwpTodoWorkSon.setStartDate(s.parse(time));
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			result += this.insertSelective(ocrmFwpTodoWorkSon);
		}
		return result;
	}

	public List<Map<String, Object>> queryByToDoWorkId(QueryModel queryModel) {
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = ocrmFwpTodoWorkSonMapper.queryByToDoWorkId(queryModel);
		PageHelper.clearPage();
		return list;
	}

	public List<OcrmFwpTodoWorkSon> queryState(List<String> todoWorkId) {
		// TODO 自动生成的方法存根
		return ocrmFwpTodoWorkSonMapper.queryState(todoWorkId);
	}

	public int updateCyCle(OcrmFwpTodoWorkSon ocrmFwpTodoWorkSon, List<Date> startDates) {
		// TODO 自动生成的方法存根
		List<Map<String, Object>> list = ocrmFwpTodoWorkSonMapper.queryStartDate(ocrmFwpTodoWorkSon.getNoticeId());
		List<String> noticeId = new ArrayList<>();
		noticeId.add(ocrmFwpTodoWorkSon.getNoticeId());
		int result = this.deleteByNoticeId(noticeId);
		List<Date> midData = new ArrayList<Date>();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Iterator<Date> iterator = startDates.iterator(); iterator.hasNext();) {
			Date date = (Date) iterator.next();
			String dateS = s.format(date);
			int sum = 0;
			for (Iterator<Map<String, Object>> iterator1 = list.iterator(); iterator1.hasNext();) {
				Map<String, Object> map = (Map<String, Object>) iterator1.next();
				String startDate = s.format((Date) map.get("startDate"));
				if (dateS.equals(startDate)) {
					if ("1".equals((String) map.get("todoWorkState"))) {
						this.updateByTodoWorkId((String) map.get("todoWorkId"));
					}
					sum += 1;
				}
			}
			if (sum == 0) {
				midData.add(date);
			}
		}
		result += this.addCyCleTodoWork(ocrmFwpTodoWorkSon, midData);
		return result;
	}

	public int updateByTodoWorkId(String todoWorkId) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		OcrmFwpTodoWorkSon ocrmFwpTodoWorkSon = new OcrmFwpTodoWorkSon();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ocrmFwpTodoWorkSon.setTodoWorkId(todoWorkId);
		ocrmFwpTodoWorkSon.setLastChgDate(new Date());
		try {
			ocrmFwpTodoWorkSon.setLastChgDate(s.parse(s.format(ocrmFwpTodoWorkSon.getLastChgDate())));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		ocrmFwpTodoWorkSon.setLastChgUsrId(dto.getBody().getLoginCode());
		ocrmFwpTodoWorkSon.setLastChgUsrName(dto.getBody().getUserName());
		ocrmFwpTodoWorkSon.setLastChgUsrOrgId(dto.getBody().getOrg().getId());
		ocrmFwpTodoWorkSon.setLastChgUsrOrgName(dto.getBody().getOrg().getName());
		int result = ocrmFwpTodoWorkSonMapper.updateByTodoWorkId(ocrmFwpTodoWorkSon);
		return result;
	}

	public int deleteByNoticeId(List<String> noticeId) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		OcrmFwpTodoWorkSon ocrmFwpTodoWorkSon = new OcrmFwpTodoWorkSon();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> map = new HashMap<>();
		map.put("noticeIds",noticeId);
		map.put("lastChgUsrId",dto.getBody().getLoginCode());
		map.put("lastChgUsrName",dto.getBody().getUserName());
		map.put("lastChgUsrOrgId",dto.getBody().getOrg().getId());
		map.put("lastChgUsrOrgName",dto.getBody().getOrg().getName());
		map.put("lastChgDate",s.format(new Date()));
		int result = ocrmFwpTodoWorkSonMapper.deleteByNoticeId(map);
		return result;
	}

	public int deleteByTodoWorkId(List<String> todoWorkId) {
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
		int result = ocrmFwpTodoWorkSonMapper.deleteByTodoWorkId(map);
		List<String> noticeIds = ocrmFwpTodoWorkSonMapper.queryNoticeId(todoWorkId);
		List<String> delNotice = new ArrayList<>();
		List<String> stateNotice = new ArrayList<>();
		for (String notice : noticeIds){
			int num = ocrmFwpTodoWorkSonMapper.queryNotice(notice);
			if (num == 0){
				delNotice.add(notice);
			}else {
				int num1 = ocrmFwpTodoWorkSonMapper.querySon(notice);
				if (num1 == 0){
					stateNotice.add(notice);
				}
			}
		}
		if (delNotice.size() > 0){
			ocrmFwpTodoWorkService.deleteOne(delNotice);
		}
		if (stateNotice.size() > 0){
			ocrmFwpTodoWorkService.updateToDoWorkState(stateNotice);
		}
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
		int result = ocrmFwpTodoWorkSonMapper.updateToDoWorkState(map);
		List<OcrmFwpTodoWorkSon> list = ocrmFwpTodoWorkSonMapper.listConTactByTodoWorkIds(map);
		if (list != null && list.size() > 0){
			todoworkAndCustContactService.addTodoWorkSons(list);
		}
		List<String> noticeIds = ocrmFwpTodoWorkSonMapper.queryNoticeId(todoWorkId);
		List<String> stateNotice = new ArrayList<>();
		for (String notice : noticeIds){
			int num = ocrmFwpTodoWorkSonMapper.querySon(notice);
			if (num == 0){
				stateNotice.add(notice);
			}
		}
		if (stateNotice.size() > 0){
			ocrmFwpTodoWorkService.updateToDoWorkState(stateNotice);
		}
		return result;
	}

	public int updateSon(OcrmFwpTodoWork ocrmFwpTodoWork) {
		// TODO 自动生成的方法存根
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		OcrmFwpTodoWorkSon ocrmFwpTodoWorkSon = new OcrmFwpTodoWorkSon();
		ocrmFwpTodoWorkSon.setLastChgUsrId(dto.getBody().getLoginCode());
		ocrmFwpTodoWorkSon.setLastChgUsrName(dto.getBody().getUserName());
		ocrmFwpTodoWorkSon.setLastChgUsrOrgId(dto.getBody().getOrg().getId());
		ocrmFwpTodoWorkSon.setLastChgUsrOrgName(dto.getBody().getOrg().getName());
		ocrmFwpTodoWorkSon.setLastChgDate(new Date());
		try {
			ocrmFwpTodoWorkSon.setLastChgDate(s.parse(s.format(ocrmFwpTodoWorkSon.getLastChgDate())));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		ocrmFwpTodoWorkSon.setTodoWorkId(ocrmFwpTodoWork.getTodoWorkId());
		ocrmFwpTodoWorkSon.setTodoWorkContent(ocrmFwpTodoWork.getTodoWorkContent());
		ocrmFwpTodoWorkSon.setRelationCust(ocrmFwpTodoWork.getRelationCust());
		return ocrmFwpTodoWorkSonMapper.updateSon(ocrmFwpTodoWorkSon);
	}

	public int updateSons(OcrmFwpTodoWork ocrmFwpTodoWork) {
		// TODO 自动生成的方法存根
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		OcrmFwpTodoWorkSon ocrmFwpTodoWorkSon = new OcrmFwpTodoWorkSon();
		ocrmFwpTodoWorkSon.setLastChgUsrId(dto.getBody().getLoginCode());
		ocrmFwpTodoWorkSon.setLastChgUsrName(dto.getBody().getUserName());
		ocrmFwpTodoWorkSon.setLastChgUsrOrgId(dto.getBody().getOrg().getId());
		ocrmFwpTodoWorkSon.setLastChgUsrOrgName(dto.getBody().getOrg().getName());
		ocrmFwpTodoWorkSon.setLastChgDate(new Date());
		try {
			ocrmFwpTodoWorkSon.setLastChgDate(s.parse(s.format(ocrmFwpTodoWorkSon.getLastChgDate())));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		ocrmFwpTodoWorkSon.setTodoWorkId(ocrmFwpTodoWork.getTodoWorkId());
		ocrmFwpTodoWorkSon.setStartDate(ocrmFwpTodoWork.getStartDate());
		ocrmFwpTodoWorkSon.setTodoWorkContent(ocrmFwpTodoWork.getTodoWorkContent());
		ocrmFwpTodoWorkSon.setRelationCust(ocrmFwpTodoWork.getRelationCust());
		return ocrmFwpTodoWorkSonMapper.updateSons(ocrmFwpTodoWorkSon);
	}
}
