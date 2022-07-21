/*
 * 代码生成器自动生成的
 * Since 2008 - 2019
 *
 */
package cn.com.yusys.yscrm.custservice.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.custservice.domain.OcrmFciCustFeedbackInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import  cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * @项目名称: demo模块
 * @类名称: OcrmFciCustFeedbackInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: 23378
 * @创建时间: 2019-02-11 16:49:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciCustFeedbackInfo1Mapper extends CommonMapper<OcrmFciCustFeedbackInfo>{

   
    List<OcrmFciCustFeedbackInfo> queryAll(QueryModel model);
    
    List<OcrmFciCustFeedbackInfo> queryPer(QueryModel model);
    List<Map<String,String>> queryOrgId(@Param("orgId") String orgId);
    String queryProp(String value);
}