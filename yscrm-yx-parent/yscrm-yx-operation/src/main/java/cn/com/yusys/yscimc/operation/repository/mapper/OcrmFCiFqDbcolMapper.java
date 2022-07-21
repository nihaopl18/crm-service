package cn.com.yusys.yscimc.operation.repository.mapper;

import cn.com.yusys.yscimc.operation.domain.OcrmFCiFqDbcol;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: crm-service
 * @类名称: OcrmFCiFqDbcolMapper
 * @类描述:
 * @功能描述: 数据集管理
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2019年01月14日
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */

@Mapper
public interface OcrmFCiFqDbcolMapper extends CommonMapper<OcrmFCiFqDbcol> {
    String getSeq();

    long getSeqId();

    List<OcrmFCiFqDbcol> qryCollist(QueryModel model);

    List<OcrmFCiFqDbcol> isExist(QueryModel model);

    List<OcrmFCiFqDbcol> qrysetdata(QueryModel model);

    List<OcrmFCiFqDbcol> qryallsetdata(String SQL);

    List<Map<String, Object>> loadData(String id);

    List<Map<String, Object>> prepare(String SQL);

    List<OcrmFCiFqDbcol> getResultList(String SQL);

    List<OcrmFCiFqDbcol> queryColumns(String SQL);

    List<OcrmFCiFqDbcol> queryLeftTab(String SQL);

    List<OcrmFCiFqDbcol> queryJoinColumms(String SQL);

    String getSingleResult(String SQL);

    List<OcrmFCiFqDbcol> getSingleResults(String SQL);

    List<Map<String, Object>> queryResult(QueryModel model);

    int deleteData(OcrmFCiFqDbcol record);

    void insertDbcol(List list);

    List<Map<String, Object>> showcoltype(QueryModel model);

    List<Map<String, Object>> qryLookupcode();

    List<Map<String, Object>> getcodeitem(String lookupCode);

    List<Map<String, Object>> qryCustSta(String custId);

    List<OcrmFCiFqDbcol> getDataSetSolution();

    void deleteByid(String id);

    List<Map<String, Object>> qryCustinfo(String sql);

    int getCount(String sql);

    String queryUserBusiType(@Param(value = "loginCode") String loginCode);

    List<Map<String, String>> existTable(QueryModel model);

    Map<String, Object> getAliasByObjId(String id);

    List<String> getCustIdBySql(@Param("sql") String sql);
}

