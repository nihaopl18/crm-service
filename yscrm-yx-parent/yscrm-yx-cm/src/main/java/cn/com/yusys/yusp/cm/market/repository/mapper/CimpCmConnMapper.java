package cn.com.yusys.yusp.cm.market.repository.mapper;


import cn.com.yusys.yusp.cm.market.domain.CimpCmConninfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 流程模板——连线信息接口
 * @author chenlin
 *
 */
public interface CimpCmConnMapper extends CommonMapper<CimpCmConninfo>{
	List<CimpCmConninfo> getConnByTempId(@Param("tempId") String tempId);
	List<CimpCmConninfo> getTargetId(@Param("sourceId") String sourceId);
	int delConn(@Param("nodeId") String nodeId);
}
