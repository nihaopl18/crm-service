//package cn.com.yusys.yusp.kit.data.authority.mybatis.xmltags;
//
//import com.google.common.base.CaseFormat;
//import org.apache.ibatis.reflection.MetaObject;
//import org.apache.ibatis.reflection.wrapper.MapWrapper;
//
//import java.util.Map;
//
///**
// * @description:
// * @author: Zhan YongQiang
// * @date: 2022/4/15 15:37
// */
//public class CustomWrapper extends MapWrapper {
//
//    public CustomWrapper(MetaObject metaObject, Map<String, Object> map) {
//        super(metaObject, map);
//    }
//
//
//    @Override
//    public String findProperty(String name, boolean useCamelCaseMapping) {
//        if(useCamelCaseMapping){
//            return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,name);
//        }
//        return name;
//    }
//}
