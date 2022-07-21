package cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper;

import java.util.HashMap;
import java.util.List;

public interface RpcNewMbkQueryMapper {
    /**
     * 查询资产负债汇总
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryCustDesAndAssetAll(HashMap paramMap);

    /**
     * 查询存款信息
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryCustDesDetil(HashMap paramMap);

    /**
     * 查询财富明细信息
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryListForTreaDetails(HashMap paramMap);

    /**
     * 查询用户财富总条数
     * @param paramMap
     * @return
     */
    int queryCreditTotalNum(HashMap paramMap);

    /**
     * 查询理财客户经理及其联系方式 -手机号和固定电话
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryCustFinMgrContact(HashMap paramMap);

    /**
     * 查询财富汇总信息
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryListForTotal(HashMap paramMap);

    /**
     * 查看历史收益明细总条数
     * @param paramMap
     * @return
     */
    int queryCustHisTotalNum(HashMap paramMap);

    /**
     * 查看历史收益明细
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryCustHisTbprofit(HashMap paramMap);
}
