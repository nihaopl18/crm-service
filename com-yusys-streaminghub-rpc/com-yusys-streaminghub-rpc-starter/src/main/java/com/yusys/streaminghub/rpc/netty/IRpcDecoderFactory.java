package com.yusys.streaminghub.rpc.netty;

import com.yusys.streaminghub.rpc.netty.codec.FixedRpcDecoder;
import com.yusys.streaminghub.rpc.netty.codec.XmlRpcDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
public interface IRpcDecoderFactory {

     static IRpcDecoder getDecoder(String decoderName) {
        switch (decoderName) {
            case "fixed":
                return new FixedRpcDecoder();
            case "xml":
                return new XmlRpcDecoder();
        }
        return null;
    }
}
