package cn.com.yusys.yscrm.info.workreport.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import cn.com.yusys.yscrm.info.workreport.domain.CellInfo;
import cn.com.yusys.yscrm.info.workreport.domain.WorkReportExcle;
import cn.com.yusys.yscrm.pcrm.common.util.ExcelFillCellMergeStrategy;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.info.workreport.domain.OcrmFwpWorkReport;
import cn.com.yusys.yscrm.info.workreport.repository.mapper.OcrmFwpWorkReportMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0.0
 * @项目名称: yscrm-mgr-info-workreport-core模块
 * @类名称: OcrmFwpWorkReportService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: lixt1
 * @创建时间: 2019-01-28 20:32:24
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFwpWorkReportService extends CommonService {
    @Autowired
    private OcrmFwpWorkReportMapper ocrmFwpWorkReportMapper;

    @Autowired
    private UaaClient uaaClient;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFwpWorkReportMapper;
    }

    /**
     * @方法名称: listByModel
     * @方法描述: 条件查询 - 查询进行分页
     * @参数与返回说明:
     * @算法描述: 无
     */
    public List<Map<String, Object>> listByModel(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        Map<String, Object> condition = model.getCondition();
        if (condition.get("rangeDate") instanceof List) {
            List<String> rangeDate = (List<String>) condition.get("rangeDate");
            if (rangeDate != null && rangeDate.size() == 2) {
                condition.put("startDate", rangeDate.get(0).trim());
                condition.put("endDate", rangeDate.get(1).trim());
            }
        }
        if (condition.get("workSummary") instanceof String) {
            String workSummary = (String) condition.get("workSummary");
            if (workSummary != null && !"".equals(workSummary)) {
                workSummary = "%" + workSummary + "%";
                condition.put("workSummary", workSummary);
            }
        }
        if (condition.get("workReportId") instanceof String) {
            String workReportId = (String) condition.get("workReportId");
            if (workReportId != null && !"".equals(workReportId)) {
                String[] workReportIds = workReportId.split(",");
                condition.put("workReportIds", workReportIds);
            }
        }
        if (condition.get("workReportBusiType") instanceof String) {
            String workReportBusiTypes = (String) condition.get("workReportBusiType");
            if (workReportBusiTypes != null && !"".equals(workReportBusiTypes)) {
                String[] workReportBusiType = workReportBusiTypes.split(",");
                condition.put("workReportBusiTypes", workReportBusiType);
            }
        }
        List<Map<String, Object>> list = ocrmFwpWorkReportMapper.listByModel(model);
        PageHelper.clearPage();
        return list;
    }

    /**
     * @方法名称: selectByWorkReportId
     * @方法描述: 根据 报告编号 查询
     * @参数与返回说明:
     * @算法描述: 无
     */
    public List<Map<String, Object>> selectByWorkReportId(String workReportId) {
        return ocrmFwpWorkReportMapper.selectByWorkReportId(workReportId);
    }

    /**
     * @方法名称: chkData
     * @方法描述: 查询 同一报告人、同一报告周期内，是否有重复的工作报告
     * @参数与返回说明:
     * @算法描述: 无
     */
    public List<String> chkData(String creatorId, String workReportBusiType, String startDate) {
        List<String> list = ocrmFwpWorkReportMapper.chkData(creatorId, workReportBusiType, startDate);
        return list;
    }

    /**
     * @方法名称: addReport
     * @方法描述: 新增 工作报告
     * @参数与返回说明:
     * @算法描述: 新增工作报告主表、工作报告信息表、工作报告明细表数据
     */
    public Integer addReport(OcrmFwpWorkReport ocrmFwpWorkReport) {
        // TODO 增加异常处理
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        if (ocrmFwpWorkReport.getCreatorId() == null || "".equals(ocrmFwpWorkReport.getCreatorId())) {
            ocrmFwpWorkReport.setCreatorId(dto.getBody().getLoginCode());
        }
        if (ocrmFwpWorkReport.getCreatorName() == null || "".equals(ocrmFwpWorkReport.getCreatorName())) {
            ocrmFwpWorkReport.setCreatorName(dto.getBody().getUserName());
        }
        if (ocrmFwpWorkReport.getCreatorOrg() == null || "".equals(ocrmFwpWorkReport.getCreatorOrg())) {
            ocrmFwpWorkReport.setCreatorOrg(dto.getBody().getOrg().getId());
        }
        if (ocrmFwpWorkReport.getCreatorOrgName() == null || "".equals(ocrmFwpWorkReport.getCreatorOrgName())) {
            ocrmFwpWorkReport.setCreatorOrgName(dto.getBody().getOrg().getName());
        }
        if (ocrmFwpWorkReport.getIsDelete() == null || "".equals(ocrmFwpWorkReport.getIsDelete())) {
            ocrmFwpWorkReport.setIsDelete("N");
        }
        if (ocrmFwpWorkReport.getCreateDate() == null) {
            ocrmFwpWorkReport.setCreateDate(new java.util.Date());
        }
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "";
        try {
			if (ocrmFwpWorkReport.getCreateDate() != null) {
			    time = s.format(ocrmFwpWorkReport.getCreateDate());
			    ocrmFwpWorkReport.setCreateDate(s.parse(time));
			}
			if (ocrmFwpWorkReport.getEndDate() != null) {
			    time = s.format(ocrmFwpWorkReport.getEndDate()).split("\\s+")[0]+" 23:59:59";
			    ocrmFwpWorkReport.setEndDate(s.parse(time));
			}
			if (ocrmFwpWorkReport.getStartDate() != null) {
			    time = s.format(ocrmFwpWorkReport.getStartDate()).split("\\s+")[0]+" 00:00:00";
			    ocrmFwpWorkReport.setStartDate(s.parse(time));
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        int result = this.insertSelective(ocrmFwpWorkReport);
        return result;
    }

    /**
     * @方法名称: updateContent
     * @方法描述: 根据 报告编号 更新 ： 工作内容、工作困难、工作小结
     * @参数与返回说明:
     * @算法描述: 无
     */
    public int updateContent(OcrmFwpWorkReport ocrmFwpWorkReport) {
        return 0;
    }

    /**
     * @方法名称: deleteByWorkReportIds
     * @方法描述: 删除 - 根据 报告编号字段 逻辑删除
     * @参数与返回说明:
     * @算法描述: 无
     */
    public int deleteByWorkReportIds(OcrmFwpWorkReport ocrmFwpWorkReport) {
        // TODO 增加异常处理
        int result = 0;
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        ocrmFwpWorkReport.setIsDelete("Y");
        if (ocrmFwpWorkReport.getLastChgUsrId() == null || "".equals(ocrmFwpWorkReport.getLastChgUsrId())) {
            ocrmFwpWorkReport.setLastChgUsrId(dto.getBody().getLoginCode());
        }
        if (ocrmFwpWorkReport.getLastChgUsrName() == null || "".equals(ocrmFwpWorkReport.getLastChgUsrName())) {
            ocrmFwpWorkReport.setLastChgUsrName(dto.getBody().getUserName());
        }
        if (ocrmFwpWorkReport.getLastChgUsrOrgId() == null || "".equals(ocrmFwpWorkReport.getLastChgUsrOrgId())) {
            ocrmFwpWorkReport.setLastChgUsrOrgId(dto.getBody().getOrg().getId());
        }
        if (ocrmFwpWorkReport.getLastChgUsrOrgName() == null || "".equals(ocrmFwpWorkReport.getLastChgUsrOrgName())) {
            ocrmFwpWorkReport.setLastChgUsrOrgName(dto.getBody().getOrg().getName());
        }
        if (ocrmFwpWorkReport.getLastChgDate() == null) {
            ocrmFwpWorkReport.setLastChgDate(new java.util.Date());
        }
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "";
        try {
			if (ocrmFwpWorkReport.getLastChgDate() != null) {
			    time = s.format(ocrmFwpWorkReport.getLastChgDate());
			    ocrmFwpWorkReport.setLastChgDate(s.parse(time));
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        if (ocrmFwpWorkReport.getWorkReportId() != null && !"".equals(ocrmFwpWorkReport.getWorkReportId())) {
            String[] ids = ocrmFwpWorkReport.getWorkReportId().split(",");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("workReport", ocrmFwpWorkReport);
            map.put("workReportIds", ids);
            result = ocrmFwpWorkReportMapper.deleteByWorkReportIds(map);
        }
        return result;
    }

    @Transactional(readOnly = true)
    public String queryOrgId(String orgId) {
        List<Map<String, String>> list = ocrmFwpWorkReportMapper.queryOrgId(orgId);
        StringBuilder sb = new StringBuilder();
        for (Map<String, String> map : list) {
            sb.append("'" + map.get("orgId") + "'" + ",");
        }
        String id = sb.toString();
        id = id.substring(0, id.lastIndexOf(","));
        return id;
    }

    public int updateWorkReport(OcrmFwpWorkReport ocrmFwpWorkReport) {
        // TODO 增加异常处理
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        if (ocrmFwpWorkReport.getLastChgUsrId() == null || "".equals(ocrmFwpWorkReport.getLastChgUsrId())) {
            ocrmFwpWorkReport.setLastChgUsrId(dto.getBody().getLoginCode());
        }
        if (ocrmFwpWorkReport.getLastChgUsrName() == null || "".equals(ocrmFwpWorkReport.getLastChgUsrName())) {
            ocrmFwpWorkReport.setLastChgUsrName(dto.getBody().getUserName());
        }
        if (ocrmFwpWorkReport.getLastChgUsrOrgId() == null || "".equals(ocrmFwpWorkReport.getLastChgUsrOrgId())) {
            ocrmFwpWorkReport.setLastChgUsrOrgId(dto.getBody().getOrg().getId());
        }
        if (ocrmFwpWorkReport.getLastChgUsrOrgName() == null || "".equals(ocrmFwpWorkReport.getLastChgUsrOrgName())) {
            ocrmFwpWorkReport.setLastChgUsrOrgName(dto.getBody().getOrg().getName());
        }
        if (ocrmFwpWorkReport.getLastChgDate() == null) {
            ocrmFwpWorkReport.setLastChgDate(new java.util.Date());
        }
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "";
        try {
			if (ocrmFwpWorkReport.getEndDate() != null) {
			    time = s.format(ocrmFwpWorkReport.getEndDate()).split("\\s+")[0]+" 23:59:59";
			    ocrmFwpWorkReport.setEndDate(s.parse(time));
			}
			if (ocrmFwpWorkReport.getStartDate() != null) {
			    time = s.format(ocrmFwpWorkReport.getStartDate()).split("\\s+")[0]+" 00:00:00";
			    ocrmFwpWorkReport.setStartDate(s.parse(time));
			}
			if (ocrmFwpWorkReport.getLastChgDate() != null) {
			    time = s.format(ocrmFwpWorkReport.getLastChgDate());
			    ocrmFwpWorkReport.setLastChgDate(s.parse(time));
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        return ocrmFwpWorkReportMapper.updateWorkReport(ocrmFwpWorkReport);
    }

    public String getUuid() {
        OgnlContext contxet = new OgnlContext();
        try {
            Object ognl = Ognl.parseExpression("@java.util.UUID@randomUUID().toString().replace(\"-\", \"\")");
            return Ognl.getValue(ognl, contxet, contxet.getRoot()).toString();
        } catch (OgnlException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public void export(QueryModel model,HttpServletResponse response ) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode("工作报告", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        String templateFileName = "templates" + File.separator + "workreport_templat.xlsx";
        ExcelWriter excelWriter = null;

        excelWriter = EasyExcel.write(response.getOutputStream())
                .withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();
        WriteSheet writeSheet1 = EasyExcel.writerSheet(0, "工作日报导出").registerWriteHandler(new ExcelFillCellMergeStrategy(new int[]{0,1,2,3,4,5,6,7,14,15},2)).build();
        WriteSheet writeSheet2 = EasyExcel.writerSheet(1, "工作周报导出").build();
        WriteSheet writeSheet3 = EasyExcel.writerSheet(2, "工作月报导出").build();
        String workReportId = (String) model.getCondition().get("workReportId");
        if (workReportId != null && !"".equals(workReportId)){
            model.getCondition().put("workReportIds",workReportId.split(","));
        }
        List<WorkReportExcle> list = ocrmFwpWorkReportMapper.getDay(model);
        Map<String,List<WorkReportExcle>> resultMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        resultMap.putAll(list.stream().collect(Collectors.groupingBy(WorkReportExcle::getCreateDate)));
        int i = 1;
        for (Map.Entry<String,List<WorkReportExcle>> m: resultMap.entrySet()) {
            List<WorkReportExcle> list1 = m.getValue();
            WorkReportExcle workReportExcle = list1.get(0);
            for (WorkReportExcle wre: list1) {
                wre.setAnnex(workReportExcle.getAnnex());
                wre.setCreateDate(workReportExcle.getCreateDate());
                wre.setCreatorName(workReportExcle.getCreatorName());
                wre.setWorkReportId(String.valueOf(i));
                wre.setWorkContent(workReportExcle.getWorkContent());
                wre.setWorkReportBusiType(workReportExcle.getWorkReportBusiType());
                wre.setLaterPlan(workReportExcle.getLaterPlan());
                wre.setStartDate(workReportExcle.getStartDate());
                wre.setIsDraft(workReportExcle.getIsDraft());
                wre.setWorkSummary(workReportExcle.getWorkSummary());
            }
            i++;
        }
        excelWriter.fill(list, FillConfig.builder().forceNewRow(Boolean.TRUE).build(), writeSheet1);
        excelWriter.fill(ocrmFwpWorkReportMapper.getWeek(model), writeSheet2);
        excelWriter.fill(ocrmFwpWorkReportMapper.getMonth(model), writeSheet3);
        // 关闭流
        excelWriter.finish();
    }



    public int export1(QueryModel model, HttpServletResponse response) throws IOException {
//        logger.info("灵活查询结果数据导出export  begin");
        int ret = 0;
        List<Map<String, Object>> OneTableDataList = this.listByModel(model);//数据参数
        List<Map<String, Object>> colList = (List) model.getCondition().get("colunmNamelist");//表头参数
        List<List<CellInfo>> datalist = new ArrayList<List<CellInfo>>();
        List<Map<String, Object>> exportDataList = new ArrayList<Map<String, Object>>();
        List<List<CellInfo>> headerTwo = new ArrayList<List<CellInfo>>();
        String cols = "";
        String colskey = "";
        List<CellInfo> heads = new ArrayList<CellInfo>();
        for (int k = 0; k < colList.size(); k++) {//遍历表头数据
            if (k == 0) {
                cols = (String) colList.get(k).get("name");
                colskey = (String) colList.get(k).get("ename");
            } else {
                cols = cols + "," + (String) colList.get(k).get("name");
                colskey = colskey + "," + (String) colList.get(k).get("ename");
            }
            heads.add(new CellInfo((String) colList.get(k).get("name")));//字段名
        }
        //表头list
        if (heads.size() > 0) {
            headerTwo.add(heads);
        }
//        logger.info("灵活查询结果数据导出export  dataList.size="+OneTableDataList.size());
        if (OneTableDataList.size() > 50000) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('数据量过大，禁止导出！');</script>");
            response.getWriter().write("<script>window.close();window.history.go(-1);</script>");
            response.getWriter().flush();
        } else {
            List<CellInfo> dataForOne;
            String data = "";
            String[] colkey = colskey.split(",");
            for (int m = 0; m < OneTableDataList.size(); m++) {
                dataForOne = new ArrayList<CellInfo>();
                for (int b = 0; b < colkey.length; b++) {
                    String colName = colkey[b];
                    Object dataTemp = OneTableDataList.get(m).get(colName);
                    data = String.valueOf(dataTemp);
                    if ("workReportBusiType".equals(colName)) {
                        if ("1".equals((data))) {
                            data = "日报";
                        }
                        if ("2".equals(data)) {
                            data = "周报";
                        }
                        if ("3".equals(data)) {
                            data = "月报";
                        }
                    } else if ("workSummary".equals(colName)) {
                        String workSummary = "";
                        if (data.indexOf("1") >= 0) {
                            workSummary += "客户跟进  ";
                        }
                        if (data.indexOf("2") >= 0) {
                            workSummary += "培训/会议  ";
                        }
                        if (data.indexOf("3") >= 0) {
                            workSummary += "外访  ";
                        }
                        if (data.indexOf("4") >= 0) {
                            workSummary += "商机  ";
                        }
                        if (data.indexOf("5") >= 0) {
                            workSummary += "材料整理  ";
                        }
                        data = workSummary;
                    } else if ("isDraft".equals(colName)) {
                        if ("N".equals(data)) {
                            data = "否";
                        }
                        if ("Y".equals(data)) {
                            data = "是";
                        }
                    }else if ("workContent".equals(colName)) {
                        String[] str = data.split(";");
                        String content = "";
                        for (int i = 0; i < str.length; i++) {
							String[] item = str[i].split(":");
							if(item.length == 2) {
								content += item[0]+":"+item[1]+";";
							}
						}
                    }
                    if ("null".equals(data)) {
                        data = "";
                    }
                    dataForOne.add(new CellInfo(data));
//                    dataForOne.add(new CellInfo(String.valueOf(OneTableDataList.get(m).get(colkey[b]))));
                }
                datalist.add(dataForOne);
            }
            Map<String, Object> mapTwo = new HashMap<String, Object>();
            mapTwo.put("sheetName", "查询结果");//sheet名
            mapTwo.put("headerLength", colList.size());//表头长度
            mapTwo.put("header", headerTwo);//表头
            mapTwo.put("data", datalist);//数据
            exportDataList.add(mapTwo);
//            logger.info("灵活查询结果数据导出export  data="+exportDataList);
            OutputStream out = null;
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(cal.getTime()) + "查询结果数据";
            try {
                date = new String(date.getBytes("utf-8"), "ISO8859-1");
            } catch (UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
//
            SXSSFWorkbook workbook = exportExcel(exportDataList);
//
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.addHeader("Content-Disposition", "attachment; filename=\""
                    + date + ".xlsx\"");
            OutputStream outputStream = null;
            try {
                outputStream = response.getOutputStream();
                workbook.write(outputStream);
                outputStream.flush();
            } catch (IOException e) {
                ret = 1;
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    ret = 1;
                }
            }
        }
        return ret;
    }

    //导出
    public SXSSFWorkbook exportExcel(List<Map<String, Object>> datas) throws IOException {
//        logger.info("业务数据导出exportExcel  begin");
        //创建工作簿
        SXSSFWorkbook workbook = new SXSSFWorkbook();

        //表头的样式
//        HSSFCellStyle titlestyle = workbook.createCellStyle();// 创建样式对象
//        titlestyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中
//        titlestyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
//        titlestyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        titlestyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        titlestyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        titlestyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //字体
        Font titleFont = workbook.createFont(); // 创建字体对象
        titleFont.setFontHeightInPoints((short) 11); // 设置字体大小
        titleFont.setFontName("微软雅黑"); // 设置为黑体字
//        titlestyle.setFont(titleFont);
        //指定当单元格内容显示不下时自动换行
//        titlestyle.setWrapText(true);
        //表数据的样式
//        HSSFCellStyle style = workbook.createCellStyle();// 创建样式对象
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
//        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //字体
        Font font = workbook.createFont(); // 创建字体对象
        font.setFontHeightInPoints((short) 11); // 设置字体大小
        font.setFontName("微软雅黑"); // 设置为黑体字
//        style.setFont(font);
        //指定当单元格内容显示不下时自动换行
//        style.setWrapText(true);

        for (Map<String, Object> map : datas) {
            String sheetName = map.get("sheetName").toString();
//            String title ="";
//            String unitInfo = "";
//            logger.info("业务数据导出exportExcel  title="+title);
//            logger.info("业务数据导出exportExcel  unitInfo="+unitInfo);
            int headerLength = (int) map.get("headerLength");
            List<List<CellInfo>> header = (List<List<CellInfo>>) map.get("header");
            List<List<CellInfo>> data = (List<List<CellInfo>>) map.get("data");
            //创建Sheet
            SXSSFSheet sheet = workbook.createSheet(sheetName);
            //设置表格默认列宽度为20个字节
            sheet.setDefaultColumnWidth(20);
            //设置第一行  （单位信息，定制）
            int rowNum = -1;
//            if(null!=unitInfo || !"".equals(unitInfo)){
//            	logger.info("业务数据导出exportExcel  unitInfo=="+rowNum);
//                sheet.addMergedRegion(new CellRangeAddress(rowNum,1,0,headerLength-1));
//                HSSFRow rowUnit = sheet.createRow(rowNum);
//                HSSFCell cellUnit = rowUnit.createCell(0);
//                HSSFCellStyle unitStyle = workbook.createCellStyle();// 创建样式对象
//                unitStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
//                unitStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
//                unitStyle.setFont(font);
//                cellUnit.setCellStyle(unitStyle);
//                cellUnit.setCellValue(unitInfo);
//                rowNum =1;
//            }
            //标题
//            if(null!=title || !"".equals(title)){
//                rowNum++;
//                logger.info("业务数据导出exportExcel  title="+rowNum);
//                HSSFRow rowHeader = sheet.createRow(rowNum);
//                for(int i=0;i<headerLength;i++){
//                    HSSFCell cellHeader = rowHeader.createCell(i);
//                    cellHeader.setCellStyle(titlestyle);
//                    cellHeader.setCellValue(title);
//                }
//                rowNum++;
//                logger.info("业务数据导出exportExcel  title2="+rowNum);
//                HSSFRow title2 = sheet.createRow(rowNum);
//                for(int i=0;i<headerLength;i++){
//                    HSSFCell cellHeader = title2.createCell(i);
//                    cellHeader.setCellStyle(titlestyle);
//                    cellHeader.setCellValue(title);
//                }
//                sheet.addMergedRegion(new CellRangeAddress(rowNum-1,rowNum,0,headerLength-1));
//            }

            //表头
            for (int i = 0; i < header.size(); i++) {
                //行
                rowNum++;
//                logger.info("业务数据导出exportExcel  header="+rowNum);
                SXSSFRow row = sheet.createRow(rowNum);
                List<CellInfo> cols = header.get(i);

                //创建列
                int colNum = 0;
                for (int j = 0; j < cols.size(); j++) {
                    SXSSFCell cell = row.createCell(colNum);
//                    cell.setCellStyle(titlestyle);
                    cell.setCellValue(cols.get(j).getContent());
                    int firstRow = rowNum;
                    int lastRow = rowNum;
                    int firstCol = colNum;
                    int lastCol = colNum;
                    boolean merge = false;
                    if (cols.get(j).getRowSpan() > 1) {
                        lastRow += cols.get(j).getRowSpan() - 1;
                        merge = true;
                    }
//                    logger.info("业务数据导出exportExcel  header getRowSpan merge="+merge);
                    //如果跨行则先创建被合并的单元格（主要是不创建的话，合并后的样式引用有问题）
                    if (cols.get(j).getColSpan() > 1) {
                        for (int k = 0; k < cols.get(j).getColSpan() - 1; k++) {
                            colNum++;
                            SXSSFCell tmpCell = row.createCell(colNum);
//                            tmpCell.setCellStyle(titlestyle);
                            tmpCell.setCellValue(cols.get(j).getContent());
                        }
                        lastCol = colNum;
                        merge = true;
                    }
                    colNum++;
//                    logger.info("业务数据导出exportExcel  header getColSpan merge="+merge);
                    if (merge) {
                        sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
                    }
                }
            }
            //表格数据
//            logger.info("业务数据导出+模板data.size()="+data.size());
            if (data.size() > 0) {
                for (int i = 0; i < data.size(); i++) {
                    //行
                    rowNum++;
//               logger.info("业务数据导出exportExcel  data="+rowNum);
                    SXSSFRow row = sheet.createRow(rowNum);
                    List<CellInfo> cols = data.get(i);
                    //创建列
                    int colNum = 0;
                    for (int j = 0; j < cols.size(); j++) {
                        SXSSFCell cell = row.createCell(colNum);
//                   cell.setCellStyle(style);
                        cell.setCellValue(cols.get(j).getContent());
                        int firstRow = rowNum;
                        int lastRow = rowNum;
                        int firstCol = colNum;
                        int lastCol = colNum;
                        boolean merge = false;
                        if (cols.get(j).getRowSpan() > 1) {
                            lastRow += cols.get(j).getRowSpan() - 1;
                            merge = true;
                        }
                        //如果跨行则先创建被合并的单元格（主要是不创建的话，合并后的样式引用有问题）
                        if (cols.get(j).getColSpan() > 1) {
                            for (int k = 0; k < cols.get(j).getColSpan() - 1; k++) {
                                colNum++;
                                SXSSFCell tmpCell = row.createCell(colNum);
//                           tmpCell.setCellStyle(style);
                                tmpCell.setCellValue(cols.get(j).getContent());
                            }
                            lastCol = colNum;
                            merge = true;
                        }
                        colNum++;
                        if (merge) {
                            sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
                        }
                    }
                }
            }
            rowNum++;

        }
        return workbook;
    }

	public List<Map<String, Object>> queryMlist(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
        Map<String, Object> condition = model.getCondition();
        if (condition.get("rangeDate") instanceof List) {
            List<String> rangeDate = (List<String>) condition.get("rangeDate");
            if (rangeDate != null && rangeDate.size() == 2) {
                condition.put("startDate", rangeDate.get(0).trim());
                condition.put("endDate", rangeDate.get(1).trim());
            }
        }
        if (condition.get("workSummary") instanceof String) {
            String workSummary = (String) condition.get("workSummary");
            if (workSummary != null) {
                workSummary = "%" + workSummary + "%";
                condition.put("workSummary", workSummary);
            }
        }
        List<Map<String, Object>> list = ocrmFwpWorkReportMapper.queryMlist(model);
        PageHelper.clearPage();
        return list;
	}

    public int updateStatus(String workReportId, String s) {
        return ocrmFwpWorkReportMapper.updateStatus(workReportId,s);
    }

    public List<Map<String, Object>> detail(String workReportId) {
        return ocrmFwpWorkReportMapper.queryDetail(workReportId);
    }

    public String getCurrentNodeUserName(String receUserId) {
        return ocrmFwpWorkReportMapper.getUserName(receUserId);
    }

    public int saveIntanceId(String workReportId, String instanceId) {
        return ocrmFwpWorkReportMapper.saveIntanceId(workReportId,instanceId);
    }
}
