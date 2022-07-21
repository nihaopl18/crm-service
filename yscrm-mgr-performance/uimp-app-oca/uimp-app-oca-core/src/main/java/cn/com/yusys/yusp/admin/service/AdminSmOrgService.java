package cn.com.yusys.yusp.admin.service;

import cn.com.yusys.yusp.admin.domain.AdminSmOrg;
import cn.com.yusys.yusp.admin.repository.mapper.AdminSmOrgMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.DateUtil;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-admin
 * @类名称: AdminSmOrgService
 * @类描述: 
 * @功能描述: 机构管理Service
 * @创建人: hujun3@yusys.com.cn
 * @创建时间: 2017-12-22 15:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class AdminSmOrgService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(AdminSmOrgService.class);
	
	@Autowired
	private AdminSmOrgMapper orgMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return this.orgMapper;
	}
	
	/**
	 * 
	* @方法名称: queryPage
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryPage(QueryModel model){
		// 设置分页查询参数(设置到线程变量中了)
		PageHelper.startPage(model.getPage(), model.getSize());
		model.setSort("last_chg_dt desc");
		List<Map<String, Object>> list=this.orgMapper.queryOrgByPage(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	 * 
	* @方法名称: getInstuOrg
	* @方法描述: 自定义码值（金融机构）
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getInstuOrg(QueryModel model){
		List<Map<String, Object>> list=this.orgMapper.getInstuOrg(model);
		return list;
	}
	/**
	 * 
	* @方法名称: insertInfo
	* @方法描述: 新增机构数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	public Map<String,Object> insertInfo(AdminSmOrg pool) {
		Map<String,Object> result=new HashMap<String, Object>();
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("orgCode", pool.getOrgCode());
		List<Map<String, Object>> res=orgMapper.findOrgByParam(paramMap);
		if(res.size()==0) {
			pool.setOrgId(pool.getOrgCode());//机构id设为机构code
			pool.setLastChgDt(DateUtil.formatDateTimeByDef());//最近跟新时间
			if(pool.getOrgSts()==null||"".equals(pool.getOrgSts())) {
				pool.setOrgSts("A");//新增的数据都是生效的
			}
			logger.info("机构新增数据：【新增机构：{}】 ", pool.getOrgName());
			this.insert(getMapper(), pool);
			result.put("code", "200");
			result.put("message", "机构代码为："+pool.getOrgCode()+",机构名称为:"+pool.getOrgName()+"的数据保存成功。");
		}else {//如果已存在就不能新增
			result.put("code", "2");
			result.put("message", "机构代码为："+pool.getOrgCode()+",机构名称为:"+pool.getOrgName()+"的数据已经存在。");
		}
		
		return result;
	}
	
	
	
	/**
	 * 
	* @方法名称: insertInfo
	* @方法描述: 修改机构数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Override
	public int update(Object record) {
		AdminSmOrg pool=(AdminSmOrg)record;
		pool.setLastChgDt(DateUtil.formatDateTimeByDef());//最近跟新时间
		if(pool.getOrgSts()==null||"".equals(pool.getOrgSts())) {
			pool.setOrgSts("A");//新增的数据都是待生效的
		}
		logger.info("机构新增数据：【新增机构：{}】 ", pool.getOrgName());
		return this.updateSelective(getMapper(), pool);
	}
	/**
	 * 
	* @方法名称: useIngFn
	* @方法描述: 启用机构
	* @参数与返回说明: id(主键ID)
	* @算法描述:
	 */
	public int useIngFn(String id,String lastChgUsr) {
		int n=0;
		if(!"".equals(id)) {
			Map<String, String> paramMap=new HashMap<String, String>();
			paramMap.put("sts", "A");
			paramMap.put("id", id);
			paramMap.put("user", lastChgUsr);
			paramMap.put("date", DateUtil.formatDateTimeByDef());
			n=this.orgMapper.updateOrgSts(paramMap);
		}
		return n;
	}
	
	/**
	 * 
	* @方法名称: unUseIngFn
	* @方法描述: 停用机构
	* @参数与返回说明:id(主键ID)
	* @算法描述:
	 */
	public int unUseIngFn(String id,String lastChgUsr) {
		int n=0;
		if(!"".equals(id)) {
			Map<String, String> paramMap=new HashMap<String, String>();
			paramMap.put("sts", "I");
			paramMap.put("id", id);
			paramMap.put("user", lastChgUsr);
			paramMap.put("date", DateUtil.formatDateTimeByDef());
			n=this.orgMapper.updateOrgSts(paramMap);
		}
		return n;
	}
	/**
	 * 
	* @方法名称: getOrgTree
	* @方法描述: 根据机构ID查询是否有子机构 
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public int queryByOrgId(String orgInfo) {
			int result=0;
			Map<String, String> paramMap=new HashMap<String, String>();
			paramMap.put("orgId", orgInfo);
			List<Map<String, Object>> list= orgMapper.findOrgByParam(paramMap);
			if(list!=null) {
				result=list.size();
			}
			return result;
	}

    /**
     *
     * @方法名称: queryRelByOrgId
     * @方法描述: 根据机构ID查询是否有用户、角色、岗位、部门数据
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public int queryRelByOrgId(String orgInfo) {
        int result=0;
        Map<String, String> paramMap=new HashMap<String, String>();
        paramMap.put("orgId", orgInfo);
        result = orgMapper.queryRelByOrgId(paramMap);
        return result;
    }
	/**
	 * 
	* @方法名称: getOrgTree
	* @方法描述: 查询机构树数据 
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getOrgTree(String orgId,String orgSts,Boolean lazy) {
			Map<String, String> paramMap=new HashMap<String, String>();
			paramMap.put("orgId", orgId);
			paramMap.put("orgSts", orgSts);
			List<Map<String, Object>> originList=null;
			if(null!=lazy&&lazy) {
				originList=orgMapper.queryOrgTreeInfoLazy(paramMap);			
			}else {
				originList=orgMapper.queryOrgTreeInfo(paramMap);
				for(int i=0;i<originList.size();i++) {
					if(originList.get(i).get("orgId").equals(orgId)) {
						originList.remove(i); // 剔除本身
						break;
					}
				}
			}
			
			return originList;
	}
	
	@SuppressWarnings("rawtypes")
	public List getAllOrgs() {
		return orgMapper.getAllOrgs();
	}
}
