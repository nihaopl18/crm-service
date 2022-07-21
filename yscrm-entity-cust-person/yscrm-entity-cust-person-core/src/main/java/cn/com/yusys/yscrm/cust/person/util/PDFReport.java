package cn.com.yusys.yscrm.cust.person.util;

import java.awt.FontMetrics;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.RectangleReadOnly;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import cn.com.yusys.yscrm.cust.person.domain.CellInfo;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;


/**
 * 申明一个文档类型建立Document对象，设置页面样式等
 * 
 * @author zjy
 *
 */
public class PDFReport{


	private static Font headfont; // 设置字体大小
	private static Font keyfont; // 设置字体大小
	private static Font textfont; // 设置字体大小

	static {
		BaseFont bfChinese;
		try {
			bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			headfont = new Font(bfChinese, 11, Font.BOLD);// 设置字体大小
			keyfont = new Font(bfChinese, 11, Font.NORMAL);// 设置字体大小
			textfont = new Font(bfChinese, 10, Font.NORMAL);// 设置字体大小
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
//	 public  PDFReport(File out,List<Map<String,Object>> exportDataList) {
////			纵向
////			Document document = new Document();
////			document.setPageSize(PageSize.A4);// 设置页面大小
//			//横向
//			Document document = new Document(new RectangleReadOnly(842F,595F));
//			try {
//				PdfWriter.getInstance(document,new FileOutputStream(out));
//				document.open();
//				PdfPTable table = generatePDF(exportDataList);
//				document.add(table);
//				document.close();
//				// PDFUtil.waterMark(input.getPath(),out.getPath(), "哈哈");// 添加水印
//			} catch (DocumentException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//		 }
//	 public  PDFReport(File out,List<Map<String,Object>> exportDataList,String water) {
////			纵向
////			Document document = new Document();
////			document.setPageSize(PageSize.A4);// 设置页面大小
//			//横向
//			Document document = new Document(new RectangleReadOnly(842F,595F));
//			try {
//				PdfWriter pdfWriter = PdfWriter.getInstance(document,new FileOutputStream(out));
////				pdfWriter.setPageEvent(new PDFBuilder(water));
//				document.open();
//				PdfPTable table = generatePDF(exportDataList);
//				document.add(table);
//				document.close();
////				PDFUtil.waterMark(input.getPath(),out.getPath(), "哈哈");// 添加水印
//			} catch (DocumentException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//		 }
	 /**
	     * 生成PDF文件的主要方法
	     *
	     * @param out /input 生成pdf文件存放的完整绝对路径  example: test.pdf
	     * @param content   pdf 正文
	     * @param waterMark pdf 每页的水印， 建议不要过长 8个字符差不多了， 太长需要调节字体大小， 否则无法显示完整
	     */
	    public static void createPDF(String out, List<Map<String,Object>> exportDataList, String waterMark,String input) {
	        //横向
	        Document document = new Document(new RectangleReadOnly(842F,595F));
	        try {
	            PdfWriter.getInstance(document,new FileOutputStream(input));
	            document.open();
	            PdfPTable table = generatePDF(exportDataList);
				document.add(table);
	            document.close();
	            PDFReport.waterMark(input,out, waterMark);// 添加水印
	        } catch (DocumentException e) {
	            // TODO 自动生成的 catch 块
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO 自动生成的 catch 块
	            e.printStackTrace();
	        }

	    }

	/**
	 * 合并行的静态函数
	 */
	public static PdfPCell mergeRow(String str, Font font, int col) {

		// 创建单元格对象，将内容及字体传入
		PdfPCell cell = new PdfPCell(new Paragraph(str, font));
		// 设置单元格内容居中
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		// 设置最小单元格高度
		// cell.setMinimumHeight(40);
		cell.setMinimumHeight(10);
		// 将该单元格所在列包括该单元格在内的8行单元格合并为一个单元格
		cell.setColspan(col);
		return cell;
	}

	/**
	 * 获取指定内容与字体的单元格
	 */
	public static PdfPCell getPDFCell(String string, Font font) {
		// 创建单元格对象，将内容与字体放入段落中作为单元格内容
		PdfPCell cell = new PdfPCell(new Paragraph(string, font));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		// 设置最小单元格高度
		cell.setMinimumHeight(5);
		return cell;
	}


	public static PdfPTable generatePDF(List<Map<String,Object>> datas) {
		String sheetName = ""; //表标题
		int headerLength =0;//表格长度
		List<String> titles = new ArrayList<String>();//表列标题
		List<String> widths = new ArrayList<String>();//表列宽度
		List<String> data = new ArrayList<String>();//表数据
	    for(Map<String,Object> map:datas){
            sheetName = map.get("sheetName").toString();//表标题
            headerLength  = (int)map.get("headerLength");
            List<List<CellInfo>> header  = (List<List<CellInfo>>)map.get("header");
            List<List<CellInfo>> widthss  = (List<List<CellInfo>>)map.get("widths");
            List<List<CellInfo>> datass  = (List<List<CellInfo>>)map.get("data");
            //表头
            for (int i = 0; i < header.size(); i++) {
                List<CellInfo> cols = header.get(i);
                for(int j=0;j<cols.size();j++){
                	titles.add(cols.get(j).getContent());
                }
             }
            //表列宽度
            for (int i = 0; i < widthss.size(); i++) {
                List<CellInfo> cols = widthss.get(i);
                for(int j=0;j<cols.size();j++){
                	widths.add(cols.get(j).getContent());
                }
             }

           if(datass.size()>0){
            for (int i = 0; i < datass.size(); i++) {
               List<CellInfo> cols = datass.get(i);
               for(int j=0;j<cols.size();j++){
            	   data.add(cols.get(j).getContent());
               }
            }
           }
        }
		
		// 创建PdfTable对象
		PdfPTable table = new PdfPTable(headerLength); // 列表的字段长度
		float[] ff = new float[widths.size()];
		// 列宽度
		for (int i = 0; i < widths.size(); i++) {
			ff[i] = Float.parseFloat(widths.get(i));
		}
		// 设置各列的列宽
		try {
			// table.setTotalWidth(new float[]{100,350,350,100,100,100,100,100});
			table.setTotalWidth(ff);
			table.addCell(mergeRow(sheetName, headfont, widths.size()));// 表头
			// 表头2添加表格内容 表标题
			for (String f : titles) {
				table.addCell(getPDFCell(f, keyfont));
			}
			// 填充表格的数据
			for (String dt : data) {
					table.addCell(getPDFCell(String.valueOf(dt), textfont));
			}
			table.setWidthPercentage(100);// 表宽度设置可不受页面边距影响
		} catch (DocumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return table;
	}
	
  
	 private static int interval = -5;
	    //添加水印  String outputFile,
	    public static void waterMark(String inputFile,
	            String outputFile,String waterMarkName) {
	        try {
	            PdfReader reader = new PdfReader(inputFile);
	            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputFile));
	            BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",   BaseFont.EMBEDDED);
	            Rectangle pageRect = null;
	            PdfGState gs = new PdfGState();
	            gs.setFillOpacity(0.3f);
	            gs.setStrokeOpacity(0.4f);
	            int total = reader.getNumberOfPages() + 1;

	            JLabel label = new JLabel();
	            FontMetrics metrics;
	            int textH = 0;
	            int textW = 0;
	            label.setText(waterMarkName);
	            metrics = label.getFontMetrics(label.getFont());
	            textH = metrics.getHeight();
	            textW = metrics.stringWidth(label.getText());

	            PdfContentByte under;
	            for (int i = 1; i < total; i++) {
	                pageRect = reader.getPageSizeWithRotation(i);
	                under = stamper.getOverContent(i);
	                under.saveState();
	                under.setGState(gs);
	                under.beginText();
	                under.setFontAndSize(base, 10);

	                // 水印文字成30度角倾斜
	                //你可以随心所欲的改你自己想要的角度
	                for (int height = interval + textH; height < pageRect.getHeight();
	                        height = height + textH*3) {
	                    for (int width = interval + textW; width < pageRect.getWidth() + textW;
	                            width = width + textW*2) {
	                under.showTextAligned(Element.ALIGN_LEFT
	                        , waterMarkName, width - textW,
	                        height - textH, 30);
	                    }
	                }
	                // 添加水印文字
	                under.endText();
	            }
	            //说三遍
	           //一定不要忘记关闭流
	          //一定不要忘记关闭流
	          //一定不要忘记关闭流
	            stamper.close();
	            reader.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
    

  
}
