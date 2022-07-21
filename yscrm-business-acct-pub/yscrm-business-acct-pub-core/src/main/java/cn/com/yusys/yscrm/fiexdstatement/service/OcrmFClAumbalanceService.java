package cn.com.yusys.yscrm.fiexdstatement.service;

import cn.com.yusys.yscrm.custmgr.domain.DateUtils;
import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClAumbalance;
import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClNationality;
import cn.com.yusys.yscrm.fiexdstatement.repository.mapper.OcrmFClAumbalanceMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

@Service
public class OcrmFClAumbalanceService extends CommonService {

    @Autowired
    private OcrmFClAumbalanceMapper ocrmFClAumbalanceMapper;

    @Autowired
    private OcrmFClNationalityService ocrmFClNationalityService; //区域地区服务

    @Autowired
    private UaaClient uaaClient;

    private static String BELONG_BRCH_NO_ALL = "500";  //东亚中国
    private static String BELONG_BRCH_NO_SUB = "00";   //子行

    @Override
    protected CommonMapper getMapper() {
        return ocrmFClAumbalanceMapper;
    }

    public List<Map<String, Object>> getBalanceList(QueryModel queryModel) {
        Map<String, Object> map = new HashMap<>();
        String dataDate=(String)queryModel.getCondition().get("dataDate"); //日期天数
        String targetId=(String)queryModel.getCondition().get("targetId"); //客户经理
        map.put("dataDate", dataDate);
        map.put("targetId", targetId);

        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken()); //获取当前登录人信息
        UserInfoDTO user = dto.getBody(); //获取当前登录者信息
        map.put("userCode", user.getLoginCode());  //登录用户编码
        List<Map<String, Object>> list = new ArrayList<>();
        if (user.getOrg().getCode() != null && user.getOrg().getCode().length()==2){
            map.put("orgCode", user.getOrg().getCode());  //登录用户所属机构编码
            list = ocrmFClAumbalanceMapper.getBalanceList(map);
        }else if (user.getOrg().getCode() != null && BELONG_BRCH_NO_ALL.equals(user.getOrg().getCode())){
            list = ocrmFClAumbalanceMapper.getBalanceList(map);
        }

        return list;
    }

    public void export(HttpServletResponse response, QueryModel queryModel) throws IOException {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken()); //获取当前登录人信息
        Map<String, Object> mapMap = new HashMap<>();
        String dataDate=(String)queryModel.getCondition().get("dataDate"); //日期天数
        mapMap.put("dataDate", dataDate);
        UserInfoDTO user = dto.getBody(); //获取当前登录者信息
        if (user.getOrg().getCode() != null && user.getOrg().getCode().length()==2) {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码
            String fileName = URLEncoder.encode("AUM余额", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            mapMap.put("orgCode", user.getOrg().getCode());  //登录用户所属机构编码
            List<Map<String, Object>> list = ocrmFClAumbalanceMapper.getBalanceList(mapMap);
            exportFile(response, "aumbalance_template.xlsx", "AUM余额", list,dataDate);
        }else if (user.getOrg().getCode() != null && BELONG_BRCH_NO_ALL.equals(user.getOrg().getCode())) {
            //        List<OcrmFClAumbalance> list = ocrmFClAumbalanceMapper.selectPreparation(mapMap);
//        String excelName = "AUM余额列表";
//        ExportExcelUtils2.export(excelName, list, OcrmFClAumbalance.class, response);
            //1.创建一个workbook,对应一个excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            //2.在workbook中添加一个sheet,对应Excel中的sheet
            HSSFSheet sheet = wb.createSheet("分行AUM余额");
            //表头字体
            Font headerFont = wb.createFont();
            headerFont.setFontName("宋体");
            headerFont.setFontHeightInPoints((short) 18);
            headerFont.setBold(true);
            headerFont.setColor(Font.COLOR_NORMAL);
            //正文字体
            Font contextFont = wb.createFont();
            contextFont.setFontName("宋体");
            contextFont.setFontHeightInPoints((short) 12);
            headerFont.setBold(true);
            //表头样式，左右上下居中
            CellStyle headerStyle = wb.createCellStyle();
            headerStyle.setFont(headerFont);
            // 左右居中
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            // 上下居中
            headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            headerStyle.setLocked(true);
            // 自动换行
            headerStyle.setWrapText(false);
            //单元格样式，左右上下居中 边框
            CellStyle commonStyle = wb.createCellStyle();
            commonStyle.setFont(contextFont);
            // 左右居中
            commonStyle.setAlignment(HorizontalAlignment.CENTER);
            // 上下居中
            commonStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            commonStyle.setLocked(true);
            // 自动换行
            commonStyle.setWrapText(false);
            //单元格样式，左右上下居中 边框
            CellStyle commonWrapStyle = wb.createCellStyle();
            commonWrapStyle.setFont(contextFont);
            //单元格样式，竖向 边框
            CellStyle verticalStyle = wb.createCellStyle();
            verticalStyle.setFont(contextFont);
            CellStyle commonStyleNoBorder = wb.createCellStyle();
            commonStyleNoBorder.setFont(contextFont);
            commonStyleNoBorder.setLocked(true);
            // 自动换行
            commonStyleNoBorder.setWrapText(false);
            CellStyle alignLeftStyle = wb.createCellStyle();
            alignLeftStyle.setFont(contextFont);
            alignLeftStyle.setLocked(true);
            // 自动换行
            alignLeftStyle.setWrapText(false);
            //单元格样式，左对齐 无边框
            CellStyle alignLeftNoBorderStyle = wb.createCellStyle();
            alignLeftNoBorderStyle.setFont(contextFont);
            alignLeftNoBorderStyle.setLocked(true);
            // 自动换行
            alignLeftNoBorderStyle.setWrapText(false);
            //单元格样式，右对齐
            CellStyle alignRightStyle = wb.createCellStyle();
            alignRightStyle.setFont(contextFont);
            alignRightStyle.setLocked(true);
            // 自动换行
            alignRightStyle.setWrapText(false);
            //行号
            int rowNum = 0;
            //设置列宽
            for (int i = 0;i < 10;i++){
                sheet.setColumnWidth(i,256*15);
            }
            //创建第一行，索引从0开始(标题行)
            Row row0 = sheet.createRow(rowNum++);
            row0.setHeight((short) 800);// 设置行高
            Cell c00 = row0.createCell(0);
            c00.setCellValue("单位：万元    时间："+dataDate);
            c00.setCellStyle(alignLeftStyle);
            //合并单元格
            sheet.addMergedRegion(new CellRangeAddress(0,0,0,19));
            //第二行
            Row row1 = sheet.createRow(rowNum++);
            row1.setHeight((short) 800);// 设置行高
            String[] rowFirst = {"","","AUM余额","","","","","","","","","AUM余额月日均"};
            for (int i = 0; i < rowFirst.length; i++) {
                Cell tempCell = row1.createCell(i);
                tempCell.setCellValue(rowFirst[i]);
                tempCell.setCellStyle(commonStyle);
            }
            //第三行
            Row row2 = sheet.createRow(rowNum++);
            row2.setHeight((short) 800);// 设置行高
            String[] rowSecond = {"一般存款","非汇率结构性产品","汇款结构性产品","QDII","国内基金","代销信托","资管","银保","合计","存款月日均","非汇理财余额月日均","汇率理财余额月日均","QDII余额月日均","人民币基金余额月日均","代销信托余额月日均","资管余额月日均","保险余额月日均","余额月日均合计"};
            for (int i = 0; i < rowSecond.length; i++) {
                Cell tempCell = row2.createCell(i + 2);
                tempCell.setCellValue(rowSecond[i]);
                tempCell.setCellStyle(commonStyle);
            }
            //合并单元格
            sheet.addMergedRegion(new CellRangeAddress(1,2,0,0));
            sheet.addMergedRegion(new CellRangeAddress(1,2,1,1));
            sheet.addMergedRegion(new CellRangeAddress(1,1,2,10));
            sheet.addMergedRegion(new CellRangeAddress(1,1,11,19));
            //查询地区分类

            List<Map<String, Object>> areaNoList = ocrmFClNationalityService.getAreaNoList();
            List<Map<String, Object>> nationalityList = ocrmFClNationalityService.getNationality();
            if (areaNoList.size()>0 && areaNoList != null && nationalityList.size()>0 && nationalityList !=null){
                int num = 0;
                Map<String, Object> areaNoMap = areaNoList.get(num);
                String  areaNo = (String)areaNoMap.get("areaNo");//华东区编号
                Map<String, Object> nationalityMap = nationalityList.get(num);
                String nationality = (String)nationalityMap.get("nationality");

                //查询地区数据
                List<OcrmFClNationality> fClNationalities = ocrmFClNationalityService.queryByAreaNo(areaNo);
                Map<String, Object> paramMap = new HashMap<String, Object>();


                paramMap.put("dataDate",dataDate);

                for (int i = 0; i < fClNationalities.size()+1; i++) {  //4个华东区地区+合计行
                    Row rowNO = sheet.createRow(rowNum++);
                    //查询地区分行数据
                    if (i < fClNationalities.size()){
                        paramMap.put("belongBrchNo", fClNationalities.get(i).getBelongBrchNo());
                        System.out.println("参数："+fClNationalities.get(i).getBelongBrchNo());
                    }


                    OcrmFClAumbalance ocrmFClAumbalance = ocrmFClAumbalanceMapper.queryBybrchNo(paramMap);
                    //查询地区分行数据合计
                    paramMap.put("areaNo",areaNo);
                    OcrmFClAumbalance aumBalanceSum = ocrmFClAumbalanceMapper.getAumBalanceSum(paramMap); //关联查询 统计计算
                    for (int j = 0; j < rowSecond.length; j++) {
                        if (j<2){
                            Cell cellHead = rowNO.createCell(j);
                            String cellValue = "";
                            if ((i == 0 && j == 0)||i == fClNationalities.size()){
                                cellValue = nationality;
                            }else {
                                cellValue = fClNationalities.get(i).getBelongBrch();
                            }
                            cellHead.setCellValue(cellValue);
                            cellHead.setCellStyle(commonStyle);

                        }
                        Cell tempCell = rowNO.createCell(j + 2);
                        String cellValue = "";
                        if (i<fClNationalities.size()){
                            cellValue = getAumbalanceValue(ocrmFClAumbalance,j);
                        }else {
                            cellValue = getAumbalanceValue(aumBalanceSum,j);
                        }

                        tempCell.setCellValue(cellValue);
                        tempCell.setCellStyle(commonStyle);
                    }
                }
                //合并单元格
                sheet.addMergedRegion(new CellRangeAddress(3,3+fClNationalities.size(),0,0));
                int line = 0;
                line = line + ocrmFClNationalityService.getCountByArea(areaNo)+1; //合并行个数
                num++;
                areaNoMap = areaNoList.get(num);
                areaNo = (String)areaNoMap.get("areaNo");//华北区编号
                nationalityMap = nationalityList.get(num);
                nationality = (String)nationalityMap.get("nationality");//华北地区

                fClNationalities = ocrmFClNationalityService.queryByAreaNo(areaNo);
                for (int i = 0; i < fClNationalities.size()+1; i++) {  //4个华东区地区+合计行
                    Row rowNO = sheet.createRow(rowNum++);
                    //查询地区分行数据
                    if (i < fClNationalities.size()){
                        paramMap.put("belongBrchNo", fClNationalities.get(i).getBelongBrchNo());
                        System.out.println("参数："+fClNationalities.get(i).getBelongBrchNo());
                    }
                    OcrmFClAumbalance ocrmFClAumbalance = ocrmFClAumbalanceMapper.queryBybrchNo(paramMap);
                    //查询地区分行数据合计
                    paramMap.put("areaNo",areaNo);
                    OcrmFClAumbalance aumBalanceSum = ocrmFClAumbalanceMapper.getAumBalanceSum(paramMap); //关联查询 统计计算
                    for (int j = 0; j < rowSecond.length; j++) {
                        if (j<2){
                            Cell cellHead = rowNO.createCell(j);
                            String cellValue = "";
                            if ((i == 0 && j == 0)||(i == fClNationalities.size() && j != 0 )){
                                cellValue = nationality;
                            }else if (j!=0){
                                cellValue = fClNationalities.get(i).getBelongBrch();
                            }
                            cellHead.setCellValue(cellValue);
                            cellHead.setCellStyle(commonStyle);

                        }
                        Cell tempCell = rowNO.createCell(j + 2);
                        String cellValue = "";
                        if (i<fClNationalities.size()){
                            cellValue = getAumbalanceValue(ocrmFClAumbalance,j);
                        }else {
                            cellValue = getAumbalanceValue(aumBalanceSum,j);
                        }

                        tempCell.setCellValue(cellValue);
                        tempCell.setCellStyle(commonStyle);
                    }
                }

                //合并单元格
                sheet.addMergedRegion(new CellRangeAddress(3+line,3+line+fClNationalities.size(),0,0));

                line =line + ocrmFClNationalityService.getCountByArea(areaNo)+1;
                num++;
                areaNoMap = areaNoList.get(num);
                areaNo = (String)areaNoMap.get("areaNo");//华南区编号
                nationalityMap = nationalityList.get(num);
                nationality = (String)nationalityMap.get("nationality");//华南地区

                fClNationalities = ocrmFClNationalityService.queryByAreaNo(areaNo);
                for (int i = 0; i < fClNationalities.size()+1; i++) {  //4个华东区地区+合计行
                    Row rowNO = sheet.createRow(rowNum++);
                    //查询地区分行数据
                    if (i < fClNationalities.size()){
                        paramMap.put("belongBrchNo", fClNationalities.get(i).getBelongBrchNo());
                        System.out.println("参数："+fClNationalities.get(i).getBelongBrchNo());
                    }
                    OcrmFClAumbalance ocrmFClAumbalance = ocrmFClAumbalanceMapper.queryBybrchNo(paramMap);
                    //查询地区分行数据合计
                    paramMap.put("areaNo",areaNo);
                    OcrmFClAumbalance aumBalanceSum = ocrmFClAumbalanceMapper.getAumBalanceSum(paramMap); //关联查询 统计计算
                    for (int j = 0; j < rowSecond.length; j++) {
                        if (j<2){
                            Cell cellHead = rowNO.createCell(j);
                            String cellValue = "";
                            if ((i == 0 && j == 0)||(i == fClNationalities.size() && j != 0 )){
                                cellValue = nationality;
                            }else if (j!=0){
                                cellValue = fClNationalities.get(i).getBelongBrch();
                            }
                            cellHead.setCellValue(cellValue);
                            cellHead.setCellStyle(commonStyle);

                        }
                        Cell tempCell = rowNO.createCell(j + 2);
                        String cellValue = "";
                        if (i<fClNationalities.size()){
                            cellValue = getAumbalanceValue(ocrmFClAumbalance,j);
                        }else {
                            cellValue = getAumbalanceValue(aumBalanceSum,j);
                        }

                        tempCell.setCellValue(cellValue);
                        tempCell.setCellStyle(commonStyle);
                    }
                }

                //合并单元格
                sheet.addMergedRegion(new CellRangeAddress(3+line,3+line+fClNationalities.size(),0,0));

                line = line+ocrmFClNationalityService.getCountByArea(areaNo)+1;
                num++;
                areaNoMap = areaNoList.get(num);
                areaNo = (String)areaNoMap.get("areaNo");//中西区编号
                nationalityMap = nationalityList.get(num);
                nationality = (String)nationalityMap.get("nationality");//中西地区

                fClNationalities = ocrmFClNationalityService.queryByAreaNo(areaNo);
                for (int i = 0; i < fClNationalities.size()+1; i++) {  //4个华东区地区+合计行
                    Row rowNO = sheet.createRow(rowNum++);
                    //查询地区分行数据
                    if (i < fClNationalities.size()){
                        paramMap.put("belongBrchNo", fClNationalities.get(i).getBelongBrchNo());
                        System.out.println("参数："+fClNationalities.get(i).getBelongBrchNo());
                    }
                    OcrmFClAumbalance ocrmFClAumbalance = ocrmFClAumbalanceMapper.queryBybrchNo(paramMap);
                    //查询地区分行数据合计
                    paramMap.put("areaNo",areaNo);
                    OcrmFClAumbalance aumBalanceSum = ocrmFClAumbalanceMapper.getAumBalanceSum(paramMap); //关联查询 统计计算
                    for (int j = 0; j < rowSecond.length; j++) {
                        if (j<2){
                            Cell cellHead = rowNO.createCell(j);
                            String cellValue = "";
                            if ((i == 0 && j == 0)||(i == fClNationalities.size() && j != 0 )){
                                cellValue = nationality;
                            }else if (j!=0){
                                cellValue = fClNationalities.get(i).getBelongBrch();
                            }
                            cellHead.setCellValue(cellValue);
                            cellHead.setCellStyle(commonStyle);
                        }
                        Cell tempCell = rowNO.createCell(j + 2);
                        String cellValue = "";
                        if (i<fClNationalities.size()){
                            cellValue = getAumbalanceValue(ocrmFClAumbalance,j);
                        }else {
                            cellValue = getAumbalanceValue(aumBalanceSum,j);
                        }

                        tempCell.setCellValue(cellValue);
                        tempCell.setCellStyle(commonStyle);
                    }
                }
                //合并单元格
                sheet.addMergedRegion(new CellRangeAddress(3+line,3+line+fClNationalities.size(),0,0));

                line = line+ocrmFClNationalityService.getCountByArea(areaNo)+1;
                num++;
                areaNoMap = areaNoList.get(num);
                areaNo = (String)areaNoMap.get("areaNo");//子银行编号
                nationalityMap = nationalityList.get(num);
                nationality = (String)nationalityMap.get("nationality");//子银行

                fClNationalities = ocrmFClNationalityService.queryByAreaNo(areaNo);
                for (int i = 0; i < fClNationalities.size(); i++) {  //子行
                    Row rowNO = sheet.createRow(rowNum++);
                    //查询地区分行数据
                    paramMap.put("belongBrchNo", fClNationalities.get(i).getBelongBrchNo());
                    System.out.println("参数："+fClNationalities.get(i).getBelongBrchNo());

                    OcrmFClAumbalance ocrmFClAumbalance = ocrmFClAumbalanceMapper.queryBybrchNo(paramMap);
                    //查询地区分行数据合计
                    for (int j = 0; j < rowSecond.length; j++) {
                        if (j<2){
                            Cell cellHead = rowNO.createCell(j);
                            String cellValue = "";
                            if ((i == 0 && j == 0)||(i == fClNationalities.size() && j != 0 )){
                                cellValue = nationality;
                            }else if (j!=0){
                                cellValue = fClNationalities.get(i).getBelongBrch();
                            }
                            cellHead.setCellValue(cellValue);
                            cellHead.setCellStyle(commonStyle);
                        }
                        Cell tempCell = rowNO.createCell(j + 2);
                        String cellValue = "";
                        if (i<fClNationalities.size()){
                            cellValue = getAumbalanceValue(ocrmFClAumbalance,j);
                        }
                        tempCell.setCellValue(cellValue);
                        tempCell.setCellStyle(commonStyle);
                    }
                }

                line=line+1;

                List<String> areaSumList = Arrays.asList(BELONG_BRCH_NO_SUB,BELONG_BRCH_NO_ALL);
                paramMap.put("areaSumList",areaSumList);

                for (int i = 0; i < fClNationalities.size(); i++) {  //区域合计
                    Row rowNO = sheet.createRow(rowNum++);
                    //查询统计区域合计数据（除子行外）
                    OcrmFClAumbalance ocrmFClAumbalance = ocrmFClAumbalanceMapper.queryCountBybatchArea(paramMap);
                    //查询地区分行数据合计
                    for (int j = 0; j < rowSecond.length; j++) {
                        if (j<2){
                            Cell cellHead = rowNO.createCell(j);
                            String cellValue = "";
                            if ((i == 0 && j == 0)){
                                cellValue = "区域合计";
                            }
                            cellHead.setCellValue(cellValue);
                            cellHead.setCellStyle(commonStyle);
                        }
                        Cell tempCell = rowNO.createCell(j + 2);
                        String cellValue = "";
                        if (i<fClNationalities.size()){
                            cellValue = getAumbalanceValue(ocrmFClAumbalance,j);
                        }
                        tempCell.setCellValue(cellValue);
                        tempCell.setCellStyle(commonStyle);
                    }
                }

                //合并单元格
                sheet.addMergedRegion(new CellRangeAddress(3+line,3+line,0,1));

                line=line+1;

                paramMap.put("belongBrchNo",BELONG_BRCH_NO_ALL);
                for (int i = 0; i < fClNationalities.size(); i++) {  //中国合计
                    Row rowNO = sheet.createRow(rowNum++);
                    //查询统计区域合计数据（除子行外）
                    OcrmFClAumbalance ocrmFClAumbalance = ocrmFClAumbalanceMapper.queryCountAll(paramMap);
                    //查询地区分行数据合计
                    for (int j = 0; j < rowSecond.length; j++) {
                        if (j<2){
                            Cell cellHead = rowNO.createCell(j);
                            String cellValue = "";
                            if ((i == 0 && j == 0)){
                                cellValue = "东亚中国";
                            }
                            cellHead.setCellValue(cellValue);
                            cellHead.setCellStyle(commonStyle);
                        }
                        Cell tempCell = rowNO.createCell(j + 2);
                        String cellValue = "";
                        if (i<fClNationalities.size()){
                            cellValue = getAumbalanceValue(ocrmFClAumbalance,j);
                        }
                        tempCell.setCellValue(cellValue);
                        tempCell.setCellStyle(commonStyle);
                    }
                }


                //合并单元格
                sheet.addMergedRegion(new CellRangeAddress(3+line,3+line,0,1));
            }



            //导出excel
            String fileName =  "分行AUM余额表.xls";
            try {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
                response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + "\"");
                OutputStream stream = response.getOutputStream();
                if (null != wb && null != stream) {
                    wb.write(stream);
                    wb.close();
                    stream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码
            String fileName = URLEncoder.encode("AUM余额", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            mapMap.put("orgCode", user.getOrg().getCode());  //登录用户所属机构编码
            List<Map<String, Object>> list = new ArrayList<>();
            exportFile(response, "aumbalance_template.xlsx", "AUM余额", list,dataDate);
        }

    }

    private void exportFile(HttpServletResponse response, String fileName, String title, List list,String dataDate) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", dataDate);
        String templateFileName = "templates" + File.separator + fileName;
        ExcelWriter excelWriter = null;
        excelWriter = EasyExcel.write(response.getOutputStream())
                .withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        // 填充集合 data
        excelWriter.fill(list, writeSheet);
        excelWriter.fill(map, writeSheet);
        // 关闭流
        excelWriter.finish();
    }

    private String getAumbalanceValue(OcrmFClAumbalance ocrmFClAumbalance, int j) {
        String cellValue = "";
        switch (j){
            case 0 :
                cellValue = ocrmFClAumbalance.getDepositBalanceRmb().toString();
                break;
            case 1 :
                cellValue = ocrmFClAumbalance.getNonExchangeFinBalance().toString();
                break;
            case 2 :
                cellValue = ocrmFClAumbalance.getExchangeFinBalance().toString();
                break;
            case 3 :
                cellValue = ocrmFClAumbalance.getQdiiBalanceRmb().toString();
                break;
            case 4 :
                cellValue = ocrmFClAumbalance.getRmbFundBalance().toString();
                break;
            case 5 :
                cellValue = ocrmFClAumbalance.getTrustBalanceRmb().toString();
                break;
            case 6 :
                cellValue = ocrmFClAumbalance.getAssestManageBalance().toString();
                break;
            case 7 :
                cellValue = ocrmFClAumbalance.getInsurranceBalance().toString();
                break;
            case 8 :
                cellValue = ocrmFClAumbalance.getBalanceTotal().toString();
                break;
            case 9 :
                cellValue = ocrmFClAumbalance.getDepositMthAvgBalanceRmb().toString();
                break;
            case 10 :
                cellValue = ocrmFClAumbalance.getNonExchangeFinMthAvgBalRmb().toString();
                break;
            case 11 :
                cellValue = ocrmFClAumbalance.getExchangeFinMthAvgBalRmb().toString();
                break;
            case 12 :
                cellValue = ocrmFClAumbalance.getQdiiMthAvgBalanceRmb().toString();
                break;
            case 13 :
                cellValue = ocrmFClAumbalance.getRmbFundMthAvgBal().toString();
                break;
            case 14 :
                cellValue = ocrmFClAumbalance.getSellTrustMthAvgBalRmb().toString();
                break;
            case 15 :
                cellValue = ocrmFClAumbalance.getAssestManageMthAvgBal().toString();
                break;
            case 16 :
                cellValue = ocrmFClAumbalance.getInsurranceMthAvgBalRmb().toString();
                break;
            case 17 :
                cellValue = ocrmFClAumbalance.getMthAvgBalanceRmbTotal().toString();
                break;
            default:
                cellValue = "";
        }
        return cellValue;
    }




}
