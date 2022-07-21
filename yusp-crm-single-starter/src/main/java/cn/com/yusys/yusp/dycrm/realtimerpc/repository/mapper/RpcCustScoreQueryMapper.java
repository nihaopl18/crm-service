package cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RpcCustScoreQueryMapper {
    /**
     * 查询客户积分明细
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryCustScoreDetails(HashMap paramMap);

    /**
     * 查询客户可用积分
     * @param paramMap
     * @return
     */
    int queryCustScore(HashMap paramMap);

    /**
     * 查询客户评级信息
     * @param paramMap
     * @return
     */
    HashMap<String, Object> queryCustGrade(HashMap paramMap);

    /**
     * 查询客户可兑换礼遇信息
     * @param paramMap
     * @return
     */
    List<Map<String, Object>> queryCustServiceInfo(HashMap paramMap);

    /**
     * 查询全部礼遇信息
     * @param paramMap
     * @return
     */
    List<Map<String, Object>> queryCustServiceInfoAll(HashMap paramMap);

    /**
     * 查询客户主办客户经理信息
     * @param paramMap
     * @return
     */
    Map<String, Object> queryCustMgr(HashMap paramMap);

    /**
     * 查询客户评级信息
     * @param paramMap
     * @return
     */
    Map<String, Object> queryCustGradeInfo(HashMap paramMap);

    /**
     * 查询积分可用信息
     * @param paramMap
     * @return
     */
    Map<String, Object> queryCustScoreInfo(HashMap paramMap);
}
