package cn.com.yusys.yscrm.salesoppor.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.SocketException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.log.SysoCounter;

import cn.com.yusys.yscrm.salesoppor.fileTrans.RealtimeTransJobSrvSrvBindingQSService;
import cn.com.yusys.yscrm.salesoppor.fileTrans.RealtimeTransJobSrvSrvPortType;
import cn.com.yusys.yscrm.salesoppor.fileTrans.SrvReqBizBody;
import cn.com.yusys.yscrm.salesoppor.fileTrans.SrvReqBody;
import cn.com.yusys.yscrm.salesoppor.fileTrans.SrvResBody;
import cn.com.yusys.yscrm.salesoppor.fileTrans.SysMsgHeader;
import cn.com.yusys.yscrm.salesoppor.service.LogService;
@Component
public class MessageSendUtil {
	
	private static LogService logService;
	
	@Autowired
	public MessageSendUtil(LogService logService) {
		MessageSendUtil.logService=logService;
	}
	
	private static Logger logger = LoggerFactory.getLogger(MessageSendUtil.class);

	/** 本地字符编码 */
	private static String LOCAL_CHARSET = "GBK";

	// FTP协议里面，规定文件名编码为iso-8859-1
	private static String SERVER_CHARSET = "ISO-8859-1";
	
	/**
     * @方法名称: createDataFile
     * @方法描述: 生成 短信-数据文件
     * @参数与返回说明: 
     * @算法描述:
     */
	public static String createDataFile(String localFilePath, List<Map<String, String>> mesDatas) throws IOException {
		if(mesDatas == null || mesDatas.size() < 1) {
			logger.warn("param msgDatas is null or length is zero !!!");
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = sdf.format(new Date());
		String dataFileName = "ftpsmsebill" + dateString + "01001" + ".txt";
		File dataFile = new File(localFilePath +"/" + dataFileName);
		BufferedWriter output =null;
		try {
			 output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dataFile),"GBK"));
			for(Map mesData : mesDatas) {
				String info = "";
				info = mesData.get("recvNum") + "|J603||01001|"+ mesData.get("sendContent") + "\r\n";
				output.write(info);
			}
			output.close();
		} catch (IOException e) {
			logger.error("create message data file error !!!");
			dataFileName = "";
			e.printStackTrace();
		}finally {
			if(output!=null){
				output.close();
			}
		}
		return dataFileName;
	}
	
	/**
     * @方法名称: createInfoFile
     * @方法描述: 生成 短信-描述信息文件
     * @参数与返回说明: 
     * @算法描述:
     */
	public static String createInfoFile(String dataFileName, String sendDate, String RecordNum,String localFilePath) throws IOException {
		// TODO 考虑定时发送可能
		Date nowDate=new Date();
		String infoFileName = "BatSms" + sendDate + "01001" + ".txt";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String genDateTime = sdf2.format(nowDate);
		File infoFile = new File(localFilePath + "/" + infoFileName);
		BufferedWriter output1 =null;
		try {
			 output1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(infoFile),"GBK"));
			StringBuffer info = new StringBuffer();
			info.append("<FileName>" + dataFileName + "</><YeWuTypeId>B602</><YeWuName>短信提醒</>");
			info.append("<IsSendTimeCtrl>0</><BeginSendTime></><LatestSendTime></><GenDateTime>" + genDateTime + "</>");
			info.append("<PiciTag></><IsUseOneSms>0</><SmsInfo></><RecordNum>" + RecordNum + "</>");
			output1.write(info.toString());
			output1.close();
		} catch (Exception e) {
			logger.error("create message info file error !!!");
			infoFileName = "";
			e.printStackTrace();
		}finally {
			if(output1!=null){
				output1.close();
			}
		}
		return infoFileName;
	}
	
    /**
     * @方法名称: getFTPClient
     * @方法描述: 获取FTPClient对象
     * @参数与返回说明: 
     * @param ftpHost : FTP主机服务器
     * @param ftpPort : FTP端口 默认为21
     * @param ftpUserName : FTP登录用户名
     * @算法描述: 
     */
//	public static FTPClient getFTPClient(String ftpHost, int ftpPort, String ftpUserName, String ftpPassword) {
//		FTPClient ftpClient = null;
//		try {
//			ftpClient = new FTPClient();
//			ftpClient.setControlEncoding(LOCAL_CHARSET);
//			ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器
//			ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器
//			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
//				logger.error("未连接到FTP，用户名或密码错误。");
//				ftpClient.disconnect();
//			} else {
////				logger.info("FTP连接成功。");
//			}
//		} catch (SocketException e) {
//			e.printStackTrace();
//			logger.error("FTP的IP地址可能错误，请正确配置。");
//		} catch (IOException e) {
//			e.printStackTrace();
//			logger.error("FTP的端口错误,请正确配置。");
//		}
//		return ftpClient;
//	}

//	/**
//     * @方法名称: uploadFile
//     * @方法描述: 向FTP服务器上传文件
//     * @参数与返回说明: 
//     * @param ftpHost : FTP主机服务器
//     * @param ftpPort : FTP端口 默认为21
//     * @param ftpUserName : FTP登录用户名
//     * @param ftpPassword : FTP 登录密码
//     * @算法描述: 
//     */
//	public static boolean uploadFile(String ftpHost, int ftpPort, String ftpUserName, String ftpPassword,
//			String basePath, String filePath, String filename, InputStream input) {
//		boolean result = false;
//		FTPClient ftpClient = new FTPClient();
//		try {
//			ftpClient = new FTPClient();
//			ftpClient.setControlEncoding("GBK");
//			ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器
//			ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器
//			int reply = ftpClient.getReplyCode();
//			if (!FTPReply.isPositiveCompletion(reply)) {
//				ftpClient.disconnect();
//				return result;
//			}
//			logger.info("----------------------ftp登陆成功------------------------");
//			// 切换到上传目录
//			if (!ftpClient.changeWorkingDirectory(basePath + filePath)) {
//				// 如果目录不存在创建目录
//				String[] dirs = filePath.split("/");
//				String tempPath = basePath;
//				for (String dir : dirs) {
//					if (null == dir || "".equals(dir))
//						continue;
//					tempPath += "/" + dir;
//					if (!ftpClient.changeWorkingDirectory(tempPath)) {
//						if (!ftpClient.makeDirectory(tempPath)) {
//							return result;
//						} else {
//							ftpClient.changeWorkingDirectory(tempPath);
//						}
//					}
//				}
//			}
//			logger.info("--------------------切换到路径："+basePath + filePath+"----------------------");
//			// 设置上传文件的类型为二进制类型
////			if (FTPReply.isPositiveCompletion(ftpClient.sendCommand("OPTS UTF8", "ON"))) {// 开启服务器对UTF-8的支持，如果服务器支持就用UTF-8编码，否则就使用本地编码（GBK）.
////				LOCAL_CHARSET = "UTF-8";
////			}
////			ftpClient.setControlEncoding(LOCAL_CHARSET);
////			ftpClient.enterLocalPassiveMode();// 设置被动模式
////			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);// 设置传输的模式
//			// 上传文件
//			filename = new String(filename.getBytes(LOCAL_CHARSET), SERVER_CHARSET);
//			if (!ftpClient.storeFile(filename, input)) {
//				return result;
//			}
//			if (null != input) {
//				input.close();
//			}
//			result = true;
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (ftpClient.isConnected()) {
//				try {
//					// 退出登录
//					ftpClient.logout();
//					// 关闭连接
//					ftpClient.disconnect();
//				} catch (IOException ioe) {
//				}
//			}
//		}
//		return result;
//	}
	
	/**
	 * 调用文传接口
	 * @param
	 * @param fileTransWsdl
	 */
	@SuppressWarnings("static-access")
	public static String applyFileTrans(String fileTransWsdl,String dataFileName) throws NoSuchAlgorithmException {
		RealtimeTransJobSrvSrvBindingQSService rtjs=new RealtimeTransJobSrvSrvBindingQSService();
		RealtimeTransJobSrvSrvPortType rj=rtjs.getPort(RealtimeTransJobSrvSrvPortType.class);
		BindingProvider bp2=(BindingProvider) rj;
		bp2.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, fileTransWsdl);
		SysMsgHeader paramRealtimeTransJobReqHeader=new SysMsgHeader();
		SrvReqBody paramRealtimeTransJobReqBody=new SrvReqBody();
		Holder<SysMsgHeader> paramRealtimeTransJobResHeader=new Holder<SysMsgHeader>();
		Holder<SrvResBody> paramRealtimeTransJobResBody=new Holder<SrvResBody>();
		MessageSendUtil.getFileTransReqHeader(paramRealtimeTransJobReqHeader);
		MessageSendUtil.getMsgPlatformReqBody(paramRealtimeTransJobReqBody,dataFileName);
		rj.realtimeTransJob(paramRealtimeTransJobReqHeader, paramRealtimeTransJobReqBody, paramRealtimeTransJobResHeader, paramRealtimeTransJobResBody);
		System.out.println("3.*********短信平台文传接口请求报文头："+paramRealtimeTransJobReqHeader);
		System.out.println("3.*********短信平台文传接口请求报文体："+paramRealtimeTransJobReqBody);
		System.out.println("3.*********短信平台文传接口响应报文头："+paramRealtimeTransJobResHeader.value);
		logger.info("---------------调用短信平台文传接口新增日志开始：" + "------------------");
		// 添加日志表
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reqhead", paramRealtimeTransJobReqHeader);
		map.put("reqbody", paramRealtimeTransJobReqBody);
		map.put("rsphead", paramRealtimeTransJobResHeader.value);
		map.put("rspbody", paramRealtimeTransJobResBody.value);
		map.put("msg", "调用短信平台文传接口");
		try {
			int r = logService.addLogFile(map);
			logger.info("新增日志数："+r);
			if (r == 0) {
				logger.info("调用短信平台文传接口新增日志新增失败");
			} else {
				logger.info("调用短信平台文传接口新增日志新增成功");
			}
		} catch (ParseException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		logger.info("---------------调用短信平台文传接口新增日志结束：" + "------------------");
		return paramRealtimeTransJobResHeader.value.getBizResCd();
	}
	
	/**
	 * 生成发往短信平台的文传报文体
	 * @param rqb
	 * @param fileName
	 */
	public static void  getMsgPlatformReqBody (SrvReqBody reqb,String fileName) {
		SrvReqBizBody reqbb=new SrvReqBizBody();
		reqbb.setLocalAppCode("0038");
		reqbb.setLocalNodeCode("01");
		reqbb.setLocalFilePath("crmFiles/ftpFile/");
		reqbb.setLocalFileName(fileName);
		reqbb.setRemoteAppCode("0028");
		reqbb.setRemoteNodeCode("01");
		reqbb.setRemoteFilePath("");
		reqbb.setRemoteFileName(fileName);
		reqbb.setTransFlag("0");
		reqbb.setIsCompress("0");
		reqbb.setIsEncrypt("0");
		reqbb.setIsPassServer("1");
		reqb.setBizBody(reqbb);
	}
	
	
	/**
	 * 生成文传接口报文头
	 * @param reqh
	 * @param resHeader
	 */
	public static  void getFileTransReqHeader(SysMsgHeader reqh) throws NoSuchAlgorithmException {
		Random r= SecureRandom.getInstanceStrong();
		reqh.setMsgId(DateUtils.getCurrentDateTimeWithMS()+(int)(r.nextDouble()*100));
		reqh.setMsgDate(DateUtils.getCurrentDateWithMS().substring(0,10));
		reqh.setMsgTime(DateUtils.getCurrentDateWithMS().substring(11,23));
		reqh.setServCd("P00002000313");
		reqh.setOperation("RealtimeTransJob");
		reqh.setSysCd("176");
		reqh.setBizId("000");
		reqh.setBizType("000");
		reqh.setOrgCd("86");
		reqh.setResCd("");
		reqh.setResText("");
		reqh.setBizResCd("");
		reqh.setBizResText("");
		reqh.setVer("110.100.000");
		reqh.setAuthId("");
		reqh.setAuthPara("");
		reqh.setAuthContext("");
		reqh.setPinIndex("");
		reqh.setPinValue("");
	}
	
}
