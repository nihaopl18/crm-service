package cn.com.yusys.yscimc.cust.group.repository.mapper;

import cn.com.yusys.yscimc.cust.group.domain.CimpCCustgroupCust;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 1.0.0
 * @项目名称: yscimc-cust-group模块
 * @类名称: CimpCcustgroupCustMapper
 * @类描述: #Dao类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-05-06 11:26:02
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface CimpCCustgroupCustMapper extends CommonMapper<CimpCCustgroupCust> {
    int checkBe(CimpCCustgroupCust c);

    int outGroup(CimpCCustgroupCust c);

    int getCustNums(String custGroupId);

    int setCustNums(@Param("custNum") String custNum, @Param("custGroupId") String custGroupId);

    int updPro(CimpCCustgroupCust c);

    int updProd(CimpCCustgroupCust c);

    int delCustAll(String id);

    void insertAll(@Param("sql") String sql);

    /**
     * 通过客户群编号查询所有客户群成员编号
     *
     * @param custGroupId
     * @return
     */
    List<String> getCustIdsByGroupId(String custGroupId);
}