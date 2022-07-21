package com.yusys.streaminghub.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IReceiptsStateService {
    void updateState(String state, String message, String receiptId,Object data) throws JsonProcessingException;

    void updateStateJsonData(String state, String message, String receiptId,String jsonData) throws JsonProcessingException;

}
