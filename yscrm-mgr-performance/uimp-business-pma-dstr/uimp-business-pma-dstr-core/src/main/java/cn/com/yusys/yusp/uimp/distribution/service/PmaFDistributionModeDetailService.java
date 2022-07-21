package cn.com.yusys.yusp.uimp.distribution.service;

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
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFDistributionModeDetail;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFDistributionModeDetailMapper;
/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFDistributionModeDetailService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-23 10:36:20
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFDistributionModeDetailService extends CommonService {
    @Autowired
    private PmaFDistributionModeDetailMapper pmaFDistributionModeDetailMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFDistributionModeDetailMapper;
    }

    @Transactional(readOnly = true)
   	public List<Map<String,Object>> queryList(QueryModel model){
   		PageHelper.startPage(model.getPage(), model.getSize());
   		List<Map<String,Object>> list = pmaFDistributionModeDetailMapper.queryList(model);
   		PageHelper.clearPage();
   		return list;
   	}
    
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> addInfo(List<PmaFDistributionModeDetail> list){
		ResultDto<Object> result = new ResultDto<Object>();
		if(list.size() > 0) {
			pmaFDistributionModeDetailMapper.delDetail(list.get(0).getBrchNo());
			for(int i=0;i<list.size();i++) {
				pmaFDistributionModeDetailMapper.insertSelective(list.get(i));
			}
		}
		result.setCode(0);
		result.setMessage("保存信息成功");
		return result;
	}
}
