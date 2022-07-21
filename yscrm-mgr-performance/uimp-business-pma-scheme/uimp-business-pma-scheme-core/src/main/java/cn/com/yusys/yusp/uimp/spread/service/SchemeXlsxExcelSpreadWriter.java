package cn.com.yusys.yusp.uimp.spread.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.yuchengtech.report.frame.spreadjs.entity.DataTable;
import com.yuchengtech.report.frame.spreadjs.entity.DataTableProperty;
import com.yuchengtech.report.frame.spreadjs.entity.DataTablePropertyProperty;
import com.yuchengtech.report.frame.spreadjs.service.XlsxExcelSpreadWriter;

public class SchemeXlsxExcelSpreadWriter extends XlsxExcelSpreadWriter {

	public SchemeXlsxExcelSpreadWriter(File file) throws FileNotFoundException {
		super(file);
	}

	@Override
	protected void createBody(Sheet ssheet, DataTable dataTable) {
		Map<String, DataTableProperty> dtps = dataTable.getAdditionalProperties();
		for (String rowIndex : dtps.keySet()) {
			Row row = ssheet.createRow(NumberUtils.toInt(rowIndex));
			Map<String, Object> dtpps = ((DataTableProperty) dtps.get(rowIndex)).getAdditionalProperties();
			for (String colIndex : dtpps.keySet()) {
				Object obj = dtpps.get(colIndex);
				if ((obj != null) && (obj instanceof DataTablePropertyProperty)) {
					DataTablePropertyProperty dtpp = (DataTablePropertyProperty) obj;
					Cell cell = row.createCell(NumberUtils.toInt(colIndex));
					setCellStyle(cell, dtpp.getStyle());
					setCellValue(cell, dtpp.getValue());
					if ((dtpp.getFormula() != null) && (StringUtils.isNotBlank(dtpp.getFormula()))) {
						// formula单元格赋值时公式内容第一个字符不允许是=等号
						cell.setCellFormula(dtpp.getFormula().indexOf("=") == 0 ? dtpp.getFormula().substring(1) : dtpp.getFormula());
					}
				}
			}
		}
		ssheet.setForceFormulaRecalculation(true);
	}
	
}
