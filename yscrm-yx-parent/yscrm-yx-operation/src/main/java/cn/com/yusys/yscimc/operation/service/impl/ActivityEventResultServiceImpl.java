package cn.com.yusys.yscimc.operation.service.impl;

import cn.com.yusys.yscimc.operation.domain.ActivityEventResultEntity;
import cn.com.yusys.yscimc.operation.repository.mapper.ActivityEventResultMapper;
import cn.com.yusys.yscimc.operation.service.ActivityEventResultService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author Lenovo
 * @Data 2022/3/17 14:39
 */
@Service
public class ActivityEventResultServiceImpl implements ActivityEventResultService {

    private final ActivityEventResultMapper resultMapper;

    public ActivityEventResultServiceImpl(ActivityEventResultMapper resultMapper) {
        this.resultMapper = resultMapper;
    }

    @Override
    public void saveResultEntity(ActivityEventResultEntity resultEntity) {
        resultMapper.insert(resultEntity);
    }

    @Override
    public ActivityEventResultEntity getById(String outTradeNo) {
        return resultMapper.selectByPrimaryKey(outTradeNo);
    }

    @Override
    public ActivityEventResultEntity getByOutTradeNo(String outTradeNo) {
        Example example = new Example(ActivityEventResultEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("outTradeNo", outTradeNo);
        return resultMapper.selectOneByExample(example);
    }

    @Override
    public void delete(ActivityEventResultEntity resultEntity) {
        resultMapper.delete(resultEntity);
    }

    @Override
    public int selectCountByTempId(String tempId) {
        Example example = new Example(ActivityEventResultEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activityId", tempId);
        return resultMapper.selectCountByExample(example);
    }

    @Override
    public String distinctTransCodeByTempId(String tempId) {
        return resultMapper.distinctTransCodeByTempId(tempId);
    }
}