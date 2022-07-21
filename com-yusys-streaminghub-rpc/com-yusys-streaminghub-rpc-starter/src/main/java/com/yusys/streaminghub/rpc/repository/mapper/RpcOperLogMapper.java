package com.yusys.streaminghub.rpc.repository.mapper;

import com.yusys.streaminghub.rpc.domain.TPSmOperLogInf;

import java.util.Map;

public interface RpcOperLogMapper  {
    int saveLogByRealTime(TPSmOperLogInf operLogInf);

    int saveLogByNonRealTime(TPSmOperLogInf operLogInf);
}
