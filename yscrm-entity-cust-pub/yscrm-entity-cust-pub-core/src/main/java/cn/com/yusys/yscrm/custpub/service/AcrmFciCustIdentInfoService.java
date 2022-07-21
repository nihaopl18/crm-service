package cn.com.yusys.yscrm.custpub.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciAddrInfo;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustIdentInfo;
import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmFciCustIdentInfoMapper;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciCustIdentInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-01-27 17:34:34
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciCustIdentInfoService extends CommonService {
	@Autowired
	private AcrmFciCustIdentInfoMapper acrmFciCustIdentInfoMapper;
	@Autowired
	private CommonCustDataChangeService commonCustDataChangeService;
	@Autowired
	private UaaClient uaaClient;
	private static final String IDENT = "IDENT";
	@Override
	protected CommonMapper<?> getMapper() {
		return this.acrmFciCustIdentInfoMapper;
	}

	/**
	 * 
	 * @方法名称: queryIdentList
	 * @方法描述: 根据证件ID查询证件信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryIdentList(String custId, QueryModel model) {

		PageHelper.startPage(model.getPage(), model.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		List<Map<String, Object>> list = acrmFciCustIdentInfoMapper.queryIdentList(paramMap);
		PageHelper.clearPage();
		return list;
	}

	/**
	 * 
	 * @方法名称: insertIdent
	 * @方法描述: 保存证件信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public AcrmFciCustIdentInfo insertIdent(AcrmFciCustIdentInfo record) {

		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String orgCode = dto.getBody().getOrg().getCode();
		String loginCode = dto.getBody().getLoginCode();
		String corpOrgCode = dto.getBody().getInstu().getCode();
		record.setCratDt(new Date());
		record.setCratOrgId(orgCode);
		record.setCratUsr(loginCode);
		record.setLastChgDt(new Date());
		record.setLastChgSys("CRM");
		record.setLastChgUsr(loginCode);
		record.setCorpOrgCode(corpOrgCode);
		if (record.getEffectDate() != null && !record.getEffectDate().equals("")) {
			record.setEffectDate(record.getEffectDate().replace("-", ""));
		}
		if (record.getExpiredDate() != null && !record.getExpiredDate().equals("")) {
			record.setExpiredDate(record.getExpiredDate().replace("-", ""));
		}
		// if (record.getMainIdentFlg() != null && !record.getMainIdentFlg().equals(""))
		// {
		// if (record.getMainIdentFlg().equals("1")) {// 如果当前修改数据为主证件，则将此客户的其他证件设为非主证件
		// this.updateMainIdentFlag(record.getCustId());
		// }
		// }

		// 调用通用记录修改信息接口
		Object original = new AcrmFciCustIdentInfo();
		try {
			this.commonCustDataChangeService.saveChangeData(record, original, record.getCustId(), IDENT, "新增", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.insertSelective(getMapper(), record);
		return record;
	}

	/**
	 * 
	 * @方法名称: updateIdent
	 * @方法描述: 更新证件信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public int updateIdent(Object record) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String orgCode = dto.getBody().getOrg().getCode();
		String loginCode = dto.getBody().getLoginCode();
		String corpOrgCode = dto.getBody().getInstu().getCode();
		AcrmFciCustIdentInfo pool = (AcrmFciCustIdentInfo) record;
		pool.setLastChgDt(new Date());
		pool.setLastChgSys("CRM");
		pool.setLastChgUsr(loginCode);
		pool.setCorpOrgCode(corpOrgCode);
		if (pool.getEffectDate() != null && !pool.getEffectDate().equals("")) {
			pool.setEffectDate(pool.getEffectDate().replace("-", ""));
		}
		if (pool.getExpiredDate() != null && !pool.getExpiredDate().equals("")) {
			pool.setExpiredDate(pool.getExpiredDate().replace("-", ""));
		}
		// if (pool.getMainIdentFlg() != null && !pool.getMainIdentFlg().equals("")) {
		// if (pool.getMainIdentFlg().equals("1")) {// 如果当前修改数据为主证件，则将此客户的其他证件设为非主证件
		// this.updateMainIdentFlag(pool.getCustId());
		// }
		// }

		// 调用通用记录修改信息接口
		Object original = this.selectByPrimaryKey(getMapper(), pool);
		try {
			this.commonCustDataChangeService.saveChangeData(pool, original, pool.getCustId(), IDENT, "修改", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.updateSelective(getMapper(), pool);

	}

	/**
	 * 
	 * @方法名称: deleteIdentInfo
	 * @方法描述:删除证件信息
	 * @参数与返回说明:
	 * @算法描述:
	 */

	// @Transactional(readOnly = false, rollbackFor = {Exception.class,
	// RuntimeException.class})
	public int deleteIdentInfo(String id) {
		/*
		 * Map<String, String> paramMap = new HashMap<String, String>();
		 * paramMap.put("id", id);
		 */
		AcrmFciCustIdentInfo pool = new AcrmFciCustIdentInfo();
		pool.setId(id);
		// 调用通用记录修改信息接口
		Object original = this.selectByPrimaryKey(getMapper(), pool);
		try {
			this.commonCustDataChangeService.saveChangeData(new AcrmFciCustIdentInfo(), original,
					((AcrmFciCustIdentInfo) original).getCustId(), IDENT, "删除", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.delete(pool);
	}

	/**
	 * 
	 * @方法名称: updateMainIdentFlag
	 * @方法描述:主证件标识修改
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public int updateMainIdentFlag(String custId) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		paramMap.put("mainIdentFlg", "0");
		return acrmFciCustIdentInfoMapper.updateMainIdentFlag(paramMap);
	}

	public int updatePoten(AcrmFciCustIdentInfo acrmFciCustIdentInfo) {
		// TODO 自动生成的方法存根
		return acrmFciCustIdentInfoMapper.updatePoten(acrmFciCustIdentInfo);
	}
}
