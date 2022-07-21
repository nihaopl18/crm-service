package cn.com.yusys.yscrm.pcrm.common.remindInfo.utils;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
public class ExportExcel {

    /**
     * 导出excel
     *
     * @param response
     *            HttpServletResponse
     * @param list
     *            导出数据集合
     * @param lables
     *            表头数组
     * @param fields
     *            key数组
     * @param title
     *            文件名
     */
    public static void export(HttpServletResponse response,List<Map<String, Object>> list,String[] lables,String[] fields,String title,String password) {
       /* response.setContentType("application/octet-stream");//告诉浏览器输出内容为流
        String filename = "";
        try {
            filename = new String(title.getBytes("UTF-8"), "ISO_8859_1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        response.setHeader("Content-Disposition","attachment;filename=" + filename);*/
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
         title=title+df.format(new Date());
        OutputStream os = null;
        SXSSFWorkbook sxssfWorkbook = null;
        try {
            // 获取SXSSFWorkbook
            sxssfWorkbook = new SXSSFWorkbook();
            Sheet sheet = sxssfWorkbook.createSheet("sheet1");
            // 冻结第一行
            sheet.createFreezePane(0, 1);
            // 创建第一行,作为header表头
            Row header = sheet.createRow(0);
            // 循环创建header单元格
            for (int cellnum = 0; cellnum < lables.length; cellnum++) {
                Cell cell = header.createCell(cellnum);
                //cell.setCellStyle(getAndSetXSSFCellStyleHeader(sxssfWorkbook));//设置表头单元格样式,根据需要设置
                cell.setCellValue(lables[cellnum]);
                //设置每列固定宽度
                sheet.setColumnWidth(cellnum, 20 * 256);
            }
            // 遍历创建行,导出数据
            for (int rownum = 1; rownum <= list.size(); rownum++) {
                Row row = sheet.createRow(rownum);
                Map<String, Object> map = list.get(rownum - 1);
                // 循环创建单元格
                for (int cellnum = 0; cellnum < fields.length; cellnum++) {
                    Cell cell = row.createCell(cellnum);
                    //cell.setCellStyle(getAndSetXSSFCellStyleOne(sxssfWorkbook));//设置数据行单元格样式,根据需要设置
                    cell.setCellValue(map.get(fields[cellnum]) == null ? "" : map.get(fields[cellnum]).toString());
                }
            }
            if (sxssfWorkbook != null) {
                ByteArrayOutputStream bout = null;
                ByteArrayInputStream workbookinput = null;
                OutputStream outstream = null;
                OPCPackage opc = null;
                OutputStream oss = null;
                try {
                    // 把工作薄输出到字节里面
                    bout = new ByteArrayOutputStream();
                    sxssfWorkbook.write(bout);
                    bout.flush();
                    workbookinput = new ByteArrayInputStream(bout.toByteArray());
                    // 读取临时文件进行加密
                    POIFSFileSystem fs = new POIFSFileSystem();
                    EncryptionInfo info = new EncryptionInfo(EncryptionMode.standard);
                    Encryptor enc = info.getEncryptor();
                    enc.confirmPassword(password);//打开excel 密码
                    // 然后把字节输入到输入流，然后输入到OPC包里面
                    opc = OPCPackage.open(workbookinput);
                    oss = enc.getDataStream(fs);
                    opc.save(oss);
                    opc.close();
                    // 返回给浏览器
                    outstream = response.getOutputStream();
                    response.reset();
                    response.setHeader("Content-disposition",
                            "attachment; filename=" + new String(title.getBytes(), "ISO-8859-1") + ".xlsx");
                    response.setContentType("application/x-download");
                    fs.writeFilesystem(outstream);
       /*     //自定义各列宽度
            //setSheet(sheet);
            sxssfWorkbook.write(os);*/
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (sxssfWorkbook != null) {
                            //处理SXSSFWorkbook导出excel时，产生的临时文件
                            sxssfWorkbook.dispose();
                        }
                        if (os != null) {
                            os.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch (Exception e) {
                    e.printStackTrace();
                }
    }
}
