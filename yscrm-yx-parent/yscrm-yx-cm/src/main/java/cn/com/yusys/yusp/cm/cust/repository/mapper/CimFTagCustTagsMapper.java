package cn.com.yusys.yusp.cm.cust.repository.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import cn.com.yusys.yusp.cm.cust.domain.CimFTagCustTags;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * 
 * @项目名称: yusp-app-cim
 * @类名称: CimFTagCustTagsMapper
 * @类描述: 
 * @功能描述: 标签客户信息
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2018年10月08日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */

@Mapper
public interface CimFTagCustTagsMapper extends CommonMapper<CimFTagCustTags>{
	List<String> getCustIdsByTags(@Param("list") List<String> list);
	List<CimFTagCustTags> getListByTags(QueryModel model);
	List<Map<String, Object>> qryTags(Map<String, Object> map);
	List<Map<String, Object>> qryTagsname(Map<String, Object> map);
	List<CimFTagCustTags> qryByTagsname(Map<String, Object> map);
	List<CimFTagCustTags> qryAvailable(@Param("tagNo") String tagNo,@Param("today") String today);
	int delcustTags(String custId);// 删除分组
	String getSeq();// 获取tagNo
	List<CimFTagCustTags> getAuthData(QueryModel model);
}
