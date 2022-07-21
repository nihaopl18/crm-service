package cn.com.yusys.yusp.dycrm.realtimerpc.service;

import cn.com.yusys.yusp.dycrm.mobileClient.service.IMobilesClientService;
import cn.com.yusys.yusp.dycrm.mobileClient.service.impl.MobilesClientServiceImpl;
import cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper.RpcCustViewQueryMapper;
import cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper.RpcNewMbkQueryMapper;
import cn.com.yusys.yusp.dycrm.realtimerpc.util.rpcUtil;
import com.github.pagehelper.PageHelper;
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

@Service("SERVICE_CODE=MOBLIEBANK_AL_QUERY_003")
public class CustHisEarningsRpcService implements IRpcService {

    JSONObject jsp = new JSONObject();

    @Autowired
    RpcCustViewQueryMapper rpcCustViewQueryMapper;

    @Autowired
    RpcNewMbkQueryMapper rpcNewMbkQueryMapper;


    //日期格式化
    public static final SimpleDateFormat TIMESTAMPF = new SimpleDateFormat();
    //日志
    private static final Logger log = LoggerFactory.getLogger(CustFinanceAcctQueryRpcService.class);
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

    int[] rowBounds = new int[2];

    private int queryNum = 10;

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

    List<HashMap<String, Object>> hisELists = new ArrayList<HashMap<String, Object>>();// 存款账户明細详情

    @Override
    public void doService(RpcRequest request, RpcResponse response) throws Exception {


        Map<String, String> header = request.getHeader();
        SERVICE_CODE = rpcUtil.notNull(header.get("SERVICE_CODE"));//交易代码
        UPDATED_SYSTEM_ID =rpcUtil.notNull(header.get("UPDATED_SYSTEM_ID"));//更新系统号
        SRC_UPDATED_TS = rpcUtil.notNull(header.get("SRC_UPDATED_TS"));//交易处理时间
        UPDATED_USER = rpcUtil.notNull(header.get("UPDATED_USER"));//操作客户经理编号
        UPDATED_UNIT = rpcUtil.notNull(header.get("UPDATED_UNIT"));//操作分行
        FLOW_ID = rpcUtil.notNull(header.get("FLOW_ID"));//流水号
        if (request.isAppHead()) {

            //获取翻页信息
            //获取上翻/下翻标识
            if (rpcUtil.intNotNull(request.getPgupPgdn())){
                pgup_or_pgdn = Integer.valueOf(request.getPgupPgdn());
            }
            //记录数
            if (rpcUtil.intNotNull(request.getTotalNum())){
                total_num = Integer.valueOf(request.getTotalNum());
            }
            //当前记录号
            if (rpcUtil.intNotNull(request.getCurrentNum())){
                current_num = Integer.valueOf(request.getCurrentNum());
            }
            //本地第一笔标识
            if (rpcUtil.intNotNull(request.getPageStart())){
                page_start = Integer.valueOf(request.getPageStart());
            }
            //本地最后一笔标识
            if (rpcUtil.intNotNull(request.getPageEnd())){
                page_end = Integer.valueOf(request.getPageEnd());
            }
        }
        Map<String, Object> body = request.getBody();

        //解析报文体信息

        // 源系统编号
        SYSTEM_ID = rpcUtil.notNull(body.get("SYSTEM_ID"));
        // 源系统客户号
        CUST_ID = rpcUtil.notNull(body.get("CUST_ID"));
        // 开始时间
        String startTime = rpcUtil.notNull(body.get("START_TIME"));
        // 结束时间
        String stopTime = rpcUtil.notNull(body.get("STOP_TIME"));


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

        if ("".equals(CUST_ID) || "".equals(SYSTEM_ID)){
            jsp.put("ERROR_CODE","1002");
            jsp.put("ERROR_MSG","源系统号与源系统客户号内容不允许为空");
        }else {
            jsp.put("CUST_ID",CUST_ID);
            jsp.put("SYSTEM_ID",SYSTEM_ID);
            String custId = rpcCustViewQueryMapper.queryEcifNo(SYSTEM_ID,CUST_ID);
            ecif_cust_no = custId != null ? custId : "";
            if("".equals(ecif_cust_no)){
                jsp.put("ERROR_CODE", "1004");
                jsp.put("ERROR_MSG", "未查询到该客户对应的ecif客户号");
                fill(response,jsp);
            }else {
                HashMap paramMap = new HashMap();
                paramMap.put("ecifCustNo",ecif_cust_no);
                if(startTime!= null && !"".equals(startTime)){//开始时间
                    if(startTime.length() > 8){
                        startTime = startTime.substring(0,8);
                    }
                    paramMap.put("startTime",startTime);
                }

                if(stopTime != null && !"".equals(stopTime)){
                    if(stopTime.length() > 8){
                        stopTime = stopTime.substring(0,8);
                    }
                    paramMap.put("stopTime",stopTime);
                }
                if (rpcUtil.intIsNotEmpty(page_start) && rpcUtil.intIsNotEmpty(page_end) && current_num != -1){
                    //下翻
                    if (pgup_or_pgdn == 1){
                        page_start = page_start + queryNum;
                        if (current_num != 0){
                            page_end = page_start + current_num -1;
                        }else {
                            page_end = page_start;
                        }
                    }
                    //上翻
                    if (pgup_or_pgdn == 0 && page_start == 1){
                        page_end = page_start + current_num -1;
                    }else if (pgup_or_pgdn == 0 && page_start >1){
                        page_start = page_start - queryNum;
                        if (page_start <= 0){
                            page_start = 1;
                        }
                        page_end = page_start + current_num - 1;
                    }
                }
                rowBounds[0] = page_start;
                rowBounds[1] = queryNum;
                int pageNum = rowBounds[1] != 0 ? (int)Math.ceil(((double)rowBounds[0] + (double)rowBounds[1]) / (double)rowBounds[1]) : 0;
                if (current_num != 0 && current_num != -1){
                    total_num = rpcNewMbkQueryMapper.queryCustHisTotalNum(paramMap);
                }
                PageHelper.startPage(pageNum,queryNum );
                hisELists = rpcNewMbkQueryMapper.queryCustHisTbprofit(paramMap);
                current_num = hisELists != null ? hisELists.size() : 0;
                PageHelper.clearPage();
                fill(response,jsp,hisELists);
            }
        }
    }

    private void fill(RpcResponse response, JSONObject jsp, List<HashMap<String, Object>> hisELists) {
        Map<String, String> header = response.getHeader();
        header.put("SERVICE_CODE",jsp.get("SERVICE_CODE").toString());
        header.put("UPDATED_SYSTEM_ID", jsp.get("UPDATED_SYSTEM_ID").toString());
        header.put("SRC_CREATE_TS", jsp.get("SRC_UPDATED_TS").toString());
        header.put("SRC_UPDATED_TS", TIMESTAMPF.format(new Date()));
        header.put("UPDATED_USER", jsp.get("UPDATED_USER").toString());
        header.put("UPDATED_UNIT", jsp.get("UPDATED_UNIT").toString());
        header.put("FLOW_ID", jsp.get("FLOW_ID").toString());
        header.put("ERROR_CODE", jsp.get("ERROR_CODE").toString());
        header.put("ERROR_MSG", jsp.get("ERROR_MSG").toString());
        Map<String, String> appHead = response.getAppHead();
        appHead.put("PGUP_OR_PGDN",String.valueOf(pgup_or_pgdn));
        appHead.put("TOTAL_NUM",String.valueOf(total_num));
        appHead.put("CURRENT_NUM",String.valueOf(current_num));
        appHead.put("PAGE_START",String.valueOf(page_start));
        appHead.put("PAGE_END",String.valueOf(page_end));
        //返回报文体
        Map bodyData = response.getBodyMapData();
        //历史收益明细
        bodyData.put("hisELists",hisELists);
    }


    private void fill(RpcResponse response, JSONObject jsp) {
        Map<String, String> header = response.getHeader();
        header.put("SERVICE_CODE",jsp.get("SERVICE_CODE").toString());
        header.put("UPDATED_SYSTEM_ID", jsp.get("UPDATED_SYSTEM_ID").toString());
        header.put("SRC_CREATE_TS", jsp.get("SRC_UPDATED_TS").toString());
        header.put("SRC_UPDATED_TS", TIMESTAMPF.format(new Date()));
        header.put("UPDATED_USER", jsp.get("UPDATED_USER").toString());
        header.put("UPDATED_UNIT", jsp.get("UPDATED_UNIT").toString());
        header.put("FLOW_ID", jsp.get("FLOW_ID").toString());
        header.put("ERROR_CODE", jsp.get("ERROR_CODE").toString());
        header.put("ERROR_MSG", jsp.get("ERROR_MSG").toString());
        Map<String, String> appHead = response.getAppHead();
        appHead.put("PGUP_OR_PGDN",String.valueOf(pgup_or_pgdn));
        appHead.put("TOTAL_NUM",String.valueOf(total_num));
        appHead.put("CURRENT_NUM",String.valueOf(current_num));
        appHead.put("PAGE_START",String.valueOf(page_start));
        appHead.put("PAGE_END",String.valueOf(page_end));

    }
}
