package cn.com.yusys.yscrm.custpub.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yscrm.custpub.domain.AdminSmUserAttr;
import cn.com.yusys.yscrm.custpub.repository.mapper.AdminSmUserAttrMapper;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AdminSmUserAttrService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-02-14 09:45:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AdminSmUserAttrService extends CommonService {
    @Autowired
    private AdminSmUserAttrMapper adminSmUserAttrMapper;
    @Autowired
    private UaaClient uaaClient;
	private static final String LOGINCODE = "loginCode";
    @Override
    protected CommonMapper<?> getMapper() {
        return adminSmUserAttrMapper;
    }
    
    /**
	 * @方法名称: addUserAttr
	 * @方法描述: 新增用户属性表信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public AdminSmUserAttr addUserAttr(AdminSmUserAttr adminSmUserAttr) {
		if(this.insertSelective(adminSmUserAttrMapper, adminSmUserAttr)!=1) {
			return null;
		}
		return adminSmUserAttr;
	}
	
	/**
	 * @方法名称: editUserAttr
	 * @方法描述: 修改视图信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public int editUserAttr(AdminSmUserAttr adminSmUserAttr) {
		Map<String,Object> params = new HashMap<>();
		params.put(LOGINCODE,adminSmUserAttr.getLoginCode());
		params.put("busiType",adminSmUserAttr.getBusiType());
		return adminSmUserAttrMapper.editUserAttr(params);
	}
	
	/**
	 * @方法名称: qryBusiType
	 * @方法描述: 根剧选中数据的登录代码查询业务条线字段
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String,Object>> qryBusiType(String loginCode){
		Map<String,Object> params = new HashMap<>();
		params.put(LOGINCODE,loginCode);
		return adminSmUserAttrMapper.qryBusiType(params);
	}

	public List<Map<String, Object>> getUserByParams(String orgCode, String size, String page,String userName,String roleId,String loginCode) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(size));
		Map<String,String> map=new HashMap<>();
		map.put("orgCode", orgCode);
		map.put(LOGINCODE, loginCode);
		map.put("roleId", roleId);
		map.put("userName", userName);
		List<Map<String, Object>> list = this.adminSmUserAttrMapper.getUserByParams(map);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, Object>> querybyrolests() {
		// TODO 自动生成的方法存根
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		List<ObjBean> list=user.getRoles();
		String[] roles=new String[]{"0000000"};
		for(int i=0;i<list.size();i++) {
			ObjBean obj=list.get(i);
			if(obj.getCode()!=null&&obj.getCode().equals("114")) {
				roles= new String[]{"105","103","102","101","100","R001"};
			}
		}
		List<Map<String, Object>> listRoles=this.adminSmUserAttrMapper.querybyrolests(roles);
		return listRoles;
	}

	public int updatePwdTime(String userId) {
		// TODO 自动生成的方法存根
		int result=this.adminSmUserAttrMapper.updatePwdTime(userId);
		return result;
	}

}
