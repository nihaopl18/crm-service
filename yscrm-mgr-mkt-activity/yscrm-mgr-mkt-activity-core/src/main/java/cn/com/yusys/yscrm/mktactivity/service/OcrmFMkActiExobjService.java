package cn.com.yusys.yscrm.mktactivity.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiExobjInfo;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActiExobjMapper;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActivityMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

@Service
public class OcrmFMkActiExobjService extends CommonService{
	@Autowired
	private OcrmFMkActiExobjMapper mapper;
	@Autowired
	private OcrmFMkActivityMapper mapperAct;
	@Autowired
	private UaaClient uaaClient;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiTargetDecom
	* @方法描述: 营销活动分配
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiTargetDecom(OcrmFMkActiExobjInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		// 	获取主键
		record.setObjId(mapperAct.getSeq());
		// 获取登录信息
		record.setCreateDate(df.parse(df.format(new Date())));
		record.setCreateUser(SecurityUtils.getCurrentUserLogin());
		record.setCreateOrg(org.getBody().getOrg().getCode());
		record.setUpdateUser(record.getCreateUser());
		record.setUpdateDate(record.getUpdateDate());
		record.setUpdateOrg(record.getCreateOrg());
		mapper.insertSelective(record);
		dto.setCode(0);
		dto.setMessage("分配成功");
		return dto;
	}
}