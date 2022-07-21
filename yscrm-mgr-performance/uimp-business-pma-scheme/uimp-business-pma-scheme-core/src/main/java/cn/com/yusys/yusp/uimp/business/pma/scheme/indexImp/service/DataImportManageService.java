package cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.domain.PmaFImpFillInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.repository.mapper.PmaFImpFillInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.utils.DateUtil;
import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.utils.PmaCommonUtil;
import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.utils.PmaConstantDefine;
import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.vo.ExcelObjVo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.vo.PmaASchemeIndexRelVo;

/**
 * @ClassName: DataImportManageService
 * @Description: 数据补录管理(指标补录、目标补录、基数补录)
 * @author: chenhx
 * @date 2016年1月19日 下午2:15:33
 * @version V3.3
 * 
 */
@SuppressWarnings("deprecation")
@Service
public class DataImportManageService extends CommonService {
	
	private static final Logger log = LoggerFactory.getLogger(DataImportManageService.class);
	
    @Autowired
    private PmaFImpFillInfoMapper pmaFImpFillInfoMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFImpFillInfoMapper;
    }

    /** 
     * <pre>
     * 功能描述:  创建excel
     * @Title: createExcel 
     * @author: chenhx
     * @param excelObjVo excel基本信息
     * @param pmaVO 考核方案和指标关系VO
     * @param dataList 数据
     * </pre>
     */ 
    public void createExcel(ExcelObjVo excelObjVo, PmaASchemeIndexRelVo pmaVO,List<PmaASchemeIndexRelVo> dataList) {
    	HSSFWorkbook wb = null;
    	FileOutputStream fileOut = null;
    	try {
	        // 创建一个工作簿
	        wb = new HSSFWorkbook();
	        // 创建一个sheet页
	        HSSFSheet sheet = wb.createSheet();
	        //创建表头
	        this.createHeader(wb, sheet, excelObjVo, pmaVO, dataList);
	        //创建文件引用
	        File pathFile = new File(excelObjVo.getFilePath() + File.separator
	                + "downLoad");
	        if (!pathFile.exists()) {
	            //若文件不存在创建文件
	            pathFile.mkdirs();
	        }
            fileOut = new FileOutputStream(excelObjVo.getFilePath() + excelObjVo.getFileName());
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            log.error("数据补录管理生成模板失败,未找到模板文件.",e);
        } catch (IOException e) {
            log.error("数据补录管理生成模板失败,模板文件读取权限异常.",e);
        } finally {
        	if(Objects.nonNull(fileOut)) {
        		try {
					fileOut.close();
				} catch (IOException e) {
					log.error("close fileOut error: ", e);
				}
        	}
        	if(Objects.nonNull(wb)) {
        		try {
					wb.close();
				} catch (IOException e) {
					log.error("close wb error: ", e);
				}
        	}
        }
    }

    /** 
     * <pre>
     * 功能描述: 创建文件表头
     * @Title: createHeader 
     * @author: chenhx
     * @param wb 当前操作的工作簿
     * @param sheet 当前操作的sheet
     * @param excelObjVo  Excel基本信息
     * @param pmaVO 考核方案和指标关系
     * @param dataList 数据集合
     * @return: void   
     * @throws 
     * </pre>
     */ 
    private void createHeader(HSSFWorkbook wb, HSSFSheet sheet,
            ExcelObjVo excelObjVo, PmaASchemeIndexRelVo pmaVO,
            List<PmaASchemeIndexRelVo> dataList) {
        // excel总列数
        String[] fixedHeaderArra = excelObjVo.getFixedHeader().split(",");
        int totalColumn = fixedHeaderArra.length
                + pmaVO.getIndexIdArray().length;
        Map<String, BigDecimal> evlObjIndexValueMap
            = this.initEvlObjIndexValueMap(dataList);
        Map<String, String> postnameMap
        = this.initPostnameMap(dataList);
        Map<String, String> unitnameMap
        = this.initUnitnameMap(dataList);
        HSSFCell cell = null;

        /**
         * 1、生成excel第一行
         */
        
        // 创建excel表标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.setHeight((short) 600);
        HSSFCellStyle cellStyle2 = wb.createCellStyle();
        HSSFFont font2 = wb.createFont();
        for (int i = 0; i < totalColumn; i++) {
            cell = titleRow.createCell(i);
        }
        // 合并第一行单元格 ,各参数(rowFrom, colFrom, rowTo, colTo)
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, totalColumn - 1));
        // 创建单元格
        cell = titleRow.createCell(0, HSSFCell.CELL_TYPE_STRING);
        // 给单元格增加样式
        cell = this.getStyleCell(wb, cell, cellStyle2, font2, true, true, true,
                true, false);
        // 向单元格中写入值
        cell.setCellValue(excelObjVo.getTitle());
        HSSFCellStyle cellStyle = wb.createCellStyle();
        HSSFFont font = wb.createFont();
        
        /**
         * 2、生成excel第二、三行
         */
        HSSFRow secondRow = sheet.createRow(1);
        HSSFRow thirdRow = sheet.createRow(2);
        thirdRow.setHeight((short) 800);// 设置行高

        // 左侧固定部分
        // 合并第一行和第二行 并赋值,各参数(rowFrom, colFrom, rowTo, colTo)
        for (int i = 1; i <= fixedHeaderArra.length; i++) {
            sheet.setColumnWidth(i - 1, 60 * 60);// 对列设置宽度为60像素
            HSSFCell cell2 = secondRow.createCell(i - 1,
                    HSSFCell.CELL_TYPE_STRING);
            HSSFCell cell3 = thirdRow.createCell(i - 1,
                    HSSFCell.CELL_TYPE_STRING);
            // 设置单元格样式
            cell2 = this.getStyleCell(wb, cell2, cellStyle, font, false, true,
                    true, true, false);
            cell3 = this.getStyleCell(wb, cell3, cellStyle, font, false, true,
                    true, true, false);
            // 合并固定表头部分（第二行和第三行）
            sheet.addMergedRegion(new CellRangeAddress((short) 1, (short) (i - 1),
                    (short) 2, (short) (i - 1)));
            cell2.setCellValue(fixedHeaderArra[i - 1]);

        }
        // 第二行、第三行的右侧指标部分
        for (int i = fixedHeaderArra.length; i < totalColumn; i++) {
            sheet.setColumnWidth(i, 80 * 80);// 对列设置宽度为60像素
            HSSFCell cell3 = secondRow.createCell(i, HSSFCell.CELL_TYPE_STRING);
            HSSFCell cell4 = thirdRow.createCell(i, HSSFCell.CELL_TYPE_STRING);
            cell3 = this.getStyleCell(wb, cell3, cellStyle, font, false, true,
                    true, true, true);
            cell4 = this.getStyleCell(wb, cell4, cellStyle, font, false, true,
                    true, true, true);
            cell3.setCellValue(pmaVO.getIndexIdArray()[i
                    - fixedHeaderArra.length]);
            cell4.setCellValue(pmaVO.getIndexNameArray()[i
                    - fixedHeaderArra.length]);
        }
        HSSFCellStyle _cellStyle = wb.createCellStyle();
        HSSFFont _font = wb.createFont();
        /**
         * 生成数据区(第四行开始)
         */
        String[] evlObjIdArra = pmaVO.getEvlObjIds().split(",");
        String[] evlObjNameArra = pmaVO.getEvlObjNames().split(",");
        String[] postnameArra = pmaVO.getPostnames().split(",");
        String[] unitnameArra = pmaVO.getUnitnames().split(",");
        int rowCount = evlObjIdArra.length;// 数据区总行数
        int fixColumnCount = excelObjVo.getFixedHeader().split(",").length;
        int indexColumnCount = pmaVO.getIndexIdArray().length;
        // 数据区总行数为用户界面所选的考核对象的个数
        for (int i = 3; i < rowCount + 3; i++) {
            // (从第四行开始)
            HSSFRow row = sheet.createRow(i);
            //给数据区每行所有单元格设置样式
            for (int m = 0; m < (fixColumnCount + indexColumnCount); m++) {
                cell = row.createCell(m);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell = this.getStyleCell(wb, cell, _cellStyle, _font, false,
                        false, true, true, true);// 常规样式
            }
            row.getCell(0).setCellValue(pmaVO.getStatDate());// 数据日期
            row.getCell(1).setCellValue(pmaVO.getSchemeName());// 考核方案名称
            row.getCell(2).setCellValue(evlObjIdArra[i - 3]);// 考核对象编号
            row.getCell(3).setCellValue(evlObjNameArra[i - 3]);// 考核对象名称
            if (PmaConstantDefine.EVL_OBJ_TYPE_EMPLOYEE.equals(pmaVO.getEvlObjType())) {// 员工
                row.getCell(4).setCellValue(postnameArra[i - 3]);// 考核对象名称
                row.getCell(5).setCellValue(unitnameArra[i - 3]);// 考核对象名称
            }
            
            // 数据区指标部分
            for (int j = fixColumnCount; j < (fixColumnCount + indexColumnCount); j++) {
                String indexDimIdStr = sheet.getRow(1).getCell(j).getStringCellValue();

                // 指标维度ID串
                 String  indexValueStr= evlObjIndexValueMap.get(evlObjIdArra[i - 3] + indexDimIdStr) + "";
                 if(indexValueStr.equals("null")) {
                	 indexValueStr="0";
                 }
                row.getCell(j).setCellValue(indexValueStr);
            }
        }
    }

    /** 
     * <pre>
     * 功能描述: 设置当前单元格样式
     * @Title: getStyleCell 
     * @author: chenhx
     * @param wb 当前操作的工作簿
     * @param cell 当前要设置样式的单元格
     * @param cellStyle 单元格样式
     * @param font 单元格字体
     * @param isTitleFont 是否是标题字体
     * @param isBlod 是否要加粗
     * @param isAlignAndVert 是否水平、垂直对齐
     * @param isWrapText 是否自动换行
     * @param isBackgroundColor 是否有背景颜色
     * @return: HSSFCell 返回设置好样式的当前单元格    
     * </pre>
     */ 
    private HSSFCell getStyleCell(HSSFWorkbook wb, HSSFCell cell,
            HSSFCellStyle cellStyle, HSSFFont font, boolean isTitleFont,
            boolean isBlod, boolean isAlignAndVert, boolean isWrapText,
            boolean isBackgroundColor) {
        if (isTitleFont) {// 如果是标题字体
            font.setBold(true);// 字体加粗
            font.setFontHeightInPoints((short) 20); // 字号为大号
        } else if (isBlod) {
            font.setBold(true);// 字体加粗
            font.setFontHeightInPoints((short) 10);
        } else {
        	font.setBold(true);// 字体加粗
//            font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
            font.setFontHeightInPoints((short) 10);
        }
        // 将字体应用到样式中
        cellStyle.setFont(font);

        if (isAlignAndVert) {// 是否水平垂直居中
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        if (isWrapText) {// 是否自动换行
            cellStyle.setWrapText(true);
        }
        if (isBackgroundColor) {// 是否设置背景颜色(固定位灰色)
//        	HSSFCellStyle.SOLID_FOREGROUND
//        	
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle.setFillForegroundColor((short) HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        }

        // 默认都设置边框
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);

        // 将样式应用到单元格
        cell.setCellStyle(cellStyle);
        return cell;
    }

    /** 
     * <pre>
     * 功能描述: 读取excel数据
     * @Title: readDataFromExcel 
     * @author: chenhx
     * @param filePath 文件路径
     * @return: Map<String,Object>   
     * </pre>
     */ 
    public Map<String, Object> readDataFromExcel(String filePath,String param) {
        //创建map用来存放返回数据
        Map<String, Object> retMap = new HashMap<String, Object>();
        // 存储信息list
        Set<Map<String, String>> alertMsgSet = new HashSet<Map<String, String>>();
        String aditionType = PmaConstantDefine.DATA_ADTIONNAL_TYPE_INDEX;// 补录类型：默认为指标补录
        // 验证文件是否存在
        File file = new File(filePath);
        if (!file.exists()) {
            Map<String, String> alertMap = new HashMap<String, String>();
            alertMap.put("alertMsg", "文件不存在");
            alertMsgSet.add(alertMap);
            retMap.put("flag", "false");
            retMap.put("alertMsg", alertMsgSet);
            return retMap;
        }
        InputStream inputStream = null;
        HSSFWorkbook workbook = null;
        // 读取Excel
        try {
        	inputStream = new FileInputStream(filePath);
            // 创建对Excel工作簿文件的引用
            workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            // 获得总行数,该方法是获取的最后行数下标，所以实际数量应该+1
            int totalRowCount = sheet.getLastRowNum() + 1;
            if (3 >= totalRowCount) {// 无数据
                Map<String, String> alertMap = new HashMap<String, String>();
                alertMap.put("alertMsg", "Excel中无数据");
                alertMsgSet.add(alertMap);
                retMap.put("flag", "false");
                retMap.put("alertMsg", alertMsgSet);
                return retMap;
            }
            // 获得总列数
            int totalcoloumCount = sheet.getRow(1).getPhysicalNumberOfCells();
            String title = this.getStringCellValue(sheet.getRow(0).getCell(0), alertMsgSet);
            if(param.equals("01")){//指标
            	
                    aditionType = PmaConstantDefine.DATA_ADTIONNAL_TYPE_INDEX;
                    if (!"方案指标补录模板".equals(title)) {
                        Map<String, String> alertMap = new HashMap<String, String>();
                        alertMap.put("alertMsg", "已选文件不是标准模板，请选择标准模板");
                        alertMsgSet.add(alertMap);
                        retMap.put("flag", "false");
                        retMap.put("alertMsg", alertMsgSet);
                        return retMap;
                    }
                
            }else  if(param.equals("02")){//目标
            	  
                      aditionType = PmaConstantDefine.DATA_ADTIONNAL_TYPE_TARGET;
                      if (!"方案目标补录模板".equals(title)) {
                          Map<String, String> alertMap = new HashMap<String, String>();
                          alertMap.put("alertMsg", "已选文件不是标准模板，请选择标准模板");
                          alertMsgSet.add(alertMap);
                          retMap.put("flag", "false");
                          retMap.put("alertMsg", alertMsgSet);
                          return retMap;
                      }
                 
            }else  if(param.equals("03")){//基数
            	
                    aditionType = PmaConstantDefine.DATA_ADTIONNAL_TYPE_RADIX;
                    if (!"方案基数补录模板".equals(title)) {
                        Map<String, String> alertMap = new HashMap<String, String>();
                        alertMap.put("alertMsg", "已选文件不是标准模板，请选择标准模板");
                        alertMsgSet.add(alertMap);
                        retMap.put("flag", "false");
                        retMap.put("alertMsg", alertMsgSet);
                        return retMap;
                    }
                
            }else{

                Map<String, String> alertMap = new HashMap<String, String>();
                alertMap.put("alertMsg", "已选文件不是标准模板，请选择标准模板");
                alertMsgSet.add(alertMap);
                retMap.put("flag", "false");
                retMap.put("alertMsg", alertMsgSet);
                return retMap;
            
            }
           
            // (第二行)
            HSSFRow row = null;
            HSSFCell cell = null;
            // 获取考核方案ID、币种、余额类型
            row = sheet.getRow(1);// 获取第二行
            cell = row.getCell(1);// 第二行第二列
            String schemeId = this.getStringCellValue(cell, alertMsgSet).replace("]", "")
                    .substring(this.getStringCellValue(cell, alertMsgSet).replace("]", "")
                            .indexOf('[') + 1);// 考核方案ID

            cell = row.getCell(2);// 第二行第三列
            String evlObjType = this.getStringCellValue(cell, alertMsgSet).replace("]", "")
                    .substring(this.getStringCellValue(cell, alertMsgSet) .replace("]", "")
                            .indexOf('[') + 1);// 考核对象类型

            // 考核方案下的考核对象
            String evlObjArra = this.queryAllEvlObjBySchemeId(schemeId, evlObjType)[0];

            List<PmaFImpFillInfo> list = new ArrayList<PmaFImpFillInfo>();
            for (int i = 3; i < totalRowCount; i++) {// 循环行(第四行开始)
                row = sheet.getRow(i);// 第（i+1）行
                if (null == row) {
                    Map<String, String> alertMap = new HashMap<String, String>();
                    alertMap.put("alertMsg", "第【" + (i + 1) + "】行数据为空");
                    alertMsgSet.add(alertMap);
                    retMap.put("flag", "false");
                    retMap.put("alertMsg", alertMsgSet);
                    continue;

                } else {
                    String statDate = "";
                    String evlObjId = "";
                    if (null == row.getCell(0)) {
                        Map<String, String> alertMap = new HashMap<String, String>();
                        alertMap.put("alertMsg", "第【" + (i + 1)
                                + "】行,第【1】列数据为空");
                        alertMsgSet.add(alertMap);
                        retMap.put("flag", "false");
                        retMap.put("alertMsg", alertMsgSet);
                    } else {
                        // 业务日期
                        statDate = this.getStringCellValue(row.getCell(0),alertMsgSet);
                        this.validateStatDate(statDate, row.getCell(0),alertMsgSet);
                    }
                    if (null == row.getCell(2)) {
                        Map<String, String> alertMap = new HashMap<String, String>();
                        alertMap.put("alertMsg", "第【" + (i + 1)
                                + "】行,第【3】列数据为空");
                        alertMsgSet.add(alertMap);
                        retMap.put("flag", "false");
                        retMap.put("alertMsg", alertMsgSet);
                    } else {
                        /*
                         * 验证数据日期格式是否正确
                         */
                        // 考核对象ID
                        evlObjId = this.getStringCellValue(row.getCell(2), alertMsgSet);
                        if (!evlObjArra.contains(evlObjId)) {// 如果考核对象不在考核方案下
                            Map<String, String> alertMap = new HashMap<String, String>();
                            alertMap.put("alertMsg", "第【"
                                    + (row.getCell(2).getRowIndex() + 1)
                                    + "】行的考核对象不在考该核方案下,无法对其进行补录,请删除后再进行补录");
                            alertMsgSet.add(alertMap);
                            retMap.put("flag", "false");
                            retMap.put("alertMsg", alertMsgSet);
                        }
                    }
                    
                    
                    if (PmaConstantDefine.EVL_OBJ_TYPE_EMPLOYEE.equals(evlObjType)) {
                    	 // 循环列（从第5列开始）获取指标号和指标值
                        for (int j = 6; j < totalcoloumCount; j++) {
                            if (null == sheet.getRow(1).getCell(j)) {
                                Map<String, String> alertMap = new HashMap<String, String>();
                                alertMap.put("alertMsg", "第【" + (i + 1) + "】行,第【"
                                        + (j + 1) + "】列数据为空");
                                alertMsgSet.add(alertMap);
                                retMap.put("flag", "false");
                                retMap.put("alertMsg", alertMsgSet);
                                continue;
                            }

                            String indexDimIds = this.getStringCellValue(
                                    sheet.getRow(1).getCell(j), alertMsgSet);// 指标维度id串
                            /**
                             * 解析指标维度串
                             * */
                            String indexDimArra[] = this.analysisIndexDim(indexDimIds);
                            
                            String indexId = indexDimArra[0];
                            
                            String balTypeId = indexDimArra[1];
                            String curTypeId = indexDimArra[2];
                            String applyTypeId = indexDimArra[3];
                            evlObjType = indexDimArra[4];
                            String appraiseTypeId= indexDimArra[5];
                            
                            /**
                             * 
                             * retIndexDimArra[1] = dimArra.substring(0, 2);	// 发生额   this.balTypeId = balTypeId;// 余额类型
                             * retIndexDimArra[2] = dimArra.substring(3, 5);	// 外折本   this.curTypeId = curTypeId; // 币种
                             * retIndexDimArra[3] = dimArra.substring(6, 8);	// 指标       this.applyTypeId = applyTypeId; // 应用类型
                             * retIndexDimArra[4] = dimArra.substring(9, 11);	// 机构       this.evlObjType = evlObjType;// 考核对象类型
                             * retIndexDimArra[5] = dimArra.substring(12, 14);	// 账面	appraiseTypeId
                             * 
                             */
                            
                            if (null == row.getCell(j)) {
                                Map<String, String> alertMap = new HashMap<String, String>();
                                alertMap.put("alertMsg", "第【" + (i + 1) + "】行,第【"
                                        + (j + 1) + "】列数据为空");
                                alertMsgSet.add(alertMap);
                                retMap.put("flag", "false");
                                retMap.put("alertMsg", alertMsgSet);
                                continue;
                            }

                            BigDecimal indexValue = new BigDecimal(0);
                            if (HSSFCell.CELL_TYPE_NUMERIC == row.getCell(j)
                                    .getCellType()) {
                                double indexValueDb = row.getCell(j).getNumericCellValue();
                                // 指标值(精确至小数点后四位)
                                indexValue = new BigDecimal(indexValueDb)
                                    .setScale(4, BigDecimal.ROUND_HALF_UP);
                            } else if (HSSFCell.CELL_TYPE_STRING == row.getCell(j)
                                    .getCellType()) {
                                try {
                                 // 指标值(精确至小数点后四位)
                                    indexValue = new BigDecimal(
                                            row.getCell(j).getStringCellValue()).setScale(4);
                                } catch (Exception e) {
                                    String msg = "指标值有误";
                                    this.setMsg(row.getCell(j), alertMsgSet, msg);
                                }
                            } else {
                                String msg = "指标值有误";
                                this.setMsg(row.getCell(j), alertMsgSet, msg);
                            }

                            // 将数据放入model
                            PmaFImpFillInfo pmaFImpFillInfo = new PmaFImpFillInfo();
//                            statDate, schemeId, curTypeId, balTypeId, evlObjType, applyTypeId, appraiseTypeId
                            pmaFImpFillInfo.setSchemeId(schemeId);
                            pmaFImpFillInfo.setCurTypeId(curTypeId);
                            pmaFImpFillInfo.setBalTypeId(balTypeId);
                            pmaFImpFillInfo.setEvlObjType(evlObjType);
                            pmaFImpFillInfo.setApplyTypeId(applyTypeId);
                            pmaFImpFillInfo.setAppraiseTypeId(appraiseTypeId);
                            
                            pmaFImpFillInfo.setStartDate(statDate);
                            pmaFImpFillInfo.setEvlObjId(evlObjId);
                            pmaFImpFillInfo.setIndexId(indexId);
                            pmaFImpFillInfo.setIndexValue(indexValue);

                            list.add(pmaFImpFillInfo);
                        }
                    }else {
                    	 // 循环列（从第5列开始）获取指标号和指标值
                        for (int j = 4; j < totalcoloumCount; j++) {
                            if (null == sheet.getRow(1).getCell(j)) {
                                Map<String, String> alertMap = new HashMap<String, String>();
                                alertMap.put("alertMsg", "第【" + (i + 1) + "】行,第【"
                                        + (j + 1) + "】列数据为空");
                                alertMsgSet.add(alertMap);
                                retMap.put("flag", "false");
                                retMap.put("alertMsg", alertMsgSet);
                                continue;
                            }

                            String indexDimIds = this.getStringCellValue(
                                    sheet.getRow(1).getCell(j), alertMsgSet);// 指标维度id串
                            /**
                             * 解析指标维度串
                             * */
                            String indexDimArra[] = this.analysisIndexDim(indexDimIds);
                            
                            String indexId = indexDimArra[0];
                            
                            String balTypeId = indexDimArra[1];
                            String curTypeId = indexDimArra[2];
                            String applyTypeId = indexDimArra[3];
                            evlObjType = indexDimArra[4];
                            String appraiseTypeId= indexDimArra[5];
                            
                            /**
                             * 
                             * retIndexDimArra[1] = dimArra.substring(0, 2);	// 发生额   this.balTypeId = balTypeId;// 余额类型
                             * retIndexDimArra[2] = dimArra.substring(3, 5);	// 外折本   this.curTypeId = curTypeId; // 币种
                             * retIndexDimArra[3] = dimArra.substring(6, 8);	// 指标       this.applyTypeId = applyTypeId; // 应用类型
                             * retIndexDimArra[4] = dimArra.substring(9, 11);	// 机构       this.evlObjType = evlObjType;// 考核对象类型
                             * retIndexDimArra[5] = dimArra.substring(12, 14);	// 账面	appraiseTypeId
                             * 
                             */
                            
                            if (null == row.getCell(j)) {
                                Map<String, String> alertMap = new HashMap<String, String>();
                                alertMap.put("alertMsg", "第【" + (i + 1) + "】行,第【"
                                        + (j + 1) + "】列数据为空");
                                alertMsgSet.add(alertMap);
                                retMap.put("flag", "false");
                                retMap.put("alertMsg", alertMsgSet);
                                continue;
                            }

                            BigDecimal indexValue = new BigDecimal(0);
                            if (HSSFCell.CELL_TYPE_NUMERIC == row.getCell(j)
                                    .getCellType()) {
                                double indexValueDb = row.getCell(j).getNumericCellValue();
                                // 指标值(精确至小数点后四位)
                                indexValue = new BigDecimal(indexValueDb)
                                    .setScale(4, BigDecimal.ROUND_HALF_UP);
                            } else if (HSSFCell.CELL_TYPE_STRING == row.getCell(j)
                                    .getCellType()) {
                                try {
                                 // 指标值(精确至小数点后四位)
                                    indexValue = new BigDecimal(
                                            row.getCell(j).getStringCellValue()).setScale(4);
                                } catch (Exception e) {
                                    String msg = "指标值有误";
                                    this.setMsg(row.getCell(j), alertMsgSet, msg);
                                }
                            } else {
                                String msg = "指标值有误";
                                this.setMsg(row.getCell(j), alertMsgSet, msg);
                            }

                            // 将数据放入model
                            PmaFImpFillInfo pmaFImpFillInfo = new PmaFImpFillInfo();
                            //statDate, schemeId, curTypeId, balTypeId, evlObjType, applyTypeId, appraiseTypeId
                            pmaFImpFillInfo.setSchemeId(schemeId);
                            pmaFImpFillInfo.setCurTypeId(curTypeId);
                            pmaFImpFillInfo.setBalTypeId(balTypeId);
                            pmaFImpFillInfo.setEvlObjType(evlObjType);
                            pmaFImpFillInfo.setApplyTypeId(applyTypeId);
                            pmaFImpFillInfo.setAppraiseTypeId(appraiseTypeId);
                            pmaFImpFillInfo.setEvlObjId(evlObjId);
                            pmaFImpFillInfo.setIndexId(indexId);
                            pmaFImpFillInfo.setIndexValue(indexValue);

                            list.add(pmaFImpFillInfo);
                        }
                    }

                }
            }
            //验证考核对象是否在该考核方案下且是否被删除
            if (alertMsgSet != null && alertMsgSet.size() > 0) {// 数据未通过验证,导入失败
                retMap.put("flag", "false");
                retMap.put("alertMsg", alertMsgSet);
            } else {
                retMap.put("flag", "true");
                retMap.put("dataList", list);
            }
            retMap.put("aditionType", aditionType);// 补录类型(指标补录、目标补录、基数补录)
        } catch (FileNotFoundException e) {
            Map<String, String> alertMap = new HashMap<String, String>();
            alertMap.put("alertMsg", "已选文件不是标准模板，请选择标准模板");
            alertMsgSet.add(alertMap);
            retMap.put("flag", "false");
            retMap.put("alertMsg", alertMsgSet);
            return retMap;
        } catch (IOException e) {
            log.error("数据补录管理导入失败,上传文件读写权限异常",e);
        } finally {
        	if(Objects.nonNull(workbook)) {
        		try {
					workbook.close();
				} catch (IOException e) {
					log.error("close workbook error: ", e);
				}
        	}
        	if(Objects.nonNull(inputStream)) {
        		try {
					inputStream.close();
				} catch (IOException e) {
					log.error("close inputStream error: ", e);
				}
        	}
        }
        return retMap;
    }

    /** 
     * <pre>
     * 功能描述: 以字符串的形式获取当前单元格内容
     * @Title: getStringCellValue 
     * @author: chenhx
     * @param cell 当前单元格
     * @param alertMsgSet 错误提示
     * @return: String   
     * </pre>
     */ 
    private String getStringCellValue(HSSFCell cell,
            Set<Map<String, String>> alertMsgSet) {
        String str = "";
        if (HSSFCell.CELL_TYPE_BLANK == cell.getCellType()) {
            String msg = "该单元格数据不能为空";
            this.setMsg(cell, alertMsgSet, msg);
        } else if (HSSFCell.CELL_TYPE_BOOLEAN == cell.getCellType()) {
            str += cell.getBooleanCellValue();
        } else if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
            str += cell.getNumericCellValue();
            str = str.substring(0, str.length() - 2);
        } else if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) {
            str = cell.getStringCellValue();
        } else {
            String msg = "该单元格信息格式有误，请检查";
            this.setMsg(cell, alertMsgSet, msg);
        }
        if ("".equals(str)) {
            String msg = "该单元格信息格式有误或为空";
            this.setMsg(cell, alertMsgSet, msg);
        }
        return str;
    }

    /** 
     * <pre>
     * 功能描述: 设置信息（用于excel）
     * @Title: setMsg 
     * @author: chenhx
     * @param cell 当前操作的单元格
     * @param alertMsgSet 返回的信息map
     * @param msg 信息内容    
     * </pre>
     */ 
    private void setMsg(HSSFCell cell, Set<Map<String, String>> alertMsgSet,
            String msg) {
        Map<String, String> alertMap = new HashMap<String, String>();

        if (null != cell) {
            alertMap.put("alertMsg", "第【" + (cell.getRowIndex() + 1) + "行】，第【"
                    + (cell.getColumnIndex() + 1) + "】列：" + msg);
        } else {
            alertMap.put("alertMsg", msg);
        }
        alertMsgSet.add(alertMap);
    }

    /** 
     * <pre>
     * 功能描述: 返回处理过的model :读取excel后根据 业务日期、考核方案ID、考核对象ID、
     *              考核对象类型、余额类型、币种、应用类型、指标编号 这8个业务
     *          主键判断库中是否有这条数据，如果有则导入为修改，否则为新增；
     *          修改即把当前model的ID赋值，并将当前model的修改人、
     *          修改日期、修改人ID赋值后将其返回；
     *          新增即把当前model的ID置空，并将创建人ID、创建人、创建日期赋值后将其返回)
     * @Title: getModel 
     * @author: chenhx
     * @param pmaFImpFillInfo 补录信息
     * @return: PmaFImpFillInfo   
     * </pre>
     */ 
    @SuppressWarnings({ "unchecked", "unused" })
    private PmaFImpFillInfo getModel(PmaFImpFillInfo pmaFImpFillInfo) {
//        AuthUser auth = (AuthUser) SecurityContextHolder.getContext()
//                .getAuthentication().getPrincipal();
        StringBuilder jql = new StringBuilder();
        jql.append("select p from PmaFImpFillInfo p ");
        jql.append(" where p.statDate =:statDate ");
        jql.append(" and p.schemeId =:schemeId " );
        jql.append(" and p.evlObjId =:evlObjId ");
        jql.append(" and p.evlObjType =:evlObjType ");
        jql.append(" and p.balTypeId =:balTypeId ");
        jql.append(" and p.curTypeId =:curTypeId ");
        jql.append(" and p.applyTypeId =:applyTypeId ");
        jql.append(" and p.indexId =:indexId ");
        // 设置查询条件值
        Map<String, Object> values = new HashMap<String, Object>();
        try {
            values.put("statDate", 
                    PmaCommonUtil.transDateStrToStr(pmaFImpFillInfo.getStatDate()));
        } catch (Exception e) {
            values.put("statDate", null);
        }
        values.put("schemeId", pmaFImpFillInfo.getSchemeId());
        values.put("evlObjId", pmaFImpFillInfo.getEvlObjId());
        values.put("evlObjType", pmaFImpFillInfo.getEvlObjType());
        values.put("balTypeId", pmaFImpFillInfo.getBalTypeId());
        values.put("curTypeId", pmaFImpFillInfo.getCurTypeId());
        values.put("applyTypeId", pmaFImpFillInfo.getApplyTypeId());
        values.put("indexId", pmaFImpFillInfo.getIndexId());

        // 根据8个业务主键查询数据
        List<PmaFImpFillInfo> list = new ArrayList<PmaFImpFillInfo>();
//        list = this.findByJql(jql.toString(), values);
        if (1 == list.size()) {// 如果有数据，则说明为修改
            // 即把当前model的ID赋值，并将当前model的指标值、修改人、修改日期、修改人ID赋值
            BigDecimal indexValue = pmaFImpFillInfo.getIndexValue();
            pmaFImpFillInfo = list.get(0);
            pmaFImpFillInfo.setModifyDate(DateUtil.getShortNoSymbol());// 修改日期
            pmaFImpFillInfo.setModifyUser(getUser().getUserName());// 修改人
            pmaFImpFillInfo.setModifyUserId(getUser().getLoginCode());// 修改人ID
            pmaFImpFillInfo.setIndexValue(indexValue);
            pmaFImpFillInfo.setStatDate(
                    PmaCommonUtil.transStrToDateStr(pmaFImpFillInfo.getStatDate()));
            pmaFImpFillInfo.setEndDate(
                    PmaCommonUtil.transStrToDateStr(pmaFImpFillInfo.getEndDate()));
        } else {// 即把当前model的ID置空，并将创建人ID、创建人、创建日期赋值
            pmaFImpFillInfo.setCreateDate(DateUtil.getShortNoSymbol());// 创建日期
            pmaFImpFillInfo.setCreator(getUser().getUserName());// 创建人
            pmaFImpFillInfo.setCreatorId(getUser().getLoginCode());// 创建人ID
        }
        return pmaFImpFillInfo;
    }

    /** 
     * <pre>
     * 功能描述: 获取考核方案关联的考核对象及考核指标的值
     * @Title: queryBaseIndexValue 
     * @author: chenhx
     * @param pmaVo : 考核方案和指标关系VO
     * @return: List<PmaASchemeIndexRelVo>   
     * </pre>
     */ 
    @SuppressWarnings("unchecked")
    public List<PmaASchemeIndexRelVo> queryBaseIndexValue(PmaASchemeIndexRelVo pmaVo) {
        List<PmaASchemeIndexRelVo> list = new ArrayList<PmaASchemeIndexRelVo>();

        StringBuffer sql = new StringBuffer();
        sql.append("SELECT DISTINCT ");
        if (pmaVo.getAditionType().equals(
                PmaConstantDefine.DATA_ADTIONNAL_TYPE_TARGET)) {
            sql.append(pmaVo.getStatDate() + " AS  STAT_DATE ");
        } else {
            sql.append(" S.STAT_DATE ");
        }
        sql.append(",M.SCHEME_ID, M.EVL_OBJ_TYPE, M.EVL_OBJ_ID, ");
        sql.append(" M.EVL_OBJ_NAME, H.INDEX_ID,  H.INDEX_NAME, ");

        if (pmaVo.getAditionType().equals(
                PmaConstantDefine.DATA_ADTIONNAL_TYPE_TARGET)) {
            // 如果为目标补录，直接到补录表（PMA_F_IMP_FILL_INFO）取目标值
            sql.append(" NVL(XX.INDEX_VALUE,0) AS INDEX_VALUE, ");
        } else {
            /*
             * 如果为指标补录或者基数补录，先从补录表（PMA_F_IMP_FILL_INFO）取值，
             * 如果值不存在则到基础指标结果事实表（pma_f_base_index_res）中取值，如果没有值，则为：0
             */
            sql.append(" NVL(NVL(S.INDEX_VALUE,XX.INDEX_VALUE),0) AS INDEX_VALUE, ");
        }
        sql.append(" H.BAL_TYPE_ID, H.CUR_TYPE_ID, H.APPLY_TYPE_ID, " );
        sql.append(" H.INDEX_DIM_ID FROM (SELECT A.SCHEME_ID, A.INDEX_ID, ");
        sql.append(" B.EVL_OBJ_TYPE, B.EVL_OBJ_ID,");
        if (PmaConstantDefine.EVL_OBJ_TYPE_EMPLOYEE.equals(
                pmaVo.getEvlObjType())) {// 员工
            sql.append(" U.USERNAME AS EVL_OBJ_NAME,U.POSTNAME,U.UNITNAME ");
        } else
        	//if (PmaConstantDefine.EVL_OBJ_TYPE_ORG.equals(
               // pmaVo.getEvlObjType())) 
        	{// 机构
            sql.append(" U.UNITNAME AS EVL_OBJ_NAME ");
        }
        sql.append(" FROM PMA_A_SCHEME_INDEX_REL A ");//考核方案与指标关系表
        sql.append(" INNER JOIN PMA_A_SCHEME_EVLOBJ_REL B ");//考核方案评价对象表
        sql.append(" ON A.SCHEME_ID = B.SCHEME_ID ");
        sql.append(" AND A.EVL_OBJ_TYPE = B.EVL_OBJ_TYPE");
        if (PmaConstantDefine.EVL_OBJ_TYPE_EMPLOYEE.equals(pmaVo
                .getEvlObjType())) {// 员工
            sql.append(" LEFT JOIN SYS_USERS U ON U.USERID = B.EVL_OBJ_ID ");
        } else 
        	//if (PmaConstantDefine.EVL_OBJ_TYPE_ORG.equals(pmaVo
                //.getEvlObjType())) 
        	{// 机构
            sql.append(" LEFT JOIN SYS_ORG_DEPART_TEAM U ON U.UNITID = B.EVL_OBJ_ID ");
        }
        sql.append(" WHERE A.INDEX_TYPE = '"+ PmaConstantDefine.INDEX_TYPE_BASE_INDEX);
        sql.append("' AND B.EVL_OBJ_TYPE = '" + pmaVo.getEvlObjType() + "') M ");
        sql.append(" LEFT JOIN (SELECT C.INDEX_ID, C.INDEX_NAME, D.BAL_TYPE_ID, ");
        sql.append(" E.CUR_TYPE_ID, G.APPLY_TYPE_ID, C.INDEX_ID ||'[' || ");
        sql.append(" D.BAL_TYPE_ID || '.' || E.CUR_TYPE_ID || '.' || ");
        sql.append(" G.APPLY_TYPE_ID || ']' AS INDEX_DIM_ID");
        sql.append(" FROM PMA_F_BASE_INDEX_INFO C ");//基础指标信息表
        sql.append(" LEFT JOIN PMA_F_INDEX_BAL_INFO D ");//余额类型维表
        sql.append(" ON D.INDEX_ID = C.INDEX_ID ");
        sql.append(" LEFT JOIN PMA_F_CUR_DIM E ");//币种维表
        sql.append("  ON E.INDEX_ID = C.INDEX_ID ");
        sql.append(" LEFT JOIN PMA_F_INDEX_EVL_OBJ_INFO F ");//考核对象维表
        sql.append(" ON F.INDEX_ID = C.INDEX_ID ");
        sql.append(" LEFT JOIN PMA_F_INDEX_APPLY_INFO G ");//应用类型维表
        sql.append(" ON G.INDEX_ID = C.INDEX_ID " );
        sql.append("  WHERE C.STAT_FLAG = '" + PmaConstantDefine.STST_FLAG_EFFECT + "' ");
        if (PmaConstantDefine.DATA_ADTIONNAL_TYPE_INDEX.equals(
                pmaVo.getAditionType())||PmaConstantDefine.DATA_ADTIONNAL_TYPE_RADIX.equals(pmaVo.getAditionType())) {// 指标补录
            sql.append(" AND C.LOGIC_TYPE = '"
                    + PmaConstantDefine.BASE_INDEX_LOGIC_TYPE_IMP + "' ");
        } else {// 如果是目标和基数补录不做过滤

        }
        sql.append(" ) H ON M.INDEX_ID = H.INDEX_ID  ");
        if (pmaVo.getAditionType().equals(
                PmaConstantDefine.DATA_ADTIONNAL_TYPE_TARGET)) {
            // 如果为目标补录，直接到补录表（pMA_F_IMP_FILL_INFO）取目标值

        } else {
            /*
             * 如果为指标补录或者基数补录，先从补录表（PMA_F_IMP_FILL_INFO）取值，
             * 如果值不存在则到基础指标结果事实表（pma_f_base_index_res）中取值，如果没有值，则为：0
             */
            sql.append(" LEFT JOIN PMA_F_BASE_INDEX_RES S ");//基础指标加工结果事实表
            sql.append(" ON H.INDEX_ID = S.INDEX_ID " );
            sql.append(" AND S.STAT_DATE = '" );
            sql.append(PmaCommonUtil.transDateStrToStr(pmaVo.getStatDate()));
            sql.append("' AND H.BAL_TYPE_ID = S.BAL_TYPE_ID ");
            sql.append(" AND H.CUR_TYPE_ID = S.CUR_TYPE_ID ");
            sql.append(" AND H.APPLY_TYPE_ID = S.APPLY_TYPE_ID ");
            sql.append(" AND M.EVL_OBJ_TYPE = S.EVL_OBJ_TYPE ");
            sql.append(" AND M.EVL_OBJ_ID = S.EVL_OBJ_ID ");
        }
        sql.append(" LEFT JOIN PMA_F_IMP_FILL_INFO XX " );
        sql.append(" ON XX.STAT_DATE = '");
        sql.append(PmaCommonUtil.transDateStrToStr(pmaVo.getStatDate()));
        sql.append("' AND XX.SCHEME_ID = M.SCHEME_ID ");
        sql.append(" AND XX.INDEX_ID = H.INDEX_ID ");
        sql.append(" AND XX.EVL_OBJ_TYPE = M.EVL_OBJ_TYPE ");
        sql.append(" AND XX.EVL_OBJ_ID = M.EVL_OBJ_ID ");
        sql.append(" AND XX.BAL_TYPE_ID = H.BAL_TYPE_ID ");
        sql.append(" AND XX.CUR_TYPE_ID = H.CUR_TYPE_ID ");
        sql.append(" AND XX.APPLY_TYPE_ID = H.APPLY_TYPE_ID ");

        sql.append(" WHERE 1=1 ");
        sql.append(" AND M.SCHEME_ID ='" + pmaVo.getSchemeId() + "' ");
        sql.append(" AND M.EVL_OBJ_ID IN ('"
                + pmaVo.getEvlObjIds().replace(",", "','") + "')");
        sql.append(" AND H.INDEX_DIM_ID IN ('"
                + pmaVo.getIndexDimIdAll().replace(",", "','") + "') ");
        // 拼接
       /* try
        {
            QueryHelper queryHelper = new QueryHelper(sql.toString(), ds.getConnection());
            List<Map<String, Object>> list2 = (List<Map<String, Object>>) (queryHelper.getJSON(true).get("data"));
            if (null != list2 && 0 < list2.size())
            {
                for (int i = 0; i < list2.size(); i++)
                {
                    Map<String, Object> dataMap = new HashMap<String, Object>();
                    dataMap = list2.get(i);
                    PmaASchemeIndexRelVo pmaVOTemp = new PmaASchemeIndexRelVo();
                    
                    pmaVOTemp.setStatDate((String) dataMap.get("statDate"));// 日期
                    pmaVOTemp.setSchemeId((String) dataMap.get("schemeId"));// 考核方案ID
                    pmaVOTemp.setSchemeName(pmaVo.getSchemeName());// 考核方案名称
                    pmaVOTemp.setEvlObjId((String) dataMap.get("evlObjId"));// 考核对象编号
                    pmaVOTemp.setEvlObjId((String) dataMap.get("evlObjId"));// 考核对象名称
                    if (PmaConstantDefine.EVL_OBJ_TYPE_EMPLOYEE.equals(
                            pmaVo.getEvlObjType())) {// 员工
                    	pmaVOTemp.setPostname((String) dataMap.get("postname"));
                    	pmaVOTemp.setUnitname((String) dataMap.get("unitname"));
                    }
                    // 维度ID指标串(格式：B0001179[01.AA.00])
                    String dimIdIndexStr = (String) dataMap.get("indexId")  + "[" + (String) dataMap.get("balTypeId") + "."
                            + (String) dataMap.get("curTypeId") + "."
                            + (String) dataMap.get("applyTypeId") + "b]";
                    pmaVOTemp.setIndexDimIdAll(dimIdIndexStr);
                    // 维度Name指标串（格式：指标名称A[月日均.折人民币.月目标]）
                    String balTypeName = LookupManager.getInstance().getOracleValues("YE_TYPE").get((String) dataMap.get("balTypeId"));
                    String curTypeName = LookupManager.getInstance().getOracleValues("BZ_TYPE").get((String) dataMap.get("curTypeId"));
                    String applyTypeName = LookupManager.getInstance().getOracleValues("INDEX_APPLY_TYPE").get((String) dataMap.get("applyTypeId"));
                    String dimNameIndexStr = (String) dataMap.get("indexName") + "[" + balTypeName + "." + curTypeName + "." + applyTypeName + "." + "A]";
                    pmaVOTemp.setIndexDimNameAll(dimNameIndexStr);

                    pmaVOTemp.setIndexValue(new BigDecimal((String) dataMap.get("indexValue")));

                    list.add(pmaVOTemp);

                }
            }
        } catch (SQLException e) {
//            log.info("查询基础指标值时发生错误,获取连接异常.",e);
            e.printStackTrace();
        }*/
        return list;
    }

    /** 
     * <pre>
     * 功能描述: 解析指标维度串（包含维度ID串和维度名称串）
     * @Title: analysisIndexDim 
     * @author: chenhx
     * @param indexDimStr 格式：B0000046[05.AA.00] 
     *                     四年期（含）以下个人贷款[月利润.折人民币.指标]
     * @return: String['指标ID','余额类型','币种','应用类型'][发生额.外折本.指标.机构.账面]
     * </pre>
     */ 
    public String[] analysisIndexDim(String indexDimStr) {
        // B0000046[05.AA.00.00.00]
        // 四年期（含）以下个人贷款[月利润.折人民币.指标]
        String[] retIndexDimArra = new String[6];
        if (null != indexDimStr && !"".equals(indexDimStr)) {
            retIndexDimArra[0] = indexDimStr.substring(0,
                    indexDimStr.indexOf('['));// 第一位指标编号
            String dimArra = indexDimStr.substring(
                    indexDimStr.indexOf('[') + 1, indexDimStr.length() - 1);
            retIndexDimArra[1] = dimArra.substring(0, 2);	// 发生额
            retIndexDimArra[2] = dimArra.substring(3, 5);	// 外折本
            retIndexDimArra[3] = dimArra.substring(6, 8);	// 指标
            retIndexDimArra[4] = dimArra.substring(9, 11);	// 机构
            retIndexDimArra[5] = dimArra.substring(12, 14);	// 账面
        }
        return retIndexDimArra;
    }

    /**
     * <pre>
     *  验证日期格式是否正确
     * @author  zh_haining@yuchengtech.com
     * 参数列表：
     *     @param statDate
     *     @param cell
     *     @param alertMsgSet
     * ReturnType: void
     * 所在文件:com.yuchengtech.pma.aditionalrecordmanage.service.DataImportManageService.java
     * 修改时间:2014-7-8 下午01:08:09 修改人：          修改后版本:@version 1.00.00
     * </pre>
     * */
    private void validateStatDate(String statDate, HSSFCell cell,
            Set<Map<String, String>> alertMsgSet) {
        // 日期格式：2014-05-08
        if (null == statDate || "".equals(statDate) || statDate.length() != 10
                || statDate.indexOf('-') == -1) {
            Map<String, String> alertMap = new HashMap<String, String>();

            alertMap.put("alertMsg", "第【" + (cell.getRowIndex() + 1) + "行】，第【"
                    + (cell.getColumnIndex() + 1)
                    + "】列日期格式错误，正确日期格式如：2014-05-08");
            alertMsgSet.add(alertMap);
        } else {

        }
    }

    /** 
     * <pre>
     * 功能描述: 获取考核方案下的所有考核对象
     * @Title: queryAllEvlObjBySchemeId 
     * @author: chenhx
     * @param schemeId 考核方案ID
     * @param evlObjType 考核对象类型
     * @return: String[]   
     * </pre>
     */ 
    @SuppressWarnings("unchecked")
    public String[] queryAllEvlObjBySchemeId(String schemeId, String evlObjType) {
        String evlObjIds = "";
        String evlObjNames = "";
        String postnames = "";
        String unitnames = "";

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT A.EVL_OBJ_ID ");
        if("01".equals(evlObjType)){
            sql.append(" ||'###'|| B.USERNAME||'###'||B.POSTNAME||'###'||B.UNITNAME ");
        }else if("02".equals(evlObjType)){
            sql.append(" ||'###'|| B.UNITNAME ");
        }else if("03".equals(evlObjType)){
            sql.append(" ||'###'|| B.UNITNAME ");
        }
        sql.append(" FROM    PMA_A_SCHEME_EVLOBJ_REL A " );
        if("01".equals(evlObjType)){
            sql.append(" INNER JOIN SYS_USERS B " );
            sql.append(" ON A.EVL_OBJ_ID = B.USERID ");
        }else if("02".equals(evlObjType)){
            sql.append(" INNER JOIN SYS_ORG_DEPART_TEAM B " );
            sql.append(" ON A.EVL_OBJ_ID = B.UNITID ");
        }else if("03".equals(evlObjType)){
            sql.append(" INNER JOIN SYS_ORG_DEPART_TEAM B " );
            sql.append(" ON A.EVL_OBJ_ID = B.UNITID ");
        }
        sql.append(" WHERE A.SCHEME_ID = '" + schemeId );
        sql.append("' AND A.EVL_OBJ_TYPE = '" + evlObjType + "' ");
        /*List<String> list = this.baseDAO.findByNativeSQLWithNameParam(sql.toString(), null);
        if (null != list && 0 < list.size()) {
            for (int i = 0; i < list.size(); i++) {
                String _evlObj = list.get(i);
                evlObjIds += _evlObj.split("###")[0];
                evlObjNames += _evlObj.split("###")[1];
                if("01".equals(evlObjType)){
                	postnames+=	_evlObj.split("###")[2];
                	unitnames+=	_evlObj.split("###")[3];
                }
                if (i != list.size() - 1) {
                    evlObjIds += ",";
                    evlObjNames += ",";
                    if("01".equals(evlObjType)){
                    	postnames+= ",";
                    	unitnames+= ",";
                    }
                }
            }
        }*/
        

        if("01".equals(evlObjType)){
            String retStrArra[] = new String[4];
            retStrArra[0] = evlObjIds;
            retStrArra[1] = evlObjNames;
            retStrArra[2]=postnames;
            retStrArra[3]=unitnames;
            return retStrArra;
        }else {
        	String retStrArra[] = new String[2];  
            retStrArra[0] = evlObjIds;
            retStrArra[1] = evlObjNames;
            return retStrArra;
        }
    }
    /** 
     * <pre>
     * 功能描述: 获取考核方案下的所有考核对象
     * @Title: queryAllEvlObjBySchemeId 
     * @author: chenhx
     * @param evlObjType 
     * @param schemeId 考核方案ID
     * @return: String[]   
     * </pre>
     */ 
    @SuppressWarnings("unchecked")
    public String[] queryPostUnit(String evlObjIds, String evlObjType) {
        String postnames = "";
        String unitnames = "";
        String retStrArra[] = new String[2];
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        if("01".equals(evlObjType)){
            sql.append("B.POSTNAME||'###'||B.UNITNAME ");
        }
        sql.append(" FROM    SYS_USERS B " );
        sql.append(" WHERE B.USERID IN ('"+evlObjIds.replace(",", "','")+"')");
        /*List<String> list = this.baseDAO.findByNativeSQLWithNameParam(sql.toString(), null);
        if (null != list && 0 < list.size()) {
            for (int i = 0; i < list.size(); i++) {
                String _evlObj = list.get(i);
                postnames += _evlObj.split("###")[0];
                unitnames += _evlObj.split("###")[1];
                if (i != list.size() - 1) {
                	postnames += ",";
                	unitnames += ",";
                }
            }
        }*/
        
        retStrArra[0] = postnames;
        retStrArra[1] = unitnames;
        return retStrArra;
    }
    /** 
     * <pre>
     * 功能描述: 将考核对象考核指标维度和指标值放入map
     * @Title: initEvlObjIndexValueMap 
     * @author: chenhx
     * @param dataList 数据集合
     * @return: Map<String,BigDecimal>   
     * </pre>
     */ 
    private Map<String, BigDecimal> initEvlObjIndexValueMap(
            List<PmaASchemeIndexRelVo> dataList) {
        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        if (null != dataList && 0 < dataList.size()) {
            for (int i = 0; i < dataList.size(); i++) {
                // key:考核对象ID+考核指标维度ID串 value:考核指标值
                map.put(dataList.get(i).getEvlObjId()
                        + dataList.get(i).getIndexDimIdAll(),
                            dataList.get(i).getIndexValue());
            }
        }
        return map;
    }
    /** 
     * <pre>
     * 功能描述: 将考核对象考核指标维度和指标值放入map
     * @Title: initEvlObjIndexValueMap 
     * @author: chenhx
     * @param dataList 数据集合
     * @return: Map<String,BigDecimal>   
     * </pre>
     */ 
    private Map<String, String> initPostnameMap(
            List<PmaASchemeIndexRelVo> dataList) {
        Map<String, String> map = new HashMap<String, String>();
        if (null != dataList && 0 < dataList.size()) {
            for (int i = 0; i < dataList.size(); i++) {
                // key:考核对象ID+考核指标维度ID串 value:考核指标值
                map.put(dataList.get(i).getEvlObjId()
                        + dataList.get(i).getIndexDimIdAll(),
                            dataList.get(i).getPostname());
            }
        }
        return map;
    }
    /** 
     * <pre>
     * 功能描述: 将考核对象考核指标维度和指标值放入map
     * @Title: initEvlObjIndexValueMap 
     * @author: chenhx
     * @param dataList 数据集合
     * @return: Map<String,BigDecimal>   
     * </pre>
     */ 
    private Map<String, String> initUnitnameMap(
            List<PmaASchemeIndexRelVo> dataList) {
        Map<String, String> map = new HashMap<String, String>();
        if (null != dataList && 0 < dataList.size()) {
            for (int i = 0; i < dataList.size(); i++) {
                // key:考核对象ID+考核指标维度ID串 value:考核指标值
                map.put(dataList.get(i).getEvlObjId()
                        + dataList.get(i).getIndexDimIdAll(),
                            dataList.get(i).getUnitname());
            }
        }
        return map;
    }
    private UserInfoDTO getUser() {
        UserInfoDTO user = userInfoService.getUserInfo();
    	return user;
    }
}