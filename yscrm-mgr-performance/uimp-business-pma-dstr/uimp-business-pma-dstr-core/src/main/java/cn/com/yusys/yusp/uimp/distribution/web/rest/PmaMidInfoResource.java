package cn.com.yusys.yusp.uimp.distribution.web.rest;


import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants;
import cn.com.yusys.yusp.uimp.distribution.model.PmaMidDistribute;
import cn.com.yusys.yusp.uimp.distribution.model.PmaMidInfo;
import cn.com.yusys.yusp.uimp.distribution.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(tags = "中收业绩分配")
@RestController
@RequestMapping("/api/pmamiddistribute")
public class PmaMidInfoResource {

    private static final Logger log = LoggerFactory.getLogger(PmaMidInfoResource.class);

    @Autowired
    PmaMidDistributeService pmaMidDistributeService;

    @Autowired
    PmaMidInfoService pmaMidInfoService;

    @Autowired
    PmaFComDepAcctInfoService pmaFComDepAcctInfoService;

    @Autowired
    PmaFComDepPeriodService pmaFComDepPeriodService;

    @Autowired
    PmaFComDepLoansInfoService pmaFComDepLoansInfoService;

    @Autowired
    BatchImportPreHandleService batchImportPreHandleService;


    @ApiOperation(value = "中收业绩列表查询")
    @GetMapping("/querylist")
    public ResultDto<List<PmaMidInfo>> querylist(QueryModel queryModel){
        Long count = pmaMidInfoService.selectCount(queryModel);
        List<PmaMidInfo> list = pmaMidInfoService.selectList(queryModel);
        ResultDto<List<PmaMidInfo>> resultDto = new ResultDto<>(list);
        resultDto.setTotal(count);
        return resultDto;
    }

    @ApiOperation(value = "保存区间及详情")
    @PostMapping("/saveDistribute")
    public ResultDto<Void> saveDistribute(@RequestBody PmaMidInfo pmaMidInfo) throws  Exception{
        pmaMidDistributeService.saveList(pmaMidInfo);
        ResultDto<Void> result = new ResultDto<Void>();
        result.setCode(1);
        result.setMessage("sucess");
        return result;
    }

    @ApiOperation(value = "查询中收分配详情")
    @GetMapping("/queryDistribute")
    public ResultDto<List<PmaMidDistribute>> queryDistribute(PmaMidDistribute model) throws  Exception{
        List<PmaMidDistribute> list = pmaMidDistributeService.selectList(model);
        return new ResultDto<List<PmaMidDistribute>>(list);
    }

    @ApiOperation(value = "业绩批量导入查询")
    @GetMapping("/uploadlist")
    public ResultDto<List> uploadlist(QueryModel queryModel){
        ResultDto<List> resultDto = null;
        String bussType = String.valueOf(queryModel.getCondition().get("bussType"));
        queryModel.getCondition().remove("bussType");
        if(DistributionConstants.ACCT_BUSS_TYPE.equalsIgnoreCase(bussType)){
            List<Map<String, Object>> list = pmaFComDepAcctInfoService.oneToManyQueryList(queryModel);
            Long count = pmaFComDepAcctInfoService.oneToManyQueryCount(queryModel);
            resultDto = new ResultDto<>(list);
            resultDto.setTotal(count);
        }else if(DistributionConstants.DEPT_BUSS_TYPE.equalsIgnoreCase(bussType)){
            List<Map<String, Object>> list = pmaFComDepLoansInfoService.oneToManyQueryList(queryModel);
            Long count = pmaFComDepLoansInfoService.oneToManyQueryCount(queryModel);
            resultDto = new ResultDto<>(list);
            resultDto.setTotal(count);
        }else if(DistributionConstants.MID_BUSS_TYPE.equalsIgnoreCase(bussType)){
            Long count = pmaMidInfoService.oneToManyQueryCount(queryModel);
            List<Map<String, Object>> list = pmaMidInfoService.oneToManyQueryList(queryModel);
            resultDto = new ResultDto<>(list);
            resultDto.setTotal(count);
        }
        return resultDto;
    }

    @ApiOperation(value = "业绩批量导入")
    @PostMapping("/upload")
    public ResultDto<Object> upload(String bussType, MultipartFile file){
        return batchImportPreHandleService.preHandleExcel(file, bussType);
    }


    @ApiOperation(value = "业绩批量导出")
    @GetMapping("/download")
    public void download(String bussType, String dstrSts, String ids,
                         String managerId, String custName, String custNumber,
                         String orgId, HttpServletResponse response){
        List<Map<String, Object>> resultList = null;
        if(StringUtils.isNotBlank(ids)){
            resultList = new ArrayList<>();
            String[] arr = ids.split(",");
            for(String id: arr){
                if(DistributionConstants.ACCT_BUSS_TYPE.equalsIgnoreCase(bussType)){
                    QueryModel select = new QueryModel();
                    select.setSize(1);
                    select.setPage(0);
                    select.getCondition().put("id",id);
                    List<Map<String,Object>> list = pmaFComDepAcctInfoService.queryCommList(select);
                    if(!list.isEmpty()){
                        resultList.add(list.get(0));
                    }
                }else if(DistributionConstants.DEPT_BUSS_TYPE.equalsIgnoreCase(bussType)){
                    QueryModel select = new QueryModel();
                    select.setSize(1);
                    select.setPage(0);
                    select.getCondition().put("id",id);
                    List<Map<String,Object>> list = pmaFComDepLoansInfoService.queryCommList(select);
                    if(!list.isEmpty()){
                        resultList.add(list.get(0));
                    }
                }else if(DistributionConstants.MID_BUSS_TYPE.equalsIgnoreCase(bussType)){
                    try {
                        resultList.add(convertBeanToMap(pmaMidInfoService.selectByPrimaryKey(id)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            QueryModel model = new QueryModel();
            model.setPage(0);
            model.setSize(10000000);
            if(StringUtils.isNotBlank(dstrSts)){
                model.getCondition().put("dstrSts", dstrSts);
            }
            if(StringUtils.isNotBlank(managerId)){
                model.getCondition().put("managerId", managerId);
            }
            if(StringUtils.isNotBlank(custName)){
                model.getCondition().put("custName", custName);
            }
            if(StringUtils.isNotBlank(custNumber)){
                model.getCondition().put("custNumber", custNumber);
            }
            if(StringUtils.isNotBlank(orgId)){
                model.getCondition().put("orgId", orgId);
            }
            if(DistributionConstants.ACCT_BUSS_TYPE.equalsIgnoreCase(bussType)){
                resultList = pmaFComDepAcctInfoService.queryCommList(model);
            }else if(DistributionConstants.DEPT_BUSS_TYPE.equalsIgnoreCase(bussType)){
                resultList = pmaFComDepLoansInfoService.queryCommList(model);
            }else if(DistributionConstants.MID_BUSS_TYPE.equalsIgnoreCase(bussType)){
                resultList = new ArrayList<>();
                List<PmaMidInfo> list = pmaMidInfoService.selectList(model);
                for(PmaMidInfo pmaMidInfo : list){
                    Map<String, Object> info = null;
                    try {
                        info = convertBeanToMap(pmaMidInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(info != null){
                        resultList.add(info);
                    }
                }
            }
        }
        if(resultList == null || resultList.isEmpty()){
            throw new RuntimeException("没有数据");
        }
        SXSSFWorkbook wb = new SXSSFWorkbook();
        List<Map<String, Object>> bussTypes = pmaMidInfoService.selectItem("CD0501");
        List<Map<String, Object>> dstrStsTypes = pmaMidInfoService.selectItem("DS0001");
        List<Map<String, Object>> acctTypes = pmaMidInfoService.selectItem("DS0003");
        if(DistributionConstants.ACCT_BUSS_TYPE.equalsIgnoreCase(bussType)){
            Sheet sheet = wb.createSheet("存款分配批量导入");
            CellStyle style = wb.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            Row row = sheet.createRow(0);
            for(int i=0;i<DistributionConstants.ACCT_COLUMNS.length;i++){
                Cell cell = row.createCell(i);
                cell.setCellValue(DistributionConstants.ACCT_COLUMNS[i]);
                cell.setCellType(CellType.STRING);
                cell.setCellStyle(style);
            }
            int i=1;
            for(Map<String,Object> map : resultList){
                Row dataRow = sheet.createRow(i);
                for(int j=0;j<DistributionConstants.ACCT_COLUMNS_EN.length;j++){
                    Cell cell = dataRow.createCell(j);
                    if(DistributionConstants.ACCT_COLUMNS[j].equals("账户类型")){
                        for(Map<String, Object> itemMap :acctTypes ){
                            if(StringUtils.isNotBlank(String.valueOf(map.get(DistributionConstants.ACCT_COLUMNS_EN[j])==null?"":map.get(DistributionConstants.ACCT_COLUMNS_EN[j]))) && ((String)map.get(DistributionConstants.ACCT_COLUMNS_EN[j])).equals(itemMap.get("lookupItemCode"))){
                                cell.setCellValue((String)itemMap.get("lookupItemName"));
                                break;
                            }
                        }
                    }else if(DistributionConstants.ACCT_COLUMNS[j].equals("分配状态")){
                        for(Map<String, Object> itemMap :dstrStsTypes ){
                            if(StringUtils.isNotBlank(String.valueOf(map.get(DistributionConstants.ACCT_COLUMNS_EN[j])==null?"":map.get(DistributionConstants.ACCT_COLUMNS_EN[j]))) && ((String)map.get(DistributionConstants.ACCT_COLUMNS_EN[j])).equals(itemMap.get("lookupItemCode"))){
                                cell.setCellValue((String)itemMap.get("lookupItemName"));
                                break;
                            }
                        }
                    }else {
                        cell.setCellValue(StringUtils.isNotBlank(String.valueOf(map.get(DistributionConstants.ACCT_COLUMNS_EN[j])==null?"":map.get(DistributionConstants.ACCT_COLUMNS_EN[j])))?String.valueOf(map.get(DistributionConstants.ACCT_COLUMNS_EN[j])):"" );
                    }
                    cell.setCellType(CellType.STRING);
                    cell.setCellStyle(style);
                }
                i++;
            }
        }else if(DistributionConstants.DEPT_BUSS_TYPE.equalsIgnoreCase(bussType)){
            Sheet sheet = wb.createSheet("贷款分配批量导入");
            CellStyle style = wb.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            Row row = sheet.createRow(0);
            for(int i=0;i<DistributionConstants.DEPT_COLUMNS.length;i++){
                Cell cell = row.createCell(i);
                cell.setCellValue(DistributionConstants.DEPT_COLUMNS[i]);
                cell.setCellType(CellType.STRING);
                cell.setCellStyle(style);
            }
            int i=1;
            for(Map<String,Object> map : resultList){
                Row dataRow = sheet.createRow(i);
                for(int j=0;j<DistributionConstants.DEPT_COLUMNS_EN.length;j++){
                    Cell cell = dataRow.createCell(j);
                    if(DistributionConstants.DEPT_COLUMNS[j].equals("分配状态")){
                        for(Map<String, Object> itemMap :dstrStsTypes ){
                            if(StringUtils.isNotBlank(String.valueOf(map.get(DistributionConstants.DEPT_COLUMNS_EN[j])==null?"":map.get(DistributionConstants.DEPT_COLUMNS_EN[j]))) && ((String)map.get(DistributionConstants.DEPT_COLUMNS_EN[j])).equals(itemMap.get("lookupItemCode"))){
                                cell.setCellValue((String)itemMap.get("lookupItemName"));
                                break;
                            }
                        }
                    }else {
                        cell.setCellValue(StringUtils.isNotBlank(String.valueOf(map.get(DistributionConstants.DEPT_COLUMNS_EN[j])==null?"":map.get(DistributionConstants.DEPT_COLUMNS_EN[j])))?String.valueOf(map.get(DistributionConstants.DEPT_COLUMNS_EN[j])):"" );
                    }
                    cell.setCellType(CellType.STRING);
                    cell.setCellStyle(style);
                }
                i++;
            }
        }else if(DistributionConstants.MID_BUSS_TYPE.equalsIgnoreCase(bussType)){
            Sheet sheet = wb.createSheet("中收分配批量导入");
            CellStyle style = wb.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            Row row = sheet.createRow(0);
            for(int i=0;i<DistributionConstants.MID_COLUMNS.length;i++){
                Cell cell = row.createCell(i);
                cell.setCellValue(DistributionConstants.MID_COLUMNS[i]);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellStyle(style);
            }
            int i=1;
            for(Map<String,Object> map : resultList){
                Row dataRow = sheet.createRow(i);
                for(int j=0;j<DistributionConstants.MID_COLUMNS_EN.length;j++){
                    Cell cell = dataRow.createCell(j);
                    if(DistributionConstants.MID_COLUMNS[j].equals("业务类型")){
                        for(Map<String, Object> itemMap :bussTypes ){
                            if(StringUtils.isNotBlank(String.valueOf(map.get(DistributionConstants.MID_COLUMNS_EN[j])==null?"":map.get(DistributionConstants.MID_COLUMNS_EN[j]))) && ((String)map.get(DistributionConstants.MID_COLUMNS_EN[j])).equals(itemMap.get("lookupItemCode"))){
                                cell.setCellValue((String)itemMap.get("lookupItemName"));
                                break;
                            }
                        }
                    }else if(DistributionConstants.MID_COLUMNS[j].equals("分配状态")){
                        for(Map<String, Object> itemMap :dstrStsTypes ){
                            if(StringUtils.isNotBlank(String.valueOf(map.get(DistributionConstants.MID_COLUMNS_EN[j])==null?"":map.get(DistributionConstants.MID_COLUMNS_EN[j]))) && ((String)map.get(DistributionConstants.MID_COLUMNS_EN[j])).equals(itemMap.get("lookupItemCode"))){
                                cell.setCellValue((String)itemMap.get("lookupItemName"));
                                break;
                            }
                        }
                    }else {
                        cell.setCellValue(StringUtils.isNotBlank(String.valueOf(map.get(DistributionConstants.MID_COLUMNS_EN[j])==null?"":map.get(DistributionConstants.MID_COLUMNS_EN[j])))?String.valueOf(map.get(DistributionConstants.MID_COLUMNS_EN[j])):"" );
                    }
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellStyle(style);
                }
                i++;
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        ServletOutputStream os = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/x-download;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + sdf.format(new Date())+".xlsx");
            os = response.getOutputStream();
            wb.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(os  != null){
                try {
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ResultDto<Object> result = new ResultDto<>();
        result.setCode(1);
        result.setMessage("sucess");
    }

    @ApiOperation(value = "中收业绩历史查询")
    @GetMapping("/queryMidHis")
    public ResultDto<List<Map<String, Object>>> queryMidHis(QueryModel model){
        List<Map<String, Object>> list = this.pmaMidInfoService.queryMidHis(model);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

    public static Map<String,Object> convertBeanToMap(Object bean) throws Exception {
        Class type = bean.getClass();
        Map<String,Object> returnMap = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }

    @ApiOperation(value = "")
    @GetMapping("/queryReview")
    public ResultDto<List<PmaMidInfo>> queryReview(QueryModel model){
//        List<Map<String, Object>> list = this.pmaMidInfoService.queryMidHis(model);
        List<PmaMidInfo> list = new ArrayList<>();
        list.add(pmaMidInfoService.selectByPrimaryKey((String)model.getCondition().get("id")));
        return new ResultDto<List<PmaMidInfo>>(list);
    }
}

