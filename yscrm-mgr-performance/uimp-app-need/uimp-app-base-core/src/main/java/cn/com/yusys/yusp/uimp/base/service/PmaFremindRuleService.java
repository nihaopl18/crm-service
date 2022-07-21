package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.base.domain.PmaFremindRule;
import cn.com.yusys.yusp.uimp.base.repository.mapper.PmaFremindRuleMapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: PmaFremindRuleService
 * @类描述: #信息提醒规则  服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-07-06 10:02:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFremindRuleService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFremindRuleService.class);
	
    @Autowired
    private PmaFremindRuleMapper pmaFremindRuleMapper;
    
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFremindRuleMapper;
    }

    
    /**
     * @函数名称:queryList
     * @函数描述:查询对象列表，公共API接口
     * @参数与返回说明:
     * @param QueryModel
     *            分页查询类
     * @算法描述:
     */
	public List<PmaFremindRule> queryList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<PmaFremindRule> list = pmaFremindRuleMapper.queryList(model);
		PageHelper.clearPage();
		return list;
	}
	
	/**
     * @方法名称: add
     * @方法描述: 新增 信息提醒规则数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public String add(PmaFremindRule rule) throws Exception {
    	String id = "";
    	try {
    		rule.setId(null);
    		rule.setCratUser(userInfoService.getUserInfo().getLoginCode());
    		rule.setCratOrgId(userInfoService.getUserInfo().getOrg().getCode());
    		rule.setCratDt(new Date());
    		pmaFremindRuleMapper.insertSelective(rule);
    		id = rule.getId();
    	} catch (Exception e) {
    		logger.error("service add error !");
    		e.printStackTrace();
    		throw e;
    	}
    	return id;
    }

    /**
     * @方法名称: modify
     * @方法描述: 修改 信息提醒规则数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public String modify(PmaFremindRule rule) throws Exception {
    	String id = "";
    	try {
    		if(StringUtil.isEmpty(rule.getId())) {
    			logger.warn("id is null, can not modify");
    			return "";
    		}
    		rule.setLastChgUsr(userInfoService.getUserInfo().getLoginCode());
    		rule.setLastChgOrgId(userInfoService.getUserInfo().getOrg().getCode());
    		rule.setLastChgDt(new Date());
    		pmaFremindRuleMapper.updateByPrimaryKeySelective(rule);
    		id = rule.getId();
    	} catch (Exception e) {
    		logger.error("service modify error !");
    		logger.error("error id is " + rule.getId());
    		e.printStackTrace();
    		throw e;
    	}
    	return id;
    }
    
    /**
     * @方法名称: deleteData
     * @方法描述: 删除  信息提醒规则
     * @参数与返回说明: 
     * @算法描述:
     *   物理删除
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer deleteData(String ids) throws Exception {
    	Integer code = 0;
    	try {
    		if(StringUtil.isEmpty(ids)) {
    			logger.warn("ids is null, can not delete");
    			return -9;
    		}
    		pmaFremindRuleMapper.deleteByIds(ids);
    	} catch (Exception e) {
    		logger.error("service deleteData error !");
    		logger.error("error ids is " + ids);
    		e.printStackTrace();
    		throw e;
    	}
    	return code;
    }


	public Integer okData(String ids,String status) {

    	Integer code = 0;
    	try {
    		if(StringUtil.isEmpty(ids)) {
    			logger.warn("ids is null, can not delete");
    			return -9;
    		}
    		String []idStr = ids.split(",");
    		for (int i = 0; i < idStr.length; i++) {
				String id = idStr[i];
	    		pmaFremindRuleMapper.pushSql(id,status);
			}
    	} catch (Exception e) {
    		logger.error("service pushSql error !");
    		logger.error("error ids is " + ids);
    		e.printStackTrace();
    		throw e;
    	}
    	return code;
    	}
}
