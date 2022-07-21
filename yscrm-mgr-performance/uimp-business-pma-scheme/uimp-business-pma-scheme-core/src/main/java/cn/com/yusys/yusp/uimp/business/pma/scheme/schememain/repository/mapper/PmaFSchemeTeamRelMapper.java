package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeTeamRel;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Zhan YongQiang
 * @date: 2022/5/20 11:26
 */
public interface PmaFSchemeTeamRelMapper extends CommonMapper<PmaFSchemeTeamRel> {

    /**
     * 根据考核方案ID删除
     * @param schemeId
     * @return
     */
    int deleteBySchemeId(String schemeId);

    /**
     * 根据考核方案查询
     * @param schemeId
     * @return
     */
    List<Map<String, Object>> selectBySchemeId(String schemeId);

    /**
     * 批量插入
     * @param teamRelList
     */
    void batchInsert(List<PmaFSchemeTeamRel> teamRelList);
}
