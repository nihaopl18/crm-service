package cn.com.yusys.yscrm.custpub.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmFciCustAdmitAllMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciCustAdmitAllService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-31 16:58:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciCustAdmitAllService extends CommonService {
    @Autowired
    private AcrmFciCustAdmitAllMapper acrmFciCustAdmitAllMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.acrmFciCustAdmitAllMapper;
    }

	public int updateBelong(Map<String, String> record) {
		return acrmFciCustAdmitAllMapper.updateBelong(record);
		// TODO 自动生成的方法存根
		
	}
	
	@Transactional(readOnly = true)
	public List<Map<Object, String>> getListOrg(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<Object, String>> list = null;
		String yesNoAdmit = (String)model.getCondition().get("yesNoAdmit");
		String busiType = (String)model.getCondition().get("busiType");
		if (busiType.equals("6")) {
				list = acrmFciCustAdmitAllMapper.getListOrgAll(model);
		}else {
			
				list = acrmFciCustAdmitAllMapper.getListOrg(model);
		}
		PageHelper.clearPage();
		return list;
	}
	@Transactional(readOnly = true)
	public List<Map<String, String>> getListPer(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = null;
		String busiType = (String)model.getCondition().get("busiType");
		String yesNoAdmit = (String)model.getCondition().get("yesNoAdmit");
		if (busiType.equals("6")) {
				list = acrmFciCustAdmitAllMapper.getListPerAll(model);
		}else {
				list = acrmFciCustAdmitAllMapper.getListPer(model);
		}
		PageHelper.clearPage();
		return list;
	}
	public int add(Map<String, Object> map) {
		return insertSelective(getMapper(), map);
	}

}
