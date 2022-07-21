package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.repository.mapper;

import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.dto.PmaFSchemeIndexScoreSumMgr;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.dto.PmaFSchemeIndexScoreSumTeam;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.*;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreTeamVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.SchemeScoreInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sandMan
 * @date 2022/5/13 - 16:54
 */
public interface PmaFSchemeIndexScoreTeamMapper {
    List<PmaFSchemeIndexScoreTeamVo> teamAssessSelfDesc(TeamAssessForm teamAssessForm);

    List<PmaFSchemeIndexScoreTeamVo> teamAssessSelfAsc(TeamAssessForm teamAssessForm);

    PmaFSchemeIndexScoreSumTeam selectScheme(QueryTeamScoreInfoForm queryTeamScoreInfoForm);

    List<SchemeScoreInfoVo> teamAssessIndexInfoAscAndAsc(@Param("id") String id, @Param("indexId")String indexId);

    List<SchemeScoreInfoVo> teamAssessIndexInfoAscAndDesc(@Param("id")String id, @Param("indexId")String indexId);

    List<SchemeScoreInfoVo> teamAssessIndexInfoDescAndAsc(@Param("id")String id, @Param("indexId")String indexId);

    List<SchemeScoreInfoVo> teamAssessIndexInfoDescAndDesc(@Param("id")String id, @Param("indexId")String indexId);

    List<String> selectManagerTeam(String orgId);

    List<String> selectManagerTeamList(String userId);


    List<TeamExcleData> selectAllToExcel(TeamAssessForm teamAssessForm);
}
