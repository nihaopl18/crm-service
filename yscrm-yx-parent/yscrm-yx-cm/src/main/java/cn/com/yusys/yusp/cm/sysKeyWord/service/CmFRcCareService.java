package cn.com.yusys.yusp.cm.sysKeyWord.service;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcCareInfo;
import cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper.CmFRcCareMapper;
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
 * @类名称: CmFRcCareMapper
 * @类描述: 客户关怀配置接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-067
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcCareService extends CommonService{
	@Autowired
	private CmFRcCareMapper mapper;
	
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
	* @方法描述: 查询客户关怀表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<CmFRcCareInfo> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcCareInfo> list = mapper.getList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	 * 
	* @方法名称: deleteList
	* @方法描述: 删除客户关怀表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> deleteList(CmFRcCareInfo record) {
		String[] str = record.getCareId().split(",");
		for(int i=0;i<str.length;i++) {
			record.setCareId(str[i]);
			mapper.deleteList(record);
		}
		ResultDto<Integer> dto = new ResultDto<Integer>();
		return dto;
	}
	/**
	 * 
	* @方法名称: insertList
	* @方法描述: 新增客户关怀表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> insertList(CmFRcCareInfo record) {
		// 设置id
		record.setCareId(mapper.getSeq());
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
	* @方法描述: 修改客户关怀表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> updateList(CmFRcCareInfo record) {
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
