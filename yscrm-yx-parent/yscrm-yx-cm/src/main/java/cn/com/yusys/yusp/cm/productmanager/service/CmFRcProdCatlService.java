package cn.com.yusys.yusp.cm.productmanager.service;

import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProdCatlInfo;
import cn.com.yusys.yusp.cm.productmanager.repository.mapper.CmFRcProdCatlMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
public class CmFRcProdCatlService extends CommonService{
	@Autowired
	private CmFRcProdCatlMapper mapper;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* 
	* @方法名称: getList
	* @方法描述: 查询产品类别表
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public ResultDto<List<CmFRcProdCatlInfo>> getList() {
		List<CmFRcProdCatlInfo> list = mapper.getList();
		ResultDto<List<CmFRcProdCatlInfo>> dto = new ResultDto<List<CmFRcProdCatlInfo>>(list);
		dto.setCode(0);
		dto.setMessage("查询成功");
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: insertList
	* @方法描述: 新增产品类别
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> insertList(CmFRcProdCatlInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 新增成功
		if("0".equals(mapper.getSameName(record)) && 
				mapper.getNodeLevel(record.getCatlParent()) <= 5) {
			// 设置id
			record.setCatlCode(Integer.parseInt(mapper.getSeq()));
			// 设置创建人 
			record.setCreatUser(SecurityUtils.getCurrentUserLogin());
			// 设置创建时间 
			record.setCreatDate(df.parse(df.format(new Date())));
			// 设置最近更新人
			record.setUpdataUser(SecurityUtils.getCurrentUserLogin());
			// 设置最近更新时间
			record.setUpdataDate(record.getCreatDate());
			
			mapper.insertSelective(record);
			dto.setCode(0);
			dto.setMessage("新增成功");
		} else {
			if(mapper.getNodeLevel(record.getCatlParent()) > 5) {
				// 新增失败 
				dto.setCode(-2);
				dto.setMessage("产品树级别过高");
			} else {
				// 新增失败 
				dto.setCode(-1);
				dto.setMessage("类别名称重复");
			}
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: updateList
	* @方法描述: 更新产品类别
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> updateList(CmFRcProdCatlInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if("0".equals(mapper.getSameName(record)) &&
				mapper.getNodeLevel(record.getCatlParent()) <= 5) {
			// 设置最近更新人
			record.setUpdataUser(SecurityUtils.getCurrentUserLogin());
			// 设置最近更新时间
			record.setUpdataDate(df.parse(df.format(new Date())));
			
			mapper.updateList(record);
			dto.setCode(0);
			dto.setMessage("更新成功");
		} else {
			if(mapper.getNodeLevel(record.getCatlParent()) > 5) {
				// 新增失败 
				dto.setCode(-2);
				dto.setMessage("产品树级别过高");
			} else {
				// 新增失败 
				dto.setCode(-1);
				dto.setMessage("类别名称重复");
			}
		}
		return dto;
	}
	/**
	* @throws  
	* @方法名称: deleteList
	* @方法描述: 删除产品类别
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> deleteList(CmFRcProdCatlInfo record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 产品类别下没有子节点
		if("0".equals(mapper.getSonNode(record.getCatlCode())) && 
				mapper.getSonProd(record.getCatlCode()) == 0) {
			mapper.deleteList(record);
			dto.setCode(0);
			dto.setMessage("删除成功");
		} else {
			if(!"0".equals(mapper.getSonNode(record.getCatlCode()))) {
				// 产品类别下含有子节点
				dto.setCode(-1);
				dto.setMessage("产品类别下含有子节点");
			} else {
				// 产品类别下含有子产品
				dto.setCode(-2);
				dto.setMessage("产品类别下含有子产品");
			}
		}
		return dto;
	}
}
