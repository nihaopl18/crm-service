package cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexType;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.domain.PmaFParamMenu;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.repository.mapper.PmaFParamInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.repository.mapper.PmaFParamMenuMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFParamMenuService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-09 09:56:57
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFParamMenuService extends CommonService {
    @Autowired
    private PmaFParamMenuMapper pmaFParamMenuMapper;
    
    @Autowired
    private PmaFParamInfoMapper pmaFParamInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFParamMenuMapper;
    }
    @Autowired
    private UserInfoService userInfoService;
    
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querymenulist() {
    	String  orgQxSql=userInfoService.getDataOrgAuth("T.ORG_ID", false);
		List<Map<String, Object>> list = this.pmaFParamMenuMapper.querymenulist(orgQxSql);
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFParamMenu> add (PmaFParamMenu pmaFParamMenu) throws Exception {
    	ResultDto<PmaFParamMenu> result = new ResultDto<PmaFParamMenu>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	pmaFParamMenu.setCreator(userInfoService.getUserInfo().getLoginCode());
    	pmaFParamMenu.setCreateDate(df.format(new Date()));
    	pmaFParamMenu.setOrgId(userInfoService.getUserInfo().getOrg().getId());
    	this.pmaFParamMenuMapper.insertSelective(pmaFParamMenu);
		result.setData(pmaFParamMenu);
		result.setMessage("新增目录成功");
		result.setCode(0);
    	return result;
    }

    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFParamMenu> modify (PmaFParamMenu pmaFParamMenu) throws Exception {
    	ResultDto<PmaFParamMenu> result = new ResultDto<PmaFParamMenu>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	pmaFParamMenu.setModifyDate(df.format(new Date()));
    	pmaFParamMenu.setModifyUser(userInfoService.getUserInfo().getLoginCode());
    	this.pmaFParamMenuMapper.updateByPrimaryKeySelective(pmaFParamMenu);
		result.setData(pmaFParamMenu);
		result.setMessage("修改目录成功");
		result.setCode(0);
    	return result;
    }
    
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> delete (String id){
    	ResultDto<Integer> result = new ResultDto<Integer>();
        this.pmaFParamMenuMapper.deleteByIds(id);
        this.pmaFParamInfoMapper.deleInfo(id);
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
    @Transactional(readOnly = true)
    public Map<String, Object> queryIsMenuCode(String dirId) {
		Map<String, Object> map = this.pmaFParamMenuMapper.queryIsMenuCode(dirId);
		return map;
	}
}
