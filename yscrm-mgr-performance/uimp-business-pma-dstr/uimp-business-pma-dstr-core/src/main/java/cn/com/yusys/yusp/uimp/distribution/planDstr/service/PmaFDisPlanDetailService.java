package cn.com.yusys.yusp.uimp.distribution.planDstr.service;

import java.math.BigDecimal;
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
import cn.com.yusys.yusp.uimp.displan.domain.PmaFDisPlanDetail;
import cn.com.yusys.yusp.uimp.displan.repository.mapper.PmaFDisPlanDetailMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFDisPlanDetailService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-03-26 10:16:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFDisPlanDetailService extends CommonService {
    @Autowired
    private PmaFDisPlanDetailMapper pmaFDisPlanDetailMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFDisPlanDetailMapper;
    }
    /**
     * 查询
     * @param model
     * @return
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.pmaFDisPlanDetailMapper.listByModel(model);
		PageHelper.clearPage();
		return list;
	}
    /**
     * 新增
     * @param map
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<String> add(Map<String, Object> map) {
		String list = (String) map.get("list");
		String bussType = (String) map.get("bussType");
		String orgNo = (String) map.get("orgNo");
		String orgName = (String) map.get("orgName");
		JSONArray listArray = JSONArray.fromObject(list);
		pmaFDisPlanDetailMapper.deleteSql(bussType,orgNo);
		for (int i = 0; i < listArray.size(); i++) {
			PmaFDisPlanDetail pmaFDisPlanDetail = new PmaFDisPlanDetail();
			JSONObject listJson = listArray.getJSONObject(i);
			pmaFDisPlanDetail.setBussType(bussType);
			pmaFDisPlanDetail.setDistrRate(BigDecimal.valueOf(listJson.getLong("distrRate")));
			pmaFDisPlanDetail.setManagerType(listJson.getString("managerType"));
			pmaFDisPlanDetail.setOrgNo(orgNo);
			pmaFDisPlanDetail.setOrgName(orgName);
			pmaFDisPlanDetailMapper.insertSelective(pmaFDisPlanDetail);
		}
		ResultDto<String> result = new ResultDto<String>();
		result.setCode(0);
		result.setMessage("保存成功！");
		return result;
	}

}
