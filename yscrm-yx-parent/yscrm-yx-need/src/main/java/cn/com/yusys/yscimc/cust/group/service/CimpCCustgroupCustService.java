package cn.com.yusys.yscimc.cust.group.service;

import cn.com.yusys.yscimc.cust.group.domain.CimpCCustgroupCust;
import cn.com.yusys.yscimc.cust.group.repository.mapper.CimpCCustgroupCustMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0.0
 * @项目名称: yscimc-cust-group模块
 * @类名称: CimpCcustgroupCustService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-05-06 11:26:02
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CimpCCustgroupCustService extends CommonService {
    @Autowired
    private CimpCCustgroupCustMapper mapper;

    @Override
    public CommonMapper getMapper() {
        // TODO 自动生成的方法存根
        return this.mapper;
    }

    public int checkBe(CimpCCustgroupCust c) {
        // TODO 自动生成的方法存根
        int num = mapper.checkBe(c);
        return num;
    }

    public ResultDto<Integer> joinGroup(CimpCCustgroupCust c) {
        // TODO 自动生成的方法存根
        ResultDto<CimpCCustgroupCust> resultDto = null;
        if (insertSelective(getMapper(), c) == 1) {
            resultDto = new ResultDto<>(c);
            resultDto.setMessage("加群成功");
            resultDto.setCode(0);
            return new ResultDto<>(0);
        }
        ;
        resultDto = new ResultDto<>();
        resultDto.setMessage("加群失败");
        resultDto.setCode(-1);
        return new ResultDto<>(-1);
    }

    public ResultDto<Integer> outGroup(CimpCCustgroupCust c) {
        // TODO 自动生成的方法存根
        ResultDto<CimpCCustgroupCust> resultDto = null;
        if (mapper.outGroup(c) == 1) {
            int a = mapper.setCustNums("" + mapper.getCustNums(c.getCustGroupId()) + "", c.getCustGroupId());
            if (a == 1) {
                resultDto = new ResultDto<>(c);
                resultDto.setMessage("移出成功");
                resultDto.setCode(0);
                return new ResultDto<>(0);
            }
            ;
            resultDto = new ResultDto<>(c);
            resultDto.setMessage("移出失败");
            resultDto.setCode(-1);
            return new ResultDto<>(-1);
        }
        ;
        resultDto = new ResultDto<>();
        resultDto.setMessage("移除失败");
        resultDto.setCode(-1);
        return new ResultDto<>(-1);
    }

    public int updPro(QueryModel model) {
        // TODO 自动生成的方法存根
        String[] ids = ((String) model.getCondition().get("ids")).split(",");
        String proids = (String) model.getCondition().get("proids");
        int num = 0;
        for (int i = 0; i < ids.length; i++) {
            String id = ids[i];
            CimpCCustgroupCust c = new CimpCCustgroupCust();
            c.setId(id);
            c.setMarkeProPri(proids);
//			Util.updateUtl(c);
            num += mapper.updPro(c);
        }
        return num;
    }

    public int getCustNums(String id) {
        return this.mapper.getCustNums(id);
    }

    public void insertAll(String sql) {
        mapper.insertAll(sql);
    }

    public void deleteByGroupId(String customerGroupId) {
        this.mapper.delCustAll(customerGroupId);
    }

    /**
     * 通过客户群编号查询所有客户群成员编号
     *
     * @param custGroupId
     * @return
     */
    public List<String> getCustIdsByGroupId(String custGroupId) {
        return mapper.getCustIdsByGroupId(custGroupId);
    }

    ;
}
