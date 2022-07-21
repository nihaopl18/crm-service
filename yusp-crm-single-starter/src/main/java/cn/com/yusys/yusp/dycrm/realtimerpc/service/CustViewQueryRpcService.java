package cn.com.yusys.yusp.dycrm.realtimerpc.service;

import cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper.RpcCustViewQueryMapper;
import com.yusys.streaminghub.rpc.IRpcService;
import com.yusys.streaminghub.rpc.RpcRequest;
import com.yusys.streaminghub.rpc.RpcResponse;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @项目名称: yusp-crm-single-starter
 * @类名称: CustViewQueryRpcService
 * @类描述:
 * @功能描述: 移动进件营销平台-客户汇总信息及业务概览
 * @创建人: chenrb@yusys.com.cn
 * @创建时间: 2022/4/6 9:50
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service("SERVICE_CODE=CUSTVIEW_QUERY_001")
public class CustViewQueryRpcService implements IRpcService {
    //编码格式
    private static final String ENCODING = "GBK";
    private static final int HDRDESCLEN = 10;

    JSONObject jsp = new JSONObject();

    @Autowired
    RpcCustViewQueryMapper rpcCustViewQueryMapper;


    //日期格式化
    public static final SimpleDateFormat TIMESTAMPF = new SimpleDateFormat();
    //日志
    private static final Logger log = LoggerFactory.getLogger(CustViewQueryRpcService.class);

    //本行员工
    private final String BANK_STAFF_FLAG = "1000000001";
    //主办客户经理
    private final String RELA_TYPE_FLAG = "1";

    /**
     * 客户汇总信息接口交易代码
     */
    private final String CUSTVIEW_SUM_QUERY = "CUSTVIEW_QUERY_001";
    /**
     * 客户存款账号明细接口交易代码
     */
    private final String CUSTVIEW_DEPOSIT_QUERY = "CUSTVIEW_QUERY_002";
    /**
     * 客户理财账号明细接口交易代码
     */
    private final String CUSTVIEW_FINANCE_QUERY = "CUSTVIEW_QUERY_003";
    /**
     * 客户保险账户明细接口交易代码
     */
    private final String CUSTVIEW_INSURE_QUERY = "CUSTVIEW_QUERY_004";
    /**
     * 客户贷款户明细接口交易代码
     */
    private final String CUSTVIEW_LOAN_QUERY = "CUSTVIEW_QUERY_005";
    /**
     * 客户信用卡款户明细接口交易代码
     */
    private final String CUSTVIEW_CREDIT_QUERY = "CUSTVIEW_QUERY_006";
    /**
     * 客户金贷通款户明细接口交易代码
     */
    private final String CUSTVIEW_GOLDLOAN_QUERY = "CUSTVIEW_QUERY_007";

    /**
     * 更新系统号-个人网银
     */
    private final String CYB_SYSTEM_ID = "CYB";

    /**
     * 更新系统号-手机银行
     */
    private final String MBK_SYSTEM_ID = "MBK";

    /**
     * 更新系统号-个人贷款
     */
    private final String YRL_SYSTEM_ID = "YRL";

    /**
     * 更新系统号-移动进件营销平台
     */
    private final String MMP_SYSTEM_ID = "MMP";

    String ERROR_CODE = "000000";
    String ERROR_MSG = "CRM查询成功";

    //ECIF客户号
    String ecif_cust_no = "";
    //源系统客户号
    String CUST_ID = "";
    //源系统编号
    String SYSTEM_ID = "";
    //客户经理编号
    String CUST_MGR_NO = "";
    //客户经理编号所属机构编号
    String CUST_MGR_NO_ORG = "";
    //标识
    String FLAG = "";
    //证件号码
    String GLOBAL_ID = "";
    //证件类型
    String GLOBAL_TYPE = "";
    //签发国家
    String GLOBAL_CON = "";

    /** 翻页信息*/
    //0-上翻 1-下翻
    int pgup_or_pgdn;
    // 总记录数
    int total_num;
    // 当前查询记录数
    int current_num;
    // 本页第一笔标识
    int page_start;
    // 本页最后一笔标识
    int page_end;

    /** 报文头 */
    //服务编码
    String SERVICE_CODE = "";
    //交易流水
    String FLOW_ID = "";
    //更新系统ID
    String UPDATED_SYSTEM_ID = "";
    //系统更新时间
    String SRC_UPDATED_TS = "";
    //操作用户
    String UPDATED_USER = "";
    //操作机构
    String UPDATED_UNIT = "";

    //主办客户经理信息
    List<ConcurrentHashMap<String,Object>> mgrList = new ArrayList<>();
    //客户评级信息
    List<ConcurrentHashMap<String,Object>> grdList = new ArrayList<>();
    //客户分析信息
    List<ConcurrentHashMap<String,Object>> anaList = new ArrayList<>();
    //客户风险评估信息
    List<ConcurrentHashMap<String,Object>> evaList = new ArrayList<>();

    @Override
    public void doService(RpcRequest request, RpcResponse response) throws Exception {
        Map<String, String> header = request.getHeader();
        SERVICE_CODE = notNull(header.get("SERVICE_CODE"));//交易代码
        UPDATED_SYSTEM_ID =notNull(header.get("UPDATED_SYSTEM_ID"));//更新系统号
        SRC_UPDATED_TS = notNull(header.get("SRC_UPDATED_TS"));//交易处理时间
        UPDATED_USER = notNull(header.get("UPDATED_USER"));//操作客户经理编号
        UPDATED_UNIT = notNull(header.get("UPDATED_UNIT"));//操作分行
        FLOW_ID = notNull(header.get("FLOW_ID"));//流水号
        if (request.isAppHead()){
            //获取翻页信息
            //获取上翻/下翻标识
            if (intNotNull(request.getPgupPgdn())){
                pgup_or_pgdn = Integer.valueOf(request.getPgupPgdn());
            }
            //记录数
            if (intNotNull(request.getTotalNum())){
                total_num = Integer.valueOf(request.getTotalNum());
            }
            //当前记录号
            if (intNotNull(request.getCurrentNum())){
                current_num = Integer.valueOf(request.getCurrentNum());
            }
            //本地第一笔标识
            if (intNotNull(request.getPageStart())){
                page_start = Integer.valueOf(request.getPageStart());
            }
            //本地最后一笔标识
            if (intNotNull(request.getPageEnd())){
                page_end = Integer.valueOf(request.getPageEnd());
            }
        }
        Map<String, Object> body = request.getBody();

        //解析报文体信息
        //标识
        FLAG = notNull(body.get("FLAG"));
        // 源系统编号
        SYSTEM_ID = notNull(body.get("SYSTEM_ID"));
        // 客户经理编号
        CUST_MGR_NO = notNull(body.get("CUST_MGR_NO"));
        // 客户经理所属机构编号
        CUST_MGR_NO_ORG = notNull(body.get("CUST_MGR_NO_ORG"));
        // 源系统客户号
        CUST_ID = notNull(body.get("CUST_ID"));
        // 证件号码
        GLOBAL_ID = notNull(body.get("GLOBAL_ID"));
        // 证件类型
        GLOBAL_TYPE = notNull(body.get("GLOBAL_TYPE"));
        // 签发国家
        GLOBAL_CON = notNull(body.get("GLOBAL_CON"));

        jsp.put("SERVICE_CODE",SERVICE_CODE);
        jsp.put("UPDATED_SYSTEM_ID",UPDATED_SYSTEM_ID);
        jsp.put("SRC_UPDATED_TS",SRC_UPDATED_TS);
        jsp.put("UPDATED_USER",UPDATED_USER);
        jsp.put("UPDATED_UNIT",UPDATED_UNIT);
        jsp.put("FLOW_ID",FLOW_ID);
        jsp.put("ERROR_CODE",ERROR_CODE);
        jsp.put("ERROR_MSG",ERROR_MSG);

        jsp.put("pgup_or_pgdn",pgup_or_pgdn);
        jsp.put("total_num",total_num);
        jsp.put("current_num",current_num);
        jsp.put("page_start",page_start);
        jsp.put("page_end",page_end);
        if ("".equals(FLAG)){
            jsp.put("ERROR_CODE","1002");
            jsp.put("ERROR_MSG","FLAG标识内容不允许为空");
        }else if ("01".equals(FLAG) || "1".equals(FLAG)){
            if ("".equals(CUST_ID) || "".equals(SYSTEM_ID)){
                jsp.put("ERROR_CODE","1002");
                jsp.put("ERROR_MSG","源系统号与源系统客户号内容不允许为空");
            }else {
                jsp.put("CUST_ID",CUST_ID);
                jsp.put("SYSTEM_ID",SYSTEM_ID);
                String custId = rpcCustViewQueryMapper.queryEcifNo(SYSTEM_ID,CUST_ID);
                ecif_cust_no = custId != null ? custId : "";
            }
        }else if ("02".equals(FLAG) || "2".equals(FLAG)){
            if ("".equals(GLOBAL_ID) || "".equals(GLOBAL_TYPE) || "".equals(GLOBAL_CON)){
                jsp.put("ERROR_CODE","1002");
                jsp.put("ERROR_MSG","客户证件类型、证件号码、签发国家内容不允许为空");
            }else {
                jsp.put("GLOBAL_ID",GLOBAL_ID);
                jsp.put("GLOBAL_TYPE",GLOBAL_TYPE);
                jsp.put("GLOBAL_CON",GLOBAL_CON);
                String custId = rpcCustViewQueryMapper.queryEcifCustNo(GLOBAL_ID,GLOBAL_TYPE,GLOBAL_CON) ;
                ecif_cust_no = custId != null ? custId : "";
            }
        }
        String bank_rela_flag = "";
        if (UPDATED_SYSTEM_ID.equals(MMP_SYSTEM_ID)){
            int relaAuthority  = rpcCustViewQueryMapper.relaAuthorityQuery(ecif_cust_no, CUST_MGR_NO);
            if (relaAuthority > 0){
                bank_rela_flag = "1";
            }else {
                bank_rela_flag = "4";
            }
            log.info("客户关系：" +bank_rela_flag +";(1、主办，4：既非主办也非协办)");
        }else {
            bank_rela_flag = "1";
        }
        if ("".equals(UPDATED_SYSTEM_ID) || UPDATED_SYSTEM_ID ==null){
            jsp.put("ERROR_CODE","1007");
            jsp.put("ERROR_MSG","报文头请求方系统号UPDATED_SYSTEM_ID字段不能为空");
            fill(response,jsp);
        }else if ("".equals(ecif_cust_no)){
            jsp.put("ERROR_CODE","1003");
            jsp.put("ERROR_MSG","未查询到该客户对应的ecif客户号");
            fill(response,jsp);
        }else if ("4".equals(bank_rela_flag)){
            jsp.put("ERROR_CODE","1005");
            jsp.put("ERROR_MSG","该客户经理非客户主办，无权限查询");
            fill(response,jsp);
        }else {
            jsp.put("ECIF_CUST_NO",ecif_cust_no);
            jsp.put("BANK_RELA_FLAG",bank_rela_flag);
            jsp.put("CUST_MGR_NO",CUST_MGR_NO);
            jsp.put("CUST_MGR_NO_ORG",CUST_MGR_NO_ORG);
            //查询客户主办经理信息
            mgrList = rpcCustViewQueryMapper.queryCustMgr(ecif_cust_no);
            //查询客户评级信息
            grdList = rpcCustViewQueryMapper.queryCustGrade(ecif_cust_no);
            //查询客户分析信息
            anaList = rpcCustViewQueryMapper.queryCustAnalyse(ecif_cust_no);
            //查询客户风险评估信息
            evaList = rpcCustViewQueryMapper.queryCustEva(ecif_cust_no);
            //查询客户业务汇总信息
            HashMap<String,Object> sumBusi = rpcCustViewQueryMapper.querySumBusi(ecif_cust_no,bank_rela_flag,CUST_MGR_NO_ORG);
            //查询客户当年的AUM峰值
            String bYearTopAumBalRmb = rpcCustViewQueryMapper.queryAumYearMax(ecif_cust_no);

            fill(response,mgrList,grdList,anaList,evaList,sumBusi,bYearTopAumBalRmb,jsp);
        }


    }

    private void fill(RpcResponse response, JSONObject jsp) {
        Map header = response.getHeader();
        header.put("SERVICE_CODE",jsp.get("SERVICE_CODE").toString());
        header.put("UPDATED_SYSTEM_ID", jsp.get("UPDATED_SYSTEM_ID").toString());
        header.put("SRC_CREATE_TS", jsp.get("SRC_UPDATED_TS").toString());
        header.put("SRC_UPDATED_TS", TIMESTAMPF.format(new Date()));
        header.put("UPDATED_USER", jsp.get("UPDATED_USER").toString());
        header.put("UPDATED_UNIT", jsp.get("UPDATED_UNIT").toString());
        header.put("FLOW_ID", jsp.get("FLOW_ID").toString());
        header.put("ERROR_CODE", jsp.get("ERROR_CODE").toString());
        header.put("ERROR_MSG", jsp.get("ERROR_MSG").toString());
        Map appHead = response.getAppHead();
        appHead.put("PGUP_OR_PGDN",String.valueOf(pgup_or_pgdn));
        appHead.put("TOTAL_NUM",String.valueOf(total_num));
        appHead.put("CURRENT_NUM",String.valueOf(current_num));
        appHead.put("PAGE_START",String.valueOf(page_start));
        appHead.put("PAGE_END",String.valueOf(page_end));

    }

    private void fill(RpcResponse response, List<ConcurrentHashMap<String, Object>> mgrList, List<ConcurrentHashMap<String, Object>> grdList, List<ConcurrentHashMap<String, Object>> anaList, List<ConcurrentHashMap<String, Object>> evaList, HashMap<String, Object> sumBusi, String bYearTopAumBalRmb, JSONObject jsp) {
        Map header = response.getHeader();
        header.put("SERVICE_CODE",jsp.get("SERVICE_CODE").toString());
        header.put("UPDATED_SYSTEM_ID", jsp.get("UPDATED_SYSTEM_ID").toString());
        header.put("SRC_CREATE_TS", jsp.get("SRC_UPDATED_TS").toString());
        header.put("SRC_UPDATED_TS", TIMESTAMPF.format(new Date()));
        header.put("UPDATED_USER", jsp.get("UPDATED_USER").toString());
        header.put("UPDATED_UNIT", jsp.get("UPDATED_UNIT").toString());
        header.put("FLOW_ID", jsp.get("FLOW_ID").toString());
        header.put("ERROR_CODE", jsp.get("ERROR_CODE").toString());
        header.put("ERROR_MSG", jsp.get("ERROR_MSG").toString());
        Map bodyData = response.getBodyData();
        bodyData.put("CUST_BELONG_ARR",mgrList);
        bodyData.put("CUST_ANALYSE_ARR",anaList);
        bodyData.put("CUST_GRADE_ARR",grdList);
        bodyData.put("CUST_EVA_ARR",evaList);
        List<ConcurrentHashMap<String,Object>> bussList = new ArrayList<>();
        ConcurrentHashMap<String,Object> bussMap = new ConcurrentHashMap<>();
        if (sumBusi != null){
            bussMap.put("depositTermAmt",notNull(sumBusi.get("depositTermAmt")));
            bussMap.put("financeBalanceRmb",notNull(sumBusi.get("financeBalanceRmb")));
            bussMap.put("loanTermAmt",notNull(sumBusi.get("loanTermAmt")));
            bussMap.put("creditBal",notNull(sumBusi.get("creditBal")));
            bussMap.put("inssranceAmt",notNull(sumBusi.get("inssranceAmt")));
            bussMap.put("aumBalRmb",notNull(sumBusi.get("aumBalRmb")));
            bussMap.put("aumYearMax",notNull(bYearTopAumBalRmb));
        }else {
            bussMap.put("depositTermAmt","");
            bussMap.put("financeBalanceRmb","");
            bussMap.put("loanTermAmt","");
            bussMap.put("creditBal","");
            bussMap.put("inssranceAmt","");
            bussMap.put("aumBalRmb","");
            bussMap.put("aumYearMax",notNull(bYearTopAumBalRmb));
        }
        bussList.add(bussMap);
        bodyData.put("CUST_BUSS_INF_ARR",bussList);
    }

    /**
     * 避免出现"null"
     * @param obj
     * @return
     */
    public static String notNull(Object obj) {
        if (obj == null)
            return "";
        return obj.toString();

    }
    /**
     * 避免出现"null"
     * @param var
     * @return
     */
    public static boolean intNotNull(int var) {
        boolean result = true;
        if ("".equals(var + "")){
            result = false;
        }
        return result;
    }
}
