package com.yusys.streaminghub.rpc;

import com.yusys.streaminghub.rpc.annotation.RpcService;

/**
 * 此接口声明为rpc服务
 * 注意：在实现类中@Service名字与交易代码对应，如：SERVICE_CODE=CRMQUERY_0001_000001。
 * 其中SERVICE_CODE作为交易代码被作为关键字，关键字的添加见application.properties中的rpc.service.keywords中添加
 */
@RpcService
public interface IRpcService {
    void doService(RpcRequest request, RpcResponse response)throws Exception;
}
