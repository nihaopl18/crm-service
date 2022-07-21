package cn.com.yusys.yusp.dycrm.realtimerpc.service;


import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper.RpcCustScoreQueryMapper;
import cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper.RpcCustViewQueryMapper;

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

@Service("SERVICE_CODE=CYBQUERY_0001_000003")
public class ScoreDetailsRpcService implements IRpcService {

    JSONObject jsb = new JSONObject();

    //日志
    private static final Logger log = LoggerFactory.getLogger(ScoreDetailsRpcService.class);

    public static final SimpleDateFormat TIMESTAMPF = new SimpleDateFormat("yyyyMMddHHmmss");

    private int queryNum = 10;
;


    @Autowired
    RpcCustViewQueryMapper rpcCustViewQueryMapper;

    @Autowired
    RpcCustScoreQueryMapper rpcCustScoreQueryMapper;

    String error_code = "000000";
    String error_msg = "CRM查询成功";
    String reqmsg = "";
    String respmsg = "";
    String ecif_cust_no = "";
    String system_id = "";
    String cust_id = "";

    String SERVICE_CODE = "";
    String FLOW_ID = "";
    String UPDATED_SYSTEM_ID = "";
    String SRC_UPDATED_TS = "";
    String UPDATED_USER = "";
    String UPDATED_UNIT = "";

    // 积分明细信息
    String SCORE_DEAL_TYPE = "";
    String SCORE = "";
    String DEAL_DT = "";
    String LAST_SCORE = "";
    String NEXT_SCORE = "";
    String SCD_FK_ID = "";
    String begin_dt = "";
    String end_dt = "";

    // 翻页信息
    int pgup_or_pgdn;
    int total_num;
    int current_num;
    int page_start;
    int page_end;

    List<HashMap<String, Object>> rowsList = new ArrayList<HashMap<String, Object>>();

    public ScoreDetailsRpcService() {
    }

    @Override
    public void doService(RpcRequest request, RpcResponse response) throws Exception {
        Map<String, String> header = request.getHeader();
        request.setQueryNum(queryNum);
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
        system_id = rpcUtil.notNull(body.get("SYSTEM_ID"));
        // 源系统客户号
        cust_id = rpcUtil.notNull(body.get("CUST_ID"));
        //开始时间
        begin_dt = rpcUtil.notNull(body.get("BEGIN_DT"));
        //结束时间
        end_dt = rpcUtil.notNull(body.get("END_DT"));

        // 判断报文头节点是否存在
        if (header.get("SERVICE_CODE") == null) {
            jsb.put("ERROR_CODE", "1001");
            jsb.put("ERROR_MSG", "SERVICE_CODE报文格式不符合规范");
        } else if (header.get("UPDATED_SYSTEM_ID") == null) {
            jsb.put("ERROR_CODE", "1001");
            jsb.put("ERROR_MSG", "UPDATED_SYSTEM_ID报文格式不符合规范");
        } else if (header.get("SRC_UPDATED_TS") == null) {
            jsb.put("ERROR_CODE", "1001");
            jsb.put("ERROR_MSG", "SRC_UPDATED_TS报文格式不符合规范");
        } else if (header.get("UPDATED_USER") == null) {
            jsb.put("ERROR_CODE", "1001");
            jsb.put("ERROR_MSG", "UPDATED_USER报文格式不符合规范");
        } else if (header.get("UPDATED_UNIT") == null) {
            jsb.put("ERROR_CODE", "1001");
            jsb.put("ERROR_MSG", "UPDATED_UNIT报文格式不符合规范");
        } else if (header.get("FLOW_ID") == null) {
            jsb.put("ERROR_CODE", "1001");
            jsb.put("ERROR_MSG", "FLOW_ID报文格式不符合规范");
        } else if (header.get("ERROR_CODE") == null) {
            jsb.put("ERROR_CODE", "1001");
            jsb.put("ERROR_MSG", "ERROR_CODE报文格式不符合规范");
        } else if (header.get("ERROR_MSG") == null) {
            jsb.put("ERROR_CODE", "1001");
            jsb.put("ERROR_MSG", "ERROR_MSG报文格式不符合规范");
        } // 校验报文头值不为空
        else if (SERVICE_CODE == null || "".equals(SERVICE_CODE)) {
            jsb.put("ERROR_CODE", "1002");
            jsb.put("ERROR_MSG", "交易代码输入内容不允许为空");
        } else if (UPDATED_SYSTEM_ID == null || "".equals(UPDATED_SYSTEM_ID)) {
            jsb.put("ERROR_CODE", "1002");
            jsb.put("ERROR_MSG", "更新系统号输入内容不允许为空");
        } else if (SRC_UPDATED_TS == null || "".equals(SRC_UPDATED_TS)) {
            jsb.put("ERROR_CODE", "1002");
            jsb.put("ERROR_MSG", "交易处理时间输入内容不允许为空");
        } else if (FLOW_ID == null || "".equals(FLOW_ID)) {
            jsb.put("ERROR_CODE", "1002");
            jsb.put("ERROR_MSG", "流水号输入内容不允许为空");
        } // 判断报文头节点是否存在
        else if (body.get("SYSTEM_ID") == null) {
            jsb.put("ERROR_CODE", "1001");
            jsb.put("ERROR_MSG", "源系统名称报文格式不符合规范");
        } else if (body.get("CUST_ID") == null) {
            jsb.put("ERROR_CODE", "1001");
            jsb.put("ERROR_MSG", "源系统客户号报文格式不符合规范");
        } // 对请求报文体必输字段做校验
        else if ("".equals(system_id.toString())) {
            jsb.put("ERROR_CODE", "1002");
            jsb.put("ERROR_MSG", "源系统名称输入内容不允许为空");
        } else if ("".equals(cust_id.toString())) {
            jsb.put("ERROR_CODE", "1002");
            jsb.put("ERROR_MSG", "源系统客户号输入内容不允许为空");
        } else if ("".equals(request.getPgupPgdn())) {
            jsb.put("ERROR_CODE", "1002");
            jsb.put("ERROR_MSG", "上翻下翻标识输入内容不允许为空");
        } else if (pgup_or_pgdn < 0) {
            jsb.put("ERROR_CODE", "1002");
            jsb.put("ERROR_MSG", "上翻下翻标识栏位值输入有误");
        } else if (page_start <= 0 && current_num != -1) {
            jsb.put("ERROR_CODE", "1002");
            jsb.put("ERROR_MSG", "本页第一笔标识栏位值输入有误");
        } else if (page_end <= page_start && current_num != -1) {
            jsb.put("ERROR_CODE", "1002");
            jsb.put("ERROR_MSG", "本页最后一笔标识栏位值输入有误");
        }else {
            jsb.put("SERVICE_CODE", SERVICE_CODE);
            jsb.put("UPDATED_SYSTEM_ID", UPDATED_SYSTEM_ID);
            jsb.put("SRC_UPDATED_TS", SRC_UPDATED_TS);
            jsb.put("UPDATED_USER", UPDATED_USER);
            jsb.put("UPDATED_UNIT", UPDATED_UNIT);
            jsb.put("FLOW_ID", FLOW_ID);
            jsb.put("ERROR_CODE", error_code);
            jsb.put("ERROR_MSG", error_msg);
            jsb.put("CUST_ID", cust_id);
            jsb.put("SYSTEM_ID", system_id);

            String custId = rpcCustViewQueryMapper.queryEcifNo(system_id,cust_id);
            ecif_cust_no = custId != null ? custId : "";

            HashMap paramMap = new HashMap();
            paramMap.put("ecifCustNo",ecif_cust_no);
            paramMap.put("beginDt",begin_dt);
            paramMap.put("endDt",end_dt);


            if("".equals(ecif_cust_no)){
                jsb.put("ERROR_CODE", "1007");
                jsb.put("ERROR_MSG", "该NDS客户号未查询ECIF客户号");
                fill(response,jsb,rowsList);
            }else {
                PageHelper.startPage(request.getPageNum(),request.getQueryNum());
                rowsList = rpcCustScoreQueryMapper.queryCustScoreDetails(paramMap);
                ResultDto<List<HashMap<String, Object>>> rs = new ResultDto<List<HashMap<String, Object>>>(rowsList);
                request.setCurrentNum(rowsList != null ? rowsList.size() : 0);
                request.setTotalNum((int) rs.getTotal());
                PageHelper.clearPage();
                if (rowsList.size()>0){
                    for (HashMap<String, Object> hashMap : rowsList) {
                        String dealDt = (String)hashMap.get("dealDt");
                        if (!"".equals(dealDt) && dealDt != null){
                            dealDt = dealDt.substring(0,10);
                            dealDt = dealDt.replace("/","");
                            dealDt = dealDt.replace("-","");
                            hashMap.put("dealDt",dealDt);
                        }
                    }
                }
                if (rowsList.size() <= 0 ){
                    jsb.put("ERROR_CODE", "1007");
                    jsb.put("ERROR_MSG", "未查询到该客户积分明细信息");
                    fill(response,jsb,rowsList);
                }
                fill(response,jsb,rowsList);

            }
        }
    }

    private void fill(RpcResponse response, JSONObject jsb, List<HashMap<String, Object>> rowsList) {
        Map<String, String> header = response.getHeader();
        header.put("SERVICE_CODE",jsb.get("SERVICE_CODE").toString());
        header.put("UPDATED_SYSTEM_ID", jsb.get("UPDATED_SYSTEM_ID").toString());
        header.put("SRC_CREATE_TS", jsb.get("SRC_UPDATED_TS").toString());
        header.put("SRC_UPDATED_TS", TIMESTAMPF.format(new Date()));
        header.put("UPDATED_USER", jsb.get("UPDATED_USER").toString());
        header.put("UPDATED_UNIT", jsb.get("UPDATED_UNIT").toString());
        header.put("FLOW_ID", jsb.get("FLOW_ID").toString());
        header.put("ERROR_CODE", jsb.get("ERROR_CODE").toString());
        header.put("ERROR_MSG", jsb.get("ERROR_MSG").toString());
        Map<String, String> appHead = response.getAppHead();
        appHead.put("PGUP_OR_PGDN",String.valueOf(pgup_or_pgdn));
        appHead.put("TOTAL_NUM",String.valueOf(total_num));
        appHead.put("CURRENT_NUM",String.valueOf(current_num));
        appHead.put("PAGE_START",String.valueOf(page_start));
        appHead.put("PAGE_END",String.valueOf(page_end));


        Map body = response.getBody();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("SYSTEM_ID",system_id);
        hashMap.put("CUST_ID",cust_id);
        hashMap.put("ECIF_CUST_NO",ecif_cust_no);


        body.put("SYSTEMTOTAL",hashMap);
        body.put("SCORE_DET_ARR_ARR",rowsList);

    }

}
