package cn.com.yusys.yscrm.cust.group.repository.mapper;

import cn.com.yusys.yscrm.cust.group.domain.*;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @项目名称: yscrm-entity-cust-group-core模块
 * @类名称: OcrmFciCgBaseMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-18 10:34:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciCgBaseMapper extends CommonMapper<OcrmFciCgBase> {

	int checkName(String name);// 检查客户群名称是否重复

	String getSeq();

	int checkUpName(@Param("id") String id,@Param("name") String name);

	int updateFun(OcrmFciCgBase c);

	List<Map<Object, String>> getListByModel(QueryModel model);

	Map<String, String> getGroupInfoByModel(String groupId);
	
	Map<String, String> getOrgLevel(String orgId);

	Map<String, String> getOneOrg(Map<String, String> map);

	int updateAuto(Map<String, String> map);

	int updateAutoCust(Map<String, String> map);
	int cgdelete(Map<String, String> map);

	int delecteMemberByGroupId(String custGroupId);

    List<CrmFCgPreparationVO> getcustomerList(CrmCustomerDTO crmCustomerDTO);

	void insertCountTage(CrmFCgTagcountTag crmFCgTagcountTag);

	int updateBase(CrmFCissCgBase crmFCiCgBase);

	List<CrmFCissCgBase> queryBaselist(CrmBaseDTO crmBaseDTO);

	List<CrmBaseCountVo> countCustomer(CrmBaseDTO crmBaseDTO);

	CrmFCissCgBase queryGroupBaselist(Map<String, String> map);

	List<CrmBaseCountVo> countGroupCustomer(Map<String, String> map);

	List<CrmFCgPreparationVO> selectPreparation(Map<String, String> mapMap);

	int deleteBaseCustomer(CrmBaseCuDTO crmBaseCuDTO);

	void insertchange(CrmFCgJournal crmFCgJournal);

	List<CrmFCgJournalVO> Selectjournal(Map<String, String> mapMap);

	List<CrmFCissCgIndexStats> queryIndexStatuslist(Map<String, String> mapMap);

	int checkUpNameId(@Param("custGroupId") String custGroupId, @Param("custGroupName")String custGroupName);

	void insertBase(CrmFCissCgBase crmFCissCgBase);

	void insertcustomer(CrmFCgCustomer crmFCgCustomer);

    int deleteCustomer(CrmBaseCuDTO crmBaseCuDTO);

	CrmFCissCgIndexStats queryIndexStatuslistMap(Map<String, String> mapMap);

    List<CrmFCgCustomerTag> querycrmFCgCustomerTagList(Map<String, String> mapMap);

	String gettagName(@Param("tagNo") String tagNo);

    CrmBaseCountVo Customercount(Map<String, String> map);

    void insertcrmFCgCustomerPreparation(CrmFCgCustomerPreparation crmFCgCustomerPreparation);

	CrmFCgCustomerPreparation selectocrmFciCgBaseMapper(Map<String, String> map);

	List<CrmFCgPreparationVO> queryjournallist(CrmBasePreparDTO crmBasePreparDTO);

    String selectGroupName(@Param("custGroupId") String custGroupId);

	int selectCheck(Map<String, String> map);

	void deleteCustomerCust(@Param("custGroupId") String custGroupId, @Param("custIdsss")String custIdsss);

    void insertcustomerList(@Param("list") List<CrmFCgCustomer> listCrmFCgCustomer);

    String selectMaxDate(@Param("custGroupId") String custGroupId);

    List<CrmFCissCgBaseVO> querycust(@Param("custId") String custId);

    List<CrmFCissCgDTO> selectcustName(@Param("str") String str);

    List<CrmFCgUserVO> wholecustomerList(CustomererDTO customererDTO);

    int checkUpNameuserId(@Param("custGroupId")String custGroupId,@Param("custGroupName") String custGroupName,@Param("userName") String userName);

    List<Map<String, Object>> queryprodlist(ProdDTO prodDTO);

    List<String> selectorg(@Param("code") String code);

	List<String> selectmgrId(Map<String, Object> map);

	List<String> selectmgrIduser(Map<String, Object> mapp);

	List<String> selectorgid(Map<String, Object> mapp);
}