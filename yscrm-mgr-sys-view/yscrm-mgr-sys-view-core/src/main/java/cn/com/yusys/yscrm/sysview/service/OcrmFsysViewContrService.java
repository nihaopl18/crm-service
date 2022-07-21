package cn.com.yusys.yscrm.sysview.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import cn.com.yusys.yscrm.sysview.domain.OcrmFsysViewContr;
import cn.com.yusys.yscrm.sysview.repository.mapper.OcrmFsysViewAuthMapper;
import cn.com.yusys.yscrm.sysview.repository.mapper.OcrmFsysViewContrMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewContrService
 * @类描述: 视图控制点
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 13:50:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFsysViewContrService extends CommonService {
    @Autowired
    private OcrmFsysViewContrMapper ocrmFsysViewContrMapper;

    @Autowired
    private OcrmFsysViewAuthMapper ocrmFsysViewAuthMapper;
    
    @Autowired
	private UaaClient uaaClient;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFsysViewContrMapper;
    }
    
    /**
     * @方法名称:getContrInfo
     * @方法描述:查询控制点信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getContrInfo(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        if (model.getCondition().containsKey("contrCode")) {
            model.getCondition().put("contrCode", "%" + model.getCondition().get("contrCode") + "%");
        }
        if (model.getCondition().containsKey("contrName")) {
            model.getCondition().put("contrName", "%" + model.getCondition().get("contrName") + "%");
        }
        if (model.getCondition().containsKey("contrUrl")) {
            model.getCondition().put("contrUrl", "%" + model.getCondition().get("contrUrl") + "%");
        }
        List<Map<String, Object>> list = this.ocrmFsysViewContrMapper.getContrInfo(model);
        PageHelper.clearPage();
        return list;
    }

    /**
     * @方法名称: ifCodeRepeat
     * @方法描述: 保存控制点信息前，判断视图项是否已关联相同控制操作代码的控制点
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> ifCodeRepeat(String viewItemId, String contrCode, String contrId) {
        Map<String, Object> params = new HashMap<>();
        params.put("viewItemId", viewItemId);
        params.put("contrCode", contrCode);
        params.put("contrId", contrId);
        return ocrmFsysViewContrMapper.ifCodeRepeat(params);
    }

    /**
     * @方法名称: createContr
     * @方法描述: 新增控制点信息
     * @参数与返回说明:
     * @算法描述:
     */
    public OcrmFsysViewContr createContr(OcrmFsysViewContr ocrmFsysViewContr) {
    		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new java.util.Date());
		ocrmFsysViewContr.setLastChgDt(time);
		if(this.insertSelective(ocrmFsysViewContrMapper, ocrmFsysViewContr)!=1) {
			return null;
		}
		return ocrmFsysViewContr;
    }

    /**
     * @方法名称: editContr
     * @方法描述: 修改控制点信息
     * @参数与返回说明:
     * @算法描述:
     */
    public OcrmFsysViewContr editContr(OcrmFsysViewContr ocrmFsysViewContr) {
    		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new java.util.Date());
		ocrmFsysViewContr.setLastChgDt(time);
        if(this.updateSelective(ocrmFsysViewContrMapper, ocrmFsysViewContr)!=1) {
			return null;
		}
		return ocrmFsysViewContr;
    }

    /**
     * @方法名称: deleteContr
     * @方法描述: 删除控制点时删除对应的数据权限及二者的授权数据
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public int deleteContr(String ids) {
        int n = 0;
        if (ids != null && !"".equals(ids)) {
            String[] contrIds = ids.split(",");
	        //删除权限表控制点数据
	        this.ocrmFsysViewAuthMapper.deleteContrInfo(contrIds);
            for (int i = 0; i < contrIds.length; i++) {
                if (!"".equals(contrIds[i])) {
                    n = n + this.ocrmFsysViewContrMapper.deleteByPrimaryKey(contrIds[i]);
                }
            }
        }
        return n;
    }

    /**
     * @方法名称: getViewTree
     * @方法描述: 左侧树查询
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getViewTree(QueryModel model) {
        List<Map<String, Object>> list = ocrmFsysViewContrMapper.getViewTree(model);
        return list;
    }
}
