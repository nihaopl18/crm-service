package cn.com.yusys.yusp.uimp.base.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseAutoSearchConf;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseAutoSearchConfMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-17 10:54:49
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface AdminBaseAutoSearchConfMapper extends CommonMapper<AdminBaseAutoSearchConf> {
	// 根据id 查询表配置
    List<Map<String, Object>> querylist(@Param("seacherId") String seacherId);
    // 根据id 查询表名
    String queryTable(@Param("seacherId") String seacherId);
    // 根据id 查询权限
    String queryDataAuth(@Param("seacherId") String seacherId);
    // 根据id 查询表类型
    String queryTableType(@Param("seacherId") String seacherId);
    // 公共查询
    List<Map<String, Object>> queryPubliclist(QueryModel model);
    // 删除
    void delConf(@Param("seacherId") String seacherId);
    // 查询 数据字典Value值
    String queryDataCodeValue(@Param("dataCode")String dataCode,@Param("key")String key);
    
    int queryLastOrg(@Param("orgCode") String orgCode);
    //查询字段是否有新增
    List<Map<String, Object>> queryFieldInsert(@Param("seacherId") String seacherId,@Param("tableName") String tableName);
    //查询字段是否有删除
    List<Map<String, Object>> queryFieldDel(@Param("seacherId") String seacherId,@Param("tableName") String tableName);
}