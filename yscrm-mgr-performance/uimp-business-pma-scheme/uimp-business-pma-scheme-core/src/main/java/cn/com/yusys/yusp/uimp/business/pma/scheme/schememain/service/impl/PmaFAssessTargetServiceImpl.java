package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.impl;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.uimp.base.repository.mapper.PmaFPerformanceResultMapper;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFScheme;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.*;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFAssessTargetMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFAssessTargetService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/** 目标下发service实现类
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/5/19 16:49
 */
@Service
public class PmaFAssessTargetServiceImpl implements PmaFAssessTargetService {

    // 注入用户信息服务
    private UserInfoService userInfoService;

    @Autowired
    private void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    // 注入方案主表mapper
    private PmaFSchemeMapper pmaFSchemeMapper;

    @Autowired
    private void setPmaFSchemeMapper(PmaFSchemeMapper pmaFSchemeMapper) {
        this.pmaFSchemeMapper = pmaFSchemeMapper;
    }

    // 注入评分标准mapper
    private PmaFAssessTargetMapper mapper;

    @Autowired
    private void setMapper(PmaFAssessTargetMapper mapper) {
        this.mapper = mapper;
    }

    // 注入考核结果mapper
    private PmaFPerformanceResultMapper pmaFPerformanceResultMapper;

    @Autowired
    private void setPmaFPerformanceResultMapper(PmaFPerformanceResultMapper pmaFPerformanceResultMapper) {
        this.pmaFPerformanceResultMapper = pmaFPerformanceResultMapper;
    }

    // 表格表头-年
    private static final String YEAR_TITLE = "年份-考核方案ID-考核方案名称-考核对象编号-考核对象名称-指标编号-指标名称-考核周期类型-考核对象类型-全年指标任务计划值";
    // 表格表头-半年
    private static final String HALF_TITLE = "年份-考核方案ID-考核方案名称-考核对象编号-考核对象名称-指标编号-指标名称-考核周期类型-考核对象类型-上半年-下半年";
    // 表格表头-季度
    private static final String QUARTER_TITLE = "年份-考核方案ID-考核方案名称-考核对象编号-考核对象名称-指标编号-指标名称-考核周期类型-考核对象类型-第一季度-第二季度-第三季度-第四季度";
    // 表格表头-月
    private static final String MONTH_TITLE = "年份-考核方案ID-考核方案名称-考核对象编号-考核对象名称-指标编号-指标名称-考核周期类型-考核对象类型-一月-二月-三月-四月-五月-六月-七月-八月-九月-十月-十一月-十二月";

    // 定义周期对应解析的类
    private static final HashMap<String,Class<?>> CYCLE_MODEL_TYPE_MAP = new HashMap<>(8);

    // 客户经理类型码值
    private static final String MGR_CODE = "01";
    // 团队类型码值
    private static final String TEAM_CODE = "04";
    // 机构类型码值
    private static final String ORG_CODE = "02";
    static {
        CYCLE_MODEL_TYPE_MAP.put("Y", YearTargetDistriExcelVo.class);
        CYCLE_MODEL_TYPE_MAP.put("HY", HalfYearTargetDistriExcelVo.class);
        CYCLE_MODEL_TYPE_MAP.put("Q", QuarterTargetDistriExcelVo.class);
        CYCLE_MODEL_TYPE_MAP.put("M", MonthTargetDistriExcelVo.class);
    }

    // 周期类型码值定义
    private static final HashMap<String, String> CYCLE_TYPE_MAP = new HashMap<>(8);

    static {
        CYCLE_TYPE_MAP.put("Y", "年");
        CYCLE_TYPE_MAP.put("HY", "半年");
        CYCLE_TYPE_MAP.put("Q", "季");
        CYCLE_TYPE_MAP.put("M", "月");
    }

    // 考核对象类型码值定义
    private static final HashMap<String, String> EVL_OBJ_TYPE = new HashMap<>(16);

    static {
        EVL_OBJ_TYPE.put(MGR_CODE, "客户经理");
        EVL_OBJ_TYPE.put(TEAM_CODE, "团队");
        EVL_OBJ_TYPE.put(ORG_CODE, "机构");
    }

    @Override
    public void export(String id, String years, String objIds, String indexIds, HttpServletResponse response) {

        // 通过考核方案ID查询考核方案信息
        PmaFScheme pmaFScheme = pmaFSchemeMapper.selectByPrimaryKey(id);
        if (null == pmaFScheme) {
            throw new RuntimeException("没有查询到考核方案信息");
        }
        // 获取考核方案考核对象类型
        String evlObjType = pmaFScheme.getEvlObjType();
        if (StringUtils.isBlank(evlObjType)) {
            throw new RuntimeException("考核方案考核对象类型为空");
        }
        // 通过方案获取该方案下关联指标信息
        CompletableFuture<List<Map<String, Object>>> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            List<Map<String, Object>> indexList = new ArrayList<>();
            try {
                if (StringUtils.isNotBlank(indexIds)) {
                    indexList = pmaFPerformanceResultMapper.getRelationListByTypeInIds(pmaFScheme.getSchemeId(), evlObjType, Arrays.asList(indexIds.split(",")));
                } else {
                    indexList = pmaFPerformanceResultMapper.getRelationListByType(pmaFScheme.getSchemeId(), evlObjType);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return indexList;
        });

        // 获取当前用户的机构信息
        UserInfoDTO userInfo = userInfoService.getUserInfo();
        String orgId = userInfo.getOrg().getId();
        // 获取考核方案考核对象
        List<Map<String, Object>> objList = new ArrayList<>();
        List<String> objLists = null;
        if (StringUtils.isNotBlank(objIds)) {
            objLists = Arrays.asList(objIds.split(","));
        }
        // 根据考核方案编号获取需要导出的考核对象（用当前用户机构限制查询范围，可选定考核对象查询）
        switch (evlObjType) {
            case MGR_CODE:
                objList = mapper.getExportMgrBySchemeId(pmaFScheme.getSchemeId(), orgId, objLists);
                break;
            case TEAM_CODE:
                objList = mapper.getExportTeamBySchemeId(pmaFScheme.getSchemeId(), orgId, objLists);
                break;
            case ORG_CODE:
                objList = mapper.getExportOrgBySchemeId(pmaFScheme.getSchemeId(), orgId, objLists);
                break;
        }

        List<Map<String, Object>> indexList;
        try {
            indexList = voidCompletableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("获取指标信息失败");
        }


        // 两个集合合并
        List<Map<String, Object>> dataList = new ArrayList<>();


        for (Map<String, Object> stringObjectMap : objList) {
            assert indexList != null;
            for (Map<String, Object> objectMap : indexList) {
                Map<String, Object> map = new HashMap<>(stringObjectMap);
                map.put("years", years);
                map.put("schemeId", pmaFScheme.getSchemeId());
                map.put("schemeName", pmaFScheme.getSchemeName());
                map.put("schemeCycleType", CYCLE_TYPE_MAP.get(pmaFScheme.getSchemeCycleType()));
                map.put("evlObjType", EVL_OBJ_TYPE.get(evlObjType));
                map.put("evlObjId", stringObjectMap.get("evlObjId"));
                map.put("evlObjName", stringObjectMap.get("evlObjName"));
                map.put("indexId", objectMap.get("indexId"));
                map.put("indexName", objectMap.get("indexName"));
                dataList.add(map);
            }

        }

        // 组装成导出数据
        List<TargetDistriExcelVo> list = new ArrayList<>();
        dataList.forEach(item -> {
            // MAP转换为对象
            TargetDistriExcelVo targetDistriExcelVo = (TargetDistriExcelVo) JSONObject.parseObject(JSONObject.toJSONString(item), CYCLE_MODEL_TYPE_MAP.get(pmaFScheme.getSchemeCycleType()));
            list.add(targetDistriExcelVo);
        });

        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("考核目标下发-" + EVL_OBJ_TYPE.get(pmaFScheme.getEvlObjType()) + "-" + CYCLE_TYPE_MAP.get(pmaFScheme.getSchemeCycleType()), "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            // 这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream(), CYCLE_MODEL_TYPE_MAP.get(pmaFScheme.getSchemeCycleType())).autoCloseStream(Boolean.FALSE).sheet("任务表").doWrite(list);
        } catch (Exception e) {
            throw new RuntimeException("文件下载失败");
        }
    }

    @Override
    public void importExcel(MultipartFile file) {

        // 获取表头信息，并根据表头信息判断目标类型
        String excelTitle = getExcelTitle(file);
        try {
            switch (excelTitle) {
                case YEAR_TITLE:
                    EasyExcel.read(file.getInputStream(), YearTargetDistriExcelVo.class, new TargetDistriExcelVoListener(mapper, userInfoService)).sheet().doRead();
                    break;
                case HALF_TITLE:
                    EasyExcel.read(file.getInputStream(), HalfYearTargetDistriExcelVo.class, new TargetDistriExcelVoListener(mapper, userInfoService)).sheet().doRead();
                    break;
                case QUARTER_TITLE:
                    EasyExcel.read(file.getInputStream(), QuarterTargetDistriExcelVo.class, new TargetDistriExcelVoListener(mapper, userInfoService)).sheet().doRead();
                    break;
                case MONTH_TITLE:
                    EasyExcel.read(file.getInputStream(), MonthTargetDistriExcelVo.class, new TargetDistriExcelVoListener(mapper, userInfoService)).sheet().doRead();
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Map<String, Object>> getMgrBySchemeId(QueryModel model) {
        UserInfoDTO userInfo = userInfoService.getUserInfo();
        model.getCondition().put("currentOrgId", userInfo.getOrg().getId());
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = mapper.getMgrBySchemeId(model);
        PageHelper.clearPage();
        return list;
    }

    @Override
    public List<PmaFAssessTargetVo> getList(QueryModel model) {
        String schemeId = model.getCondition().get("schemeId").toString();
        if (StringUtils.isBlank(schemeId)) {
            throw new RuntimeException("方案ID不能为空");
        }
        // 判断是否存在考核对象查询，如果存在则将字符串转换为集合
        String objIds = model.getCondition().get("objIds").toString();
        List<String> objList = null;
        if (StringUtils.isNotBlank(objIds)) {
            objList = Arrays.asList(objIds.split(","));
        }

        // 判断是否存在指标查询，如果存在则将字符串转换为集合
        String indexIds = model.getCondition().get("indexIds").toString();
        List<String> indexList = null;
        if (StringUtils.isNotBlank(indexIds)) {
            indexList = Arrays.asList(indexIds.split(","));
        }

        PageHelper.startPage(model.getPage(), model.getSize());
        List<PmaFAssessTargetVo> list = mapper.getList(model, CollectionUtils.isEmpty(objList) ? null : objList, CollectionUtils.isEmpty(indexList) ? null : indexList);
        PageHelper.clearPage();
        return list;
    }

    @Override
    public List<Map<String, Object>> getTemeBySchemeId(QueryModel model) {
        UserInfoDTO userInfo = userInfoService.getUserInfo();
        model.getCondition().put("orgId", userInfo.getOrg().getId());
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = mapper.getTeamBySchemeId(model);
        PageHelper.clearPage();
        return list;
    }

    /**
     * 获取表头信息
     * @param file 文件
     * @return 表头信息
     */
    private String getExcelTitle(MultipartFile file) {
        Workbook workbook = null;
        //判断文件是否03版本
        if (Objects.requireNonNull(file.getOriginalFilename()).endsWith(".xls")) {
            try {
                workbook = new HSSFWorkbook(file.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (file.getOriginalFilename().endsWith(".xlsx")) {
            try {
                workbook = new XSSFWorkbook(file.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件类型不正确");
        }
        StringBuilder title = new StringBuilder();

        if (workbook == null) {
            throw new RuntimeException("文件类型不正确");
        }
        //获取第一个sheet
        Sheet sheet = workbook.getSheetAt(0);
        //获取第一行
        Row row = sheet.getRow(0);
        row.getPhysicalNumberOfCells();
        //获取表头信息
        title.append(row.getCell(0).getStringCellValue());
        for (int i = 1; i < row.getLastCellNum(); i++) {
            title.append("-").append(row.getCell(i).getStringCellValue());
        }

        return title.toString();
    }
}
