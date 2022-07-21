package cn.com.yusys.yusp.cm.cust.service;

import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.cm.cust.domain.CimFMmFTagGroup;
import cn.com.yusys.yusp.cm.cust.repository.mapper.MergeCimFMmFTagGroupMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("")
public class MergeCimFMmFTagGroupService extends CommonService {
    @Autowired
    private MergeCimFMmFTagGroupMapper mapper;
    @Autowired
    private UserInfoService userInfo;

    private final Logger logger = LoggerFactory.getLogger(MergeCimFMmFTagGroupService.class);

    @Override
    protected CommonMapper getMapper() {
        // TODO Auto-generated method stub
        return this.mapper;
    }

    /**
     * 分组查询
     *
     * @return
     */
    public List<CimFMmFTagGroup> getGroupTree() {
        return this.mapper.getGroupTree();
    }

    /**
     * 分组新增
     *
     * @param record
     * @return
     */
    public CimFMmFTagGroup saveTagGroup(CimFMmFTagGroup record) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        java.util.Date time = null;
        try {
            time = df.parse(df.format(new Date()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        record.setCreateDate(time);
        record.setCreateUser(SecurityUtils.getCurrentUserLogin());
        record.setCreateOrg(userInfo.getOrgCode());
        System.out.println("机构代码：" + userInfo.getOrgCode());
        record.setGroupNo(this.mapper.getSeq());
        if (this.insertSelective(getMapper(), record) != 1) {
            return null;
        }
        return record;

    }

    public int deleteTagGroup(QueryModel model) {
        return this.mapper.deleteTagGroup(model);
    }

    public int updateTagGroup(CimFMmFTagGroup record) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        java.util.Date time = null;
        try {
            time = df.parse(df.format(new Date()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        record.setModifyTime(time);
        record.setModifyUser(SecurityUtils.getCurrentUserLogin());//获取用户

        return this.mapper.modifyTagGroup(record);
    }

    public List<CimFMmFTagGroup> getByParentNo(QueryModel model) {
        return this.mapper.getByParentNo(model);
    }

    public List<CimFMmFTagGroup> getChild(QueryModel model) {
        return this.mapper.getChild(model);
    }
}
