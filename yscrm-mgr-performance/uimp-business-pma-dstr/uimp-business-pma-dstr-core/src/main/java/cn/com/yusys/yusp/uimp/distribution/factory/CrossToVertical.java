package cn.com.yusys.yusp.uimp.distribution.factory;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepAcctInfo;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFComDepAcctInfoMapper;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author:Mr.raop
 * @create:2022-06-02
 */

@RestController
@RequestMapping("/api/CrossToVerticalController")
public class CrossToVertical {

    private final static Map<String, String> commonFiledMgrMap = new LinkedHashMap<>();
    private final static Map<String, String> keyValueMap = new LinkedHashMap<>();
    private final static String mgrStr = "007";

    @Autowired
    private PmaFComDepAcctInfoMapper mapper;


    static {
        commonFiledMgrMap.put("schemeId", "方案编号");
        commonFiledMgrMap.put("schemeName", "方案名称");
        commonFiledMgrMap.put("schemeCycle", "方案周期");
        commonFiledMgrMap.put("managerId", "客户经理编号");

        keyValueMap.put("indexId", "编号");
        keyValueMap.put("indexName", "指标");
        keyValueMap.put("compRate", "完成率");
    }
       /* 原始数据：{list3=[{schemeId=S3, schemeName=考核方案2022S3, schemeCycle=2022-04-15, managerId=007, indexId=B20220509094, indexName=存款, compRate=90},
            {schemeId=S3, schemeName=考核方案2022S3, schemeCycle=2022-04-15, managerId=007, indexId=B20220509095, indexName=贷款, compRate=70},
            {schemeId=S3, schemeName=考核方案2022S3, schemeCycle=2022-04-15, managerId=007, indexId=E20220509062, indexName=中收, compRate=40},
            {schemeId=S3, schemeName=考核方案2022S3, schemeCycle=2022-04-21, managerId=069, indexId=B20220509094, indexName=存款, compRate=85},
            {schemeId=S3, schemeName=考核方案2022S3, schemeCycle=2022-04-21, managerId=069, indexId=B20220509095, indexName=贷款, compRate=25},
            {schemeId=S3, schemeName=考核方案2022S3, schemeCycle=2022-04-21, managerId=069, indexId=E20220509062, indexName=中收, compRate=0},
            {schemeId=S3, schemeName=考核方案2022S3, schemeCycle=2021-05-21, managerId=021, indexId=B20220509094, indexName=存款, compRate=15},
            {schemeId=S3, schemeName=考核方案2022S3, schemeCycle=2021-05-21, managerId=021, indexId=B20220509095, indexName=贷款, compRate=35},
            {schemeId=S3, schemeName=考核方案2022S3, schemeCycle=2021-05-21, managerId=021, indexId=E20220509062, indexName=中收, compRate=10}]}*/

       /* 目标数据：[{indexIdB20220509095=B20220509095, indexIdB20220509094=B20220509094, indexNameE20220509062=中收, schemeName=考核方案2022S3, schemeId=S3, managerId=021, indexIdE20220509062=E20220509062, compRateB20220509094=15, compRateB20220509095=35, schemeCycle=2021-05-21, indexNameB20220509094=存款, indexNameB20220509095=贷款, compRateE20220509062=10},
        {indexIdB20220509095=B20220509095, indexIdB20220509094=B20220509094, indexNameE20220509062=中收, schemeName=考核方案2022S3, schemeId=S3, managerId=007, indexIdE20220509062=E20220509062, compRateB20220509094=90, compRateB20220509095=70, schemeCycle=2022-04-15, indexNameB20220509094=存款, indexNameB20220509095=贷款, compRateE20220509062=40},
        {indexIdB20220509095=B20220509095, indexIdB20220509094=B20220509094, indexNameE20220509062=中收, schemeName=考核方案2022S3, schemeId=S3, managerId=069, indexIdE20220509062=E20220509062, compRateB20220509094=85, compRateB20220509095=25, schemeCycle=2022-04-21, indexNameB20220509094=存款, indexNameB20220509095=贷款, compRateE20220509062=0}]*/


    @PostMapping("/queryTotalList")
    public ResultDto<List<Map<String, Object>>> queryTotalList(@RequestBody Map<String, Object> map) throws Exception {
        List<Map<String, Object>> collect = queryList(map);
        return new ResultDto<List<Map<String, Object>>>(collect);
    }

    /**
     * 横向9条数据变纵向3条数据，
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> queryList(Map<String, Object> map) throws Exception {

        List<Map<String, Object>> resultList = new ArrayList();
        Map<String, Map<String, Object>> resultMap = new HashMap<>();
        Object list3 = map.get("list3");
        System.out.println("数据：" + map);
        if (list3 != null) {
            List<Map<String, Object>> listByItem = (List<Map<String, Object>>) list3;

            for (Map<String, Object> listSingle : listByItem) {

                String tempKey = listSingle.get("managerId").toString();

                if (resultMap.containsKey(tempKey)) {
                    Map<String, Object> newMap = resultMap.get(tempKey);

                    for (Map.Entry<String, String> next : keyValueMap.entrySet()) {
                        String newkey = next.getKey() + listSingle.get("indexId");
                        newMap.put(newkey, listSingle.get(next.getKey()));
                    }

                } else {
                    Map newMap = new HashMap();
                    Set<Map.Entry<String, String>> entries = commonFiledMgrMap.entrySet();
                    for (Map.Entry<String, String> next : entries) {
                        String key = next.getKey();
                        newMap.put(key, listSingle.get(key));
                    }

                    Set<Map.Entry<String, String>> entriesKv = keyValueMap.entrySet();
                    for (Map.Entry<String, String> next : entriesKv) {
                        String newkey = next.getKey() + listSingle.get("indexId");
                        newMap.put(newkey, listSingle.get(next.getKey()));
                    }
                    resultMap.put(tempKey, newMap);
                }

            }

            resultMap.forEach((key, value) -> resultList.add(value));
        }
        System.out.println("排序前：" + resultList);

        List<Map<String, Object>> collect = resultList.stream().sorted((o1, o2) -> {
            String cycle1 = o1.containsKey("schemeCycle") ? o1.get("schemeCycle").toString() : "";
            String cycle2 = o2.containsKey("schemeCycle") ? o2.get("schemeCycle").toString() : "";
            if (StringUtils.isBlank(cycle1)) {
                return -1;
            }
            if (StringUtils.isBlank(cycle2)) {
                return 1;
            }
            int compareNum = LocalDate.parse(cycle1, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    .compareTo(LocalDate.parse(cycle2, DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            if (compareNum > 0) {
                return 1;
            } else {
                return -1;
            }
        }).collect(Collectors.toList());

        System.out.println("排序后：" + collect);

        return collect;
    }

    /**
     * 利用EasyExcel导出excel
     * @param map
     * @param response
     * @throws Exception
     */
    @PostMapping("/exportExcel")
    public void export(@RequestBody Map<String, Object> map, HttpServletResponse response) throws Exception {
        List<List<String>> excelTitleList = new LinkedList<>();
        List<List<String>> excelDataList = new LinkedList<>();

        List<Map<String, Object>> resultList = queryList(map);

        List<Map<String, Object>> list = new ArrayList<>();
        for (Map.Entry<String, String> next : commonFiledMgrMap.entrySet()) {
            Map<String, Object> tempMap = new HashMap<>();
            String key = next.getKey();
            String value = next.getValue();
            tempMap.put("key", key);
            tempMap.put("value", value);
            list.add(tempMap);
        }
        Object list3 = map.get("list3");
        List<Map<String, Object>> listByItem = (List<Map<String, Object>>) list3;
        System.out.println("去重前的List<Map<String, Object>>为：" + listByItem);

        //去重
        List<Map<String, Object>> resList = new ArrayList<>();
        for (Map<String, Object> nextList : listByItem) {
            Map<String, Object> tempmap = new HashMap<>();
            String indexId = nextList.get("indexId").toString();
            String indexName = nextList.get("indexName").toString();
            tempmap.put("indexId", indexId);
            tempmap.put("indexName", indexName);
            resList.add(tempmap);
        }
        List<Map<String, Object>> collectToRepeat = resList.stream().distinct().collect(Collectors.toList());
        System.out.println("方法一去重后的List<Map<String, Object>>为：" + collectToRepeat);

        List<Map<String, Object>> listToRepeat = removeRepeatMapByKey(listByItem, "indexId");
        System.out.println("方法二去重后的List<Map<String, Object>>为：" + listToRepeat);

        for (Map<String, Object> listSingle : collectToRepeat) {
            Set<Map.Entry<String, String>> entriesKv = keyValueMap.entrySet();
            for (Map.Entry<String, String> next : entriesKv) {
                Map<String, Object> tempMap = new HashMap<>();
                String key = next.getKey() + listSingle.get("indexId").toString();
                String value = listSingle.get("indexName").toString() + next.getValue();
                tempMap.put("key", key);
                tempMap.put("value", value);
                list.add(tempMap);
            }
        }

        for (Map<String, Object> titleList : list) {
            List<String> templist = new ArrayList<>();
            templist.add(titleList.get("value").toString());
            excelTitleList.add(templist);
        }

        //根据表头字段顺序添加数据
        /*for (Map<String, Object> vo : resultList) {
            List<String> templist = new ArrayList<>();
            for (Map<String, Object> titleList : list) {
                templist.add((vo.get(titleList.get("key").toString())).toString());
                excelDataList.add(templist);
            }
        }*/
        resultList.forEach(vo -> {
            List<String> tempList = new ArrayList<>();
            for (Map<String, Object> stringObjectMap : list) {
                tempList.add(vo.get(stringObjectMap.get("key").toString()).toString());
            }
            excelDataList.add(tempList);
        });

        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("下载测试", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

            EasyExcel.write(response.getOutputStream())
                    .head(excelTitleList)
                    .registerWriteHandler(new SimpleColumnWidthStyleStrategy(20))
                    .sheet("sheet").doWrite(excelDataList);
        } catch (IOException e) {
            throw new RuntimeException("文件下载失败");
        }

    }

    /**
     * 根据指定字段去重
     * @param list
     * @param mapKey
     * @return
     */
    public static List<Map<String, Object>> removeRepeatMapByKey(List<Map<String, Object>> list, String mapKey) {

        List<Map<String, Object>> listMap = new ArrayList<>();
        Map<String, Map> msp = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Map map = list.get(i);

            String id = map.get(mapKey).toString();//错误举例 (String)map.get(mapKey);
            //删除现有Map中你所指定的字段。
            map.remove(mapKey);
            msp.put(id, map);
        }
        //其实上面👆🏻已经做好去重啦。我们只需要将key再次循环送到Map中就好啦
        Set<String> mspKey = msp.keySet();
        for (String key : mspKey) {
            Map newMap = msp.get(key);
            newMap.put(mapKey, key);
            listMap.add(newMap);
        }
        return listMap;
    }

    @PostMapping("/importExcel")
    public void importExc(@RequestBody MultipartFile file) {

        try {
            EasyExcel.read(file.getInputStream(), DepAcctInfoExcelVo.class, new ExcelListen(mapper)).sheet().doRead();
        } catch (IOException e) {
            throw new RuntimeException("文件导入失败");
        }

    }
}
