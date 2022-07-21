package cn.com.yusys.yscrm.custflexEs.service;

import cn.com.yusys.yscrm.custflexEs.domain.CrmFCiFqSsolution;
import cn.com.yusys.yscrm.custflexEs.repository.mapper.CrmFCiFqSsolutionMapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
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
 * @类名称: CrmFCiFqSsolutionService
 * @类描述: #数据集-查询方案 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2021-01-02 13:04:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class CrmFCiFqSsolutionService extends CommonService {
	
	private static final Logger log = LoggerFactory.getLogger(CrmFCiFqSsolutionService.class);
	
    @Autowired
    private UserInfoService userInfoService;
    
    @Autowired
    private CrmFCiFqSsolutionMapper crmFCiFqSsolutionMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return crmFCiFqSsolutionMapper;
    }

	/**
     * @函数名称:querySolutionList
     * @函数描述:查询灵活查询方案列表信息
     * @参数与返回说明:
     * @算法描述:
     * 查询本人创建的灵活查询方案信息
     */
	public List<Map<String, Object>> querySolutionList(QueryModel model) throws Exception {
		model.getCondition().put("ssUser", userInfoService.getUserInfo().getLoginCode());
		List<Map<String, Object>> list = crmFCiFqSsolutionMapper.querySolutionList(model);
		return list;
	}
	
	/**
     * @函数名称:isRepeatSsName 通过创建人 加方案名称判断 当前方案是否存在
     * @函数描述:判断方案名是否重复
     * @参数与返回说明:
     * @算法描述:
     */
	public List<CrmFCiFqSsolution> isRepeatSsName(String ssName) throws Exception {
		return crmFCiFqSsolutionMapper.queryBySsName(ssName,userInfoService.getUserInfo().getLoginCode());
	}
	
	/**
     * @函数名称:deleteBySsIds
     * @函数描述:批量删除方案信息
     * @参数与返回说明:
     * @算法描述:
     */
	public Integer deleteBySsIds(String ids) throws Exception {
		if(StringUtil.isNotEmpty(ids)) {
			return crmFCiFqSsolutionMapper.deleteBySsIds(ids.split(","));
		} else {
			log.warn("ids is null, cannot delete solution info");
			return 0;
		}
	}
}
