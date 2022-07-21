package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;

import java.math.BigDecimal;

/** 目标下发ExcelVo-季度
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/5/19 16:53
 */

public class QuarterTargetDistriExcelVo extends TargetDistriExcelVo {

    /**
     * 年份
     */
    @HeadFontStyle()
    @ExcelProperty(value = "年份")
    @ColumnWidth(value = 8)
    private String years;
    /**
     * 考核方案ID
     */
    @HeadStyle(hidden = true)
    @ContentStyle(hidden = true)
    @ColumnWidth(value = 0)
    @ExcelProperty(value = "考核方案ID")
    private String schemeId;
    /**
     * 考核方案名称
     */
    @HeadFontStyle()
    @ColumnWidth(value = 30)
    @ExcelProperty(value = "考核方案名称")
    private String schemeName;
    /**
     * 考核对象ID
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "考核对象编号")
    private String evlObjId;
    /**
     * 考核对象名称
     */
    @HeadFontStyle()
    @ColumnWidth(value = 30)
    @ExcelProperty(value = "考核对象名称")
    private String evlObjName;
    /**
     * 指标编号
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "指标编号")
    private String indexId;
    /**
     * 指标名称
     */
    @HeadFontStyle()
    @ColumnWidth(value = 30)
    @ExcelProperty(value = "指标名称")
    private String indexName;
    /**
     * 考核周期类型
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "考核周期类型")
    private String schemeCycleType;
    /**
     * 考核对象类型
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "考核对象类型")
    private String evlObjType;

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getEvlObjId() {
        return evlObjId;
    }

    public void setEvlObjId(String evlObjId) {
        this.evlObjId = evlObjId;
    }

    public String getEvlObjName() {
        return evlObjName;
    }

    public void setEvlObjName(String evlObjName) {
        this.evlObjName = evlObjName;
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getSchemeCycleType() {
        return schemeCycleType;
    }

    public void setSchemeCycleType(String schemeCycleType) {
        this.schemeCycleType = schemeCycleType;
    }

    public String getEvlObjType() {
        return evlObjType;
    }

    public void setEvlObjType(String evlObjType) {
        this.evlObjType = evlObjType;
    }

    /**
     * 任务值（第一季度）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "第一季度")
    private BigDecimal q1Value;
    /**
     * 任务值（第二季度）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "第二季度")
    private BigDecimal q2Value;
    /**
     * 任务值（第三季度）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "第三季度")
    private BigDecimal q3Value;
    /**
     * 任务值（第四季度）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "第四季度")
    private BigDecimal q4Value;

    public BigDecimal getQ1Value() {
        return q1Value;
    }

    public void setQ1Value(BigDecimal q1Value) {
        this.q1Value = q1Value;
    }

    public BigDecimal getQ2Value() {
        return q2Value;
    }

    public void setQ2Value(BigDecimal q2Value) {
        this.q2Value = q2Value;
    }

    public BigDecimal getQ3Value() {
        return q3Value;
    }

    public void setQ3Value(BigDecimal q3Value) {
        this.q3Value = q3Value;
    }

    public BigDecimal getQ4Value() {
        return q4Value;
    }

    public void setQ4Value(BigDecimal q4Value) {
        this.q4Value = q4Value;
    }

}
