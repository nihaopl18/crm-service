package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.repository.mapper;

import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.dto.PmaFSchemeIndexScoreSumMgr;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.ManagerAssessForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.MgrExcleData;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.QueryScoreInfoForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreMgrVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.SchemeScoreInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sandMan
 * @date 2022/5/10 - 9:53
 */
public interface PmaFSchemeIndexScoreMgrMapper {
    List<PmaFSchemeIndexScoreMgrVo> mgrAssessSelfDesc(ManagerAssessForm managerAssessForm);
    List<PmaFSchemeIndexScoreMgrVo> mgrAssessSelfAsc(ManagerAssessForm managerAssessForm);
    PmaFSchemeIndexScoreSumMgr selectScheme(QueryScoreInfoForm queryScoreInfoForm);
    List<SchemeScoreInfoVo> mgrAssessIndexInfoAscAndAsc(@Param("id") String id,@Param("indexId")String indexId);

    List<SchemeScoreInfoVo> mgrAssessIndexInfoAscAndDesc(@Param("id") String id,@Param("indexId")String indexId);

    List<SchemeScoreInfoVo> mgrAssessIndexInfoDescAndAsc(@Param("id") String id,@Param("indexId")String indexId);

    List<SchemeScoreInfoVo> mgrAssessIndexInfoDescAndDesc(@Param("id") String id,@Param("indexId")String indexId);

    List<MgrExcleData> selectAll(@Param("managerIdList")List<String> managerIdList);

    List<MgrExcleData> selectSelf(String userId);

    String selectRoleId(String roleCode);

    List<String> selectAllManager(String roleId);

    List<String> selectManagerList(@Param("code") String code, @Param("managerList") List<String> managerList);

    List<MgrExcleData> selectAllExcelData(ManagerAssessForm managerAssessForm);
}
