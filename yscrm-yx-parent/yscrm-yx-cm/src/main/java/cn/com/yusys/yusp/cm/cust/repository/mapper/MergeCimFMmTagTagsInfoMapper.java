package cn.com.yusys.yusp.cm.cust.repository.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import cn.com.yusys.yusp.cm.cust.domain.CimFMmTagTagsInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * 
 * @项目名称: yusp-app-cim
 * @类名称: CimFMmTagTagsInfoMapper
 * @类描述: 
 * @功能描述: 标签管理
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018年09月28日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Mapper
public interface MergeCimFMmTagTagsInfoMapper extends CommonMapper<CimFMmTagTagsInfo>{
	List<CimFMmTagTagsInfo> getTagList(QueryModel model);
	// 判断标签名是否重复
	List<Map<String,Object>> judgeSameTag(CimFMmTagTagsInfo tag);
	int updateTagList(CimFMmTagTagsInfo tag);
	int deleteByTagNo(Map<String, Object> map);
	int insertTagList(CimFMmTagTagsInfo tag);
	List<CimFMmTagTagsInfo> getTagByGroupNo(QueryModel model);
	// 判断标签是否含有子节点
	List<Map<String,Object>> getTagNodeList(CimFMmTagTagsInfo tag);
	int deleteByTagNos(Map<String, Object> map);
	// 查询审批中标签信息
	List<CimFMmTagTagsInfo> getUploadTagById(QueryModel model);
	// 更新标签生命周期
	int setTagLifeCycle(CimFMmTagTagsInfo tag);
	// 查询审批中的标签
	CimFMmTagTagsInfo getTagById(String tagNo);
	// 获取tagNo
	String getSeq();
	// 获取机构级别
	Map<String, Object>getOrgLevel(QueryModel model);
	// 获取标签分组编号
	Map<String, Object>getGroupNo(String groupNo);
	// 获取客户使用的标签
	String getCustTag(String tagNo);
	
	List<Map<String,Object>> qryTagBytagno(List<String> list);
}
