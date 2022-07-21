package cn.com.yusys.yscrm.custflexEs.esconfig.pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class EsClientPoolFactory implements PooledObjectFactory<TransportClient> {

    private static Logger log = LoggerFactory.getLogger(EsPool.class);

    private static String name;
	
    @Value("${spring.data.elasticsearch.cluster-name}")
	public void setName(String name) {
    	EsClientPoolFactory.name = name;
	}

    private static String nodes;
	
    @Value("${spring.data.elasticsearch.cluster-nodes}")
	public void setNodes(String nodes) {
    	EsClientPoolFactory.nodes = nodes;
	}
    
    @Override
    //生成pooledObject
    public PooledObject<TransportClient> makeObject() throws Exception {
//        Map<String, String> map = readProperty();
//        if ( map == null ) {
//            log.error("读取es配置信息出现错误，无法创建连接！！！！！！！！！！！！！！！");
//        }
        Settings settings = Settings.builder()
                .put("cluster.name", EsClientPoolFactory.name)
                .put("client.transport.sniff", false)
                .build();
        TransportClient client = null;
        try {
            /**
             * 关闭嗅探机制，指定所有的ES节点，解决日志中相关的超时问题
             * failed to get local cluster state for {#transport#-1}{cAagOGR2SoSZJv5HEBB8GA}{172.xx.xx.xx}{172.xx.xx.xx:9300}, disconnecting...
             **/
            PreBuiltTransportClient preBuiltTransportClient = new PreBuiltTransportClient(settings);
            String[] ps = EsClientPoolFactory.nodes.split(",");
            for ( String key : ps ) {
                String[] tmpStr = key.split(":");
//                preBuiltTransportClient.addTransportAddress(new TransportAddress(InetAddress.getByName(tmpStr[0]),Integer.parseInt(tmpStr[1])));
              preBuiltTransportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(tmpStr[0]),Integer.parseInt(tmpStr[1])));

            }
            client = preBuiltTransportClient;
            // .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(map.get("ip")),Integer.parseInt(map.get("port"))));
        } catch (UnknownHostException e) {
            // e.printStackTrace();
            log.error("错误消息：{}",e.getMessage(),e);
        }
        return new DefaultPooledObject<TransportClient>(client);
    }

//    private static Map<String, String> readProperty() {
//        Properties properties = new Properties();
//        try {
//            properties = PropertiesLoaderUtils.loadAllProperties("config/nosqlConfig.properties");
//            Map<String, String> map = new HashMap<>();
//            map.put("name", new String(properties.getProperty("elasticsearch.cluster.name").getBytes("iso-8859-1"), "gbk"));
//            map.put("ip", new String(properties.getProperty("elasticsearch.cluster.ip").getBytes("iso-8859-1"), "gbk"));
//            map.put("port", new String(properties.getProperty("elasticsearch.cluster.port").getBytes("iso-8859-1"), "gbk"));
//            return map;
//        } catch (IOException e) {
//            // e.printStackTrace();
//            log.error("错误消息：{}",e.getMessage(),e);
//            return null;
//        }
//    }

    @Override
    //销毁对象
    public void destroyObject(PooledObject<TransportClient> pooledObject) throws Exception {
        TransportClient client = pooledObject.getObject();
        client.close();
    }

    @Override
    //验证对象
    public boolean validateObject(PooledObject<TransportClient> pooledObject) {
        return true;
    }

    @Override
    //激活对象
    public void activateObject(PooledObject<TransportClient> pooledObject) throws Exception {
        // System.out.println("activate esClient");
    }

    @Override
    //钝化对象
    public void passivateObject(PooledObject<TransportClient> pooledObject) throws Exception {
        // System.out.println("passivate Object");
    }
}
