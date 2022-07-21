package cn.com.yusys.yscrm.sysview.repository.mapper;

import cn.com.yusys.yscrm.sysview.domain.CimFMmTagDataSource;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: yusp-app-cm-cust
 * @类名称: CimFMmTagDataSourceMapper
 * @类描述:
 * @功能描述: 模型版本信息
 * @创建人: yangye@yusys.com.cn
 * @创建时间: 2018年09月27日
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */

@Mapper
public interface CimFMmTagDataSourceMapper extends CommonMapper<CimFMmTagDataSource>{
	/**
	 * 查询数据来源信息
	 */
	List<Map<String, Object>> getTagDataSourceList(QueryModel model);
	/**
	 * 删除数据来源信息
	 */
	int deleteTagDataSource(QueryModel model);
	/**
	 * 新增数据来源信息
	 */
	int insertTagDataSource(CimFMmTagDataSource tag);
	/**
	 * 修改数据来源信息
	 */
	int updateTagDataSource(CimFMmTagDataSource tag);
	/**
	 * 获取tagNo
	 */
	List<CimFMmTagDataSource> getTagNo(QueryModel model);
	/**
	 * 获取entityNo
	 */
	List<Map<String, Object>> getEntityNo(QueryModel model);
	/**
	 * 获取表名
	 */
	List<Map<String, Object>> getTableName(QueryModel model);
	/**
	 * 查找数据库中来源实体编号、属性、表名是否重复
	 * */
	List<Map<String, Object>> getDsRepeat(QueryModel model);
	// 删除标签的数据来源信息
	int delTagNo(String tagNo);
	int checkTagNo(String tagno);
	
}

