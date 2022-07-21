package com.yusys.streaminghub.rpc.netty;

import com.yusys.streaminghub.rpc.IRpcService;
import com.yusys.streaminghub.rpc.RpcRequest;
import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.annotation.RpcService;
import com.yusys.streaminghub.rpc.config.RpcKeyword;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ChannelHandler.Sharable
@Slf4j
public class TCPServerHandler extends ChannelInboundHandlerAdapter {
    Map<String, Object> mappings;
    List<String> keyswords;
    //日期格式化 17位
    public static final SimpleDateFormat TIMESTAMPF = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public TCPServerHandler(@Autowired ApplicationContext applicationContext,
                            @Autowired RpcKeyword keyword) {
        mappings = applicationContext.getBeansWithAnnotation(RpcService.class);
        checkMapping(mappings);
        this.keyswords = (keyword == null || keyword.getKeywords() == null) ? new ArrayList<>() : keyword.getKeywords();
    }

    private void checkMapping(Map<String, Object> mappings) {
        for (Map.Entry<String, Object> entry : mappings.entrySet()) {
            Object o = entry.getValue();
            if (!(o instanceof IRpcService)) {
                throw new RuntimeException(String.format("rpc服务:%s 没有实现接口：IRpcService", entry.getKey()));
            }
            log.info(String.format("发现rpcService:%s", entry.getKey()));
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcRequest request = (RpcRequest) msg;
        RpcResponse response = new RpcResponse(request.getContentType());
        Object rpcService = null;
        for (String keyword : keyswords) {
            Map<String, String> header = request.getHeader();
            if (!header.containsKey(keyword)) {
                continue;
            }
            String value = header.get(keyword);
            String mapping = String.format("%s=%s", keyword, value);
            rpcService = mappings.get(mapping);
            if (rpcService != null) {
                break;
            }
        }
        if (rpcService == null) {
            Map<String, String> requestHeader = request.getHeader();
            Map<String, String> responseHeader = response.getHeader();
            responseHeader.put("SERVICE_CODE",notNull(requestHeader.get("SERVICE_CODE")));
            responseHeader.put("UPDATED_SYSTEM_ID", notNull(requestHeader.get("UPDATED_SYSTEM_ID")));
            responseHeader.put("SRC_CREATE_TS", notNull(requestHeader.get("SRC_UPDATED_TS")));
            responseHeader.put("SRC_UPDATED_TS", TIMESTAMPF.format(new Date()));
            responseHeader.put("UPDATED_USER", notNull(requestHeader.get("UPDATED_USER")));
            responseHeader.put("UPDATED_UNIT", notNull(requestHeader.get("UPDATED_UNIT")));
            responseHeader.put("FLOW_ID", notNull(requestHeader.get("FLOW_ID")));
            responseHeader.put("ERROR_CODE", "1007");
            responseHeader.put("ERROR_MSG", "交易代码输入有误");
            //throw new Exception("未识别的交易代码或缺少服务实现");
        }
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIP = insocket.getAddress().getHostAddress();
        String clientPort = String.valueOf(insocket.getPort());
        log.info("客户端IP："+clientIP +" 客户端端口号："+clientPort);
        long begin = System.currentTimeMillis();
        String flowId = request.getHeader().get("FLOW_ID");
        if (rpcService!=null){
            IRpcService service = (IRpcService) rpcService;
            try {
                if (start(request,response)){
                    service.doService(request, response);
                }
            }catch (Exception e){
                response.getHeader().put("ERROR_CODE","1005");
                response.getHeader().put("ERROR_MSG","系统内部异常");
                log.error("RPC服务异常信息："+e.getMessage());
                e.printStackTrace();
            }
            setResponse(request,response);
        }
        ctx.writeAndFlush(response);
        ctx.close();
    }

    private void setResponse(RpcRequest request, RpcResponse response) {
        Map<String, String> requestHeader = request.getHeader();
        Map<String, String> responseHeader = response.getHeader();
        responseHeader.put("SERVICE_CODE",notNull(requestHeader.get("SERVICE_CODE")));
        responseHeader.put("UPDATED_SYSTEM_ID", notNull(requestHeader.get("UPDATED_SYSTEM_ID")));
        responseHeader.put("SRC_CREATE_TS", notNull(requestHeader.get("SRC_UPDATED_TS")));
        responseHeader.put("SRC_UPDATED_TS", TIMESTAMPF.format(new Date()));
        responseHeader.put("UPDATED_USER", notNull(requestHeader.get("UPDATED_USER")));
        responseHeader.put("UPDATED_UNIT", notNull(requestHeader.get("UPDATED_UNIT")));
        responseHeader.put("FLOW_ID", notNull(requestHeader.get("FLOW_ID")));
        if (request.isAppHead()){
            Map<String,String> appHead = response.getAppHead();
            appHead.put("PGUP_OR_PGDN",String.valueOf(request.getPgupPgdn()));
            appHead.put("TOTAL_NUM",String.valueOf(request.getTotalNum()));
            appHead.put("CURRENT_NUM",String.valueOf(request.getCurrentNum()));
            int pageStart = request.getPageStart();
            int queryNum = request.getQueryNum();
            if (request.getPgupPgdn() == 1){
                //下翻
                pageStart = pageStart + queryNum;
                appHead.put("PAGE_START",String.valueOf(pageStart));
                if (request.getCurrentNum() != 0){
                    appHead.put("PAGE_END",String.valueOf(pageStart + request.getCurrentNum() - 1));
                }else {
                    appHead.put("PAGE_END",String.valueOf(pageStart));
                }
            }else if(request.getPgupPgdn() == 0){
                //上翻
                if (request.getPageStart() == 1) {
                    appHead.put("PAGE_START",String.valueOf(pageStart));
                }else if (request.getPageStart() > 1){
                    pageStart = pageStart - queryNum;
                    if (pageStart <= 0){
                        pageStart = 1;
                    }
                    appHead.put("PAGE_START",String.valueOf(request.getPageStart() + request.getCurrentNum()));
                }
                appHead.put("PAGE_END",String.valueOf(pageStart + request.getCurrentNum() - 1));
            }

        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }


    private boolean start(RpcRequest request,RpcResponse response) {
        Map<String,String> header = request.getHeader();
        if (isNull(header.get("SERVICE_CODE"))){
            response.getHeader().put("ERROR_CODE","1001");
            response.getHeader().put("ERROR_MSG","SERVICE_CODE报文格式不符合规范");
            return false;
        }else if (isNull(header.get("UPDATED_SYSTEM_ID"))){
            response.getHeader().put("ERROR_CODE","1001");
            response.getHeader().put("ERROR_MSG","UPDATED_SYSTEM_ID报文格式不符合规范");
            return false;
        }else if (isNull(header.get("SRC_UPDATED_TS"))){
            response.getHeader().put("ERROR_CODE","1001");
            response.getHeader().put("ERROR_MSG","SRC_UPDATED_TS报文格式不符合规范");
            return false;
        }else if (isNull(header.get("UPDATED_USER"))){
            response.getHeader().put("ERROR_CODE","1001");
            response.getHeader().put("ERROR_MSG","UPDATED_USER报文格式不符合规范");
            return false;
        }else if (isNull(header.get("UPDATED_UNIT"))){
            response.getHeader().put("ERROR_CODE","1001");
            response.getHeader().put("ERROR_MSG","UPDATED_UNIT报文格式不符合规范");
            return false;
        }else if (isNull(header.get("FLOW_ID"))){
            response.getHeader().put("ERROR_CODE","1001");
            response.getHeader().put("ERROR_MSG","FLOW_ID报文格式不符合规范");
            return false;
        }else if (isNull(header.get("ERROR_CODE"))){
            response.getHeader().put("ERROR_CODE","1001");
            response.getHeader().put("ERROR_MSG","ERROR_CODE报文格式不符合规范");
            return false;
        }else if (isNull(header.get("ERROR_MSG"))){
            response.getHeader().put("ERROR_CODE","1001");
            response.getHeader().put("ERROR_MSG","ERROR_MSG报文格式不符合规范");
            return false;
        }else {
            if (isNullString(header.get("SERVICE_CODE"))){
                response.getHeader().put("ERROR_CODE","1002");
                response.getHeader().put("ERROR_MSG","交易代码输入内容不允许为空");
                return false;
            }else if (isNullString(header.get("UPDATED_SYSTEM_ID"))){
                response.getHeader().put("ERROR_CODE","1002");
                response.getHeader().put("ERROR_MSG","更新系统号输入内容不允许为空");
                return false;
            }else if (isNullString(header.get("SRC_UPDATED_TS"))){
                response.getHeader().put("ERROR_CODE","1002");
                response.getHeader().put("ERROR_MSG","交易处理时间输入内容不允许为空");
                return false;
            }else if (isNullString(header.get("FLOW_ID"))){
                response.getHeader().put("ERROR_CODE","1002");
                response.getHeader().put("ERROR_MSG","流水号输入内容不允许为空");
                return false;
            }else {
                if (request.isAppHead()){
                    if (request.getPgupPgdn() == null){
                        response.getHeader().put("ERROR_CODE","1002");
                        response.getHeader().put("ERROR_MSG","上翻下翻标志输入内容不允许为空");
                        return false;
                    }else if (request.getPgupPgdn() < 0 || request.getPgupPgdn() >1){
                        response.getHeader().put("ERROR_CODE","1002");
                        response.getHeader().put("ERROR_MSG","上翻下翻标志栏位值有误");
                        return false;
                    }else if (request.getPageStart() <= 0 && request.getCurrentNum() != -1){
                        response.getHeader().put("ERROR_CODE","1002");
                        response.getHeader().put("ERROR_MSG","本页第一笔标志栏位值有误");
                        return false;
                    }else if (request.getPageEnd() <= request.getPageStart() && request.getCurrentNum() != -1){
                        response.getHeader().put("ERROR_CODE","1002");
                        response.getHeader().put("ERROR_MSG","本页最后一笔标志栏位值有误");
                        return false;
                    }else {
                        if (request.getPageStart() != 0 && request.getPageEnd() != 0 && request.getCurrentNum() != -1){
                            int pageNum = 1;
                            int queryNum = 10;
                            if (request.getPgupPgdn() == 1){
                                //下翻
                                pageNum = queryNum != 0 ? (int) Math.ceil(( ((double) request.getPageStart() - 1 + (double) queryNum) + (double) queryNum) / (double) queryNum) : 0;
                            }else if(request.getPgupPgdn() == 0){
                                //上翻
                                if (request.getPageStart() == 1) {
                                    pageNum = queryNum != 0 ? (int) Math.ceil(((double) request.getPageStart() - 1 + (double) queryNum) / (double) queryNum) : 0;
                                }else if (request.getPageStart() > 1){
                                    pageNum = queryNum != 0 ? (int) Math.ceil((((double) request.getPageStart() - 1 - (double) queryNum) + (double) queryNum) / (double) queryNum) : 0;
                                }
                            }
                            request.setPageNum(pageNum);
                            request.setQueryNum(queryNum);
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * 避免出现"null"
     * @param obj
     * @return
     */
    public static String notNull(Object obj) {
        if (obj == null)
            return "";
        return obj.toString();

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
}
