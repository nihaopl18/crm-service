package cn.com.yusys.yusp.uimp.distribution.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFAppointSet;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFAppointSetMapper;
/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFAppointSetService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-29 13:44:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFAppointSetService extends CommonService {
    @Autowired
    private PmaFAppointSetMapper pmaFAppointSetMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFAppointSetMapper;
    }

    @Transactional(readOnly = false)
    public List<Map<String, Object>> getSetting(){
    	//查询业务种类数据
    	List<Map<String, Object>> list = pmaFAppointSetMapper.getBusType();
    	//查询业务种类下配置项
    	for(int i=0;i<list.size();i++) {
    		String busType = list.get(i).get("key").toString();
    		List<Map<String, Object>> listOne = pmaFAppointSetMapper.getSetting(busType);
    		if(listOne.size() > 0) {
    			list.get(i).put("formList", listOne);
    		}else {
    			List<Map<String, Object>> listTwo = pmaFAppointSetMapper.getSettingModel();
    			list.get(i).put("formList", listTwo);
    		}
    	}
    	return list;
    }
    
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Object> saveData(List<PmaFAppointSet> list) throws Exception {
    	ResultDto<Object> resultDto = new ResultDto<>();
    	try {
	    	pmaFAppointSetMapper.delAll();
	    	for (int i = 0; i < list.size(); i++) {
	    		PmaFAppointSet pmaFAppointSet = list.get(i);
				// 新增
				this.pmaFAppointSetMapper.insertSelective(pmaFAppointSet);
			}
    	} catch (Exception e) {
			resultDto.setCode(500);
			resultDto.setMessage(e.getMessage());
			return resultDto;
		}
    	resultDto.setCode(0);
		resultDto.setMessage("新增成功");
    	return resultDto;
    }
}
