package cn.com.yusys.yscrm.salesoppor.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.salesoppor.domain.OcrmFMkMktActivityInfo;
import cn.com.yusys.yscrm.salesoppor.repository.mapper.OcrmFMkMktActivityMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkMktActivityService
 * @类描述：营销活动明细相关Service
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-22
 */
@Service
public class OcrmFMkMktActivityService extends CommonService{
	@Autowired
	private OcrmFMkMktActivityMapper mapper;
	@Autowired
	private UaaClient uaaClient;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* @方法名称: activiListQuery
	* @方法描述: 销售活动查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = true)
	public List<Map<String,Object>> activiListQuery(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.activiListQuery(model);
		PageHelper.clearPage();
		return list;
	}

	/**
	* @throws ParseException 
	* @方法名称: activiInsert
	* @方法描述: 销售活动新增
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> activiInsert(OcrmFMkMktActivityInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 销售名称验重
		if(mapper.activiSame(record) > 0) {
			dto.setCode(-1);
			dto.setMessage("销售名称重复");
		} else {
			// 设置销售编号
			record.setActivityNo(getUUID());
			// 设置活动执行日期
			record.setActivityExecuteDate(df.parse(df.format(record.getActivityExecuteDate())));
			// 获取机构信息
			ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
			// 设置执行机构、执行人
			record.setActivityExecuteOrg(org.getBody().getOrg().getCode());
			record.setActivityExecuteUser(SecurityUtils.getCurrentUserLogin());
			// 设置创建人、创建机构、创建时间
			record.setCreateUser(SecurityUtils.getCurrentUserLogin());
			record.setCreateOrg(org.getBody().getOrg().getCode());
			record.setCreateDate(df.parse(df.format(new Date())));
			// 设置最近更新人、更新机构、更新时间
			record.setUpdataUser(record.getCreateUser());
			record.setUpdataOrg(record.getCreateOrg());
			record.setUpdataDate(record.getCreateDate());
			mapper.insertSelective(record);
			// 设置对应的商机阶段
			String actiStage = record.getActivityStage();
			if("0".equals(actiStage)) {// 了解商机 对应销售阶段0
				mapper.setBusinessStage("1",record.getBusinessNo());
			} else if("1".equals(actiStage)) {// 确认商机 对应销售阶段1
				mapper.setBusinessStage("2",record.getBusinessNo());
			} else if("2".equals(actiStage) || "3".equals(actiStage)) {// 方案论证 对应销售阶段2,3
				mapper.setBusinessStage("3",record.getBusinessNo());
			} else if("4".equals(actiStage) || "5".equals(actiStage)) {// 商务谈判 对应销售阶段4,5
				mapper.setBusinessStage("4",record.getBusinessNo());
			} else if("6".equals(actiStage)) {// 商机成交 对应销售阶段6
				mapper.setBusinessStage("5",record.getBusinessNo());
			}
			dto.setCode(0);
			dto.setMessage("新增成功");
		}
		return dto;
	}
	/**
	* @throws ParseException 
	* @方法名称: activiUpdate
	* @方法描述: 销售活动修改
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> activiUpdate(OcrmFMkMktActivityInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 销售名称验重
		if(mapper.activiSame(record) > 0) {
			dto.setCode(-1);
			dto.setMessage("销售名称重复");
		} else {
			// 设置活动执行日期
			record.setActivityExecuteDate(df.parse(df.format(record.getActivityExecuteDate())));
			// 获取机构信息
			ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
			// 设置执行机构、执行人
			record.setActivityExecuteOrg(org.getBody().getOrg().getCode());
			record.setActivityExecuteUser(SecurityUtils.getCurrentUserLogin());
			// 设置最近更新人、更新机构、更新时间
			record.setUpdataUser(SecurityUtils.getCurrentUserLogin());
			record.setUpdataOrg(org.getBody().getOrg().getCode());
			record.setUpdataDate(df.parse(df.format(new Date())));
			mapper.updateByPrimaryKeySelective(record);
			// 设置对应的商机阶段
			String actiStage = record.getActivityStage();
			if("0".equals(actiStage)) {// 了解商机 对应销售阶段0
				mapper.setBusinessStage("1",record.getBusinessNo());
			} else if("1".equals(actiStage)) {// 确认商机 对应销售阶段1
				mapper.setBusinessStage("2",record.getBusinessNo());
			} else if("2".equals(actiStage) || "3".equals(actiStage)) {// 方案论证 对应销售阶段2,3
				mapper.setBusinessStage("3",record.getBusinessNo());
			} else if("4".equals(actiStage) || "5".equals(actiStage)) {// 商务谈判 对应销售阶段4,5
				mapper.setBusinessStage("4",record.getBusinessNo());
			} else if("6".equals(actiStage)) {// 商机成交 对应销售阶段6
				mapper.setBusinessStage("5",record.getBusinessNo());
			}
			dto.setCode(0);
			dto.setMessage("更新成功");
		}
		return dto;
	}
	/**
	* @方法名称: activiDel
	* @方法描述: 销售活动删除
	* @参数与返回说明: 
	* @算法描述:
	**/
	public ResultDto<Integer> activiDel(String ids) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String[] arr = ids.split(",");
		for(int i=0;i<arr.length;i++) {
			mapper.activiDel(arr[i]);
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
}
