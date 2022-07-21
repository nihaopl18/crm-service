package com.yusys.streaminghub.rpc.netty;

public interface IRpcServer {
    void start() throws InterruptedException;
    void stop();
}
