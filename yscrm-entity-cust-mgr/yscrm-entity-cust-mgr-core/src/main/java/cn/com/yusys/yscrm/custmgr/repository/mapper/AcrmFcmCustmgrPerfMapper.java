package cn.com.yusys.yscrm.custmgr.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custmgr.domain.*;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFcmCustmgrPerfMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-22 17:25:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFcmCustmgrPerfMapper extends CommonMapper<AcrmFcmCustmgrPerf> {
	
	/**
	 * 列表查询
	 * 
	 * @param queryModel
	 * @return
	 */
	List<Map<String, Object>> querylist(QueryModel queryModel);

    String selectmgrId(String selectRole);

	String getmktTeamId(String loginCode);

	List<CrmFYyTriumphVO> selectcrmFYyTriumphVO(Map<String, Object> map);

	List<CrmTriuVO> crmTriuVOList(Map<String, Object> map);

	List<CrmTriuVO> crmTriuVOListb(Map<String, Object> map);

	List<CrmTriuVO> crmTriuVOListt(Map<String, Object> map);

	List<CrmTriuVO> crmTriuVOListC(Map<String, Object> map);

	List<CrmTriuVO> crmTriuVOListtd(Map<String, Object> map);

	int getcheck(Map<String, Object> map);

	void inserttriumph(Map<String, Object> map);

	void updatetriumph(Map<String, Object> map);

	void inserttriumphhictoric(Map<String, Object> map);

	List<organdmgrVO> selectorg();

	String selectorgId(String cellValue0);

	void insertexcel(CrmFYyTriumphPpopExcel crmFYyTriumphPpopExcel);

    List<Map<String, Object>> uploadlist(Map<String, Object> map);


    List<CrmFYyTriumphLookUp> selectcrmFYyTriumphLookUpList(Map<String, Object> map);

    List<CrmFYyTriumphLookPpop> selectcrmCrmTriuLookPpopList(Map<String, Object> map);

	List<CrmFYyTriumphAumDetailed> selectAumz(Map<String, Object> map);

    List<CrmFYyTriumphAumDetailed> selectAum(Map<String, Object> map);

	List<CrmFYyTriumphDepositDetailed> selectdeposit(Map<String, Object> map);

	List<CrmFYyTriumphDepositDetailed> selectdepositL(Map<String, Object> map);

	List<CrmFYyTriumphLoanDetailed> selectloan(Map<String, Object> map);

	List<CrmFYyTriumphLoanDetailed> selectselectloanL(Map<String, Object> map);

	List<CrmFYyTriumphCharge> selectCharge(Map<String, Object> map);

	List<CrmFYyTriumphCharge> selectChargeL(Map<String, Object> map);

    List<CrmFYyTriumphLookUp> CrmFYyTriumphLookUpList(Map<String, Object> map);


	List<CrmFYyTriumphLookUp> selectcrmFYyTriumphLookUpListlist(Map<String, Object> map);

	String selectMaxDateD(Map<String, Object> map);

	List<CrmFYyTriumphLookUp> Querydetappoplistl(Map<String, Object> map);

    List<CrmFYyTriumphLookUpEXCEL> CrmFYyTriumphLookUpListlistExcel(Map<String, Object> map);

    analyseVO selectppop(Map<String, Object> map);

    int selectfileCheck(String month);

	void deletefile(String month);

    List<CrmFYyTriumphLookUp> Querymonthdetalist(Map<String, Object> map);

    List<CrmFYyTriumphLookUp> selectcrmFYyTriumphListlist(Map<String, Object> map);

	List<CrmFYyTriumphLookUp> CrmFYyTriumphLookUpListt4(Map<String, Object> map);

	List<CrmFYyTriumphLookUpEXCEL> CrmFYyTriumphLookUpListlistExcelT4(Map<String, Object> map);
}