package cn.com.yusys.yusp.cm.monitoring.service.impl;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReExtensionVo;
import cn.com.yusys.yusp.cm.monitoring.repository.mapper.YscimcActReExtensionMapper;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActReExtensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YscimcActReExtensionServiceImpl implements YscimcActReExtensionService {

    @Autowired
    private YscimcActReExtensionMapper mapper;


    @Override
    public List<YscimcActReExtensionVo> getLastData(String actId) {
        return mapper.getLastData(actId);
    }


}