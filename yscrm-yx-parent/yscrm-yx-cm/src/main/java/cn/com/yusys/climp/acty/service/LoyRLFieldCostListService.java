package cn.com.yusys.climp.acty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.climp.acty.domain.LoyRLFieldCostList;
import cn.com.yusys.climp.acty.repository.mapper.LoyRLFieldCostListMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRLFieldCostListService
 * @类描述: #成本归属类
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2019-04-23 15:37:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyRLFieldCostListService extends CommonService {
	@Autowired
	LoyRLFieldCostListMapper mapper;
	@Override
	protected CommonMapper<?> getMapper() {
		return mapper;
	}
	/**
	 * 查询成本归属信息
	 **/
	public List<Map<String,Object>>costList(String tableId) {
		return mapper.costList(tableId);
	}
	/**
	 * 新增成本归属信息
	 **/
	public ResultDto<Integer>costInsert(Map<String,Object> map){
		ResultDto<Integer> dto = new ResultDto<Integer>();
		mapper.delByTableId(map.get("tableId").toString());
		LoyRLFieldCostList record = new LoyRLFieldCostList();
		record.setTableId(map.get("tableId").toString());
		if (map.get("costType").toString().equals("[]")) {
			dto.setCode(-1);
			dto.setMessage("请选择归属类别");
		} else {
			String costType = map.get("costType").toString();
			if(costType.indexOf("1") != -1) {
				// 机构归属类别
				record.setCostType("1");
				if(map.get("org").toString().equals("1")) {
					// 业务机构
					record.setCostField(map.get("costField").toString());
				} else if (map.get("org").toString().equals("2")) {
					//  TODO 返回交易归属机构
					record.setCostField("500");
				}
				mapper.insertSelective(record);
			}
			if(costType.indexOf("3") != -1) {
				// 产品归属类别
				record.setCostType("3");
				record.setCostField(map.get("costField").toString());
				mapper.insertSelective(record);
			}
			if(costType.indexOf("4") != -1) {
				// 法人归属类别
				record.setCostType("4");
				// TODO 返回交易法人
				record.setCostField("01");
				mapper.insertSelective(record);
			}
			dto.setCode(0);
			dto.setMessage("保存成功");
		}
		return dto;
	}
	/**
	 * 更新成本归属信息
	 **/
	public ResultDto<Integer>costUpdate(LoyRLFieldCostList record){
		ResultDto<Integer> dto = new ResultDto<Integer>();
		mapper.updateByPrimaryKeySelective(record);
		dto.setCode(0);
		dto.setMessage("更新成功");
		return dto;
	}
	/**
	 * 删除成本归属信息
	 **/
	public ResultDto<Integer>costDel(String id) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		mapper.deleteByIds(id);
		dto.setCode(0);
		dto.setMessage("删除成功");
		return dto;
	}
	/**
	 * 查询成本归属字段
	 **/
	public List<Map<String,Object>> costField(String tableId){
		return mapper.costField(tableId);
	}
	
	/**
	 * 查询成本归属列表
	 **/
	public List<Map<String,Object>> getCostList (String tableId) {
		return mapper.getCostList(tableId);
	}
}
