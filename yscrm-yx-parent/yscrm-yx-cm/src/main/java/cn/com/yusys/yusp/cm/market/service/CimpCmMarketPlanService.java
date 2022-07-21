package cn.com.yusys.yusp.cm.market.service;

import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.climp.acty.repository.mapper.LoyRlActivityMapper;
import cn.com.yusys.climp.acty.service.LoyRlActivityService;
import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.cm.indexplan.domain.YscimcIndexStatePo;
import cn.com.yusys.yusp.cm.market.constant.MarketPlanInfoEnum;
import cn.com.yusys.yusp.cm.market.domain.*;
import cn.com.yusys.yusp.cm.market.form.ActivityReqForm;
import cn.com.yusys.yusp.cm.market.form.MarketPlanReqForm;
import cn.com.yusys.yusp.cm.market.repository.mapper.*;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 营销活动策划——营销活动管理
 *
 * @author zhanghan3
 * 20181113
 */
@Service
public class CimpCmMarketPlanService  extends CommonService {

	
	@Autowired
	private CimpCmMarkePlanMapper markePlanMapper;
//	@Autowired
//	private DmpTaskInfoMapper taskInfoMapper;
	@Autowired
	private DmpTaskNodeMapper taskNodeMapper;
	@Autowired
	private LoyRlActivityMapper actyMapper;
	@Autowired
	private LoyRlActivityService actyService;
	@Autowired
	private CimpCmMarketPositCtMapper cimpCmMarketPositCtMapper;
	@Autowired
	private UserInfoService userInfo; 
	//节点信息接口
	@Autowired
	private CimpCmNodeMapper nodeMapper;
	@Autowired
	private EngProcessMapper engPro;
	//连线信息接口
	@Autowired
	private CimpCmConnMapper connMapper;

	@Autowired
	private MarketPlanMapper marketPlanMapper;
	private Set<String> orgCodeSet=new HashSet<>();

	@Override
	protected CommonMapper<?> getMapper() {
		return this.markePlanMapper;
	}

	
	private final static int SUCCESS = 1;
	private final static int FAILED = 0;
	
	//营销策划查询
	public List<CimpCmMarketplanVo> getMarketPlanList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CimpCmMarketplanVo> list = markePlanMapper.getMarketPlanList(model);
		PageHelper.clearPage();
		return list;
	}

	/**
	 * 
	* @throws ParseException 
	 * @方法名称: saveMktPositContent
	* @方法描述: 保存营销位的内容信息
	* @参数与返回说明: 
	* @算法描述:保存之前先删除以前的数据
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Map<String,Object> saveMktPositContent(List<CimpCmMarketPositCt> data) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Map<String,Object> reuslt=new HashMap<String,Object>();
		String loginCode = SecurityUtils.getCurrentUserLogin();
		if(!data.isEmpty()) {
			for(int i=0;i<data.size();i++) {
				CimpCmMarketPositCt pool=data.get(i);
				if(i==0) {//新增之前先删除以前的内容
					markePlanMapper.deleteMktPositContent(pool.getChannelNodeId());
				}
				pool.setCratDt(df.parse(df.format(new Date())));
				pool.setLastChgDt(df.parse(df.format(new Date())));
				pool.setCratUsr(loginCode);
				pool.setCratOrg(userInfo.getOrgCode());
				pool.setLastChgUsr(loginCode);
				pool.setLastChgOrg(userInfo.getOrgCode());
				cimpCmMarketPositCtMapper.insertSelective(pool);
			}
		}
		return reuslt;
	}

	//删除节点下的营销位内容信息
	public void deleteMktPositContent(String nodeId) {
		markePlanMapper.deleteMktPositContent(nodeId);
	}

	//营销策划新增
	@Transactional(rollbackFor = Exception.class)
	public CimpCmMarketplan add(CimpCmMarketplanVo cimpCmMarketplan) throws Exception {
		String loginCode = SecurityUtils.getCurrentUserLogin();
		cimpCmMarketplan.setLastChgDt(new Date());
	
		cimpCmMarketplan.setLastChgUsr(loginCode);
		cimpCmMarketplan.setLastChgOrg(userInfo.getOrgCode());
		cimpCmMarketplan.setActivitySts("01");
		cimpCmMarketplan.setWfAppStatus("997");
		CimpCmMarketplan entity = new CimpCmMarketplan();
		BeanUtils.copyProperties(cimpCmMarketplan,entity);
		if(entity.getTempId()==null||"".equals(entity.getTempId())) {
			entity.setTempId(markePlanMapper.getSeq());
			entity.setCratUsr(loginCode);
			entity.setCratOrg(userInfo.getOrgCode());
			entity.setCratDt(new Date());
			if(this.insertSelective(getMapper(), entity) != 1) {
				return null;
			}
			if(!StringUtils.isBlank(entity.getModelId())){
				copyToMarketCase(entity.getModelId(),entity.getTempId());
			}
		}else {
			markePlanMapper.updateByPrimaryKeySelective(entity);
		}

		return entity;
	}
	
	// 营销策划修改
	public CimpCmMarketplan update(CimpCmMarketplanVo cimpCmMarketplan) throws ParseException {
		String loginCode = SecurityUtils.getCurrentUserLogin();
		// 获取登录用户的机构号
		String orgCode = userInfo.getOrgCode();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		cimpCmMarketplan.setStartDate(cimpCmMarketplan.getStartDate());
		cimpCmMarketplan.setEndDate(cimpCmMarketplan.getEndDate());
		cimpCmMarketplan.setActivitySts("01");
		cimpCmMarketplan.setWfAppStatus("000");
		cimpCmMarketplan.setLastChgDt(df.parse(df.format(new Date())));
		cimpCmMarketplan.setLastChgOrg(orgCode);
		cimpCmMarketplan.setLastChgUsr(loginCode);
		CimpCmMarketplan entity = new CimpCmMarketplan();
		BeanUtils.copyProperties(cimpCmMarketplan,entity);
		markePlanMapper.updateByPrimaryKeySelective(entity);
		return entity;
	}

	/**
	 * 
	* @方法名称: updateSts
	* @方法描述: 修改流程状态
	* @参数与返回说明: CimpCmMarketplan
	* @算法描述:修改流程状态，如果是上架就需要把权益规则集写道路由表中，如果是下架就需要删除对应的路由信息
	 */
	public CimpCmMarketplan updateSts(CimpCmMarketplan cimpCmMarketplan) throws ParseException {
		String loginCode = SecurityUtils.getCurrentUserLogin();
		CimpCmMarketplan pool=this.markePlanMapper.selectByPrimaryKey(cimpCmMarketplan.getTempId());
		// 获取登录用户的机构号
		String orgCode = userInfo.getOrgCode();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		pool.setLastChgDt(df.parse(df.format(new Date())));
		pool.setLastChgOrg(orgCode);
		pool.setLastChgUsr(loginCode);
		// markePlanMapper.updateByPrimaryKeySelective(cimpCmMarketplan);
		Map<String,String> param = new HashMap<String,String>();
		param.put("flowId", pool.getTempId());
		param.put("sts", cimpCmMarketplan.getActivitySts());
		param.put("userId", pool.getLastChgUsr());
		param.put("date", df.format(new Date()));
		param.put("orgId", pool.getLastChgOrg());
		markePlanMapper.updateFlowStsById(param);
		if(cimpCmMarketplan.getActivitySts()!=null) {//上架或者下架
			//根据营销活动id查询积分权益活动
			List<LoyRlActivity> actyList = actyMapper.getActivityByTempId(cimpCmMarketplan.getTempId());
			//事件规则信息
			List<Map<String,Object>> event=engPro.getRuleByFlowId(cimpCmMarketplan.getTempId());
			if(!actyList.isEmpty()) {
				String activityId = "";
				for(int i= 0;i<actyList.size();i++) {
					activityId += actyList.get(i).getActivityId()+",";
				}
				if(cimpCmMarketplan.getActivitySts().equals("02")) {
					//上架——启动活动
					actyService.useIngFn(activityId.split(","), orgCode);
				}else if(cimpCmMarketplan.getActivitySts().equals("03")) {
					//下架——停用活动
					actyService.unUseIngFn(activityId.split(","), orgCode);
				}
			}
			if(!event.isEmpty()) {//判断是否以后事件规则信息
				Map<String, String> params=new HashMap<String, String>();
				params.put("activityId", cimpCmMarketplan.getTempId());
				if(cimpCmMarketplan.getActivitySts().equals("02")) {
					//上架——启动活动
					params.put("sts", "1");
				}else if(cimpCmMarketplan.getActivitySts().equals("03")) {
					//下架——停用活动
					params.put("sts", "0");
				}
				engPro.updateEventSts(params);
			}
			
		}
		return cimpCmMarketplan;
	}

	// 递归存储任务节点
	public int insertTaskNode(Map<String, Object> node,int nodeStep,int serialNumber,String tempId,String sourceTable) {
		// 设置日期占位符
		// SimpleDateFormat df = new SimpleDateFormat("${YYYYMMDD}");
		String str = "${YYYYMMDD}";
		// 新增节点信息
		DmpTaskNode dmpTaskNode = new DmpTaskNode();
		dmpTaskNode.setId(Long.parseLong(tempId));
		dmpTaskNode.setNodeStep(nodeStep);
		dmpTaskNode.setSerialNumber(serialNumber);
		// 组件类别默认为过滤F
		if(node.get("dataType") == null) {
			dmpTaskNode.setNodeType("F");
		} else {
			dmpTaskNode.setNodeType(node.get("dataType").toString());
		}
		// 设置源表
		if(node.get("sourceTable") == null) {
			if (node.get("classId").toString().equals("4")) {
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
				} else {
					dmpTaskNode.setSourceTable(sourceTable);
				}
			}
		}
		// 设置目标表
		if(node.get("targetTable") == null) {
			dmpTaskNode.setTargetTable("TEMP" + tempId + "_" + str);
			// 查目标表是否存在
			if(taskNodeMapper.getTarTable(dmpTaskNode.getTargetTable())>0) {
				dmpTaskNode.setTargetExists("E"); // 存在目标表
				dmpTaskNode.setTargetTruncate("T"); // 默认追加目标表
			} else {
				dmpTaskNode.setTargetExists("C"); // 默认创建目标表
				dmpTaskNode.setTargetTruncate("T"); // 默认追加目标表
			}
		} else {
			dmpTaskNode.setTargetTable(node.get("targetTable").toString()+str);
			// 查目标表是否存在
			if(taskNodeMapper.getTarTable(dmpTaskNode.getTargetTable())>0) {
				dmpTaskNode.setTargetExists("E"); // 存在目标表
				dmpTaskNode.setTargetTruncate("T"); // 默认追加目标表
			} else {
				dmpTaskNode.setTargetExists("C"); // 默认创建目标表
				dmpTaskNode.setTargetTruncate("T"); // 默认追加目标表
			}
		}
		// 设置源表字段
		if(node.get("sourceColumns") == null) {
			if(node.get("classId").toString().equals("4")) {
				// 渠道组件
				dmpTaskNode.setSourceColumns("T.*,'" + node.get("assemblyId") + "' AS CHANNEL" + node.get("assemblyId"));
			} else {
				dmpTaskNode.setSourceColumns(""); // 组合节点类型默认为空
			}
		} else {
			if(node.get("nodeName").toString().equals("产品选择")) {
				dmpTaskNode.setSourceColumns("T.*," + node.get("targetColumns").toString());
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

	/**
	 * 
	* @方法名称: deletePlan
	* @方法描述: 根据流程实例ID删除活动
	* @参数与返回说明: 
	* @算法描述: 删除活动和活动相关流程
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Integer deletePlan(String ids) {
		String[] arr = ids.split(",");
		// 删除活动流程
		for (int i = 0; i < arr.length; i++) {
			delActy(arr[i]);
		}
		return markePlanMapper.deletePlan(ids);
	}

	/**
	 * 
	* @方法名称: getfieldsInfo
	* @方法描述: 根据流程实例ID获取事件组件中的关联表格的field
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getfieldsInfo(String flowId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("activityId", flowId);
		List<Map<String, Object>> result= markePlanMapper.getFieldsInfo(paramMap);
		return result;
	}

	/**
	 * 
	* @throws ParseException 
	 * @方法名称: copyFlowInfo
	* @方法描述: 根据流程实例ID获取事件组件中的关联表格的field
	* @参数与返回说明: 
	* @算法描述:先复制基本信息，然后是节点信息和连接信息
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Map<String, String> copyFlowInfo(String flowId) throws ParseException {
		String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, String> result=new HashMap<String, String>();
		List<Map<String,String>> nodeId=new ArrayList<Map<String,String>>();
		//流程基本信息
		CimpCmMarketplan info=markePlanMapper.selectByPrimaryKey(flowId);
		//节点信息
		List<CimpCmNodeinfo> nodeinfo=nodeMapper.getNodeByTempId(flowId);
		//连线信息
		List<CimpCmConninfo> conninfo=connMapper.getConnByTempId(flowId);
		
		//保存流程基本信息
		info.setTempId(markePlanMapper.getSeq());
		info.setActivityName("[复制]"+info.getActivityName());
		info.setCratDt(df.parse(df.format(new Date())));
		info.setLastChgDt(df.parse(df.format(new Date())));
		info.setCratUsr(loginCode);
		info.setCratOrg(userInfo.getOrgCode());
		info.setLastChgUsr(loginCode);
		info.setLastChgOrg(userInfo.getOrgCode());
		info.setActivitySts("01");
		info.setWfAppStatus("000");
		markePlanMapper.insertSelective(info);
		
		//保存节点信息
		for(int i=0;i<nodeinfo.size();i++) {
			Map<String,String> newAndOld=new HashMap<String,String>();
			CimpCmNodeinfo node=nodeinfo.get(i);
			String uuid=getUuid();
			newAndOld.put("old", node.getNodeId());
			newAndOld.put("new", uuid);
			node.setNodeId(uuid);
			node.setTempId(info.getTempId());
			nodeMapper.insertSelective(node);
			nodeId.add(newAndOld);
		}
		
		//保存连接信息
		for(int s=0;s<conninfo.size();s++) {
			CimpCmConninfo conn=conninfo.get(s);
			conn.setTempId(info.getTempId());
			conn.setConnId(getUuid());
			for(int j=0;j<nodeId.size();j++) {
				Map<String,String> id=nodeId.get(j);
				if(conn.getSourceId().equals(id.get("old"))) {
					conn.setSourceId(id.get("new"));
				}else if(conn.getTargetId().equals(id.get("old"))) {
					conn.setTargetId(id.get("new"));
				}
			}
			connMapper.insertSelective(conn);
			
		}
		return result;
	}

	public Map<String, String> copyToMarketCase(String marketActionId,String marketCaseId) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		List<Map<String, String>> nodeId = new ArrayList<Map<String, String>>();
		//流程基本信息
		CimpCmMarketplan info = markePlanMapper.selectByPrimaryKey(marketActionId);
		//节点信息
		List<CimpCmNodeinfo> nodeinfo = nodeMapper.getNodeByTempId(marketActionId);
		//连线信息
		List<CimpCmConninfo> conninfo = connMapper.getConnByTempId(marketActionId);
		//保存节点信息
		for (int i = 0; i < nodeinfo.size(); i++) {
			Map<String, String> newAndOld = new HashMap<String, String>();
			CimpCmNodeinfo node = nodeinfo.get(i);
			String uuid = getUuid();
			newAndOld.put("old", node.getNodeId());
			newAndOld.put("new", uuid);
			node.setNodeId(uuid);
			node.setTempId(marketCaseId);
			nodeMapper.insertSelective(node);
			nodeId.add(newAndOld);
		}
		//保存连接信息
		for (int s = 0; s < conninfo.size(); s++) {
			CimpCmConninfo conn = conninfo.get(s);
			conn.setTempId(marketCaseId);
			conn.setConnId(getUuid());
			for (int j = 0; j < nodeId.size(); j++) {
				Map<String, String> id = nodeId.get(j);
				if (conn.getSourceId().equals(id.get("old"))) {
					conn.setSourceId(id.get("new"));
				} else if (conn.getTargetId().equals(id.get("old"))) {
					conn.setTargetId(id.get("new"));
				}
			}
			connMapper.insertSelective(conn);

		}
		return result;
	}

//    // 递归存储任务节点
//    public int insertTaskNode(Map<String, Object> node, int nodeStep, int serialNumber, String tempId, String sourceTable) {
//        // 设置日期占位符
//        // SimpleDateFormat df = new SimpleDateFormat("${YYYYMMDD}");
//        String str = "${YYYYMMDD}";
//        // 新增节点信息
//        DmpTaskNode dmpTaskNode = new DmpTaskNode();
//        dmpTaskNode.setId(Long.parseLong(tempId));
//        dmpTaskNode.setNodeStep(nodeStep);
//        dmpTaskNode.setSerialNumber(serialNumber);
//        // 组件类别默认为过滤F
//        if (node.get("dataType") == null) {
//            dmpTaskNode.setNodeType("F");
//        } else {
//            dmpTaskNode.setNodeType(node.get("dataType").toString());
//        }
//        // 设置源表
//        if (node.get("sourceTable") == null) {
//            if (node.get("classId").toString().equals("4")) {
//                //	渠道组件
//                dmpTaskNode.setSourceTable(sourceTable + " T");
//            } else {
//                dmpTaskNode.setSourceTable(sourceTable);
//            }
//        } else {
//            // 分隔符转换
//            if (sourceTable.equals("${YYYYMMDD}")) {
//                // 根节点
//                dmpTaskNode.setSourceTable(node.get("sourceTable").toString());
//            } else {
//                // 子节点
//                if (node.get("nodeName").toString().equals("产品选择")) {
//                    dmpTaskNode.setSourceTable(sourceTable + " T");
//                } else {
//                    dmpTaskNode.setSourceTable(sourceTable);
//                }
//            }
//        }
//        // 设置目标表
//        if (node.get("targetTable") == null) {
//            dmpTaskNode.setTargetTable("TEMP" + tempId + "_" + str);
//            // 查目标表是否存在
//            if (taskNodeMapper.getTarTable(dmpTaskNode.getTargetTable()) > 0) {
//                dmpTaskNode.setTargetExists("E"); // 存在目标表
//                dmpTaskNode.setTargetTruncate("T"); // 默认追加目标表
//            } else {
//                dmpTaskNode.setTargetExists("C"); // 默认创建目标表
//                dmpTaskNode.setTargetTruncate("T"); // 默认追加目标表
//            }
//        } else {
//            dmpTaskNode.setTargetTable(node.get("targetTable").toString() + str);
//            // 查目标表是否存在
//            if (taskNodeMapper.getTarTable(dmpTaskNode.getTargetTable()) > 0) {
//                dmpTaskNode.setTargetExists("E"); // 存在目标表
//                dmpTaskNode.setTargetTruncate("T"); // 默认追加目标表
//            } else {
//                dmpTaskNode.setTargetExists("C"); // 默认创建目标表
//                dmpTaskNode.setTargetTruncate("T"); // 默认追加目标表
//            }
//        }
//        // 设置源表字段
//        if (node.get("sourceColumns") == null) {
//            if (node.get("classId").toString().equals("4")) {
//                // 渠道组件
//                dmpTaskNode.setSourceColumns("T.*,'" + node.get("assemblyId") + "' AS CHANNEL" + node.get("assemblyId"));
//            } else {
//                dmpTaskNode.setSourceColumns(""); // 组合节点类型默认为空
//            }
//        } else {
//            if (node.get("nodeName").toString().equals("产品选择")) {
//                dmpTaskNode.setSourceColumns("T.*," + node.get("targetColumns").toString());
//            } else {
//                dmpTaskNode.setSourceColumns((node.get("sourceColumns").toString()));
//            }
//        }
//        // 设置目标表字段
//        if (node.get("targetColumns") == null) {
//            dmpTaskNode.setTargetColumns(""); // 组合节点类型默认为空
//        } else {
//            if (node.get("nodeName").toString().equals("产品选择")) {
//                dmpTaskNode.setTargetColumns("");
//            } else {
//                dmpTaskNode.setTargetColumns((node.get("targetColumns").toString()));
//            }
//        }
//        // 设置任务条件
//        if (node.get("taskConditionVal") != null) {
//            // 流程节点操作表不为空时生成任务条件
//            if (node.get("classId").toString().equals("4")) {
//                // 渠道组件
//                // dmpTaskNode.setTaskCondition("R.ASSEMBLY_NAME = '" + node.get("nodeName").toString() + "'");
//                dmpTaskNode.setTaskCondition("");
//            } else {
//                // 设置源表字段
//                if (node.get("sourceColumns") == null) {
//                    dmpTaskNode.setSourceColumns(node.get("taskConditionFiled").toString());
//                } else {
//                    dmpTaskNode.setSourceColumns(dmpTaskNode.getSourceColumns() + "," + node.get("taskConditionFiled").toString());
//                }
//                dmpTaskNode.setTaskCondition(node.get("taskConditionFiled").toString() + " = " + "'" + node.get("taskConditionVal").toString() + "'");
//            }
//        }
//        taskNodeMapper.insertNode(dmpTaskNode);
//        // 查询下级节点
//        CimpCmNodeinfo cimpCmNodeinfo = new CimpCmNodeinfo();
//        cimpCmNodeinfo.setTempId(tempId);
//        cimpCmNodeinfo.setNodeName(node.get("nodeName").toString());
//        List<Map<String, Object>> nodes = taskNodeMapper.getSonNode(cimpCmNodeinfo);
//        nodeStep++;
//        if (!nodes.get(0).get("nodeName").toString().equals("结束")) {
//            for (int i = 0; i < nodes.toArray().length; i++) {
//                try {
//                    insertTaskNode(nodes.get(i), nodeStep, i + 1, tempId, dmpTaskNode.getTargetTable());
//                } catch (Exception e) {
//                    // 节点重复录入
//                }
//            }
//        }
//        return nodeStep;
//    }


    /**
     * @方法名称: getmktPositContent
     * @方法描述: 获取节点营销位内容信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getmktPositContent(String nodeId) {
        List<Map<String, Object>> result = markePlanMapper.getmktPositContent(nodeId);
        return result;
    }

    /**
     * @方法名称: updateFlowStsById
     * @方法描述: 更新流程状态
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public void updateFlowStsById(String flowId, String sts) {
        Map<String, String> param = new HashMap<String, String>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        param.put("sts", sts);
        param.put("userId", userInfo.getLoginCode());
        param.put("date", df.format(new Date()));
        param.put("orgId", userInfo.getOrgCode());
        param.put("flowId", flowId);
        markePlanMapper.updateFlowStsById(param);
    }

    /**
     * @方法名称: updateWfStatus
     * @方法描述: 更新活动流程状态
     * @参数与返回说明: 活动id，审批状态
     * @算法描述:
     */
    public int updateWfStatus(String tempId, String wfstatus) {
        Map<String, Object> param = new HashMap<String, Object>();
        if ("".equals(tempId) || "".equals(wfstatus)) {
            // 输入为空更新失败
            return -1;
        } else {
            // 更新审批状态
            param.put("tempId", tempId);
            param.put("wfstatus", wfstatus);
            markePlanMapper.updateWfStatus(param);
            return 0;
        }
    }

    /**
     * @方法名称: getUuid
     * @方法描述: 获取UUID
     * @参数与返回说明:
     * @算法描述:
     */
    public String getUuid() {
        String uuid = UUID.randomUUID().toString(); //转化为String对象
        uuid = uuid.replace("-", "");
        return uuid;
    }

    // 通过tempId获取信息
    @Transactional(readOnly = true)
    public CimpCmMarketplan gettempById(String tempId) {

        return markePlanMapper.gettempById(tempId);
    }

    // 删除流程相关表数据
    public int delActy(String tempId) {
        Map<String, Object> map = markePlanMapper.getNodeIdFormId(tempId);
        if (map != null) {
            if (map.get("formId") != null) {
                String formId = map.get("formId").toString();
                String nodeId = map.get("nodeId").toString();
                markePlanMapper.delDisplay(formId);
                markePlanMapper.delPresentation(formId);
                markePlanMapper.delInfo(tempId);
                markePlanMapper.delCard(tempId);
                markePlanMapper.delMktPositByCtNodeId(nodeId);
                return SUCCESS;
            } else {
                return FAILED;
            }
        } else {
            return FAILED;
        }
    }


	/**
	 * 通过活动编号获取手机银行里营销方式信息
	 * @param actId
	 */
	public List<String> getMarketTypeIdByActId(String actId){
		return markePlanMapper.getMarketTypeIdByActId(actId);
	}

//	/**
//	 * 通过活动编号获取手机银行里营销位标识信息
//	 * @param actId
//	 */
//	public List<String> getMktPositCodeByActId(String actId){
//
//		return markePlanMapper.getMktPositCodeByActId(actId);
//	}

	public List<CimpCmMarketplan> getResultList(MarketPlanReqForm reqForm) {
		Example example = new Example(CimpCmMarketplan.class);
		Example.Criteria criteria = example.createCriteria();

//		List<String> status = new ArrayList<>();
//		status.add("997");
//		status.add("1");
//		criteria.andIn("wfAppStatus", status);
		List<String> sts = new ArrayList<>();
		sts.add("02");
		sts.add("03");
		sts.add("04");
		sts.add("05");
		criteria.andIn("activitySts", sts);
		Example.Criteria andCriteria = example.createCriteria();
		String keyword = reqForm.getKeyword();
		if (!StringUtils.isBlank(keyword)) {
			keyword = "%" + reqForm.getKeyword() + "%";
			andCriteria.orLike("tempId", keyword);
			andCriteria.orLike("activityName", keyword);
			if (MarketPlanInfoEnum.MARKET_PLAN_TYPE_EVENT.getName().contains(reqForm.getKeyword())) {
				andCriteria.orEqualTo("activityType", MarketPlanInfoEnum.MARKET_PLAN_TYPE_EVENT.getCode());
			} else if (MarketPlanInfoEnum.MARKET_PLAN_TYPE_INTERNET.getName().contains(reqForm.getKeyword())) {
				andCriteria.orEqualTo("activityType", MarketPlanInfoEnum.MARKET_PLAN_TYPE_INTERNET.getCode());
			} else if (MarketPlanInfoEnum.MARKET_PLAN_TYPE_LIST.getName().contains(reqForm.getKeyword())) {
				andCriteria.orEqualTo("activityType", MarketPlanInfoEnum.MARKET_PLAN_TYPE_LIST.getCode());
			}
		}

		example.and(andCriteria);
		List<CimpCmMarketplan> li = marketPlanMapper.selectByExample(example);
		return li;
	}
	public List<YscimcIndexStatePo> getIndexState(ActivityReqForm reqForm){
		//先查询出没有过期且执行完的活动
		MarketPlanReqForm marketPlanReqForm =new MarketPlanReqForm();
		List<CimpCmMarketplan> resultList = getResultList(marketPlanReqForm);
		List<String> activityIdList =new ArrayList<>();
		for (CimpCmMarketplan cimpCmMarketplan : resultList) {
			activityIdList.add(cimpCmMarketplan.getTempId());
		}
		PageHelper.startPage(reqForm.getPage(), reqForm.getSize());
		List<YscimcIndexStatePo> yscimcIndexStatePos = markePlanMapper.selectActivity(reqForm,activityIdList);
		PageHelper.clearPage();
		return yscimcIndexStatePos;
	}
    public void updateSts(String id, String sts) {
		if (StringUtils.isBlank(id)||StringUtils.isBlank(sts)){
			throw new RuntimeException("参数异常");
		}
		CimpCmMarketplan cimpCmMarketplan = new CimpCmMarketplan();
		cimpCmMarketplan.setTempId(id);
		cimpCmMarketplan.setActivitySts(sts);
        markePlanMapper.updateByPrimaryKeySelective(cimpCmMarketplan);

    }

	public List<CimpCmMarketplan> getMarketPlanListByOrgCode(String orgId,String keyWord) {
		//查询当前机构及其子机构orgId集合
		childOrg(orgId);
		orgCodeSet.add(orgId);
		//int size = orgCodeSet.size();
		ArrayList<String> orgCodeList = new ArrayList<>(orgCodeSet);
		List<CimpCmMarketplan> marketPlanListByOrgCode = markePlanMapper.getMarketPlanListByOrgCode(orgCodeList, keyWord);


		orgCodeSet.clear();
		return marketPlanListByOrgCode;
	}
	/**
	 * 查询子机构
	 * @param orgId
	 */
	public void childOrg(String orgId){
		List<String> orgIdList = markePlanMapper.childOrg(orgId);
		if (orgIdList!=null){
			orgCodeSet.addAll(orgIdList);
			for (String s : orgIdList) {
				childOrg(s);
			}
		}
	}
	public List<CimpCmMarketplan> getMarketPlanListByFuzzyQuery(String keyWord) {
		List<CimpCmMarketplan> list = markePlanMapper.getMarketPlanListByFuzzyQuery(keyWord);
		return list;
	}
	public CimpCmMarketplan getMarketPlanListByAccurateQuery(String activityId, String activityName) {

		return null;
	}


	public List<CimpCmMarketPositCt> getMarketPositCtByActId(String actId) {
		List<CimpCmMarketPositCt> list = cimpCmMarketPositCtMapper.getMarketPositCtByActId(actId);
		return list;
	}

    public Map getActBaseInfobyid(String tempId) {
		return markePlanMapper.getActBaseInfobyid(tempId);
	}

	public List<Map<String, Object>> getListByCondition(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = markePlanMapper.getListByCondition(model);
		PageHelper.clearPage();
		return list;
	}
}
