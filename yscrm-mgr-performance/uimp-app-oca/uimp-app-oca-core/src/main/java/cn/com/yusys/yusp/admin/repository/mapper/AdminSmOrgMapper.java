package cn.com.yusys.yusp.admin.repository.mapper;

import cn.com.yusys.yusp.admin.domain.AdminSmOrg;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-admin
 * @类名称: AdminSmOrgMapper
 * @类描述: 
 * @功能描述: 机构管理Mapper
 * @创建人: ????@yusys.com.cn
 * @创建时间: 2017-12-22 15:52
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface AdminSmOrgMapper extends CommonMapper<AdminSmOrg> {
     
	/**
	 * 
	* @方法名称: updateOrgSts
	* @方法描述: 更新机构状态
	* @参数与返回说明: sts 状态|id 主键ID
	* @算法描述:
	 */
	int updateOrgSts(Map<?, ?> param);
	
	/**
	 * 
	* @方法名称: queryOrgTreeInfo
	* @方法描述: 查询机构树
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryOrgTreeInfo(Map<String, String> paramMap);
	
	/**
	 * 
	* @方法名称: queryOrgTreeInfoLazy
	* @方法描述: 查询机构树(懒加载，只查询下一级机构)
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryOrgTreeInfoLazy(Map<String, String> paramMap);

	/**
	 * 
	* @方法名称: findOrgByParam
	* @方法描述: 根据条件查询
	* @参数与返回说明:  orgInfo 机构代码
	* @算法描述:
	 */
	List<Map<String, Object>> findOrgByParam(Map<String, String> paramMap);

    /**
     *
     * @方法名称: queryRelByOrgId
     * @方法描述: 根据机构ID查询是否有用户、角色、岗位、部门数据
     * @参数与返回说明:
     * @算法描述:
     */
	int queryRelByOrgId(Map<String, String> paramMap);
	
	/**
	 * 
	* @方法名称: queryOrgByPage
	* @方法描述: 分页查询
	* @参数与返回说明: QueryModel
	* @算法描述:
	 */
	List<Map<String, Object>> queryOrgByPage(QueryModel param);
	
	/**
	 * 
	* @方法名称: getInstuOrg
	* @方法描述: 自定义码值（金融机构）
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> getInstuOrg(QueryModel param);
	
	/**
	 * 
	* @方法名称: getParentOrgIds
	* @方法描述: 查询父级机构
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, String>> getParentOrgIds(List<String> list);
	
	
	List<Map<String,Object>> getAllOrgs();
	
}
