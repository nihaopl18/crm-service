package cn.com.yusys.yscrm.mktactivity.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiTargetInfo;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActiTargetMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

@Service
public class OcrmFMkActiTargetService extends CommonService{
	@Autowired
	private OcrmFMkActiTargetMapper mapper;
	@Autowired
	private UaaClient uaaClient;
	@Autowired
	private OcrmFMkActivityService service;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiTargetInsert
	* @方法描述: 营销成效指标新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiTargetInsert(OcrmFMkActiTargetInfo[] record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		for(int i=0;i<record.length;i++) {
			// 设置主键
			record[i].setTargetId(mapper.getSeq());
			// 设置创建信息
			record[i].setCreateDate(df.parse(df.format(new Date())));
			record[i].setCreateOrg(org.getBody().getOrg().getCode());
			record[i].setCreateUser(SecurityUtils.getCurrentUserLogin());
			// 设置更新信息
			record[i].setUpdateDate(record[i].getCreateDate());
			record[i].setUpdateOrg(record[i].getCreateOrg());
			record[i].setUpdateUser(record[i].getCreateUser());
			mapper.insertSelective(record[i]);
		}
		dto.setCode(0);
		dto.setMessage("新增成功");
		// 新增失败则删除上一步输入数据
		if(dto.getCode() == -1) {
			service.actiErrorDel(record[0].getActiId());
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiTargetEdit
	* @方法描述: 营销成效指标修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiTargetEdit(OcrmFMkActiTargetInfo[] record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		// 判断关联指标是否为空
		if(record.length == 0) {
			dto.setCode(-1);
			dto.setMessage("未关联指标");
		} else {
			// 删除上次关联的指标
			mapper.lastTargetDel(record[0].getActiId());
			for(int i=0;i<record.length;i++) {
				// 设置主键
				record[i].setTargetId(mapper.getSeq());
				// 设置创建信息
				record[i].setCreateDate(df.parse(df.format(new Date())));
				record[i].setCreateOrg(org.getBody().getOrg().getCode());
				record[i].setCreateUser(SecurityUtils.getCurrentUserLogin());
				// 设置更新信息
				record[i].setUpdateDate(record[i].getCreateDate());
				record[i].setUpdateOrg(record[i].getCreateOrg());
				record[i].setUpdateUser(record[i].getCreateUser());
				mapper.insertSelective(record[i]);
			}
			dto.setCode(0);
			dto.setMessage("修改成功");
		}
		return dto;
	}
	/**
	* @方法名称: getTargetPie
	* @方法描述: 营销成效指标目标机构占比图
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getTargetPie(QueryModel model) {
		return mapper.getTargetPie(model);
	}
	/**
	* @方法名称: getTargetBar
	* @方法描述: 营销成效指标目标机构完成情况对比图
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getTargetBar(QueryModel model) {
		return mapper.getTargetBar(model);
	}
	/**
	* @方法名称: getCmBar
	* @方法描述: 营销成效指标目标客户经理进展图
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getCmBar(QueryModel model) {
		return mapper.getCmBar(model);
	}
	/**
	* @方法名称: getCmPie
	* @方法描述: 营销成效指标目标客户经理占比图
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getCmPie(QueryModel model){
		return mapper.getCmPie(model);
	}
}