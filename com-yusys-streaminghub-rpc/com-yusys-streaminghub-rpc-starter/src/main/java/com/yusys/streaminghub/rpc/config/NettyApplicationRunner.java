package com.yusys.streaminghub.rpc.config;

import com.yusys.streaminghub.rpc.netty.IRpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class NettyApplicationRunner implements ApplicationRunner, ApplicationListener<ContextClosedEvent> {
    @Autowired
    IRpcServer rpcServer;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        rpcServer.start();
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        rpcServer.stop();
    }
}
