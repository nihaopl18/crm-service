package cn.com.yusys.yusp.cm.sysKeyWord.service;

import cn.com.yusys.yusp.cm.market.domain.CimpCmAsseminfo;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmAssemblyMapper;
import cn.com.yusys.yusp.cm.market.service.CimpCmAssemiblyService;
import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcChannelMgr;
import cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper.CmFRcChannelMgrMapper;
import cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper.CmFRcSysTypeMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcChannelMgrService
 * @类描述: 渠道管理接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-14 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcChannelMgrService extends CommonService{
	@Autowired
	private CmFRcChannelMgrMapper mapper;
	@Autowired
	private CmFRcSysTypeMapper typeMapper;
	@Autowired
	private CimpCmAssemiblyService assService;
	@Autowired
	private CimpCmAssemblyMapper connMapper;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	 * 
	* @方法名称: getList
	* @方法描述: 查询渠道管理表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<CmFRcChannelMgr> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcChannelMgr> list = mapper.getList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	 * 
	* @方法名称: deleteList
	* @方法描述: 删除渠道管理表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> deleteList(CmFRcChannelMgr record) {
		String[] str = record.getChannelId().split(",");
		String[] itemId = record.getChannelItemId().split(","); 
		boolean flag = true;
		for(int i=0;i<str.length;i++) {
			if(mapper.getApplyChannel(record.getChannelName()) == 0) {
				assService.deleteByPrimaryKey(itemId[i]);
				// 如果渠道未使用则删除
				mapper.deleteList(str[i]);
			} else {
				// 如果渠道正在使用则不删除
				flag = false;
				break;
			}
		}
		ResultDto<Integer> dto = new ResultDto<Integer>();
		if(flag) {
			dto.setCode(0);
			dto.setMessage("删除成功");
		} else {
			dto.setCode(-1);
			dto.setMessage("删除失败,渠道正在使用中");
		}
		return dto;
	}
	/**
	 * 
	* @throws ParseException 
	 * @方法名称: insertList
	* @方法描述: 新增渠道管理表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> insertList(CmFRcChannelMgr record) throws ParseException {
		// 设置id
		record.setChannelId(getUUID());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 设置创建人 
		record.setCreatUser(SecurityUtils.getCurrentUserLogin());
		// 设置创建人名称
		record.setCreatUserName(typeMapper.getUserName(record.getCreatUser()));
		// 设置创建时间 
		record.setCreatDate(df.parse(df.format(new Date())));
		// 设置修改人
		record.setUpdataUser(record.getCreatUser());
		// 设置修改人名称
		record.setUpdataUserName(record.getCreatUserName());
		// 设置修改时间	
		record.setUpdataDate(record.getCreatDate());
		// 服务器密码加密
		if(record.getFileServerPswd() != null) {
			record.setFileServerPswd(mapper.encrypt(record.getFileServerPswd()));
		}
		ResultDto<Integer> dto = new ResultDto<Integer>();
		if(mapper.getSameName(record) == 0) {
			// 名称未重复
			mapper.insertSelective(record);
			dto.setCode(0);
			dto.setMessage("新增成功");
		} else {
			// 名称重复新增失败
			dto.setCode(-1);
			dto.setMessage("新增失败，渠道名称重复");
		}
		return dto;
	}
	/**
	 * 
	* @throws ParseException 
	 * @方法名称: updateList
	* @方法描述: 修改渠道管理表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> updateList(CmFRcChannelMgr record) throws ParseException {
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 设置修改人
		record.setUpdataUser(SecurityUtils.getCurrentUserLogin());
		// 设置修改人名称
		record.setUpdataUserName(typeMapper.getUserName(record.getUpdataUser()));
		// 设置修改时间	
		record.setUpdataDate(df.parse(df.format(new Date())));
		// 服务器密码加密
		if(record.getFileServerPswd() != null) {
//			record.setFileServerPswd(mapper.encrypt(record.getFileServerPswd()));
			record.setFileServerPswd(record.getFileServerPswd());
		}		
		// 更新数据
		ResultDto<Integer> dto = new ResultDto<Integer>();
		if(mapper.getSameName(record) == 0) {
			if(mapper.getApplyChannel(mapper.getChannelNameById(record.getChannelId())) == 0) {
				//组件表
				CimpCmAsseminfo assInfo = assService.selectByPrimaryKey(record.getChannelItemId());
				assInfo.setAssemblyName(record.getChannelName());
				int i = connMapper.updateByPrimaryKeySelective(assInfo);

				// 如果渠道未使用则更新
				int j = mapper.updateByPrimaryKeySelective(record);
				dto.setCode(0);
				dto.setMessage("修改成功");
			} else {
				// 如果渠道使用中则不更新
				dto.setCode(-2);
				dto.setMessage("修改失败，渠道正在使用中");
			}
		} else {
			// 渠道名称重复
			dto.setCode(-1);
			dto.setMessage("修改失败，渠道名称重复");
		}
		
		return dto;
	}
	/**
	    * @方法名称: getChannelName
	    * @方法描述: 获取渠道名称
	    * @参数与返回说明: 
	    * @算法描述: 
	    */
	public List<Map<String,Object>>getChannelName() {
		return mapper.getChannelName();
	}
	/**
	    * @方法名称: getUUID
	    * @方法描述: UUID生成器
	    * @参数与返回说明: 
	    * @算法描述: 
	    */
	private String getUUID() {
		return UUID.randomUUID().toString().toLowerCase().replace("-", "");
	}
}
