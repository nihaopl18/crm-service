package cn.com.yusys.yusp.uimp.business.pma.app.service;

import cn.com.yusys.yusp.admin.service.MessageProviderService;
import cn.com.yusys.yusp.commons.exception.YuspException;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.app.domain.PmaAppMarketActivityInfo;
import cn.com.yusys.yusp.uimp.business.pma.app.repository.mapper.PmaAppMarketActivityInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFScheme;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @项目名称: uimp-business-pma-app-core模块
 * @类名称: PmaFMarketActivityInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-07-08 14:20:35
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaAppMarketActivityInfoService extends CommonService {
    @Autowired
    private PmaAppMarketActivityInfoMapper pmaAppMarketActivityInfoMapper;
    
    @Autowired
    private MessageProviderService messageProviderService;
    
    @Autowired
	private UserInfoService userInfoService;
    
    @Autowired
	private AppPerformanceService appPerformanceService;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaAppMarketActivityInfoMapper;
    }

    /**
     * 查询
     * @param model
     * @return
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.pmaAppMarketActivityInfoMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}
    
    /**
     * 保存或更新新闻事件信息
     * @param pmaAppNews
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Object> saveOrUpdate(PmaAppMarketActivityInfo pmaFMarketActivityInfo) {
    	ResultDto<Object> resultDto = new ResultDto<Object>();
    	try {
			if(pmaFMarketActivityInfo.getInfoId()==null || "".equals(pmaFMarketActivityInfo.getInfoId())) {
				pmaFMarketActivityInfo.setState("1");
				pmaFMarketActivityInfo.setCratDt(new Date());
				pmaFMarketActivityInfo.setCratOrg(userInfoService.getGrantOrgCode());
				pmaFMarketActivityInfo.setCratUse(userInfoService.getUserInfo().getLoginCode());
				pmaFMarketActivityInfo.setIsDel("0");
				this.pmaAppMarketActivityInfoMapper.insertSelective(pmaFMarketActivityInfo);
				resultDto.setCode(0);
				resultDto.setMessage("新增成功");
			} else {
				pmaFMarketActivityInfo.setLastChgDt(new Date());
				pmaFMarketActivityInfo.setLastChgOrg(userInfoService.getGrantOrgCode());
				pmaFMarketActivityInfo.setLastChgUse(userInfoService.getUserInfo().getLoginCode());
				if("0".equals(pmaFMarketActivityInfo.getState()) && ("0".equals(pmaFMarketActivityInfo.getIsDel()))) {
					//判断数据只有一个有效状态，如果存在其他有效的数据默认置成无效
					QueryModel model = new QueryModel();
					model.getCondition().put("state", pmaFMarketActivityInfo.getState());
					model.getCondition().put("specialInfoId", pmaFMarketActivityInfo.getInfoId());
					List<Map<String, Object>> list = this.pmaAppMarketActivityInfoMapper.querylist(model);
					if(list.size() > 0) {
						for(int i=0;i<list.size();i++) {
							PmaAppMarketActivityInfo newInfo = new PmaAppMarketActivityInfo();
							newInfo.setInfoId(list.get(i).get("infoId").toString());
							newInfo.setState("1");
							newInfo.setLastChgDt(new Date());
							newInfo.setLastChgOrg(userInfoService.getGrantOrgCode());
							newInfo.setLastChgUse(userInfoService.getUserInfo().getLoginCode());
							this.pmaAppMarketActivityInfoMapper.updateByPrimaryKeySelective(newInfo);
						}
					}
				}
				this.pmaAppMarketActivityInfoMapper.updateByPrimaryKeySelective(pmaFMarketActivityInfo);
				resultDto.setCode(0);
				resultDto.setMessage("修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new YuspException(messageProviderService.getMessage("300000"));
		}
    	return resultDto;
    }
    
    /**
     * 查询
     * @param model
     * @return
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querySchemeIndex(QueryModel model) {
    	List<PmaFScheme> pmaFSchemeList = appPerformanceService.selectDrawSchemeInfo(model.getCondition().get("schemeId").toString());
		PmaFScheme pmaFScheme = pmaFSchemeList.get(0);
    	if(model.getCondition().get("evlObjId") == null) {
    		if(pmaFScheme.getEvlObjType().equals("01")) {
    			model.getCondition().put("evlObjId", userInfoService.getUserInfo().getLoginCode());
    		}else {
    			model.getCondition().put("evlObjId", userInfoService.getGrantOrgCode());
    		}
    	}
    	if(model.getCondition().get("etlDate") == null) {
    		model.getCondition().put("etlDate", appPerformanceService.queryEtlDate().get(0).get("etlDate").toString());
    	}
    	List<Map<String, Object>> list = appPerformanceService.queryScheme(model);
    	return list;
  	}
}
