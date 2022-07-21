package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFIndexCdtInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper.PmaFBaseIndexConditionMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexConditionService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-07 11:29:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFBaseIndexConditionService extends CommonService {
    @Autowired
    private PmaFBaseIndexConditionMapper pmaFBaseIndexConditionMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFBaseIndexConditionMapper;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(String indexId) {	
		List<Map<String, Object>> list = this.pmaFBaseIndexConditionMapper.querylist(indexId);
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFIndexCdtInfo> add (PmaFIndexCdtInfo pmaFIndexCdtInfo) throws Exception {
    	ResultDto<PmaFIndexCdtInfo> result = new ResultDto<PmaFIndexCdtInfo>();    
        //保存指标基本信息
    	this.pmaFBaseIndexConditionMapper.insertSelective(pmaFIndexCdtInfo);
		result.setData(pmaFIndexCdtInfo);
		result.setMessage("新增筛选条件成功");
		result.setCode(0);
    	return result;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> delCondition(String  id){
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	this.pmaFBaseIndexConditionMapper.delCondition(id);
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
}
