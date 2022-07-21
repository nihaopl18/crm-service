package cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.service;

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
import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.domain.PmaFEvlIndexExcelInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.repository.mapper.PmaFEvlIndexExcelInfoMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFEvlIndexExcelInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-04-21 15:02:20
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFEvlIndexExcelInfoService extends CommonService {
	private static String EVL_SEQ="PMA_EVL_SEQ";
    @Autowired
    private PmaFEvlIndexExcelInfoMapper pmaFEvlIndexExcelInfoMapper;
    
    @Autowired
    private SequenceTemplateService sequenceTemplateService;
    
    @Autowired
    private UserInfoService userInfoService;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFEvlIndexExcelInfoMapper;
    }

    /**
     * @方法名称: querylist
     * @方法描述: 查询订单列表数据(分页)
     * @参数与返回说明: 
     * @算法描述: 
     */
    @Transactional(readOnly = true)
	public List<Map<String, Object>> querylist(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.pmaFEvlIndexExcelInfoMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}
    /**
     * @方法名称: addorupdate
     * @方法描述: 新增和修改
     * @参数与返回说明: 
     * @算法描述: 
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<PmaFEvlIndexExcelInfo> addorupdate(PmaFEvlIndexExcelInfo pmaFEvlIndexExcelInfo) {
    	if(pmaFEvlIndexExcelInfo.getId()==null||"".equals(pmaFEvlIndexExcelInfo.getId())) {
			String nextSeq = sequenceTemplateService.getSequenceTemplate(EVL_SEQ, new HashMap<String,String>());
			pmaFEvlIndexExcelInfo.setIndexId(nextSeq);
			pmaFEvlIndexExcelInfo.setOrgId(userInfoService.getGrantOrgCode());
    		ResultDto<PmaFEvlIndexExcelInfo> result = new ResultDto<PmaFEvlIndexExcelInfo>();
        	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        	pmaFEvlIndexExcelInfo.setCreateDate(df.format(new Date()));
        	pmaFEvlIndexExcelInfo.setCreator(userInfoService.getUserInfo().getLoginCode());
        	this.pmaFEvlIndexExcelInfoMapper.insertSelective(pmaFEvlIndexExcelInfo);
        	result.setData(pmaFEvlIndexExcelInfo);
        	result.setMessage("新增成功");
            result.setCode(0);
        	return result;
    	}else {
    		ResultDto<PmaFEvlIndexExcelInfo> result = new ResultDto<PmaFEvlIndexExcelInfo>();
    		pmaFEvlIndexExcelInfo.setModifyUser(userInfoService.getUserInfo().getLoginCode());
        	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        	pmaFEvlIndexExcelInfo.setModifyDate(df.format(new Date()));
    		this.pmaFEvlIndexExcelInfoMapper.updateByPrimaryKeySelective(pmaFEvlIndexExcelInfo);
    		result.setData(pmaFEvlIndexExcelInfo);
    		result.setMessage("修改成功");
    		result.setCode(0);
        	return result;
    	}
    	
	}
    /**
     * @方法名称: del
     * @方法描述: 删除
     * @参数与返回说明: 
     * @算法描述: 
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> del (String ids){
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	String[] id=ids.split(",");
    	for(int i=0;i<id.length;i++) {
    		this.pmaFEvlIndexExcelInfoMapper.deleteByPrimaryKey(id[i]);
    	}
        result.setCode(0);
        result.setMessage("删除成功");
        return result;
        
    }
}
