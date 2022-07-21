package cn.com.yusys.climp.qypool.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.qypool.domain.LoyQyCommPicture;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommPictureMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26 14:40:21
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyQyCommPictureMapper extends CommonMapper<LoyQyCommPicture> {
	/**
	* @方法名称:getPicture
	* @方法描述:根据商品编号查询商品图片list
	* @参数与返回说明:
	* @算法描述:
	 */
	List<LoyQyCommPicture> getPicture(String commodityCode);
	/**
	* @方法名称:getCommPic
	* @方法描述:根据商品id查询商品图片
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String,Object>> getCommPic(String commId);
	/**
	* @方法名称:delCommPic
	* @方法描述:根据商品id删除商品图片
	* @参数与返回说明:
	* @算法描述:
	 */
	int delCommPic(String commId);
	/**
	 * 新增或者修改商品图片信息时，判断是否能够新增或者修改缩略图。
	 * 判断逻辑：每个商品最多只能有一张缩略图，如果已存在一个缩略图，那么不能再新增，不能再修改其它记录为缩略图（修改的那条记录本身除外）
	 * @param commodityCode 商品编号
	 * @param pictureType 图片类型，01代表缩略图
	 * @param id 商品图片信息表主键
	 * @return 可以新增/修改缩略图图片，返回false，反之返回true
	 */
	List<LoyQyCommPicture> isRepeatThumbnail(Map<?, ?> map);
}