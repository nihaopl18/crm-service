package cn.com.yusys.yscrm.custflexEs.repository.mapper;

import cn.com.yusys.yscrm.custflexEs.domain.CrmCustFoucsInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmCustFoucsInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: sawyerwei
 * @创建时间: 2020-12-07 12:30:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface CrmCustFoucsInfoMapper extends CommonMapper<CrmCustFoucsInfo> {

	// 查找是否有关注
	CrmCustFoucsInfo findIsAttention(@Param("custId") String custId, @Param("loginCode") String loginCode);

	Integer insertCustFoucsInfo(CrmCustFoucsInfo prodFoucsInfo);

	Integer updateCustFoucsInfo(CrmCustFoucsInfo prodFoucsInfo);

	List<String> queryFocusCustIds(@Param("loginCode") String loginCode);
	
}