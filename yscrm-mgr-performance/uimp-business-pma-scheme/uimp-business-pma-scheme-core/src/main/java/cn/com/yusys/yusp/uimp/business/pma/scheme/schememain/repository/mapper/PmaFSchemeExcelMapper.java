package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFScheme;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeExcelMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 15:01:33
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFSchemeExcelMapper extends CommonMapper<PmaFScheme> {
	String queryIndexCount(Map<String, Object> map);
	int  delorg(String schemeId);
	int  delpost(String schemeId);
	int  delsperule(String schemeId);
	int  delobj(String schemeId);
	int  delinfo(String schemeId);
	List<Map<String, Object>> listByModel(QueryModel model);
	void insertObj(String schemeId);
	void insertObjNew(String schemeId);
	void insertOrgObjNew(@Param("schemeId") String schemeId,@Param("evlObjType")  String evlObjType);
	void updateSchemeInfo(@Param("schemeId")String schemeId,@Param("specialValue")  String specialValue);
	void schemePub(@Param("schemeId")String schemeId,@Param("statFlag")  String statFlag);
	List<String> queryNames(@Param("schemeId") String[] schemeId);
	List<Map<String, Object>> queryHomePageIndex(QueryModel model);
	List<Map<String, Object>> queryHomePageIndexNew(QueryModel model);
	List<Map<String, Object>> querySchemeIndex(String schemeId);
	void delindex(String schemeId);
	void delsplit(String schemeId);
	
	/**
     * @函数名称: copySchemeInf
     * @函数描述: 复制考核方案信息-考核方案基础信息表
     * @参数与返回说明:
     * @算法描述:
     */
	Integer copySchemeInf(@Param("schemeId") String schemeId, @Param("newSchemeId") String newSchemeId, @Param("menuId") String menuId, 
			@Param("loginCode") String loginCode, @Param("orgCode") String orgCode, @Param("createDate") String createDate);
}