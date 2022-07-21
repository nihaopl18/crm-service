package cn.com.yusys.yscrm.custpub.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciAddrInfo;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciContactInfo;
import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmFciContactInfoMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciContactInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-28 15:24:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciContactInfoService extends CommonService {
    @Autowired
    private AcrmFciContactInfoMapper acrmFciContactInfoMapper;
    @Autowired
  	private CommonCustDataChangeService commonCustDataChangeService;
    @Autowired
  	private UaaClient uaaClient;

	private static final String CONTRA = "CONTRA";
    @Override
    protected CommonMapper<?> getMapper() {
        return this.acrmFciContactInfoMapper;
    }
    /**
   	 * 
   	* @方法名称: queryContactList
   	* @方法描述: 根据custID查询联系信息
   	* @参数与返回说明: 
   	* @算法描述:
   	 */
   	@Transactional(readOnly = true)
   	public List<Map<String, Object>> queryContactList(String custId,QueryModel model) {
   		   
   		    PageHelper.startPage(model.getPage(),model.getSize());
   			Map<String, String> paramMap=new HashMap<String, String>();
   			paramMap.put("custId", custId);
   			List<Map<String, Object>> list=acrmFciContactInfoMapper.queryContactList(paramMap);
   			PageHelper.clearPage();
   			return list;
   	}
   	/**
   	 * 
   	* @方法名称: insertContact
   	* @方法描述: 保存联系信息
   	* @参数与返回说明: 
   	* @算法描述:
   	 */
   	public AcrmFciContactInfo insertContact(AcrmFciContactInfo record) {
   		
   		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
  		String orgCode = dto.getBody().getOrg().getCode();
  		String loginCode=dto.getBody().getLoginCode();
  		String corpOrgCode=dto.getBody().getInstu().getCode();
  		record.setCratDt(new Date());
  		record.setCratOrgId(orgCode);
  		record.setCratUsr(loginCode);
  		record.setLastChgDt(new Date());
  		record.setLastChgSys("CRM");
  		record.setLastChgUsr(loginCode);
  		record.setCorpOrgCode(corpOrgCode);
  		if(record.getMainContFlg()!=null&&!record.getMainContFlg().equals("")) {
  			 if(record.getMainContFlg().equals("1")) {
 	        	this.updateMainConFlag(record.getCustId());
 	        }
  		}
  		
  	// 调用通用记录修改信息接口
 		Object original = new AcrmFciContactInfo();
 		try {
 			this.commonCustDataChangeService.saveChangeData(record, original, record.getCustId(),CONTRA,"新增",true);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
   		this.insertSelective(getMapper(), record);
   		return record ;
   	}
   	/**
   	 * 
   	* @方法名称: updateContact
   	* @方法描述: 更新联系信息
   	* @参数与返回说明: 
   	* @算法描述:
   	 */
         public int updateContact(Object record) {
        	 AcrmFciContactInfo pool = (AcrmFciContactInfo) record;
        	 ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
       		String orgCode = dto.getBody().getOrg().getCode();
       		String loginCode=dto.getBody().getLoginCode();
       		String corpOrgCode=dto.getBody().getInstu().getCode();
       		pool.setLastChgDt(new Date());
       		pool.setLastChgSys("CRM");
       		pool.setLastChgUsr(loginCode);
       		pool.setCorpOrgCode(corpOrgCode);
       		if(pool.getMainContFlg()!=null&&!pool.getMainContFlg().equals("")) {
     			 if(pool.getMainContFlg().equals("1")) {
    	        	this.updateMainConFlag(pool.getCustId());
    	        }
     		}
     	// 调用通用记录修改信息接口
 		Object original = this.selectByPrimaryKey(getMapper(), pool);
 		try {
 			this.commonCustDataChangeService.saveChangeData(pool, original, pool.getCustId(),CONTRA,"修改",true);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
   		return this.updateSelective(getMapper(), pool);
   		
   	}

 /**
	 * 
	* @方法名称: deleteContactInfo
	* @方法描述: 删除联系信息
	* @参数与返回说明: 
	* @算法描述:
	 */
   	
   	// @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
   	public int deleteContactInfo(String id) {
   		
   		AcrmFciContactInfo acrmFciContactInfo=new AcrmFciContactInfo();
   		acrmFciContactInfo.setId(id);
   	// 调用通用记录修改信息接口
  		Object original = this.selectByPrimaryKey(getMapper(), acrmFciContactInfo);
		try {
			this.commonCustDataChangeService.saveChangeData(new AcrmFciContactInfo(),original,((AcrmFciContactInfo)original).getCustId(),CONTRA,"删除",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return this.delete(acrmFciContactInfo);
   	}
    /**
  	 * 
  	* @方法名称: updateMainConFlag
  	* @方法描述:修改主地址
  	* @参数与返回说明: 
  	* @算法描述:
  	 */
	public int updateMainConFlag(String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("custId", custId);
		paramMap.put("mainContFlg", "0");
		return acrmFciContactInfoMapper.updateMainConFlag(paramMap);
	}
	public int updatePoten(AcrmFciContactInfo acrmFciContactInfo) {
		// TODO 自动生成的方法存根
		return acrmFciContactInfoMapper.updatePoten(acrmFciContactInfo);
	}
}
