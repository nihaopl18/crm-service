package cn.com.yusys.yscrm.sysview.service;


import cn.com.yusys.yscrm.sysview.domain.CimFMmFTagGroup;
import cn.com.yusys.yscrm.sysview.domain.TagTree;
import cn.com.yusys.yscrm.sysview.domain.activity.TouchSRC;
import cn.com.yusys.yscrm.sysview.repository.mapper.CimFMmFTagGroupMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CimFMmFTagGroupService extends CommonService{
	@Autowired
	private CimFMmFTagGroupMapper mapper;
	@Autowired
	private UaaClient uaaClient;
//	@Autowired
//	private UserInfoService userInfo;
	
	private final Logger logger = LoggerFactory.getLogger(CimFMmFTagGroupService.class);
	
	@Override
	protected CommonMapper getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}
	/**
	 * 分组查询
	 * @return
	 */
	public List<CimFMmFTagGroup> getGroupTree(){
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		return this.mapper.getGroupTree(user.getLoginCode());
	}

	/**
	 * 系统标签组、全部标签分组查询
	 * @return
	 */
	public List<CimFMmFTagGroup> getSystemTree(){
		return this.mapper.getSystemTree();
	}
	
	/**
	 * 分组新增
	 * @param record
	 * @return
	 */
	public CimFMmFTagGroup saveTagGroup(CimFMmFTagGroup record){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		java.util.Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		record.setCreateDate(time);
		record.setCreateUser(SecurityUtils.getCurrentUserLogin());
//		record.setCreateOrg(userInfo.getOrgCode());
		record.setGroupNo(this.mapper.getSeq());
		if("1".equals(record.getParentNo())) {
			record.setSystemGroup("1");
		}else {
			record.setSystemGroup("0");
		}
		record.setCreateSys("CRM");
		if(this.insertSelective(getMapper(), record) != 1) {
			return null;
		}
		return record;

	}

	public int deleteTagGroup(QueryModel model){
		return this.mapper.deleteTagGroup(model);
	}

	public int updateTagGroup(CimFMmFTagGroup record){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		java.util.Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  record.setModifyTime(time);
		  record.setModifyUser(SecurityUtils.getCurrentUserLogin());//获取用户
		  
		return this.mapper.modifyTagGroup(record);
	}
	
	public List<CimFMmFTagGroup> getByParentNo(QueryModel model){
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		model.getCondition().put("loginCode",user.getLoginCode());
		return this.mapper.getByParentNo(model);
	}
	
	public List<CimFMmFTagGroup> getChild(QueryModel model){
		return this.mapper.getChild(model);
	}

	public List<CimFMmFTagGroup> getCustomTree(String groupNo){
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		QueryModel model=new QueryModel();
		model.getCondition().put("groupNo",groupNo);
		model.getCondition().put("loginCode",user.getLoginCode());
		return this.mapper.getChildByNo(model);
	}

    public List<TagTree> getTagsTree(String groupNo, String custId) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		QueryModel model=new QueryModel();
		model.getCondition().put("custId",custId);
		model.getCondition().put("groupNo",groupNo);
		model.getCondition().put("loginCode",user.getLoginCode());
		List<TagTree> list = this.mapper.getTagsTree(model);
		Map<String, List<TagTree>> resultMap = list.stream()
				.collect(Collectors.groupingBy(TagTree::getGroupNo));
		List<TagTree> resultList = this.getTree(resultMap,"1023");
		return resultList;
    }

	public String getGroupName(String groupNo) {
		return this.mapper.getGroupName(groupNo);
	}

	public List<TagTree> getTree(Map<String, List<TagTree>> resultMap, String groupNo){
		List<TagTree> resultList = new ArrayList<>();
		List<TagTree> groupList = resultMap.get(groupNo);
		if (groupList != null && groupList.size() >0){
			for (TagTree ta : groupList) {
				List<TagTree> list = getTree(resultMap,ta.getTagNo());
				ta.setChildren((list));
				resultList.add(ta);
			}
		}
		return resultList;
	}
}
