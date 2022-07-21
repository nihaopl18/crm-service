package cn.com.yusys.yusp.cm.market.repository.mapper;


import cn.com.yusys.yusp.cm.market.domain.DmpTaskInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 流程模板——连线信息接口
 * @author chenlin
 *
 */
public interface DmpTaskInfoMapper extends CommonMapper<DmpTaskInfo>{
	List<DmpTaskInfo> getTaskInfo(@Param("tempId") long tempId);
	// 流程生成任务
	int taskInsert(String tempId);
	// 流程删除任务
	int delTask(long tempId);
	// 判断活动类型
	String getActivityType(String tempId);
}
