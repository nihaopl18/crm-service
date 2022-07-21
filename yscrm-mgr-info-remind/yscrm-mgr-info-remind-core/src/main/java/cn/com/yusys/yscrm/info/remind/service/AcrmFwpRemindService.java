package cn.com.yusys.yscrm.info.remind.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.info.remind.domain.RemindExcle;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.info.remind.domain.AcrmFwpRemind;
import cn.com.yusys.yscrm.info.remind.repository.mapper.AcrmFwpRemindMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: AcrmFwpRemindService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: lixt1
 * @创建时间: 2019-02-20 14:09:15
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFwpRemindService extends CommonService {
	@Autowired
	private AcrmFwpRemindMapper acrmFwpRemindMapper;

	@Autowired
	private UaaClient uaaClient;
			
	@Override
	protected CommonMapper<?> getMapper() {
		return acrmFwpRemindMapper;
	}

	public String getRoles() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String role = "";
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String selectRole = request.getHeader("selectRole");
		for (ObjBean obj : dto.getBody().getRoles()) {
			if (obj.getId().equals(selectRole)){
				role = obj.getCode();
			}
		}
		return role;
	}
	/**
	 * @方法名称: queryRemindList
	 * @方法描述: 异动提醒 列表查询，公共API接口 - 查询进行分页
	 * @参数与返回说明:
	 * @算法描述: 无
	 */
	public List<Map<String, Object>> queryList(QueryModel model) {
		Map<String, Object> condition = model.getCondition();
		if (condition.get("rangeDate") instanceof List) {
			List<String> rangeDate = (List<String>) condition.get("rangeDate");
			if (rangeDate != null && rangeDate.size() == 2) {
				condition.put("startDate", rangeDate.get(0).trim());
				condition.put("endDate", rangeDate.get(1).trim());
			}
		}
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = s.format(new Date());
		condition.put("currentDate",currentDate);
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = null;
		String role = getRoles();
		if ("R002,R003".contains(role)){
			list = acrmFwpRemindMapper.queryList(model);
		}else {
			list = acrmFwpRemindMapper.queryMList(model);
		}
		PageHelper.clearPage();
		return list;
	}

	public int updateStat(String infoId,String operation) {
		// TODO 自动生成的方法存根
		int result = 0;
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		AcrmFwpRemind acrmFwpRemind = new AcrmFwpRemind();
		acrmFwpRemind.setLastChgUsr(dto.getBody().getUserCode());
		acrmFwpRemind.setLastChgDt(new Date());
		acrmFwpRemind.setOperation(operation);
		try {
			acrmFwpRemind.setLastChgDt(s.parse(s.format(acrmFwpRemind.getLastChgDt())));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String[] infoIdCopy = infoId.split(",");
		for (int i = 0; i < infoIdCopy.length; i++) {
			acrmFwpRemind.setInfoId(infoIdCopy[i]);
			result += acrmFwpRemindMapper.updateStat(acrmFwpRemind);
		}
		return result;
	}

    public void export(QueryModel model, HttpServletResponse response)  throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		// 这里URLEncoder.encode可以防止中文乱码
		String fileName = URLEncoder.encode("异动提醒", "UTF-8").replaceAll("\\+", "%20");
		response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
		String templateFileName = "templates" + File.separator + "remind_templat.xlsx";
		ExcelWriter excelWriter = null;

		excelWriter = EasyExcel.write(response.getOutputStream())
				.withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();
		WriteSheet writeSheet = EasyExcel.writerSheet().build();
		List<RemindExcle> list = acrmFwpRemindMapper.export(model);
		excelWriter.fill(list, writeSheet);
		// 关闭流
		excelWriter.finish();
    }


    /**
	 * @方法名称: send
	 * @方法描述: 发送短信-单条
	 * @参数与返回说明:
	 * @算法描述: 1、 根据参数 ，生成短信数据发送文件 2、 调用ftp客户端 发送数据文件 3、 生成短信描述信息文件 4、 调用ftp客户端
	 *        发送描述信息文件
	 */
//	public int send(String infoId, String custId, String rcvNum, String sendDate, String sendContent, String sendTime,
//			String custName, String typeId, String typeName) {
//		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
//		String loginCode = dto.getBody().getLoginCode();
//		// 生成 短信发送数据
//		List<Map<String, String>> mesDatas = new ArrayList<Map<String, String>>();
//		Map<String, String> mesData = new HashMap<String, String>();
//		mesData.put("rcvNum", rcvNum);
//		mesData.put("sendContent", sendContent);
//		mesData.put("custId", custId);
//		mesData.put("custName", custName);
//		mesData.put("typeId", typeId);
//		mesData.put("typeName", typeName);
//		mesDatas.add(mesData);
//		sendTime = sendTime.substring(11, 19);
//		return this.mesSendComFn(mesDatas, infoId, sendDate, sendTime);
//	}

//	public Map<String, String> sendBatch(List<Map<?, ?>> list) {
//		Map<String, String> resultMap = new HashMap<String, String>();
//		Integer totalNum = list.size();
//		Integer successNum = 0;
//		Integer failNum = 0;
//		Integer telErrNum = 0;
//		// 生成 短信发送数据
//		List<Map<String, String>> mesDatas = new ArrayList<Map<String, String>>();
//		String infoIds = "";
//		// 遍历 list, 获取符合条件的短信发送数据
//		for (Map map : list) {
//			if (map.get("infoId") != null && map.get("custId") != null && map.get("sendContent") != null
//					&& !StringTools.isEmpty(map.get("infoId") + "") && !StringTools.isEmpty(map.get("custId") + "")
//					&& !StringTools.isEmpty(map.get("sendContent") + "")) {
//				Map custIdMap = new HashMap<>();
//				custIdMap.put("custId", map.get("custId"));
//				List<Map<String, Object>> receNumList = acrmFwpRemindMapper.queryCustNum(custIdMap);
//				String receNum = "";
//				for (Map<String, Object> map2 : receNumList) {
//					if ((map2.get("contMeth") + "").length() == 11) {
//						receNum = map2.get("contMeth") + "";
//					}
//				}
//				if (receNum != "") {
//					Map<String, String> mesData = new HashMap<String, String>();
//					mesData.put("rcvNum", receNum);
//					mesData.put("sendContent", map.get("sendContent") + "");
//					mesData.put("custId", map.get("custId") + "");
//					mesData.put("custName", map.get("custName") + "");
//					mesData.put("TypeId", map.get("TypeId") + "");
//					mesData.put("TypeName", map.get("TypeName") + "");
//					mesDatas.add(mesData);
//					infoIds += map.get("infoId") + ",";
//				} else {
//					telErrNum++;
//				}
//			} else {
//				failNum++;
//			}
//		}
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
//		if (mesDatas.size() != 0) {
//			successNum = this.mesSendComFn(mesDatas, infoIds.substring(0, infoIds.length() - 1),
//					sdf.format(new Date()).substring(0, 10), sdf.format(new Date()).substring(11, 19));
//		}
//		resultMap.put("totalNum", totalNum + "");
//		resultMap.put("successNum", successNum + "");
//		resultMap.put("failNum", failNum + "");
//		resultMap.put("telErrNum", telErrNum + "");
//		return resultMap;
//	}
//
//	@SuppressWarnings("static-access")
//	public Integer mesSendComFn(List<Map<String, String>> msgDatas, String infoIds, String sendDate, String sendTime) {
//		// 获取基础信息
//		// List<Map<String, Object>> list =
//		// ocrmFwpRemindChlMapper.queryChlByChlId(sendChl);
//		String localPath = "/home/crm/crmFiles/ftpFile";
//		long time4 = System.currentTimeMillis();
//		// 1、生成短信数据文件
//		String dataFileName = messageSendUtil.createDataFile(localPath, msgDatas);
//		if ("".equals(dataFileName)) { // 数据文件名为空，抛出 生成短信数据文件 异常
//			return 0;
//		}
//		// 2、文传传输短信数据文件
//		String fileTransWsdl = "http://"+env.getProperty("wsdl.address")+":8111/services/P00002000313?wsdl";
//		String mesCode = messageSendUtil.applyFileTrans(fileTransWsdl, dataFileName);
//		long time5 = System.currentTimeMillis();
//		logger.info("=================短信数据信息从本地读取传到短信平台所需时间：" + (time5 - time4) + "===========================");
//		// 3、生成短信描述信息文件
//		String filedate = dataFileName.substring(11, 25);
//		sendTime = sendDate + " " + sendTime;
//		String infoFileName = messageSendUtil.createInfoFile(dataFileName, filedate, msgDatas.size() + "", localPath,
//				sendTime);
//		if ("".equals(infoFileName)) { // 描述信息文件名为空，抛出 生成描述信息文件 异常
//			return 0;
//		}
//		// 4、ftp传输短信描述信息文件
//		String desMesCode = messageSendUtil.applyFileTrans(fileTransWsdl, infoFileName);
//		long time6 = System.currentTimeMillis();
//		logger.info("=================短信描述信息从本地传到短信平台所需时间：" + (time6 - time5) + "===========================");
//		// 5、 发送成功， 更新 是否已发送短信、短信发送时间 字段
//		if ("000000".equals(mesCode.trim()) && "000000".equals(desMesCode.trim())) {
//			this.updateSendStat(infoIds, sendTime);
//			this.insertHistory(msgDatas, sendTime,dataFileName);
//		} else {
//			return 0;
//		}
//		return msgDatas.size();
//	}
//
//	public void insertHistory(List<Map<String, String>> msgDatas, String sendTime,String fileName) {
//		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
//		String loginCode = dto.getBody().getLoginCode();
//		for (Map<String, String> map : msgDatas) {
//			AcrmFwpRemindHistory his = new AcrmFwpRemindHistory();
//			his.setMessageInfo(map.get("sendContent"));
//			his.setMessageSendId(loginCode);
//			his.setMessageReceId(map.get("custId"));
//			his.setMessageReceNum(map.get("rcvNum"));
//			his.setSendTime(sendTime);
//			his.setMessageReceName(map.get("custName"));
//			his.setTypeId(map.get("typeId"));
//			his.setTypeName(map.get("typeName"));
//			his.setMessageName(fileName);
//			acrmFwpRemindHistoryMapper.insertSelective(his);
//		}
//	}
//
}
