package cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.repository.mapper;

import java.util.List;

import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.domain.PmaFEvlIndexInfoEntity;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFEvlIndexInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-31 14:11:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFEvlIndexInfoMapper extends CommonMapper<PmaFEvlIndexInfoEntity> {
	List<PmaFEvlIndexInfoEntity> querylist(QueryModel model);
	List<String> queryNames(@Param("objId") String[] objId);

    void startOrStopState(@Param("ids") JSONArray ids, @Param("statFlag") String statFlag);
}