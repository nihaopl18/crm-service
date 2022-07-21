package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.repository.mapper;

import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.dto.PmaFSchemeIndexScoreSumOrg;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.dto.PmaFSchemeIndexScoreSumTeam;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.ManagerAssessForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.OrgAssessForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.OrgExcleData;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.QueryOrgScoreInfoForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreOrgVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreTeamVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.SchemeScoreInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sandMan
 * @date 2022/5/15 - 16:05
 */
public interface PmaFSchemeIndexScoreOrgMapper {
    List<PmaFSchemeIndexScoreOrgVo> orgAssessSelfDesc(OrgAssessForm orgAssessForm);

    List<PmaFSchemeIndexScoreOrgVo> orgAssessSelfAsc(OrgAssessForm orgAssessForm);

    PmaFSchemeIndexScoreSumOrg selectScheme(QueryOrgScoreInfoForm queryOrgScoreInfoForm);

    List<SchemeScoreInfoVo> orgAssessIndexInfoAscAndAsc(@Param("id") String id, @Param("indexId")String indexId);

    List<SchemeScoreInfoVo> orgAssessIndexInfoAscAndDesc(@Param("id")String id, @Param("indexId")String indexId);

    List<SchemeScoreInfoVo> orgAssessIndexInfoDescAndAsc(@Param("id")String id, @Param("indexId")String indexId);

    List<SchemeScoreInfoVo> orgAssessIndexInfoDescAndDesc(@Param("id")String id, @Param("indexId")String indexId);


    List<OrgExcleData> selectAllToExcel(OrgAssessForm orgAssessForm);
}
