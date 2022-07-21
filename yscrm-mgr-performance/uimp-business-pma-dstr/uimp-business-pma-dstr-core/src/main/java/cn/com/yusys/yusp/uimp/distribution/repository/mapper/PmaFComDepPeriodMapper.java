package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepPeriod;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PmaFComDepPeriodMapper extends CommonMapper<PmaFComDepPeriod> {
    /**
     * 查询区间表信息
     * @param model
     * @return
     */
    List<Map<String, Object>> queryList(QueryModel model);

    /**
     * 根据id删除区间表信息
     * @param id
     * @return
     */
    int  delPmaFComDepPeriod(String id);

    /**
     * 批量插入区间表信息
     * @param list
     */
    void batchInsertPeriod(List<PmaFComDepPeriod> list);

    /**
     * 根据ACCT_INFO_NO更新applySts
     * @param acctInfoNo
     * @param applySts
     */
    void updatePeriodByAcctInfoNo (@Param("acctInfoNo") String acctInfoNo, @Param("applySts") String applySts);

    /**
     * 批量更新区间表信息
     * @param periodListsUp
     */
    void batchUpdatePeriod(List<PmaFComDepPeriod> periodListsUp);
}
