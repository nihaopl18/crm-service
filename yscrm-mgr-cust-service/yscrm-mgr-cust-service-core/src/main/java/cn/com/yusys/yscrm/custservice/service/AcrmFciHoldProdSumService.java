package cn.com.yusys.yscrm.custservice.service;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custservice.domain.AcrmFciHoldProdSum;
import cn.com.yusys.yscrm.custservice.repository.mapper.AcrmFciHoldProdSumMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: ccccc模块
 * @类名称: AcrmFciHoldProdSumService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 18:08:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciHoldProdSumService extends CommonService {
    @Autowired
    private AcrmFciHoldProdSumMapper acrmFciHoldProdSumMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFciHoldProdSumMapper;
    }
   public List<AcrmFciHoldProdSum> queryAll(QueryModel model){
	  return  acrmFciHoldProdSumMapper.queryAll(model);
   }
    
}
