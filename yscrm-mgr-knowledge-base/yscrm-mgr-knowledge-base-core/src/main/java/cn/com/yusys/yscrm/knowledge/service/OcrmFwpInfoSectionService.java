package cn.com.yusys.yscrm.knowledge.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.knowledge.domain.OcrmFwpInfoSection;
import cn.com.yusys.yscrm.knowledge.repository.mapper.OcrmFwpInfoSectionMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yscrm-mgr-knowledge-base-core模块
 * @类名称: OcrmFwpInfoSectionService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Bronze
 * @创建时间: 2019-02-01 12:00:17
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFwpInfoSectionService extends CommonService {
    @Autowired
    private OcrmFwpInfoSectionMapper ocrmFwpInfoSectionMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFwpInfoSectionMapper;
    }
    
	@Autowired
	private UaaClient uaaClient;

    /**
     * @方法名称: querySection
     * @方法描述: 知识库栏目数据查询
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public List<Map<String, Object>> querySection() {
    	List<Map<String, Object>> list = ocrmFwpInfoSectionMapper.querySection();
    	return list;
    }
    
    /**
     * @方法名称: insertSection
     * @方法描述: 新增 知识库栏目数据
     * @参数与返回说明: 
     * @算法描述: 
     */
    public Integer insertSection(OcrmFwpInfoSection ocrmFwpInfoSection) {
    	// TODO 增加异常处理 
    	ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	ocrmFwpInfoSection.setCorpOrgCode(dto.getBody().getInstu().getCode());
    	ocrmFwpInfoSection.setCreateTime(new Date());
    	ocrmFwpInfoSection.setIsDelete("N");
    	int result = this.insertSelective(ocrmFwpInfoSection);
    	return result;
    }
    
    /**
     * @方法名称: updateSection
     * @方法描述: 更新 知识库栏目数据
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public int updateSection(OcrmFwpInfoSection ocrmFwpInfoSection) {
    	// TODO 增加异常处理 
        return ocrmFwpInfoSectionMapper.updateByPrimaryKeySelective(ocrmFwpInfoSection);
    }
    
    /**
     * @方法名称: deleteSection
     * @方法描述: 删除  - 根据 栏目编号字段， 删除该栏目及其下所有栏目数据 逻辑删除
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public int deleteSection(String sectionId) {
    	// TODO 增加异常处理 
    	int result = ocrmFwpInfoSectionMapper.deleteSection(sectionId);
        return result;
    }

    /**
     * @方法名称: sameSection
     * @方法描述: 校验  - 根据 栏目编号字段， 以及目录名称判断该栏目下是否有相同名称的目录
     * @参数与返回说明:
     * @算法描述: 无
     */
    public boolean sameSection(OcrmFwpInfoSection ocrmFwpInfoSection) {
        int result = ocrmFwpInfoSectionMapper.sameSection(ocrmFwpInfoSection);
        if (result == 0){
            return true;
        }else {
            return false;
        }
    }
}
