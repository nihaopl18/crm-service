package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepLoansPeriod;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepPeriod;

import java.util.List;
import java.util.Map;

public interface PmaFComDepLoansPeriodMapper extends CommonMapper<PmaFComDepLoansPeriod> {
    /**
     * 查询贷款列表
     * @param model
     * @return
     */
    List<Map<String, Object>> queryList(QueryModel model);

    /**
     * 根据id删除贷款区间表
     * @param id
     * @return
     */
    int  delPmaFComDepPeriod(String id);

    /**
     * 批量插入贷款区间及明细
     * @param list
     */
    void batchInsertPeriod(List<PmaFComDepLoansPeriod> list);
}
