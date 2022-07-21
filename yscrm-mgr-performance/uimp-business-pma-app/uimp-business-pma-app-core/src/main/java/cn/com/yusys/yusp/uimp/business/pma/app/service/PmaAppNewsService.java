package cn.com.yusys.yusp.uimp.business.pma.app.service;

import cn.com.yusys.yusp.admin.service.MessageProviderService;
import cn.com.yusys.yusp.commons.exception.YuspException;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.app.domain.PmaAppNews;
import cn.com.yusys.yusp.uimp.business.pma.app.repository.mapper.PmaAppNewsMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @项目名称: uimp-business-pma-app-core模块
 * @类名称: PmaAppNewsService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-03 10:48:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaAppNewsService extends CommonService {
	
    @Autowired
    private PmaAppNewsMapper pmaAppNewsMapper;
    
    @Autowired
    private MessageProviderService messageProviderService;
    
    @Autowired
	private UserInfoService userInfoService;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaAppNewsMapper;
    }
    
    /**
     * 查询
     * @param model
     * @return
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.pmaAppNewsMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}
    
    /**
     * 保存或更新新闻事件信息
     * @param pmaAppNews
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Object> saveOrUpdate(PmaAppNews pmaAppNews) {
    	ResultDto<Object> resultDto = new ResultDto<Object>();
    	try {
			if(pmaAppNews.getId()==null || "".equals(pmaAppNews.getId())) {
				pmaAppNews.setState("1");
				pmaAppNews.setCratDt(new Date());
				pmaAppNews.setCratOrg(userInfoService.getGrantOrgCode());
				pmaAppNews.setCratUse(userInfoService.getUserInfo().getLoginCode());
				pmaAppNews.setIsDel("0");
				this.pmaAppNewsMapper.insertSelective(pmaAppNews);
				resultDto.setCode(0);
				resultDto.setMessage("新增成功");
			} else {
				pmaAppNews.setLastChgDt(new Date());
				pmaAppNews.setLastChgOrg(userInfoService.getGrantOrgCode());
				pmaAppNews.setLastChgUse(userInfoService.getUserInfo().getLoginCode());
				this.pmaAppNewsMapper.updateByPrimaryKeySelective(pmaAppNews);
				resultDto.setCode(0);
				resultDto.setMessage("修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new YuspException(messageProviderService.getMessage("300000"));
		}
    	return resultDto;
    }

}
