package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.base.repository.mapper.PmaFSmEtlLogMapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: PmaFetlDateService
 * @类描述: #数据日期表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-09-21 16:49:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFSmEtlLogService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFSmEtlLogService.class);
	
    @Autowired
    private PmaFSmEtlLogMapper pmaFSmEtlLogMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFSmEtlLogMapper;
    }

    /**
     * @函数名称:queryList
     * @函数描述:列表查询接口
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryList(QueryModel queryModel) throws Exception {
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = pmaFSmEtlLogMapper.queryList(queryModel);
		PageHelper.clearPage();
		return list;
	}

}
