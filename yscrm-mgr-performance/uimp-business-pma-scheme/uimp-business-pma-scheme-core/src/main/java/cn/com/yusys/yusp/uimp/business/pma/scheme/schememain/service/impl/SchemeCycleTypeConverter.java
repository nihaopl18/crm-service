package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.impl;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.util.HashMap;

/**
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/5/27 17:41
 */
public class SchemeCycleTypeConverter implements Converter {

    // 周期类型码值定义
    private static final HashMap<String, String> CYCLE_TYPE_MAP = new HashMap<>(16);
    static {
        CYCLE_TYPE_MAP.put("年度", "Y");
        CYCLE_TYPE_MAP.put("半年度", "HY");
        CYCLE_TYPE_MAP.put("季度", "Q");
        CYCLE_TYPE_MAP.put("月度", "M");
    }

    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Object convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return CYCLE_TYPE_MAP.get(cellData.getStringValue());
    }

    @Override
    public CellData convertToExcelData(Object o, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }
}
