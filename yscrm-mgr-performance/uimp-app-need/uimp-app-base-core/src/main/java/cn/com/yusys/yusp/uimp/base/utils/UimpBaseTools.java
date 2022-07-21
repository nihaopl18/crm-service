package cn.com.yusys.yusp.uimp.base.utils;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UimpBaseTools {
	
	private Pattern linePattern = Pattern.compile("_(\\w)");

	/**
	 * 下划线转驼峰
	 */
	public String lineToHump(String str) {
		str = str.toLowerCase();
		Matcher matcher = linePattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)})
	 */
	public String humpToLine(String str) {
		return str.replaceAll("[A-Z]", "_$0").toLowerCase();
	}

	private Pattern humpPattern = Pattern.compile("[A-Z]");

	/**
	 * 驼峰转下划线,效率比上面高
	 */
	public String humpToLine2(String str) {
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 功能：设置2007以及以上版本单元格风格的属性
	 */
	public CellStyle SetXCellStyleAttribute(int stylenum, CellStyle style, Font font) {
		switch (stylenum) {
		// 单元格格式一:水平居中，垂直居中
		case 1:
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setBorderBottom(BorderStyle.THIN); // 下边框
			style.setBorderLeft(BorderStyle.THIN);// 左边框
			style.setBorderTop(BorderStyle.THIN);// 上边框
			style.setBorderRight(BorderStyle.THIN);// 右边框
			style.setFont(font);

			break;
		// 单元格格式二:水平居中，垂直居中，有边框
		case 2:
			style.setAlignment(HorizontalAlignment.CENTER);// 左右居中
			style.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
			style.setBorderBottom(BorderStyle.THIN); // 下边框
			style.setBorderLeft(BorderStyle.THIN);// 左边框
			style.setBorderTop(BorderStyle.THIN);// 上边框
			style.setBorderRight(BorderStyle.THIN);// 右边框
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());// 设置背景色
			style.setFont(font);
			break;
		// 单元格格式三:垂直居中
		case 3:
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			style.setFont(font);
			break;
		default:
			break;
		}
		return style;

	}

	/**
	 * 设置2007以及以上版本字体风格的属性
	 */
	@SuppressWarnings("deprecation")
	public void setXFontStyleAttribute(int fontnum, Font font) {
		font.setColor(HSSFColor.BLACK.index);
		switch (fontnum) {
			case 1:// 字体风格：微软雅黑，12号字体，黑色，加粗
				font.setFontName("微软雅黑");
				font.setFontHeightInPoints((short) 12);
				font.setBold(true);
				break;
			case 2:// 字体风格：微软雅黑，10号字体，黑色
				font.setFontName("微软雅黑");
				font.setFontHeightInPoints((short) 10);
				break;
			case 3:// 字体风格：微软雅黑，9号字体，黑色
				font.setFontName("微软雅黑");
				font.setFontHeightInPoints((short) 9);
				break;
			case 4:// 字体风格：宋体，12号字体，黑色，加粗
				font.setFontName("宋体");
				font.setFontHeightInPoints((short) 12);
				font.setBold(true);
				break;
			case 5:// 字体风格：宋体，10号字体，黑色
				font.setFontName("宋体");
				font.setFontHeightInPoints((short) 10);
				break;
			case 6:// 字体风格：宋体，9号字体，黑色
				font.setFontName("宋体");
				font.setFontHeightInPoints((short) 9);
				break;
			default:
				break;
		}

	}
}