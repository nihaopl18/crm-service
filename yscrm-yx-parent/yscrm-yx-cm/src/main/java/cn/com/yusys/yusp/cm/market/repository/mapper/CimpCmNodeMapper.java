package cn.com.yusys.yusp.cm.market.repository.mapper;

import cn.com.yusys.yusp.cm.market.domain.CimpCmAssemInout;
import cn.com.yusys.yusp.cm.market.domain.CimpCmAsseminfo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 流程模板——节点信息接口
 * @author chenlin
 *
 */
public interface CimpCmNodeMapper extends CommonMapper<CimpCmNodeinfo>{

	/**获取流程节点信息**/
	List<CimpCmNodeinfo> getNodeList(QueryModel model);
	/**根据活动id查询流程节点*/
	List<CimpCmNodeinfo> getNodeByTempId(@Param("tempId") String tempId);
	/**根据活动id查询所有节点信息*/
	List<Map<String,String>> getNodeInfo(@Param("tempId") String tempId);
	/**更具组件id查询组件信息*/
	CimpCmAsseminfo getAssem(@Param("assemblyId") String assemblyId);
	/**根据组件id查询组件输入输出项*/
	List<CimpCmAssemInout> getAssemInout(@Param("assemblyId") String assemblyId);
}
