package cn.com.yusys.climp.qypool.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.climp.qypool.repository.mapper.MerchantCompareMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyMaterialListService
 * @类描述: 素材管理服务类
 * @功能描述:
 * @创建人: yangxiao2
 * @创建时间: 2019-04-17
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class MerchantCompareService extends CommonService{
	@Autowired
	private MerchantCompareMapper mapper;
    @Autowired
    private UserInfoService userInfoService;
	@Override
	protected CommonMapper<?> getMapper() {
		return mapper;
	}
	/**
	 * @方法名称:getOrgCode
	 * @方法描述:获取登录用户的机构号
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public String getOrgCode() {
        return userInfoService.getOrgCode();
	}
	/**
	 * @方法名称:materialQuery
	 * @方法描述:查询素材列表
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<Map<String,Object>>getCompareList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> result=this.mapper.getCompareList(model);
		PageHelper.clearPage();
		return result;
	}
	/**
	 * @方法名称:insert
	 * @方法描述:新增素材列表
	 * @参数与返回说明:
	 * @算法描述:
	 */
//	public ResultDto<Integer>insert(LoyQyMaterialList record){
//		ResultDto<Integer> dto = new ResultDto<Integer>();
//		String loginCode = SecurityUtils.getCurrentUserLogin();
//		boolean nullflag = "".equals(record.getUploadApproal()) 
//				&& "".equals(record.getUploadFile()) 
//				&& "".equals(record.getUploadLink())
//				&& "".equals(record.getDetailContent());
//		if (mapper.getSameName(record.getMaterialName()) != 0) {
//			// 素材名重复校验
//			dto.setCode(-1);
//			dto.setMessage("素材名重复");
//		} else if (nullflag) {
//			// 上传文件校验
//			dto.setCode(-1);
//			dto.setMessage("未上传文件");
//		} else {
//			if(record.getNaturalSize() != null && !record.getNaturalSize().equals("")) {
//				String[] size = record.getNaturalSize().split("\\*");
//				long math_size = Long.parseLong(size[0])*Long.parseLong(size[1]);
//				if(math_size != 0) {
//					if(math_size<2073600) { // 分辨率1920*1080
//						record.setApplySize("4"); // 特大尺寸
//					} else if (math_size<1310720) { // 1280*1024
//						record.setApplySize("3"); // 大尺寸
//					} else if (math_size<307200) { // 640*480
//						record.setApplySize("2"); // 中尺寸
//					} else {
//						record.setApplySize("1"); // 小尺寸
//					}
//				}
//			}
//			record.setMaterialSts("1");// 初始状态未提交
//			record.setCreateDate(new Date());
//			record.setUpdateDate(record.getCreateDate());
//			record.setCreateOrg(getOrgCode());
//			record.setUpdateOrg(getOrgCode());
//			record.setCreateUser(loginCode);
//			record.setUpdateUser(loginCode);
//			mapper.insertSelective(record);
//			dto.setCode(0);
//			dto.setMessage("新增成功");
//		}
//		return dto;
//	}
//	/**
//	 * @方法名称:edit
//	 * @方法描述:修改素材列表
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	public ResultDto<Integer>edit(LoyQyMaterialList record) {
//		ResultDto<Integer> dto = new ResultDto<Integer>();
//		String loginCode = SecurityUtils.getCurrentUserLogin();
//		boolean nullflag = "".equals(record.getUploadApproal()) 
//				&& "".equals(record.getUploadFile()) 
//				&& "".equals(record.getUploadLink())
//				&& "".equals(record.getDetailContent());
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("materialName", record.getMaterialName());
//		map.put("id", record.getId());
//		if (mapper.getSameNameEdit(map) != 0) {
//			// 素材名重复校验
//			dto.setCode(-1);
//			dto.setMessage("素材名重复");
//		} else if (nullflag) {
//			// 上传文件校验
//			dto.setCode(-1);
//			dto.setMessage("未上传文件");
//		} else {
//			record.setUpdateDate(new Date());
//			record.setUpdateUser(loginCode);
//			record.setUpdateOrg(getOrgCode());
//			mapper.updateByPrimaryKeySelective(record);
//			dto.setCode(0);
//			dto.setMessage("修改成功");
//		}
//		return dto;
//	}
//	/**
//	 * @方法名称:delete
//	 * @方法描述:删除素材列表
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	public ResultDto<Integer>delete(Map<String,Object> map) {
//		ResultDto<Integer> dto = new ResultDto<Integer>();
//		boolean nullflag = map.get("uploadApproal") == null
//				&& map.get("uploadFile") == null
//				&& map.get("uploadLink") == null
//				&& map.get("detailContent") == null;
//		if (nullflag) {
//			dto.setCode(-1);
//			dto.setMessage("删除失败");
//		} else {
//			mapper.deleteByPrimaryKey(map.get("id").toString());
//			dto.setCode(0);
//			dto.setMessage("删除成功");
//		}
//		return dto;
//	}
	public List<Map<String, Object>> merchantDetail(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> result=this.mapper.getCompareList(model);
		PageHelper.clearPage();
		return null;
	}
}
