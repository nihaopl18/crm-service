package cn.com.yusys.yscimc.operation.repository.mapper;

import cn.com.yusys.yscimc.operation.domain.OcrmFCiFqRelation;
import cn.com.yusys.yscimc.operation.domain.vo.FqRelationVo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: crm-service
 * @类名称: OcrmFCiFqRelationMapper
 * @类描述:
 * @功能描述: 数据集管理
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2019年01月14日
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */

@Mapper
public interface OcrmFCiFqRelationMapper extends CommonMapper<OcrmFCiFqRelation> {
    List<Map<String, Object>> getListByModel(QueryModel model);

    List<Map<String, Object>> getDataObj(QueryModel model);

    List<Map<String, Object>> getDataObjs(String SQL);

    List<Map<String, Object>> getColDataObj(String SQL);

    List<Map<String, Object>> getColDataObjs(String SQL);

    List<OcrmFCiFqRelation> queryRelations(String SQL);

    long getSeq();

    int deletebyid(String id);

    int addData(OcrmFCiFqRelation record);

    void updateData(OcrmFCiFqRelation record);

    List<FqRelationVo> getFqRelationVo();
}

