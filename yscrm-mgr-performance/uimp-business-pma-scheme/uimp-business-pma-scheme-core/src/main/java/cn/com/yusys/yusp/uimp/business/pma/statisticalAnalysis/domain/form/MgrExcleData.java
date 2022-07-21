package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sandMan
 * @date 2022/5/12 - 10:54
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor  // 一定要有无参构造方法
public class MgrExcleData extends BaseRowModel {
    @ExcelProperty(value = "考核周期")
    private String schemeCycle;
    @ExcelProperty(value = "客户经理编号")
    private String managerId;
    @ExcelProperty(value = "客户经理姓名")
    private String managerName;
    @ExcelProperty(value = "考核方案编号")
    private String schemeId;
    @ExcelProperty(value = "考核方案")
    private String schemeName;
    @ExcelProperty(value = "总评分")
    private String totalScore;
    @ExcelProperty(value = "排名")
    private String totalScoreRank;
}
