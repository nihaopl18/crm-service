package cn.com.yusys.yscrm.salesoppor.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import cn.com.yusys.yscrm.salesoppor.domain.TxLog;
import cn.com.yusys.yscrm.salesoppor.interfaces.SrvReqBizBody;
import cn.com.yusys.yscrm.salesoppor.repository.mapper.LogMapper;
import cn.com.yusys.yscrm.salesoppor.sendRequest.SrvReqBody;
import cn.com.yusys.yscrm.salesoppor.sendRequest.SrvResBody;
import cn.com.yusys.yscrm.salesoppor.sendRequest.SysMsgHeader;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import cn.com.yusys.yusp.commons.service.CommonService;
import io.netty.util.internal.ThreadLocalRandom;

@Service
public class LogService extends CommonService {
	@Autowired
	private LogMapper mapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	 * 新增日志(调用核心动账查询接口)
	 * 
	 * @param sysqHeader请求报文头
	 * @param srvqBody请求报文体(包含报文头和报文体)
	 * @param srsbh响应报文头
	 * @param srsb响应报文体(包含报文头和报文体)
	 * @param msg报文描述
	 * @return
	 * @throws ParseException
	 */
	public  int addLog(Map<String,Object> map )
			throws ParseException {
//		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		SysMsgHeader sysqHeader = (SysMsgHeader)map.get("reqhead");
		SrvReqBody srvqBody = (SrvReqBody)map.get("reqbody");
		SysMsgHeader srsbh = (SysMsgHeader)map.get("rsphead");
		SrvResBody srsb = (SrvResBody)map.get("rspbody");
		String msg = (String)map.get("msg");
		TxLog txLog = new TxLog();
		long id = new Random().nextLong();
		txLog.setTxLogId(id);
		// 交易流水号
		if (sysqHeader.getMsgId() != null) {
			txLog.setTxFwId(sysqHeader.getMsgId());
		} else {
			txLog.setTxFwId("");
		}
		// 交易标识
		if (sysqHeader.getServCd() != null) {
			txLog.setTxId(sysqHeader.getServCd());
		} else {
			txLog.setTxId("");
		}
		// 交易代码
		if (srvqBody.getBizHeader().getTransCode() != null) {
			txLog.setTxCode(srvqBody.getBizHeader().getTransCode());
		} else {
			txLog.setTxCode("");
		}
		// 交易名称
		txLog.setTxName(msg);
		txLog.setTxCnName(msg);
		txLog.setTxMethod("web"); // 交易方式
		// 交易时间
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (sysqHeader.getMsgDate() != null) {
			txLog.setTxDt(Date.valueOf(sysqHeader.getMsgDate()));
			// txLog.setTxDt(simpleDateFormat.parse(sysqHeader.getMsgDate()));
		}
		// 交易请求时间戳
		String times = sysqHeader.getMsgDate() + " " + sysqHeader.getMsgTime();
		if (sysqHeader.getMsgTime() != null) {
			txLog.setTxReqTm(Timestamp.valueOf(times));
		}
		// 交易响应时间戳
		// String time = srsbh.getMsgDate()+" "+srsbh.getMsgTime().substring(0,8);
		String time = srsbh.getMsgDate() + " " + srsbh.getMsgTime();
		if (srsbh.getMsgTime() != null) {
			txLog.setTxResTm(Timestamp.valueOf(time));
		}
		if (srsbh.getBizResCd().startsWith("000000")) {
			txLog.setTxResult("0"); // 成功
		}else {
			txLog.setTxResult("2"); // 失败
		}

		txLog.setTxRtnCd(srsbh.getBizResCd());
		if (srsbh.getResText() != null && srsbh.getResText().length() > 255) {
			txLog.setTxRtnMsg(srsbh.getResText().substring(0, 210));
		} else {
			txLog.setTxRtnMsg(srsbh.getResText());
		}
		// txLog.setTxSvrIp(StringUtil.getLocalIp()); //交易服务ip地址==本服务ip
		try {
			txLog.setSrcSysCd(sysqHeader.getSysCd());
		} catch (Exception e) {
			txLog.setSrcSysCd("99"); // 未知源系统代码
		}
		// 请求报文
		txLog.setReqMsg(msg + "请求报文头:" + sysqHeader + msg + "请求报文体:" + srvqBody);
		// 响应报文
		txLog.setResMsg(msg + "响应报文头:" + srsbh + msg + "响应报文体:" + srsb);
		
		int i = 0;
		i=mapper.insertSelective(txLog);
		return i;
	}
	
	/**
	 * 新增日志(调用核心文传接口/短信平台)
	 * 
	 * @param sysqHeader请求报文头
	 * @param srvqBody请求报文体(包含报文头和报文体)
	 * @param srsbh响应报文头
	 * @param srsb响应报文体(包含报文头和报文体)
	 * @param msg报文描述
	 * @return
	 * @throws ParseException
	 */
	public  int addLogFile(Map<String,Object> map )
			throws ParseException {
//		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		cn.com.yusys.yscrm.salesoppor.fileTrans.SysMsgHeader sysqHeader = (cn.com.yusys.yscrm.salesoppor.fileTrans.SysMsgHeader)map.get("reqhead");
		cn.com.yusys.yscrm.salesoppor.fileTrans.SrvReqBody srvqBody = (cn.com.yusys.yscrm.salesoppor.fileTrans.SrvReqBody)map.get("reqbody");
		cn.com.yusys.yscrm.salesoppor.fileTrans.SysMsgHeader srsbh = (cn.com.yusys.yscrm.salesoppor.fileTrans.SysMsgHeader)map.get("rsphead");
		cn.com.yusys.yscrm.salesoppor.fileTrans.SrvResBody srsb = (cn.com.yusys.yscrm.salesoppor.fileTrans.SrvResBody)map.get("rspbody");
		String msg = (String)map.get("msg");
		TxLog txLog = new TxLog();
		long id = new Random().nextLong();
		txLog.setTxLogId(id);
		// 交易流水号
		if (sysqHeader.getMsgId() != null) {
			txLog.setTxFwId(sysqHeader.getMsgId());
		} else {
			txLog.setTxFwId("");
		}
		// 交易标识
		if (sysqHeader.getServCd() != null) {
			txLog.setTxId(sysqHeader.getServCd());
		} else {
			txLog.setTxId("");
		}
		// 交易名称
		txLog.setTxName(msg);
		txLog.setTxCnName(msg);
		txLog.setTxMethod("web"); // 交易方式
		// 交易时间
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (sysqHeader.getMsgDate() != null) {
			txLog.setTxDt(Date.valueOf(sysqHeader.getMsgDate()));
			// txLog.setTxDt(simpleDateFormat.parse(sysqHeader.getMsgDate()));
		}
		// 交易请求时间戳
		String times = sysqHeader.getMsgDate() + " " + sysqHeader.getMsgTime();
		if (sysqHeader.getMsgTime() != null) {
			txLog.setTxReqTm(Timestamp.valueOf(times));
		}
		// 交易响应时间戳
		// String time = srsbh.getMsgDate()+" "+srsbh.getMsgTime().substring(0,8);
		String time = srsbh.getMsgDate() + " " + srsbh.getMsgTime();
		if (srsbh.getMsgTime() != null) {
			txLog.setTxResTm(Timestamp.valueOf(time));
		}
		if (srsbh.getBizResCd().startsWith("000000")) {
			txLog.setTxResult("0"); // 成功
		} else {
			txLog.setTxResult("2"); // 失败
		}

		txLog.setTxRtnCd(srsbh.getBizResCd());
		if (srsbh.getResText() != null && srsbh.getResText().length() > 255) {
			txLog.setTxRtnMsg(srsbh.getResText().substring(0, 210));
		} else {
			txLog.setTxRtnMsg(srsbh.getResText());
		}
		// txLog.setTxSvrIp(StringUtil.getLocalIp()); //交易服务ip地址==本服务ip
		try {
			txLog.setSrcSysCd(sysqHeader.getSysCd());
		} catch (Exception e) {
			txLog.setSrcSysCd("99"); // 未知源系统代码
		}
		// 请求报文
		txLog.setReqMsg(msg + "请求报文头:" + sysqHeader + msg + "请求报文体:" + srvqBody);
		// 响应报文
		txLog.setResMsg(msg + "响应报文头:" + srsbh + msg + "响应报文体:" + srsb);
		
		int i = 0;
		i=mapper.insertSelective(txLog);
		return i;
	}



	/**
	 * 商机日志新增
	 * @param sysqHeader
	 * @param srvqBody
	 * @param srsbh
	 * @param srsbb
	 * @param msg
	 * @return
	 */
	public int inserLog(cn.com.yusys.yscrm.salesoppor.interfaces.SysMsgHeader sysqHeader,
			cn.com.yusys.yscrm.salesoppor.interfaces.SrvReqBody srvqBody,
			cn.com.yusys.yscrm.salesoppor.interfaces.SysMsgHeader srsbh,
			cn.com.yusys.yscrm.salesoppor.interfaces.SrvResBody srsbb,
			 String msg) {
		TxLog txLog = new TxLog();
		long id = new Random().nextLong();
		txLog.setTxLogId(id);
		// 交易流水号
		if (sysqHeader.getMsgId() != null) {
			txLog.setTxFwId(sysqHeader.getMsgId());
		} else {
			txLog.setTxFwId("");
		}
		// 交易标识
		if (sysqHeader.getServCd() != null) {
			txLog.setTxId(sysqHeader.getServCd());
		} else {
			txLog.setTxId("");
		}
		// 交易代码
		if (srvqBody.getBizHeader().getTransCode() != null) {
			txLog.setTxCode(srvqBody.getBizHeader().getTransCode());
		} else {
			txLog.setTxCode("");
		}
		// 交易名称
		txLog.setTxName(msg);
		txLog.setTxCnName(msg);
		txLog.setTxMethod("web"); // 交易方式
		// 交易时间
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (sysqHeader.getMsgDate() != null) {
			txLog.setTxDt(Date.valueOf(sysqHeader.getMsgDate()));
			// txLog.setTxDt(simpleDateFormat.parse(sysqHeader.getMsgDate()));
		}
		// 交易请求时间戳
		String times = sysqHeader.getMsgDate() + " " + sysqHeader.getMsgTime();
		if (sysqHeader.getMsgTime() != null) {
			txLog.setTxReqTm(Timestamp.valueOf(times));
		}
		// 交易响应时间戳
		// String time = srsbh.getMsgDate()+" "+srsbh.getMsgTime().substring(0,8);
		String time = srsbh.getMsgDate() + " " + srsbh.getMsgTime();
		if (srsbh.getMsgTime() != null) {
			txLog.setTxResTm(Timestamp.valueOf(time));
		}
		if (srsbh.getBizResCd().startsWith("000000")) {
			txLog.setTxResult("0"); // 成功
		} else  if(srsbh.getBizResCd().startsWith("0000014")){
			txLog.setTxResult("1"); // 警告
		} else {
			txLog.setTxResult("2"); // 失败
		}

		txLog.setTxRtnCd(srsbh.getBizResCd());
		if (srsbh.getBizResText() != null && srsbh.getBizResText().length() > 255) {
			txLog.setTxRtnMsg(srsbh.getBizResText().substring(0, 210));
		} else {
			txLog.setTxRtnMsg(srsbh.getBizResText());
		}
		// txLog.setTxSvrIp(StringUtil.getLocalIp()); //交易服务ip地址==本服务ip
		try {
			txLog.setSrcSysCd(sysqHeader.getSysCd());
		} catch (Exception e) {
			txLog.setSrcSysCd("99"); // 未知源系统代码
		}
		// 请求报文
		txLog.setReqMsg(msg + "请求报文头:" + sysqHeader + msg + "请求报文体:" + srvqBody);
		// 响应报文
		txLog.setResMsg(msg + "响应报文头:" + srsbh + msg + "响应报文体:" + srsbb);
		// 客户号
		if (null != (srvqBody.getBizBody().getCstNo()) && !"".equals(srvqBody.getBizBody().getCstNo())) {
			txLog.setCustNo(srvqBody.getBizBody().getCstNo());
		}
		int i = 0;
		i=mapper.insertSelective(txLog);
		return i;
    }
}
