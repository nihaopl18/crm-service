package cn.com.yusys.yscrm.custpub.repository.mapper;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.AcrmCustVO;
import cn.com.yusys.yscrm.custpub.domain.CrmFCiBelongHisData;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciAdmitBelong;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciTrusteeshipApply;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import io.lettuce.core.dynamic.annotation.Param;
/**
 * @项目名称: yscrm-entity-cust-pub模块
 * @类名称: OcrmFciAdmitBelongMapper
 * @类描述: 客户分配调整
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-25 19:38:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciAdmitBelongMapper extends CommonMapper<OcrmFciAdmitBelong> {
	List<Map<String, Object>> getOrglist(String orgCode);
	List<Map<String, Object>> getMgrlist(QueryModel model);
	List<Map<String, Object>> getUpMgrlist(String orgCode);
	List<Map<String, Object>> qryOrgId(String custId);
	List<Map<String, Object>> qryMgrId(String custId);
	List<Map<String, Object>> qryBelongHis(QueryModel model);
	void updateByCustid(OcrmFciAdmitBelong belongrecord);
	void updateOrgByCustid(OcrmFciAdmitBelong belongrecord);
	void deleteByCustId(Map<?, ?> map);
	void deletemgrByCustId(Map<?, ?> map);
	String getCustByCustIdAndOrgAndMgr(@Param("custId") String custId, @Param("mgrId") String mgrId, @Param("orgId") String orgId);
	int updateHost(Map<String, String> map);
	OcrmFciAdmitBelong getBelongByCustIdAndMgrIdAndOrgId(Map<String, String> map);
	int delBelongByCustIdMgrIdOrgId(Map<String, String> map);
	List<Map<String, Object>> getNoAdminBelong(String custId);
	String getBelongOrgIdByCustId(String custId);
	int deleteByCustIdAndMgrId(Map<String, String> cust);
	int updMainOrgTypeByOrgId(String string);
	int updAssistOrgTypeByOrgId(String string);
	/*int updateMgrType(Map<String, String> cust);*/
//	void updateOrgType(String orgId, String orgType1);
	void updateOrgType(Map<String, String> map);
	void deletemgrByCustId1(Map<String, Object> params);


	List<Map<String, Object>> qrybelonglist(Map<String, Object> map);

	void insertaumGrade(Map<String, String> map);

    int checkUpNameId(String id);

	List<Map<String, Object>> selectById(Map<String, String> map);


    String selectmgrId(String selectRole);

	void updatebelong(CrmFCiBelongHisData crmFCiBelongHisData);

    void updateaumGradeGrade(Map<String, Object> map);

	void updateFci(OcrmFciTrusteeshipApply ocrmFciTrusteeshipApply);

    void updateinformation(Map<String, Object> map);

	void updateassets(Map<String, Object> map);

	Map<String, Object> detailebelonghis(String seqno);

	Map<String, Object> Gradelist(String id);

    String selectTeam(String selectRole);

    List<Map<String, Object>> qrybelonglistlist(Map<String, Object> map);

    void updatebelonghis(Map<String, Object> mapp);

	AcrmCustVO  selectgrade(String bizSeqNo);

	void updateGrade(AcrmCustVO acrmCustVO);

	String selectdata(String bizSeqNo);

	List<Map<String, Object>> qrybelonglistString(Map<String, Object> map);

	void inserthisData(List<CrmFCiBelongHisData> list);

    List<Map<String, Object>> selectmgr(Map<String, String> mapp);

	int selectCount(Map<String, String> mapp);

	void deleteByinse(Map<String, String> mapp);

	List<Map<String, Object>> qrybelonglistStringS(Map<String, Object> map2);

	List<Map<String, Object>> qrybelonglistli(Map<String, Object> map);

	List<Map<String, Object>> qrybelonglistlis(Map<String, Object> map);

    List<Map<String, Object>> qrybelonglistStringl(Map<String, Object> map2);

	void deleteByCustById(Map<String, String> mapp);

	void deleteByCustByIdl(Map<String, String> mapp);

    void updateEsExportQuery(Map<String, Object> map);
}
