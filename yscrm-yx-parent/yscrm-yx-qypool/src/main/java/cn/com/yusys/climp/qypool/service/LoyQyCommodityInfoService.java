package cn.com.yusys.climp.qypool.service;
import cn.com.yusys.climp.qypool.domain.LoyQyCommPicture;
import cn.com.yusys.climp.qypool.domain.LoyQyCommodityInfo;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyCommModelMapper;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyCommPictureMapper;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyCommodityInfoMapper;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyMerchantInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommodityInfoService
 * @类描述: 商品信息服务类
 * @功能描述:
 * @创建人: chenlin
 * @创建时间: 2019-02-26
 * @修改备注:
 * @修改记录: 修改时间： 2019-07-23 修改人员： yangxiao2 修改原因： 配合页面改造加入新接口
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyQyCommodityInfoService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(LoyQyCommodityInfoService.class);
	@Autowired
	private LoyQyCommodityInfoMapper loyQyCommodityInfoMapper;
	@Autowired
	private LoyQyCommPictureMapper picMapper;
	@Autowired
	private LoyQyCommModelMapper modelMapper;
	@Autowired
	private LoyQyMerchantInfoMapper loyQyMerchantInfoMapper;
//	@Autowired
//	private IClientService clientService;
    @Autowired
    private UserInfoService userInfoService;

	@Override
	protected CommonMapper<?> getMapper() {
		return loyQyCommodityInfoMapper;
	}
	public String getUuid() {
		OgnlContext contxet = new OgnlContext();
		try {
			Object ognl = Ognl.parseExpression("@java.util.UUID@randomUUID().toString().replace(\"-\", \"\")");
			return Ognl.getValue(ognl, contxet, contxet.getRoot()).toString();
		} catch (OgnlException var3) {
			var3.printStackTrace();
			return null;
		}
	}

	/**
	 * @方法名称:getCommodity
	 * @方法描述:商品信息查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<LoyQyCommodityInfo> getCommodity(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<LoyQyCommodityInfo> list = loyQyCommodityInfoMapper.getCommodity(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	 * @方法名称:getCommodityById
	 * @方法描述:根据ID查询商品信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<LoyQyCommodityInfo> getCommodityById(String id) {
		Map<String,Object> param=new HashMap<String,Object>();
		List<LoyQyCommodityInfo> list=new ArrayList<LoyQyCommodityInfo>();
		if(id!=null) {
			param.put("ids", id.split(","));
			 list = loyQyCommodityInfoMapper.getCommodityById(param);
		}
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


	public String getRandom() {
		String result = "";
		int flag = new Random().nextInt(999999);
		if (flag < 100000) {
			flag += 100000;
		}
		result = "" + flag;
		return result;
	}

	/**
	 * 信息新增
	 */
	@Override
	public int insert(Object record) {
		LoyQyCommodityInfo commodity = (LoyQyCommodityInfo) record;
		String loginCode = SecurityUtils.getCurrentUserLogin();
		String code = commodity.getCommodityType() + commodity.getSuitObjType() + commodity.getCategoryCode()
				+ getRandom();
		if (commodity.getCommodityCode() == null || "".equals(commodity.getCommodityCode())){
			commodity.setCommodityCode(code);
		}
		if (commodity.getCategoryCode() == null || "".equals(commodity.getCategoryCode())){
			commodity.setCategoryCode("0");
		}
		List<Map<String, Object>> list = loyQyCommodityInfoMapper.getPropByName("COMM_DETAIL_PREFIX");
		// TODO 自动生成的方法存根
		String sign = (String) list.get(0).get("PROP_VALUE");
		String path = sign + "&goodId=" + code;
		commodity.setWfApprSts("000");
		commodity.setUpDownState("20");// 默认下架
		commodity.setCommodityStgNum(BigDecimal.ZERO);
		commodity.setCommoditySalNum(BigDecimal.ZERO);
		commodity.setCommodityLink(path);// 商品链接
		commodity.setCreateDate(getDate2String(new Date()));
		commodity.setCreateOrg(getOrgCode());
		commodity.setCreateUser(loginCode);
		commodity.setUpdateDate(getDate2String(new Date()));
		commodity.setUpdateOrg(getOrgCode());
		commodity.setUpdateUser(loginCode);
		commodity.setDelFlag("0");
		logger.info("商品信息新增数据：【新增商品名称：" + commodity.getCommodityName() + "】 " + getDate2String(new Date()));
		return super.insertSelective(commodity);
	}

	/**
	 * 信息修改
	 */
	@Override
	public int update(Object record) {
		LoyQyCommodityInfo commodity = (LoyQyCommodityInfo) record;
		String loginCode = SecurityUtils.getCurrentUserLogin();
		// TODO 自动生成的方法存根
		commodity.setUpdateDate(getDate2String(new Date()));
		commodity.setUpdateOrg(getOrgCode());
		commodity.setUpdateUser(loginCode);
		logger.info("商品信息修改数据：【修改商品名称：" + commodity.getCommodityName() + "】的相关数据； " + getDate2String(new Date()));
		return super.updateSelective(commodity);
	}
	/**
	 * 
	* @方法名称:deleteImage
	* @方法描述:删除图片文件
	* @参数与返回说明:
	* @算法描述:
	 */
	public void deleteImage(String name){
		String filepath = ""//系统上传路径（配置文件获取）
				+ File.separator + name;
		File file=new File(filepath);
		if(file.exists()){
			file.delete();
			System.out.print("删除图片:"+name);
		}
		
	}
	/**
	* @方法名称:delCommodity
	* @方法描述:删除商品信息
	* @参数与返回说明:
	* @算法描述:
	 */
	public int delCommodity(String id) {
		List<Map<String,Object>> picList = picMapper.getCommPic(id);
		for(int i=0;i<picList.size();i++){
			String path=  picList.get(i).get("picturePath").toString();
			deleteImage(path);
		}
		picMapper.delCommPic(id);
		modelMapper.delCommModel(id);
		return loyQyCommodityInfoMapper.delFlagEdit(id);
	}
	/**
	* @方法名称:downShel
	* @方法描述:商品下架
	* @参数与返回说明:
	* @算法描述:
	 */
	public int doUpdateUpDown(String[] idStr,String upDownState,String onShelfBegin,String onShelfEnd) throws Exception{
		int count = 0;
		for(int i =0;i<idStr.length;i++) {
			LoyQyCommodityInfo commodity = loyQyCommodityInfoMapper.selectByPrimaryKey(idStr[i]);
			commodity.setUpDownState(upDownState);
			if("U".equals(upDownState)) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				commodity.setOnShelfBegin(df.parse(onShelfBegin));
				commodity.setOnShelfEnd(df.parse(onShelfEnd));
			}
			count+=update(commodity);
		}
		return count;
	}
	/**
	* @方法名称:upLoad
	* @方法描述:提交审批
	* @参数与返回说明:
	* @算法描述:
	 */
	public int upLoadCommodity(String id,String wfApprSts) {
		int count = 0;
		LoyQyCommodityInfo record = loyQyCommodityInfoMapper.selectByPrimaryKey(id);
		record.setWfApprSts(wfApprSts);
		count += update(record);
		return count;
	}
	
	/**
	* @方法名称:getOrgByInstuValue
	* @方法描述:通过金融机构查询机构列表
	* @参数与返回说明: instuValue-机构id
	* @算法描述:
	 */
	public List<Map<String,Object>>getOrgByInstuValue(String instuValue) {
		return loyQyCommodityInfoMapper.getOrgByInstuValue(instuValue);
	}

	public Map<String, Object> getDetail(String id) {
		Map<String,Object> map = new HashMap<>();
		LoyQyCommodityInfo loyQyCommodityInfo = loyQyCommodityInfoMapper.getOneCommodityById(id);
		map.put("comm",loyQyCommodityInfo);
		map.put("mer",loyQyMerchantInfoMapper.getInfoById(loyQyCommodityInfo.getBelongMerchant()));
		map.put("pic",loyQyCommodityInfoMapper.getPic(id));
		map.put("attr",loyQyCommodityInfoMapper.getAttr(id));
		return map;
	}

	public List<Map<String, String>> getAttr(QueryModel queryModel) {
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, String>> list = loyQyCommodityInfoMapper.getExAttr(queryModel);
		PageHelper.clearPage();
		return list;
	}

	public int addCommAttr(Map<String, String> map) {
		String commId = map.get("commodityId");
		loyQyCommodityInfoMapper.deleteExAttr(commId);
		List<Map<String,String>> list = new ArrayList<>();
		List<String> attrs = Arrays.asList(map.get("attrId").split(","));
		for (String s : attrs) {
			Map<String,String> map_0 = new HashMap<>();
			map_0.put("attrId",s);
			map_0.put("commodityId",commId);
			map_0.put("serId",getUuid());
			list.add(map_0);
		}
		return loyQyCommodityInfoMapper.addCommAttr(list);
	}
}
