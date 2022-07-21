package cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.service;

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
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain.PmaFPersonpostParamInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.repository.mapper.PmaFPersonpostParamInfoMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFPersonpostParamInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-10 15:10:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFPersonpostParamInfoService extends CommonService {
	private static String PARAM_SEQ="POST_PARAM_ID_SEQ";
    @Autowired
    private PmaFPersonpostParamInfoMapper pmaFPersonpostParamInfoMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private SequenceTemplateService sequenceTemplateService;
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFPersonpostParamInfoMapper;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) {
    	PageHelper.startPage(model.getPage(), model.getSize());
    	String  orgQxSql=userInfoService.getDataOrgAuth("T.ORG_ID", false);
    	String menuOrgQxSql=userInfoService.getDataOrgAuth("menu.ORG_ID", false);
		model.getCondition().put("sql",orgQxSql);
		model.getCondition().put("menuSql", menuOrgQxSql);
		List<Map<String, Object>> list = this.pmaFPersonpostParamInfoMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFPersonpostParamInfo> add (PmaFPersonpostParamInfo pmaFPersonpostParamInfo) throws Exception {
    	ResultDto<PmaFPersonpostParamInfo> result = new ResultDto<PmaFPersonpostParamInfo>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	String paramId = sequenceTemplateService.getSequenceTemplate(PARAM_SEQ, new HashMap<String,String>());
        String paramIdStr = paramId;
        pmaFPersonpostParamInfo.setParamId(paramIdStr);
        pmaFPersonpostParamInfo.setCreateDate(df.format(new Date()));//创建时间
        pmaFPersonpostParamInfo.setCreator(userInfoService.getUserInfo().getLoginCode());   
        pmaFPersonpostParamInfo.setOrgId(userInfoService.getGrantOrgCode());
        //保存参数基本信息
    	this.pmaFPersonpostParamInfoMapper.insertSelective(pmaFPersonpostParamInfo);
		result.setData(pmaFPersonpostParamInfo);
		result.setMessage("新增参数信息成功");
		result.setCode(0);
    	return result;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFPersonpostParamInfo> modify (PmaFPersonpostParamInfo pmaFPersonpostParamInfo) throws Exception {
    	ResultDto<PmaFPersonpostParamInfo> result = new ResultDto<PmaFPersonpostParamInfo>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	pmaFPersonpostParamInfo.setModifyDate(df.format(new Date()));//创建时间
    	pmaFPersonpostParamInfo.setModifyUser(userInfoService.getUserInfo().getLoginCode());        
        //保存参数基本信息
    	this.pmaFPersonpostParamInfoMapper.updateByPrimaryKeySelective(pmaFPersonpostParamInfo);
		result.setData(pmaFPersonpostParamInfo);
		result.setMessage("修改参数信息成功");
		result.setCode(0);
    	return result;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> delete (String  ids){
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	String[] id = ids.split(",");
    	for (int i =0 ;i < id.length ; i++) {	
    		pmaFPersonpostParamInfoMapper.deleteByIds(id[i]);
    	}
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querypostlist() {
		List<Map<String, Object>> list = this.pmaFPersonpostParamInfoMapper.querypostlist();
		return list;
	}
    @Transactional(readOnly = true)
    public String queryNameByParamId(String paramId) {
		return this.pmaFPersonpostParamInfoMapper.queryNameByParamId(paramId);
	}
}
