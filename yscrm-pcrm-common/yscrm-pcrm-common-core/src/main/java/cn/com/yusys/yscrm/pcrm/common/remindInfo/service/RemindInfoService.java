package cn.com.yusys.yscrm.pcrm.common.remindInfo.service;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.DemoDTO;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.EchainJoinWorkEndDTO;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.EchainJoinWorkTodoDTO;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.RemindInfo;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.repository.mapper.RemindInfoMapper;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExeclParseUtil;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.FileUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: yscrm-pcrm-common-core模块
 * @类名称: AcrmFwpRemindInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-11-04 11:31
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class RemindInfoService extends CommonService {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RemindInfoMapper acrmFwpRemindInfoMapper;

	@Override
	protected CommonMapper<RemindInfo> getMapper() {
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
	public int addOne(RemindInfo acrmFwpRemindInfo) {
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

	public int addlist(List<RemindInfo> list) {
		// TODO 自动生成的方法存根
		int result = 0;
		for (RemindInfo acrmFwpRemindInfo : list) {
			result += this.addOne(acrmFwpRemindInfo);
		}
		return result;
	}

	public List<EchainJoinWorkTodoDTO> selectUserTodos(QueryModel model) {
			PageHelper.startPage(model.getPage(), model.getSize());
			List<EchainJoinWorkTodoDTO> todos = acrmFwpRemindInfoMapper.selectUserTodos(model);
			PageHelper.clearPage();
			return todos;
		}

	public List<EchainJoinWorkEndDTO> selectUserEnds(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<EchainJoinWorkEndDTO> todos = acrmFwpRemindInfoMapper.selectUserEnds(model);
		PageHelper.clearPage();
		return todos;
	}

	public List<EchainJoinWorkTodoDTO> selectUserDones(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<EchainJoinWorkTodoDTO> todos = acrmFwpRemindInfoMapper.selectUserDones(model);
		PageHelper.clearPage();
		return todos;
	}

	public Map<String, Object> uploadFile(MultipartFile file) {
		Map<String, Object> reMap = new HashMap<>();
		try {
			InputStream stream = FileUtil.vaildataFile(file);
			ExeclParseUtil execlParseUtil = new ExeclParseUtil();
			List<DemoDTO> execlList = execlParseUtil.getEntity(stream, DemoDTO.class);

				//批量插入数据，可在前做个删除


			reMap.put("message", "succese");
			return reMap;
		} catch (Exception e) {
			reMap.put("error",e.getMessage());
			reMap.put("message","error");
			return reMap;
		}
	}
}
