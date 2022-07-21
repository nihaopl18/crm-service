package cn.com.yusys.yusp.cm.market.service;

import cn.com.yusys.yusp.cm.market.domain.FrRuleTabfieldinfo;
import cn.com.yusys.yusp.cm.market.repository.mapper.FrRuleTabfieldinfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FrRuleTabfieldinfoService extends CommonService {
	
	private Logger logger = LoggerFactory.getLogger(FrRuleTabfieldinfoService.class);
	@Autowired
	private FrRuleTabfieldinfoMapper mapper;

	public FrRuleTabfieldinfoService(FrRuleTabfieldinfoMapper commonMapper) {
		super();
		this.mapper = commonMapper;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}
	
	public int updatesField(List<FrRuleTabfieldinfo> list){
		int count = 0;
		if(list.size()>0){
			mapper.deleteByPrimaryKey(list.get(0).getTabName());
			for(int i=0;i<list.size();i++){
				mapper.insertSelective(list.get(i));
			}
		}
		return count;
	}
	
	/**
	 * 
	 * @方法名称: list
	 * @方法描述: 查询字段列表
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> list(String tabName) {
		return mapper.list(tabName);
	}
	
	/**
	 * 
	 * @方法名称: createTable
	 * @方法描述: 创建表
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public int createTable(List<FrRuleTabfieldinfo> list){
		int count = 0;
		logger.info("songer createtable"+list.size());
		StringBuffer ddlStr = new StringBuffer();
		String  field_name= "";
		String  field_type= "";
		String  nvl_flag= "";
		String  def_value= "";
		int  field_len= 0;
		String hasKey= "";
		int  scale= 0;
		String  key_flag = "";
		StringBuffer  keyColumns = new StringBuffer();
		String tab_name=list.get(0).getTabName();
		ddlStr.append(" create table  "+tab_name + " (  ");
		keyColumns.append(" alter table "+tab_name+" add constraint pk_"+tab_name+" primary key (" );
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				field_name=list.get(i).getFieldName();
				field_type=list.get(i).getFieldType();
				field_len=list.get(i).getFieldLen();
				nvl_flag=list.get(i).getNvlFlag();
				def_value=list.get(i).getDefValue();
				if(list.get(i).getFieldScale()!=null){
				 scale=list.get(i).getFieldScale();
				}
				key_flag=list.get(i).getKeyFlag(); 
				String  columnsAtt = "";
				if(null != nvl_flag && "1".equals(nvl_flag.trim()) ){
				   columnsAtt= " NOT NULL  " ;
				}
				if(null != def_value && !"".equals(def_value.trim())){
				   columnsAtt+= "  default '"+ def_value.trim() +"'  ";
				}
				if(field_len==0){
				   ddlStr.append(field_name +"  "+field_type +columnsAtt +"," );
				}else{
				if(scale==0){
					ddlStr.append(field_name +"  "+field_type +"("+field_len+")  "+columnsAtt+"  ," );
				}else{
				   ddlStr.append(field_name +"  "+field_type +"("+field_len+"," + scale +") "+columnsAtt+"  ," );
				   }
			   }
			   if(null != key_flag && "1".equals(key_flag.trim()) ){
				   keyColumns.append(field_name +"," );
				   hasKey="1";
			   }
			}
		}
		int length = ddlStr.toString().length();
		String  table = ddlStr.toString().substring(0,length-1)+" ) ";
		
		int keycolumnsLen = keyColumns.toString().length();
		String keycolumnCret = keyColumns.toString().substring(0,keycolumnsLen-1)+")";
		
		logger.info("songer createtable sql==="+table);
		logger.info("songer keycolumnCret=="+keycolumnCret);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("ddlStr", table);
		mapper.createTable(map);
		map.remove("table");
		if(null != hasKey && "1".equals(hasKey.trim()) ){
			 map.put("keycolumnCret",keycolumnCret);
			 mapper.addConstraints(map);
		}
		mapper.updateCreateFlag(tab_name);
		return count;
	}
	
	public int dropTable(String tabName) {
		int count = 0;
		StringBuffer ddlStr = new StringBuffer();
		Map<String, Object> map=new HashMap<String, Object>();
		
		ddlStr.append("drop table  "+tabName);
		String  table =ddlStr.toString();
		logger.info("droptable="+table);
		map.put("ddlDrop", table);
		mapper.dropTable(map);
		mapper.updateFlag(tabName);
		return count;
	}
	
	public int selectByfield(String id) {
		return mapper.selectByfield(id);
	}
	
	public int selecttransByfield(String id) {
		return mapper.selecttransByfield(id);
	}
	
	public int deleteField(String tabName) {
		return mapper.deleteField(tabName);
	}
}
