package cn.com.yusys.yusp.uimp.distribution.planDstr.service;

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
import cn.com.yusys.yusp.uimp.displan.domain.PmaFDisPlanInfo;
import cn.com.yusys.yusp.uimp.displan.repository.mapper.PmaFDisPlanInfoMapper;
/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFDisPlanInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-03-26 10:05:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFDisPlanInfoService extends CommonService {
    @Autowired
    private PmaFDisPlanInfoMapper pmaFDisPlanInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFDisPlanInfoMapper;
    }
    /**
     *  查询 
     * @param model
     * @return
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.pmaFDisPlanInfoMapper.listByModel(model);
		PageHelper.clearPage();
		return list;
	}
    /**
     * 新增
     * @param pmaFDisPlanInfo
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<PmaFDisPlanInfo> add(PmaFDisPlanInfo pmaFDisPlanInfo) {
    	ResultDto<PmaFDisPlanInfo> result = new ResultDto<PmaFDisPlanInfo>();
    	this.pmaFDisPlanInfoMapper.insertSelective(pmaFDisPlanInfo);
    	result.setData(pmaFDisPlanInfo);
    	result.setMessage("新增成功");
        result.setCode(0);
    	return result;
    }
    /**
     * 删除
     * @param ids
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> delete (String  ids){
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	String[] id = ids.split(",");
    	for (int i =0 ;i < id.length ; i++) {	
    		pmaFDisPlanInfoMapper.deleteByIds(id[i]);
    	}
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
    /**
     * 修改
     * @param pmaFDisPlanInfo
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFDisPlanInfo> modify (PmaFDisPlanInfo pmaFDisPlanInfo){
    	ResultDto<PmaFDisPlanInfo> result = new ResultDto<PmaFDisPlanInfo>();
		this.pmaFDisPlanInfoMapper.updateByPrimaryKeySelective(pmaFDisPlanInfo);
		result.setData(pmaFDisPlanInfo);
		result.setMessage("修改成功");
		result.setCode(0);
    	return result;
    }
}
