package cn.com.yusys.yusp.cm.market.repository.mapper;


import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesDisplayInput;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @项目名称：yscimc-service
 * @类名称：CimpCmNodesDisplayInputMapper
 * @类描述：节点表单表输入表
 * @功能描述:
 * @创建人：chenlin2 
 * @创建时间：2018-11-17
 */
public interface CimpCmNodesDisplayInputMapper extends CommonMapper<CimpCmNodesDisplayInput>{

	List<CimpCmNodesDisplayInput> getDisInput(@Param("formId") String formId);
	List<Map<String, Object>> getTagno(String nodeId);
}
