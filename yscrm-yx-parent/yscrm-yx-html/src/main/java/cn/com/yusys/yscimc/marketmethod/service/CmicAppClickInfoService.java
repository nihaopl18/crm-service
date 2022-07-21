package cn.com.yusys.yscimc.marketmethod.service;

import cn.com.yusys.yscimc.marketmethod.domain.CmicAppClickInfo;
import cn.com.yusys.yscimc.marketmethod.repository.mapper.CmicAppClickInfoMapper;
import cn.com.yusys.yusp.cm.cust.domain.AcimFCiCustomer;
import cn.com.yusys.yusp.cm.cust.repository.mapper.AcimFCiCustomerMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.YscimcFmkActiFissionMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @项目名称: yscimc-cust-group模块
 * @类名称: CmicAppClickInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-06-15 16:19:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CmicAppClickInfoService extends CommonService {
	private static final Logger log = getLogger(CmicAppClickInfoService.class);

    @Autowired
    private CmicAppClickInfoMapper cmicAppClickInfoMapper;
    @Autowired
    private AcimFCiCustomerMapper acimFCiCustomerMapper;
    @Autowired
    private YscimcFmkActiFissionMapper yscimcFmkActiFissionMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return cmicAppClickInfoMapper;
    }

//    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int clickinfo(String activityId, String recommenderId, String custId, String data) {
		AcimFCiCustomer acimFCiCustomer = acimFCiCustomerMapper.getCustByid(custId);
		if (acimFCiCustomer == null) {
			return -1;
		}
		CmicAppClickInfo clickInfo = new CmicAppClickInfo();
		clickInfo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		clickInfo.setActyId(activityId);
		clickInfo.setRecommenderId(recommenderId);
		clickInfo.setRecommender(acimFCiCustomer.getCustName());

		clickInfo.setCustId(custId);
		clickInfo.setData(data);
		
		cmicAppClickInfoMapper.insertSelective(clickInfo); // 新增一个点击信息

//		int num = getClickNumByRecommenderId(custId);
//		List<YscimcFmkActiFission> list = yscimcFmkActiFissionMapper.getListById(activityId); // 获取裂变对应的奖励
//		for (int i = 0; i < list.size(); i++) {
//			if (String.valueOf(num).equals(list.get(i).getfrequency())) {
//				if (list.get(i).getPrizeType().equals("1")) { // 匹配奖励类型
//					// 如果奖励是商品，获取商品ID创建商品订单
//					// 活动自己处理奖励
//					log.info("奖励名称：{}", list.get(i).getPrizeName());
//				}else if (list.get(i).getPrizeType().equals("2")){
//					// 如果奖励是积分，获取积分池信息，增加积分
//					log.info("奖励名称：{}", list.get(i).getPrizeName());
//				}
//			}
//
//		}
		return 1;
	}
	
    public int getClickNumByRecommenderId(String recommenderId) {
    	return cmicAppClickInfoMapper.getClickNumByRecommenderId(recommenderId);
    }

	public List<Map<String, Object>> getClickNum(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, Object>> list = cmicAppClickInfoMapper.getClickNum(model);
		PageHelper.clearPage();
		return list;
	}
    
    

}
