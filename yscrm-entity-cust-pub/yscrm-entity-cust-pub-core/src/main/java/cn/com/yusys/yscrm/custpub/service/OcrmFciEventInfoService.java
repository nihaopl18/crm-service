package cn.com.yusys.yscrm.custpub.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

import cn.com.yusys.yscrm.custpub.domain.OcrmFciEventInfo;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciEventInfoMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciEventInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-15 15:57:54
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciEventInfoService extends CommonService {
    @Autowired
    private OcrmFciEventInfoMapper ocrmFciEventInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFciEventInfoMapper;
    }
    @Transactional(readOnly = true)
  	public List<Map<String, Object>> queryEventList(String custId,QueryModel model,String topfive) {
  		   
  		    PageHelper.startPage(model.getPage(),model.getSize());
  			Map<String, String> paramMap=new HashMap<String, String>();
  			if( topfive!=null&&!topfive.equals("")) {
  			  
  			   paramMap.put("topfive", topfive);
			}
  			paramMap.put("custId", custId);
  			List<Map<String, Object>> list=ocrmFciEventInfoMapper.queryEventList(paramMap);
  			PageHelper.clearPage();
  			return list;
  	}
    /**
     * 查询事件的提醒规则
     */
    @Transactional(readOnly = true)
  	public List<Map<String, Object>> queryRemindDec(QueryModel model) {
 
  			List<Map<String, Object>> list=ocrmFciEventInfoMapper.queryRemindDec();
  			return list;
  	}
  	/**
  	 * 
  	* @方法名称: insertEvent
  	* @方法描述: 保存客户事件
  	* @参数与返回说明: 
  	* @算法描述:
  	 */
  	public OcrmFciEventInfo insertEvent(OcrmFciEventInfo record) {
  		
  	 
  		this.insertSelective(getMapper(), record);
  		return record ;
  	}
  	/**
  	 * 
  	* @方法名称: updateEvent
  	* @方法描述: 更新客户事件
  	* @参数与返回说明: 
  	* @算法描述:
  	 */
        public int updateEvent(Object record) {
        	OcrmFciEventInfo pool = (OcrmFciEventInfo) record;
      	
  		return this.updateSelective(getMapper(), pool);
  		
  	}
  	
        /**
    	 * 
    	* @方法名称: deleteEvent
    	* @方法描述: 删除客户事件
    	* @参数与返回说明: 
    	* @算法描述:
    	 */
  	
  	// @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
  	public int deleteEvent(String id) {
  		
  		OcrmFciEventInfo pool =new OcrmFciEventInfo();
  		pool.setEventId(id);
  		return this.delete(pool);
  	}
  	
  	public List<Map<String,Object>> selectNotice(QueryModel model){
  		List<Map<String,Object>> list=ocrmFciEventInfoMapper.selectNotice(model);
  		return list;
  	}
  	
  	public String queryDate() {
  		String date=ocrmFciEventInfoMapper.queryDate();
  		return date;
  	}
}
