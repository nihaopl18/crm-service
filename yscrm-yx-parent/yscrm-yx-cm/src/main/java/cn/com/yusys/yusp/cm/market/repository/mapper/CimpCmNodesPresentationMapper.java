package cn.com.yusys.yusp.cm.market.repository.mapper;


import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesPresentation;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @项目名称：yscimc-service
 * @类名称：CimpCmNodesPresentationMapper
 * @类描述：节点表单表操作表
 * @功能描述:
 * @创建人：chenlin2 
 * @创建时间：2018-11-17
 */
public interface CimpCmNodesPresentationMapper extends CommonMapper<CimpCmNodesPresentation>{
	List<CimpCmNodesPresentation> getPresentation(@Param("formId") String formId);
}
