package cn.com.yusys.climp.qypool.service;

import cn.com.yusys.climp.qypool.domain.LoyQyCommodityCategory;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyCommodityCategoryMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommodityCategoryService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26 14:39:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyQyCommodityCategoryService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(LoyQyCommodityCategoryService.class);
    @Autowired
    private LoyQyCommodityCategoryMapper loyQyCommodityCategoryMapper;
//    @Autowired
//////	private IClientService clientService;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected CommonMapper<?> getMapper() {
        return loyQyCommodityCategoryMapper;
    }
    /**
     * @方法名称:getCategory
     * @方法描述:商品类别树查询
     * @参数与返回说明:
     * @算法描述:
      */
     public List<LoyQyCommodityCategory> getCategoryTree() {
 		List<LoyQyCommodityCategory> list = loyQyCommodityCategoryMapper.getCategoryTree();
 		return list;
 	}
    /**
    * @方法名称:getCategory
    * @方法描述:商品类别查询
    * @参数与返回说明:
    * @算法描述:
     */
    public List<LoyQyCommodityCategory> getCategory(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<LoyQyCommodityCategory> list = loyQyCommodityCategoryMapper.getCategory(model);
		PageHelper.clearPage();
		return list;
	}
    /**
    * @方法名称:getOrgCode
    * @方法描述:获取登录用户的机构号
    * @参数与返回说明:
    * @算法描述:
     */
    public String getOrgCode(){
//		ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
//		String orgCode = dto.getBody().getOrg().getCode();
//		return orgCode;
        return userInfoService.getOrgCode();
	}
    /**
    * @方法名称:getDate2String
    * @方法描述:获取String时间
    * @参数与返回说明:
    * @算法描述:
     */
    public String getDate2String(Date date) {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
    	return df.format(date);
    }
    /**
    * @方法名称:getSequenceNo
    * @方法描述:获取类别编号
    * @参数与返回说明:
    * @算法描述:
     */
    public String getSequenceNo(String sequence) {
    	int count = loyQyCommodityCategoryMapper.getSequenceNo(sequence);
		String sequenceNo = "";
    	if(sequence.equals("0000")) {
    		sequence = "0";
    	}
    	if(count == 0) {
    		sequenceNo = sequence+"0"+1;
    	}else {
    		sequenceNo = sequence+"0"+(Integer.parseInt(sequenceNo)+1);
    	}
    	return sequenceNo;
    }
    
    /**
     * 类别新增
     */
    @Override
    public int insert(Object record) {
    	LoyQyCommodityCategory category = (LoyQyCommodityCategory) record;
    	String loginCode = SecurityUtils.getCurrentUserLogin();
    	// TODO 自动生成的方法存根
    	category.setCategoryCode(getSequenceNo(category.getParentCategoryCode()));
    	// category.setCategoryStatus("1");
    	category.setCreateDate(getDate2String(new Date()));
    	category.setCreateOrg(getOrgCode());
    	category.setCreateUser(loginCode);
    	category.setUpdateDate(getDate2String(new Date()));
    	category.setUpdateOrg(getOrgCode());
    	category.setUpdateUser(loginCode);
    	logger.info("商品类别新增数据：【新增类别名称：" + category.getCategoryName() + "】 " + getDate2String(new Date()));
    	return super.insertSelective(category);
    }
    /**
     * 类别修改
     */
    @Override
    public int update(Object record) {
    	LoyQyCommodityCategory category = (LoyQyCommodityCategory) record;
    	String loginCode = SecurityUtils.getCurrentUserLogin();
    	// TODO 自动生成的方法存根
    	category.setUpdateDate(getDate2String(new Date()));
    	category.setUpdateOrg(getOrgCode());
    	category.setUpdateUser(loginCode);
    	Map<String, String> map = new HashMap<>();
		map.put("categoryCode", category.getCategoryCode());
		map.put("categoryName", category.getCategoryName());
		map.put("updateDate", getDate2String(new Date()));
		map.put("orgCode", getOrgCode());
		map.put("userCode", loginCode);
    	loyQyCommodityCategoryMapper.updateCategory(map);
    	logger.info("商品类别修改数据：【修改类别名称：" + category.getCategoryName() + "】的相关数据； " + getDate2String(new Date()));
    	return super.updateSelective(category);
    }
    /**
    * @方法名称:delCategory
    * @方法描述:商品类别删除
    * @参数与返回说明:
    * @算法描述:
     */
    public int delCategory(String categoryCode) {
		if (loyQyCommodityCategoryMapper.getNodeCommodity(categoryCode) == 0) {
			// 类别下没有商品时可以删除
			logger.info("商品类别删除  【类目编号：" + categoryCode + "】 " + getDate2String(new Date()));
			return loyQyCommodityCategoryMapper.delCategory(categoryCode);
		} else {
			return -1;
		}
	}
    public List<Map<String,Object>>getInstus(){
    	return loyQyCommodityCategoryMapper.getInstus();
    }
}
