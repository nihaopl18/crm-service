package cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.sequence.service.SequenceTemplateService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.domain.PmaFParamInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.repository.mapper.PmaFParamInfoMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFParamInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-09 15:32:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFParamInfoService extends CommonService {
	private static String PARAM_SEQ="PARAM_ID_SEQ";
    @Autowired
    private PmaFParamInfoMapper pmaFParamInfoMapper;

    @Autowired
    private SequenceTemplateService sequenceTemplateService;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFParamInfoMapper;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) {
    	PageHelper.startPage(model.getPage(), model.getSize());
    	String orgQxSql=userInfoService.getDataOrgAuth("T.ORG_ID", false);
    	String menuOrgQxSql=userInfoService.getDataOrgAuth("menu.ORG_ID", false);
		model.getCondition().put("sql",orgQxSql);
		model.getCondition().put("menuSql", menuOrgQxSql);
		List<Map<String, Object>> list = this.pmaFParamInfoMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFParamInfo> add (PmaFParamInfo pmaFParamInfo) throws Exception {
    	ResultDto<PmaFParamInfo> result = new ResultDto<PmaFParamInfo>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	String paramId = sequenceTemplateService.getSequenceTemplate(PARAM_SEQ, new HashMap<String,String>());
        String paramIdStr = paramId;
        pmaFParamInfo.setParamId(paramIdStr);
        pmaFParamInfo.setCreateDate(df.format(new Date()));//创建时间
        pmaFParamInfo.setCreator(userInfoService.getUserInfo().getLoginCode());  
        pmaFParamInfo.setOrgId(userInfoService.getGrantOrgCode());
        //保存参数基本信息
    	this.pmaFParamInfoMapper.insertSelective(pmaFParamInfo);
		result.setData(pmaFParamInfo);
		result.setMessage("新增参数信息成功");
		result.setCode(0);
    	return result;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFParamInfo> modify (PmaFParamInfo pmaFParamInfo) throws Exception {
    	ResultDto<PmaFParamInfo> result = new ResultDto<PmaFParamInfo>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	pmaFParamInfo.setModifyDate(df.format(new Date()));//创建时间
    	pmaFParamInfo.setModifyUser(userInfoService.getUserInfo().getLoginCode());        
        //保存参数基本信息
    	this.pmaFParamInfoMapper.updateByPrimaryKeySelective(pmaFParamInfo);
		result.setData(pmaFParamInfo);
		result.setMessage("修改参数信息成功");
		result.setCode(0);
    	return result;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> delete (String  ids){
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	String[] id = ids.split(",");
    	for (int i =0 ;i < id.length ; i++) {	
    		pmaFParamInfoMapper.deleteByIds(id[i]);
    	}
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryorglist() {
		List<Map<String, Object>> list = this.pmaFParamInfoMapper.queryorglist();
		return list;
	}
    
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryAuth(String paramId) {
    	List<Map<String, Object>> list = this.pmaFParamInfoMapper.queryAuth(paramId);
    	return list;
    }
    
    @Transactional(readOnly = true)
    public String queryNameByParamId(String paramId) {
    	return this.pmaFParamInfoMapper.queryNameByParamId(paramId);
    }
}
