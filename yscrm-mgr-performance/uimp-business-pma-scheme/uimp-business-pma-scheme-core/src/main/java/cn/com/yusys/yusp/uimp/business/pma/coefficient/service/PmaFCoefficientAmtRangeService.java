package cn.com.yusys.yusp.uimp.business.pma.coefficient.service;

import java.math.BigDecimal;
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
import cn.com.yusys.yusp.uimp.business.pma.coefficient.domain.PmaFCoefficientAmtRange;
import cn.com.yusys.yusp.uimp.business.pma.coefficient.repository.mapper.PmaFCoefficientAmtRangeMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFCoefficientAmtRangeService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-07 14:53:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFCoefficientAmtRangeService extends CommonService {
    @Autowired
    private PmaFCoefficientAmtRangeMapper pmaFCoefficientAmtRangeMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFCoefficientAmtRangeMapper;
    }

	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryList(QueryModel model) {
    	PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.pmaFCoefficientAmtRangeMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}

    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<PmaFCoefficientAmtRange> add(PmaFCoefficientAmtRange pmaFCoefficientAmtRange) {
    	ResultDto<PmaFCoefficientAmtRange> result = new ResultDto<PmaFCoefficientAmtRange>();
		QueryModel modelNew = new QueryModel();
		modelNew.getCondition().put("amt", pmaFCoefficientAmtRange.getStartAmt());
		modelNew.getCondition().put("cdflag", pmaFCoefficientAmtRange.getCdflag());
    	//开始金额 是否需要进行拆分 如果能查询到 则进行拆分
    	PmaFCoefficientAmtRange startAmtObj=   pmaFCoefficientAmtRangeMapper.amtObj(modelNew);
    	modelNew.getCondition().put("amt", pmaFCoefficientAmtRange.getEndAmt());
    	PmaFCoefficientAmtRange endAmtObj=   pmaFCoefficientAmtRangeMapper.amtObj(modelNew);
    	if(endAmtObj!=null){
    		//如果 需要拆分的区间段是同一个金额段 则需要补充 后半部分金额区间
    		if(startAmtObj!=null&&startAmtObj.getId().equals(endAmtObj.getId())){
    			PmaFCoefficientAmtRange supplementCoefficientAmtRangeVo=new PmaFCoefficientAmtRange();
    			supplementCoefficientAmtRangeVo.setCdflag(startAmtObj.getCdflag());
    			supplementCoefficientAmtRangeVo.setAmtCoefficient(startAmtObj.getAmtCoefficient());
    			supplementCoefficientAmtRangeVo.setStartAmt(pmaFCoefficientAmtRange.getEndAmt());
    			supplementCoefficientAmtRangeVo.setEndAmt(new BigDecimal(startAmtObj.getEndAmt().toString())); //处理指针
    	    	pmaFCoefficientAmtRangeMapper.deleteSql(startAmtObj.getStartAmt(),startAmtObj.getCdflag(),startAmtObj.getEndAmt());
    			pmaFCoefficientAmtRangeMapper.insertSelective(supplementCoefficientAmtRangeVo);
    		}else{
    			endAmtObj.setStartAmt(pmaFCoefficientAmtRange.getEndAmt());
    			pmaFCoefficientAmtRangeMapper.insertSelective(endAmtObj);
    		}
        	if(startAmtObj!=null){
            	startAmtObj.setEndAmt(pmaFCoefficientAmtRange.getStartAmt());
            	pmaFCoefficientAmtRangeMapper.insertSelective(startAmtObj);
        	}
    	}
    	pmaFCoefficientAmtRangeMapper.deleteSql(pmaFCoefficientAmtRange.getStartAmt(),pmaFCoefficientAmtRange.getCdflag(),pmaFCoefficientAmtRange.getEndAmt());
    	pmaFCoefficientAmtRangeMapper.insertSelective(pmaFCoefficientAmtRange);
		result.setData(pmaFCoefficientAmtRange);
		result.setMessage("新增成功");
		result.setCode(0);
    	return result;
    }

	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<PmaFCoefficientAmtRange> edit(PmaFCoefficientAmtRange pmaFCoefficientAmtRange) {
		ResultDto<PmaFCoefficientAmtRange> result = new ResultDto<PmaFCoefficientAmtRange>();
		pmaFCoefficientAmtRangeMapper.updateByPrimaryKey(pmaFCoefficientAmtRange);
		result.setData(pmaFCoefficientAmtRange);
		result.setMessage("修改成功");
		result.setCode(0);
		return result;
	}
}
