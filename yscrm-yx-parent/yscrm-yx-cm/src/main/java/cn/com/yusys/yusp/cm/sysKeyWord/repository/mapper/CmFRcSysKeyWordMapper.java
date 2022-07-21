package cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcSysKeyWord;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcSysKeyWordMapper
 * @类描述: 渠道模型关键字配置接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-10-17 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcSysKeyWordMapper extends CommonMapper<CmFRcSysKeyWord>{
	
	// 渠道模型关键字查询
	List<CmFRcSysKeyWord> getModelKeyWordList(QueryModel model);
	// 渠道模型关键字新增
	int insertModelKeyWordList(Map<String, Object> map);
	// 渠道模型关键字修改
	int updateModelKeyWordList(Map<String, Object> map);
	// 渠道模型关键字删除
	int deleteModelKeyWordList(String id);
	// 渠道模型关键字别名重复验证
	List<Map<String, Object>> getSameAliasName();
	// 别名验重
	int getSameName(CmFRcSysKeyWord record);
	// 渠道模型关键字返回表英文名
	List<Map<String, Object>> getTabEName();
	// 渠道模型关键字返回表中文名
	List<Map<String, Object>> getTabCName();
	// 渠道模型关键字返回表字段名
	List<Map<String, Object>> getField(Map<String, Object> map);

	List<Map<String, Object>> getmainField(Map<String, Object> map);
}
