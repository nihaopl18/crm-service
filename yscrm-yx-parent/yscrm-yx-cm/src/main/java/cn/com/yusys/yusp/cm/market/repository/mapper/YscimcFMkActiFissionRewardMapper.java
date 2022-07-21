package cn.com.yusys.yusp.cm.market.repository.mapper;

import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiFissionReward;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YscimcFMkActiFissionRewardMapper extends CommonMapper<YscimcFMkActiFissionReward>{

    /**
     * 通过裂变组件ID查询奖励
     * @param fissionId 裂变组件ID
     * @return
     */
    List<YscimcFMkActiFissionReward> getListByFissionId(String fissionId);

    /**
     * 通过裂变组件ID删除奖励
     * @param fissionId 裂变组件ID
     * @return
     */
    int deleteByFissionId(String fissionId);
}
