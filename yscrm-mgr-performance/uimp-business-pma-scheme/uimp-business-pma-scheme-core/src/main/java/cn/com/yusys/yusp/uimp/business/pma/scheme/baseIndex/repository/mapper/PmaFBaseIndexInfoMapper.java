package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.vo.PmaFBaseIndexInfoVO;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.domain.PmaFIndexApplyInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.domain.PmaFIndexBalInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.domain.PmaFIndexEvlObjInfo;
import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexInfo;


/**
 * @项目名称: uimp-business-core模块
 * @类名称: PmaFBaseIndexInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2019-12-24 16:17:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFBaseIndexInfoMapper extends CommonMapper<PmaFBaseIndexInfo> {
	List<Map<String, Object>> querylist(QueryModel model);
	List<Map<String, Object>> querycolumnlist(String tableName);
    String selTableName(String bizFlg);
    List<Map<String, Object>> selConditionVal();
    List<Map<String, Object>> sellookup();
    List<Map<String, Object>> sellookupitem(String lookupCode);
    List<Map<String, Object>> selObjDim(String indexId);
    List<Map<String, Object>> selApplyDim(String indexId);
    List<Map<String, Object>> selYueDim(String indexId);
    int  delobj(String indexId);
    int  delapply(String indexId);
    int  delyue(String indexId);
    int  deleInfo(String indexId);
    int  delBuss(String indexId);
    List<Map<String, Object>> querysqlinfo(String indexId);
    int stopIndex(@Param("ids") String[] ids,
                  @Param("maintainManNo") String maintainManNo,
                  @Param("maintainDate") String maintainDate);
    int startIndex(@Param("ids") String[] ids,
                   @Param("maintainManNo") String maintainManNo,
                   @Param("maintainDate") String maintainDate);
    List<Map<String, Object>> selColumnType(@Param("tabname") String tabname,@Param("column") String column);
    List<Map<String, Object>> iseditIndex(String indexId);
    List<Map<String, Object>> selIsEditIndex(@Param("indexId") String indexId,@Param("dateStr") String dateStr );
    List<Map<String, Object>> queryIndexIsQuote(String indexId);
    
	/**
	 * @方法名称: executeQuerySql
	 * @方法描述: 动态执行查询语句-公共方法
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	List<Map<String,Object>> executeQuerySql(@Param("sqlStr") String sqlStr);

    PmaFBaseIndexInfoVO selectByindexId(String indexId);

    List<PmaFIndexEvlObjInfo> selectObjByIndexId(String indexId);

    List<PmaFIndexApplyInfo> selectApplyByIndexId(String indexId);

    List<PmaFIndexBalInfo> selectBalByIndexId(String indexId);

    List<Map<String, Object>> listByModel(@Param("indexIdList") List<String> indexIdList,@Param("indexId") String indexId,@Param("indexName")String indexName);

    List<String> selectIndexId(String schemeId);

    /**
     * 检查是否有相同名称
     *
     * @param id        指标数据ID
     * @param indexName 指标名称
     * @return 指标数据
     * @author weixy6
     * @date 2022/6/13
     */
    List<Map<String, Object>> checkSameIndexName(@Param("id") String id,
                                    @Param("indexName") String indexName);
}