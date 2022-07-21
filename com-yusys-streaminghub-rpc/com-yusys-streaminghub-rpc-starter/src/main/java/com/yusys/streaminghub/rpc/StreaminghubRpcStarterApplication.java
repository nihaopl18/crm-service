package com.yusys.streaminghub.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication(scanBasePackages = {"com.yusys.streaminghub.rpc"})
public class StreaminghubRpcStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreaminghubRpcStarterApplication.class, args);
    }

}
