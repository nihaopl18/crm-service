package cn.com.yusys.climp.score.repository.mapper;

import cn.com.yusys.climp.score.domain.LoySrScoreCollect;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;

public interface LoySrScoreCollectMapper extends CommonMapper<LoySrScoreCollect> {
    List<LoySrScoreCollect> selectData(String importCode);
}
