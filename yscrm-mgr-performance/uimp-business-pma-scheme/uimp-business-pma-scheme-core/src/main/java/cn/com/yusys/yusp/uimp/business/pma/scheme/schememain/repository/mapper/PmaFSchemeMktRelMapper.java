package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeMktRel;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Zhan YongQiang
 * @date: 2022/5/20 10:46
 */
public interface PmaFSchemeMktRelMapper extends CommonMapper<PmaFSchemeMktRel> {

    /**
     * 根据考核方案删除
     * @param schemeId
     * @return
     */
    int deleteBySchemeId(String schemeId);

    /**
     * 根据考核对象查询客户经理和考核方案关系
     * @param schemeId
     * @return
     */
    List<Map<String,Object>> selectBySchemeId(String schemeId);

    /**
     * 批量插入考核方案和客户经理关系
     * @param list
     * @return
     */
    int batchInsert(List<PmaFSchemeMktRel> list);
}
