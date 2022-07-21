package cn.com.yusys.yscrm.custmgr.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CrmFYyTriumphLookUpEXCEL implements Serializable{

  private static final long serialVersionUID = 1492150948801412096L;


    /**
     * 数据日期
     */
    private String dataDate;

    /**
     * 指标编号(01:存款日均净增 02:AUM余额净增 03:合格优惠及以上客户数 04:合格优惠及以上客户数净增 05:贷款放款量 06:优质按揭客户数 07:模拟PPOP
     08:存款日均余额 09:AUM余额 10:合格优惠客户数 11：贷款放款笔数 12：按揭放款笔数 13：人均按揭放款笔数 14：车位贷放款笔数 15：人均车位贷放款笔数
     16：利率、汇率挂钩手续费收入 17：人民币基金手续费收入 18：ODII手续费收入 19：境内结构性产品手续费收入)
     */
    private String triumphId;

    /**
     * 指标名称
     */
    private String triumphName;

    /**
     * 层级(0：总行管理 1:总行理财个贷主管  2：分行 3：支行 4：团队 5：客户经理)
     */
    private String triumphLevel;

    /**
     * 对象id （层级为0 对象id 为总行机构编码 层级为1,对象id为总行理财个贷主管角色编码 层级为2 对象id为分行机构编码
     层级为3 对象id为支行机构编码 层级为4 对象id为团队编码 层级为5 对象id为客户经理编码）
     */
    private String targetId;

    /**
     * 对象名称 （层级为0 对象id 为总行机构名称 层级为1,对象名称为总行理财个贷主管角色名称 层级为2 对象id为分行机构名称
     层级为3 对象id为支行机构名称 层级为4 对象id为团队名称 层级为5 对象id为客户经理名称）
     */
    private String targetName;

    /**
     * 分配所属条线（0 总行 1 理财 2 个贷）
     */
    private String triumphLine;

    /**
     * 同比
     */
    private String yearOnYear;

    /**
     * 环比
     */
    private String ringRatio;

    /**
     * 完成率
     */
    private String completionRate;

    /**
     * 余额
     */
    private String balance;


	/**
	 * 第一个月份
	 */
  private String month1;

	/**
	 * 第二个月份
	 */
  private String month2;

	/**
	 * 第三个月份
	 */
  private String month3;

	/**
     * 第四个月份
     */
    private String month4;
    /**
     * 第五个月份
     */
    private String month5;
    /**
     * 第六个月份
     */
    private String month6;

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getTriumphId() {
        return triumphId;
    }

    public void setTriumphId(String triumphId) {
        this.triumphId = triumphId;
    }

    public String getTriumphName() {
        return triumphName;
    }

    public void setTriumphName(String triumphName) {
        this.triumphName = triumphName;
    }

    public String getTriumphLevel() {
        return triumphLevel;
    }

    public void setTriumphLevel(String triumphLevel) {
        this.triumphLevel = triumphLevel;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getTriumphLine() {
        return triumphLine;
    }

    public void setTriumphLine(String triumphLine) {
        this.triumphLine = triumphLine;
    }

    public String getYearOnYear() {
        return yearOnYear;
    }

    public void setYearOnYear(String yearOnYear) {
        this.yearOnYear = yearOnYear;
    }

    public String getRingRatio() {
        return ringRatio;
    }

    public void setRingRatio(String ringRatio) {
        this.ringRatio = ringRatio;
    }

    public String getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(String completionRate) {
        this.completionRate = completionRate;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getMonth1() {
        return month1;
    }

    public void setMonth1(String month1) {
        this.month1 = month1;
    }

    public String getMonth2() {
        return month2;
    }

    public void setMonth2(String month2) {
        this.month2 = month2;
    }

    public String getMonth3() {
        return month3;
    }

    public void setMonth3(String month3) {
        this.month3 = month3;
    }

    public String getMonth4() {
        return month4;
    }

    public void setMonth4(String month4) {
        this.month4 = month4;
    }

    public String getMonth5() {
        return month5;
    }

    public void setMonth5(String month5) {
        this.month5 = month5;
    }

    public String getMonth6() {
        return month6;
    }

    public void setMonth6(String month6) {
        this.month6 = month6;
    }
}
