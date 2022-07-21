package cn.com.yusys.yusp.dycrm.todowork.service;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * jasypt-spring-boot-starter 生成密文的工具代码
 *
 * @author hujun3
 * @date 2021/09/15 21:53
 **/
public class EncryptConfigUtil {
    public static void main(String[] args) {

        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt
        textEncryptor.setPassword("123456");
//        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("pcrm_app");
        String password = textEncryptor.encrypt("pcrm_app1209");
        System.out.println("username:"+username);
        System.out.println("password:"+password);

        //用户登录密码加密验证
        String pass = "Abc-1234";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String salut = BCrypt.gensalt();
        System.out.println("salut:"+salut);
        final String passHash = encoder.encode(pass);
        System.out.println("passHash:"+passHash);
        final boolean matches = encoder.matches(pass,"$2a$10$Hsovhxs5qwereLi2AA/kWuYILacL9iWYdRKXBA/CWUGwM/xSX.HJK");
        System.out.println(matches);
    }
}