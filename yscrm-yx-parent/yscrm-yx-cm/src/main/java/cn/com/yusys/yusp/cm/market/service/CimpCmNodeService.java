package cn.com.yusys.yusp.cm.market.service;

import cn.com.yusys.yusp.cm.market.domain.*;
import cn.com.yusys.yusp.cm.market.repository.mapper.*;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 流程模板——节点信息服务类
 * @author chenlin
 *
 */
@Service
public class CimpCmNodeService  extends CommonService{
	//节点信息接口
	@Autowired
	private CimpCmNodeMapper nodeMapper;
	//连线信息接口
	@Autowired
	private CimpCmConnMapper connMapper;
	//任务信息接口
	@Autowired
	private DmpTaskInfoMapper taskInfoMapper;
	//任务节点信息接口
	@Autowired
	private DmpTaskNodeMapper taskNodeMapper;
	//组件信息接口
	@Autowired
	private CimpCmAssemblyMapper assemMapper;
	//节点展现表单接口
	@Autowired
	private CimpCmNodesDisplayMapper displayMapper;
	//节点信息节点输入接口
	@Autowired
	private CimpCmNodesDisplayInputMapper disInMapper;
	//节点信息节点输出接口
	@Autowired
	private CimpCmNodesDisplayOutputMapper disOutMapper;

	public List<CimpCmNodeinfo> getNodeByTempId(String tempId) {
		return this.nodeMapper.getNodeByTempId(tempId);
	}


	@Override
	protected CommonMapper<?> getMapper() {
		return this.nodeMapper;
	}
	/**获取节点信息**/
	public List<CimpCmNodeinfo> getNodeList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CimpCmNodeinfo> list = nodeMapper.getNodeList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	 * 保存流程信息
	 * @param nodeList
	 * @param connList
	 * @return
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int saveFlow(List<CimpCmNodeinfo> nodeList,List<CimpCmConninfo> connList){
		int count = 0;
		/**
		 * 保存节点信息
		 */
		if(nodeList.size()>0) {
			List<CimpCmNodeinfo> node = nodeMapper.getNodeByTempId(nodeList.get(0).getTempId());
			for(int n=0;n<node.size();n++) {
				nodeMapper.delete(node.get(n));
			}
			for(int i =0;i< nodeList.size(); i++) {
				nodeMapper.insertSelective(nodeList.get(i));
				count++;
			}
		}
		/**
		 * 保存连线信息
		 */
		if(connList.size()>0) {
			List<CimpCmConninfo> conn = connMapper.getConnByTempId(connList.get(0).getTempId());
			for(int c=0;c<conn.size();c++) {
				connMapper.delete(conn.get(c));
			}
			for(int j=0;j<connList.size();j++) {
				connMapper.insertSelective(connList.get(j));
				count++;
			}
		}
		if(nodeList.size()>0) {
			String tempId = nodeList.get(0).getTempId();
			// 事件营销不生成清单任务
//			if(!taskInfoMapper.getActivityType(tempId).equals("02")) {
//				// 删除之前生成的任务
//				taskInfoMapper.delTask(Long.parseLong(tempId));
//				taskNodeMapper.delNodes(Long.parseLong(tempId));
//				// 流程生成任务
//				taskInfoMapper.taskInsert(tempId);
//				// 流程生成任务节点
//				CimpCmNodeinfo cimpCmNodeinfo = new CimpCmNodeinfo();
//				cimpCmNodeinfo.setTempId(tempId);
//				cimpCmNodeinfo.setNodeName("开始");
//				try {
//					// 递归存储节点信息
//					List<Map<String,Object>> nodes = taskNodeMapper.getSonNode(cimpCmNodeinfo);
//					for (int k=0;k<nodes.toArray().length;k++) {
//						if(nodes.get(k).get("targetTable") == null) {
//							insertTaskNode(nodes.get(k),1,k+1,tempId,"${YYYYMMDD}");
//						} else {
//							insertTaskNode(nodes.get(k),1,k+1,tempId,nodes.get(k).get("targetTable").toString());
//						}
//					}
//				} catch (Exception e) {
//					// 流程没有节点
//				}
//			}
			if(taskInfoMapper.getActivityType(tempId)!=null){
				if(!taskInfoMapper.getActivityType(tempId).equals("02")) {
					// 删除之前生成的任务
					taskInfoMapper.delTask(Long.parseLong(tempId));
					taskNodeMapper.delNodes(Long.parseLong(tempId));
					// 流程生成任务
					taskInfoMapper.taskInsert(tempId);
					// 流程生成任务节点
					CimpCmNodeinfo cimpCmNodeinfo = new CimpCmNodeinfo();
					cimpCmNodeinfo.setTempId(tempId);
					cimpCmNodeinfo.setNodeName("开始");
					try {
						// 递归存储节点信息
						List<Map<String, Object>> nodes = taskNodeMapper.getSonNode(cimpCmNodeinfo);
						for (int k = 0; k < nodes.toArray().length; k++) {
							if (nodes.get(k).get("targetTable") == null) {
								insertTaskNode(nodes.get(k), 1, k + 1, tempId, "${YYYYMMDD}");
							} else {
								insertTaskNode(nodes.get(k), 1, k + 1, tempId, nodes.get(k).get("targetTable").toString());
							}
						}
					} catch (Exception e) {
						// 流程没有节点
					}
				}
			}
			//用于营销案例库处流程设计保存组件
			if(taskInfoMapper.getActivityType(tempId)==null) {
				// 删除之前生成的任务
				taskInfoMapper.delTask(Long.parseLong(tempId));
				taskNodeMapper.delNodes(Long.parseLong(tempId));
				// 流程生成任务
				taskInfoMapper.taskInsert(tempId);
				// 流程生成任务节点
				CimpCmNodeinfo cimpCmNodeinfo = new CimpCmNodeinfo();
				cimpCmNodeinfo.setTempId(tempId);
				cimpCmNodeinfo.setNodeName("开始");
				try {
					// 递归存储节点信息
					List<Map<String,Object>> nodes = taskNodeMapper.getSonNode(cimpCmNodeinfo);
					for (int k=0;k<nodes.toArray().length;k++) {
						if(nodes.get(k).get("targetTable") == null) {
							insertTaskNode(nodes.get(k),1,k+1,tempId,"${YYYYMMDD}");
						} else {
							insertTaskNode(nodes.get(k),1,k+1,tempId,nodes.get(k).get("targetTable").toString());
						}
					}
				} catch (Exception e) {
					// 流程没有节点
				}
			}
		}
		return count;
	}
	/**
	 * 删除流程
	 * @param tempId
	 * @return
	 */
	public int delFlow(String tempId) {
		int count = 0;
		/**
		 * 删除节点信息
		 */
		List<CimpCmNodeinfo> node = nodeMapper.getNodeByTempId(tempId);
		for (int n = 0; n < node.size(); n++) {
			nodeMapper.delete(node.get(n));
		}
		/**
		 * 删除连线信息
		 */
		List<CimpCmConninfo> conn = connMapper.getConnByTempId(tempId);
		for (int c = 0; c < conn.size(); c++) {
			connMapper.delete(conn.get(c));
		}
		// 删除流程对应的任务
		taskInfoMapper.delTask(Long.parseLong(tempId));
		taskNodeMapper.delNodes(Long.parseLong(tempId));
		return count;
	}
	/**
	* @方法名称:delNode
	* @方法描述:删除节点
	* @参数与返回说明:
	* @算法描述:
	 */
	public int delNode(String nodeId) {
		int count = 0;
		if(nodeId!=null) {
			count = nodeMapper.deleteByPrimaryKey(nodeId);
			connMapper.delConn(nodeId);
		}
		return count;
	}
	/**
	 * 删除流程引擎所用表
	 * @param tempId
	 * @return
	 */
	public int delTask(String tempId) {
		int count = 0;
		List<DmpTaskInfo> info = taskInfoMapper.getTaskInfo(Long.parseLong(tempId));
		for (int n = 0; n < info.size(); n++) {
			taskInfoMapper.delete(info.get(n));
		}
		List<DmpTaskNode> node = taskNodeMapper.getTaskNode(Long.parseLong(tempId));
		for (int c = 0; c < node.size(); c++) {
			taskNodeMapper.delete(node.get(c));
		}
		return count;
	}
	/**
	 * 获取流程
	 * @param tempId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, List> getFlow(String tempId) {
		Map<String,List> flowMap = new HashMap<String,List>();
		List<Map<String,String>> nodemap = nodeMapper.getNodeInfo(tempId);
		List<CimpCmConninfo> connmap = connMapper.getConnByTempId(tempId);
		flowMap.put("nodes", nodemap);
		flowMap.put("conns", connmap);
		return flowMap;
	}
	/**
	 * 保存精准引擎所用表
	 * @param nodeId
	 * @param tempId
	 */
	public void saveTask(String nodeId,String tempId) {
		
		/**任务信息表*/
		DmpTaskInfo taskInfo = new DmpTaskInfo();
		taskInfo.setId(Long.parseLong(tempId));//流程id
		taskInfo.setTaskName("测试任务明");//流程名称
		taskInfo.setFrequncy("1D1");//运行频率
		taskInfo.setPriority(BigDecimal.valueOf(1));//优先级
		taskInfo.setBeginDate(BigDecimal.valueOf(20181010));//开始时间
		taskInfo.setEndDate(BigDecimal.valueOf(20201010));//结束时间
		taskInfo.setTaskComment("精准引擎");//备注
		taskInfoMapper.insertSelective(taskInfo);
		saveNext(nodeId, tempId, 0);				
	}
	
	public void saveNext(String sourceId,String tempId,int step) {
		List<CimpCmConninfo> conn = connMapper.getTargetId(sourceId);
		if(step == 0) {
			for(int i = 0;i<conn.size();i++) {
				saveNext(conn.get(i).getTargetId(), tempId, step+1);
			}
		}else {
			CimpCmNodeinfo nodeinfo = this.selectByPrimaryKey(sourceId);
			CimpCmAsseminfo  assem = nodeMapper.getAssem(nodeinfo.getAssemblyId());
			for(int i = 0;i<conn.size();i++) {
				DmpTaskNode taskNode = new DmpTaskNode();
				taskNode.setId(Long.parseLong(tempId));//流程id
				taskNode.setNodeStep(step);//步骤
				taskNode.setSerialNumber(i+1);//序号
				taskNode.setNodeType(assem.getDataType());//处理数据的类型
				List<CimpCmAssemInout> inout = nodeMapper.getAssemInout(nodeinfo.getAssemblyId());
				if(inout.size()>0) {
					for(int j =0;j<inout.size();j++) {
						if(inout.get(j).getInOrOut().equals("I")) {
							taskNode.setSourceTable(inout.get(j).getSourceTargetTab());//源表
							taskNode.setSourceColumns(inout.get(j).getSourceTargetField());//源表字段
						}else if(inout.get(j).getInOrOut().equals("O")) {
							taskNode.setTargetTable(inout.get(j).getSourceTargetTab());//目标表
							taskNode.setTargetColumns(inout.get(j).getSourceTargetField());//目标字段
							taskNode.setTargetExists("E");//目标表是否存在
							taskNode.setTargetTruncate("A");//目标表是否清空
						}
					}
				}else {
					taskNode.setSourceTable("ACIM_F_CI_CUSTOMER");//源表
					taskNode.setTargetTable("ACIM_F_CI_CUSTOMER_OUT");//目标表
					taskNode.setTargetExists("C");//目标表是否存在
					taskNode.setTargetTruncate("A");//目标表是否清空
				}
				taskNodeMapper.insertSelective(taskNode);
				saveNext(conn.get(i).getTargetId(), tempId, step+1);
			}
		}
	}
	 
	/**
	 * 保存输入输出表
	 * @param nodeId
	 */
	public void saveInAndOut(String nodeId,String assemId) {
		/**保存节点表单表**/
		CimpCmNodesDisplay display = new CimpCmNodesDisplay();
		display.setNodeId(nodeId);
		displayMapper.insertSelective(display);
		/**根据组件id查询组件输入输出**/
		QueryModel param = new QueryModel();
		param.getCondition().put("id", assemId);
		List<CimpCmAssemInout> inoutList = assemMapper.getInOutinfo(param);
		for(int i=0;i<inoutList.size();i++) {
			CimpCmAssemInout inout = inoutList.get(i);
			if(inout.getInOrOut().equals("I")&&inout.getParamType().equals("T")) {//处理表类型的输入（报文及文件的待实现）
				String field = inout.getSourceTargetField();
				String[] fields = field.split("@@");
				for(int j = 0;j<fields.length;j++) {
					String[] tabField = fields[j].split("\\.");
					/**保存节点表单输入表**/
					CimpCmNodesDisplayInput disIn = new CimpCmNodesDisplayInput();
					disIn.setFormId(display.getFormId());
					disIn.setFormInTable(tabField[0]);
					disIn.setFormInFiled(tabField[1]);
					disInMapper.insertSelective(disIn);
				}
			}else if(inout.getInOrOut().equals("O")&&inout.getParamType().equals("T")) {//处理表类型的输出（报文及文件的待实现）
				String field = inout.getSourceTargetField();
				String[] fields = field.split("@@");
				for(int j = 0;j<fields.length;j++) {
					String[] tabField = fields[j].split("\\.");
					/**保存节点表单输出表**/
					CimpCmNodesDisplayOutput disOut = new CimpCmNodesDisplayOutput();
					disOut.setFormId(display.getFormId());
					disOut.setFormOutTable(tabField[0]);
					disOut.setFormOutFiled(tabField[1]);
					disOutMapper.insertSelective(disOut);
				}
			}
		}
	}
	/**
	 * 删除输入输出表
	 * @param nodeId
	 */
	public void delInAndOut(String nodeId) {
		CimpCmNodesDisplay dis = displayMapper.getDisplay(nodeId);
		if(dis!=null) {
			displayMapper.deleteByPrimaryKey(dis.getFormId());
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
	// 递归存储任务节点
	public int insertTaskNode(Map<String, Object> node,int nodeStep,int serialNumber,String tempId,String sourceTable) {
		// 设置日期占位符
		String str = "${YYYYMMDD}";
		// 新增节点信息
		DmpTaskNode dmpTaskNode = new DmpTaskNode();
		dmpTaskNode.setId(Long.parseLong(tempId));
		dmpTaskNode.setNodeStep(nodeStep);
		dmpTaskNode.setSerialNumber(serialNumber);
		// 组件类别默认为过滤F
		if(node.get("dataType") == null) {
			dmpTaskNode.setNodeType("F");
		} else if(node.get("dataType").toString().equals("U")) {
			dmpTaskNode.setNodeType("F");
		} else {
			dmpTaskNode.setNodeType(node.get("dataType").toString());
		}
		// 设置源表
		if(node.get("sourceTable") == null) {
			if (node.get("classId").toString().equals("4") || 
					node.get("nodeName").toString().equals("清单整合")) {
				//	渠道组件
				dmpTaskNode.setSourceTable(sourceTable + " T");
			} else {
				dmpTaskNode.setSourceTable(sourceTable);
			}
		} else {
			// 分隔符转换
			if(sourceTable.equals("${YYYYMMDD}")) {
				// 根节点
				dmpTaskNode.setSourceTable(node.get("sourceTable").toString());
			} else {
				// 子节点
				if(node.get("nodeName").toString().equals("产品选择")) {
					dmpTaskNode.setSourceTable(sourceTable + " T");
				} else if (node.get("nodeName").toString().equals("合并") || 
						node.get("nodeName").toString().equals("分群")) {
					// 合并、分群
					dmpTaskNode.setSourceTable("CIMP_C_CG_BASEINFO");
				} else {
					dmpTaskNode.setSourceTable(sourceTable);
				}
			}
		}
		// 设置目标表
		if(node.get("targetTable") == null) {
			if (node.get("nodeName").toString().equals("清单整合")) {
				// 清单整合
				dmpTaskNode.setTargetTable("CM_F_RC_LIST_FILTER" + str);
			} else {
				dmpTaskNode.setTargetTable("TEMP" + tempId + "_" + str);
			}
		} else if(node.get("nodeName").toString().equals("合并") || 
				node.get("nodeName").toString().equals("分群")) {
			// 合并、分群
			dmpTaskNode.setTargetTable("CIMP_C_CG_BASEINFO" + str);
		} else {
			dmpTaskNode.setTargetTable(node.get("targetTable").toString()+str);
		}
		// 查目标表是否存在
		if(taskNodeMapper.getTarTable(dmpTaskNode.getTargetTable())>0) {
			dmpTaskNode.setTargetExists("E"); // 存在目标表
			dmpTaskNode.setTargetTruncate("T"); // 默认追加目标表
		} else {
			dmpTaskNode.setTargetExists("C"); // 默认创建目标表
			dmpTaskNode.setTargetTruncate("T"); // 默认追加目标表
		}
		// 设置源表字段
		if(node.get("sourceColumns") == null) {
			if(node.get("classId").toString().equals("4")) {
				// 渠道组件
				dmpTaskNode.setSourceColumns("T.*,'" + node.get("assemblyId") + "' AS CHANNEL" + node.get("assemblyId"));
			} else if (node.get("nodeName").toString().equals("清单整合")) {
				dmpTaskNode.setSourceColumns("T.*");
			} else {
				dmpTaskNode.setSourceColumns(""); // 组合节点类型默认为空
			}
		} else {
			if(node.get("nodeName").toString().equals("产品选择")) {
				dmpTaskNode.setSourceColumns("T.*," + node.get("targetColumns").toString());
			} else if(node.get("nodeName").toString().equals("合并") || 
					node.get("nodeName").toString().equals("分群")) { 
				dmpTaskNode.setSourceColumns("CUST_GROUP_ID");
			} else {
				dmpTaskNode.setSourceColumns((node.get("sourceColumns").toString()));
			}
		}
		// 设置目标表字段
		if(node.get("targetColumns") == null) {
			dmpTaskNode.setTargetColumns(""); // 组合节点类型默认为空
		} else {
			if(node.get("nodeName").toString().equals("产品选择")) {
				dmpTaskNode.setTargetColumns("");
			} else if(node.get("nodeName").toString().equals("合并") || 
					node.get("nodeName").toString().equals("分群")) {
				dmpTaskNode.setTargetColumns("CUST_GROUP_ID");
			} else {
				dmpTaskNode.setTargetColumns((node.get("targetColumns").toString()));
			}
		}
		// 设置任务条件
		if(node.get("taskConditionVal") != null) {
			// 流程节点操作表不为空时生成任务条件
			if(node.get("classId").toString().equals("4")) {
				// 渠道组件
				// dmpTaskNode.setTaskCondition("R.ASSEMBLY_NAME = '" + node.get("nodeName").toString() + "'");
				dmpTaskNode.setTaskCondition("");
			} else {
				// 设置源表字段
				if(node.get("sourceColumns") == null) {
					dmpTaskNode.setSourceColumns(node.get("taskConditionFiled").toString());
				} else {
					dmpTaskNode.setSourceColumns(dmpTaskNode.getSourceColumns() + "," + node.get("taskConditionFiled").toString());
				}
				dmpTaskNode.setTaskCondition(node.get("taskConditionFiled").toString() + " = " + "'" + node.get("taskConditionVal").toString() + "'");
			}
		} else {
			if(node.get("nodeName").toString().equals("合并") || 
					node.get("nodeName").toString().equals("分群")) {
				dmpTaskNode.setTaskCondition(dmpTaskNode.getSourceColumns() + "=" + "'" + node.get("outVal").toString() + "'");
			}
		}
		taskNodeMapper.insertNode(dmpTaskNode);
		// 查询下级节点
		CimpCmNodeinfo cimpCmNodeinfo = new CimpCmNodeinfo();
		cimpCmNodeinfo.setTempId(tempId);
		cimpCmNodeinfo.setNodeName(node.get("nodeName").toString());
		List<Map<String,Object>> nodes = taskNodeMapper.getSonNode(cimpCmNodeinfo);
		nodeStep++;
		if(!nodes.get(0).get("nodeName").toString().equals("结束")) {
			for(int i=0;i<nodes.toArray().length;i++) {
				try {
					insertTaskNode(nodes.get(i),nodeStep,i+1,tempId,dmpTaskNode.getTargetTable());
				} catch (Exception e) {
					// 节点重复录入
				}
			}
		} 
		return nodeStep;
	}
	// 流程生成任务时分隔符转换
	public String strexc (String str) {
		String[] array = str.split(",");
		if(array.length == 1) {
			// 无分隔符直接返回
			return str;
		} else {
			// 有分隔符进行转换
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<array.length;i++) {
				sb.append(array[i]);
				sb.append("@@");
			}
			return sb.substring(0, sb.length()-2).toString();	
		}
	}
}
