package cn.com.yusys.yusp.dycrm.realtimerpc.service;


import cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper.RpcCustScoreQueryMapper;
import cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper.RpcCustViewQueryMapper;
import com.yusys.streaminghub.rpc.IRpcService;
import com.yusys.streaminghub.rpc.RpcRequest;
import com.yusys.streaminghub.rpc.RpcResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("SERVICE_CODE=CYBQUERY_0001_000009")
public class ScoreQueryRpcService implements IRpcService {
    JSONObject jsb = new JSONObject();
    String ecif_cust_no = "";
    String system_id = "";
    String cust_id = "";

    public static final SimpleDateFormat TIMESTAMPF = new SimpleDateFormat("yyyyMMddHHmmss");

    public static final SimpleDateFormat TIMESTAMPFDD = new SimpleDateFormat("yyyyMMdd");


    @Autowired
    RpcCustViewQueryMapper rpcCustViewQueryMapper;

    @Autowired
    RpcCustScoreQueryMapper rpcCustScoreQueryMapper;

    Map<String, Object> custScoreMap = new HashMap<>();

    @Override
    public void doService(RpcRequest request, RpcResponse response) throws Exception {
        jsb.put("ERROR_CODE", "000000");
        jsb.put("ERROR_MSG", "CRM查询成功");
        Map<String,Object> requestBody = request.getBody();
        if (ifContinue(requestBody)){
            String custId = rpcCustViewQueryMapper.queryEcifNo(system_id,cust_id);
            ecif_cust_no = custId != null ? custId : "";
            HashMap paramMap = new HashMap();
            paramMap.put("ecifCustNo",ecif_cust_no);
            if ("".equals(ecif_cust_no)){
                jsb.put("ERROR_CODE", "1007");
                jsb.put("ERROR_MSG", "该NDS客户号未查询ECIF客户号");
            }else {

                custScoreMap = rpcCustScoreQueryMapper.queryCustScoreInfo(paramMap);


                if (custScoreMap == null || "".equals(String.valueOf((BigDecimal)custScoreMap.get("useableScore"))) || String.valueOf((BigDecimal)custScoreMap.get("useableScore"))==null ){
                    jsb.put("ERROR_CODE", "1007");
                    jsb.put("ERROR_MSG", "未查询到该客户积分信息");
                }else if (custScoreMap.get("invalidingDt")!=null && !"".equals(custScoreMap.get("invalidingDt"))){
                    Date invalidingDt = (Date)custScoreMap.get("invalidingDt");
                    String time = TIMESTAMPFDD.format(invalidingDt);
                    custScoreMap.put("invalidingDt",time);
                }

            }
            fill(request,response,custScoreMap);



        }

    }

    private void fill(RpcRequest request, RpcResponse response, Map<String, Object> custScoreMap) {

        response.getHeader().put("ERROR_CODE",jsb.get("ERROR_CODE"));
        response.getHeader().put("ERROR_MSG",jsb.get("ERROR_MSG"));
        Map<String, Object> responseBody = response.getBody();
        responseBody.put("systemId",system_id);
        responseBody.put("custId",cust_id);
        responseBody.put("ecifCustNo",ecif_cust_no);
        if (custScoreMap != null&& custScoreMap.size() > 0){
            for (Map.Entry<String, Object> en : custScoreMap.entrySet()) {
                responseBody.put(en.getKey(),en.getValue());
            }
        }
    }

    /**
     * 是否满足查询条件
     * @param requestBody
     * @return
     */
    private boolean ifContinue(Map<String, Object> requestBody) {
        if (isNull(requestBody.get("SYSTEM_ID"))){
            jsb.put("ERROR_CODE","1001");
            jsb.put("ERROR_MSG","源系统名称报文格式不符合规范");
            return false;
        }else if (isNull(requestBody.get("CUST_ID"))){
            jsb.put("ERROR_CODE","1001");
            jsb.put("ERROR_MSG","源系统客户号报文格式不符合规范");
            return false;
        }else {
            if (isNullString(requestBody.get("SYSTEM_ID"))) {
                jsb.put("ERROR_CODE", "1002");
                jsb.put("ERROR_MSG", "源系统名称输入内容不允许为空");
                return false;
            } else if (isNullString(requestBody.get("CUST_ID"))) {
                jsb.put("ERROR_CODE", "1002");
                jsb.put("ERROR_MSG", "源系统客户号输入内容不允许为空");
                return false;
            }
        }
        system_id = (String) requestBody.get("SYSTEM_ID");
        cust_id = (String) requestBody.get("CUST_ID");
        return true;
    }

    private boolean isNullString(Object str) {
        if (str instanceof String && "".equals(str)){
            return true;
        }
        return false;
    }

    private boolean isNull(Object obj) {
        if (obj == null){
            return true;
        }
        return false;
    }
}
