package cn.com.yusys.yscrm.custflexEs.esconfig.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



/**
 * @version v1.0
 * @ProjectName: demo
 * @ClassName: EsConfig
 * @Description: TODO(一句话描述该类的功能)
 * @Author: sakura
 * @Date: 2020/8/2 19:16
 */
@Component
public class EsPool {

    private static Logger log = LoggerFactory.getLogger(EsPool.class);

    private static GenericObjectPool pool = getPool();

    private EsPool(){};

    public static synchronized GenericObjectPool getInstance() {
        if(pool == null) {
            synchronized (EsPool.class) {
                if(pool == null) {
                    log.info("重新创建es连接池");
                    pool = EsPool.getPool();
                }
            }
        }
        return pool;
    }

    private static GenericObjectPool getPool() {
//        Map<String, String> map = readProperty();
//        if ( map == null ) {
//            log.error("读取es配置信息出现错误，无法创建连接池！！！！！！！！！！！！！！！");
//        }
        log.info("开始创建连接");
        //对象池配置类，不写也可以，采用默认配置
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        //采用默认配置maxTotal是8，池中有8个client
        poolConfig.setMaxTotal(8);
        poolConfig.setMinIdle(0);
        poolConfig.setMaxIdle(8);
        // 最大等待时间，-1表示一直等
        poolConfig.setMaxWaitMillis(2000);
        // 当对象池没有空闲对象时，新的获取对象的请求是否阻塞。true阻塞。默认值是true
        poolConfig.setBlockWhenExhausted(true);
        // 在从对象池获取对象时是否检测对象有效，true是；默认值是false
        poolConfig.setTestOnBorrow(true);
        // 在向对象池中归还对象时是否检测对象有效，true是，默认值是false
        poolConfig.setTestOnReturn(true);
        // 在检测空闲对象线程检测到对象不需要移除时，是否检测对象的有效性。true是，默认值是false
        poolConfig.setTestWhileIdle(true);
        // 可发呆的时间,10mins
        poolConfig.setMinEvictableIdleTimeMillis( 10 * 30 * 1000 );
        // 发呆过长移除的时候是否test一下先
        poolConfig.setTestWhileIdle(false);
        // 每60秒检查一次空闲连接
        poolConfig.setTimeBetweenEvictionRunsMillis( 3 * 60 * 1000);
        // 连接保持的最小时间，超出后将被移除
        poolConfig.setSoftMinEvictableIdleTimeMillis( 10 * 60 * 1000 );
        //要池化的对象的工厂类，这个是我们要实现的类
        EsClientPoolFactory esClientPoolFactory = new EsClientPoolFactory();
        //利用对象工厂类和配置类生成对象池
        GenericObjectPool<TransportClient> clientPool = new GenericObjectPool<>(esClientPoolFactory,poolConfig);
        log.info("连接创建完成");
        log.info("连接池当前活跃连接为" + clientPool.getNumActive());
        return clientPool;
    };

//    private static Map<String, String> readProperty() {
//        Properties properties = new Properties();
//        try {
//            properties = PropertiesLoaderUtils.loadAllProperties("config/nosqlConfig.properties");
//            Map<String, String> map = new HashMap<>();
//            map.put("MaxTotal", new String(properties.getProperty("elasticsearch.pool.MaxTotal").getBytes("iso-8859-1"), "gbk"));
//            map.put("MinIdle", new String(properties.getProperty("elasticsearch.pool.MinIdle").getBytes("iso-8859-1"), "gbk"));
//            map.put("MaxIdle", new String(properties.getProperty("elasticsearch.pool.MaxIdle").getBytes("iso-8859-1"), "gbk"));
//            map.put("MaxWaitMillis", new String(properties.getProperty("elasticsearch.pool.MaxWaitMillis").getBytes("iso-8859-1"), "gbk"));
//            return map;
//        } catch (IOException e) {
//            // e.printStackTrace();
//            log.error("错误消息：{}",e.getMessage(),e);
//            return null;
//        }
//    }

}
