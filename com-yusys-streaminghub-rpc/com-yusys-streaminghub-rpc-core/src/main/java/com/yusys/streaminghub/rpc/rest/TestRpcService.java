package com.yusys.streaminghub.rpc.rest;

import com.yusys.streaminghub.rpc.IRpcService;
import com.yusys.streaminghub.rpc.RpcRequest;
import com.yusys.streaminghub.rpc.RpcResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 在crm的子项目中用法：
 * - rpcService可定义在你的子项目中，以方便注入你的业务服务，不必定义在rpc.core项目中
 * - 在你的项目中只需要引入项目：com-yusys-streaminghub-rpc-core
 */
@Service("SERVICE_CODE=CRMQUERY_0001_000001")
public class TestRpcService implements IRpcService {

    @Override
    public void doService(RpcRequest request, RpcResponse response) throws Exception {
        System.out.println("------这是rpc处理");
        fill(response);
    }

    private void fill(RpcResponse response) {
        Map<String, String> header = response.getHeader();
        header.put("SERVICE_CODE", "xxx1");
        header.put("UPDATED_SYSTEM_ID", "xxx2");
        header.put("SRC_CREATE_TS", "xxx3");
        header.put("SRC_UPDATED_TS", "xxx4");
        header.put("UPDATED_USER", "xxx5");
        header.put("UPDATED_UNIT", "xxx6");
        header.put("FLOW_ID", "xxx7");
        header.put("ERROR_CODE", "xxx8");
        header.put("ERROR_MSG", "xxx9");

        Map<String, String> body = response.getBody();
        body.put("CUST_ID", "xxx10");
        body.put("EVALUATE_RESULT", "xxx11");
        body.put("EVA_DATE", "xxx12");
        body.put("USEFUL_LIFE_DATE", "xxx13");
        body.put("ACCOUNT", "xxx14");
        body.put("REMARK_BACK1", "xxx15");
        body.put("EVA_CHANNEL", "xxx16");
        body.put("COUNTER_EVA_FLAG", "xxx17");
        body.put("IF_EXPERIENCE", "xxx18");
        body.put("AUM_GRADE_CD", "xxx19");
        body.put("IS_STAFF_FLAG", "xxx20");
        body.put("BIRTH_DT", "xxx21");
        body.put("INVEST_TERM", "xxx22");
        body.put("CLIENT_SOURCE", "xxx23");
        body.put("CUST_TYPE", "xxx24");
        body.put("IS_LOWEST_FLAG", "xxx25");
        body.put("CODE_OCCUPATION", "xxx26");
    }
}
