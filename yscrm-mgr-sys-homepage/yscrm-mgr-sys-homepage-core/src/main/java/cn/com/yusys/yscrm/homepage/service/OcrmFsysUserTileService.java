package cn.com.yusys.yscrm.homepage.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.security.UaaRedisTokenStore;
import cn.com.yusys.yscrm.homepage.domain.OcrmFsysUserTile;
import cn.com.yusys.yscrm.homepage.repository.mapper.OcrmFsysUserTileMapper;
/**
 * @项目名称: yscrm-mgr-sys-homepage-core模块
 * @类名称: OcrmFsysUserTileService
 * @类描述: 首页定制化服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-17 11:35:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFsysUserTileService extends CommonService {
    @Autowired
    private OcrmFsysUserTileMapper ocrmFsysUserTileMapper;
    @Resource
	private UaaRedisTokenStore uaaTokenStore;
	@Autowired
	private RedisTemplate<String, Object> temp;
    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFsysUserTileMapper;
    }
    
    @Transactional(readOnly = true)
    public List<Map<Object, String>> getGraphList(QueryModel model) {
		return ocrmFsysUserTileMapper.getGraphList(model);
	}
    @Transactional(readOnly = true)
	public List<Map<Object, String>> getStyleList() {
		// TODO 自动生成的方法存根
		return ocrmFsysUserTileMapper.getStyleList();
	}
    
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int updateStyle(List<OcrmFsysUserTile> ocrmFsysUserTiles) {
		ocrmFsysUserTileMapper.delByUserId(ocrmFsysUserTiles.get(0).getUserId());
		int num = 0;
		for (int i = 0; i < ocrmFsysUserTiles.size(); i++) {
			OcrmFsysUserTile ocrmFsysUserTile = ocrmFsysUserTiles.get(i);
			ocrmFsysUserTile.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			num += insertSelective(getMapper(),ocrmFsysUserTile);
		}
		return num;
		// TODO 自动生成的方法存根
	}
	
	@Transactional(readOnly = true)
	public List<Map<Object, String>> getListBySql(QueryModel model) {
		// TODO 自动生成的方法存根
		String sql = (String) model.getCondition().get("sql");
		return ocrmFsysUserTileMapper.getListBySql(sql);
	}
	/**
	* @方法名称: onlineUserList
	* @方法描述: 在线用户监控
	* @参数与返回说明: 
	* @算法描述: 
	*/
	public List<Map<String, Object>> onlineUserList(QueryModel model) {
		// 在线用户监控
		// RedisTokenStore token = new RedisTokenStore(temp.getConnectionFactory());
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// Map<String, Object> map = new HashMap<String, Object>();
		StringRedisSerializer serializer = new StringRedisSerializer();
		temp.setKeySerializer(serializer);
		temp.setValueSerializer(serializer);
		Set<String> keys = temp.keys("access:*");
		List<String> ids = new ArrayList<String>();
		for(String key:keys) {
			Map tokenMap;
			try {
				tokenMap = new ObjectMapper().readValue(JwtHelper.decode(key.substring(7)).getClaims(),Map.class);
				// map = ocrmFsysUserTileMapper.getUserData(tokenMap.get("user_name").toString());
				ids.add(tokenMap.get("user_name").toString());
//				if(map!=null) {
//					list.add(map);
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// list去重
//		for (int i = 0; i <list.size()-1; i++) {
//            for (int j = list.size()-1; j >i; j--) {
//                if (list.get(j).equals(list.get(i))) {
//                	list.remove(j);
//                }
//            }
//        }
		list = ocrmFsysUserTileMapper.getAllUserData(ids);
		// 在线用户条件查询
		if((model.getCondition().get("userName") != null && !model.getCondition().get("userName").equals(""))
				|| (model.getCondition().get("orgName") != null && !model.getCondition().get("orgName").equals(""))) {
			if(list.contains(ocrmFsysUserTileMapper.getUserModel(model))) {
				// 查询后返回用户数据
				list.get(list.indexOf(ocrmFsysUserTileMapper.getUserModel(model)));
				List<Map<String,Object>> dislist = new ArrayList<Map<String, Object>>();
				dislist.add(list.get(list.indexOf(ocrmFsysUserTileMapper.getUserModel(model))));
				return dislist;
			} else {
				// 查询后未返回用户数据
				list.clear();
				return list;
			}
		} else {
			return list;
		}
	}
}
