package cn.com.yusys.yusp.cm.monitoring.service;

import cn.com.yusys.yusp.cm.monitoring.repository.mapper.OrgMonitoringMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * 营销活动策划——营销活动管理
 * @author zhanghan3
 * 20181113
 */
@Service
public class OrgMonitoringService  extends CommonService{
	
	@Autowired
	private OrgMonitoringMapper orgMonitoringMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return this.orgMonitoringMapper;
	}
	//页面主表格查询
	public List<Map<String, Object>> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		return orgMonitoringMapper.getList(model);
	}
	//查询执行中信息
	public List<Map<String, Object>> getImpList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		return orgMonitoringMapper.getImpList(model);
	}
	//查询 执行成功信息
	public List<Map<String, Object>> getSuccessList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		return orgMonitoringMapper.getSuccessList(model);
	}
	//查询执行失败信息
	public List<Map<String, Object>> getFailedList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		return orgMonitoringMapper.getFailedList(model);
	}
}
