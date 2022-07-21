package cn.com.yusys.yusp.cm.market.service;

import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiFission;
import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiFissionImg;
import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiFissionReward;
import cn.com.yusys.yusp.cm.market.repository.mapper.YscimcFMkActiFissionImgMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.YscimcFMkActiFissionRewardMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.YscimcFmkActiFissionMapper;
import cn.com.yusys.yusp.cm.market.vo.YscimcFMkActiFissionVo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @项目名称: yscimc-cust-group模块
 * @类名称: YscimcFmkActiFissionService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-06-12 09:35:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class YscimcFmkActiFissionService extends CommonService {
    @Autowired
    private YscimcFmkActiFissionMapper yscimcFmkActiFissionMapper;

	@Autowired
	private YscimcFMkActiFissionRewardMapper rewardMapper;

	@Autowired
	private YscimcFMkActiFissionImgMapper imgMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return yscimcFmkActiFissionMapper;
    }

	public List<Map<String, Object>> getListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		return yscimcFmkActiFissionMapper.getListByModel(model);
	}

	@Transactional(rollbackFor = Exception.class)
	public synchronized Integer save(YscimcFMkActiFissionVo vo) {

		YscimcFMkActiFission entity = new YscimcFMkActiFission();
		BeanUtils.copyProperties(vo,entity);

		String id = yscimcFmkActiFissionMapper.hasId(entity.getNodeId());
		boolean ifAdd = StringUtils.isBlank(id);
		if (ifAdd){
			entity.setId(UUID.randomUUID().toString().replace("-",""));
		}else {
			entity.setId(id);
			rewardMapper.deleteByFissionId(vo.getId());
			imgMapper.deleteByFissionId(vo.getId());
		}

		List<YscimcFMkActiFissionReward> rewards = vo.getRewards();

		List<YscimcFMkActiFissionImg> images = vo.getImages();

		if (null != rewards && rewards.size() != 0){
			rewards.forEach(reward -> {
				reward.setId(UUID.randomUUID().toString().replace("-",""));
				reward.setFissionId(entity.getId());rewardMapper.insertSelective(reward);
			});
		}

		if (null != images && images.size() > 0){
			images.forEach(img -> {

				img.setFissionId(entity.getId());
				imgMapper.insertSelective(img);
			});
		}
		entity.setActHtml("/fission?tempId="+entity.getNodeId());
		if (ifAdd){
			return yscimcFmkActiFissionMapper.insertSelective(entity);
		}else {
			return this.yscimcFmkActiFissionMapper.updateByPrimaryKeySelective(entity);
		}

	}

	public YscimcFMkActiFissionVo getInfoByAssemble(String nodeId) {
		YscimcFMkActiFission fission = yscimcFmkActiFissionMapper.getListById(nodeId);
		if (null == fission){
			return null;
		}
		YscimcFMkActiFissionVo vo = new YscimcFMkActiFissionVo();
		BeanUtils.copyProperties(fission,vo);
		vo.setRewards(rewardMapper.getListByFissionId(fission.getId()));
		vo.setImages(imgMapper.getListByFissionId(fission.getId()));
		return vo;
	}

	public List<YscimcFMkActiFission> getInfoByIds(List<String> fissionIds) {
		return yscimcFmkActiFissionMapper.getInfoByIds(fissionIds);
	}


//	public int add(Map<String, Object> record) {
//		// TODO 自动生成的方法存根
//		int num = 0;
//		String nodeId = (String) record.get("nodeId");
//		yscimcFmkActiFissionMapper.delByNodeId(nodeId);
//		String fissionMode = (String) record.get("fissionMode");
//		JSONArray attr =JSONArray.fromObject(record.get("frequency"));
//
//		List<YscimcFmkActiFission> list = (List<YscimcFmkActiFission>) JSONArray.toCollection(attr, YscimcFmkActiFission.class);
//		for (int i = 0; i < list.size(); i++) {
//			YscimcFmkActiFission yscimcFmkActiFission = list.get(i);
//			yscimcFmkActiFission.setId(UUID.randomUUID().toString().replaceAll("-", ""));
//			yscimcFmkActiFission.setNodeId(nodeId);
//			yscimcFmkActiFission.setFissionMode(fissionMode);
//			num += insertSelective(getMapper(), yscimcFmkActiFission);
//		}
//		return num;
//	}

}
