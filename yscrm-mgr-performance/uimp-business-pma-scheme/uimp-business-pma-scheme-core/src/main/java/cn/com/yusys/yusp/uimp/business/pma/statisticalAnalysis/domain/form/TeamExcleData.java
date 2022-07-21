package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sandMan
 * @date 2022/5/15 - 14:55
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TeamExcleData extends BaseRowModel {
    @ExcelProperty(value = "考核周期")
    private String schemeCycle;
    @ExcelProperty(value = "团队编号")
    private String teamId;
    @ExcelProperty(value = "团队名称")
    private String teamName;
    @ExcelProperty(value = "考核方案编号")
    private String schemeId;
    @ExcelProperty(value = "考核方案")
    private String schemeName;
    @ExcelProperty(value = "总评分")
    private String totalScore;
    @ExcelProperty(value = "排名")
    private String totalScoreRank;
}
