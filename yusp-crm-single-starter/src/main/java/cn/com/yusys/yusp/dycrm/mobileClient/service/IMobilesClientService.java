package cn.com.yusys.yusp.dycrm.mobileClient.service;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

import java.util.List;
import java.util.Map;

public interface IMobilesClientService {
    ResultDto<String> sendReq(String branch, String content, String mobile, String channel, String clientNo);
    //Runnable sendmsg(String branch,String content,String mobile,String channel,String clientNo);
    ResultDto<String> sendMsg2Cust(String custCode,String telNo,String msgContent,String branch);
}
