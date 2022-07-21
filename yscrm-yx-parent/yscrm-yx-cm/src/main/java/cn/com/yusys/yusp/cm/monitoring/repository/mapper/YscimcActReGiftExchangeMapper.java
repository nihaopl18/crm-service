package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReGiftExchangeVo;
import cn.com.yusys.yusp.cm.monitoring.entity.YscimcActReGiftExchangePo;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * 活动效果礼品兑换表
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-15 16:43:06
 */
@Mapper
public interface YscimcActReGiftExchangeMapper extends BaseMapper<YscimcActReGiftExchangePo> {

    /**
     * 根据id查询最新礼品发放记录
     *
     * @param
     * @return
     */
    List<YscimcActReGiftExchangeVo> getLastData(String actId);
}
