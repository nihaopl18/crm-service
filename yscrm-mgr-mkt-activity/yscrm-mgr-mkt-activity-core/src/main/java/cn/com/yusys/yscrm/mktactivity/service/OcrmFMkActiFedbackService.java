package cn.com.yusys.yscrm.mktactivity.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiFedbackInfo;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActivityInfo;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActiFedbackMapper;
import cn.com.yusys.yscrm.mktactivity.repository.mapper.OcrmFMkActivityMapper;
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
 * @类名称：OcrmFMkActiFedbackMapper
 * @类描述：营销活动反馈
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-30 
 */
@Service
public class OcrmFMkActiFedbackService extends CommonService {
	@Autowired
	private UaaClient uaaClient;
	@Autowired
	private OcrmFMkActiFedbackMapper mapper;
	@Autowired
	private OcrmFMkActivityMapper actmapper;
	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	/**
	* @throws ParseException 
	* @方法名称: getActUser
	* @方法描述: 营销活动反馈查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> actiFedBackList (QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.actiFedBackList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	* @throws ParseException 
	* @方法名称: actiFeedback
	* @方法描述: 营销活动反馈
	* @参数与返回说明: 
	* @算法描述:
	**/
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Integer> actiFeedback(OcrmFMkActiFedbackInfo record) throws ParseException {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取机构信息	
		ResponseEntity<UserInfoDTO> org = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		OcrmFMkActivityInfo  actInfo=actmapper.selectByPrimaryKey(record.getActiId());//活动信息
		if(record.getRecordId() == null) {//新增
			// 设置主键
			record.setRecordId(mapper.getSeq());
			// 设置反馈人、反馈时间
			record.setFdDate(df.parse(df.format(new Date())));
			record.setFdUser(SecurityUtils.getCurrentUserLogin());
			// 设置创建信息
			record.setCreateDate(record.getFdDate());
			record.setCreateOrg(org.getBody().getOrg().getCode());
			record.setCreateUser(record.getFdUser());
			record.setUpdateDate(record.getCreateDate());
			record.setUpdateOrg(record.getCreateOrg());
			record.setUpdateUser(record.getCreateUser());
			mapper.insertSelective(record);
			
			BigDecimal cost=actInfo.getPracticeCost();
			actInfo.setPracticeCost(cost.add(new BigDecimal(record.getCostInAction())));//累积实际话费
			actmapper.updateByPrimaryKeySelective(actInfo);
			dto.setCode(0);
			dto.setMessage("反馈成功");
		} else {//修改
			OcrmFMkActiFedbackInfo pool=mapper.selectByPrimaryKey(record.getRecordId());
			String oldcost=pool.getCostInAction();
			// 设置反馈人、反馈时间
			pool.setFdDate(df.parse(df.format(new Date())));
			pool.setFdUser(SecurityUtils.getCurrentUserLogin());
			// 设置创建信息
			pool.setAcceHumanNum(record.getAcceHumanNum());
			pool.setCostInAction(record.getCostInAction());
			pool.setReviewInCoustomer(record.getReviewInCoustomer());
			pool.setAdvPaperNum(record.getAdvPaperNum());
			pool.setOutcomeInAction(record.getOutcomeInAction());
			pool.setCreateOrg(org.getBody().getOrg().getCode());
			pool.setCreateUser(record.getFdUser());
			pool.setUpdateDate(record.getCreateDate());
			pool.setUpdateOrg(record.getCreateOrg());
			pool.setUpdateUser(record.getCreateUser());
			mapper.updateByPrimaryKeySelective(pool);
			
			BigDecimal cost=actInfo.getPracticeCost();
			actInfo.setPracticeCost(cost.add(new BigDecimal(record.getCostInAction())).subtract(new BigDecimal(oldcost)));//累积实际话费
			actmapper.updateByPrimaryKeySelective(actInfo);
			dto.setCode(0);
			dto.setMessage("反馈成功");
		}
		return dto;
	}
}
