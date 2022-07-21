package cn.com.yusys.yusp.cm.market.repository.mapper;

import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiShareImg;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YscimcFMkActiShareImgMapper extends CommonMapper<YscimcFMkActiShareImg> {

    /**
     * 通过裂变组件ID查询图片
     * @param shareId 裂变组件ID
     * @return
     */
    List<YscimcFMkActiShareImg> getListByShareId(String shareId);

    /**
     * 通过裂变组件ID删除图片
     * @param shareId 裂变组件ID
     * @return
     */
    int deleteByShareId(String shareId);
}
