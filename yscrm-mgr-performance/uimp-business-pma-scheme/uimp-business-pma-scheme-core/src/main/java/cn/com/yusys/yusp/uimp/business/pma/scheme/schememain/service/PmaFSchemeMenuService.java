package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeMenu;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeMenuMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeMenuService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 09:56:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFSchemeMenuService extends CommonService {
    @Autowired
    private PmaFSchemeMenuMapper pmaFSchemeMenuMapper;

    @Autowired
    private UserInfoService userInfoService;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFSchemeMenuMapper;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) {
    	model.getCondition().put("orgId", userInfoService.getOrgCode());
		List<Map<String, Object>> list = this.pmaFSchemeMenuMapper.listByModel(model);
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<PmaFSchemeMenu> add(PmaFSchemeMenu pmaFSchemeMenu) {
		UserInfoDTO user = getUser();
    	pmaFSchemeMenu.setCreator(user.getLoginCode());
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    	pmaFSchemeMenu.setCreateDate(dateFormat.format(new Date()));
    	ResultDto<PmaFSchemeMenu> result = new ResultDto<PmaFSchemeMenu>();
    	this.pmaFSchemeMenuMapper.insertSelective(pmaFSchemeMenu);
    	result.setData(pmaFSchemeMenu);
    	result.setMessage("新增目录成功");
        result.setCode(0);
    	return result;
    }
    private UserInfoDTO getUser() {
		UserInfoDTO user = userInfoService.getUserInfo();
    	return user;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<PmaFSchemeMenu> modify(PmaFSchemeMenu pmaFSchemeMenu) {
		UserInfoDTO user = this.getUser();
    	ResultDto<PmaFSchemeMenu> result = new ResultDto<PmaFSchemeMenu>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		pmaFSchemeMenu.setUpdateUser(user.getLoginCode());
		pmaFSchemeMenu.setUpdateDate(dateFormat.format(new Date()));
		this.pmaFSchemeMenuMapper.updateByPrimaryKeySelective(pmaFSchemeMenu);
		result.setData(pmaFSchemeMenu);
		result.setMessage("修改目录成功");
		result.setCode(0);
    	return result;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> delete (String  ids){
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	String[] id = ids.split(",");
    	for (int i =0 ;i < id.length ; i++) {	
    		pmaFSchemeMenuMapper.deleteByIds(id[i]);
    	}
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
}
