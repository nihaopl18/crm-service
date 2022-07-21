package cn.com.yusys.yusp.admin.license;

import cn.com.yusys.license.LicenseManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Configuration
public class LicenseConfiguration {
	// 日志对象
	private final Logger logger = LoggerFactory.getLogger(LicenseConfiguration.class);
	// 配置信息对象
	private Environment env;

	// License验证模式，默认为PRO
	private String licenseModel = "PRO";

	// License文件名称(可以是文件名称，也可以是包含文件名的绝对路径)
	private String licenseFile = "";

	// License管理对象
	private LicenseManager lManager = LicenseManager.getInstance();

	/**
	 * 构造方法
	 *
	 * @param env
	 *            配置信息对象
	 */
	public LicenseConfiguration(Environment env) {
		this.env = env;
		checkLicense();// 校验License文件是否合法
	}

	/**
	 * 校验License文件
	 */
	private void checkLicense() {
		logger.info("Check License File.");
		this.setLicenseConfig();// 设置License文件的相关配置信息
		lManager.initialize();// 调用License管理对象中的初始化方法，对License文件进行校验
	}

	/**
	 * 设置License文件的相关信息
	 */
	private void setLicenseConfig() {
		// 从配置文件中读取License验证级别及License文件名称
		licenseModel = env.getProperty("license.license-model") == null ? licenseModel
				: env.getProperty("license.license-model");// License验证级别
		licenseFile = env.getProperty("license.license-file") == null ? licenseFile
				: env.getProperty("license.license-file");// License文件名称
		lManager.setLicenseModel(licenseModel);// 设置License验证级别
		lManager.setInputStream(getLicFileInputStream(licenseFile));// 设置License文件名称(绝对路径)
	}

    /**
     * 获取License文件的数据流
     *
     * @param licenseFile
     * @return
     */
    private InputStream getLicFileInputStream(String licenseFile)  {
        File tf = new File(licenseFile);// 创建License文件对象
        InputStream inputStream;
        //License文件配置的是执行目录的相对路径
        if (tf.exists()) {
            logger.debug("License file absolute path:{}" , tf.getAbsolutePath());
            try {
                inputStream = new FileInputStream(tf);
            } catch (FileNotFoundException e) {
                throw new RuntimeException("License文件:" + licenseFile + "读取异常!!!");
            }
        } else {
            //License文件配置的是classpath
            logger.debug("License file relative path:" + licenseFile);
            try {
                Resource resource = new ClassPathResource(licenseFile);
                inputStream = resource.getInputStream();
            } catch (Exception e) {
                throw new RuntimeException("License文件:" + licenseFile + "不存在!!!");
            }
        }
        return inputStream;
    }
}
