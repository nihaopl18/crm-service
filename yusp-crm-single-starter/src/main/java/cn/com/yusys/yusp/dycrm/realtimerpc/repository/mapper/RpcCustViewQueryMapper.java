package cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper;

import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface RpcCustViewQueryMapper {
    /**
     * 查询客户经理信息，仅查客户主办经理及所属机构
     * @param ecif_cust_no
     * @return
     */
    List<ConcurrentHashMap<String, Object>> queryCustMgr(String ecif_cust_no);

    /**
     * 查询客户评级信息
     * @param ecif_cust_no
     * @return
     */
    List<ConcurrentHashMap<String, Object>> queryCustGrade(String ecif_cust_no);

    /**
     * 查询客户分析信息
     * @param ecif_cust_no
     * @return
     */
    List<ConcurrentHashMap<String, Object>> queryCustAnalyse(String ecif_cust_no);

    /**
     * 查询客户风险评估信息，查询最近一次评估的记录
     * @param ecif_cust_no
     * @return
     */
    List<ConcurrentHashMap<String, Object>> queryCustEva(String ecif_cust_no);

    /**
     * 查询客户业务汇总数据，包括存款，贷款、理财、信用卡、保险、金贷通
     * @param ecif_cust_no
     * @param bank_rela_flag
     * @param cust_mgr_no_org
     * @return
     */
    HashMap<String, Object> querySumBusi(@Param("ecif_cust_no") String ecif_cust_no, @Param("bank_rela_flag") String bank_rela_flag,@Param("cust_mgr_no_org") String cust_mgr_no_org);

    /**
     * 查询客户资产余额信息
     * @param ecif_cust_no
     * @return
     */
    String querySumAumBal(String ecif_cust_no);

    /**
     * 查询客户的当年的AUM峰值
     * @param ecif_cust_no
     * @return
     */
    String queryAumYearMax(String ecif_cust_no);

    /**
     * 通过原系统号和源系统客户查询ecif客户号
     * @param systemId
     * @param custId
     * @return
     */
    String queryEcifNo(@Param("systemId") String systemId, @Param("custId") String custId);

    /**
     * 三证查询ecif客户号
     * @param globalId
     * @param globalType
     * @param globalCon
     * @return
     */
    String queryEcifCustNo(@Param("globalId") String globalId, @Param("globalType") String globalType, @Param("globalCon") String globalCon);

    /**
     * 存款账户汇总信息
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> querySumDepAcc(HashMap paramMap);

    /**
     * 查询存款账号详细信息
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryDepAccDetail(HashMap paramMap);

    /**
     * 查看电子账户信息
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryEleAcc(HashMap paramMap);

    /**
     * 信用卡溢缴款明细信息
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryCreditCardOverDetail(HashMap paramMap);

    /**
     * 查询理财账户明细信息总记录数
     * @param paramMap
     * @return
     */
    int queryFinanceTotal(HashMap paramMap);

    /**
     * 查询当前数据条数
     * @param paramMap
     * @return
     */
    int queryFinanceCurrNum(HashMap paramMap);

    /**
     * 理财账户信息汇总
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> querySummaryFinAccounts(HashMap paramMap);

    /**
     * 查询理财账户信息明细
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryFinAccounts(HashMap paramMap);

    /**
     * 查询客户保险分类信息
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryTotalInfo(HashMap paramMap);

    /**
     * 查询客户保险总条数
     * @param paramMap
     * @return
     */
    int queryTotalNum(HashMap paramMap);

    /**
     * 查询客户保险账户明细信息
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryDetailInfo(HashMap paramMap);

    /**
     * 查询贷款汇总信息
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryLoanTotalInfo(HashMap paramMap);

    /**
     * 查询贷款明细信息
     * @param paramMap
     * @return
     */
    List<HashMap<String, Object>> queryLoanDetailInfo(HashMap paramMap);

    /**
     * 查询客户信用卡分类统计信息，按照司机产品分类统计
     * @param paramMap
     * @return
     */
    List<ConcurrentHashMap<String, Object>> queryCreditClassInf(HashMap paramMap);

    /**
     * 查询客户信用卡账户明细
     * @param paramMap
     * @return
     */
    List<ConcurrentHashMap<String, Object>> queryAcctDtlInf(HashMap paramMap);

    /**
     * 查询汇总总条数
     * @param paramMap
     * @return
     */
    int queryLoanTotalNum(HashMap paramMap);

    /**
     * 查看信用卡指定客户总条数
     * @param paramMap
     * @return
     */
    int queryCreditTotalNum(HashMap paramMap);

    /**
     * 查询客户与客户经理的关系
     * @param ecif_cust_no
     * @param cust_mgr_no
     * @return
     */
    int relaAuthorityQuery(@Param("ecif_cust_no") String ecif_cust_no, @Param("cust_mgr_no") String cust_mgr_no);

    /**
     * 查询客户分析信息
     * @param paramMap
     * @return
     */
    Map<String, Object> queryCustAnalyseInfo(HashMap paramMap);

    /**
     * 查询客户上月aum月日均
     * @param paramMap
     * @return
     */
    Map<String, Object> querycustAumMthAvg(HashMap paramMap);
}
