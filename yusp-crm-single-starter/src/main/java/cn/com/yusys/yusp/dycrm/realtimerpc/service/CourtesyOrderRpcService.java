package cn.com.yusys.yusp.dycrm.realtimerpc.service;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.dycrm.complaintfeedback.domain.CSRCommonHead;
import cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper.RpcCustScoreQueryMapper;
import cn.com.yusys.yusp.dycrm.realtimerpc.repository.mapper.RpcCustViewQueryMapper;
import cn.com.yusys.yusp.dycrm.realtimerpc.util.DataDateUtis;
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

@Service("SERVICE_CODE=CYBQUERY_0001_000004")
public class CourtesyOrderRpcService implements IRpcService {
    JSONObject jsb = new JSONObject();
    CSRCommonHead requestHeader = new CSRCommonHead();

    //日志
    private static final Logger log = LoggerFactory.getLogger(CourtesyOrderRpcService.class);

    public static final SimpleDateFormat TIMESTAMPF = new SimpleDateFormat("yyyyMMddHHmmss");

    private int queryNum = 20;



    @Autowired
    RpcCustViewQueryMapper rpcCustViewQueryMapper;

    @Autowired
    RpcCustScoreQueryMapper rpcCustScoreQueryMapper;

    String ecif_cust_no = "";
    String system_id = "";
    String cust_id = "";

    // 礼遇信息
    String service_category = "";

    String query_type="";


    List<Map<String, Object>> rowsList = new ArrayList<Map<String, Object>>();
    Map<String,Object> CustGrade = new HashMap<>();



    @Override
    public void doService(RpcRequest request, RpcResponse response) throws Exception {
        jsb.put("ERROR_CODE", "000000");
        jsb.put("ERROR_MSG", "CRM查询成功");
        Map<String, Object> body = request.getBody();
        request.setQueryNum(queryNum);
        //解析报文体信息
        if (ifContinue(body)){
            String custId = rpcCustViewQueryMapper.queryEcifNo(system_id,cust_id);
            ecif_cust_no = custId != null ? custId : "";

            HashMap paramMap = new HashMap();
            paramMap.put("ecifCustNo",ecif_cust_no);

            String batchDate = DataDateUtis.getCurrentDate();
            paramMap.put("batchDate",batchDate);
            paramMap.put("serviceCategory",service_category);



            if ("1".equals(query_type)){
                if ("".equals(ecif_cust_no)){
                    jsb.put("ERROR_CODE", "1007");
                    jsb.put("ERROR_MSG", "该NDS客户号未查询ECIF客户号");
                }else {
                    //查询客户可用积分
                    int score = rpcCustScoreQueryMapper.queryCustScore(paramMap);
                    //查询客户评级信息
                    //CustGrade = rpcCustScoreQueryMapper.queryCustGrade(paramMap);
                    paramMap.put("score",score);
                    //查询客户可兑换礼遇清单排序
                    PageHelper.startPage(request.getPageNum(),request.getQueryNum());
                    rowsList = rpcCustScoreQueryMapper.queryCustServiceInfo(paramMap);
                    if (rowsList.size()<=0){
                        jsb.put("ERROR_CODE", "1007");
                        jsb.put("ERROR_MSG", "该客户号可兑换的礼遇");
                    }
                    ResultDto<List<Map<String, Object>>> rs = new ResultDto<List<Map<String, Object>>>(rowsList);
                    request.setCurrentNum(rowsList != null ? rowsList.size() : 0);
                    request.setTotalNum((int) rs.getTotal());
                    PageHelper.clearPage();

                }
            }else {
                PageHelper.startPage(request.getPageNum(),request.getQueryNum());
                rowsList = rpcCustScoreQueryMapper.queryCustServiceInfoAll(paramMap);
                if (rowsList.size()<=0){
                    jsb.put("ERROR_CODE", "1007");
                    jsb.put("ERROR_MSG", "未查询到可兑换的礼遇");

                }
                ResultDto<List<Map<String, Object>>> rs = new ResultDto<List<Map<String, Object>>>(rowsList);
                request.setCurrentNum(rowsList != null ? rowsList.size() : 0);
                request.setTotalNum((int) rs.getTotal());
                PageHelper.clearPage();
            }

            fill(rowsList,response);
        }




    }

    private void fill(List<Map<String, Object>> rowsList, RpcResponse response) {
        response.getHeader().put("ERROR_CODE",jsb.get("ERROR_CODE"));
        response.getHeader().put("ERROR_MSG",jsb.get("ERROR_MSG"));
        Map<String, Object> responseBody = response.getBody();
        responseBody.put("systemId",system_id);
        responseBody.put("custId",cust_id);
        responseBody.put("ecifCustNo",ecif_cust_no);
        List<Map<String,Object>> list = new ArrayList<>();
        if (rowsList.size()==0){
            Map<String,Object> temp = new HashMap<>();
            temp.put("serviceNo","");
            temp.put("serviceName","");
            temp.put("serviceExcgType","");
            temp.put("serviceCategory","");
            temp.put("ifRcd","");
            temp.put("usableCount","");
            temp.put("serviceOrder","");
            list.add(temp);
        }else {
            list = rowsList;
        }
        responseBody.put("serviceArr",list);
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
        // 源系统编号
        system_id = rpcUtil.notNull(requestBody.get("SYSTEM_ID"));
        // 源系统客户号
        cust_id = rpcUtil.notNull(requestBody.get("CUST_ID"));
        //礼遇种类
        service_category = rpcUtil.notNull(requestBody.get("SERVICE_CATEGORY"));
        query_type = rpcUtil.notNull(requestBody.get("QUERY_TYPE"));
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
