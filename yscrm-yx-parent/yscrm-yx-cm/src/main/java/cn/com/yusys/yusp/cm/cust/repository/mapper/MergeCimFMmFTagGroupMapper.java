package cn.com.yusys.yusp.cm.cust.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.com.yusys.yusp.cm.cust.domain.CimFMmFTagGroup;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

@Mapper
public interface MergeCimFMmFTagGroupMapper extends CommonMapper<CimFMmFTagGroup>{
	List<CimFMmFTagGroup> getGroupTree(); // 标签组查询
	
	String getSeq();// 获取GroupNo
	
	int deleteTagGroup(QueryModel model);// 删除分组
	
	int modifyTagGroup(CimFMmFTagGroup record);//维护分组
	
	List<CimFMmFTagGroup> getByParentNo(QueryModel model);// 验证同组下名称是否重复
	
	List<CimFMmFTagGroup> getChild(QueryModel model);// 校验当前节点的上级节点是否为他的子节点
	
}
