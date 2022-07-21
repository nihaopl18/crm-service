package cn.com.yusys.yscrm.cust.person.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerFamilyMember;
import cn.com.yusys.yscrm.cust.person.repository.mapper.AcrmFciPerFamilyMemberMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;


/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFciPerFamilyMemberService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-29 16:09:50
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciPerFamilyMemberService extends CommonService {
    @Autowired
    private AcrmFciPerFamilyMemberMapper acrmFciPerFamilyMemberMapper;
	private static final String CUST_ID = "custId";
	private static final String CUST_STATUS = "custStatus";
	
    @Override
    protected CommonMapper<?> getMapper() {
        return this.acrmFciPerFamilyMemberMapper;
    }
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryFamMemList(String custId,QueryModel model) {
		   
		    PageHelper.startPage(model.getPage(),model.getSize());
			Map<String, String> paramMap=new HashMap<String, String>();
			paramMap.put(CUST_ID, custId);
			List<Map<String, Object>> list=acrmFciPerFamilyMemberMapper.queryFamMemList(paramMap);
			PageHelper.clearPage();
			return list;
	}
	/**
	 * 判断成员是否为本行客户
	 *   通过名称+证件类型+证件号码判断是否为我行客户
	 * @param
	 * @param
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryIsBankList(AcrmFciPerFamilyMember  pool) {
		   
		   
			Map<String, String> paramMap=new HashMap<String, String>();
			paramMap.put("memName",pool.getMemName() );//成员名称
			paramMap.put("memCertType",pool.getMemCertType() );//成员证件类型
			paramMap.put("memCertNo",pool.getMemCertNo());//成员证件号码
			return acrmFciPerFamilyMemberMapper.queryIsBankList(paramMap);
	}
	/**
	 * 
	* @方法名称: insertFamMem
	* @方法描述: 保存家庭成员
	* @参数与返回说明: 
	* @算法描述:
	 */
	public AcrmFciPerFamilyMember insertFamMem(AcrmFciPerFamilyMember record) {
		List<Map<String, Object>> list=this.queryIsBankList(record);
		 if(list.size()>0) {
			 if(list.get(0).get(CUST_ID)!=null&&!list.get(0).get(CUST_ID).equals("")) {
				 record.setFamCustId(list.get(0).get(CUST_ID).toString());
			 }
             if(list.get(0).get(CUST_STATUS)!=null&&!list.get(0).get(CUST_STATUS).equals("")) {
            	 record.setFamCustStatus(list.get(0).get(CUST_STATUS).toString());
			 }	
		 }
		this.insertSelective(getMapper(), record);
		return record ;
	}
	/**
	 * 
	* @方法名称: updateFamMem
	* @方法描述: 更新家庭成员
	* @参数与返回说明: 
	* @算法描述:
	 */
      public int updateFamMem(Object record) {
    	  AcrmFciPerFamilyMember pool = (AcrmFciPerFamilyMember) record;
    	  
    	  List<Map<String, Object>> list=this.queryIsBankList(pool);
 		 if(list.size()>0) {
 			 if(list.get(0).get(CUST_ID)!=null&&list.get(0).get(CUST_ID).equals("")) {
 				pool.setFamCustId(list.get(0).get(CUST_ID).toString());
 			 }
              if(list.get(0).get(CUST_STATUS)!=null&&list.get(0).get(CUST_STATUS).equals("")) {
            	  pool.setFamCustStatus(list.get(0).get(CUST_STATUS).toString());
 			 }
 			 
 			
 		 }
    	//  AcrmFciCustIdentInfo info=this.selectByPrimaryKey(getMapper(), pool);
		//pool.setLastUpdateUser(info.getLastUpdateUser());
	//	pool.setLastUpdateTm(new Date());	
	//	pool.setSrcSys(info.getSrcSys());
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
	public int deleteFamMem(String id) {
		/* Map<String, String> paramMap = new HashMap<String, String>();
		 paramMap.put("id", id);*/
		AcrmFciPerFamilyMember pool =new AcrmFciPerFamilyMember();
		  pool.setId(id);
		return this.delete(pool);
	}
	
//	public List<Map<String, Object>> getMemCert(String memName,String memCertNo,String memCertType){
//		return acrmFciPerFamilyMemberMapper.getgetMemCert(memName,memCertNo,memCertType);
//	}
}
