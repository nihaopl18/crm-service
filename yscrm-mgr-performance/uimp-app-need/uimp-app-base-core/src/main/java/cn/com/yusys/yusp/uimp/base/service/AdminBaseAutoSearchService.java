package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.config.AutoSearch;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseAutoSearch;
import cn.com.yusys.yusp.uimp.base.repository.mapper.AdminBaseAutoSearchMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseAutoSearchService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-17 10:54:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class AdminBaseAutoSearchService extends CommonService {
	
    @Autowired
    private AdminBaseAutoSearchMapper adminBaseAutoSearchMapper;
    
    @Autowired
    private AutoSearch autoSearch;

    @Override
    protected CommonMapper<?> getMapper() {
        return adminBaseAutoSearchMapper;
    }
    
    /**
     * 查询
     *
     * @param model
     * @return
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = this.adminBaseAutoSearchMapper.querylist(model);
        PageHelper.clearPage();
        return list;
    }

    /**
     * 查询
     *
     * @param tableName
     * @param seacherId
     * @return
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryConflist(String tableName, String seacherId) {
        List<Map<String, Object>> list = null;
        if (tableName != null && !"".equals(tableName)) {
            list = this.adminBaseAutoSearchMapper.queryConfList(tableName, seacherId);
        } else {
            list = this.adminBaseAutoSearchMapper.queryConfListYpz(seacherId);
        }
        return list;
    }

    /**
     * 查询 表的名字
     *
     * @param model
     * @return
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryTablelist(QueryModel model) {
        List<Map<String, Object>> list = null;
        list = this.adminBaseAutoSearchMapper.queryTablelist(model);
        return list;
    }

    /**
     * 查询 数据字典
     *
     * @param model
     * @return
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryDataCodeList(QueryModel model) {
        List<Map<String, Object>> list = null;
        list = this.adminBaseAutoSearchMapper.queryDataCodeList(model);
        return list;
    }

    /**
     * 新增配置
     *
     * @param adminSmautoSearch
     * @return
     * @throws Exception
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<Object> saveorupdate(AdminBaseAutoSearch adminBaseAutoSearch) throws Exception {
        ResultDto<Object> resultDto = new ResultDto<>();
        try {
            if (adminBaseAutoSearch.getId() != null) { //修改
                this.adminBaseAutoSearchMapper.updateByPrimaryKeySelective(adminBaseAutoSearch);
                resultDto.setCode(0);
                resultDto.setMessage("保存成功");
            } else { //新增
            	adminBaseAutoSearch.setIfConf("0"); // 默认是否配置为否
                this.adminBaseAutoSearchMapper.insertSelective(adminBaseAutoSearch);
                resultDto.setCode(0);
                resultDto.setMessage("新增成功");
            }
        } catch (Exception e) {
            resultDto.setCode(500);
            resultDto.setMessage(e.getMessage());
        }
        return resultDto;
    }

	/**
	 * @方法名称: remove
	 * @方法描述: 删除
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@CacheEvict(value = "myAutoCache", key = "#ids")
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> remove(String ids) throws Exception {
		ResultDto<Object> resultDto = new ResultDto<>();
		try {
			String[] idArr = ids.split(",");
			for (int i = 0; i < idArr.length; i++) {
               this.getMapper().deleteByPrimaryKey(idArr[i]);
               this.adminBaseAutoSearchMapper.deleteAutoConf(idArr[i]);
            }
			resultDto.setCode(0);
			resultDto.setMessage("生成功能点成功");
		} catch (Exception e) {
			resultDto.setCode(500);
			resultDto.setMessage(e.getMessage());
		}
		return resultDto;
	}

	/**
	 * @方法名称: updateFun
	 * @方法描述: 生成功能点
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> updateFun(String id, String confUrl, String funcName, String funcDesc) throws Exception {
		ResultDto<Object> resultDto = new ResultDto<>();
		try {
			String funcUrl = autoSearch.getUrl() + confUrl + "=" + id;
			this.adminBaseAutoSearchMapper.updateFun(id, funcUrl);
			Map<String, String> map = new HashMap<>();
			map.put("funcName", funcName);
			map.put("funDesc", funcDesc);
			map.put("funcUrl", funcUrl);
			this.insertModFun(map);// 生成模块
			resultDto.setCode(0);
			resultDto.setMessage("生成功能点成功");
		} catch (Exception e) {
			resultDto.setCode(500);
			resultDto.setMessage(e.getMessage());
		}
		return resultDto;
	}

    /**
     * @方法名称: insertModFun
     * @方法描述: 生成模块
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> insertModFun(Map<String, String> map) throws Exception {
		ResultDto<Object> resultDto = new ResultDto<>();
		try {
			String uuid = this.adminBaseAutoSearchMapper.queryUuid();
			map.put("funId", uuid);
			map.put("modId", this.autoSearch.getModId());
			map.put("expUrl", this.autoSearch.getExpUrl());
			map.put("expWay", this.autoSearch.getExpWay());
			this.adminBaseAutoSearchMapper.insertModFun(map);
			resultDto.setCode(0);
			resultDto.setMessage("生成模块");
		} catch (Exception e) {
			resultDto.setCode(500);
			resultDto.setMessage(e.getMessage());
		}
		return resultDto;
	}

    /**
     * @方法名称: updateIfConf
     * @方法描述: 更新配置
     * @参数与返回说明:
     * @算法描述:
     */
	@CacheEvict(value = "myAutoCache", key = "#id")
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> updateIfConf(String id) throws Exception {
		ResultDto<Object> resultDto = new ResultDto<>();
		try {
			this.adminBaseAutoSearchMapper.updateIfConf(id);
			resultDto.setCode(0);
			resultDto.setMessage("更新配置成功");
		} catch (Exception e) {
			resultDto.setCode(500);
			resultDto.setMessage(e.getMessage());
		}
		return resultDto;
	}

}
