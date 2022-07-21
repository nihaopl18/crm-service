package cn.com.yusys.yusp.kit.data.authority.mybatis.xmltags;

import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.Configuration;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.autoconfigure.ConfigurationCustomizer;

/**
 * 自定义{@code Mybatis}的{@link Configuration}对象中的某些属性, 用于扩展处理, 该处主要自定义了默认的{@link LanguageDriver}对象,
 * 用于处理自定义的占位符方式, 将其在解析时替换成{@code Mybatis}的$占位符方式
 * @author Cytus_
 * @since 2.4.1
 */
@Component
public class CustomizedConfiguration implements ConfigurationCustomizer {

    @Override
    public void customize(Configuration configuration) {
        configuration.getLanguageRegistry().setDefaultDriverClass(DefaultLanguageDriver.class);
    }

}
