package cn.com.yusys.yscimc.operation.service.impl;

import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yscimc.cust.group.domain.CellInfo;
import cn.com.yusys.yscimc.operation.domain.*;
import cn.com.yusys.yscimc.operation.repository.mapper.*;
import cn.com.yusys.yscimc.operation.util.FlexibleQueryUtils;
import cn.com.yusys.yusp.admin.service.MessageProviderService;
import cn.com.yusys.yusp.commons.dto.Obj;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.exception.Message;
import cn.com.yusys.yusp.commons.web.rest.exception.YuspException;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @version 1.0.0
 * @项目名称: crm-service
 * @类名称: OcrmFCiFqDbcolService
 * @类描述:
 * @功能描述: 灵活查询
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2019年01月14日
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */

@Service
public class OcrmFCiFqDbcolService extends CommonService {
    @Autowired
    private OcrmFCiFqDbcolMapper mapper;
    @Autowired
    private OcrmFCiFqScolMapper ocrmFCiFqScolMapper;
    @Autowired
    private OcrmAciFqReportMapper ocrmAciFqReportMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private MessageProviderService messageProviderService;
    private final Logger logger = LoggerFactory.getLogger(OcrmFCiFqDbcolService.class);
    @Autowired
    private OcrmFCiFqObjMapper cimpFFqObjMapper;
    @Autowired
    private OcrmAciFqGraphMapper ocrmAciFqGraphMapper;
    @Autowired
    private OcrmFCiFqRelationMapper ocrmFCiFqRelationMapper;

    @Override
    protected CommonMapper getMapper() {
        // TODO Auto-generated method stub
        return this.mapper;
    }

    /**
     * 页面初始化查询指标
     *
     * @param
     * @return
     */
    public List<OcrmFCiFqDbcol> qryCollist(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        List<OcrmFCiFqDbcol> list = mapper.qryCollist(model);
        PageHelper.clearPage();
        return list;
    }

    /**
     * 通过拼装SQL查询客户编号集合（灵活查询组件用）
     *
     * @param sql
     * @return
     */
    public List<String> getCustIdBySql(String sql) {
        return mapper.getCustIdBySql(sql);
    }

    public List<OcrmFCiFqDbcol> isExist(QueryModel model) {
        List<OcrmFCiFqDbcol> list = mapper.isExist(model);
        return list;
    }

    /**
     * 查询数据集
     *
     * @param
     * @return
     */
    public List<OcrmFCiFqDbcol> qrysetdata(QueryModel model) {
        List<OcrmFCiFqDbcol> list = mapper.qrysetdata(model);
        return list;
    }

    /**
     * 查询全部数据集
     *
     * @param
     * @return
     */
    public List<OcrmFCiFqDbcol> qryallsetdata(QueryModel model) {
        logger.info("qryallsetdata=" + model.getCondition().get("value"));
        String value = (String) model.getCondition().get("value");
        StringBuilder sb = new StringBuilder("");
        sb.append("SELECT t4.column_name AS COL_NAME_E,"
                + " t4.COMMENTS  AS COL_NAME_C,"
                + " t4.DATA_TYPE  AS COL_TYPE,"
                + " t4.DATA_LENGTH  AS COL_SIZE, "
                + " CASE "
                + "   WHEN t4.NULLABLE ='Y' "
                + "   THEN '否'    "
                + "   ELSE '是'  "
                + " END AS IS_NULL ,  "
                + " CASE   "
                + "   WHEN t4.constraint_type='P'  "
                + "   THEN '是'  "
                + "   ELSE '否'  "
                + " END AS PRIMARY_KEY_FLAG, "
                + " t4.COLUMN_ID AS COL_SORT "
                + " FROM   "
                + " (SELECT t1.comments,"
                + "   t2.*,   "
                + "   t3.CONSTRAINT_TYPE "
                + " FROM user_col_comments t1 "
                + " INNER JOIN user_tab_columns t2 "
                + " ON t1.COLUMN_NAME = t2.COLUMN_NAME  "
                + " LEFT JOIN  "
                + "   (SELECT DISTINCT coll.column_name,"
                + "     con.constraint_type  "
                + "   FROM user_constraints con, "
                + "     user_cons_columns coll "
                + "   WHERE con.constraint_name = coll.constraint_name"
                + "   AND con.constraint_type  IN('U' ,'P')"
                + "   ) t3 "
                + " ON t3.COLUMN_NAME  =t2.column_name"
                + " WHERE t2.table_name='"
                + value + "'"
                + " AND t1.table_name  ='"
                + value + "'"
                + " )t4  order by t4.column_name");
        logger.info("sql=" + sb.toString());
        List<OcrmFCiFqDbcol> list = mapper.qryallsetdata(sb.toString());
        return list;
    }

    /**
     * 更新指标数据删除
     *
     * @param record
     * @return
     */
    public int deletedata(OcrmFCiFqDbcol record) {
        return mapper.deleteData(record);
    }

    /**
     * 更新指标数据
     *
     * @param
     * @return
     */
    public int updatesetdata(List<OcrmFCiFqDbcol> list) {
        int count = 0;
        if (list.size() > 0) {
            OcrmFCiFqDbcol record = new OcrmFCiFqDbcol();
            record.setGroupId(list.get(0).getGroupId());
            record.setDbtableName(list.get(0).getDbtableName());
            mapper.deleteData(record);
            mapper.insertDbcol(list);
        }
        return count;
    }

    /**
     * 查询数据
     *
     * @param
     * @return
     */
    public List<Map<String, Object>> loadData(String id) {
        return mapper.loadData(id);
    }

    /**
     * 客户灵活查询查询左侧树
     *
     * @param
     * @return
     */
    public List<Map<String, Object>> prepare(QueryModel model) {
        //if(queryTytpe==null||"".equals(queryTytpe)){
        String queryTytpe = (String) model.getCondition().get("queryTytpe");//默认查询类型-客户高级查询
        //}
        StringBuilder sb = new StringBuilder();
        sb.append("   select o.id as nodeid, o.obj_name as name, o.parent_id, '1' AS tables, '' AS ename, o.table_name as value, '' AS ctype, '' AS NOTES " +
                " from CIMP_F_CI_FQ_OBJ o where o.id='" + queryTytpe + "' " +
                " union" +
                "  select g.id as nodeid, g.group_name as name, g.obj_id as parent_id,  '1' AS tables, '' AS ename, '' as value, '' AS ctype, '' AS NOTES" +
                "  from CIMP_F_CI_FQ_GROUP g where g.obj_id='" + queryTytpe + "' " +
                " union" +
                "  SELECT id AS nodeid, col_name_c AS name, group_id AS parent_id,'2' AS tables,col_name_e AS ename,DBTABLE_NAME AS value, COL_TYPE AS ctype,NOTES" +
                "  FROM CIMP_F_CI_FQ_DBCOL" +
                " WHERE IS_ENABLE = 'true' and group_id in (select id from CIMP_F_CI_FQ_GROUP where obj_id in(select id from CIMP_F_CI_FQ_OBJ where id='" + queryTytpe + "' ))");
        logger.info("sql=" + sb.toString());
        List<Map<String, Object>> list = mapper.prepare(sb.toString());
        return list;
    }

    /**
     * 客户灵活查询查询结果
     *
     * @param
     * @return
     */

    public List<Map<String, Object>> queryResult(QueryModel model) {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            List conditionAttrs = (List) model.getCondition().get("conditionAttrs");//条件参数
            logger.info("conditionAttrs===" + conditionAttrs);
            List results = (List) model.getCondition().get("results");//结果列参数
            String groupsql = "";
            String groupsqls = "";
            if (model.getCondition().containsKey("groupsql")) {
                groupsql = (String) model.getCondition().get("groupsql");//分群组件使用客户群拼接条件
            }
            if (model.getCondition().containsKey("groupsqls")) {
                groupsqls = (String) model.getCondition().get("groupsqls");//分群组件中 自动筛选类型客户群的主群sql
            }
            logger.info("results===" + results);
            //crm开发分组汇总
            String groupParams = (String) model.getCondition().get("groupParams");//分组字段参数
            List sumParams = (List) model.getCondition().get("sumParams");//汇总字段参数
//			JSONArray sumParams = JSONArray.fromObject(sumParam);
            //crm开发分组汇总
            String topNum = "";
            if (model.getCondition().containsKey("topNum")) {
                topNum = String.valueOf(model.getCondition().get("topNum"));
            }
            String isexport = "";
            if (model.getCondition().containsKey("isexport")) {
                isexport = String.valueOf(model.getCondition().get("isexport"));
            }
            String busiTypeFlag = "";
            if (model.getCondition().containsKey("busiTypeFlag")) {
                busiTypeFlag = String.valueOf(model.getCondition().get("busiTypeFlag"));
            }
            String topField = (String) model.getCondition().get("topField");//筛选排序字段
            JSONArray jaCondition = JSONArray.fromObject(conditionAttrs);
            logger.info("topNum===" + topNum);
            JSONArray jaColumns = null;
            if (results != null && !"".equals(results)) {
                jaColumns = JSONArray.fromObject(results);
            }
            //判断是否为客户经理角色
            String mgrFlag = "0";
            List<? extends ObjBean> rolecodelist = userInfoService.getUserInfo().getRoles();
            //List<? extends Obj> rolecodelist = userInfoService.getUserInfo().getRoles();
            for (ObjBean obj : rolecodelist) {
                if ("15".equals(obj.getCode())) {
                    mgrFlag = "1";
                }
            }
            //sql拼装处理
            Map<String, Object> res = generatorSql(jaCondition,
                    jaColumns, groupParams, sumParams, groupsql, groupsqls, isexport, mgrFlag, busiTypeFlag);
            //获得拼装的sql语句，可以添加额外控制语句
            String sql = (String) res.get("SQL");
            String ordersql = (String) res.get("ORDERSQL");

            logger.info("sql===" + sql);
            int countnum = 0;

            //如果不汇总，则对sql进行topNum 处理
//			if(groupParams==null||"".equals(groupParams)){
//				sql=generateTopSql(sql,topField,topNum);
//			}else{

//				String cousql="select count (1) from ("+sql+")";
//				countnum=mapper.getCount(cousql);
//				if(countnum>2000){
//					throw new YuspException(messageProviderService.getMessage("110002"));//提示"分组条数已超过1000条，不予处理，请检查方案是否合理！"
//				}
//			}

            model.getCondition().put("topNum", topNum);
            model.getCondition().put("SQL", sql);
            model.getCondition().put("ORDERSQL", ordersql);
            //PageHelper.startPage(model.getPage(), model.getSize());
            list = mapper.queryResult(model);
            //PageHelper.clearPage();

            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(0).put("sql", sql + ordersql);
                }
            }
//			 else {
//				 Map map = new HashMap();
//				 map.put("sql", sql+ordersql);
//				 list.add(map);
//			 }
        } catch (BadSqlGrammarException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    //拼接sql
    public Map<String, Object> generatorSql(JSONArray jaCondition,
                                            JSONArray jaColumns, String groupParams, List sumParams, String groupsql, String groupsqls, String isexport, String mgrFlag, String busiTypeFlag) {
        String conditionColumns = "";
        for (Object oa : jaCondition) {
            JSONArray joa = JSONArray.fromObject(oa);
            for (Object o : joa) {
                JSONObject jo = (JSONObject) o;
                if ("".equals(conditionColumns)) {
                    conditionColumns += jo.getLong("SS_COL_ITEM");
                } else {
                    conditionColumns += "," + jo.getLong("SS_COL_ITEM");
                }
            }
        }

        /**
         * 查询条件中的列对象
         */
//		Query queryConditionColumms = em
//				.createQuery("SELECT cols FROM AcrmFFqDbcol cols WHERE cols.id in ("
//						+ conditionColumns + ")");
//		List<CimpFFqDbcol> conditionColumnsObj = queryConditionColumms
//				.getResultList();


        StringBuilder sb = new StringBuilder();
        sb.append("SELECT cols.* FROM CIMP_F_CI_FQ_DBCOL cols WHERE cols.id in (" + conditionColumns + ")");
        List<OcrmFCiFqDbcol> conditionColumnsObj = mapper.getResultList(sb.toString());

        /**
         * 查询结果列对象
         */
        String resultColumnsId = "0";
        if (jaColumns != null) {
            for (Object o : jaColumns) {
                JSONObject jo = (JSONObject) o;
                resultColumnsId += "," + jo.getLong("columnId");
            }
        }
//		Query queryColumns = em
//				.createQuery("SELECT cols FROM AcrmFFqDbcol cols WHERE cols.id in ("
//						+ resultColumnsId + ")");
//		List<CimpFFqDbcol> dscs = (List<CimpFFqDbcol>) queryColumns
//				.getResultList();
//		
        StringBuilder sbsql = new StringBuilder();
        sbsql.append("SELECT cols.* FROM CIMP_F_CI_FQ_DBCOL cols WHERE cols.id in (" + resultColumnsId + ")");
        List<OcrmFCiFqDbcol> dscs = mapper.queryColumns(sbsql.toString());

        String relTable = "0";
        for (OcrmFCiFqDbcol table : dscs) {
            relTable += "," + table.getGroupId();
        }
        logger.info("relTable==" + relTable);
        /**
         * 根据分组id查询出对象主表
         */
//		Query queryLeftTab = em
//				.createQuery("SELECT col FROM AcrmFFqObj col WHERE col.id in (select t.objId from AcrmFFqGroup t where  t.id in (SELECT cols.groupId FROM AcrmFFqDbcol cols WHERE cols.id in ("
//						+ resultColumnsId + ")))");
//		List<CimpFFqDbcol> leftTabs = (List<CimpFFqDbcol>) queryLeftTab.getResultList();

        StringBuilder leftsql = new StringBuilder();
        leftsql.append("SELECT col.* FROM CIMP_F_CI_FQ_OBJ col WHERE col.id in (select t.obj_Id from CIMP_F_CI_FQ_GROUP t where  t.id in (SELECT cols.group_Id FROM CIMP_F_CI_FQ_DBCOL cols WHERE cols.id in ("
                + resultColumnsId + ")))");
        List<OcrmFCiFqObj> leftTabs = cimpFFqObjMapper.queryLeftTab(leftsql.toString());

        logger.info("leftsql.toString()==" + leftsql.toString());
        String leftTab = "";
        String leftTabId = "";
        for (OcrmFCiFqObj left : leftTabs) {
            leftTabId = left.getId() + "";
            leftTab = left.getTableName();
        }
        /**
         * 联表所需关联关系对象
         */
//		Query queryRelations = em
//				.createQuery("SELECT osr FROM AcrmFFqRelation osr WHERE osr.joinLeftTable in ("
//						+ leftTabId//左表
//						+ ") and osr.joinRightTable in ("
//						+ relTable
//						+ ")");
//		List<CimpFFqRelation> ofasrs = queryRelations.getResultList();
        logger.info("leftTabId==" + leftTabId);
        logger.info("relTable==" + relTable);
        StringBuilder relationsql = new StringBuilder();
        relationsql.append("SELECT osr.ID,osr.JOIN_LEFT_TABLE AS JOIN_LEFT_NAME,osr.JOIN_RIGHT_TABLE AS JOIN_RIGHT_NAME,osr.SS_COL_LEFT,osr.JOIN_LEFT_ALIAS,osr.JOIN_RIGHT_ALIAS,osr.JOIN_LEFT_COL AS JOIN_LEFT_COL_NAME,osr.JOIN_RIGHT_COL AS JOIN_RIGHT_COL_NAME FROM CIMP_F_CI_FQ_RELATION osr WHERE osr.join_Left_Table in ("
                + leftTabId//左表
                + ") and osr.join_Right_Table in (" + relTable
                + ")");
        List<OcrmFCiFqRelation> ofasrs = ocrmFCiFqRelationMapper.queryRelations(relationsql.toString());
        logger.info("relationsql==" + relationsql.toString());

        String joinColumns = "0";
        for (OcrmFCiFqRelation ofasr : ofasrs) {
            joinColumns += "," + Long.toString(ofasr.getJoinLeftColName()) + ","
                    + Long.toString(ofasr.getJoinRightColName());
        }

        logger.info("joinColumns==" + joinColumns);
        /**
         * 连表所需列对象
         */
//		Query queryJoinColumms = em
//				.createQuery("SELECT cols FROM AcrmFFqDbcol cols WHERE cols.id in ("
//						+ joinColumns + ")");
//		List<CimpFFqDbcol> joinColumnsObj = queryJoinColumms.getResultList();

        StringBuilder colsql = new StringBuilder();
        colsql.append("SELECT cols.* FROM CIMP_F_CI_FQ_DBCOL cols WHERE cols.id in ("
                + joinColumns + ")");
        logger.info("colsql==" + colsql.toString());
        List<OcrmFCiFqDbcol> joinColumnsObj = mapper.queryJoinColumms(colsql.toString());

        // 连表语句
        logger.info("leftTab==" + leftTab);
        String joinSQL = FlexibleQueryUtils.createTableJoin(leftTabs, ofasrs,
                joinColumnsObj);
        // SELECT语句
        logger.info("joinSQL==" + joinSQL);
//		String selectSQL = FlexibleQueryUtils.createSelectColumns(leftTabs,dscs,
//				jaColumns, groupParams, sumParams);
        String selectSQL = "";
//		if("1".equals(isexport)) {//如果是导出，则数据不做脱敏处理
        selectSQL = FlexibleQueryUtils.createSelectColumnsexport(leftTabs, dscs,
                jaColumns, groupParams, sumParams);
//		}else {
//			selectSQL = FlexibleQueryUtils.createSelectColumns(leftTabs,dscs,
//					jaColumns, groupParams, sumParams);
//		}
        logger.info("selectSQL==" + selectSQL);
        // 条件语句
        String whereSQL = FlexibleQueryUtils.createWhereColumns(jaCondition,
                conditionColumnsObj);
        logger.info("whereSQL==" + whereSQL);

        // 排序语句
        String orderSQL = "";
        // 分组语句
        String groupBySQL = "";
        if (jaColumns != null) {
            orderSQL = FlexibleQueryUtils
                    .createOrderSQL(dscs, jaColumns);
        }
        if (null != groupParams && !groupParams.equals("")) {
            groupBySQL = FlexibleQueryUtils.createGroupByColumns(
                    dscs, groupParams);
        }


        Map<String, Object> lastResult = new HashMap<String, Object>();
        // 获取需要数据字段编码映射的字段
        Map<OcrmFCiFqDbcol, String> look = new HashMap<OcrmFCiFqDbcol, String>();
        for (OcrmFCiFqDbcol l : dscs) {
            if (null != l.getNotes() && !l.getNotes().equals("")) {
                for (Object o : jaColumns) {
                    JSONObject jo = (JSONObject) o;
                    Long ti = jo.getLong("columnId");
                    if (ti.equals(l.getId())) {
                        look.put(l, jo.getString("columnTotle"));
                        break;
                    }
                }
            }
        }
        //分群组件中拼接主客户群为手工或者导入
        String groupSQL = "";
        String groupwhereSQL = "";
        if (!"".equals(groupsql) && groupsql != null) {
            StringBuilder sqls = new StringBuilder();
            sqls.append(" left join cimp_c_custgroup_cust cg on cg.cust_id = ltinfo.cust_id  ");
            groupSQL = sqls.toString();

            StringBuilder wheresqls = new StringBuilder();
            wheresqls.append(" and cg.cust_group_id ='" + groupsql + "'  ");
            groupwhereSQL = wheresqls.toString();
        }
        //分群组件中拼接主客户群为自动筛选
        String groupsSQL = "";
        if (!"".equals(groupsqls) && groupsqls != null) {
            StringBuilder wheresql = new StringBuilder();
            wheresql.append(" and ltinfo.cust_id in (" + groupsqls + " )");
            groupsSQL = wheresql.toString();
        }
        String userId = userInfoService.getUserInfo().getUserId();
        String orgCode = userInfoService.getOrgCode();
//		String finalSql = "SELECT " + selectSQL + " FROM " + joinSQL + groupSQL
//				+ " WHERE " + whereSQL + groupwhereSQL +" " + groupsSQL;

        String finalSql = "SELECT " + selectSQL + " FROM " + joinSQL + groupSQL
                + " WHERE 1=1  ";
//		if(!mgrFlag.equals("1")) {
//			finalSql += "AND custall.BELONG_ORG in (SELECT ORG_ID FROM ADMIN_SM_ORG START WITH ORG_ID = '"+orgCode+"' CONNECT BY PRIOR ORG_ID = UP_ORG_ID)"; 
//		}
//		if(!mgrFlag.equals("1") && !busiTypeFlag.equals("1")) {
//			finalSql += "AND custall.BELONG_BRCH in (SELECT ORG_ID FROM ADMIN_SM_ORG START WITH ORG_ID = '"+orgCode+"' CONNECT BY PRIOR ORG_ID = UP_ORG_ID)"; 
//		}
//		if(mgrFlag.equals("1")) {//是客户经理角色的加条件
//			finalSql += " AND (b.mgr_id= '"+userId+"') ";
//		}
//		if(busiTypeFlag.equals("1")) {//如果是总行用户增加业务条线过滤
//			finalSql +=queryUserBusiType();
//		}
        finalSql += " AND " + whereSQL + groupwhereSQL + " " + groupsSQL;

        //权限过滤,根据custinfo主表关联配置权限
//		finalSql+=FlexibleQueryUtils.getAuthorityString(auth);

        //分组排序
//		if (!groupBySQL.equals("")) {
//			finalSql += " GROUP BY " + groupBySQL;
//			finalSql += " ORDER BY " + groupBySQL;
//		}else{
//			if (!orderSQL.equals("")) {
//				finalSql += " ORDER BY " + orderSQL;
//			}
//		}
        String ordersql = "";
        if (!groupBySQL.equals("")) {
            ordersql += " GROUP BY " + groupBySQL;
            ordersql += " ORDER BY " + groupBySQL;
        } else {
            if (!orderSQL.equals("")) {
                ordersql += " ORDER BY " + orderSQL;
            }
        }

        lastResult.put("SQL", finalSql);
        lastResult.put("ORDERSQL", ordersql);
        lastResult.put("lookupColumns", look);
        return lastResult;
    }

    public String generateTopSql(String sql, String topField, String topNum) {
        //根据topField查询表名称和列名称,如果是 ACRM_F_CI_CUSTOMER 表 ，别名强制替换成custinfo
        String finalsql = sql;
        if (!"".equals(topField) && topField != null) {
//			Object ss1=em.createNativeQuery(" select p.col_name_e from ACRM_F_FQ_DBCOL p where  p.id='"+topField+"' ").getSingleResult();

            StringBuilder colsql = new StringBuilder();
            colsql.append(" select p.col_name_e from CIMP_F_CI_FQ_DBCOL p where  p.id='" + topField + "' ");
            String colNName = mapper.getSingleResult(colsql.toString());

//			Object  ss2=em.createNativeQuery("select p.DBTABLE_NAME,p.ALIAS from ACRM_F_FQ_DBCOL p where  p.id='"+topField+"'  ").getSingleResult();
            StringBuilder sqls = new StringBuilder();
            sqls.append("select p.DBTABLE_NAME,p.ALIAS from CIMP_F_CI_FQ_DBCOL p where  p.id='" + topField + "'  ");
            List<OcrmFCiFqDbcol> ss2 = mapper.getSingleResults(sqls.toString());

            String tbName = (String) ss2.get(0).getDbtableName();
            String tbNName = (String) ss2.get(0).getAlias();
            if (tbName.equals(FlexibleQueryUtils.CUST_MAIN_INFO_TABLE)) {
                tbNName = "custinfo";
            }

            finalsql += " order by " + tbNName + "." + colNName + " ";
        }
        if (!"".equals(topNum) && topNum != null) {
            finalsql = "SELECT * FROM (" + finalsql + ") WHERE ROWNUM <= " + topNum;
        }
        return finalsql;
    }

    public String generateGroupSql(String sql, String groupsql) {
        String finalsql = sql;
        if (!"".equals(groupsql) && groupsql != null) {
            StringBuilder sqls = new StringBuilder();
            sqls.append("left join cimp_c_custgroup_cust cg on cg.cust_id = ltinfo.cust_id where cg.cust_group_id ='" + groupsql + "'  ");
            finalsql += sqls.toString();
        }
        logger.info("finalsql===" + finalsql);
        return finalsql;
    }

    public List<Map<String, Object>> showcoltype(QueryModel model) {
        return mapper.showcoltype(model);
    }

    public List<Map<String, Object>> qryLookupcode() {
        return mapper.qryLookupcode();
    }

    public List<Map<String, Object>> getcodeitem(String lookupCode) {
        return mapper.getcodeitem(lookupCode);
    }

    /**
     * 查询表名
     */
    public List<OcrmFCiFqDbcol> getDataSetSolution() {
        List<OcrmFCiFqDbcol> list = mapper.getDataSetSolution();
        return list;
    }

    public int deleteByid(String id) {
        int count = 0;
        mapper.deleteByid(id);
        return count;
    }

    public List<Map<String, Object>> qryCustinfo(String sql) {
        return mapper.qryCustinfo(sql);
    }


    /**
     * 发布报表
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public int createReport(JSONArray conditions, JSONArray results, JSONArray busiTypeFlag, String reportName, JSONArray solutionAttr) {
        int count = 0;
//     	JSONObject solu=JSONObject.fromObject(solutionAttr);
        //sql拼装处理
        //判断是否为客户经理角色
        String mgrFlag = "0";
        List<? extends ObjBean> rolecodelist = userInfoService.getUserInfo().getRoles();
        //List<? extends Obj> rolecodelist = userInfoService.getUserInfo().getRoles();
        for (ObjBean obj : rolecodelist) {
            if ("15".equals(obj.getCode())) {
                mgrFlag = "1";
            }
        }
        JSONObject jsonObject = (JSONObject) busiTypeFlag.get(0);
        String busiTypeFlags = (String) jsonObject.get("busiTypeFlag");
        Map<String, Object> res = generatorSql(conditions, results, null, null, null, null, null, mgrFlag, busiTypeFlags);

        String reportSql = (String) res.get("SQL");
        //判断sql长度是否超出限制。
        if (reportSql.length() > 2000) {
            throw new YuspException(new Message("2006", "生成查询语句过长，请优化查询", "error"));//提示"生成查询语句过长，请优化查询！"
        } else {
            count = saveReport(solutionAttr, conditions, reportName, reportSql);
        }
        return count;
    }

    public int saveReport(JSONArray solutionAttr, JSONArray condi, String reportName, String reportSql) {
        int n = 0;
        //新增报表方案
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        String time = df.format(new Date());
        OcrmAciFqReport solutionModel = new OcrmAciFqReport();
        solutionModel.setReportName(reportName);
        try {
            solutionModel.setCreateDate(new Date(df.parse(time).getTime()));
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        solutionModel.setReportSql(reportSql);
        String setSsResult = "";
        String setSsSort = "";
        String setTopNum = "";
        String OBJ_TYPE = "";
        for (Object oa : solutionAttr) {
            JSONArray joa = JSONArray.fromObject(oa);
            for (Object o : joa) {
                JSONObject jo = (JSONObject) o;
                if ("".equals(setSsResult)) {
                    setSsResult += jo.getString("SS_RESULT");
                    setSsSort += jo.getString("SS_SORT");
                    setTopNum = jo.getString("TOP_NUM");
                } else {
                    setSsResult += "," + jo.getString("SS_RESULT");
                    setSsSort += "," + jo.getString("SS_SORT");
                }
                if (jo.get("OBJ_TYPE") != null) {
                    OBJ_TYPE = jo.getString("OBJ_TYPE");
                }

            }
        }
        solutionModel.setReportId(getUUID());
        solutionModel.setSsResult(setSsResult);
        solutionModel.setSsSort(setSsSort);
        solutionModel.setSsType(OBJ_TYPE);
        solutionModel.setDataProcessingTable("TEMP" + System.currentTimeMillis());//数据处理临时表名
        if (!setTopNum.isEmpty()) {
            Long top = Long.parseLong(setTopNum);
            solutionModel.setTopNum(new BigDecimal(top));
        }
        solutionModel.setCreater(userInfoService.getLoginCode());
        solutionModel.setCreateOrg(userInfoService.getOrgCode());
        n = this.insertSelective(ocrmAciFqReportMapper, solutionModel);

        for (Object sc : condi) {
            JSONArray scd = JSONArray.fromObject(sc);
            for (Object scc : scd) {
                JSONObject sccd = (JSONObject) scc;
                OcrmFCiFqScol asc = new OcrmFCiFqScol();
                asc.setSsId(solutionModel.getReportId());
                BigDecimal sscolitem = new BigDecimal(sccd.getLong("SS_COL_ITEM"));
                BigDecimal sscolgorder = new BigDecimal(sccd.getString("SS_COL_GORDER"));
                BigDecimal sscolorder = new BigDecimal(sccd.getString("SS_COL_ORDER"));
                asc.setId(getUUID());
                asc.setSsColItem(sscolitem);
                asc.setSsColOp(sccd.getString("SS_COL_OP"));
                asc.setSsColValue(sccd.getString("SS_COL_VALUE"));
                asc.setSsColGjoin(sccd.getString("SS_COL_GJOIN").equals("null") ? null : sccd.getString("SS_COL_GJOIN"));
                asc.setSsColGorder(sscolgorder);
                asc.setSsColJoin(sccd.getString("SS_COL_JOIN").equals("null") ? null : sccd.getString("SS_COL_JOIN"));
                asc.setSsColOrder(sscolorder);
                this.insertSelective(ocrmFCiFqScolMapper, asc);
            }
        }
        return n;
    }

    /**
     * 发布图表
     */
    public OcrmAciFqGraph addGraph(OcrmAciFqGraph ocrmAciFqGraph) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        String time = df.format(new Date());
        try {
            ocrmAciFqGraph.setCreateDate(new Date(df.parse(time).getTime()));
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        ocrmAciFqGraph.setGraphId(getUUID());
        ocrmAciFqGraph.setCreateOrg(userInfoService.getOrgCode());
        ocrmAciFqGraph.setCreateUser(userInfoService.getLoginCode());
        if (this.insertSelective(ocrmAciFqGraphMapper, ocrmAciFqGraph) != 1) {
            return null;
        }
        return ocrmAciFqGraph;
    }

    /**
     * 查询结果数据导出
     */
    @SuppressWarnings("unchecked")
    public int export(QueryModel model, HttpServletResponse response) throws IOException {
        logger.info("灵活查询结果数据导出export  begin");
        int ret = 0;
        List<Map<String, Object>> colList = (List) model.getCondition().get("colunmNamelist");//表头参数
        List<Map<String, Object>> OneTableDataList = (List) model.getCondition().get("datalist");//数据参数

        List<List<CellInfo>> datalist = new ArrayList<List<CellInfo>>();

        List<Map<String, Object>> exportDataList = new ArrayList<Map<String, Object>>();
        List<List<CellInfo>> headerTwo = new ArrayList<List<CellInfo>>();
        String cols = "";
        String colskey = "";
        List<CellInfo> heads = new ArrayList<CellInfo>();
        for (int k = 0; k < colList.size(); k++) {//遍历表头数据
            if (k == 0) {
                cols = (String) colList.get(k).get("name");
                colskey = (String) colList.get(k).get("ename");
            } else {
                cols = cols + "," + (String) colList.get(k).get("name");
                colskey = colskey + "," + (String) colList.get(k).get("ename");
            }
            heads.add(new CellInfo((String) colList.get(k).get("name")));//字段名
        }
        //表头list
        if (heads.size() > 0) {
            headerTwo.add(heads);
        }
        logger.info("灵活查询结果数据导出export  dataList.size=" + OneTableDataList.size());
        if (OneTableDataList.size() > 10000) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('数据量过大，禁止导出！');</script>");
            response.getWriter().write("<script>window.close();window.history.go(-1);</script>");
            response.getWriter().flush();
        } else {
            for (int m = 0; m < OneTableDataList.size(); m++) {
                List<CellInfo> dataForOne = new ArrayList<CellInfo>();
                String data = "";
                String[] colkey = colskey.split(",");
                for (int b = 0; b < colkey.length; b++) {
                    String colName = colkey[b];
                    Object dataTemp = OneTableDataList.get(m).get(colName);
                    data = String.valueOf(dataTemp);
                    dataForOne.add(new CellInfo(data));
                }
                datalist.add(dataForOne);
            }
            Map<String, Object> mapTwo = new HashMap<String, Object>();
            mapTwo.put("sheetName", "查询结果");//sheet名
            mapTwo.put("headerLength", colList.size());//表头长度
            mapTwo.put("header", headerTwo);//表头
            mapTwo.put("data", datalist);//数据
            exportDataList.add(mapTwo);
            logger.info("灵活查询结果数据导出export  data=" + exportDataList);
            OutputStream out = null;
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(cal.getTime()) + "查询结果数据";
            try {
                date = new String(date.getBytes("gbk"), "ISO8859-1");
            } catch (UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            HSSFWorkbook workbook = exportExcel(exportDataList);

            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=GBK");
            response.addHeader("Content-Disposition", "attachment; filename=\""
                    + date + ".xls\"");
            OutputStream outputStream = null;
            try {
                outputStream = response.getOutputStream();
                workbook.write(outputStream);
                outputStream.flush();
            } catch (IOException e) {
                ret = 1;
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    ret = 1;
                }
            }
        }
        return ret;
    }

    /**
     * @方法名称: getUUID
     * @方法描述: UUID生成器
     * @参数与返回说明:
     * @算法描述:
     */
    private String getUUID() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }

    //导出
    public HSSFWorkbook exportExcel(List<Map<String, Object>> datas) throws IOException {
        logger.info("业务数据导出exportExcel  begin");
        //创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //表头的样式
//        HSSFCellStyle titlestyle = workbook.createCellStyle();// 创建样式对象 
//        titlestyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中 
//        titlestyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中 
//        titlestyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);   
//        titlestyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);   
//        titlestyle.setBorderRight(HSSFCellStyle.BORDER_THIN);   
//        titlestyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //字体 
        HSSFFont titleFont = workbook.createFont(); // 创建字体对象 
        titleFont.setFontHeightInPoints((short) 11); // 设置字体大小 
        titleFont.setFontName("微软雅黑"); // 设置为黑体字 
//        titlestyle.setFont(titleFont);
        //指定当单元格内容显示不下时自动换行 
//        titlestyle.setWrapText(true);  
        //表数据的样式
//        HSSFCellStyle style = workbook.createCellStyle();// 创建样式对象 
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中 
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中 
//        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);   
//        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);   
//        style.setBorderRight(HSSFCellStyle.BORDER_THIN);   
//        style.setBorderTop(HSSFCellStyle.BORDER_THIN); 
        //字体 
        HSSFFont font = workbook.createFont(); // 创建字体对象 
        font.setFontHeightInPoints((short) 11); // 设置字体大小 
        font.setFontName("微软雅黑"); // 设置为黑体字 
//        style.setFont(font); 
        //指定当单元格内容显示不下时自动换行 
//        style.setWrapText(true);   

        for (Map<String, Object> map : datas) {
            String sheetName = map.get("sheetName").toString();
//            String title ="";
//            String unitInfo = "";
//            logger.info("业务数据导出exportExcel  title="+title);
//            logger.info("业务数据导出exportExcel  unitInfo="+unitInfo);
            int headerLength = (int) map.get("headerLength");
            List<List<CellInfo>> header = (List<List<CellInfo>>) map.get("header");
            List<List<CellInfo>> data = (List<List<CellInfo>>) map.get("data");
            //创建Sheet
            HSSFSheet sheet = workbook.createSheet(sheetName);
            //设置表格默认列宽度为20个字节
            sheet.setDefaultColumnWidth(20);
            //设置第一行  （单位信息，定制）
            int rowNum = -1;
//            if(null!=unitInfo || !"".equals(unitInfo)){
//            	logger.info("业务数据导出exportExcel  unitInfo=="+rowNum);
//                sheet.addMergedRegion(new CellRangeAddress(rowNum,1,0,headerLength-1));
//                HSSFRow rowUnit = sheet.createRow(rowNum);   
//                HSSFCell cellUnit = rowUnit.createCell(0);
//                HSSFCellStyle unitStyle = workbook.createCellStyle();// 创建样式对象 
//                unitStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中 
//                unitStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
//                unitStyle.setFont(font);
//                cellUnit.setCellStyle(unitStyle); 
//                cellUnit.setCellValue(unitInfo);
//                rowNum =1;
//            }
            //标题
//            if(null!=title || !"".equals(title)){
//                rowNum++;
//                logger.info("业务数据导出exportExcel  title="+rowNum);
//                HSSFRow rowHeader = sheet.createRow(rowNum);
//                for(int i=0;i<headerLength;i++){
//                    HSSFCell cellHeader = rowHeader.createCell(i);
//                    cellHeader.setCellStyle(titlestyle); 
//                    cellHeader.setCellValue(title);
//                }
//                rowNum++;
//                logger.info("业务数据导出exportExcel  title2="+rowNum);
//                HSSFRow title2 = sheet.createRow(rowNum);
//                for(int i=0;i<headerLength;i++){
//                    HSSFCell cellHeader = title2.createCell(i);
//                    cellHeader.setCellStyle(titlestyle); 
//                    cellHeader.setCellValue(title);
//                }
//                sheet.addMergedRegion(new CellRangeAddress(rowNum-1,rowNum,0,headerLength-1));
//            }

            //表头
            for (int i = 0; i < header.size(); i++) {
                //行
                rowNum++;
                logger.info("业务数据导出exportExcel  header=" + rowNum);
                HSSFRow row = sheet.createRow(rowNum);
                List<CellInfo> cols = header.get(i);

                //创建列
                int colNum = 0;
                for (int j = 0; j < cols.size(); j++) {
                    HSSFCell cell = row.createCell(colNum);
//                    cell.setCellStyle(titlestyle);   
                    cell.setCellValue(cols.get(j).getContent());
                    int firstRow = rowNum;
                    int lastRow = rowNum;
                    int firstCol = colNum;
                    int lastCol = colNum;
                    boolean merge = false;
                    if (cols.get(j).getRowSpan() > 1) {
                        lastRow += cols.get(j).getRowSpan() - 1;
                        merge = true;
                    }
                    logger.info("业务数据导出exportExcel  header getRowSpan merge=" + merge);
                    //如果跨行则先创建被合并的单元格（主要是不创建的话，合并后的样式引用有问题）
                    if (cols.get(j).getColSpan() > 1) {
                        for (int k = 0; k < cols.get(j).getColSpan() - 1; k++) {
                            colNum++;
                            HSSFCell tmpCell = row.createCell(colNum);
//                            tmpCell.setCellStyle(titlestyle);   
                            tmpCell.setCellValue(cols.get(j).getContent());
                        }
                        lastCol = colNum;
                        merge = true;
                    }
                    colNum++;
                    logger.info("业务数据导出exportExcel  header getColSpan merge=" + merge);
                    if (merge) {
                        sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
                    }
                }
            }
            //表格数据
            logger.info("业务数据导出+模板data.size()=" + data.size());
            if (data.size() > 0) {
                for (int i = 0; i < data.size(); i++) {
                    //行
                    rowNum++;
                    logger.info("业务数据导出exportExcel  data=" + rowNum);
                    HSSFRow row = sheet.createRow(rowNum);
                    List<CellInfo> cols = data.get(i);
                    //创建列
                    int colNum = 0;
                    for (int j = 0; j < cols.size(); j++) {
                        HSSFCell cell = row.createCell(colNum);
//                   cell.setCellStyle(style);   
                        cell.setCellValue(cols.get(j).getContent());
                        int firstRow = rowNum;
                        int lastRow = rowNum;
                        int firstCol = colNum;
                        int lastCol = colNum;
                        boolean merge = false;
                        if (cols.get(j).getRowSpan() > 1) {
                            lastRow += cols.get(j).getRowSpan() - 1;
                            merge = true;
                        }
                        //如果跨行则先创建被合并的单元格（主要是不创建的话，合并后的样式引用有问题）
                        if (cols.get(j).getColSpan() > 1) {
                            for (int k = 0; k < cols.get(j).getColSpan() - 1; k++) {
                                colNum++;
                                HSSFCell tmpCell = row.createCell(colNum);
//                           tmpCell.setCellStyle(style);   
                                tmpCell.setCellValue(cols.get(j).getContent());
                            }
                            lastCol = colNum;
                            merge = true;
                        }
                        colNum++;
                        if (merge) {
                            sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
                        }
                    }
                }
            }
            rowNum++;

        }
        logger.info("业务数据导出exportExcel  end");
        return workbook;

    }

    /**
     * @方法名称:qryCustSta
     * @方法描述:
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> qryCustSta(String custId) {
        List<Map<String, Object>> list = mapper.qryCustSta(custId);
        return list;
    }


    /**
     * @方法名称: queryUserBusiType
     * @方法描述: 查询当前登录用户所属条线
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public String queryUserBusiType() {
        String loginCode = userInfoService.getLoginCode();
        String busiTypeAuth = " AND (";
        String busiType = mapper.queryUserBusiType(loginCode);
        if (busiType != null) {
            String arr[] = busiType.split(",");
            for (String a : arr) {
                busiTypeAuth = busiTypeAuth + " custall.BUSI_TYPE LIKE '%" + a + "%' OR ";
            }
            if (busiTypeAuth.contains("OR")) {
                busiTypeAuth = busiTypeAuth.substring(0, busiTypeAuth.lastIndexOf("OR"));
            }
        }
        busiTypeAuth = busiTypeAuth + ") ";
        return busiTypeAuth;
    }

    /**
     * 客户灵活查询获取sql
     *
     * @param model
     * @return
     */

    public Map<String, Object> querySql(QueryModel model) {

//		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        Map<String, Object> map = new HashMap<>();
        try {
            List conditionAttrs = (List) model.getCondition().get("conditionAttrs");//条件参数
            logger.info("conditionAttrs===" + conditionAttrs);
            List results = (List) model.getCondition().get("results");//结果列参数
            String groupsql = "";
            String groupsqls = "";
            if (model.getCondition().containsKey("groupsql")) {
                groupsql = (String) model.getCondition().get("groupsql");//分群组件使用客户群拼接条件
            }
            if (model.getCondition().containsKey("groupsqls")) {
                groupsqls = (String) model.getCondition().get("groupsqls");//分群组件中 自动筛选类型客户群的主群sql
            }
            logger.info("results===" + results);
            //crm开发分组汇总
            String groupParams = (String) model.getCondition().get("groupParams");//分组字段参数
            List sumParams = (List) model.getCondition().get("sumParams");//汇总字段参数
//			JSONArray sumParams = JSONArray.fromObject(sumParam);
            //crm开发分组汇总
            String topNum = "";
            if (model.getCondition().containsKey("topNum")) {
                topNum = String.valueOf(model.getCondition().get("topNum"));
            }
            String isexport = "";
            if (model.getCondition().containsKey("isexport")) {
                isexport = String.valueOf(model.getCondition().get("isexport"));
            }
            String busiTypeFlag = "";
            if (model.getCondition().containsKey("busiTypeFlag")) {
                busiTypeFlag = String.valueOf(model.getCondition().get("busiTypeFlag"));
            }
            String topField = (String) model.getCondition().get("topField");//筛选排序字段
            JSONArray jaCondition = JSONArray.fromObject(conditionAttrs);
            logger.info("topNum===" + topNum);
            JSONArray jaColumns = null;
            if (results != null && !"".equals(results)) {
                jaColumns = JSONArray.fromObject(results);
            }
            //判断是否为客户经理角色
            String mgrFlag = "0";
            List<? extends ObjBean> rolecodelist = userInfoService.getUserInfo().getRoles();
            //List<? extends Obj> rolecodelist = userInfoService.getUserInfo().getRoles();
            for (ObjBean obj : rolecodelist) {
                if ("15".equals(obj.getCode())) {
                    mgrFlag = "1";
                }
            }
            //sql拼装处理
            Map<String, Object> res = generatorSql(jaCondition,
                    jaColumns, groupParams, sumParams, groupsql, groupsqls, isexport, mgrFlag, busiTypeFlag);
            //获得拼装的sql语句，可以添加额外控制语句
            String sql = (String) res.get("SQL");
            String ordersql = (String) res.get("ORDERSQL");

            logger.info("sql===" + sql);
            int countnum = 0;

            model.getCondition().put("topNum", topNum);
            model.getCondition().put("SQL", sql);
            model.getCondition().put("ORDERSQL", ordersql);
            map.put("sql", sql + ordersql);
        } catch (BadSqlGrammarException e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }

    public List<Map<String, String>> existTable(QueryModel model) {
        // TODO 自动生成的方法存根
        return mapper.existTable(model);
    }

    public Map<String, Object> getAliasByObjId(String id) {
        // TODO 自动生成的方法存根
        return mapper.getAliasByObjId(id);
    }
}

