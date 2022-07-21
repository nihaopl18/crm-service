package cn.com.yusys.yusp.cm.market.repository.mapper;


import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.market.domain.DmpTaskNode;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 流程模板——连线信息接口
 * @author chenlin
 *
 */
public interface DmpTaskNodeMapper extends CommonMapper<DmpTaskNode>{
	List<DmpTaskNode> getTaskNode(@Param("tempId") long tempId);
	// 查找下级节点
	List<Map<String, Object>> getSonNode(CimpCmNodeinfo cimpCmNodeinfo);
	// 新增节点
	int insertNode (DmpTaskNode dmpTaskNode);
	// 查目标表是否存在
	int getTarTable(String targetTable);
	// 删除节点
	int delNodes (long tempId);
	Integer markePlanMapper(String ids);
}
