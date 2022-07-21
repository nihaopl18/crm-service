package cn.com.yusys.yusp.cm.sysKeyWord.service;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcMarketPosition;
import cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper.CmFRcMarketPositionMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcMarketPositionService
 * @类描述: 营销位管理
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2019-04-25 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcMarketPositionService extends CommonService{
	@Autowired
	private CmFRcMarketPositionMapper mapper;
	@Override
	protected CommonMapper<?> getMapper() {
		return mapper;
	}
	public List<Map<String,Object>>setPositionList(String channelId) {
		return mapper.setPositionList(channelId);
	}
	public ResultDto<Integer> setInsert(CmFRcMarketPosition record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		mapper.insertSelective(record);
		dto.setCode(0);
		dto.setMessage("新增成功");
		return dto;
	}
	public ResultDto<Integer> setUpdate(CmFRcMarketPosition record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		mapper.updateByPrimaryKeySelective(record);
		dto.setCode(0);
		dto.setMessage("更新成功");
		return dto;
	}
	public ResultDto<Integer> setDel(String id) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		mapper.deleteByIds(id);
		return dto;
	}
}
