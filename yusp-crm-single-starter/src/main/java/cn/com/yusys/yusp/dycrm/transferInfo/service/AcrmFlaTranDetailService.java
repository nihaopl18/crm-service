package cn.com.yusys.yusp.dycrm.transferInfo.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.dycrm.transferInfo.domain.TransferInfoFA;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.TransferInfoLA;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.dycrm.transferInfo.repository.mapper.AcrmFlaTranDetailMapper;

import javax.servlet.http.HttpServletResponse;

@Service
public class AcrmFlaTranDetailService  extends CommonService {
	@Autowired
	private AcrmFlaTranDetailMapper acrmFlaTranDetailMapper;
	
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO 自动生成的方法存根
		return acrmFlaTranDetailMapper;
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
					list = acrmFlaTranDetailMapper.queryMonth(queryModel);
				} else {
					list = acrmFlaTranDetailMapper.queryAll(queryModel);
				}
			} catch (ParseException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}else {
			list = acrmFlaTranDetailMapper.queryAll(queryModel);
		}
		PageHelper.clearPage();
		return list;
	}

	public void export(QueryModel model, HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		// 这里URLEncoder.encode可以防止中文乱码
		String fileName = URLEncoder.encode("客户贷款借据号交易查询数据导出", "UTF-8").replaceAll("\\+", "%20");
		response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
		String templateFileName = "templates" + File.separator + "tranferinfoLA_templat.xlsx";
		ExcelWriter excelWriter = null;

		excelWriter = EasyExcel.write(response.getOutputStream())
				.withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();
		WriteSheet writeSheet = EasyExcel.writerSheet().build();

		excelWriter.fill(this.excel(model), writeSheet);

		// 关闭流
		excelWriter.finish();
	}

	private List<TransferInfoLA> excel(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<TransferInfoLA> list = null;
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
					list = acrmFlaTranDetailMapper.excelMonth(model);
				} else {
					list = acrmFlaTranDetailMapper.excelAll(model);
				}
			} catch (ParseException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}else {
			list = acrmFlaTranDetailMapper.excelAll(model);
		}
		PageHelper.clearPage();
		return list;
	}
}
