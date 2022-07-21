package cn.com.yusys.yusp.dycrm.mobileClient.service.impl;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.dycrm.mobileClient.service.IMobilesClientService;
import com.yusys.streaminghub.rpc.service.MessageLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 *
 * @项目名称: yscrm-business-acct-pub
 * @类名称: MobilesClientServiceImpl
 * @类描述:
 * @功能描述: 短信通用接口
 * @创建人: chenrb@yusys.com.cn
 * @创建时间: 2022/4/24 14:04
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class MobilesClientServiceImpl implements IMobilesClientService {





    // 日志
    private static final Logger log = LoggerFactory.getLogger(MobilesClientServiceImpl.class);
    //字符编码
    private static final String ENCODING = "GBK";

    // 请求超时设置(毫秒)
    private static final int TIMEOUT = 60000;

    private static SimpleDateFormat sf = new SimpleDateFormat(
            "yyyyMMddHHmmssSSS");


    // 日期格式化
    public static final SimpleDateFormat TIMESTAMPF3 = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");


    // 日期格式化
    private static final SimpleDateFormat TIMESTAMPF = new SimpleDateFormat(
            "yyyyMMdd");

    // 日期格式化
    private static final SimpleDateFormat TIMESTAMPF2 = new SimpleDateFormat(
            "HH:mm:ss");


    //业务代码，09代表CRM
    private static final String BSNCODE = "09";
    //交易代码
    private static final String TRAN_TYPE ="0000";
    //交易名称，30个字节，不足后补空格
    private static final String TRAN_NAME ="营销类实时短信-CRM";
    //分行号，6个字节，没有就送CRM001
    private static final String BRANCH = "CRM001";


    //public static String flow_no ="";
    public static String is_success ="1";

    private static Runnable Runnable = new Thread();

    private ResultDto<String> resultDto = new ResultDto<>();




    @Value("${spring.smsPlatform.host}")
    private String connectionIp;

    @Value("${spring.smsPlatform.port}")
    private String connectionPort;

    /**
     * 短信发送请求
     * @param branch
     * @param content
     * @param mobile
     * @param channel
     * @param clientNo
     * @return
     */
    @Override
    public ResultDto<String> sendReq(String branch, String content, String mobile, String channel, String clientNo) {
        //ResultDto<String> resultDto = new ResultDto<>();
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(sendQryRequest(branch,content,mobile,channel,clientNo));
            //resultDto.setCode(0);
            //resultDto.setMessage("发送成功！");
        }catch (Exception e){
            is_success = "2";
            resultDto.setCode(1);
            resultDto.setMessage(e.getMessage());
            log.info(e.getMessage());
        }
        return resultDto;
    }


    public Runnable sendQryRequest(String branch, String content, String mobile, String channel, String clientNo) throws Exception {
        String bran = "";
        if ("".equals(branch) || branch == null){
            bran = BRANCH;
        }else {
            bran = extendBlank(bran,6);
        }
        String tranName =extendBlank(TRAN_NAME,30);
        //交易日期
        String tranDt = TIMESTAMPF.format(new Date());
        //交易时间
        String tranTm = TIMESTAMPF2.format(new Date());

        //modify by lchszdev091  20150707 替换短信内容中回车换行符
        content = xmlto(content);

        //短息内容
        content = extendBlank(content,255);
        //手机号码
        mobile =extendBlank(mobile,11);

        //发送渠道，00-都不上送；01-微信；10-短信；11-微信，短信
        String chann = extendBlank(channel,5);
        //核心客户号,微信通知需要上送
        String client = extendBlank(clientNo,8);

        StringBuffer sb = new StringBuffer();
        sb.append(BSNCODE);
        sb.append(TRAN_TYPE);
        sb.append(bran);
        sb.append(tranName);
        sb.append(tranDt);
        sb.append(tranTm);
        sb.append(content);
        sb.append(mobile);
        sb.append(chann);
        sb.append(client);
        sb.append("\r\n");

        String launchTime = "'" + TIMESTAMPF3.format(new Date()) + "'";

        String backTime = "'" + TIMESTAMPF3.format(new Date()) + "'";

        String flowNo = "CRM_"+sf.format(new Date());
        Map<String,String> header = new HashMap<>();
        header.put("FLOW_ID",flowNo);
        try {
            //记录日志
            MessageLogService.msg2log(sb.toString(),is_success,launchTime,backTime,header);
            log.info("请求:"+sb.toString());
            //发起请求
            doTCPIPConnect(sb.toString());

        }catch (Exception e){
            resultDto.setCode(1);
            resultDto.setMessage(e.getMessage());
            log.info(e.getMessage());
        }
        return Runnable;
    }


    /**
     * 以TCP/IP的方式请求
     *
     * @param req
     * @return
     * @throws Exception
     * @throws UnknownHostException
     * @throws Exception
     */
    private synchronized String doTCPIPConnect(String req) throws UnknownHostException, Exception{
        String seq = null;
        // 响应信息流
        Socket client = null;
        try {

            // 流套接字
            client = new Socket(connectionIp, Integer.parseInt(connectionPort));
            // 超时设置
            client.setSoTimeout(TIMEOUT);

            // 发送请求信息
            client.getOutputStream().write(req.getBytes(ENCODING));
            client.getOutputStream().flush();


            // 读取响应信息
            ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
            InputStream is = client.getInputStream();
            byte[] buf = new byte[1024];
            int size = 0 ;
            while((size = is.read(buf)) != -1){
                baos.write(buf,0,size);
            }
            String msg = baos.toString(ENCODING);
            req = msg;
            log.info("返回报文:"+msg);
            parseRespMsg(req);
            is.close();
        } finally {
            if (client != null) {
                client.close();
                client = null;
            }
        }

        return seq;
    }

    /**
     * 解析网银返回报文
     * @param req
     * @return
     */
    private ResultDto<String>  parseRespMsg(String req) {

        if(req.length() >1 ){
            resultDto.setCode(0);
            resultDto.setMessage(req.substring(0,1));

        }
        return resultDto;
    }


    /**
     * 字符串扩展到指定长度，不够味的后补空格
     * @param text
     * @param length
     * @return
     */
    private String extendBlank(String text, int length) throws UnsupportedEncodingException {
        if (text == null || text.length() >= length){
            return textLimit2NDS(text,length);
        }
        char[] array = new char[length];
        Arrays.fill(array,0,length,' ');
        System.arraycopy(text.toCharArray(), 0, array, 0,
                text.length());

        return textLimit2NDS(String.valueOf(array),length);

    }

    /**
     * 替换短信内容中的特殊符号
     * @param content
     * @return
     */
    public static String xmlto(String content) {
        content = content.replaceAll("\r\n", "");
        content = content.replaceAll("\r", "");
        content = content.replaceAll("\n", "");
        content = content.replaceAll("&lt;", "<");
        content = content.replaceAll("&gt;", ">");
        return content = content.replaceAll("&quot;", "\"");
    }

    /**
     * 限定字段长度 CRM的长度不区分字符集
     * @param text
     * @param maxlen
     * @return
     */
    private String textLimit2NDS(String text, int maxlen) throws UnsupportedEncodingException {
        int counterDoubleByte = 0;
        byte[] b = text.getBytes(ENCODING);
        if (text == null || "".equals(text))
            return "";
        if (maxlen <= 0)
            return "";

        // 替换回车换行
        text = text.replace('\n', ' ');
        text = text.replace('\r', ' ');

        if (b.length <= maxlen)
            return text;
        else{
            for(int i=0;i<maxlen;i++){
                if(b[i] < 0)
                    counterDoubleByte ++;
            }
            if(counterDoubleByte % 2 == 0)
                return new String(b,0,maxlen,ENCODING);
            else
                return new String(b,0,maxlen-1,ENCODING);
        }

    }

    /**
     * 发送短信给客户
     * @param custCode
     * @param telNo
     * @param msgContent
     * @param branch
     * @return
     */
    @Override
    public ResultDto<String> sendMsg2Cust(String custCode, String telNo, String msgContent, String branch) {
        String channel = "10"; //10:短信 20：微信息
        ResultDto<String> resultDto = new ResultDto<>();
        resultDto = sendReq(branch, msgContent, telNo, channel, custCode);
        if (resultDto.getCode()!= 0){
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resultDto = sendReq(branch, msgContent, telNo, channel, custCode);
        }
        return resultDto;
    }

}
