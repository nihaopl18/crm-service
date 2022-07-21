package cn.com.yusys.yscrm.product.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.product.domain.AcrmFpdProdCatl;
import cn.com.yusys.yscrm.product.repository.mapper.AcrmFpdProdCatlMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFpdProdCatlService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-01-25 10:59:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFpdProdCatlService extends CommonService {
    @Autowired
    private AcrmFpdProdCatlMapper acrmFpdProdCatlMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFpdProdCatlMapper;
    }
    
    /**
     * @方法名称: getTreelist
	 * @方法描述:  产品类别树查询
	 * @param 
	 * @return
	 */
	public List<Map<String, Object>> treeListQuery(QueryModel model){
		List<Map<String, Object>> list = acrmFpdProdCatlMapper.treeListQuery(model);
		return list;	
	}
	
	/**
     * @方法名称: getTreelist
	 * @方法描述:  产品类别树点击查询
	 * @param 
	 * @return
	 */
	public List<Map<String, Object>> productTreeQuery(String catlCode){
		QueryModel queryModel = new QueryModel();
		queryModel.getCondition().put("catlCode", catlCode);
		List<Map<String, Object>> list = acrmFpdProdCatlMapper.productTreeQuery(queryModel);
		return list;	
	}
    
	/**
     * @方法名称: createProductTree
	 * @方法描述:  产品类别树新增
	 * @param 
	 * @return
	 */
	public int createProductTree(AcrmFpdProdCatl acrmFpdProdCatl) {
		return this.insertSelective(getMapper(), acrmFpdProdCatl);
	}
	
	/**
     * @方法名称: createProductTree
	 * @方法描述:  产品类别树修改
	 * @param 
	 * @return
	 */
	public int editProductTree(AcrmFpdProdCatl acrmFpdProdCatl) {
		return this.updateSelective(getMapper(), acrmFpdProdCatl);
	}
	
	/**
     * @方法名称: createProductTree
	 * @方法描述:  产品类别树删除
	 * @param 
	 * @return
	 */
	public int deleteProductTree(String catlCode) {
		QueryModel queryModel = new QueryModel();
		queryModel.getCondition().put("catlCode", catlCode);
		return acrmFpdProdCatlMapper.deleteProductTree(queryModel);
	}

	/**
     * @方法名称: displaySchemeQuery
	 * @方法描述:  产品展示方案查询
	 * @param 
	 * @return
	 */
	public List<Map<String, Object>> displaySchemeQuery(QueryModel model){
		List<Map<String, Object>> list = acrmFpdProdCatlMapper.displaySchemeQuery(model);
		return list;	
	}
	
	/**
     * @方法名称: yufpDptSelectorQuery
	 * @方法描述:  部门选择器查询
	 * @param 
	 * @return
	 */
	public List<Map<String, Object>> yufpDptSelectorQuery(QueryModel model){
		List<Map<String, Object>> list = acrmFpdProdCatlMapper.yufpDptSelectorQuery(model);
		return list;	
	}

	public List<Map<String, Object>> custProdTree(QueryModel model) {
		// TODO 自动生成的方法存根
		List<Map<String, Object>> list = acrmFpdProdCatlMapper.custProdTree(model);
		return list;
	}
	
	
	
}
