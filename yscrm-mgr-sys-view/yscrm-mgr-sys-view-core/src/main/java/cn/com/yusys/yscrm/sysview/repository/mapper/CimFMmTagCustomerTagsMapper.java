package cn.com.yusys.yscrm.sysview.repository.mapper;

import cn.com.yusys.yscrm.sysview.domain.CimFTagCustTags;
import cn.com.yusys.yscrm.sysview.domain.CustSysGroup;
import cn.com.yusys.yscrm.sysview.domain.CustSysTag;
import cn.com.yusys.yscrm.sysview.domain.CustomTag;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *  客户标签
 */
public interface CimFMmTagCustomerTagsMapper extends CommonMapper<CimFTagCustTags> {
    /**
     *设置标签是否展示
     * @param map
     * @return
     */
    int updateTagDisplay(Map<String, Object> map);

    List<CustSysGroup> custSysTag(QueryModel queryModel);


    Integer removecusttag(@Param("tagNo") String tagNo, @Param("custId") String custId);
}
