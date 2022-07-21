package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.commons.util.StringUtil;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.vo.PmaFBaseIndexInfoVO;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.RequestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.sequence.service.SequenceTemplateService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexSql;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFIndexBussInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper.PmaFBaseIndexConditionMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper.PmaFBaseIndexInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper.PmaFBaseIndexSqlMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper.PmaFIndexBussInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.domain.PmaFIndexApplyInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.domain.PmaFIndexBalInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.domain.PmaFIndexEvlObjInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.repository.mapper.PmaFIndexApplyInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.repository.mapper.PmaFIndexBalInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.repository.mapper.PmaFIndexEvlObjInfoMapper;
import org.springframework.util.StringUtils;

/**
 * @项目名称: uimp-business-core模块
 * @类名称: PmaFBaseIndexInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2019-12-24 16:17:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFBaseIndexInfoService extends CommonService {
	private static String BASE_SEQ="INDEX_ID_SEQ";
	
    @Autowired
    private PmaFBaseIndexInfoMapper pmaFBaseIndexInfoMapper;
    
    @Autowired
    private PmaFBaseIndexConditionMapper pmaFBaseIndexConditionMapper;
    
    @Autowired
    private PmaFIndexBalInfoMapper pmaFBalanceTypeDimMapper;
    
    @Autowired
    private PmaFIndexEvlObjInfoMapper pmaFEvlobjDimMapper;
    
    @Autowired
    private PmaFIndexApplyInfoMapper pmaFApplyDimMapper;
    
    @Autowired
    private PmaFBaseIndexSqlMapper pmaFBaseIndexSqlMapper;
    @Autowired
    private PmaFIndexBussInfoMapper pmaFIndexBussInfoMapper;
    @Autowired
    private SequenceTemplateService sequenceTemplateService;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFBaseIndexInfoMapper;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		String  orgQxSql=userInfoService.getDataOrgAuth("T.CREATE_ORG", true);
		model.getCondition().put("sql",orgQxSql);
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFBaseIndexInfo> add (PmaFBaseIndexInfo pmaFBaseIndexInfo) throws Exception {
    	ResultDto<PmaFBaseIndexInfo> result = new ResultDto<PmaFBaseIndexInfo>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	String indexId = sequenceTemplateService.getSequenceTemplate(BASE_SEQ, new HashMap<String,String>());
        if (8 != indexId.length()) {

          }
        String indexIdStr = indexId;
        String curDate = df.format(new Date());
		String operator = userInfoService.getUserInfo().getLoginCode();
		String curOrg = userInfoService.getGrantOrgCode();
        pmaFBaseIndexInfo.setIndexId(indexIdStr);
        pmaFBaseIndexInfo.setCreateDate(curDate);//创建时间
        pmaFBaseIndexInfo.setCreator(operator);
		pmaFBaseIndexInfo.setCreateOrg(curOrg);//指标所属机构

		pmaFBaseIndexInfo.setUpdateDate(curDate);// 最新更新时间
		pmaFBaseIndexInfo.setUpdaterId(operator); // 最新更新人
		pmaFBaseIndexInfo.setUpdateOrg(curOrg); // 最新更新机构
        pmaFBaseIndexInfo.setIndexState("0");
        // 首先检查是否有相同的指标名称
		if (!checkIndexName(pmaFBaseIndexInfo)) {
			result.setMessage("指标名称重复，请检查");
			result.setCode(-1);
			return result;
		}
        //保存指标基本信息
    	this.pmaFBaseIndexInfoMapper.insertSelective(pmaFBaseIndexInfo);
    	//将简单配置类指标的业务品种单独保存
    	String indexType=pmaFBaseIndexInfo.getIndexType();//指标类型
    	if("02".equals(indexType)) {//简单配置类
    		String bussNo=pmaFBaseIndexInfo.getIndexBusinessType();
    		if (!StringUtils.isEmpty(bussNo)){
				String[] bussNos=bussNo.split(",");
				for(int i=0;i<bussNos.length;i++) {
					PmaFIndexBussInfo pmaFIndexBussInfo=new PmaFIndexBussInfo();
					pmaFIndexBussInfo.setIndexId(indexIdStr);
					pmaFIndexBussInfo.setBussNo(bussNos[i]);
					this.pmaFIndexBussInfoMapper.insertSelective(pmaFIndexBussInfo);
				}
			}

    	}
        //保存考核对象维度信息
    	String[] objs=pmaFBaseIndexInfo.getObj().split(",");
    	for(int i=0;i<objs.length;i++) {
    		PmaFIndexEvlObjInfo pmaFIndexEvlObjInfo=new PmaFIndexEvlObjInfo();
    		pmaFIndexEvlObjInfo.setIndexId(indexIdStr);
    		pmaFIndexEvlObjInfo.setEvlObjType(objs[i]);
        	this.pmaFEvlobjDimMapper.insertSelective(pmaFIndexEvlObjInfo);
    	}
    	//保存应用类型维度信息
    	String[] applyIds=pmaFBaseIndexInfo.getApplyTypeId().split(",");
    	for(int j=0;j<applyIds.length;j++) {
    		PmaFIndexApplyInfo pmaFIndexApplyInfo=new PmaFIndexApplyInfo();
    		pmaFIndexApplyInfo.setIndexId(indexIdStr);
    		pmaFIndexApplyInfo.setApplyType(applyIds[j]);
        	this.pmaFApplyDimMapper.insertSelective(pmaFIndexApplyInfo);
    	}
    	//保存余额类型维度信息
    	String[] yueTypes=pmaFBaseIndexInfo.getYeType().split(",");
    	for(int k=0;k<yueTypes.length;k++) {
    		PmaFIndexBalInfo pmaFIndexBalInfo=new PmaFIndexBalInfo();
    		pmaFIndexBalInfo.setIndexId(indexIdStr);
    		pmaFIndexBalInfo.setBalType(yueTypes[k]);
        	this.pmaFBalanceTypeDimMapper.insertSelective(pmaFIndexBalInfo);
    	}
		result.setData(pmaFBaseIndexInfo);
		result.setMessage("新增指标基本信息成功");
		result.setCode(0);
    	return result;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFBaseIndexInfo> modify (PmaFBaseIndexInfo pmaFBaseIndexInfo) throws Exception {
    	ResultDto<PmaFBaseIndexInfo> result = new ResultDto<PmaFBaseIndexInfo>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        pmaFBaseIndexInfo.setUpdateDate(df.format(new Date()));//创建时间
		pmaFBaseIndexInfo.setUpdaterId(userInfoService.getUserInfo().getLoginCode());
		pmaFBaseIndexInfo.setUpdateOrg(userInfoService.getGrantOrgCode());
		// 首先检查是否有相同的指标名称
		if (!checkIndexName(pmaFBaseIndexInfo)) {
			result.setMessage("指标名称重复，请检查");
			result.setCode(-1);
			return result;
		}
		//保存指标基本信息
    	this.pmaFBaseIndexInfoMapper.updateByPrimaryKeySelective(pmaFBaseIndexInfo);
    	//将简单配置类指标的业务品种单独保存
    	String indexType=pmaFBaseIndexInfo.getIndexType();//指标类型
    	if("02".equals(indexType)) {//简单配置类
    		this.pmaFBaseIndexInfoMapper.delBuss(pmaFBaseIndexInfo.getIndexId());
    		String bussNo=pmaFBaseIndexInfo.getIndexBusinessType();
    		if (!StringUtils.isEmpty(bussNo)){
				String[] bussNos=bussNo.split(",");
				for(int i=0;i<bussNos.length;i++) {
					PmaFIndexBussInfo pmaFIndexBussInfo=new PmaFIndexBussInfo();
					pmaFIndexBussInfo.setIndexId(pmaFBaseIndexInfo.getIndexId());
					pmaFIndexBussInfo.setBussNo(bussNos[i]);
					this.pmaFIndexBussInfoMapper.insertSelective(pmaFIndexBussInfo);
				}
			}
    	}
        //保存考核对象维度信息
    	this.pmaFBaseIndexInfoMapper.delobj(pmaFBaseIndexInfo.getIndexId());
    	String[] objs=pmaFBaseIndexInfo.getObj().split(",");
    	for(int i=0;i<objs.length;i++) {
    		PmaFIndexEvlObjInfo pmaFIndexEvlObjInfo=new PmaFIndexEvlObjInfo();
    		pmaFIndexEvlObjInfo.setIndexId(pmaFBaseIndexInfo.getIndexId());
    		pmaFIndexEvlObjInfo.setEvlObjType(objs[i]);
        	this.pmaFEvlobjDimMapper.insertSelective(pmaFIndexEvlObjInfo);
    	}
    	//保存应用类型维度信息
    	this.pmaFBaseIndexInfoMapper.delapply(pmaFBaseIndexInfo.getIndexId());
    	String[] applyIds=pmaFBaseIndexInfo.getApplyTypeId().split(",");
    	for(int j=0;j<applyIds.length;j++) {
    		PmaFIndexApplyInfo pmaFIndexApplyInfo=new PmaFIndexApplyInfo();
    		pmaFIndexApplyInfo.setIndexId(pmaFBaseIndexInfo.getIndexId());
    		pmaFIndexApplyInfo.setApplyType(applyIds[j]);
        	this.pmaFApplyDimMapper.insertSelective(pmaFIndexApplyInfo);
    	}
    	//保存余额类型维度信息
    	this.pmaFBaseIndexInfoMapper.delyue(pmaFBaseIndexInfo.getIndexId());
    	String[] yueTypes=pmaFBaseIndexInfo.getYeType().split(",");
    	for(int k=0;k<yueTypes.length;k++) {
    		PmaFIndexBalInfo pmaFIndexBalInfo=new PmaFIndexBalInfo();
    		pmaFIndexBalInfo.setIndexId(pmaFBaseIndexInfo.getIndexId());
    		pmaFIndexBalInfo.setBalType(yueTypes[k]);
        	this.pmaFBalanceTypeDimMapper.insertSelective(pmaFIndexBalInfo);
    	}
		result.setData(pmaFBaseIndexInfo);
		result.setMessage("修改指标基本信息成功");
		result.setCode(0);
    	return result;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> delete (List<PmaFBaseIndexInfo> list){
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	for(int i=0;i<list.size();i++) {
    		pmaFBaseIndexInfoMapper.deleteByIds(list.get(i).getId());//删除基本信息
    		pmaFBaseIndexConditionMapper.delcon(list.get(i).getIndexId());//删除条件信息
    		pmaFBaseIndexSqlMapper.deleteSql(list.get(i).getIndexId());//删除sql信息
    	}
    	result.setCode(0);
    	result.setMessage("删除成功");
		return result;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> stopIndex (String ids){
    	ResultDto<Integer> result = new ResultDto<Integer>();
		String loginCode = userInfoService.getUserInfo().getLoginCode();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String updateTime = df.format(new Date());
        pmaFBaseIndexInfoMapper.stopIndex(ids.split(","), loginCode, updateTime);//删除基本信息
    	result.setCode(0);
    	result.setMessage("停用成功");
		return result;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<Integer> startIndex (String ids){
    	ResultDto<Integer> result = new ResultDto<Integer>();
    	//String idsstr="'"+ids.replace(",", "','")+"'";
		String loginCode = userInfoService.getUserInfo().getLoginCode();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String updateTime = df.format(new Date());
        pmaFBaseIndexInfoMapper.startIndex(ids.split(","), loginCode, updateTime);
    	result.setCode(0);
    	result.setMessage("启用成功");
		return result;
    }
    
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querycolumnlist(String bizFlg) {
		//PageHelper.startPage(model.getPage(), model.getSize());
		String tableName=this.pmaFBaseIndexInfoMapper.selTableName(bizFlg);
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoMapper.querycolumnlist(tableName);
		//PageHelper.clearPage();
		return list;
	}
    
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFBaseIndexSql> addsqlinfo (PmaFBaseIndexSql pmaFBaseIndexSql) throws Exception {
    	ResultDto<PmaFBaseIndexSql> result = new ResultDto<PmaFBaseIndexSql>();
    	this.pmaFBaseIndexSqlMapper.deleteSql(pmaFBaseIndexSql.getIndexId());
    	this.pmaFBaseIndexSqlMapper.insertSelective(pmaFBaseIndexSql);
		result.setData(pmaFBaseIndexSql);
		result.setMessage("新增指标SQL成功");
		result.setCode(0);
    	return result;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> selConditionVal() {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoMapper.selConditionVal();
		return list;
	}
    @Transactional(readOnly = true)
    public List<Map<String, Object>> sellookup() {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoMapper.sellookup();
		return list;
	}
    @Transactional(readOnly = true)
    public List<Map<String, Object>> sellookupitem(String lookupCode) {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoMapper.sellookupitem(lookupCode);
		return list;
	}
    @Transactional(readOnly = true)
    public List<Map<String, String>> qureywdlist(String indexId) {
    	List<Map<String, String>> wdlist=new ArrayList<Map<String, String>>();
    	Map<String, String> objmap=new HashMap<String, String>();
    	Map<String, String> applymap=new HashMap<String, String>();
    	Map<String, String> yuemap=new HashMap<String, String>();
		List<Map<String, Object>> objlist = this.pmaFBaseIndexInfoMapper.selObjDim(indexId);
		
		if(objlist.size()>0) {
			String objs="";
			objs=objlist.get(0).get("evlObjType").toString();
			for(int i=1;i<objlist.size();i++) {
				objs=objs+","+	objlist.get(i).get("evlObjType").toString();
			}
			objmap.put("objmap", objs);
			wdlist.add(objmap);
		}else {
			objmap.put("objmap", "");
			wdlist.add(objmap);
		}
		List<Map<String, Object>> applylist = this.pmaFBaseIndexInfoMapper.selApplyDim(indexId);
        if(applylist.size()>0) {
			String applys="";
			applys=applylist.get(0).get("applyType").toString();
			for(int i=1;i<applylist.size();i++) {
				applys=applys+","+	applylist.get(i).get("applyType").toString();
			}
			applymap.put("applymap", applys);
			wdlist.add(applymap);
		}else {
			applymap.put("applymap", "");
			wdlist.add(applymap);
		}
		List<Map<String, Object>> yuelist = this.pmaFBaseIndexInfoMapper.selYueDim(indexId);
        if(yuelist.size()>0) {
        	String yues="";
        	yues=yuelist.get(0).get("balType").toString();
			for(int i=1;i<yuelist.size();i++) {
				yues=yues+","+	yuelist.get(i).get("balType").toString();
			}
			yuemap.put("yuemap", yues);
			wdlist.add(yuemap);
		}else {
			yuemap.put("yuemap", "");
			wdlist.add(yuemap);
		}
		return wdlist;
	}
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querysqlinfo(String indexId) {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoMapper.querysqlinfo(indexId);
		return list;
	}
    @Transactional(readOnly = true)
    public ResultDto<Object> checkSqlIsExecute(String infoStr) {
    	String[] infos=infoStr.split("#");
    	String tableName=this.pmaFBaseIndexInfoMapper.selTableName(infos[0]);
    	String inputStr=infos[1];
    	if(!"".equals(inputStr)&&inputStr!=null) {
    		if(inputStr.indexOf("I_ETL_DATE")>-1) {
    			inputStr=inputStr.replace("I_ETL_DATE", "20200316");//将后台对应的参数字段转换为一个8位的日期。以确定sql正常执行
        	}
    	}
    	
    	String sql="select *  from "+tableName+" where 1=2  and "+infos[2]+"  "+inputStr;
    	ResultDto<Object> result= new ResultDto<Object>();
    	try {
//    		jdbcTemplate.queryForList(sql);
    		pmaFBaseIndexInfoMapper.executeQuerySql(sql);
    		result.setCode(0);
    		result.setMessage("校验成功");
		} catch (Exception e) {
			result.setCode(1);
			result.setMessage("校验失败");
		}
    	
		return result;
    	
	}
    @Transactional(readOnly = true)
    public List<Map<String, Object>> selColumnType(String colInfo) {
    	String[] colInfoStr = colInfo.split(",");
    	String tableName=this.pmaFBaseIndexInfoMapper.selTableName(colInfoStr[0]);
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoMapper.selColumnType(tableName,colInfoStr[1]);
		if(list.size() == 0) {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("columnType", "2"); 
			list.add(map);
		}
		return list;
	} 
    @Transactional(readOnly = true)
    public List<Map<String, Object>> iseditIndex(String indexId) {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoMapper.iseditIndex(indexId);
		List<Map<String, Object>> listfal=new ArrayList<Map<String, Object>>();
	    String dataStr=list.get(0).get("data").toString()+"01";
	    //获取定版日的月末日期
        try {
        	 Calendar cale = Calendar.getInstance();
             SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			 cale.setTime(formatter.parse(dataStr));
			 cale.add(Calendar.MONTH, 1);
		     cale.set(Calendar.DAY_OF_MONTH, 0);
		     String lastDayOfMonth = formatter.format(cale.getTime()); 
		     listfal= this.pmaFBaseIndexInfoMapper.selIsEditIndex(indexId, lastDayOfMonth);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return listfal;
	}
    /**
     *返回参数flag    01-代表方案派生引用  02-指标已经定版    03-可以对数据进行修改，删除，停用操作
     * @param indexIds
     * @return
     */
    @Transactional(readOnly = true)
    public Map<String, Object> isOperIndexInfo(String indexIds) {
    	Map<String, Object> retMap=new HashMap<String, Object>();
		//第一步  先判断当前指标是否被方案或者派生指标引用
    	List<Map<String, Object>> list =new ArrayList<Map<String, Object>>();
    	List<Map<String, Object>> alllist =new ArrayList<Map<String, Object>>();
    	String[] indexIsStr=indexIds.split(",");
    	for(int i=0;i<indexIsStr.length;i++) {
    		list = this.pmaFBaseIndexInfoMapper.queryIndexIsQuote(indexIsStr[i]);
    		if(list.size()>0) {
    			for (int j=0;j<list.size();j++) {
    				Map<String, Object> map=new HashMap<String, Object>();
    				map.put("qId", list.get(j).get("qId"));
    				map.put("qName", list.get(j).get("qName"));
					map.put("indexId", list.get(j).get("indexId"));
					map.put("quoteName", list.get(j).get("quoteName"));
    				alllist.add(map);
    			}
    		}
    	}
    	if(alllist.size()>0) {//选择的指标被引用
    		retMap.put("flag", "01");
    		retMap.put("datalist", alllist);
    		return  retMap;
    	}else {
    		//第二步  判断指标是否已经定版
    		List<Map<String, Object>> datelist =new ArrayList<Map<String, Object>>();
    		List<Map<String, Object>> alldatelist =new ArrayList<Map<String, Object>>();
    		 try {
	    		for(int k=0;k<indexIsStr.length;k++) {
	    			List<Map<String, Object>> listfal =new ArrayList<Map<String, Object>>();
	    			datelist=this.pmaFBaseIndexInfoMapper.iseditIndex(indexIsStr[k]);
	    			String dataStr=datelist.get(0).get("data").toString()+"01";
	    			//获取定版日的月末日期
	               
	                	 Calendar cale = Calendar.getInstance();
	                     SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	        			 cale.setTime(formatter.parse(dataStr));
	        			 cale.add(Calendar.MONTH, 1);
	        		     cale.set(Calendar.DAY_OF_MONTH, 0);
	        		     String lastDayOfMonth = formatter.format(cale.getTime()); 
	        		     listfal= this.pmaFBaseIndexInfoMapper.selIsEditIndex(indexIsStr[k], lastDayOfMonth);
	        		     if(listfal.size()>0) {
	        		    	 String counum=listfal.get(0).get("countnum").toString();
	        		    	 if(counum.equals("0")) {
	        		    		 
	        		    	 }else {
	        		    		 Map<String, Object> map=new HashMap<String, Object>();
	            		    	 map.put("indexId", indexIsStr[k]);
	            		    	 map.put("qName", "该指标已经定版");
	            		    	 alldatelist.add(map); 
	        		    	 }
	        		    	
	        		     }
	    		}
    		} catch (ParseException e) {
     			e.printStackTrace();
     		}
    		if(alldatelist.size()>0) {
    			retMap.put("flag", "02");
        		retMap.put("datalist", alldatelist);
        		return  retMap;
    		}else {
    			retMap.put("flag", "03");
        		return  retMap;
    		}
    	   
    	    
    	}

	}

	public PmaFBaseIndexInfoVO info(PmaFBaseIndexInfo pmaFBaseIndexInfo) {
    	String indexId =pmaFBaseIndexInfo.getIndexId();
		PmaFBaseIndexInfoVO pmaFBaseIndexInfoVO=pmaFBaseIndexInfoMapper.selectByindexId(indexId);
		//根据indexId查出考核对象
		List<PmaFIndexEvlObjInfo> objList=pmaFBaseIndexInfoMapper.selectObjByIndexId(indexId);
		StringBuilder objString=new StringBuilder();
		for (PmaFIndexEvlObjInfo pmaFIndexEvlObjInfo : objList) {
			objString.append(pmaFIndexEvlObjInfo.getEvlObjType()).append(",");
		}
		//删除最后一位的","
		objString.deleteCharAt(objString.length()-1);
		pmaFBaseIndexInfoVO.setObj(objString.toString());
		//根据indexId查出应用类型
		List<PmaFIndexApplyInfo> applyList=pmaFBaseIndexInfoMapper.selectApplyByIndexId(indexId);
		StringBuilder applyString=new StringBuilder();
		for (PmaFIndexApplyInfo pmaFIndexApplyInfo : applyList) {
			applyString.append(pmaFIndexApplyInfo.getApplyType()).append(",");
		}
		//删除最后一位的","
		applyString.deleteCharAt(applyString.length()-1);
		pmaFBaseIndexInfoVO.setApplyTypeId(applyString.toString());
		//根据indexId查出余额类型
		List<PmaFIndexBalInfo> balList=pmaFBaseIndexInfoMapper.selectBalByIndexId(indexId);
		StringBuilder balString = new StringBuilder();
		for (PmaFIndexBalInfo pmaFIndexBalInfo : balList) {
			balString.append(pmaFIndexBalInfo.getBalType()).append(",");
		}
		//删除最后一位的","
		balString.deleteCharAt(balString.length()-1);
		pmaFBaseIndexInfoVO.setYeType(balString.toString());
    	return pmaFBaseIndexInfoVO;
	}

	public List<Map<String, Object>> queryIndexList(RequestForm resultForm) {

		List<String> indexIdList=pmaFBaseIndexInfoMapper.selectIndexId(resultForm.getSchemeId());
		PageHelper.startPage(resultForm.getPage(), resultForm.getSize());
		List<Map<String, Object>> list = pmaFBaseIndexInfoMapper.listByModel(indexIdList,resultForm.getIndexId(),resultForm.getIndexName());
		PageHelper.clearPage();
		return list;
	}

	/**
	 * 检查指标名称是否重复
	 *
	 * @param indexInfo 指标数据
	 * @return 是否有重复数据
	 * @author weixy6
	 * @date 2022/6/13
	 */
	private boolean checkIndexName(PmaFBaseIndexInfo indexInfo) {
		return pmaFBaseIndexInfoMapper.checkSameIndexName(indexInfo.getId(), indexInfo.getIndexName()).isEmpty();
	}
}
