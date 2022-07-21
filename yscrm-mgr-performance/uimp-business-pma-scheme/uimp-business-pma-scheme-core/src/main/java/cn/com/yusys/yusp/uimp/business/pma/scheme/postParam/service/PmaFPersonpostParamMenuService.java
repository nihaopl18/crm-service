package cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.service;

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
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.domain.PmaFParamMenu;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.repository.mapper.PmaFParamInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain.PmaFPersonpostParamMenu;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.repository.mapper.PmaFPersonpostParamInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.repository.mapper.PmaFPersonpostParamMenuMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFPersonpostParamMenuService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-10 10:35:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFPersonpostParamMenuService extends CommonService {
    @Autowired
    private PmaFPersonpostParamMenuMapper pmaFPersonpostParamMenuMapper;
    
    @Autowired
    private PmaFPersonpostParamInfoMapper pmaFPersonpostParamInfoMapper;
    
    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFPersonpostParamMenuMapper;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querymenulist() {
    	String  orgQxSql=userInfoService.getDataOrgAuth("T.ORG_ID", false);
		List<Map<String, Object>> list = this.pmaFPersonpostParamMenuMapper.querymenulist(orgQxSql);
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFPersonpostParamMenu> add (PmaFPersonpostParamMenu pmaFPersonpostParamMenu) throws Exception {
    	ResultDto<PmaFPersonpostParamMenu> result = new ResultDto<PmaFPersonpostParamMenu>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	pmaFPersonpostParamMenu.setCreator(userInfoService.getUserInfo().getLoginCode());
    	pmaFPersonpostParamMenu.setCreateDate(df.format(new Date()));
    	pmaFPersonpostParamMenu.setOrgId(userInfoService.getUserInfo().getOrg().getId());
    	this.pmaFPersonpostParamMenuMapper.insertSelective(pmaFPersonpostParamMenu);
		result.setData(pmaFPersonpostParamMenu);
		result.setMessage("新增目录成功");
		result.setCode(0);
    	return result;
    }

    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFPersonpostParamMenu> modify (PmaFPersonpostParamMenu pmaFPersonpostParamMenu) throws Exception {
    	ResultDto<PmaFPersonpostParamMenu> result = new ResultDto<PmaFPersonpostParamMenu>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	pmaFPersonpostParamMenu.setModifyDate(df.format(new Date()));
    	pmaFPersonpostParamMenu.setModifyUser(userInfoService.getUserInfo().getLoginCode());
    	this.pmaFPersonpostParamMenuMapper.updateByPrimaryKeySelective(pmaFPersonpostParamMenu);
		result.setData(pmaFPersonpostParamMenu);
		result.setMessage("修改目录成功");
		result.setCode(0);
    	return result;
    }
    
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> delete (String id){
    	ResultDto<Integer> result = new ResultDto<Integer>();
        this.pmaFPersonpostParamMenuMapper.deleteByIds(id);
        this.pmaFPersonpostParamInfoMapper.deleInfo(id);
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
    @Transactional(readOnly = true)
    public Map<String, Object> queryIsMenuCode(String dirId) {
		Map<String, Object> map = this.pmaFPersonpostParamMenuMapper.queryIsMenuCode(dirId);
		return map;
	}
}
