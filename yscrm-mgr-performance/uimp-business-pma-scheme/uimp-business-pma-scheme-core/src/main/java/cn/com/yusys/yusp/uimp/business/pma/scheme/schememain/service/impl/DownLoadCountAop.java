package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/6/6 13:45
 */
@Aspect
@Component
public class DownLoadCountAop {

    private static final int COUNT_NUM = 20;

    @Pointcut("@annotation(cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.impl.DownLoadCount)")
    public void pointCut() { }


    @Around("pointCut()")
    public Object downAround(ProceedingJoinPoint point) {

        Signature signature = point.getSignature();
        String taskName = signature.getClass().getName() + "-" + signature.getName();
        String taskId = DownLoadNumService.addMap(taskName, "1");
        if (StringUtils.isNotBlank(taskId)) {
            throw new RuntimeException("请勿多次提交请求");
        }
        if (DownLoadNumService.get() >= COUNT_NUM) {
            System.out.println("下载次数超过"+COUNT_NUM+"次，请稍后再试");
            return null;
        }
        DownLoadNumService.addGet();
        Object proceed = null;
        try {
            proceed = point.proceed();
        } catch (Throwable throwable) {
            DownLoadNumService.removeMap(taskName);
            DownLoadNumService.subGet();
        }
        DownLoadNumService.removeMap(taskName);
        DownLoadNumService.subGet();
        return proceed;
    }
}
