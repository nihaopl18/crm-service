package cn.com.yusys.climp.qypool.repository.mapper;

import cn.com.yusys.climp.qypool.domain.LoyAcOrderExAttr;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LoyAcOrderExAttrMapper extends CommonMapper<LoyAcOrderExAttr> {
    List<Map<String,Object>> getAttrByOrderNo(String orderNo);
}
