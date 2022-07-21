package cn.com.yusys.yscrm.sysview.repository.mapper;

import cn.com.yusys.yscrm.sysview.domain.*;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;

/**
 * @author: sxm
 * @time: 2021/8/15 20:40
 */
public interface AcrmAbrBusiSumInfoMapper {

    ProdConfRaInfo getProdConfRaInfo(QueryModel model);

    List<ProdHoldDeInfo> getProdHoldDeInfo(QueryModel model);

    List<ProdHoldDeInfo> exportProdHoldDeInfo(QueryModel model);

    List<DepositProdHoldDel> getDepositProdHoldDel(QueryModel model);

    List<DepositProdHoldDel> exportDepositProdHoldDel(QueryModel model);

    List<InsuranceProdHoldDel> getInsuranceProdHoldDel(QueryModel model);

    List<InsuranceProdHoldDel> exportInsuranceProdHoldDel(QueryModel model);

    List<LoanProdHoldDel> getLoanProdHoldDel(QueryModel model);

    List<LoanProdHoldDel> exportLoanProdHoldDel(QueryModel model);

    List<CreditCardProdHoldDel> getCreditCardProdHoldDel(QueryModel model);

    List<CreditCardProdHoldDel> exportCreditCardProdHoldDel(QueryModel model);
}
