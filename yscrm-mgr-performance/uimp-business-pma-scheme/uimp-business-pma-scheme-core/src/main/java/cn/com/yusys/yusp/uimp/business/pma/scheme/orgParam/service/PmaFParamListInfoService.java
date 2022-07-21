package cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.domain.PmaFParamListInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.repository.mapper.PmaFParamListInfoMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFParamListInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-09 17:02:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFParamListInfoService extends CommonService {
    @Autowired
    private PmaFParamListInfoMapper pmaFParamListInfoMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFParamListInfoMapper;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(String paramId) {
		List<Map<String, Object>> list = this.pmaFParamListInfoMapper.querylist(paramId);
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFParamListInfo> add (List<PmaFParamListInfo> list) throws Exception {
    	ResultDto<PmaFParamListInfo> result = new ResultDto<PmaFParamListInfo>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	this.pmaFParamListInfoMapper.deldetail(list.get(0).getParamId());
    	if(list.size()==1&&(list.get(0).getOrgId()==null||"".equals(list.get(0).getOrgId()))) {
    		
    	}else {
    		 for(int i=0;i<list.size();i++) {
            	 //保存参数明细信息
            	list.get(i).setCreatorId(userInfoService.getUserInfo().getUserId());
            	list.get(i).setModifyUserId(userInfoService.getUserInfo().getUserId());
            	this.pmaFParamListInfoMapper.insertSelective(list.get(i));
            }
    	}
       
		//result.setData(pmaFParamListInfo);
		result.setMessage("新增参数明细成功");
		result.setCode(0);
    	return result;
    }
}
