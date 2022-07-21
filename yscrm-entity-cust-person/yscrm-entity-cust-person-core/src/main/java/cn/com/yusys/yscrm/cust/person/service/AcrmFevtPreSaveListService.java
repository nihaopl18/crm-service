package cn.com.yusys.yscrm.cust.person.service;

import java.awt.FontMetrics;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JLabel;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFevtPerSaveList;
import cn.com.yusys.yscrm.cust.person.domain.CellInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmAciReportApply;
import cn.com.yusys.yscrm.cust.person.interfaces.QryAccountSvcSrvBindingQSService;
import cn.com.yusys.yscrm.cust.person.interfaces.QryAccountSvcSrvPortType;
import cn.com.yusys.yscrm.cust.person.interfaces.SRVReqHead;
import cn.com.yusys.yscrm.cust.person.interfaces.SrvReqBizBody;
import cn.com.yusys.yscrm.cust.person.interfaces.SrvReqBody;
import cn.com.yusys.yscrm.cust.person.interfaces.SrvResBizBody;
import cn.com.yusys.yscrm.cust.person.interfaces.SrvResBody;
import cn.com.yusys.yscrm.cust.person.interfaces.SysMsgHeader;
import cn.com.yusys.yscrm.cust.person.repository.mapper.AcrmFevtPreSaveListMapper;
import cn.com.yusys.yscrm.cust.person.util.CstRelInfQrySvcSrvBindingQSPortImpl;
import cn.com.yusys.yscrm.cust.person.util.DataUtils;
import cn.com.yusys.yscrm.cust.person.util.DateUtils;
import cn.com.yusys.yscrm.cust.person.util.IdCreator;
import cn.com.yusys.yscrm.cust.person.util.SendFileClient;
import cn.com.yusys.yscrm.cust.person.util.SoapUtil;

import cn.com.yusys.yscrm.cust.person.util.PDFReport;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

import net.sf.json.JSONObject;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFevtPreSaveListService
 * @类描述: #服务类
 * @功能描述: 账户信息-存款交易流水
 * @创建人: 15104
 * @创建时间: 2019-01-28 00:23:48
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFevtPreSaveListService extends CommonService {
	private static final Logger LOG = Logger.getLogger(AcrmFevtPreSaveListService.class.getName());
	@Autowired
	private AcrmFevtPreSaveListMapper acrmFevtPreSaveListMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return acrmFevtPreSaveListMapper;
	}

	@Autowired
	private Environment env;
	@Autowired
	LogServicess logService;
	@Transactional(readOnly = true) // 贷款概览信息查询
	public List<Map<Object, String>> querylist(QueryModel model) {
		if (model.getCondition().get("export") != null && (model.getCondition().get("export").equals("1"))) {
			List<Map<Object, String>> list = acrmFevtPreSaveListMapper.querySaveListByCustId(model);
			return list;
		}
		PageHelper.startPage(model.getPage(), model.getSize());
		// model.getCondition().put("acctId", acctId);
		List<Map<Object, String>> list = acrmFevtPreSaveListMapper.querySaveListByCustId(model);
		PageHelper.clearPage();
		return list;
	}

	@Transactional(readOnly = true)
	public List<Map<Object, String>> queryballist(QueryModel model) throws NoSuchAlgorithmException {
		System.out.println("=====================调用核心系统帐户查询接口==================");
		List<Map<Object, String>> list = new ArrayList<>();
		String acctNo = (String) model.getCondition().get("acctId");
		String wsdlArr = "http://"+env.getProperty("wsdl.address")+":8111/services/P00001002360?wsdl";
		QryAccountSvcSrvBindingQSService qs = new QryAccountSvcSrvBindingQSService();
		QryAccountSvcSrvPortType portType = qs.getPort(QryAccountSvcSrvPortType.class);
		BindingProvider bp = (BindingProvider) portType;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, wsdlArr);
		SysMsgHeader paramQryAccountReqHeader = new SysMsgHeader();
		SrvReqBody paramQryAccountReqBody = new SrvReqBody();
		Holder<SysMsgHeader> paramQryAccountResHeader = new Holder<>();
		Holder<SrvResBody> paramQryAccountResBody = new Holder<>();
		getReqHeader(paramQryAccountReqHeader);
		getReqBody(paramQryAccountReqBody, acctNo, paramQryAccountReqHeader);
		portType.qryAccount(paramQryAccountReqHeader, paramQryAccountReqBody, paramQryAccountResHeader,
				paramQryAccountResBody);
		System.out.println("帐户查询报文头：" + paramQryAccountResHeader.value);
		System.out.println("帐户查询报文体：" + paramQryAccountResBody.value);
		if("000000".equals(paramQryAccountResHeader.value.getBizResCd().trim())) {
			getValue(paramQryAccountResBody.value, list);
		}
		
		// 新增交易日志
		LOG.info("------------------------调用核心系统帐户新增日志开始--------------------------------");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reqhead", paramQryAccountReqHeader);
		map.put("reqbody", paramQryAccountReqBody);
		map.put("rsphead", paramQryAccountResHeader.value);
		map.put("rspbody", paramQryAccountResBody.value);
		map.put("msg", "调用核心系统帐户");
		if (!map.isEmpty()) {
			try {
				int r = logService.addLogCore(map);
				if (r == 0) {
					LOG.info("调用核心系统帐户交易日志新增失败");
				} else {
					LOG.info("调用核心系统帐户交易日志新增成功");
				}
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		LOG.info("------------------------调用核心系统帐户新增日志结束----------------------------------");
		return list;
	}

	private void getReqHeader(SysMsgHeader header) throws NoSuchAlgorithmException {
		Random rand= SecureRandom.getInstanceStrong();
		header.setMsgId(DateUtils.getCurrentDateTimeWithMS() + (int) (rand.nextDouble() * 100));
		header.setMsgDate(DateUtils.getCurrentDateWithMS().substring(0, 10));
		header.setMsgTime(DateUtils.getCurrentDateWithMS().substring(11, 23));
		header.setServCd("P00001002360");
		header.setOperation("QryAccount");
		header.setSysCd("176");
		header.setBizId("000");
		header.setBizType("000");
		header.setOrgCd("86");
		header.setResCd("");
		header.setResText("");
		header.setBizResCd("");
		header.setBizResText("");
		header.setVer("110.100.000");
		header.setAuthId("");
		header.setAuthPara("");
		header.setAuthContext("");
		header.setPinIndex("");
		header.setPinValue("");
	}

	private void getReqBody(SrvReqBody body, String acctNo, SysMsgHeader header) {
		String time = header.getMsgTime().substring(0, 8).replace(":", "");
		String date = header.getMsgDate().replace("-", "");
		SRVReqHead reqh = new SRVReqHead();
		SrvReqBizBody reqb = new SrvReqBizBody();
		reqh.setMsgLen("00000000");
		reqh.setTransCode("720000");
		reqh.setMsgType("RQ");
		reqh.setFileSendType("0");
		reqh.setMacBuf("################################");
		reqh.setSvcName("tp720000");
		reqh.setMsgAgreement("1");
		reqb.setTransCode("720000");
		reqb.setAccNo(acctNo);
		reqb.setICCardSeq("");
		reqb.setTxnChnlNo("16");
		reqb.setTxnSerSeqNo(header.getMsgId());
		reqb.setFrntTm(time);
		reqb.setFrntDt(date);
		reqb.setClrDt("");
		reqb.setTxnInd("00010000000000000000");
		reqb.setFeeFlag("");
		reqb.setFeeCode1("");
		reqb.setFeeDesc1("");
		reqb.setFeeCcy1("");
		reqb.setFeeAmt1("");
		reqb.setFeeAcctNo1("");
		reqb.setFeePaySrc1("");
		reqb.setFeePayAcctNo1("");
		reqb.setFeePayAcctName1("");
		reqb.setFeePayTime1("");
		reqb.setFeeRalAcctNo1("");
		reqb.setFeeCode2("");
		reqb.setFeeDesc2("");
		reqb.setFeeCcy2("");
		reqb.setFeeAmt2("");
		reqb.setFeeAcctNo2("");
		reqb.setFeePaySrc2("");
		reqb.setFeePayAcctNo2("");
		reqb.setFeePayAcctName2("");
		reqb.setFeePayTime2("");
		reqb.setFeeRalAcctNo2("");
		reqb.setFeeCode3("");
		reqb.setFeeDesc3("");
		reqb.setFeeCcy3("");
		reqb.setFeeAmt3("");
		reqb.setFeeAcctNo3("");
		reqb.setFeePaySrc3("");
		reqb.setFeePayAcctNo3("");
		reqb.setFeePayAcctName3("");
		reqb.setFeePayTime3("");
		reqb.setFeeRalAcctNo3("");
		reqb.setFeeCode4("");
		reqb.setFeeDesc4("");
		reqb.setFeeCcy4("");
		reqb.setFeeAmt4("");
		reqb.setFeeAcctNo4("");
		reqb.setFeePaySrc4("");
		reqb.setFeePayAcctNo4("");
		reqb.setFeePayAcctName4("");
		reqb.setFeePayTime4("");
		reqb.setFeeRalAcctNo4("");
		reqb.setFeeCode5("");
		reqb.setFeeDesc5("");
		reqb.setFeeCcy5("");
		reqb.setFeeAmt5("");
		reqb.setFeeAcctNo5("");
		reqb.setFeePaySrc5("");
		reqb.setFeePayAcctNo5("");
		reqb.setFeePayAcctName5("");
		reqb.setFeePayTime5("");
		reqb.setFeeRalAcctNo5("");
		reqb.setVNo("");
		reqb.setTxnSysCd("9916001");
		reqb.setICARQCDT("");
		reqb.setSndTrckInf("");
		reqb.setThrdTrckInf("");
		reqb.setTermId("");
		reqb.setTxnInsNo("01001");
		reqb.setPsbkPrtNo("");
		reqb.setCcyCd("01");
		reqb.setTxnTlrNo("096555");
		reqb.setPasswd("");
		reqb.setSafeCtrlInf("");
		reqb.setCrdtTpCd("");
		reqb.setCrdtNo("");
		reqb.setMacBuf("");
		body.setBizHeader(reqh);
		body.setBizBody(reqb);
	}

	// ccyCd" width="120" data-code="CD0071"></yu-xtable-column>
	// <yu-xtable-column label="存款余额" prop="depBal" width="100"
	// align="right"></yu-xtable-column>
	// <yu-xtable-column label="可用余额" prop="avlBal" width="120"
	// align="right"></yu-xtable-column>
	// <yu-xtable-column label="证件类型" prop="crdtTpCd" width="120"
	// data-code="CD0011"></yu-xtable-column>
	// <yu-xtable-column label="证件号码" prop="crdtNo" width="120"></yu-xtable-column>
	// <yu-xtable-column label="账户状态" prop="accSt

	private List<Map<Object, String>> getValue(SrvResBody resb, List<Map<Object, String>> list) {
		SrvResBizBody resbb = null;
		if (resb != null && (resbb = resb.getBizBody()) != null) {
			Map<Object, String> map = new HashMap<>();
			String ntcInf = resbb.getNtcInf();
			String accSts = resbb.getAccSt();
			String acctSt = "";
			String[] arr = ntcInf.split("\\|");
			String[] stArr = accSts.split(" ");
			for (String string : stArr) {
				acctSt += string;
			}
			List<Map<String, String>> orgList = acrmFevtPreSaveListMapper.queryOrgNameById(resbb.getOpenBrc());
			map.put("cstNo", resbb.getCstNo());
			map.put("clrDt", resbb.getClrDt());
			if (orgList.size() > 0) {
				map.put("openBrc", orgList.get(0).get("orgName"));
			}
			map.put("accNm", resbb.getAccNm());
			map.put("ccyCd", resbb.getCcyCd());
			if (resbb.getDepBal().length() > 3) {
				map.put("depBal", resbb.getDepBal().substring(0, resbb.getDepBal().length() - 4));
			}
			if (resbb.getAvlBal().length() > 3) {
				map.put("avlBal", resbb.getAvlBal().substring(0, resbb.getAvlBal().length() - 4));
			}
			if (arr.length >= 21) {
				map.put("crdtTpCd", arr[19]);
				map.put("crdtNo", arr[20]);
			}
			if (acctSt.length() > 2) {
				map.put("accSt", acctSt.charAt(3) + "");
			}
			list.add(map);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public int export(QueryModel model, HttpServletResponse response) throws IOException {
		System.out.println("个人存款查询数据导出export  begin");
		int ret = 0;
		List<OcrmAciReportApply> resultlist = acrmFevtPreSaveListMapper
				.getParams(model.getCondition().get("bizseqno").toString());
		JSONObject array = JSONObject.fromObject(resultlist.get(0).getParams());
		Map map = new HashMap<>();
		for (Object array1 : array.keySet()) {
			Object v = array.get(array1);
			map.put(array1, v);
		}
		List<Map<String, Object>> colList = (List) map.get("colunmNamelist");// 表头参数(列)
		List<Map<String, Object>> OneTableDataList = (List) map.get("datalist");// 数据参数
		String userName = (String) map.get("userName");// 水印文字
		String userId=(String) map.get("userId");
		userName=userId+"_"+userName;
		String fileName = (String) map.get("fileName");// 表标题
		List<List<CellInfo>> datalist = new ArrayList<List<CellInfo>>();
		List<Map<String, Object>> exportDataList = new ArrayList<Map<String, Object>>();
		List<List<CellInfo>> headerTwo = new ArrayList<List<CellInfo>>();
		List<List<CellInfo>> widthTwo = new ArrayList<List<CellInfo>>();
		String cols = "";
		String colskey = "";
		String colswid = "";
		List<CellInfo> heads = new ArrayList<CellInfo>();
		List<CellInfo> widths = new ArrayList<CellInfo>();
		for (int k = 0; k < colList.size(); k++) {// 遍历表头数据
			if (k == 0) {
				cols = (String) colList.get(k).get("label");
				colskey = (String) colList.get(k).get("prop");
				colswid = (String) colList.get(k).get("width");
			} else {
				cols = cols + "," + (String) colList.get(k).get("label");
				colskey = colskey + "," + (String) colList.get(k).get("prop");
				colswid = colswid + "," + (String) colList.get(k).get("width");
			}
			heads.add(new CellInfo((String) colList.get(k).get("label")));// 字段名
			widths.add(new CellInfo((String) colList.get(k).get("width")));// 字段宽度s
		}
		// 表头list
		if (heads.size() > 0) {
			headerTwo.add(heads);
		}
		// 表头宽度
		if (widths.size() > 0) {
			widthTwo.add(widths);
		}
		System.out.println("个人存款查询数据导出export  dataList.size=" + OneTableDataList.size());
		if (OneTableDataList.size() > 10000) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('数据量过大，禁止导出！');</script>");
			response.getWriter().write("<script>window.close();window.history.go(-1);</script>");
			response.getWriter().flush();
		} else {
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
			mapTwo.put("sheetName", fileName);// sheet名
			mapTwo.put("headerLength", colList.size());// 表头长度
			mapTwo.put("header", headerTwo);// 表头
			mapTwo.put("data", datalist);// 数据
			mapTwo.put("userName", userName);// 水印文字
			mapTwo.put("widths", widthTwo);// 表列宽度
			exportDataList.add(mapTwo);
			System.out.println("个人存款查询数据导出export  data=" + exportDataList);

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(cal.getTime()) + "个人存款查询数据";
			String date1 = sdf.format(cal.getTime()) + "个人存款查询数据tmp";
			try {
				date = new String(date.getBytes("gbk"), "ISO8859-1");
				date1 = new String(date1.getBytes("gbk"), "ISO8859-1");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BufferedInputStream buf = null;
			OutputStream os = null;
			// PdfReader reader = null;
			// PdfStamper stamper = null;
			// File file = new File(date + ".pdf");
			// new PDFReport(file, userName,exportDataList);
			response.reset();
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename=\"" + date + ".pdf\"");
			try {
				// new PDFReport(file,exportDataList,userName);//生成pdf
				PDFReport.createPDF(date, exportDataList, userName, date1);
				buf = new BufferedInputStream(new FileInputStream(date));
				int j = 0;
				byte[] b = new byte[buf.available() + 1000];
				os = response.getOutputStream();// 直接下载导出
				// =============================添加水印=================//
				// this.export(file,response,userName);
				// int interval = -5;
				// reader = new PdfReader(file.getPath(), "PDF".getBytes());
				// stamper = new PdfStamper(reader, os);
				// BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
				// BaseFont.EMBEDDED);
				// Rectangle pageRect = null;
				// PdfGState gs = new PdfGState();
				// gs.setFillOpacity(0.3f);
				// gs.setStrokeOpacity(0.4f);
				// int total = reader.getNumberOfPages() + 1;
				//
				// JLabel label = new JLabel();
				// FontMetrics metrics;
				// int textH = 0;
				// int textW = 0;
				// label.setText(userName);
				// metrics = label.getFontMetrics(label.getFont());
				// textH = metrics.getHeight();
				// textW = metrics.stringWidth(label.getText());
				//
				// PdfContentByte under;
				// for (int i = 1; i < total; i++) {
				// pageRect = reader.getPageSizeWithRotation(i);
				// under = stamper.getOverContent(i);
				// under.saveState();
				// under.setGState(gs);
				// under.beginText();
				// under.setFontAndSize(base, 10);
				//
				// // 水印文字成30度角倾斜
				// // 你可以随心所欲的改你自己想要的角度
				// for (int height = interval + textH; height < pageRect.getHeight(); height =
				// height + textH * 3) {
				// for (int width = interval + textW; width < pageRect.getWidth() + textW; width
				// = width + textW * 2) {
				// under.showTextAligned(Element.ALIGN_LEFT, userName, width - textW, height -
				// textH, 30);
				// }
				// }
				// // 添加水印文字
				// under.endText();
				// }

				// =======================添加水印 ========================//
				// PDFReport.waterMark(file.getPath(), os,userId, reader, stamper);
				while ((j = buf.read(b)) != -1) {
					os.write(b, 0, j);
				}
				os.flush();
				// os.close();
			} catch (Exception e) {
				ret = 1;
			} finally {
				try {
					// stamper.close();
					// reader.close();
					if (os != null) {
						os.close();
					}
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
					ret = 1;
				}finally {
					if (buf != null) {
						buf.close();
					}
				}

			}
		}
		return ret;
	}
}
