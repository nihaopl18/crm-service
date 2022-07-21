package cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.domain.PmaFBaseIndexRes;
import cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.domain.PmaFSchemeIndexAdjust;
import cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.repository.mapper.PmaFBaseIndexResMapper;
import cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.repository.mapper.PmaFSchemeIndexAdjustMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexResService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-06 10:46:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFBaseIndexResService extends CommonService {
    @Autowired
    private PmaFBaseIndexResMapper pmaFBaseIndexResMapper;
    
    @Autowired
    private PmaFSchemeIndexAdjustMapper pmaFSchemeIndexAdjustMapper;

	@Qualifier("performanceUserInfoService")
	@Autowired
	private UserInfoService userInfoService;
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFBaseIndexResMapper;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		String etlDate = model.getCondition().get("etlDate")!= null ? model.getCondition().get("etlDate").toString().replaceAll("-", "") + "" : "";
		model.getCondition().replace("etlDate", etlDate);
		String evlObjIdS="";
		String indexS="";
		String[] evlObjIdStr;
		String[] indexIdStrs;
		if(model.getCondition().get("evlObjId")!=null&&!model.getCondition().get("evlObjId").equals("")) {
			 evlObjIdS=model.getCondition().get("evlObjId").toString();
			 evlObjIdStr=evlObjIdS.split(",");
			 model.getCondition().put("evlObjId", evlObjIdStr);
			 model.getCondition().put("evlObjIdSize",evlObjIdStr.length);
		}
        if(model.getCondition().get("indexId")!=null&&!model.getCondition().get("indexId").equals("")) {
    		indexS=model.getCondition().get("indexId").toString();
    		indexIdStrs=indexS.split(",");
    		model.getCondition().put("indexId", indexIdStrs);
    		model.getCondition().put("indexIdSize", indexIdStrs.length);
		}
		List<Map<String, Object>> list = this.pmaFBaseIndexResMapper.listByModel(model);
		PageHelper.clearPage();
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFBaseIndexRes> modify (PmaFBaseIndexRes pmafbaseindexres) throws Exception {
		UserInfoDTO  user = this.getUser();
    	ResultDto<PmaFBaseIndexRes> result = new ResultDto<PmaFBaseIndexRes>();
    	if(pmafbaseindexres.getOldIndexValue() == null) {
    		QueryModel model = new QueryModel();
    		model.getCondition().put("indexId", pmafbaseindexres.getIndexId());
    		model.getCondition().put("applyType", pmafbaseindexres.getApplyType());
    		model.getCondition().put("balType", pmafbaseindexres.getBalType());
    		model.getCondition().put("evlObjId", pmafbaseindexres.getEvlObjId());
    		model.getCondition().put("evlObjType", pmafbaseindexres.getEvlObjType());
    		model.getCondition().put("etlDate", pmafbaseindexres.getEtlDate());
    		List<Map<String, Object>> list = this.pmaFBaseIndexResMapper.queryIndexValueF(model);
    		pmafbaseindexres.setOldIndexValue((BigDecimal) list.get(0).get("indexValue"));
    	}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    	PmaFSchemeIndexAdjust pmafschemeindexadjust = new PmaFSchemeIndexAdjust();
    	pmafschemeindexadjust.setApplyType(pmafbaseindexres.getApplyType());
    	pmafschemeindexadjust.setBalType(pmafbaseindexres.getBalType());
    	pmafschemeindexadjust.setEvlObjId(pmafbaseindexres.getEvlObjId());
    	pmafschemeindexadjust.setEvlObjType(pmafbaseindexres.getEvlObjType());
    	pmafschemeindexadjust.setIndexId(pmafbaseindexres.getIndexId());
    	pmafschemeindexadjust.setIndexValue(pmafbaseindexres.getIndexValue());
    	pmafschemeindexadjust.setOldIndexValue(pmafbaseindexres.getOldIndexValue());
    	pmafschemeindexadjust.setModifyDate(dateFormat.format(new Date()));
    	pmafschemeindexadjust.setModifyUsername(user.getLoginCode());
    	pmafschemeindexadjust.setEtlDate(pmafbaseindexres.getEtlDate());
		QueryModel modelNew = new QueryModel();
		modelNew.getCondition().put("indexId", pmafbaseindexres.getIndexId());
		modelNew.getCondition().put("applyType", pmafbaseindexres.getApplyType());
		modelNew.getCondition().put("balType", pmafbaseindexres.getBalType());
		modelNew.getCondition().put("evlObjId", pmafbaseindexres.getEvlObjId());
		modelNew.getCondition().put("evlObjType", pmafbaseindexres.getEvlObjType());
		modelNew.getCondition().put("etlDate", pmafbaseindexres.getEtlDate());
    	String aId = this.pmaFSchemeIndexAdjustMapper.queryAdjustId(modelNew);
    	if("".equals(aId)||aId==null) {
    		pmaFSchemeIndexAdjustMapper.insertSelective(pmafschemeindexadjust);
    	}else {
        	pmaFSchemeIndexAdjustMapper.updateByPrimaryKeySelective(pmafschemeindexadjust);
    	}
		this.pmaFBaseIndexResMapper.updateByPrimaryKeySelective(pmafbaseindexres);
		result.setData(pmafbaseindexres);
		result.setMessage("修改成功");
		result.setCode(0);
    	return result;
    }
    private UserInfoDTO getUser() {
		UserInfoDTO user = userInfoService.getUserInfo();
    	return user;
    }
}
