package cn.com.yusys.yusp.cm.monitoring.service.impl;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReGiftExchangeVo;
import cn.com.yusys.yusp.cm.monitoring.repository.mapper.YscimcActReGiftExchangeMapper;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActReGiftExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YscimcActReGiftExchangeServiceImpl  implements YscimcActReGiftExchangeService {

@Autowired
    private YscimcActReGiftExchangeMapper yscimcActReGiftExchangeMapper;


    @Override
    public List<YscimcActReGiftExchangeVo> getLastData(String actId) {
        return yscimcActReGiftExchangeMapper.getLastData(actId);
    }
}