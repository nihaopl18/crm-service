package cn.com.yusys.yscrm.mktactivity.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiAttachRelInfo;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActiAttachRelMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

@Service
public class OcrmFMkActiAttachRelService extends CommonService{
	@Autowired
	private OcrmFMkActiAttachRelMapper mapper;
	@Autowired
	private OcrmFMkActivityService service;
	@Autowired
	private UaaClient uaaClient;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiFileInsert
	* @方法描述: 关联附件新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiFileInsert(OcrmFMkActiAttachRelInfo[] record) throws ParseException{
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		for(int i=0;i<record.length;i++) {
			// 设置主键
			record[i].setRecordId(mapper.getSeq());
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
	* @方法名称: actiFileEdit
	* @方法描述: 关联附件修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiFileEdit(OcrmFMkActiAttachRelInfo[] record) throws ParseException{
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		// 判断关联附件是否为空
		if(record.length == 0) {
			dto.setCode(-1);
			dto.setMessage("未添加关联附件");
		} else {
			// 删除上次关联的附件
			mapper.lastFileDel(record[0].getActiId());
			for(int i=0;i<record.length;i++) {
				// 设置主键
				record[i].setRecordId(mapper.getSeq());
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
}
