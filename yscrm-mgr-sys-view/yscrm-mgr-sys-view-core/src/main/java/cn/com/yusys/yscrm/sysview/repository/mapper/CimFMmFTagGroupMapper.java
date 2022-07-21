package cn.com.yusys.yscrm.sysview.repository.mapper;

import cn.com.yusys.yscrm.sysview.domain.CimFMmFTagGroup;
import cn.com.yusys.yscrm.sysview.domain.TagTree;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CimFMmFTagGroupMapper extends CommonMapper<CimFMmFTagGroup>{
	List<CimFMmFTagGroup> getGroupTree(@Param("loginCode")String loginCode); // 标签组查询

	List<CimFMmFTagGroup> getSystemTree();

	String getSeq();// 获取GroupNo
	
	int deleteTagGroup(QueryModel model);// 删除分组
	
	int modifyTagGroup(CimFMmFTagGroup record);//维护分组
	
	List<CimFMmFTagGroup> getByParentNo(QueryModel model);// 验证同组下名称是否重复
	
	List<CimFMmFTagGroup> getChild(QueryModel model);// 校验当前节点的上级节点是否为他的子节点

	/**
	 * 根据groupNo查询当前节点及子节点
	 * @param model
	 * @return
	 */
	List<CimFMmFTagGroup> getChildByNo(QueryModel model);

    List<TagTree> getTagsTree(QueryModel model);

	String getGroupName(@Param("groupNo")String groupNo);
}
