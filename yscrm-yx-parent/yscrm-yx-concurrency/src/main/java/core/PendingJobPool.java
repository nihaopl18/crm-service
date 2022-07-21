package core;

import constant.TaskResultType;
import dto.TaskResultDto;
import process.ITaskProcessor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池包装类
 * @author zhangyt12
 * @date 2021/12/17 10:39
 */
public class PendingJobPool {
    // 核心线程数 - CPU 核心数量
    private static final int THREAD_COUNTS = Runtime.getRuntime().availableProcessors();

    // 线程池队列，默认最大任务数：5000
    private static final BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<>(5000);

    // 自定义线程名称
    private static final ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, runnable.toString() + LocalDateTime.now());
        }
    };

    // TODO 自定义线程池，此处使用缺省拒绝策略，任务数超出队列抛出异常
    private static final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
            THREAD_COUNTS,
            THREAD_COUNTS * 2,
            60,
            TimeUnit.SECONDS,
            taskQueue,
            threadFactory
    );

    // 存放所有工作类的 map <jobName, JobInfo>
    private static final ConcurrentHashMap<String, JobInfo<?>> jobMap = new ConcurrentHashMap<>();

    // 私有化构造函数，使用单例模式创建该对象
    private PendingJobPool() {}

    // 移除过期任务，释放内存
    public static void removeExpireJob(String jobName) {
        jobMap.remove(jobName);
    }

    /**
     * 添加新的【工作 JobInfo】
     * @param jobName
     * @param jobLength
     * @param iTaskProcessor
     * @param expireTime
     */
    public void registerJob(String jobName, int jobLength, ITaskProcessor<?,?> iTaskProcessor, int expireTime) {
        JobInfo<?> jobInfo = new JobInfo<>(jobName, jobLength, iTaskProcessor, expireTime);
        this.registerJob(jobInfo);
    }

    public void registerJob(JobInfo<?> jobInfo) {
        if (jobMap.putIfAbsent(jobInfo.getJobName(), jobInfo) != null) {
            throw new RuntimeException(jobInfo.getJobName() + " - 该任务已添加！！！");
        }
    }

    /**
     * 添加任务
     * @param jobName
     * @param data
     * @param <T>
     */
    public <T,R> void putTask(String jobName, T data) {
        JobInfo<R> jobInfo = (JobInfo<R>) getJob(jobName);
        PendingTask<T,R> task = new PendingTask<>(jobInfo, data);
        poolExecutor.submit(task);
    }

    /**
     * 获取 jobInfo
     * @param jobName
     * @return
     */
    public JobInfo<?> getJob(String jobName) {
        JobInfo<?> jobInfo = jobMap.get(jobName);
        if (jobInfo == null) {
            throw new RuntimeException(jobName + " - 该任务不存在");
        }
        return jobInfo;
    }

    /**
     * 获取任务执行结果
     * @param jobName 任务唯一名称
     * @return
     */
    public List<? extends TaskResultDto<?>> getTaskDetails(String jobName) {
        return getJob(jobName).getTaskDetails();
    }

    /**
     * 返回任务进度
     * @param jobName 任务唯一名称
     * @return
     */
    public String getJobProgress(String jobName) {
        return getJob(jobName).getJobProgress();
    }

    /**
     * 单例模式获取
     * @return
     */
    public static PendingJobPool jobPoolInstance() {
        return JobPoolHolder.jobPoolInstance;
    }

    /**
     * 静态任务类，实现 Runnable
     * @param <T> ITaskProcessor.taskExecute 方法所需的参数类型
     * @param <R> ITaskProcessor.taskExecute 方法返回的结果类型
     */
    private static class PendingTask <T, R> implements Runnable{

        private final JobInfo<R> jobInfo;

        private final T data;

        public PendingTask(JobInfo<R> jobInfo, T data) {
            this.jobInfo = jobInfo;
            this.data = data;
        }

        @Override
        public void run() {
            ITaskProcessor<T, R> taskProcessor = (ITaskProcessor<T, R>) jobInfo.getTaskProcessor();
            TaskResultDto<R> resultDto = null;
            try {
                resultDto = taskProcessor.taskExecute(data);
                if (resultDto == null) {
                    resultDto = new TaskResultDto<>(TaskResultType.Exception, null, "任务执行结果为空");
                }
                if (resultDto.getResultData() == null) {
                    if (resultDto.getResultMessage() == null) {
                        resultDto = new TaskResultDto<>(TaskResultType.Exception, null,
                                "任务执行结果 resultMessage 属性为空");
                    } else {
                        resultDto = new TaskResultDto<>(TaskResultType.Exception, null,
                                "任务执行结果 resultMessage 属性为空，原因是：" + resultDto.getResultMessage());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                jobInfo.addResultDto(resultDto);
            }
        }

        public JobInfo<R> getJobInfo() {
            return jobInfo;
        }

        public T getData() {
            return data;
        }
    }

    /**
     * 使用内部静态类持有实例，暴露静态实例获取方法，提供单例模式实例获取
     */
    private static class JobPoolHolder {
        public static final PendingJobPool jobPoolInstance = new PendingJobPool();
    }
}
