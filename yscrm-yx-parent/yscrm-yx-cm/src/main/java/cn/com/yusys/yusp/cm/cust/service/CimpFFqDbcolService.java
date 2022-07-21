package cn.com.yusys.yusp.cm.cust.service;

import cn.com.yusys.yusp.cm.cust.domain.CimpFFqDbcol;
import cn.com.yusys.yusp.cm.cust.domain.CimpFFqGroup;
import cn.com.yusys.yusp.cm.cust.domain.CimpFFqObj;
import cn.com.yusys.yusp.cm.cust.domain.CimpFFqRelation;
import cn.com.yusys.yusp.cm.cust.repository.mapper.*;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.mortbay.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: yusp-app-cm
 * @类名称: CimpFFqDbcolService
 * @类描述:
 * @功能描述: 数据集管理
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2018年11月08日
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */

@Service
public class CimpFFqDbcolService extends CommonService {
    private static final List<CimpFFqGroup> CimpFFqGroup = null;
    @Autowired
    private CimpFFqDbcolMapper mapper;
    @Autowired
    private CimpFFqDbtableMapper tablemapper;
    @Autowired
    private CimpFFqGroupMapper groupmapper;
    private final Logger logger = LoggerFactory.getLogger(CimpFFqDbcolService.class);
    @Autowired
    private CimpFFqObjMapper cimpFFqObjMapper;
    @Autowired
    private CimpFFqRelationMapper cimpFFqRelationMapper;

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
    public List<CimpFFqDbcol> qryCollist(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        List<CimpFFqDbcol> list = mapper.qryCollist(model);
        PageHelper.clearPage();
        return list;
    }

    public List<CimpFFqDbcol> isExist(QueryModel model) {
        List<CimpFFqDbcol> list = mapper.isExist(model);
        return list;
    }

    /**
     * 查询数据集
     *
     * @param record 否重新设置
     * @return
     */
    public List<CimpFFqDbcol> qrysetdata(QueryModel model) {
        List<CimpFFqDbcol> list = mapper.qrysetdata(model);
        return list;
    }

    /**
     * 查询全部数据集
     *
     * @param record 是重新设置
     * @return
     */
    public List<CimpFFqDbcol> qryallsetdata(QueryModel model) {
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
        List<CimpFFqDbcol> list = mapper.qryallsetdata(sb.toString());
        return list;
    }

    /**
     * 更新指标数据删除
     *
     * @param record
     * @return
     */
    public int deletedata(CimpFFqDbcol record) {
        return mapper.deleteData(record);
    }

    /**
     * 更新指标数据
     *
     * @param record 是重新设置
     * @return
     */
    @Transactional(readOnly = true)
    public int updatesetdata(List<CimpFFqDbcol> list) {
        int count = 0;
        if (list.size() > 0) {
//			CimpFFqGroup record =  new CimpFFqGroup();
//			record.setId(mapper.getSeqId());
//			record.setParentId("0");
//			record.setObjId((long) 2);
//			List<CimpFFqDbtable> listinfo=tablemapper.selectByid(dbtableId);
//			if(listinfo.size()>0){
//			    record.setGroupName(listinfo.get(0).getName());
//			    dbtableName=listinfo.get(0).getValue();
//			}else {
//				record.setGroupName("客户查询");
//			}
//			groupmapper.insertfgroup(record);//新增分组
            //long id=groupinfo.get(0).getId();//取出分组的id入到col表的groupid

            mapper.insertDbcol(list);
        }
        return count;
    }

    /**
     * 查询数据
     *
     * @param record 是重新设置
     * @return
     */
    public List<Map<String, Object>> loadData(String id) {
        return mapper.loadData(id);
    }

    /**
     * 客户灵活查询查询左侧树
     *
     * @param record 是重新设置
     * @return
     */
    public List<Map<String, Object>> prepare() {
        //if(queryTytpe==null||"".equals(queryTytpe)){
        String queryTytpe = "2";//默认查询类型-客户高级查询
        //}
        StringBuilder sb = new StringBuilder();
        sb.append("   select o.id as nodeid, o.obj_name as name, o.parent_id, '1' AS tables, '' AS ename, o.table_name as value, '' AS ctype, '' AS NOTES " +
                " from cimp_f_fq_obj o where o.id='" + queryTytpe + "' " +
                " union" +
                "  select g.id as nodeid, g.group_name as name, g.obj_id as parent_id,  '1' AS tables, '' AS ename, '' as value, '' AS ctype, '' AS NOTES" +
                "  from cimp_f_fq_group g where g.obj_id='" + queryTytpe + "' " +
                " union" +
                "  SELECT id AS nodeid, col_name_c AS name, group_id AS parent_id,'2' AS tables,col_name_e AS ename,DBTABLE_NAME AS value, COL_TYPE AS ctype,NOTES" +
                "  FROM cimp_F_FQ_DBCOL" +
                " WHERE IS_ENABLE = 'true' and group_id in (select id from cimp_f_fq_group where obj_id in(select id from cimp_f_fq_obj where id='" + queryTytpe + "' ))");
        logger.info("sql=" + sb.toString());
        List<Map<String, Object>> list = mapper.prepare(sb.toString());
        return list;
    }

    /**
     * 客户灵活查询查询结果
     *
     * @param record
     * @return
     */

    public List<Map<String, Object>> queryResult(QueryModel model) {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            List conditionAttrs = (List) model.getCondition().get("conditionAttrs");//条件参数
            logger.info("conditionAttrs===" + conditionAttrs);
            List results = (List) model.getCondition().get("results");//结果列参数
            String groupsql = "";
            if (model.getCondition().containsKey("groupsql")) {
                groupsql = (String) model.getCondition().get("groupsql");//分群组件使用客户群拼接条件
            }
            logger.info("results===" + results);
//		String groupParams = request.getParameter("groupParams");//分组字段参数
//		String sumParams = request.getParameter("sumParams");//汇总字段参数
            String topNum = "";
            if (model.getCondition().containsKey("topNum")) {
                topNum = String.valueOf(model.getCondition().get("topNum"));
            }
            String groupParams = "";
            String sumParams = "";
            String topField = (String) model.getCondition().get("topField");//筛选排序字段
            JSONArray jaCondition = JSONArray.fromObject(conditionAttrs);
            logger.info("topNum===" + topNum);
            JSONArray jaColumns = null;
            if (results != null && !"".equals(results)) {
                jaColumns = JSONArray.fromObject(results);
            }
            //sql拼装处理
            Map<String, Object> res = generatorSql(jaCondition,
                    jaColumns, groupParams, sumParams, groupsql);
            //获得拼装的sql语句，可以添加额外控制语句
            String sql = (String) res.get("SQL");
            logger.info("sql===" + sql);
            //组件分群拼接客户群条件
//		if(groupsql!=null||!"".equals(groupsql)){
//			sql=generateGroupSql(sql,groupsql);
//		}
            //组件分群拼接客户群条件
            //如果不汇总，则对sql进行topNum 处理
            if (groupParams == null || "".equals(groupParams)) {
                sql = generateTopSql(sql, topField, topNum);
            } else {
                //如果汇总，判断汇总结果条数是否过大。
//			if(getCount(sql)>1000){
//				this.json = new HashMap<String, Object>();
//				this.json.put("success",  false);
//				this.json.put("message",  "分组条数已超过1000条，不予处理，请检查方案是否合理！");
//				return "failure";
//			}
            }

            logger.info("sql1===" + sql);
//		try {
            StringBuilder sb = new StringBuilder(sql);
//			if (this.json != null) {
//				this.json.clear();
//			} else {
//				this.json = new HashMap<String, Object>();
//			}
//			if (request.getParameter("start") != null)
//				start = Integer.parseInt(request.getParameter("start"));
//			if (request.getParameter("limit") != null)
//				limit = Integer.parseInt(request.getParameter("limit"));
//	        int currentPage = start / limit + 1;
//			PagingInfo pi = null;
//			if (request.getParameter("start") != null
//					&& request.getParameter("limit") != null) {
//	        	pi = new PagingInfo(limit, currentPage);
//	        }

//			QueryHelper query = new QueryHelper(sb.toString(), ds.getConnection(), pi);
//			//数据转码
//			@SuppressWarnings("unchecked")
//			Map<AcrmFFqDbcol, String> lookups = (Map<AcrmFFqDbcol, String>) res
//					.get("lookupColumns");
//			Iterator<AcrmFFqDbcol> itl = lookups.keySet().iterator();
//			while (itl.hasNext()) {
//				AcrmFFqDbcol dsc = itl.next();
//				query.addOracleLookup(dsc.getColNameE() + "_" + lookups.get(dsc),
//						dsc.getNotes());
//			}
//			
//			Map<String, Object>  queryResult=query.getJSON();
//			this.json.put("success",  true);
//			this.json.put("json", queryResult);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			new HashMap<String, Object>();
//			this.json.put("success",  false);
//			this.json.put("message",  "执行查询出错，请检查方案是否合理！");
//			return "failure";
//		}
            logger.info("sql2===" + sb.toString());
            list = mapper.queryResult(sb.toString());
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(0).put("sql", sb.toString());
                }
            }

        } catch (BadSqlGrammarException e) {
            e.printStackTrace();
//			new HashMap<String, Object>();
//			this.json.put("success",  false);
//			this.json.put("message",  "执行查询出错，请检查方案是否合理！");
            return null;
        }

        return list;
    }

    //拼接sql
    public Map<String, Object> generatorSql(JSONArray jaCondition,
                                            JSONArray jaColumns, String groupParams, String sumParams, String groupsql) {
//		AuthUser auth = (AuthUser) SecurityContextHolder.getContext()
//				.getAuthentication().getPrincipal();
        String conditionColumns = "";
        for (Object oa : jaCondition) {
            //JSONArray joa = (JSONArray) oa;
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
        sb.append("SELECT cols.* FROM CIMP_F_FQ_DBCOL cols WHERE cols.id in (" + conditionColumns + ")");
        List<CimpFFqDbcol> conditionColumnsObj = mapper.getResultList(sb.toString());

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
        sbsql.append("SELECT * FROM CIMP_F_FQ_DBCOL cols WHERE cols.id in (" + resultColumnsId + ")");
        List<CimpFFqDbcol> dscs = mapper.queryColumns(sbsql.toString());


        String tables = "0";
        if (!dscs.isEmpty()) {
            for (CimpFFqDbcol dsc : dscs) {
                tables += "," + dsc.getDbtableId();
            }
        }
        for (CimpFFqDbcol dsc : conditionColumnsObj) {
            tables += "," + dsc.getDbtableId();
        }
        String relTable = "0";
        for (CimpFFqDbcol table : dscs) {
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
        leftsql.append("SELECT col.* FROM CIMP_F_FQ_OBJ col WHERE col.id in (select t.obj_Id from CIMP_F_FQ_Group t where  t.id in (SELECT cols.group_Id FROM CIMP_F_FQ_Dbcol cols WHERE cols.id in ("
                + resultColumnsId + ")))");
        List<CimpFFqObj> leftTabs = cimpFFqObjMapper.queryLeftTab(leftsql.toString());

        logger.info("leftsql.toString()==" + leftsql.toString());
        String leftTab = "";
        String leftTabId = "";
        for (CimpFFqObj left : leftTabs) {
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
        relationsql.append("SELECT osr.* FROM CIMP_F_Fq_Relation osr WHERE osr.join_Left_Table in ("
                + leftTabId//左表
                + ") and osr.join_Right_Table in (" + relTable
                + ")");
        List<CimpFFqRelation> ofasrs = cimpFFqRelationMapper.queryRelations(relationsql.toString());


        String joinColumns = "0";
        for (CimpFFqRelation ofasr : ofasrs) {
            joinColumns += "," + ofasr.getJoinLeftCol() + ","
                    + ofasr.getJoinRightCol();
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
        colsql.append("SELECT * FROM cimp_F_Fq_Dbcol cols WHERE cols.id in ("
                + joinColumns + ")");
        logger.info("colsql==" + colsql.toString());
        List<CimpFFqDbcol> joinColumnsObj = mapper.queryJoinColumms(colsql.toString());

        // 连表语句
        logger.info("leftTab==" + leftTab);
        String joinSQL = FlexibleQueryUtils.createTableJoin(leftTab, ofasrs,
                joinColumnsObj);
        // SELECT语句
        logger.info("joinSQL==" + joinSQL);
        String selectSQL = FlexibleQueryUtils.createSelectColumns(dscs,
                jaColumns, groupParams, sumParams);
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
        Map<CimpFFqDbcol, String> look = new HashMap<CimpFFqDbcol, String>();
        for (CimpFFqDbcol l : dscs) {
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
        String finalSql = "SELECT " + selectSQL + " FROM " + joinSQL + groupSQL
                + " WHERE " + whereSQL + groupwhereSQL;

        //权限过滤,根据custinfo主表关联配置权限
//		finalSql+=FlexibleQueryUtils.getAuthorityString(auth);

        //分组排序
        if (!groupBySQL.equals("")) {
            finalSql += " GROUP BY " + groupBySQL;
            finalSql += " ORDER BY " + groupBySQL;
        } else {
            if (!orderSQL.equals("")) {
                finalSql += " ORDER BY " + orderSQL;
            }
        }

        lastResult.put("SQL", finalSql);
        lastResult.put("lookupColumns", look);
        return lastResult;
    }

    public String generateTopSql(String sql, String topField, String topNum) {
        //根据topField查询表名称和列名称,如果是 ACRM_F_CI_CUSTOMER 表 ，别名强制替换成custinfo
        String finalsql = sql;
        if (!"".equals(topField) && topField != null) {
//			Object ss1=em.createNativeQuery(" select p.col_name_e from ACRM_F_FQ_DBCOL p where  p.id='"+topField+"' ").getSingleResult();

            StringBuilder colsql = new StringBuilder();
            colsql.append(" select p.col_name_e from CIMP_F_FQ_DBCOL p where  p.id='" + topField + "' ");
            String colNName = mapper.getSingleResult(colsql.toString());

//			Object  ss2=em.createNativeQuery("select p.DBTABLE_NAME,p.ALIAS from ACRM_F_FQ_DBCOL p where  p.id='"+topField+"'  ").getSingleResult();
            StringBuilder sqls = new StringBuilder();
            sqls.append("select p.DBTABLE_NAME,p.ALIAS from CIMP_F_FQ_DBCOL p where  p.id='" + topField + "'  ");
            List<CimpFFqDbcol> ss2 = mapper.getSingleResults(sqls.toString());

            String tbName = (String) ss2.get(0).getDbtableName();
            String tbNName = (String) ss2.get(0).getAlias();
            if (tbName.equals(FlexibleQueryUtils.CUST_MAIN_INFO_TABLE)) {
                tbNName = "custinfo";
            }

            finalsql += " order by " + tbNName + "." + colNName + " ";
        }
        Log.info("topNum1=" + topNum);
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
    public List<CimpFFqDbcol> getDataSetSolution() {
        List<CimpFFqDbcol> list = mapper.getDataSetSolution();
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

}
