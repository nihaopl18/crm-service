package cn.com.yusys.yscrm.homepage.web.rest;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import net.sf.json.JSONArray;
import cn.com.yusys.yscrm.homepage.domain.OcrmFsysUserTile;
import cn.com.yusys.yscrm.homepage.service.OcrmFsysUserTileService;

/**
 * @项目名称: yscrm-mgr-sys-homepage-core模块
 * @类名称: OcrmFsysUserTileResource
 * @类描述: 首页个性化定制
 * @功能描述: 首页个性化图表设置
 * @创建人: hyx
 * @创建时间: 2019-01-17 11:35:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfsysusertile")
public class OcrmFsysUserTileResource extends CommonResource<OcrmFsysUserTile, String> {
    @Autowired
    private OcrmFsysUserTileService ocrmFsysUserTileService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFsysUserTileService;
    }
    /**
	* @方法名称: getGraphList
	* @方法描述: 首页获取图表信息
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/graphlist")
    public ResultDto<List<Map<Object, String>>> getGraphList(QueryModel model) {
    	return new ResultDto<>(ocrmFsysUserTileService.getGraphList(model));
	}
    
    // 首页获取页面样式信息
    @GetMapping("/stylelist")
    public ResultDto<List<Map<Object, String>>> getStyleList(QueryModel model) {
    	return new ResultDto<>(ocrmFsysUserTileService.getStyleList());
	}
    
    /**
	* @方法名称: updateStyle
	* @方法描述: 首页页面样式保存
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @PostMapping("/updatestyle")
    public ResultDto<Integer> updateStyle(@RequestBody  List<OcrmFsysUserTile> ocrmFsysUserTiles) {
    	return new ResultDto<>(ocrmFsysUserTileService.updateStyle(ocrmFsysUserTiles));
	}
    /**
	* @方法名称: getListBySql
	* @方法描述: 执行图表SQL
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @PostMapping("/sql")
    public ResultDto<List<Map<Object, String>>>  getListBySql(@RequestBody QueryModel model){
    	List<Map<Object, String>>  map = ocrmFsysUserTileService.getListBySql(model);
		return new ResultDto<>(map);
    	
    }
    /**
	* @方法名称: onlineUserList
	* @方法描述: 在线用户监控
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/onlineuserlist")
    public ResultDto<List<Map<String,Object>>> onlineUserList(QueryModel model){
    	List<Map<String,Object>> list = ocrmFsysUserTileService.onlineUserList(model);
    	return new ResultDto<>(list);
    }
}
