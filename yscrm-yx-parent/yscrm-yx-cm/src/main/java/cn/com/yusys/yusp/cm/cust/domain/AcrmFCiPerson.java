package cn.com.yusys.yusp.cm.cust.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
@Entity
@Table(name = "ACRM_F_CI_PERSON")
public class AcrmFCiPerson extends BaseDomain implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CUST_ID")//客户编号
    private String custId;
	
	@Column(name = "SUR_NAME")//客户姓氏
    private String surName;

	@Column(name = "PERSONAL_NAME")//客户名字
    private String personalName;

	@Column(name = "PINYIN_NAME")//拼音名称
    private String pinyinName;

	@Column(name = "PINYIN_ABBR")//拼音缩写
    private String pinyinAbbr;

	@Column(name = "PERSON_TITLE")//客户称谓
    private String personTitle;

	@Column(name = "NICK_NAME")//客户昵称
    private String nickName;

	@Column(name = "USED_NAME")//曾用名
    private String usedName;

	@Column(name = "GENDER")//性别
    private String gender;

	@Column(name = "BIRTHDAY")//出生日期
    private Date birthday;

	@Column(name = "BIRTHLOCALE")//出生地点
    private String birthlocale;

	@Column(name = "CITIZENSHIP")//国籍
    private String citizenship;

	@Column(name = "NATIONALITY")//民族
    private String nationality;

	@Column(name = "NATIVEPLACE")//籍贯
    private String nativeplace;

	@Column(name = "HOUSEHOLD")//户籍性质
    private String household;

	@Column(name = "HUKOU_PLACE")//户口所在地
    private String hukouPlace;

	@Column(name = "MARRIAGE")//婚姻状况
    private String marriage;

	@Column(name = "RESIDENCE")//居住状况
    private String residence;

	@Column(name = "HEALTH")//健康状况
    private String health;

	@Column(name = "RELIGIOUS_BELIEF")//宗教信仰
    private String religiousBelief;

	@Column(name = "POLITICAL_FACE")//政治面貌
    private String politicalFace;

	@Column(name = "HIGHEST_SCHOOLING")//最高学历
    private String highestSchooling;

	@Column(name = "HIGHEST_DEGREE")//最高学位
    private String highestDegree;

	@Column(name = "GRADUATE_SCHOOL")//毕业学校
    private String graduateSchool;

	@Column(name = "MAJOR")//所学专业
    private String major;

	@Column(name = "GRADUATION_DATE")//毕业时间
    private Date graduationDate;

	@Column(name = "CAREER_STAT")//职业状况
    private String careerStat;

	@Column(name = "CAREER_TYPE")//职业
    private String careerType;

	@Column(name = "PROFESSION")//从事行业
    private String profession;

	@Column(name = "UNIT_NAME")//单位名称
    private String unitName;

	@Column(name = "UNIT_CHAR")//单位性质
    private String unitChar;

	@Column(name = "DUTY")//职务
    private String duty;

	@Column(name = "CAREER_START_DATE")//参加工作时间
    private Date careerStartDate;

	@Column(name = "ANNUAL_INCOME_SCOPE")//年收入范围
    private String annualIncomeScope;

	@Column(name = "ANNUAL_INCOME")//年收入
    private String annualIncome;

	@Column(name = "RESUME")//个人简历
    private String resume;

	@Column(name = "REMARK")//备注
    private String remark;

	@Column(name = "LAST_UPDATE_SYS")//最后更新系统
    private String lastUpdateSys;

	@Column(name = "LAST_UPDATE_USER")//最后更新人
    private String lastUpdateUser;

	@Column(name = "LAST_UPDATE_TM")//最后更新时间
    private Date lastUpdateTm;

	@Column(name = "TX_SEQ_NO")//交易流水号
    private String txSeqNo;

	@Column(name = "ETL_DATE")//ETL日期
    private Date etlDate;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public String getPinyinName() {
		return pinyinName;
	}

	public void setPinyinName(String pinyinName) {
		this.pinyinName = pinyinName;
	}

	public String getPinyinAbbr() {
		return pinyinAbbr;
	}

	public void setPinyinAbbr(String pinyinAbbr) {
		this.pinyinAbbr = pinyinAbbr;
	}

	public String getPersonTitle() {
		return personTitle;
	}

	public void setPersonTitle(String personTitle) {
		this.personTitle = personTitle;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUsedName() {
		return usedName;
	}

	public void setUsedName(String usedName) {
		this.usedName = usedName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBirthlocale() {
		return birthlocale;
	}

	public void setBirthlocale(String birthlocale) {
		this.birthlocale = birthlocale;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getHousehold() {
		return household;
	}

	public void setHousehold(String household) {
		this.household = household;
	}

	public String getHukouPlace() {
		return hukouPlace;
	}

	public void setHukouPlace(String hukouPlace) {
		this.hukouPlace = hukouPlace;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getReligiousBelief() {
		return religiousBelief;
	}

	public void setReligiousBelief(String religiousBelief) {
		this.religiousBelief = religiousBelief;
	}

	public String getPoliticalFace() {
		return politicalFace;
	}

	public void setPoliticalFace(String politicalFace) {
		this.politicalFace = politicalFace;
	}

	public String getHighestSchooling() {
		return highestSchooling;
	}

	public void setHighestSchooling(String highestSchooling) {
		this.highestSchooling = highestSchooling;
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public String getGraduateSchool() {
		return graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getCareerStat() {
		return careerStat;
	}

	public void setCareerStat(String careerStat) {
		this.careerStat = careerStat;
	}

	public String getCareerType() {
		return careerType;
	}

	public void setCareerType(String careerType) {
		this.careerType = careerType;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitChar() {
		return unitChar;
	}

	public void setUnitChar(String unitChar) {
		this.unitChar = unitChar;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public Date getCareerStartDate() {
		return careerStartDate;
	}

	public void setCareerStartDate(Date careerStartDate) {
		this.careerStartDate = careerStartDate;
	}

	public String getAnnualIncomeScope() {
		return annualIncomeScope;
	}

	public void setAnnualIncomeScope(String annualIncomeScope) {
		this.annualIncomeScope = annualIncomeScope;
	}

	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLastUpdateSys() {
		return lastUpdateSys;
	}

	public void setLastUpdateSys(String lastUpdateSys) {
		this.lastUpdateSys = lastUpdateSys;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Date getLastUpdateTm() {
		return lastUpdateTm;
	}

	public void setLastUpdateTm(Date lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}

	public String getTxSeqNo() {
		return txSeqNo;
	}

	public void setTxSeqNo(String txSeqNo) {
		this.txSeqNo = txSeqNo;
	}

	public Date getEtlDate() {
		return etlDate;
	}

	public void setEtlDate(Date etlDate) {
		this.etlDate = etlDate;
	}
	
	

}
