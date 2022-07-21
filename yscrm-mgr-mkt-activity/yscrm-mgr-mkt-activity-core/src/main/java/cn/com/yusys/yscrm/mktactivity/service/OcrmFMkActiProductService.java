package cn.com.yusys.yscrm.mktactivity.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiProductInfo;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActiProductMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

@Service
public class OcrmFMkActiProductService extends CommonService{
	@Autowired
	private OcrmFMkActiProductMapper mapper;
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
	* @方法名称: actiProdInsert
	* @方法描述: 关联产品新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiProdInsert(OcrmFMkActiProductInfo[] record) throws ParseException {
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
	* @方法名称: actiProdEdit
	* @方法描述: 关联产品修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiProdEdit(OcrmFMkActiProductInfo[] record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		// 判断是否关联产品
		if(record.length == 0) {
			dto.setCode(-1);
			dto.setMessage("未关联产品");
		} else {
			// 删除上次关联的产品
			// mapper.lastProdDel(record[0].getActiId());
			// 新增本次关联产品
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