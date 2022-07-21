package cn.com.yusys.yscrm.custpub.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.ibm.db2.jcc.am.m;

import cn.com.yusys.yusp.admin.client.IClientService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciNetworkRela;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciNetworkRelaMember;
import cn.com.yusys.yscrm.custpub.domain.OcrmFnetworkCiRela;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciNetworkRelaMapper;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciNetworkRelaMemberMapper;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFnetworkCiRelaMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciNetworkRelaService
 * @类描述: #客户网络关系图服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 16:23:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciNetworkRelaService extends CommonService {
    @Autowired
    private OcrmFciNetworkRelaMapper ocrmFciNetworkRelaMapper;
    @Autowired
	private IClientService clientService;

    @Autowired
    private OcrmFciNetworkRelaMemberMapper ocrmFciNetworkRelaMemberMapper;
    
    @Autowired
    private OcrmFnetworkCiRelaMapper ocrmFnetworkCiRelaMapper ;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciNetworkRelaMapper;
    }
    
	public List<Map<String, Object>> getListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
		model.getCondition().put("userId", dto.getBody().getUserId());
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = ocrmFciNetworkRelaMapper.getListByModel(model);
		PageHelper.clearPage();
		return list;
	}
	 /**
		 * 
		* @方法名称: getCustInfo
		* @方法描述:查询所辖客户信息
		* @参数与返回说明: 
		* @算法描述:
		 */
	public List<Map<String, Object>> getCustInfo(String custName) {
		ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
		Map<String,String> param =new HashMap<String,String>();
		param.put("custName", custName);
		param.put("userId", dto.getBody().getUserId());
		// TODO 自动生成的方法存根
		return ocrmFciNetworkRelaMapper.getCustInfoByInfo(param);
	}
	 /**
		 * 
		* @方法名称: getnetWorkRelaInfoBynetId
		* @方法描述:获取关系图节点信息和连接信息
		* @参数与返回说明: 
		* @算法描述:
		 */
	public Map<String, Object> getnetWorkRelaInfoBynetId(String netId) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<Map<String, Object>> nodes=ocrmFciNetworkRelaMemberMapper.getRelaMemberByNetId(netId);
		List<Map<String, Object>> conn=ocrmFnetworkCiRelaMapper.getRelaDetailByNetId(netId);
		result.put("nodes", nodes);
		result.put("conns", conn);
		// TODO 自动生成的方法存根
		return result;
	}

	  /**
	 * 
	* @方法名称: add
	* @方法描述:新增客户网络关系图
	* @参数与返回说明: 
	* @算法描述:同时保存关系图主表，节点信息，连接信息
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public int add(Map<Object, Object> map) {
		// TODO 自动生成的方法存根
		String uuid = UtilTools.getUUID();
		
		OcrmFciNetworkRela ocrmFciNetworkRela =JSON.parseObject(map.get("formdata").toString(),OcrmFciNetworkRela.class);
		// 获取登录信息
    	ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
		ocrmFciNetworkRela.setNetworkRelaId(uuid);
		UtilTools.createUtl(ocrmFciNetworkRela);
		UtilTools.updateUtl(ocrmFciNetworkRela);
		ocrmFciNetworkRela.setCreateOrg(dto.getBody().getOrg().getCode());
		insertSelective(getMapper(), ocrmFciNetworkRela);
		saveMember(map, uuid);
		saveRela(map, uuid);
		return 0;
	}
   /**
	 * 
	* @方法名称: saveMember
	* @方法描述:保存节点信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	public int saveMember(Map<Object, Object> map, String uuid) {
		// TODO 自动生成的方法存根
		int num = 0;
		if(!map.isEmpty()) {
			List OcrmFciNetworkRelaMember =  JSON.parseObject(map.get("nodeData").toString(),List.class);
			for (int i = 0; i < OcrmFciNetworkRelaMember.size(); i++) {
				OcrmFciNetworkRelaMember ocrmFnetworkCiRela = JSON.parseObject(OcrmFciNetworkRelaMember.get(i).toString(),OcrmFciNetworkRelaMember.class);
				ocrmFnetworkCiRela.setNetworkRelaId(uuid);
				UtilTools.createUtl(ocrmFnetworkCiRela);
				ocrmFciNetworkRelaMemberMapper.insertSelective(ocrmFnetworkCiRela);
				num++;
			}
		}
		return num;
	}
	   /**
		 * 
		* @方法名称: saveRela
		* @方法描述:保存节点信息
		* @参数与返回说明: 
		* @算法描述:
		 */
	public int saveRela(Map<Object, Object> map, String uuid) {
		// TODO 自动生成的方法存根
		int num = 0;
		if(!map.isEmpty()) {
			List ocrmFnetworkCiRelas =  JSON.parseObject( map.get("connData").toString(),List.class);
			for (int i = 0; i < ocrmFnetworkCiRelas.size(); i++) {
				OcrmFnetworkCiRela ocrmFnetworkCiRela = JSON.parseObject(ocrmFnetworkCiRelas.get(i).toString(),OcrmFnetworkCiRela.class);
				ocrmFnetworkCiRela.setNetworkRelaId(uuid);
				ocrmFnetworkCiRela.setRelaId(UtilTools.getUUID());
				ocrmFnetworkCiRelaMapper.insertSelective(ocrmFnetworkCiRela);
				num++;
			}	
		}
		
		return num;
	}
	  /**
		 * 
		* @方法名称: updFun
		* @方法描述:修改关系图信息
		* @参数与返回说明: 
		* @算法描述:同时保存关系图主表，节点信息，连接信息
		 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public int updFun(Map<Object, Object> map) {
		//ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
		// TODO 自动生成的方法存根
		OcrmFciNetworkRela ocrmFciNetworkRela = JSON.parseObject(map.get("formdata").toString(),OcrmFciNetworkRela.class);
		String netId = ocrmFciNetworkRela.getNetworkRelaId();
		OcrmFciNetworkRela pool=ocrmFciNetworkRelaMapper.selectByPrimaryKey(netId);
		//pool.setUpdateDate(new Date());
		//pool.setUpdateUser(dto.getBody().getUserId());
		UtilTools.updateUtl(pool);
		pool.setNetworkRelaName(ocrmFciNetworkRela.getNetworkRelaName());
		pool.setRemark(ocrmFciNetworkRela.getRemark());
		ocrmFciNetworkRelaMapper.updateByPrimaryKeySelective(pool);
		
		ocrmFciNetworkRelaMemberMapper.delByNetId(netId);
		ocrmFnetworkCiRelaMapper.delByNetId(netId);
		saveMember(map, netId);
		saveRela(map, netId);
		return 0;
	}
	  /**
			 * 
			* @方法名称: del
			* @方法描述:删除网络关系图相关信息
			* @参数与返回说明: 
			* @算法描述:同时删除关系图主表，节点信息，连接信息
			 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public int del(String netId) {
		// TODO 自动生成的方法存根
		String[] ids=netId.split(",");
		int num = 0;
		for(int i=0;i<ids.length;i++) {
			ocrmFciNetworkRelaMemberMapper.delByNetId(ids[i]);
			ocrmFnetworkCiRelaMapper.delByNetId(ids[i]);
			ocrmFciNetworkRelaMapper.deleteByPrimaryKey(ids[i]);
			num++;
		}
		
		return num;
	}

}
