package com.yusys.streaminghub.rpc.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NettyRpcServer implements IRpcServer {
    EventLoopGroup bossGroup;
    EventLoopGroup workerGroup;
    @Autowired
    ServerChannelInitializer serverChannelInitializer;
    @Value("${rpc.server.port}")
    int port;
    @Value("${rpc.server.nThreads.boss}")
    int bossThread;
    @Value("${rpc.server.nThreads.work}")
    int workThread;
    @Override
    public void start() throws InterruptedException {
        bossGroup = new NioEventLoopGroup(bossThread);
        workerGroup = new NioEventLoopGroup(workThread);
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(serverChannelInitializer)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, false);
        //绑定端口后，开启监听
        ChannelFuture channelFuture = b.bind(port).sync();
        if (channelFuture.isSuccess()) {
            log.info(String.format("Rpc服务已启动成功 端口号：%s",port));
        }
    }

    @Override
    public void stop() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}
