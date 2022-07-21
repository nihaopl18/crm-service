
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package cn.com.yusys.yscrm.cust.person.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import cn.com.yusys.yscrm.cust.person.service.InterfaceService;
import cn.com.yusys.yscrm.cust.person.service.LogServicess;

/**
 * This class was generated by Apache CXF 3.3.0 2019-03-11T14:30:54.207+08:00
 * Generated source version: 3.3.0
 *
 */

@javax.jws.WebService(serviceName = "CstRelInfQrySvcSrvBindingQSService", portName = "CstRelInfQrySvcSrvBindingQSPort", targetNamespace = "http://www.whrcbank.com", endpointInterface = "cn.com.yusys.yscrm.cust.person.util.CstRelInfQrySvcSrvPortType")
@Service
public class CstRelInfQrySvcSrvBindingQSPortImpl implements CstRelInfQrySvcSrvPortType {

	private static final Logger LOG = Logger.getLogger(CstRelInfQrySvcSrvBindingQSPortImpl.class.getName());
	private List<Map<String, Object>> sumList1;
	private List<Map<String, Object>> sumList2;
	private List<Map<String, Object>> sumList3;
	@Autowired
	LogServicess logService;

	@Autowired
	InterfaceService interfaceService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.yusys.yscrm.cust.person.util.CstRelInfQrySvcSrvPortType#cstRelInfQry(
	 * cn.com.yusys.yscrm.cust.person.util.SysMsgHeader paramCstRelInfQryReqHeader,
	 * cn.com.yusys.yscrm.cust.person.util.SrvReqBody paramCstRelInfQryReqBody,
	 * cn.com.yusys.yscrm.cust.person.util.SysMsgHeader paramCstRelInfQryResHeader,
	 * cn.com.yusys.yscrm.cust.person.util.SrvResBody paramCstRelInfQryResBody)*
	 */
	@Override
	public void cstRelInfQry(SysMsgHeader paramCstRelInfQryReqHeader, SrvReqBody paramCstRelInfQryReqBody,
							 javax.xml.ws.Holder<SysMsgHeader> paramCstRelInfQryResHeader,
							 javax.xml.ws.Holder<SrvResBody> paramCstRelInfQryResBody) throws NoSuchAlgorithmException {
		// LOG.info("Executing operation cstRelInfQry");
		// System.out.println(paramCstRelInfQryReqHeader);
		// System.out.println(paramCstRelInfQryReqBody);
		System.out.println(
				"\n\n\n\n\n\n\n*******************************************************************************使用调用接口\n\n\n\n\n\n\n");
		// SysMsgHeader paramCstRelInfQryResHeaderValue = new SysMsgHeader();
		SrvResBody srsb = new SrvResBody();
		System.out.println(paramCstRelInfQryReqHeader);
		System.out.println(paramCstRelInfQryReqBody);
		System.out.println(paramCstRelInfQryResHeader);
		System.out.println(paramCstRelInfQryResBody);
		System.out.println();
		System.out.println(paramCstRelInfQryReqBody.getBizBody());
		System.out.println(paramCstRelInfQryReqBody.getBizBody().getCstNo());
		sumList1 = new ArrayList<Map<String, Object>>();
		sumList2 = new ArrayList<Map<String, Object>>();
		sumList3 = new ArrayList<Map<String, Object>>();
		String propValue=interfaceService.queryProp("801a15d2537943ca99efc2cd7c39e498");
		if(!"1".equals(propValue)) {
			LOG.info("新柜面的客户信息查询接口关闭");
			return;
		}
		// insertMessage(str);
		if (paramCstRelInfQryReqBody != null && paramCstRelInfQryReqBody.getBizBody() != null
				&& paramCstRelInfQryReqBody.getBizBody().getCstNo() != null
				&& !paramCstRelInfQryReqBody.getBizBody().getCstNo().equals("")
				) {
			String cstNo = paramCstRelInfQryReqBody.getBizBody().getCstNo();
			System.out.println(cstNo);
			sumList1 = interfaceService.queryOne(cstNo);
			sumList2 = interfaceService.queryTwo(cstNo);
			sumList3 = interfaceService.queryThree(cstNo);
			LOG.info("查询结果1" + sumList1);
			LOG.info("查询结果2" + sumList2);
			LOG.info("查询结果3" + sumList3);
			SysMsgHeader resHeader = getHeader(paramCstRelInfQryReqHeader);
			SRVReqHead srqbh = new SRVReqHead();
			srqbh = paramCstRelInfQryReqBody.getBizHeader();
			SRVResHead srsbh = getBizHeader(srqbh);
			srsb.setBizHeader(srsbh);
			SrvReqBizBody srqbb = paramCstRelInfQryReqBody.getBizBody();
			SrvResBizBody srsbb = getBizBody(sumList1, sumList2, sumList3, srqbb);
			srsb.setBizBody(srsbb);
			paramCstRelInfQryResHeader.value = resHeader;
			paramCstRelInfQryResBody.value = srsb;
			System.out.println(paramCstRelInfQryResHeader);
			System.out.println(paramCstRelInfQryResBody);
			// 新增交易日志
			LOG.info("------------------------客户信息查询新增日志开始----根据客户号查询--------------------------------");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("reqhead", paramCstRelInfQryReqHeader);
			map.put("reqbody", paramCstRelInfQryReqBody);
			map.put("rsphead", paramCstRelInfQryResHeader.value);
			map.put("rspbody", paramCstRelInfQryResBody.value);
			map.put("msg", "客户信息查询--客户号");
			if (!map.isEmpty()) {
				try {
					int r = logService.addLog(map);
					if (r == 0) {
						LOG.info("客户信息查询（客户号）交易日志新增失败");
					} else {
						LOG.info("客户信息查询（客户号）交易日志新增成功");
					}
				} catch (ParseException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			LOG.info("------------------------客户信息查询新增日志结束----根据客户号查询--------------------------------");
		} else if (paramCstRelInfQryReqBody.getBizBody().getCrdtNo() != null
				&& !paramCstRelInfQryReqBody.getBizBody().getCrdtNo().equals("")
				&& paramCstRelInfQryReqBody.getBizBody().getCrdtTpCd() != null
				&& !paramCstRelInfQryReqBody.getBizBody().getCrdtTpCd().equals("")) {
			Map<String,String> newMap=new HashMap<>();
			newMap.put("certType", paramCstRelInfQryReqBody.getBizBody().getCrdtTpCd());
			newMap.put("certNo", paramCstRelInfQryReqBody.getBizBody().getCrdtNo());
			String cstNo=interfaceService.queryCustId(newMap);
			if (cstNo!=null&&!cstNo.equals("")) {
				System.out.println(cstNo);
				sumList1 = interfaceService.queryOne(cstNo);
				sumList2 = interfaceService.queryTwo(cstNo);
				sumList3 = interfaceService.queryThree(cstNo);
				LOG.info("查询结果1" + sumList1);
				LOG.info("查询结果2" + sumList2);
				LOG.info("查询结果3" + sumList3);
				SysMsgHeader resHeader = getHeader(paramCstRelInfQryReqHeader);
				SRVReqHead srqbh = new SRVReqHead();
				srqbh = paramCstRelInfQryReqBody.getBizHeader();
				SRVResHead srsbh = getBizHeader(srqbh);
				srsb.setBizHeader(srsbh);
				SrvReqBizBody srqbb = paramCstRelInfQryReqBody.getBizBody();
				SrvResBizBody srsbb = getBizBody(sumList1, sumList2, sumList3, srqbb);
				srsb.setBizBody(srsbb);
				paramCstRelInfQryResHeader.value = resHeader;
				paramCstRelInfQryResBody.value = srsb;
				// 新增交易日志
				// 新增交易日志
				LOG.info("------------------------客户信息查询新增日志开始----根据客户账号类型和账号查询--------------------------------");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("reqhead", paramCstRelInfQryReqHeader);
				map.put("reqbody", paramCstRelInfQryReqBody);
				map.put("rsphead", paramCstRelInfQryResHeader.value);
				map.put("rspbody", paramCstRelInfQryResBody.value);
				map.put("msg", "客户信息查询--证件类型和账号");
				if (!map.isEmpty()) {
					try {
						int r = logService.addLog(map);
						if (r == 0) {
							LOG.info("客户信息查询（证件类型和证件号查询）交易日志新增失败");
						} else {
							LOG.info("客户信息查询（证件类型和证件号查询）交易日志新增成功");
						}
					} catch (ParseException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				LOG.info("------------------------客户信息查询新增日志结束----根据客户证件类型和证件号查询--------------------------------");
			} else {
				System.out.println("报文中的证件信息在crm未查询到结果");
				return;
			}
		} else {
			System.out.println("客户信息不完整");
			return;
		}
	}

	@WebMethod(exclude = true)
	public SysMsgHeader getHeader(SysMsgHeader reqHeader) {
		SysMsgHeader resHeader = new SysMsgHeader();
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

	@WebMethod(exclude = true)
	public SRVResHead getBizHeader(SRVReqHead srq) throws NoSuchAlgorithmException {
		Random r= SecureRandom.getInstanceStrong();
		SRVResHead srs = new SRVResHead();
		srs.setTransCode(srq.getTransCode());
		srs.setUserNm(srq.getUserNm());
		srs.setAuthPw(srq.getAuthPw());
		srs.setTlrNo(srq.getTlrNo());
		srs.setTlrPwd(srq.getTlrPwd());
		srs.setBrchNo(srq.getBrchNo());
		srs.setFileHMac(srq.getFileHMac());
		srs.setFileName(srq.getFileName());
		srs.setFileSendType(srq.getFileSendType());
		srs.setSvrDt(DateUtils.getCurrentDateWithMS().substring(0, 10));
		srs.setSvrTm(DateUtils.getCurrentDateWithMS().substring(11, 23));
		srs.setSvrSeqNo(DateUtils.getCurrentDateTimeWithMS() + (int) (r.nextDouble() * 100));
		srs.setRowNum("1");
		return srs;
	}

	@WebMethod(exclude = true)
	public SrvResBizBody getBizBody(List<Map<String, Object>> list1, List<Map<String, Object>> list2,
			List<Map<String, Object>> list3, SrvReqBizBody srqb) {
		SrvResBizBody srsb = new SrvResBizBody();
		srsb.setCstNo(srqb.getCstNo());
		if (list1 != null && list1.size() != 0) {
			srsb.setCstNo((String) list1.get(0).get("custNo"));
			String cstNm=list1.get(0).get("custNm") == null?"": list1.get(0).get("custNm")+"";
			srsb.setCstNm(cstNm);
			String tpCd = list1.get(0).get("crdtTpCd") == null ? "" : list1.get(0).get("crdtTpCd") + "";
			srsb.setCrdtTpCd(tpCd);
			String crdNo = list1.get(0).get("crdNo") == null ? "" : list1.get(0).get("crdNo") + "";
			srsb.setCrdtNo(crdNo);
			String aum = list1.get(0).get("aum") == null ? "" : list1.get(0).get("aum") + "";
			srsb.setAUM(aum);
			String vl = list1.get(0).get("valLvl") == null ? "" : (String) list1.get(0).get("valLvl");
			srsb.setValLvl(vl);
			String sl = list1.get(0).get("svcLvl") == null ? "" : (String) list1.get(0).get("svcLvl");
			srsb.setSvcLvl(sl);
			String cc = list1.get(0).get("cphsCtbd") == null ? "" : list1.get(0).get("cphsCtbd") + "";
			srsb.setCphsCtbd(cc);
			String cmn = list1.get(0).get("cstMgrNo") == null ? "" : (String) list1.get(0).get("cstMgrNo");
			srsb.setCstMgrNo(cmn);
			String cmmn = list1.get(0).get("cstMgrMblPhNo") == null ? "" : (String) list1.get(0).get("cstMgrMblPhNo");
			srsb.setCstMgrMblPhNo(cmmn);
		}
		ProdListType pdlt = new ProdListType();
		if (list2 != null) {
			for (int i = 0; i < list2.size(); i++) {
				ProdType pdtp = new ProdType();
				pdtp.setPrdNo((String) list2.get(i).get("prdNo"));
				pdtp.setPrdName((String) list2.get(i).get("prdName"));
				pdlt.getProd().add(pdtp);
			}
		}
		SuitProdListType spdlt = new SuitProdListType();
		if (list3 != null) {
			if (list3 != null) {
				for (int i = 0; i < list3.size(); i++) {
					SuitProdType spdtp = new SuitProdType();
					spdtp.setPrdNo((String) list3.get(i).get("prdNo"));
					spdtp.setPrdName((String) list3.get(i).get("prdName"));
					spdlt.getSuitProd().add(spdtp);
				}
			}
		}
		System.out.println("pdlt" + pdlt);
		System.out.println("spdlt" + spdlt);
		srsb.setProdList(pdlt);
		srsb.setSuitProdList(spdlt);
		return srsb;
	}
}
