package cn.com.yusys.yscrm.notice.service;

import cn.com.yusys.yscrm.notice.repository.mapper.NoticeExtendMapper;
import cn.com.yusys.yusp.admin.service.PropProviderService;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeExtendService extends CommonService {
    @Autowired
    private NoticeExtendMapper noticeExtendMapper;
    @Autowired
    private PropProviderService propProviderService;

    @Override
    protected CommonMapper getMapper() {
        return null;
    }

    private String pathRestore(String path) throws JsonProcessingException{
        return this.propProviderService.pathRestore(path);
    }

    public List<Map<String,String>> getNoticeByNoticeId(String noticeId) {
        List<Map<String,String>> list = this.noticeExtendMapper.getNoticeByNoticeId(noticeId);
        if (list != null && list.size() > 0) {
            try {
                if (((Map)list.get(0)).get("detailcontent") != null && ((String)((Map)list.get(0)).get("detailcontent")).contains("pathtrs")) {
                    ((Map)list.get(0)).put("detailcontent", this.pathRestore((String)((Map)list.get(0)).get("detailcontent")));
                }
            } catch (JsonProcessingException var5) {
                var5.printStackTrace();
            }
        }
        return list;
    }
}
