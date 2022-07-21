package com.yusys.streaminghub.rpc.netty;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.netty.codec.FixedRpcEncoder;
import com.yusys.streaminghub.rpc.netty.codec.XmlRpcEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;

public class NettyEncoder extends MessageToByteEncoder {

    private final Logger log = LoggerFactory.getLogger(NettyEncoder.class);
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        if (!(o instanceof RpcResponse)) {
            return;
        }
        RpcResponse rpcResponse= (RpcResponse) o;
        String type=rpcResponse.getContentType();
        IRpcEncoder rpcEncoder=null;
        switch (type) {
            case "fixed":
                rpcEncoder = new FixedRpcEncoder();
                break;
            case "xml":
                rpcEncoder = new XmlRpcEncoder();
                break;
        }
        InetSocketAddress insocket = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
        String clientIP = insocket.getAddress().getHostAddress();
        String clientPort = String.valueOf(insocket.getPort());
        log.info("客户端IP："+clientIP +" 客户端端口号："+clientPort);
        try {
            if (rpcEncoder == null) {
                throw new Exception(String.format("类型:%s 对应的编码器不存在。",type));
            }
            rpcEncoder.encode(rpcResponse,byteBuf,channelHandlerContext);
        }catch (IOException e){
            log.info("【发送端IP】："+clientIP+e.getMessage());
        }
    }


}
