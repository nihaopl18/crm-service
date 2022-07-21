package cn.com.yusys.yscrm.sysview.job;


import cn.com.yusys.yscrm.sysview.repository.mapper.CimFMmTagTagsInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @author: sxm
 * @time: 2021/9/3 17:34
 */
@Component
@EnableScheduling
public class TagJob {

    private final Logger logger = LoggerFactory.getLogger(TagJob.class);
    @Autowired
    private CimFMmTagTagsInfoMapper mapper;

    @Scheduled(cron = "0 0 0 */1 * ?")
    public void execute() {
        logger.info("执行下架标签定时任务");
        mapper.updateTagStatusJob();
    }


}
