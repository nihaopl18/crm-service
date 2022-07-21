package cn.com.yusys.yusp.cm.sysKeyWord.service;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcSysKeyWord;
import cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper.CmFRcSysKeyWordMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcSysKeyWordService
 * @类描述: 渠道模型关键字配置接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-10-17 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcSysKeyWordService extends CommonService{
	@Autowired
	private CmFRcSysKeyWordMapper mapper;
	
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	 * 
	* @方法名称: getModelKeyWordList
	* @方法描述: 查询渠道模型关键字
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<CmFRcSysKeyWord> getModelKeyWordList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcSysKeyWord> list = mapper.getModelKeyWordList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	 * 
	* @方法名称: insertModelKeyWordList
	* @方法描述: 插入渠道模型关键字
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> insertModelKeyWordList(CmFRcSysKeyWord record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置id
		record.setId(getUUID());
		if(mapper.getSameName(record) == 0) {
			// 没有重复别名
			mapper.insertSelective(record);
			dto.setCode(0);
			dto.setMessage("新增成功");
		} else {
			dto.setCode(-1);
			dto.setMessage("关键字别名重复");
		}
		return dto;
	}
	/**
	 * 
	* @方法名称: updateModelKeyWordList
	* @方法描述: 更新渠道模型关键字
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> updateModelKeyWordList(CmFRcSysKeyWord record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		if(mapper.getSameName(record) == 0) {
			// 没有重复别名
			mapper.updateByPrimaryKey(record);
			dto.setCode(0);
			dto.setMessage("新增成功");
		} else {
			dto.setCode(-1);
			dto.setMessage("关键字别名重复");
		}
		return dto;
	}
	/**
	 * 
	* @方法名称: deleteModelKeyWordList
	* @方法描述: 删除渠道模型关键字
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> deleteModelKeyWordList(CmFRcSysKeyWord record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String[] str = record.getId().split(",");
		for(int i=0;i<str.length;i++) {
			mapper.deleteModelKeyWordList(str[i]);
		}
		dto.setCode(0);
		dto.setMessage("删除成功");
		return dto;
	}
	/**
	 * 
	* @方法名称: getSameAliasName
	* @方法描述: 渠道模型关键字别名重复验证
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<Map<String, Object>> getSameAliasName() {
		return mapper.getSameAliasName();
	}
	/**
	 * 
	* @方法名称: getTabEName
	* @方法描述: 渠道模型关键字返回表英文名
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<Map<String, Object>> getTabEName() {
		return mapper.getTabEName();
	}
	/**
	 * 
	* @方法名称: getTabCName
	* @方法描述: 渠道模型关键字返回表中文名
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<Map<String, Object>> getTabCName() {
		return mapper.getTabCName();
	}
	/**
	 * 
	* @方法名称: getField
	* @方法描述: 渠道模型关键字返回表字段名
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<Map<String, Object>> getField(Map<String, Object> map) {
		return mapper.getField(map);
	}
	/**
	    * @方法名称: getUUID
	    * @方法描述: UUID生成器
	    * @参数与返回说明: 
	    * @算法描述: 
	    */
	private String getUUID() {
		return UUID.randomUUID().toString().toLowerCase().replace("-", "");
	}

	public List<Map<String, Object>> getmainField(Map<String, Object> map) {
		return mapper.getmainField(map);
	}
}
