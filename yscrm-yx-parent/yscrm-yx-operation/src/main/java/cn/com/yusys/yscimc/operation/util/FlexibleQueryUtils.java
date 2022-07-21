package cn.com.yusys.yscimc.operation.util;

import cn.com.yusys.yscimc.operation.domain.OcrmFCiFqDbcol;
import cn.com.yusys.yscimc.operation.domain.OcrmFCiFqObj;
import cn.com.yusys.yscimc.operation.domain.OcrmFCiFqRelation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 灵活查询SQL生成器，单态模式，线程非安全
 *
 * @author wangmk1
 * @since 2015-11-25
 */
public class FlexibleQueryUtils {
    private final static Logger logger = LoggerFactory.getLogger(FlexibleQueryUtils.class);
    /**
     * 条件数据操作符
     */
    public static final Map<String, String> conditonOperates = new HashMap<String, String>();

    static {
        conditonOperates.put("0000", "包含");
        conditonOperates.put("0001", "大于");
        conditonOperates.put("0002", "等于");
        conditonOperates.put("0003", "小于");
        conditonOperates.put("0004", "大于等于");
        conditonOperates.put("0005", "小于等于");
        conditonOperates.put("0006", "不等于");
    }

    public static final String OP_INCLUDE = "0000";
    public static final String OP_LARGER = "0001";
    public static final String OP_EQUAL = "0002";
    public static final String OP_SMALLER = "0003";
    public static final String OP_E_LARGER = "0004";
    public static final String OP_E_SAMLLER = "0005";
    public static final String OP_NO_EQUAL = "0006";


    /**
     * 连表类型
     */
    public static final Map<String, String> joinType = new HashMap<String, String>();

    static {
        joinType.put("left", "LEFT JOIN");
        joinType.put("right", "RIGHT JOIN");
        joinType.put("inner", "INNER JOIN");
    }

    /**
     * 客户基本信息表
     */
    public static final String CUST_MAIN_INFO_TABLE = "ACRM_F_CI_CUSTOMER";

    /**
     * 条件连接符
     */
    public static final String OR = "OR";
    public static final String AND = "AND";

    public static final String LEFTBRACKET = "(";
    public static final String RIGHTBRACKET = ")";

    /**
     * 数据类型列表
     */
    public static final List<String> dataTypes = new ArrayList<String>();

    static {
        dataTypes.add("VARCHAR2");
        dataTypes.add("DATE");
        dataTypes.add("NUMBER");
        dataTypes.add("DECIMAL");
        dataTypes.add("INTEGER");
        dataTypes.add("VARCHAR");
        dataTypes.add("CHAR");
        dataTypes.add("BIGINT");
        dataTypes.add("TIMESTMP");
    }


    /**
     * 1-汇总数值
     * 2-汇总数量
     * 3-最大值
     * 4-最小值
     * 5-总值
     * 6-平均值
     * 汇总类型列表
     */
    public static final List<String> sumTypes = new ArrayList<String>();

    static {
        sumTypes.add("1");
        sumTypes.add("2");
        sumTypes.add("3");
        sumTypes.add("4");
        sumTypes.add("5");
        sumTypes.add("6");
        sumTypes.add("7");
    }

    /**
     * 排序类型
     */
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";
    // 分隔符
    public static final String seporator = ",";

    /**
     * 创建表关联语句
     *
     * @param datasets    ：表关联涉及的datasets对象列表
     * @param relations   ： 表关联需要的关联对象列表
     * @param joinColumns ： 表关联涉及的列表列对象
     * @return 返回连表的语句，同时返填datasets中数据里notes属性，该属性存储本次查询中的表别名
     */
    public static final String createTableJoin(List<OcrmFCiFqObj> leftTabs,
                                               List<OcrmFCiFqRelation> relations, List<OcrmFCiFqDbcol> joinColumns) {
        //客户主表别名固定为custinfo
        String mainTable = leftTabs.get(0).getTableName() + " " + leftTabs.get(0).getAlias();
        for (int i = 0; i < joinColumns.size(); i++) {
            try {
                OcrmFCiFqDbcol ds = joinColumns.get(i);
                if (ds.getDbtableName().equals(leftTabs.get(0).getTableName())) {
                    //mainTable+=ds.getAlias();
                    continue;
                }
                OcrmFCiFqRelation re = getRelationsByTable(relations, ds);
                logger.info("DbtableName==" + ds.getDbtableName());
                mainTable += " LEFT JOIN " + ds.getDbtableName() + " " + ds.getAlias()
                        + " ON " + re.getJoinLeftAlias() + ".";//左表别名从设置关系表中取出
                OcrmFCiFqDbcol leftColumn = getJoinColumnById(joinColumns,
                        re.getJoinLeftColName());
                OcrmFCiFqDbcol rightColumn = getJoinColumnById(joinColumns,
                        re.getJoinRightColName());
                mainTable += leftColumn.getColNameE() + " = ";
                mainTable += ds.getAlias() + "." + rightColumn.getColNameE();
//				mainTable +=" LEFT JOIN OCRM_F_CI_ADMIT_BELONG b on " + re.getJoinLeftAlias()+ "."
//				+leftColumn.getColNameE() + " = "+"b.cust_id ";
            } catch (Exception e) {
                continue;
            }
        }

        return mainTable;
    }

    /**
     * 创建查询SELECT 子句
     *
     * @param datasets  ：查询结果涉及的数据集对象
     * @param dscs      ： 查询结果列对象
     * @param jaColumns ：结果列属性，用于别名生成
     * @return
     */
    private static final String createSelectColumns(List<OcrmFCiFqObj> lefttabs,
                                                    List<OcrmFCiFqDbcol> dscs, JSONArray jaColumns) {

        StringBuilder namesb = new StringBuilder();
        String CUST_NAME_BASE = lefttabs.get(0).getAlias() + ".CUST_NAME";
        namesb.append("  case  when length(" + CUST_NAME_BASE + ") = 2 then subStr(" + CUST_NAME_BASE + ",0,1) || '*' ");
        namesb.append("when length(" + CUST_NAME_BASE + ") = 3 then subStr(" + CUST_NAME_BASE + ",0,1) || '*' || subStr(" + CUST_NAME_BASE + ",3,4) ");
        namesb.append("when length(" + CUST_NAME_BASE + ") = 4 then subStr(" + CUST_NAME_BASE + ",0,1) || '**' || subStr(" + CUST_NAME_BASE + ",4, 5 ) ");
        namesb.append("when length(" + CUST_NAME_BASE + ") = 5 then subStr(" + CUST_NAME_BASE + ",0,2) || '**' || subStr(" + CUST_NAME_BASE + ",4, 6 ) ");
        namesb.append("when length(" + CUST_NAME_BASE + ") > 5 then subStr(" + CUST_NAME_BASE + ",0, length(" + CUST_NAME_BASE + ") /2-2) || '****' || subStr(" + CUST_NAME_BASE + ",length(" + CUST_NAME_BASE + ") /2+3, length(" + CUST_NAME_BASE + ") )");
        namesb.append("else " + CUST_NAME_BASE + " ");
        namesb.append(" END ");

        String select = lefttabs.get(0).getAlias() + ".CUST_ID as CUST_ID_BASE ," + namesb.toString() + " as CUST_NAME_BASE,";
        if (!dscs.isEmpty()) {
            for (int i = 0; i < dscs.size(); i++) {
                JSONObject jo = (JSONObject) jaColumns.get(i);
                Long columnId = jo.getLong("columnId");
                OcrmFCiFqDbcol dsc = getJoinColumnById(dscs, columnId);
                //脱敏处理begin
                StringBuilder sb = new StringBuilder();
                if (dsc.getNoSensi() != null || !"".equals(dsc.getNoSensi())) {//脱敏处理
                    if ("1".equals(dsc.getNoSensi())) {//客户名称 联系方式
                        String CUST_NAME = dsc.getAlias() + "." + dsc.getColNameE();
                        sb.append("  case  when length(" + CUST_NAME + ") = 2 then subStr(" + CUST_NAME + ",0,1) || '*' ");
                        sb.append("when length(" + CUST_NAME + ") = 3 then subStr(" + CUST_NAME + ",0,1) || '*' || subStr(" + CUST_NAME + ",3,4) ");
                        sb.append("when length(" + CUST_NAME + ") = 4 then subStr(" + CUST_NAME + ",0,1) || '**' || subStr(" + CUST_NAME + ",4, 5 ) ");
                        sb.append("when length(" + CUST_NAME + ") = 5 then subStr(" + CUST_NAME + ",0,2) || '**' || subStr(" + CUST_NAME + ",4, 6 ) ");
                        sb.append("when length(" + CUST_NAME + ") > 5 then subStr(" + CUST_NAME + ",0, length(" + CUST_NAME + ") /2-2) || '****' || subStr(" + CUST_NAME + ",length(" + CUST_NAME + ") /2+3, length(" + CUST_NAME + ") )");
                        sb.append("else " + CUST_NAME + " ");
                        sb.append(" END ");
                    } else if ("2".equals(dsc.getNoSensi())) {//证件号码
                        sb.append("subStr(" + dsc.getAlias() + "." + dsc.getColNameE() + ", 0, length(" + dsc.getAlias() + "." + dsc.getColNameE() + ") - 4) || '****'");
                    } else if ("3".equals(dsc.getNoSensi())) {//联系地址
                        String CUST_ADDR = dsc.getAlias() + "." + dsc.getColNameE();
                        sb.append("  case  when length(" + CUST_ADDR + ") = 2 then subStr(" + CUST_ADDR + ",0,1) || '*' ");
                        sb.append("when length(" + CUST_ADDR + ") = 3 then subStr(" + CUST_ADDR + ",0,1) || '*' || subStr(" + CUST_ADDR + ",3,4) ");
                        sb.append("when length(" + CUST_ADDR + ") = 4 then subStr(" + CUST_ADDR + ",0,1) || '**' || subStr(" + CUST_ADDR + ",4,5 ) ");
                        sb.append("when length(" + CUST_ADDR + ") = 5 then subStr(" + CUST_ADDR + ",0,2) || '***' || subStr(" + CUST_ADDR + ",4,6 ) ");
                        sb.append("when length(" + CUST_ADDR + ") > 5 then subStr(" + CUST_ADDR + ",0,5) || '****' ");
                        sb.append("else " + CUST_ADDR + " ");
                        sb.append(" END ");
                    } else {
                        sb.append(dsc.getAlias() + "." + dsc.getColNameE());
                    }
                }
                //脱敏处理end
                String columnName = sb.toString()
                        + " AS " + dsc.getColNameE() + "_"
                        + jo.getString("columnTotle");
                if (i == 0) {
                    select += columnName;
                } else {
                    select += "," + columnName;
                }
            }
        } else {
            select = " custinfo.CUST_ID as CUST_ID_BASE ,custinfo.CUST_NAME as CUST_NAME_BASE ";
        }
        return select;
    }


    private static final String createSelectColumnsexportdata(List<OcrmFCiFqObj> lefttabs,
                                                              List<OcrmFCiFqDbcol> dscs, JSONArray jaColumns) {
        String select = "";
        if (!dscs.isEmpty()) {
            for (int i = 0; i < dscs.size(); i++) {
                JSONObject jo = (JSONObject) jaColumns.get(i);
                Long columnId = jo.getLong("columnId");
                OcrmFCiFqDbcol dsc = getJoinColumnById(dscs, columnId);
                String columnName = dsc.getAlias() + "." + dsc.getColNameE();
                if (i == 0) {
                    select += columnName;
                } else {
                    select += "," + columnName;
                }
            }
        }
        return select;
    }

    /**
     * 创建查询SELECT 子句
     *
     * @param datasets    ：查询结果涉及的数据集对象
     * @param jaColumns   ：结果列属性，用于别名生成
     * @param groupParams ：分组参数
     * @param sumParams   (属性 ：sumColumns,sumTypes,sumNames)
     *                    ：统计参数
     * @return 根据分组参数和统计参数创建SELECT 子句
     */
    public static final String createSelectColumns(List<OcrmFCiFqObj> lefttabs,
                                                   List<OcrmFCiFqDbcol> dscs, JSONArray jaColumns, String groupParams,
                                                   List sumParams) {
        String sumColumns = "";
        String sumTypes = "";
        if (null == groupParams || "".equals(groupParams)) {
            return createSelectColumns(lefttabs, dscs, jaColumns);
        } else {
            String countSelects = "";
            JSONArray sum = JSONArray.fromObject(sumParams);
            for (Object oa : sum) {
                JSONArray joa = JSONArray.fromObject(oa);
                for (Object o : joa) {
                    JSONObject jo = (JSONObject) o;
                    sumColumns = jo.getString("sumColumns");
                    sumTypes = jo.getString("sumTypes");
                }
            }

            for (int i = 0; i < dscs.size(); i++) {
                JSONObject jo = (JSONObject) jaColumns.get(i);
                Long columnId = jo.getLong("columnId");
                OcrmFCiFqDbcol dsc = getJoinColumnById(dscs, columnId);

                logger.info("Alias===" + dsc.getAlias());
                if (groupParams.indexOf(dsc.getId() + "") >= 0) {
                    StringBuilder sb = new StringBuilder();
                    //脱敏处理begin
                    if (dsc.getNoSensi() != null || !"".equals(dsc.getNoSensi())) {//脱敏处理
                        if ("1".equals(dsc.getNoSensi())) {//客户名称 联系方式
                            String CUST_NAME = dsc.getAlias() + "." + dsc.getColNameE();
                            sb.append("  case  when length(" + CUST_NAME + ") = 2 then subStr(" + CUST_NAME + ",0,1) || '*' ");
                            sb.append("when length(" + CUST_NAME + ") = 3 then subStr(" + CUST_NAME + ",0,1) || '*' || subStr(" + CUST_NAME + ",3,4) ");
                            sb.append("when length(" + CUST_NAME + ") = 4 then subStr(" + CUST_NAME + ",0,1) || '**' || subStr(" + CUST_NAME + ",4, 5 ) ");
                            sb.append("when length(" + CUST_NAME + ") = 5 then subStr(" + CUST_NAME + ",0,2) || '**' || subStr(" + CUST_NAME + ",4, 6 ) ");
                            sb.append("when length(" + CUST_NAME + ") > 5 then subStr(" + CUST_NAME + ",0, length(" + CUST_NAME + ") /2-2) || '****' || subStr(" + CUST_NAME + ",length(" + CUST_NAME + ") /2+3, length(" + CUST_NAME + ") )");
                            sb.append("else " + CUST_NAME + " ");
                            sb.append(" END ");
                        } else if ("2".equals(dsc.getNoSensi())) {//证件号码
                            sb.append("subStr(" + dsc.getAlias() + "." + dsc.getColNameE() + ", 0, length(" + dsc.getAlias() + "." + dsc.getColNameE() + ") - 4) || '****'");
                        } else if ("3".equals(dsc.getNoSensi())) {//联系地址
                            String CUST_ADDR = dsc.getAlias() + "." + dsc.getColNameE();
                            sb.append("  case  when length(" + CUST_ADDR + ") = 2 then subStr(" + CUST_ADDR + ",0,1) || '*' ");
                            sb.append("when length(" + CUST_ADDR + ") = 3 then subStr(" + CUST_ADDR + ",0,1) || '*' || subStr(" + CUST_ADDR + ",3,4) ");
                            sb.append("when length(" + CUST_ADDR + ") = 4 then subStr(" + CUST_ADDR + ",0,1) || '**' || subStr(" + CUST_ADDR + ",4,5 ) ");
                            sb.append("when length(" + CUST_ADDR + ") = 5 then subStr(" + CUST_ADDR + ",0,2) || '***' || subStr(" + CUST_ADDR + ",4,6 ) ");
                            sb.append("when length(" + CUST_ADDR + ") > 5 then subStr(" + CUST_ADDR + ",0,5) || '****' ");
                            sb.append("else " + CUST_ADDR + " ");
                            sb.append(" END ");
                        } else {
                            sb.append(dsc.getAlias() + "." + dsc.getColNameE());
                        }
                    }
                    //脱敏处理end
                    if (countSelects.equals("")) {
                        countSelects += sb.toString()
                                + " AS " + dsc.getColNameE() + "_"
                                + jo.getString("columnTotle");
                    } else {
                        countSelects += seporator + sb.toString() + " AS "
                                + dsc.getColNameE() + "_"
                                + jo.getString("columnTotle");
                    }
                }

                if (sumTypes == null || "".equals(sumTypes)) {
                    if (sumColumns.indexOf(dsc.getId() + "") >= 0) {
                        if (countSelects.equals("")) {
                            countSelects += getCountColumn(dsc, jo.getString("columnTotle"));
                        } else {
                            countSelects += seporator
                                    + getCountColumn(dsc, jo.getString("columnTotle"));
                        }
                    }
                } else {
                    if (sumColumns.indexOf(dsc.getId() + "") >= 0) {
                        //sumColumns转数组，判断出dsc.getId()的位置，从而获取sumType在sumTypes中的位置
                        String[] sumArr = sumColumns.split(",");
                        String[] typeArr = sumTypes.split(",");
                        for (int id = 0; id < sumArr.length; id++) {
                            if (sumArr[id].equals(dsc.getId() + "")) {
                                if (countSelects.equals("")) {
                                    countSelects += getCountColumn(dsc,
                                            jo.getString("columnTotle"), typeArr[id]);
                                } else {
                                    countSelects += seporator
                                            + getCountColumn(dsc, jo.getString("columnTotle"), typeArr[id]);
                                }
                            }
                        }
                    }
                }
            }
            return countSelects;
        }
    }

    /**
     * 创建查询SELECT 子句  导出使用不做脱敏处理
     *
     * @param datasets    ：查询结果涉及的数据集对象
     * @param jaColumns   ：结果列属性，用于别名生成
     * @param groupParams ：分组参数
     * @param sumParams   (属性 ：sumColumns,sumTypes,sumNames)
     *                    ：统计参数
     * @return 根据分组参数和统计参数创建SELECT 子句
     */
    public static final String createSelectColumnsexport(List<OcrmFCiFqObj> lefttabs,
                                                         List<OcrmFCiFqDbcol> dscs, JSONArray jaColumns, String groupParams,
                                                         List sumParams) {
        String sumColumns = "";
        String sumTypes = "";
        if (null == groupParams || "".equals(groupParams)) {
            return createSelectColumnsexportdata(lefttabs, dscs, jaColumns);
        } else {
            String countSelects = "";
            JSONArray sum = JSONArray.fromObject(sumParams);
            for (Object oa : sum) {
                JSONArray joa = JSONArray.fromObject(oa);
                for (Object o : joa) {
                    JSONObject jo = (JSONObject) o;
                    sumColumns = jo.getString("sumColumns");
                    sumTypes = jo.getString("sumTypes");
                }
            }

            for (int i = 0; i < dscs.size(); i++) {
                JSONObject jo = (JSONObject) jaColumns.get(i);
                Long columnId = jo.getLong("columnId");
                OcrmFCiFqDbcol dsc = getJoinColumnById(dscs, columnId);

                logger.info("Alias===" + dsc.getAlias());
                if (groupParams.indexOf(dsc.getId() + "") >= 0) {
                    if (countSelects.equals("")) {
                        countSelects += dsc.getAlias() + "." + dsc.getColNameE()
                                + " AS " + dsc.getColNameE() + "_"
                                + jo.getString("columnTotle");
                    } else {
                        countSelects += seporator + dsc.getAlias() + "."
                                + dsc.getColNameE() + " AS "
                                + dsc.getColNameE() + "_"
                                + jo.getString("columnTotle");
                    }
                }

                if (sumTypes == null || "".equals(sumTypes)) {
                    if (sumColumns.indexOf(dsc.getId() + "") >= 0) {
                        if (countSelects.equals("")) {
                            countSelects += getCountColumn(dsc, jo.getString("columnTotle"));
                        } else {
                            countSelects += seporator
                                    + getCountColumn(dsc, jo.getString("columnTotle"));
                        }
                    }
                } else {
                    if (sumColumns.indexOf(dsc.getId() + "") >= 0) {
                        //sumColumns转数组，判断出dsc.getId()的位置，从而获取sumType在sumTypes中的位置
                        String[] sumArr = sumColumns.split(",");
                        String[] typeArr = sumTypes.split(",");
                        for (int id = 0; id < sumArr.length; id++) {
                            if (sumArr[id].equals(dsc.getId() + "")) {
                                if (countSelects.equals("")) {
                                    countSelects += getCountColumn(dsc,
                                            jo.getString("columnTotle"), typeArr[id]);
                                } else {
                                    countSelects += seporator
                                            + getCountColumn(dsc, jo.getString("columnTotle"), typeArr[id]);
                                }
                            }
                        }
                    }
                }
            }
            return countSelects;
        }
    }

    private static String getCountColumn(OcrmFCiFqDbcol dsc,
                                         String totle, String sumType) {
        //根据sumType匹配适合的汇总类型
        //		1-汇总数值
        //		2-汇总数量
        //		3-最大值
        //		4-最小值
        //		5-总值
        //		6-平均值
        String item = "";
        if (sumTypes.indexOf(sumType) > -1) {
            switch (sumTypes.indexOf(sumType) + 1) {
                case 1:
                    item = "COUNT(" + dsc.getAlias() + "." + dsc.getColNameE()
                            + ") AS " + dsc.getColNameE() + "_" + totle + "_SUM1";
                    break;
                case 2:
                    item = "COUNT(*) AS " + dsc.getColNameE() + "_" + totle + "_SUM2";
                    break;
                case 3:
                    item = "cast( MAX(" + dsc.getAlias() + "." + dsc.getColNameE()
                            + " ) as decimal(18,0) ) AS " + dsc.getColNameE() + "_" + totle + "_SUM3";
                    break;
                case 4:
                    item = "cast( MIN(" + dsc.getAlias() + "." + dsc.getColNameE()
                            + ") as decimal(18,0) ) AS " + dsc.getColNameE() + "_" + totle + "_SUM4";
                    break;
                case 5:
                    item = "cast( SUM(" + dsc.getAlias() + "." + dsc.getColNameE()
                            + ") as decimal(18,2) ) AS " + dsc.getColNameE() + "_" + totle + "_SUM5";
                    break;
                case 6:
                    item = "cast( AVG(" + dsc.getAlias() + "." + dsc.getColNameE()
                            + ") as decimal(18,2) ) AS " + dsc.getColNameE() + "_" + totle + "_SUM6";
                    break;
                default:
                    item = "COUNT(" + dsc.getAlias() + "." + dsc.getColNameE()
                            + ") AS " + dsc.getColNameE() + "_" + totle + "_SUM1";
                    break;
            }
        }
        return item;
    }

    /**
     * 创建查询条件语句
     *
     * @param ja              ： 查询条件JSON对象
     * @param datasets        ：查询条件涉及的数据集对象
     * @param conditonsColumn ：查询条件涉及的列对象
     * @return
     */
    public static final String createWhereColumns(JSONArray condi, List<OcrmFCiFqDbcol> conditonsColumn) {
        String condition = "";
        for (Object sc : condi) {
            //JSONArray scd = (JSONArray) sc;
            JSONArray scd = JSONArray.fromObject(sc);
            //添加外连接符
            String outerJoin = ((JSONObject) scd.get(0)).getString("SS_COL_GJOIN");
            if (!condition.equals("")) {
                if ("or".equals(outerJoin)) {
                    condition += " " + OR + " ";
                } else if ("and".equals(outerJoin)) {
                    condition += " " + AND + " ";
                }
            }
            condition += LEFTBRACKET;
            String innerCondi = "";
            for (Object scc : scd) {
                JSONObject sccd = (JSONObject) scc;
                Long columnId = sccd.getLong("SS_COL_ITEM");
                String op = sccd.getString("SS_COL_OP");
                String value = sccd.getString("SS_COL_VALUE");
                String innerJoin = sccd.getString("SS_COL_JOIN");

                OcrmFCiFqDbcol dsc = getJoinColumnById(conditonsColumn, columnId);
                String conditionValue = getConditonString(op, value, dsc);
                if (null == conditionValue) {
                    continue;
                }
                if (!innerCondi.equals("")) {
                    if ("or".equals(innerJoin)) {
                        innerCondi += " " + OR + " ";
                    } else if ("and".equals(innerJoin)) {
                        innerCondi += " " + AND + " ";
                    }
                }
                innerCondi += " " + dsc.getAlias() + "." + dsc.getColNameE() + conditionValue;
            }
            condition += innerCondi;
            condition += RIGHTBRACKET;
        }
        return condition;
    }

    /**
     * 创建排序ORDER BY 子句，
     *
     * @param datasets  ：涉及数据集
     * @param dscs      ：涉及列
     * @param jaColumns ：结果集数据属性，取排序类型
     * @return
     */
    public static String createOrderSQL(
            List<OcrmFCiFqDbcol> dscs, JSONArray jaColumns) {

        String returns = "";
        for (Object o : jaColumns) {
            JSONObject jo = (JSONObject) o;
            OcrmFCiFqDbcol dsc = getJoinColumnById(dscs, jo.getLong("columnId"));
            int orderType = 0;
            if (!"".equals(jo.getString("sortType")) && jo.getString("sortType") != null) {
                String orderTypes = jo.getString("sortType");
                orderType = Integer.parseInt(orderTypes);
            }
            String order = "";
            switch (orderType) {
                case 0:
                    break;
                case 1:
                    order = dsc.getAlias() + "." + dsc.getColNameE() + " " + ASC;
                    break;
                case 2:
                    order = dsc.getAlias() + "." + dsc.getColNameE() + " " + DESC;
                    break;
                default:
                    break;
            }
            if (order.equals("")) {
                continue;
            }

            if (returns.equals("")) {
                returns = order;
            } else {
                returns += "," + order;
            }
        }

        return returns;
    }

    /**
     * 创建分组GROUP BY 子句
     *
     * @param datasets    ：涉及数据集
     * @param dscs        ： 涉及列
     * @param groupParams ：分组参数
     * @return
     */
    public static final String createGroupByColumns(
            List<OcrmFCiFqDbcol> dscs, String groupParams) {

        if (null == groupParams || groupParams.equals("")) {
            return "";
        }

        String groupBy = "";
        String[] groupParamArray = groupParams.split(seporator);
        for (int i = 0; i < groupParamArray.length; i++) {
            OcrmFCiFqDbcol dsc = getJoinColumnById(dscs,
                    Long.valueOf(groupParamArray[i]));
            String columnName = dsc.getAlias() + "." + dsc.getColNameE();
            if (i == 0) {
                groupBy += columnName;
            } else {
                groupBy += "," + columnName;
            }
        }

        return groupBy;
    }

    /**
     * 创建一个条件子句
     *
     * @param op    ：操作符
     * @param value ：条件值
     * @param dsc   ：涉及列
     * @return
     */
    private static String getConditonString(String op, String value,
                                            OcrmFCiFqDbcol dsc) {

        String columnType = dsc.getColType().trim();//加上trim，容错处理

        String result = "";
        logger.info("OP_INCLUDE==" + OP_INCLUDE);

        logger.info("OP==" + op);
        if (op.equals(OP_INCLUDE)) {

            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " LIKE '%" + value + "%'";
                    break;
                case 1:
                case 2:
                case 8:
                    return null;
                case 3:
                    return null;
                case 4:
                    return null;
                case 7:
                    return null;
                default:
            }
        } else if (op.equals(OP_LARGER)) {
            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " > " + "'" + value + "'";
                    break;
                case 1:
                case 8:
                    result += " > to_date('" + value + "','YYYY-MM-DD')";
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    result += " > " + value;
                    break;
                default:
            }
        } else if (op.equals(OP_E_SAMLLER)) {
            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " <= " + "'" + value + "'";
                    break;
                case 1:
                case 8:
                    result += " <= to_date('" + value + "','YYYY-MM-DD')";
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    result += " <= " + value;
                    break;
                default:
            }
        } else if (op.equals(OP_SMALLER)) {
            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " < " + "'" + value + "'";
                    break;
                case 1:
                case 8:
                    result += " < to_date('" + value + "','YYYY-MM-DD')";
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    result += " < " + value;
                    break;
                default:
            }

        } else if (op.equals(OP_E_LARGER)) {

            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " >= " + "'" + value + "'";
                    break;
                case 1:
                case 8:
                    result += " >= to_date('" + value + "','YYYY-MM-DD')";
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    result += " >= " + value;
                    break;
                default:
            }
        } else if (op.equals(OP_NO_EQUAL)) {

            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " <> " + "'" + value + "'";
                    break;
                case 1:
                case 8:
                    result += " <> to_date('" + value + "','YYYY-MM-DD')";
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    result += " <> " + value;
                    break;
                default:
            }
        } else {
            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " = '" + value + "'";
                    break;
                case 1:
                case 8:
                    result += " = to_date('" + value + "','YYYY-MM-DD')";
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    result += " = " + value;
                    break;
                default:
            }
        }
        return result;
    }

    /**
     * 创建一个条件子句
     *
     * @param op    ：操作符
     * @param value ：条件值
     * @param dsc   ：涉及列
     * @return
     */
    public static String getConditonString(String op, String value,
                                           String dsc) {

        String columnType = dsc.trim();//加上trim，容错处理

        String result = "";
        logger.info("OP_INCLUDE==" + OP_INCLUDE);

        logger.info("OP==" + op);
        if (op.equals(OP_INCLUDE)) {

            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " LIKE '%" + value + "%'";
                    break;
                case 1:
                case 2:
                case 8:
                    return null;
                case 3:
                    return null;
                case 4:
                    return null;
                case 7:
                    return null;
                default:
            }
        } else if (op.equals(OP_LARGER)) {
            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " > " + "'" + value + "'";
                    break;
                case 1:
                case 8:
                    result += " > to_date('" + value + "','YYYY-MM-DD')";
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    result += " > " + value;
                    break;
                default:
            }
        } else if (op.equals(OP_E_SAMLLER)) {
            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " <= " + "'" + value + "'";
                    break;
                case 1:
                case 8:
                    result += " <= to_date('" + value + "','YYYY-MM-DD')";
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    result += " <= " + value;
                    break;
                default:
            }
        } else if (op.equals(OP_SMALLER)) {
            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " < " + "'" + value + "'";
                    break;
                case 1:
                case 8:
                    result += " < to_date('" + value + "','YYYY-MM-DD')";
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    result += " < " + value;
                    break;
                default:
            }

        } else if (op.equals(OP_E_LARGER)) {

            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " >= " + "'" + value + "'";
                    break;
                case 1:
                case 8:
                    result += " >= to_date('" + value + "','YYYY-MM-DD')";
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    result += " >= " + value;
                    break;
                default:
            }
        } else if (op.equals(OP_NO_EQUAL)) {

            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " <> " + "'" + value + "'";
                    break;
                case 1:
                case 8:
                    result += " <> to_date('" + value + "','YYYY-MM-DD')";
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    result += " <> " + value;
                    break;
                default:
            }
        } else {
            switch (dataTypes.indexOf(columnType)) {
                case 6:
                case 5:
                case 0:
                    result += " = '" + value + "'";
                    break;
                case 1:
                case 8:
                    result += " = to_date('" + value + "','YYYY-MM-DD')";
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    result += " = " + value;
                    break;
                default:
            }
        }
        return result;
    }

    /**
     * 根据ID，从数组中获取该数据集
     *
     * @param datasets
     * @param id
     * @return
     */
//	private static AcrmFFqDbtable getDatasetById(List<AcrmFFqDbtable> datasets, Long id) {
//		for (AcrmFFqDbtable ds : datasets) {
//			if (ds.getId().equals(id)) {
//				return ds;
//			}
//		}
//		return null;
//	}

    /**
     * 根据数据集，获取该数据集与客户基础信息表的关联对象（OCRM_F_CI_CUST_DESC）
     *
     * @param relations
     * @param ds
     * @return
     */
    private static OcrmFCiFqRelation getRelationsByTable(
            List<OcrmFCiFqRelation> relations, OcrmFCiFqDbcol ds) {
        for (OcrmFCiFqRelation re : relations) {
            Long a = re.getJoinRightName();
            Long b = ds.getGroupId();
            Long c = re.getJoinRightColName();
            Long d = ds.getId();
            if (a.equals(b) && c.equals(d)) {
                return re;
            }
        }
        return null;
    }

    /**
     * 根据ID，从数组中获取数据列对象
     *
     * @param joinColumns
     * @param id
     * @return
     */
    private static OcrmFCiFqDbcol getJoinColumnById(
            List<OcrmFCiFqDbcol> joinColumns, Long id) {
        for (OcrmFCiFqDbcol column : joinColumns) {
            Long ids = column.getId();
            if (ids.equals(id)) {
                return column;
            }
        }
        return null;
    }

    /**
     * 根据字段类型，创建统计子句，数字型求和，字符型和日期型求个数
     *
     * @param dsc   ：列对象
     * @param ds    ：数据集
     * @param totle ：别名后缀
     * @return
     */
    private static String getCountColumn(OcrmFCiFqDbcol dsc,
                                         String totle) {
        if (dsc.getColType().trim().equals("INTEGER")
                || dsc.getColType().trim().equals("DECIMAL")
                || dsc.getColType().trim().equals("NUMBER")) {
            String item = "SUM(" + dsc.getAlias() + "." + dsc.getColNameE()
                    + ") AS " + dsc.getColNameE() + "_" + totle + "_SUM";
            return item;
        } else {
            String item = "COUNT(" + dsc.getAlias() + "." + dsc.getColNameE()
                    + ") AS " + dsc.getColNameE() + "_" + totle + "_SUM";
            return item;
        }
    }

//	public static String getAuthorityString(AuthUser auth){
//		String authority="";
//		//灵活查询授权特殊处理
//		authority=auth.getFilterString("FlexibleQueryAuthority", AuthUser.METHOD_SELECT);
//		if(!authority.isEmpty()){
//			authority="and "+authority;
//		}
//		return authority;
//	}

}
