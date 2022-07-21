package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepLoansRel;

import java.util.List;
import java.util.Map;

public interface PmaFComDepLoansRelMapper extends CommonMapper<PmaFComDepLoansRel> {

    /**
     * 查询贷款明细记录
     * @param model
     * @return
     */
    List<Map<String, Object>> queryList(QueryModel model);

    /**
     * 根据id删除明细表
     * @param id
     * @return
     */
    int  delDistribute(String id);

    /**
     * 批量插入明细表
     * @param list
     */
    void batchInsertDistribute(List<PmaFComDepLoansRel> list);
}
