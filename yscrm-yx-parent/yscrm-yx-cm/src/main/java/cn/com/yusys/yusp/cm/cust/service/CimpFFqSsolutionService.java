package cn.com.yusys.yusp.cm.cust.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.cm.cust.domain.CimpFFqScol;
import cn.com.yusys.yusp.cm.cust.domain.CimpFFqSsolution;
import cn.com.yusys.yusp.cm.cust.repository.mapper.CimpFFqScolMapper;
import cn.com.yusys.yusp.cm.cust.repository.mapper.CimpFFqSsolutionMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * 保存方案
 * @author zhangxs4
 * 
 */
@Service
public class CimpFFqSsolutionService  extends CommonService{
	
	@Autowired
	private CimpFFqSsolutionMapper cimpFFqSsolutionMapper;
	@Autowired
	private CimpFFqScolMapper colMapper;
	@Autowired
	private UserInfoService userInfo; 
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO 自动生成的方法存根
		return this.cimpFFqSsolutionMapper;
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
	/**
	 * 保存表单节点关系表及保存输出表
	 * @param 
	 * @return
	 */
	public int saveScol(List<CimpFFqScol>  t,List<CimpFFqSsolution> record)  throws ParseException{
		int count = 0;
		//保存方案
		String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			CimpFFqSsolution solution = new CimpFFqSsolution();
			if("1".equals(record.get(0).getId())){//如果是灵活查询模块
				solution.setId(getUUID());
			}else{//灵活查询组件
				solution.setId(record.get(0).getId());
			}
			solution.setSsType(record.get(0).getSsType());
			solution.setSsSort(record.get(0).getSsSort());
			solution.setSsResult(record.get(0).getSsResult());
			solution.setSsName(record.get(0).getSsName());
			solution.setSsUser(loginCode);
			solution.setSsDate(df.parse(df.format(new Date())));
			cimpFFqSsolutionMapper.deleteByPrimaryKey(record.get(0).getId());
			cimpFFqSsolutionMapper.insertSelective(solution);	
			
		//保存条件列
			colMapper.deletebyssid(record.get(0).getId());
			
			for(int i=0;i<t.size();i++){
				t.get(i).setId(getUUID());
				if("1".equals(t.get(0).getSsId())){//灵活查询模块
					t.get(i).setSsId(solution.getId());
				}
				colMapper.insertSelective(t.get(i));
			}
		return count;
	}
	
	
	public int updateScol(List<CimpFFqScol>  t,List<CimpFFqSsolution> record)  throws ParseException{
		int count = 0;
		//保存方案
		String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			CimpFFqSsolution solution = new CimpFFqSsolution();
			solution.setSsType(record.get(0).getSsType());
			solution.setSsSort(record.get(0).getSsSort());
			solution.setSsResult(record.get(0).getSsResult());
			solution.setSsName(record.get(0).getSsName());
			solution.setSsUser(loginCode);
			solution.setSsDate(df.parse(df.format(new Date())));
			solution.setCreateOrg(userInfo.getOrgCode());
			if("1".equals(record.get(0).getId())){//如果是灵活查询模块
				List<CimpFFqSsolution> cimpFFqSsolution=cimpFFqSsolutionMapper.checkSsolution(record.get(0).getSsName());
				solution.setId(cimpFFqSsolution.get(0).getId());
			}else{//灵活查询组件
				solution.setId(record.get(0).getId());
			}
			cimpFFqSsolutionMapper.deleteByPrimaryKey(solution.getId());
			cimpFFqSsolutionMapper.insertSelective(solution);
		//保存条件列
			if("1".equals(record.get(0).getId())){//如果是灵活查询模块
				colMapper.deletebyssid(solution.getId());
			}else{//灵活查询组件
				colMapper.deletebyssid(record.get(0).getId());
			}
			for(int i=0;i<t.size();i++){
				t.get(i).setId(getUUID());
				if("1".equals(t.get(0).getSsId())){//灵活查询模块
					t.get(i).setSsId(solution.getId());
				}
				colMapper.insertSelective(t.get(i));
			}
		return count;
	}
	
	/**
	 * 根据节点信息查询条件字段列
	 * @param 
	 * @return
	 */
	public List<Map<String, Object>> getSsresult(String id) {
		List<Map<String, Object>> list = cimpFFqSsolutionMapper.getSsresult(id);
		return list;
	}
	
	public List<Map<String, Object>> getList() {
		List<Map<String, Object>> list = cimpFFqSsolutionMapper.getList();
		return list;
	}
	
	public List<CimpFFqSsolution> checkSsolution(String ssName) {
		List<CimpFFqSsolution> list = cimpFFqSsolutionMapper.checkSsolution(ssName);
		return list;
	}

	public void addByGroup(CimpFFqSsolution cimpFFqSsolution) {
		// TODO 自动生成的方法存根
		insertSelective(getMapper(), cimpFFqSsolution);
	}

	public List<Map<String, Object>> getListById(QueryModel model) {
		// TODO 自动生成的方法存根
		return cimpFFqSsolutionMapper.getListById(model);
	}

}

