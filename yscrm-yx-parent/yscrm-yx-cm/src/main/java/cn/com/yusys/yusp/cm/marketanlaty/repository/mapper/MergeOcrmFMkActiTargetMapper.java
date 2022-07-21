package cn.com.yusys.yusp.cm.marketanlaty.repository.mapper;

import cn.com.yusys.yusp.cm.marketanlaty.domain.OcrmFMkActiTargetInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkActiTargetMapper
 * @类描述：营销活动指标管理
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-28
 */
public interface MergeOcrmFMkActiTargetMapper extends CommonMapper<OcrmFMkActiTargetInfo> {
    /**
     * @方法名称: targetList
     * @方法描述: 查询标签表
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> targetList(QueryModel model);

    /**
     * @方法名称: getSeq
     * @方法描述: 返回自增序列
     * @参数与返回说明:
     * @算法描述:
     **/
    public BigDecimal getSeq();

    /**
     * @方法名称: lastTargetDel
     * @方法描述: 删除上次关联的指标
     * @参数与返回说明:
     * @算法描述:
     **/
    public int lastTargetDel(BigDecimal actiId);

    /**
     * @方法名称: ActiviTargetByActivity
     * @方法描述: 查询活动指标信息
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> ActiviTargetByActivity(@Param("actiId") BigDecimal actiId);

    /**
     * @方法名称: ActiviTargetByObj
     * @方法描述: 查询执行对象指标信息
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> ActiviTargetByObj(Map<String, Object> param);

    /**
     * @方法名称: getTargetPie
     * @方法描述: 营销成效指标目标机构占比图
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> getTargetPie(QueryModel model);

    /**
     * @方法名称: getTargetBar
     * @方法描述: 营销成效指标目标机构完成情况对比图
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> getTargetBar(QueryModel model);

    /**
     * @方法名称: getCmBar
     * @方法描述: 营销成效指标目标客户经理进展图
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> getCmBar(QueryModel model);

    /**
     * @方法名称: getCmPie
     * @方法描述: 营销成效指标目标客户经理占比图
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> getCmPie(QueryModel model);
}
