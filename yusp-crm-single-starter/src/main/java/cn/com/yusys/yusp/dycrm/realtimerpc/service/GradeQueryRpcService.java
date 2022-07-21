package cn.com.yusys.yusp.dycrm.realtimerpc.service;


import cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper.RpcCustScoreQueryMapper;
import cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper.RpcCustViewQueryMapper;
import cn.com.yusys.yusp.dycrm.realtimerpc.util.rpcUtil;
import com.yusys.streaminghub.rpc.IRpcService;
import com.yusys.streaminghub.rpc.RpcRequest;
import com.yusys.streaminghub.rpc.RpcResponse;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Map;

@Service("SERVICE_CODE=CYBQUERY_0001_000008")
public class GradeQueryRpcService implements IRpcService {

    JSONObject jsb = new JSONObject();
    String ecif_cust_no = "";
    String system_id = "";
    String cust_id = "";

    public static final SimpleDateFormat TIMESTAMPF = new SimpleDateFormat("yyyyMMddHHmmss");



    @Autowired
    RpcCustViewQueryMapper rpcCustViewQueryMapper;

    @Autowired
    RpcCustScoreQueryMapper rpcCustScoreQueryMapper;

    Map<String, Object> custMgrMap = new HashMap<>();
    Map<String, Object> custGradeMap = new HashMap<>();
    Map<String, Object> custAnalyseMap = new HashMap<>();

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
                //查询客户主办信息
                custMgrMap = rpcCustScoreQueryMapper.queryCustMgr(paramMap);
                //查询客户评级信息
                custGradeMap = rpcCustScoreQueryMapper.queryCustGradeInfo(paramMap);
                //查询客户分析信息
                custAnalyseMap = rpcCustViewQueryMapper.queryCustAnalyseInfo(paramMap);
                //查询客户上月aum月日均
                Map<String,Object> custAumMthAvg = rpcCustViewQueryMapper.querycustAumMthAvg(paramMap);
                if (custAumMthAvg!=null){
                    custGradeMap.put("upmthAumMthavg",custAumMthAvg.get("upmthAumMthavg"));
                }
            }

            fill(custMgrMap,custGradeMap,custAnalyseMap,request,response);
        }
    }

    private void fill(Map<String, Object> custMgrMap, Map<String, Object> custGradeMap, Map<String, Object> custAnalyseMap, RpcRequest request, RpcResponse response) {
        response.getHeader().put("ERROR_CODE",jsb.get("ERROR_CODE"));
        response.getHeader().put("ERROR_MSG",jsb.get("ERROR_MSG"));
        Map<String, Object> responseBody = response.getBody();
        responseBody.put("systemId",system_id);
        responseBody.put("custId",cust_id);
        responseBody.put("ecifCustNo",ecif_cust_no);
        if (custMgrMap != null && custMgrMap.size()>0){
            for (Map.Entry<String, Object> en : custMgrMap.entrySet()) {
                responseBody.put(en.getKey(),en.getValue());
            }
        }
        if (custGradeMap != null && custGradeMap.size()>0){
            responseBody.put("gradeArr",custGradeMap);
        }
        if (custAnalyseMap != null && custAnalyseMap.size()>0){
            responseBody.put("analyseArr",custAnalyseMap);
        }

    }

    /*private void fill(List<Map<String, Object>> custMgrList, List<Map<String, Object>> custGradeList, List<Map<String, Object>> custAnalyseList, RpcRequest request, RpcResponse response) {
        response.getHeader().put("ERROR_CODE",jsb.get("error_code"));
        response.getHeader().put("ERROR_MSG",jsb.get("error_msg"));
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> responseBody = response.getBody();
        responseBody.put("SYSTEM_ID",system_id);
        responseBody.put("CUST_ID",cust_id);
        responseBody.put("ECIF_CUST_NO",ecif_cust_no);
        if (custMgrList != null && custMgrList.size()>0){
            for (Map<String, Object> vMap : custMgrList) {
                for (Map.Entry<String, Object> en : vMap.entrySet()) {
                    responseBody.put(en.getKey(),en.getValue());
                }
            }
        }
        if (custGradeList != null && custGradeList.size()>0){
            responseBody.put("GRADE_ARR",custGradeList);
        }
    }*/

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
        // 源系统编号
        system_id = rpcUtil.notNull(requestBody.get("SYSTEM_ID"));
        // 源系统客户号
        cust_id = rpcUtil.notNull(requestBody.get("CUST_ID"));
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
