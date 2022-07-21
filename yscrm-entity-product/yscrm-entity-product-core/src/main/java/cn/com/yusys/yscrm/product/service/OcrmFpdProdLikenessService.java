package cn.com.yusys.yscrm.product.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.product.domain.OcrmFpdProdLikeness;
import cn.com.yusys.yscrm.product.repository.mapper.OcrmFpdProdLikenessMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdProdLikenessService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-11 10:26:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFpdProdLikenessService extends CommonService {
    @Autowired
    private OcrmFpdProdLikenessMapper ocrmFpdProdLikenessMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFpdProdLikenessMapper;
    }

    /**
     * @方法名称: similarProductsQuery
	 * @方法描述: 类似产品查询
	 * @param 
	 * @return
	 */
	public List<Map<String, Object>> similarProductsQuery(QueryModel model, String prodId){
		PageHelper.startPage(model.getPage(), model.getSize());
		model.getCondition().put("prodId", prodId);
		List<Map<String, Object>> list = ocrmFpdProdLikenessMapper.similarProductsQuery(model);
		PageHelper.clearPage();
		return list;	
	}
	
	/**
     * @方法名称: createSimilarProducts
	 * @方法描述: 类似产品新增
	 * @param 
	 * @return
	 */
	public int createSimilarProducts(OcrmFpdProdLikeness ocrmFpdProdLikeness) {
		return this.insertSelective(getMapper(), ocrmFpdProdLikeness);
	}
	
	/**
     * @方法名称: deleteSimilarProducts
	 * @方法描述: 类似产品删除
	 * @param 
	 * @return
	 */
	public int deleteSimilarProducts(String likenessId) {
		QueryModel queryModel = new QueryModel();
		queryModel.getCondition().put("likenessId", likenessId);
		return ocrmFpdProdLikenessMapper.deleteSimilarProducts(queryModel);
	}
    
}
