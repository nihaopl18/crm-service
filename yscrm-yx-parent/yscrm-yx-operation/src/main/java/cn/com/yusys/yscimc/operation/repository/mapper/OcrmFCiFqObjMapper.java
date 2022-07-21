package cn.com.yusys.yscimc.operation.repository.mapper;

import cn.com.yusys.yscimc.operation.domain.OcrmFCiFqDbcol;
import cn.com.yusys.yscimc.operation.domain.OcrmFCiFqObj;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OcrmFCiFqObjMapper extends CommonMapper<OcrmFCiFqObj> {
    List<OcrmFCiFqObj> queryLeftTab(String SQL);

    List<OcrmFCiFqObj> getObj(QueryModel model);

    List<OcrmFCiFqDbcol> queryCols(String SQL);

    void deleteColsByObjId(String objId);

    String getSeq();
}
