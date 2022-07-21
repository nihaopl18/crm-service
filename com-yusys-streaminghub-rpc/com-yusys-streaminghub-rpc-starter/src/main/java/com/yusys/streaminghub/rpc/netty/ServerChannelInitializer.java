package com.yusys.streaminghub.rpc.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.socket.SocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Autowired
    TCPServerHandler tcpServerHandler;

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.config().setRecvByteBufAllocator(new FixedRecvByteBufAllocator(1024*1024));
        channel.pipeline().
                addLast(new NettyDecoder()).        //自定义解码器
                addLast(new NettyEncoder()).
                addLast(tcpServerHandler);
    }
}
