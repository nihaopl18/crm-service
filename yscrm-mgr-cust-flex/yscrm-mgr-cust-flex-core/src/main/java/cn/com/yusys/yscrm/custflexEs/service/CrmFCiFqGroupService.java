package cn.com.yusys.yscrm.custflexEs.service;


import cn.com.yusys.yscrm.custflexEs.repository.mapper.CrmFCiFqGroupMapper;
import cn.com.yusys.yscrm.custflexEs.vo.CrmFCiFqObjNodeVo;
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
 * @类名称: CrmFCiFqGroupService
 * @类描述: #数据集—分组 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-29 11:26:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class CrmFCiFqGroupService extends CommonService {
	
	private static final Logger log = LoggerFactory.getLogger(CrmFCiFqGroupService.class);
	
    @Autowired
    private CrmFCiFqGroupMapper crmFCiFqGroupMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return crmFCiFqGroupMapper;
    }

	/**
     * @函数名称:queryFqTreeData
     * @函数描述:查询灵活查询左侧树-分组数据
     * @参数与返回说明:
     * @算法描述:
     */
	public List<CrmFCiFqObjNodeVo> queryFqTreeData(String objId) throws Exception {
		if(StringUtil.isNotEmpty(objId)) {
			return crmFCiFqGroupMapper.queryFqGroupDataByObjId(objId);
		} else {
			log.warn("param objId is null");
			return null;
		}
	}
}
