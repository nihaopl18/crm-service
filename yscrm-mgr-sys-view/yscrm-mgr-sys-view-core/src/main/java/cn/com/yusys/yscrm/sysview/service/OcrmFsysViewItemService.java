package cn.com.yusys.yscrm.sysview.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import cn.com.yusys.yscrm.sysview.domain.OcrmFsysViewItem;
import cn.com.yusys.yscrm.sysview.repository.mapper.OcrmFsysViewItemMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewItemService
 * @类描述: 视图项
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 13:47:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFsysViewItemService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(OcrmFsysViewItemService.class);
    @Autowired
    private OcrmFsysViewItemMapper ocrmFsysViewItemMapper;

    @Autowired
	private UaaClient uaaClient;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFsysViewItemMapper;
    }
    /**
	 * @方法名称: getViewItemlist
	 * @方法描述: 查询视图项信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getViewItemlist(QueryModel model) {
		if (model.getCondition().get("viewId") == null || model.getCondition().get("viewId").equals("")) {
            return null;
        } else {
			PageHelper.startPage(model.getPage(), model.getSize());
			if (model.getCondition().containsKey("viewItemName")) {
				if (model.getCondition().get("viewItemName") != null && !model.getCondition().get("viewItemName").equals("")) {
					model.getCondition().put("viewItemName", "%" + model.getCondition().get("viewItemName") + "%");
				}
			}
			if (model.getCondition().containsKey("viewAddr")) {
				if (model.getCondition().get("viewAddr") != null && !model.getCondition().get("viewAddr").equals("")) {
					model.getCondition().put("viewAddr", "%" + model.getCondition().get("viewAddr") + "%");
				}
			}
			List<Map<String, Object>> list = this.ocrmFsysViewItemMapper.getViewItemlist(model);
			PageHelper.clearPage();
			return list;
        }
	}
	
	/**
	 * @方法名称: createView
	 * @方法描述: 新增视图项信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public OcrmFsysViewItem createViewItem(OcrmFsysViewItem ocrmFsysViewItem) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new java.util.Date());
		try {
			ocrmFsysViewItem.setLastChgDt(new Date(df.parse(time).getTime()));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFsysViewItem.setLastChgOrg(dto.getBody().getOrg().getCode());
		if(this.insertSelective(ocrmFsysViewItemMapper, ocrmFsysViewItem)!=1) {
			return null;
		}
		return ocrmFsysViewItem;
	}

	/**
	 * @方法名称: editViewItem
	 * @方法描述: 修改视图项信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public OcrmFsysViewItem editViewItem(OcrmFsysViewItem ocrmFsysViewItem) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new java.util.Date());
		try {
			ocrmFsysViewItem.setLastChgDt(new Date(df.parse(time).getTime()));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFsysViewItem.setLastChgOrg(dto.getBody().getOrg().getCode());
		if(this.updateSelective(ocrmFsysViewItemMapper, ocrmFsysViewItem)!=1) {
			return null;
		}
		return ocrmFsysViewItem;
	}

    /**
     * @方法名称: deleteViewItem
     * @方法描述: 删除视图项信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public Map<String, Object> deleteViewItem(String ids) {
        int n = 0;
        Map<String, Object> result = new HashMap<String, Object>();
        if (ids != null && !"".equals(ids.toString())) {
            String[] idStr = ids.toString().split(",");
            int undeletes = 0;
            int undeletes1 = 0;
            for (int i = 0; i < idStr.length; i++) {
                if (!"".equals(idStr[i])) {
                    int contrNum = this.ocrmFsysViewItemMapper.getContrById(idStr[i]);
                    int menuNum = this.ocrmFsysViewItemMapper.getMenuById(idStr[i]);
                    logger.info("contrNum==="+contrNum);
                    logger.info("menuNum==="+menuNum);
                    if (contrNum > 0) {
                        undeletes++;
                    } else if (menuNum > 0) {
                        undeletes1++;
                    } else {
                        n = n + ocrmFsysViewItemMapper.deleteByPrimaryKey(idStr[i]);
                    }
                }
            }
            if (undeletes == 0 && undeletes1 == 0) {
                result.put("message", "成功删除" + n + "条数据!");
            } else if(undeletes == 0 && undeletes1 != 0){
                result.put("message", "成功删除" + n + "条数据,有" + undeletes1 + "条数据由于关联视图菜单，无法删除!");
            }else if(undeletes != 0 && undeletes1 == 0){
                result.put("message", "成功删除" + n + "条数据,有" + undeletes+ "条数据由于关联控视图控制点，无法删除!");
            } else {
                result.put("message", "成功删除" + n + "条数据,有" + (undeletes + undeletes1) + "条数据由于关联视图菜单和控制点，无法删除!");
            }
        }
        return result;
    }

	/**
	 * @方法名称: checkName
	 * @方法描述: 保存数据前查询视图项名称是否已经存在
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String,Object>> checkName(String viewItemName,String id){
		Map<String,Object> params = new HashMap<>();
		params.put("viewItemName",viewItemName);
		params.put("id",id);
		return ocrmFsysViewItemMapper.checkName(params);
	}
}
