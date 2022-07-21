package cn.com.yusys.yscrm.cust.person.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.person.domain.OcrmFciLawsuitInfo;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciLawsuitInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciLawsuitInfoService
 * @类描述: #服务类
 * @功能描述: 诉讼信息
 * @创建人: 15104
 * @创建时间: 2019-02-13 12:53:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciLawsuitInfoService extends CommonService {
    @Autowired
    private OcrmFciLawsuitInfoMapper ocrmFciLawsuitInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciLawsuitInfoMapper;
    }

    /**
	 * @方法名称: querylist
	 * @方法描述: 诉讼信息查询
	 * @param
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> querylist(QueryModel model, String custId) {
    	PageHelper.startPage(model.getPage(), model.getSize());
    	
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		
		List<Map<Object, String>>  list = ocrmFciLawsuitInfoMapper.querylist(paramMap);
		PageHelper.clearPage();
		
		return list;
	}

	/**
	 * @方法名称: ctrate
	 * @方法描述: 诉讼信息新增
	 * @param
	 * @return
	 */
	public int ctrate(OcrmFciLawsuitInfo ocrmFciLawsuitInfo) {

		return this.insertSelective(getMapper(), ocrmFciLawsuitInfo);
	}

	/**
	 * @方法名称: ctrate
	 * @方法描述: 诉讼信息修改
	 * @param
	 * @return
	 */
	public int modify(OcrmFciLawsuitInfo ocrmFciLawsuitInfo) {

		return this.updateSelective(getMapper(), ocrmFciLawsuitInfo);
	}

	/**
	 * @方法名称: deleteById
	 * @方法描述: 诉讼信息删除
	 * @param
	 * @return
	 */
	public int delete(String id) {
		OcrmFciLawsuitInfo ocrmFciLawsuitInfo = new OcrmFciLawsuitInfo();
		ocrmFciLawsuitInfo.setId(id);
		return this.delete(ocrmFciLawsuitInfo);
	}
}
