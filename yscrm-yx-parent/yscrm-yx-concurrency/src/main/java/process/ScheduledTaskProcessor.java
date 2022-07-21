package process;

/**
 * 定时任务执行逻辑接口
 * @author zhangyt12
 * @date 2022/1/27 15:33
 */
public interface ScheduledTaskProcessor {

    // 如果该方法执行的时间较长，请使用异步执行
    void scheduledTask(Object object);
}
