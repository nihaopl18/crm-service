package cn.com.yusys.yusp.cm.cust.service;

import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.cm.cust.domain.CimFMmTagDataSource;
import cn.com.yusys.yusp.cm.cust.domain.CimFMmTagTagsInfo;
import cn.com.yusys.yusp.cm.cust.domain.CimFTagCustTags;
import cn.com.yusys.yusp.cm.cust.repository.mapper.CimFTagCustTagsMapper;
import cn.com.yusys.yusp.cm.cust.repository.mapper.MergeCimFMmTagDataSourceMapper;
import cn.com.yusys.yusp.cm.cust.repository.mapper.MergeCimFMmTagTagsInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @version 1.0.0
 * @项目名称: yusp-app-cm
 * @类名称: CimFTagCustTagsService
 * @类描述:
 * @功能描述: 标签客户信息
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2018年10月08日
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */

@Service
public class CimFTagCustTagsService extends CommonService {
    @Autowired
    private CimFTagCustTagsMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(CimFTagCustTagsService.class);
    @Autowired
    private UserInfoService userInfo;
    @Autowired
    private MergeCimFMmTagTagsInfoMapper cimFMmTagTagsInfoMapper;
    @Autowired
    private MergeCimFMmTagDataSourceMapper cimFMmTagDataSourceMapper;

    @Override
    protected CommonMapper getMapper() {
        // TODO Auto-generated method stub
        return this.mapper;
    }

    @Transactional(readOnly = true)
    public List<String> getListByTags(List list) {
        return this.mapper.getCustIdsByTags(list);
    }

    /**
     * 查询信息
     *
     * @throws JsonProcessingException
     */
    @Transactional(readOnly = true)
    public List<CimFTagCustTags> getListByTags(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        String SQL = "";
        //无条件查询
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT  C.CUST_ID,C.CUST_NAME,C.IDENT_TYPE,C.IDENT_NO,C.CUST_TYPE, C.CUST_STAT ")
                .append(" FROM ACIM_F_CI_CUSTOMER  c  ");
        //.append(" WHERE 1=1  ");

        SQL = sb.toString();
        logger.info("SQL1============" + SQL);
        //标签查询条件
        logger.info("tagIdGroup============" + model.getCondition().containsKey("tagIdGroup"));
        if (model.getCondition().containsKey("tagIdGroup")) {
            //判断传参不为空
            List groupInfo = (List) model.getCondition().get("tagIdGroup");
            logger.info("groupInfo============" + groupInfo);
            if (groupInfo != null && !groupInfo.isEmpty()) {
                SQL = getSearchSql(groupInfo);
            }
        }
        logger.info("SQL2============" + SQL);

        model.getCondition().put("SQL", SQL);
        List<CimFTagCustTags> list = mapper.getListByTags(model);
//		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
//		list = mapper.getListByTags(model);
        String QRYSQL = SQL + "ORDER BY c.CUST_ID desc";
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ((Map) list.get(0)).put("sql", QRYSQL);
            }
        }
        PageHelper.clearPage();
        return list;
    }


    private String getSearchSql(List groupInfo) {
        String sql = "";
        String preString = " SELECT C.CUST_ID, C.CUST_NAME,C.IDENT_TYPE, C.IDENT_NO, C.CUST_TYPE,C.CUST_STAT FROM ( ";
        String sufString = " ) t  left join ACIM_F_CI_CUSTOMER c on t.cust_id = c.cust_Id  ";
        String preSelectString = " select t0.cust_id from ";
        String joinString = " inner join ";
        JSONArray groups = JSONArray.fromObject(groupInfo);

        sql = preString;

        //根据组数获得每一组的sql
        for (int i = 0; i < groups.size(); i++) {
            JSONObject group = (JSONObject) groups.get(i);
            JSONArray tags = (JSONArray) group.get("stu");
            String tagString = "";
            String sufGroupString = "";
            if (i == 0) {
                tagString = preSelectString;
                sufGroupString = " ) t" + i + " ";
            } else {
                tagString = joinString;
                sufGroupString = " ) t" + i + "  on t" + (i - 1) + ".cust_id = t" + i + ".cust_id ";
            }
            String preGroupString = " (select cust_id from CIM_F_TAG_CUST_TAGS tag" + i + "  ";

            String whereString = " where ( ";
            logger.info("songer============" + tags.size());
            for (int j = 0; j < tags.size(); j++) {

                if (j > 0) {
                    whereString += " or tag" + i + ".tag_no = '" + tags.getString(j) + "' ";
                } else {
                    whereString += " tag" + i + ".tag_no = '" + tags.getString(j) + "' ";
                }
            }
            whereString += " )";
            tagString += (preGroupString + whereString + sufGroupString);
            sql += tagString;
        }
        sql += sufString;
        logger.info("songersql============" + sql);
        return sql;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> qryTags(String custId) {
        Map<String, Object> params = new HashMap<String, Object>();
        int today = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis())));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new java.util.Date());
        // 设置创建日期，最近更新日期
        params.put("today", time);
        logger.info("today=" + today);
        params.put("custId", custId);
        List<Map<String, Object>> list = mapper.qryTags(params);
        return list;
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

    /**
     * 新增标签
     *
     * @param record
     * @return
     */
    @Transactional(readOnly = true)
    public int addTags(CimFTagCustTags record) throws ParseException {
        int number = 1;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        SimpleDateFormat dfdate = new SimpleDateFormat("yyyy-MM-dd 00:00:00");// 设置日期格式
        // 设置创建日期，最近更新日期
        //tag.setCreateDate(new Date(df.parse(time).getTime()));
        String str = "9999-12-31 00:00:00";
        String time = df.format(new java.util.Date());
        String datastart = dfdate.format(new java.util.Date());
        record.setId(getUUID());
        record.setCreateDate(new Date(df.parse(time).getTime()));
        record.setCreateUser(SecurityUtils.getCurrentUserLogin());

        record.setCreateOrg(userInfo.getOrgCode());

        CimFMmTagTagsInfo recordss = new CimFMmTagTagsInfo();
        recordss.setTagNo(mapper.getSeq());
        recordss.setGroupNo("1705");
        recordss.setParentNo("1023");
        recordss.setTagName(record.getTagName());
        recordss.setCreateUser(SecurityUtils.getCurrentUserLogin());
        recordss.setCreateOrg(userInfo.getOrgCode());
        recordss.setAvailableDate(new Date(df.parse(time).getTime()));
        recordss.setCreateDate(new Date(df.parse(time).getTime()));
        recordss.setDisableDate(new Date(df.parse(str).getTime()));
        recordss.setCreateSys("CRM");
        recordss.setTagLifecycle("RUNNING");
        recordss.setLastUpdateDt(time);
        recordss.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
        recordss.setProcessMode("MANUAL");

        CimFMmTagDataSource tagDatasource = new CimFMmTagDataSource();
        tagDatasource.setSysNo("MANUAL");
        tagDatasource.setEntityNo("MANUAL");
        tagDatasource.setEntityProp("MANUAL");
        tagDatasource.setEntityType("MANUAL");
        tagDatasource.setDateStart(new Date(df.parse(datastart).getTime()));
        tagDatasource.setDateEnd(new Date(df.parse(str).getTime()));
        tagDatasource.setID(getUUID());
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("today", time);
        params.put("custId", record.getCustId());
        params.put("tagName", record.getTagName());
        //校验标签表是否有此标签名
        List<CimFTagCustTags> detailLists = this.mapper.qryByTagsname(params);
        if (detailLists.size() == 0) {//如果没有，则新增到标签表和标签客户表
            //新增到标签表中
            if (cimFMmTagTagsInfoMapper.insertSelective(recordss) != 1) {
                return 0;
            }

            //查询新增到标签表中的数据然后新增到客户标签表中
            List<CimFTagCustTags> tagLists = this.mapper.qryByTagsname(params);
            if (tagLists.size() > 0) {
                logger.info("addTags cust defined begin=====");
                record.setTagNo(tagLists.get(0).getTagNo());
                tagDatasource.setTagNo(tagLists.get(0).getTagNo());
                record.setAvailableDate((Date) tagLists.get(0).getAvailableDate());
                record.setDisableDate((Date) tagLists.get(0).getDisableDate());
                //新增到数据来源表中
                if (cimFMmTagDataSourceMapper.insertSelective(tagDatasource) != 1) {
                    return 0;
                }
                //新增到客户标签表中
                if (this.insertSelective(getMapper(), record) != 1) {
                    return 0;
                }
                logger.info("addTags cust defined end=====");
            }
        } else if (detailLists.size() > 0) {//如果标签表有此标签
            record.setTagNo(detailLists.get(0).getTagNo());
            record.setAvailableDate((Date) detailLists.get(0).getAvailableDate());
            record.setDisableDate((Date) detailLists.get(0).getDisableDate());
            //查询校验该客户下是否已经有此标签
            List<Map<String, Object>> detailList = this.mapper.qryTagsname(params);
            if (detailList.size() > 0) {
                //返回message“该客户下已经有此自定义标签”
                return -1;
            } else {//新增到该客户下标签
                if (this.insertSelective(getMapper(), record) != 1) {
                    return 0;
                }
            }
        }

        return number;
    }

    /**
     * 更新标签
     *
     * @param record
     * @return
     */
    @Transactional(readOnly = true)
    public int updateTags(CimFTagCustTags record) throws ParseException {
        int number = 1;
        //先删除该客户下所有标签
        this.mapper.delcustTags(record.getCustId());

        logger.info("record.getTagNo()=====" + record.getTagNo());
        if (StringUtils.isEmpty(record.getTagNo()) || record.getTagNo() == null) {
            return number;
        } else {
            String arr[] = record.getTagNo().split(",");//标签编号
            //然后每个标签进行循环新增
            for (int j = 0; j < arr.length; j++) {
                //根据tagNo查询标签库中生效失效时间
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
                String time = df.format(new java.util.Date());
                List<CimFTagCustTags> availableList = this.mapper.qryAvailable(arr[j], time);
                if (availableList.size() > 0) {//查询结果有生效的数据则新增
                    logger.info("updateTags cust defined begin=====");
                    record.setAvailableDate((Date) availableList.get(0).getAvailableDate());
                    record.setDisableDate((Date) availableList.get(0).getDisableDate());
                    record.setTagName(availableList.get(0).getTagName());
                    record.setTagNo(arr[j]);
                    record.setId(getUUID());
                    record.setCreateDate(new Date(df.parse(time).getTime()));
                    record.setCreateUser(SecurityUtils.getCurrentUserLogin());
                    record.setCreateOrg(userInfo.getOrgCode());
                    if (this.insertSelective(getMapper(), record) != 1) {
                        return 0;
                    }
                    logger.info("updateTags cust defined end=====");
                } else {
                    return 0;
                }
            }
        }
        return number;
    }

    /**
     * 查询信息
     *
     * @throws JsonProcessingException
     */
    public List<CimFTagCustTags> getAuthData(QueryModel model) throws JsonProcessingException {
        return this.mapper.getAuthData(model);
    }
}
