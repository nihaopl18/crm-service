package cn.com.yusys.yscrm.knowledge.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.knowledge.domain.OcrmFwpInfoSection;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @项目名称: yscrm-mgr-knowledge-base-core模块
 * @类名称: OcrmFwpInfoSectionMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-30 17:50:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpInfoSectionMapper extends CommonMapper<OcrmFwpInfoSection> {
	
	/**
	 * @方法名称: querySection
	 * @方法描述: 知识库栏目数据查询
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	List<Map<String, Object>> querySection();
	
    /**
     * @方法名称: deleteSection
     * @方法描述: 删除  - 根据 栏目编号字段， 删除该栏目及其下所有栏目数据 逻辑删除
     * @参数与返回说明: 
     * @算法描述: 无
     */
    int deleteSection(String sectionId);

	/**
	 * @方法名称: sameSection
	 * @方法描述: 校验  - 根据 栏目编号字段， 以及目录名称判断该栏目下是否有相同名称的目录
	 * @参数与返回说明:
	 * @算法描述: 无
	 */
	int sameSection(OcrmFwpInfoSection ocrmFwpInfoSection);
}