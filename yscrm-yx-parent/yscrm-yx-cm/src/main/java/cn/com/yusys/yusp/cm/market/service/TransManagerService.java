package cn.com.yusys.yusp.cm.market.service;

import cn.com.yusys.yusp.cm.market.domain.FrDetailConf;
import cn.com.yusys.yusp.cm.market.domain.FrTransInfoAllModel;
import cn.com.yusys.yusp.cm.market.domain.FrTransInfoModel;
import cn.com.yusys.yusp.cm.market.domain.FrTransMapModel;
import cn.com.yusys.yusp.cm.market.repository.mapper.TransManagerMapper;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcTableEcName;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcRulePropertyMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.*;

 
@Service
public class TransManagerService extends CommonService {

	@Autowired
	private TransManagerMapper mapper;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private CmFRcRulePropertyMapper proMapper;
	
	@Override
	protected TransManagerMapper getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}
	
	
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}



	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}



	/**
     * @函数名称:selectByModel
     * @函数描述:重新，支持页面模糊查询
     * @参数与返回说明:
     * @算法描述:
     */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> selectByModel(QueryModel model) {
		if (model.getCondition().containsKey("code")) {
			model.getCondition().put("code", "%" + model.getCondition().get("code") + "%");
		}
		if (model.getCondition().containsKey("message")) {
			model.getCondition().put("message", "%" + model.getCondition().get("message") + "%");
		}
		
		// 设置分页查询参数(设置到线程变量中了)
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,String>> list=this.mapper.getTransList(model);
		// 清除线程绑定的分页参数，防止影响同线程的其他查询
		PageHelper.clearPage();
		
		return (List<T>) list;
	}
	
	public void addTransInfo(FrTransInfoModel transModel) {
		this.mapper.transInsert(transModel);
	}
	
	public  List<FrTransMapModel> getCurrentTransParamList(FrTransInfoModel transModel) {
		List<FrTransMapModel> list=this.mapper.getCurrentTransParamList(transModel);
		return list;
	}
	public  List<CmFRcTableEcName> getTableByTransCode(String transCode) {
		List<CmFRcTableEcName> list=this.mapper.getTableByTransCode(transCode);
		return list;
	}
	public List<Map<String, String>> queryFrParamPoolList(QueryModel model){
		
		// 设置分页查询参数(设置到线程变量中了)
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list=this.mapper.getTransParamList(model);
		// 清除线程绑定的分页参数，防止影响同线程的其他查询
		PageHelper.clearPage();
		return list;
	}
	
	public List<Map<String, String>> queryFrParamPoolWithNoPage(FrTransInfoModel transModel){
		
		List<Map<String, String>> list=this.mapper.getTransListWithNoPage(transModel);
	
		return list;
	}
	
	
	public void updateTrans(FrTransInfoModel transModel) { 
		 
		this.mapper.transUpdateByPk(transModel);
	}
	
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void deleteTransByPks(Map<String,List<String>> pks) {
		String transCode = pks.get("Listpks").get(0);
		FrTransInfoModel trans = mapper.getTrans(transCode);
		
		List<Map<String,String>> tabList = mapper.selectTab(trans.getTabName());
		if(tabList.size()>0) {
			/**删除表**/
			StringBuffer ddl = new StringBuffer();
			Map<String, Object> dorpmap=new HashMap<String, Object>();
			ddl.append("drop table  "+trans.getTabName());
			String  dorpTab =ddl.toString();
			dorpmap.put("ddlDrop", dorpTab);
			mapper.dropTable(dorpmap);	
		}
		//删除交易类型
		proMapper.deleteTransCode(transCode);
		//删除交易和交易映射
		this.mapper.deleteTransByPks(pks);
		this.mapper.deleteTransMapByPks(pks);
	}
	public int createTab(FrTransInfoModel frTransInfoModel) {
		List<FrTransMapModel> list =  this.mapper.getCurrentTransParamList(frTransInfoModel);
		StringBuffer ddlStr = new StringBuffer();
		String  field_name= "";
		String  field_type= "";
		String tab_name=frTransInfoModel.getTabName().toUpperCase();
		mapper.updateTransByCode(frTransInfoModel.getTransCode());
		List<Map<String,String>> tabList = mapper.selectTab(tab_name);
		if(tabList.size()>0) {
			/**删除表**/
			StringBuffer ddl = new StringBuffer();
			Map<String, Object> dorpmap=new HashMap<String, Object>();
			ddl.append("drop table  "+tab_name);
			String  dorpTab =ddl.toString();
			dorpmap.put("ddlDrop", dorpTab);
			mapper.dropTable(dorpmap);	
		}
		
		ddlStr.append(" create table  "+tab_name + " (  ");
		ddlStr.append(" TE_ID  VARCHAR2(50), SEND_STS VARCHAR2(2),");
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				FrTransMapModel field = (FrTransMapModel) list.get(i);
				field_name=field.getFieldName();
				if(field.getFieldType().equals("C")) {
					field_type="VARCHAR2";
					ddlStr.append(field_name +"  "+field_type +"("+field.getFieldLen()+")   ," );
				}else{
					field_type="INTEGER";
					ddlStr.append(field_name +"  "+field_type +"," );
				}
			}
		}
		int length = ddlStr.toString().length();
		String  table = ddlStr.toString().substring(0,length-1)+" ) ";
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("ddlStr", table);
//		mapper.createTable(map);
		//先删除交易类型码值，再新增
		if(frTransInfoModel.getEventType().equals("2")) {
			mapper.delTrans(frTransInfoModel.getTransCode());
			Map<String, Object> tabMap =new HashMap<String, Object>();
			tabMap.put("transCode", frTransInfoModel.getTransCode());
			tabMap.put("transName", frTransInfoModel.getTransName());
			tabMap.put("tabName", frTransInfoModel.getTabName().toUpperCase());
			tabMap.put("transType", '1');
			mapper.insertTrans(tabMap);
		}
		return mapper.createTable(map);
	}
	   
	public void updateTransMapsetting(FrTransInfoAllModel frTransInfoAllModel)throws Exception {
		
		  SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		  Connection conn = session.getConnection();
		  PreparedStatement  prs = null;
		  PreparedStatement  prs1 = null;
		  PreparedStatement  prs2 = null;
		  PreparedStatement  prs3 = null;
		 
		  String sql = "";
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			try { 
				conn.setAutoCommit(false);
				/*更新主表*/
				System.err.println("更新主表信息......");
				sql = "UPDATE FR_RULE_TRANS_INFO      "
						+ " SET TAB_NAME = 'TRANS_"+frTransInfoAllModel.getTransCode()+"',     "
						+ "   OP_TIME='"+df.format(new Date())+"',       "
						+ "   LOGIN_NO=?,            "
						+ "  OP_ORG=? "
						+ " WHERE TRANS_CODE = ?" ; 
					 
				System.err.println("frTransInfoAllModel.getLoginNo():" +frTransInfoAllModel.getLoginNo());
				System.err.println("frTransInfoAllModel.getTransCode():" +frTransInfoAllModel.getTransCode());
				prs = conn.prepareStatement(sql);
				//prs.setString(1, frTransInfoAllModel.getTabName());
				prs.setString(1, frTransInfoAllModel.getLoginNo());
				prs.setString(2, frTransInfoAllModel.getOpOrg());
				prs.setString(3, frTransInfoAllModel.getTransCode()); 
				prs.executeUpdate();
				
				System.err.println("删除明细信息......");
				//01. 更新交易主表信息记录
				sql = "delete from FR_RULE_TRANS_MAPPING where TRANS_CODE='"+frTransInfoAllModel.getTransCode()+"'";
				prs2 = conn.prepareStatement(sql);
				// prs.setString(1, frTransInfoAllModel.getTransCode());  
				
				prs2.executeUpdate();
		 
				//批量插入明细表信息
				sql=" INSERT INTO FR_RULE_TRANS_MAPPING (TRANS_CODE,PARAM_CODE,PARAM_POS,PARAM_DESC,FIELD_NAME,"
						+ "RULE_VISIBLE,OP_TIME,LOGIN_NO,OP_ORG,FIELD_TYPE,FIELD_LEN,FIELD_FLAG,FIELD_OFFSET,UPDOWN_FLAG)"
						+ "values(?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?)";
				 	prs1 = conn.prepareStatement(sql);
				
			
				 
				 	
				List<FrTransMapModel> list = frTransInfoAllModel.getTransMapList();
				for(FrTransMapModel frTransMapModel:list) { 
					prs1.setString(1, frTransInfoAllModel.getTransCode());
					prs1.setString(2, frTransMapModel.getParamCode());
					prs1.setInt(3, frTransMapModel.getParamPos());
					prs1.setString(4, frTransMapModel.getParamDesc());
					prs1.setString(5, frTransMapModel.getFieldName());
					prs1.setString(6, frTransMapModel.getRuleVisible());
					prs1.setString(7,frTransInfoAllModel.getLoginNo());
					prs1.setString(8,frTransInfoAllModel.getOpOrg());
					prs1.setString(9,frTransMapModel.getFieldType());
					prs1.setString(10,frTransMapModel.getFieldLen());
					prs1.setString(11,frTransMapModel.getFieldFlag());
					prs1.setInt(12,frTransMapModel.getFieldOffset());
					prs1.setString(13,frTransMapModel.getUpdownFlag());
					prs1.addBatch();
				}
				
				prs1.executeBatch();
			 
//				List<FrDetailConf> detailConfigList = this.getNewDetailConf(frTransInfoAllModel);
//				if(detailConfigList.size()>0) {
//					sql = " insert into FR_ENG_DETAIL_CONF"
//							+ "(SUB_ID,PARAM_ID,PARAM_NAME,VISIBLE,SHOW_ORDER,OP_TIME, LOGIN_NO, OP_ORG,ORG_ID,TARGET_FIELD,TARGET_FIELD_NAME,TARGET_TAB)" +  //
//							" values(?,?,?,'N',0,SYSDATE,?,?,?,?,?,?)"; //,'N',0,SYSDATE,?,?,?,?,?,?
//					//stmt = conn.createStatement();
//					 
//					//stmt.execute(sql);
//					 prs3 = conn.prepareStatement(sql);
//					
//					
//					 for(FrDetailConf frDetailConf: detailConfigList) {
//						prs3.setString(1, frDetailConf.getSubId());
//						prs3.setString(2, frDetailConf.getParamId());					 
//						prs3.setString(3, frDetailConf.getParamName());					 
//						prs3.setString(4, frDetailConf.getLoginNo());					 
//						prs3.setString(5, frTransInfoAllModel.getOpOrg()==null?"100000":frTransInfoAllModel.getOpOrg());					 
//						prs3.setString(6, frDetailConf.getOrgId());				 
//						prs3.setString(7, frDetailConf.getTargetField());					 
//						prs3.setString(8, frDetailConf.getTargetFieldName());				 
//						prs3.setString(9, frDetailConf.getTargetTab());						 
//						prs3.addBatch();
//					} 
//					 
//					 prs3.executeBatch();
//					 
//				}
				 
				conn.commit();
	            session.clearCache();
			}catch(Exception e) {
				try {
					conn.rollback();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			
				session.rollback();
				e.printStackTrace();
				throw new Exception(e.getMessage(),e);
			}finally {
				if(prs!=null) {
					try { 
						prs.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				if(prs1!=null) {
					try { 
						prs1.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				if(prs2!=null) {
					try { 
						prs2.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
				if(prs3!=null) {
					try { 
						prs2.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
				
				try { 
					conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				 session.close();
			}
		}
	
	public List<FrDetailConf> getNewDetailConf(FrTransInfoAllModel frTransInfoAllModel){
		List<FrDetailConf> retList = new ArrayList<FrDetailConf>();
		 List<FrTransMapModel> mappinglist = frTransInfoAllModel.getTransMapList();
		List<Map<String,String>> list = this.getMapper().getRruleDetailConfigDetail(frTransInfoAllModel.getTransCode());
		 for (Map<String, String> map : list) {
			 String configDetailFields = map.get("paramids");
			 String subId = map.get("subid");
			 String targetTab = map.get("targettab");
			   List<String> detailFileds = Arrays.asList(configDetailFields.split(",")); 
			   for(FrTransMapModel FrTransMapModel:mappinglist) {
				   
				   if(!detailFileds.contains(FrTransMapModel.getParamCode() )) {
					   FrDetailConf detailConf = new FrDetailConf();
					   detailConf.setSubId(subId );
					   detailConf.setTargetTab(targetTab );
					   detailConf.setParamId( FrTransMapModel.getParamCode());
					   detailConf.setParamName(FrTransMapModel.getParamDesc());
					   detailConf.setLoginNo(frTransInfoAllModel.getLoginNo());
					   detailConf.setOrgId(FrTransMapModel.getOpOrg());
					   detailConf.setTargetField( FrTransMapModel.getParamCode());
					   detailConf.setTargetFieldName(FrTransMapModel.getParamDesc() );
					   detailConf.setVisible("N"); 
					   retList.add(detailConf); 
				   }
				    
			   }  
		}

		return retList;
	}
	public List<FrTransInfoModel> querylist(QueryModel model) {
		List<FrTransInfoModel> list = mapper.querylist(model);
		return list;
	}
}
