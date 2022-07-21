package process;

import core.PendingJobPool;

/**
 * 清楚定时任务
 * @author zhangyt12
 * @date 2022/1/27 16:22
 */
public class RemoveExpireJobProcessor implements ScheduledTaskProcessor{

    @Override
    public void scheduledTask(Object object) {
        // TODO 不能使用 System.out 打印日志！！
        System.out.println("开始清除过期任务：" + object.toString());
        PendingJobPool.removeExpireJob(object.toString());
    }
}
