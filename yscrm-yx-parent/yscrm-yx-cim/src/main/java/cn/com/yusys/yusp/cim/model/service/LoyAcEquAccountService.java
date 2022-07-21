package cn.com.yusys.yusp.cim.model.service;

import cn.com.yusys.yusp.cim.model.domain.LoyAcEquAccount;
import cn.com.yusys.yusp.cim.model.repository.mapper.LoyAcEquAccountMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: yscimc-cust-group模块
 * @类名称: LoyAcEquAccountService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-05-27 18:17:31
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyAcEquAccountService extends CommonService {
    @Autowired
    private LoyAcEquAccountMapper loyAcEquAccountMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return loyAcEquAccountMapper;
    }

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public int add(LoyAcEquAccount loyAcEquAccount) {
        // TODO 自动生成的方法存根
        Date date = new Date();
        loyAcEquAccount.setCreateDate(date);
        loyAcEquAccount.setUpdateDate(date);
        loyAcEquAccount.setApprStat("000");
        loyAcEquAccount.setIsDel("1");
        loyAcEquAccount.setAccountId(loyAcEquAccountMapper.getAccountSeq());
        return insertSelective(getMapper(), loyAcEquAccount);
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> getListByModel(QueryModel model) {
        // TODO 自动生成的方法存根
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = loyAcEquAccountMapper.getListByModel(model);
        PageHelper.clearPage();
        return list;
    }

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public int upd(LoyAcEquAccount loyAcEquAccount) {
        // TODO 自动生成的方法存根
        loyAcEquAccount.setUpdateDate(new Date());
        return updateSelective(getMapper(), loyAcEquAccount);
    }

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public int del(QueryModel model) {
        // TODO 自动生成的方法存根
        int num = 0;
        String[] ids = ((String) model.getCondition().get("ids")).split(",");
        for (int i = 0; i < ids.length; i++) {
            LoyAcEquAccount loyAcEquAccount = new LoyAcEquAccount();
            loyAcEquAccount.setAccountId(ids[i]);
            loyAcEquAccount.setIsDel("0");
            num += updateSelective(getMapper(), loyAcEquAccount);
        }
        return num;
    }

    @Transactional(readOnly = true)
    public LoyAcEquAccount getInfoById(String BizSeqNo) {
        // TODO 自动生成的方法存根
        return loyAcEquAccountMapper.getInfoById(BizSeqNo);
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> getFinanceOrg(QueryModel model) {
        // TODO 自动生成的方法存根
        return loyAcEquAccountMapper.getFinanceOrg(model);
    }

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public int upload(Map<String, String> map) {
        // TODO 自动生成的方法存根
        int num = 0;
        String[] ids = map.get("ids").split(",");
        String updateOrg = map.get("updateOrg");
        String updateUser = map.get("updateUser");
        for (int i = 0; i < ids.length; i++) {
            LoyAcEquAccount loyAcEquAccount = new LoyAcEquAccount();
            loyAcEquAccount.setAccountId(ids[i]);
            loyAcEquAccount.setUpdateDate(new Date());
            loyAcEquAccount.setUpdateOrg(updateOrg);
            loyAcEquAccount.setUpdateUser(updateUser);
            loyAcEquAccount.setAcctStat("1");
            num += updateSelective(getMapper(), loyAcEquAccount);

        }
        return num;
    }

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public int download(Map<String, String> map) {
        // TODO 自动生成的方法存根
        int num = 0;
        String[] ids = map.get("ids").split(",");
        String updateOrg = map.get("updateOrg");
        String updateUser = map.get("updateUser");
        for (int i = 0; i < ids.length; i++) {
            LoyAcEquAccount loyAcEquAccount = new LoyAcEquAccount();
            loyAcEquAccount.setAccountId(ids[i]);
            loyAcEquAccount.setUpdateDate(new Date());
            loyAcEquAccount.setUpdateOrg(updateOrg);
            loyAcEquAccount.setUpdateUser(updateUser);
            loyAcEquAccount.setAcctStat("2");
            num += updateSelective(getMapper(), loyAcEquAccount);

        }
        return num;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> getOrgTreeByInstu(QueryModel model) {
        // TODO 自动生成的方法存根
        return loyAcEquAccountMapper.getOrgTreeByInstu(model);
    }

}
