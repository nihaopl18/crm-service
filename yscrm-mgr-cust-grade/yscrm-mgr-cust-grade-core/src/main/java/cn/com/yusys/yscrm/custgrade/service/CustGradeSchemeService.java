package cn.com.yusys.yscrm.custgrade.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custgrade.domain.OcrmFciGradeLevel;
import cn.com.yusys.yscrm.custgrade.domain.OcrmFciGradeScheme;
import cn.com.yusys.yscrm.custgrade.domain.OcrmFciGradeStandard;
import cn.com.yusys.yscrm.custgrade.repository.mapper.OcrmFciGradeLevelMapper;
import cn.com.yusys.yscrm.custgrade.repository.mapper.OcrmFciGradeSchemeMapper;
import cn.com.yusys.yscrm.custgrade.repository.mapper.OcrmFciGradeStandardMapper;
import cn.com.yusys.yscrm.custgrade.util.UtilsCommon;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: OcrmFciGradeSchemeService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-02-18 11:14:46
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CustGradeSchemeService extends CommonService {
	@Autowired
	private OcrmFciGradeSchemeMapper ocrmFciGradeSchemeMapper;
	@Autowired
	private OcrmFciGradeStandardMapper OcrmFciGradeStandardMapper;

	@Autowired
	private OcrmFciGradeLevelMapper OcrmFciGradeLevelMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return ocrmFciGradeSchemeMapper;
	}

	@Autowired
	private UaaClient uaaClient;

	public List<Map<String, Object>> queryList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.ocrmFciGradeSchemeMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}

	/**
	 * 新增 评价方案 与 评价标准和评价参数列表
	 * 
	 * @param gs
	 * @param listGstand
	 * @param mapGl
	 */
	public int insertGs(OcrmFciGradeScheme gs, List<Object> listGstand, Map<String, List<Object>> mapGl) {
		// TODO 自动生成的方法存根
		// 新增 评价 方案 表 ，并取回新增的ID, 赋值给 其它两张表
		// Map map = new HashMap();
		// map.put("gradeUseage", gs.getGradeUseage());
		// map.put("gradeType", gs.getGradeType());
		// map.put("isUsed", gs.getIsUsed());
		UtilsCommon util = new UtilsCommon();

		// 验证一下 是的 只有一条方案。
		if (gs.getIsUsed().equals("1"))
			if (!this.checkIsEnable(gs)) {
				return -1;// 失败标识
			}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		Date date = new Date();
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());

		String schemeId = "";
		gs.setCorpOrgCode(dto.getBody().getInstu().getCode());// 法人
		gs.setCratDt(new Date());// 创建日期
		gs.setCratUsr(dto.getBody().getLoginCode());// 创建人id
		gs.setCratUserName(dto.getBody().getUserName());
		gs.setCratOrgId(dto.getBody().getOrg().getCode());// 创建机构Id
		gs.setCratOrgName(dto.getBody().getOrg().getName());
		gs.setLastChgDt(gs.getCratDt());
		gs.setLastChgUsr(dto.getBody().getLoginCode());
		gs.setLastChgUsrName(dto.getBody().getUserName());
		// 认为 方案数据已经插入
		if (this.insertSelective(ocrmFciGradeSchemeMapper, gs) > 0) {
			schemeId = gs.getSchemeId();
			for (Object stand0 : listGstand) {
				OcrmFciGradeStandard stand = util.map2Object((Map<String, Object>) stand0, OcrmFciGradeStandard.class);
				stand.setSchemeId(schemeId);
				stand.setCorpOrgCode(gs.getCorpOrgCode());
				stand.setCratDt(gs.getCratDt());
				stand.setCratOrgId(gs.getCratOrgId());
				stand.setCratUsr(gs.getCratUsr());
				stand.setLastChgDt(gs.getLastChgDt());
				stand.setLastChgUsrId(gs.getCratUsr());
				stand.setLastChgOrgId(gs.getCratOrgId());
				// standId 找到 从前台赋值的standardId
				String standardId = stand.getStandardId();
				// 得到参数表的list对象
				List<Object> listGl = mapGl.get(standardId);
				// 置空 standId
				stand.setStandardId(null);
				// 保存
				if (this.insertSelective(OcrmFciGradeStandardMapper, stand) > 0) {
					standardId = stand.getStandardId();
					for (Object gl0 : listGl) {
						OcrmFciGradeLevel gl = util.map2Object((Map<String, Object>) gl0, OcrmFciGradeLevel.class);
						gl.setCorpOrgCode(stand.getCorpOrgCode());
						gl.setSchemeId(schemeId);
						gl.setStandardId(standardId);
						this.insertSelective(OcrmFciGradeLevelMapper, gl);
					}
				}
			}
		}
		return 0;// 成功标识
	}
	public int updateGs(OcrmFciGradeScheme gs, List<Object> listGstand, Map<String, List<Object>> mapGl) {
		UtilsCommon util = new UtilsCommon();
		OcrmFciGradeScheme oldGs=this.ocrmFciGradeSchemeMapper.selectByPrimaryKey(gs.getSchemeId());

		// 验证一下 是的 修改方案 为启用,需要验证，改为禁用不需要，不修改也不需要
		if (gs.getIsUsed().equals("1")&&oldGs.getIsUsed().equals("0"))
			if (!this.checkIsEnable(gs)) {
				return -1;// 失败标识
			}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		Date date = new Date();
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());

		String schemeId = "";
		gs.setCorpOrgCode(oldGs.getCorpOrgCode());// 法人
		gs.setCratDt(oldGs.getCratDt());// 创建日期
		gs.setCratUsr(oldGs.getCratUsr());// 创建人id
		gs.setCratUserName(oldGs.getCratUserName());
		gs.setCratOrgId(oldGs.getCratOrgId());// 创建机构Id
		gs.setCratOrgName(oldGs.getCratOrgName());
		gs.setLastChgDt(new Date());
		gs.setLastChgUsr(dto.getBody().getLoginCode());
		gs.setLastChgUsrName(dto.getBody().getUserName());
		gs.setLastChgOrgId(dto.getBody().getOrg().getCode());
		gs.setLastChgOrgName(dto.getBody().getOrg().getName());

		// 认为 方案数据已经修改
		if (this.updateSelective(ocrmFciGradeSchemeMapper, gs) > 0) {
			schemeId = gs.getSchemeId();
			// 清空  标准列表 与 标准参数列表
			this.ocrmFciGradeSchemeMapper.deleteStandard(schemeId);
			this.ocrmFciGradeSchemeMapper.deleteLevel(schemeId);
			for (Object stand0 : listGstand) {
				OcrmFciGradeStandard stand = util.map2Object((Map<String, Object>) stand0, OcrmFciGradeStandard.class);
				stand.setSchemeId(schemeId);
				stand.setCorpOrgCode(gs.getCorpOrgCode());
				stand.setCratDt(gs.getCratDt());
				stand.setCratOrgId(gs.getCratOrgId());
				stand.setCratUsr(gs.getCratUsr());
				stand.setLastChgDt(gs.getLastChgDt());
				stand.setLastChgUsrId(gs.getCratUsr());
				stand.setLastChgOrgId(gs.getCratOrgId());
				// standId 找到 从前台赋值的standardId
				String standardId = stand.getStandardId();
				// 得到参数表的list对象
				List<Object> listGl = mapGl.get(standardId);
				// 置空 standId
				stand.setStandardId(null);
				// 保存
				if (this.insertSelective(OcrmFciGradeStandardMapper, stand) > 0) {
					standardId = stand.getStandardId();
					for (Object gl0 : listGl) {
						OcrmFciGradeLevel gl = util.map2Object((Map<String, Object>) gl0, OcrmFciGradeLevel.class);
						gl.setCorpOrgCode(stand.getCorpOrgCode());
						gl.setSchemeId(schemeId);
						gl.setStandardId(standardId);
						this.insertSelective(OcrmFciGradeLevelMapper, gl);
					}
				}
			}
		}
		return 0;// 成功标识
	}
	
	public List<Map<String, Object>> queryPeriodList(QueryModel model) {
		List<Map<String, Object>> list = this.ocrmFciGradeSchemeMapper
				.queryperiodlist(String.valueOf(model.getCondition().get("schemeId")));
		return list;

	}

	public List<Map<String, Object>> queryGradeLevel(QueryModel model) {
		List<Map<String, Object>> list = this.ocrmFciGradeSchemeMapper
				.queryGradeLevel(String.valueOf(model.getCondition().get("schemeId")));
		return list;
	}

	public List<Map<String, Object>> queryDetail(QueryModel model) {
		List<Map<String, Object>> list = this.ocrmFciGradeSchemeMapper
				.queryDetail(String.valueOf(model.getCondition().get("schemeId")));
		return list;
	}

	public int deleteBySchemeId(String schemeId) {
		int n = 0;
		if (schemeId != null) {
			String[] schemeIdarr = schemeId.split(",");
			for (int i = 0; i < schemeIdarr.length; i++) {
				n++;
				ocrmFciGradeSchemeMapper.deleteById(schemeIdarr[i]);
				this.ocrmFciGradeSchemeMapper.deleteStandard(schemeIdarr[i]);
				this.ocrmFciGradeSchemeMapper.deleteLevel(schemeIdarr[i]);
			}
		}
		return n;
	}

	/**
	 * 验证是否可以启用
	 * 
	 * @param string
	 * @return
	 */
	public boolean enable(String schemeId) {
		OcrmFciGradeScheme gs = this.ocrmFciGradeSchemeMapper.selectByPrimaryKey(schemeId);
		if (this.checkIsEnable(gs)) {
			this.ocrmFciGradeSchemeMapper.enable(getLast(schemeId));
			return true;
		}
		return false;

		// if (this.checkIsEnable(gs)) {
		// return "0";// 可以启用
		// }else {
		// return "-1";//不可以启用
		// }
	}

	/**
	 * 禁用方案
	 * @param string
	 */
	public void disEnable(String schemeId) {
		this.ocrmFciGradeSchemeMapper.disEnable(getLast(schemeId));
	}

	/**
	 * 验证启用方法
	 */
	public boolean checkIsEnable(OcrmFciGradeScheme gs) {
		Map map = new HashMap();
		map.put("gradeUseage", gs.getGradeUseage());
		map.put("gradeType", gs.getGradeType());
		map.put("isUsed", "1");
		if (this.ocrmFciGradeSchemeMapper.queryEnable(map) >= 1) {
			return false; // 不可以启用
		}
		return true; // 可以启用
	}
/**
 * 获得维护人信息
 * @param schemeId
 * @return
 */
	public Map<String,Object> getLast(String schemeId){
		Map<String,Object> map = new HashMap();
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		if(schemeId!=null) {
			map.put("schemeId", schemeId);
			map.put("lastChgUsr", dto.getBody().getLoginCode());
			map.put("lastChgUsrName", dto.getBody().getUserName());
			map.put("lastChgOrgId", dto.getBody().getOrg().getCode());
			map.put("lastChgOrgName", dto.getBody().getOrg().getName());
		}
		return map;
	}
 /**
  * 查询指标
  */
	public List<Map<String, Object>> queryBaseIndex(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.ocrmFciGradeSchemeMapper.queryBaseIndex(String.valueOf(model.getCondition().get("indexUse")));
		PageHelper.clearPage();
		return list;
	}
	
}
