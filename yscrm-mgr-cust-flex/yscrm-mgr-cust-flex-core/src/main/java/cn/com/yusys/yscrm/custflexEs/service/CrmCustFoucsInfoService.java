package cn.com.yusys.yscrm.custflexEs.service;

import java.util.Date;
import java.util.List;

import cn.com.yusys.yscrm.custflexEs.domain.CrmCustFoucsInfo;
import cn.com.yusys.yscrm.custflexEs.repository.mapper.CrmCustFoucsInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.util.StringUtil;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmCustFoucsInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: sawyerwei
 * @创建时间: 2020-12-07 12:30:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class CrmCustFoucsInfoService extends CommonService {
	
	private static final Logger log = LoggerFactory.getLogger(CrmCustFoucsInfoService.class);

    @Autowired
    private UserInfoService userInfoService;
    
    @Autowired
    private CrmCustFoucsInfoMapper crmCustFoucsInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return crmCustFoucsInfoMapper;
    }

    /**
     * @函数名称: updateCustFoucsInfo
     * @函数描述: 维护客户关注信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public String updateCustFoucsInfo(String custId) throws Exception {
    	try {
    		CrmCustFoucsInfo custFoucsInfo = null;
			if(StringUtil.isNotEmpty(custId)) {
				custFoucsInfo = crmCustFoucsInfoMapper.findIsAttention(custId, userInfoService.getUserInfo().getLoginCode());
				Integer count = 0;
				if(custFoucsInfo == null) {
					custFoucsInfo = new CrmCustFoucsInfo();
					custFoucsInfo.setCustId(custId);
					custFoucsInfo.setIsFoucs("1");
					custFoucsInfo.setCreateUser(userInfoService.getUserInfo().getLoginCode());
					custFoucsInfo.setCreateOrg(userInfoService.getOrgCode());
					custFoucsInfo.setCreateDt(new Date());
					count = crmCustFoucsInfoMapper.insertCustFoucsInfo(custFoucsInfo);
				} else {
					custFoucsInfo.setIsFoucs("1".equals(custFoucsInfo.getIsFoucs()) ? "0" : "1");
					count = crmCustFoucsInfoMapper.updateCustFoucsInfo(custFoucsInfo);
				}
				if(count == 0) {
					log.warn("updateCustFoucsInfo fail custId:{}, createUser:{}", custId, userInfoService.getUserInfo().getLoginCode());
				}
			} else {
				log.warn("custId is null, cannot update custFoucsInfo");
				return "-1";
			}
    		return custId;
    	} catch (Exception e) {
    		log.error("updateCustFoucsInfo error custId:{}", custId, e);
    		throw e;
    	}
    }
    
    /**
     * @函数名称: queryFocusCustIds
     * @函数描述: 查询当前人关注的客户编号信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<String> queryFocusCustIds() {
    	return crmCustFoucsInfoMapper.queryFocusCustIds(userInfoService.getUserInfo().getLoginCode());
    }
    
    /**
     * @函数名称: batchSetFoucsCusts
     * @函数描述: 批量设置关注客户
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public String batchSetFoucsCusts(String custIds) throws Exception {
    	try {
    		CrmCustFoucsInfo custFoucsInfo = null;
			if(StringUtil.isNotEmpty(custIds)) {
				String[] custIdsArr = custIds.split(",");
				for(String custId: custIdsArr) {
					custFoucsInfo = crmCustFoucsInfoMapper.findIsAttention(custId, userInfoService.getUserInfo().getLoginCode());
					if(custFoucsInfo == null) {
						custFoucsInfo = new CrmCustFoucsInfo();
						custFoucsInfo.setCustId(custId);
						custFoucsInfo.setIsFoucs("1");
						custFoucsInfo.setCreateUser(userInfoService.getUserInfo().getLoginCode());
						custFoucsInfo.setCreateOrg(userInfoService.getOrgCode());
						custFoucsInfo.setCreateDt(new Date());
						crmCustFoucsInfoMapper.insertCustFoucsInfo(custFoucsInfo);
					} else if("0".equals(custFoucsInfo.getIsFoucs())) {	// 只维护-未关注的数据
						custFoucsInfo.setIsFoucs("1");
						crmCustFoucsInfoMapper.updateCustFoucsInfo(custFoucsInfo);
					}
				}
			} else {
				log.warn("custIds is null, cannot batch setFoucsCusts");
				return "-1";
			}
    		return "";
    	} catch (Exception e) {
    		log.error("batchSetFoucsCusts error custIds:{}", custIds, e);
    		throw e;
    	}
    }

    /**
     * 查询当前客户是否关注
     * @param custId
     * @param loginCode
     * @return
     */
	public CrmCustFoucsInfo findIsAttention(String custId, String loginCode) {
		// TODO 自动生成的方法存根
		return crmCustFoucsInfoMapper.findIsAttention(custId, loginCode);
	}
}
