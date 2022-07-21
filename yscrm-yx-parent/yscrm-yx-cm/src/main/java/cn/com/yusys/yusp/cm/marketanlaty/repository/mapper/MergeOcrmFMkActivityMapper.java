package cn.com.yusys.yusp.cm.marketanlaty.repository.mapper;

import cn.com.yusys.yusp.cm.marketanlaty.domain.OcrmFMkActiTargetInfo;
import cn.com.yusys.yusp.cm.marketanlaty.domain.OcrmFMkActivityInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkActivityMapper
 * @类描述：营销活动管理
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-24
 */
public interface MergeOcrmFMkActivityMapper extends CommonMapper<OcrmFMkActivityInfo> {
    /**
     * @方法名称: actiListQuery
     * @方法描述: 营销活动信息查询
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> actiListQuery(QueryModel model);

    /**
     * @方法名称: myActiListQuery
     * @方法描述: 我的营销活动信息查询
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> myActiListQuery(QueryModel model);

    /**
     * @方法名称: actiProdListQuery
     * @方法描述: 营销活动关联产品信息查询
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> actiProdListQuery(QueryModel model);

    /**
     * @方法名称: actiCustListQuery
     * @方法描述: 营销活动关联客户信息查询
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> actiCustListQuery(QueryModel model);

    /**
     * @方法名称: actiOrgTargetListQuery
     * @方法描述: 营销成效指标查询-机构类
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> actiOrgTargetListQuery(QueryModel model);

    /**
     * @方法名称: actiUserTargetListQuery
     * @方法描述: 营销成效指标查询-用户类
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> actiUserTargetListQuery(QueryModel model);

    /**
     * @方法名称: actiFileListQuery
     * @方法描述: 营销活动附件信息查询
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> actiFileListQuery(QueryModel model);

    /**
     * @方法名称: actiTargetInsert
     * @方法描述: 营销成效指标新增
     * @参数与返回说明:
     * @算法描述:
     **/
    public int actiTargetInsert(OcrmFMkActiTargetInfo record);

    /**
     * @方法名称: actiDel
     * @方法描述: 营销产品删除
     * @参数与返回说明:
     * @算法描述:
     **/
    public int actiDel(BigDecimal actiId);

    /**
     * @方法名称: delTargetByOrg
     * @方法描述: 删除机构下对应的指标设置数据
     * @参数与返回说明:
     * @算法描述:
     **/
    public int delTargetByOrg(Map<String, Object> param);

    /**
     * @方法名称: delTargetObjByOrg
     * @方法描述: 删除机构下对应的指标执行对象信息
     * @参数与返回说明:
     * @算法描述:
     **/
    public int delTargetObjByOrg(Map<String, Object> param);

    /**
     * @方法名称: actiRelease
     * @方法描述: 营销活动下达
     * @参数与返回说明:
     * @算法描述:
     **/
    public int actiRelease(Map<String, Object> param);

    /**
     * @方法名称: actiCustDcom
     * @方法描述: 修改关联客户表的主办经理
     * @参数与返回说明:
     * @算法描述:
     **/
    public int actiCustDcom(Map<String, Object> param);

    /**
     * @方法名称: actiCustTaskObj
     * @方法描述: 修改指标执行对象数据
     * @参数与返回说明:
     * @算法描述:
     **/
    public int actiCustTaskObj(Map<String, Object> param);

    /**
     * @方法名称: actiCustTaskInfo
     * @方法描述: 修改指标数据中的执行对象信息
     * @参数与返回说明:
     * @算法描述:
     **/
    public int actiCustTaskInfo(Map<String, Object> param);

    /**
     * @方法名称: actiApproval
     * @方法描述: 营销活动提交
     * @参数与返回说明:
     * @算法描述:
     **/
    public int actiApproval(OcrmFMkActivityInfo record);

    /**
     * @方法名称: actiExecute
     * @方法描述: 营销活动执行
     * @参数与返回说明:
     * @算法描述:
     **/
    public int actiExecute(OcrmFMkActivityInfo record);

    /**
     * @方法名称: actiUpSuccess
     * @方法描述: 营销活动审批成功
     * @参数与返回说明:
     * @算法描述:
     **/
    public int actiUpSuccess(OcrmFMkActivityInfo record);

    /**
     * @方法名称: actiUpFailed
     * @方法描述: 营销活动审批失败
     * @参数与返回说明:
     * @算法描述:
     **/
    public int actiUpFailed(OcrmFMkActivityInfo record);

    /**
     * @方法名称: actiOff
     * @方法描述: 营销活动关闭
     * @参数与返回说明:
     * @算法描述:
     **/
    public int actiOff(OcrmFMkActivityInfo record);

    /**
     * @方法名称: actiSameName
     * @方法描述: 营销活动名称验重
     * @参数与返回说明:
     * @算法描述:
     **/
    public int actiSameName(OcrmFMkActivityInfo record);

    /**
     * @方法名称: cmMonitor
     * @方法描述: 客户经理监控
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> cmMonitor(QueryModel model);

    /**
     * @方法名称: cmMonitorRelation
     * @方法描述: 客户经理监控执行中数
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> cmMonitorRelation(QueryModel model);

    /**
     * @方法名称: cmMonitorSuccess
     * @方法描述: 客户经理监控成功数
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> cmMonitorSuccess(QueryModel model);

    /**
     * @方法名称: cmMonitorFail
     * @方法描述: 客户经理监控失败数
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> cmMonitorFail(QueryModel model);

    /**
     * @方法名称: orgMonitor
     * @方法描述: 机构监控
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> orgMonitor(QueryModel model);

    /**
     * @方法名称: orgMonitorRelation
     * @方法描述: 机构监控执行中数
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> orgMonitorRelation(QueryModel model);

    /**
     * @方法名称: orgMonitorSuccess
     * @方法描述: 机构监控成功数
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> orgMonitorSuccess(QueryModel model);

    /**
     * @方法名称: orgMonitorFail
     * @方法描述: 机构监控失败数
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> orgMonitorFail(QueryModel model);

    /**
     * @方法名称: actiMonitor
     * @方法描述: 活动监控
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> actiMonitor(QueryModel model);

    /**
     * @方法名称: actiMonitorRelation
     * @方法描述: 活动监控执行中数
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> actiMonitorRelation(QueryModel model);

    /**
     * @方法名称: actiMonitorSuccess
     * @方法描述: 活动监控成功数
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> actiMonitorSuccess(QueryModel model);

    /**
     * @方法名称: actiMonitorFail
     * @方法描述: 活动监控失败数
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> actiMonitorFail(QueryModel model);

    /**
     * @方法名称: getActiById
     * @方法描述: 返回活动数据
     * @参数与返回说明:
     * @算法描述:
     **/
    public OcrmFMkActivityInfo getActiById(BigDecimal actiId);

    /**
     * @方法名称: getSonNode
     * @方法描述: 返回子活动信息
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> getSonNode(BigDecimal actiId);

    /**
     * @方法名称: actiTree
     * @方法描述: 营销活动分析树
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> actiTree(QueryModel model);

    /**
     * @方法名称: getSeq
     * @方法描述: 返回自增序列
     * @参数与返回说明:
     * @算法描述:
     **/
    public BigDecimal getSeq();
}