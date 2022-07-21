package cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcChannelMgr;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcChannelMgrMapper
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
public interface CmFRcChannelMgrMapper extends CommonMapper<CmFRcChannelMgr>{
	// 查询渠道管理表
	List<CmFRcChannelMgr> getList(QueryModel model);
	// 删除渠道管理表数据
	int deleteList(String channelId);
	// 获取渠道名称
	List<Map<String,Object>>getChannelName();
	// 返回使用中的渠道
	int getApplyChannel(String channelName);
	// 根据id返回渠道名称
	String getChannelNameById(String channelId);
	// 渠道名称验重
	int getSameName(CmFRcChannelMgr record);
	// 服务器密码加密
	String encrypt(String pswd);
	// 服务器密码解密
	String decrypt(String pswd);
}
