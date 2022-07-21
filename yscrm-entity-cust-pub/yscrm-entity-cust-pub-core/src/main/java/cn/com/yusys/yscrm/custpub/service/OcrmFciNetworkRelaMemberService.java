package cn.com.yusys.yscrm.custpub.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciNetworkRelaMember;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciNetworkRelaMemberMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciNetworkRelaMemberService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 16:23:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciNetworkRelaMemberService extends CommonService {
    @Autowired
    private OcrmFciNetworkRelaMemberMapper ocrmFciNetworkRelaMemberMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciNetworkRelaMemberMapper;
    }

	public int add(Map<String, String> map) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public List<Map<String, Object>> getList(String netId) {
		// TODO 自动生成的方法存根
		return ocrmFciNetworkRelaMemberMapper.getRelaMemberByNetId(netId);
	}

}
