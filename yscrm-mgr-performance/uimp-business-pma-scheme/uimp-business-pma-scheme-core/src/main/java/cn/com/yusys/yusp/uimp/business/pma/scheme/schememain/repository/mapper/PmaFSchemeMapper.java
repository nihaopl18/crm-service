package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFScheme;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeMapper
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
@Mapper
public interface PmaFSchemeMapper extends CommonMapper<PmaFScheme> {
	String queryIndexCount(Map<String, Object> map);
	int  delorg(String schemeId);
	int  delpost(String schemeId);
	int  delsperule(String schemeId);
	int  delobj(String schemeId);
	int  delinfo(String schemeId);
	
	int  delinfoBySchemeIds(String[] schemeIds);
	int  delobjBySchemeIds(String[] schemeIds);
	int  delorgBySchemeIds(String[] schemeIds);
	int  delpostBySchemeIds(String[] schemeIds);
	int  delsperuleBySchemeIds(String[] schemeIds);
	int  delindexBySchemeIds(String[] schemeIds);
	int  delsplitBySchemeIds(String[] schemeIds);
	List<Map<String, Object>> querySpecialList(QueryModel model);
	List<Map<String, Object>> listByModel(QueryModel model);
	List<Map<String, Object>> querySchemeInfo(@Param("type") String type, @Param("evlObjId") String evlObjId);
	void insertObj(String schemeId);
	void insertObjNew(String schemeId);
	void insertOrgObjNew(@Param("schemeId") String schemeId,@Param("evlObjType")  String evlObjType);
	void updateSchemeInfo(@Param("schemeId")String schemeId,@Param("specialValue")  String specialValue);
	void schemePub(@Param("schemeId")String schemeId,@Param("statFlag")  String statFlag, @Param("updaterId")String updaterId, @Param("updateDate")String updateDate);
	List<String> queryNames(@Param("schemeId") String[] schemeId);
	List<Map<String, Object>> queryHomePageIndex(QueryModel model);
	List<Map<String, Object>> queryHomePageIndexNew(QueryModel model);
	List<Map<String, Object>> querySchemeIndex(String schemeId);
	void delindex(String schemeId);
	void delsplit(String schemeId);
	List<PmaFScheme> selectDrawSchemeInfo(String schemeId);
	List<Map<String, Object>> queryHomePageIndexRate(QueryModel model);
	List<Map<String, Object>> queryHomePageIndexDate(QueryModel model);
	List<Map<String, Object>> queryHomePageIndexName(QueryModel model);

	List<Map<String, Object>> querySchemeList(QueryModel model);

    List<Map<String, Object>> queryManagerTeamList(String orgCode);

	List<Map<String, Object>> queryManagerTeamListByUserId(String userId);

	List<String> selectAllUser(String code);

	String selectMgrRoleId(String custMgr);

	List<Map<String, Object>> selectMgrList(@Param("userList") List<String> userList, @Param("code")String code);

	List<String> selectUserIdList(String roleId);

	int  delTeamBySchemeIds(String[] schemeIds);

	int  delMktBySchemeIds(String[] schemeIds);


}