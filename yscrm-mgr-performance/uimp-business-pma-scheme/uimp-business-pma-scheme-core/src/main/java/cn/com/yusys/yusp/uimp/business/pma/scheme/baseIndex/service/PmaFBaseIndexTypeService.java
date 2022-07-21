package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexType;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper.PmaFBaseIndexInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper.PmaFBaseIndexTypeMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexTypeService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-02 16:29:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFBaseIndexTypeService extends CommonService {
    @Autowired
    private PmaFBaseIndexTypeMapper pmaFBaseIndexTypeMapper;
    @Autowired
    private PmaFBaseIndexInfoMapper pmaFBaseIndexInfoMapper;
    
    @Autowired
    private UserInfoService userInfoService;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFBaseIndexTypeMapper;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querymenulist() {
    	String  orgQxSql=userInfoService.getDataOrgAuth("T.ORG_ID", true);
		List<Map<String, Object>> list = this.pmaFBaseIndexTypeMapper.querymenulist(orgQxSql);
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFBaseIndexType> add (PmaFBaseIndexType pmaFBaseIndexType) throws Exception {
    	ResultDto<PmaFBaseIndexType> result = new ResultDto<PmaFBaseIndexType>();

		// 首先判断是否有相同名称的指标数据
		if (checkSameName(pmaFBaseIndexType)) {
			result.setCode(-1);
			result.setMessage("已存在相同名称的目录");
			return result;
		}
    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
    	pmaFBaseIndexType.setOrgId(userInfoService.getGrantOrgCode());
    	pmaFBaseIndexType.setCreateDate(df.format(new Date()));
    	pmaFBaseIndexType.setCreator(userInfoService.getUserInfo().getLoginCode());
    	this.pmaFBaseIndexTypeMapper.insertSelective(pmaFBaseIndexType);
		result.setData(pmaFBaseIndexType);
		result.setMessage("新增目录成功");
		result.setCode(0);
    	return result;
    }

    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFBaseIndexType> modify (PmaFBaseIndexType pmaFBaseIndexType) throws Exception {
    	ResultDto<PmaFBaseIndexType> result = new ResultDto<PmaFBaseIndexType>();// 首先判断是否有相同名称的指标数据
		if (checkSameName(pmaFBaseIndexType)) {
			result.setCode(-1);
			result.setMessage("已存在相同名称的目录");
			return result;
		}
    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
    	pmaFBaseIndexType.setUpdateDate(df.format(new Date()));
		pmaFBaseIndexType.setUpdaterId(userInfoService.getUserInfo().getLoginCode());
    	this.pmaFBaseIndexTypeMapper.updateByPrimaryKeySelective(pmaFBaseIndexType);
		result.setData(pmaFBaseIndexType);
		result.setMessage("修改目录成功");
		result.setCode(0);
    	return result;
    }
    
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> delete (PmaFBaseIndexType pmaFBaseIndexType){
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	String ids = pmaFBaseIndexType.getId();
    	String[] id = ids.split(",");
    	for (int i =0 ;i < id.length ; i++) {	
    		pmaFBaseIndexTypeMapper.deleteByIds(id[i]);
    		//关联删除子节点下数据
    		pmaFBaseIndexInfoMapper.deleInfo(id[i]);
    	}
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public List<Map<String, Object>>  delval (String dirId){
    	List<Map<String, Object>>list=pmaFBaseIndexTypeMapper.delval(dirId);
		return list;
    }

	/**
	 * 检查是否存在相同的目录名称
	 *
	 * @param indexType 目录信息
	 * @return 存在与否
	 * @author weixy6
	 * @date 2022/6/6
	 */
	private boolean checkSameName(PmaFBaseIndexType indexType) {
		return !pmaFBaseIndexTypeMapper.checkSameName(indexType.getId(), indexType.getTypeName()).isEmpty();
	}
}
