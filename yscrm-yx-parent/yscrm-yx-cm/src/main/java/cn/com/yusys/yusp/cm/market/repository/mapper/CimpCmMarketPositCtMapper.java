package cn.com.yusys.yusp.cm.market.repository.mapper;

import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketPositCt;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;

/**
 * @项目名称:yscimc-app-cm模块
 * @类名称: CimpCmMarketPositCtMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-06-11 15:33:32
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface CimpCmMarketPositCtMapper extends CommonMapper<CimpCmMarketPositCt> {

    List<CimpCmMarketPositCt> getMarketPositCtByActId(String actId);
}