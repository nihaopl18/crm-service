package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexScore;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexScoreParam;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaScoreModelParams;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.PamScoreParamVo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.PmaScoreIndexVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @description: 考核方案评分模型数据持久化处理类
 * @author: Zhan YongQiang
 * @date: 2022/4/2 15:55
 */
public interface PmaFSchemeIndexScoreMapper extends CommonMapper<PmaFSchemeIndexScore> {

    /**
     * 查询所有可用的评分模型
     * @return
     */
    List<Map<String,Object>> queryAllScoreInfo();

    /**
     * 统计指标的评分数量
     * @param indexId
     * @return
     */
    int countByIndexId(@Param("schemeId")String schemeId,@Param("indexId")String indexId,@Param("applyType") String applyType, @Param("balType")String balType,@Param("evlObjType") String evlObjType);




    /**
     * 根据模型ID查询它使用的参数
     * @param scoreId 评分模型ID
     * @return
     */
    List<PmaScoreModelParams> queryParamsByModelId(@Param("scoreId") String scoreId);

    /**
     * 批量查询评分模型信息
     * @param list
     */
    void batchInsert(List<PmaFSchemeIndexScore> list);

    /**
     * 批量插入模型参数数据
     * @param list
     */
    void batchInsertParams(List<PmaFSchemeIndexScoreParam> list);


    /**
     * 根据考核方案ID和指标ID查询评分模型
     * @param schemeId
     * @param indexId
     * @return
     */
    List<PmaScoreIndexVo> queryScoreBySchemeId(@Param("schemeId")String schemeId,@Param("indexId") String indexId,@Param("applyTypeId") String applyTypeId,@Param("balTypeId") String balTypeId,@Param("evlObjType") String evlObjType);

    /**
     * 根据考核方案ID、指标ID、评分模型ID查询评分模型参数配置
     * @param schemeId
     * @param indexId
     * @param scoreModelId
     * @return
     */
    List<PamScoreParamVo> queryFSchemeScoreParams(@Param("schemeId") String schemeId,@Param("indexId") String indexId,@Param("scoreModelId")String scoreModelId,@Param("applyTypeId") String applyTypeId,@Param("balTypeId") String balTypeId,@Param("evlObjType") String evlObjType);

    /**
     * 根据考核方案ID、指标ID、评分模型ID删除评分模型参数配置
     * @param schemeId
     * @param indexId
     * @param scoreModelId
     */
    void deleteScoreParamByModelId(@Param("schemeId")String schemeId,@Param("indexId")String indexId,@Param("scoreModelId") String scoreModelId, @Param("applyTypeId") String applyTypeId,@Param("balTypeId") String balTypeId,@Param("evlObjType") String evlObjType);

    /**
     * 根据考核方案ID删除评分模型
     * @param schemeId
     * @param indexId
     */
    void deleteScoreBySchemeId(@Param("schemeId") String schemeId,@Param("indexId")String indexId, @Param("applyTypeId") String applyTypeId,@Param("balTypeId") String balTypeId,@Param("evlObjType") String evlObjType);

    /**
     * 根据考核方案ID查询机构编号
     * @param schemeId
     * @return
     */
    List<String> selectOrgIdBySchemeId(String schemeId);

    /**
     * 根据考核方案ID查询团队ID
     * @param schemeId
     * @return
     */
    List<String> selectTeamIdBySchemeId(String schemeId);

    /**
     * 根据考核方案ID查询关联的客户经理ID
     * @param schemeId
     * @return
     */
    List<String> selectMtkIdBySchemeId(String schemeId);


    /**
     * 根据考核方案ID 查询评分权重之和
     * @param schemeId 考核方案ID
     * @return
     */
    String selectTotalWeight(String schemeId);
}
