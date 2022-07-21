package cn.com.yusys.yusp.commons.util;
import java.security.PrivateKey;
import java.security.PublicKey;
/**
 * BCRSAUtil工具类测试.
 * 
 * <p>
 * resources/cert/如果没有或者为空，测试会有异常信息，可忽略
 * 
 *
 * @since 2.1.1
 */
public class RsaTest {  
    /**
     * 通过key加解密.
     * <p>
     * 注意，该测试，默认读取两个文件: resources/cert/pwd_private.key resources/cert/pwd_public.key
     * 
     */
    public static void testKeyFile() throws Exception {
        String orgString = "dycrm";
        
        System.out.println("原值:" + orgString);
        
        String encryptString = BCRSAUtil.encryptByRSA(orgString);
        
        System.out.println("加密后值:" + encryptString);
        
        String decryptString = BCRSAUtil.decrypt(encryptString);
        
        System.out.println("解密后:" + decryptString);
    }
    public static void main(String[] args) throws Exception {

        System.out.println("测试3:Key文件加解密，加解密测试-----------------");
        testKeyFile();
    }
}