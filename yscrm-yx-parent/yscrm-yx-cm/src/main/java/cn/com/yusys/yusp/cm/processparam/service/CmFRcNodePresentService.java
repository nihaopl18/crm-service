package cn.com.yusys.yusp.cm.processparam.service;

import cn.com.yusys.yusp.cm.processparam.domain.CmFRcNodePresentInfo;
import cn.com.yusys.yusp.cm.processparam.repository.mapper.CmFRcNodePresentMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcNodePresentService
 * @类描述: 组件操作参数接口
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
public class CmFRcNodePresentService extends CommonService{
	@Autowired
	private CmFRcNodePresentMapper mapper;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* 
	* @方法名称: getList
	* @方法描述: 查询组件操作参数表
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public ResultDto<List<CmFRcNodePresentInfo>> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcNodePresentInfo> list = mapper.getList(model);
		PageHelper.clearPage();
		ResultDto<List<CmFRcNodePresentInfo>> dto = new ResultDto<List<CmFRcNodePresentInfo>>(list);
		dto.setCode(0);
		dto.setMessage("查询成功");
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: insertList
	* @方法描述: 新增组件操作参数表数据
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> insertList(CmFRcNodePresentInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String flag = record.getFlag();
		// 设置主键id
		record.setFormOperationId(getUUID());
		if("".equals(record.getFormId())) {
			// 表单id为空则设置表单id
			record.setFormId(getUUID());
			// 插入参数节点信息
			mapper.addNodes(record);
		}
		if(record.getFormId() == null) {
			// 表单id为空则设置表单id
			record.setFormId(getUUID());
			// 插入参数节点信息
			mapper.addNodes(record);
		}
		// 删除该节点下已有的数据
		mapper.delSameNodeData(record.getNodeId());
		// 根据返回的组件类型设置参数输入表字段
		if("".equals(record.getFlag())) {
			// 保存组件类型为空
			dto.setCode(-1);
			dto.setMessage("参数识别失败");
		} else {
			// 根据返回的集合类型设置参数输出表字段
			if("apply".equals(flag)) {
				// 输入为关怀集合
				record.setFormOperationTable("CM_F_RC_CARE_ACTION");
				record.setFormOperationFiled("TEMP_TYPE,CHANNEL");
				record.setFormOperationName("序号,是否已发送,客户编号,客户名称,客户类型,手机号码，关怀类型，关怀营销话术");
				mapper.insertSelective(record);
				dto.setCode(0);
				dto.setMessage(record.getFormId());
			} else if("disk".equals(flag)) {
				// 输入为关注风险集合
				record.setFormOperationTable("CM_F_RC_RISK_ACTION");
				record.setFormOperationFiled("TEMP_TYPE,CHANNEL");
				record.setFormOperationName("序号,是否已发送,客户编号,客户名称,客户类型,手机号码，风险类型，关注风险话术");
				mapper.insertSelective(record);
				dto.setCode(0);
				dto.setMessage(record.getFormId());
			} else if("product".equals(flag)) {
				// 输入为产品集合
				record.setFormOperationTable("CM_F_RC_PROD_INFO");
				// record.setFormOutFiled("PRODUCT_ID,PROD_NAME,CATL_CODE,PROD_TYPE_ID,PROD_STATE,MONEY,RISK_LEVEL,PROD_DEPT,PROD_MAG,RATE,CHANNEL_NUM,MODEL_NUM,TARGET_NUM");
				// record.setFormOutName("产品编号,产品名称,产品类型,产品分类,是否在售,币种,风险等级,管理部门,产品经理,基准利率,可用营销渠道,营销渠道模板,可用成效指标");
				record.setFormOperationFiled("PRODUCT_ID");
				record.setFormOperationName("产品编号");
				mapper.insertSelective(record);
				dto.setCode(0);
				dto.setMessage(record.getFormId());
			} else if ("custprod".equals(flag)) {
				// 输入为产品目标客户
				record.setFormOperationTable("CIMP_C_CG_BASEINFO");
				record.setFormOperationFiled("CUST_GROUP_ID");
				record.setFormOperationName("客户群编号");
				// record.setFormOperationVal("CUST_GROUP_ID = " + record.getFormOperationVal());
				mapper.insertSelective(record);
				dto.setCode(0);
				dto.setMessage(record.getFormId());
				
			} else if ("fission".equals(flag)) {
				// 输入为产品目标客户
				record.setFormOperationTable("");
				record.setFormOperationFiled("");
				record.setFormOperationName("");
				dto = new ResultDto<>(mapper.insertSelective(record));
				dto.setCode(0);
				dto.setMessage("操作成功");
				
			} else {
				// 输入未定义字段
				dto.setCode(-2);
				dto.setMessage("未定义操作参数类型");
			}
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: updateList
	* @方法描述: 更新组件操作参数表数据
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> updateList(CmFRcNodePresentInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String flag = record.getFormId();
		// 根据返回的组件类型设置参数输入表字段
		if("weixin".equals(flag)) {
			// 输入为渠道组件
			record.setFormOperationTable("CIMP_C_CG_BASEINFO");
			record.setFormOperationFiled("SENT_TYPE,START_TIME,END_TIME");
			record.setFormOperationName("发送方式,发送开始时间,发送截止时间");
		}
		mapper.updateByPrimaryKeySelective(record);
		dto.setCode(0);
		dto.setMessage("修改成功");
		return dto;
	}
	/**
	* @throws  
	* @方法名称: deleteList
	* @方法描述: 删除组件操作参数表数据
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> deleteList(CmFRcNodePresentInfo record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String[] str = record.getFormOperationId().split(",");
		for (int i=0;i<str.length;i++) {
			record.setFormOperationId(str[i]);
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
	public int checkBe(String formInId) {
		// TODO 自动生成的方法存根
		return mapper.checkBe(formInId);
	}
	public int add(CmFRcNodePresentInfo cm) {
		return insertSelective(getMapper(), cm);
		// TODO 自动生成的方法存根
		
	}
	
}
