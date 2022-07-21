package cn.com.yusys.yscrm.custflexEs.repository.mapper;

import cn.com.yusys.yscrm.custflexEs.domain.AdminSmLookupItem;
import cn.com.yusys.yscrm.custflexEs.model.CrmFEsExportQuery;
import cn.com.yusys.yscrm.custflexEs.model.CrmFEsExportZhQuery;
import cn.com.yusys.yscrm.custflexEs.model.CrmFEsUserQueryVO;
import cn.com.yusys.yscrm.custflexEs.model.LookupItemVO;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @项目名称：yusp-admin
 * @类名称：AdminSmLookupItemMapper
 * @类描述：数据字典内容
 * @功能描述:
 * @创建人：liaoxd@yusys.com.cn @创建时间：2017-12-12 21:22 @修改备注：
 * @修改日期 修改人员 修改原因 -------- -------- ----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Repository
public interface AdminSmLookupItemOutInfoMapper extends CommonMapper<AdminSmLookupItem> {

	List<Map<String, String>> getLookupCodeListByLookUpCodes(List<?> ids);

	List<Map<String, String>> getListByCodeForTree(Map<?, ?> param);

	List<Map<String,String>> getItemListBycodeOrName(QueryModel model);

    /**
     * 联表查询所有数据字典
     * @return
     */
	List<Map<String,String>> getItemList();
	
	List<String> getLookupItemNameByLookupCodeAndLookupItemCode(@Param("lookupCode") String lookupCode, @Param("lookupItemCodes") List<String> lookupItemCodes);

    void deleteEsUserQuery(Map<String, String> map);

    void insertEsUserQuery(List<CrmFEsUserQueryVO> list);

    List<CrmFEsUserQueryVO> getEsUserQueryList(@Param("userId") String userId);

    void insertEsExportQuery(List<CrmFEsExportQuery> list);

    List<CrmFEsExportQuery> getEsExportQueryList(Map<String,String> map);

    void insertEsExportZhQuery(List<CrmFEsExportZhQuery> list);

    List<CrmFEsExportZhQuery> getEsExportZhQueryList(Map<String, String> map);

    void deleteExportQuery(@Param("seqno")  String seqno);

    void deleteExportzhQuery(@Param("seqno")  String seqno);

    List<LookupItemVO> selectBymZ(@Param("str")  String str);
}
