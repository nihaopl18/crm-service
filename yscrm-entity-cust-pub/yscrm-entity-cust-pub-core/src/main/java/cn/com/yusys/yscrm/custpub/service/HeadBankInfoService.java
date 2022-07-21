package cn.com.yusys.yscrm.custpub.service;

import cn.com.yusys.yscrm.custpub.repository.mapper.HeadBankInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: HeadBankInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-10-26 17:29:59
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class HeadBankInfoService{

    @Autowired
    private HeadBankInfoMapper headBankInfoMapper;

    public List<Map<String, Object>> getBusiView() {
        return headBankInfoMapper.getBusiView();
    }

    public Map<String, Object> getCustView() {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> custType = headBankInfoMapper.getCustType();
        map.put("custType",custType);
        List<Map<String, Object>> custGrade = headBankInfoMapper.getCustGrade();
        map.put("custGrade",custGrade);
        List<Map<String, Object>> custOrg = headBankInfoMapper.getCustOrg();
        map.put("custOrg",custOrg);
        return map;
    }

    public Map<String, Object> getEmpView() {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> cardInfo = headBankInfoMapper.getCardInfo();
        map.put("cardInfo",cardInfo);
        List<Map<String, Object>> tableInfo = headBankInfoMapper.getTableInfo();
        map.put("tableInfo",tableInfo);
        return map;
    }
}
