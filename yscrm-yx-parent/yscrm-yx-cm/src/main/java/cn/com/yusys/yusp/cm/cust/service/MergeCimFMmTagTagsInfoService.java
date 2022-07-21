package cn.com.yusys.yusp.cm.cust.service;

import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.cm.cust.domain.CimFMmTagDataSource;
import cn.com.yusys.yusp.cm.cust.domain.CimFMmTagTagsInfo;
import cn.com.yusys.yusp.cm.cust.repository.mapper.MergeCimFMmTagDataSourceMapper;
import cn.com.yusys.yusp.cm.cust.repository.mapper.MergeCimFMmTagTagsInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @version 1.0.0
 * @项目名称: yusp-app-cim
 * @类名称: CimFMmTagTagsInfoService
 * @类描述:
 * @功能描述: 标签管理
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018年09月28日
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class MergeCimFMmTagTagsInfoService extends CommonService {
    @Autowired
    private MergeCimFMmTagTagsInfoMapper mapper;
    //	@Autowired
//	private CimpCCgBaseinfoMapper ccmapper;
    @Autowired
    private MergeCimFMmTagDataSourceMapper sourceMapper;
    @Autowired
    private UserInfoService userInfo;

    @Override
    protected CommonMapper<?> getMapper() {
        // TODO Auto-generated method stub
        return this.mapper;
    }

    /*
     * 查询标签列表
     */
    @Transactional(readOnly = true)
    public List<CimFMmTagTagsInfo> getTagList(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        List<CimFMmTagTagsInfo> list = mapper.getTagList(model);
        PageHelper.clearPage();
        return list;
    }

    /*
     * 判断标签名称是否重复
     */
    public List<Map<String, Object>> judgeSameTag(CimFMmTagTagsInfo tag) {
        List<Map<String, Object>> hashmap = this.mapper.judgeSameTag(tag);
        return hashmap;
    }

    /*
     * 更新标签内容
     */
    public int updateTagList(CimFMmTagTagsInfo tag) throws ParseException {
        // 设置最近更新人
        tag.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df_lud = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df_lud.format(new java.util.Date());
        // 设置最近更新日期
        tag.setLastUpdateDt(time);
        // 设置生效日期、失效日期格式
        tag.setAvailableDate(new Date(df.parse(df.format(tag.getAvailableDate())).getTime()));
        tag.setDisableDate(new Date(df.parse(df.format(tag.getDisableDate())).getTime()));
        return mapper.updateTagList(tag);
    }

    /*
     * 删除标签内容
     */
    public int deleteByTagNo(Map<String, Object> map) {
        return mapper.deleteByTagNo(map);
    }

    /*
     * 新增标签
     */
    public ResultDto<CimFMmTagTagsInfo> insertTagList(CimFMmTagTagsInfo tag) throws ParseException {
        // 设置创建人，创建机构
        int num = 0;
        tag.setCreateUser(SecurityUtils.getCurrentUserLogin());
        tag.setCreateOrg(userInfo.getOrgCode());
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df_create = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String time = df.format(new java.util.Date());
        String time_create = df_create.format(new java.util.Date());
        // 设置创建日期，最近更新日期
        tag.setCreateDate(new Date(df_create.parse(time_create).getTime()));
        tag.setLastUpdateDt(time_create);
        // 设置最近更新人
        tag.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
        // 设置标签编号
        tag.setTagNo(mapper.getSeq());
        // 设置生效日期、失效日期格式
        tag.setAvailableDate(new Date(df.parse(df.format(tag.getAvailableDate())).getTime()));
        tag.setDisableDate(new Date(df.parse(df.format(tag.getDisableDate())).getTime()));
        // 新增标签数据插入数据来源表
        CimFMmTagDataSource tagDatasource = new CimFMmTagDataSource();
        tagDatasource.setSysNo("MANUAL");
        tagDatasource.setEntityNo("MANUAL");
        tagDatasource.setEntityProp("MANUAL");
        tagDatasource.setEntityType("MANUAL");
        tagDatasource.setDateStart(tag.getAvailableDate());
        tagDatasource.setDateEnd(tag.getDisableDate());
        tagDatasource.setID(getUUID());
        tagDatasource.setTagNo(tag.getTagNo());
        sourceMapper.insertSelective(tagDatasource);

        // 设置groupNo不为空、生效日期小于失效日期时新增数据
        if (tag.getGroupNo() != null && (tag.getAvailableDate().before(tag.getDisableDate()) ||
                df.format(tag.getAvailableDate()).equals(df.format(tag.getDisableDate())))) {
            num = mapper.insertSelective(tag);
        }
        ResultDto<CimFMmTagTagsInfo> resultDto = null;
        if (num < 1 || mapper.getGroupNo(tag.getGroupNo()).get("num").toString().equals("0")) {
            resultDto = new ResultDto<CimFMmTagTagsInfo>();
            resultDto.setCode(-1);
            resultDto.setMessage("新增失败");
        } else {
            resultDto = new ResultDto<CimFMmTagTagsInfo>(tag);
            resultDto.setCode(0);
            resultDto.setMessage("新增成功");
        }
        return resultDto;
    }

    /**
     * 通过groupNo来查询标签
     *
     * @param model
     * @return
     */
    public List<CimFMmTagTagsInfo> getTagByGroupNo(QueryModel model) throws JsonProcessingException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        Map<String, String> map = new HashMap<String, String>();
        map.put("today", df.format(new java.util.Date()));
        map.put("groupNo", (String) model.getCondition().get("groupNo"));
        ObjectMapper jsonObj = new ObjectMapper();
        model.setCondition(jsonObj.writeValueAsString(map));
        return this.mapper.getTagByGroupNo(model);
    }

    /*
     * 返回标签分组编号
     */
    public List<Map<String, Object>> getTagNodeList(CimFMmTagTagsInfo tag) {
        List<Map<String, Object>> hashmap = this.mapper.getTagNodeList(tag);
        return hashmap;
    }

    /*
     * 批量删除标签
     */
    public int deleteByTagNos(Map<String, Object> map) {
        return mapper.deleteByTagNos(map);
    }

    /*
     * 查询审批中标签信息
     */
    public List<CimFMmTagTagsInfo> getUploadTagById(QueryModel model) {
        return mapper.getUploadTagById(model);
    }

    /*
     * 更新标签生命周期
     */
    public int setTagLifeCycle(CimFMmTagTagsInfo tag) {
        // 设置最新更新人
        tag.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new java.util.Date());
        // 设置最新更新时间
        tag.setLastUpdateDt(time);
        return mapper.setTagLifeCycle(tag);
    }

    /*
     * 查询审批中的标签
     */
    public CimFMmTagTagsInfo getTagById(String tagNo) {
        return mapper.getTagById(tagNo);
    }

    /*
     * 获取机构级别
     */
    public Map<String, Object> getOrgLevel(QueryModel model) {
        return mapper.getOrgLevel(model);
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

    /*
     * 获取客户使用的标签
     */
    public String getCustTag(String tagNo) {
        return mapper.getCustTag(tagNo);
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> qryTagBytagno(QueryModel model) {
        String tags = (String) model.getCondition().get("tag");
        String[] tag = tags.split(",");
        List<String> listtag = Arrays.asList(tag);
        List<Map<String, Object>> list = mapper.qryTagBytagno(listtag);
        return list;
    }

}
