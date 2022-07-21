package cn.com.yusys.yscrm.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.product.domain.OcrmFsysRicheditInfo;
import cn.com.yusys.yscrm.product.repository.mapper.OcrmFsysRicheditInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: OcrmFsysRicheditInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-27 17:43:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFsysRicheditInfoService extends CommonService {
    @Autowired
    private OcrmFsysRicheditInfoMapper ocrmFsysRicheditInfoMapper;

    @Autowired
	private UaaClient uaaClient;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFsysRicheditInfoMapper;
    }

    /**
     * @方法名称: richTextInformationQuery
     * @方法描述: 产品视图-富文本信息查询
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public List<OcrmFsysRicheditInfo> richTextInformationQuery(QueryModel model, String prodId) {
    	model.getCondition().put("prodId", prodId);
    	List<OcrmFsysRicheditInfo> list = null;
    	// 主题名称 模糊查询
    	list = ocrmFsysRicheditInfoMapper.richTextInformationQuery(model);
    	return list;
    }
	
	 /**
     * @方法名称: insertData
     * @方法描述: 产品视图-富文本信息新增
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public Integer insertData(OcrmFsysRicheditInfo ocrmFsysRicheditInfo) {
    	Integer result = 0;
    	ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	ocrmFsysRicheditInfo.setCorpOrgCode(dto.getBody().getInstu().getCode());
    	result = this.insertSelective(ocrmFsysRicheditInfo);
    	return result;
    }
    
    /**
     * @方法名称: updateData
     * @方法描述: 产品视图-富文本信息修改
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public Integer updateData(OcrmFsysRicheditInfo ocrmFsysRicheditInfo) {
    	Integer result = 0;
    	result = this.updateSelective(ocrmFsysRicheditInfo);
    	return result;
    }

}
