package cn.com.yusys.yscrm.custflexEs.service;

import cn.com.yusys.yscrm.custflexEs.repository.mapper.CrmFCiFqScolMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmFCiFqScolService
 * @类描述: #数据集-查询条件 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2021-01-02 14:02:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class CrmFCiFqScolService extends CommonService {
	
	private static final Logger log = LoggerFactory.getLogger(CrmFCiFqScolService.class);
	
    @Autowired
    private CrmFCiFqScolMapper crmFCiFqScolMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return crmFCiFqScolMapper;
    }

    /**
     * @函数名称:queryFqScolBySsid
     * @函数描述:根据方案主键ssId 查询-查询条件信息
     * @参数与返回说明:
     * @算法描述:
     */
	public List<Map<String, Object>> queryFqScolBySsid(String ssId) throws Exception {
		return crmFCiFqScolMapper.queryFqScolBySsid(ssId);
	}
	
	/**
     * @函数名称:deleteBySsIds
     * @函数描述:批量删除方案-查询条件信息
     * @参数与返回说明:
     * @算法描述:
     */
	public Integer deleteBySsIds(String ids) throws Exception {
		if(StringUtil.isNotEmpty(ids)) {
			return crmFCiFqScolMapper.deleteBySsIds(ids.split(","));
		} else {
			log.warn("ids is null, cannot delete solution-scol info");
			return 0;
		}
	}
}
