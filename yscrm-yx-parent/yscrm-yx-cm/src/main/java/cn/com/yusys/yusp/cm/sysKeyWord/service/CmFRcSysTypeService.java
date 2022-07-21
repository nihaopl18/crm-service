package cn.com.yusys.yusp.cm.sysKeyWord.service;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcSysTypeInfo;
import cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper.CmFRcSysTypeMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcSysTypeService
 * @类描述: 渠道营销模板接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-10-17 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcSysTypeService extends CommonService{
	@Autowired
	private CmFRcSysTypeMapper mapper;
	
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	
	/*
	 * 查询渠道营销模板表
	 */
	@Transactional(readOnly = true)
	public List<CmFRcSysTypeInfo> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcSysTypeInfo> list = mapper.getList(model);
		PageHelper.clearPage();
		return list;
	}
	
	/*
	 * 营销动作组件查询模板信息
	 */
	@Transactional(readOnly = true)
	public List<CmFRcSysTypeInfo> getListByNodeId(String modelId) {
		Map<String,Object> param=new HashMap<String,Object>();
		if(modelId !=null) {
			param.put("modelId", modelId.split(","));
		}
		List<CmFRcSysTypeInfo> list = mapper.getListByNodeId(param);
		return list;
	}
	/*
	 * 删除渠道营销模板表
	 */
	public ResultDto<Integer> deleteList(CmFRcSysTypeInfo record) {
		String[] del_str = record.getId().split(",");
		String dto_data = record.getId();
		for (int i=0;i<del_str.length;i++) {
			record.setId(del_str[i]);
			mapper.deleteList(record);
		}
		ResultDto<Integer> dto = new ResultDto<Integer>();
		dto.setMessage(dto_data);
		return dto;
	}
	/*
	 * 新增渠道营销模板表
	 */
	public ResultDto<Integer> insertList(CmFRcSysTypeInfo record) {
		// 设置id
		record.setId(mapper.getSeq());
		// 设置创建人
		record.setCreatUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 设置创建日期
		record.setCreatDate(df.format(new Date()));
		// 设置创建人名称
		record.setCreatUserName(mapper.getUserName(record.getCreatUser()));
		// 设置最近修改人
		record.setUpdataUser(record.getCreatUser());
		// 设置最近修改日期
		record.setUpdataDate(record.getCreatDate());
		// 设置最近修改人名称
		record.setUpdataUserName(mapper.getUserName(record.getUpdataUser()));
		// 设置适用对象名称
		if("PRODUCT".equals(record.getApplyType())) {
			record.setApplyObjectName(mapper.getProdName(record.getApplyObject()));
		}
		if("RISK".equals(record.getApplyType())) {
			if("01".equals(record.getApplyObject())) {
				record.setApplyObjectName("交易风险");
			} else if ("02".equals(record.getApplyObject())) {
				record.setApplyObjectName("业务风险");
			}
		}
		if("CARE".equals(record.getApplyType())) {
			if("03".equals(record.getApplyObject())) {
				record.setApplyObjectName("生日关怀");
			}
		}
		if("PRODCATL".equals(record.getApplyType())) {
			int catlCode = Integer.parseInt(record.getApplyObject());
			record.setApplyObjectName(mapper.getApplyObjectName(catlCode));
		}
		// 返回报文
		ResultDto<Integer> dto = new ResultDto<Integer>();
		if(mapper.getSameName(record) == 0) {
			// 名称未重复
			mapper.insertSelective(record);
			dto.setCode(0);
			dto.setMessage("新增成功");
		} else {
			dto.setCode(-1);
			dto.setMessage("模板名称重复");
		}
		return dto;
	}
	/*
	 * 修改渠道营销模板表
	 */
	public ResultDto<Integer> updateList(CmFRcSysTypeInfo record) {
		// 设置最近修改人
		record.setUpdataUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 设置最近修改日期
		record.setUpdataDate(df.format(new Date()));
		// 设置最近修改人名称
		record.setUpdataUserName(mapper.getUserName(record.getUpdataUser()));
		// 设置适用对象名称
		if("PRODUCT".equals(record.getApplyType())) {
			record.setApplyObjectName(mapper.getProdName(record.getApplyObject()));
		}
		if("RISK".equals(record.getApplyType())) {
			if("01".equals(record.getApplyObject())) {
				record.setApplyObjectName("交易风险");
			} else if ("02".equals(record.getApplyObject())) {
				record.setApplyObjectName("业务风险");
			}
		}
		if("CARE".equals(record.getApplyType())) {
			if("03".equals(record.getApplyObject())) {
				record.setApplyObjectName("生日关怀");
			}
		}
		if("PRODCATL".equals(record.getApplyType())) {
			int catlCode = Integer.parseInt(record.getApplyObject());
			record.setApplyObjectName(mapper.getApplyObjectName(catlCode));
		}
		// 返回报文
		ResultDto<Integer> dto = new ResultDto<Integer>();
		if(mapper.getSameName(record) == 0) {
			// 名称未重复
			mapper.updateByPrimaryKeySelective(record);
			dto.setCode(0);
			dto.setMessage("更新成功");
		} else {
			dto.setCode(-1);
			dto.setMessage("模板名称重复");
		}
		return dto;
	}
	/*
	 * 获取关键字/别名
	 */
	public List<Map<String, Object>>getAliasName(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> aliasNameList = mapper.getAliasName(model);
		PageHelper.clearPage();
		return aliasNameList;

	}
	/*
	 * 产品视图查询渠道模型表
	 */
	public List<CmFRcSysTypeInfo>getListProd(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcSysTypeInfo> list = mapper.getListProd(model);
		PageHelper.clearPage();
		return list;
	}

	public List<CmFRcSysTypeInfo> selectByIdList(List<String> actionIdList) {
		return mapper.selectByIdList(actionIdList);
	}
}
