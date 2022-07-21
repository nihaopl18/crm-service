package cn.com.yusys.yusp.cm.monitoring.service.impl;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReActiveVo;
import cn.com.yusys.yusp.cm.monitoring.repository.mapper.YscimcActReActiveMapper;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActReActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/4/6 14:20
 */
@Service
public class YscimcActReActiveServiceImpl implements YscimcActReActiveService {

    @Autowired
    private YscimcActReActiveMapper mapper;

    @Override
    public String getUserActive(String actId, LocalDate date, String timeArr) {

        //通过活动编号和时间获取记录信息
        List<YscimcActReActiveVo> list = mapper.getListByActIdAndDate(actId, date);

        String[] timearr = timeArr.split(",");

//        int[] resultArr = new int[timearr.length];

        StringBuffer str = new StringBuffer("");
        // 通过需要查询的时间点遍历记录信息，查找当前时间点内距离时间点最近的一条
        for (int i = 0; i < timearr.length; i++) {

            long reslut = 0;

            for (int j = 0; j < list.size(); j++) {

                if (Integer.valueOf(timearr[i]) == list.get(j).getRecordTime().getHour()) {

                    reslut = list.get(j).getActiveNum();

                    break;
                }
            }

            //如果时间点内有记录则取该时间点记录的人数，没有取零
            if (i == 0){
                str.append(reslut);
            }else {
                str.append(","+reslut);
            }
        }

//        String join = StringUtils.join(resultArr);
        return str.toString();
    }

    @Override
    public YscimcActReActiveVo getLastDataByDate(String actId, String currentDate) {
        //字符串转LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(currentDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        //通过活动编号和时间获取记录信息
        YscimcActReActiveVo vo = mapper.getLastDataByDate(actId, dateTime);

        return vo;
    }



}
