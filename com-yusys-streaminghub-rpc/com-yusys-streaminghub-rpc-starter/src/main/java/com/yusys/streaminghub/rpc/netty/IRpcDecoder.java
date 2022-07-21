package com.yusys.streaminghub.rpc.netty;

import io.netty.channel.ChannelHandlerContext;

import java.util.List;

public interface IRpcDecoder {
    void decode(byte[] bytes, List<Object> outList, ChannelHandlerContext channelHandlerContext) throws Exception;

}
