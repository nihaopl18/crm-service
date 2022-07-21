package cn.com.yusys.yusp.uimp.base.app.uaa.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tk.mybatis.mapper.util.StringUtil;

/**
 * @项目名称: yscrm-base-core模块
 * @类名称: MessageSendUtil
 * @类描述: # 发送短信 接口类
 * @功能描述: 
 *    调用短信接口 SWI_SMS_SEND 发送短信，其中SWI_SMS_SEND为数据库存储过程，参数如下：
 *      request: 
 *      	ClientID	integer	业务系统ID
 *			SysMsgID	integer	业务系统短信ID
 *			Mobile	char(1200)	手机号码
 *			Content	char(450)	短信内容
 *			SysCode	char(4)	业务类型
 *			Depart	char(4)	归口部门编号
 *      response:
 *      	ResultCode	integer	状态代码
 * @创建人: lixt1
 * @创建时间: 2019-05-13 09:49:01
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class MessageSendUtil {
	
	private static Logger logger = LoggerFactory.getLogger(MessageSendUtil.class);
	
//	private static final String CLIENT_ID = "ClientID";		// 业务系统ID
//	private static final String SYS_MSG_ID = "SysMsgID";	// 业务系统短信ID
//	private static final String MOBILE = "Mobile";			// 手机号码
//	private static final String CONTENT = "Content";		// 短信内容
//	private static final String SYS_CODE = "SysCode";		// 业务类型
//	private static final String DEPART = "Depart";			// 归口部门编号
//	private static final String RESULT_CODE = "ResultCode";	// 状态代码
	
	private static final String PROC_NAME = "SWI_SMS_SEND"; // 存储过程名

	private static final Integer clientID = 0;	// 业务系统ID  TODO 添加默认值
	private static final Integer sysMsgID = 0;	// 业务系统短信ID  TODO 添加默认值
	private static final String sysCode = "";		// 业务类型  TODO 添加默认值
	private static final String depart = "";		// 归口部门编号  TODO 添加默认值
	
	/**
	 * 
	 * @param dataSource
	 * @param mobile
	 * @param content
	 * @return  0发送成功  -1短信发送失败  -2异常
	 */
//	public static Integer sendMessage(DataSource dataSource, String mobile, String content) {
//		System.out.println(dataSource);		// TODO delete after test
//		int resultCode = 0;
//		if(dataSource == null || StringUtil.isEmpty(mobile) || StringUtil.isEmpty(content)) {
//			logger.warn("mobile or content is null, won't send message! ");
//			return -9;
//		}
//		logger.debug("prepare send message to mobile " + mobile);
//		Connection conn = null;
//		CallableStatement stmt = null;
//		try {
//			conn = dataSource.getConnection();
//			stmt = conn.prepareCall("{call " + PROC_NAME + "(?,?,?,?,?,?,?)}");
//			stmt.setInt(1, clientID);
//			stmt.setInt(2, sysMsgID);
//			stmt.setString(3, mobile);
//			stmt.setString(4, content);
//			stmt.setString(5, sysCode);
//			stmt.setString(6, depart);
//			
//			stmt.registerOutParameter(7, Types.INTEGER);
//			stmt.execute();
//			resultCode = stmt.getInt(7);
//			logger.info("after send message to mobile " + mobile + ", resultCode is " + resultCode);
//			resultCode = resultCode != 0 ? -1 : 0;
//		} catch(Exception e) {
//			resultCode = -2;
//			e.printStackTrace();
//		} finally {
//			if(stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			} 
//			if(conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return resultCode;
//	}
}
