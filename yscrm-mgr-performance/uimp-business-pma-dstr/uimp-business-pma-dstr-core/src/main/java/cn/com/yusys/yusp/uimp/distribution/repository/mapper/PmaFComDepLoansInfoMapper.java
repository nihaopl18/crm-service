package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepAcctInfo;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepLoansInfo;

import java.util.List;
import java.util.Map;

public interface PmaFComDepLoansInfoMapper extends CommonMapper<PmaFComDepLoansInfo> {


    /**
     * 查询列表
     * @param model
     * @return
     */
    List<Map<String, Object>> queryList(QueryModel model);

    /**
     * 删除贷款记录
     * @param pmaFComDepLoansInfo
     * @return
     */
    int  delPmaFComDepLoansInfo(PmaFComDepLoansInfo pmaFComDepLoansInfo);

    /**
     * 查询贷款历史记录
     * @param model
     * @return
     */
    List<Map<String, Object>> queryLoansHis(QueryModel model);

    /**
     * 一对多批量贷款查询数据量
     * @param queryModel
     * @return
     */
    Long oneToManyQueryCount(QueryModel queryModel);

    /**
     *  一对多批量贷款查询
     * @param queryModel
     * @return
     */
    List<Map<String, Object>> oneToManyQueryList(QueryModel queryModel);
}
