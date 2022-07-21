package cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.service;

import cn.com.yusys.yusp.admin.domain.AdminSmOrg;
import cn.com.yusys.yusp.admin.repository.mapper.AdminSmOrgMapper;
import cn.com.yusys.yusp.admin.service.MessageProviderService;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.commons.web.rest.exception.YuspException;
import cn.com.yusys.yusp.sequence.service.SequenceTemplateService;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper.PmaFBaseIndexInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.service.PmaFBaseIndexInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.domain.PmaFIndexApplyInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.domain.PmaFIndexBalInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.domain.PmaFIndexEvlObjInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.service.PmaFApplyDimService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.service.PmaFBalanceTypeDimService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.service.PmaFEvlobjDimService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.domain.PmaFEvlIndexInfoEntity;
import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.domain.PmaFEvlIndexInfoVo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.enums.IndexApplyTypeEnum;
import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.enums.ObjTypeEnum;
import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.enums.YETypeEnum;
import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.repository.mapper.PmaFEvlIndexInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.domain.PmaFParamInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.service.PmaFParamInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain.PmaFPersonpostParamInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.service.PmaFPersonpostParamInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.tools.AddCommonFieldTools;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFEvlIndexInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-31 14:11:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
@Transactional
public class PmaFEvlIndexInfoService extends CommonService {
	private static String EVL_SEQ="PMA_EVL_SEQ";
    @Autowired
    private PmaFApplyDimService pmaFApplyDimService;
    @Autowired
    private PmaFBalanceTypeDimService pmaFBalanceTypeDimService;
    @Autowired
    private PmaFEvlobjDimService pmaFEvlobjDimService;
    @Autowired
    private SequenceTemplateService sequenceTemplateService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private PmaFEvlIndexInfoMapper pmaFEvlIndexInfoMapper;
    @Autowired
    private AdminSmOrgMapper adminSmOrgMapper;
    @Autowired
    private PmaFEvlIndexInfoService pmaFEvlIndexInfoService;
	@Autowired
	private PmaFBaseIndexInfoService pmaFBaseIndexInfoService;
	@Autowired
	private MessageProviderService messageProviderService;
	@Autowired
	private PmaFParamInfoService pmaFParamInfoService;
	@Autowired
	private PmaFPersonpostParamInfoService pmaFPersonpostParamInfoService;

	@Autowired
	private PmaFBaseIndexInfoMapper pmaFBaseIndexInfoMapper;
	
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFEvlIndexInfoMapper;
    }
    
//  @Cacheable(value = "AdminSmOrg", key = "#orgCode", unless= "#result == null")
    @Transactional(readOnly = true)
	public AdminSmOrg queryOrgByCode(String orgCode) {
	  	QueryModel model = new QueryModel();
	  	model.setCondition(orgCode);
	  	List<AdminSmOrg> list = adminSmOrgMapper.selectByModel(model);
	  	if(list.size()>0) {
	  		return list.get(0);
	  	}
	    return null;
	}
  
    @Transactional(readOnly = true)
    public List<PmaFEvlIndexInfoEntity> querylist(QueryModel model) {

        model.getCondition().put("orgCode", userInfoService.getUserInfo().getOrg().getCode());

		PageHelper.startPage(model.getPage(), model.getSize());
		List<PmaFEvlIndexInfoEntity> list = this.pmaFEvlIndexInfoMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}

    @Transactional(readOnly = true)
    public List<PmaFEvlIndexInfoEntity> queryUpOrglist(QueryModel model) {

        model.getCondition().put("orgCode", userInfoService.getUserInfo().getOrg().getCode());

        PageHelper.startPage(model.getPage(), model.getSize());
        List<PmaFEvlIndexInfoEntity> list = this.pmaFEvlIndexInfoMapper.querylist(model);
        PageHelper.clearPage();
        return list;
    }
    
    @Transactional(rollbackFor = { Exception.class})
    public ResultDto<Object> saveOrUpdate(PmaFEvlIndexInfoVo vo) {
    	ResultDto<Object> resultDto = new ResultDto<>();
    	UserInfoDTO user = getUser();

        if (StringUtils.isBlank(vo.getId())) {
            PmaFEvlIndexInfoEntity entity = new PmaFEvlIndexInfoEntity();
            BeanUtils.copyProperties(vo, entity);
            String nextSeq = sequenceTemplateService.getSequenceTemplate(EVL_SEQ, new HashMap<String, String>());
            entity.setIndexId(nextSeq);
            entity.setOrgId(userInfoService.getGrantOrgCode());
            AddCommonFieldTools.createCommonFieldFun(entity, user);
            entity.setBussSysNo("H99");
            entity.setStatFlag("0");
            entity.setIndexState("0");
            pmaFEvlIndexInfoMapper.insertSelective(entity);
            // 考核对象类型(01员工，02机构)
            PmaFIndexEvlObjInfo pmaFEvlobjDim = new PmaFIndexEvlObjInfo();
            pmaFEvlobjDim.setEvlObjType(entity.getObjType());
            pmaFEvlobjDim.setIndexId(entity.getIndexId());
            pmaFEvlobjDimService.insertSelective(pmaFEvlobjDim);

            // 应用类型01-指标
            PmaFIndexApplyInfo pmaFApplyDim = new PmaFIndexApplyInfo();
            pmaFApplyDim.setApplyType("01");
            pmaFApplyDim.setIndexId(entity.getIndexId());
            pmaFApplyDimService.insertSelective(pmaFApplyDim);

            // 余额类型01-余额
            PmaFIndexBalInfo pmaFBalanceTypeDim = new PmaFIndexBalInfo();
            pmaFBalanceTypeDim.setBalType("01");
            pmaFBalanceTypeDim.setIndexId(entity.getIndexId());
            pmaFBalanceTypeDimService.insertSelective(pmaFBalanceTypeDim);
            resultDto.setCode(0);
            resultDto.setMessage("保存成功！");
        } else {
            PmaFEvlIndexInfoEntity entity = new PmaFEvlIndexInfoEntity();
            entity.setId(vo.getId());
            entity.setIndexName(vo.getIndexName());
            entity.setObjType(vo.getObjType());
            entity.setFormula(vo.getFormula());
            entity.setFormulaNotes(vo.getFormulaNotes());
            AddCommonFieldTools.updateCommonFieldFun(entity, user);
            pmaFEvlIndexInfoMapper.updateByPrimaryKeySelective(entity);
            resultDto.setCode(0);
            resultDto.setMessage("更新成功！");
        }
        return resultDto;

    }
    
    @Transactional(readOnly = true)
    public String convertToChinese(String indexId,String param) {
    	
    	StringBuffer sb = new StringBuffer();
    	lookupValidate(indexId,param);
		//公式判断 +-*/
		param = formulaValidate(param);
		
		//if条件判断
		ifValidate(param);
		param = param.replaceAll("IF", "#IF#");
		param = param.replaceAll("\\(", "#(#");
		param = param.replaceAll("\\)", "#)#");
		param = param.replaceAll("!=", "#CCFA#");
		param = param.replaceAll(">=", "#FHFA#");
		param = param.replaceAll("<=", "#FOFA#");
		
		param = param.replaceAll("&", "#&#");
		param = param.replaceAll("\\|", "#|#");
		param = param.replaceAll(">", "#>#");
		param = param.replaceAll("<", "#<#");
		param = param.replaceAll("=", "#=#");
		param = param.replaceAll(":", "#:#");
		param = param.replaceAll(";", "#;#");
		String[] p = param.split("#");
		
		for (int i = 0; i < p.length; i++) {
			if (p[i].length() > 0) {
				switch (p[i].substring(0, 1)) {
					case "B":
						String bParam = queryBEParam(p[i]);
						if(bParam.equals(p[i])) {
							throw new YuspException(messageProviderService.getMessage("310010"));//基础指标公式有误，请确认
						}else {
							sb.append(bParam);
						}
						break;
					case "E":
						String eParam = queryBEParam(p[i]);
						if(eParam.equals(p[i])) {
							throw new YuspException(messageProviderService.getMessage("310011"));//派生指标公式有误，请确认
						}else {
							sb.append(eParam);
						}
						break;
					case "P":
						String pParam = queryPParam(p[i]);
						if(pParam.equals(p[i])) {
							throw new YuspException(messageProviderService.getMessage("310012"));//机构参数指标公式有误，请确认
						}else {
							sb.append(pParam);
						}
						break;
					case "G":
						String gParam = queryGParam(p[i]);
						if(gParam.equals(p[i])) {
							throw new YuspException(messageProviderService.getMessage("310013"));//人员岗位参数指标公式有误，请确认
						}else {
							sb.append(gParam);
						}
						break;
					default:
						if(isNumeric(p[i])||isOperator(p[i])) {
							sb.append(p[i]);
						}else if(!"CCFA,FHFA,FOFA".contains(p[i])) {
							sb.append(p[i]);
						}else {
							if("CCFA".equals(p[i])) {
								sb.append("!=");
							}else if("FHFA".equals(p[i])) {
								sb.append(">=");
								
							}else if("FOFA".equals(p[i])) {
								sb.append("<=");
							}
						}
				}
			}

		}
		return sb.toString();
    }
    private void lookupValidate(String indexId,String param) {
		if(!indexId.isEmpty()) {
			lookup(indexId,param);
		}
		
	}
    private void lookup(String indexId,String param) {
    	if(param.contains(indexId)) {
			throw new YuspException(messageProviderService.getMessage("310022"));//派生指标存在循环依赖，请确认
		}
    	param=findStr(param, "E", 8);
		if (StringUtils.isBlank(param)){
			return;
		}
    	String[] p = param.split("(?<=\\G.{8})");
    	for(int i=0;i<p.length;i++) {
    		QueryModel qm = new QueryModel();
    		qm.setCondition(p[i]);
    		List<PmaFEvlIndexInfoEntity> list = pmaFEvlIndexInfoService.selectByModel(qm);
    		if(list.size()>0) {
    			if(!list.get(0).getFormula().contains(indexId)) {
    				lookup(indexId,list.get(0).getFormula());
    			}else {
    				throw new YuspException(messageProviderService.getMessage("310022"));//派生指标存在循环依赖，请确认
    			}
    		}
    	}
    }

	private String formulaValidate(String param) {
		if(param.contains(")(")) {
			throw new YuspException(messageProviderService.getMessage("310015"));//存在非法运算符，请确认
		}else if(param.contains("()")) {
			throw new YuspException(messageProviderService.getMessage("310015"));//存在非法运算符，请确认
		}else if(param.contains("-=")) {
			throw new YuspException(messageProviderService.getMessage("310015"));//存在非法运算符，请确认
		}else if(param.contains("+=")) {
			throw new YuspException(messageProviderService.getMessage("310015"));//存在非法运算符，请确认
		}else if(param.contains("*=")) {
			throw new YuspException(messageProviderService.getMessage("310015"));//存在非法运算符，请确认
		}else if(param.contains("/=")) {
			throw new YuspException(messageProviderService.getMessage("310015"));//存在非法运算符，请确认
		}
		String prefix = param.substring(0,1);
		String suffix = param.substring(param.length()-1,param.length());
		if(!")]1234567890".contains(suffix)) {
			throw new YuspException(messageProviderService.getMessage("310015"));//存在非法运算符，请确认
		}
		if("+-IBEPG(1234567890".contains(prefix)) {
			if(param.contains("IF(")) {	// 存在IF函数，需要单独处理，IF函数中内容不做-四则运算符替换
				int ifStartIndex = param.lastIndexOf("IF(");
				String beforeIfStr = param.substring(0, ifStartIndex);
				String afterIfStr = param.substring(ifStartIndex, param.length());
				int ifEndIndex = afterIfStr.lastIndexOf(")");
				ifEndIndex += ifStartIndex;
				String ifStr = param.substring(ifStartIndex, ifEndIndex + 1);
				afterIfStr = param.substring(ifEndIndex + 1, param.length());
				
				beforeIfStr = beforeIfStr.replaceAll("\\+", "#+#");
				beforeIfStr = beforeIfStr.replaceAll("-", "#-#");
				beforeIfStr = beforeIfStr.replaceAll("\\*", "#*#");
				beforeIfStr = beforeIfStr.replaceAll("/", "#/#");
				
				afterIfStr = afterIfStr.replaceAll("\\+", "#+#");
				afterIfStr = afterIfStr.replaceAll("-", "#-#");
				afterIfStr = afterIfStr.replaceAll("\\*", "#*#");
				afterIfStr = afterIfStr.replaceAll("/", "#/#");
				param = beforeIfStr + ifStr + afterIfStr;
			} else {
				param = param.replaceAll("\\+", "#+#");
				param = param.replaceAll("-", "#-#");
				param = param.replaceAll("\\*", "#*#");
				param = param.replaceAll("/", "#/#");
			}
			
			if(param.indexOf("##")>0) {
				throw new YuspException(messageProviderService.getMessage("310015"));//存在非法运算符，请确认
			}
		}else {
			throw new YuspException(messageProviderService.getMessage("310015"));//存在非法运算符，请确认
		}
		
		return param;
	}
	private void ifValidate(String param) {
		
		String[] p = param.split("#");
		for (int i = 0; i < p.length; i++) {
			String tmp = p[i];
			int index = countStr(tmp,"IF");
			if(index==1) {
				if(!tmp.startsWith("IF(")) {
					throw new YuspException(messageProviderService.getMessage("310016"));//IF函数无法解析，请确认
				}
				if(tmp.endsWith(")")) {
					//if函数校验
					tmp=tmp.substring(3);
					tmp=tmp.substring(0,tmp.length()-1);
					String[]str = tmp.split(";");
					if(str.length>=2) {
						for(int j=0;j<str.length;j++) {
							if(j!=str.length-1) {
								String[]k =str[j].split("[&|]");
								String val = "";
								for(int a=0;a<k.length;a++) {
									if(k[a].indexOf(":")>0) {
										if(val.isEmpty()) {
											val=k[a].substring(k[a].indexOf(":"));
										}else {
											if(!k[a].substring(k[a].indexOf(":")).equals(val)) {
												throw new YuspException(messageProviderService.getMessage("310019"));//IF函数表达式中条件解析有误，请检查
											}
										}
										if(countStr(k[a],":")>1) {
											throw new YuspException(messageProviderService.getMessage("310019"));//IF函数表达式中条件解析有误，请检查
										}else {
											k[a] = k[a].replaceAll("!=", "X");
											k[a] = k[a].replaceAll(">=", "Y");
											k[a] = k[a].replaceAll("<=", "Z");
											if(k[a].split("[XYZ//=//>//<:]").length!=3) {
												throw new YuspException(messageProviderService.getMessage("310019"));//IF函数表达式中条件解析有误，请检查
											};
										}
									}else {
										throw new YuspException(messageProviderService.getMessage("310016"));//IF函数无法解析，请确认
									}
								}
							}else {
								//最后默认值
								switch (str[j].substring(0, 1)) {
									case "B":
										String bParam = queryBEParam(str[j]);
										if(bParam.equals(str[j])) {
											throw new YuspException(messageProviderService.getMessage("310020"));//IF函数表达式中默认值填写有误，请确认
										}
										break;
									case "E":
										String eParam = queryBEParam(str[j]);
										if(eParam.equals(str[j])) {
											throw new YuspException(messageProviderService.getMessage("310020"));//IF函数表达式中默认值填写有误，请确认
										}
										break;
									case "P":
										String pParam = queryPParam(str[j]);
										if(pParam.equals(str[j])) {
											throw new YuspException(messageProviderService.getMessage("310020"));//IF函数表达式中默认值填写有误，请确认
										}
										break;
									case "G":
										String gParam = queryGParam(str[j]);
										if(gParam.equals(str[j])) {
											throw new YuspException(messageProviderService.getMessage("310020"));//IF函数表达式中默认值填写有误，请确认
										}
										break;
									default:
										if(!("-".equals(str[j].substring(0, 1)) && isNumeric(str[j].substring(1,  str[j].length()))) && 
												!isNumeric(str[j])) {
											throw new YuspException(messageProviderService.getMessage("310020"));//IF函数表达式中默认值填写有误，请确认
										}
								}
								
							}
							
						}
					}else {
						throw new YuspException(messageProviderService.getMessage("310016"));//IF函数无法解析，请确认
					}
				}else {
					throw new YuspException(messageProviderService.getMessage("310016"));//IF函数无法解析，请确认
				}
			}else if(index>1){
				throw new YuspException(messageProviderService.getMessage("310016"));//IF函数无法解析，请确认
			}
		}
		
	}
    /**
     * @param str 原字符串
     * @param sToFind 需要查找的字符串
     * @return 返回在原字符串中sToFind出现的次数
     */
    private int countStr(String str,String sToFind) {
        int num = 0;
        while (str.contains(sToFind)) {
            str = str.substring(str.indexOf(sToFind) + sToFind.length());
            num ++;
        }
        return num;
    }
    /**
     * @param str 原字符串
     * @param sToFind 需要查找的字符串
     * @param length 需要查找的字符串长度
     * @return 返回在原字符串中sToFind 匹配的字符串 
     * 
     */
    private String findStr(String str,String sToFind,int length) {
    	String returnStr = "";
        while (str.contains(sToFind)) {
        	returnStr+=str.substring(str.indexOf(sToFind), str.indexOf(sToFind)+ length);
            str = str.substring(str.indexOf(sToFind) + length);
        }
        return returnStr;
    }
	/**
	 * 判断是不是数字
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumeric(String str) {
//		Pattern p1 = Pattern.compile("[0-9]+");
		// 公式默认值-支持校验小数
		Pattern p1 = Pattern.compile("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])");
		Matcher isNum = p1.matcher(str);
		if (isNum.matches()) {
			return true;
		}
		return false;
	}
	/**
	 * 判断是不是运算符
	 * 
	 * @param str
	 * @return
	 */
	public boolean isOperator(String str) {
		Pattern p2 = Pattern.compile("[IF\\+\\-\\*\\/\\:\\;\\|\\&\\(\\)\\=]+");
		Matcher isOperator = p2.matcher(str);
		if (isOperator.matches()) {
			return true;
		}
		return false;
	}


	public String queryBEParam(String param) {
		if(param.length()!=22) {
			throw new YuspException(messageProviderService.getMessage("310021"));//指标格式有误，请确认
		}
		if (param.substring(param.length()-10, param.length()-9).equals("[") && param.endsWith("]")) {
			String param1 = param.substring(0, 12);
			String tmp = param.substring(13);
			tmp = tmp.substring(0, tmp.length() - 1);
			if (tmp.split(",").length == 3) {
				String param2 = tmp.split(",")[0];
				String param3 = tmp.split(",")[1];
				String param4 = tmp.split(",")[2];
				Map map = getBEParamChinese(param1, param2, param3, param4);
				if (!map.isEmpty()) {
					return map.get("param1") + "[" + map.get("param2") + "," + map.get("param3") + ","
							+ map.get("param4") + "]";
				}
			}

		}
		return param;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map getBEParamChinese(String param1, String param2, String param3, String param4) {
		Map map = new HashMap<>();
		if (param1.startsWith("B")) {
			QueryModel model = new QueryModel();
//			model.setCondition(param1);
			model.getCondition().put("indexId", param1);
			List<PmaFBaseIndexInfo> list = pmaFBaseIndexInfoService.selectByModel(model);
			if(list.size()>0) {
				map.put("param1", list.get(0).getIndexName());
			}else {
				throw new YuspException(messageProviderService.getMessage("310017"));//基础指标无法解析，请确认
			}
			
		} else if (param1.startsWith("E")) {
			QueryModel model = new QueryModel();
			model.getCondition().put("indexId", param1);
			List<PmaFEvlIndexInfoEntity> list = pmaFEvlIndexInfoService.selectByModel(model);
			if(list.size()>0) {
				map.put("param1", list.get(0).getIndexName());
			}else {
				throw new YuspException(messageProviderService.getMessage("310018"));//派生指标无法解析，请确认
			}
			
		}
		map.put("param2", YETypeEnum.valueOf("YE_TYPE_".concat(param2)).getName());
		map.put("param3", IndexApplyTypeEnum.valueOf("INDEX_APPLY_TYPE_".concat(param3)).getName());
		map.put("param4", ObjTypeEnum.valueOf("OBJ_TYPE_".concat(param4)).getName());
		return map;
	}

	private String queryPParam(String param) {
		QueryModel model = new QueryModel();
		model.setCondition(param);
		List<PmaFParamInfo> list = pmaFParamInfoService.selectByModel(model);
		if(list.size()>0) {
			param=list.get(0).getParamName();
		}
		return param;
	}

	private String queryGParam(String param) {
		QueryModel model = new QueryModel();
		model.setCondition(param);
		List<PmaFPersonpostParamInfo> list = pmaFPersonpostParamInfoService.selectByModel(model);
		if(list.size()>0) {
			param=list.get(0).getParamName();
		}
		return param;
	}
	
    private UserInfoDTO getUser() {
		UserInfoDTO user = userInfoService.getUserInfo();
    	return user;
    }
    
    @Transactional(readOnly = true)
	public String queryNames(String objId) {
    	String result = "";
    	List<String> resultList = new ArrayList<String>();
    	try {
    		if(!StringUtils.isEmpty(objId)) {
    			String[] ids = objId.split(",");
    			resultList = this.pmaFEvlIndexInfoMapper.queryNames(ids);
    			if(resultList.size() > 0) {
    				for(String s : resultList) {
    					result += s + ",";
    				}
    				result = result.substring(0, result.length() - 1);
    			}
    		}
    	} catch (Exception e) {
    		result = "-1";
    		e.printStackTrace();
    	}
    	return result;
    }

    /**
     * 可以直接用单条数据传参，但是这里考虑到可能会出现多选的情况，所以用数组传参
     * 1、转JSON字符串
     * 2、转JSONObject
     * 3、转JSONArray
     * @param map
     * @return
     */
    @Transactional(rollbackFor = { Exception.class})
    public ResultDto<String> startOrStopState(Map<String, Object> map) {
        //String indexId = map.get("indexId").toString();
        String statFlag = map.get("statFlag").toString();

        String json = JSONObject.toJSONString(map);
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray arr = JSONArray.parseArray(jsonObject.getString("arr"));

        pmaFEvlIndexInfoMapper.startOrStopState(arr,statFlag);

        ResultDto<String> result = new ResultDto<String>();
		result.setMessage("处理成功");
		result.setCode(0);
		return result;
    }

    /**
     * 余额类型,应用类型,考核对象的key和value根据基础指标管理选择的值进行级联展示
     * @param indexId
     * @return
     */
	public Map<String, Object> getTypesByPkid(String indexId) {

        Map<String, Object> json = new HashMap<>();

		//考核对象
		List<PmaFIndexEvlObjInfo> pmaFIndexEvlObjInfos = pmaFBaseIndexInfoMapper.selectObjByIndexId(indexId);
        List<PmaFIndexEvlObjInfo>  listEvlObj = new ArrayList<>();

		for(PmaFIndexEvlObjInfo evlObj :pmaFIndexEvlObjInfos){
            String code = evlObj.getEvlObjType();
            String name = ObjTypeEnum.valueOf("OBJ_TYPE_".concat(code)).getName();
            if("员工".equals(name)){
                name = "客户经理";
            }

            PmaFIndexEvlObjInfo temp = new PmaFIndexEvlObjInfo();
            temp.setEvlObjType(code);
            temp.setEvlObjTypeName(name);
            listEvlObj.add(temp);
        }

		//应用类型
		List<PmaFIndexApplyInfo> pmaFIndexApplyInfos = pmaFBaseIndexInfoMapper.selectApplyByIndexId(indexId);
        List<PmaFIndexApplyInfo> listEvlApply = new ArrayList<>();

		for(PmaFIndexApplyInfo evlApply :pmaFIndexApplyInfos){
            String code = evlApply.getApplyType();
            String name = IndexApplyTypeEnum.valueOf("INDEX_APPLY_TYPE_".concat(code)).getName();

            PmaFIndexApplyInfo temp = new PmaFIndexApplyInfo();
            temp.setApplyType(code);
            temp.setApplyTypeName(name);
            listEvlApply.add(temp);
        }

		//余额类型
		List<PmaFIndexBalInfo> pmaFIndexBalInfos = pmaFBaseIndexInfoMapper.selectBalByIndexId(indexId);
        List<PmaFIndexBalInfo> listEvlxBal = new ArrayList<>();

		for(PmaFIndexBalInfo evlBal :pmaFIndexBalInfos){
            String code = evlBal.getBalType();
            String name = YETypeEnum.valueOf("YE_TYPE_".concat(code)).getName();

            PmaFIndexBalInfo temp = new PmaFIndexBalInfo();
            temp.setBalType(code);
            temp.setBalTypeName(name);
            listEvlxBal.add(temp);
        }

        json.put("listEvlObj",listEvlObj);
        json.put("listEvlApply",listEvlApply);
        json.put("listEvlxBal",listEvlxBal);

        json.put("code",0);
        json.put("message","获取成功");

		return json;
	}
}
