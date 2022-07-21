package cn.com.yusys.yusp.cm.cust.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.cm.cust.domain.CimpCViewPubRelation;
import cn.com.yusys.yusp.cm.cust.repository.mapper.CimpCViewPubRelationMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
@Service
public class CimpCViewPubRelationService extends CommonService{
	private final Logger log = LoggerFactory.getLogger(CimpCViewPubRelation.class);
	@Autowired
	private CimpCViewPubRelationMapper mapper;
	@Override
	protected CommonMapper getMapper() {
		// TODO 自动生成的方法存根
		return this.mapper;
	}
	public List<CimpCViewPubRelation> getListByModel(QueryModel queryModel) {
		// TODO 自动生成的方法存根
		List<CimpCViewPubRelation> list = mapper.getListByModel(queryModel);
		PageHelper.clearPage();
		return list;
	}
}
