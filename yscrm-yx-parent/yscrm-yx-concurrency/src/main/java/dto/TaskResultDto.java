package dto;

import constant.TaskResultType;

/**
 * @Author Lenovo
 * @Data 2021/12/16 14:34
 */
public class TaskResultDto <R> {

    private final TaskResultType resultType;

    private final R resultData;

    private final String resultMessage;

    public TaskResultDto(TaskResultType resultType, R resultData, String resultMessage) {
        this.resultType = resultType;
        this.resultData = resultData;
        this.resultMessage = resultMessage;
    }

    public TaskResultType getResultType() {
        return resultType;
    }

    public R getResultData() {
        return resultData;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
