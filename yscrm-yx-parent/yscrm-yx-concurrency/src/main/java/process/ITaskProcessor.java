package process;

import dto.TaskResultDto;

/**
 * 任务逻辑接口
 * T：处理任务所需的参数
 * R：任务结束返回的数据
 * @author zhangyt12
 * @date 2021/12/16 14:32
 */
public interface ITaskProcessor <T,R> {

    TaskResultDto<R> taskExecute(T data);
}
