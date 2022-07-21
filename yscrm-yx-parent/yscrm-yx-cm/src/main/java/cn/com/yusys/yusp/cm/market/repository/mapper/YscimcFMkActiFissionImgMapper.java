package cn.com.yusys.yusp.cm.market.repository.mapper;

import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiFissionImg;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YscimcFMkActiFissionImgMapper extends CommonMapper<YscimcFMkActiFissionImg> {

    /**
     * 通过裂变组件ID查询图片
     * @param fissionId 裂变组件ID
     * @return
     */
    List<YscimcFMkActiFissionImg> getListByFissionId(String fissionId);

    /**
     * 通过裂变组件ID删除图片
     * @param fissionId 裂变组件ID
     * @return
     */
    int deleteByFissionId(String fissionId);
}
