package cn.com.yusys.yusp.cm.cust.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.com.yusys.yusp.cm.cust.domain.CimpCViewPubRelation;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
@Mapper
public interface CimpCViewPubRelationMapper extends CommonMapper<CimpCViewPubRelation>{

	List<CimpCViewPubRelation> getListByModel(QueryModel queryModel);

	

}
