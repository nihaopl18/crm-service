package cn.com.yusys.climp.qypool.rpcservice;

import cn.com.yusys.climp.qypool.service.LoyAcOrderListService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.yusys.streaminghub.rpc.IRpcService;
import com.yusys.streaminghub.rpc.RpcRequest;
import com.yusys.streaminghub.rpc.RpcResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("SERVICE_CODE=CYBQUERY_0001_000006")
public class OrderQueryRpcService implements IRpcService {
    JSONObject jsp = new JSONObject();
    String ecif_cust_no = "";
    String system_id = "";
    String cust_id = "";

    @Autowired
    private LoyAcOrderListService loyAcOrderListService;
    @Override
    public void doService(RpcRequest request, RpcResponse response) throws Exception {
        jsp.put("error_code","000000");
        jsp.put("error_msg","CRM查询成功");
        Map<String,Object> requestBody = request.getBody();
        ResultDto<List<Map<String,Object>>> rs = new ResultDto<>();
        if (ifContinue(requestBody)){
            rs = loyAcOrderListService.getOrderListByCustNds(requestBody,request.isAppHead(),request.getQueryNum(), request.getPageNum());
            if (rs.getCode() != 0){
                jsp.put("error_code",String.valueOf(rs.getCode()));
                jsp.put("error_msg",rs.getMessage());
            }else {
                ecif_cust_no = rs.getMessage();
                request.setCurrentNum(rs.getData().size());
                request.setTotalNum((int) rs.getTotal());
            }
        }
        fill(rs.getData(),request,response);
    }

    private void fill(List<Map<String, Object>> data, RpcRequest request, RpcResponse response) {
        response.getHeader().put("ERROR_CODE",jsp.get("error_code"));
        response.getHeader().put("ERROR_MSG",jsp.get("error_msg"));
        Map<String, Object> responseBody = response.getBody();
        responseBody.put("systemId",system_id);
        responseBody.put("custId",cust_id);
        responseBody.put("ecifCustNo",ecif_cust_no);
        List<Map<String,Object>> list = new ArrayList<>();
        List<Map<String,Object>> list1 = new ArrayList<>();
        if (data != null && data.size() > 0){
            data.forEach(map -> {
                Map<String,Object> temp = new HashMap<>();
                temp.put("orderDt",notNull(map.get("orderDt")));
                temp.put("orderCode",notNull(map.get("orderNo")));
                temp.put("orderStatus",notNull(map.get("orderStatus")));
                temp.put("sumScore",notNull(map.get("sumScore")));
                temp.put("serviceNo",notNull(map.get("comodityCode")));
                temp.put("serviceNm",notNull(map.get("comodityName")));
                temp.put("changeCount",notNull(map.get("comodityNumber")));
                temp.put("orderChannel",notNull(map.get("orderChannel")));
                temp.put("orderDesc",notNull(map.get("orderDesc")));
                temp.put("extendDesc",notNull(map.get("extendDesc")));
                temp.put("remark","");
                List<Map<String,Object>> attr_list = (List<Map<String, Object>>) map.get("attr");
                if (attr_list != null && attr_list.size() > 0){
                    attr_list.forEach(map1 -> {
                        Map<String,Object> temp1 = new HashMap<>();
                        temp1.put("attbeCode",notNull(map1.get("attrCode")));
                        temp1.put("attbeName",notNull(map1.get("attrName")));
                        temp1.put("attbeDesc",notNull(map1.get("attrDesc")));
                        temp1.put("attbeRemark",notNull(map1.get("attrRemark")));
                        list1.add(temp1);
                    });
                }else {
                    Map<String,Object> temp1 = new HashMap<>();
                    temp1.put("attbeCode","");
                    temp1.put("attbeCode","");
                    temp1.put("attbeCode","");
                    temp1.put("attbeCode","");
                    list1.add(temp1);
                }
                temp.put("extendArr",list1);
                list.add(temp);
            });
        }else {
            Map<String,Object> temp = new HashMap<>();
            temp.put("orderDt","");
            temp.put("orderCode","");
            temp.put("orderStatus","");
            temp.put("sumScore","");
            temp.put("serviceNo","");
            temp.put("serviceNm","");
            temp.put("changeCount","");
            temp.put("orderChannel","");
            temp.put("orderDesc","");
            temp.put("extendDesc","");
            temp.put("remark","");
            Map<String,Object> temp1 = new HashMap<>();
            temp1.put("attbeCode","");
            temp1.put("attbeName","");
            temp1.put("attbeDesc","");
            temp1.put("attbeRemark","");
            list1.add(temp1);
            temp.put("extendArr",list1);
            list.add(temp);
        }
        responseBody.put("orderArr",list);
    }

    /**
     * 是否满足查询条件
     * @param requestBody
     * @return
     */
    private boolean ifContinue(Map<String, Object> requestBody) {
        if (isNull(requestBody.get("SYSTEM_ID"))){
            jsp.put("error_code","1001");
            jsp.put("error_msg","源系统名称报文格式不符合规范");
            return false;
        }else if (isNull(requestBody.get("CUST_ID"))){
            jsp.put("error_code","1001");
            jsp.put("error_msg","源系统客户号报文格式不符合规范");
            return false;
        }else if (isNull(requestBody.get("BEGIN_DT"))){
            jsp.put("error_code","1001");
            jsp.put("error_msg","开始时间报文格式不符合规范");
            return false;
        }else if (isNull(requestBody.get("END_DT"))){
            jsp.put("error_code","1001");
            jsp.put("error_msg","结束时间报文格式不符合规范");
            return false;
        }else {
            if (isNullString(requestBody.get("SYSTEM_ID"))) {
                jsp.put("error_code", "1002");
                jsp.put("error_msg", "源系统名称输入内容不允许为空");
                return false;
            } else if (isNullString(requestBody.get("CUST_ID"))) {
                jsp.put("error_code", "1002");
                jsp.put("error_msg", "源系统客户号输入内容不允许为空");
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

    private String notNull(Object obj){
        return obj == null ? "" : obj.toString();
    }

}
