package cn.com.yusys.yscrm.fiexdstatement.service;

import cn.com.yusys.yscrm.custmgr.domain.DateUtils;
import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClBranchtotal;
import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClBranchtotalVO;
import cn.com.yusys.yscrm.fiexdstatement.repository.mapper.OcrmFClBranchtotalMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OcrmFClBranchtotalService extends CommonService {

    @Autowired
    private OcrmFClBranchtotalMapper ocrmFClBranchtotalMapper;
    @Override
    protected CommonMapper getMapper() {
        return ocrmFClBranchtotalMapper;
    }


    private static String isPeopleCode = "1"; //是否民生 ，1：是、0：否

    public void export(HttpServletResponse response, QueryModel model) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode("分行销售团队", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
//        Map<String, String> mapMap = new HashMap<>();
//        List<OcrmFClBranchtotal> list = ocrmFClBranchtotalMapper.selectPreparation(mapMap);
//        OcrmFClBranchtotal ocrmFClBranchtotal = ocrmFClBranchtotalMapper.queryStatistics();
//        ocrmFClBranchtotal.setBranch("总计");
//        list.add(ocrmFClBranchtotal);
        String isPeople = (String)model.getCondition().get("isPeople"); //是否民生
        String dataDate=(String)model.getCondition().get("dataDate");
        List<Map<String, Object>> list = new ArrayList<>();
        if (isPeopleCode.equalsIgnoreCase(isPeople)){
            list = queryBranchList(model);
        }else {
            list = queryBranchListUnPeople(model);
        }
        //设置百分数
        setPercentage(list);
        exportFile(response, "branchtotal_template.xlsx", "分行合计(管户机构合计)", list,isPeople,dataDate);
    }

    private void exportFile(HttpServletResponse response, String fileName, String title, List list,String isPeople,String dataDate) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (isPeopleCode.equalsIgnoreCase(isPeople)){
            map.put("isPeople","是");
        }else {
            map.put("isPeople","否");
        }
        map.put("date", dataDate);
        String templateFileName = "templates" + File.separator + fileName;
        ExcelWriter excelWriter = null;
        excelWriter = EasyExcel.write(response.getOutputStream())
                .withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        // 填充集合 data
        excelWriter.fill(list, writeSheet);
        excelWriter.fill(map, writeSheet);
        // 关闭流
        excelWriter.finish();
    }

    public List<Map<String, Object>> queryBranchList(QueryModel queryModel) {
        Map<String, Object> map = new HashMap<String, Object>();
        String dataDate=(String)queryModel.getCondition().get("dataDate");
        map.put("dataDate",dataDate);
        map.put("count","500"); //总计编码
        List<Map<String, Object>> list = ocrmFClBranchtotalMapper.queryBranchTotalList(map);
        Map<String, Object> getSumBranch = ocrmFClBranchtotalMapper.getSumBrach(map);
        if (getSumBranch!=null ){
            getSumBranch.put("branch","总计");
            list.add(getSumBranch);
        }
        return list;
    }

    public List<Map<String, Object>> queryBranchListUnPeople(QueryModel queryModel) {
        Map<String, Object> map = new HashMap<String, Object>();
        String dataDate=(String)queryModel.getCondition().get("dataDate");
        map.put("dataDate",dataDate);
        map.put("count","500");
        List<Map<String, Object>> list = ocrmFClBranchtotalMapper.queryBranchTotalListUnPeople(map);
        Map<String, Object> getSumBranch = ocrmFClBranchtotalMapper.getSumBrachUnPeople(map);
        if (getSumBranch!=null ){
            getSumBranch.put("branch","总计");
            list.add(getSumBranch);
        }
        return list;
    }
    /**
     * 转换百分数
     * @param resultList
     */
    private void setPercentage(List<Map<String, Object>> resultList) {
        NumberFormat nf   =   NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits( 2 );
        for (Map<String, Object> map : resultList) {
            BigDecimal aumDepositSort = (BigDecimal)map.get("aumDepositSort")!=null ? (BigDecimal)map.get("aumDepositSort") : new BigDecimal("0");
            BigDecimal aumRateSort = (BigDecimal)map.get("aumRateSort")!=null ? (BigDecimal)map.get("aumRateSort") : new BigDecimal("0");
            BigDecimal aumNonrateSort = (BigDecimal)map.get("aumNonrateSort")!=null ? (BigDecimal)map.get("aumNonrateSort") : new BigDecimal("0");
            BigDecimal consignmentSort = (BigDecimal)map.get("consignmentSort")!=null ? (BigDecimal)map.get("consignmentSort") : new BigDecimal("0");
            BigDecimal danahartaSort = (BigDecimal)map.get("danahartaSort")!=null ? (BigDecimal)map.get("danahartaSort") : new BigDecimal("0");
            BigDecimal qdiiSort = (BigDecimal)map.get("qdiiSort")!=null ? (BigDecimal)map.get("qdiiSort") : new BigDecimal("0");
            BigDecimal rmbfundSort = (BigDecimal)map.get("rmbfundSort")!=null ? (BigDecimal)map.get("rmbfundSort") : new BigDecimal("0");
            BigDecimal insurranceSort = (BigDecimal)map.get("insurranceSort")!=null ? (BigDecimal)map.get("insurranceSort") : new BigDecimal("0");
            map.put("aumDepositSort",nf.format(aumDepositSort));
            map.put("aumRateSort",nf.format(aumRateSort));
            map.put("aumNonrateSort",nf.format(aumNonrateSort));
            map.put("consignmentSort",nf.format(consignmentSort));
            map.put("danahartaSort",nf.format(danahartaSort));
            map.put("qdiiSort",nf.format(qdiiSort));
            map.put("rmbfundSort",nf.format(rmbfundSort));
            map.put("insurranceSort",nf.format(insurranceSort));
        }
    }
}
