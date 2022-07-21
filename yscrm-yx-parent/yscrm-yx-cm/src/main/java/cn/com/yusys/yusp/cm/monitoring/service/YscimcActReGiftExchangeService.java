package cn.com.yusys.yusp.cm.monitoring.service;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReGiftExchangeVo;

import java.util.List;

/**
 * 活动效果礼品兑换表
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-15 16:49:33
 */
public interface YscimcActReGiftExchangeService {


    List<YscimcActReGiftExchangeVo> getLastData(String act_id);
}

