package cn.com.yusys.yusp.uimp.bonus.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.bonus.domain.PmaFbonusPoolInfo;
import cn.com.yusys.yusp.uimp.bonus.repository.mapper.PmaFbonusPoolInfoMapper;
/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFbonusPoolInfoService
 * @类描述: #二次分配奖金池信息表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-08-06 10:24:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFbonusPoolInfoService extends CommonService {
	
    @Autowired
    private PmaFbonusPoolInfoMapper pmaFbonusPoolInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFbonusPoolInfoMapper;
    }

    /**
     * @方法名称: queryBonusPoolInfo
     * @方法描述: 分页查询-二次分配奖金池信息数据
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryBonusPoolInfo(QueryModel queryModel) throws Exception {
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = pmaFbonusPoolInfoMapper.queryBonusPoolInfo(queryModel);
		PageHelper.clearPage();
		return list;
	}
	
    /**
     * @方法名称: queryBonusPoolInfoByStatDateAndOrgId
     * @方法描述: 根据数据日期、机构ID，查询-二次分配奖金池信息数据
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public PmaFbonusPoolInfo queryBonusPoolInfoByStatDateAndOrgId(String statDate, String orgId) throws Exception {
		return pmaFbonusPoolInfoMapper.queryBonusPoolInfoByStatDateAndOrgId(statDate, orgId);
	}
}
