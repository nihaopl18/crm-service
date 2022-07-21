package cn.com.yusys.yscrm.sysview.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import cn.com.yusys.yscrm.sysview.domain.OcrmFsysViewManager;
import cn.com.yusys.yscrm.sysview.repository.mapper.OcrmFsysViewAuthMapper;
import cn.com.yusys.yscrm.sysview.repository.mapper.OcrmFsysViewManagerMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewManagerService
 * @类描述: 视图树
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 13:50:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFsysViewManagerService extends CommonService {
    @Autowired
    private OcrmFsysViewManagerMapper ocrmFsysViewManagerMapper;
    private static final String QUERYKEY =  "queryKey";
    @Autowired
	private UaaClient uaaClient;
    
    @Autowired
    private OcrmFsysViewAuthMapper ocrmFsysViewAuthMapper;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFsysViewManagerMapper;
    }
    
    /**
     * @方法名称:getSysViewTree
     * @方法描述:视图树初始化查询
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getSysViewTree(String sysId) {
        List<Map<String, Object>> list = ocrmFsysViewManagerMapper.getSysViewTree(sysId);
        return list;
    }
    
    /**
     * @方法名称:getViewInfo
     * @方法描述:节点信息查询
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public Map<String, Object> getViewInfo(String id) {
        return ocrmFsysViewManagerMapper.getViewInfo(id);
    }
    
    /**
     * @方法名称: createView
     * @方法描述: 新增
     * @参数与返回说明:
     * @算法描述:
     */
    public OcrmFsysViewManager createView(OcrmFsysViewManager ocrmFsysViewManager) {
    		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new java.util.Date());
		try {
			ocrmFsysViewManager.setLastChgDt(new Date(df.parse(time).getTime()));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFsysViewManager.setLastChgOrg(dto.getBody().getOrg().getCode());
		if(this.insertSelective(ocrmFsysViewManagerMapper, ocrmFsysViewManager)!=1) {
			return null;
		}
		return ocrmFsysViewManager;
    }

    /**
     * @方法名称: editView
     * @方法描述: 修改
     * @参数与返回说明:
     * @算法描述:
     */
    public OcrmFsysViewManager editView(OcrmFsysViewManager ocrmFsysViewManager) {
    		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new java.util.Date());
		try {
			ocrmFsysViewManager.setLastChgDt(new Date(df.parse(time).getTime()));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFsysViewManager.setLastChgOrg(dto.getBody().getOrg().getCode());
		if(this.updateSelective(ocrmFsysViewManagerMapper, ocrmFsysViewManager)!=1) {
			return null;
		}
		return ocrmFsysViewManager;
    }

    /**
     * @方法名称:deleteView
     * @方法描述: 删除，同时删除子节点及引用控制点和对应授权数据
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public int deleteView(String id) {
        int n = 0;
        List<String> list = ocrmFsysViewManagerMapper.getDeleteMenuId(id);
        for (int i = 0, listLen = list.size(); i < listLen; i++) {
            this.ocrmFsysViewAuthMapper.deleteMenuInfo(list.get(i));
            n = super.deleteByPrimaryKey(id);
        }
        return n;
    }

    /**
     * @方法名称: getListInfo
     * @方法描述: 视图项列表查询
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getListInfo(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        if (model.getCondition().containsKey(QUERYKEY)) {
            model.getCondition().put(QUERYKEY, "%" + model.getCondition().get(QUERYKEY) + "%");
        }
        List<Map<String, Object>> list = ocrmFsysViewManagerMapper.getListInfo(model);
        PageHelper.clearPage();
        return list;
    }
}
