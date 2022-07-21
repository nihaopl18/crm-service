package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.ManagerAssessForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.MgrExcleData;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.QueryConditionForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.QueryScoreInfoForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreMgrVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.SchemeScoreInfoVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/5/9 - 17:18
 */
public interface PmaFSchemeIndexScoreMgrService {
    /**
     * 查询客户经理的考核评分数据
     * @param queryConditionForm
     * @return
     */
    List<PmaFSchemeIndexScoreMgrVo> mgrAssessSelf(QueryConditionForm queryConditionForm);

    /**
     * 客户经理考核评分详情
     * @param queryConditionForm
     * @return
     */
    List<SchemeScoreInfoVo> mgrAssessIndexInfo(QueryConditionForm queryConditionForm);


    /**
     * 查询所有的客户经理
     * @return
     */
    List<MgrExcleData> selectAll(List<String> managerIdList);

    List<String> getManagerIdList(String userId);

    List<MgrExcleData> selectSelf(String userId);

    void teamAssessExportExcelAll(ManagerAssessForm model, HttpServletRequest request, HttpServletResponse response);
}
