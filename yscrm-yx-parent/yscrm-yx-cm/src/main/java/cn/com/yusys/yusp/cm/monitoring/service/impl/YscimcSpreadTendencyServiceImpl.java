package cn.com.yusys.yusp.cm.monitoring.service.impl;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcSpreadTendencyVo;
import cn.com.yusys.yusp.cm.monitoring.repository.mapper.YscimcSpreadTendencyMapper;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcSpreadTendencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YscimcSpreadTendencyServiceImpl implements YscimcSpreadTendencyService {

    @Autowired
    private YscimcSpreadTendencyMapper yscimcSpreadTendencyMapper;

    @Override
    public Map<String, Object> getLastDataForMonth(String actId, int month) {

        List<YscimcSpreadTendencyVo> yscimcSpreadTendencyVos = yscimcSpreadTendencyMapper.getLastDataForMonth(actId, month);

        Map<String, Object> map = new HashMap<>();
        StringBuffer participatePeopleNumber = new StringBuffer();
        StringBuffer shareFriendTimes = new StringBuffer();
        StringBuffer shareWechatMoment = new StringBuffer();
        StringBuffer participatePeopleTimes = new StringBuffer();
        StringBuffer recordDate = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < yscimcSpreadTendencyVos.size(); i++) {
            if (i == 0) {
                participatePeopleNumber.append(yscimcSpreadTendencyVos.get(i).getParticipatePeopleNumber());
                shareFriendTimes.append(yscimcSpreadTendencyVos.get(i).getShareFriendTimes());
                shareWechatMoment.append(yscimcSpreadTendencyVos.get(i).getShareWechatMoment());
                participatePeopleTimes.append(yscimcSpreadTendencyVos.get(i).getParticipatePeopleTimes());
                recordDate.append(sdf.format(yscimcSpreadTendencyVos.get(i).getRecordDate()));
            }else {
                participatePeopleNumber.append(",").append(yscimcSpreadTendencyVos.get(i).getParticipatePeopleNumber());
                shareFriendTimes.append(",").append(yscimcSpreadTendencyVos.get(i).getShareFriendTimes());
                shareWechatMoment.append(",").append(yscimcSpreadTendencyVos.get(i).getShareWechatMoment());
                participatePeopleTimes.append(",").append(yscimcSpreadTendencyVos.get(i).getParticipatePeopleTimes());
                recordDate.append(",").append(sdf.format(yscimcSpreadTendencyVos.get(i).getRecordDate()));
            }

        }
        map.put("participatePeopleNumber", participatePeopleNumber.toString());
        map.put("shareFriendTimes", shareFriendTimes.toString());
        map.put("shareWechatMoment", shareWechatMoment.toString());
        map.put("participatePeopleTimes", participatePeopleTimes.toString());
        map.put("recordDate", recordDate.toString());


        return map;
    }
}