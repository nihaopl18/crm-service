package cn.com.yusys.yscrm.notice.repository.mapper;

import cn.com.yusys.yscrm.notice.domain.AdminSmNotice;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NoticeExtendMapper extends CommonMapper<AdminSmNotice> {
    List<Map<String, String>> getNoticeByNoticeId(@Param("noticeId")String noticeId);
}
