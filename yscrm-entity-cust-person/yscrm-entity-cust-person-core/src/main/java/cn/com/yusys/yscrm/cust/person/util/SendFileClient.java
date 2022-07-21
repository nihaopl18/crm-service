package cn.com.yusys.yscrm.cust.person.util;

import java.io.*;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 客户端发送请求
 * @author 15104
 *
 */
public class SendFileClient extends Thread {
	private static Log log = LogFactory.getLog(SendFileClient.class);

	/**
	 * 发送xml数据给服务端
	 * 
	 * @param ip
	 *            发送地址
	 * @param port
	 *            发送端口
	 * @param soap
	 *            发送内容
	 * @return
	 */
	public String sendData(String ip, String port, String soap) throws IOException {
		Socket socket = null;
		InputStream inputStream;
		OutputStream outputStream;
		PrintStream printStream;
		String rtnValue = "";

		try {
//			log.info("ip:" + ip + " ,port:" + port);
//			log.info(sendXML.getBytes("utf-8").length);
//			log.info("sendXML====" + sendXML + "\n");
			
			socket = new Socket(ip, Integer.parseInt(port));

			// 获得对应socket的输入/输出流
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();

			printStream = new PrintStream(outputStream);
			printStream.print(soap); // 将读取得字符串传给server

			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String rtnStr = "";
			StringBuilder rtnBuilder = new StringBuilder();
//			log.info("开始获取返回数据");
			// br.read(buf);
			// String rtnlen=String.valueOf(buf);
			// log.info(rtnlen);
			// int rtnlength=Integer.parseInt(rtnlen);
			// []rtnbuffer=new char[rtnlength];
			// .read(rtnbuffer);
			// =String.valueOf(rtnbuffer);
			while ((rtnStr = br.readLine()) != null) {// 从服务器获得字符串
//				log.info("getXML====" + rtnStr);
				rtnBuilder.append(rtnStr).append("\n");
			}
//			log.info("获取返回数据完成");
			br.close();

			// 关闭连接

			printStream.close(); // 关闭数据输出流
			inputStream.close(); // 关闭输入流
			outputStream.close(); // 关闭输出流
			socket.close(); // 关闭socket
			rtnValue = rtnBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error:" + e);
			return null;
		}finally {
			if(socket!=null){
				socket.close();
			}
		}
		return rtnValue;
	}

}
