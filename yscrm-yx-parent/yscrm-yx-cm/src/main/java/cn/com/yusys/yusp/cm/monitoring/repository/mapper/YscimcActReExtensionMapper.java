package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReExtensionVo;
import cn.com.yusys.yusp.cm.monitoring.entity.YscimcActReExtensionPo;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * 活动效果推广信息表
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-15 16:43:06
 */
@Mapper
public interface YscimcActReExtensionMapper extends BaseMapper<YscimcActReExtensionPo> {

    /**
     * 根据id查询最新推广记录
     *
     * @param
     * @return
     */
    List<YscimcActReExtensionVo> getLastData(String actId);
}
