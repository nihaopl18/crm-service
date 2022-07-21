package core;

import constant.TaskResultType;
import dto.TaskResultDto;
import process.ITaskProcessor;
import process.RemoveExpireJobProcessor;
import vo.CustomDelayedVo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 一项需要多线程完成的工作
 * @author zhangyt12
 * @date 2021/12/16 14:48
 */
public class JobInfo <R> {

    // 该工作的名称，用于区分其他工作
    private final String jobName;
    // 该工作的任务数量
    private final int jobLength;
    // 该工作任务处理器
    private final ITaskProcessor<?,?> taskProcessor;
    // 每个任务的结果能在队列中保存多久，和 LinkedBlockingDeque<TaskResultDto<R>> blockingDeque 相关
    private final long expireTime;

    // 成功处理任务数
    private final AtomicInteger successCount;
    // 已经处理的任务数
    private final AtomicInteger processCount;

    // 用于保存每个任务结束后的结果
    private LinkedBlockingDeque<TaskResultDto<R>> taskResultDtoDeque;

    public JobInfo(String jobName, int jobLength, ITaskProcessor<?, ?> taskProcessor, long expireTime) {
        this.jobName = jobName;
        this.jobLength = jobLength;
        this.taskProcessor = taskProcessor;
        this.expireTime = expireTime;
        this.successCount = new AtomicInteger(0);
        this.processCount = new AtomicInteger(0);
        this.taskResultDtoDeque = new LinkedBlockingDeque<>();
    }

    public String getJobName() {
        return jobName;
    }

    public int getJobLength() {
        return jobLength;
    }

    public ITaskProcessor<?, ?> getTaskProcessor() {
        return taskProcessor;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public int getSuccessCount() {
        return successCount.get();
    }

    public int getProcessCount() {
        return processCount.get();
    }

    public int addSuccessCount(int count) {
        return this.successCount.addAndGet(count);
    }

    public int addProcessCount(int num) {
        return this.processCount.addAndGet(num);
    }

    public List<TaskResultDto<R>> getTaskDetails() {
       List<TaskResultDto<R>> taskResultDtoList = new ArrayList<>();
       TaskResultDto<R> resultDto = null;
       while ((resultDto = taskResultDtoDeque.pollFirst()) != null) {
           taskResultDtoList.add(resultDto);
       }
        return taskResultDtoList;
    }

    public void addResultDto(TaskResultDto<R> taskResultDto) {

        if (TaskResultType.Success.equals(taskResultDto.getResultType())) {
            this.successCount.incrementAndGet();
        }
        this.processCount.incrementAndGet();
        this.taskResultDtoDeque.addLast(taskResultDto);

        if (processCount.get() == jobLength) {
            // 定时清除 PendingJobPool 中执行完成并过期的任务
            CustomDelayedVo<String> customDelayedVo = new CustomDelayedVo<>(expireTime, jobName, new RemoveExpireJobProcessor());
            ScheduledJobPool.getInstance().putJob(customDelayedVo);
        }
    }

    public void addResultDto(Collection<TaskResultDto<R>> taskResultDtoList) {
        for (TaskResultDto<R> resultDto : taskResultDtoList) {
            this.addResultDto(resultDto);
        }
    }

    /**
     * 返回工作进度字符串
     * @return
     */
    public String getJobProgress() {
        return processCount.get() + " / " + jobLength;
    }
}
