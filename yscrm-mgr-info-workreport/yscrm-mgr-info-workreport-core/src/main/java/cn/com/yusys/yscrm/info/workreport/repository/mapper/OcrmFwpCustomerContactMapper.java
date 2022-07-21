package cn.com.yusys.yscrm.info.workreport.repository.mapper;

import cn.com.yusys.yscrm.info.workreport.domain.OcrmFwpCustomerContact;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: yscrm-mgr-info-workreport-core模块
 * @类名称: OcrmFwpWorkReportMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-28 20:32:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpCustomerContactMapper extends CommonMapper<OcrmFwpCustomerContact> {

    int deleteByWorkReportIds(Map<String, Object> map);

    List<Map<String, Object>> selectByWorkReportId(@Param("workReportIds") String[] workReportId,@Param("isDelete") String isDelete);

    int updateCustomerContact(OcrmFwpCustomerContact ocrmFwpCustomerContact);

    void updateStatus(@Param("workReportId")String workReportId, @Param("isDraft") String s);

    List<Map<String, Object>> queryConTact(QueryModel queryModel);

    int deleteByWorkReportIdsAndSource(Map<String, Object> map);

    int deletecustomerContact(Map<String, String> map);
}