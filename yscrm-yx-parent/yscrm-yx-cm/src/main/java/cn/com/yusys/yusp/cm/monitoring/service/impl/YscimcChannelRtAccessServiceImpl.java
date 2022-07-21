package cn.com.yusys.yusp.cm.monitoring.service.impl;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcChannelRtAccessVo;
import cn.com.yusys.yusp.cm.monitoring.repository.mapper.YscimcChannelRtAccessMapper;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcChannelRtAccessService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/12 - 14:48
 */
@Service
public class YscimcChannelRtAccessServiceImpl implements YscimcChannelRtAccessService {
    private final YscimcChannelRtAccessMapper mapper;

    public YscimcChannelRtAccessServiceImpl(YscimcChannelRtAccessMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String getchannelrtaccess(String activityId, LocalDate date, String timeArr) {
        //通过活动编号和时间获取记录信息
        List<YscimcChannelRtAccessVo> list=mapper.getchannelrtaccess(activityId, date);

        String[] timearr = timeArr.split(",");

        StringBuffer str = new StringBuffer("");

        // 通过需要查询的时间点遍历记录信息，查找当前时间点内距离时间点最近的一条
        for (int i = 0; i < timearr.length; i++) {

            String reslut = "0";

            for (int j = 0; j < list.size(); j++) {

                if (Integer.parseInt(timearr[i]) == list.get(j).getRecordTime().getHour()) {

                    reslut = list.get(j).getVisitNumber();

                    break;
                }
            }

            //如果时间点内有记录则取该时间点记录的人数，没有取零
            if (i == 0){
                str.append(reslut);
            }else {
                str.append(",").append(reslut);
            }
        }
        return str.toString();
    }
}
