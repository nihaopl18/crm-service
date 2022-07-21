package cn.com.yusys.yscrm.salesoppor.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.salesoppor.fileTrans.RealtimeTransJobSrvSrvBindingQSService;
import cn.com.yusys.yscrm.salesoppor.fileTrans.RealtimeTransJobSrvSrvPortType;
import cn.com.yusys.yscrm.salesoppor.repository.mapper.MessageMapper;
import cn.com.yusys.yscrm.salesoppor.sendRequest.CRMAcctDtQrySvcSrvBindingQSService;
import cn.com.yusys.yscrm.salesoppor.sendRequest.CRMAcctDtQrySvcSrvPortType;
import cn.com.yusys.yscrm.salesoppor.sendRequest.SRVReqHead;
import cn.com.yusys.yscrm.salesoppor.sendRequest.SrvReqBizBody;
import cn.com.yusys.yscrm.salesoppor.sendRequest.SrvReqBody;
import cn.com.yusys.yscrm.salesoppor.sendRequest.SrvResBody;
import cn.com.yusys.yscrm.salesoppor.sendRequest.SysMsgHeader;
import cn.com.yusys.yscrm.salesoppor.service.LogService;
import cn.com.yusys.yscrm.salesoppor.utils.DateUtils;
import cn.com.yusys.yscrm.salesoppor.utils.JdbcUtils;
import cn.com.yusys.yscrm.salesoppor.utils.MessageSendUtil;

@Service
public class ClientMain implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	JdbcUtils jdbcUtils;

	@Autowired
	Environment env;

	@Autowired
	MessageMapper mapper;

	@Autowired
	LogService logService;

	@Autowired
	MessageSendUtil messageSendUtil;
	private static Logger logger = LoggerFactory.getLogger(ClientMain.class);
	private static long time1;
	private static List<Map<String, String>> hisList;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		System.out.println("\n\n\n核心大额数据提取接口启动\n\n\n\n\n");
//		timeTask();
	}

	public void timeTask() {
		// Timer timer = new Timer();
		// timer.schedule(new TimerTask() {
		// @Override
		// public void run() {
		// useInterface();
		// }
		//
		// }, 10000, 300000);
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		pool.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try {
					useInterface();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}, 10000, 1200000, TimeUnit.MILLISECONDS);
	}

	/**
	 * 调用接口
	 * 
	 * @param
	 */
	@SuppressWarnings("static-access")
	public synchronized void useInterface() throws IOException, NoSuchAlgorithmException {
		String value = mapper.queryProp("69255759aafe42a3b17ec52003272016");
		if (!"1".equals(value)) {
			logger.info("大额动帐变动已关闭");
			return;
		}
		time1 = System.currentTimeMillis();
		String wsdlAdd = "http://" + env.getProperty("wsdl.address") + ":8111/services/P00002003098?wsdl";
		CRMAcctDtQrySvcSrvBindingQSService crm = new CRMAcctDtQrySvcSrvBindingQSService();
		CRMAcctDtQrySvcSrvPortType cpt = crm.getPort(CRMAcctDtQrySvcSrvPortType.class);
		BindingProvider bp = (BindingProvider) cpt;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, wsdlAdd);
		SysMsgHeader paramCRMAcctDtQryReqHeader = new SysMsgHeader();
		SrvReqBody paramCRMAcctDtQryReqBody = new SrvReqBody();
		Holder<SysMsgHeader> paramCRMAcctDtQryResHeader = new Holder<SysMsgHeader>();
		Holder<SrvResBody> paramCRMAcctDtQryResBody = new Holder<SrvResBody>();
		getReqHeader(paramCRMAcctDtQryReqHeader);
		getReqBody(paramCRMAcctDtQryReqBody, paramCRMAcctDtQryReqHeader);
		if (paramCRMAcctDtQryReqBody.getBizBody() != null) {
			paramCRMAcctDtQryReqBody.getBizBody().setTxnSerSeqNo(paramCRMAcctDtQryReqHeader.getMsgId());
		}
		cpt.crmAcctDtQry(paramCRMAcctDtQryReqHeader, paramCRMAcctDtQryReqBody, paramCRMAcctDtQryResHeader,
				paramCRMAcctDtQryResBody);
		System.out.println("1.返回核心动账查询请求报文头:*************" + paramCRMAcctDtQryReqHeader);
		System.out.println("1.返回核心动账查询请求报文体:*************" + paramCRMAcctDtQryReqBody);
		System.out.println("1.返回核心动账查询响应报文头:*************" + paramCRMAcctDtQryResHeader.value);
		System.out.println("1.返回核心动账查询响应报文体:*******" + paramCRMAcctDtQryResBody.value);
		long time2 = System.currentTimeMillis();
		// 新增日志
		logger.info("---------------调用核心动账查询接口新增日志开始：" + "------------------");
		// 添加日志表
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reqhead", paramCRMAcctDtQryReqHeader);
		map.put("reqbody", paramCRMAcctDtQryReqBody);
		map.put("rsphead", paramCRMAcctDtQryResHeader.value);
		map.put("rspbody", paramCRMAcctDtQryResBody.value);
		map.put("msg", "调用核心动账查询接口新增");
		try {
			int r = logService.addLog(map);
			if (r == 0) {
				logger.info("调用核心动账查询接口新增日志新增失败");
			} else {
				logger.info("调用核心动账查询接口新增日志新增成功");
			}
		} catch (ParseException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		logger.info("---------------调用核心动账查询接口新增日志结束：" + "------------------");

		logger.info("---------------调用核心动账查询接口到接收到响应所需时间：" + (time2 - time1) + "------------------");

		// String fileTransWsdl = "http://23.1.0.129:8111/services/P00002000313?wsdl";

		String fileTransWsdl = "http://" + env.getProperty("wsdl.address") + ":8111/services/P00002000313?wsdl";

		String fileName = "";
		List<Map<String, String>> list = new ArrayList<>();
		List<Map<String, String>> msgDatas = new ArrayList<>();
		if (paramCRMAcctDtQryResBody.value.getBizBody() != null) {
			fileName = paramCRMAcctDtQryResBody.value.getBizBody().getNtcInf();
		}
		if (!"000000".equals(paramCRMAcctDtQryResHeader.value.getBizResCd())) {
			logger.error("核心的响应报文返回报错");
			return;
		} else if ("".equals(fileName)) {
			logger.error("从核心传过来的文件的文件名不存在");
			return;
		}
		RealtimeTransJobSrvSrvBindingQSService rtjs = new RealtimeTransJobSrvSrvBindingQSService();
		RealtimeTransJobSrvSrvPortType rj = rtjs.getPort(RealtimeTransJobSrvSrvPortType.class);
		BindingProvider bp2 = (BindingProvider) rj;
		bp2.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, fileTransWsdl);
		cn.com.yusys.yscrm.salesoppor.fileTrans.SysMsgHeader paramRealtimeTransJobReqHeader = new cn.com.yusys.yscrm.salesoppor.fileTrans.SysMsgHeader();
		cn.com.yusys.yscrm.salesoppor.fileTrans.SrvReqBody paramRealtimeTransJobReqBody = new cn.com.yusys.yscrm.salesoppor.fileTrans.SrvReqBody();
		Holder<cn.com.yusys.yscrm.salesoppor.fileTrans.SysMsgHeader> paramRealtimeTransJobResHeader = new Holder<cn.com.yusys.yscrm.salesoppor.fileTrans.SysMsgHeader>();
		Holder<cn.com.yusys.yscrm.salesoppor.fileTrans.SrvResBody> paramRealtimeTransJobResBody = new Holder<cn.com.yusys.yscrm.salesoppor.fileTrans.SrvResBody>();
		MessageSendUtil.getFileTransReqHeader(paramRealtimeTransJobReqHeader);
		getFileTransReqBody(paramRealtimeTransJobReqBody, fileName);
		rj.realtimeTransJob(paramRealtimeTransJobReqHeader, paramRealtimeTransJobReqBody,
				paramRealtimeTransJobResHeader, paramRealtimeTransJobResBody);
		long time3 = System.currentTimeMillis();
		logger.info("---------------调用核心文传接口新增日志开始：" + "------------------");
		// 添加日志表
		Map<String, Object> mapf = new HashMap<String, Object>();
		mapf.put("reqhead", paramRealtimeTransJobReqHeader);
		mapf.put("reqbody", paramRealtimeTransJobReqBody);
		mapf.put("rsphead", paramRealtimeTransJobResHeader.value);
		mapf.put("rspbody", paramRealtimeTransJobResBody.value);
		mapf.put("msg", "调用核心文传接口新增");
		try {
			int r = logService.addLogFile(mapf);
			if (r == 0) {
				logger.info("调用核心文传接口新增日志新增失败");
			} else {
				logger.info("调用核心文传接口新增日志新增成功");
			}
		} catch (ParseException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		logger.info("---------------调用核心文传接口新增日志结束：" + "------------------");
		logger.info("---------------调用文传接口到返回时间：" + (time3 - time2) + "----------------------");
		System.out.println("2.接收核心文件传输请求报文头：***********" + paramRealtimeTransJobReqHeader);
		System.out.println("2.接收核心文件传输请求报文头：***********" + paramRealtimeTransJobReqBody);
		System.out.println("2.接收核心文件传输响应报文头：***********" + paramRealtimeTransJobResHeader.value);
		System.out.println("2.接收核心文件传输响应报文体：***********" + paramRealtimeTransJobResBody.value);
		String fileAdd = "/home/crm/crmFiles/recvPath/" + fileName;
		if (paramRealtimeTransJobResHeader.value != null) {
			cn.com.yusys.yscrm.salesoppor.fileTrans.SysMsgHeader msgHeader = paramRealtimeTransJobResHeader.value;
			if (msgHeader.getBizResCd().trim().equals("000000")) {
				list = readFile(fileAdd, fileName);
				logger.info("从核心的文件中读取到的内容：" + list);
				if (list != null && list.size() != 0) {
					msgDatas = getMsgContent(list);
					logger.info("短信内容及接收人为：" + msgDatas);
					long time4 = System.currentTimeMillis();
					logger.info(
							"===============从文传返回的文件读取到生成短信发送内容所需时间：" + (time4 - time3) + "=======================");
					if (msgDatas != null && msgDatas.size() != 0) {
						// 1.生成短信传输数据文件
						String localPath = "/home/crm/crmFiles/ftpFile";
						String dataFileName = MessageSendUtil.createDataFile(localPath, msgDatas);
						if ("".equals(dataFileName)) { // 数据文件名为空，抛出 生成短信数据文件 异常
							return;
						}
						logger.info("短信传输文件名为：" + dataFileName);
						// 2、文传传输短信数据文件
						String mesCode = MessageSendUtil.applyFileTrans(fileTransWsdl, dataFileName);
						long time5 = System.currentTimeMillis();
						logger.info("=================短信数据信息从本地传到短信平台所需时间：" + (time5 - time4)
								+ "===========================");
						// 3、生成短信描述信息文件
						String sendDate = dataFileName.substring(11, 25);
						String infoFileName = MessageSendUtil.createInfoFile(dataFileName, sendDate,
								msgDatas.size() + "", localPath);
						if ("".equals(infoFileName)) { // 描述信息文件名为空，抛出 生成描述信息文件 异常
							return;
						}
						logger.info("短信描述信息文件名为：" + infoFileName);
						// 4、文传传输短信描述信息文件
						String desMesCode = MessageSendUtil.applyFileTrans(fileTransWsdl, infoFileName);
						long time6 = System.currentTimeMillis();
						logger.info("=================短信描述信息从本地传到短信平台所需时间：" + (time6 - time5)
								+ "===========================");
						if (!("000000".equals(mesCode.trim()) && "000000".equals(desMesCode.trim()))) {
							logger.error("短信平台的响应报文返回报错");
							return;
						}
						// 5.发送成功，生成短信记录
						String hisSql = "insert into ACRM_F_WP_REMIND_HISTORY(MESSAGE_RECE_ID,MESSAGE_INFO,SEND_TIME,MESSAGE_SEND_ID,MESSAGE_RECE_NUM,MESSAGE_NAME,TYPE_NAME,TYPE_ID) VALUES (?,?,?,?,?,?,?,?)";
						String msgType = "大额变动查询";
						logger.info("短信历史记录表sql为：" + hisSql);
						logger.info("短信历史记录表内容为：" + hisList);
						int hisNum = jdbcUtils.createHis(hisSql, hisList, dataFileName, msgType, "R200");
						logger.info("============短信记录表中新增短信记录：" + hisNum);
					} else {
						logger.info("大额变动客户信息未在数据库查询到");
					}
				} else {
					logger.info("从核心传来的文件内容有误");
				}
				// String sendContent=querySendCont();
				// query
			} else {
				logger.error("响应失败", msgHeader.getBizResText());
			}
		}
	}

	/**
	 * 生成核心接口报文头
	 * 
	 * @param header
	 */
	public void getReqHeader(SysMsgHeader header) throws NoSuchAlgorithmException {
		Random r= SecureRandom.getInstanceStrong();
		header.setMsgId(DateUtils.getCurrentDateTimeWithMS() + (int) (r.nextDouble() * 100));
		header.setMsgDate(DateUtils.getCurrentDateWithMS().substring(0, 10));
		header.setMsgTime(DateUtils.getCurrentDateWithMS().substring(11, 23));
		header.setServCd("P00002003098");
		header.setOperation("CRMAcctDtQry");
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

	/**
	 * 生成核心接口报文体
	 * 
	 * @param body
	 */
	public void getReqBody(SrvReqBody body, SysMsgHeader header) {
		String reqTime = header.getMsgTime().substring(0, 8).replace(":", "");
		String reqDate = header.getMsgDate().replace("-", "");
		SRVReqHead reqh = new SRVReqHead();
		SrvReqBizBody reqb = new SrvReqBizBody();
		reqh.setMsgLen("00000000");
		reqh.setTransCode("276484");
		reqh.setMsgType("RQ");
		reqh.setFileSendType("0");
		reqh.setMacBuf("################################");
		reqh.setSvcName("tp276484");
		reqh.setMsgAgreement("1");
		reqb.setEpsTranCode("276484");
		reqb.setTxnChnlNo("70");
		reqb.setTxnSerSeqNo(header.getMsgId());
		reqb.setFrntTm(reqTime);
		reqb.setFrntDt(reqDate);
		reqb.setTxnInsNo("01001");
		reqb.setTxnTlrNo("crmtel");
		body.setBizHeader(reqh);
		body.setBizBody(reqb);
	}

	/***
	 * 生成核心的文传接口报文体
	 * 
	 * @param reqb
	 * @param name
	 */
	public void getFileTransReqBody(cn.com.yusys.yscrm.salesoppor.fileTrans.SrvReqBody reqb, String name) {
		cn.com.yusys.yscrm.salesoppor.fileTrans.SrvReqBizBody reqbb = new cn.com.yusys.yscrm.salesoppor.fileTrans.SrvReqBizBody();
		reqbb.setLocalAppCode("0038");
		reqbb.setLocalNodeCode("01");
		reqbb.setLocalFilePath("crmFiles/recvPath/");
		reqbb.setLocalFileName(name);
		reqbb.setRemoteAppCode("0010");
		reqbb.setRemoteNodeCode("01");
		reqbb.setRemoteFilePath("fil/");
		reqbb.setRemoteFileName(name);
		reqbb.setTransFlag("1");
		reqbb.setIsCompress("0");
		reqbb.setIsEncrypt("0");
		reqbb.setIsPassServer("1");
		reqb.setBizBody(reqbb);
	}

	/**
	 * 读取核心文件并保存到数据库
	 * 
	 * @param filePath
	 * @return
	 */
	public List<Map<String, String>> readFile(String filePath, String fileName) {
		String url = env.getProperty("spring.datasource.url");
		String user = env.getProperty("spring.datasource.username");
		String pwd = env.getProperty("spring.datasource.password");
		InputStreamReader reader = null;
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		List<Map<String, String>> list = new ArrayList<>();
		try {
			File file = new File(filePath);
			reader = new InputStreamReader(new FileInputStream(file), "GBK");
			br = new BufferedReader(reader);
			String line;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pwd);
			String sql = "insert into ACRM_F_EVT_DATA_DRAW_PORT(DATA_DT,SEQ_NO,TRANS_TM,ACCT_NO,FUND,CURRENCY,"
					+ "TRAN_AMT,CUR_BAL,CD_IND,CUST_ID,TRAN_ORG,ACC_TYPE,REF_IND,BRIEFCODE_NO,REMARK,TRAN_SOUR,STORE_FILE)"
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			logger.info("动账提取接口表的新增sql:" + sql);
			while ((line = br.readLine()) != null) {
				if (++count > 1) {
					Map<String, String> map = new HashMap<>();
					conn.setAutoCommit(false);
					line=line+"temp";
					String[] dataOld = line.split("\\|");
					String[] data = new String[dataOld.length-1];
					System.arraycopy(dataOld, 0, data, 0, dataOld.length-1);
					String custId = data[9];
					String cdInd = data[8];
					String sum = data[6];
					String acctNo = data[3];
					String date = data[0];
					map.put("custId", custId);
					map.put("cdInd", cdInd);
					map.put("sum", sum);
					map.put("acctNo", acctNo);
					map.put("date", date);
					list.add(map);
					ps.setString(1, data[0]);
					ps.setString(2, data[1]);
					ps.setString(3, data[2]);
					ps.setString(4, data[3]);
					ps.setString(5, data[4]);
					ps.setString(6, data[5]);
					ps.setDouble(7, Double.valueOf(data[6]));
					ps.setDouble(8, Double.valueOf(data[7]));
					ps.setString(9, data[8]);
					ps.setString(10, data[9]);
					ps.setString(11, data[10]);
					ps.setString(12, data[11]);
					ps.setString(13, data[12]);
					ps.setString(14, data[13]);
					ps.setString(15, data[14]);
					ps.setString(16, data[15]);
					ps.setString(17, fileName);
					ps.addBatch();
					if (count % 1000 == 0) {
						ps.executeBatch();
					}
				}
			}
			if (ps != null) {
				ps.executeBatch();
			}
			if (conn != null && count > 1) {
				conn.commit();
			}
		} catch (Exception e) {
			if (conn != null && count > 1) {
				try {
					list = null;
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	/**
	 * 生成短信内容
	 * 
	 * @param list
	 * @return
	 */
	public List<Map<String, String>> getMsgContent(List<Map<String, String>> list) {
		// List<String> custList = new ArrayList<>();
		List<String> selectedCust = new ArrayList<>();
		List<String> fieldList = new ArrayList<>();
		hisList = new ArrayList<>();
		fieldList.add("custId");
		fieldList.add("custName");
		fieldList.add("custNum");
		fieldList.add("userNum");
		fieldList.add("mgrId");
		List<Map<String, String>> custMsgList = new ArrayList<>();
		List<Map<String, Object>> queryList = new ArrayList<>();
		for (Map<String, String> map : list) {
			String custId = map.get("custId");
			selectedCust.add(custId);
		}
		// String queryCustTypeSql = "SELECT CUST_ID,CUST_TYPE FROM ACRM_F_CI_CUST_ALL
		// where CUST_ID in (";
		// queryCustTypeSql = getSql(queryCustTypeSql, custList);
		// List<String> fieldList2 = new ArrayList<>();
		// fieldList2.add("custId");
		// fieldList2.add("custType");
		// List<Map<String, Object>> custTypeList =
		// jdbcUtils.selectMsg(queryCustTypeSql, custList, fieldList2);
		// for (Map<String, Object> map : custTypeList) {
		// String custIdValid = (String) map.get("custId");
		// for (Map<String, String> map2 : list) {
		// if (map2.get("custId") != null && !("").equals(map2.get("custId"))
		// && map2.get("custId").equals(custIdValid)) {
		// String sum = map2.get("sum");
		// double f = Double.valueOf(sum);
		// String custType = (String) map.get("custType");
		// if ("1".equals(custType)) {
		// if (f >= 500000.00) {
		// selectedCust.add(map2.get("custId"));
		// }
		// } else if ("2".equals(custType)) {
		// if (f >= 5000000.00) {
		// selectedCust.add(map2.get("custId"));
		// }
		// }
		// }
		// }
		// }
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		String nowDate = sdf.format(new Date());
		String msgContent = "";
		String sql = "SELECT A.CUST_ID, A.CUST_NAME, B.CONT_METH, C.USER_MOBILEPHONE, C.USER_ID AS MGR_ID"
				+ "  FROM (SELECT CUST_ID, CUST_NAME, BELONG_MGR FROM ACRM_F_CI_PER_ADMIT_INFO WHERE BELONG_MGR NOT LIKE 'VM%'"
				+ "      UNION ALL SELECT CUST_ID, CUST_NAME, BELONG_MGR FROM ACRM_F_CI_ORG_CUST_INFO"
				+ "      WHERE BELONG_MGR NOT LIKE 'VM%') A,(select CUST_ID, CONT_METH,"
				+ "      ROW_NUMBER() OVER(PARTITION BY CUST_ID ORDER BY LAST_CHG_DT DESC) AS RN"
				+ "     from ACRM_F_CI_CONTACT_INFO  where main_cont_flg = '1'"
				+ "      AND LENGTH(CONT_METH) = 11) B, ADMIN_SM_USER C WHERE A.CUST_ID = B.CUST_ID"
				+ "   AND A.BELONG_MGR = C.USER_ID AND B.RN = '1' AND length(C.USER_MOBILEPHONE) = 11"
				+ "   AND A.CUST_ID IN (";
		sql = getSql(sql, selectedCust);
		logger.info("根据核心内容查询信息的sql为：" + sql);
		queryList = jdbcUtils.selectMsg(sql, selectedCust, fieldList);
		for (int i = 0; i < queryList.size(); i++) {
			String custIdValid = (String) queryList.get(i).get("custId");
			for (Map<String, String> map : list) {
				if (map.get("custId") != null && !("").equals(map.get("custId"))
						&& map.get("custId").equals(custIdValid)) {
					String custType = judgeCustType(map.get("custId"));
					Map<String, String> custMsgMap = new HashMap<>();
					Map<String, String> hisMap = new HashMap<>();
					String cdInd = map.get("cdInd").equals("C") ? "转入" : "转出";
					String sum = map.get("sum");
					double f = Double.valueOf(sum);
					DecimalFormat df = new DecimalFormat("#,###.00");
					sum = df.format(f);
					String acctNo = map.get("acctNo");
					acctNo = acctNo.substring(acctNo.length() - 4);
					String date = map.get("date");
					msgContent = "您的客户" + (String) queryList.get(i).get("custName") + "存款账户（尾号" + acctNo + "）于" + date
							+ "发生了大额变动，" + cdInd + "金额" + sum + "元，客户联系电话：" + (String) queryList.get(i).get("custNum")
							+ "。";
					custMsgMap.put("recvNum", (String) queryList.get(i).get("userNum"));
					custMsgMap.put("sendContent", msgContent);
					hisMap.put("messageReceId", (String) queryList.get(i).get("mgrId"));
					hisMap.put("messageInfo", msgContent);
					hisMap.put("sendTime", nowDate);
					hisMap.put("messageSendId", "crm");
					hisMap.put("messageReceNum", (String) queryList.get(i).get("userNum"));
					if (custType.equals("1")) {
						if (f >= 500000.00) {
							custMsgList.add(custMsgMap);
							hisList.add(hisMap);
						}
					} else if (custType.equals("2")) {
						if (f >= 5000000.00) {
							custMsgList.add(custMsgMap);
							hisList.add(hisMap);
						}
					}
					// 短信历史记录表信息 insert into
					// ACRM_F_WP_REMIND_history(MESSAGE_RECE_NAME,MESSAGE_RECE_ID ,
					// SEND_TIME,MESSAGE_INFO,MESSAGE_RECE_NUM ,MESSAGE_SEND_NAME) values
				}
			}
		}
		return custMsgList;
	}

	public String getSql(String sql, List<String> list) {
		StringBuilder sb = new StringBuilder(sql);
		for (int i = 0; i < list.size(); i++) {
			sb.append(" ?");
			if (i != list.size() - 1) {
				sb.append(",");
			}
		}
		if (list.size() == 0) {
			sb.append("''");
		}
		sb.append(")");
		sql = sb.toString();
		return sql;
	}

	public String judgeCustType(String custId) {
		if (custId.startsWith("1") || custId.startsWith("9")
				|| (custId.startsWith("0") && (!"000000002".equals(custId)))) {
			return "1";
		} else if (custId.startsWith("2") || custId.startsWith("3") || "000000002".equals(custId)) {
			return "2";
		}
		return "0";
	}

	public String queryProp(String value) {
		String prop = mapper.queryProp(value);
		return prop;

	}
}
