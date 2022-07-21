//package cn.com.yusys.yusp.kit.data.authority.mybatis.xmltags;
//
//import org.apache.ibatis.reflection.MetaObject;
//import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
//import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
//
//import java.util.Map;
//
///**
// * @description:
// * @author: Zhan YongQiang
// * @date: 2022/4/15 15:39
// */
//public class MapWrapperFactory implements ObjectWrapperFactory {
//    @Override
//    public boolean hasWrapperFor(Object object) {
//        return object != null && object instanceof Map;
//    }
//
//    @Override
//    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
//        return new CustomWrapper(metaObject,(Map)object);
//    }
//}
