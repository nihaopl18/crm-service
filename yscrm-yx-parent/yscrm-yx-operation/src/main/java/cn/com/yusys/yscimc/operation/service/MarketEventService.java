package cn.com.yusys.yscimc.operation.service;

/**
 * @Author Lenovo
 * @Data 2022/2/23 14:07
 */
public interface MarketEventService {

    void realTimeEvent(String jsonData);

    void batchTaskEvent(String jsonData);
}
