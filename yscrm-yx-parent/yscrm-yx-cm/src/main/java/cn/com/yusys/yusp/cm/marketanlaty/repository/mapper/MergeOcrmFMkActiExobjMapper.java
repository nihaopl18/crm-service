package cn.com.yusys.yusp.cm.marketanlaty.repository.mapper;

import cn.com.yusys.yusp.cm.marketanlaty.domain.OcrmFMkActiExobjInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface MergeOcrmFMkActiExobjMapper extends CommonMapper<OcrmFMkActiExobjInfo> {
    /**
     * @方法名称: lastExobjDel
     * @方法描述: 删除上次关联的指标执行对象信息
     * @参数与返回说明:
     * @算法描述:
     **/
    public int lastExobjDel(BigDecimal actiId);

    /**
     * @方法名称: ActiviObjInfo
     * @方法描述: 查询活动执行对象信息
     * @参数与返回说明:
     * @算法描述:
     **/
    public List<Map<String, Object>> ActiviObjInfo(BigDecimal actiId);

}
