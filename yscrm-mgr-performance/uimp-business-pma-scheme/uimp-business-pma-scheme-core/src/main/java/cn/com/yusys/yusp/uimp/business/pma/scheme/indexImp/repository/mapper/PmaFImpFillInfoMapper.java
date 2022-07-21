package cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.repository.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.domain.PmaFImpFillInfo;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFImpFillInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-15 17:34:04
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFImpFillInfoMapper extends CommonMapper<PmaFImpFillInfo> {
	List<PmaFImpFillInfo> querylist(QueryModel model);
	List<Map<String, Object>> queryDatalist(QueryModel model);
	List<Map<String, Object>> datelist(QueryModel model);
	int delImpInfo(@Param("statDate") String statDate,@Param("evlObjId") String evlObjId,@Param("indexId") String indexId,
			@Param("evlObjType") String evlObjType,@Param("balTypeId") String balTypeId,@Param("applyTypeId") String applyTypeId);

	List<Map<String, Object>> queryIndexList(QueryModel model);

	/**
	 * 判断该数据是否已经存在
	 *
	 * @param fillInfo 数据信息
	 * @return 数据
	 * @author weixy6
	 * @date 2022/6/16
	 */
	Map<String, Object> queryExistData(PmaFImpFillInfo fillInfo);
}