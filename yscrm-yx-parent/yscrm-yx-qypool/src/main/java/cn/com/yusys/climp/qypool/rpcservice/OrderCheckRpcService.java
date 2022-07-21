package cn.com.yusys.climp.qypool.rpcservice;

import cn.com.yusys.climp.qypool.service.LoyAcOrderListService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.itextpdf.text.pdf.parser.clipper.Clipper;
import com.yusys.streaminghub.rpc.IRpcService;
import com.yusys.streaminghub.rpc.RpcRequest;
import com.yusys.streaminghub.rpc.RpcResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("SERVICE_CODE=CYBQUERY_0001_000007")
public class OrderCheckRpcService implements IRpcService {
    JSONObject jsp = new JSONObject();
    @Autowired
    private LoyAcOrderListService loyAcOrderListService;
    @Override
    public void doService(RpcRequest request, RpcResponse response) throws Exception {
        jsp.put("error_code","000000");
        jsp.put("error_msg","CRM查询成功");
        Map<String,Object> requestBody = request.getBody();
        ResultDto<Map<String,Object>> rs = new ResultDto<>();
        if (ifContinue(requestBody)){
            rs = loyAcOrderListService.orderCheck((String)requestBody.get("ORDER_CODE"));
            if (rs.getCode() != 0){
                jsp.put("error_code",String.valueOf(rs.getCode()));
                jsp.put("error_msg",rs.getMessage());
            }
        }
        fill(rs.getData(),request,response);
    }

    private void fill(Map<String, Object> data, RpcRequest request, RpcResponse response) {
        response.getHeader().put("ERROR_CODE",jsp.get("error_code"));
        response.getHeader().put("ERROR_MSG",jsp.get("error_msg"));
        Map<String, Object> responseBody = response.getBody();
        if (data != null){
            responseBody.put("dataDt",notNull(data.get("dataDt")));
            responseBody.put("orderCode",notNull(data.get("orderNo")));
            responseBody.put("orderStatus",notNull(data.get("orderStatus")));
            responseBody.put("sumScore",notNull(data.get("sumScore")));
            responseBody.put("serviceNo",notNull(data.get("commodityCode")));
            responseBody.put("serviceNm",notNull(data.get("commodityName")));
            responseBody.put("changeCount",notNull(data.get("commodityNumber")));
            responseBody.put("orderChannel",notNull(data.get("orderChannel")));
            responseBody.put("orderDesc",notNull(data.get("orderDesc")));
            responseBody.put("remark","");
        }else {
            responseBody.put("dataDt","");
            responseBody.put("orderCode","");
            responseBody.put("orderStatus","");
            responseBody.put("sumScore","");
            responseBody.put("serviceNo","");
            responseBody.put("serviceNm","");
            responseBody.put("changeCount","");
            responseBody.put("orderChannel","");
            responseBody.put("orderDesc","");
            responseBody.put("remark","");
        }
    }

    private boolean ifContinue(Map<String, Object> requestBody) {
        if (isNull(requestBody.get("ORDER_CODE"))){
            jsp.put("error_code","1001");
            jsp.put("error_msg","订单编号报文格式不符合规范");
            return false;
        }else if (isNullString(requestBody.get("ORDER_CODE"))) {
            jsp.put("error_code", "1002");
            jsp.put("error_msg", "订单编号输入内容不允许为空");
            return false;
        }
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
