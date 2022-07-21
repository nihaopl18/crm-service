package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.uimp.base.repository.mapper.PmaFPerformanceResultMapper;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.net.Socket;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PmaFPerformanceResultService {
    // 业绩结果Mapper
    private PmaFPerformanceResultMapper pmaFPerformanceResultMapper;

    @Autowired
    private void setPmaFPerformanceResultMapper(PmaFPerformanceResultMapper pmaFPerformanceResultMapper) {
        this.pmaFPerformanceResultMapper = pmaFPerformanceResultMapper;
    }

    // 用户信息服务
    private UserInfoService userInfoService;

    @Autowired
    private void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    private static final Map<String, String> keyValueMap = new LinkedHashMap<>();
    // 客户经理需要合并公共字段
    private static final Map<String, String> mgrCommonFiledMap = new LinkedHashMap<>();
    // 团队需要合并公共字段
    private static final Map<String, String> teamCommonFiledMap = new LinkedHashMap<>();
    // 机构需要合并公共字段
    private static final Map<String, String> orgCommonFiledMap = new LinkedHashMap<>();

    private static Log logger = LogFactory.getLog(PmaFPerformanceResultService.class);

    // 客户经理类型码值
    private static final String MGR_CODE = "01";
    // 团队类型码值
    private static final String TEAM_CODE = "04";
    // 机构类型码值
    private static final String ORG_CODE = "02";
    static {

        keyValueMap.put("indexId", "编号");
        keyValueMap.put("indexName", "指标");
        keyValueMap.put("indexTargetValue", "目标值");
        keyValueMap.put("indexRes", "结果值");
        keyValueMap.put("compRate", "完成率");
        keyValueMap.put("rank", "完成率排行");

        mgrCommonFiledMap.put("schemeId", "方案编号");
        mgrCommonFiledMap.put("schemeName", "方案名称");
        mgrCommonFiledMap.put("schemeCycle", "方案周期");
        mgrCommonFiledMap.put("managerId", "客户经理编号");
        mgrCommonFiledMap.put("managerName", "客户经理名称");
        mgrCommonFiledMap.put("orgId", "机构编号");
        mgrCommonFiledMap.put("orgName", "机构名称");
        mgrCommonFiledMap.put("teamName", "团队名称");

        teamCommonFiledMap.put("schemeId", "方案编号");
        teamCommonFiledMap.put("schemeName", "方案名称");
        teamCommonFiledMap.put("schemeCycle", "方案周期");
        teamCommonFiledMap.put("teamId", "团队编号");
        teamCommonFiledMap.put("teamName", "团队名称");
        teamCommonFiledMap.put("teamleaderId", "团队负责人编号");
        teamCommonFiledMap.put("teamleaderName", "团队负责人名称");
        teamCommonFiledMap.put("branchId", "分公司编号");
        teamCommonFiledMap.put("branchName", "分公司名称");
        teamCommonFiledMap.put("orgId", "机构编号");
        teamCommonFiledMap.put("orgName", "机构名称");

        orgCommonFiledMap.put("schemeId", "方案编号");
        orgCommonFiledMap.put("schemeName", "方案名称");
        orgCommonFiledMap.put("schemeCycle", "方案周期");
        orgCommonFiledMap.put("orgId", "机构编号");
        orgCommonFiledMap.put("orgName", "机构名称");
    }

    /**
     * 客户经理指标统计
     *
     * @param model 查询条件
     * @return Map<String, Object>
     */
    public ResultDto<List<Map<String, Object>>> getListByMgr(QueryModel model) {

        String schemeId = model.getCondition().get("schemeId").toString();
        if (StringUtils.isBlank(schemeId)) {
            throw new RuntimeException("指标编号不能为空");
        }

        // 根据方案编号查询指标信息
        List<Map<String, Object>> titleList = pmaFPerformanceResultMapper.getRelationListByType(schemeId, MGR_CODE);
        if (CollectionUtils.isEmpty(titleList)) {
            return null;
        }
        setModel(model);

        // 根据条件查询出对象编号
        Page<Object> objects = PageHelper.startPage(model.getPage(), model.getSize());
        List<String> listByItem = pmaFPerformanceResultMapper.getMgrIdInfoByMgr(model);
        PageHelper.clearPage();
        long total = objects.getTotal();
        // 根据考核编号与对象编号查询考核详情
        if(CollectionUtils.isEmpty(listByItem)){
            listByItem = new ArrayList<>();
            listByItem.add("null");
        }
        List<Map<String, Object>> list = pmaFPerformanceResultMapper.getRusultByMgr(schemeId, listByItem);

        List<Map<String, Object>> resultList = commFn(mgrCommonFiledMap, titleList, list, "managerId");
        ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<>(resultList);
        resultDto.setTotal(total);
        return resultDto;
    }

    private void setModel(QueryModel model) {
        UserInfoDTO userInfo = userInfoService.getUserInfo();
        model.getCondition().put("orgId", userInfo.getOrg().getId());
        model.getCondition().put("mgrId", userInfo.getUserId());
    }

    /**
     * 团队指标统计
     * @param model 查询条件
     * @return Map<String, Object>
     */
    public ResultDto<List<Map<String, Object>>> getListByTeam(QueryModel model) {
        String schemeId = model.getCondition().get("schemeId").toString();
        if (StringUtils.isBlank(schemeId)) {
            throw new RuntimeException("指标编号不能为空");
        }

        // 根据方案编号查询指标信息
        List<Map<String, Object>> titleList = pmaFPerformanceResultMapper.getRelationListByType(schemeId, TEAM_CODE);

        if (CollectionUtils.isEmpty(titleList)) {
            return null;
        }
        setModel(model);
        // 根据条件查询出对象编号
        Page<Object> objects = PageHelper.startPage(model.getPage(), model.getSize());
        List<String> listByItem = pmaFPerformanceResultMapper.getTeamIdInfoByTeam(model);
        PageHelper.clearPage();
        long total = objects.getTotal();
        // 根据考核编号与对象编号查询考核详情
        if(CollectionUtils.isEmpty(listByItem)){
            listByItem = new ArrayList<>();
            listByItem.add("null");
        }

        List<Map<String, Object>> list = pmaFPerformanceResultMapper.getRusultByTeam(schemeId, listByItem);
        List<Map<String, Object>> resultList = commFn(teamCommonFiledMap, titleList, list, "teamId");
        ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<>(resultList);
        resultDto.setTotal(total);
        return resultDto;
    }

    /**
     * 机构指标统计
     *
     * @param model 查询条件
     * @return Map<String, Object>
     */
    public ResultDto<List<Map<String, Object>>> getListByOrg(QueryModel model) {
        String schemeId = model.getCondition().get("schemeId").toString();
        if (StringUtils.isBlank(schemeId)) {
            throw new RuntimeException("指标编号不能为空");
        }

        // 根据方案编号查询指标信息
        List<Map<String, Object>> titleList = pmaFPerformanceResultMapper.getRelationListByType(schemeId, ORG_CODE);
        if (CollectionUtils.isEmpty(titleList)) {
            return null;
        }
        // 根据方案编号查询业绩详情
        Page<Object> objects = PageHelper.startPage(model.getPage(), model.getSize());
        List<String> listByItem = pmaFPerformanceResultMapper.getOrgIdInfoByOrg(model);
        PageHelper.clearPage();
        long total = objects.getTotal();
        // 根据考核编号与对象编号查询考核详情
        if(CollectionUtils.isEmpty(listByItem)){
            listByItem = new ArrayList<>();
            listByItem.add("null");
        }
        List<Map<String, Object>> list = pmaFPerformanceResultMapper.getRusultByOrg(schemeId, listByItem);
        List<Map<String, Object>> resultList = commFn(orgCommonFiledMap, titleList, list, "orgId");
        ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<>(resultList);
        resultDto.setTotal(total);
        return resultDto;
    }

    /**
     * @param commonFiledMap 数据共有字段
     * @param titleList      表头信息
     * @param listByItem     指标数据
     * @return Map<String, Object> 返回结果
     */
    private List<Map<String, Object>> commFn(Map<String, String> commonFiledMap, List<Map<String, Object>> titleList, List<Map<String, Object>> listByItem, String objType) {

        String fistIndex = "compRate";
        if(!CollectionUtils.isEmpty(titleList)){
            fistIndex = "compRate" + titleList.get(0).get("indexId").toString();
        }

        // 解析list数据，将相同keyValue的数据合并
        List<Map<String, Object>> resultList = resolveData(listByItem, commonFiledMap, objType);

        // 根据周期与第一个指标排名排序

        String finalFistIndex = fistIndex;
        return resultList.stream().sorted((o1, o2) -> {
            String cycle1 = o1.containsKey("schemeCycle") ? o1.get("schemeCycle").toString() : "";
            String cycle2 = o2.containsKey("schemeCycle") ? o2.get("schemeCycle").toString() : "";
            if (StringUtils.isBlank(cycle1)) {
                return -1;
            }
            if (StringUtils.isBlank(cycle2)) {
                return 1;
            }
            int compareNum = LocalDate.parse(cycle1, DateTimeFormatter.ofPattern("yyyy-MM-dd")).compareTo(LocalDate.parse(cycle2, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            if (compareNum > 0) {
                return 1;
            } else if (compareNum < 0) {
                return -1;
            } else {
                int resultNum;
                double a1 = o1.containsKey(finalFistIndex) ? Double.parseDouble(o1.get(finalFistIndex).toString()) : 0;
                double a2 = o2.containsKey(finalFistIndex) ? Double.parseDouble(o2.get(finalFistIndex).toString()) : 0;
                resultNum = Double.compare(a2, a1);
                return resultNum;
            }
        }).collect(Collectors.toList());
    }


    /**
     * 将多条指标合并为一条数据
     *
     * @param list 指标数据
     * @param commonFiledMap 数据共有字段
     * @return 表头字段
     */
    private List<Map<String, Object>> getTitleFiled(List<Map<String, Object>> list, Map<String, String> commonFiledMap) {
        List<Map<String, Object>> list3 = new ArrayList<>();
        Set<Map.Entry<String, String>> commFiledSet = commonFiledMap.entrySet();
        for (Map.Entry<String, String> next : commFiledSet) {
            HashMap<String, Object> tempMap = new HashMap<>();
            String key = next.getKey();
            String value = next.getValue();
            tempMap.put("key", key);
            tempMap.put("value", value);
            list3.add(tempMap);
        }
        for (Map<String, Object> stringObjectMap : list) {
            Set<Map.Entry<String, String>> entries = keyValueMap.entrySet();
            for (Map.Entry<String, String> next : entries) {
                HashMap<String, Object> tempMap = new HashMap<>();
                String key = next.getKey() + stringObjectMap.get("indexId").toString();
                String value = stringObjectMap.get("indexName").toString() + next.getValue();
                tempMap.put("key", key);
                tempMap.put("value", value);
                list3.add(tempMap);
            }
        }
        return list3;
    }

    /**
     * 解析list数据，将相同keyValue的数据合并
     * @param list           处理数据
     * @param commonFiledMap 公共字段
     * @param objType        标识为相同数据的字段（客户经理，团队，机构）编号
     * @return 同一对象不同指标合并后的数据
     */
    private List<Map<String, Object>> resolveData(List<Map<String, Object>> list, Map<String, String> commonFiledMap, String objType) {
        Map<String, Map<String, Object>> resultMap = new HashMap<>();

        for (Map<String, Object> entity : list) {
            Set<Map.Entry<String, String>> entries = keyValueMap.entrySet();
            Iterator<Map.Entry<String, String>> iterator = entries.iterator();


            //判断是否处理过指标，指标处理过会放到resultMap中,并以指标编号为key
            String tempKey = entity.get(objType).toString();
            if (resultMap.containsKey(tempKey)) {
                //已经处理过指标，其他指标信息合并

                Map<String, Object> put = resultMap.get(tempKey);
                while (iterator.hasNext()) {
                    Map.Entry<String, String> next = iterator.next();
                    put.put(next.getKey() + entity.get("indexId"), entity.get(next.getKey()));
                }
            } else {

                //未处理过指标，定义指标信息并加上公共字段，指标信息放入resultMap
                Map<String, Object> put = new HashMap<>();
                Set<Map.Entry<String, String>> commFiledSet = commonFiledMap.entrySet();
                for (Map.Entry<String, String> next : commFiledSet) {
                    put.put(next.getKey(), entity.get(next.getKey()));
                }

                //添加指标信息
                while (iterator.hasNext()) {
                    Map.Entry<String, String> next = iterator.next();
                    put.put(next.getKey() + entity.get("indexId"), entity.get(next.getKey()));
                }
                resultMap.put(tempKey, put);
            }
        }
        List<Map<String, Object>> rusultList = new ArrayList<>();
        resultMap.forEach((key, value) -> rusultList.add(value));
        return rusultList;
    }


    /**
     * 根据不同类型导出Excel
     *
     * @param model 条件
     * @param response 响应
     */
    public void export(QueryModel model, HttpServletResponse response) {
        String schemeId = model.getCondition().get("schemeId").toString();
        if (StringUtils.isBlank(schemeId)) {
            throw new RuntimeException("指标编号不能为空");
        }

        // 根据方案编号查询指标信息
        String objType = model.getCondition().get("objType").toString();
        List<Map<String, Object>> titleFiled = getListTitle(model);
        if(CollectionUtils.isEmpty(titleFiled)){
            logger.info("未查询到表头数据");
        }
        List<Map<String, Object>> titleList = pmaFPerformanceResultMapper.getRelationListByType(schemeId, objType);
        List<Map<String, Object>> resultList;
        List<String> listByItem;
        switch (objType) {
            case MGR_CODE: // 客户经理
                // 根据考核编号与对象编号查询考核详情
                listByItem = pmaFPerformanceResultMapper.getMgrIdInfoByMgr(model);
                if(CollectionUtils.isEmpty(listByItem)){
                    listByItem = new ArrayList<>();
                    listByItem.add("null");
                }
                List<Map<String, Object>> rusultByMgr = pmaFPerformanceResultMapper.getRusultByMgr(schemeId, listByItem);
                resultList = commFn(mgrCommonFiledMap, titleList, rusultByMgr, "managerId");
                break;
            case TEAM_CODE: // 团队
                // 根据考核编号与对象编号查询考核详情
                listByItem = pmaFPerformanceResultMapper.getTeamIdInfoByTeam(model);
                if(CollectionUtils.isEmpty(listByItem)){
                    listByItem = new ArrayList<>();
                    listByItem.add("null");
                }
                List<Map<String, Object>> rusultByTeam = pmaFPerformanceResultMapper.getRusultByTeam(schemeId, listByItem);
                resultList = commFn(teamCommonFiledMap, titleList, rusultByTeam, "teamId");
                break;
            case ORG_CODE: // 机构
                listByItem = pmaFPerformanceResultMapper.getOrgIdInfoByOrg(model);
                if(CollectionUtils.isEmpty(listByItem)){
                    listByItem = new ArrayList<>();
                    listByItem.add("null");
                }
                List<Map<String, Object>> rusultByOrg = pmaFPerformanceResultMapper.getRusultByOrg(schemeId, listByItem);
                resultList = commFn(orgCommonFiledMap, titleList, rusultByOrg, "orgId");
                break;
            default:
                throw new RuntimeException("未指定导出对象类型");
        }
        if (resultList == null || resultList.size() == 0) {
            logger.info("未查询到表体数据");
        }
        List<List<String>> excelTitleList = new LinkedList<>();
        List<List<String>> excelDataList = new LinkedList<>();

        if(!CollectionUtils.isEmpty(titleFiled)){
            //添加表头字段
            for (Map<String, Object> stringObjectMap : titleFiled) {
                List<String> tempList = new ArrayList<>();
                tempList.add(stringObjectMap.get("value").toString());
                excelTitleList.add(tempList);
            }

            //根据表头字段顺序添加数据
            resultList.forEach(vo -> {
                List<String> tempList = new ArrayList<>();
                for (Map<String, Object> stringObjectMap : titleFiled) {
                    tempList.add(vo.get(stringObjectMap.get("key").toString()).toString());
                }
                excelDataList.add(tempList);
            });
        }

        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("业绩结果", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

           // 这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream()).head(excelTitleList).registerWriteHandler(new SimpleColumnWidthStyleStrategy(25)).sheet("sheet").doWrite(excelDataList);
        } catch (Exception e) {
            throw new RuntimeException("文件下载失败");
        }
    }


    /**
     * 通过考核方案查询显示的动态表头
     * @param model 查询条件
     * @return 动态表头
     */
    public List<Map<String, Object>> getListTitle(QueryModel model) {
        String schemeId = model.getCondition().get("schemeId").toString();

        String objType = model.getCondition().get("objType").toString();
        if (StringUtils.isBlank(schemeId) ) {
            throw new RuntimeException("指标编号不能为空");
        }
        if (StringUtils.isBlank(objType)) {
            throw new RuntimeException("对象类型不能为空");
        }

        // 根据方案编号查询指标信息
        List<Map<String, Object>> titleList = pmaFPerformanceResultMapper.getRelationListByType(schemeId, objType);
        if (CollectionUtils.isEmpty(titleList)) {
            return null;
        }
        switch (objType){
            case MGR_CODE:
                return getTitleFiled(titleList,mgrCommonFiledMap);
            case TEAM_CODE:
                return getTitleFiled(titleList,teamCommonFiledMap);
            case ORG_CODE:
                return getTitleFiled(titleList,orgCommonFiledMap);
        }
        return null;
    }

    /**
     * 通过考核方案编号与考核对象类型查询指标信息
     * @param model 查询条件
     * @return 指标信息
     */
    public List<Map<String, Object>> getIndexList(QueryModel model) {
        String schemeId = model.getCondition().get("schemeId").toString();
        if (StringUtils.isBlank(schemeId)) {
            throw new RuntimeException("指标编号不能为空");
        }
        String objType = model.getCondition().get("objType").toString();
        if (StringUtils.isBlank(objType)) {
            throw new RuntimeException("对象类型不能为空");
        }

        // 根据方案编号查询指标信息
        List<Map<String, Object>> indexList = pmaFPerformanceResultMapper.getRelationListByType(schemeId, objType);
        if (CollectionUtils.isEmpty(indexList)) {
            return null;
        }
        return indexList;
    }
}