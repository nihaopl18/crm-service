package cn.com.yusys.yscrm.sysview.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.sysview.domain.OcrmFsysViewAuth;
import cn.com.yusys.yscrm.sysview.repository.mapper.OcrmFsysViewAuthMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.com.yusys.yusp.admin.client.IClientService;
/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewAuthService
 * @类描述: 视图权限
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 19:08:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFsysViewAuthService extends CommonService {
	
	private Logger logger = LoggerFactory.getLogger(OcrmFsysViewAuthService.class);
	
    @Autowired
    private OcrmFsysViewAuthMapper ocrmFsysViewAuthMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
    @Autowired
	private IClientService clientService;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFsysViewAuthMapper;
    }
    /**
	 * 
	* @方法名称: getRecoInfo
	* @方法描述: 查询数据 
	* @参数与返回说明: 对象类型 objectType|资源类型 resType|对象记录编号 objectId
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getRecoInfo(String objectType,String resType,String objectId,String sysId) {
			Map<String, Object> paramMap=new HashMap<String, Object>();
			paramMap.put("objectType", objectType);
			paramMap.put("resType", resType.split(","));
			paramMap.put("objectId", objectId);
			paramMap.put("sysId",sysId);
			return ocrmFsysViewAuthMapper.getRecoInfo(paramMap);
	}
	
	/**
	* @方法名称:qryViewTree
	* @方法描述:初始化查询右侧视图树
	* @参数与返回说明:
	* @算法描述:
	*/
	@Transactional(readOnly = true)
	public List<Map<String, Object>> qryViewTree(String sysId) {
		List<Map<String, Object>> list = ocrmFsysViewAuthMapper.qryViewTree(sysId);
		return list;
	}
	
	/**
	 * 
	* @方法名称: saveRelate
	* @方法描述: 保存对象资源关系数据
	* @参数与返回说明: 
	* @算法描述:逻辑：先把以前的数据删除，然后在新建关系数据
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	@SuppressWarnings("finally")
	public int insertBatch(List<Map<String, Object>> menus,List<Map<String, Object>> ctrs) {
		SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		OcrmFsysViewAuthMapper reMapper = session.getMapper(OcrmFsysViewAuthMapper.class);
		int result=0;
        try {
        	if(menus.size()>0) {
    			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    			List<String> ids=new ArrayList<String>();
    			int length=menus.size();
    			int ctrLength=ctrs.size();
    			for(int s=0;s<length;s++) {
    				Map<String, Object> pol=menus.get(s);
    				ids.add(pol.get("authresId").toString());
    			}
    			List<Map<String, Object>> listRes=this.ocrmFsysViewAuthMapper.quryParentIdById(ids);
    			int listResSize=listRes.size();
    			//先删除关系数据
    			Map<String, Object> pool=menus.get(0);
    			List<String> resType=new ArrayList<String>();
    			resType.add("M");
    			resType.add("C");
    			this.deleteInfo(pool.get("authobjType").toString(), resType, pool.get("authobjId").toString());//删除关系数据
    			//新建关系数据
    			for(int i=0;i<listResSize;i++) {//新增授权数据
    				OcrmFsysViewAuth info=new OcrmFsysViewAuth();
    				Map<String, Object> map=listRes.get(i);
    				info.setLastChgDt(df.format(new Date()));//最近跟新时间
    				info.setSysId(pool.get("sysId").toString());
    				info.setAuthobjId(pool.get("authobjId").toString());
    				info.setAuthobjType(pool.get("authobjType").toString());
    				info.setLastChgUsr(pool.get("lastChgUsr").toString());
    				if(map.get("idItem") !=null) {
    					info.setAuthresId(map.get("idItem").toString());
    				}
    				if(map.get("id") !=null) {
    					info.setId(map.get("id").toString());
    				}
    				if(map.get("menuType") !=null) {
    					info.setAuthresType(map.get("menuType").toString());
    				}
    		        
    		        result=result+reMapper.insert(info);
    			}
    			for(int s=0;s<ctrLength;s++) {
    				Map<String, Object> map=ctrs.get(s);
    				OcrmFsysViewAuth info=new OcrmFsysViewAuth();
    				info.setLastChgDt(df.format(new Date()));
    				info.setSysId(map.get("sysId").toString());
    				info.setAuthobjId(map.get("authobjId").toString());
    				info.setAuthobjType(map.get("authobjType").toString());
    				info.setLastChgUsr(map.get("lastChgUsr").toString());
    				info.setAuthresId(map.get("authresId").toString());
    				info.setId(map.get("id").toString());
    				info.setAuthresType(map.get("authresType").toString());
    		        result=result+reMapper.insert(info);
    			}
    			session.commit();//提交数据
    			session.clearCache();
    			logger.info("新增视图授权数据-- |"+pool.get("authobjType").toString()+"|"+pool.get("authobjId").toString()+"| ---"+df.format(new Date()));
    			clientService.clearAllContrUrl(HeaderUtil.getAccessToken());
    		}
        } catch (Exception e) {
            // 没有提交的数据可以回滚
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		return result;
	}
	
	/**
	 * 
	* @方法名称: deleteInfo
	* @方法描述: 删除关系数据 
	* @参数与返回说明: 对象类型 objectType|资源类型 resType|对象记录编号 objectId
	* @算法描述:
	 */
	public int deleteInfo(String objectType,List resType,String objectId) {
			Map<String, Object> paramMap=new HashMap<String, Object>();
			paramMap.put("objectType", objectType);
			paramMap.put("resType", resType);
			paramMap.put("objectId", objectId);
			return ocrmFsysViewAuthMapper.deleteRelInfo(paramMap);
	}
	
	/**
	* @方法名称:selectViewTree
	* @方法描述:查询授权的视图树数据
	* @参数与返回说明:
	* @算法描述:
	*/
	@Transactional(readOnly = true)
	public List<Map<String, Object>> selectViewTree(String loginCode,String sysId) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("loginCode", loginCode);
		paramMap.put("sysId", sysId);
		List<Map<String, Object>> list = ocrmFsysViewAuthMapper.selectViewTree(paramMap);
		return list;
	}
	
	/**
	* @方法名称:selectContrList
	* @方法描述:查询授权的控制点数据
	* @参数与返回说明:
	* @算法描述:
	*/
	@Transactional(readOnly = true)
	public List<Map<String, Object>> selectContrList(String loginCode,String sysId) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("loginCode", loginCode);
		paramMap.put("sysId", sysId);
		List<Map<String, Object>> list = ocrmFsysViewAuthMapper.selectContrList(paramMap);
		return list;
	}
	
	/**
	* @方法名称:qryGrantList
	* @方法描述:
	* @参数与返回说明:
	* @算法描述:
	*/
	@Transactional(readOnly = true)
	public List<Map<String, Object>> qryGrantList(String custId,String mgrId) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("custId", custId);
		paramMap.put("mgrId", mgrId);
		List<OcrmFsysViewAuth> list = ocrmFsysViewAuthMapper.qryGrantList(paramMap);
		List<Map<String, Object>> grantlist = new ArrayList<Map<String, Object>>();
		if(list.size()>0) {
			logger.info("print==="+list.get(0).getId());
			String[] ids = list.get(0).getId().split(",");
			grantlist=ocrmFsysViewAuthMapper.qryViewList(ids);
		}
		
		return grantlist;
	}
	
}
