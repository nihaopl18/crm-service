package cn.com.yusys.yscrm.mktactivity.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiCustInfo;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActiCustMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

@Service
public class OcrmFMkActiCustService extends CommonService{
	@Autowired
	private OcrmFMkActiCustMapper mapper;
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
	* @方法名称: actiCustInsert
	* @方法描述: 关联客户新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiCustInsert(OcrmFMkActiCustInfo[] record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		for(int i=0;i<record.length;i++) {
			// 设置主键
			record[i].setRecordId(mapper.getSeq());
			// 设置关联客户日期
			record[i].setRelationDate(df.parse(df.format(new Date())));
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
	* @方法名称: prodFitCustInfo
	* @方法描述: 查询关联产品的目标客户
	* @参数与返回说明: 
	* @算法描述:
	**/
	 public List<Map<String,Object>> prodFitCustInfo(String prodIds){
		 String[] prodId=prodIds.split(",");
		 Map<String,Object> param =new HashMap<String,Object>();
		 List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
		 param.put("prodId", prodId);
		 result=mapper.prodFitCustInfo(param);
		 return result;
	 }
		/**
		* @throws ParseException 
		* @方法名称: custGroupCustInfo
		* @方法描述: 查询客户群客户信息
		* @参数与返回说明: 
		* @算法描述:
		**/
	  public List<Map<String,Object>> custGroupCustInfo(String groupIds){
			 String[] groupId=groupIds.split(",");
			 Map<String,Object> param =new HashMap<String,Object>();
			 List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
			 param.put("groupId", groupId);
			 result=mapper.custGroupCustInfo(param);
			 return result;
		 }
		/**
		* @throws ParseException 
		* @方法名称: userInfoByNo
		* @方法描述: 根据用户ID或者登录号查询用户信息
		* @参数与返回说明: 
		* @算法描述:
		**/
	  public List<Map<String,Object>> userInfoByNo(String userIds){
			 String[] userId=userIds.split(",");
			 Map<String,Object> param =new HashMap<String,Object>();
			 List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
			 param.put("userId", userId);
			 result=mapper.userInfoByNo(param);
			 return result;
		 }
	  
		/**
		* @throws ParseException 
		* @方法名称: getIndexInfoByProdId
		* @方法描述: 查询指标信息根据产品编号
		* @参数与返回说明: 
		* @算法描述:
		**/
	  public List<Map<String,Object>> getIndexInfoByProdId( QueryModel model){
		  PageHelper.startPage(model.getPage(), model.getSize());
		  	String prodIds=model.getCondition().get("prodId").toString();
		  	String[] id=prodIds.split(",");
		  	model.getCondition().put("prodId", id);
			List<Map<String,Object>> list = mapper.getIndexInfoByProdId(model);
			PageHelper.clearPage();
			 return list;
		 }
	  
	/**
	* @throws ParseException 
	* @方法名称: actiCustEdit
	* @方法描述: 关联客户修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> actiCustEdit(OcrmFMkActiCustInfo[] record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		// 判断是否关联客户
		if(record.length == 0) {
			dto.setCode(-1);
			dto.setMessage("未关联客户");
		} else {
			// 删除上次关联客户
			// mapper.lastCustDel(record[0].getActiId());
			for(int i=0;i<record.length;i++) {
				// 设置主键
				record[i].setRecordId(mapper.getSeq());
				// 设置关联客户日期
				record[i].setRelationDate(df.parse(df.format(new Date())));
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