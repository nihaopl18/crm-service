package cn.com.yusys.climp.acty.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.climp.acty.domain.LoyRlTableType;
import cn.com.yusys.climp.acty.service.LoyRlTableTypeService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlTableTypeResource
 * @类描述: 表类别资源类
 * @功能描述:
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:08:57
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/tabletype")
public class LoyRlTableTypeResource extends CommonResource<LoyRlTableType, String> {
	@Autowired
	private LoyRlTableTypeService loyRlTableTypeService;

	@Override
	protected CommonService getCommonService() {
		return loyRlTableTypeService;
	}

	/**
	 * 
	 * @方法名称: getTableType
	 * @方法描述: 查询表类别
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/list")
	public ResultDto<List<LoyRlTableType>> getTableType(QueryModel queryModel) {
		List<LoyRlTableType> list = loyRlTableTypeService.getTableType(queryModel);
		return new ResultDto<List<LoyRlTableType>>(list);
	}

	/**
	 * 表类型刪除
	 * 
	 * @param ids
	 * @return
	 */
	@PostMapping("/deletebatch")
	public ResultDto<Map<String, Object>> deleteBatch(@RequestBody Map<?, ?> map) {
		String[] idStr = map.get("typeId").toString().split(",");
		String orgCode = map.get("orgCode").toString();
		ResultDto<Map<String, Object>> reuslt = new ResultDto<Map<String, Object>>();
		try {
			int count = 0;
			for (int i = 0; i < idStr.length; i++) {
				List<LoyRlActivity> data = loyRlTableTypeService.getRuleByType(idStr[i]);
				count+=data.size();
			}
			if (count > 0) {
				reuslt.setCode(200001);
				reuslt.setMessage("该类型下的表已被积分活动使用不能删除！");
			} else {
				loyRlTableTypeService.deleteBatch(idStr, orgCode);
				reuslt.setCode(0);
				reuslt.setMessage("表类型删除成功！");
			}
		} catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
}
