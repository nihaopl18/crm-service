
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package cn.com.yusys.yscrm.custservice.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.custservice.repository.mapper.OcrmFciCustFeedbackInfo1Mapper;
import cn.com.yusys.yscrm.custservice.service.LogServices;



/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-03-13T10:21:26.452+08:00
 * Generated source version: 3.3.0
 *
 */

@javax.jws.WebService(
                      serviceName = "CstRsInRgsSvcSrvBindingQSService",
                      portName = "CstRsInRgsSvcSrvBindingQSPort",
                      targetNamespace = "http://www.whrcbank.com",
                      endpointInterface = "cn.com.yusys.yscrm.custservice.util.CstRsInRgsSvcSrvPortType")
@Service
public class CstRsInRgsSvcSrvBindingQSPortImpl implements CstRsInRgsSvcSrvPortType {
	@Autowired
	LogServices logService;
	
	@Autowired
	OcrmFciCustFeedbackInfo1Mapper mapper;
    private static final Logger LOG = Logger.getLogger(CstRsInRgsSvcSrvBindingQSPortImpl.class.getName());

    /* (non-Javadoc)
     * @see cn.com.yusys.yscrm.custservice.util.CstRsInRgsSvcSrvPortType#cstRsInRgs(cn.com.yusys.yscrm.custservice.util.SysMsgHeader paramCstRsInRgsReqHeader, cn.com.yusys.yscrm.custservice.util.SrvReqBody paramCstRsInRgsReqBody, cn.com.yusys.yscrm.custservice.util.SysMsgHeader paramCstRsInRgsResHeader, cn.com.yusys.yscrm.custservice.util.SrvResBody paramCstRsInRgsResBody)*
     */
    @Override
	public void cstRsInRgs(SysMsgHeader paramCstRsInRgsReqHeader, SrvReqBody paramCstRsInRgsReqBody, javax.xml.ws.Holder<SysMsgHeader> paramCstRsInRgsResHeader, javax.xml.ws.Holder<SrvResBody> paramCstRsInRgsResBody) throws NoSuchAlgorithmException {
        LOG.info("Executing operation cstRsInRgs");
        LOG.info("客户反馈登记的技术报文头："+paramCstRsInRgsReqHeader);
        LOG.info("客户反馈登记技术报文体："+paramCstRsInRgsReqBody);
        String propValue=mapper.queryProp("0a19f4605f874875b8b39c9be7e04dec");
        if(!"1".equals(propValue)) {
        	LOG.info("反馈登记接口已关闭");
        	return;
        }
        paramCstRsInRgsResHeader.value=getHeader(paramCstRsInRgsReqHeader);
        SRVReqHead srqbh=paramCstRsInRgsReqBody.getBizHeader();
		SRVResHead srsbh=getBizHeader(srqbh);
		SrvReqBizBody srqbb=paramCstRsInRgsReqBody.getBizBody();
		SrvResBizBody srsbb=insertFeedback(srqbb);
		SrvResBody srsb=new SrvResBody();
		srsb.setBizHeader(srsbh);
		srsb.setBizBody(srsbb);
		paramCstRsInRgsResBody.value=srsb;
		// 添加日志表
		LOG.info("--------------------客户反馈登记添加日志开始：----------------------");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reqhead", paramCstRsInRgsReqHeader);
		map.put("reqbody", paramCstRsInRgsReqBody);
		map.put("rsphead", paramCstRsInRgsResHeader.value);
		map.put("rspbody", paramCstRsInRgsResBody.value);
		map.put("msg", "客户反馈登记交易");
		try {
			int r = logService.addLog(map);
			if (r == 0) {
				LOG.info("客户反馈登记交易日志新增失败");
			} else {
				LOG.info("客户反馈登记交易日志新增成功");
			}

		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		LOG.info("--------------------客户反馈登记添加日志结束：----------------------");
    }
    
    @WebMethod(exclude=true) 
	public SysMsgHeader getHeader(SysMsgHeader reqHeader) {
		SysMsgHeader resHeader=new SysMsgHeader();
		resHeader.setMsgId(reqHeader.getMsgId());
		resHeader.setMsgDate(reqHeader.getMsgDate());
		resHeader.setMsgTime(reqHeader.getMsgTime());
		resHeader.setServCd(reqHeader.getServCd());
		resHeader.setOperation(reqHeader.getOperation());
		resHeader.setSysCd(reqHeader.getSysCd());
		resHeader.setBizId(reqHeader.getBizId());
		resHeader.setBizType(reqHeader.getBizType());
		resHeader.setOrgCd(reqHeader.getOrgCd());
		resHeader.setBizResCd("000000");
		resHeader.setBizResText("成功");
		resHeader.setVer(reqHeader.getVer());
		resHeader.setAuthId(reqHeader.getAuthId());
		resHeader.setAuthPara(reqHeader.getAuthPara());
		resHeader.setAuthContext(reqHeader.getAuthContext());
		resHeader.setPinIndex(reqHeader.getPinIndex());
		resHeader.setPinValue(reqHeader.getPinValue());
		return resHeader;
	}
    
    @WebMethod(exclude=true) 
	public SRVResHead getBizHeader(SRVReqHead srq) throws NoSuchAlgorithmException {
		Random rand= SecureRandom.getInstanceStrong();
		SRVResHead srs=new SRVResHead();
		srs.setTransCode(srq.getTransCode());
		srs.setUserNm(srq.getUserNm());
		srs.setAuthPw(srq.getAuthPw());
		srs.setTlrNo(srq.getTlrNo());
		srs.setTlrPwd(srq.getTlrPwd());
		srs.setBrchNo(srq.getBrchNo());
		srs.setFileHMac(srq.getFileHMac());
		srs.setFileName(srq.getFileName());
		srs.setFileSendType(srq.getFileSendType());
		srs.setSvrDt(DateUtils.getCurrentDateWithMS().substring(0,10));
		srs.setSvrTm(DateUtils.getCurrentDateWithMS().substring(11,23));
		srs.setSvrSeqNo(DateUtils.getCurrentDateTimeWithMS()+(int)(rand.nextDouble()*100));
		srs.setRowNum("1");
		return srs;
	}
    
    @WebMethod(exclude=true)
    public SrvResBizBody insertFeedback(SrvReqBizBody srqbb) {
    	String cstNo=srqbb.getCstNo();
    	String tpCd=srqbb.getFreeBackTpCd();
    	String pcsInd=srqbb.getPcsInd();
    	String chnl=srqbb.getFreeBackChnl();
    	String title=srqbb.getFreeBackTitle();
    	String cont=srqbb.getFreeBackCont();
    	String cst=srqbb.getFreeBackCst();
    	SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:MM:ss");
    	String feedbackDate=sdf.format(new Date());
    	//String url="jdbc:oracle:thin:@22.1.0.61:1521:crmdb";
    	String url="jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=22.1.0.62)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=22.1.0.64)(PORT=1521))(LOAD_BALANCE=yes)(failover=yes)(failover_mode=(type=select)(method=basic))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=crmdb)))";
    	
		String user="yucrm";
		String userps="yucrm";
		String sql="insert into Ocrm_f_Ci_Cust_Feedback_Info(cust_Id,Feedback_Type,is_Processed,feedback_Chg,Feedback_Title," + 
				"Feedback_Content,Feedback_Per_Id,feedback_Id,corp_Org_Code,feedback_Date) values (?,?,?,?,?,?,?,?,?,TO_DATE(?,'YYYY/MM/DD hh24:mi:ss'))";
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url,user,userps);
			ps=conn.prepareStatement(sql);
			ps.setString(1,cstNo);
			ps.setString(2,tpCd);
			ps.setString(3,pcsInd);
			ps.setString(4,chnl);
			ps.setString(5,title);
			ps.setString(6,cont);
			ps.setString(7,cst);
			String uuid=UUID.randomUUID().toString().substring(0,32);
			ps.setString(8,uuid);
			ps.setString(9, "001");
			ps.setString(10, feedbackDate);
			int rs=ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		return new SrvResBizBody();
    }
} 
