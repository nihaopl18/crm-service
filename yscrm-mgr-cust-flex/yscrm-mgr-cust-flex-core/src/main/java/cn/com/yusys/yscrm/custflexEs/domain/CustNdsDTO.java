package cn.com.yusys.yscrm.custflexEs.domain;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExeclTitle;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * @项目名称: yscrm-pcrm-common-core模块
 * @类名称: AcrmFwpRemindInfo
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-11-04 10:31
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
public class CustNdsDTO extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;




	@ExeclTitle("客户号")
	private String CustNo;

	private String NdsCustNo;

	public String getCustNo() {
		return CustNo;
	}

	public void setCustNo(String custNo) {
		CustNo = custNo;
	}

	public String getNdsCustNo() {
		return NdsCustNo;
	}

	public void setNdsCustNo(String ndsCustNo) {
		NdsCustNo = ndsCustNo;
	}
}