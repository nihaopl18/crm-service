package cn.com.yusys.yusp.cm.market.service;

import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesDisplay;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesPresentation;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmMarkePlanMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmNodesDisplayMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmNodesPresentationMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.CustValGradeMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 展现表单接口
 * 
 * @author chenlin
 *
 */
@Service
public class PresentationFormService extends CommonService {

	@Autowired
	private CimpCmNodesDisplayMapper mapper;
	@Autowired
	private CimpCmNodesDisplayMapper disMapper;
	@Autowired
	private CimpCmNodesPresentationMapper preMapper;
	@Autowired
	private CimpCmMarkePlanMapper planMapper;
	@Autowired
	private CustValGradeMapper custvalMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		// TODO 自动生成的方法存根
		return this.mapper;
	}

	/**
	 * 保存表单操作
	 * 
	 * @param proList
	 * @param nodeId
	 * @return
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int savePre(List<CimpCmNodesPresentation> preList, String nodeId) {
		int count = 0;
		delPre(nodeId);
		CimpCmNodesDisplay dis = new CimpCmNodesDisplay();
		dis.setNodeId(nodeId);
		disMapper.insertSelective(dis);
		for (int i = 0; i < preList.size(); i++) {
			CimpCmNodesPresentation pre = preList.get(i);
			pre.setFormId(dis.getFormId());
			preMapper.insertSelective(pre);
			count++;
		}
		return count;
	}
	/**
	 * 删除操作
	 * @param nodeId
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int delPre(String nodeId) {
		int count = 0;
		CimpCmNodesDisplay dis = disMapper.getDisplay(nodeId);
		if (dis != null) {
			count = disMapper.deleteByPrimaryKey(dis.getFormId());
			List<CimpCmNodesPresentation> preList = preMapper.getPresentation(dis.getFormId());
			for (int i = 0; i < preList.size(); i++) {
				preMapper.delete(preList.get(i));
			}
		}
		return count;
	}

	/**
	 * 查询表单操作
	 * 
	 * @param nodeId
	 * @return
	 */
	public List<CimpCmNodesPresentation> getPre(String nodeId) {
		CimpCmNodesDisplay dis = disMapper.getDisplay(nodeId);
		List<CimpCmNodesPresentation> preList = new ArrayList<CimpCmNodesPresentation>();
		if(dis!=null) {
			preList = preMapper.getPresentation(dis.getFormId());
		}
		return preList;
	}
	/**
	 * 查詢活動
	 * @param flowId
	 * @return
	 */
	public CimpCmMarketplan getPlan(String flowId) {
		return planMapper.selectByPrimaryKey(flowId);
	}
	/**
	 * 查询流程中的营销方式节点
	 * @param flowId
	 * @return
	 */
	public List<Map<String,Object>> getMarketTypeByFlowId(String flowId) {
		Map<String,String> param=new HashMap<String,String>();
		param.put("flowId", flowId);
		return mapper.getMarketTypeByFlowId(param);
	}

	public List<Map<String,Object>> getMarketTypeAllByFlowId(String flowId) {
		Map<String,String> param=new HashMap<String,String>();
		param.put("flowId", flowId);
		return mapper.getMarketTypeAllByFlowId(param);
	}

	/**
	 * 
	* @方法名称: getChannelInfo
	* @方法描述:查询渠道信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<Map<String,Object>> getChannelInfo(){
		return custvalMapper.getChannelInfo();
		
	};
}
