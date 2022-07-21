package cn.com.yusys.yusp.cm.market.service;


import cn.com.yusys.yusp.cm.market.domain.CimpCmAssemClassifyinfo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmAssemInout;
import cn.com.yusys.yusp.cm.market.domain.CimpCmAsseminfo;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmAssemClassifyinfoMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmAssemInOutMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmAssemblyMapper;
import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcChannelMgr;
import cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper.CmFRcChannelMgrMapper;
import cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper.CmFRcSysTypeMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.sequence.service.SequenceTemplateService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.*;
/**
 * @项目名称：yscimc-service
 * @类名称：CimpCmAssemiblyService
 * @类描述：营销组件相关SERVICE
 * @功能描述:
 * @创建人：hujun3 
 * @创建时间：2018-11-15
 */
@Service
public class CimpCmAssemiblyService  extends CommonService{
	
	@Autowired
	private CimpCmAssemblyMapper connMapper;
	
	@Autowired
	private CimpCmAssemClassifyinfoMapper classifyMapper;
	
	@Autowired
	public CimpCmAssemInOutMapper inOutMapper;
	
	@Autowired
	private CmFRcChannelMgrMapper channelMapper;
	
	@Autowired
	private CmFRcSysTypeMapper typeMapper;
	
	@Autowired
    private SequenceTemplateService sequenceConfigService;
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO 自动生成的方法存根
		return this.connMapper;
	}
	
	
	/**
	 * 
	* @方法名称: getAllClassifyinfo
	* @方法描述: 查询组件分类信息 
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getAllClassifyinfo() {
			List<Map<String, Object>> result= connMapper.getAllClassifyinfo();
			return result;
	}
	/**
	 * 
	* @方法名称: getItemsByClassify
	* @方法描述: 根据分类查询组件信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getItemsByClassify(String id ) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("id", id);
		List<Map<String, Object>> result= connMapper.getIteminfoByClassify(paramMap);
		return result;
	}
	/**
	 * 
	* @方法名称: getfieldsChannelById
	* @方法描述: 根据渠道组件的ID查询渠道对应的栏位信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getfieldsChannelById(String id ) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("id", id);
		List<Map<String, Object>> result= connMapper.getfieldsChannelById(paramMap);
		return result;
	}
	/**
	 * 
	* @方法名称: getAllItemsInfo
	* @方法描述: 查询全部组件信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getAllItemsInfo() {
		List<Map<String, Object>> result= connMapper.getAllIteminfo();
		return result;
	}
	/**
	 * 
	* @方法名称: getAllItemsInfoByScene
	* @方法描述: 根据活动的场景查询全部组件信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getAllItemsInfoByScene(String flowId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("flowId", flowId);
		List<Map<String, Object>> result= connMapper.getAllIteminfoByScene(paramMap);
		return result;
	}
	/**
	 * 
	* @方法名称: updateClassifyInfo
	* @方法描述: 维护分类信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	public void updateClassifyInfo(CimpCmAssemClassifyinfo data ) {
		if(data.getClassId() ==null) {//新增
			classifyMapper.insertSelective(data);
		}else {//修改
			classifyMapper.updateByPrimaryKeySelective(data);
		}
		
	}
	/**
	 * 
	* @方法名称: updateItemInfo
	* @方法描述: 维护组件信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	public void updateItemInfo(CimpCmAsseminfo data ) {
		if(data.getClassId() ==null) {//新增
			connMapper.insertSelective(data);
		}else {//修改
			connMapper.updateCmFRcChannelMgr(data);
			connMapper.updateByPrimaryKeySelective(data);
		}
		
	}
	
	/**
     * 
    * @方法名称:getAssemblyId
    * @方法描述:生成组件Id
    * @参数与返回说明:
    * @算法描述:
     */
    public String getAssemblyId() {
    	return sequenceConfigService.getNextSeq("ID_SEQUENCES");
	}
	/**
	 * 
	* @方法名称: insert
	* @方法描述: 新增渠道组件信息
	* @参数与返回说明: 
	* @算法描述:新增渠道信息，同时插入一条数据导渠道管理表。
	 */
	@Override
	public int insert(Object record) {
		CimpCmAsseminfo assInfo = (CimpCmAsseminfo) record;
		String assId = getAssemblyId();
		assInfo.setAssemblyId(assId);
		CmFRcChannelMgr channel = new CmFRcChannelMgr();
		channel.setChannelItemId(assId);
		channel.setChannelName(assInfo.getAssemblyName());
		channel.setIsSet("0");
		channel.setCreatDate(new Date());
		channel.setCreatUser(SecurityUtils.getCurrentUserLogin());
		channel.setCreatUserName(typeMapper.getUserName(channel.getCreatUser()));
		channel.setUpdataDate(new Date());
		channel.setUpdataUser(SecurityUtils.getCurrentUserLogin());
		channel.setUpdataUserName(typeMapper.getUserName(channel.getUpdataUser()));
		super.insertSelective(channelMapper, channel);
		return super.insertSelective(connMapper, assInfo);
	}
	
	
	/**
	 * 
	* @方法名称: deleteClassifyInfo
	* @方法描述: 删除分类信息
	* @参数与返回说明: 
	* @算法描述:删除分类的同时也删除对应的组件信息
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public void deleteClassifyInfo(String id ) {
		//删除分类信息
		classifyMapper.deleteByPrimaryKey(id);
		//删除组件信息
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("classId", id);
		connMapper.removeItemsByClassify(paramMap);
		//删除组件输入输出信息
		connMapper.removeInOutByClassify(paramMap);
		
	}
	/**
	 * 
	* @方法名称: deleteItemInfo
	* @方法描述: 删除组件信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public void deleteItemInfo(String id ) {
		connMapper.deleteByIds(id);
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("id", id);
		connMapper.removeInOutByItem(paramMap);
	}
	/**
	 * 
	* @方法名称: getInOutInfo
	* @方法描述: 根据组件ID查询输入输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getInOutInfo(QueryModel param) {
		// 设置分页查询参数(设置到线程变量中了)
		PageHelper.startPage(param.getPage(), param.getSize());
		//param.setSort("last_chg_dt desc");
		List<Map<String, Object>> result=connMapper.getItemInOutinfo(param);
		for(int i=0;i<result.size();i++) {
			Map<String, Object> info=result.get(i);
			//读取大字段的内容
			Clob content_Clob=(Clob) info.get("message");
			long contentLength;
			String content=null;
			if(content_Clob!=null){
			  try {
				contentLength=content_Clob.length();
				content=content_Clob.getSubString(1,(int)contentLength);
				info.put("message", content);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			  
			 }
		}
		
		PageHelper.clearPage();
		return result;
	}
	
	/**
	 * 
	* @方法名称: updateItemInOutInfo
	* @方法描述: 维护组件输入输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	public void updateItemInOutInfo(CimpCmAssemInout data ) {
		if(data.getParamId() ==null||data.getParamId().equals("")) {//新增
			data.setParamId(null);
			inOutMapper.insertSelective(data);
		}else {//修改
			inOutMapper.updateByPrimaryKeySelective(data);
		}
		
	}
	/**
	 * 
	* @方法名称: deleteItemInOutInfo
	* @方法描述: 删除组件输入输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	public void deleteItemInOutInfo(String id ) {
		String[] ids=id.split(",");
		for(int i=0;i<ids.length;i++) {
			inOutMapper.deleteByIds(ids[i]);
		}
		
	}
	
	/**
	 * 
	* @方法名称: getTablesInfo
	* @方法描述: 查询数据库表格信息 
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getTablesInfo(QueryModel queryModel) {
		// 设置分页查询参数(设置到线程变量中了)
			PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
			List<Map<String, Object>> result= connMapper.getTablesInfo(queryModel);
			PageHelper.clearPage();
			return result;
	}
	/**
	 * 
	* @方法名称: getColumnByTable
	* @方法描述: 根据表格查询字段信息 
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getColumnByTable(QueryModel queryModel,String tables) {
			PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
			Map<String, Object>con=queryModel.getCondition();//查询条件
			List<String> list=new ArrayList<String>();
			if(tables!=null&&!tables.equals("")) {
				String[] str=tables.split("@@");
				for(int i=0;i<str.length;i++) {
					list.add(str[i]);
				}
			}else {
				list.add("");
			}
			con.put("list", list);
			List<Map<String, Object>> result= connMapper.getcolumnByTable(con);
			PageHelper.clearPage();
			return result;
	}

	public List<CimpCmAsseminfo> getAll() {
		return connMapper.selectAll();
	}
}
