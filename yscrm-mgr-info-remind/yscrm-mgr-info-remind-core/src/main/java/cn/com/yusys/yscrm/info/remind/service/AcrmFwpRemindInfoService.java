package cn.com.yusys.yscrm.info.remind.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.info.remind.domain.AcrmFwpRemindInfo;
import cn.com.yusys.yscrm.info.remind.repository.mapper.AcrmFwpRemindInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: AcrmFwpRemindInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-10-22 11:14:59
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFwpRemindInfoService extends CommonService {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AcrmFwpRemindInfoMapper acrmFwpRemindInfoMapper;

	@Autowired
	private UaaClient uaaClient;

	@Override
	protected CommonMapper<AcrmFwpRemindInfo> getMapper() {
		// TODO 自动生成的方法存根
		return acrmFwpRemindInfoMapper;
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

	public List<Map<String, Object>> queryList(QueryModel queryModel) {
		// TODO 自动生成的方法存根
		List<Map<String, Object>> list = null;
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		list = acrmFwpRemindInfoMapper.queryList(queryModel);
		PageHelper.clearPage();
		return list;
	}

	public int getIsReadNum(QueryModel queryModel) {
		return acrmFwpRemindInfoMapper.getIsReadNum(queryModel);
	}

	public int updateState(String infoId) {
		// TODO 自动生成的方法存根
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return acrmFwpRemindInfoMapper.updateStateByInfoId(infoId,s.format(new Date()));
	}

	public int updateStatAll(String userId) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return acrmFwpRemindInfoMapper.updateStateByUserId(userId,s.format(new Date()));
	}

	public int updateStateByIssuDate(String currentDate) {
		// TODO 自动生成的方法存根
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String userId = dto.getBody().getUserId();
		return acrmFwpRemindInfoMapper.updateStateByIssuDate(userId,currentDate);
	}

	public int addOne(AcrmFwpRemindInfo acrmFwpRemindInfo) {
		// TODO 自动生成的方法存根
		if (acrmFwpRemindInfo.getInfoId() == null || "".equals(acrmFwpRemindInfo.getInfoId())) {
			acrmFwpRemindInfo.setInfoId(getUuid());
		}
		if (acrmFwpRemindInfo.getBusiId() == null || "".equals(acrmFwpRemindInfo.getBusiId())) {
			acrmFwpRemindInfo.setBusiId(acrmFwpRemindInfo.getInfoId());
		}
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		try {
			time = s.format(date);
			date = s.parse(time);

		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			this.log.error("日期格式化出错", e);
		}
		if (acrmFwpRemindInfo.getCreateDate() == null) {
			acrmFwpRemindInfo.setCreateDate(date);
		}
		if (acrmFwpRemindInfo.getIssueDate() == null) {
			acrmFwpRemindInfo.setIssueDate(date);
		}
		if (acrmFwpRemindInfo.getCreateDate().getTime() < acrmFwpRemindInfo.getIssueDate().getTime()) {
			acrmFwpRemindInfo.setInfoState("0");
		} else {
			acrmFwpRemindInfo.setInfoState("1");
		}
		return this.insertSelective(acrmFwpRemindInfoMapper, acrmFwpRemindInfo);
	}

	public int addlist(List<AcrmFwpRemindInfo> list) {
		// TODO 自动生成的方法存根
		int result = 0;
		for (AcrmFwpRemindInfo acrmFwpRemindInfo : list) {
			result += this.addOne(acrmFwpRemindInfo);
		}
		return result;
	}

}
