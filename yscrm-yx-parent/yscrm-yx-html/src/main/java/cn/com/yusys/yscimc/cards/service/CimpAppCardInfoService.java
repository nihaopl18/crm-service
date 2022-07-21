package cn.com.yusys.yscimc.cards.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscimc.cards.domain.CimpAppCardInfo;
import cn.com.yusys.yscimc.cards.repository.mapper.CimpAppCardInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimpAppCardInfoService
 * @类描述: #集卡卡片服务类
 * @功能描述: 集卡卡片操作逻辑
 * @创建人: yangxiao2
 * @创建时间: 2019-06-11 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CimpAppCardInfoService extends CommonService{
//	@Autowired
//	private CimpAppCardCustsMapper mapperCust;
	@Autowired
	private CimpAppCardInfoMapper mapperInfo;
	
	@Override
	protected CommonMapper<?> getMapper() {
		return mapperInfo;
	}
	
	/**
    * @方法名称: getActyCards
    * @方法描述: 查找全部活动相关卡片
    * @参数与返回说明: 
    * @算法描述: 
    */
	public List<Map<String,Object>>getActyCards(String actyId){
		return mapperInfo.getCards(actyId);
	}
	
	/**
    * @方法名称: insertCard
    * @方法描述: 卡片新增
    * @参数与返回说明: 
    * @算法描述: 
    */
	public ResultDto<Integer> insertCard(List<Map<String,Object>> list) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String parentId = "";
		String actyId = list.get(0).get("actyId").toString();
		// 删除上次保存的卡片
		mapperInfo.delByActyId(actyId);
		for(int i=0;i<list.size();i++) {
			CimpAppCardInfo record = new CimpAppCardInfo();
			record.setCardName(list.get(i).get("cardName").toString().split("\\.")[0]);
			record.setCardPic(list.get(i).get("cardPic").toString());
			record.setCardType(list.get(i).get("cardType").toString());
			record.setActyId(actyId);
			if (i==0) {
				// 默认第一张卡片是父卡片
				record.setId(getUUID());
				parentId = record.getId();
			} else {
				record.setId(getUUID());
				// 其他卡片定义父卡片
				record.setParentId(parentId);
			}
			mapperInfo.insertSelective(record);
		}
		dto.setCode(0);
		dto.setData(list.size());
		return dto;
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
}
