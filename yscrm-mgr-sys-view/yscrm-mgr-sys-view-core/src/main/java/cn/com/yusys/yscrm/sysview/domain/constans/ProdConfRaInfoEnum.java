package cn.com.yusys.yscrm.sysview.domain.constans;


/**
 * 节点类型枚举
 *
 * @author sxm
 * @date 2021/04/20
 */
public enum ProdConfRaInfoEnum {


    TRUSTBALANCERMB("trustBalanceRmb", "信托余额"),
    RMBFUNDBALANCE("rmbFundBalance", "人民币基金余额"),
    STRUCTFINBALANCE("structFinBalanceRmb", "结构化理财余额"),
    TIMEDEPOSITBALANCE("timeDepositBalance", "定期存款余额"),
    DEMANDDEPOSITBALANCE("demandDepositBalance", "活期存款余额"),
    QDIIBALANCERMB("qdiiBalanceRmb", "QDII余额"),
    INSURRANCEBALANCE("insurranceBalance","总缴保费");

    private String englishName;

    private String chineseName ;

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    ProdConfRaInfoEnum(String englishName, String chineseName) {
        this.englishName = englishName;
        this.chineseName = chineseName;
    }
}
