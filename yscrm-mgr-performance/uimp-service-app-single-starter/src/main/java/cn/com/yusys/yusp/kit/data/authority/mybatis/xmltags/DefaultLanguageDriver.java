package cn.com.yusys.yusp.kit.data.authority.mybatis.xmltags;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

/**
 * 扩展的自定义{@link XMLLanguageDriver}自定义处理, 主要用于在{@code Mybatis}解析XML文件中SQL信息时的处理
 * @author Cytus_
 * @since 2.4.1
 */
public class DefaultLanguageDriver extends XMLLanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, XNode script, Class<?> parameterType) {
      XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
      return builder.parseScriptNode();
    }

}
