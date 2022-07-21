package cn.com.yusys.yscrm.sysview.service;

import cn.com.yusys.yscrm.sysview.domain.*;
import cn.com.yusys.yscrm.sysview.domain.constans.ProdConfRaInfoEnum;
import cn.com.yusys.yscrm.sysview.repository.mapper.AcrmAbrBusiSumInfoMapper;
import cn.com.yusys.yscrm.sysview.utils.DateUtils;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: sxm
 * @time: 2021/8/15 20:39
 */
@Service
public class AcrmAbrBusiSumInfoService {

	@Autowired
	private AcrmAbrBusiSumInfoMapper acrmAbrBusiSumInfoMapper;
	/**
	 * 信托
	 */
	public static final String TRUST = "0";
	/**
	 * 结构化理财
	 */
	public static final String STRUCT = "1";
	/**
	 * QDII
	 */
	public static final String QDII = "2";
	/**
	 * 代收付
	 */
	public static final String AGENT = "3";
	/**
	 * 人民币基金
	 */
	public static final String FUND = "4";
	/**
	 * 活期存款
	 */
	public static final String CURRENT_DEPOSIT = "51";
	/**
	 * 定期存款
	 */
	public static final String FIXED_DEPOSIT = "52";
	/**
	 * 保险
	 */
	public static final String INSURANCE = "6";
	/**
	 * 贷款
	 */
	public static final String LOAN = "7";
	/**
	 * 信用卡
	 */
	public static final String CREDITCARD = "8";

    @Transactional(readOnly = true)
    public List getProdHoldDeInfo(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        List list = new ArrayList();
            if (model.getCondition().get("prodType") != null && !"".equals(model.getCondition().get("prodType"))) {
                if (TRUST.equals(model.getCondition().get("prodType")) || STRUCT.equals(model.getCondition().get("prodType")) || QDII.equals(model.getCondition().get("prodType")) || AGENT.equals(model.getCondition().get("prodType")) || FUND.equals(model.getCondition().get("prodType"))) {
                    list = acrmAbrBusiSumInfoMapper.getProdHoldDeInfo(model);
                }
                if (CURRENT_DEPOSIT.equals(model.getCondition().get("prodType")) || FIXED_DEPOSIT.equals(model.getCondition().get("prodType"))) {
                    list = acrmAbrBusiSumInfoMapper.getDepositProdHoldDel(model);
                }
                if (INSURANCE.equals(model.getCondition().get("prodType"))) {
                    list = acrmAbrBusiSumInfoMapper.getInsuranceProdHoldDel(model);
                }
                if (LOAN.equals(model.getCondition().get("prodType"))) {
                    list = acrmAbrBusiSumInfoMapper.getLoanProdHoldDel(model);
                }
                if (CREDITCARD.equals(model.getCondition().get("prodType"))) {
                    list = acrmAbrBusiSumInfoMapper.getCreditCardProdHoldDel(model);
                }
            }
//            if (LOAN.equals(model.getCondition().get("prodType"))) {
//                list = acrmAbrBusiSumInfoMapper.getLoanProdHoldDel(model);
//            }
//            if (CREDITCARD.equals(model.getCondition().get("prodType"))) {
//                list = acrmAbrBusiSumInfoMapper.getCreditCardProdHoldDel(model);
//            }
        PageHelper.clearPage();
        return list;
    }

	@Transactional(readOnly = true)
	public Map<String, Object> getProdConfRaInfo(QueryModel model) {
		Map<String, Object> map = new HashMap();
		Map prodConfRaInfoMap = new HashMap();
		ProdConfRaInfo prodConfRaInfo = acrmAbrBusiSumInfoMapper.getProdConfRaInfo(model);
		if (prodConfRaInfo != null) {
			prodConfRaInfoMap.put(ProdConfRaInfoEnum.TRUSTBALANCERMB.getEnglishName(), new ProdConfRaDetail(
					ProdConfRaInfoEnum.TRUSTBALANCERMB.getChineseName(), prodConfRaInfo.getTrustBalanceRmb()));
			prodConfRaInfoMap.put(ProdConfRaInfoEnum.RMBFUNDBALANCE.getEnglishName(), new ProdConfRaDetail(
					ProdConfRaInfoEnum.RMBFUNDBALANCE.getChineseName(), prodConfRaInfo.getRmbFundBalance()));
			prodConfRaInfoMap.put(ProdConfRaInfoEnum.STRUCTFINBALANCE.getEnglishName(), new ProdConfRaDetail(
					ProdConfRaInfoEnum.STRUCTFINBALANCE.getChineseName(), prodConfRaInfo.getStructFinBalanceRmb()));
			prodConfRaInfoMap.put(ProdConfRaInfoEnum.TIMEDEPOSITBALANCE.getEnglishName(), new ProdConfRaDetail(
					ProdConfRaInfoEnum.TIMEDEPOSITBALANCE.getChineseName(), prodConfRaInfo.getTimeDepositBalance()));
			prodConfRaInfoMap.put(ProdConfRaInfoEnum.DEMANDDEPOSITBALANCE.getEnglishName(), new ProdConfRaDetail(
					ProdConfRaInfoEnum.DEMANDDEPOSITBALANCE.getChineseName(), prodConfRaInfo.getDemandDepositBalance()));
			prodConfRaInfoMap.put(ProdConfRaInfoEnum.QDIIBALANCERMB.getEnglishName(), new ProdConfRaDetail(
					ProdConfRaInfoEnum.QDIIBALANCERMB.getChineseName(), prodConfRaInfo.getQdiiBalanceRmb()));
			prodConfRaInfoMap.put(ProdConfRaInfoEnum.INSURRANCEBALANCE.getEnglishName(), new ProdConfRaDetail(
					ProdConfRaInfoEnum.INSURRANCEBALANCE.getChineseName(), prodConfRaInfo.getInsurranceBalance()));
			map.put("prodConfRaInfo", prodConfRaInfoMap);
		} else {
			map.put("prodConfRaInfo", null);
		}
		return map;
	}

	public List export(HttpServletResponse response, QueryModel model) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		// 这里URLEncoder.encode可以防止中文乱码
		String fileName = URLEncoder.encode("产品持有详情", "UTF-8").replaceAll("\\+", "%20");
		response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
		if (model.getCondition().get("prodType") != null && !"".equals(model.getCondition().get("prodType"))) {
			if (!((String)model.getCondition().get("prodType")).contains("99")) {
				if (TRUST.equals(model.getCondition().get("prodType"))
						|| STRUCT.equals(model.getCondition().get("prodType"))
						|| QDII.equals(model.getCondition().get("prodType"))
						|| AGENT.equals(model.getCondition().get("prodType"))
						|| FUND.equals(model.getCondition().get("prodType"))) {
					List<ProdHoldDeInfo> list = acrmAbrBusiSumInfoMapper.exportProdHoldDeInfo(model);
					if (TRUST.equals(model.getCondition().get("prodType"))) {
						exportFile(response, "trust_template.xlsx", "信托", list);
					}
					if (STRUCT.equals(model.getCondition().get("prodType"))) {
						exportFile(response, "struct_template.xlsx", "结构化理财", list);
					}
					if (QDII.equals(model.getCondition().get("prodType"))) {
						exportFile(response, "qdii_template.xlsx", "QDII", list);
					}
					if (AGENT.equals(model.getCondition().get("prodType"))) {
						exportFile(response, "agent_template.xlsx", "代收付", list);
					}
					if (FUND.equals(model.getCondition().get("prodType"))) {
						exportFile(response, "fund_template.xlsx", "人民币基金", list);
					}
				}
				if (CURRENT_DEPOSIT.equals(model.getCondition().get("prodType"))) {
					List<DepositProdHoldDel> list = acrmAbrBusiSumInfoMapper.exportDepositProdHoldDel(model);
					exportFile(response, "deposit_templat.xlsx", "活期存款", list);
				}
				if (FIXED_DEPOSIT.equals(model.getCondition().get("prodType"))) {
					List<DepositProdHoldDel> list = acrmAbrBusiSumInfoMapper.exportDepositProdHoldDel(model);
					exportFile(response, "deposit_templat.xlsx", "定期存款", list);
				}
				if (INSURANCE.equals(model.getCondition().get("prodType"))) {
					List<InsuranceProdHoldDel> list = acrmAbrBusiSumInfoMapper.exportInsuranceProdHoldDel(model);
					exportFile(response, "insurance_templat.xlsx", "保险", list);
				}
				if (LOAN.equals(model.getCondition().get("prodType"))) {
					List<LoanProdHoldDel> list = acrmAbrBusiSumInfoMapper.exportLoanProdHoldDel(model);
					exportFile(response, "loan_templat.xlsx", "贷款", list);
				}
				if (CREDITCARD.equals(model.getCondition().get("prodType"))) {
					List<CreditCardProdHoldDel> list = acrmAbrBusiSumInfoMapper.exportCreditCardProdHoldDel(model);
					exportFile(response, "creditcard_template.xlsx", "信用卡", list);
				}
			}else{
				exportFileAll(response,model);
			}
		}
		return null;
	}
	private void exportFileAll(HttpServletResponse response, QueryModel model) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", DateUtils.getCurrentDate());
		ExcelWriter excelWriter = null;
		Boolean financing = (boolean)model.getCondition().get("financing");
		Boolean loan = (boolean)model.getCondition().get("loan");
		Map<String, Object> condition = model.getCondition();
		if (financing && !loan){
			if ("99".equals(model.getCondition().get("prodType"))){
				String templateFileName = "templates" + File.separator + "fproduct_template.xlsx";
				excelWriter = EasyExcel.write(response.getOutputStream())
						.withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();

				WriteSheet writeSheet0 = EasyExcel.writerSheet(0,"活期存款").build();
				excelWriter.fill(map,writeSheet0);
				condition.put("prodType",CURRENT_DEPOSIT);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportDepositProdHoldDel(model),writeSheet0);

				WriteSheet writeSheet1 = EasyExcel.writerSheet(1,"定期存款").build();
				excelWriter.fill(map,writeSheet1);
				condition.put("prodType",FIXED_DEPOSIT);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportDepositProdHoldDel(model),writeSheet1);

				WriteSheet writeSheet2 = EasyExcel.writerSheet(2,"结构化理财").build();
				excelWriter.fill(map,writeSheet2);
				condition.put("prodType",STRUCT);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportProdHoldDeInfo(model),writeSheet2);

				WriteSheet writeSheet3 = EasyExcel.writerSheet(3,"人民币基金").build();
				excelWriter.fill(map,writeSheet3);
				condition.put("prodType",FUND);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportProdHoldDeInfo(model),writeSheet3);

				WriteSheet writeSheet4 = EasyExcel.writerSheet(4,"QDII").build();
				excelWriter.fill(map,writeSheet4);
				condition.put("prodType",QDII);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportProdHoldDeInfo(model),writeSheet4);

				WriteSheet writeSheet5 = EasyExcel.writerSheet(5,"信托").build();
				excelWriter.fill(map,writeSheet5);
				condition.put("prodType",TRUST);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportProdHoldDeInfo(model),writeSheet5);

				WriteSheet writeSheet6 = EasyExcel.writerSheet(6,"保险").build();
				excelWriter.fill(map,writeSheet6);
				condition.put("prodType",INSURANCE);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportInsuranceProdHoldDel(model),writeSheet6);

//				WriteSheet writeSheet3 = EasyExcel.writerSheet(3,"代收付").build();
//				excelWriter.fill(map,writeSheet3);
//				condition.put("prodType",AGENT);
//				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportProdHoldDeInfo(model),writeSheet3);

//				WriteSheet writeSheet8 = EasyExcel.writerSheet(8,"信用卡").build();
//				excelWriter.fill(map,writeSheet8);
//				condition.put("prodType",CREDITCARD);
//				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportCreditCardProdHoldDel(model),writeSheet8);
			} else if ("991".equals(model.getCondition().get("prodType"))){
				List<CreditCardProdHoldDel> list = acrmAbrBusiSumInfoMapper.exportCreditCardProdHoldDel(model);
				exportFile(response, "creditcard_template.xlsx", "信用卡", list);
			}
		}else if (!financing && loan){
			if ("99".equals(model.getCondition().get("prodType"))){
				String templateFileName = "templates" + File.separator + "lproduct_template.xlsx";
				excelWriter = EasyExcel.write(response.getOutputStream())
						.withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();

				WriteSheet writeSheet0 = EasyExcel.writerSheet(0,"活期存款").build();
				excelWriter.fill(map,writeSheet0);
				condition.put("prodType",CURRENT_DEPOSIT);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportDepositProdHoldDel(model),writeSheet0);

				WriteSheet writeSheet1 = EasyExcel.writerSheet(1,"定期存款").build();
				excelWriter.fill(map,writeSheet1);
				condition.put("prodType",FIXED_DEPOSIT);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportDepositProdHoldDel(model),writeSheet1);

				WriteSheet writeSheet2 = EasyExcel.writerSheet(2,"结构化理财").build();
				excelWriter.fill(map,writeSheet2);
				condition.put("prodType",STRUCT);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportProdHoldDeInfo(model),writeSheet2);

				WriteSheet writeSheet3 = EasyExcel.writerSheet(3,"保险").build();
				excelWriter.fill(map,writeSheet3);
				condition.put("prodType",INSURANCE);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportInsuranceProdHoldDel(model),writeSheet3);

//				WriteSheet writeSheet0 = EasyExcel.writerSheet(0,"贷款").build();
//				excelWriter.fill(map,writeSheet0);
//				condition.put("prodType",LOAN);
//				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportLoanProdHoldDel(model),writeSheet0);

//				WriteSheet writeSheet8 = EasyExcel.writerSheet(5,"信用卡").build();
//				excelWriter.fill(map,writeSheet8);
//				condition.put("prodType",CREDITCARD);
//				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportCreditCardProdHoldDel(model),writeSheet8);
			}else if ("991".equals(model.getCondition().get("prodType"))){
				String templateFileName = "templates" + File.separator + "lproductl_template.xlsx";
				excelWriter = EasyExcel.write(response.getOutputStream())
						.withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();

				WriteSheet writeSheet0 = EasyExcel.writerSheet(0,"贷款").build();
				excelWriter.fill(map,writeSheet0);
				condition.put("prodType",LOAN);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportLoanProdHoldDel(model),writeSheet0);

				WriteSheet writeSheet1 = EasyExcel.writerSheet(1,"信用卡").build();
				excelWriter.fill(map,writeSheet1);
				condition.put("prodType",CREDITCARD);
				excelWriter.fill(acrmAbrBusiSumInfoMapper.exportCreditCardProdHoldDel(model),writeSheet1);
			}
		}
		excelWriter.finish();
	}
	private void exportFile(HttpServletResponse response, String fileName, String title, List list) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", DateUtils.getCurrentDate());
		map.put("title", title);
		String templateFileName = "templates" + File.separator + fileName;
		ExcelWriter excelWriter = null;
		excelWriter = EasyExcel.write(response.getOutputStream())
				.withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();
		WriteSheet writeSheet = EasyExcel.writerSheet().build();
		// 填充集合 data
		excelWriter.fill(list, writeSheet);
		excelWriter.fill(map, writeSheet);
		// 关闭流
		excelWriter.finish();
	}
}
