package cn.com.yusys.yusp.cm.productmanager.service;

import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProductManagerInfo;
import cn.com.yusys.yusp.cm.productmanager.repository.mapper.CmFRcProductManagerMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcProductManagerService
 * @类描述: 产品管理接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-08 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcProductManagerService extends CommonService{
	@Autowired
	private CmFRcProductManagerMapper mapper;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* 
	* @方法名称: getList
	* @方法描述: 查询产品表
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<CmFRcProductManagerInfo> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcProductManagerInfo> list = mapper.getList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @throws ParseException 
	* @方法名称: insertList
	* @方法描述: 新增产品
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> insertList(CmFRcProductManagerInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 新增成功
		if("0".equals(mapper.getSameId(record.getProductId())) && "0".equals(mapper.getSameName(record.getProdName()))) {
			// 设置创建人 
			record.setProdCreator(SecurityUtils.getCurrentUserLogin());
			// 设置创建时间 
			record.setCreateDate(df.parse(df.format(new Date())));
			// 设置产品生效、失效日期
			record.setProdStartDate(df.parse(df.format(record.getProdStartDate())));
			record.setProdEndDate(df.parse(df.format(record.getProdEndDate())));
			
			mapper.insertSelective(record);
			dto.setCode(0);
			dto.setMessage("新增成功");
		} else {
			// 新增失败 
			dto.setCode(-1);
			dto.setMessage("新增失败,产品标号或名称重复");
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: updateList
	* @方法描述: 更新产品
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> updateList(CmFRcProductManagerInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		if ("0".equals(mapper.getSameUpdateName(record))) {
			// 修改成功
			mapper.updateByPrimaryKeySelective(record);
			dto.setCode(0);
			dto.setMessage("修改成功");
		} else {
			dto.setCode(-1);
			dto.setMessage("产品名称重复");
		}
		return dto;
	}
	/**
	* @throws 
	* @方法名称: getProdById
	* @方法描述: 组件返回产品信息输入
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<CmFRcProductManagerInfo>getProdById(CmFRcProductManagerInfo record) {
		return mapper.getProdById(record);
	}
	/**
	* @throws 
	* @方法名称: getOutputProd
	* @方法描述: 组件返回产品信息输出
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getOutputProd (QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.getOutputProd(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @throws 
	* @方法名称: getProdCust
	* @方法描述: 产品目标客户
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>getProdCust(QueryModel model) {
		return mapper.getProdCust(model);
	}
	//通过多产品编号获取产品信息
	public List<CmFRcProductManagerInfo> getProByIds(QueryModel model) {
		String idsString = (String) model.getCondition().get("productIds");
		String[] ids = idsString.split(",");
		List<String> listids = Arrays.asList(ids);
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcProductManagerInfo> list = mapper.getProByIds(listids);
		PageHelper.clearPage();
		return list;
	}
	// 获取所有产品信息
	public List<CmFRcProductManagerInfo> getPro() {
		return mapper.getPro();
	}

	public List<CmFRcProductManagerInfo> selectByIdList(List<String> productIdList) {
		return mapper.selectByIdList(productIdList);
	}
}
