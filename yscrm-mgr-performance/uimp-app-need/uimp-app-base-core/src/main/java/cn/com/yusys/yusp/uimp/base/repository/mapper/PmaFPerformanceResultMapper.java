package cn.com.yusys.yusp.uimp.base.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 考核指标事实表
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-05-11 15:43:46
 */
@Mapper
public interface PmaFPerformanceResultMapper {

    /**
     * 根据指标编号与考核对象查询方案与指标关系信息
     * @param schemeId 方案编号
     * @param evlObjType 考核对象类型
     * @return 指标关系信息
     */
    List<Map<String, Object>> getRelationListByType(@Param("schemeId") String schemeId,@Param("evlObjType") String evlObjType);

    /**
     * 根据指标编号与考核对象查询方案与指标关系信息
     * @param schemeId 方案编号
     * @param evlObjType 考核对象类型
     * @return 指标关系信息
     */
    List<Map<String, Object>> getRelationListByTypeInIds(@Param("schemeId") String schemeId,@Param("evlObjType") String evlObjType,@Param("ids") List<String> ids);

    /**
     * 查询考核指标事实表-团队编号
     * @param model 查询条件
     * @return 考核指标事实表-团队编号
     */
    List<String> getTeamIdInfoByTeam(QueryModel model);

    /**
     * 通过编号查询考核指标事实表-团队考核结果信息
     */
    List<Map<String, Object>> getRusultByTeam(@Param("schemeId") String schemeId,@Param("list") List<String> list);

    /**
     * 通过查询条件查询出客户经理编号
     */
    List<String> getMgrIdInfoByMgr(QueryModel model);

    /**
     * 通过考核经理编号与考核方案编号查询考核指标事实表-客户经理考核结果信息
     */
    List<Map<String, Object>> getRusultByMgr(@Param("schemeId") String schemeId,@Param("list") List<String> list);

    /**
     * 通过考核方案编号查询考核指标事实表-机构考核结果信息
     */
    List<String> getOrgIdInfoByOrg(QueryModel model);

    /**
     * 通过考核方案编号与机构编号查询考核指标事实表-机构考核结果信息
     */
    List<Map<String, Object>> getRusultByOrg(@Param("schemeId") String schemeId,@Param("list") List<String> list);
}
