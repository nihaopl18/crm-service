package cn.com.yusys.yscrm.cust.person.service;

import java.awt.FontMetrics;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.swing.JLabel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import cn.com.yusys.yscrm.cust.person.domain.CellInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmAciReportApply;
import cn.com.yusys.yscrm.cust.person.repository.mapper.AcrmFevtPerCcdTransMapper;
import cn.com.yusys.yscrm.cust.person.util.PDFReport;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import net.sf.json.JSONObject;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFevtCcdTransService
 * @类描述: #服务类
 * @功能描述: 账户信息-贷记卡账户交易流水
 * @创建人: 15104
 * @创建时间: 2019-02-11 09:59:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFevtPerCcdTransService extends CommonService {
    @Autowired
    private AcrmFevtPerCcdTransMapper acrmFevtCcdTransMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFevtCcdTransMapper;
    }

    @Transactional(readOnly = true) // 贷款概览信息查询
	public List<Map<Object, String>> querylist(QueryModel model) {
		if(model.getCondition().get("export")!=null&&model.getCondition().get("export").equals("1")) {
			List<Map<Object, String>>  list = acrmFevtCcdTransMapper.queryccdListByCustId(model);
			return list;
		}
    	PageHelper.startPage(model.getPage(), model.getSize());
		
		List<Map<Object, String>>  list = acrmFevtCcdTransMapper.queryccdListByCustId(model);
		
		PageHelper.clearPage();
		
		return list;
	}
    
    
    @SuppressWarnings("unchecked")
   	public int export(QueryModel model, HttpServletResponse response) throws IOException {
		System.out.println("信用卡交易查询数据导出export  begin");
		int ret = 0;
		List<OcrmAciReportApply> resultlist= acrmFevtCcdTransMapper.getParams(model.getCondition().get("bizseqno").toString());
		JSONObject array=JSONObject.fromObject(resultlist.get(0).getParams());
		Map map=new HashMap<>();
		for(Object array1:array.keySet()) {
			Object v=array.get(array1);
			map.put(array1,v);
		}
		List<Map<String, Object>> colList  = (List)map.get("colunmNamelist");//表头参数(列)
		List<Map<String, Object>> OneTableDataList = (List)map.get("datalist");//数据参数
		String userName = (String)map.get("userName");//水印文字
		String fileName = (String)map.get("fileName");//表标题
		List<List<CellInfo>> datalist=new ArrayList<List<CellInfo>>();
		List<Map<String,Object>> exportDataList = new ArrayList<Map<String,Object>>();
		List<List<CellInfo>> headerTwo = new ArrayList<List<CellInfo>>();
		List<List<CellInfo>> widthTwo = new ArrayList<List<CellInfo>>();
		String cols = "";
		String colskey = "";
		String colswid = "";
		List<CellInfo> heads = new ArrayList<CellInfo>();
		List<CellInfo> widths = new ArrayList<CellInfo>();
		for (int k = 0; k < colList.size(); k++) {//遍历表头数据
			if (k == 0) {
				cols = (String) colList.get(k).get("label");
				colskey = (String) colList.get(k).get("prop");
				colswid = (String) colList.get(k).get("width");
			} else {
				cols = cols + "," + (String) colList.get(k).get("label");
				colskey=colskey+ ","+(String) colList.get(k).get("prop");
				colswid =colswid+"," +(String) colList.get(k).get("width");
			}
			heads.add(new CellInfo((String)colList.get(k).get("label")));//字段名
			widths.add(new CellInfo((String)colList.get(k).get("width")));//字段宽度s
		}
		//表头list	
		if (heads.size() > 0) {
			headerTwo.add(heads);
		}
		//表头宽度
		if(widths.size()>0) {
			widthTwo.add(widths);
		}
		System.out.println("信用卡交易查询数据导出export  dataList.size="+OneTableDataList.size());
		if(OneTableDataList.size()>10000){
			response.setContentType("text/html;charset=utf-8"); 
			response .getWriter().write("<script>alert('数据量过大，禁止导出！');</script>");
			response.getWriter().write("<script>window.close();window.history.go(-1);</script>");    
			response.getWriter().flush();
		}else{
			List<CellInfo> dataForOne;
			String[] colkey = colskey.split(",");
			for (int m = 0; m < OneTableDataList.size(); m++) {
				dataForOne = new ArrayList<CellInfo>();
				for (int b = 0; b < colkey.length; b++) {
					dataForOne.add(new CellInfo(String.valueOf(OneTableDataList.get(m).get(colkey[b]))));
				}
				datalist.add(dataForOne);
			}
			Map<String, Object> mapTwo = new HashMap<String, Object>();
			mapTwo.put("sheetName", fileName);//sheet名
			mapTwo.put("headerLength", colList.size());//表头长度
			mapTwo.put("header", headerTwo);//表头
			mapTwo.put("data", datalist);//数据
			mapTwo.put("userName", userName);//水印文字
			mapTwo.put("widths", widthTwo);//表列宽度
			exportDataList.add(mapTwo);
			System.out.println("信用卡交易查询数据导出export  data="+exportDataList);
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(cal.getTime()) + "信用卡交易查询数据";
			String date1 = sdf.format(cal.getTime()) + "信用卡交易查询数据tmp";
			try {
				date = new String(date.getBytes("gbk"), "ISO8859-1");
				date1 = new String(date1.getBytes("gbk"), "ISO8859-1");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BufferedInputStream buf = null;
			OutputStream os = null;
			response.reset();
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename=\"" + date + ".pdf\"");
			try {
				PDFReport.createPDF(date,exportDataList,userName,date1);
				buf = new BufferedInputStream(new FileInputStream(date));
				int j = 0;
				byte[] b = new byte[buf.available() + 1000];
				os = response.getOutputStream();// 直接下载导出
				while ((j = buf.read(b)) != -1) {
					os.write(b, 0, j);
				}
				os.flush();
				// os.close();
			} catch (Exception e) {
				ret = 1;
			} finally {
				try {
					if (os != null) {
						os.close();
					}
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
					ret = 1;
				}finally {
					if(buf!=null){
						buf.close();
					}
				}

			}
		}
		return ret;
	}
}
