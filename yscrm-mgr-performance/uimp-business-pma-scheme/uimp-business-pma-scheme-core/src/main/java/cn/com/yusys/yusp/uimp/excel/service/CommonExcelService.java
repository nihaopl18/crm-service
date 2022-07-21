package cn.com.yusys.yusp.uimp.excel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeEvlobjRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeEvlobjRelService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeExcelService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeIndexRelService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeOrgRelService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemePostRelService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeSperuleRelService;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelCellInfo;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelEvlindexInfo;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelFormulaInf;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelIndexInfo;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelObjInfo;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelTmpInfo;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExceldutyInf;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelgrantInf;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelhideInf;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelobjidInf;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelorgInf;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelorgparamInf;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelpstparamInf;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelrunInfo;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelsvwInf;
import cn.com.yusys.yusp.uimp.excel.model.ExcelDataModel;
import cn.com.yusys.yusp.uimp.excel.model.ExcelPublishModel;
import cn.com.yusys.yusp.uimp.excel.model.ExcelQuoteModel;
import cn.com.yusys.yusp.uimp.excel.model.ExcelRunModel;
import cn.com.yusys.yusp.uimp.excel.thread.SchemeExcelRunThreadManager;
import cn.com.yusys.yusp.uimp.excel.util.CommonExcelUtil;
import cn.com.yusys.yusp.uimp.spread.utils.DesignAnalysisFactory;
import tk.mybatis.mapper.util.StringUtil;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: CommonExcelService
 * @类描述: # 考核方案Excel组件 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-22 21:01:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CommonExcelService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExcelService.class);
	
	@Autowired
	private PmaFSchemeExcelService schemeExcelService;
	
	@Autowired
	private PmaFSchemeOrgRelService schemeOrgRelService;
	
	@Autowired
	private PmaFSchemePostRelService schemePostRelService;
	
	@Autowired
	private PmaFSchemeSperuleRelService schemeSperuleRelService;
	
	@Autowired
	private PmaFSchemeEvlobjRelService schemeEvlobjRelService;
	
	@Autowired
	private PmaFschemeExcelTmpInfoService tmpInfoService;
	
	@Autowired
	private PmaFschemeExcelCellInfoService cellInfoService;
	
	@Autowired
	private PmaFschemeExcelObjInfoService objInfoService;
	
	@Autowired
	private PmaFschemeExcelIndexInfoService indexInfoService;
	
	@Autowired
	private PmaFschemeExcelEvlindexInfoService evlindexInfoService;
	
	@Autowired
	private PmaFschemeExcelFormulaInfService formulaInfService;
	
	@Autowired
	private PmaFschemeExcelorgparamInfService orgparamInfService;
	
	@Autowired
	private PmaFschemeExcelpstparamInfService pstparamInfService;
	
	@Autowired
	private PmaFschemeExcelsvwInfService svwInfService;
	
	@Autowired
	private PmaFSchemeEvlobjRelMapper pmaFSchemeEvlobjRelMapper;
	
	@Autowired
	private PmaFSchemeIndexRelService pmaFSchemeIndexRelService;
	
	@Autowired
	private SchemeExcelRunThreadManager runThreadManager;
	
	@Autowired
	private PmaFschemeExcelrunInfoService runInfoService;
	
	@Autowired
	private PmaFschemeExcelhideInfService hideInfService;
	
	@Autowired
	private PmaFschemeExcelgrantInfService grantInfService;
	
	@Autowired
	private PmaFschemeExceldutyInfService dutyInfService;
	
	@Autowired
	private PmaFschemeExcelorgInfService orgInfService;
	
	@Autowired
	private PmaFschemeExcelobjidInfService objIdInfService;
	
	@Autowired
	private UserInfoService userInfo; 

	@Override
    protected CommonMapper<?> getMapper() {
        return null;
    }
	
    /**
	 * @方法名称: indexSelectorQuerylist
	 * @方法描述: 考核方案-指标放大镜-查询列表数据(分页)
	 * @参数与返回说明: 
	 * @param model: condition-type: 1基础指标  2派生指标  0基础/派生都查询
	 * @算法描述: 
	 *   支持查询基础指标、派生指标数据
	 *   返回数据包含指标维度信息
	 */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> indexSelectorQuerylist(QueryModel model) {
    	if(!"2".equals(model.getCondition().get("type"))) {	// 查询基础指标，需要增加数据权限
    		String orgQxSql = userInfo.getDataOrgAuth("b.ORG_NO", true);
    		model.getCondition().put("sql",orgQxSql);
    	}
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = tmpInfoService.indexSelectorQuerylist(model);
		PageHelper.clearPage();
		return list;
	}
    
    /**
	 * @方法名称: queryIndexNameByIndexId
	 * @方法描述: 根据指标编号，查询指标名称，包括基础指标/派生指标
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
    @Transactional(readOnly = true)
	public String queryIndexNameByIndexId(String indexIds) {
    	return tmpInfoService.queryIndexNameByIndexId(indexIds);
    }
	
	/**
     * @函数名称:saveTemplateAndDesignData
     * @函数描述:保存模板数据及单元格信息数据
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public String saveTemplateAndDesignData(ExcelDataModel excelDataModel) throws Exception {
		try {
			// 判断考核方案编号非空，为空不允许保存数据
			if(StringUtil.isNotEmpty(excelDataModel.getSchemeId())) {
				String schemeId = excelDataModel.getSchemeId();
				// 1、保存-考核方案报表模板信息表数据
				PmaFschemeExcelTmpInfo templateInfo = new PmaFschemeExcelTmpInfo();
				templateInfo.setSchemeId(schemeId);
				templateInfo.setTemplateType(excelDataModel.getTemplateType());
				templateInfo.setTemplateContentjson(excelDataModel.getTemplateJson());
				templateInfo.setEvlObjType(excelDataModel.getEvlObjType());
				boolean isNewTemplate = false;
				if(StringUtil.isEmpty(excelDataModel.getTemplateId())) {
					isNewTemplate = true;
					tmpInfoService.insertSelective(templateInfo);
				} else {
					isNewTemplate = false;
					templateInfo.setTemplateId(excelDataModel.getTemplateId());
					tmpInfoService.updateSelective(templateInfo);
				}
				String templateId = templateInfo.getTemplateId();
				// 2、根据模板ID(如果是新增的模板跳过此步)
				// 删除-考核方案报表单元格信息表、考核方案报表考核对象信息表、考核方案报表基础指标信息表、考核方案报表派生指标信息表、考核方案报表公式信息表
				//    考核方案报表机构参数信息表、考核方案报表岗位参数信息表、考核方案报表得分/计价/权重信息表
				//    考核方案报表岗位信息表、考核方案报表考核/归属机构信息表、考核方案报表考核对象编号信息表中数据
				if(!isNewTemplate) {
					cellInfoService.deleteByTemplateId(templateId);
					objInfoService.deleteByTemplateId(templateId);
					indexInfoService.deleteByTemplateId(templateId);
					evlindexInfoService.deleteByTemplateId(templateId);
					formulaInfService.deleteByTemplateId(templateId);
					orgparamInfService.deleteByTemplateId(templateId);
					pstparamInfService.deleteByTemplateId(templateId);
					svwInfService.deleteByTemplateId(templateId);
					dutyInfService.deleteByTemplateId(templateId);
					orgInfService.deleteByTemplateId(templateId);
					objIdInfService.deleteByTemplateId(templateId);
				}
				// 获取单元格数据集
				String designData = excelDataModel.getDesignData();
				JSONObject designObj = JSONObject.parseObject(designData);
				JSONArray commonArray = designObj.getJSONArray("commonArray");
				JSONArray evalobjArray = designObj.getJSONArray("evalobjArray");
				JSONArray idxArray = designObj.getJSONArray("idxArray");
				JSONArray evlidxArray = designObj.getJSONArray("evlidxArray");
				JSONArray formulaArray = designObj.getJSONArray("formulaArray");
				JSONArray orgParamArray = designObj.getJSONArray("orgParamArray");
				JSONArray postParamArray = designObj.getJSONArray("postParamArray");
				JSONArray svwArray = designObj.getJSONArray("svwArray");
				JSONArray dutyArray = designObj.getJSONArray("dutyArray");
				JSONArray orgArray = designObj.getJSONArray("orgArray");
				JSONArray objIdArray = designObj.getJSONArray("objIdArray");
				// 3、生成数据集，并批量保存数据
				// 涉及表： 考核方案报表单元格信息表、考核方案报表考核对象信息表、考核方案报表基础指标信息表、考核方案报表派生指标信息表、
				//       考核方案报表公式信息表、考核方案报表机构参数信息表、考核方案报表岗位参数信息表、考核方案报表得分/计价/权重信息表
				//       考核方案报表岗位信息表、考核方案报表考核/归属机构信息表、考核方案报表考核对象编号信息表
				List<PmaFschemeExcelCellInfo> cellInfoList = new ArrayList<PmaFschemeExcelCellInfo>();
				for(int i = 0; i < commonArray.size(); ++i) {
					String cellInfoStr = commonArray.getString(i);
					PmaFschemeExcelCellInfo cellInfo = JSONObject.parseObject(cellInfoStr, PmaFschemeExcelCellInfo.class);
					cellInfo.setTemplateId(templateId);
					cellInfoList.add(cellInfo);
				}
				List<PmaFschemeExcelObjInfo> objInfoList = new ArrayList<PmaFschemeExcelObjInfo>();
				for(int i = 0; i < evalobjArray.size(); ++i) {
					String objInfoStr = evalobjArray.getString(i);
					PmaFschemeExcelObjInfo objInfo = JSONObject.parseObject(objInfoStr, PmaFschemeExcelObjInfo.class);
					objInfo.setTemplateId(templateId);
					objInfoList.add(objInfo);
				}
				List<PmaFschemeExcelIndexInfo> indexInfoList = new ArrayList<PmaFschemeExcelIndexInfo>();
				for(int i = 0; i < idxArray.size(); ++i) {
					String idxInfoStr = idxArray.getString(i);
					PmaFschemeExcelIndexInfo indexInfo = JSONObject.parseObject(idxInfoStr, PmaFschemeExcelIndexInfo.class);
					indexInfo.setTemplateId(templateId);
					indexInfoList.add(indexInfo);
				}
				List<PmaFschemeExcelEvlindexInfo> evlindexInfoList = new ArrayList<PmaFschemeExcelEvlindexInfo>();
				for(int i = 0; i < evlidxArray.size(); ++i) {
					String evlidxInfoStr = evlidxArray.getString(i);
					PmaFschemeExcelEvlindexInfo evlindexInfo = JSONObject.parseObject(evlidxInfoStr, PmaFschemeExcelEvlindexInfo.class);
					evlindexInfo.setTemplateId(templateId);
					evlindexInfoList.add(evlindexInfo);
				}
				List<PmaFschemeExcelFormulaInf> formulaInfoList = new ArrayList<PmaFschemeExcelFormulaInf>();
				for(int i = 0; i < formulaArray.size(); ++i) {
					String formulaInfoStr = formulaArray.getString(i);
					PmaFschemeExcelFormulaInf formulaInfo = JSONObject.parseObject(formulaInfoStr, PmaFschemeExcelFormulaInf.class);
					formulaInfo.setTemplateId(templateId);
					formulaInfoList.add(formulaInfo);
				}
				List<PmaFschemeExcelorgparamInf> orgparamInfList = new ArrayList<PmaFschemeExcelorgparamInf>();
				for(int i = 0; i < orgParamArray.size(); ++i) {
					String orgParamStr = orgParamArray.getString(i);
					PmaFschemeExcelorgparamInf orgparamInf = JSONObject.parseObject(orgParamStr, PmaFschemeExcelorgparamInf.class);
					orgparamInf.setTemplateId(templateId);
					orgparamInfList.add(orgparamInf);
				}
				List<PmaFschemeExcelpstparamInf> pstparamInfList = new ArrayList<PmaFschemeExcelpstparamInf>();
				for(int i = 0; i < postParamArray.size(); ++i) {
					String pstParamStr = postParamArray.getString(i);
					PmaFschemeExcelpstparamInf pstparamInf = JSONObject.parseObject(pstParamStr, PmaFschemeExcelpstparamInf.class);
					pstparamInf.setTemplateId(templateId);
					pstparamInfList.add(pstparamInf);
				}
				List<PmaFschemeExcelsvwInf> svwInfoList = new ArrayList<PmaFschemeExcelsvwInf>();
				for(int i = 0; i < svwArray.size(); ++i) {
					String svwInfoStr = svwArray.getString(i);
					PmaFschemeExcelsvwInf svwInfo = JSONObject.parseObject(svwInfoStr, PmaFschemeExcelsvwInf.class);
					svwInfo.setTemplateId(templateId);
					svwInfoList.add(svwInfo);
				}
				List<PmaFschemeExceldutyInf> dutyInfoList = new ArrayList<PmaFschemeExceldutyInf>();
				for(int i = 0; i < dutyArray.size(); ++i) {
					String dutyInfoStr = dutyArray.getString(i);
					PmaFschemeExceldutyInf dutyInfo = JSONObject.parseObject(dutyInfoStr, PmaFschemeExceldutyInf.class);
					dutyInfo.setTemplateId(templateId);
					dutyInfoList.add(dutyInfo);
				}
				List<PmaFschemeExcelorgInf> orgInfoList = new ArrayList<PmaFschemeExcelorgInf>();
				for(int i = 0; i < orgArray.size(); ++i) {
					String orgInfoStr = orgArray.getString(i);
					PmaFschemeExcelorgInf orgInfo = JSONObject.parseObject(orgInfoStr, PmaFschemeExcelorgInf.class);
					orgInfo.setTemplateId(templateId);
					orgInfoList.add(orgInfo);
				}
				List<PmaFschemeExcelobjidInf> objIdInfoList = new ArrayList<PmaFschemeExcelobjidInf>();
				for(int i = 0; i < objIdArray.size(); ++i) {
					String objIdInfoStr = objIdArray.getString(i);
					PmaFschemeExcelobjidInf objIdInfo = JSONObject.parseObject(objIdInfoStr, PmaFschemeExcelobjidInf.class);
					objIdInfo.setTemplateId(templateId);
					objIdInfoList.add(objIdInfo);
				}
				// 执行批量保存操作
				cellInfoService.batchInsert(cellInfoList);
				objInfoService.batchInsert(objInfoList);
				indexInfoService.batchInsert(indexInfoList);
				evlindexInfoService.batchInsert(evlindexInfoList);
				formulaInfService.batchInsert(formulaInfoList);
				orgparamInfService.batchInsert(orgparamInfList);
				pstparamInfService.batchInsert(pstparamInfList);
				svwInfService.batchInsert(svwInfoList);
				dutyInfService.batchInsert(dutyInfoList);
				orgInfService.batchInsert(orgInfoList);
				objIdInfService.batchInsert(objIdInfoList);
				// 4、删除-考核方案与指标关系表中对应考核方案ID的数据，之后遍历indexInfoList、evlindexInfoList数据并批量保存-考核方案与指标关系表数据
				pmaFSchemeIndexRelService.deleteBySchemeId(schemeId);
				if(indexInfoList.size() > 0) {
					List<PmaFSchemeIndexRel> indexRelList = new ArrayList<PmaFSchemeIndexRel>();
					List<String> indexIdList = new ArrayList<String>();
					for(PmaFschemeExcelIndexInfo item: indexInfoList) {
						if(StringUtil.isNotEmpty(item.getIndexId()) && !indexIdList.contains(item.getIndexId())) {	// 排除重复的基础指标编号
							PmaFSchemeIndexRel relInfo = new PmaFSchemeIndexRel();
							relInfo.setSchemeId(schemeId);
							relInfo.setIndexId(item.getIndexId());
							relInfo.setIndexType("01");	// 01基础指标
							relInfo.setBalTypeId(item.getBalType());
							relInfo.setEvlObjType(item.getEvlObjType());
							relInfo.setApplyTypeId(item.getApplyType());
							indexRelList.add(relInfo);
							indexIdList.add(item.getIndexId());
						}
					}
					pmaFSchemeIndexRelService.batchInsert(indexRelList);
				}
				if(evlindexInfoList.size() > 0) {
					List<PmaFSchemeIndexRel> evlindexRelList = new ArrayList<PmaFSchemeIndexRel>();
					List<String> evlindexIdList = new ArrayList<String>();
					for(PmaFschemeExcelEvlindexInfo item: evlindexInfoList) {
						if(StringUtil.isNotEmpty(item.getEvlindexId()) && !evlindexIdList.contains(item.getEvlindexId())) {	// 排除重复的派生指标编号
							PmaFSchemeIndexRel relInfo = new PmaFSchemeIndexRel();
							relInfo.setSchemeId(schemeId);
							relInfo.setIndexId(item.getEvlindexId());
							relInfo.setIndexType("02");	// 02派生指标
							// 派生指标-维度信息默认为01
							relInfo.setBalTypeId("01");
							relInfo.setEvlObjType("01");
							relInfo.setApplyTypeId("01");
							evlindexRelList.add(relInfo);
							evlindexIdList.add(item.getEvlindexId());
						}
					}
					pmaFSchemeIndexRelService.batchInsert(evlindexRelList);
				}
				return templateId;
			} else {
				logger.warn("schemeId is null, can not save");
				return "-9";
			}
		} catch (Exception e) {
    		logger.error("service saveTemplateAndDesignData error !");
    		e.printStackTrace();
    		throw e;
    	}
	}

	/**
     * @函数名称:getDesignInfoBySchemeId
     * @函数描述:根据考核方案ID，查询excel设计器信息
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public Map<String, Object> getDesignInfoBySchemeId(String schemeId) throws Exception {
		try {
			if(StringUtil.isNotEmpty(schemeId)) {	// 考核方案ID非空，允许查询
				Map<String, Object> retMap = new HashMap<String, Object>();
				// 1、查询-考核方案报表模板信息表数据
				PmaFschemeExcelTmpInfo tmpInfo = tmpInfoService.getTmpInfoBySchemeId(schemeId);
				if(tmpInfo == null) {
					logger.warn("schemeId " + schemeId + " is not exist");
					return null;
				}
				// 2、分别查询-一般单元格、考核对象、基础指标、派生指标、公式、机构参数、岗位参数、得分/计价/权重数据、岗位数据、所属机构
				String templateId = tmpInfo.getTemplateId();
				List<PmaFschemeExcelCellInfo> commonCellInfoList = cellInfoService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> objCellInfoList = objInfoService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> indexCellInfoList = indexInfoService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> evlindexCellInfoList = evlindexInfoService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> formulaCellInfoList = formulaInfService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> orgparamCellInfoList = orgparamInfService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> pstparamCellInfoList = pstparamInfService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> svwCellInfoList = svwInfService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> dutyCellInfoList = dutyInfService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> orgCellInfoList = orgInfService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> objIdCellInfoList = objIdInfService.getCellInfoByTemplateId(templateId);
				// 3、构造retMap
				retMap.put("tmpInfo", tmpInfo);
				retMap.put("commonArray", commonCellInfoList);
				retMap.put("evalobjArray", objCellInfoList);
				retMap.put("idxArray", indexCellInfoList);
				retMap.put("evlidxArray", evlindexCellInfoList);
				retMap.put("formulaArray", formulaCellInfoList);
				retMap.put("orgParamArray", orgparamCellInfoList);
				retMap.put("postParamArray", pstparamCellInfoList);
				retMap.put("svwArray", svwCellInfoList);
				retMap.put("dutyArray", dutyCellInfoList);
				retMap.put("orgArray", orgCellInfoList);
				retMap.put("objIdArray", objIdCellInfoList);
				return retMap;
			} else {
				logger.warn("schemeId is null, can not getDesignInfo");
				return null;
			}
		} catch (Exception e) {
			logger.error("service getDesignInfoBySchemeId error !");
			e.printStackTrace();
			throw e;
		}
	}

	/**
     * @函数名称:getEvlObjBySchemeId
     * @函数描述:根据考核方案ID，查询该考核方案所有考核对象数据
     * @参数与返回说明:
     * {
     *   id: '',  考核对象编号
     *   pId: '03',	默认值03，表示上级节点id
     *   name: '',  考核对象名称
     *   type: '1'  默认值1，表示叶子节点
     * }
     * @算法描述:
     */
	public List<Map<String, Object>> getEvlObjBySchemeId(String schemeId) {
		try {
			if(StringUtil.isNotEmpty(schemeId)) {	// 考核方案ID非空，允许查询
				return pmaFSchemeEvlobjRelMapper.getEvlObjBySchemeId(schemeId);
			} else {
				logger.warn("schemeId is null, can not getEvlObjBySchemeId");
				return null;
			}
		} catch (Exception e) {
			logger.error("service getEvlObjBySchemeId error !");
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
     * @函数名称:getPreviewInfo
     * @函数描述:获取方案预览数据
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public Map<String, Object> getPreviewInfo(String schemeId, String etlDate, String evlObjId) throws Exception {
		try {
			if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate)) {	// 考核方案ID非空、数据日期非空，允许查询
				Map<String, Object> retMap = new HashMap<String, Object>();
				// 1、查询-考核方案报表模板信息表数据
				PmaFschemeExcelTmpInfo tmpInfo = tmpInfoService.getTmpInfoBySchemeId(schemeId);
				if(tmpInfo == null) {
					logger.warn("schemeId " + schemeId + " is not exist");
					return null;
				}
				String templateId = tmpInfo.getTemplateId();
				String templateType = tmpInfo.getTemplateType();
				String evlObjType = tmpInfo.getEvlObjType();
				// 2、分别查询-一般单元格、考核对象、基础指标、派生指标、机构/岗位参数、公式、得分/计价/权重、岗位、所属机构、考核对象编号数据
				// 一般单元格、考核对象、公式、得分/计价/权重、考核对象编号的数据与查询设计器数据保持一致
				// 基础指标、派生指标、岗位、所属机构数据需要查询具体数据日期(考核对象)的实际值
				// 机构/岗位参数数据需要根据参数取数规则，查询对应考核对象的参数值
				List<PmaFschemeExcelCellInfo> commonCellInfoList = cellInfoService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> objCellInfoList = objInfoService.getCellInfoByTemplateId(templateId);
//				List<Map<String, Object>> evlindexCellInfoList = evlindexInfoService.getCellInfoByTemplateId(templateId);  TODO
				List<Map<String, Object>> formulaCellInfoList = formulaInfService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> svwCellInfoList = svwInfService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> objIdCellInfoList = objIdInfService.getCellInfoByTemplateId(templateId);
				List<Map<String, Object>> indexCellInfoList = null;
				List<Map<String, Object>> evlindexCellInfoList = null;
				List<Map<String, Object>> orgparamCellInfoList = null;
				List<Map<String, Object>> pstparamCellInfoList = null;
				List<Map<String, Object>> dutyCellInfoList = null;
				List<Map<String, Object>> orgCellInfoList = null;
				if("02".equals(templateType)) {	// 针对单元格类型的考核方案，考核对象编号不能为空
					if(StringUtil.isNotEmpty(evlObjId)) {
						indexCellInfoList = indexInfoService.getPreviewInfo(templateId, etlDate, evlObjId, templateType);
						evlindexCellInfoList = evlindexInfoService.getPreviewInfo(templateId, etlDate, evlObjId, templateType);
						orgparamCellInfoList = orgparamInfService.getPreviewInfo(templateId, evlObjType, evlObjId);
						pstparamCellInfoList = pstparamInfService.getPreviewInfo(templateId, evlObjType, evlObjId);
						dutyCellInfoList = dutyInfService.getPreviewInfo(templateId, etlDate, evlObjId, templateType);
						orgCellInfoList = orgInfService.getPreviewInfo(templateId, etlDate, evlObjId, templateType, evlObjType);
					} else {
						logger.warn("evlObjId is null, can not find index/orgparam cellinfo, schemeId:" + schemeId + "; etlDate:" + etlDate);
					}
				} else {	// 横/纵向类型的考核方案，考核对象编号传空
					indexCellInfoList = indexInfoService.getPreviewInfo(templateId, etlDate, "", templateType);
					evlindexCellInfoList = evlindexInfoService.getPreviewInfo(templateId, etlDate, "", templateType);
					orgparamCellInfoList = orgparamInfService.getPreviewInfo(templateId, evlObjType, "");
					pstparamCellInfoList = pstparamInfService.getPreviewInfo(templateId, evlObjType, "");
					dutyCellInfoList = dutyInfService.getPreviewInfo(templateId, etlDate, "", templateType);
					orgCellInfoList = orgInfService.getPreviewInfo(templateId, etlDate, "", templateType, evlObjType);
				}
				
				// 临时使用-后台加工单元格数据方式
				String contentJson = DesignAnalysisFactory.createAnalysis(tmpInfo.getTemplateContentjson(), tmpInfo, commonCellInfoList, 
						objCellInfoList, indexCellInfoList, evlindexCellInfoList, formulaCellInfoList, 
						orgparamCellInfoList, pstparamCellInfoList, svwCellInfoList, dutyCellInfoList, 
						orgCellInfoList, objIdCellInfoList).analysisSourceInfo();
				tmpInfo.setTemplateContentjson(contentJson);
				
				// 3、构造retMap
				retMap.put("tmpInfo", tmpInfo);
				
//				retMap.put("tmpInfo", tmpInfo);
//				retMap.put("commonArray", commonCellInfoList);
//				retMap.put("evalobjArray", objCellInfoList);
//				retMap.put("idxArray", indexCellInfoList);
//				retMap.put("evlidxArray", evlindexCellInfoList);
//				retMap.put("formulaArray", formulaCellInfoList);
//				retMap.put("orgParamArray", orgparamCellInfoList);
//				retMap.put("postParamArray", pstparamCellInfoList);
//				retMap.put("svwArray", svwCellInfoList);
				return retMap;
			} else {
				logger.warn("schemeId or etlDate is null, can not getPreviewInfo");
				return null;
			}
		} catch (Exception e) {
			logger.error("service getPreviewInfo error !");
			e.printStackTrace();
			throw e;
		}
	}

	/**
     * @函数名称:runScheme
     * @函数描述:运行考核方案
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Integer runScheme(ExcelRunModel excelRunModel) throws Exception {
		try {
			Integer code = 0;
			String schemeId = excelRunModel.getSchemeId();
			String etlDate = excelRunModel.getEtlDate();
			// 考核方案ID非空、数据日期非空，允许运行
			if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate) && 
					CommonExcelUtil.verifyDateStrByFormat(etlDate, "yyyyMMdd")) {
				// 查询-考核方案报表模板信息表数据
				PmaFschemeExcelTmpInfo tmpInfo = tmpInfoService.getTmpInfoBySchemeId(schemeId);
				if(tmpInfo == null) {
					logger.warn("schemeId " + schemeId + " is not exist");
					return -9;
				}
				String templateId = tmpInfo.getTemplateId();
				String templateType = tmpInfo.getTemplateType();
				String evlObjType = tmpInfo.getEvlObjType();
				// 多线程运行考核方案
				runThreadManager.process(schemeId, templateId, templateType, evlObjType, etlDate, tmpInfo, 
						StringUtil.isNotEmpty(excelRunModel.getEtlFlag()) ? "1" : "0");
			} else {
				logger.warn("schemeId etlDate is null, or etlDate format error, can not runScheme");
				return -9;
			}
			return code;
		} catch (Exception e) {
    		logger.error("service runScheme error !");
    		e.printStackTrace();
    		throw e;
    	}
	}
	
	/**
     * @函数名称:checkRunResultInfo
     * @函数描述:校验方案运行结果数据是否存在
     * @参数与返回说明:
     *   0  考核方案在该数据日期(考核对象)已运行
     *   -1 考核方案在该数据日期(考核对象)未运行
     *   -9 请求参数错误
     * @算法描述:
     * 从方案运行的备份表中校验方案运行结果数据是否存在
     */
	@Transactional(readOnly = true)
	public Integer checkRunResultInfo(String schemeId, String etlDate, String evlObjId) throws Exception {
		try {
			if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate) && 
					CommonExcelUtil.verifyDateStrByFormat(etlDate, "yyyyMMdd")) {	// 考核方案ID非空、数据日期非空，允许查询
				// 1、查询-考核方案报表模板信息表(备份表)数据数量
				Integer tmpInfoCount = tmpInfoService.getBackupTableDataCount(schemeId, etlDate);
				if(tmpInfoCount > 0) {	// 模板信息表(备份表)中数据存在，查询基础指标信息表(备份表)数据数量
					PmaFschemeExcelTmpInfo tmpInfo = tmpInfoService.getTmpInfoFromBackupTableBySchemeIdAndEtlDate(schemeId, etlDate);
					String templateId = tmpInfo.getTemplateId();
					String templateType = tmpInfo.getTemplateType();
					// 单元格类型考核方案，需要校验-考核对象编号是否存在
					if("02".equals(templateType) && StringUtil.isEmpty(evlObjId)) {
						logger.warn("evlObjId is null for schemeId " + schemeId + ", can not checkRunResultInfo");
						return -9;
					}
					Integer indexInfoCount = 0;
					// 2、获取基础指标信息表(备份表)数据数量
					if("02".equals(templateType)) {	// 单元格类型考核方案，需要传考核对象编号
						indexInfoCount = indexInfoService.getIndexInfoCountFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, evlObjId);
					} else {
						indexInfoCount = indexInfoService.getIndexInfoCountFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, "");
					}
					// 3、构造返回值
					if(indexInfoCount > 0) {
						return 0;
					} else if(indexInfoCount == 0) {
						return -1;
					} else {
						return -9;
					}
				} else if(tmpInfoCount == 0) {	// 未查到数据
					return -1;
				} else {
					return -9;
				}
			} else {
				logger.warn("schemeId is null or etlDate format error, can not checkRunResultInfo");
				return -9;
			}
		} catch (Exception e) {
			logger.error("service checkRunResultInfo error !");
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
     * @函数名称:getRunResultInfo
     * @函数描述:获取方案运行结果数据
     * @参数与返回说明:
     * @算法描述:
     * 从方案运行的备份表中获取方案运行结果数据
     */
	@Transactional(readOnly = true)
	public Map<String, Object> getRunResultInfo(String schemeId, String etlDate, String evlObjId) throws Exception {
		try {
			if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate) && 
					CommonExcelUtil.verifyDateStrByFormat(etlDate, "yyyyMMdd")) {	// 考核方案ID非空、数据日期非空，允许查询
				Map<String, Object> retMap = new HashMap<String, Object>();
				// 1、查询-考核方案报表模板信息表(备份表)数据
				PmaFschemeExcelTmpInfo tmpInfo = tmpInfoService.getTmpInfoFromBackupTableBySchemeIdAndEtlDate(schemeId, etlDate);
				if(tmpInfo == null) {
					logger.warn("schemeId:" + schemeId + ", etlDate:" + etlDate + " is not exist in backup table PMA_F_SCHEME_EXCELTMP_BAK");
					return null;
				}
				String templateId = tmpInfo.getTemplateId();
				String templateType = tmpInfo.getTemplateType();
				// 单元格类型考核方案，需要校验-考核对象编号是否存在
				if("02".equals(templateType) && StringUtil.isEmpty(evlObjId)) {
					logger.warn("evlObjId is null for schemeId " + schemeId + ", can not getRunResultInfo");
					return null;
				}
				// 2、分别查询-一般单元格、考核对象、基础指标、派生指标、公式数据(从对应备份表)
				// 一般单元格、考核对象的数据与查询设计器数据保持一致
				// 基础指标、派生指标、公式数据、机构参数、岗位参数需要查询指标值(考核对象)，且RESULT_VALUE字段对应基础指标/公式计算后的值
				// 岗位、所属机构、考核对象编号的数据保持不变
				List<PmaFschemeExcelCellInfo> commonCellInfoList = cellInfoService.getCellInfoFromBackupTableByTemplateIdAndEtlDate(templateId, etlDate);
				List<Map<String, Object>> objCellInfoList = null;
				List<Map<String, Object>> formulaCellInfoList = null;
				List<Map<String, Object>> indexCellInfoList = null;
				List<Map<String, Object>> evlindexCellInfoList = null;
				List<Map<String, Object>> orgparamCellInfoList = null;
				List<Map<String, Object>> pstparamCellInfoList = null;
				List<Map<String, Object>> svwCellInfoList = null;
				List<Map<String, Object>> dutyCellInfoList = null;
				List<Map<String, Object>> orgCellInfoList = null;
				List<Map<String, Object>> objIdCellInfoList = null;
				if(!"02".equals(templateType)) {	// 非单元格类型的考核方案，需要查询考核对象单元格数据
					objCellInfoList = objInfoService.getCellInfoFromBackupTableByTemplateIdAndEtlDate(templateId, etlDate);
					formulaCellInfoList = formulaInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, "");
					indexCellInfoList = indexInfoService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, "");
					evlindexCellInfoList = evlindexInfoService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, "");
					orgparamCellInfoList = orgparamInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, "");
					pstparamCellInfoList = pstparamInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, "");
					svwCellInfoList = svwInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, "");
					dutyCellInfoList = dutyInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, "");
					orgCellInfoList = orgInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, "");
					objIdCellInfoList = objIdInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, "");
				} else {	// 单元格类型的考核方案，需要按照考核对象查询基础指标、公式单元格数据
					formulaCellInfoList = formulaInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, evlObjId);
					indexCellInfoList = indexInfoService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, evlObjId);
					evlindexCellInfoList = evlindexInfoService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, evlObjId);
					orgparamCellInfoList = orgparamInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, evlObjId);
					pstparamCellInfoList = pstparamInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, evlObjId);
					svwCellInfoList = svwInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, evlObjId);
					dutyCellInfoList = dutyInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, evlObjId);
					orgCellInfoList = orgInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, evlObjId);
					objIdCellInfoList = objIdInfService.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, evlObjId);
				}
				// 3、根据schemeId,etlDate查询考核方案隐藏行列信息
				PmaFschemeExcelhideInf hideInf = hideInfService.getHideInfoBySchemeIdAndEtlDate(schemeId, etlDate);
				Map<String, Object> hideInfo = new HashMap<String, Object>();
				if(hideInf != null) {
					hideInfo.put("cols", hideInf.getHideColsIndex() != null ? hideInf.getHideColsIndex() : null);
					hideInfo.put("rows", hideInf.getHideRows() != null ? hideInf.getHideRows() : null);
				}
				
				// 临时使用-后台加工单元格数据方式
				String contentJson = DesignAnalysisFactory.createAnalysis(tmpInfo.getTemplateContentjson(), tmpInfo, commonCellInfoList, 
						objCellInfoList, indexCellInfoList, evlindexCellInfoList, formulaCellInfoList, 
						orgparamCellInfoList, pstparamCellInfoList, svwCellInfoList, 
						dutyCellInfoList, orgCellInfoList, objIdCellInfoList).analysisSourceInfo();
				tmpInfo.setTemplateContentjson(contentJson);
				
				// 4、构造retMap
				retMap.put("tmpInfo", tmpInfo);
				retMap.put("hideInfo", hideInfo);
				
//				retMap.put("tmpInfo", tmpInfo);
//				retMap.put("commonArray", commonCellInfoList);
//				retMap.put("evalobjArray", objCellInfoList);
//				retMap.put("idxArray", indexCellInfoList);
//				retMap.put("evlidxArray", evlindexCellInfoList);
//				retMap.put("formulaArray", formulaCellInfoList);
//				retMap.put("orgParamArray", orgparamCellInfoList);
//				retMap.put("postParamArray", pstparamCellInfoList);
//				retMap.put("svwArray", svwCellInfoList);
//				retMap.put("hideInfo", hideInfo);
				return retMap;
			} else {
				logger.warn("schemeId is null or etlDate format error, can not getRunResultInfo");
				return null;
			}
		} catch (Exception e) {
			logger.error("service getRunResultInfo error !");
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
     * @函数名称:getSchemeRunInfoList
     * @函数描述:考核方案运行状态信息列表查询接口
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getSchemeRunInfoList(QueryModel queryModel) throws Exception {
		List<Map<String, Object>> list = runInfoService.getSchemeRunInfoList(queryModel);
		return list;
	}
	
	/**
     * @函数名称:pubScheme
     * @函数描述:发布考核方案
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Integer pubScheme(ExcelPublishModel excelPublishModel) throws Exception {
		try {
			Integer code = 0;
			String runId = excelPublishModel.getRunId();
			String hideInfId = excelPublishModel.getHideInfId();
			String schemeId = excelPublishModel.getSchemeId();
			String etlDate = excelPublishModel.getEtlDate();
			// 考核方案报表运行信息表-主键值、考核方案发布隐藏行列信息表-主键值、考核方案ID非空、数据日期非空，允许发布
			if(StringUtil.isNotEmpty(runId) && (StringUtil.isNotEmpty(hideInfId) || (StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate) && 
					CommonExcelUtil.verifyDateStrByFormat(etlDate, "yyyyMMdd")))) {
				// 1、根据runId，更新-考核方案报表运行信息表-发布状态值为1已发布
				PmaFschemeExcelrunInfo runInfo = runInfoService.selectByPrimaryKey(runId);
				if(!"1".equals(runInfo.getPubStatus())) {
					runInfo.setPubStatus("1");
					runInfoService.updateSelective(runInfo);
				}
				// 2、根据考核方案发布隐藏行列信息表-主键值 or 考核方案编号/数据日期，维护-考核方案报表发布隐藏行列信息表数据
				PmaFschemeExcelhideInf hideInf = null;
				if(StringUtil.isNotEmpty(hideInfId)) {
					hideInf = hideInfService.selectByPrimaryKey(hideInfId);
				} else {
					hideInf = hideInfService.getHideInfoBySchemeIdAndEtlDate(schemeId, etlDate);
				}
				if(hideInf == null) {
					hideInf = new PmaFschemeExcelhideInf();
					hideInf.setSchemeId(schemeId);
					hideInf.setEtlDate(etlDate);
					hideInf.setHideCols(excelPublishModel.getHideCols());
					hideInf.setHideColsIndex(excelPublishModel.getHideColsIndex());
					hideInf.setHideRows(excelPublishModel.getHideRows());
					hideInfService.insertSelective(hideInf);
				} else {
					hideInf.setHideCols(excelPublishModel.getHideCols());
					hideInf.setHideColsIndex(excelPublishModel.getHideColsIndex());
					hideInf.setHideRows(excelPublishModel.getHideRows());
					hideInfService.updateSelective(hideInf);
				}
			} else {
				logger.warn("runId schemeId etlDate is null, or etlDate format error, can not pubScheme");
				return -9;
			}
			return code;
		} catch (Exception e) {
    		logger.error("service pubScheme error !");
    		e.printStackTrace();
    		throw e;
    	}
	}
	
	/**
     * @函数名称:getSchemeHideInfo
     * @函数描述:考核方案发布隐藏行列信息查询接口
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public PmaFschemeExcelhideInf getSchemeHideInfo(String schemeId, String etlDate) throws Exception {
		return hideInfService.getHideInfoBySchemeIdAndEtlDate(schemeId, etlDate);
	}
	
    /**
     * @函数名称:getMySchemeInfoList
     * @函数描述:获取我的考核方案列表数据
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getMySchemeInfoList(QueryModel queryModel) throws Exception {
		List<Map<String, Object>> list = runInfoService.getMySchemeInfoList(queryModel);
		return list;
	}
	
	/**
     * @函数名称:getMySchemeResultInfo
     * @函数描述:获取我的考核方案运行结果数据
     * @参数与返回说明:
     * @算法描述:
     * 从方案运行的备份表中获取我的考核方案运行结果数据
     */
	@Transactional(readOnly = true)
	public Map<String, Object> getMySchemeResultInfo(String schemeId, String etlDate) throws Exception {
		try {
			if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate) && 
					CommonExcelUtil.verifyDateStrByFormat(etlDate, "yyyyMMdd")) {	// 考核方案ID非空、数据日期非空，允许查询
				Map<String, Object> retMap = new HashMap<String, Object>();
				// 1、查询-考核方案报表模板信息表(备份表)数据
				PmaFschemeExcelTmpInfo tmpInfo = tmpInfoService.getTmpInfoFromBackupTableBySchemeIdAndEtlDate(schemeId, etlDate);
				if(tmpInfo == null) {
					logger.warn("schemeId:" + schemeId + ", etlDate:" + etlDate + " is not exist in backup table PMA_F_SCHEME_EXCELTMP_BAK");
					return null;
				}
				String templateId = tmpInfo.getTemplateId();
				String templateType = tmpInfo.getTemplateType();
				String evlObjType = tmpInfo.getEvlObjType();
				String evlObjId = "";
				if("01".equals(evlObjType)) {	// 员工
					evlObjId = userInfo.getUserInfo().getLoginCode();
				} else if("02".equals(evlObjType) || "03".equals(evlObjType)) {	// 机构(人)、机构(业务、账面)
					evlObjId = userInfo.getUserInfo().getOrg().getCode();
				}
				// 2、根据schemeId,etlDate查询考核方案隐藏行列信息
				PmaFschemeExcelhideInf hideInf = hideInfService.getHideInfoBySchemeIdAndEtlDate(schemeId, etlDate);
				String hideRows = "";
				String hideCols = "";
				if(hideInf != null) {
					hideRows = hideInf.getHideRows() != null ? hideInf.getHideRows() : "";
					hideCols = hideInf.getHideColsIndex() != null ? hideInf.getHideColsIndex() : "";
				}
				
				// 3、分别查询-一般单元格、考核对象、基础指标、派生指标、公式、机构参数、岗位参数、得分/计价/权重数据(从对应备份表)
				// 一般单元格、考核对象的数据与查询设计器数据保持一致
				// 基础指标、派生指标、公式数据、机构参数、岗位参数、得分/计价/权重需要查询指标值(考核对象)，且RESULT_VALUE字段对应基础指标或公式内容或参数规则计算后的值
				// 岗位、所属机构、考核对象编号直接查询备份表数据
				List<PmaFschemeExcelCellInfo> commonCellInfoList = cellInfoService.getMySchemeCellInfoFromBackupTable(templateId, etlDate, hideRows, hideCols);
				List<Map<String, Object>> objCellInfoList = null;
				List<Map<String, Object>> formulaCellInfoList = null;
				List<Map<String, Object>> indexCellInfoList = null;
				List<Map<String, Object>> evlindexCellInfoList = null;
				List<Map<String, Object>> orgparamCellInfoList = null;
				List<Map<String, Object>> pstparamCellInfoList = null;
				List<Map<String, Object>> svwCellInfoList = null;
				List<Map<String, Object>> dutyCellInfoList = null;
				List<Map<String, Object>> orgCellInfoList = null;
				List<Map<String, Object>> objIdCellInfoList = null;
				formulaCellInfoList = formulaInfService.getMySchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				indexCellInfoList = indexInfoService.getMySchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				evlindexCellInfoList = evlindexInfoService.getMySchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				orgparamCellInfoList = orgparamInfService.getMySchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				pstparamCellInfoList = pstparamInfService.getMySchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				svwCellInfoList = svwInfService.getMySchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				dutyCellInfoList = dutyInfService.getMySchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				orgCellInfoList = orgInfService.getMySchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				objIdCellInfoList = objIdInfService.getMySchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				
				// 4、由于横/纵类型考核方案包含多个考核对象，针对不在权限范围内的考核对象所在行/列需要隐藏
				String hideRowIndexInf = "";	// 保存需要隐藏的其他考核对象所在行索引
				String hideColIndexInf = "";	// 保存需要隐藏的其他考核对象所在列索引
				if("04".equals(templateType) || "05".equals(templateType)) {	// 横/纵类型的考核方案
					// 获取当前登录人权限内的考核对象单元格数据
					objCellInfoList = objInfoService.getMySchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
					// 获取考核方案所有考核对象单元格数据
					List<Map<String, Object>> allObjCellInfoList = objInfoService.getCellInfoFromBackupTableByTemplateIdAndEtlDate(templateId, etlDate);
					List<String> evlObjIds = new ArrayList<String>();	// 保存当前登录人权限内的考核对象编号数据
					for(Map<String, Object> myObjCell : objCellInfoList) {
						evlObjIds.add(myObjCell.get("evlObjId") != null ? myObjCell.get("evlObjId") + "" : "");
					}
					for(Map<String, Object> objCell : allObjCellInfoList) {
						if(!evlObjIds.contains(objCell.get("evlObjId"))) {	// 不在权限内的考核对象
							if("04".equals(templateType)) {
								hideRowIndexInf += (Integer.parseInt(objCell.get("rowId") + "") + 1) + "$";
							} else if("05".equals(templateType)) {
								hideColIndexInf += objCell.get("colId") + "$";
							}
						}
					}
				}
				Map<String, Object> hideInfo = new HashMap<String, Object>();
				hideInfo.put("rows", hideRows);
				hideInfo.put("cols", hideCols);
				// 以下两个if，针对横/纵类型考核方案，增加隐藏行/列索引
				if(StringUtil.isNotEmpty(hideRowIndexInf)) {
					hideInfo.put("rows", hideInfo.get("rows") != null ? hideInfo.get("rows") + hideRowIndexInf : hideRowIndexInf);
				}
				if(StringUtil.isNotEmpty(hideColIndexInf)) {
					hideInfo.put("cols", hideInfo.get("cols") != null ? hideInfo.get("cols") + hideColIndexInf : hideColIndexInf);
				}
				
				// 临时使用-后台加工单元格数据方式
				String contentJson = DesignAnalysisFactory.createAnalysis(tmpInfo.getTemplateContentjson(), tmpInfo, commonCellInfoList, 
						objCellInfoList, indexCellInfoList, evlindexCellInfoList, formulaCellInfoList, 
						orgparamCellInfoList, pstparamCellInfoList, svwCellInfoList,
						dutyCellInfoList, orgCellInfoList, objIdCellInfoList).analysisSourceInfo();
				tmpInfo.setTemplateContentjson(contentJson);
				
				// 5、构造retMap
				retMap.put("tmpInfo", tmpInfo);
				retMap.put("hideInfo", hideInfo);
				
//				retMap.put("tmpInfo", tmpInfo);
//				retMap.put("commonArray", commonCellInfoList);
//				retMap.put("evalobjArray", objCellInfoList);
//				retMap.put("idxArray", indexCellInfoList);
//				retMap.put("evlidxArray", evlindexCellInfoList);
//				retMap.put("formulaArray", formulaCellInfoList);
//				retMap.put("orgParamArray", orgparamCellInfoList);
//				retMap.put("postParamArray", pstparamCellInfoList);
//				retMap.put("svwArray", svwCellInfoList);
//				retMap.put("hideInfo", hideInfo);
				return retMap;
			} else {
				logger.warn("schemeId is null or etlDate format error, can not getMySchemeResultInfo");
				return null;
			}
		} catch (Exception e) {
			logger.error("service getMySchemeResultInfo error !");
			e.printStackTrace();
			throw e;
		}
	}
	
    /**
     * @函数名称:getOrgStaffSchemeInfoList
     * @函数描述:获取机构辖内员工考核方案列表数据
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getOrgStaffSchemeInfoList(QueryModel queryModel) throws Exception {
		List<Map<String, Object>> list = runInfoService.getOrgStaffSchemeInfoList(queryModel);
		return list;
	}
	
	/**
     * @函数名称:getMySchemeResultInfo
     * @函数描述:获取机构辖内员工考核方案运行结果数据
     * @参数与返回说明:
     * @算法描述:
     * 从方案运行的备份表中获取机构辖内员工考核方案运行结果数据
     */
	@Transactional(readOnly = true)
	public Map<String, Object> getOrgStaffSchemeResultInfo(String schemeId, String etlDate, String evlObjId) throws Exception {
		try {
			if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate) && 
					CommonExcelUtil.verifyDateStrByFormat(etlDate, "yyyyMMdd")) {	// 考核方案ID非空、数据日期非空，允许查询
				Map<String, Object> retMap = new HashMap<String, Object>();
				// 1、查询-考核方案报表模板信息表(备份表)数据
				PmaFschemeExcelTmpInfo tmpInfo = tmpInfoService.getTmpInfoFromBackupTableBySchemeIdAndEtlDate(schemeId, etlDate);
				if(tmpInfo == null) {
					logger.warn("schemeId:" + schemeId + ", etlDate:" + etlDate + " is not exist in backup table PMA_F_SCHEME_EXCELTMP_BAK");
					return null;
				}
				String templateId = tmpInfo.getTemplateId();
				String templateType = tmpInfo.getTemplateType();
				String evlObjType = tmpInfo.getEvlObjType();
				// 2、根据schemeId,etlDate查询考核方案隐藏行列信息
				PmaFschemeExcelhideInf hideInf = hideInfService.getHideInfoBySchemeIdAndEtlDate(schemeId, etlDate);
				String hideRows = "";
				String hideCols = "";
				if(hideInf != null) {
					hideRows = hideInf.getHideRows() != null ? hideInf.getHideRows() : "";
					hideCols = hideInf.getHideColsIndex() != null ? hideInf.getHideColsIndex() : "";
				}
				
				// 3、分别查询-一般单元格、考核对象、基础指标、派生指标、公式、机构参数、岗位参数、得分/计价/权重数据(从对应备份表)
				// 一般单元格、考核对象的数据与查询设计器数据保持一致
				// 基础指标、派生指标、公式数据、机构参数、岗位参数、得分/计价/权重需要查询指标值(考核对象)，且RESULT_VALUE字段对应基础指标或公式内容或参数规则计算后的值
				// 岗位、所属机构、考核对象编号直接查询备份表数据
				List<PmaFschemeExcelCellInfo> commonCellInfoList = cellInfoService.getMySchemeCellInfoFromBackupTable(templateId, etlDate, hideRows, hideCols);
				List<Map<String, Object>> objCellInfoList = null;
				List<Map<String, Object>> formulaCellInfoList = null;
				List<Map<String, Object>> indexCellInfoList = null;
				List<Map<String, Object>> evlindexCellInfoList = null;
				List<Map<String, Object>> orgparamCellInfoList = null;
				List<Map<String, Object>> pstparamCellInfoList = null;
				List<Map<String, Object>> svwCellInfoList = null;
				List<Map<String, Object>> dutyCellInfoList = null;
				List<Map<String, Object>> orgCellInfoList = null;
				List<Map<String, Object>> objIdCellInfoList = null;
				formulaCellInfoList = formulaInfService.getOrgStaffSchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				indexCellInfoList = indexInfoService.getOrgStaffSchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				evlindexCellInfoList = evlindexInfoService.getOrgStaffSchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				orgparamCellInfoList = orgparamInfService.getOrgStaffSchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				pstparamCellInfoList = pstparamInfService.getOrgStaffSchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				svwCellInfoList = svwInfService.getOrgStaffSchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				dutyCellInfoList = dutyInfService.getOrgStaffSchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				orgCellInfoList = orgInfService.getOrgStaffSchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				objIdCellInfoList = objIdInfService.getOrgStaffSchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
				
				// 4、由于横/纵类型考核方案包含多个考核对象，针对不在权限范围内的考核对象所在行/列需要隐藏
				String hideRowIndexInf = "";	// 保存需要隐藏的其他考核对象所在行索引
				String hideColIndexInf = "";	// 保存需要隐藏的其他考核对象所在列索引
				if("04".equals(templateType) || "05".equals(templateType)) {	// 横/纵类型的考核方案
					// 获取当前登录人权限内的考核对象单元格数据
					objCellInfoList = objInfoService.getOrgStaffSchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
					// 获取考核方案所有考核对象单元格数据
					List<Map<String, Object>> allObjCellInfoList = objInfoService.getCellInfoFromBackupTableByTemplateIdAndEtlDate(templateId, etlDate);
					List<String> evlObjIds = new ArrayList<String>();	// 保存当前登录人权限内的考核对象编号数据
					for(Map<String, Object> myObjCell : objCellInfoList) {
						evlObjIds.add(myObjCell.get("evlObjId") != null ? myObjCell.get("evlObjId") + "" : "");
					}
					for(Map<String, Object> objCell : allObjCellInfoList) {
						if(!evlObjIds.contains(objCell.get("evlObjId"))) {	// 不在权限内的考核对象
							if("04".equals(templateType)) {
								hideRowIndexInf += (Integer.parseInt(objCell.get("rowId") + "") + 1) + "$";
							} else if("05".equals(templateType)) {
								hideColIndexInf += objCell.get("colId") + "$";
							}
						}
					}
				}
				Map<String, Object> hideInfo = new HashMap<String, Object>();
				hideInfo.put("rows", hideRows);
				hideInfo.put("cols", hideCols);
				// 以下两个if，针对横/纵类型考核方案，增加隐藏行/列索引
				if(StringUtil.isNotEmpty(hideRowIndexInf)) {
					hideInfo.put("rows", hideInfo.get("rows") != null ? hideInfo.get("rows") + hideRowIndexInf : hideRowIndexInf);
				}
				if(StringUtil.isNotEmpty(hideColIndexInf)) {
					hideInfo.put("cols", hideInfo.get("cols") != null ? hideInfo.get("cols") + hideColIndexInf : hideColIndexInf);
				}
				
				// 临时使用-后台加工单元格数据方式
				String contentJson = DesignAnalysisFactory.createAnalysis(tmpInfo.getTemplateContentjson(), tmpInfo, commonCellInfoList, 
						objCellInfoList, indexCellInfoList, evlindexCellInfoList, formulaCellInfoList, 
						orgparamCellInfoList, pstparamCellInfoList, svwCellInfoList,
						dutyCellInfoList, orgCellInfoList, objIdCellInfoList).analysisSourceInfo();
				tmpInfo.setTemplateContentjson(contentJson);
				
				// 5、构造retMap
				retMap.put("tmpInfo", tmpInfo);
				retMap.put("hideInfo", hideInfo);
				
//				retMap.put("tmpInfo", tmpInfo);
//				retMap.put("commonArray", commonCellInfoList);
//				retMap.put("evalobjArray", objCellInfoList);
//				retMap.put("idxArray", indexCellInfoList);
//				retMap.put("evlidxArray", evlindexCellInfoList);
//				retMap.put("formulaArray", formulaCellInfoList);
//				retMap.put("orgParamArray", orgparamCellInfoList);
//				retMap.put("postParamArray", pstparamCellInfoList);
//				retMap.put("svwArray", svwCellInfoList);
//				retMap.put("hideInfo", hideInfo);
				return retMap;
			} else {
				logger.warn("schemeId is null or etlDate format error, can not getOrgStaffSchemeResultInfo");
				return null;
			}
		} catch (Exception e) {
			logger.error("service getOrgStaffSchemeResultInfo error !");
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
     * @方法名称: getGrantInfBySchemeId
     * @方法描述: 根据考核方案ID，查询-方案授权信息
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<PmaFschemeExcelgrantInf> getGrantInfBySchemeId(QueryModel queryModel) {
    	if(queryModel.getCondition() != null && queryModel.getCondition().containsKey("schemeId")) {
    		List<PmaFschemeExcelgrantInf> list = grantInfService.getGrantInfBySchemeId(queryModel);
    		return list;
    	} else {
    		logger.warn("schemeId is null, can not getGrantInfo");
			return null;
    	}
    }
    
    /**
     * @函数名称: addGrantInf
     * @函数描述: 新增  考核方案授权信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public String addGrantInf(PmaFschemeExcelgrantInf record) throws Exception {
    	return grantInfService.addData(record);
    }
    
    /**
     * @函数名称: deleteGrantInf
     * @函数描述: 批量删除授权信息 
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer deleteGrantInf(String ids) throws Exception {
    	return grantInfService.deleteData(ids);
    }
    
    /**
     * @方法名称: getQuoteSchemeInf
     * @方法描述: 查询-可以引用的考核方案信息
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<PmaFschemeExcelgrantInf> getQuoteSchemeInf(QueryModel queryModel) {
		return grantInfService.getQuoteSchemeInf(queryModel);
    }
    
    /**
     * @函数名称: quoteSchemeInf
     * @函数描述: 引用考核方案信息 
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Integer quoteSchemeInf(ExcelQuoteModel model) throws Exception {
		try {
			Integer code = 0;
			String schemeId = model.getSchemeId();
			String menuId = model.getMenuId();
			// 考核方案编号、当前-考核方案目录编号不允许为空
			if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(menuId)) {
				// 1、复制：考核方案基础信息表、考核方案机构关系表、考核方案岗位关系表、考核方案特殊规则表、考核方案评价对象表
				String newSchemeId = schemeExcelService.copySchemeInf(schemeId, menuId);
				schemeOrgRelService.copySchemeInf(schemeId, newSchemeId);
				schemePostRelService.copySchemeInf(schemeId, newSchemeId);
				schemeSperuleRelService.copySchemeInf(schemeId, newSchemeId);
				schemeEvlobjRelService.copySchemeInf(schemeId, newSchemeId);
				// 2、获取原考核方案模板信息数据
				PmaFschemeExcelTmpInfo tmpInfo = tmpInfoService.getTmpInfoBySchemeId(schemeId);
				String templateId = tmpInfo.getTemplateId();
				// 3、复制：考核方案报表模板信息表、考核方案报表单元格信息表、考核方案报表考核对象信息表、考核方案报表基础指标信息表
				//       考核方案报表派生指标信息表、考核方案报表公式信息表、考核方案报表机构参数信息表、考核方案报表岗位参数信息表、考核方案报表得分/计价/权重信息表、
				//       考核方案报表岗位信息表、考核方案报表考核/归属机构信息表、考核方案报表考核对象编号信息表
				//       考核方案与指标关系表
				String newTemplateId = tmpInfoService.copySchemeInf(schemeId, newSchemeId);
				cellInfoService.copySchemeInf(templateId, newTemplateId);
				objInfoService.copySchemeInf(templateId, newTemplateId);
				indexInfoService.copySchemeInf(templateId, newTemplateId);
				evlindexInfoService.copySchemeInf(templateId, newTemplateId);
				formulaInfService.copySchemeInf(templateId, newTemplateId);
				orgparamInfService.copySchemeInf(templateId, newTemplateId);
				pstparamInfService.copySchemeInf(templateId, newTemplateId);
				svwInfService.copySchemeInf(templateId, newTemplateId);
				dutyInfService.copySchemeInf(templateId, newTemplateId);
				orgInfService.copySchemeInf(templateId, newTemplateId);
				objIdInfService.copySchemeInf(templateId, newTemplateId);
				pmaFSchemeIndexRelService.copySchemeInf(schemeId, newSchemeId);
			} else {
				logger.warn("schemeId or menuId is null, can not quoteSchemeInf");
				return -9;
			}
			return code;
		} catch (Exception e) {
    		logger.error("service quoteSchemeInf error !");
    		e.printStackTrace();
    		throw e;
    	}
	}

	public ResultDto<Integer> del(String ids) {
		return runInfoService.del(ids);
    }

	/**
     * @函数名称:getSchemeResultInfo
     * @函数描述:APP-查询员工/机构考核方案运行结果数据
     * @参数与返回说明:
     * @param tpye: 1员工  2机构
     * @算法描述:
     * 查询已发布的考核方案中：基础指标、派生指标、机构/岗位参数结果值
     * 员工：考核对象是当前登录人的数据
     * 机构：考核对象是当前登录人授权机构及下辖的数据
     */
	@Transactional(readOnly = true)
	public Map<String, Object> getSchemeResultInfo(String type, String schemeId, String etlDate) throws Exception {
		try {
			Map<String, Object> retMap = new HashMap<String, Object>();
			if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate) && 
					CommonExcelUtil.verifyDateStrByFormat(etlDate, "yyyyMMdd")) {	// 考核方案ID非空、数据日期非空，允许查询
				// 1、查询-考核方案报表模板信息表(备份表)数据
				PmaFschemeExcelTmpInfo tmpInfo = tmpInfoService.getTmpInfoFromBackupTableBySchemeIdAndEtlDate(schemeId, etlDate);
				if(tmpInfo == null) {
					logger.warn("schemeId:" + schemeId + ", etlDate:" + etlDate + " is not exist in backup table PMA_F_SCHEME_EXCELTMP_BAK");
					return null;
				}
				String templateId = tmpInfo.getTemplateId();
				String templateType = tmpInfo.getTemplateType();
				String evlObjType = tmpInfo.getEvlObjType();
				String evlObjId = "";
				// 2、根据schemeId,etlDate查询考核方案隐藏行列信息
				PmaFschemeExcelhideInf hideInf = hideInfService.getHideInfoBySchemeIdAndEtlDate(schemeId, etlDate);
				String hideRows = "";
				String hideCols = "";
				if(hideInf != null) {
					hideRows = hideInf.getHideRows() != null ? hideInf.getHideRows() : "";
					hideCols = hideInf.getHideColsIndex() != null ? hideInf.getHideColsIndex() : "";
				}
				if("1".equals(type)) {	// 员工考核成绩查询
					evlObjId = userInfo.getUserInfo().getLoginCode();
					List<Map<String, Object>> indexCellInfoList = null;
					List<Map<String, Object>> evlindexCellInfoList = null;
					List<Map<String, Object>> orgparamCellInfoList = null;
					List<Map<String, Object>> pstparamCellInfoList = null;
					// 分别查询 基础指标、派生指标、机构参数、岗位参数单元格数据
					indexCellInfoList = indexInfoService.getAppMySchemeResultInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
					evlindexCellInfoList = evlindexInfoService.getAppMySchemeResultInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
					orgparamCellInfoList = orgparamInfService.getAppMySchemeResultInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
					pstparamCellInfoList = pstparamInfService.getAppMySchemeResultInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
					retMap.put("idxList", indexCellInfoList);
					retMap.put("evlIdxList", evlindexCellInfoList);
					retMap.put("orgparamList", orgparamCellInfoList);
					retMap.put("pstparamList", pstparamCellInfoList);
				} else if("2".equals(type)) {	// 机构考核成绩查询
					evlObjId = userInfo.getGrantOrgCode();
					List<Map<String, Object>> indexCellInfoList = null;
					List<Map<String, Object>> evlindexCellInfoList = null;
					List<Map<String, Object>> orgparamCellInfoList = null;
					List<Map<String, Object>> pstparamCellInfoList = null;
					// 查询授权机构内考核方案-考核对象信息
					List<Map<String, Object>> evlObjInfoList = tmpInfoService.getAppOrgSchemeEvlObjInfo(schemeId, etlDate, evlObjId);
					// 分别查询 基础指标、派生指标、机构参数、岗位参数单元格数据
					indexCellInfoList = indexInfoService.getAppOrgSchemeResultInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
					evlindexCellInfoList = evlindexInfoService.getAppOrgSchemeResultInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
					orgparamCellInfoList = orgparamInfService.getAppOrgSchemeResultInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
					pstparamCellInfoList = pstparamInfService.getAppOrgSchemeResultInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType, hideRows, hideCols);
					List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
					// 遍历权限内的考核对象，生成数据
					for(Map<String, Object> evlObjInfo: evlObjInfoList) {
						Map<String, Object> evlObjResultMap = new HashMap<String, Object>();
						evlObjResultMap.put("evlObjId", evlObjInfo.get("evlObjId"));
						evlObjResultMap.put("evlObjName", evlObjInfo.get("evlObjName"));
						List<Map<String, Object>> idxList = new ArrayList<Map<String, Object>>();
						List<Map<String, Object>> evlidxList = new ArrayList<Map<String, Object>>();
						List<Map<String, Object>> orgparamList = new ArrayList<Map<String, Object>>();
						List<Map<String, Object>> pstparamList = new ArrayList<Map<String, Object>>();
						for(Map<String, Object> idxInfo: indexCellInfoList) {
							if(idxInfo.get("evlObjId").equals(evlObjInfo.get("evlObjId"))) {
								idxList.add(idxInfo);
							}
						}
						for(Map<String, Object> evlidxInfo: evlindexCellInfoList) {
							if(evlidxInfo.get("evlObjId").equals(evlObjInfo.get("evlObjId"))) {
								evlidxList.add(evlidxInfo);
							}						
						}
						for(Map<String, Object> orgparamInfo: orgparamCellInfoList) {
							if(orgparamInfo.get("evlObjId").equals(evlObjInfo.get("evlObjId"))) {
								orgparamList.add(orgparamInfo);
							}
						}
						for(Map<String, Object> pstparamInfo: pstparamCellInfoList) {
							if(pstparamInfo.get("evlObjId").equals(evlObjInfo.get("evlObjId"))) {
								pstparamList.add(pstparamInfo);
							}
						}
						evlObjResultMap.put("idxList", idxList);
						evlObjResultMap.put("evlIdxList", evlidxList);
						evlObjResultMap.put("orgparamList", orgparamList);
						evlObjResultMap.put("pstparamList", pstparamList);
						resultList.add(evlObjResultMap);
					}
					retMap.put("result", resultList);
				}
				return retMap;
			} else {
				logger.warn("schemeId is null or etlDate format error, can not getSchemeResultInfo");
				return null;
			}
		} catch (Exception e) {
			logger.error("service getSchemeResultInfo error !");
			e.printStackTrace();
			throw e;
		}
	}
}
