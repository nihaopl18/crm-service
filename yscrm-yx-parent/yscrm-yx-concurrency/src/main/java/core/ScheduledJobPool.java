package core;

import process.ScheduledTaskProcessor;
import vo.CustomDelayedVo;

import java.util.concurrent.DelayQueue;


/**
 * DelayQueue 包装类
 * 实现定时任务
 * @author zhangyt12
 * @date 2021/12/20 15:40
 */
public class ScheduledJobPool {

    static {
        Thread thread = new Thread(new FetchJob());
        thread.setDaemon(true);
        thread.start();
    }

    private static final DelayQueue<CustomDelayedVo<?>> delayQueue = new DelayQueue<>();

    private static class FetchJob implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    CustomDelayedVo<?> customDelayedVo = delayQueue.take();
                    ScheduledTaskProcessor taskProcessor = customDelayedVo.getTaskProcessor();
                    taskProcessor.scheduledTask(customDelayedVo.getData());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private ScheduledJobPool() {}

    public synchronized void putJob(CustomDelayedVo<?> customDelayedVo) {
        // 用于避免存放多个任务
        boolean flag = false;
        for (CustomDelayedVo<?> delayedVo : delayQueue) {
            if (flag = delayedVo.getData().equals(customDelayedVo.getData())) {
                break;
            }
        }
        if (!flag) {
            delayQueue.offer(customDelayedVo);
        }
    }

    public static ScheduledJobPool getInstance() {
        return ScheduledJobQueueHolder.processor;
    }

    private static class ScheduledJobQueueHolder {
        public static final ScheduledJobPool processor = new ScheduledJobPool();
    }
}
