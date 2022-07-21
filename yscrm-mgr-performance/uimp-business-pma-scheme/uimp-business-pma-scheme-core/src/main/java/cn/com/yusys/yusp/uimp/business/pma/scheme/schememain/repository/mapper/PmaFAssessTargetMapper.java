package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFAssessTargetEntity;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.PmaFAssessTargetVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 考核目标下发表;考核目标下发表
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-05-19 17:41:11
 */
@Component
public interface PmaFAssessTargetMapper extends Mapper<PmaFAssessTargetEntity> {

    /**
     * 根据考核方案编号获取考核的客户经理信息
     * @param schemeId 考核方案编号
     * @param orgId 机构编号
     * @param objList 指定考核对象编号
     * @return 考核客户经理信息
     */
    List<Map<String, Object>> getExportMgrBySchemeId(@Param("schemeId") String schemeId,@Param("orgId") String orgId,@Param("objList") List<String> objList);

    /**
     * 根据考核方案编号获取考核的客户经理团队信息
     * @param schemeId 考核方案编号
     * @param orgId 机构编号
     * @param objList 指定考核对象编号
     * @return 考核客户经理团队信息
     */
    List<Map<String, Object>> getExportTeamBySchemeId(@Param("schemeId") String schemeId,@Param("orgId") String orgId,@Param("objList") List<String> objList);

    /**
     * 根据考核方案编号获取考核的机构信息
     * @param schemeId 考核方案编号
     * @param orgId 机构编号
     * @param objList 指定考核对象编号
     * @return 考核机构信息
     */
    List<Map<String, Object>> getExportOrgBySchemeId(@Param("schemeId") String schemeId,@Param("orgId") String orgId,@Param("objList") List<String> objList);

    /**
     * 查询与考核方案关联的客户经理信息
     * @param model 查询条件
     * @return 客户经理信息
     */
    List<Map<String, Object>> getMgrBySchemeId(QueryModel model);

    /**
     * 查询考核下发目标信息
     * @param model 查询条件
     * @param objList 指定考核对象编号
     * @param indexList 指定考核对象
     * @return 考核下发目标信息
     */
    List<PmaFAssessTargetVo> getList(@Param("model") QueryModel model, @Param("objList") List<String> objList, @Param("indexList") List<String> indexList);

    /**
     * 批量新增或删除考核下发目标信息
     * @param list 考核下发目标信息
     */
    void upsert(List<PmaFAssessTargetEntity> list);

    /**
     * 查询与考核方案关联的客户经理团队信息
     * @param model 查询条件
     * @return 客户经理团队信息
     */
    List<Map<String, Object>> getTeamBySchemeId(QueryModel model);
}
