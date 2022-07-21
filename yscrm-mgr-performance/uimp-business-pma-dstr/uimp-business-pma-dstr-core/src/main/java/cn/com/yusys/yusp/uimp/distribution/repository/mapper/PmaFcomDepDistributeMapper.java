package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFcomDepDistributeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author:Mr.raop
 * @create:2022-05-10
 */
public interface PmaFcomDepDistributeMapper extends CommonMapper<PmaFcomDepDistributeInfo> {

    /**
     * 查询列表
     * @param model
     * @return
     */
    List<Map<String, Object>> queryList(QueryModel model);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int  delDistribute(String id);

    /**
     * 批量插入明细记录
     * @param list
     */
    void batchInsertDistribute(List<PmaFcomDepDistributeInfo> list);

    /**
     * 批量更新明细记录
     * @param distributeListsUp
     */
    void batchUpdateDistribute(List<PmaFcomDepDistributeInfo> distributeListsUp);

    /**
     * 根据acctInfoId删除
     * @param acctInfoId
     * @return
     */
    void delDistributeFail(String acctInfoId);

    /**
     * 根据ACCT_INFO_NO更新applySts
     * @param acctInfoNo
     * @param applySts
     */
    void updateDistributeByAcctInfoNo (@Param("acctInfoNo") String acctInfoNo, @Param("applySts") String applySts);
}
