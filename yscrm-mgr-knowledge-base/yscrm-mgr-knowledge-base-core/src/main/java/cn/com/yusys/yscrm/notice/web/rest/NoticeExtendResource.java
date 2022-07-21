package cn.com.yusys.yscrm.notice.web.rest;

import cn.com.yusys.yscrm.notice.service.NoticeExtendService;
import cn.com.yusys.yusp.admin.web.rest.dto.AdminSmNoticeDTO;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/noticeext")
public class NoticeExtendResource extends CommonResource<AdminSmNoticeDTO,String> {
    private final Logger log = LoggerFactory.getLogger(NoticeExtendResource.class);

    @Autowired
    private NoticeExtendService noticeExtendService;
    @Override
    protected CommonService getCommonService() {
        return this.noticeExtendService;
    }

    @GetMapping("/noticeinfo/{noticeId}")
    @Timed
    public ResultDto<Map<String, String>> getNoticeByNoticeId(@ApiParam(value = "String",required = true) @PathVariable String noticeId) {
        List<Map<String,String>> list = this.noticeExtendService.getNoticeByNoticeId(noticeId);
        return new ResultDto<>(list.get(0));
    }
}
