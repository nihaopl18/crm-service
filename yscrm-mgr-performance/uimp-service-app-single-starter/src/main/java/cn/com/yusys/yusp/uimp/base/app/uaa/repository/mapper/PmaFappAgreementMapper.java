package cn.com.yusys.yusp.uimp.base.app.uaa.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.base.app.uaa.domain.PmaFappAgreement;

/**
 * @项目名称: yscrm-base-core模块
 * @类名称: PmaFappAgreementMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: sawyer
 * @创建时间: 2019-07-17 17:29:20
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFappAgreementMapper extends CommonMapper<PmaFappAgreement> {

	String queryList();
	
}