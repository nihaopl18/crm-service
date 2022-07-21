package cn.com.yusys.yscrm.info.custlosswarn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.info.custlosswarn.domain.AcrmFwpLossCustWarnO;
import cn.com.yusys.yscrm.info.custlosswarn.domain.AcrmFwpLossCustWarnP;
import cn.com.yusys.yscrm.info.custlosswarn.repository.mapper.AcrmFwpLossCustWarnOMapper;
import cn.com.yusys.yscrm.info.custlosswarn.repository.mapper.AcrmFwpLossCustWarnPMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yscrm-mgr-info-custlosswarn-core模块
 * @类名称: AcrmFwpLossCustWarnService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-28 16:52:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFwpLossCustWarnService extends CommonService {
    
    @Autowired
    private AcrmFwpLossCustWarnPMapper acrmFwpLossCustWarnPMapper;
    
    @Autowired
    private AcrmFwpLossCustWarnOMapper acrmFwpLossCustWarnOMapper;

    @Autowired
    private UaaClient uaaClient;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFwpLossCustWarnPMapper;
    }
    
    /**
     * @方法名称: queryList
     * @方法描述: 条件查询 - 查询进行分页
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public List<Map<String, Object>> queryList(QueryModel model) {
    	if(model.getCondition().containsKey("detentionResult")) {
    		if(model.getCondition().get("detentionResult") != null && !"".equals(model.getCondition().get("detentionResult")))
    			model.getCondition().put("detentionResult", "%" + model.getCondition().get("detentionResult") + "%");
    	}
    	ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
//        List<ObjBean> roleList = dto.getBody().getRoles();
//    	String loginCode=dto.getBody().getLoginCode();
//    	String orgId=dto.getBody().getOrg().getCode();
//    	boolean isCustMgr = false;
//    	for(ObjBean obj : roleList) {
//    		if("15".equals(obj.getCode())&&roleList.size()==1) {
//    			isCustMgr = true;
//    		}
//    	}
//    	//如果不是客户经理，加入业务条线过滤条件
//    	if(!isCustMgr) {
//    		//加入业务条线授权
//    		if(!"500".equals(orgId)) {
//    			model.getCondition().put("uncertain", " AND c.ORG_ID IN ("+queryOrgId(orgId)+")");
//    		}
//    	}else {
//    		String str=" AND c.MGR_ID="+"'"+loginCode+"'";
//    		model.getCondition().put("uncertain", str);
//    	}
    	PageHelper.startPage(model.getPage(), model.getSize());
    	List<Map<String, Object>> list = null;
    	if(model.getCondition().containsKey("custType")) {
    		if("1".equals(model.getCondition().get("custType"))) {	// 个人
    			list = acrmFwpLossCustWarnPMapper.queryList(model);
    		} else if("2".equals(model.getCondition().get("custType"))) {	// 对公
    			list = acrmFwpLossCustWarnOMapper.queryList(model);
    		}
    	} else 
    		return list;
    	PageHelper.clearPage();
    	return list;
    }
    
    /**
     * @方法名称: selectByLossId
     * @方法描述: 根据 主键 查询
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public Object selectByLossId(String custType, String id) {
    	if("1".equals(custType)) {	// 个人
    		return acrmFwpLossCustWarnPMapper.selectByLossId(id);
    	} else if("2".equals(custType)) {	// 对公
    		return acrmFwpLossCustWarnOMapper.selectByLossId(id);
    	}
		return null;
    }
    
    /**
     * @方法名称: updatePerResult
     * @方法描述: 修改个人-客户预警信息
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public int updatePerResult(AcrmFwpLossCustWarnP acrmFwpLossCustWarnP) {
    	// TODO 增加异常处理 
        return acrmFwpLossCustWarnPMapper.updateByPrimaryKeySelective(acrmFwpLossCustWarnP);
    }
    
    /**
     * @方法名称: updateCorResult
     * @方法描述: 修改对公-客户预警信息
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public int updateCorResult(AcrmFwpLossCustWarnO acrmFwpLossCustWarnO) {
    	// TODO 增加异常处理 
        return acrmFwpLossCustWarnOMapper.updateByPrimaryKeySelective(acrmFwpLossCustWarnO);
    }
    
    @Transactional(readOnly = true)
    public String queryOrgId(String orgId) {
    	List<Map<String,String>> list=acrmFwpLossCustWarnPMapper.queryOrgId(orgId);
    	StringBuilder sb=new StringBuilder();
    	for (Map<String,String> map : list) {
    		sb.append("'"+map.get("orgId")+"'"+",");
		}
    	String id=sb.toString();
    	id=id.substring(0,id.lastIndexOf(","));
    	return id;
    }

}
