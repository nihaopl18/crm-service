package cn.com.yusys.yusp.uimp.spread.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.yuchengtech.report.frame.spreadjs.service.ISpreadWriter;
import com.yuchengtech.report.frame.spreadjs.service.PdfSpreadWriter;
import com.yuchengtech.report.frame.spreadjs.service.XlsExcelSpreadWriter;
import com.yuchengtech.report.frame.spreadjs.service.XlsxExcelSpreadWriter;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: SchemeSpreadWriterFactory
 * @类描述: # 考核方案-excel导出工厂类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-07-01 15:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class SchemeSpreadWriterFactory {
	
	public static ISpreadWriter createWriter(String type, File file) throws IOException, InvalidFormatException {
		if (!file.exists()) {
			file.createNewFile();
		}
		if (StringUtils.equals(type, "xls")) {
			return new XlsExcelSpreadWriter(file);
		}
		if (StringUtils.equals(type, "xlsx")) {	// 考核方案-默认导出xlsx文件
			return new SchemeXlsxExcelSpreadWriter(file);
		}
		if (StringUtils.equals(type, "pdf")) {
			return new PdfSpreadWriter(file, null, null);
		}
		return new XlsxExcelSpreadWriter(file);
	}
}
