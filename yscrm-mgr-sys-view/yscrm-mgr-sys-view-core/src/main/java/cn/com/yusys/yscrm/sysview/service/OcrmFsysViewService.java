package cn.com.yusys.yscrm.sysview.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import cn.com.yusys.yscrm.sysview.domain.OcrmFsysView;
import cn.com.yusys.yscrm.sysview.repository.mapper.OcrmFsysViewMapper;
import cn.com.yusys.yusp.admin.service.MessageProviderService;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

import cn.com.yusys.yusp.commons.web.rest.exception.YuspException;
/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewService
 * @类描述: 视图
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-16 19:38:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFsysViewService extends CommonService {
    @Autowired
    private OcrmFsysViewMapper ocrmFsysViewMapper;

    @Autowired
    private MessageProviderService messageProviderService;
	private static final String VIEWNAME =  "viewName";
    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFsysViewMapper;
    }
    
    /**
	 * @方法名称: getViewlist
	 * @方法描述: 查询视图信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getViewlist(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		if (model.getCondition().containsKey(VIEWNAME)) {
			model.getCondition().put(VIEWNAME, "%" + model.getCondition().get(VIEWNAME) + "%");
		}
		List<Map<String, Object>> list = this.ocrmFsysViewMapper.getViewlist(model);
		PageHelper.clearPage();
		return list;
	}
	
	/**
	 * @方法名称: createView
	 * @方法描述: 新增视图信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public OcrmFsysView createView(OcrmFsysView ocrmFsysView) {
		if(this.insertSelective(ocrmFsysViewMapper, ocrmFsysView)!=1) {
			return null;
		}
		return ocrmFsysView;
	}

	/**
	 * @方法名称: editView
	 * @方法描述: 修改视图信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public OcrmFsysView editView(OcrmFsysView ocrmFsysView) {
		if(this.updateSelective(ocrmFsysViewMapper, ocrmFsysView)!=1) {
			return null;
		}
		return ocrmFsysView;
	}

    /**
     * @方法名称: deleteView
     * @方法描述: 删除视图信息，如模块已关联视图项，不允许删除
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int deleteView(String viewId){
	    int n=0;
        if(viewId!=null&&!viewId.equals("")){
            int unDelete = ocrmFsysViewMapper.getItemByViewId(viewId);
            if(unDelete!=0){
                throw new YuspException(messageProviderService.getMessage("110000"));
            }else{
                n = n + this.ocrmFsysViewMapper.deleteByPrimaryKey(viewId);
            }
        }
        return n;
    }

	/**
	 * @方法名称: checkName
	 * @方法描述: 保存数据前查询视图名称是否已经存在
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String,Object>> checkName(String viewName,String viewId){
		Map<String,Object> params = new HashMap<>();
		params.put(VIEWNAME,viewName);
		params.put("viewId",viewId);
		return ocrmFsysViewMapper.checkName(params);
	}
}
