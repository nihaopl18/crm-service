package com.yusys.streaminghub.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yusys.streaminghub.app.info.ReceiptsInfo;
import com.yusys.streaminghub.app.info.RequestInfo;

public interface IReceiptsCacher {
    String getData(RequestInfo requestInfo) throws JsonProcessingException;

    boolean hasData(RequestInfo requestInfo) throws JsonProcessingException;
}
