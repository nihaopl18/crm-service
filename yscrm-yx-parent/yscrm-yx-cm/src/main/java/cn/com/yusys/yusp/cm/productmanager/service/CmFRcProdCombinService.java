package cn.com.yusys.yusp.cm.productmanager.service;

import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProdCombinInfo;
import cn.com.yusys.yusp.cm.productmanager.repository.mapper.CmFRcProdCombinMapper;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcProdCombinService
 * @类描述: 组合产品管理接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-12 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcProdCombinService extends CommonService{
	@Autowired
	private CmFRcProdCombinMapper mapper;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* 
	* @方法名称: getList
	* @方法描述: 查询组合产品管理表
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public ResultDto<List<CmFRcProdCombinInfo>> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcProdCombinInfo> list = mapper.getList(model);
		PageHelper.clearPage();
		ResultDto<List<CmFRcProdCombinInfo>> dto = new ResultDto<List<CmFRcProdCombinInfo>>(list);
		dto.setCode(0);
		dto.setMessage("查询成功");
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: insertList
	* @方法描述: 新增组合子产品
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> insertList(CmFRcProdCombinInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置权重占比
		float weight = Float.parseFloat(record.getParentProdWeight().substring(0, record.getParentProdWeight().length()-1));
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		float total_weight;
		try {
			total_weight = mapper.getWeight(record);
		} catch (Exception e) {
			total_weight = 0;
		}
		// 新增成功
		if("0".equals(mapper.getSameId(record)) 
				&& total_weight + weight <= 100 
				&& weight > 0
				&& !record.getParentProdId().equals(record.getProductId())
				&& mapper.getProdCombin(record.getProductId()).equals("0")) {
			// 设置id
			record.setId(getUUID());;
			// 设置创建人 
			record.setCreatUser(SecurityUtils.getCurrentUserLogin());
			// 设置创建时间 
			record.setCreatDate(df.parse(df.format(new Date())));
			// 设置最近更新人
			record.setUpdataUser(record.getCreatUser());
			// 设置最近更新时间
			record.setUpdataDate(record.getCreatDate());
			
			mapper.insertSelective(record);
			// 设置可用配比
			float last_weight = 100 - (total_weight + weight);
			dto.setCode(0);
			dto.setMessage("新增成功,可用配比为" + last_weight + "%");
		} else {
			// 新增失败 
			if(!"0".equals(mapper.getSameId(record))) {
				dto.setCode(-1);
				dto.setMessage("子产品ID重复");
			} else if(total_weight + weight > 100) {
				dto.setCode(-2);
				dto.setMessage("子产品配比大于100%");
			} else if(!mapper.getProdCombin(record.getProductId()).equals("0")) {
				dto.setCode(-3);
				dto.setMessage("子产品不能为组合产品");
			} else if (weight <= 0) {
				dto.setCode(-2);
				dto.setMessage("子产品配比错误");
			} else {
				dto.setCode(-4);
				dto.setMessage("未知错误");
			}
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: updateList
	* @方法描述: 更新组合产品状态
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> updateList(CmFRcProdCombinInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置权重占比
		float weight = Float.parseFloat(record.getParentProdWeight().substring(0, record.getParentProdWeight().length()-1));
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if(!record.getParentProdId().equals("")
				&& mapper.getWeight(record) + weight <= 100
				&& weight > 0
				&& mapper.getProdCombin(record.getProductId()).equals("0")) {
			// 设置最近更新人
			record.setUpdataUser(SecurityUtils.getCurrentUserLogin());
			// 设置最近更新时间
			record.setUpdataDate(df.parse(df.format(new Date())));
			
			mapper.updateList(record);
			// 设置可用配比
			float last_weight = 100 - (mapper.getWeight(record)+ weight);
			dto.setCode(0);
			dto.setMessage("更新成功,可用配比为" + last_weight + "%");
		} else {
			// 更新失败 
			if(record.getParentProdId().equals("")) {
				dto.setCode(-1);
				dto.setMessage("主产品编号为空");
			} else if(mapper.getWeight(record)+weight > 100) {
				dto.setCode(-2);
				dto.setMessage("子产品配比大于100%");
			} else if (weight <= 0) {
				dto.setCode(-2);
				dto.setMessage("子产品配比错误");
			} else if (!mapper.getProdCombin(record.getProductId()).equals("0")) {
				dto.setCode(-3);
				dto.setMessage("子产品不能为组合产品");
			} else {
				dto.setCode(-4);
				dto.setMessage("未知错误");
			}
		}
		return dto;
	}
	/**
	* @throws  
	* @方法名称: deleteList
	* @方法描述: 删除组合子产品
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> deleteList(CmFRcProdCombinInfo record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String[] str = record.getProductId().split(",");
		for (int i=0;i<str.length;i++) {
			record.setProductId(str[i]);
			mapper.deleteList(record);
		}
		dto.setCode(0);
		dto.setMessage("删除子产品成功");
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
