package cn.com.yusys.yscrm.sysview.service;

import cn.com.yusys.yscrm.sysview.domain.CimFMmTagDataSource;
import cn.com.yusys.yscrm.sysview.repository.mapper.CimFMmTagDataSourceMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 
 * @项目名称: yusp-app-cim-cust
 * @类名称: CimFMmTagDataSourceService
 * @类描述: 
 * @功能描述: 模型版本信息
 * @创建人: yangye@yusys.com.cn
 * @创建时间: 2018年09月27日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CimFMmTagDataSourceService extends CommonService{
	@Autowired
	private CimFMmTagDataSourceMapper mapper;
//	@Autowired
//	FileManagementClientFactory fileManagementCilentFactory;
	/**
	 * 自增UUID
	 */
	private String getUUID() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}

	/**
	 * 查询数据来源信息
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getTagDataSourceList(QueryModel model) {
		List<Map<String, Object>> list = mapper.getTagDataSourceList(model);
		return list;
	}
	/*
	 * 修改数据来源内容
	 * */
	public int updateTagDataSource(CimFMmTagDataSource tag) {
		return mapper.updateTagDataSource(tag);
	}
	/*
	 * 删除数据来源内容
	 * */
	public int deleteTagDataSource(QueryModel model){
		return this.mapper.deleteTagDataSource(model);
	}
	/*
	 * 新增数据来源内容
	 * */
	public int insertTagDataSource(CimFMmTagDataSource tag) {
		tag.setID(getUUID());
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 String t1 = df.format(tag.getDateStart());
		 String t2 = df.format(tag.getDateEnd());
		 Date date1 = null; 
		 Date date2 = null; 
		 try {
			date1 = df.parse(t1);
			date2 = df.parse(t2);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		 tag.setDateStart(date1);
		 tag.setDateEnd(date2);
		return mapper.insertTagDataSource(tag);
	}
	/*
	 * 通过数据库表名查找实体属性
	 * */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getEntityNo(QueryModel model) {
		List<Map<String, Object>> list = mapper.getEntityNo(model);
		return list;
	}
	/*
	 * 查找全部数据库表名
	 * */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getTableName(QueryModel model) {
		List<Map<String, Object>> list = mapper.getTableName(model);
		return list;
	}
	  /*
	   * 查找数据库中来源实体编号、属性、表名是否重复
	   * */
	public List<Map<String, Object>> getDsRepeat(QueryModel model){
		return this.mapper.getDsRepeat(model);
	}
	public int checkTagNo(String tagno) {
		return mapper.checkTagNo(tagno);
	}
	/*
	 * 删除标签的数据来源信息
	 * */
	public int delTagNo(String tagNo) {
		return mapper.delTagNo(tagNo);
	}
}
