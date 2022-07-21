package cn.com.yusys.yusp.cm.market.repository.mapper;


import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesDisplayOutput;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @项目名称：yscimc-service
 * @类名称：CimpCmNodesDisplayOutputMapper
 * @类描述：节点表单表输出表
 * @功能描述:
 * @创建人：chenlin2 
 * @创建时间：2018-11-17
 */
public interface CimpCmNodesDisplayOutputMapper extends CommonMapper<CimpCmNodesDisplayOutput>{
	List<CimpCmNodesDisplayOutput> getDisOutput(@Param("formId") String formId);
}
