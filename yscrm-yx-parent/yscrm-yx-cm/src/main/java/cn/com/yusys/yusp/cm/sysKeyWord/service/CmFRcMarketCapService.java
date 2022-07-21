package cn.com.yusys.yusp.cm.sysKeyWord.service;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcMarketCapInfo;
import cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper.CmFRcMarketCapMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/** 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcMarketCapService
 * @类描述: 营销封顶接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-12-17 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcMarketCapService extends CommonService{
	@Autowired
	private CmFRcMarketCapMapper mapper;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* @方法名称: getList
	* @方法描述: 查询营销封顶表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<CmFRcMarketCapInfo> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcMarketCapInfo> list = mapper.getList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @方法名称: deleteList
	* @方法描述: 删除营销封顶表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> deleteList(CmFRcMarketCapInfo record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		mapper.deleteList(record);
		dto.setCode(0);
		dto.setMessage("删除成功");
		return dto;
	}
	/**
	* @方法名称: insertList
	* @方法描述: 新增营销封顶表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> insertList(CmFRcMarketCapInfo record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		mapper.insertSelective(record);
		dto.setCode(0);
		dto.setMessage("新增成功");
		return dto;
	}
	/**
	* @方法名称: updateList
	* @方法描述: 修改营销封顶表
	* @参数与返回说明: 
	* @算法描述:
	 */
	public ResultDto<Integer> updateList(CmFRcMarketCapInfo record) {	
		// 更新数据
		ResultDto<Integer> dto = new ResultDto<Integer>();
		mapper.updateByPrimaryKeySelective(record);
		dto.setCode(0);
		dto.setMessage("更新成功");
		return dto;
	}
	/**
	 * @方法名称: getUUID
	 * @方法描述: UUID生成器
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
//	private String getUUID() {
//		return UUID.randomUUID().toString().toLowerCase().replace("-", "");
//	}
}
