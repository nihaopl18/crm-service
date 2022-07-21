package cn.com.yusys.yscrm.sysview.service;

import cn.com.yusys.yscrm.sysview.domain.*;
import cn.com.yusys.yscrm.sysview.repository.mapper.CimFMmTagCustomerTagsMapper;
import cn.com.yusys.yscrm.sysview.repository.mapper.CimFMmTagDataSourceMapper;
import cn.com.yusys.yscrm.sysview.repository.mapper.CimFMmTagTagsInfoMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 客户标签
 *
 * @author: sxm
 * @time: 2021/9/6 11:40
 */
@Service
public class CimFMmTagCustomerTagsService {
    @Autowired
    private CimFMmTagCustomerTagsMapper mapper;
    private static final String MANUAL =  "MANUAL";
    @Autowired
    private CimFMmTagTagsInfoMapper cimFMmTagTagsInfoMapper;

    @Autowired
    private CimFMmTagDataSourceMapper sourceMapper;

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public int setTagDisplay(TagDisplay tagDisplay) {
        Map map = new HashMap();
        int n = 0;
        map.put("custId", tagDisplay.getCustId());
        for (CustomTag obj : tagDisplay.getCustomTags()) {
            map.put("display", obj.getDisplay());
            map.put("tagNo", obj.getTagNo());
            n = mapper.updateTagDisplay(map);
        }
        return n;
    }
    @Transactional(readOnly = true)
    public List<CustSysGroup> custSysTag(QueryModel queryModel) {

        return mapper.custSysTag(queryModel);
    }

    public ResultDto<CimFMmTagTagsInfo> insertTagList(CimFMmTagTagsInfo tag) throws ParseException {
        // 设置创建人，创建机构
        int num = 0;
        CimFTagCustTags cimFTagCustTags=new CimFTagCustTags();
        tag.setCreateUser(SecurityUtils.getCurrentUserLogin());
        cimFTagCustTags.setCreateUser(SecurityUtils.getCurrentUserLogin());
        cimFTagCustTags.setCreateOrg(tag.getCreateOrg());
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df_create = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String time = df.format(new java.util.Date());
        String time_create = df_create.format(new java.util.Date());
        // 设置创建日期，最近更新日期
        tag.setCreateDate(new Date(df_create.parse(time_create).getTime()));
        cimFTagCustTags.setCreateDate(new Date(df_create.parse(time_create).getTime()));
        tag.setLastUpdateDt(time_create);
        // 设置最近更新人
        tag.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
        // 设置标签编号
        String id=cimFMmTagTagsInfoMapper.getTagSeq();
        tag.setTagNo(id);
        cimFTagCustTags.setTagNo(id);
        cimFTagCustTags.setTagName(tag.getTagName());
        // 设置生效日期、失效日期格式
        if(tag.getAvailableDate()!=null){
            tag.setAvailableDate(new Date(df.parse(df.format(tag.getAvailableDate())).getTime()));
            cimFTagCustTags.setAvailableDate(new Date(df.parse(df.format(tag.getAvailableDate())).getTime()));
        }else {
            tag.setAvailableDate(new Date(df.parse(df.format(new java.util.Date())).getTime()));
            cimFTagCustTags.setAvailableDate(new Date(df.parse(df.format(new java.util.Date())).getTime()));
        }
        if (tag.getDisableDate()!=null){
            tag.setDisableDate(new Date(df.parse(df.format(tag.getDisableDate())).getTime()));
            cimFTagCustTags.setDisableDate(new Date(df.parse(df.format(tag.getDisableDate())).getTime()));
        }else{
            tag.setDisableDate(new Date(df.parse(df.format(new Date(new GregorianCalendar(9999, Calendar.DECEMBER, 31).getTimeInMillis()))).getTime()));
            cimFTagCustTags.setDisableDate(new Date(df.parse(df.format(new Date(new GregorianCalendar(9999, Calendar.DECEMBER, 31).getTimeInMillis()))).getTime()));
        }
        cimFTagCustTags.setId(getUUID());
        //设置标签展示
        cimFTagCustTags.setDisplay("1");
        cimFTagCustTags.setCustId(tag.getCustId());
        //设置类型为自定义标签
        tag.setSystemTag("0");
        // 新增标签数据插入数据来源表
        CimFMmTagDataSource tagDatasource = new CimFMmTagDataSource();
        tagDatasource.setSysNo(MANUAL);
        tagDatasource.setEntityNo(MANUAL);
        tagDatasource.setEntityProp(MANUAL);
        tagDatasource.setEntityType(MANUAL);
        tagDatasource.setDateStart(tag.getAvailableDate());
        tagDatasource.setDateEnd(tag.getDisableDate());
        tagDatasource.setID(getUUID());
        tagDatasource.setTagNo(tag.getTagNo());
        sourceMapper.insertSelective(tagDatasource);

        // 设置groupNo不为空、生效日期小于失效日期时新增数据
        if (tag.getGroupNo() != null && (tag.getAvailableDate().before(tag.getDisableDate()) ||
                df.format(tag.getAvailableDate()).equals(df.format(tag.getDisableDate())))) {
            num = cimFMmTagTagsInfoMapper.insertSelective(tag);
        }
        ResultDto<CimFMmTagTagsInfo> resultDto = null;
        if (num < 1 || cimFMmTagTagsInfoMapper.getGroupNo(tag.getGroupNo()).get("num").toString().equals("0")) {
            resultDto = new ResultDto<CimFMmTagTagsInfo>();
            resultDto.setCode(-1);
            resultDto.setMessage("新增失败");
        } else {
            resultDto = new ResultDto<CimFMmTagTagsInfo>(tag);
            resultDto.setCode(0);
            resultDto.setMessage("新增成功");
            num=mapper.insertSelective(cimFTagCustTags);
            if (num < 1 ) {
                resultDto.setMessage("客户标签新增失败");
            } else {
                resultDto = new ResultDto<CimFMmTagTagsInfo>(tag);
                resultDto.setCode(0);
                resultDto.setMessage("客户标签新增成功");
            }
        }
        return resultDto;

    }


    private String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public Integer addcusttag(CimFMmTagTagsInfo tag) throws ParseException {
        CimFTagCustTags cimFTagCustTags = new CimFTagCustTags();
        cimFTagCustTags.setCreateUser(SecurityUtils.getCurrentUserLogin());
        cimFTagCustTags.setCreateOrg(tag.getCreateOrg());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df_create = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_create = df_create.format(new java.util.Date());
        cimFTagCustTags.setCreateDate(new Date(df_create.parse(time_create).getTime()));
        cimFTagCustTags.setTagNo(tag.getTagNo());
        cimFTagCustTags.setTagName(tag.getTagName());
        if(tag.getAvailableDate()!=null){
            cimFTagCustTags.setAvailableDate(new Date(df.parse(df.format(tag.getAvailableDate())).getTime()));
        }else {
            cimFTagCustTags.setAvailableDate(new Date(df.parse(df.format(new java.util.Date())).getTime()));
        }
        if (tag.getDisableDate()!=null){
            cimFTagCustTags.setDisableDate(new Date(df.parse(df.format(tag.getDisableDate())).getTime()));
        }else{
            cimFTagCustTags.setDisableDate(new Date(df.parse(df.format(new Date(new GregorianCalendar(9999, Calendar.DECEMBER, 31).getTimeInMillis()))).getTime()));
        }
        cimFTagCustTags.setId(getUUID());
        cimFTagCustTags.setDisplay("1");
        cimFTagCustTags.setCustId(tag.getCustId());
        return mapper.insertSelective(cimFTagCustTags);
    }

    public Integer removecusttag(String tagNo, String custId) {
        return mapper.removecusttag(tagNo,custId);
    }
}
