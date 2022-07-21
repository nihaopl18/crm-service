	package cn.com.yusys.yusp.cm.processparam.service;

    import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesDisplay;
    import cn.com.yusys.yusp.cm.market.service.CimpCmNodesDisplayService;
    import cn.com.yusys.yusp.cm.processparam.domain.CmFRcNodeInputInfo;
    import cn.com.yusys.yusp.cm.processparam.domain.CmFRcNodeOutputInfo;
    import cn.com.yusys.yusp.cm.processparam.repository.mapper.CmFRcNodeInputMapper;
    import cn.com.yusys.yusp.commons.mapper.CommonMapper;
    import cn.com.yusys.yusp.commons.mapper.QueryModel;
    import cn.com.yusys.yusp.commons.service.CommonService;
    import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import java.text.ParseException;
    import java.util.List;
    import java.util.Map;
    import java.util.UUID;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcNodeInputService
 * @类描述: 组件输入参数接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-15
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcNodeInputService extends CommonService{
	@Autowired
	private CmFRcNodeInputMapper mapper;
	
	@Autowired
	private CimpCmNodesDisplayService cimpCmNodesDisplayService;
	
	@Autowired
	private CmFRcNodeOutputService cmFRcNodeOutputService;
	
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* 
	* @方法名称: getList
	* @方法描述: 查询节点下参数
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<List<Map<String,Object>>> getList(CmFRcNodeInputInfo record) {
		List<Map<String,Object>> hashmap = mapper.getList(record.getNodeId());
		ResultDto<List<Map<String,Object>>> dto = new ResultDto<List<Map<String,Object>>>(hashmap);
		dto.setCode(0);
		dto.setMessage("查询成功");
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: insertList
	* @方法描述: 新增查询组件输入参数表
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> insertList(CmFRcNodeInputInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String flag = record.getFlag();
		// 删除该节点下已有的数据
		mapper.delSameNodeData(record.getNodeId());
		// 删除该节点数据
		mapper.delSameNode(record.getNodeId());
		// 设置主键id
		record.setFormInId(getUUID());
		if("".equals(record.getFormId())) {
			// 表单id为空则设置表单id
			record.setFormId(getUUID());
			// 插入参数节点信息
			mapper.addNodes(record);
		}
		// 根据返回的集合类型设置参数输入表字段
		if("".equals(record.getFlag())) {
			// 保存组件类型为空
			dto.setCode(-1);
			dto.setMessage("参数识别失败");
		} else {
			// 根据返回的集合类型设置参数输入表字段
			if("apply".equals(flag)) {
				// 输入为关怀集合
				record.setFormInTable("CM_F_RC_CARE_ACTION");
				record.setFormInFiled("TEMP_TYPE,CHANNEL");
				record.setFormInName("序号,是否已发送,客户编号,客户名称,客户类型,手机号码，关怀类型，关怀营销话术");
				mapper.insertSelective(record);
				dto.setCode(0);
				dto.setMessage(record.getFormId());
			} else if("disk".equals(flag)) {
				// 输入为关注风险集合
				record.setFormInTable("CM_F_RC_RISK_ACTION");
				record.setFormInFiled("TEMP_TYPE,CHANNEL");
				record.setFormInName("序号,是否已发送,客户编号,客户名称,客户类型,手机号码，风险类型，关注风险话术");
				mapper.insertSelective(record);
				dto.setCode(0);
				dto.setMessage(record.getFormId());
			} else if("product".equals(flag)) {
				// 输入为产品集合
				record.setFormInTable("CM_F_RC_PROD_INFO");
				// record.setFormOutFiled("PRODUCT_ID,PROD_NAME,CATL_CODE,PROD_TYPE_ID,PROD_STATE,MONEY,RISK_LEVEL,PROD_DEPT,PROD_MAG,RATE,CHANNEL_NUM,MODEL_NUM,TARGET_NUM");
				// record.setFormOutName("产品编号,产品名称,产品类型,产品分类,是否在售,币种,风险等级,管理部门,产品经理,基准利率,可用营销渠道,营销渠道模板,可用成效指标");
				record.setFormInFiled("PRODUCT_ID");
				record.setFormInName("产品编号");
				mapper.insertSelective(record);
				dto.setCode(0);
				dto.setMessage(record.getFormId());
			} else if ("custprod".equals(flag)){
				// 输入为产品目标客户
				record.setFormInTable("CM_F_RC_PROD_INFO");
				record.setFormInFiled("PRODUCT_ID");
				record.setFormInName("产品编号");
				mapper.insertSelective(record);
				dto.setCode(0);
				dto.setMessage(record.getFormId());
			} else {
				// 输入未定义字段
				dto.setCode(-2);
				dto.setMessage("未定义输入参数类型");
			}
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: updateList
	* @方法描述: 更新查询组件输入参数表
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> updateList(CmFRcNodeInputInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String flag = record.getFormId();
		// 根据返回的集合类型设置参数输入表字段
		if("custom".equals(flag)) {
			// 输入为客户集合
			record.setFormInTable("CIMP_C_CG_BASEINFO");
			record.setFormInFiled("CUST_GROUP_ID,CUST_GROUP_NAME,CUST_NUM");
			record.setFormInName("客户群编号,客户群名称,客户数");
		} else if("apply".equals(flag)) {
			// 输入为关怀集合
			record.setFormInTable("CM_F_RC_CARE_ACTION");
			record.setFormInFiled("TEMP_TYPE,CHANNEL");
			record.setFormInName("序号,关怀类型,营销渠道模板");
		} else if("disk".equals(flag)) {
			// 输入为关注风险集合
			record.setFormInName("CM_F_RC_RISK_ACTION");
			record.setFormInFiled("TEMP_TYPE,CHANNEL");
			record.setFormInName("序号,风险类型,营销渠道模板");
		} else if("product".equals(flag)) {
			// 输入为产品集合
			record.setFormInName("CM_F_RC_PROD_INFO");
			record.setFormInFiled("PRODUCT_ID,PROD_NAME,CATL_CODE,PROD_TYPE_ID,PROD_STATE,MONEY,RISK_LEVEL,PROD_DEPT,PROD_MAG,RATE,CHANNEL,CHANNEL_TYPE");
			record.setFormInName("序号,产品编号,产品名称,产品类型,产品分类,是否在售,币种,风险等级,管理部门,产品经理,基准利率,可用营销渠道,营销渠道模板");
		}
		mapper.updateByPrimaryKeySelective(record);
		dto.setCode(0);
		dto.setMessage("修改成功");
		return dto;
	}
	/**
	* @throws  
	* @方法名称: deleteList
	* @方法描述: 删除查询组件输入参数表
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> deleteList(CmFRcNodeInputInfo record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String[] str = record.getFormInId().split(",");
		for (int i=0;i<str.length;i++) {
			record.setFormInId(str[i]);
			mapper.deleteList(record);
		}
		dto.setCode(0);
		dto.setMessage("删除成功");
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
	
	@Transactional
	public ResultDto<Integer> add(CmFRcNodeInputInfo record) throws ParseException {
		
		
		record.setFormInId(mapper.getSeq());
		record.setFormInTable("CIMP_C_CG_BASEINFO");
		record.setFormInFiled("CUST_GROUP_ID");
		record.setFormInName("客户群编号");
		CimpCmNodesDisplay cm = new CimpCmNodesDisplay();
		cm.setFormId(UUID.randomUUID().toString().toLowerCase().replace("-", ""));
		cm.setNodeId(record.getNodeId());
		CmFRcNodeOutputInfo cmout = new CmFRcNodeOutputInfo();
		cmout.setFormOutId(record.getFormInId());
		cmout.setFormId(cm.getFormId());
		cmout.setFormOutTable("CIMP_C_CG_BASEINFO");
		cmout.setFormOutFiled("CUST_GROUP_ID");
		cmout.setFormOutName("客户群编号");
		cmout.setFormOutVal(record.getFormInVal());
		record.setFormId(cm.getFormId());
		ResultDto<Integer> resultDto = new ResultDto<>();
		int num = insertSelective(getMapper(),record)+cmFRcNodeOutputService.add(cmout)+cimpCmNodesDisplayService.add(cm);
		if(num!=3) {
			resultDto.setCode(-1);
			resultDto.setMessage("保存失败");
			return resultDto;
		};
		resultDto.setCode(0);
		resultDto.setMessage("保存成功");
		return resultDto;
	}
	@Transactional
	public ResultDto<Integer> upd(CmFRcNodeInputInfo record) throws ParseException {
		ResultDto<Integer> resultDto = new ResultDto<>();
		CmFRcNodeOutputInfo cmout = new CmFRcNodeOutputInfo();
		cmout.setFormOutVal(record.getFormInVal());
		cmout.setNodeId(record.getNodeId());
		int num = cmFRcNodeOutputService.upd(cmout) + mapper.upd(record);
		
		if(num!=2) {
			resultDto.setCode(-1);
			resultDto.setMessage("保存失败");
			return resultDto;
		};
		resultDto.setCode(0);
		resultDto.setMessage("保存成功");
		return resultDto;
	}
	@Transactional
	public ResultDto<Integer> addmerge(CmFRcNodeInputInfo record) throws ParseException {
		record.setFormInId(mapper.getSeq());
		record.setFormInTable("CIMP_C_CG_BASEINFO");
		record.setFormInFiled("CUST_GROUP_ID");
		record.setFormInName("客户群编号");
		CimpCmNodesDisplay cm = new CimpCmNodesDisplay();
		cm.setFormId(UUID.randomUUID().toString().toLowerCase().replace("-", ""));
		cm.setNodeId(record.getNodeId());
		record.setFormId(cm.getFormId());
		ResultDto<Integer> resultDto = new ResultDto<>();
		int num = insertSelective(getMapper(),record)+cimpCmNodesDisplayService.add(cm);
		if(num!=2) {
			resultDto.setCode(-1);
			resultDto.setMessage("保存失败");
			return resultDto;
		};
		resultDto.setCode(0);
		resultDto.setMessage("保存成功");
		return resultDto;
	}
	@Transactional
	public ResultDto<Integer> updmerge(CmFRcNodeInputInfo record) throws ParseException {
		ResultDto<Integer> resultDto = new ResultDto<>();
		int num = mapper.upd(record);
		if(num!=1) {
			resultDto.setCode(-1);
			resultDto.setMessage("保存失败");
			return resultDto;
		};
		resultDto.setCode(0);
		resultDto.setMessage("保存成功");
		return resultDto;
	}
	public int checkBe(String formInId) {
		// TODO 自动生成的方法存根
		return mapper.checkBe(formInId);
	}
	public CmFRcNodeInputInfo checknodeid(QueryModel model) {
		// TODO 自动生成的方法存根

		return mapper.checknodeid(model);
	}
	public int insertadd(CmFRcNodeInputInfo in) {
		return insertSelective(getMapper(), in);
	}
}
