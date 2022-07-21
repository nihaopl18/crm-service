package cn.com.yusys.yusp.cm.monitoring.service.impl;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReRoiVo;
import cn.com.yusys.yusp.cm.monitoring.repository.mapper.YscimcActReRoiMapper;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActReRoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class YscimcActReRoiServiceImpl implements YscimcActReRoiService {

    @Autowired
    private YscimcActReRoiMapper mapper;


    @Override
    public YscimcActReRoiVo getRealTimeData(String actId, String date) {
        LocalDateTime parse = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        YscimcActReRoiVo vo = mapper.getLastDataByDate(actId, parse);




//        list.stream().filter(
//                vo -> vo.getExpenditure() / vo.getPartakeNum();
//        )
        return vo;
    }

}