package cn.com.yusys.yscrm.product.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import cn.com.yusys.yscrm.product.domain.AcrmFPdProdShortInfo;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.product.domain.AcrmFpdProdCatl;
import cn.com.yusys.yscrm.product.domain.AcrmFpdProdInfo;
import cn.com.yusys.yscrm.product.repository.mapper.AcrmFpdProdInfoMapper;
/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFpdProdInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-01-29 15:15:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFpdProdInfoService extends CommonService {
    @Autowired
    private AcrmFpdProdInfoMapper acrmFpdProdInfoMapper;

	@Autowired
	private UaaClient uaaClient;

	/**
	 * 信托
	 */
	@Value("${prodType.trust}")
	public String  TRUST;
	/**
	 * 代销信托
	 */
	@Value("${prodType.contrust}")
	public String  CON_TRUST;
	/**
	 * 结构化理财
	 */
	@Value("${prodType.struct}")
	public String STRUCT;
	/**
	 * QDII
	 */
	@Value("${prodType.qdii}")
	public String QDII;
	/**
	 * 代收付
	 */
	@Value("${prodType.agent}")
	public String AGENT;
	/**
	 * 人民币基金
	 */
	@Value("${prodType.fund}")
	public String FUND;
	/**
	 * 资管
	 */
	@Value("${prodType.manag}")
	public String MANAG;
	/**
	 * 存款
	 */
	@Value("${prodType.deposit}")
	public String DEPOSIT;
	/**
	 * 保险
	 */
	@Value("${prodType.insurance}")
	public String INSURANCE;
	/**
	 * 贷款
	 */
	@Value("${prodType.loan}")
	public String LOAN;
	/**
	 * 信用卡
	 */
	@Value("${prodType.creditcard}")
	public String CREDITCARD;

	/**
	 * 理财
	 */
	@Value("${prodType.fin}")
	public String FIN;

	private static final String PRODUCTID = "productId";
    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFpdProdInfoMapper;
    }

	private Map<String,String> getUserMap(){
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		Map<String,String> map = new HashMap<>();
		map.put("_userCode", dto.getBody().getLoginCode());
		map.put("_orgCode",dto.getBody().getOrg().getCode());
		return map;
	}

    /**
     * @方法名称: productInfoQuery
	 * @方法描述: 产品信息查询
	 * @param 
	 * @return
	 */
	public List<AcrmFPdProdShortInfo> productInfoQuery(QueryModel model){
		if (model.getCondition().get("catlCode") != null && !"".equals(model.getCondition().get("catlCode"))){
			model.getCondition().put("prodCode",model.getCondition().get("catlCode") + "%");
		}
		if (model.getCondition().get("prodName") != null && !"".equals(model.getCondition().get("prodName"))){
			model.getCondition().put("prodName","%" + model.getCondition().get("prodName") + "%");
		}
		PageHelper.startPage(model.getPage(), model.getSize());
		List<AcrmFPdProdShortInfo> list = acrmFpdProdInfoMapper.productInfoQuery(model);
		PageHelper.clearPage();
		return list;	
	}

	/**
     * @方法名称: ctrateProductInfo
	 * @方法描述: 产品信息新增
	 * @param 
	 * @return
	 */
	public int ctrateProductInfo(Map<String, Object> map) {
		int rel = 0;
		String productId = (String) map.get(PRODUCTID);
		String num = this.createCheckProdId(productId);
		if(num.equals("0")) {
			rel = this.insertSelective(getMapper(), map);
		} else {
			rel = 111;
		}
		return rel;
	}
	
	/**
     * @方法名称: editProductInfo
	 * @方法描述: 产品信息修改
	 * @param 
	 * @return
	 */
	public int editProductInfo(Map<String, Object> map) {
		int rel = 0;
		String productId = (String) map.get(PRODUCTID);
		String proId = (String) map.get("proId");
		String num = this.editCheckProdId(productId,proId);
		Object prodStartDateObj=map.get("prodStartDate");
		Object prodEndDateObj=map.get("prodEndDate");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(prodStartDateObj!=null&&!prodStartDateObj.toString().equals("")) {
			Date prodStartDate = null;
			try {
				prodStartDate = sdf.parse(prodStartDateObj.toString());
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			map.put("prodStartDate", prodStartDate);
		}
		if(prodEndDateObj!=null&&!prodEndDateObj.toString().equals("")) {
			Date prodEndDate = null;
			try {
				prodEndDate = sdf.parse(prodEndDateObj.toString());
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			map.put("prodEndDate", prodEndDate);
		}
		if(num.equals("0")) {
			rel = this.updateSelective(getMapper(), map);
		} else {
			rel = 111;
		}
		return rel;
	}
	
	private String createCheckProdId(String productId) {
		String num = "";
		List<Map<String, Object>> list = acrmFpdProdInfoMapper.createCheckProdId(productId);
		num = String.valueOf(list.get(0).get("num"));
		return num;
	}
	
	private String editCheckProdId(String productId,String proId) {
		String num = "";
		List<Map<String, Object>> list = acrmFpdProdInfoMapper.editCheckProdId(productId,proId);
		num = String.valueOf(list.get(0).get("num"));
		return num;
	}
	
	/**
     * @方法名称: delerteProductInfo
	 * @方法描述: 产品信息删除
	 * @param 
	 * @return
	 */
	public int delerteProductInfo(String productId) {
		QueryModel queryModel = new QueryModel();
		queryModel.getCondition().put(PRODUCTID, productId);
		return acrmFpdProdInfoMapper.delerteProductInfo(queryModel);
	}
	
	/**
	 * 列表查询
	 * 
	 * @param prodCode 产品类别
	 * @param prodId 产品编号
	 * @return
	 */
	public List<Map<String, Object>> productBasicInfoQuery(String prodCode,String prodId) {
		List<Map<String, Object>> list = new ArrayList<>();
		String prodCode_str = prodCode.substring(0,3);
		if (INSURANCE.contains(prodCode_str)){
			list = acrmFpdProdInfoMapper.insuranceProductBasicInfoQuery(prodCode, prodId);
		} else if (LOAN.contains(prodCode_str)){
			list = acrmFpdProdInfoMapper.loanProductBasicInfoQuery(prodCode, prodId);
		} else if (CREDITCARD.contains(prodCode_str)){
			list = acrmFpdProdInfoMapper.creditcardProductBasicInfoQuery(prodCode, prodId);
		} else if (DEPOSIT.contains(prodCode_str)){
			list = acrmFpdProdInfoMapper.depositProductBasicInfoQuery(prodCode, prodId);
		} else if (FIN.contains(prodCode_str)){
			prodCode_str = prodCode.substring(0, 5);
			if (TRUST.contains(prodCode_str)) {
				list = acrmFpdProdInfoMapper.trustProductBasicInfoQuery(prodCode, prodId);
			} else if (STRUCT.contains(prodCode_str)) {
				list = acrmFpdProdInfoMapper.structProductBasicInfoQuery(prodCode, prodId);
			} else if (QDII.contains(prodCode_str)) {
				list = acrmFpdProdInfoMapper.qdiiProductBasicInfoQuery(prodCode, prodId);
			} else if (AGENT.contains(prodCode_str)) {
				list = acrmFpdProdInfoMapper.agentProductBasicInfoQuery(prodCode, prodId);
			} else if (FUND.contains(prodCode_str)) {
				list = acrmFpdProdInfoMapper.fundProductBasicInfoQuery(prodCode, prodId);
			} else if (CON_TRUST.contains(prodCode_str)) {
				list = acrmFpdProdInfoMapper.conTrustProductBasicInfoQuery(prodCode, prodId);
			} else if (MANAG.contains(prodCode_str)) {
				list = acrmFpdProdInfoMapper.managProductBasicInfoQuery(prodCode, prodId);
			}
		}
		list.forEach(item->{
			if (item.containsKey("allrowCustPpropertyGroup") && !"".equals((String)item.get("allrowCustPpropertyGroup"))
					&& ((String)item.get("allrowCustPpropertyGroup")).length() > 1){
				String allrowCustPpropertyGroup = (String)item.get("allrowCustPpropertyGroup");
				List<String> allrowCustPpropertyGroups = new ArrayList<>();
				for (int i = 0; i < allrowCustPpropertyGroup.length(); i++){
					allrowCustPpropertyGroups.add(String.valueOf(allrowCustPpropertyGroup.charAt(i)));
				}
				item.put("allrowCustPpropertyGroup",allrowCustPpropertyGroups);
			}
			if (item.containsKey("allowCustPropertyGroup") && !"".equals((String)item.get("allowCustPropertyGroup"))
					&& ((String)item.get("allowCustPropertyGroup")).length() > 1){
				String allrowCustPpropertyGroup = (String)item.get("allowCustPropertyGroup");
				List<String> allrowCustPpropertyGroups = new ArrayList<>();
				for (int i = 0; i < allrowCustPpropertyGroup.length(); i++){
					allrowCustPpropertyGroups.add(String.valueOf(allrowCustPpropertyGroup.charAt(i)));
				}
				item.put("allowCustPropertyGroup",allrowCustPpropertyGroups);
			}
			if (item.containsKey("allowChannelGroup") && !"".equals((String)item.get("allowChannelGroup"))
					&& ((String)item.get("allowChannelGroup")).length() > 1){
				String allowChannelGroup = (String)item.get("allowChannelGroup");
				List<String> allowChannelGroups = new ArrayList<>();
				for (int i = 0; i < allowChannelGroup.length(); i++){
					allowChannelGroups.add(String.valueOf(allowChannelGroup.charAt(i)));
				}
				item.put("allowChannelGroup",allowChannelGroups);
			}
			if (item.containsKey("prodSaleRange") && !"".equals((String)item.get("prodSaleRange"))){
				List<String> prodSaleRanges = Arrays.asList(((String) item.get("prodSaleRange")).split(";"));
				if (prodSaleRanges.size() > 0){
					item.put("prodSaleRange",prodSaleRanges);
				}
			}
		});
		return list;
	}

	/**
	 * @方法名称: productNetValueInfoQuery
	 * @方法描述: 产品净值趋势
	 * @param queryModel
	 * @return
	 */
    public List<Map<String, Object>> productNetValueInfoQuery(QueryModel queryModel) {
		List<Map<String, Object>> list = acrmFpdProdInfoMapper.productNetValueInfoQuery(queryModel);
		return list;
    }

	/**
	 * @方法名称: productCustFitInfoQuery
	 * @方法描述: 客户收益
	 * @param queryModel
	 * @return
	 */
	public List<Map<String, Object>> productCustFitInfoQuery(QueryModel queryModel) {
		Map<String,Object> map = new HashMap<>();
		map.put("condition",queryModel.getCondition());
		map.putAll(getUserMap());
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = acrmFpdProdInfoMapper.productCustFitInfoQuery(map);
		PageHelper.clearPage();
		return list;
	}
}
