package cn.com.yusys.yscrm.custpub.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yscrm.custpub.domain.AcrmAbrBusiSum;
import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmAbrBusiSumMapper;
import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmAcmBusiSumMapper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmAbrBusiSumService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-28 10:30:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmAbrBusiSumService extends CommonService {
    @Autowired
    private AcrmAbrBusiSumMapper acrmAbrBusiSumMapper;
    @Autowired
    private AcrmAcmBusiSumMapper acrmAcmBusiSumMapper;
    @Autowired
    private UaaClient uaaClient;
    @Override
    protected CommonMapper<?> getMapper() {
        return acrmAbrBusiSumMapper;
    }
    public  UserInfoDTO getUserInfoDTO() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		return user;
	}
	public String getRoles() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String role = "";
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String selectRole = request.getHeader("selectRole");
		for (ObjBean obj : dto.getBody().getRoles()) {
			if (obj.getId().equals(selectRole)){
				role = obj.getCode();
			}
		}
		return role;
	}
	public List<Map<String, Object>> getListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		UserInfoDTO user = getUserInfoDTO();
		List<ObjBean> roleList = user.getRoles();
		List<Map<String, Object>> list= null;
		Boolean flag=false;
		Boolean flag1=false;
		Boolean flag2=false;
		for (ObjBean objBean : roleList) {
			if (!(objBean.getCode().equals("15") || objBean.getCode().equals("115"))) {
				flag=true;
			}else {
				if(objBean.getCode().equals("15")) {
					flag2=true;
				}else if(objBean.getCode().equals("115")) {
					flag1=true;
				}
				//list = acrmAcmBusiSumMapper.getListByModel(model);
			}
		}
		if(flag) {
			list = acrmAbrBusiSumMapper.getListByModel(model);
		}else if(flag1) {
			list = acrmAcmBusiSumMapper.getListByModel1(model);
		}else if(flag2) {
			list = acrmAcmBusiSumMapper.getListByModel(model);
		}
		return list;
	}

	public List<Map<String, Object>> getRank(QueryModel model) {
		// TODO 自动生成的方法存根
		return acrmAbrBusiSumMapper.getRank(model);
	}

	public List<Map<String, Object>> getPropertyInfo(QueryModel model) {
		String role = getRoles();
		List<Map<String, Object>> list= null;
		if("R002,R003".contains(role)){
			list = acrmAbrBusiSumMapper.getProp1(model);
		}else if ("R004,R018,R019".contains(role)){
			list = acrmAbrBusiSumMapper.getProp2(model);
		}else {
			if ("R005,R013,R014".contains(role)){
					model.getCondition().put("line","0");
			}else if ("R015,R017".contains(role)){
					model.getCondition().put("line","1");
			}else if ("R016".contains(role)){
					model.getCondition().put("line","2");
			}
			list = acrmAbrBusiSumMapper.getProp(model);
		}
		return list;
	}

}
