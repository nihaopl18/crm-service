package cn.com.yusys.yscimc.assemble.repository.mapper;

import cn.com.yusys.yscimc.assemble.domain.CmicAppAsseSignImgEntity;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmicAppAsseSignImgMapper extends CommonMapper<CmicAppAsseSignImgEntity> {
    List<CmicAppAsseSignImgEntity> selectListById(String id);
}
