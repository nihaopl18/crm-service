package cn.com.yusys.yscrm.knowledge.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.knowledge.domain.OcrmFwpInfo;
import cn.com.yusys.yscrm.knowledge.repository.mapper.OcrmFwpInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.StringTools;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @项目名称: yscrm-mgr-knowledge-base-core模块
 * @类名称: OcrmFwpInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-30 17:48:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFwpInfoService extends CommonService {
    @Autowired
    private OcrmFwpInfoMapper ocrmFwpInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFwpInfoMapper;
    }
    
	@Autowired
	private UaaClient uaaClient;

	@Value("${role.branch}")
	public String BRANCH;

	@Value("${role.subbranch}")
	public String  SUBBRANCH;

    /**
     * @方法名称: listByModel
     * @方法描述: 条件查询 - 查询进行分页
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public List<Map<String, Object>> listByModel(QueryModel model) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		model.getCondition().put("userCode",dto.getBody().getUserId());
		model.getCondition().put("orgCode",dto.getBody().getOrg().getId());
    	// 默认查询所有栏目的知识库数据
    	if(!model.getCondition().containsKey("sectionId") || StringTools.isEmpty(model.getCondition().get("sectionId") + "")) {
    		model.getCondition().put("sectionId", "100");
    	}
    	// 查询条件中包含 检索范围、检索信息，处理检索内容为标题或内容 
    	if(model.getCondition().containsKey("searchScope") && model.getCondition().containsKey("searchContent")) {
    		if("2".equals(model.getCondition().get("searchScope"))) {	// 标题
    			model.getCondition().put("messageTitle", "%" + model.getCondition().get("searchContent") + "%");
    		} else if("3".equals(model.getCondition().get("searchScope"))) {	// 内容
    			model.getCondition().put("messageIntroduce", "%" + model.getCondition().get("searchContent") + "%");
    		} else if("1".equals(model.getCondition().get("searchScope"))) {	// 全部
    			model.getCondition().put("messageTitle", "%" + model.getCondition().get("searchContent") + "%");
    			model.getCondition().put("messageIntroduce", "%" + model.getCondition().get("searchContent") + "%");
    		}
    	} else if(model.getCondition().containsKey("messageTitle")) {
    		model.getCondition().put("messageTitle", "%" + model.getCondition().get("messageTitle") + "%");
    	}
		if (model.getCondition().containsKey("publishDateTo") && !"".equals((String)model.getCondition().get("publishDateTo"))){
			model.getCondition().put("publishDateTo",(String)model.getCondition().get("publishDateTo") + " 23:59:59");
		}
    	PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = ocrmFwpInfoMapper.listByModel1(model);
    	PageHelper.clearPage();
    	return list;
    }

	/**
	 * @函数名称:queryById
	 * @函数描述:查询知识库数据，公共API接口
	 * @参数与返回说明:
	 * @param bizSeqNo
	 * @算法描述:
	 */
	public Map<String, Object> queryById(String bizSeqNo) {
		Map<String,Object> map = ocrmFwpInfoMapper.queryById(bizSeqNo);
		return map;
	}

    /**
     * @方法名称: add
     * @方法描述: 新增知识库数据
     * @参数与返回说明: 
     * @算法描述: 
     */
	public String add(OcrmFwpInfo ocrmFwpInfo) {
		// TODO 增加异常处理
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String selectRole = request.getHeader("selectRole");
		ocrmFwpInfo.setCorpOrgCode(dto.getBody().getInstu().getCode());
		ocrmFwpInfo.setIsDelete("N");
//		if ("2".equals(ocrmFwpInfo.getPublicType())){
			ocrmFwpInfo.setPublishType("N");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			ocrmFwpInfo.setPublishDate(df.format(new Date()));
//		}else {
//			ocrmFwpInfo.setPublishType("Y");
//			ocrmFwpInfo.setPublishDate(null);
//		}
		String upOrgId = dto.getBody().getUpOrg().getId();
		String orgCode = dto.getBody().getOrg().getCode();
		if ("3".equals(ocrmFwpInfo.getPublicType()) && (BRANCH.contains(selectRole) || SUBBRANCH.contains(selectRole)) && upOrgId.equals(orgCode)){
			ocrmFwpInfo.setPublishOrg(dto.getBody().getUpOrg().getId());
			ocrmFwpInfo.setPublishOrgName(dto.getBody().getUpOrg().getName());
		}else {
			ocrmFwpInfo.setPublishOrg(dto.getBody().getOrg().getId());
			ocrmFwpInfo.setPublishOrgName(dto.getBody().getOrg().getName());
		}
		this.insertSelective(getMapper(), ocrmFwpInfo);
		return ocrmFwpInfo.getMessageId();
	}
    
    /**
     * @方法名称: updateData
     * @方法描述: 更新 知识库数据
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public int updateData(OcrmFwpInfo OcrmFwpInfo) {
    	// TODO 增加异常处理 
    	int result = 0;
//		if (!"2".equals(OcrmFwpInfo.getPublicType())){
//			OcrmFwpInfo.setPublishType("Y");
//			OcrmFwpInfo.setPublishDate(null);
//		}else {
//			OcrmFwpInfo.setPublishType("N");
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//			OcrmFwpInfo.setPublishDate(df.format(new Date()));
//		}
    	result = this.updateSelective(OcrmFwpInfo);
        return result;
    }

	/**
	 * @方法名称: updatePublishData
	 * @方法描述: 更新 知识库数据发布
	 * @参数与返回说明:
	 * @算法描述: 无
	 */
	public int updatePublishData(OcrmFwpInfo OcrmFwpInfo) {
		// TODO 增加异常处理
		int result = 0;
		result = this.ocrmFwpInfoMapper.updatePublishData(OcrmFwpInfo);
		return result;
	}

    /**
     * @方法名称: deleteByMessageIds
     * @方法描述: 删除  - 根据 知识库编号字段 逻辑删除
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public int deleteByMessageIds(String messageIds) {
    	// TODO 增加异常处理 
    	int result = 0;
    	if (messageIds != null && !"".equals(messageIds)) {
            String[] ids = messageIds.split(",");
            result = ocrmFwpInfoMapper.deleteByMessageIds(ids);
            ocrmFwpInfoMapper.deleteFilesByBusno(ids);
    	}
        return result;
    }

	/**
	 * @函数名称:sameInfo
	 * @函数描述:校验  - 根据 栏目编号,以及文档名称判断该栏目下是否有相同名称的文档
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public boolean sameInfo(OcrmFwpInfo ocrmFwpInfo) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		Map<String, String> map = new HashMap<>();
		map.put("userCode",dto.getBody().getLoginCode());
		map.put("selectId",ocrmFwpInfo.getSectionId());
		map.put("infoName",ocrmFwpInfo.getMessageTitle());
		map.put("messageId",ocrmFwpInfo.getMessageId());
		int result = ocrmFwpInfoMapper.sameInfo(map);
		if (result == 0){
			return true;
		}else {
			return false;
		}
	}
}
