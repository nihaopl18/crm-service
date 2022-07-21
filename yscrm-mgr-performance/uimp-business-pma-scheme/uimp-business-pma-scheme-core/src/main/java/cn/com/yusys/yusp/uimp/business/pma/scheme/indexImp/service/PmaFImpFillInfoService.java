package cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.service;

import cn.com.yusys.yusp.admin.repository.mapper.AdminSmLookupItemMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.file.FileTypeUtil;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.commons.web.rest.exception.Message;
import cn.com.yusys.yusp.commons.web.rest.exception.YuspException;
import cn.com.yusys.yusp.uimp.base.service.AdminBaseAutoSearchConfService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.domain.PmaFImpFillInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.repository.mapper.PmaFImpFillInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeEvlobjRelMapper;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @version 1.0.0
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFImpFillInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: asus
 * @创建时间: 2020-01-15 17:34:04
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFImpFillInfoService extends CommonService {
    @Autowired
    private PmaFImpFillInfoMapper pmaFImpFillInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(AdminBaseAutoSearchConfService.class);

    @Value("${application.excel.temp-file-dir}")
    private String excelTempFileDir;

    @Value("${application.localDiskPath}")
    private String localDiskPath;

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private PmaFSchemeEvlobjRelMapper pmaFSchemeEvlobjRelMapper;

    @Autowired
    private AdminSmLookupItemMapper adminSmLookupItemMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFImpFillInfoMapper;
    }

    public List<PmaFImpFillInfo> querylist(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        String sql = userInfoService.processDataOrgAuth("S.ORG_ID", "SUB_ORG", userInfoService.getGrantOrgCode());
        model.getCondition().put("sql", sql);
        if (model.getCondition().get("statDate") != null && !model.getCondition().get("statDate").equals("")) {
            model.getCondition().put("statDate", model.getCondition().get("statDate").toString().substring(0, 7));
        }
        String evlObjIdS = "";
        String indexS = "";
        String[] evlObjIdStr;
        String[] indexIdStrs;
        if (model.getCondition().get("evlObjId") != null && !model.getCondition().get("evlObjId").equals("")) {
            evlObjIdS = model.getCondition().get("evlObjId").toString();
            evlObjIdStr = evlObjIdS.split(",");
            model.getCondition().put("evlObjId", evlObjIdStr);
            model.getCondition().put("evlObjIdSize", evlObjIdStr.length);
        }
        if (model.getCondition().get("indexId") != null && !model.getCondition().get("indexId").equals("")) {
            indexS = model.getCondition().get("indexId").toString();
            indexIdStrs = indexS.split(",");
            model.getCondition().put("indexId", indexIdStrs);
            model.getCondition().put("indexIdSize", indexIdStrs.length);
        }
        List<PmaFImpFillInfo> list = this.pmaFImpFillInfoMapper.querylist(model);
        PageHelper.clearPage();
        return list;
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
            String fileName = "数据补录" + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date()) + ".xlsx";
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
    @SuppressWarnings({"resource"})
    public SXSSFWorkbook exportExcel(QueryModel model) throws IOException {
        logger.info("业务数据导出exportExcel  begin");

        // 创建工作簿
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        String evlObjType = model.getCondition().get("evlObjType").toString();
        String schemeId = model.getCondition().get("schemeId").toString();
        String indexIds = model.getCondition().get("indexId").toString();
        String[] indexIdStrs = indexIds.split(",");
        String indexNames = model.getCondition().get("indexName").toString();
        String[] indexNameStrs = indexNames.split(",");
        model.getCondition().put("indexId", indexIdStrs);
        String showCol = "";
        Map<String, String> colMap = new HashMap<String, String>();
        if (evlObjType.equals("01")) {//员工
//			showCol="statDate,schemeName,evlObjId,evlObjName,evlObjPost,orgName";
            showCol = "statDate,schemeName,evlObjId,evlObjName,evlObjType,applyTypeId,balTypeId,orgName";
        } else {
            showCol = "statDate,schemeName,evlObjId,evlObjName,evlObjType,applyTypeId,balTypeId";
        }
        for (int i = 0; i < indexIdStrs.length; i++) {
            showCol = showCol + "," + indexIdStrs[i];
        }
        String[] showCols = showCol.split(",");
        int showColsize = showCols.length;
        if (evlObjType.equals("01")) {//员工
            colMap.put("statDate", "业务日期(YYYY-MM)");
            colMap.put("schemeName", "考核方案名称[" + schemeId + "]");
            colMap.put("evlObjId", "考核对象编号[" + evlObjType + "]");
            colMap.put("evlObjName", "考核对象名称");
            colMap.put("evlObjType", "考核对象类型");
            colMap.put("applyTypeId", "应用类型");
            colMap.put("balTypeId", "余额类型");
//			colMap.put("evlObjPost", "考核对象岗位");
            colMap.put("orgName", "考核对象所属机构");

        } else {
            colMap.put("statDate", "业务日期(YYYY-MM)");
            colMap.put("schemeName", "考核方案名称[" + schemeId + "]");
            colMap.put("evlObjId", "考核对象编号[" + evlObjType + "]");
            colMap.put("evlObjName", "考核对象名称");
            colMap.put("evlObjType", "考核对象类型");
            colMap.put("applyTypeId", "应用类型");
            colMap.put("balTypeId", "余额类型");
        }
        for (int j = 0; j < indexNameStrs.length; j++) {
            colMap.put(indexIdStrs[j], indexIdStrs[j] + indexNameStrs[j]);
        }
        String evlObjId = null;
        String[] evlObjIdStr = null;
        if (model.getCondition().get("evlObjId") == null || "".equals(model.getCondition().get("evlObjId").toString())) {
            //如果没有录入考核对象，查询对应考核指标下辖的所有考核对象
            QueryModel modelOne = new QueryModel();
            modelOne.getCondition().put("schemeId", schemeId);
            List<Map<String, Object>> list = pmaFSchemeEvlobjRelMapper.listByModel(modelOne);
            if (!list.isEmpty()) {
                evlObjIdStr = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    String evlObjIdIndex = list.get(i).get("evlObjId").toString();
                    evlObjIdStr[i] = evlObjIdIndex;
                }
            } else {
                workbook = createSheet(workbook, list, "sheet0", showCol, colMap, new HashMap<String, String>(), 0, showColsize, evlObjType);
                return workbook;
            }
        } else {
            evlObjId = model.getCondition().get("evlObjId").toString();
            evlObjIdStr = evlObjId.split(",");
        }
        model.getCondition().put("evlObjId", evlObjIdStr);

        Map<String, String> dataCodeMap = new HashMap<String, String>();
        //查询选择开始和结束时间之间的数据
        List<Map<String, Object>> datelist = this.pmaFImpFillInfoMapper.datelist(model);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();//存储导出数据

        // 获取数据字典的值
        QueryModel lookupQueryModel = new QueryModel();
        lookupQueryModel.getCondition().put("lookupCode", "OBJ");
        Map<String, Map<String, String>> evlObjItem = adminSmLookupItemMapper.getItemListBycodeOrName(lookupQueryModel).stream()
                .collect(Collectors.toMap(item -> item.get("lookupItemCode"), item -> item));
        lookupQueryModel.getCondition().put("lookupCode", "INDEX_APPLY_TYPE");
        Map<String, Map<String, String>> applyTypeItem = adminSmLookupItemMapper.getItemListBycodeOrName(lookupQueryModel).stream()
                .collect(Collectors.toMap(item -> item.get("lookupItemCode"), item -> item));
        lookupQueryModel.getCondition().put("lookupCode", "YE_TYPE");
        Map<String, Map<String, String>> balTypeItem = adminSmLookupItemMapper.getItemListBycodeOrName(lookupQueryModel).stream()
                .collect(Collectors.toMap(item -> item.get("lookupItemCode"), item -> item));

        model.getCondition().put("evlObjIdStr", evlObjIdStr);
        List<Map<String, Object>> indexlist = this.pmaFImpFillInfoMapper.queryDatalist(model);
        // 循环日期
        for (Map<String, Object> objectMap : datelist) {
            //循环对象
            for (Map<String, Object> stringObjectMap : indexlist) {
                Map<String, Object> map = new HashMap<>();
                map.put("statDate", objectMap.get("statDate"));
                map.put("schemeName", stringObjectMap.get("schemeName"));
                map.put("evlObjId", stringObjectMap.get("evlObjId"));
                map.put("evlObjName", stringObjectMap.get("evlObjName"));
                map.put("evlObjType", evlObjItem.get(stringObjectMap.get("evlObjType").toString()).get("lookupItemName"));
                map.put("applyTypeId", applyTypeItem.get(stringObjectMap.get("applyTypeId").toString()).get("lookupItemName"));
                map.put("balTypeId", balTypeItem.get(stringObjectMap.get("balTypeId").toString()).get("lookupItemName"));
                if ("01".equals(evlObjType)) {
                    map.put("orgName", stringObjectMap.get("orgName"));
                }
                list.add(map);
            }
        }
        int listSize = list.size();
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
                    workbook = createSheet(workbook, list2, sheetName, showCol, colMap, dataCodeMap, listSize, showColsize, evlObjType);
                }
            } else {
                workbook = createSheet(workbook, list, "sheet0", showCol, colMap, dataCodeMap, listSize, showColsize, evlObjType);
            }
        } else {
            workbook = createSheet(workbook, list, "sheet0", showCol, colMap, new HashMap<String, String>(), 0, showColsize, evlObjType);
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
                                     String showCol, Map<String, String> colMap, Map<String, String> dataCodeMap, int listSize, int showColsize, String evlObjType) {
        // 创建Sheet
        SXSSFSheet sheet = workbook.createSheet(sheetName);
        //sheet.protectSheet("password");
        XSSFCellStyle cellStylelocktitle = getReportStyle(workbook, true, (short) 16, "宋体", true, true, sheet);//锁定列样式
        XSSFCellStyle cellStylelock = getReportStyle(workbook, true, (short) 12, "宋体", true, true, sheet);//锁定列样式
        XSSFCellStyle cellStyle = getReportStyle(workbook, true, (short) 12, "宋体", true, false, sheet);//未锁定列样式
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth(20);
        String[] Stringarr = showCol.split(",");
        // 设置第一行的信息
        sheet = createFirst(sheet, cellStylelocktitle, Stringarr.length, listSize, showColsize);
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

            if (evlObjType.equals("01")) {//员工
                if (j < 6) {
                    sheet.setColumnWidth(j, 6000);
                } else {
                    sheet.setColumnWidth(j, 10000);
                }
                //冻结行列
                //参数1-要冻结的列数   参数2-要冻结的行数  参数3-冻结后首次展示的列号，从0开始  参数4-冻结后首次展示的行号，从0开始
                // sheet.createFreezePane(6,2,6,2);
            } else {
                if (j < 4) {
                    sheet.setColumnWidth(j, 6000);
                } else {
                    sheet.setColumnWidth(j, 10000);
                }
                //冻结行列
                //sheet.createFreezePane(4,2,4,2);
            }

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
                XSSFCellStyle cellStyle1 = getReportStyle(workbook, false, (short) 10, "宋体", false, false, sheet);//未锁定列样式
                XSSFCellStyle cellStyle2 = getReportStyle(workbook, false, (short) 10, "宋体", false, true, sheet);//锁定列样式
                if (map.get(Stringarr[j]) != null) {
                    value = map.get(Stringarr[j]).toString();
                    if (Stringarr[j].charAt(0) == 'B') {
                        cell.setCellStyle(cellStyle1);//如果式为指标列，则设置样式未锁定
                    } else {
                        cell.setCellStyle(cellStyle2);
                    }
                    cell.setCellValue(value);

                } else {
                    cell.setCellStyle(cellStyle2);
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
                                               boolean bold, boolean isLock, SXSSFSheet sheet) {
        XSSFCellStyle cellStyle = (XSSFCellStyle) workbook.createCellStyle();
        if (isLock) {//列锁定
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
        } else {
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
     */
    public SXSSFSheet createFirst(SXSSFSheet sheet, XSSFCellStyle cellStyle, int k, int listSize, int showColsize) {
        String resultCell = "方案指标补录模板(【" + listSize + "】行【" + showColsize + "】列)";
        int rowNum = 0;
        // 行
        SXSSFRow row = sheet.createRow(rowNum);
        row.setHeight((short) 800);//目的是想把行高设置成25px
        SXSSFCell cell = row.createCell(0);
        // 合并单元格：参数：起始行, 终止行, 起始列, 终止列
        CellRangeAddress cra = new CellRangeAddress(0, 0, 0, k - 1);
        sheet.addMergedRegion(cra);
        cell.setCellValue(resultCell);
        cell.setCellStyle(cellStyle);

        return sheet;
    }

    /**
     * 数据字典转换
     */
    public String getValue(String dateCode, String key) {
        String value = "";
        //value = this.pmaFImpFillInfoMapper.queryDataCodeValue(dateCode, key);
        if (value != null && !value.equals("")) {
            return value;
        } else {
            return key;
        }
    }

    /**
     * @方法名称: processImport
     * @方法描述: 导入入口方法
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public List<String> processImport(String fileRelatePath, MultipartFile mnultiFile, String fileName) throws Exception {
        InputStream inputStream = null;
        XSSFWorkbook wb = null;
        try {
            List<String> errMsgList = new ArrayList<String>();// 存储错误信息
            String filePath = this.localDiskPath + (this.localDiskPath.endsWith(File.separatorChar + "") ? "" : File.separatorChar) + fileRelatePath;
//			String filePath=localPath+fileRelatePath;
            File file = new File(filePath);
            if (!file.exists()) {
                throw new YuspException(new Message("500", "上传文件不存在", "error"));
            }
            inputStream = new FileInputStream(filePath);
            wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheetAt(0); // 数据页
            // 2、 excel格式基本校验（非空且符合标准excel头）
            errMsgList = this.validateBaseInfo(sheet);
            if (errMsgList.size() > 0) {
                return errMsgList;
            }
            Map<String, Object> retMap = this.getDataListFromSheet(errMsgList, sheet);
            if (retMap.get("flag").equals("true")) {//校验通过
                try {
                    List<PmaFImpFillInfo> dataList = (List<PmaFImpFillInfo>) retMap.get("dataList");
                    for (int i = 0; i < dataList.size(); i++) {
                        //先删除后插入，覆盖之前的补录数据
                        pmaFImpFillInfoMapper.delImpInfo(dataList.get(i).getStatDate(), dataList.get(i).getEvlObjId(),
                                dataList.get(i).getIndexId(), dataList.get(i).getEvlObjType(),
                                dataList.get(i).getBalTypeId(), dataList.get(i).getApplyTypeId());
                        pmaFImpFillInfoMapper.insertSelective(dataList.get(i));
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
            if (Objects.nonNull(wb)) {
                wb.close();
            }
            if (Objects.nonNull(inputStream)) {
                inputStream.close();
            }
        }
        return null;
    }

    /**
     * @方法名称: getDataListFromSheet
     * @方法描述: 遍历excel，生成dataList
     * @参数与返回说明:
     * @算法描述:
     */
    public Map<String, Object> getDataListFromSheet(List<String> errMsgList, XSSFSheet sheet) {
        //创建map用来存放返回数据
        Map<String, Object> retMap = new HashMap<String, Object>();
        //用来存放数据的list
        List<PmaFImpFillInfo> dataList = new ArrayList<PmaFImpFillInfo>();
        // 获得总行数,该方法是获取的最后行数下标，所以实际数量应该+1
        int totalRowCount = sheet.getLastRowNum() + 1;
        XSSFRow row = null;
        XSSFCell cell = null;
        //从excle中获取行和列的数字
        String title = sheet.getRow(0).getCell(0).toString();

        // 加载数据字段的值
        QueryModel lookupQueryModel = new QueryModel();
        lookupQueryModel.getCondition().put("lookupCode", "OBJ");
        Map<String, Map<String, String>> evlObjItem = adminSmLookupItemMapper.getItemListBycodeOrName(lookupQueryModel).stream()
                .collect(Collectors.toMap(item -> item.get("lookupItemName"), item -> item, (v1, v2) -> v1));
        lookupQueryModel.getCondition().put("lookupCode", "INDEX_APPLY_TYPE");
        Map<String, Map<String, String>> applyTypeItem = adminSmLookupItemMapper.getItemListBycodeOrName(lookupQueryModel).stream()
                .collect(Collectors.toMap(item -> item.get("lookupItemName"), item -> item, (v1, v2) -> v1));
        lookupQueryModel.getCondition().put("lookupCode", "YE_TYPE");
        Map<String, Map<String, String>> balTypeItem = adminSmLookupItemMapper.getItemListBycodeOrName(lookupQueryModel).stream()
                .collect(Collectors.toMap(item -> item.get("lookupItemName"), item -> item, (v1, v2) -> v1));

        //行
        int staStr = title.indexOf("(【");
        int endStr = title.indexOf("】行");
        String hang = title.substring(staStr + 2, endStr);
        //列
        int lstaStr = title.indexOf("行【");
        int lendStr = title.indexOf("】列");
        String lie = title.substring(lstaStr + 2, lendStr);
        //从列名中获取考核对象类型
        String evlObjTypeStr = sheet.getRow(1).getCell(2).toString();
        int evlStart = evlObjTypeStr.indexOf("[");
        String evlObjType = evlObjTypeStr.substring(evlStart + 1, evlStart + 3);
        for (int i = 2; i < totalRowCount; i++) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM");
            row = sheet.getRow(i);
            if (evlObjType.equals("01")) {//员工
                //Integer.valueOf("12")
//	        	for(int j=6;j<Integer.valueOf(lie);j++) {
                for (int j = 8; j < Integer.valueOf(lie); j++) {
                    PmaFImpFillInfo pmaFImpFillInfo = new PmaFImpFillInfo();
                    cell = row.getCell(j);
                    if (row.getCell(j) == null || "".equals(row.getCell(j).toString())) {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + (j + 1) + "】列：该单元格无数据，请查验。");
                        continue;
                    } else {
                        BigDecimal bd = new BigDecimal(row.getCell(j).toString());
                        pmaFImpFillInfo.setIndexValue(bd);//指标值
                    }

                    //获取方案编号
                    String schemeIdStr = sheet.getRow(1).getCell(1).toString();
                    String schemeId = schemeIdStr.substring(schemeIdStr.indexOf("[") + 1, schemeIdStr.indexOf("]"));

                    //获取考核对象类型
                    String objType = row.getCell(4).toString();
                    if (evlObjItem.get(objType) != null) {
                        pmaFImpFillInfo.setEvlObjType(evlObjItem.get(objType).get("lookupItemCode"));
                    } else {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + (j + 1) + "】列：该单元格含未知的考核对象类型，请查验。");
                        continue;
                    }
                    //获取应用类型
                    String applyTypeId = row.getCell(5).toString();
                    if (applyTypeItem.get(applyTypeId) != null) {
                        pmaFImpFillInfo.setApplyTypeId(applyTypeItem.get(applyTypeId).get("lookupItemCode"));
                    } else {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + (j + 1) + "】列：该单元格含未知的应用类型，请查验。");
                        continue;
                    }
                    //获取余额类型
                    String balTypeId = row.getCell(6).toString();
                    if (balTypeItem.get(balTypeId) != null) {
                        pmaFImpFillInfo.setBalTypeId(balTypeItem.get(balTypeId).get("lookupItemCode"));
                    } else {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + (j + 1) + "】列：该单元格含未知的余额类型，请查验。");
                        continue;
                    }
                    //获取指标编号维度  例如：B3003422[01.05.05]   指标编号【考核对象类型.余额类型.应用类型】
//		        	String indexInfoStr=sheet.getRow(1).getCell(j).toString().substring(0,18);
                    String indexInfoStr = sheet.getRow(1).getCell(j).toString();

                    // 获取格式化的业务日期
                    String statDate = getBizDate(row.getCell(0).toString(), "yyyy-MM");
                    if (StringUtils.isEmpty(statDate)) {
                        errMsgList.add("第【" + (i + 1) + "】行：该行的业务日期格式错误，请查验。");
                        continue;
                    } else {
                        pmaFImpFillInfo.setStatDate(statDate);//业务日期
                    }

                    pmaFImpFillInfo.setSchemeId(schemeId);//考核方案号
                    pmaFImpFillInfo.setEvlObjId(row.getCell(2).toString());//考核对象编号

                    pmaFImpFillInfo.setIndexId(indexInfoStr.substring(0, 12));//指标编号
                    pmaFImpFillInfo.setIndexName(indexInfoStr.substring(12, 16));

                    if (checkExistData(pmaFImpFillInfo)) {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + (j + 1) + "】列：该指标补录数据已经存在，请查验。");
                        continue;
                    }

//		        	pmaFImpFillInfo.setEvlObjType(indexInfoStr.substring(9, 11));//考核对象类型
//		        	pmaFImpFillInfo.setApplyTypeId(indexInfoStr.substring(12, 14));//应用类型
//		        	pmaFImpFillInfo.setBalTypeId(indexInfoStr.substring(15, 17));//余额类型
                    pmaFImpFillInfo.setCreateDate(df.format(new Date()));
                    pmaFImpFillInfo.setCreatorId(userInfoService.getUserInfo().getLoginCode());
                    pmaFImpFillInfo.setCreator(userInfoService.getUserInfo().getUserName());
                    dataList.add(pmaFImpFillInfo);
                }

            } else {//机构，团队
                for (int j = 7; j < Integer.parseInt(lie); j++) {
                    PmaFImpFillInfo pmaFImpFillInfo = new PmaFImpFillInfo();
                    cell = row.getCell(j);
                    if (cell == null) {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + (j + 1) + "】列：该单元格无数据，请查验。");
                        continue;
                    } else {
                        BigDecimal bd = new BigDecimal(row.getCell(j).toString());
                        pmaFImpFillInfo.setIndexValue(bd);//指标值
                    }
                    //获取方案编号
                    String schemeIdStr = sheet.getRow(1).getCell(1).toString();
                    String schemeId = schemeIdStr.substring(schemeIdStr.indexOf("[") + 1, schemeIdStr.indexOf("]"));
                    //获取考核对象类型
//                    String objType = row.getCell(4).toString();
//                    pmaFImpFillInfo.setEvlObjType(objType);
//                    //获取应用类型
//                    String applyTypeId = row.getCell(5).toString();
//                    pmaFImpFillInfo.setApplyTypeId(applyTypeId);
//                    //获取余额类型
//                    String balTypeId = row.getCell(6).toString();
//                    pmaFImpFillInfo.setBalTypeId(balTypeId);


                    String objType = row.getCell(4).toString();
                    if (evlObjItem.get(objType) != null) {
                        pmaFImpFillInfo.setEvlObjType(evlObjItem.get(objType).get("lookupItemCode"));
                    } else {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + (j + 1) + "】列：该单元格含未知的考核对象类型，请查验。");
                        continue;
                    }
                    //获取应用类型
                    String applyTypeId = row.getCell(5).toString();
                    if (applyTypeItem.get(applyTypeId) != null) {
                        pmaFImpFillInfo.setApplyTypeId(applyTypeItem.get(applyTypeId).get("lookupItemCode"));
                    } else {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + (j + 1) + "】列：该单元格含未知的应用类型，请查验。");
                        continue;
                    }
                    //获取余额类型
                    String balTypeId = row.getCell(6).toString();
                    if (balTypeItem.get(balTypeId) != null) {
                        pmaFImpFillInfo.setBalTypeId(balTypeItem.get(balTypeId).get("lookupItemCode"));
                    } else {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + (j + 1) + "】列：该单元格含未知的余额类型，请查验。");
                        continue;
                    }

                    //获取指标编号维度  例如：B3003422[01.05.05]   指标编号【考核对象类型.余额类型.应用类型】
//		        	String indexInfoStr=sheet.getRow(1).getCell(j).toString().substring(0,17);
                    String indexInfoStr = sheet.getRow(1).getCell(j).toString();

                    // 获取格式化的业务日期
                    String statDate = getBizDate(row.getCell(0).toString(), "yyyy-MM");
                    if (StringUtils.isEmpty(statDate)) {
                        errMsgList.add("第【" + (i + 1) + "】行：该行的业务日期格式错误，请查验。");
                        continue;
                    } else {
                        pmaFImpFillInfo.setStatDate(statDate);//业务日期
                    }

                    pmaFImpFillInfo.setSchemeId(schemeId);//考核方案号
                    pmaFImpFillInfo.setEvlObjId(row.getCell(2).toString());//考核对象编号
                    pmaFImpFillInfo.setIndexId(indexInfoStr.substring(0, 12));//指标编号
                    pmaFImpFillInfo.setIndexName(indexInfoStr.substring(12, 16));//指标标号

                    if (checkExistData(pmaFImpFillInfo)) {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + (j + 1) + "】列：该指标补录数据已经存在，请查验。");
                        continue;
                    }

//		        	pmaFImpFillInfo.setEvlObjType(indexInfoStr.substring(9, 11));//考核对象类型
//		        	pmaFImpFillInfo.setBalTypeId(indexInfoStr.substring(15, 17));//余额类型
//		        	pmaFImpFillInfo.setApplyTypeId(indexInfoStr.substring(12, 14));//应用类型
                    pmaFImpFillInfo.setCreateDate(df.format(new Date()));
                    pmaFImpFillInfo.setCreatorId(userInfoService.getUserInfo().getLoginCode());
                    pmaFImpFillInfo.setCreator(userInfoService.getUserInfo().getUserName());
                    dataList.add(pmaFImpFillInfo);
                }
            }
        }
        if (errMsgList.size() > 0) {
            retMap.put("flag", "false");
            retMap.put("errMsgList", errMsgList);
        } else {
            retMap.put("flag", "true");
            retMap.put("dataList", dataList);
        }
        return retMap;
    }

    /**
     * @方法名称: validateBaseInfo
     * @方法描述: 导入excel基本校验
     * @参数与返回说明:
     * @算法描述: 1、判断excel模板非空
     * 2、判断excel列格式是否满足标准模板列名
     */
    private List<String> validateBaseInfo(XSSFSheet sheet) {
        List<String> errMsgList = new ArrayList<String>();
        // 获得总行数,该方法是获取的最后行数下标，所以实际数量应该+1
        int totalRowCount = sheet.getLastRowNum() + 1;
        //int totalcoloumCount = sheet.getRow(1).getPhysicalNumberOfCells();// 获得总列数
        String title = sheet.getRow(0).getCell(0).toString();//获取表头
        /** 校验是否为空模板 */
        if (3 > totalRowCount) {// 数据从第三行开始
            errMsgList.add("Excel模板为空或无数据");
        } else if (title.indexOf("方案指标补录模板") < 0) {    // 校验是否为标准模板
            errMsgList.add("Excel模板不是标准模板，请检查");
        }
        return errMsgList;
    }

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<Integer> delete(String ids) {
        ResultDto<Integer> result = new ResultDto<Integer>();
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            pmaFImpFillInfoMapper.deleteByIds(id[i]);
        }
        result.setCode(0);
        result.setMessage("删除成功");
        return result;
    }

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<PmaFImpFillInfo> modify(PmaFImpFillInfo pmaFImpFillInfo) throws Exception {
        ResultDto<PmaFImpFillInfo> result = new ResultDto<PmaFImpFillInfo>();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        pmaFImpFillInfo.setModifyDate(df.format(new Date()));
        pmaFImpFillInfo.setModifyUser(userInfoService.getUserInfo().getUserName());
        pmaFImpFillInfo.setModifyUserId(userInfoService.getUserInfo().getLoginCode());
        this.pmaFImpFillInfoMapper.updateByPrimaryKeySelective(pmaFImpFillInfo);
        result.setData(pmaFImpFillInfo);
        result.setMessage("修改成功");
        result.setCode(0);
        return result;
    }

    /**
     * 检查补录数据是否已经存在
     *
     * @param fillInfo 补录数据
     * @return 是否存在
     * @author weixy6
     * @date 2022/6/16
     */
    private boolean checkExistData(PmaFImpFillInfo fillInfo) {
        return pmaFImpFillInfoMapper.queryExistData(fillInfo) != null;
    }

    private String getBizDate(String dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.format(sdf.parse(dateStr));
        } catch (ParseException e) {
            return "";
        }
    }
}
