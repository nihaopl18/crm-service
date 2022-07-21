package cn.com.yusys.yscrm.custmgr.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmFcmCustMgrInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: luhongyan
 * @创建时间: 2019-02-02 10:41:54
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CM_CUST_MGR_INFO")
public class AcrmFcmCustMgrInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户经理员工号 **/
	@Id
	@Column(name = "CUST_MANAGER_ID")
	@Generated(GenerationType.UUID)
	private String custManagerId;
	
	/** 用户ID **/
	@Column(name = "USER_ID", unique = false, nullable = true, length = 32)
	private String userId;
	
	/** 客户经理名称 **/
	@Column(name = "CUST_MANAGER_NAME", unique = false, nullable = true, length = 100)
	private String custManagerName;
	
	/** 学历 **/
	@Column(name = "EDUCATION", unique = false, nullable = true, length = 13)
	private String education;
	
	/** 入行日期 **/
	@Column(name = "ENTRANTS_DATE", unique = false, nullable = true, length = 7)
	private Date entrantsDate;
	
	/** 金融从业时间(月) **/
	@Column(name = "FINANCIAL_JOB_TIME", unique = false, nullable = true, length = 20)
	private String financialJobTime;
	
	/** 所获奖励 **/
	@Column(name = "AWARD", unique = false, nullable = true, length = 100)
	private String award;
	
	/** 资格证书 **/
	@Column(name = "CERTIFICATE", unique = false, nullable = true, length = 20)
	private String certificate;
	
	/** 职称 **/
	@Column(name = "DUTY", unique = false, nullable = true, length = 13)
	private String duty;
	
	/** 出生日期 **/
	@Column(name = "BIRTHDAY", unique = false, nullable = true, length = 7)
	private Date birthday;
	
	/** 任职日期 **/
	@Column(name = "POSITION_TIME", unique = false, nullable = true, length = 7)
	private Date positionTime;
	
	/** 客户经理等级 **/
	@Column(name = "CUST_MANAGER_LEVEL", unique = false, nullable = true, length = 13)
	private String custManagerLevel;
	
	/** 状态 **/
	@Column(name = "STATE", unique = false, nullable = true, length = 13)
	private String state;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 毕业院校 **/
	@Column(name = "GRADUATE_SCHOOL", unique = false, nullable = true, length = 20)
	private String graduateSchool;
	
	/** 专业 **/
	@Column(name = "MAJOR", unique = false, nullable = true, length = 20)
	private String major;
	
	/** 专长 **/
	@Column(name = "EXPERTISE", unique = false, nullable = true, length = 200)
	private String expertise;
	
	/** 爱好 **/
	@Column(name = "HOBBY", unique = false, nullable = true, length = 200)
	private String hobby;
	
	/** 开始工作时间 **/
	@Column(name = "BEGIN_WORK_DATE", unique = false, nullable = true, length = 7)
	private Date beginWorkDate;
	
	/** 任职客户经理时间 **/
	@Column(name = "CUSTMGR_DATE", unique = false, nullable = true, length = 7)
	private Date custmgrDate;
	
	/** 是否为内部培训师 **/
	@Column(name = "IS_INNER_TRAINER", unique = false, nullable = true, length = 20)
	private String isInnerTrainer;
	
	/** 年度培训次数 **/
	@Column(name = "TRAIN_NUM_YEAR", unique = false, nullable = true, length = 20)
	private String trainNumYear;
	
	/** 累计培训次数 **/
	@Column(name = "TRAIN_NUM_TOTAL", unique = false, nullable = true, length = 20)
	private String trainNumTotal;
	
	/** 培训经历 **/
	@Column(name = "TRAIN_EXPERIENCE", unique = false, nullable = true, length = 500)
	private String trainExperience;
	
	/** 年度授课次数 **/
	@Column(name = "TEACH_NUM_YEAR", unique = false, nullable = true, length = 20)
	private String teachNumYear;
	
	/** 累计授课次数 **/
	@Column(name = "TEACH_NUM_TOTAL", unique = false, nullable = true, length = 20)
	private String teachNumTotal;
	
	/** 授课经理 **/
	@Column(name = "TEACH_EXPERIENCE", unique = false, nullable = true, length = 500)
	private String teachExperience;
	
	/** 性别 **/
	@Column(name = "SEX", unique = false, nullable = true, length = 20)
	private String sex;
	
	/** 是否具有信贷从业资格 **/
	@Column(name = "IS_LOAN_QUA", unique = false, nullable = true, length = 20)
	private String isLoanQua;
	
	/** 联系手机 **/
	@Column(name = "MOBILE", unique = false, nullable = true, length = 20)
	private String mobile;
	
	/** 办公座机 **/
	@Column(name = "PHONE", unique = false, nullable = true, length = 20)
	private String phone;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 500)
	private String remark;
	
	
	/**
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}
	
    /**
     * @return UserId
     */	
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * @param custManagerName
	 */
	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName == null ? null : custManagerName.trim();
	}
	
    /**
     * @return CustManagerName
     */	
	public String getCustManagerName() {
		return this.custManagerName;
	}
	
	/**
	 * @param custManagerId
	 */
	public void setCustManagerId(String custManagerId) {
		this.custManagerId = custManagerId == null ? null : custManagerId.trim();
	}
	
    /**
     * @return CustManagerId
     */	
	public String getCustManagerId() {
		return this.custManagerId;
	}
	
	/**
	 * @param education
	 */
	public void setEducation(String education) {
		this.education = education == null ? null : education.trim();
	}
	
    /**
     * @return Education
     */	
	public String getEducation() {
		return this.education;
	}
	
	/**
	 * @param entrantsDate
	 */
	public void setEntrantsDate(Date entrantsDate) {
		this.entrantsDate = entrantsDate;
	}
	
    /**
     * @return EntrantsDate
     */	
	public Date getEntrantsDate() {
		return this.entrantsDate;
	}
	
	/**
	 * @param financialJobTime
	 */
	public void setFinancialJobTime(String financialJobTime) {
		this.financialJobTime = financialJobTime == null ? null : financialJobTime.trim();
	}
	
    /**
     * @return FinancialJobTime
     */	
	public String getFinancialJobTime() {
		return this.financialJobTime;
	}
	
	/**
	 * @param award
	 */
	public void setAward(String award) {
		this.award = award == null ? null : award.trim();
	}
	
    /**
     * @return Award
     */	
	public String getAward() {
		return this.award;
	}
	
	/**
	 * @param certificate
	 */
	public void setCertificate(String certificate) {
		this.certificate = certificate == null ? null : certificate.trim();
	}
	
    /**
     * @return Certificate
     */	
	public String getCertificate() {
		return this.certificate;
	}
	
	/**
	 * @param duty
	 */
	public void setDuty(String duty) {
		this.duty = duty == null ? null : duty.trim();
	}
	
    /**
     * @return Duty
     */	
	public String getDuty() {
		return this.duty;
	}
	
	/**
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
    /**
     * @return Birthday
     */	
	public Date getBirthday() {
		return this.birthday;
	}
	
	/**
	 * @param positionTime
	 */
	public void setPositionTime(Date positionTime) {
		this.positionTime = positionTime;
	}
	
    /**
     * @return PositionTime
     */	
	public Date getPositionTime() {
		return this.positionTime;
	}
	
	/**
	 * @param custManagerLevel
	 */
	public void setCustManagerLevel(String custManagerLevel) {
		this.custManagerLevel = custManagerLevel == null ? null : custManagerLevel.trim();
	}
	
    /**
     * @return CustManagerLevel
     */	
	public String getCustManagerLevel() {
		return this.custManagerLevel;
	}
	
	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}
	
    /**
     * @return State
     */	
	public String getState() {
		return this.state;
	}
	
	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
	}
	
	/**
	 * @param graduateSchool
	 */
	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool == null ? null : graduateSchool.trim();
	}
	
    /**
     * @return GraduateSchool
     */	
	public String getGraduateSchool() {
		return this.graduateSchool;
	}
	
	/**
	 * @param major
	 */
	public void setMajor(String major) {
		this.major = major == null ? null : major.trim();
	}
	
    /**
     * @return Major
     */	
	public String getMajor() {
		return this.major;
	}
	
	/**
	 * @param expertise
	 */
	public void setExpertise(String expertise) {
		this.expertise = expertise == null ? null : expertise.trim();
	}
	
    /**
     * @return Expertise
     */	
	public String getExpertise() {
		return this.expertise;
	}
	
	/**
	 * @param hobby
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby == null ? null : hobby.trim();
	}
	
    /**
     * @return Hobby
     */	
	public String getHobby() {
		return this.hobby;
	}
	
	/**
	 * @param beginWorkDate
	 */
	public void setBeginWorkDate(Date beginWorkDate) {
		this.beginWorkDate = beginWorkDate;
	}
	
    /**
     * @return BeginWorkDate
     */	
	public Date getBeginWorkDate() {
		return this.beginWorkDate;
	}
	
	/**
	 * @param custmgrDate
	 */
	public void setCustmgrDate(Date custmgrDate) {
		this.custmgrDate = custmgrDate;
	}
	
    /**
     * @return CustmgrDate
     */	
	public Date getCustmgrDate() {
		return this.custmgrDate;
	}
	
	/**
	 * @param isInnerTrainer
	 */
	public void setIsInnerTrainer(String isInnerTrainer) {
		this.isInnerTrainer = isInnerTrainer == null ? null : isInnerTrainer.trim();
	}
	
    /**
     * @return IsInnerTrainer
     */	
	public String getIsInnerTrainer() {
		return this.isInnerTrainer;
	}
	
	/**
	 * @param trainNumYear
	 */
	public void setTrainNumYear(String trainNumYear) {
		this.trainNumYear = trainNumYear == null ? null : trainNumYear.trim();
	}
	
    /**
     * @return TrainNumYear
     */	
	public String getTrainNumYear() {
		return this.trainNumYear;
	}
	
	/**
	 * @param trainNumTotal
	 */
	public void setTrainNumTotal(String trainNumTotal) {
		this.trainNumTotal = trainNumTotal == null ? null : trainNumTotal.trim();
	}
	
    /**
     * @return TrainNumTotal
     */	
	public String getTrainNumTotal() {
		return this.trainNumTotal;
	}
	
	/**
	 * @param trainExperience
	 */
	public void setTrainExperience(String trainExperience) {
		this.trainExperience = trainExperience == null ? null : trainExperience.trim();
	}
	
    /**
     * @return TrainExperience
     */	
	public String getTrainExperience() {
		return this.trainExperience;
	}
	
	/**
	 * @param teachNumYear
	 */
	public void setTeachNumYear(String teachNumYear) {
		this.teachNumYear = teachNumYear == null ? null : teachNumYear.trim();
	}
	
    /**
     * @return TeachNumYear
     */	
	public String getTeachNumYear() {
		return this.teachNumYear;
	}
	
	/**
	 * @param teachNumTotal
	 */
	public void setTeachNumTotal(String teachNumTotal) {
		this.teachNumTotal = teachNumTotal == null ? null : teachNumTotal.trim();
	}
	
    /**
     * @return TeachNumTotal
     */	
	public String getTeachNumTotal() {
		return this.teachNumTotal;
	}
	
	/**
	 * @param teachExperience
	 */
	public void setTeachExperience(String teachExperience) {
		this.teachExperience = teachExperience == null ? null : teachExperience.trim();
	}
	
    /**
     * @return TeachExperience
     */	
	public String getTeachExperience() {
		return this.teachExperience;
	}
	
	/**
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}
	
    /**
     * @return Sex
     */	
	public String getSex() {
		return this.sex;
	}
	
	/**
	 * @param isLoanQua
	 */
	public void setIsLoanQua(String isLoanQua) {
		this.isLoanQua = isLoanQua == null ? null : isLoanQua.trim();
	}
	
    /**
     * @return IsLoanQua
     */	
	public String getIsLoanQua() {
		return this.isLoanQua;
	}
	
	/**
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}
	
    /**
     * @return Mobile
     */	
	public String getMobile() {
		return this.mobile;
	}
	
	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}
	
    /**
     * @return Phone
     */	
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
	}

}