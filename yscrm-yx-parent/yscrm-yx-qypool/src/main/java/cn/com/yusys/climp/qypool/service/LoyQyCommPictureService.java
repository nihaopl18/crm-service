package cn.com.yusys.climp.qypool.service;

import cn.com.yusys.climp.qypool.domain.LoyQyCommPicture;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyCommPictureMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
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
 * @类名称: LoyQyCommPictureService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26 14:40:21
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyQyCommPictureService extends CommonService {
    @Autowired
    private LoyQyCommPictureMapper loyQyCommPictureMapper;
    private Logger logger = LoggerFactory.getLogger(LoyQyCommPictureService.class);
//	@Autowired
//	private IClientService clientService;
    @Autowired
    private UserInfoService userInfoService;

	@Autowired
	private LoyQyCommodityInfoService comminfoService;
    @Override
    protected CommonMapper<?> getMapper() {
        return loyQyCommPictureMapper;
    }
    /**
    * @方法名称:getPicture
    * @方法描述:根据商品编号查询商品图片
    * @参数与返回说明:
    * @算法描述:
     */
    public List<LoyQyCommPicture> getPicture(String commodityCode) {
		List<LoyQyCommPicture> list = loyQyCommPictureMapper.getPicture(commodityCode);
		return list;
	}
    /**
	 * @方法名称:getOrgCode
	 * @方法描述:获取登录用户的机构号
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public String getOrgCode() {
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
	 * 商品图片新增
	 */
	@Override
	public int insert(Object record) {
		LoyQyCommPicture picture = (LoyQyCommPicture) record;
		String loginCode = SecurityUtils.getCurrentUserLogin();
		// TODO 自动生成的方法存根
		picture.setCreateDate(getDate2String(new Date()));
		picture.setCreateOrg(getOrgCode());
		picture.setCreateUser(loginCode);
		picture.setUpdateDate(getDate2String(new Date()));
		picture.setUpdateOrg(getOrgCode());
		picture.setUpdateUser(loginCode);
		logger.info("商品图片新增数据：【新增图片名称：" + picture.getPictureName() + "】 " + getDate2String(new Date()));
		return super.insertSelective(picture);
	}

	/**
	 * 商品图片修改
	 */
	@Override
	public int update(Object record) {
		LoyQyCommPicture picture = (LoyQyCommPicture) record;
		String loginCode = SecurityUtils.getCurrentUserLogin();
		// TODO 自动生成的方法存根
		picture.setUpdateDate(getDate2String(new Date()));
		picture.setUpdateOrg(getOrgCode());
		picture.setUpdateUser(loginCode);
		logger.info("商品图片修改数据：【修改图片名称：" + picture.getPictureName() + "】的相关数据； " + getDate2String(new Date()));
		return super.updateSelective(picture);
	}
	/**
	 * 新增或者修改商品图片信息时，判断是否能够新增或者修改缩略图。
	 * 判断逻辑：每个商品最多只能有一张缩略图，如果已存在一个缩略图，那么不能再新增，不能再修改其它记录为缩略图（修改的那条记录本身除外）
	 * @param commodityCode 商品编号
	 * @param pictureType 图片类型，01代表缩略图
	 * @param id 商品图片信息表主键
	 * @return 可以新增/修改缩略图图片，返回false，反之返回true
	 */
	public boolean isRepeatThumbnail(String commodityCode,String pictureType,String id){
		boolean result = false;
		if("10".equals(pictureType)){
			Map<String, Object> map = new HashMap<>();
			map.put("commodityCode", commodityCode);
			map.put("id", id);
			List<LoyQyCommPicture> list = loyQyCommPictureMapper.isRepeatThumbnail(map);
			if(list != null && list.size() > 0){
				result = true;
			}
		}
		return result;
	}
	/**
	* @方法名称:delPic
	* @方法描述:商品图片删除
	* @参数与返回说明:
	* @算法描述:
	 */
	public int delPic(String[] idStr) {
		int count = 0;
		for(int i = 0;i<idStr.length;i++) {
			LoyQyCommPicture picture = loyQyCommPictureMapper.selectByPrimaryKey(idStr[i]);
			// String path  = picture.getPicturePath().split("path=")[1];
			String path = picture.getPicturePath();
			comminfoService.deleteImage(path);
			count += loyQyCommPictureMapper.deleteByPrimaryKey(idStr[i]);
		}
		return count;
	}
}
