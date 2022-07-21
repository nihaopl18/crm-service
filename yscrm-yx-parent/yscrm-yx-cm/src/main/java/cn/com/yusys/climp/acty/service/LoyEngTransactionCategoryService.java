package cn.com.yusys.climp.acty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.climp.acty.repository.mapper.LoyEngTransactionCategoryMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngTransactionCategoryService
 * @类描述: 交易类型服务类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyEngTransactionCategoryService extends CommonService {
    @Autowired
    private LoyEngTransactionCategoryMapper loyEngTransactionCategoryMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return loyEngTransactionCategoryMapper;
    }
    /**
	 * 查询交易码
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> searchTransCode(String transType) {
		return loyEngTransactionCategoryMapper.searchTransCode(transType);
	}
	/**
	 * 查询所有码值
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> searchLookupCode() {
		return loyEngTransactionCategoryMapper.searchLookupCode();
	}
}
