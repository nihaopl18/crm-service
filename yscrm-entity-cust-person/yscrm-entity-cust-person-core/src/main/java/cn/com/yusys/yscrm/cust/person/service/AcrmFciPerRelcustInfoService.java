package cn.com.yusys.yscrm.cust.person.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerRelcustInfo;
import cn.com.yusys.yscrm.cust.person.repository.mapper.AcrmFciPerRelcustInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFciPerRelcustInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-13 10:59:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciPerRelcustInfoService extends CommonService {
    @Autowired
    private AcrmFciPerRelcustInfoMapper acrmFciPerRelcustInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.acrmFciPerRelcustInfoMapper;
    }
    @Transactional(readOnly = true)
	public List<Map<String, Object>> queryPerrelList(String custId,QueryModel model) {
		   
		    PageHelper.startPage(model.getPage(),model.getSize());
			Map<String, String> paramMap=new HashMap<String, String>();
			String relationship="";
			String relaCustName="";
			String relaCustId="";
			
			if( model.getCondition().get("relationship")!=null) {
				relationship= model.getCondition().get("relationship").toString();
			}
			if( model.getCondition().get("relaCustName")!=null) {
				relaCustName= model.getCondition().get("relaCustName").toString();
			}
			if( model.getCondition().get("relaCustId")!=null) {
				relaCustId= model.getCondition().get("relaCustId").toString();
			}
			paramMap.put("custId", custId);
			paramMap.put("relationship",  relationship);
			paramMap.put("relaCustName", relaCustName);
			paramMap.put("relaCustId", relaCustId);
			List<Map<String, Object>> list=acrmFciPerRelcustInfoMapper.queryPerrelList(paramMap);
			PageHelper.clearPage();
			return list;
	}
	/**
	 * 
	* @方法名称: insertPerrel
	* @方法描述: 保存关联关系
	* @参数与返回说明: 
	* @算法描述:
	 */
	public AcrmFciPerRelcustInfo insertPerrel(AcrmFciPerRelcustInfo record) {
		
	 
		this.insertSelective(getMapper(), record);
		return record ;
	}
	public Map<String, Object> getCustType(String custId){
		return acrmFciPerRelcustInfoMapper.getCustType(custId);
	}
	/**
	 * 
	* @方法名称: updatePerrel
	* @方法描述: 更新关联关系
	* @参数与返回说明: 
	* @算法描述:
	 */
      public int updatePerrel(Object record) {
    	  AcrmFciPerRelcustInfo pool = (AcrmFciPerRelcustInfo) record;
    	
		return this.updateSelective(getMapper(), pool);
		
	}
	
      /**
  	 * 
  	* @方法名称: updateFamMem
  	* @方法描述: 更新家庭成员
  	* @参数与返回说明: 
  	* @算法描述:
  	 */
	
	// @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int deletePerrel(String id) {
		
		AcrmFciPerRelcustInfo pool =new AcrmFciPerRelcustInfo();
		pool.setId(id);
		return this.delete(pool);
	}
}
