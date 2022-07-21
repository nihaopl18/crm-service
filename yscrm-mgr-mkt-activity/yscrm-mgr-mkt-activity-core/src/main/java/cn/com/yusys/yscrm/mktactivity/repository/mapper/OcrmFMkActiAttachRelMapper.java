package cn.com.yusys.yscrm.mktactivity.repository.mapper;

import java.math.BigDecimal;

import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiAttachRelInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkActiTargetMapper
 * @类描述：营销活动附件管理
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-28 
 */
public interface OcrmFMkActiAttachRelMapper extends CommonMapper<OcrmFMkActiAttachRelInfo>{
	/**
	* @方法名称: getSeq
	* @方法描述: 返回自增序列
	* @参数与返回说明: 
	* @算法描述:
	**/
	public BigDecimal getSeq();
	/**
	* @方法名称: lastFileDel
	* @方法描述: 删除上次关联的附件
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int lastFileDel(BigDecimal actiId);
}
