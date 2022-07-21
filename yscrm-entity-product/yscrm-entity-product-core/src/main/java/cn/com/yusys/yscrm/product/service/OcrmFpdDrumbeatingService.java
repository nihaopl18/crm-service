package cn.com.yusys.yscrm.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.product.domain.AcrmFpdProdInfo;
import cn.com.yusys.yscrm.product.domain.OcrmFpdDrumbeating;
import cn.com.yusys.yscrm.product.repository.mapper.OcrmFpdDrumbeatingMapper;
/**
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: OcrmFpdDrumbeatingService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-19 10:36:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFpdDrumbeatingService extends CommonService {
    @Autowired
    private OcrmFpdDrumbeatingMapper ocrmFpdDrumbeatingMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFpdDrumbeatingMapper;
    }
    
    /**
     * @方法名称: publicityMaterialQuery
	 * @方法描述: 宣传资料查询
	 * @param 
	 * @return
	 */
	public List<Map<String, Object>> publicityMaterialQuery(QueryModel model, String prodId){
		PageHelper.startPage(model.getPage(), model.getSize());
		model.getCondition().put("prodId", prodId);
		List<Map<String, Object>> list = ocrmFpdDrumbeatingMapper.publicityMaterialQuery(model);
		PageHelper.clearPage();
		return list;	
	}
	
	/**
     * @方法名称: createPublicityAaterial
	 * @方法描述: 宣传资料新增
	 * @param 
	 * @return
	 */
	public int createPublicityAaterial(OcrmFpdDrumbeating ocrmFpdDrumbeating) {
		return this.insertSelective(getMapper(), ocrmFpdDrumbeating);
	}
	
	/**
     * @方法名称: updatePublicityAaterial
	 * @方法描述: 宣传资料修改
	 * @param 
	 * @return
	 */
	public int updatePublicityAaterial(OcrmFpdDrumbeating ocrmFpdDrumbeating) {
		return this.updateSelective(getMapper(), ocrmFpdDrumbeating);
	}
	
	/**
     * @方法名称: delertePublicityAaterial
	 * @方法描述: 宣传资料删除
	 * @param 
	 * @return
	 */
	public int deletePublicityAaterial(String id) {
		QueryModel queryModel = new QueryModel();
		queryModel.getCondition().put("id", id);
		//同时删除附件信息
		ocrmFpdDrumbeatingMapper.deleteAttachmentInformation(queryModel);
		return ocrmFpdDrumbeatingMapper.deletePublicityAaterial(queryModel);
	}

}
