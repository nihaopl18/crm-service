package com.yusys.streaminghub.rpc.netty;

import com.yusys.streaminghub.rpc.RpcResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public interface IRpcEncoder {
    void encode(RpcResponse response, ByteBuf byteBuf, ChannelHandlerContext channelHandlerContext)throws Exception;
}
