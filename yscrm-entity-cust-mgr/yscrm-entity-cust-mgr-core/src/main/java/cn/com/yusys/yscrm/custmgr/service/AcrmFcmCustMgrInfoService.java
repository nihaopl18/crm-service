package cn.com.yusys.yscrm.custmgr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.custmgr.repository.mapper.AcrmFcmCustMgrInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmFcmCustMgrInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: luhongyan
 * @创建时间: 2019-01-31 22:21:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFcmCustMgrInfoService extends CommonService {
    @Autowired
    private AcrmFcmCustMgrInfoMapper acrmFcmCustMgrInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFcmCustMgrInfoMapper;
    }
    
    /**
     * 根据客户经理编号获取客户经理表单信息
     * @param queryModel
     * @param mgrId
     * @return
     */
    public List<Map<String, Object>> queryinfo(String mgrId) {
		List<Map<String, Object>> list = acrmFcmCustMgrInfoMapper.queryinfo(mgrId);
		return list;
	}

}
