package cn.com.yusys.yscrm.cust.person.util;

import java.io.BufferedReader;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.cust.person.repository.mapper.AcrmFevtPreSaveListMapper;
import cn.com.yusys.yscrm.cust.person.util.DateUtils;
import cn.com.yusys.yscrm.cust.person.util.SoapUtil;

@Service
public class CustMsgQuery{
	
	public StringBuilder sb=new StringBuilder();
	String ip="";
	String port="";
	Socket socket;
	
	public void queryInfo() throws Exception {
		Map<String,Object> eleMap=new HashMap<String,Object>();
		List sumList1=new ArrayList<Map<String,Object>>();
		List sumList2=new ArrayList<Map<String,Object>>();
		List sumList3=new ArrayList<Map<String,Object>>();
		String request=getRequest();
		ResolveUtils ru=new ResolveUtils();
		try {
			eleMap=ru.parse(request);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		String cstNo="";
		if(eleMap!=null&&eleMap.size()!=0) {
			cstNo=(String)eleMap.get("ns2:CstNo");
		}else {
			return;
		}
		List columnNmList=new ArrayList<String>();
		String[] arr1=new String[]{"CstNo","CstNm","CrdtTpCd","CrdtNo","AUM","ValLvl","SvcLvl","CphsCtbd","CstMgrNo","CstMgrMblPhNo"};	
		String sql="SELECT A.CUST_ID AS custNo,A.CUST_NAME AS custNm," + 
				"       A.CERT_TYPE AS CrdtTpCd," + 
				"       A.CERT_NO AS CrdNo," + 
				"       (SELECT AUM_BAL" + 
				"          FROM ACRM_A_CI_PER_BUSI_SUM_D" + 
				"         WHERE CUST_ID = A.CUST_ID" + 
				"           AND DATA_DATE = TO_CHAR(SYSDATE - 1, 'YYYYMMDD')) AS AUM," + 
				"       A.VALUE_LEV AS ValLvl," + 
				"       A.SERV_LEV AS SvcLvl," + 
				"       (SELECT REPORT_SUM\r\n" + 
				"          FROM ACRM_A_CI_PER_BUSI_SUM_M" + 
				"         WHERE CUST_ID = A.CUST_ID" + 
				"           AND DATA_DATE = TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -14)), 'YYYYMMDD')) AS CphsCtbd," + 
				"       A.BELONG_MGR AS CstMgrNo," + 
				"       (SELECT MOBILE FROM ACRM_F_CM_CUST_MGR_INFO WHERE CUST_ID = A.CUST_ID) AS CstMgrMblPhNo" + 
				"  FROM ACRM_F_CI_PER_ADMIT_INFO A" + 
				" WHERE A.CUST_ID =?";
		sumList1=selectMessage(cstNo,sql,arr1);
		String sql2="SELECT A.PRODUCT_ID AS PrdNo,"+
			       "(SELECT PROD_NAME FROM ACRM_F_PD_PROD_INFO WHERE PRODUCT_ID=A.PRODUCT_ID) AS PrdName"+
			       "FROM ACRM_F_AG_AGREEMENT A WHERE A.CUST_ID = ?";
		String[] arr2=new String[] {"PrdNo","PrdName"};
		sumList2=selectMessage(cstNo,sql2,arr2);
		String sql3="SELECT A.PROD_ID AS PrdNo, A.PROD_NAME AS PrdName" + 
				"  FROM OCRM_F_PD_CUST_FIT_PROD A" + 
				" WHERE A.CUST_ID = ?";
		String[] arr3=new String[] {"PrdNo","PrdName"};
		sumList3=selectMessage(cstNo,sql3,arr3);
		getHeader(eleMap);
		getBody(sumList1,sumList2,sumList3,eleMap);
		String response=sb.toString();
		print(response);
	}
	
	public String getRequest() {
		InputStream inputStream;
		String result="";
		try {
			socket=new Socket(ip,Integer.parseInt(port));
			inputStream = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String rtnStr = "";
			StringBuilder rtnBuilder = new StringBuilder();
			while ((rtnStr = br.readLine()) != null) {// 从服务器获得字符串
//				log.info("getXML====" + rtnStr);
				rtnBuilder.append(rtnStr).append("\n");
			}
			result=rtnBuilder.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return result;
	}

	public  List selectMessage(String custId,String sql,String[] array) throws Exception {
		String url="jdbc:oracle:thin:@23.1.1.158:1521:crmdb";
		String user="yucrm";
		String pwd="yucrm";
		Map<String,Object> map=new HashMap<String,Object>();
		List sumList=new ArrayList<Map<String,Object>>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn=DriverManager.getConnection(url,user,pwd);
			 ps=conn.prepareStatement(sql);
			ps.setString(1,custId);
			 rs=ps.executeQuery();
			while(rs.next()) {
				for(int i=0;i<array.length;i++) {
					map.put(array[i], rs.getObject(i+1));
				}
	//			System.out.println(map);
				sumList.add(map);
	//			System.out.println(sumList);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
			ps.close();
			rs.close();
		}
		return sumList;
	}
	
	public void getHeader(Map eleMap) {
		sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		sb.append("<S:Header xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		sb.append("in:sysHeader xmlns:in=\"http://www.whrcbank.com/common/header/in\"");
		sb.append(getEleText(eleMap, "in:msgId")).append(getEleText(eleMap, "in:msgDate"));
		sb.append(getEleText(eleMap, "in:msgTime")).append(getEleText(eleMap, "in:servCd"));
		sb.append(getEleText(eleMap, "in:operation")).append(getEleText(eleMap, "in:sysCd"));
		sb.append(getEleText(eleMap, "in:bizId")).append(getEleText(eleMap, "in:bizType"));
		sb.append(getEleText(eleMap, "in:orgCd")).append(getEleText(eleMap, "in:resCd"));
		sb.append(getEleText(eleMap, "in:resText")).append("<in:bizResCd>000000</in:bizResCd>");
		sb.append("<in:bizResText>成功</in:bizResText>").append(getEleText(eleMap, "in:ver"));
		sb.append(getEleText(eleMap, "in:authId")).append(getEleText(eleMap, "in:authPara"));
		sb.append(getEleText(eleMap, "in:authContext")).append(getEleText(eleMap, "in:pinIndex"));
		sb.append(getEleText(eleMap, "in:pinValue")).append(getEleText(eleMap, "in:sysHeader"));
		sb.append("</S:Header>");
		
	}
	
	public void getBody(List list1,List list2,List list3,Map eleMap) throws NoSuchAlgorithmException {
		Random rand= SecureRandom.getInstanceStrong();
		sb.append("<S:Body>").append("<ns2:response xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">").append("<ns2:bizHeader>");
		sb.append("<TransCode>"+eleMap.get("TransCode")+"</TransCode>");
		sb.append("<UserNm>"+eleMap.get("UserNm")+"</UserNm>");
		sb.append(getEleText(eleMap,"AuthPw"));
		sb.append(getEleText(eleMap, "TlrNo")).append(getEleText(eleMap, "TlrPwd")).append(getEleText(eleMap, "BrchNo"));
		sb.append(getEleText(eleMap, "FileHMac")).append(getEleText(eleMap, "FileName"));
		sb.append("<SvrDt>"+DateUtils.getCurrentDateWithMS().substring(0,10)+"</SvrDt>");
		sb.append("<SvrTm>"+DateUtils.getCurrentDateWithMS().substring(11,24)+"</SvrTm>");
		sb.append("<SvrSeqNo>"+DateUtils.getCurrentDateTimeWithMS()+(int)(rand.nextDouble()*100)+"</SvrSeqNo>");
		sb.append("<RowNum>"+list1.size()+"</RowNum>").append("</ns2:bizHeader>");
		sb.append("<ns2:bizBody>");
		for(int i=0;i<list1.size();i++) {
			Map<String,Object> map=(Map<String, Object>) list1.get(i);
			sb.append(getEleText(map, "CstNo")).append(getEleText(map, "CstNm")).append(getEleText(map, "CrdtTpCd"));
			sb.append(getEleText(map, "CrdtNo")).append(getEleText(map, "AUM")).append(getEleText(map, "ValLvl"));
			sb.append(getEleText(map, "SvcLvl")).append(getEleText(map, "CphsCtbd")).append(getEleText(map, "CstMgrNo"));
			sb.append(getEleText(map, "CstMgrMblPhNo"));
		}
		if(list2.size()!=0) {
			sb.append("<prodList>");
			for(int i=0;i<list2.size();i++) {
				Map<String,Object> map=(Map<String, Object>) list2.get(i);
				sb.append("<prod>").append(getEleText(map, "PrdNo"));
				sb.append(getEleText(map, "PrdName")).append("</prod>");
			}
			sb.append("</prodList>");
		}
		if(list3.size()!=0) {
			sb.append("<suitProdList>");
			for(int i=0;i<list2.size();i++) {
				Map<String,Object> map=(Map<String, Object>) list2.get(i);
				sb.append("<suitProd>").append(getEleText(map, "PrdNo"));
				sb.append(getEleText(map, "PrdName")).append("</suitProd>");
			}
			sb.append("</suitProdList>");
		}
		sb.append("</ns2:bizBody>").append("</ns2:response>").append("</S:Body>").append("</soapenv:Envelope>");
	}
	
	/**
	 * 用于响应报文与请求报文的标签和值相等
	 * @param map
	 * @param str
	 * @return
	 */
	public String getEleText(Map map,String str) {
		String obj= (String) map.get(str);
		String elestr="";
		if(obj!=null&&obj.length()!=0) {
			elestr="<"+str+">"+map.get(str)+"</"+str+">";
		}else {
			elestr="<"+str+"/>";
		}
		return elestr;
	}
	
	public void print(String response) {
		try {
			OutputStream os=socket.getOutputStream();
			PrintStream ps=new PrintStream(os);
			ps.print(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		CustMsgQuery c=new CustMsgQuery();
//		String sql3="SELECT A.PROD_ID AS PrdNo, A.PROD_NAME AS PrdName" + 
//				"  FROM OCRM_F_PD_CUST_FIT_PROD A" + 
//				" WHERE A.CUST_ID = ?";
//		String[] arr3=new String[] {"PrdNo","PrdName"};
//		c.selectMessage("C3", sql3, arr3);
		Map map=new HashMap();
		map.put("Test", null);
		System.out.println(c.getEleText(map, "Test"));
	}
}
