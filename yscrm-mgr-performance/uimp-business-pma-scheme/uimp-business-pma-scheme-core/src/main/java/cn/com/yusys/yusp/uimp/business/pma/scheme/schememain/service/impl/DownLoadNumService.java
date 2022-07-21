package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/** 下载任务控制数量服务
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/6/6 11:09
 */
public class DownLoadNumService {

    // 定义计数器的初始值
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    // 定义一个Map做缓存
    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    /**
     * 放入一个任务
     * @param key 任务的key
     * @param value 任务的value
     * @return 如果存在返回value，不存在返回null
     */
    public static String addMap(String key, String value) {
        return map.putIfAbsent(key, value);
    }

    /**
     * 移除一个任务
     * @param key 任务的key
     */
    public static void removeMap(String key) {
        map.remove(key);
    }

    // 获取当前计数器的值
    public static int get() {
        return atomicInteger.get();
    }

    // 将计数器的值加1
    public static int addGet() {
        return atomicInteger.incrementAndGet();
    }

    // 将计数器的值减1
    public static int subGet() {
        return atomicInteger.decrementAndGet();
    }


}
