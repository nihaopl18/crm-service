
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package cn.com.yusys.yscrm.salesoppor.interfaces;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.salesoppor.domain.TxLog;
import cn.com.yusys.yscrm.salesoppor.repository.mapper.MessageMapper;
import cn.com.yusys.yscrm.salesoppor.service.LogService;
import cn.com.yusys.yscrm.salesoppor.utils.DateUtils;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;


/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-03-14T11:51:29.851+08:00
 * Generated source version: 3.3.0
 *
 */

@javax.jws.WebService(
                      serviceName = "BsOpInfoRgsSvcSrvBindingQSService",
                      portName = "BsOpInfoRgsSvcSrvBindingQSPort",
                      targetNamespace = "http://www.whrcbank.com",
                      endpointInterface = "cn.com.yusys.yscrm.salesoppor.interfaces.BsOpInfoRgsSvcSrvPortType")
@Service
public class BsOpInfoRgsSvcSrvBindingQSPortImpl  implements BsOpInfoRgsSvcSrvPortType{

	@Autowired
	Environment env;
	
	@Autowired
	LogService logService;
	
	@Autowired
	MessageMapper mapper;
    private static final Logger LOG = Logger.getLogger(BsOpInfoRgsSvcSrvBindingQSPortImpl.class.getName());
    private String resCode="000000";
    private String resText="成功";
    /* (non-Javadoc)
     * @see cn.com.yusys.yscrm.salesoppor.interfaces.BsOpInfoRgsSvcSrvPortType#bsOpInfoRgs(cn.com.yusys.yscrm.salesoppor.interfaces.SysMsgHeader paramBsOpInfoRgsReqHeader, cn.com.yusys.yscrm.salesoppor.interfaces.SrvReqBody paramBsOpInfoRgsReqBody, cn.com.yusys.yscrm.salesoppor.interfaces.SysMsgHeader paramBsOpInfoRgsResHeader, cn.com.yusys.yscrm.salesoppor.interfaces.SrvResBody paramBsOpInfoRgsResBody)*
     */
    
    @Override
	public void bsOpInfoRgs(SysMsgHeader paramBsOpInfoRgsReqHeader, SrvReqBody paramBsOpInfoRgsReqBody, javax.xml.ws.Holder<SysMsgHeader> paramBsOpInfoRgsResHeader, javax.xml.ws.Holder<SrvResBody> paramBsOpInfoRgsResBody) throws NoSuchAlgorithmException {
    	LOG.info("Executing operation bsOpInfoRgs");
        LOG.info("商机信息登记的技术报文头："+paramBsOpInfoRgsReqHeader);
        LOG.info("商机信息登记技术报文体："+paramBsOpInfoRgsReqBody);
        String propValue=mapper.queryProp("4107ef684ee6452793f9d8079324af2d");
        if(!"1".equals(propValue)){
        	LOG.info("商机登记接口已关闭");
        	return;
        }
        SRVReqHead srqbh=paramBsOpInfoRgsReqBody.getBizHeader();
		SRVResHead srsbh=getBizHeader(srqbh);
        SrvReqBizBody srqbb=paramBsOpInfoRgsReqBody.getBizBody();
		SrvResBizBody srsbb=new SrvResBizBody();
		int i=insertBusiInfo(srqbb);
		if(i==0) {
			resCode="000014";
			resText="未插入任何记录警告";
		}else {
			resCode="000000";
			resText="成功";
		}
		SrvResBody srsb=new SrvResBody();
		srsb.setBizHeader(srsbh);
		srsb.setBizBody(srsbb);
		paramBsOpInfoRgsResBody.value=srsb;
        paramBsOpInfoRgsResHeader.value=getHeader(paramBsOpInfoRgsReqHeader);
        //添加日志表
        LOG.info("--------------------------商机信息登记添加日志开始：-----------------------");
        int r = logService.inserLog(paramBsOpInfoRgsReqHeader,paramBsOpInfoRgsReqBody,paramBsOpInfoRgsResHeader.value,paramBsOpInfoRgsResBody.value,"商机信息登记");
        if(r== 0) {
        	LOG.info("商机信息登记交易日志新增失败");
        }else {
        	LOG.info("商机信息登记交易日志新增成功");
        }
        LOG.info("-------------商机信息登记添加日志结束：------------------------------------");
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
		resHeader.setBizResCd(resCode);
		resHeader.setBizResText(resText);
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
		Random r= SecureRandom.getInstanceStrong();
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
		srs.setSvrSeqNo(DateUtils.getCurrentDateTimeWithMS()+(int)(r.nextDouble()*100));
		srs.setRowNum("1");
		return srs;
	}
    
    @WebMethod(exclude=true)
    public int insertBusiInfo(SrvReqBizBody srq) {
    	int num=0;
    	String cstNo=srq.getCstNo();
    	String nm=srq.getBsiPttsNm();
    	String tpCd=srq.getBsiPttsTpCd();
    	String prd=srq.getBisPttsPrd();
    	String cont=srq.getBsiPttsCont();
    	String valid=srq.getBsiPttsValid();
    	String tlr=srq.getBsiPttsTlr();
    	String busiNo=UUID.randomUUID().toString().substring(0,32);
    	String url="jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=22.1.0.62)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=22.1.0.64)(PORT=1521))(LOAD_BALANCE=yes)(failover=yes)(failover_mode=(type=select)(method=basic))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=crmdb)))";
    	//String url="jdbc:oracle:thin:@22.1.0.61:1521:crmdb";
		String user="yucrm";
		String userpssss="yucrm";
		String sql="insert into Ocrm_f_Mk_Mkt_Salesoppor(Cust_Id,BUSINESS_NAME,BUSINESS_TYPE,contact_prod_name,BUSINESS_CONTENT," + 
				"   BUSINESS_VALID_DATE,CREATE_USER,Business_No,CUST_NAME,CONTACT_PROD_ID) values (?,?,?," + 
				"   (select prod_name from Acrm_f_Pd_Prod_Info where product_id=? ),?," + 
				"   to_date(?,'yyyy-MM-dd'),?,?,(select cust_name from Acrm_f_Ci_Cust_All where cust_id=?),?)";
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url,user,userpssss);
			ps=conn.prepareStatement(sql);
			ps.setString(1,cstNo);
			ps.setString(2,nm);
			ps.setString(3,tpCd);
			ps.setString(4,prd);
			ps.setString(5,cont);
			ps.setString(6,valid);
			ps.setString(7, tlr);
			ps.setString(8, busiNo);
			ps.setString(9, cstNo);
			ps.setString(10, prd);
			num=ps.executeUpdate();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return num;
    }
    
  

}
