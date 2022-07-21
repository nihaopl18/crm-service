package cn.com.yusys.yscrm.sysview.service.activity;

import cn.com.yusys.yscrm.sysview.domain.TagAnalysisQuery;
import cn.com.yusys.yscrm.sysview.domain.activity.*;
import cn.com.yusys.yscrm.sysview.repository.mapper.activity.PlatformMonitoringMapper;
import cn.com.yusys.yscrm.sysview.utils.DateUtils;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: sxm
 * @time: 2021/9/13 11:19
 */
@Service
public class PlatformMonitoringService {
	@Autowired
	private PlatformMonitoringMapper mapper;

	@Transactional(readOnly = true)
	public List<FunModuleStatsVO> funModuleStats(TagAnalysisQuery tagAnalysisQuery) {
		if (tagAnalysisQuery.getStartTime() == null) {
			tagAnalysisQuery.setStartTime(DateUtils.getLastMonthStartTime());
		}
//		PageHelper.startPage(tagAnalysisQuery.getPage(), tagAnalysisQuery.getSize());
		List<FunModuleStatsVO> list = mapper.getFunModuleInfo(tagAnalysisQuery);
//		PageHelper.clearPage();
		list.forEach(obj -> {
			if (obj.getUserCount() != null && obj.getUserCount() != 0) {
				obj.setCoverageRate((double) obj.getVisitCount() / obj.getUserCount() * 100);
			} else {
				obj.setCoverageRate(0d);
			}
		});
		// 排序
		Collections.sort(list);
		// 添加名次
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setRank(i + 1);
		}
		return list;
	}

	@Transactional(readOnly = true)
	public SystemUseInfoVO systemUseInfo() {
		SystemUseInfoVO useInfoVO = new SystemUseInfoVO();
		useInfoVO.setMAU(mapper.getCurrentMAU());
		useInfoVO.setLastMAU(mapper.getLastMAU());
		Integer usersCount = mapper.getUsersCount();
		useInfoVO.setProportion(String.valueOf((double) useInfoVO.getMAU() / usersCount * 100));
		useInfoVO.setLastProportion(String.valueOf((double) useInfoVO.getLastMAU() / usersCount * 100));
		useInfoVO.setLogins(mapper.getLogins());
		useInfoVO.setLastLogins(mapper.getLastLogins());
		return useInfoVO;
	}

	public Map<String, Object> excelSystemUseInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		SystemUseInfoVO useInfoVO = systemUseInfo();
		if (useInfoVO.getLastMAU() != 0) {
			useInfoVO.setMAUCompare((int) Math.round((double) (useInfoVO.getMAU() - useInfoVO.getLastMAU()) / useInfoVO.getLastMAU() * 100));
		} else {
			useInfoVO.setMAUCompare(useInfoVO.getMAU() == 0 ? 0 : 100);
		}
		if (useInfoVO.getLastLogins() != 0) {
			useInfoVO.setLoginsCompare((int) Math.round((double) (useInfoVO.getLogins() - useInfoVO.getLastLogins()) / useInfoVO.getLastLogins() * 100));
		} else {
			useInfoVO.setLoginsCompare(useInfoVO.getLogins() == 0 ? 0 : 100);
		}
		if (useInfoVO.getLastProportion() != null && Double.parseDouble(useInfoVO.getLastProportion()) != 0.0) {
			useInfoVO.setProportionCompare((int) Math.round(
					(Double.parseDouble(useInfoVO.getProportion()) - Double.parseDouble(useInfoVO.getLastProportion()))
							/ Double.parseDouble(useInfoVO.getLastProportion()) * 100));
		} else {
			useInfoVO.setProportionCompare(useInfoVO.getProportion() == null ? 0 : 100);
		}
		map.put("proportion", useInfoVO.getProportion());
		map.put("lastProportion", useInfoVO.getLastProportion());
		map.put("proportionCompare", useInfoVO.getProportionCompare());
		map.put("MAU", useInfoVO.getMAU());
		map.put("lastMAU", useInfoVO.getLastMAU());
		map.put("MAUCompare", useInfoVO.getMAUCompare());
		map.put("logins", useInfoVO.getLogins());
		map.put("lastLogins", useInfoVO.getLastLogins());
		map.put("loginsCompare", useInfoVO.getLoginsCompare());
		return map;
	}

	@Transactional(readOnly = true)
	public List<LineChart> getMAUFlct() {
		return mapper.getMAUFlct();
	}

	@Transactional(readOnly = true)
	public Map<String,List<OrgMAUProportion>> orgMAUProportion() {
		List<OrgMAUProportion> list = mapper.getOrgMAUProportion();
		Map<String, List<OrgMAUProportion>> resultMap = list.stream()
				.collect(Collectors.groupingBy(OrgMAUProportion::getProvince));
		List<OrgMAUProportion> listP = new ArrayList<>();
		for (Map.Entry<String, List<OrgMAUProportion>> m : resultMap.entrySet()) {
			OrgMAUProportion orgMAUProportion = new OrgMAUProportion();
			orgMAUProportion.setProvince(m.getKey());
			List<OrgMAUProportion> list1 = m.getValue();
			Integer count = 0;
			Integer userCount = 0;
			for (OrgMAUProportion op: list1) {
				count += op.getCount();
				userCount += op.getUserCount();
			}
			orgMAUProportion.setCount(count);
			orgMAUProportion.setUserCount(userCount);
			if (orgMAUProportion.getUserCount() != 0){
				double proportion = (double) orgMAUProportion.getCount() / orgMAUProportion.getUserCount() * 100;
				orgMAUProportion.setProportion(proportion);
			}
			listP.add(orgMAUProportion);
		}
		// 计算占比
		list.forEach(obj -> {
			if (obj.getUserCount() != 0) {
				double proportion = (double) obj.getCount() / obj.getUserCount() * 100;
				obj.setProportion(proportion);
			}
		});
		// 排序
		Collections.sort(list);
		// 添加名次
		int len = list.size() > 5 ? 5 : list.size();
		for (int i = 0; i < len; i++) {
			list.get(i).setRank(i + 1);
		}
		Map<String,List<OrgMAUProportion>> map = new HashMap<>();
		map.put("sort",list.subList(0,5));
		map.put("map",listP);
		return map;
	}

	public void export(HttpServletResponse response, TagAnalysisQuery tagAnalysisQuery) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		// 这里URLEncoder.encode可以防止中文乱码
		String fileName = URLEncoder.encode("平台运营监测", "UTF-8").replaceAll("\\+", "%20");
		response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", DateUtils.getCurrentDate());
		String templateFileName = "templates" + File.separator + "platformmonitoring_templat.xlsx";
		ExcelWriter excelWriter = null;
		excelWriter = EasyExcel.write(response.getOutputStream())
				.withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();
		WriteSheet writeSheet = EasyExcel.writerSheet().build();
		FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
		// 填充集合 data
		List<OrgMAUProportion> list = mapper.getOrgMAUProportion();
		list.forEach(obj -> {
			if (obj.getUserCount() != 0) {
				double proportion = (double) obj.getCount() / obj.getUserCount() * 100;
				obj.setProportion(proportion);
			}
		});
		// 排序
		Collections.sort(list);
		// 添加名次
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setRank(i + 1);
		}
		excelWriter.fill(new FillWrapper("a", list), fillConfig, writeSheet);
		excelWriter.fill(new FillWrapper("b", mapper.getMAUFlct()), fillConfig, writeSheet);
		if (tagAnalysisQuery.getStartTime() == null) {
			tagAnalysisQuery.setStartTime(DateUtils.getLastMonthStartTime());
		}
		tagAnalysisQuery.setSize(50000);
		map.put("timeBucket", tagAnalysisQuery.getStartTime() + "-" + tagAnalysisQuery.getEndTime() == null ? "-"
				: tagAnalysisQuery.getEndTime());
		excelWriter.fill(new FillWrapper("c", funModuleStats(tagAnalysisQuery)), fillConfig, writeSheet);
		excelWriter.fill(map, writeSheet);
		excelWriter.fill(excelSystemUseInfo(), writeSheet);
		// 关闭流
		excelWriter.finish();
	}

    public void exportNoLoginUser(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		// 这里URLEncoder.encode可以防止中文乱码
		String fileName = URLEncoder.encode("未登录用户信息", "UTF-8").replaceAll("\\+", "%20");
		response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", DateUtils.getCurrentDate());
		String templateFileName = "templates" + File.separator + "nologinuser_templat.xlsx";
		ExcelWriter excelWriter = null;
		excelWriter = EasyExcel.write(response.getOutputStream())
				.withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();
		WriteSheet writeSheet = EasyExcel.writerSheet().build();
		// 填充集合 data
		List<UserInfo> list = mapper.exportNoLoginUser();
		excelWriter.fill(list, writeSheet);
		// 关闭流
		excelWriter.finish();
    }
}
