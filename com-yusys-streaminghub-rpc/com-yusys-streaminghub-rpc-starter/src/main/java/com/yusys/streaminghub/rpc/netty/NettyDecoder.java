package com.yusys.streaminghub.rpc.netty;

import com.yusys.streaminghub.rpc.netty.codec.XmlRpcDecoder;
import com.yusys.streaminghub.rpc.util.UtilRpc;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;

@Component
public class NettyDecoder extends ByteToMessageDecoder {

    private final Logger log = LoggerFactory.getLogger(NettyDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        byte[] headFlag = new byte[4];
        System.arraycopy(bytes, 0, headFlag, 0, headFlag.length);
        String flag = new String(headFlag);
        String request = new String(bytes, UtilRpc.ENCODING);
        InetSocketAddress insocket = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
        String clientIP = insocket.getAddress().getHostAddress();
        String clientPort = String.valueOf(insocket.getPort());
        log.info("客户端IP："+clientIP +" 客户端端口号："+clientPort);
        IRpcDecoder rpcDecoder = null;
        switch (flag) {
            case "F009":
                rpcDecoder = IRpcDecoderFactory.getDecoder("fixed");
                break;
            default:
                rpcDecoder = IRpcDecoderFactory.getDecoder("xml");
                break;
        }
       /* try {*/
            if (rpcDecoder == null) {
                throw new Exception("不支持的侦格式，解析失败。");
            }
            rpcDecoder.decode(bytes, list, channelHandlerContext);
       /* }catch (Exception e){
            log.info("异常信息："+e.getMessage());
            //TODO 缺少异常信息反馈
        }*/
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }


}


