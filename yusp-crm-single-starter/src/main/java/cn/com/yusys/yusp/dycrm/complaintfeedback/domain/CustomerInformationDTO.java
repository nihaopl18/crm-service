package cn.com.yusys.yusp.dycrm.complaintfeedback.domain;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class CustomerInformationDTO extends CSRCommonHead implements Serializable {

    private static final long serialVersionUID =  2568813437762118508L;

    /**
     * 工单号
     */
    @Column(name = "SHEET_ID" )
    @ApiModelProperty(value = "工单号")
    @ExportEntityMap(CnName="工单号",EnName="sheetId")
    private String sheetId;

    /**
     * ECIF客户号
     */
    @Column(name = "CUST_ECIF_NO" )
    @ApiModelProperty(value = "ECIF客户号")
    @ExportEntityMap(CnName="ECIF客户号",EnName="custEcifNo")
    private String custEcifNo;

    /**
     * 客户姓名
     */
    @Column(name = "CUST_NAME" )
    @ApiModelProperty(value = "客户姓名")
    @ExportEntityMap(CnName="客户姓名",EnName="custName")
    private String custName;

    /**
     * 客户经理编号
     */
    @Column(name = "CUST_MGR_NO" )
    @ApiModelProperty(value = "客户经理编号")
    @ExportEntityMap(CnName="客户经理编号",EnName="custMgrNo")
    private String custMgrNo;

    /**
     * 客户经理名称
     */
    @Column(name = "CUST_MGR_NM" )
    @ApiModelProperty(value = "客户经理名称")
    @ExportEntityMap(CnName="客户经理名称",EnName="custMgrName")
    private String custMgrNm;

    /**
     * 客户经理机构
     */
    @Column(name = "CUST_MGR_ORG_NO" )
    @ApiModelProperty(value = "客户经理机构")
    @ExportEntityMap(CnName="客户经理机构",EnName="custMgrName")
    private String custMgrOrgNo;

    /**
     * 卡号/账号
     */
    @Column(name = "CARDNBR" )
    @ApiModelProperty(value = "卡号/账号")
    @ExportEntityMap(CnName="卡号/账号",EnName="cardnbr")
    private String cardnbr;


    /**
     * 签发国家
     */
    @Column(name = "ISSUE_COUNTRY" )
    @ApiModelProperty(value = "签发国家")
    @ExportEntityMap(CnName="签发国家",EnName="issueCountry")
    private String issueCountry;

    /**
     * 证件类型
     */
    @Column(name = "KEYTYPE" )
    @ApiModelProperty(value = "证件类型")
    @ExportEntityMap(CnName="证件类型",EnName="keytype")
    private String keytype;

    /**
     * 证件号码
     */
    @Column(name = "CUSTID" )
    @ApiModelProperty(value = "证件号码")
    @ExportEntityMap(CnName="证件号码",EnName="custid")
    private String custid;

    /**
     * 预留手机号码
     */
    @Column(name = "MOBILEPHONE" )
    @ApiModelProperty(value = "预留手机号码")
    @ExportEntityMap(CnName="预留手机号码",EnName="mobilephone")
    private String mobilephone;

    /**
     * 来电号码
     */
    @Column(name = "CALLNUM" )
    @ApiModelProperty(value = "来电号码")
    @ExportEntityMap(CnName="来电号码",EnName="callnum")
    private String callnum;

    /**
     * 灰名单标识
     */
    @Column(name = "GREYFLAG" )
    @ApiModelProperty(value = "灰名单标识")
    @ExportEntityMap(CnName="灰名单标识",EnName="greyflag")
    private String greyflag;

    /**
     * 客户类别
     */
    @Column(name = "CUSTCATEGORY" )
    @ApiModelProperty(value = "客户类别")
    @ExportEntityMap(CnName="客户类别",EnName="custcategory")
    private String custcategory;

    /**
     * 客户性别
     */
    @Column(name = "GENDER" )
    @ApiModelProperty(value = "客户性别")
    @ExportEntityMap(CnName="客户性别",EnName="gender")
    private String gender;

    /**
     * 投诉内容
     */
    @Column(name = "TS_CONTENT" )
    @ApiModelProperty(value = "投诉内容")
    @ExportEntityMap(CnName="投诉内容",EnName="tsContent")
    private String tsContent;

    /**
     * 投诉所属机构
     */
    @Column(name = "TS_DEPART" )
    @ApiModelProperty(value = "投诉所属机构")
    @ExportEntityMap(CnName="投诉所属机构",EnName="tsDepart")
    private String tsDepart;

    /**
     * 投诉/查询类型
     */
    @Column(name = "TS_TYPE" )
    @ApiModelProperty(value = "投诉/查询类型")
    @ExportEntityMap(CnName="投诉/查询类型",EnName="tsType")
    private String tsType;

    /**
     * 所涉及业务
     */
    @Column(name = "TS_BUSINESS" )
    @ApiModelProperty(value = "所涉及业务")
    @ExportEntityMap(CnName="所涉及业务",EnName="tsBusiness")
    private String tsBusiness;

    /**
     * 渠道
     */
    @Column(name = "TS_CHANNEL" )
    @ApiModelProperty(value = "渠道")
    @ExportEntityMap(CnName="渠道",EnName="tsChannel")
    private String tsChannel;

    /**
     * 备注
     */
    @Column(name = "TS_NOTE" )
    @ApiModelProperty(value = "备注")
    @ExportEntityMap(CnName="备注",EnName="tsNote")
    private String tsNote;

    /**
     * 分行投诉主任意见
     */
    @Column(name = "DIRECTOR_OPINION" )
    @ApiModelProperty(value = "分行投诉主任意见")
    @ExportEntityMap(CnName="分行投诉主任意见",EnName="directorOpinion")
    private String directorOpinion;

    /**
     * 结案日期
     */
    @Column(name = "END_DATE" )
    @ApiModelProperty(value = "结案日期")
    @ExportEntityMap(CnName="结案日期",EnName="endDate")
    private String endDate;

    /**
     * 创建时间
     */
    @Column(name = "CREATETIME" )
    @ApiModelProperty(value = "创建时间")
    @ExportEntityMap(CnName="创建时间",EnName="createtime")
    private String createtime;

    /**
     * 处理状态
     */
    @Column(name = "HANDLE_STATE" )
    @ApiModelProperty(value = "处理状态")
    @ExportEntityMap(CnName="处理状态",EnName="handleState")
    private String handleState;

    /**
     * 投诉原因
     */
    @Column(name = "COMPLAIN_REASON" )
    @ApiModelProperty(value = "投诉原因")
    @ExportEntityMap(CnName="投诉原因",EnName="complainReason")
    private String complainReason;

    /**
     * 处理结果
     */
    @Column(name = "SHEET_RESULT" )
    @ApiModelProperty(value = "处理结果")
    @ExportEntityMap(CnName="处理结果",EnName="sheetResult")
    private String sheetResult;

    /**
     * 最近处理时间
     */
    @Column(name = "HANDLETIME" )
    @ApiModelProperty(value = "最近处理时间")
    @ExportEntityMap(CnName="最近处理时间",EnName="handletime")
    private String handletime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSheetId() {
        return sheetId;
    }

    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }

    public String getCustEcifNo() {
        return custEcifNo;
    }

    public void setCustEcifNo(String custEcifNo) {
        this.custEcifNo = custEcifNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustMgrNo() {
        return custMgrNo;
    }

    public void setCustMgrNo(String custMgrNo) {
        this.custMgrNo = custMgrNo;
    }

    public String getCustMgrNm() {
        return custMgrNm;
    }

    public void setCustMgrNm(String custMgrNm) {
        this.custMgrNm = custMgrNm;
    }

    public String getCustMgrOrgNo() {
        return custMgrOrgNo;
    }

    public void setCustMgrOrgNo(String custMgrOrgNo) {
        this.custMgrOrgNo = custMgrOrgNo;
    }

    public String getCardnbr() {
        return cardnbr;
    }

    public void setCardnbr(String cardnbr) {
        this.cardnbr = cardnbr;
    }

    public String getIssueCountry() {
        return issueCountry;
    }

    public void setIssueCountry(String issueCountry) {
        this.issueCountry = issueCountry;
    }

    public String getKeytype() {
        return keytype;
    }

    public void setKeytype(String keytype) {
        this.keytype = keytype;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getCallnum() {
        return callnum;
    }

    public void setCallnum(String callnum) {
        this.callnum = callnum;
    }

    public String getGreyflag() {
        return greyflag;
    }

    public void setGreyflag(String greyflag) {
        this.greyflag = greyflag;
    }

    public String getCustcategory() {
        return custcategory;
    }

    public void setCustcategory(String custcategory) {
        this.custcategory = custcategory;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTsContent() {
        return tsContent;
    }

    public void setTsContent(String tsContent) {
        this.tsContent = tsContent;
    }

    public String getTsDepart() {
        return tsDepart;
    }

    public void setTsDepart(String tsDepart) {
        this.tsDepart = tsDepart;
    }

    public String getTsType() {
        return tsType;
    }

    public void setTsType(String tsType) {
        this.tsType = tsType;
    }

    public String getTsBusiness() {
        return tsBusiness;
    }

    public void setTsBusiness(String tsBusiness) {
        this.tsBusiness = tsBusiness;
    }

    public String getTsChannel() {
        return tsChannel;
    }

    public void setTsChannel(String tsChannel) {
        this.tsChannel = tsChannel;
    }

    public String getTsNote() {
        return tsNote;
    }

    public void setTsNote(String tsNote) {
        this.tsNote = tsNote;
    }

    public String getDirectorOpinion() {
        return directorOpinion;
    }

    public void setDirectorOpinion(String directorOpinion) {
        this.directorOpinion = directorOpinion;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public String getHandleState() {
        return handleState;
    }

    public void setHandleState(String handleState) {
        this.handleState = handleState;
    }

    public String getComplainReason() {
        return complainReason;
    }

    public void setComplainReason(String complainReason) {
        this.complainReason = complainReason;
    }

    public String getSheetResult() {
        return sheetResult;
    }

    public void setSheetResult(String sheetResult) {
        this.sheetResult = sheetResult;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getHandletime() {
        return handletime;
    }

    public void setHandletime(String handletime) {
        this.handletime = handletime;
    }
}
