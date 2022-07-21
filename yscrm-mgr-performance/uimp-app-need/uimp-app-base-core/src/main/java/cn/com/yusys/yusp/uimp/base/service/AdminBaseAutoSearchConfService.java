package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.file.FileTypeUtil;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.config.AutoSearch;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseAutoSearchConf;
import cn.com.yusys.yusp.uimp.base.repository.mapper.AdminBaseAutoSearchConfMapper;
import cn.com.yusys.yusp.uimp.base.utils.UimpBaseTools;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseAutoSearchConfService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2020-01-17 10:54:49
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class AdminBaseAutoSearchConfService extends CommonService {

	private static final Logger logger = LoggerFactory.getLogger(AdminBaseAutoSearchConfService.class);

	@Autowired
	private AdminBaseAutoSearchConfMapper adminBaseAutoSearchConfMapper;

	@Autowired
	private AdminBaseAutoSearchService adminBaseAutoSearchService;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	@Autowired
	private AutoSearch autoSearch;

	@Autowired
	private UimpBaseTools uimpBaseTools;

	 @Autowired
	private UserInfoService userInfoService;
	 
	@Override
	protected CommonMapper<?> getMapper() {
		return adminBaseAutoSearchConfMapper;
	}
	
	   /**
     * 处理当前人登录信息
     * 提供 用户ID ,名称，机构 ，机构名称， 当前日期的前一天
     * @return
     */
    public QueryModel getUserInfo(QueryModel model) {
        model.getCondition().put("userId", userInfoService.getUserInfo().getLoginCode());
        model.getCondition().put("userName", userInfoService.getUserInfo().getUserName());
        model.getCondition().put("orgId", userInfoService.getUserInfo().getOrg().getCode());
        model.getCondition().put("orgName", userInfoService.getUserInfo().getOrg().getName());
        model.getCondition().put("grant", userInfoService.getUserInfo().getOrg().getName());

//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
//        Date date = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.DAY_OF_MONTH, -1);
//        date = (Date) calendar.getTime();
//        String dateStr = df.format(date);
//        System.out.println(dateStr);
//        // 当前日期的前一天
//        dateStr="20200115";
//        model.getCondition().put("date",dateStr);
        return model;
    }

	/**
	 * 导出
	 *
	 * @param model
	 * @throws IOException
	 */
	public void export(QueryModel model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("开始导出excel");
		try {
			logger.info("开始创建工作簿!");
			Workbook book = exportExcel(model);
			logger.info("成功创建工作簿:{}", book);
			String fileName = model.getCondition().get("fileName") + ".xlsx";
			try {
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				Throwable var12 = null;
				try {
					logger.info("开始写入数据");
					response.setContentType(FileTypeUtil.getMimeType(fileName));
					response.setHeader("Content-Disposition",
							"attachment; filename=" + FileTypeUtil.getEncodeFileName(request, fileName));
					book.write(os);
					byte[] bytes = os.toByteArray();
					response.getOutputStream().write(bytes);
					response.getOutputStream().flush();
					logger.info("写入数据成功!");
				} catch (Throwable var23) {
					var12 = var23;
					throw var23;
				} finally {
					if (os != null) {
						if (var12 != null) {
							try {
								os.close();
							} catch (Throwable var22) {
								var12.addSuppressed(var22);
							}
						} else {
							os.close();
						}
					}
				}
			} catch (Exception var25) {
				throw var25;
			}
		} catch (Exception var26) {
			response.sendError(500, var26.getMessage());
		}

	}

	/**
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	public SXSSFWorkbook exportExcel(QueryModel model) throws IOException {
		logger.info("业务数据导出exportExcel  begin");
		// 创建工作簿
		SXSSFWorkbook workbook = new SXSSFWorkbook();
		model = getModel(model);
		Map<String, Object> map = this.autoconfig(model.getCondition().get("seacherId").toString());
		// 展示项的拼装
		String showCol = map.get("showCol").toString();
		// 表名
		String tableName = map.get("tableName").toString();
		// 列的map
		Map<String, String> colMap = (Map<String, String>) map.get("colMap");
		// 数据字典map
		Map<String, String> dataCodeMap = (Map<String, String>) map.get("dataCodeMap");
		// 封装数据的map
		Map<String, String> fromatterMap = (Map<String, String>) map.get("fromatterMap");
		List<Map<String, Object>> list = this.adminBaseAutoSearchConfMapper.queryPubliclist(model);
		if (list != null && list.size() > 0) {
			int n = autoSearch.getNumber();
			if (n > 50000)
				n = 50000;
			if (list.size() / n > 0) {
				int m = list.size() / n;
				if (list.size() % n > 0)
					m += 1;
				for (int i = 0; i < m; i++) {
					String sheetName = "sheet" + i;
					List<Map<String, Object>> list2 = new ArrayList<>();
					int H = (i + 1) * n;
					if (H > list.size())
						H = list.size();
					for (int j = i * n; j < H; j++) {
						list2.add(list.get(j));
					}
					workbook = createSheet(workbook, list2, sheetName, showCol, colMap, dataCodeMap, fromatterMap,
							tableName);
				}
			} else {
				workbook = createSheet(workbook, list, "sheet0", showCol, colMap, dataCodeMap, fromatterMap, tableName);
			}
		}
		// 创建workbook
		logger.info("业务数据导出exportExcel  end");
		return workbook;
	}

	/**
	 * 处理第一行表头
	 * 
	 */
	public SXSSFSheet createFirst(SXSSFSheet sheet, String tableName, XSSFCellStyle cellStyle, int k) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = format.format(date);
		String resultCell = tableName + "  (" + time + ")";
		int rowNum = 0;
		// 行
		SXSSFRow row = sheet.createRow(rowNum);
		SXSSFCell cell = row.createCell(0);
		// 合并单元格：参数：起始行, 终止行, 起始列, 终止列
		CellRangeAddress cra = new CellRangeAddress(0, 0, 0, k-1);
		sheet.addMergedRegion(cra);
		cell.setCellValue(resultCell);
		cell.setCellStyle(cellStyle);

		return sheet;
	}

	/**
	 * 创建Sheet
	 *
	 * @param workbook
	 * @param datas
	 * @return
	 */
	public SXSSFWorkbook createSheet(SXSSFWorkbook workbook, List<Map<String, Object>> datas, String sheetName,
			String showCol, Map<String, String> colMap, Map<String, String> dataCodeMap,
			Map<String, String> fromatterMap, String tableName) {
		// 创建Sheet
		SXSSFSheet sheet = workbook.createSheet(sheetName);
		XSSFCellStyle cellStyle = getReportStyle(workbook, true, (short) 12, "宋体", true);
		XSSFCellStyle cellStyle1 =  getReportStyle(workbook, false, (short) 10, "宋体", false);// 控制字符串，数字，日期格式

		// 设置表格默认列宽度为20个字节
		sheet.setDefaultColumnWidth(20);
		String[] Stringarr = showCol.split(",");
		// 设置第一行的信息
		sheet = createFirst(sheet, tableName, cellStyle, Stringarr.length);
		// 设置第一行 （单位信息，定制）
		int rowNum = 1;
		// 行
		SXSSFRow row = sheet.createRow(rowNum);
		// 创建列
		int colNum = 0;
		// 循环创建表头
		for (int j = 0; j < Stringarr.length; j++) {
			SXSSFCell cell = row.createCell(colNum);
			cell.setCellValue(colMap.get(Stringarr[j]));
			cell.setCellStyle(cellStyle);
			colNum++;
		}
		// 展示项的拼装。
		// 封装数据的map
		// 封装数据字段的map
		for (Map<String, Object> map : datas) {
			// 行
			rowNum++;
			SXSSFRow dataRow = sheet.createRow(rowNum);
			// 创建列
			int colNum2 = 0;
			for (int j = 0; j < Stringarr.length; j++) {
				SXSSFCell cell = dataRow.createCell(colNum2);
				String value = ""; // 字符型数值处理
				Double doubleValue = null; // 数值型
				if (map.get(Stringarr[j]) != null) {
					value = map.get(Stringarr[j]).toString();
					if (dataCodeMap.get(Stringarr[j]) != null) {
						value = getValue(dataCodeMap.get(Stringarr[j]), value);
					} else if (fromatterMap.get(Stringarr[j]) != null) {
						String format = fromatterMap.get(Stringarr[j]).toString();
						DataFormat formatExecl = workbook.createDataFormat();
						if (format.equals(autoSearch.getFormatDate())) {
							cellStyle1.setDataFormat(formatExecl.getFormat("@"));
							try {
								value = strToDateFormat(value);
							} catch (ParseException e) {
								e.printStackTrace();
							}
						} else if (format.equals(autoSearch.getFormatmoney())) {
							doubleValue = Double.parseDouble(value);
							cellStyle1.setDataFormat(formatExecl.getFormat("#,##0.00"));
						} else if (format.equals(autoSearch.getFormatPercent())) {
							doubleValue = Double.parseDouble(value);
							cellStyle1.setDataFormat(formatExecl.getFormat("0.00%"));
						}
					}
					if (doubleValue != null) {
						cell.setCellValue(doubleValue);
					} else {
						cell.setCellValue(value);
					}
				} else {
					cell.setCellValue(value);
				}
				cell.setCellStyle(cellStyle1);
				colNum2++;
			}
		}

		return workbook;
	}

	/**
	 * 将字符串格式yyyyMMdd的字符串转为日期，格式"yyyy-MM-dd"
	 *
	 * @param date
	 *            日期字符串
	 * @return 返回格式化的日期
	 * @throws ParseException
	 *             分析时意外地出现了错误异常
	 */
	public String strToDateFormat(String date) throws ParseException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		formatter.setLenient(false);
		Date newDate = formatter.parse(date);
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(newDate);
	}

	/**
	 * @param workbook
	 * @param color
	 * @param fh
	 * @param fontName
	 */
	public static XSSFCellStyle getReportStyle(Workbook workbook, boolean color, short fh, String fontName,
			boolean bold) {
		XSSFCellStyle cellStyle = (XSSFCellStyle) workbook.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);// 左右居中
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
		cellStyle.setBorderBottom(BorderStyle.THIN); // 下边框
		cellStyle.setBorderLeft(BorderStyle.THIN);// 左边框
		cellStyle.setBorderTop(BorderStyle.THIN);// 上边框
		cellStyle.setBorderRight(BorderStyle.THIN);// 右边框
		if (color) {
			cellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());// 设置背景色
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);// 填充模式
		}
		Font font = workbook.createFont();
		font.setBold(bold);// true 加粗，false 不加
		font.setFontHeightInPoints(fh);
		font.setFontName(fontName);
		cellStyle.setFont(font);
		return cellStyle;
	}

	/**
	 * 数据字典转换
	 */
	public String getValue(String dateCode, String key) {
		String value = "";
		value = this.adminBaseAutoSearchConfMapper.queryDataCodeValue(dateCode, key);
		if (value != null && !value.equals("")) {
			return value;
		} else {
			return key;
		}
	}

	/**
	 * 配置查询 完成拼装SQL 完成界面拼装 完成cha询拼装
	 */
	@Cacheable(value = "myAutoCache", key = "#scacherId")
	public Map<String, Object> autoconf(String scacherId) {
		Map<String, Object> map = new HashMap<>();
		String tableName = this.adminBaseAutoSearchConfMapper.queryTable(scacherId);
		List<Map<String, Object>> list = this.adminBaseAutoSearchConfMapper.querylist(scacherId);
		String sql = getSQL(list, tableName);
		String seacher = getCondtion(list);
		List<Map<String, String>> seacherList = getSeacher(list);
		List<Map<String, String>> tableList = getTableColnum(list);
		map.put("sql", sql);
		map.put("seacher", seacher);
		map.put("seacherList", seacherList);
		map.put("tableList", tableList);
		return map;
	}

	/**
	 * 重构查询方案。 根据 主键值 放入缓存 构建查询SQL,查询条件,导出列明，导出列标签，数据字典，格式化方式。
	 */
	@Cacheable(value = "myAutoCache", key = "#scacherId")
	public Map<String, Object> autoconfig(String scacherId) {
		Map<String, Object> map = new HashMap<>();
		String tableName = this.adminBaseAutoSearchConfMapper.queryTable(scacherId);
		String orgDataAuth = this.adminBaseAutoSearchConfMapper.queryDataAuth(scacherId);
		String tableType = this.adminBaseAutoSearchConfMapper.queryTableType(scacherId);
		List<Map<String, Object>> list = this.adminBaseAutoSearchConfMapper.querylist(scacherId);
		String sql = getSQL(list, tableName);
		String seacher = getCondtion(list);
		List<Map<String, String>> tableList = getTableColnum(list);
		List<Map<String, String>> seacherList = getSeacher(list);
		// 展示项的拼装
		String showCol = "";
		// 列的map
		Map<String, String> colMap = new HashMap<>();
		// 数据字典map
		Map<String, String> dataCodeMap = new HashMap<>();
		// 封装数据的map
		Map<String, String> fromatterMap = new HashMap<>();
		// 封装是否排名的map
		Map<String, String> ifColSortMap = new HashMap<>();
		
		// 处理展示列
		for (int i = 0; i < tableList.size(); i++) {
			Map<String, String> mapType = tableList.get(i);
			showCol += mapType.get("ename") + ",";
			colMap.put(mapType.get("ename"), mapType.get("name"));
			if (mapType.get("dataCode") != null) {
				dataCodeMap.put(mapType.get("ename"), mapType.get("dataCode"));
			}
			if (mapType.get("format") != null) {
				fromatterMap.put(mapType.get("ename"), mapType.get("format"));
			}
			if (mapType.get("ifColSort") != null) {
				ifColSortMap.put(mapType.get("ename"), mapType.get("ifColSort"));
			}
		}
		// 新增查询项的map
		Map<String, String> search = new HashMap<>();
		// 处理查询项
		if (list != null && list.size() > 0) {
			for (int j = 0; j < list.size(); j++) {
				Map<String, Object> listmap = list.get(j);
				if (listmap.get("ifSeacher").toString().equals("1")) {
					String ename = uimpBaseTools.lineToHump(listmap.get("fieldEnName").toString());
					// 查询选择
					if (listmap.get("ifDateSeacher") != null) {
						search.put(ename, listmap.get("ifDateSeacher").toString());
					}
					// 数据字典多选
					if (listmap.get("lookupMultiple") != null && listmap.get("ifLookup") != null
							&& listmap.get("lookupMultiple").toString().equals("1")) {
						search.put(ename, "99");// 数据字典支持多选
					}

				}
			}
		}

		map.put("tableName", tableName);// 表名
		map.put("sql", sql); // 查询的sql
		map.put("seacher", seacher); // 查询条件
		map.put("tableList", tableList);
		map.put("seacherList", seacherList);

		map.put("showCol", showCol); // 展示列字段
		map.put("colMap", colMap); // 列的map
		map.put("dataCodeMap", dataCodeMap); // 数据字点 字段
		map.put("fromatterMap", fromatterMap); // 格式化字段
		map.put("ifColSortMap", ifColSortMap); // 是否排序字段

		map.put("search", search); // 查询条件控制
		map.put("orgDataAuth", orgDataAuth);//机构数据权限
		map.put("tableType", tableType);//表类型
		return map;
	}

	/**
	 * 拼接SQL
	 */
	public String getSQL(List<Map<String, Object>> list, String tableName) {
		String sql = "";
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> listmap = list.get(i);
				sql += listmap.get("fieldEnName") + ",";
			}
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += " from " + tableName;
		return sql;
	}

	/**
	 * 拼接--查询条件
	 */
	public String getCondtion(List<Map<String, Object>> list) {
		String seacher = "";
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> listmap = list.get(i);
				if (listmap.get("ifSeacher").toString().equals("1")) {
					seacher += listmap.get("fieldEnName") + ",";
				}
			}
		}
		seacher = seacher.substring(0, seacher.length() - 1);
		return seacher;
	}

	/**
	 * 拼接查询列表
	 */
	public List<Map<String, String>> getTableColnum(List<Map<String, Object>> list) {
		List<Map<String, String>> seacherList = new ArrayList<>();
		// { 'name': '客户类型', 'ename': 'custType', 'dataCode': 'INDEX_APPLY_TYPE' },
		// { 'name': '归属机构名', 'ename': 'orgName', 'sortable': 'true' },

		boolean ifColSort=true; // 控制排序新增展示的字段
		Map<String, String> mapifColSort = new HashMap<>();

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> listmap = list.get(i);
				if (listmap.get("ifColShow").toString().equals("1")) {
					Map<String, String> mapSeacher = new HashMap<>();
					mapSeacher.put("name", listmap.get("fieldCnName").toString()); // 中文名称
					mapSeacher.put("ename", uimpBaseTools.lineToHump(listmap.get("fieldEnName").toString())); // 英文名称
					if (listmap.get("ifLookup") != null) {
						mapSeacher.put("dataCode", listmap.get("ifLookup").toString());
					}
					// 金额格式化，日期格式化。
					if (listmap.get("ifMoney") != null) {
						mapSeacher.put("format", autoSearch.getFormat(listmap.get("ifMoney").toString()));
					}
					// // 是否可排序
					mapSeacher.put("sortable", "custom");
					// if (listmap.get("ifColSort") != null &&
					// listmap.get("ifColSort").toString().equals("1")) {
					// mapSeacher.put("sortable", "true");
					// }
					// 列宽度
					if (listmap.get("colWidth") != null && !listmap.get("colWidth").toString().equals("0")) {
						mapSeacher.put("width", listmap.get("colWidth").toString());
					}
					// 列下钻属性
					if (listmap.get("colGoingDown") != null && listmap.get("colGlProp") != null) {
						// 处理下钻标识
						mapSeacher.put("goingDown", "1");
						mapSeacher.put("colGoingDown", listmap.get("colGoingDown").toString());
						mapSeacher.put("colGlProp", listmap.get("colGlProp").toString());
					}
					// 处理可排名字段
					if (listmap.get("ifColSort") != null && listmap.get("ifColSort").toString().equals("1")) {
						// 处理可排序字段标识
						mapSeacher.put("ifColSort", "1");
						if (ifColSort) {
							mapifColSort.put("name","排名");
							mapifColSort.put("ename","denseRank" );
							mapifColSort.put("sortable","false" );
							ifColSort=false;
						}
					}
					seacherList.add(mapSeacher);
				}
			}
			if(!ifColSort) {
				seacherList.add(mapifColSort);
			}
		}
		return seacherList;
	}

	/**
	 * 拼接查询条件
	 *		{ placeholder: '标题', field: 'title', type: 'custom', is: 'yufp-user-selector' },
        { placeholder: '时间', field: 'create_at', type: 'date' },
        { placeholder: '时间', field: 'create_at', type: 'input' },
       { placeholder: '类型', field: 'type', type: 'select', dataCode: 'YE_TYPE', multiple: 'multiple' }],
	 * @param list
	 * @return
	 */
	public List<Map<String, String>> getSeacher(List<Map<String, Object>> list) {
		List<Map<String, String>> seacherList = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> listmap = list.get(i);
				if (listmap.get("ifSeacher").toString().equals("1")) {
					if (listmap.get("ifDateSeacher") != null && (listmap.get("ifDateSeacher").toString().equals("2")
							|| listmap.get("ifDateSeacher").toString().equals("3"))) {
						Map<String, String> mapSeacherSta = new HashMap<>();
						Map<String, String> mapSeacherEnd = new HashMap<>();
						String name = listmap.get("fieldCnName").toString();
						String ename = uimpBaseTools.lineToHump(listmap.get("fieldEnName").toString());
						
						mapSeacherSta.put("placeholder", name + "从"); // 中文名称
						mapSeacherSta.put("field", ename + "Sta"); // 英文名称
						mapSeacherEnd.put("placeholder", name + "到"); // 中文名称
						mapSeacherEnd.put("field", ename + "End"); // 英文名称
						if (listmap.get("ifDateSeacher").toString().equals("2")) {
							mapSeacherSta.put("type", "date");
							mapSeacherEnd.put("type", "date");
						} else {
							mapSeacherSta.put("type", "input");
							mapSeacherEnd.put("type", "input");
						}
						seacherList.add(mapSeacherSta);
						seacherList.add(mapSeacherEnd);

					} else {
						Map<String, String> mapSeacher = new HashMap<>();
						mapSeacher.put("placeholder", listmap.get("fieldCnName").toString()); // 中文名称
						mapSeacher.put("field", uimpBaseTools.lineToHump(listmap.get("fieldEnName").toString())); // 英文名称
						if (listmap.get("ifLookup") != null) {
							mapSeacher.put("dataCode", listmap.get("ifLookup").toString());
							mapSeacher.put("type", "select");
							if (listmap.get("lookupMultiple") != null
									&& listmap.get("lookupMultiple").toString().equals("1")) {
								mapSeacher.put("multiple", "multiple");
							}

						} else if (listmap.get("ifDateSeacher") != null) {
							if (listmap.get("ifDateSeacher").toString().equals("1")) {
								mapSeacher.put("type", "date");
							}else 	if (listmap.get("ifDateSeacher").toString().equals("0")) {
								mapSeacher.put("type", "input");
							}

						} else if (listmap.get("ifBig") != null) {
							// 处理放大镜
							mapSeacher.put("type", "custom");
							mapSeacher.put("is", autoSearch.getBigGlass(listmap.get("ifBig").toString()));
							if (listmap.get("bigGrant") != null) {
								// 判断权限
								mapSeacher.put(autoSearch.getGrant(), listmap.get("bigGrant").toString());
							}
						} else {
							mapSeacher.put("type", "input");
						}
						seacherList.add(mapSeacher);
					}

				}
			}
		}
		return seacherList;
	}

	/**
	 * 公共查询
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> querylist(QueryModel model) {
		model = getModel(model);
		
		PageHelper.startPage(model.getPage(), model.getSize());
		PageHelper.orderBy(model.getSort());
		List<Map<String, Object>> list = this.adminBaseAutoSearchConfMapper.queryPubliclist(model);
		PageHelper.clearPage();
		return list;
	}

	/**
	 * 处理公共查询拼接SQL
	 */
	@SuppressWarnings("unchecked")
	public QueryModel getModel(QueryModel model) {
		Map<String, Object> map = this.autoconfig(model.getCondition().get("seacherId").toString());
		List<Map<String, Object>> searcherList = map.get("seacherList") != null ? (List<Map<String, Object>>) map.get("seacherList") : null;
		List<String> orgUserSelSearcherNameList = new ArrayList<String>();
		if(searcherList != null) {
			for(Map<String, Object> searcher : searcherList) {
				if(searcher.get("is") != null && searcher.get("is") != "") {
					orgUserSelSearcherNameList.add(searcher.get("field") + "");
				}
			}
		}
		String seacher = map.get("seacher").toString();
		String Sql = map.get("sql").toString();
		Map<String, String> search = (Map<String, String>) map.get("search");

		if (Sql != null) {
			Sql = "Select " + Sql + "   where 1=1  ";
		}
		String role = userInfoService.getUserInfo().getRoles().get(0).getCode();
		String[] seacherArr = seacher.split(",");
		if (seacherArr.length > 0) {
			for (int i = 0; i < seacherArr.length; i++) {
				if (model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i])) != null
						&& model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i])) != "") {
					// 处理日期查询的
					if (model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i])).toString()
							.split("-").length == 3 && search.get(uimpBaseTools.lineToHump(seacherArr[i])) != null
							&& search.get(uimpBaseTools.lineToHump(seacherArr[i])).equals("1")) {
						Sql += " AND "
								+ seacherArr[i] + "= '" + model.getCondition()
										.get(uimpBaseTools.lineToHump(seacherArr[i])).toString().replaceAll("-", "")
								+ "'";
					} else {
						// 模糊查询
						if (search.get(uimpBaseTools.lineToHump(seacherArr[i])) != null && search.get(uimpBaseTools.lineToHump(seacherArr[i])).equals("0")) {

							Sql += " AND " + seacherArr[i] + " like '%"
									+ model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i])) + "%'";
						} else if (search.get(uimpBaseTools.lineToHump(seacherArr[i])) != null && search.get(uimpBaseTools.lineToHump(seacherArr[i])).equals("99")) {
							// 数据字典多选查询
							String lookup = model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i]))
									.toString().replace("[", "").replace("]", "");
							if(!lookup.equals("")) {
								String[] lookupArr = lookup.split(",");

								if (lookupArr.length > 0) {
									Sql += " AND " + seacherArr[i]+" in (";
									for (int m = 0; m < lookupArr.length; m++) {
										Sql += "'"+lookupArr[m].trim()+"'";
										if(m!=lookupArr.length-1) Sql +=",";
									}
									Sql +=" )";
							}
							
							}
						} else {
							if(orgUserSelSearcherNameList.contains(uimpBaseTools.lineToHump(seacherArr[i]))) {
								String searchVals = model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i])) + "";
								searchVals = searchVals.replaceAll(",", "','");
								Sql += " AND " + seacherArr[i] + " in ('" + searchVals + "') ";
							} else {
								// 普通查询
								Sql += " AND " + seacherArr[i] + "= '"
										+ model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i])) + "'";
							}
						}

					}
				}

				// 处理从区间
				if (model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i]) + "Sta") != null
						&& model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i]) + "Sta") != "") {
					// 日期区间查询
					if (search.get(uimpBaseTools.lineToHump(seacherArr[i])) != null && search.get(uimpBaseTools.lineToHump(seacherArr[i])).equals("2")) {
						Sql += " AND "
								+ seacherArr[i] + " >= '" + model.getCondition()
										.get(uimpBaseTools.lineToHump(seacherArr[i])+ "Sta").toString().replaceAll("-", "")
								+ "'";
					} else if (search.get(uimpBaseTools.lineToHump(seacherArr[i])) != null && search.get(uimpBaseTools.lineToHump(seacherArr[i])).equals("3")) {
						
						if(isNumeric(model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i] )+ "Sta").toString())) {
							// 数值区间查询
							Sql += " AND " + seacherArr[i] + " >= '"
									+ model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i])+ "Sta") + "'";
						}else {
							Sql += " AND 1=2 ";
						}
						
					}

				}
				// 处理到区间
				if (model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i]) + "End") != null
						&& model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i]) + "End") != "") {
					// 日期区间查询
					if (search.get(uimpBaseTools.lineToHump(seacherArr[i])) != null && search.get(uimpBaseTools.lineToHump(seacherArr[i])).equals("2")) {
						Sql += " AND "
								+ seacherArr[i] + " <= '" + model.getCondition()
										.get(uimpBaseTools.lineToHump(seacherArr[i]) + "End").toString().replaceAll("-", "")
								+ "'";
					} else if (search.get(uimpBaseTools.lineToHump(seacherArr[i])) != null && search.get(uimpBaseTools.lineToHump(seacherArr[i])).equals("3")) {
						if(isNumeric(model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i] )+ "End").toString())) {
							// 数值区间查询
							Sql += " AND " + seacherArr[i] + " <= '"
									+ model.getCondition().get(uimpBaseTools.lineToHump(seacherArr[i] )+ "End") + "'";
						}else {
							Sql += " AND 1=2 ";
						}
						
					}
				}
			}
		}
		//  处理下钻查询,下钻后去掉权限控制
		
		if (model.getCondition().get("seacherKey") != null && model.getCondition().get("seacherValue") != null
				&&!"".equals(model.getCondition().get("seacherKey").toString())&&!"".equals(model.getCondition().get("seacherValue").toString())) {
			if ("cust".equals(map.get("tableType").toString())) {
				Sql=this.getDataGrant(model.getCondition().get("seacherKey").toString(),Sql,model.getCondition().get("seacherValue").toString(),"CUR_ORG",map.get("tableType").toString());
			}else if ("acct".equals(map.get("tableType").toString())) {
				Sql=this.getDataGrant(model.getCondition().get("seacherKey").toString(),Sql,model.getCondition().get("seacherValue").toString(),"CUR_ORG",map.get("tableType").toString());
			}else if ("team".equals(map.get("tableType").toString())) {
				Sql=this.getDataGrant(model.getCondition().get("seacherKey").toString(),Sql,model.getCondition().get("seacherValue").toString(),"CUR_ORG",map.get("tableType").toString());
			}else {
				Sql=this.getDataGrant(model.getCondition().get("seacherKey").toString(),Sql,model.getCondition().get("seacherValue").toString(),map.get("orgDataAuth").toString(),map.get("tableType").toString());
			}
		}else {
			// 增加权限控制
			if(role.equals("RC001")) {
				Sql += " AND USER_ID = '"+userInfoService.getUserInfo().getLoginCode()+"' ";
			}else {
				Sql=this.getDataGrant("ORG_ID",Sql,userInfoService.getOrgCode(),map.get("orgDataAuth").toString(),map.get("tableType").toString());
			}
		}
		
		model.getCondition().put("sql", Sql);

		// 处理排序
		if (model.getCondition().get("prop") != null && model.getCondition().get("order") != null) {
			Map<String, String> ifColSortMap = (Map<String, String>) map.get("ifColSortMap");
				if (ifColSortMap.get(model.getCondition().get("prop").toString()) != null
						&& ifColSortMap.get(model.getCondition().get("prop").toString()).toString().equals("1")) {
					String rankSql  =" select "+map.get("sql").toString().split("from")[0]+",rank() over(order by " +uimpBaseTools.humpToLine2(model.getCondition().get("prop").toString()) + "  " 
						+ model.getCondition().get("order") + " nulls last  ) dense_rank from ("+Sql+") ";
					// 重新给 sql 赋值
					model.getCondition().put("sql", rankSql);
				}else {
				String sort = " order by " +uimpBaseTools.humpToLine2(model.getCondition().get("prop").toString()) + "  " + model.getCondition().get("order")
						+ " nulls last ";
				model.getCondition().put("sort", sort);
			}
			
		}

		return model;
	}

	/**
	 * 处理权限问题
	 * @param sql
	 * @return
	 */
	public String getDataGrant(String col,String sql,String orgCode,String dataAuth,String tableType) {
		if("org".equals(tableType)) {
			String orgDataAuth = userInfoService.processDataOrgAuth(col,dataAuth,orgCode);
			sql+=orgDataAuth;
		}else if ("mgr".equals(tableType)) {
			String orgDataAuth = userInfoService.processDataOrgAuth(col,dataAuth,orgCode);
			sql+=orgDataAuth;
		}else if ("cust".equals(tableType)) {
			String orgDataAuth = userInfoService.processDataOrgAuth(col,dataAuth,orgCode);
			sql+=orgDataAuth;
		}else if ("acct".equals(tableType)) {
			String orgDataAuth = userInfoService.processDataOrgAuth(col,dataAuth,orgCode);
			sql+=orgDataAuth;
		}
		return sql;
	}
	
	/**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
    public boolean isNumeric(String str){
         //  Pattern pattern = Pattern.compile("/(^[\\-0-9][0-9]*(.[0-9]+)?)$/");
    	  Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");

           Matcher isNum = pattern.matcher(str);
           if( !isNum.matches() ){
               return false;
           }
           return true;
    }
    
    /**
     * 判断当前机构是否是最后一个机构
     * 
     */
	@Transactional(readOnly = false)
	public ResultDto<Object> queryLastOrg(String orgCode) throws Exception {
		ResultDto<Object> resultDto = new ResultDto<>();
		try {
		int m =	this.adminBaseAutoSearchConfMapper.queryLastOrg(orgCode);
	    if (m !=0 ) {
	    	resultDto.setData("1");
	    }else {
	    	resultDto.setData("lastOrg");
	    }
			resultDto.setCode(0);
			resultDto.setMessage("成功");
		} catch (Exception e) {
			resultDto.setCode(500);
			resultDto.setMessage(e.getMessage());
		}
		return resultDto;
	}
	/**
	 * 新增配置详细信息
	 *
	 * @param list
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> saveorupdate(List<AdminBaseAutoSearchConf> list) throws Exception {
		ResultDto<Object> resultDto = new ResultDto<>();
		String id = null;

		if (list != null && list.size() > 0) {
			id = list.get(0).getSeacherId();
			// this.delConf(id);
			for (int i = 0; i < list.size(); i++) {
				AdminBaseAutoSearchConf AdminBaseAutoSearchConf = list.get(i);
				try {
					if (AdminBaseAutoSearchConf.getId() != null) { // 修改
						this.adminBaseAutoSearchConfMapper.updateByPrimaryKeySelective(AdminBaseAutoSearchConf);
						resultDto.setCode(0);
						resultDto.setMessage("保存成功");
					} else {
						// 新增
						this.adminBaseAutoSearchConfMapper.insertSelective(AdminBaseAutoSearchConf);
						resultDto.setCode(0);
						resultDto.setMessage("新增成功");
					}
				} catch (Exception e) {
					resultDto.setCode(500);
					resultDto.setMessage(e.getMessage());
				}
			}
		}
		if (id != null)
			this.adminBaseAutoSearchService.updateIfConf(id);
		return resultDto;
	}

	/**
	 * 根据外建删除
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> getOrgLast(String seacherId) throws Exception {
		ResultDto<Object> resultDto = new ResultDto<>();
		try {
			this.adminBaseAutoSearchConfMapper.delConf(seacherId);
			resultDto.setCode(0);
			resultDto.setMessage("生成功能点成功");
		} catch (Exception e) {
			resultDto.setCode(500);
			resultDto.setMessage(e.getMessage());
		}
		return resultDto;
	}

	/**
	 * @方法名称: syncField
	 * @方法描述: 同步字段
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> syncField(String tableName, String seacherId){
		ResultDto<Object> resultDto = new ResultDto<>();
		try {
			//查询字段是否有新增字段
			List<Map<String, Object>> list = this.adminBaseAutoSearchConfMapper.queryFieldInsert(seacherId, tableName);
			if(list.size()>0) {
				for(int i=0;i<list.size();i++) {
					AdminBaseAutoSearchConf AdminBaseAutoSearchConf = new AdminBaseAutoSearchConf();
					AdminBaseAutoSearchConf.setFieldEnName(list.get(i).get("fieldEnName").toString());
					AdminBaseAutoSearchConf.setFieldCnName(list.get(i).get("fieldCnName").toString());
					AdminBaseAutoSearchConf.setIfColShow(list.get(i).get("ifColShow").toString());
					if(list.get(i).get("ifMoney")!=null) {
						AdminBaseAutoSearchConf.setIfMoney(list.get(i).get("ifMoney").toString());
					}
					AdminBaseAutoSearchConf.setIfSeacher(list.get(i).get("ifSeacher").toString());
					AdminBaseAutoSearchConf.setIfId(list.get(i).get("ifId").toString());
					AdminBaseAutoSearchConf.setSeacherId(list.get(i).get("seacherId").toString());
					AdminBaseAutoSearchConf.setIfColSort(list.get(i).get("ifColSort").toString());
					AdminBaseAutoSearchConf.setColShowSort(Integer.valueOf(list.get(i).get("colShowSort").toString()));
					this.adminBaseAutoSearchConfMapper.insertSelective(AdminBaseAutoSearchConf);
				}
			}
			//查询字段是否有删除字段
			List<Map<String, Object>> listOne = this.adminBaseAutoSearchConfMapper.queryFieldDel(seacherId, tableName);
			if(listOne.size()>0) {
				for(int i=0;i<listOne.size();i++) {
					this.adminBaseAutoSearchConfMapper.deleteByIds(listOne.get(i).get("id").toString());
				}
			}
			resultDto.setCode(0);
			resultDto.setMessage("同步字段成功");
		} catch (Exception e) {
			resultDto.setCode(500);
			resultDto.setMessage(e.getMessage());
		}
		return resultDto;
	}
}
