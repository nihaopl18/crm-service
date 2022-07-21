//package cn.com.yusys.yscrm.salesoppor.control;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.TimerTask;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Service;
//
//import cn.com.yusys.yscrm.salesoppor.repository.mapper.MessageMapper;
//import cn.com.yusys.yscrm.salesoppor.utils.JdbcUtils;
//import cn.com.yusys.yscrm.salesoppor.utils.MessageSendUtil;
//
//@Service
//public class MgrMsgClient implements mn<ContextRefreshedEvent> {
//	@Autowired
//	JdbcUtils jdbcUtils;
//
//	@Autowired
//	Environment env;
//
//	@Autowired
//	MessageMapper mapper;
//	@Autowired
//	MessageSendUtil messageSendUtil;
//
//	private static Logger logger = LoggerFactory.getLogger(MgrMsgClient.class);
//
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		System.out.println("\n\n\n短信提醒启动\n\n\n\n\n");
//		timeTask();
//	}
//
//	public void timeTask() {
//		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
//		pool.scheduleAtFixedRate(new TimerTask() {
//
//			@Override
//			public void run() {
//				System.out.println("发了一次短信核对请求");
//				useInterface();
//			}
//		}, 1000, 3600000, TimeUnit.MILLISECONDS);
//	}
//	@SuppressWarnings("static-access")
//	public synchronized void useInterface() {
//		String value = queryProp("06cd93a4e3f748fb8da329fc942197dc");
//		String setTime=queryProp("e8784f296028423c9c3a3b959dbd593d");
//		String now = (new SimpleDateFormat("yyyyMMddHH").format(new Date()));
//		String timeTask[] = setTime.split(",");
//		System.out.println(timeTask);
//		System.out.println("CrmRemindTimeTask: now=" + now);
//		logger.info("短信发送状态："+value);
//		for (int i = 0; i < timeTask.length; i++) {
//			if (now.endsWith(timeTask[i]) && "1".equals(value)) {
//				String sql = "SELECT A.*,USR.USER_MOBILEPHONE FROM (select INFO_ID,CUST_ID,REMIND_INFO,RECE_USER  from ACRM_F_WP_REMIND  where TO_CHAR(DATA_DATE,'YYYY-MM-DD')=TO_CHAR(SYSDATE-1,'YYYY-MM-DD') AND IS_SEND='1' AND HAVE_SEND='0' "
//						+ " AND RECE_USER NOT LIKE 'VM%') A "
//						+ "LEFT JOIN ADMIN_SM_USER USR ON USR.USER_ID=A.RECE_USER WHERE LENGTH(USR.USER_MOBILEPHONE)=11";
//				List<String> fieldList = new ArrayList<>();
//				fieldList.add("infoId");
//				fieldList.add("custId");
//				fieldList.add("remindInfo");
//				fieldList.add("receUser");
//				fieldList.add("mgrPhone");
//				List<Map<String, Object>> msgList = jdbcUtils.selectMsg(sql, new ArrayList(), fieldList);
//				List<Map<String, String>> msgNewList = new ArrayList<>();
//				for (Map<String, Object> map : msgList) {
//					Map<String, String> map2 = new HashMap<>();
//					map2.put("custId", (String) map.get("custId"));
//					map2.put("sendContent", (String) map.get("remindInfo"));
//					map2.put("receUser", (String) map.get("receUser"));
//					map2.put("recvNum", (String) map.get("mgrPhone"));
//					msgNewList.add(map2);
//				}
//				// 1.生成短信数据文件
//				String localPath = "/home/crm/crmFiles/ftpFile";
//				String dataFileName = messageSendUtil.createDataFile(localPath, msgNewList);
//				if ("".equals(dataFileName)) { // 数据文件名为空，抛出 生成短信数据文件 异常
//					return;
//				}
//				logger.info("短信传输文件名为：" + dataFileName);
//				// 2、文传传输短信数据文件
//				String fileTransWsdl = "http://" + env.getProperty("wsdl.address") + ":8111/services/P00002000313?wsdl";
//				String mesCode = messageSendUtil.applyFileTrans(fileTransWsdl, dataFileName);
//				// 3、生成短信描述信息文件
//				String sendDate = dataFileName.substring(11, 25);
//				String infoFileName = messageSendUtil.createInfoFile(dataFileName, sendDate, msgNewList.size() + "",
//						localPath);
//				if ("".equals(infoFileName)) { // 描述信息文件名为空，抛出 生成描述信息文件 异常
//					return;
//				}
//				logger.info("短信描述信息文件名为：" + infoFileName);
//				// 4、文传传输短信描述信息文件
//				String desMesCode = messageSendUtil.applyFileTrans(fileTransWsdl, infoFileName);
//				if (!("000000".equals(mesCode.trim()) && "000000".equals(desMesCode.trim()))) {
//					logger.error("从短信平台返回的响应报文报错");
//					return;
//				}
//				// 5.修改短信发送状态
//				String editSql = "update ACRM_F_WP_REMIND set SEND_TIME = to_date(?, 'yyyy-MM-dd hh24:mi:ss'), HAVE_SEND = '1' "
//						+ "        where INFO_ID in (";
//				StringBuilder sb = new StringBuilder(editSql);
//				for (Map<String, Object> map : msgList) {
//					sb.append("'" + (String) map.get("infoId") + "'" + ",");
//				}
//				editSql = new String(sb);
//				editSql = editSql.substring(0, editSql.length() - 1) + ")";
//				Map<String, Object> selectMap = new HashMap<>();
//				selectMap.put("sendTime", sendDate);
//				int num = jdbcUtils.updateMsg(editSql, selectMap);
//				logger.info("修改短信条数：" + num);
//				// 新增短信发送记录
//				String hisSql = "insert into ACRM_F_WP_REMIND_HISTORY(MESSAGE_RECE_ID,MESSAGE_INFO,SEND_TIME,MESSAGE_SEND_ID,MESSAGE_RECE_NUM,MESSAGE_NAME,TYPE_NAME,TYPE_ID) VALUES (?,?,to_char(to_date(?, 'yyyy-MM-dd hh24:mi:ss'),'yyyy-MM-dd hh24:mi:ss'),?,?,?,?,?)";
//				List<Map<String, String>> addList = new ArrayList<>();
//				for (Map<String, Object> map : msgList) {
//					Map<String, String> map3 = new HashMap<>();
//					map3.put("messageReceId", (String) map.get("receUser"));
//					map3.put("messageInfo", (String) map.get("remindInfo"));
//					map3.put("sendTime", sendDate);
//					map3.put("messageSendId", "crm");
//					map3.put("messageReceNum", (String) map.get("mgrPhone"));
//					addList.add(map3);
//				}
//				String type = "客户经理提醒";
//				int num2 = jdbcUtils.createHis(hisSql, addList, dataFileName, type, "R100");
//				logger.info("新增短信记录" + num2);
//			}
//
//		}
//	}
//
//	public String queryProp(String value) {
//		String prop = mapper.queryProp(value);
//		return prop;
//	}
//
//}
