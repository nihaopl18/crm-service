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

import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmFciAddrInfoMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciAddrInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-28 15:23:01
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciAddrInfoService extends CommonService {
    @Autowired
    private AcrmFciAddrInfoMapper acrmFciAddrInfoMapper;
    @Autowired
	private CommonCustDataChangeService commonCustDataChangeService;
    @Autowired
  	private UaaClient uaaClient;
    @Override
    protected CommonMapper<?> getMapper() {
        return this.acrmFciAddrInfoMapper;
    }
    /**
  	 * 
  	* @方法名称: queryAddrList
  	* @方法描述: 根据地址id查询地址信息
  	* @参数与返回说明: 
  	* @算法描述:
  	 */
  	@Transactional(readOnly = true)
  	public List<Map<String, Object>> queryAddrList(String custId,QueryModel model) {
  		   
  		    PageHelper.startPage(model.getPage(),model.getSize());
  			Map<String, String> paramMap=new HashMap<String, String>();
  			paramMap.put("custId", custId);
  			List<Map<String, Object>> list=acrmFciAddrInfoMapper.queryAddrList(paramMap);
  			PageHelper.clearPage();
  			return list;
  	}
  	/**
  	 * 
  	* @方法名称: insertAddr
  	* @方法描述: 保存地址信息
  	* @参数与返回说明: 
  	* @算法描述:
  	 */
  	public AcrmFciAddrInfo insertAddr(AcrmFciAddrInfo record) {
  		
  	 
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
  		if(record.getMainAddrFlg()!=null&&!record.getMainAddrFlg().equals("")) {
  			 if(record.getMainAddrFlg().equals("1")) {
 	        	this.updateMainAddrFlag(record.getCustId());
 	        }
  		}
  		
		// 调用通用记录修改信息接口
		Object original = new AcrmFciAddrInfo();
		try {
			this.commonCustDataChangeService.saveChangeData(record, original, record.getCustId(),"ADDR","新增",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
  		this.insertSelective(getMapper(), record);
  		return record ;
  	}

	/**
	 * 
	 * @方法名称: updateAddr
	 * @方法描述: 更新地址信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public int updateAddr(Object record) {
		AcrmFciAddrInfo pool = (AcrmFciAddrInfo) record;
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String orgCode = dto.getBody().getOrg().getCode();
		String loginCode = dto.getBody().getLoginCode();
		String corpOrgCode = dto.getBody().getInstu().getCode();
		pool.setLastChgDt(new Date());
		pool.setLastChgSys("CRM");
		pool.setLastChgUsr(loginCode);
		pool.setCorpOrgCode(corpOrgCode);
		if(pool.getMainAddrFlg()!=null&&!pool.getMainAddrFlg().equals("")) {
			 if(pool.getMainAddrFlg().equals("1")) {
		        	this.updateMainAddrFlag(pool.getCustId());
		        }
		}
		
		// 调用通用记录修改信息接口
		Object original = this.selectByPrimaryKey(getMapper(), pool);
		try {
			this.commonCustDataChangeService.saveChangeData(pool, original, pool.getCustId(),"ADDR","修改",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.updateSelective(getMapper(), pool);

	}
  	

    /**
  	 * 
  	* @方法名称: deleteAddrInfo
  	* @方法描述: 删除地址信息
  	* @参数与返回说明: 
  	* @算法描述:
  	 */
  	// @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
  	public int deleteAddrInfo(String id) {
  		/* Map<String, String> paramMap = new HashMap<String, String>();
  		 paramMap.put("id", id);*/
  		AcrmFciAddrInfo acrmFciAddrInfo=new AcrmFciAddrInfo();
  		acrmFciAddrInfo.setId(id);
  		// 调用通用记录修改信息接口
  		Object original = this.selectByPrimaryKey(getMapper(), acrmFciAddrInfo);
		try {
			this.commonCustDataChangeService.saveChangeData(new AcrmFciAddrInfo(),original,((AcrmFciAddrInfo)original).getCustId(),"ADDR","删除",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
  		return this.delete(acrmFciAddrInfo);
  	}
  	 /**
  	 * 
  	* @方法名称: updateMainAddrFlag
  	* @方法描述:修改主地址
  	* @参数与返回说明: 
  	* @算法描述:
  	 */
	public int updateMainAddrFlag(String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("custId", custId);
		paramMap.put("mainAddrFlg", "0");
		return acrmFciAddrInfoMapper.updateMainAddrFlag(paramMap);
	}
	public int updatePoten(AcrmFciAddrInfo acrmFciAddrInfo) {
		// TODO 自动生成的方法存根
		return acrmFciAddrInfoMapper.updatePoten(acrmFciAddrInfo);
	}
}
