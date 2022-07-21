package cn.com.yusys.yscrm.info.remind.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.info.remind.domain.OcrmFwpRemindChlNex;
import cn.com.yusys.yscrm.info.remind.domain.OcrmFwpRemindRule;
import cn.com.yusys.yscrm.info.remind.repository.mapper.OcrmFwpRemindChlMapper;
import cn.com.yusys.yscrm.info.remind.repository.mapper.OcrmFwpRemindChlNexMapper;
import cn.com.yusys.yscrm.info.remind.repository.mapper.OcrmFwpRemindRuleMapper;
import cn.com.yusys.yscrm.info.remind.repository.mapper.OcrmFwpRemindRuleTypeMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: OcrmFwpRemindRuleService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-19 09:00:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFwpRemindRuleService extends CommonService {
    @Autowired
    private OcrmFwpRemindRuleMapper ocrmFwpRemindRuleMapper;
    
    @Autowired
    private OcrmFwpRemindRuleTypeMapper ocrmFwpRemindRuleTypeMapper;
    
    @Autowired
    private OcrmFwpRemindChlNexMapper ocrmFwpRemindChlNexMapper;
    
    @Autowired
    private OcrmFwpRemindChlMapper ocrmFwpRemindChlMapper;

	@Autowired
	private UaaClient uaaClient;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFwpRemindRuleMapper;
    }

    /**
     * @方法名称: queryTree
     * @方法描述: 查询提醒规则树，公共API接口
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public List<Map<String, Object>> queryTree() {
    	List<Map<String, Object>> list = ocrmFwpRemindRuleTypeMapper.queryTree();
    	return list;
    }
    
    /**
     * @方法名称: queryList
     * @方法描述: 提醒规则 列表查询，公共API接口 - 查询进行分页
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public List<Map<String, Object>> queryList(QueryModel model) {
    	List<Map<String, Object>> list = null;
    	PageHelper.startPage(model.getPage(), model.getSize());
		list = ocrmFwpRemindRuleMapper.queryList(model);
    	PageHelper.clearPage();
    	return list;
    }
    
    /**
     * @方法名称: queryChl
     * @方法描述: 提醒渠道查询
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public List<Map<String, Object>> queryChl() {
    	List<Map<String, Object>> list = null;
		list = ocrmFwpRemindChlMapper.queryChl();
    	return list;
    }
    
    /**
     * @方法名称: insertData
     * @方法描述: 新增 提醒规则 数据
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public Integer insertData(OcrmFwpRemindRule ocrmFwpRemindRule) {
    	// TODO 异常处理
    	Integer result = 0;
    	ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	ocrmFwpRemindRule.setCorpOrgCode(dto.getBody().getInstu().getCode());
    	ocrmFwpRemindRule.setCreateDate(new Date());
    	String isSendMes = ocrmFwpRemindRule.getIsSendMes();
    	String messageModel = ocrmFwpRemindRule.getMessageModel();
    	// 由于以上两个字段不在 OCRM_F_WP_REMIND_RULE 表中，
    	// 确保保存不报错，将这两个字段在对象中置空
    	ocrmFwpRemindRule.setIsSendMes(null);
    	ocrmFwpRemindRule.setMessageModel(null);
    	result = this.insertSelective(ocrmFwpRemindRule);
    	if("1".equals(isSendMes)) {	// 如果发送短信， 新增 提醒规则渠道关系表 数据
    		OcrmFwpRemindChlNex ocrmFwpRemindChlNex = new OcrmFwpRemindChlNex();
    		ocrmFwpRemindChlNex.setRuleId(ocrmFwpRemindRule.getRuleId());
    		ocrmFwpRemindChlNex.setChlId("C01");
    		ocrmFwpRemindChlNex.setMessageModel(messageModel);
    		ocrmFwpRemindChlNexMapper.insertSelective(ocrmFwpRemindChlNex);
    	}
    	return result;
    }
    
    /**
     * @方法名称: updateData
     * @方法描述: 更新 提醒规则 数据
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public Integer updateData(OcrmFwpRemindRule ocrmFwpRemindRule) {
    	// TODO 异常处理
    	Integer result = 0;
    	ocrmFwpRemindRule.setUpdateDate(new Date());
    	String ruleId = ocrmFwpRemindRule.getRuleId();
    	String isSendMes = ocrmFwpRemindRule.getIsSendMes();
    	String messageModel = ocrmFwpRemindRule.getMessageModel();
    	ocrmFwpRemindRule.setIsSendMes(null);
    	ocrmFwpRemindRule.setMessageModel(null);
    	result = this.updateSelective(ocrmFwpRemindRule);
    	if("1".equals(isSendMes)) {
    		List<Map<String, Object>> list = ocrmFwpRemindChlNexMapper.findData(ruleId, "C01");
    		if(list.size() == 1) {
    			result += ocrmFwpRemindChlNexMapper.updateData(ruleId, "C01", messageModel);
    		} else if(list.size() == 0) {
    			result += ocrmFwpRemindChlNexMapper.insertData(ruleId, "C01", messageModel);
    		}
    	} else if("0".equals(isSendMes)) {
    		result += ocrmFwpRemindChlNexMapper.deleteData(ruleId, "C01");
    	}
    	return result;
    }
}
