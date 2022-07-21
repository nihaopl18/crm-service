package cn.com.yusys.yscrm.product.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.product.repository.mapper.AcrmFpdProdScolMapper;
import cn.com.yusys.yscrm.product.repository.mapper.OcrmFsysSsColMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: OcrmFsysSsColService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: yantianyi
 * @创建时间: 2019-03-06 10:00:31
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFsysSsColService extends CommonService {
	@Autowired
	private OcrmFsysSsColMapper ocrmFsysSsColMapper;

	@Autowired
	private AcrmFpdProdScolMapper acrmFpdProdScolMapper;

	@Autowired
	private UaaClient uaaClient;

	@Override
	protected CommonMapper<?> getMapper() {
		return ocrmFsysSsColMapper;
	}

	/**
	 * 根据节点信息查询条件字段列
	 * 
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> getScol(String prodId, String ssType) {
		QueryModel queryModel = new QueryModel();
		queryModel.getCondition().put("prodId", prodId);
		queryModel.getCondition().put("ssType", ssType);
		List<Map<String, Object>> list = ocrmFsysSsColMapper.getScol(queryModel);
		return list;
	}

	/**
	 * 保存表单节点关系表及保存输出表
	 * 
	 * @param
	 * @return
	 */
	public int saveScol(List<Map<String, Object>> col, String prodId) throws ParseException {
		int count = 0;
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		ocrmFsysSsColMapper.delerteCol(prodId);
		for (int i = 0; i < col.size(); i++) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			Map<String, Object> prodScol = (Map<String, Object>) col.get(i);
			prodScol.put("id", id);
			prodScol.put("ssColType", "1");
			this.insertSelective(acrmFpdProdScolMapper, prodScol);
			count++;
		}
		return count;
	}

	public List<Map<String, Object>> getColQuery(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = ocrmFsysSsColMapper.getColQuery(model);
		PageHelper.clearPage();
		return list;
	}

	/**
	 * 产品视图-产品准入限制左侧树查询
	 * 
	 * @param record
	 *            是重新设置
	 * @return
	 */
	public List<Map<String, Object>> prepare() {
		String queryTytpe = "251";// 默认查询类型-客户高级查询
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from ACRM_F_PD_PROD_LIMIT t where t.SS_COL_TYPE = '1'");
		List<Map<String, Object>> list = ocrmFsysSsColMapper.prepare(sb.toString());
		return list;
	}

	/**
	 * 拖动后查询字段类型
	 * 
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> showcoltype(QueryModel model) {
		return ocrmFsysSsColMapper.showcoltype(model);
	}

	/**
	 * 根据节点信息查询条件字段列
	 * 
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> getCustScol(String prodId, String ssType) {
		QueryModel queryModel = new QueryModel();
		queryModel.getCondition().put("prodId", prodId);
		queryModel.getCondition().put("ssType", ssType);
		List<Map<String, Object>> list = ocrmFsysSsColMapper.getCustScol(queryModel);
		return list;
	}

	/**
	 * 保存表单节点关系表及保存输出表
	 * 
	 * @param
	 * @return
	 */
	public int saveCustCol(List<Map<String, Object>> col, String prodId) throws ParseException {
		int count = 0;
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		ocrmFsysSsColMapper.delerteCustCol(prodId);
		for (int i = 0; i < col.size(); i++) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			Map<String, Object> prodScol = (Map<String, Object>) col.get(i);
			prodScol.put("id", id);
			prodScol.put("ssColType", "2");
			this.insertSelective(acrmFpdProdScolMapper, prodScol);
			count++;
		}
		return count;
	}
	
	/**
	 * 产品视图-产品准入限制左侧树查询
	 * 
	 * @param record
	 *            是重新设置
	 * @return
	 */
	public List<Map<String, Object>> custPrepare() {
		String queryTytpe = "251";// 默认查询类型-客户高级查询
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from ACRM_F_PD_PROD_LIMIT t where t.SS_COL_TYPE = '2'");
		List<Map<String, Object>> list = ocrmFsysSsColMapper.prepare(sb.toString());
		return list;
	}

}
