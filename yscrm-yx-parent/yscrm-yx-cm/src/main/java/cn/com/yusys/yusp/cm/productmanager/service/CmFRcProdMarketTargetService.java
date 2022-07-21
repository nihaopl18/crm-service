package cn.com.yusys.yusp.cm.productmanager.service;

import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProdMarketTargetInfo;
import cn.com.yusys.yusp.cm.productmanager.repository.mapper.CmFRcProdMarketTargetMapper;
import cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper.CmFRcSysTypeMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.github.pagehelper.PageHelper;
import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcProdMarketTargetService
 * @类描述: 营销成效指标维护接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcProdMarketTargetService extends CommonService{
	@Autowired
	private CmFRcProdMarketTargetMapper mapper;
	@Autowired
	private CmFRcSysTypeMapper typemapper;
	@Autowired
	private UserInfoService userInfo; 
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* 
	* @方法名称: getList
	* @方法描述: 查询营销成效指标
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public ResultDto<List<CmFRcProdMarketTargetInfo>> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcProdMarketTargetInfo> list = mapper.getList(model);
		PageHelper.clearPage();
		ResultDto<List<CmFRcProdMarketTargetInfo>> dto = new ResultDto<List<CmFRcProdMarketTargetInfo>>(list);
		dto.setCode(0);
		dto.setMessage("查询成功");
		return dto;
	}

	/**
	 * 不根据productId查询产品信息
	 * @param model
	 * @return
	 */
	@Transactional(readOnly = true)
	public ResultDto<List<CmFRcProdMarketTargetInfo>> getListAll(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcProdMarketTargetInfo> list = mapper.getListAll(model);
		PageHelper.clearPage();
		ResultDto<List<CmFRcProdMarketTargetInfo>> dto = new ResultDto<List<CmFRcProdMarketTargetInfo>>(list);
		dto.setCode(0);
		dto.setMessage("查询成功");
		return dto;
	}
	public ResultDto<List<CmFRcProdMarketTargetInfo>> getListByTargetId(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcProdMarketTargetInfo> list = mapper.getListByTargetId(model);
		PageHelper.clearPage();
		ResultDto<List<CmFRcProdMarketTargetInfo>> dto = new ResultDto<List<CmFRcProdMarketTargetInfo>>(list);
		dto.setCode(0);
		dto.setMessage("查询成功");
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: insertList
	* @方法描述: 新增营销成效指标
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(rollbackFor = Exception.class)
	public synchronized ResultDto<Integer> insertList(CmFRcProdMarketTargetInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 新增成功
		if("0".equals(mapper.getSameId(record)) && "0".equals(mapper.getSameName(record))) {
			// 设置id
			record.setId(getUUID());;
			// 设置创建人 
			record.setCreateUser(SecurityUtils.getCurrentUserLogin());
			// 设置创建时间 
			record.setCreateDate(df.parse(df.format(new Date())));
			// 设置创建人名称
			record.setCreateUserName(typemapper.getUserName(record.getCreateUser()));
			// 设置最近更新人
			record.setLastUpdataUser(record.getCreateUser());
			// 设置最近更新时间
			record.setLastUpdataDate(record.getCreateDate());
			// 设置最近更新人名称
			record.setLastUpdateUserName(record.getCreateUserName());
			// 设置最新更新机构
			record.setLastUpdataOrg(userInfo.getOrgCode());
			//record.setProductId(record.getProductId());

			mapper.insertSelective(record);
			// 新增指标归属vv
			String s=record.getProductId();
			if(!StringUtil.isBlank(s)) {
				mapper.addTargetProd(record);
			}
			dto.setCode(0);
			dto.setMessage("新增成功");
		} else {
			// 新增失败 
			if(!"0".equals(mapper.getSameId(record))) {
				dto.setCode(-1);
				dto.setMessage("营销成效指标ID重复");
			} else if(!"0".equals(mapper.getSameName(record))) {
				dto.setCode(-2);
				dto.setMessage("营销成效指标名称重复");
			} else {
				dto.setCode(-3);
				dto.setMessage("未知错误");
			}
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: updateList
	* @方法描述: 更新营销成效指标
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> updateList(CmFRcProdMarketTargetInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if("0".equals(mapper.getSameName(record))) {
			// 设置最近更新人
			record.setLastUpdataUser(SecurityUtils.getCurrentUserLogin());
			// 设置最近更新时间
			record.setLastUpdataDate(df.parse(df.format(new Date())));
			// 设置最近更新人名称
			record.setLastUpdateUserName(typemapper.getUserName(record.getCreateUser()));
			// 设置最新更新机构
			record.setLastUpdataOrg(userInfo.getOrgCode());
			
			mapper.updateByPrimaryKeySelective(record);
			String s=record.getProductId();

			if(!StringUtil.isBlank(s)) {
				String targetId=record.getTargetId();
				mapper.delTargetProd(targetId);
				mapper.addTargetProd(record);
			}
			dto.setCode(0);
			dto.setMessage("更新成功");
		} else {
			// 更新失败 
			if(!"0".equals(mapper.getSameName(record))) {
				dto.setCode(-1);
				dto.setMessage("营销成效指标名称重复");
			} else {
				dto.setCode(-3);
				dto.setMessage("未知错误");
			}
		}
		return dto;
	}
	/**
	* @throws  
	* @方法名称: deleteList
	* @方法描述: 删除营销成效指标
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> deleteList(CmFRcProdMarketTargetInfo record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String[] str = record.getTargetId().split(",");
		for (int i=0;i<str.length;i++) {
			record.setTargetId(str[i]);
			mapper.deleteList(record);
			// 删除指标归属
			mapper.delTargetProd(record.getTargetId());
		}
		dto.setCode(0);
		dto.setMessage("删除子产品成功");
		return dto;
	}
	/**
	* @throws  
	* @方法名称: upList
	* @方法描述: 营销成效指标启用
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> upList(CmFRcProdMarketTargetInfo record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		mapper.upList(record);
		dto.setCode(0);
		dto.setMessage("启用成功");
		return dto;
	}
	/**
	* @throws  
	* @方法名称: downList
	* @方法描述: 营销成效指标停用
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> downList(CmFRcProdMarketTargetInfo record) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		mapper.downList(record);
		dto.setCode(0);
		dto.setMessage("停用成功");
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


//	public ResultDto<List<CmFRcProdMarketTargetInfo>> getListByTargetName(QueryModel model) {
//		PageHelper.startPage(model.getPage(), model.getSize());
//		List<CmFRcProdMarketTargetInfo> list = mapper.getListByTargetName(model);
//		PageHelper.clearPage();
//		ResultDto<List<CmFRcProdMarketTargetInfo>> dto = new ResultDto<List<CmFRcProdMarketTargetInfo>>(list);
//		dto.setCode(0);
//		dto.setMessage("查询成功");
//		return dto;
//	}
	public List<CmFRcProdMarketTargetInfo> getListByTargetName(QueryModel model) {
		String idsString = (String) model.getCondition().get("targetNames");
		String[] ids = idsString.split(",");
		List<String> listids = Arrays.asList(ids);
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcProdMarketTargetInfo> list = mapper.getListByTargetName(listids);
		PageHelper.clearPage();
		return list;
	}

	public ResultDto<List<CmFRcProdMarketTargetInfo>> queryByTargetName(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcProdMarketTargetInfo> list = mapper.queryByTargetName(model);
		PageHelper.clearPage();
		ResultDto<List<CmFRcProdMarketTargetInfo>> dto = new ResultDto<List<CmFRcProdMarketTargetInfo>>(list);
		dto.setCode(0);
		dto.setMessage("查询成功");
		return dto;
	}
}
