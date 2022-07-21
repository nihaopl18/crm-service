package cn.com.yusys.yscrm.cust.person.repository.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerResumeInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFciPerCustMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-22 17:20:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PCustBaseViewMapper extends CommonMapper<AcrmFciPerResumeInfo> {
	List<Map<Object, String>> getList(Map<?, ?> param);
	List<Map<Object, String>> getworkList(Map<?, ?> param);
	List<Map<Object, String>> getrelatList(Map<?, ?> param);
	List<Map<Object, String>> getimportFlagList(Map<?, ?> param);
	List<Map<Object, String>> getresumeList(Map<?, ?> param);
	int updatebaseInfo(Map c);
	int updateworkInfo(Map c);
	int updaterelationInfo(Map c);
	int updaterelatInfo(Map c);
	int updateimportInfo(Map c);
	int updateresumeInfo(Map c);
	int insertresumeInfo(Map c);
	String getNextId();
	List<Map<String, Object>> queryCustUpdateHis(String custId);
	int updateIsUse(@Param("custId") String custId,@Param("updateName") String updateName);
	int saveImage(@Param("imagePath") String imagePath, @Param("custId") String custId);
	int saveImage1(@Param("imagePath") String imagePath, @Param("custId") String custId);
	String getItemName(Map mapCode);
}