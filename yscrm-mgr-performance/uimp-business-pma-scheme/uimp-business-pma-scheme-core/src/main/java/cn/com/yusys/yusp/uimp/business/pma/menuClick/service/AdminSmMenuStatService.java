package cn.com.yusys.yusp.uimp.business.pma.menuClick.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.business.pma.menuClick.domain.AdminSmMenuStat;
import cn.com.yusys.yusp.uimp.business.pma.menuClick.repository.mapper.AdminSmMenuStatMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: AdminSmMenuStatService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-04-03 13:57:16
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class AdminSmMenuStatService extends CommonService {
    @Autowired
    private AdminSmMenuStatMapper adminSmMenuStatMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return adminSmMenuStatMapper;
    }

    @Transactional(readOnly = true)
   	public List<Map<String, Object>> querylist(QueryModel model) {
       	PageHelper.startPage(model.getPage(), model.getSize());
   		List<Map<String, Object>> list = this.adminSmMenuStatMapper.listByModel(model);
   		PageHelper.clearPage();
   		return list;
   	}
}
