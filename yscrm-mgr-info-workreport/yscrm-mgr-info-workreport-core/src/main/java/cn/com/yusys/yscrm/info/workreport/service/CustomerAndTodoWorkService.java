package cn.com.yusys.yscrm.info.workreport.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.info.workreport.domain.OcrmFwpTodoWork;
import cn.com.yusys.yscrm.info.workreport.repository.mapper.CustmerAndTodoWorkMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
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
public class CustomerAndTodoWorkService extends CommonService {
	@Autowired
	private CustmerAndTodoWorkMapper custmerAndTodoWorkMapper;

	@Autowired
	private UaaClient uaaClient;

	@Override
	protected CommonMapper<?> getMapper() {
		return custmerAndTodoWorkMapper;
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
	 * @方法名称: addOneTodoWork
	 * @方法描述: 新增一次性待办事项
	 * @参数与返回说明:
	 * @算法描述: 新增待办事项表
	 */
	public int addOneTodoWork(OcrmFwpTodoWork ocrmFwpTodoWork) {
		// TODO 增加异常处理
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		ocrmFwpTodoWork.setTodoWorkId(getUuid());
		ocrmFwpTodoWork.setIsDelete("N");
		ocrmFwpTodoWork.setTodoWorkState("1");
		ocrmFwpTodoWork.setIsNotice("N");
		ocrmFwpTodoWork.setTodoWorkType("5");
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			if (ocrmFwpTodoWork.getCreateDate() != null) {
				ocrmFwpTodoWork.setCreateDate(s.parse(s.format(ocrmFwpTodoWork.getCreateDate())));
			}
			if (ocrmFwpTodoWork.getStartDate() != null) {
				ocrmFwpTodoWork.setStartDate(s.parse(s.format(ocrmFwpTodoWork.getStartDate())));
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return this.insertSelective(ocrmFwpTodoWork);
	}

	public void addOneTodoWork(List<OcrmFwpTodoWork> list) {
		// TODO 增加异常处理
		list.forEach(this::addOneTodoWork);
	}
}
