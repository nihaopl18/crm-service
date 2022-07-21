package cn.com.yusys.yusp.uimp.business.pma.coefficient.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.yusys.yusp.commons.util.file.FileTypeUtil;
import cn.com.yusys.yusp.commons.web.rest.exception.Message;
import cn.com.yusys.yusp.commons.web.rest.exception.YuspException;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.coefficient.domain.PmaFCoefficient;
import cn.com.yusys.yusp.uimp.business.pma.coefficient.repository.mapper.PmaFCoefficientMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFCoefficientService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-14 10:20:52
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFCoefficientService extends CommonService {
    private static final Logger logger = LoggerFactory.getLogger(PmaFCoefficient.class);
    @Autowired
    private PmaFCoefficientMapper pmaFCoefficientMapper;
    @Autowired
    private UserInfoService userInfoService;
	@Value("${info.file.local-disk-path}")
	private String localDiskPath;
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFCoefficientMapper;
    }
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryList(QueryModel model) {
    	PageHelper.startPage(model.getPage(), model.getSize());
    	model.getCondition().put("userOrgId", userInfoService.getGrantOrgCode());
		List<Map<String, Object>> list = this.pmaFCoefficientMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}
	public void export(QueryModel model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("开始导出excel");
		try {
			logger.info("开始创建工作簿!");
			Workbook book = exportExcel(model);
			logger.info("成功创建工作簿:{}", book);
			String fileName = "Coefficent" + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date()) + ".xlsx";
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
	@SuppressWarnings({ "resource" })
	public SXSSFWorkbook exportExcel(QueryModel model) throws IOException {
		logger.info("业务数据导出exportExcel  begin");
		// 创建工作簿
		SXSSFWorkbook workbook = new SXSSFWorkbook();
		String showCol="";
		Map<String, String> colMap = new HashMap<String, String>();
		showCol="trancode,tranname,coefficient";
		String[] showCols=showCol.split(",");
		int showColsize=showCols.length;
		colMap.put("trancode", "交易代码");
		colMap.put("tranname", "交易类型名称");
		colMap.put("coefficient", "折算系数");
		Map<String, String> dataCodeMap = new HashMap<String, String>();
		//查询选择开始和结束时间之间的数据
		List<Map<String, Object>> datelist= this.pmaFCoefficientMapper.querylist(model);
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();//存储导出数据
		for (int j = 0; j < datelist.size(); j++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("trancode", datelist.get(j).get("trancode"));
			map.put("tranname", datelist.get(j).get("tranname"));
			map.put("coefficient", datelist.get(j).get("coefficient"));
			list.add(map);
		}
		int  listSize=list.size();
		if (list != null && list.size() > 0) {
			int n = -1;
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
					workbook = createSheet(workbook, list2, sheetName, showCol, colMap,dataCodeMap,listSize,showColsize);
				}
			} else {
				workbook = createSheet(workbook, list, "sheet0", showCol, colMap,dataCodeMap,listSize,showColsize);
			}
		}else {
			   workbook = createSheet(workbook, list, "sheet0", showCol, colMap,new HashMap<String, String>(),0,showColsize);
		}
		// 创建workbook
		logger.info("业务数据导出exportExcel  end");
		return workbook;
	}
	/**
	 * 创建Sheet
	 *
	 * @param workbook
	 * @param datas
	 * @return
	 */
	public SXSSFWorkbook createSheet(SXSSFWorkbook workbook, List<Map<String, Object>> datas, String sheetName,
			String showCol, Map<String, String> colMap,Map<String, String> dataCodeMap,int listSize,int showColsize) {
		// 创建Sheet
		SXSSFSheet sheet = workbook.createSheet(sheetName);
		XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
		DataFormat format = workbook.createDataFormat();
		style.setDataFormat(format.getFormat("@"));
		sheet.setDefaultColumnStyle(0, style);
		sheet.setDefaultColumnStyle(1, style);
		sheet.setDefaultColumnStyle(2, style);
		XSSFCellStyle cellStylelocktitle = getReportStyle(workbook, true, (short) 16, "宋体", true,true,sheet);//锁定列样式
		XSSFCellStyle cellStylelock = getReportStyle(workbook, true, (short) 12, "宋体", true,true,sheet);//锁定列样式
		XSSFCellStyle cellStyle = getReportStyle(workbook, true, (short) 12, "宋体", true,false,sheet);//未锁定列样式
		// 设置表格默认列宽度为20个字节
		sheet.setDefaultColumnWidth(20);
		String[] Stringarr = showCol.split(",");
		// 设置第一行的信息
		sheet = createFirst(sheet,cellStylelocktitle, Stringarr.length,listSize,showColsize);
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
			cell.setCellStyle(cellStylelock);
			sheet.setColumnWidth(j, 6000);
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
				XSSFCellStyle cellStyle1 = getReportStyle(workbook, false, (short) 10, "宋体", false,false,sheet);//未锁定列样式
				if (map.get(Stringarr[j]) != null) {
					    value = map.get(Stringarr[j]).toString();
					    cell.setCellStyle(cellStyle1);
						cell.setCellValue(value);
				}else {
						cell.setCellStyle(cellStyle1);
						cell.setCellValue(value);	
				}
				//}
				colNum2++;
			}
		}

		return workbook;
	}
	/**
	 * @param workbook
	 * @param color
	 * @param fh
	 * @param fontName
	 */
	public static XSSFCellStyle getReportStyle(Workbook workbook, boolean color, short fh, String fontName,
			boolean bold,boolean isLock,SXSSFSheet sheet) {
		XSSFCellStyle cellStyle = (XSSFCellStyle) workbook.createCellStyle();
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("@"));
		if(isLock) {//列锁定
			//sheet.setColumnWidth((short) 0, (short) 10000);
			cellStyle.setLocked(true);   //设置列的锁定状态为锁定
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
		}else {
			//sheet.setColumnWidth((short) 0, (short) 1000);
			cellStyle.setLocked(false);   //设置列的锁定状态为锁定
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
		}
		
		return cellStyle;
	}
	/**
	 * 处理第一行表头
	 * 
	 */
	public SXSSFSheet createFirst(SXSSFSheet sheet, XSSFCellStyle cellStyle, int k,int listSize,int showColsize) {
		String resultCell = "折算系数补录";
		int rowNum = 0;
		// 行
		SXSSFRow row = sheet.createRow(rowNum);
		row.setHeight((short)800);//目的是想把行高设置成25px
		SXSSFCell cell = row.createCell(0);
		// 合并单元格：参数：起始行, 终止行, 起始列, 终止列
		CellRangeAddress cra = new CellRangeAddress(0, 0, 0, k-1);
		sheet.addMergedRegion(cra);
		cell.setCellValue(resultCell);
		cell.setCellStyle(cellStyle);

		return sheet;
	}
	/**
	 * @方法名称: processImport
	 * @方法描述: 导入入口方法
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public List<String> processImport(String fileRelatePath, MultipartFile mnultiFile, String fileName) throws Exception {
		InputStream inputStream = null;
		XSSFWorkbook wb = null;
		try {
			List<String> errMsgList = new ArrayList<String>();// 存储错误信息
			String filePath = this.localDiskPath + (this.localDiskPath.endsWith(File.separatorChar + "") ? "" : File.separatorChar) + fileRelatePath;
			File file = new File(filePath);
			if(!file.exists()) {
				throw new YuspException(new Message("500", "上传文件不存在","error"));
			}
			inputStream = new FileInputStream(filePath);
			wb = new XSSFWorkbook(inputStream);
	        XSSFSheet sheet = wb.getSheetAt(0); // 数据页
			// 2、 excel格式基本校验（非空且符合标准excel头）
	        errMsgList = this.validateBaseInfo(sheet);
	        if(errMsgList.size() > 0) {
	        	return errMsgList;
	        } 
	        Map<String, Object> retMap = this.getDataListFromSheet(errMsgList,sheet);
			if (retMap.get("flag").equals("true")) {// 校验通过
				try {
					List<PmaFCoefficient> dataList = (List<PmaFCoefficient>) retMap.get("dataList");
					for (int i = 0; i < dataList.size(); i++) {
						// 先删除后插入，覆盖之前的补录数据
						pmaFCoefficientMapper.deleteData(dataList.get(i));
						pmaFCoefficientMapper.insertSelective(dataList.get(i));
					}
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
			} else {
				List<String> list = (List<String>) retMap.get("errMsgList");
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(Objects.nonNull(wb)) {
				wb.close();
			}
			if(Objects.nonNull(inputStream)) {
				inputStream.close();
			}
		}
		return null;
	}
	/**
	 * @方法名称: validateBaseInfo
	 * @方法描述: 导入excel基本校验
	 * @参数与返回说明: 
	 * @算法描述: 
	 *    1、判断excel模板非空
	 *    2、判断excel列格式是否满足标准模板列名
	 */
	private List<String> validateBaseInfo(XSSFSheet sheet) {
		List<String> errMsgList = new ArrayList<String>();
		// 获得总行数,该方法是获取的最后行数下标，所以实际数量应该+1
		int totalRowCount = sheet.getLastRowNum() + 1;
		//int totalcoloumCount = sheet.getRow(1).getPhysicalNumberOfCells();// 获得总列数
		String title=sheet.getRow(0).getCell(0).toString();//获取表头
		/** 校验是否为空模板 */
		if (3 > totalRowCount) {// 数据从第三行开始
			errMsgList.add("Excel模板为空或无数据");
		} else if (title.indexOf("折算系数补录")<0) {	// 校验是否为标准模板
			errMsgList.add("Excel模板不是标准模板，请检查");
		}
		return errMsgList;
	}
	/**
	 * @方法名称: getDataListFromSheet
	 * @方法描述: 遍历excel，生成dataList
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@SuppressWarnings({ "deprecation" })
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Map<String, Object> getDataListFromSheet(List<String> errMsgList, XSSFSheet sheet) {
		 //创建map用来存放返回数据
        Map<String, Object> retMap = new HashMap<String, Object>();
		//用来存放数据的list
		List<PmaFCoefficient> dataList = new ArrayList<PmaFCoefficient>();
		// 获得总行数,该方法是获取的最后行数下标，所以实际数量应该+1
        int totalRowCount = sheet.getLastRowNum() + 1;
        XSSFRow row = null;
		for (int i = 2; i < totalRowCount; i++) {
	        row = sheet.getRow(i); 
	        PmaFCoefficient pmaFCoefficient = new PmaFCoefficient();
        	if (row.getCell(0) == null||"".equals(row.getCell(0).toString())) {
				errMsgList.add("第【" + (i + 1) + "】行,第【1】列：该单元格无数据，请查验。");
				continue;
			} else {
				if(SXSSFCell.CELL_TYPE_NUMERIC == row.getCell(0).getCellType()) {
					pmaFCoefficient.setTrancode(row.getCell(2).toString().substring(0, row.getCell(0).toString().length()-2));
				}else {
					if(row.getCell(0).toString().indexOf(".0")<0) {
						pmaFCoefficient.setTrancode(row.getCell(0).toString());
					}else {
						pmaFCoefficient.setTrancode(row.getCell(0).toString().substring(0, row.getCell(2).toString().length()-2));
					}

				}
			}
        	if (row.getCell(1) == null||"".equals(row.getCell(1).toString())) {
				errMsgList.add("第【" + (i + 1) + "】行,第【2】列：该单元格无数据，请查验。");
				continue;
			} else {
				pmaFCoefficient.setTranname(row.getCell(1).toString());
			}
        	if (row.getCell(2) == null||"".equals(row.getCell(2).toString())) {
				errMsgList.add("第【" + (i + 1) + "】行,第【3】列：该单元格无数据，请查验。");
				continue;
			} else {
				if(SXSSFCell.CELL_TYPE_NUMERIC == row.getCell(0).getCellType()) {
					pmaFCoefficient.setCoefficient(new BigDecimal(row.getCell(2).toString().substring(0, row.getCell(2).toString().length()-2)));
				}else {
					if(row.getCell(2).toString().indexOf(".0")<0) {
						pmaFCoefficient.setCoefficient(new BigDecimal(row.getCell(2).toString()));
					}else {
						pmaFCoefficient.setCoefficient(new BigDecimal(row.getCell(2).toString().substring(0, row.getCell(2).toString().length()-2)));
					}

				}

			}
        	dataList.add(pmaFCoefficient);
		}
		if(errMsgList.size()>0) {
			retMap.put("flag", "false");
			retMap.put("errMsgList", errMsgList);
		}else {
			retMap.put("flag", "true");
			retMap.put("dataList", dataList);
		}
		return retMap;
	}
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Integer> del(String ids) {
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	String[] id = ids.split(",");
    	for (int i =0 ;i < id.length ; i++) {	
    		pmaFCoefficientMapper.deleteByIds(id[i]);
    	}
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<PmaFCoefficient> add(PmaFCoefficient pmaFCoefficient) {
    	ResultDto<PmaFCoefficient> result = new ResultDto<PmaFCoefficient>();
		QueryModel modelNew = new QueryModel();
		modelNew.getCondition().put("trancode", pmaFCoefficient.getTrancode());
		String count = pmaFCoefficientMapper.selectCount(modelNew);
		if(count.equals("0")) {
			pmaFCoefficientMapper.insertSelective(pmaFCoefficient);
			result.setData(pmaFCoefficient);
			result.setMessage("新增成功");
			result.setCode(0);
	    	return result;
		}else {
			result.setData(pmaFCoefficient);
			result.setMessage("数据已存在，不允许重复新增！");
			result.setCode(1);
	    	return result;

		}
    }
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<PmaFCoefficient> edit(PmaFCoefficient pmaFCoefficient) {
		ResultDto<PmaFCoefficient> result = new ResultDto<PmaFCoefficient>();
		pmaFCoefficientMapper.updateByPrimaryKey(pmaFCoefficient);
		result.setData(pmaFCoefficient);
		result.setMessage("修改成功");
		result.setCode(0);
		return result;
	}
}
