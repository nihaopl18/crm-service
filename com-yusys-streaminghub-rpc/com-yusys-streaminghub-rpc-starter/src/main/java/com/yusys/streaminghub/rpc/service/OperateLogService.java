package com.yusys.streaminghub.rpc.service;


import com.yusys.streaminghub.rpc.domain.TPSmOperLogInf;
import com.yusys.streaminghub.rpc.repository.mapper.RpcOperLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class OperateLogService  {
    private TPSmOperLogInf operLogInf;

    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private RpcOperLogMapper rpcOperLogMapper;

    public void operateLogService(TPSmOperLogInf operLogInf){
        this.operLogInf = operLogInf;
        addServerOperateLong(operLogInf);
    }

    /**
     * 实时接口服务端操作日志保存
     * @param operLogInf
     */
    public  void addServerOperateLong(TPSmOperLogInf operLogInf){
        String operTime = sf.format(new Date());
        String year = sf.format(new Date()).split("-")[0];
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyyMMdd");
        String flowNum = operLogInf.getMouldType().toString()+sf2.format(new Date())+randomNumber();
        operLogInf.setFlowNum(flowNum);
        operLogInf.setOperateYear(year);
        operLogInf.setOperateDt(operTime);
        //TODO 缺少非实时接口的登录者信息
        //如果是实时接口操作
        if ("2".equals(operLogInf.getFlowType())) {
            String flowId = UUID.randomUUID().toString().toLowerCase().replace("-","");
            operLogInf.setFlowId(flowId);
            rpcOperLogMapper.saveLogByRealTime(operLogInf);
        }else {
            /**
             * 缺少登录信息
             */
            rpcOperLogMapper.saveLogByNonRealTime(operLogInf);
        }


    }

    /**
     * 产生六位随机数
     */
    public static String randomNumber(){
        String num = null;
        Random random = new Random();
        int sp =  Math.abs(random.nextInt());
        if (sp<10){
            num="00000"+sp;
        }else if (9 < sp && sp < 100){
            num = "0000" + sp;
        }else if (99 < sp && sp < 1000){
            num = "000" + sp;
        }else if (999 < sp && sp < 10000){
            num = "00" + sp;
        }else if (9999 < sp && sp < 100000){
            num = "0" + sp;
        }else if (99999 < sp && sp < 1000000){
            num = "" + sp;
        }else {
            num=""+sp;
            num=num.substring(0,6);
        }
        return num;
    }


}