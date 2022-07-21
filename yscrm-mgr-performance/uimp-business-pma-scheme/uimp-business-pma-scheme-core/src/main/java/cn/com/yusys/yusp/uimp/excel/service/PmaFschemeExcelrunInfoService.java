package cn.com.yusys.yusp.uimp.excel.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelrunInfo;
import cn.com.yusys.yusp.uimp.excel.repository.mapper.PmaFschemeExcelrunInfoMapper;
import tk.mybatis.mapper.util.StringUtil;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelrunInfoService
 * @类描述: #考核方案报表运行信息表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-25 14:49:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFschemeExcelrunInfoService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFschemeExcelrunInfoService.class);
	
    @Autowired
    private PmaFschemeExcelrunInfoMapper pmaFschemeExcelrunInfoMapper;
    
	@Autowired
	private UserInfoService userInfo; 

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFschemeExcelrunInfoMapper;
    }

    /**
     * @函数名称:getRunInfoBySchemeIdAndEtlDate
     * @函数描述:根据考核方案ID、数据日期，查询考核方案报表运行信息表数据
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public PmaFschemeExcelrunInfo getRunInfoBySchemeIdAndEtlDate(String schemeId, String etlDate) {
    	if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate)) {
    		return pmaFschemeExcelrunInfoMapper.getRunInfoBySchemeIdAndEtlDate(schemeId, etlDate);
    	} else {
    		logger.warn("schemeId or etlDate is null, can not getRunInfo");
    		return null;
    	}
    }
    
    /**
     * @函数名称:getSchemeRunInfoList
     * @函数描述:考核方案运行状态信息列表查询接口
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getSchemeRunInfoList(QueryModel queryModel) throws Exception {
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		queryModel.getCondition().put("userOrgId", userInfo.getGrantOrgCode());
		List<Map<String, Object>> list = pmaFschemeExcelrunInfoMapper.getSchemeRunInfoList(queryModel);
		PageHelper.clearPage();
		return list;
	}
	
    /**
     * @函数名称:getMySchemeInfoList
     * @函数描述:获取我的考核方案列表数据
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getMySchemeInfoList(QueryModel queryModel) throws Exception {
		queryModel.getCondition().put("loginCode", userInfo.getUserInfo().getLoginCode());
		queryModel.getCondition().put("orgId", userInfo.getGrantOrgCode());
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = pmaFschemeExcelrunInfoMapper.getMySchemeInfoList(queryModel);
		PageHelper.clearPage();
		return list;
	}
	
    /**
     * @函数名称:getOrgStaffSchemeInfoList
     * @函数描述:获取机构辖内员工考核方案列表数据
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getOrgStaffSchemeInfoList(QueryModel queryModel) throws Exception {
		queryModel.getCondition().put("orgId", userInfo.getGrantOrgCode());
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = pmaFschemeExcelrunInfoMapper.getOrgStaffSchemeInfoList(queryModel);
		PageHelper.clearPage();
		return list;
	}

	public ResultDto<Integer> del(String ids) {
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	String[] id = ids.split(",");
    	for (int i =0 ;i < id.length ; i++) {	
    		pmaFschemeExcelrunInfoMapper.deleteByIds(id[i]);
    	}
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
}
