package cn.com.yusys.yusp.uimp.base.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseAutoSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseAutoSearchMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-17 10:54:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface AdminBaseAutoSearchMapper extends CommonMapper<AdminBaseAutoSearch> {
	// 查询
    List<Map<String, Object>> querylist(QueryModel model);
    // 删除
    void deleteAutoConf(@Param("seacherId")String seacherId);
    // 配置查询 未配置
    List<Map<String, Object>> queryConfList(@Param("tableName")String tableName,@Param("seacherId")String seacherId);
    // 配置查询 已配置
    List<Map<String, Object>> queryConfListYpz(@Param("seacherId")String seacherId);
    // 生成功能点
    void updateFun (@Param("id") String id,@Param("confUrl") String confUrl);
    // 查询 UUID
    String queryUuid();
    // 配置模块
    void insertModFun(Map<String,String> mapConf);
    // 配置控制点
    void insertConFun(Map<String,String> mapConf);
    // 更新是否配置
    void updateIfConf (@Param("id") String id);
    // 查询库中的表名
    List<Map<String, Object>> queryTablelist(QueryModel model);
    // 查询库中的数据字典
    List<Map<String, Object>> queryDataCodeList(QueryModel model);
}