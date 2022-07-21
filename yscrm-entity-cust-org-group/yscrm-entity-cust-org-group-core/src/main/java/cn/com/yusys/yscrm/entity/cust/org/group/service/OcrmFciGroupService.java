package cn.com.yusys.yscrm.entity.cust.org.group.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.entity.cust.org.group.domain.OcrmFciGroup;
import cn.com.yusys.yscrm.entity.cust.org.group.repository.mapper.OcrmFciGroupMapper;
/**
 * @项目名称: yscrm-entity-cust-org-group-core模块
 * @类名称: OcrmFciGroupService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 19:12:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciGroupService extends CommonService {
    @Autowired
    private OcrmFciGroupMapper ocrmFciGroupMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciGroupMapper;
    }

	public List<Map<String, String>> getListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciGroupMapper.getListByModel(model);
		PageHelper.clearPage();
		return list;
	}

	public OcrmFciGroup getGroupInfoByGroupNo(String groupNo) {
		// TODO 自动生成的方法存根
		//String groupNo = (String) model.getCondition().get("groupNo");
		OcrmFciGroup pool=ocrmFciGroupMapper.selectByPrimaryKey(groupNo);
		return pool;
	}

}
