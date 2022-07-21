package cn.com.yusys.yusp.uimp.distribution.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFDistributionMode;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFDistributionModeDetailMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFDistributionModeMapper;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFDistributionModeService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-23 10:35:54
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFDistributionModeService extends CommonService {
    @Autowired
    private PmaFDistributionModeMapper pmaFDistributionModeMapper;
    
    @Autowired
    private PmaFDistributionModeDetailMapper pmaFDistributionModeDetailMapper;
    
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFDistributionModeMapper;
    }

    @Transactional(readOnly = true)
	public List<Map<String,Object>> queryList(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = pmaFDistributionModeMapper.queryList(model);
		PageHelper.clearPage();
		return list;
	}
    
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Map<String,Object> insertInfo(PmaFDistributionMode pool) {
		Map<String,Object> result=new HashMap<String, Object>();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		//校验机构数据是否已存在
		QueryModel model = new QueryModel();
		model.getCondition().put("brchNo", pool.getBrchNo());
		List<Map<String, Object>> res=pmaFDistributionModeMapper.queryList(model);
		if(res.size()==0) {
			pool.setCreateUser(userInfoService.getUserInfo().getLoginCode());
			pool.setCreateUserName(userInfoService.getUserInfo().getUserName());
			pool.setCreateDt(df.format(new Date()));
			this.insert(getMapper(), pool);
			result.put("code", "0");
			result.put("message", "数据新增成功。");
		}else {//如果已存在就不能新增
			result.put("code", "-1");
			result.put("message", "相同机构号的数据已经存在。");
		}
		return result;
	}
	
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Map<String,Object> updateInfo(PmaFDistributionMode pool) {
		Map<String,Object> result=new HashMap<String, Object>();
		this.updateSelective(getMapper(), pool);
		result.put("code", "0");
		result.put("message", "数据修改成功。");
		return result;
	}
	
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> delMode (String brchNos){
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	String[] brchNo = brchNos.split(",");
    	for (int i =0 ;i < brchNo.length ; i++) {	
    		pmaFDistributionModeMapper.delMode(brchNo[i]);
    		pmaFDistributionModeDetailMapper.delDetail(brchNo[i]);
    	}
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
}
