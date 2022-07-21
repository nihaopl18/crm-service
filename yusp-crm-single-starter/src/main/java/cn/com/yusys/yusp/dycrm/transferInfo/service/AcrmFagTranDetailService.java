package cn.com.yusys.yusp.dycrm.transferInfo.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.TransferInfoAG;
import cn.com.yusys.yusp.dycrm.transferInfo.repository.mapper.AcrmFagTranDetailMapper;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @version 1.0.0
 * @项目名称: dycrm-transferInfo模块
 * @类名称: AcrmFCustAcctInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-09-02 16:47:01
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFagTranDetailService extends CommonService {
	@Autowired
	private AcrmFagTranDetailMapper acrmFagTranDetailMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return acrmFagTranDetailMapper;
	}

	public List<Map<String, Object>> querylist(QueryModel queryModel) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = null;
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> condition = queryModel.getCondition();
		if (condition.get("rangeDate") instanceof List) {
			List<String> rangeDate = (List<String>) condition.get("rangeDate");
			if (rangeDate != null && rangeDate.size() == 2) {
				condition.put("startDate", rangeDate.get(0).trim());
				condition.put("endDate", rangeDate.get(1).trim());
			}
			try {
				Date currentDate = s.parse(s.format(new Date()));
				Calendar c = Calendar.getInstance();
				// 前一月的日期
				c.setTime(currentDate);
				c.add(Calendar.DATE, -7);
				Date mon = c.getTime();
				Date startDate = null;
				try {
					startDate = s.parse(rangeDate.get(0).trim());
				} catch (ParseException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				if (startDate != null && mon.getTime() <= startDate.getTime()) {
					list = acrmFagTranDetailMapper.queryMonth(queryModel);
				} else {
					list = acrmFagTranDetailMapper.queryAll(queryModel);
				}
			} catch (ParseException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}else {
			list = acrmFagTranDetailMapper.queryAll(queryModel);
		}
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, Object>> queryFlist(QueryModel queryModel) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, Object> condition = queryModel.getCondition();
		if (condition.get("rangeDate") instanceof List) {
			List<String> rangeDate = (List<String>) condition.get("rangeDate");
			if (rangeDate != null && rangeDate.size() == 2) {
				condition.put("startDate", rangeDate.get(0).trim());
				condition.put("endDate", rangeDate.get(1).trim());
			}
		}
		List<Map<String, Object>> list = acrmFagTranDetailMapper.queryMonth(queryModel);
		PageHelper.clearPage();
		return list;
	}

    public void export(QueryModel model, HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		// 这里URLEncoder.encode可以防止中文乱码
		String fileName = URLEncoder.encode("客户存款账户交易查询数据导出", "UTF-8").replaceAll("\\+", "%20");
		response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
		String templateFileName = "templates" + File.separator + "tranferinfoAG_templat.xlsx";
		ExcelWriter excelWriter = null;

		excelWriter = EasyExcel.write(response.getOutputStream())
				.withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();
		WriteSheet writeSheet = EasyExcel.writerSheet().build();

		excelWriter.fill(this.excel(model), writeSheet);

		// 关闭流
		excelWriter.finish();
    }

	private List<TransferInfoAG> excel(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<TransferInfoAG> list = null;
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> condition = model.getCondition();
		if (condition.get("rangeDate") instanceof List) {
			List<String> rangeDate = (List<String>) condition.get("rangeDate");
			if (rangeDate != null && rangeDate.size() == 2) {
				condition.put("startDate", rangeDate.get(0).trim());
				condition.put("endDate", rangeDate.get(1).trim());
			}
			try {
				Date currentDate = s.parse(s.format(new Date()));
				Calendar c = Calendar.getInstance();
				// 前一月的日期
				c.setTime(currentDate);
				c.add(Calendar.DATE, -7);
				Date mon = c.getTime();
				Date startDate = null;
				try {
					startDate = s.parse(rangeDate.get(0).trim());
				} catch (ParseException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				if (startDate != null && mon.getTime() <= startDate.getTime()) {
					list = acrmFagTranDetailMapper.excelMonth(model);
				} else {
					list = acrmFagTranDetailMapper.excelAll(model);
				}
			} catch (ParseException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}else {
			list = acrmFagTranDetailMapper.excelAll(model);
		}
		PageHelper.clearPage();
		return list;
	}
}
