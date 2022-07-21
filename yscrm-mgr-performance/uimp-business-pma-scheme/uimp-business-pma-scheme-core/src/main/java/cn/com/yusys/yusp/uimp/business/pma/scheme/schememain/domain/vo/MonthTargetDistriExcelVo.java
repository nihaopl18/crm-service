package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo;

import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.impl.SchemeCycleTypeConverter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import org.apache.poi.ss.usermodel.BorderStyle;

import java.math.BigDecimal;

/** 目标下发ExcelVo-月
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/5/19 16:53
 */

public class MonthTargetDistriExcelVo extends TargetDistriExcelVo {

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
     * 任务值（一月）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "一月")
    @ContentStyle(borderRight = BorderStyle.NONE)
    private BigDecimal m1Value;
    /**
     * 任务值（二月）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "二月")
    private BigDecimal m2Value;
    /**
     * 任务值（三月）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "三月")
    private BigDecimal m3Value;
    /**
     * 任务值（四月）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "四月")
    private BigDecimal m4Value;
    /**
     * 任务值（五月）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "五月")
    private BigDecimal m5Value;
    /**
     * 任务值（六月）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "六月")
    private BigDecimal m6Value;
    /**
     * 任务值（七月）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "七月")
    private BigDecimal m7Value;
    /**
     * 任务值（八月）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "八月")
    private BigDecimal m8Value;
    /**
     * 任务值（九月）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "九月")
    private BigDecimal m9Value;
    /**
     * 任务值（十月）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "十月")
    private BigDecimal m10Value;
    /**
     * 任务值（十一月）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "十一月")
    private BigDecimal m11Value;
    /**
     * 任务值（十二月）
     */
    @HeadFontStyle()
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "十二月")
    private BigDecimal m12Value;

    public BigDecimal getM1Value() {
        return m1Value;
    }

    public void setM1Value(BigDecimal m1Value) {
        this.m1Value = m1Value;
    }

    public BigDecimal getM2Value() {
        return m2Value;
    }

    public void setM2Value(BigDecimal m2Value) {
        this.m2Value = m2Value;
    }

    public BigDecimal getM3Value() {
        return m3Value;
    }

    public void setM3Value(BigDecimal m3Value) {
        this.m3Value = m3Value;
    }

    public BigDecimal getM4Value() {
        return m4Value;
    }

    public void setM4Value(BigDecimal m4Value) {
        this.m4Value = m4Value;
    }

    public BigDecimal getM5Value() {
        return m5Value;
    }

    public void setM5Value(BigDecimal m5Value) {
        this.m5Value = m5Value;
    }

    public BigDecimal getM6Value() {
        return m6Value;
    }

    public void setM6Value(BigDecimal m6Value) {
        this.m6Value = m6Value;
    }

    public BigDecimal getM7Value() {
        return m7Value;
    }

    public void setM7Value(BigDecimal m7Value) {
        this.m7Value = m7Value;
    }

    public BigDecimal getM8Value() {
        return m8Value;
    }

    public void setM8Value(BigDecimal m8Value) {
        this.m8Value = m8Value;
    }

    public BigDecimal getM9Value() {
        return m9Value;
    }

    public void setM9Value(BigDecimal m9Value) {
        this.m9Value = m9Value;
    }

    public BigDecimal getM10Value() {
        return m10Value;
    }

    public void setM10Value(BigDecimal m10Value) {
        this.m10Value = m10Value;
    }

    public BigDecimal getM11Value() {
        return m11Value;
    }

    public void setM11Value(BigDecimal m11Value) {
        this.m11Value = m11Value;
    }

    public BigDecimal getM12Value() {
        return m12Value;
    }

    public void setM12Value(BigDecimal m12Value) {
        this.m12Value = m12Value;
    }


    @Override
    public String toString() {
        return "MonthTargetDistriExcelVo{" +
                "years='" + years + '\'' +
                ", schemeId='" + schemeId + '\'' +
                ", schemeName='" + schemeName + '\'' +
                ", evlObjId='" + evlObjId + '\'' +
                ", evlObjName='" + evlObjName + '\'' +
                ", indexId='" + indexId + '\'' +
                ", indexName='" + indexName + '\'' +
                ", schemeCycleType='" + schemeCycleType + '\'' +
                ", evlObjType='" + evlObjType + '\'' +
                ", m1Value=" + m1Value +
                ", m2Value=" + m2Value +
                ", m3Value=" + m3Value +
                ", m4Value=" + m4Value +
                ", m5Value=" + m5Value +
                ", m6Value=" + m6Value +
                ", m7Value=" + m7Value +
                ", m8Value=" + m8Value +
                ", m9Value=" + m9Value +
                ", m10Value=" + m10Value +
                ", m11Value=" + m11Value +
                ", m12Value=" + m12Value +
                '}';
    }
}
