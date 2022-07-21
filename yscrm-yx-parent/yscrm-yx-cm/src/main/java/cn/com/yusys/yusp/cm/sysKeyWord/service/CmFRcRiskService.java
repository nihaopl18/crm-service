package cn.com.yusys.yusp.cm.sysKeyWord.service;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcRiskInfo;
import cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper.CmFRcRiskMapper;
import cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper.CmFRcSysTypeMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcRiskService
 * @类描述: 关注风险配置接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-06 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcRiskService extends CommonService{
	@Autowired
	private CmFRcRiskMapper mapper;
	
	@Autowired
	private CmFRcSysTypeMapper typeMapper;
	
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}
	/**
	 * 
	* @方法名称: getList
	* @方法描述: 查询关注风险表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<CmFRcRiskInfo> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcRiskInfo> list = mapper.getList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	 * 
	* @方法名称: deleteList
	* @方法描述: 删除关注风险表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> deleteList(CmFRcRiskInfo record) {
		String[] str = record.getRiskId().split(",");
		for(int i=0;i<str.length;i++) {
			record.setRiskId(str[i]);
			mapper.deleteList(record);
		}
		ResultDto<Integer> dto = new ResultDto<Integer>();
		return dto;
	}
	/**
	 * 
	* @方法名称: insertList
	* @方法描述: 新增关注风险表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> insertList(CmFRcRiskInfo record) {
		// 设置id
		record.setRiskId(mapper.getSeq());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 设置创建人 
		record.setCreatUser(SecurityUtils.getCurrentUserLogin());
		// 设置创建时间 
		record.setCreatDate(df.format(new Date()));
		// 设置创建人名称
		record.setCreatUserName(typeMapper.getUserName(record.getCreatUser()));
		// 设置修改人
		record.setUpdataUser(record.getCreatUser());
		// 设置修改时间	
		record.setUpdataDate(record.getCreatDate());
		// 设置修改人名称
		record.setUpdataUserName(record.getCreatUserName());
		
		mapper.insertSelective(record);
		ResultDto<Integer> dto = new ResultDto<Integer>();
		return dto;
	}
	/**
	 * 
	* @方法名称: updateList
	* @方法描述: 修改关注风险表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> updateList(CmFRcRiskInfo record) {
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 设置修改人
		record.setUpdataUser(SecurityUtils.getCurrentUserLogin());
		// 设置修改时间	
		record.setUpdataDate(df.format(new Date()));
		// 设置修改人名称
		record.setUpdataUserName(typeMapper.getUserName(record.getUpdataUser()));
		
		mapper.updateByPrimaryKeySelective(record);
		ResultDto<Integer> dto = new ResultDto<Integer>();
		return dto;
	}
}
