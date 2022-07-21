package cn.com.yusys.yusp.cm.cust.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.com.yusys.yusp.cm.cust.domain.CimFMmTagAuthInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * 
 * @项目名称: yusp-app-cim
 * @类名称: CimFMmTagAuthMapper
 * @类描述: 
 * @功能描述: 标签授权管理
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018年10月26日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Mapper
public interface MergeCimFMmTagAuthMapper extends CommonMapper<CimFMmTagAuthInfo>{
	// 查询授权信息
	List<CimFMmTagAuthInfo> getList(QueryModel model);
	// 维护授权信息
	int updateAuthList(CimFMmTagAuthInfo au);
	// 删除授权信息
	int deleteAuthList(CimFMmTagAuthInfo au);
	// 查询角色表
	List<Map<String, Object>>getRoleList();
	// 查询人员表
	List<Map<String, Object>>getUserList();
	// 查询组织机构表
	List<Map<String, Object>>getOrgList();
	// 查询金融机构表
	List<Map<String, Object>>getInstuList();
	// 获取授权对象Id
	Map<String, Object>getAuthObj(CimFMmTagAuthInfo au);
	Map<String, Object>getUpdateAuthName(CimFMmTagAuthInfo au);
	// 获取id
	String getSeq();
	// 获取重复id
	Map<String, Object>getSameAuth(CimFMmTagAuthInfo au);
	// 删除标签的授权信息
	int delTagNo(String tagNo);
}
