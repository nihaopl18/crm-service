package cn.com.yusys.yusp.uimp.distribution.service;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 批量导入前置处理
 *
 * @author weixy6
 * @date 2022/6/2
 */
@Service
public class BatchImportPreHandleService {

    private final Logger log = LoggerFactory.getLogger(BatchImportPreHandleService.class);

    @Autowired
    PmaMidInfoService pmaMidInfoService;

    @Autowired
    PmaFComDepPeriodService pmaFComDepPeriodService;

    @Autowired
    PmaFComDepLoansInfoService pmaFComDepLoansInfoService;

    /**
     * 根据业务类型获取字段列表
     *
     * @param bussType 业务类型
     * @return 字段列表
     */
    private String[] getColumns(String bussType) {
        if (DistributionConstants.ACCT_BUSS_TYPE.equalsIgnoreCase(bussType)) {
            return DistributionConstants.ACCT_COLUMNS;
        } else if (DistributionConstants.DEPT_BUSS_TYPE.equalsIgnoreCase(bussType)) {
            return DistributionConstants.DEPT_COLUMNS;
        } else if (DistributionConstants.MID_BUSS_TYPE.equalsIgnoreCase(bussType)) {
            return DistributionConstants.MID_COLUMNS;
        }
        return new String[0];
    }


    /**
     * 文件解析前置处理
     *
     * @param file      文件
     * @param bussType  业务类型
     * @return  返回结果
     * @author wexiy6
     * @date 2022/6/9
     */
    public ResultDto<Object> preHandleExcel(MultipartFile file, String bussType) {
        ResultDto<Object> result = new ResultDto<>();
        try {
            if (file.getSize() <= 0) {
                throw new RuntimeException("文件中没有内容！");
            }
            // 文件转换
            XSSFWorkbook wb = getWorkbook(file);

            // 解析文件数据
            List<Map<String, String>> dataList = new ArrayList<>();
            parseFileData(wb, bussType, dataList);

            // 数据校验、装载及保存
            dataVerifyNLoad(bussType, dataList);

            result.setCode(1);
            result.setMessage("success");
        } catch (Exception e) {
            log.error(e.getMessage());
            result.setCode(0);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    /**
     * 将文件解析成Workbook
     *
     * @param file 文件
     * @return workbook
     * @author weixy6
     * @date 2022/6/2
     */
    private XSSFWorkbook getWorkbook(MultipartFile file) {
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(file.getInputStream());
        } catch (IOException e) {
            log.error("文件流解析异常：{}", e.getMessage());
        }
        if (wb == null) {
            throw new RuntimeException("文件解析异常！");
        }
        // 表格sheet页超过一个不予解析
        if (wb.getNumberOfSheets() > 1) {
            throw new RuntimeException("多个sheet页，无法解析，只能填写第一个sheet页！");
        }
        return wb;
    }

    /**
     * 解析文件数据
     *
     * @param wb       文件
     * @param bussType 业务类型
     * @param dataList 数据列表
     * @author weixy6
     * @date 2022/6/2
     */
    private void parseFileData(XSSFWorkbook wb, String bussType, List<Map<String, String>> dataList) {
        Sheet sheet = wb.getSheetAt(0);
        List<String> keys = new ArrayList<>();
        boolean firstRow = true;
        for (Row row : sheet) {
            if (firstRow) {
                // 装载业务类型字段
                getParseKeys(bussType, row, keys);
                firstRow = false;
            } else {
                // 解读每一行的数据，装载到dataList中
                getRowData(bussType, row, keys, dataList);
            }
        }
        if (dataList.isEmpty()) {
            throw new RuntimeException("没有需要解析的数据");
        }
    }

    /**
     * 装载文件解析的字段
     *
     * @param bussType 业务类型
     * @param row      当前行
     * @param keys     字段列表
     * @author weixy6
     * @date 2022/6/2
     */
    private void getParseKeys(String bussType, Row row, List<String> keys) {
        Cell cell;
        String[] columns = getColumns(bussType);
        // 如果文件的表头与该业务规定的表头不一致，则终止解析
        for (int j = 0; j < columns.length; j++) {
            cell = row.getCell(j);
            if (cell == null || !columns[j].equals(cell.getStringCellValue())) {
                throw new RuntimeException("第" + j + "列无法解析");
            }
            keys.add(cell.getStringCellValue());
        }
    }

    /**
     * 获得每行的数据
     *
     * @param bussType 业务类型
     * @param row      行数据
     * @param keys     业务字段列表
     * @param dataList 文件数据列表
     * @author weixy6
     * @date 2022/6/2
     */
    private void getRowData(String bussType, Row row, List<String> keys, List<Map<String, String>> dataList) {
        Cell cell;
        String[] columns = getColumns(bussType);

        Map<String, String> dataMap = new HashMap<>();
        for (int j = 0; j < columns.length; j++) {
            cell = row.getCell(j);
            // 如果解析到ID列数据为空，则该文件也不继续进行解析
            if (columns[j].equals("ID") && StringUtils.isBlank(cell.getStringCellValue())) {
                return;
            }
            if (cell == null) {
                dataMap.put(keys.get(j), "");
            } else {
                CellType cellType = cell.getCellTypeEnum();
                switch (cellType) {
                    case STRING:
                        dataMap.put(keys.get(j), StringUtils.isNotBlank(cell.getStringCellValue()) ? cell.getStringCellValue() : "");
                        break;
                    case BOOLEAN:
                        dataMap.put(keys.get(j), String.valueOf(cell.getBooleanCellValue()));
                        break;
                    case NUMERIC:
                        dataMap.put(keys.get(j), String.valueOf(cell.getNumericCellValue()));
                        break;
                    case BLANK:
                    case ERROR:
                    case _NONE:
                    default:
                        dataMap.put(keys.get(j), "");
                }
            }
        }
        dataList.add(dataMap);
    }

    /**
     * 根据起始金额、结束金额字段和比例的填写情况，判断该业绩分配的类型
     *
     * @param dataMap 数据
     * @param index   行数
     * @return 分配类型
     * @author weixy6
     * @date 2022/6/2
     */
    private String getAllocType(Map<String, String> dataMap, int index) {
        if ((StringUtils.isBlank(dataMap.get("起始金额")) || StringUtils.isBlank(dataMap.get("结束金额"))) && StringUtils.isNotBlank(dataMap.get("业绩分配比例(%)"))) {
            return DistributionConstants.ALLOC_TYPE.RATE.toString();
        } else if (StringUtils.isNotBlank(dataMap.get("起始金额")) && StringUtils.isNotBlank(dataMap.get("结束金额")) && StringUtils.isNotBlank(dataMap.get("业绩分配比例(%)"))) {
            return DistributionConstants.ALLOC_TYPE.BOTH.toString();
        } else if (StringUtils.isBlank(dataMap.get("业绩分配比例(%)")) && StringUtils.isNotBlank(dataMap.get("起始金额")) && StringUtils.isNotBlank(dataMap.get("结束金额"))) {
            return DistributionConstants.ALLOC_TYPE.AMOUNT.toString();
        } else {
            throw new RuntimeException("第" + index + "行，无法确定按比例分配还是按金额分配");
        }
    }


    /**
     * 数据校验、装载并保存
     *
     * @param bussType 业务类型
     * @param dataList 文件数据列表
     * @author weixy6
     * @date 2022/6/2
     */
    private void dataVerifyNLoad(String bussType, List<Map<String, String>> dataList) {
        List<UploadNode> pressList = new ArrayList<>();
        if (DistributionConstants.ACCT_BUSS_TYPE.equalsIgnoreCase(bussType)) {
            // 存款数据基本校验与装载
            deptAcctDataVerifyNLoad(dataList, pressList);
            pmaFComDepPeriodService.savePmaDistributeList(pressList);
        } else if (DistributionConstants.DEPT_BUSS_TYPE.equalsIgnoreCase(bussType)) {
            deptLoanDataVerifyNLoad(dataList, pressList);
            pmaFComDepLoansInfoService.savePressList(pressList);
        } else if (DistributionConstants.MID_BUSS_TYPE.equalsIgnoreCase(bussType)) {
            midDataVerifyNLoad(dataList, pressList);
            pmaMidInfoService.savePressList(pressList);
        }
    }

    /**
     * 存款数据校验和装载.
     * <p>使用{@link cn.com.yusys.yusp.uimp.distribution.service.UploadNode}类型分层装载数据，<br>
     * value属性存储该层信息，children属性存储下一层信息；<br>
     * 目前存款业务的装载模式为：<br>
     * 第一层value存储存款基本信息；<br>
     * 第二层存储时间区间信息；<br>
     * 第三层存储存款起始金额和结束金额区间；<br>
     * 最后一层存储分配的具体信息，包含分配的客户经理编号和名称、分配的比例</p>
     *
     * @param dataList  数据列表
     * @param pressList 装载Node
     * @author weixy6
     * @date 2022/6/2
     */
    private void deptAcctDataVerifyNLoad(List<Map<String, String>> dataList, List<UploadNode> pressList) {
        UploadNode node = null;
        // 行号
        int index = 1;
        for (Map<String, String> dataMap : dataList) {
            index++;
            String ID = dataMap.get("ID");
            boolean add = true;
            // 1. 第一层数据判断——ID是否已经存在，若未存在，则判定为新的一条存款数据；若已存在，则进行下一层信息的校验
            for (UploadNode exitNode : pressList) {
                if (StringUtils.isNotBlank(ID) && ID.equals(exitNode.value.get("ID"))) {
                    add = false;
                    node = exitNode;
                    break;
                }
            }
            // 2.1 判断为新增的数据
            if (add) {
                if (StringUtils.isBlank(dataMap.get("起始日期"))) {
                    throw new RuntimeException("第" + index + "行，起始日期不能为空");
                }
                if (StringUtils.isBlank(dataMap.get("结束日期"))) {
                    throw new RuntimeException("第" + index + "行，结束日期不能为空");
                }
                // 第一层数据（存款基本信息）装载
                node = new UploadNode();
                node.value.put("ID", ID);
                node.value.put("余额", dataMap.get("余额"));
                node.value.put("主账号", dataMap.get("主账号"));
                node.value.put("子账号", dataMap.get("子账号"));
                // 第二层数据（分配时间区间）装载
                UploadNode childNode = new UploadNode();
                loadTimeData(dataMap, node, childNode);
                // 第三层数据（分配起止金额区间）装载
                UploadNode grandNode = new UploadNode();
                String allocType = getAllocType(dataMap, index);
                grandNode.value.put("分配类型", allocType);
                loadAmtData(dataMap, childNode, grandNode);
                // 第四层数据（分配信息）装载
                loadDistrData(dataMap, grandNode);
                pressList.add(node);
            } else {
                // 2.2 基本信息已经存在，开始向下划分，判断第二层数据
                boolean addChild = true;
                UploadNode childNode = null;
                for (UploadNode exitNode : node.children) {
                    // 3. 第二层数据判断——时间区间是否已经存在，若未存在，则判定为新的时间区间划分；若已存在，则进行下一层信息的校验
                    if (StringUtils.isNotBlank(exitNode.value.get("起始日期"))
                            && exitNode.value.get("起始日期").equals(dataMap.get("起始日期"))
                            && StringUtils.isNotBlank(exitNode.value.get("结束日期"))
                            && exitNode.value.get("结束日期").equals(dataMap.get("结束日期"))) {
                        addChild = false;
                        childNode = exitNode;
                        break;
                    }
                }
                // 3.1 新的时间区间，将所有下层数据装载
                if (addChild) {
                    // 第二层数据（分配时间区间）装载
                    childNode = new UploadNode();
                    if (StringUtils.isBlank(dataMap.get("起始日期"))) {
                        throw new RuntimeException("第" + index + "行，起始日期不能为空");
                    }
                    if (StringUtils.isBlank(dataMap.get("结束日期"))) {
                        throw new RuntimeException("第" + index + "行，结束日期不能为空");
                    }
                    loadTimeData(dataMap, node, childNode);

                    // 第三层数据（分配起止金额区间）装载
                    UploadNode grandNode = new UploadNode();
                    String allocType = getAllocType(dataMap, index);
                    grandNode.value.put("分配类型", allocType);
                    loadAmtData(dataMap, childNode, grandNode);

                    // 第四层数据（分配信息）装载
                    loadDistrData(dataMap, grandNode);
                } else {
                    // 3.2 时间区间已经存在，开始向下划分，判断第三层数据
                    boolean addGrand = true;
                    UploadNode grandNode = null;
                    // 4. 第三层数据判断——金额区间是否已经存在，若未存在，则判定为新的金额区间划分；若已存在，直接保存分配信息
                    for (UploadNode exitNode : childNode.children) {
                        if (StringUtils.isNotBlank(exitNode.value.get("起始金额"))
                                && exitNode.value.get("起始金额").equals(dataMap.get("起始金额"))
                                && StringUtils.isNotBlank(exitNode.value.get("结束金额"))
                                && exitNode.value.get("结束金额").equals(dataMap.get("结束金额"))) {
                            addGrand = false;
                            grandNode = exitNode;
                            break;
                        }
                    }
                    // 4.1 新的金额区间，装载金额区间和分配信息数据。
                    if (addGrand) {
                        grandNode = new UploadNode();
                        String allocType = getAllocType(dataMap, index);
                        grandNode.value.put("分配类型", allocType);
                        // 业绩分配类型分为金额、比例、金额比例并用三种。当根据比例进行分配时，金额区间可能为空，此时第三层金额数据可不装载，直接装载分配信息数据
                        if (!allocType.equals(DistributionConstants.ALLOC_TYPE.RATE.toString())) {
                            // 第三层数据（分配起止金额区间）装载
                            loadAmtData(dataMap, childNode, grandNode);
                        }
                    }
                    // 5.装载第四层数据（分配信息）
                    loadDistrData(dataMap, grandNode);
                }
            }
        }
    }

    /**
     * 装载时间区间数据
     *
     * @param dataMap   数据
     * @param node      上一节点
     * @param childNode 数据装载节点
     * @author weixy6
     * @date 2022/6/2
     */
    private void loadTimeData(Map<String, String> dataMap, UploadNode node, UploadNode childNode) {
        childNode.value.put("起始日期", dataMap.get("起始日期"));
        childNode.value.put("结束日期", dataMap.get("结束日期"));
        node.children.add(childNode);
    }

    /**
     * 装载金额区间数据
     *
     * @param dataMap   数据
     * @param childNode 上一节点
     * @param grandNode 数据装载节点
     * @author weixy6
     * @date 2022/6/2
     */
    private void loadAmtData(Map<String, String> dataMap, UploadNode childNode, UploadNode grandNode) {
        grandNode.value.put("起始金额", dataMap.get("起始金额"));
        grandNode.value.put("结束金额", dataMap.get("结束金额"));
        childNode.children.add(grandNode);
    }

    /**
     * 装载分配信息数据
     *
     * @param dataMap 数据
     * @param node    上一节点
     * @author weixy6
     * @date 2022/6/2
     */
    private void loadDistrData(Map<String, String> dataMap, UploadNode node) {
        UploadNode fourthNode = new UploadNode();
        fourthNode.value.put("客户经理编号", dataMap.get("客户经理编号"));
        fourthNode.value.put("客户经理名称", dataMap.get("客户经理名称"));
        fourthNode.value.put("业绩分配比例(%)", dataMap.get("业绩分配比例(%)"));
        node.children.add(fourthNode);
    }

    /**
     * 贷款数据校验和装载.
     * <p>使用{@link cn.com.yusys.yusp.uimp.distribution.service.UploadNode}类型分层装载数据，<br>
     * value属性存储该层信息，children属性存储下一层信息；<br>
     * 目前贷款业务的装载模式为：<br>
     * 第一层value存储贷款基本信息；<br>
     * 第二层存储时间区间信息；<br>
     * 最后一层存储分配的具体信息，包含分配的客户经理编号和名称、分配的比例</p>
     *
     * @param dataList  数据列表
     * @param pressList 装载Node
     * @author weixy6
     * @date 2022/6/2
     */
    private void deptLoanDataVerifyNLoad(List<Map<String, String>> dataList, List<UploadNode> pressList) {
        UploadNode node = null;
        int index = 1;
        for (Map<String, String> dataMap : dataList) {
            index++;
            String ID = dataMap.get("ID");
            boolean add = true;
            // 1. 第一层数据判断——ID是否已经存在，若未存在，则判定为新的一条贷款数据；若已存在，则进行下一层信息的校验
            for (UploadNode exitNode : pressList) {
                if (StringUtils.isNotBlank(ID) && ID.equals(exitNode.value.get("ID"))) {
                    add = false;
                    node = exitNode;
                    break;
                }
            }
            // 2.1 判断为新增的数据
            if (add) {
                if (StringUtils.isBlank(dataMap.get("起始日期"))) {
                    throw new RuntimeException("第" + index + "行，起始日期不能为空");
                }
                if (StringUtils.isBlank(dataMap.get("结束日期"))) {
                    throw new RuntimeException("第" + index + "行，结束日期不能为空");
                }
                // 第一层数据（贷款基本信息）装载
                node = new UploadNode();
                node.value.put("ID", ID);
                // 第二层数据（分配时间区间）装载
                UploadNode childNode = new UploadNode();
                loadTimeData(dataMap, node, childNode);
                // 第三层数据（分配信息）装载
                loadDistrData(dataMap, childNode);

                // 新增数据，需要添加新的装载node
                pressList.add(node);
            } else {
                // 2.2 基本信息已经存在，开始向下划分，判断第二层数据
                boolean addChild = true;
                UploadNode childNode = null;
                // 3. 第二层数据判断——时间区间是否已经存在，若未存在，则判定为新的时间区间划分；若已存在，直接装载分配信息
                for (UploadNode exitNode : node.children) {
                    if (StringUtils.isNotBlank(exitNode.value.get("起始日期"))
                            && exitNode.value.get("起始日期").equals(dataMap.get("起始日期"))
                            && StringUtils.isNotBlank(exitNode.value.get("结束日期"))
                            && exitNode.value.get("结束日期").equals(dataMap.get("结束日期"))) {
                        addChild = false;
                        childNode = exitNode;
                        break;
                    }
                }
                // 3.1 新的时间区间，需要额外装载时间区间信息
                if (addChild) {
                    childNode = new UploadNode();
                    if (StringUtils.isBlank(dataMap.get("起始日期"))) {
                        throw new RuntimeException("第" + index + "行，起始日期不能为空");
                    }
                    if (StringUtils.isBlank(dataMap.get("结束日期"))) {
                        throw new RuntimeException("第" + index + "行，结束日期不能为空");
                    }
                    loadTimeData(dataMap, node, childNode);
                }
                // 4. 最后装载分配信息
                loadDistrData(dataMap, childNode);
            }
        }
    }

    /**
     * 中收数据校验和装载.
     * <p>使用{@link cn.com.yusys.yusp.uimp.distribution.service.UploadNode}类型分层装载数据，<br>
     * value属性存储该层信息，children属性存储下一层信息；<br>
     * 目前中收业务的装载模式为：<br>
     * 第一层value存储中收基本信息；<br>
     * 第二层存储分配的具体信息，包含分配的客户经理编号和名称、分配的比例</p>
     *
     * @param dataList  数据列表
     * @param pressList 装载Node
     * @author weixy6
     * @date 2022/6/2
     */
    private void midDataVerifyNLoad(List<Map<String, String>> dataList, List<UploadNode> pressList) {
        UploadNode node = null;
        int index = 1;
        double rate = 0;
        for (Map<String, String> dataMap : dataList) {
            index++;
            String ID = dataMap.get("ID");
            boolean add = true;
            for (UploadNode exitNode : pressList) {
                if (StringUtils.isNotBlank(ID) && ID.equals(exitNode.value.get("ID"))) {
                    add = false;
                    node = exitNode;
                    break;
                }
            }
            if (add) {
                if (index > 2 && rate != 100) {
                    throw new RuntimeException("第" + index + "行，比例错误");
                }
                node = new UploadNode();
                node.value.put("ID", ID);
                UploadNode childNode = new UploadNode();
                String managerID = dataMap.get("客户经理编号");
                // 2022/6/14 weixy6 业绩分配的分配对象由客户经理修改为全行的职员
                Map<String, Object> manager = pmaMidInfoService.selectUser(managerID);
                if (manager == null || StringUtils.isBlank((String) manager.get("userId"))) {
                    throw new RuntimeException("第" + index + "行，该职员信息不存在");
                }
                childNode.value.put("客户经理编号", dataMap.get("客户经理编号"));
                childNode.value.put("客户经理名称", manager.get("userName").toString());
                rate = Double.parseDouble(dataMap.get("业绩分配比例(%)"));
                if (rate > 100 || rate <= 0) {
                    throw new RuntimeException("第" + index + "行，比例错误");
                }
                childNode.value.put("业绩分配比例(%)", dataMap.get("业绩分配比例(%)"));
                node.children.add(childNode);
                pressList.add(node);
            } else {
                UploadNode childNode = new UploadNode();
                childNode.value.put("客户经理编号", dataMap.get("客户经理编号"));
                childNode.value.put("客户经理名称", dataMap.get("客户经理名称"));
                rate += Integer.parseInt(dataMap.get("业绩分配比例(%)"));
                if (rate > 100 || rate <= 0) {
                    throw new RuntimeException("第" + index + "行，比例错误");
                }
                childNode.value.put("业绩分配比例(%)", dataMap.get("业绩分配比例(%)"));
                node.children.add(childNode);
            }
        }
        if (rate != 100) {
            throw new RuntimeException("第" + index + "行，比例错误");
        }
    }

}
