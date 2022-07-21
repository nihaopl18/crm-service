package com.yusys.streaminghub.rpc.netty;

import com.yusys.streaminghub.rpc.netty.codec.FixedRpcEncoder;
import com.yusys.streaminghub.rpc.netty.codec.XmlRpcEncoder;

public interface IRpcEncoderFactory {
    static IRpcEncoder getEncoder(String encoderName) {
        switch (encoderName) {
            case "fixed":
                return new FixedRpcEncoder();
            case "xml":
                return new XmlRpcEncoder();
        }
        return null;
    }
}
