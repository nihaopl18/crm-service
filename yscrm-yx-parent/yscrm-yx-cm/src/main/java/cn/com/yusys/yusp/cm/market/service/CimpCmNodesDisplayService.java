package cn.com.yusys.yusp.cm.market.service;

import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesDisplay;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesDisplayInput;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesDisplayOutput;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmNodesDisplayInputMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmNodesDisplayMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmNodesDisplayOutputMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * 表单、节点关联
 * @author zhangxs4
 * 20181113
 */
@Service
public class CimpCmNodesDisplayService  extends CommonService{
	
	@Autowired
	private CimpCmNodesDisplayMapper cimpCmNodesDisplayMapper;
	@Autowired
	private CimpCmNodesDisplayInputMapper disInMapper;
	@Autowired
	private CimpCmNodesDisplayOutputMapper disOutMapper;
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO 自动生成的方法存根
		return this.cimpCmNodesDisplayMapper;
	}
	/**
	 * 保存表单节点关系表及保存输出表
	 * @param 
	 * @return
	 */
	public int saveDisplay(List<CimpCmNodesDisplay> t,List<CimpCmNodesDisplayOutput> record, List<CimpCmNodesDisplayInput> inparam) {
		int count = 0;
		//保存前先清空
		delInAndOut(t.get(0).getNodeId());
		CimpCmNodesDisplay display = new CimpCmNodesDisplay();
		display.setNodeId(t.get(0).getNodeId());
		cimpCmNodesDisplayMapper.insertSelective(display);//存表单节点信息表
		//存表单输入表，表单id，输出表，输出字段，输出值
			for(int i =0;i< inparam.size(); i++) {
				inparam.get(i).setFormId(display.getFormId());
				disInMapper.insertSelective(inparam.get(i));
				count++;
			}
		//存表单输出表，表单id，输出表，输出字段，输出值
			CimpCmNodesDisplayOutput disOut = new CimpCmNodesDisplayOutput();
			disOut.setFormId(display.getFormId());//与表单节点关系表对应的表单id
			disOut.setFormOutTable("CIMP_C_CUSTGROUP_CUST");//输出表
			disOut.setFormOutFiled(record.get(0).getFormOutFiled());//输出字段
			disOut.setFormOutVal(record.get(0).getFormOutVal());//客户群编号
			disOut.setFormOutName(record.get(0).getFormOutName());
			disOut.setCondition(record.get(0).getCondition());
			count=disOutMapper.insertSelective(disOut);
		return count;
	}
	public int add(CimpCmNodesDisplay cm) {
		return insertSelective(getMapper(),cm);
		// TODO 自动生成的方法存根
	}
	public List<Map<String, Object>> getTagno(String nodeId) {
		List<Map<String, Object>> list = disInMapper.getTagno(nodeId);
		return list;
	}
	
	/**
	 * 删除输入输出表
	 * @param nodeId
	 */
	public void delInAndOut(String nodeId) {
		CimpCmNodesDisplay dis = cimpCmNodesDisplayMapper.getDisplay(nodeId);
		if(dis!=null) {
			cimpCmNodesDisplayMapper.deleteByPrimaryKey(dis.getFormId());
			List<CimpCmNodesDisplayInput> disIn = disInMapper.getDisInput(dis.getFormId());
			for(int i=0;i<disIn.size();i++) {
				disInMapper.delete(disIn.get(i));
			}
			List<CimpCmNodesDisplayOutput> disOut = disOutMapper.getDisOutput(dis.getFormId());
			for(int j=0;j<disOut.size();j++) {
				disOutMapper.delete(disOut.get(j));
			}
		}
	}
	// 查询是否存在节点
	public String checkBe(String nodeId) {
		return cimpCmNodesDisplayMapper.checkBe(nodeId);
		
	};

}
