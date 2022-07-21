package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepAcctInfo;
import cn.com.yusys.yusp.uimp.distribution.factory.RedisCache;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PmaFComDepAcctInfoMapper extends CommonMapper<PmaFComDepAcctInfo> {

    /**
     * 查询存款信息
     * @param model
     * @return
     */
    @RedisCache(type = List.class)
    List<Map<String, Object>> queryList(QueryModel model);

    /**
     * 查询存款信息历史记录
     * @param model
     * @return
     */
    List<Map<String, Object>> queryDepositHis(QueryModel model);

    /**
     * 批量导入查询
     * @param model
     * @return
     */
    List<Map<String, Object>> oneToManyQueryList(QueryModel model);

    /**
     * 批量导入查询数量
     * @param model
     * @return
     */
    Long oneToManyQueryCount(QueryModel model);

    List<PmaFComDepAcctInfo> queryList2(PmaFComDepAcctInfo pmaFComDepAcctInfo);

    int  delPmaFComDepAcctInfo(PmaFComDepAcctInfo pmaFComDepAcctInfo);

    /**
     * excel导入时的插入或更新
     * @param list
     */
    void upsert(List<PmaFComDepAcctInfo> list);

    void updateAcctInfoById(@Param("id") String id, @Param("applySts") String applySts, @Param("dstrSts") String dstrSts);

    void updateAcctInfo(PmaFComDepAcctInfo pmaFComDepAcctInfo);
}
