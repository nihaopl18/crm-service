package cn.com.yusys.yscrm.cust.person.repository.mapper;



import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerFinanceInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;



/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: OcrmFciPerFinanceInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-14 10:48:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PCustFinaViewMapper extends CommonMapper<OcrmFciPerFinanceInfo> {
	List<Map<Object, String>> getFinList(Map<?, ?> param);
	List<Map<Object, String>> getInvestList(Map<?, ?> param);
	List<Map<Object, String>> getIncomeList(Map<?, ?> param);
	List<Map<Object, String>> getFamilyincList(Map<?, ?> param);
	List<Map<Object, String>> getAssetsList(Map<?, ?> param);
	List<Map<Object, String>> getLiabiList(Map<?, ?> param);
	List<Map<Object, String>> getInsurList(Map<?, ?> param);
	List<Map<Object, String>> getPayList(Map<?, ?> param);
	List<Map<Object, String>> getOperList(Map<?, ?> param);
	List<Map<Object, String>> getFarmerList(Map<?, ?> param);
    int updatefinInfo(Map c);
    int updateInvestInfo(Map c);
    int updateIncomeInfo(Map c);
    int updateFamInfo(Map c);
    int updateAssInfo(Map c);
    
    int updateLiabiInfo(Map c);
    int updateInsurInfo(Map c);
    int updatePayInfo(Map c);
    int updateOperInfo(Map c);
    int updateFarmerInfo(Map c);
    String getNextId();
}