package vo;

import process.ScheduledTaskProcessor;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延时队列所用延时对象
 * @author zhangyt12
 * @date 2021/12/20 14:47
 */
public class CustomDelayedVo<T> implements Delayed {
    // 到期时间，单位毫秒
    private final long expireTime;
    // 泛型内容
    private final T data;
    // 延时队列中需要执行的任务：该任务的执行时间必须很短，不能长时间阻塞；
    private final ScheduledTaskProcessor taskProcessor;

    public CustomDelayedVo(long expireTime, T data, ScheduledTaskProcessor taskProcessor) {
        this.expireTime = TimeUnit.NANOSECONDS.convert(expireTime, TimeUnit.MILLISECONDS) + System.nanoTime();
        this.data = data;
        this.taskProcessor = taskProcessor;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public T getData() {
        return data;
    }

    public ScheduledTaskProcessor getTaskProcessor() {
        return taskProcessor;
    }

    /**
     * 获取当前还有多少时间执行
     * @param timeUnit
     * @return
     */
    @Override
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(this.expireTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    /**
     * 比较大小
     * @param delayed
     * @return
     */
    @Override
    public int compareTo(Delayed delayed) {
        long compare = this.getDelay(TimeUnit.NANOSECONDS) - delayed.getDelay(TimeUnit.NANOSECONDS);
        return compare==0 ? 0 : (compare > 0 ? 1 : -1);
    }
}
